package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.EstadoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerColoresEstadoExcluido extends Operation {

	HashTableDatos codigosColores = null;
	
	public TraerColoresEstadoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		codigosColores = EstadoExcluido.getCodigosColores();
		
		IDataSet ds = this.getDataSetColores();
		Iterator iterCodColores = EstadoExcluido.getColores().keySet().iterator();
		while (iterCodColores.hasNext()) {
			String codigo = (String) iterCodColores.next();
			String descripcion = (String) EstadoExcluido.getColores().get(codigo);
			cargarRegistro(ds, codigo, descripcion);
		}
		writeCliente(ds);

	}

	private IDataSet getDataSetColores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TColores");
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("codigo_color", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("codigo_color", (String)codigosColores.get(codigo));
	}
}
