package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.ReporteContable;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerNuevoRepConABMCtas extends Operation {

	public TraerNuevoRepConABMCtas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oid = mapaDatos.getInteger("oid");

		IDataSet dsReportes = getDataSetReportesContables();

		Iterator iterReportesContables = ReporteContable.getReportesActivosABMCtas(this.getSesion()).iterator();
		while (iterReportesContables.hasNext()) {
			ReporteContable reporteContable = (ReporteContable) iterReportesContables.next();
			cargarRegReporte(dsReportes, reporteContable, oid);
		}

		writeCliente(dsReportes);

	}

	private IDataSet getDataSetReportesContables() {
		IDataSet dataset = new TDataSet();
		dataset.create("TReportesContables");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ana_con", Field.STRING, 15));
		dataset.fieldDef(new Field("desc_reporte", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegReporte(IDataSet ds, ReporteContable reporte, Integer oidCuenta) throws BaseException {
		ds.append();
		ds.fieldValue("oid", reporte.getOIDInteger());
		ds.fieldValue("oid_ana_con", oidCuenta);
		ds.fieldValue("desc_reporte", reporte.getDescripcion());
	}

}
