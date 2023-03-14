package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.EstadoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadosExcluidos extends Operation {

	public TraerEstadosExcluidos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = this.getDataSetAlturaExcluido();
		Iterator iterEstExc = 
			EstadoExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterEstExc.hasNext()) {
			EstadoExcluido estExc = (EstadoExcluido) iterEstExc.next();
			cargarRegistro(ds,estExc);
		}
		writeCliente(ds);
		
	}
	

	private IDataSet getDataSetAlturaExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadosExcluido");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, EstadoExcluido estado) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", estado.getOIDInteger());
		dataset.fieldValue("codigo", estado.getCodigo());
		dataset.fieldValue("descripcion", estado.getDescripcion());
		dataset.fieldValue("activo", estado.isActivo());
	}
}
