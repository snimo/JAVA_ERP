package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoValoresTCyTD extends Operation {

	public TraerTipoValoresTCyTD() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsTipoValor = this.getDataSetTipoValores();
		
		Iterator iterTipoValores = 
			TipoValor.getTiposValoresByTCyTD(this.getSesion()).iterator();
		while (iterTipoValores.hasNext()) {
			TipoValor tipoValor = (TipoValor) iterTipoValores.next();
			cargarRegistroTipoValor(dsTipoValor, tipoValor);
		}
		
		writeCliente(dsTipoValor);
		
		

	}

	private IDataSet getDataSetTipoValores() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoValoresTCyTD");
		dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}
	
	private void cargarRegistroTipoValor(IDataSet dataset, TipoValor tipoValor) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_tipo_valor", tipoValor.getOIDInteger());
		dataset.fieldValue("codigo", tipoValor.getOIDInteger());
		dataset.fieldValue("descripcion", tipoValor.getOIDInteger());
	}
	
	

}
