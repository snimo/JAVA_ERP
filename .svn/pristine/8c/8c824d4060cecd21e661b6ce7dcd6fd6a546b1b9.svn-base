package com.srn.erp.ctasACobrar.op;

import java.util.Iterator;

import com.srn.erp.ctasACobrar.bm.AplicClieVto;
import com.srn.erp.ctasACobrar.bm.AplicacionComproClie;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComproAplcClie extends Operation {

  public TraerComproAplcClie() {
  }

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		AplicacionComproClie aplicacionComproClie =
			AplicacionComproClie.findByOid(mapaDatos.getInteger("oid"), this.getSesion());
		
		IDataSet ds = this.getDataSetComproAplic();
		cargarAplicComproProv(ds, aplicacionComproClie);
		writeCliente(ds);

	}

	private IDataSet getDataSetComproAplic() {
		IDataSet dataset = new TDataSet();		
		dataset.create("TComproAplicacion");
		dataset.fieldDef(new Field("oid_cco_aplicacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_cco_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante_1", Field.STRING, 100));
		dataset.fieldDef(new Field("importe_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("moneda_1", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cco_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante_2", Field.STRING, 100));
		dataset.fieldDef(new Field("importe_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("moneda_2", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_sujeto", Field.STRING, 100));
		return dataset;
	}
	
	private void cargarAplicComproProv(IDataSet ds,
									   AplicacionComproClie aplicacionComproClie) throws BaseException {

		ds.append();
		ds.fieldValue("oid_cco_aplicacion", aplicacionComproClie.getOIDInteger());
		ds.fieldValue("activo", aplicacionComproClie.isActivo());
		ds.fieldValue("comprobante", aplicacionComproClie.getCodigo());
		ds.fieldValue("fecha", aplicacionComproClie.getEmision());
		
		AplicClieVto aplicacion1 = null;
		AplicClieVto aplicacion2 = null;
		
		Iterator iterAplicCliente = 
			aplicacionComproClie.getAplicacionesClienteVto().iterator();
		while (iterAplicCliente.hasNext()) {
			AplicClieVto aplClie = (AplicClieVto) iterAplicCliente.next();
			if (aplicacion1 == null)
				aplicacion1 = aplClie;
			else if (aplicacion2==null)
				aplicacion2 = aplClie;
		}
			
		if (aplicacion1!=null) {
		  ds.fieldValue("oid_cco_1", aplicacion1.getOIDInteger());
		  ds.fieldValue("comprobante_1", aplicacion1.getCompro_ori().getCodigo());
		  ds.fieldValue("importe_1", aplicacion1.getImporte());
		  ds.fieldValue("moneda_1", aplicacion1.getMoneda().getDescripcion());
		} else {
			  ds.fieldValue("oid_cco_1", "");
			  ds.fieldValue("comprobante_1", "");
			  ds.fieldValue("importe_1", "");
			  ds.fieldValue("moneda_1", "");
		}
		if (aplicacion2!=null) {
			ds.fieldValue("oid_cco_2", aplicacion2.getOIDInteger());
			ds.fieldValue("comprobante_2", aplicacion2.getCompro_ori().getCodigo());
			ds.fieldValue("importe_2", aplicacion2.getImporte());
			ds.fieldValue("moneda_2", aplicacion2.getMoneda().getDescripcion());
		} else {
			ds.fieldValue("oid_cco_2", "");
			ds.fieldValue("comprobante_2", "");
			ds.fieldValue("importe_2", "");
			ds.fieldValue("moneda_2", "");
		}
		ds.fieldValue("oid_sujeto", aplicacionComproClie.getSujeto().getOIDInteger());
		ds.fieldValue("cod_sujeto", aplicacionComproClie.getSujeto().getCodigo());
			ds.fieldValue("rs_sujeto", aplicacionComproClie.getSujeto().getRazon_social());
		
		
	}


}
