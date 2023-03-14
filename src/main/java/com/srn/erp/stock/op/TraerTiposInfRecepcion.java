package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.InformeRecepcion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposInfRecepcion extends Operation {

	public TraerTiposInfRecepcion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = this.getDataSetTiposInfRec();
		Iterator iterCodTipos = 
			InformeRecepcion.getTiposInfRecepcion().keySet().iterator();
		while (iterCodTipos.hasNext()) {
			String codigo = (String) iterCodTipos.next();
			String descripcion = (String) InformeRecepcion.getTiposInfRecepcion().get(codigo);
			cargarRegistro(ds, codigo, descripcion);
		}
		
		writeCliente(ds);
	}

	private IDataSet getDataSetTiposInfRec() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposInfRec");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
