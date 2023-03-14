package com.srn.erp.conciTarjeta.op;


import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.TipoAsientoTarjetas;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoAsiCobTarj extends Operation {

	public TraerTipoAsiCobTarj() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = this.getDS();
		Iterator iterCodTipoAsi = 
			TipoAsientoTarjetas.getTiposAsientosCobranzas().keySet().iterator();
		while (iterCodTipoAsi.hasNext()) {
			String codigo = (String) iterCodTipoAsi.next();
			String descripcion = (String) TipoAsientoTarjetas.getTiposAsientosCobranzas().get(codigo);
			cargarRegistro(ds,codigo,descripcion);
		}
		writeCliente(ds);

	}

	private IDataSet getDS() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposAsientosCob");
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
