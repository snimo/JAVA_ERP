package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.InterpretarNroValCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInterpretarNroAValidar extends Operation {

	public TraerInterpretarNroAValidar() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetInterpretar();
		Iterator iterNroValCIP = InterpretarNroValCIP.getInterpretar().keySet().iterator();
		while (iterNroValCIP.hasNext()) {
			String codigo = (String) iterNroValCIP.next();
			String descripcion = (String) InterpretarNroValCIP.getInterpretar().get(codigo);
			cargarInterpretarNro(ds, codigo, descripcion);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetInterpretar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInterpretarNro");
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private void cargarInterpretarNro(IDataSet dataset, String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
