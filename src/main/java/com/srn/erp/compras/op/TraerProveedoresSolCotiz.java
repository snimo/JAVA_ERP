package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProveedoresSolCotiz extends Operation {

	public TraerProveedoresSolCotiz() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		SolicitudCotizProvCab solCotizProcCab =
			SolicitudCotizProvCab.findByOidProxy(mapaDatos.getInteger("oid_cco"), this.getSesion());
		
		IDataSet ds = this.getDS();
		
		Iterator iterCotizProv = 
			solCotizProcCab.getCotizacionesProveedores().iterator();
		while (iterCotizProv.hasNext()) {
			SolicitudCotizProveedor solCotizProv = (SolicitudCotizProveedor) iterCotizProv.next();
			cargarDS(ds, solCotizProv);
		}
		
		writeCliente(ds);
		
		
	}

	private IDataSet getDS() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProvSolCotiz");
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 255));
		return dataset;
	}

	private void cargarDS(
			IDataSet dataset, 
			SolicitudCotizProveedor solicitud) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_proveedor", solicitud.getProveedor().getOIDInteger());
		dataset.fieldValue("cod_proveedor", solicitud.getProveedor().getCodigo());
		dataset.fieldValue("rs_proveedor", solicitud.getProveedor().getRazonsocial());
		
	}

}
