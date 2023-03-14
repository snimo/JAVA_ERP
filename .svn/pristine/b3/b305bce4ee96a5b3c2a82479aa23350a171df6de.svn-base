package com.srn.erp.ctasAPagar.op;

import java.util.Iterator;

import com.srn.erp.general.bm.TipoComprobante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConfAnuComproProv extends Operation {

	public TraerConfAnuComproProv() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = this.getDataSetConfAnuComproProv();
		
		Iterator iterTipoComproProv = 
			TipoComprobante.getAllTiposComprobantesProveedor(this.getSesion()).iterator();
		while (iterTipoComproProv.hasNext()) {
			TipoComprobante tipoComprobante = (TipoComprobante) iterTipoComproProv.next();
			cargarConfTipoCompro(ds,tipoComprobante);
		}
		
		writeCliente(ds);

	}

	private IDataSet getDataSetConfAnuComproProv() {
		IDataSet dataset = new TDataSet();
		
		dataset.create("TConcAnuTipoCompro");
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_tc_anulador", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_tc_anulador", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tc_anulador", Field.STRING, 100));
		return dataset;
	}
	
	private void cargarConfTipoCompro(IDataSet ds,
			TipoComprobante tipoCompro) throws BaseException {

		ds.append();
		ds.fieldValue("oid_tc", tipoCompro.getOIDInteger());
		ds.fieldValue("codigo", tipoCompro.getCodigo());
		ds.fieldValue("descripcion", tipoCompro.getDescripcion());
		
		if (tipoCompro.getTipoComproAnulador()!=null) {
		  ds.fieldValue("oid_tc_anulador", tipoCompro.getTipoComproAnulador().getOIDInteger());
		  ds.fieldValue("codigo_tc_anulador", tipoCompro.getTipoComproAnulador().getCodigo());
		  ds.fieldValue("desc_tc_anulador", tipoCompro.getTipoComproAnulador().getDescripcion());
		} else {
		  ds.fieldValue("oid_tc_anulador", 0);
		  ds.fieldValue("codigo_tc_anulador", "");
		  ds.fieldValue("desc_tc_anulador", "");
		}
		
	}

}
