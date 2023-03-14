package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.TipoPuntoCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposPuntosCIP extends Operation {

	public TraerTiposPuntosCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetTipoPuntos();
		Iterator iterTipos = TipoPuntoCIP.getTiposPuntos().keySet().iterator();
		while (iterTipos.hasNext()) {
			Integer codigo = (Integer) iterTipos.next();
			String descripcion = (String) TipoPuntoCIP.getTiposPuntos().get(codigo);
			cargarRegistro(ds, codigo, descripcion);
		}
		writeCliente(ds);

	}

	private IDataSet getDataSetTipoPuntos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposPuntos");
		dataset.fieldDef(new Field("codigo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Integer codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}
}
