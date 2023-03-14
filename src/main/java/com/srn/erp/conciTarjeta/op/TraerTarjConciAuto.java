package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.ConciliarAutomaticaTarj;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTarjConciAuto extends Operation {

	public TraerTarjConciAuto() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dsTarjeta = this.getDSTarjetas();
		Iterator iterConciAutoTarj = 
			ConciliarAutomaticaTarj.getTarjetas().keySet().iterator();
		while (iterConciAutoTarj.hasNext()) {
			String codigo = (String) iterConciAutoTarj.next();
			String descripcion = (String) ConciliarAutomaticaTarj.getTarjetas().get(codigo);
			cargarRegistroTipoArchConciTar(dsTarjeta, codigo , descripcion);
		}
		writeCliente(dsTarjeta);		
	}

	private IDataSet getDSTarjetas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTarjetas");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistroTipoArchConciTar(IDataSet dataset, String codigo,String descripcion) {
		dataset.append();
		dataset.fieldValue("sel", true);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}
}
