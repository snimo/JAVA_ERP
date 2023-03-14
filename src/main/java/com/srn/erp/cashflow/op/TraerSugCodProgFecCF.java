package com.srn.erp.cashflow.op;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSugCodProgFecCF extends Operation {

	public TraerSugCodProgFecCF() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetSugCodigo();
		
		Integer oid = this.getSesion().getNewOIDByKey("COD_PROG_CF");
		cargarRegistroSugCodigo(ds, oid.toString());
		
		writeCliente(ds);
	}

	private IDataSet getDataSetSugCodigo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSugCodigo");
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		return dataset;
	}

	private void cargarRegistroSugCodigo(IDataSet dataset, String codigo) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
	}

}
