package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposTarjConci extends Operation {

	public TraerTiposTarjConci() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetTiposTarjConci();
		Iterator iterTiposTarj = TarjetaConciTar.getTiposTarjetas().keySet().iterator();
		while (iterTiposTarj.hasNext()) {
			String codigo = (String) iterTiposTarj.next();
			String descripcion = (String) TarjetaConciTar.getTiposTarjetas().get(codigo);
			cargarRegistroTipoTarjConci(ds, codigo, descripcion);
		}
		writeCliente(ds);
		
	}

	private IDataSet getDataSetTiposTarjConci() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposTarjConci");
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistroTipoTarjConci(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}
}
