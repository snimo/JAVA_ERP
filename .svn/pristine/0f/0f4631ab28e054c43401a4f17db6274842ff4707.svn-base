package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.RemplazoAcumLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImportarHorasRemplazos extends Operation {

	public ImportarHorasRemplazos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsInput = mapaDatos.getDataSet("TInput");
		IDataSet dsRemplazos = mapaDatos.getDataSet("TRemplazos");

		String periodo = "";
		boolean eliminarRemplazos = false;

		dsInput.first();
		while (!dsInput.EOF()) {

			try {

				if (dsInput.getString("periodo")!=null)
					periodo = dsInput.getString("periodo");
				String anio = dsInput.getString("periodo").substring(0, 4);
				String mes = dsInput.getString("periodo").substring(5, 7);
				
				eliminarRemplazos = dsInput.getBoolean("eliminar_reg"); 
				
				if (!(new Integer(anio).intValue()>=2000))
					throw new ExceptionValidation(null, "El año ingresado debe ser mayor al 2000");
				
				if (!(((new Integer(mes).intValue()>=1)) && ((new Integer(mes).intValue()<=12)))) 
					throw new ExceptionValidation(null, "El mes debe estar comprendido entre 1 y 12");
				

			} catch (Exception e) {
				throw new ExceptionValidation(null, "Formato período incorrecto. Ejemplo correcto: 2012.09");
			}

			dsInput.next();
		}
		
		if (periodo.equals(""))
			throw new ExceptionValidation(null, "Período no ingresado.");
		
		int cantRegElim = 0;
		int cantRegActu = 0;
		
		if (eliminarRemplazos)
			cantRegElim = RemplazoAcumLeg.eliminarRemplazosPeriodo(periodo, this.getSesion());
		
		dsRemplazos.first();
		while (!dsRemplazos.EOF()) {
			Legajo legajo = Legajo.findByOidProxy(dsRemplazos.getInteger("oid_legajo"),this.getSesion());
			if (legajo==null) { 
				dsRemplazos.next();
				continue;
			}
			RemplazoAcumLeg remplazoAcumLeg =
				RemplazoAcumLeg.getRemplazoAcumLeg(legajo, periodo, this.getSesion());
			if (remplazoAcumLeg==null)
				remplazoAcumLeg = (RemplazoAcumLeg) RemplazoAcumLeg.getNew(RemplazoAcumLeg.NICKNAME, this.getSesion());
			remplazoAcumLeg.setPeriodo(periodo);
			if (dsRemplazos.getDouble("horas_acum")!=null)
				remplazoAcumLeg.setHoras_acum(dsRemplazos.getDouble("horas_acum").intValue());
			else
				remplazoAcumLeg.setHoras_acum(0);
			remplazoAcumLeg.setLegajo(legajo);
			remplazoAcumLeg.setObservacion(dsRemplazos.getString("observacion"));
			remplazoAcumLeg.setActivo(true);
			
			this.addTransaccion(remplazoAcumLeg);
			++cantRegActu;
			
			dsRemplazos.next();
		}
		
		IDataSet ds = getDataSetResultados();
		String resultado = "Se insertaron/actualizaron "+cantRegActu+" registros.";
		if (cantRegElim!=0)
			resultado = resultado + " Eliminando previamente "+cantRegElim+" registros.";
		cargarResultado(ds, resultado);
		writeCliente(ds);
		
	}
	
	private IDataSet getDataSetResultados() {
		    IDataSet dataset = new TDataSet();
		    dataset.create("TResultados");
		    dataset.fieldDef(new Field("descripcion", Field.STRING, 500));
		    return dataset;
	}
	
	private void cargarResultado(IDataSet ds,String resultado) throws BaseException {
		ds.append();
		ds.fieldValue("descripcion", resultado);
	}
	

}
