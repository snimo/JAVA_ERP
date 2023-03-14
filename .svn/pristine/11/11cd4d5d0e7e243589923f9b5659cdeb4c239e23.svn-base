package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.stock.bm.ProductoProveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerOCPendRecParaInfRec extends Operation {

	private Integer oidInfRec = null;
	private int newOidDet = 0;
	
	public TraerOCPendRecParaInfRec() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds    = getDSDetPendRec();
		IDataSet dsOC  = mapaDatos.getDataSet("TValidadorOC");
		IDataSet dsCab = getDSInfRecCab();
		//IDataSet dsCabActual = mapaDatos.getDataSet("TInformeRecepcion");
		
		oidInfRec = mapaDatos.getInteger("oid_inf_rec");
		
		
		
		dsOC.first();
		while (!dsOC.EOF()) {
			OrdenDeCompraCab oc = OrdenDeCompraCab.findByOid(dsOC.getInteger("oid_oc"),this.getSesion());
			cargarInfRec(oc,dsCab);
			Iterator iterOCDet = 
				oc.getDetallesOCPendRecep().iterator();
			while (iterOCDet.hasNext()) {
				OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterOCDet.next();
				cargarDetInfRecep(ds,ocDet);
			}
			
			dsOC.next();
		}
		
		writeCliente(dsCab);
		writeCliente(ds);
	}
	
	private void cargarDetInfRecep(IDataSet ds,OrdenDeCompraDet ocDet) throws BaseException {
		
		ds.append();		
		ds.fieldValue("oid_inf_rec_det",new Integer(--newOidDet));
		ds.fieldValue("oid_inf_rec",oidInfRec);
		ds.fieldValue("oid_producto",ocDet.getProducto().getOIDInteger());
		ds.fieldValue("cod_producto",ocDet.getProducto().getCodigo());
		ds.fieldValue("desc_producto",ocDet.getProducto().getDescripcion());
		ds.fieldValue("desc_adic_producto",ocDet.getDesc_adic_sku());
		
		ProductoProveedor prodProv = ocDet.getProducto().getProductoProveedor(ocDet.getOrden_de_compra().getProveedor());
		if (prodProv!=null)
			ds.fieldValue("articulo_proveedor",prodProv.getCod_prod_prov());
		else
			ds.fieldValue("articulo_proveedor","");
		
		ds.fieldValue("oid_um_stk", ocDet.getUm_stock().getOIDInteger());
		ds.fieldValue("desc_um_stk", ocDet.getUm_stock().getCodigo());
		ds.fieldValue("cant_recep_us", ocDet.getCantPendRecepUS());
		ds.fieldValue("oid_um_cpra", ocDet.getUnidad_compra().getOIDInteger());
		ds.fieldValue("desc_um_cpra", ocDet.getUnidad_compra().getCodigo());
		ds.fieldValue("cant_recep_uc", ocDet.getCantPendRecepUC());
		ds.fieldValue("comentario", ocDet.getComentario());
		ds.fieldValue("activo", new Boolean(true));
		ds.fieldValue("comprado_uc", ocDet.getCant_comprada_uc());
		ds.fieldValue("recibido_uc", ocDet.getCantRecepUC());
		ds.fieldValue("pend_recep_uc", ocDet.getCantPendRecepUC());
		ds.fieldValue("oid_oc", ocDet.getOrden_de_compra().getOIDInteger());
		ds.fieldValue("codigo_oc", ocDet.getOrden_de_compra().getCodigo());
		ds.fieldValue("oid_oc_det", ocDet.getOIDInteger());
		ds.fieldValue("ref_oc", ocDet.getDescripcion());
	}

	private IDataSet getDSDetPendRec() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInformeRecepcionDet");
		dataset.fieldDef(new Field("oid_inf_rec_det",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_inf_rec",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto",Field.STRING, 100));
		dataset.fieldDef(new Field("desc_producto",Field.STRING, 255));
		dataset.fieldDef(new Field("desc_adic_producto",Field.STRING, 5000));
		dataset.fieldDef(new Field("articulo_proveedor",Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_stk",Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_um_stk",Field.STRING, 50));
		dataset.fieldDef(new Field("cant_recep_us",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_cpra",Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_um_cpra",Field.STRING, 50));
		dataset.fieldDef(new Field("cant_recep_uc",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario",Field.MEMO, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN,0));
		dataset.fieldDef(new Field("comprado_uc", Field.CURRENCY,0));
		dataset.fieldDef(new Field("recibido_uc", Field.CURRENCY,0));
		dataset.fieldDef(new Field("pend_recep_uc", Field.CURRENCY,0));
		dataset.fieldDef(new Field("oid_oc", Field.INTEGER,0));
		dataset.fieldDef(new Field("codigo_oc", Field.STRING,50));
		dataset.fieldDef(new Field("oid_oc_det", Field.INTEGER,0));
		dataset.fieldDef(new Field("ref_oc", Field.STRING,5000));
		return dataset;
	}
	
	private IDataSet getDSInfRecCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInformeRecepcionAux");
		dataset.fieldDef(new Field("oid_prov",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov",Field.STRING, 50));
		dataset.fieldDef(new Field("rs_prov",Field.STRING, 255));
		return dataset;
	}
	
	private void cargarInfRec(OrdenDeCompraCab oc,IDataSet dsDevolverCab) throws BaseException {
		dsDevolverCab.append();
		dsDevolverCab.fieldValue("oid_prov", oc.getProveedor().getOIDInteger());
		dsDevolverCab.fieldValue("cod_prov", oc.getProveedor().getCodigo());
		dsDevolverCab.fieldValue("rs_prov", oc.getProveedor().getRazonsocial());
	}
	

}
