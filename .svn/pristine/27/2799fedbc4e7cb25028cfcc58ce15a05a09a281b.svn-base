package com.srn.erp.rrhh.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.rrhh.bm.RemplazoAcumLeg;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsDiasEmpTrans extends Operation {

	public TraerConsDiasEmpTrans() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String periodoDesde = mapaDatos.getString("periodo_desde");
		String periodoHasta = mapaDatos.getString("periodo_hasta");

		Periodo periDesde = Periodo.findByCodigo(periodoDesde, this.getSesion());
		Periodo periHasta = Periodo.findByCodigo(periodoHasta, this.getSesion());

		if (periDesde == null)
			throw new ExceptionValidation(null, "Debe ingresar el período desde");

		if (periHasta == null)
			throw new ExceptionValidation(null, "Debe ingresar el período hasta");

		java.util.Date fecDesde = periDesde.getFechadesde();
		java.util.Date fecHasta = periHasta.getFechahasta();

		List listaPeriodos = new ArrayList();
		Iterator iterPeriodos = Periodo.getPeriodosEntreFechas(fecDesde, fecHasta, this.getSesion()).iterator();
		while (iterPeriodos.hasNext()) {
			Periodo periodo = (Periodo) iterPeriodos.next();
			listaPeriodos.add(periodo);
		}
		
		IDataSet ds  = getDataSetReemplazos();
		
		Iterator iterReemplazos = 
			RemplazoAcumLeg.getRemplazosAcumEnPeriodos(listaPeriodos,this.getSesion()).iterator();
		while (iterReemplazos.hasNext()) {
			RemplazoAcumLeg remplazoAcumLeg = (RemplazoAcumLeg) iterReemplazos.next();
			if (remplazoAcumLeg.getLegajo()!=null)
				cargarReemplzado(ds, 
						remplazoAcumLeg.getLegajo().getCodigo(), 
						remplazoAcumLeg.getLegajo().getApellidoyNombre(), 
						remplazoAcumLeg.getPeriodo(), 
						remplazoAcumLeg.getHoras_acum());
		}
		
		writeCliente(ds);

	}

	private IDataSet getDataSetReemplazos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRemplazos");
		dataset.fieldDef(new Field("legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("periodo", Field.STRING, 7));
		dataset.fieldDef(new Field("dias", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarReemplzado(IDataSet dataset, String legajo, String apellidoNombre, String periodo, double dias) {
		dataset.append();
		dataset.fieldValue("legajo", legajo);
		dataset.fieldValue("ape_y_nom", apellidoNombre);
		dataset.fieldValue("periodo", periodo);
		dataset.fieldValue("dias", dias);
	}
}
