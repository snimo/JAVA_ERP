package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDatosCabAltaSolCotProv extends Operation {

	public TraerDatosCabAltaSolCotProv() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = getDataSet();
		SolicitudCotizProvCab solCotProvCab = SolicitudCotizProvCab.findByOidProxy(mapaDatos.getInteger("oid_sol_cot_prov_cab"), getSesion());
		enviar(ds, solCotProvCab);
		writeCliente(ds);
	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSolCotProvCab");
		dataset.fieldDef(new Field("oid_sol_cot_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sol_cot_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_requerido", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
		dataset.fieldDef(new Field("oid_prov_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov_1", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_prov_1", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_prov_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov_2", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_prov_2", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_prov_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov_3", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_prov_3", Field.STRING, 255));
		return dataset;
	}


	private void enviar(
			IDataSet ds, 
			SolicitudCotizProvCab solCotProvCab) throws BaseException {

		ds.append();
		ds.fieldValue("oid_sol_cot_prov", solCotProvCab.getOIDInteger());
		ds.fieldValue("cod_sol_cot_prov", solCotProvCab.getCodigo());
		ds.fieldValue("fec_requerido", solCotProvCab.getFec_tope_ent_sol());
		ds.fieldValue("fec_emision", solCotProvCab.getEmision());
		ds.fieldValue("observacion", solCotProvCab.getObs_detalladas());
		
		
		Proveedor proveedor1 = null;
		Proveedor proveedor2 = null;
		Proveedor proveedor3 = null;
		
		int i = 1;
		Iterator iterCotizProv = 
			solCotProvCab.getCotizacionesProveedores().iterator();
		while (iterCotizProv.hasNext()) {
			SolicitudCotizProveedor solCotProv = (SolicitudCotizProveedor) iterCotizProv.next();
			if (i==1) 
				proveedor1 = solCotProv.getProveedor();
			else
				if (i==2) 
					proveedor2 = solCotProv.getProveedor();
				else
					if (i==3) 
						proveedor3 = solCotProv.getProveedor();
			
			++i;
			
		}
		
		if (proveedor1!=null) {
			ds.fieldValue("oid_prov_1", proveedor1.getOIDInteger());
			ds.fieldValue("cod_prov_1", proveedor1.getCodigo());
			ds.fieldValue("desc_prov_1", proveedor1.getDescripcion());
		} else {
			ds.fieldValue("oid_prov_1", "");
			ds.fieldValue("cod_prov_1", "");
			ds.fieldValue("desc_prov_1", "");
		}
		
		if (proveedor2!=null) {
			ds.fieldValue("oid_prov_2", proveedor2.getOIDInteger());
			ds.fieldValue("cod_prov_2", proveedor2.getCodigo());
			ds.fieldValue("desc_prov_2", proveedor2.getDescripcion());
		} else {
			ds.fieldValue("oid_prov_2", "");
			ds.fieldValue("cod_prov_2", "");
			ds.fieldValue("desc_prov_2", "");
		}
		
		if (proveedor3!=null) {
			ds.fieldValue("oid_prov_3", proveedor2.getOIDInteger());
			ds.fieldValue("cod_prov_3", proveedor2.getCodigo());
			ds.fieldValue("desc_prov_3", proveedor2.getDescripcion());
		} else {
			ds.fieldValue("oid_prov_3", "");
			ds.fieldValue("cod_prov_3", "");
			ds.fieldValue("desc_prov_3", "");
		}
	
	}	

}
