package com.srn.erp.ctasAPagar.op;

import java.util.Iterator;

import com.srn.erp.ctasAPagar.bm.AplProv;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProv;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComproAplcProv extends Operation {

	public TraerComproAplcProv() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		AplicacionComproProv aplicacionComproProv =
			AplicacionComproProv.findByOid(mapaDatos.getInteger("oid"), this.getSesion());
		
		IDataSet ds = this.getDataSetComproAplic();
		cargarAplicComproProv(ds, aplicacionComproProv);
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
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
		return dataset;
	}
	
	private void cargarAplicComproProv(IDataSet ds,
									   AplicacionComproProv aplicacionComproProv) throws BaseException {

		ds.append();
		ds.fieldValue("oid_cco_aplicacion", aplicacionComproProv.getOIDInteger());
		ds.fieldValue("activo", aplicacionComproProv.isActivo());
		ds.fieldValue("comprobante", aplicacionComproProv.getCodigo());
		ds.fieldValue("fecha", aplicacionComproProv.getEmision());
		
		AplProv aplicacion1 = null;
		AplProv aplicacion2 = null;
		
		Iterator iterAplicProveedor = 
			aplicacionComproProv.getAplicacionesProveedor().iterator();
		while (iterAplicProveedor.hasNext()) {
			AplProv aplProv = (AplProv) iterAplicProveedor.next();
			if (aplicacion1 == null)
				aplicacion1 = aplProv;
			else if (aplicacion2==null)
				aplicacion2 = aplProv;
		}
			
		
		ds.fieldValue("oid_cco_1", aplicacion1.getOIDInteger());
		ds.fieldValue("comprobante_1", aplicacion1.getComprobanteori().getCodigo());
		ds.fieldValue("importe_1", aplicacion1.getImporte());
		ds.fieldValue("moneda_1", aplicacion1.getMoneda().getDescripcion());
		ds.fieldValue("oid_cco_2", aplicacion2.getOIDInteger());
		ds.fieldValue("comprobante_2", aplicacion2.getComprobanteori().getCodigo());
		ds.fieldValue("importe_2", aplicacion2.getImporte());
		ds.fieldValue("moneda_2", aplicacion2.getMoneda().getDescripcion());
		ds.fieldValue("oid_proveedor", aplicacionComproProv.getProveedor().getOIDInteger());
		ds.fieldValue("cod_proveedor", aplicacionComproProv.getProveedor().getCodigo());
		ds.fieldValue("rs_proveedor", aplicacionComproProv.getProveedor().getRazonsocial());
		
		
	}

}
