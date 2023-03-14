package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.MotDifPagoExc;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivoDiferenciaPagoExcluido extends Operation {

	public TraerMotivoDiferenciaPagoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		MotDifPagoExc motivodiferenciapagoexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			motivodiferenciapagoexcluido = MotDifPagoExc.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			motivodiferenciapagoexcluido = MotDifPagoExc.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetMotivoDiferenciaPagoExcluido = getDataSetMotivoDiferenciaPagoExcluido();
		if (motivodiferenciapagoexcluido != null) 
			cargarRegistroMotivoDiferenciaPagoExcluido(datasetMotivoDiferenciaPagoExcluido, motivodiferenciapagoexcluido);
		writeCliente(datasetMotivoDiferenciaPagoExcluido);
		
	}

	private IDataSet getDataSetMotivoDiferenciaPagoExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivoDiferenciaPagoExcluido");
		dataset.fieldDef(new Field("oid_mot_dif_imp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroMotivoDiferenciaPagoExcluido(IDataSet dataset, MotDifPagoExc motivo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_mot_dif_imp", motivo.getOIDInteger());
		dataset.fieldValue("codigo", motivo.getCodigo());
		dataset.fieldValue("descripcion", motivo.getDescripcion());
		dataset.fieldValue("activo", motivo.isActivo());
	}
}
