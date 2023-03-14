package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.GrabarConsRotasCab;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsGrabRotas extends Operation {

	public TraerConsGrabRotas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		java.util.Date fecha = null;
		String tipoFecha = "";
		IDataSet dsInput = mapaDatos.getDataSet("TInput");
		Integer nroConsulta = null;
		
		dsInput.first();
		while (!dsInput.EOF()) {
			if (dsInput.getDate("fecha")!=null)
				fecha = Fecha.getFechaTruncada(dsInput.getDate("fecha"));
			if (dsInput.getString("tipo_fecha")!=null)
				tipoFecha = dsInput.getString("tipo_fecha");			
			if (dsInput.getInteger("nro_consulta")!=null)
				nroConsulta = dsInput.getInteger("nro_consulta");			
			dsInput.next();
		}
		
		if ((fecha==null) && (nroConsulta==null))
			throw new ExceptionValidation(null,"Debe ingresar la fecha o el Nro. de Consulta");
		
		
		IDataSet ds = this.getDataSetConsGrabadas();
		
		Iterator iterConsultas = null;
		
		if (tipoFecha.equals("GRABA"))
			iterConsultas =	GrabarConsRotasCab.getConsRotasGrabadas(
				Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()), 
				fecha,
				nroConsulta,
				this.getSesion()).iterator();
		else
			iterConsultas =	GrabarConsRotasCab.getConsRotasGrabadasFecRota(
					Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), 
					this.getSesion()), 
					fecha, 
					nroConsulta,
					this.getSesion()).iterator();
		
		while (iterConsultas.hasNext()) {
			
			GrabarConsRotasCab grabarConsRotasCab = (GrabarConsRotasCab) iterConsultas.next();
			cargarRegistro(ds, 
					grabarConsRotasCab.getOIDInteger(),
					grabarConsRotasCab.getNroConsulta(), 
					grabarConsRotasCab.getFecha_grab(), 
					grabarConsRotasCab.getHora_grab(), 
					grabarConsRotasCab.getAgrupador(), 
					grabarConsRotasCab.getDescripcion(), 
					grabarConsRotasCab.getFec_desde(),
					grabarConsRotasCab.getUsuario());
			
		}
		
		writeCliente(ds);
		
	}

	private IDataSet getDataSetConsGrabadas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsultasGrabadas");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("hora", Field.STRING, 5));
		dataset.fieldDef(new Field("agrupador", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 500));
		dataset.fieldDef(new Field("fec_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("usuario", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet ds,
								Integer oid,
							    Integer nroInt,
							    java.util.Date fecha,
							    String hora,
							    String agrupador,
							    String descripcion,
							    java.util.Date fecDesde,
							    Usuario usuario) throws BaseException {
		ds.append();
		ds.fieldValue("oid", oid);
		ds.fieldValue("nro_int", nroInt);
		ds.fieldValue("fecha", fecha);
		ds.fieldValue("hora", hora);
		ds.fieldValue("agrupador", agrupador);
		ds.fieldValue("descripcion", descripcion);
		ds.fieldValue("fec_desde", fecDesde);
		if (usuario!=null)
			ds.fieldValue("usuario", usuario.getApellidoyNombre());
		else
			ds.fieldValue("usuario", "?");
	}

}
