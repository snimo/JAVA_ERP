package com.srn.erp.impuestos.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.impuestos.bm.ListadoIVACab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFactFaltantesIVAVtas extends Operation {

	private int secu = 0;
	
	public TraerFactFaltantesIVAVtas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Talonario talonario = null;
		if (mapaDatos.containsKey("oid_talonario"))
			talonario = Talonario.findByOidProxy(mapaDatos.getInteger("oid_talonario"), this.getSesion());
		
		if (!mapaDatos.containsKey("fecha_desde"))
			throw new ExceptionValidation(null,"Debe ingresar la fecha desde");
		
		if (!mapaDatos.containsKey("fecha_hasta"))
			throw new ExceptionValidation(null,"Debe ingresar la fecha hasta");
		
		java.util.Date fecDesde = mapaDatos.getDate("fecha_desde");
		java.util.Date fecHasta = mapaDatos.getDate("fecha_hasta");

		IDataSet ds = this.getDataSetFactFaltantesLibroIVA();
		IDataSet dsTalonario = this.getDataSetTalonarios();

		
		
		if (talonario != null) {
			
			Integer minimo = ListadoIVACab.getMinNroExtDeTalonarioEnFechas(this.getSesion(), talonario, fecDesde, fecHasta);
			Integer maximo = ListadoIVACab.getMaxNroExtDeTalonarioEnFechas(this.getSesion(), talonario, fecDesde, fecHasta);
			
			analizarTalonario(ds, talonario,fecDesde,fecHasta,minimo,maximo);
			cargarRegistroTalonario(dsTalonario, talonario, minimo, maximo, fecDesde, fecHasta);
		}
		else {
			Iterator iterTalonarios = Talonario.getTalonariosByLibroIVAVentas(this.getSesion()).iterator();
			while (iterTalonarios.hasNext()) {
				Talonario talonarioIVAVtas = (Talonario) iterTalonarios.next();
				Integer minimo = ListadoIVACab.getMinNroExtDeTalonarioEnFechas(this.getSesion(), talonarioIVAVtas, fecDesde, fecHasta);
				Integer maximo = ListadoIVACab.getMaxNroExtDeTalonarioEnFechas(this.getSesion(), talonarioIVAVtas, fecDesde, fecHasta);
				
				analizarTalonario(ds, talonarioIVAVtas , fecDesde , fecHasta , minimo , maximo);
				cargarRegistroTalonario(dsTalonario, talonarioIVAVtas, minimo, maximo, fecDesde, fecHasta);
			}
		}

		writeCliente(ds);
		writeCliente(dsTalonario);

	}

	private void analizarTalonario(IDataSet ds, 
			Talonario talonario,
			java.util.Date fecDesde,
			java.util.Date fecHasta,
			Integer minimo,
			Integer maximo) throws BaseException {
		
		HashTableDatos comprobantes = new HashTableDatos();
		Iterator iterLibroIVAVentasCab = 
			ListadoIVACab.getLibroIVAVentasByTalonarioFecDesdeHasta(fecDesde, fecHasta, talonario, this.getSesion()).iterator();
		while (iterLibroIVAVentasCab.hasNext()) {
			ListadoIVACab libroIVACab = (ListadoIVACab) iterLibroIVAVentasCab.next();
			comprobantes.put(libroIVACab.getComprobante().getNroExt(), libroIVACab);
		}
				
		java.util.Date fecha = fecDesde;
		
		// Determinar los comprobantes que faltan en el rango indicado
		for (int i=minimo.intValue();i<=maximo.intValue();++i) {
			if (i==0) continue;
			ListadoIVACab libroIVACab = (ListadoIVACab)comprobantes.get(new Integer(i));
			
			if (libroIVACab!=null)
				fecha = libroIVACab.getComprobante().getEmision(); 
			
			if (libroIVACab == null) {
				--secu;
				String descCompro = 
					ComproCab.getFormatoCompro(
							talonario.getTipo_comprobante().getCodigo(), 
							talonario.getLetra(), 
							talonario.getLugar_emision().getLugemi(), 
							i);
				cargarRegistroFactFaltantesLibroIVA(
						ds, 
						new Integer(secu), 
						descCompro,
						talonario,
						i,
						fecha
						);
			}
		}
		
	}

	private IDataSet getDataSetFactFaltantesLibroIVA() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFacturasFaltantesLibroIVA");
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		return dataset;
	}
	
	private IDataSet getDataSetTalonarios() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTalonarios");
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_desde", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_hasta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_hasta", Field.DATE, 0));
		return dataset;
	}
	
	private void cargarRegistroTalonario(
			IDataSet dataset, 
			Talonario talonario, 
			Integer nroDesde,
			Integer nroHasta,
			java.util.Date fecDesde,
			java.util.Date fecHasta) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_talonario", talonario.getOIDInteger());
		dataset.fieldValue("descripcion", talonario.getDescripcion());
		dataset.fieldValue("nro_desde", nroDesde);
		dataset.fieldValue("nro_hasta", nroHasta);
		dataset.fieldValue("fec_desde", fecDesde);
		dataset.fieldValue("fec_hasta", fecHasta);

	}
	
	
	
	private void cargarRegistroFactFaltantesLibroIVA(
			IDataSet dataset, 
			Integer oid, 
			String comprobante,
			Talonario talonario,
			Integer nroExt,
			java.util.Date fecha) {

		dataset.append();
		dataset.fieldValue("oid_cco", oid);
		dataset.fieldValue("oid_talonario", talonario.getOIDInteger());
		dataset.fieldValue("codigo", comprobante);
		dataset.fieldValue("nro_ext", nroExt);
		dataset.fieldValue("fecha", fecha);

	}

}
