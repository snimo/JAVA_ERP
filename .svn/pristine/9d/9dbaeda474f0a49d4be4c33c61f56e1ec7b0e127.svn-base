package com.srn.erp.excluidos.op;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerNroVerModifFotoExc extends Operation {

	public TraerNroVerModifFotoExc() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetNroVerFotoExc();
		Integer proxNroVersio = this.getSesion().getNewOIDByKey("NRO_VER_MODIF_FOTO_EXC");
		cargarRegistroAlturaExcluido(ds,proxNroVersio);
		writeCliente(ds);
	}

	private IDataSet getDataSetNroVerFotoExc() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNroVersionModifFoto");
		dataset.fieldDef(new Field("nro_version", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroAlturaExcluido(IDataSet dataset, Integer nroVersion) throws BaseException {
		dataset.append();
		dataset.fieldValue("nro_version", nroVersion);
	}
}
