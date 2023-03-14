package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.LugarHechoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLugarHechoExcluido extends Operation {

	public TraerLugarHechoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		LugarHechoExcluido lugarhechoexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			lugarhechoexcluido = LugarHechoExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			lugarhechoexcluido = LugarHechoExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetLugarHechoExcluido = getDataSetLugarHechoExcluido();
		
		if (lugarhechoexcluido != null) 
			cargarRegistroLugarHechoExcluido(datasetLugarHechoExcluido, lugarhechoexcluido);
		
		writeCliente(datasetLugarHechoExcluido);
	}

	private IDataSet getDataSetLugarHechoExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLugarHechoExcluido");
		dataset.fieldDef(new Field("oid_lugar_hecho", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroLugarHechoExcluido(IDataSet dataset, LugarHechoExcluido lugarHechoEcluido) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_lugar_hecho", lugarHechoEcluido.getOIDInteger());
		dataset.fieldValue("codigo", lugarHechoEcluido.getCodigo());
		dataset.fieldValue("descripcion", lugarHechoEcluido.getDescripcion());
		dataset.fieldValue("activo", lugarHechoEcluido.isActivo());
	}
}
