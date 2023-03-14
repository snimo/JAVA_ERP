package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.OCTomarPreciosDe;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerOCTomarPreciosDe extends Operation {

	public TraerOCTomarPreciosDe() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		int secu = 0;
		IDataSet ds = getDataSetTomarPrecios();
		Iterator iterCodigos = OCTomarPreciosDe.getTomarPreciosDe().keySet().iterator();
		while (iterCodigos.hasNext()) {
			Integer oid = new Integer(++secu);
			String codigo = (String) iterCodigos.next();
			String descripcion = (String) OCTomarPreciosDe.getTomarPreciosDe().get(codigo);
			cargarRegistroTomarPrecios(ds,oid,codigo,descripcion);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetTomarPrecios() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTomarPrecios");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroTomarPrecios(IDataSet dataset, Integer oid, String codigo, String descripcion)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
