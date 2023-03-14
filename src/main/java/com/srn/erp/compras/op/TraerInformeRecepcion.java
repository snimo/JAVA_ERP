package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.stock.bm.ProductoProveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInformeRecepcion extends Operation {

	public TraerInformeRecepcion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		InformeRecepcion informeRecepcion = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			informeRecepcion = InformeRecepcion.findByOid(oid, getSesion());
		}

		// Recorrer los detalles de los informes de Recepcion	
		IDataSet datasetInfRec = getDataSetInformeRecepcion();
		IDataSet datasetInfRecDet = getDataSetInformeRecepcionDet();
		cargarRegistroInformeRecepcion(datasetInfRec,informeRecepcion);
		Iterator iterInfRecDet = informeRecepcion.getDetallesInfRec().iterator();
		while (iterInfRecDet.hasNext()) {
			InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterInfRecDet.next();
			cargarRegistroInfRecDet(datasetInfRecDet,infRecDet);
		}
		
		writeCliente(datasetInfRec);
		writeCliente(datasetInfRecDet);
	}

	private IDataSet getDataSetInformeRecepcion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInformeRecepcion");
		dataset.fieldDef(new Field("oid_inf_rec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc",Field.STRING, 50));
		dataset.fieldDef(new Field("letra",Field.STRING, 5));
		dataset.fieldDef(new Field("oid_lug_emi",Field.INTEGER, 0));
		dataset.fieldDef(new Field("lug_emi",Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_prov",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov",Field.STRING, 50));
		dataset.fieldDef(new Field("rs_prov",Field.STRING, 100));
		dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("remito_prov",Field.STRING, 50));
		dataset.fieldDef(new Field("comentario",Field.STRING, 255));
		dataset.fieldDef(new Field("oid_oc",Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_oc",Field.STRING, 50));
		dataset.fieldDef(new Field("fact_prov",Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cco_fact_prov",Field.INTEGER, 0));
		dataset.fieldDef(new Field("referencia",Field.STRING, 50));
		dataset.fieldDef(new Field("tipo",Field.STRING, 10));
		dataset.fieldDef(new Field("codigo_remito",Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroInformeRecepcion(IDataSet dataset,
			InformeRecepcion informeRecepcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_inf_rec", informeRecepcion.getOIDInteger());
		dataset.fieldValue("oid_talonario", informeRecepcion.getTalonario().getOIDInteger());
		dataset.fieldValue("oid_tc",informeRecepcion.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_tc",informeRecepcion.getTipoCompro().getCodigo());
		dataset.fieldValue("letra",informeRecepcion.getLetra());
		dataset.fieldValue("oid_lug_emi",informeRecepcion.getLugarEmision().getOIDInteger());
		dataset.fieldValue("lug_emi",informeRecepcion.getNroLugEmision());
		dataset.fieldValue("nro_ext",informeRecepcion.getNroExt());
		dataset.fieldValue("fec_emision", informeRecepcion.getImputac());
		dataset.fieldValue("oid_prov",informeRecepcion.getProveedor().getOIDInteger());
		dataset.fieldValue("cod_prov",informeRecepcion.getProveedor().getCodigo());
		dataset.fieldValue("rs_prov",informeRecepcion.getProveedor().getRazonsocial());
		dataset.fieldValue("activo",informeRecepcion.isActivo());
		dataset.fieldValue("remito_prov",informeRecepcion.getRemito_prov());
		dataset.fieldValue("comentario",informeRecepcion.getComentario());
		OrdenDeCompraCab oc = informeRecepcion.getOrdenDeCompra();
		if (oc!=null) {
		  dataset.fieldValue("oid_oc", oc.getOIDInteger());
		  dataset.fieldValue("codigo_oc", oc.getNroExt());
		} else {
		  dataset.fieldValue("oid_oc", new Integer(0));
		  dataset.fieldValue("codigo_oc", "");
		}
		
		
		if (informeRecepcion.getComproProveedor()!=null) {
			dataset.fieldValue("fact_prov", informeRecepcion.getComproProveedor().getCodigo());
			dataset.fieldValue("oid_cco_fact_prov", informeRecepcion.getComproProveedor().getOIDInteger());
		}
		else {
			dataset.fieldValue("fact_prov", "");
			dataset.fieldValue("oid_cco_fact_prov", "");
		}
		dataset.fieldValue("referencia", informeRecepcion.getReferencia());
		dataset.fieldValue("tipo", informeRecepcion.getTipo());
		dataset.fieldValue("codigo_remito", informeRecepcion.getRemitosInternos());
		
	}

	private IDataSet getDataSetInformeRecepcionDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInformeRecepcionDet");
		dataset.fieldDef(new Field("oid_inf_rec_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_inf_rec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_adic_producto", Field.STRING, 255));
		dataset.fieldDef(new Field("articulo_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_stk", Field.INTEGER, 50));
		dataset.fieldDef(new Field("cant_recep_us",Field.CURRENCY, 50));
		dataset.fieldDef(new Field("oid_um_cpra",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_recep_uc",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario",Field.STRING, 255));
		dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("comprado_uc",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("recibido_uc",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pend_recep_uc",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_oc",Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_oc", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_oc_det", Field.INTEGER, 50));
		dataset.fieldDef(new Field("ref_oc", Field.MEMO, 0));
		return dataset;
	}

	private void cargarRegistroInfRecDet(IDataSet dataset,
			InformeRecepcionDet infRecDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_inf_rec_det", infRecDet.getOIDInteger());
		dataset.fieldValue("oid_inf_rec", infRecDet.getInforme_recepcion().getOIDInteger());
		dataset.fieldValue("oid_producto", infRecDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", infRecDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", infRecDet.getProducto().getDescripcion());
		dataset.fieldValue("desc_adic_producto","");		
		ProductoProveedor productoProveedor = infRecDet.getProducto().getProductoProveedor(infRecDet.getInforme_recepcion().getProveedor());
		if (productoProveedor!=null)
			dataset.fieldValue("articulo_proveedor", productoProveedor.getCodigo());
		else
			dataset.fieldValue("articulo_proveedor", "");
		if (infRecDet.getUnidadMedidaStock()!=null)
			dataset.fieldValue("oid_um_stk",  infRecDet.getUnidadMedidaStock().getOIDInteger());
		else
			dataset.fieldValue("oid_um_stk",  0);
		dataset.fieldValue("cant_recep_us",infRecDet.getCant_rec_en_us());
		dataset.fieldValue("oid_um_cpra", infRecDet.getUnidadMedidaCompra().getOIDInteger());
		dataset.fieldValue("cant_recep_uc", infRecDet.getCant_rec_en_uc());
		dataset.fieldValue("comentario",infRecDet.getComentario());
		dataset.fieldValue("activo",!infRecDet.isAnulado().booleanValue());
		
		OrdenDeCompraCab oc = null;
		if (infRecDet.getOrdenDeCompraDet()!=null)
			oc = infRecDet.getOrdenDeCompraDet().getOrden_de_compra();
		
		OrdenDeCompraDet ocDet = infRecDet.getOrdenDeCompraDet();
			
		if (ocDet != null) {
			dataset.fieldValue("comprado_uc", ocDet.getCant_comprada_uc());
			dataset.fieldValue("recibido_uc", ocDet.getCantRecepUC());
			dataset.fieldValue("pend_recep_uc", ocDet.getCantPendRecepUC());
			dataset.fieldValue("oid_oc", ocDet.getOrden_de_compra().getOIDInteger());
			dataset.fieldValue("codigo_oc", ocDet.getOrden_de_compra().getCodigo());
			dataset.fieldValue("oid_oc_det", ocDet.getOIDInteger());
			dataset.fieldValue("ref_oc", ocDet.getDescripcion());
		} if (infRecDet.getRemitoDet()!=null) {
			dataset.fieldValue("comprado_uc", new Integer(0));
		    dataset.fieldValue("recibido_uc", new Integer(0));
		    dataset.fieldValue("pend_recep_uc", new Integer(0));
			dataset.fieldValue("oid_oc", new Integer(0));
			dataset.fieldValue("codigo_oc", "");
			dataset.fieldValue("oid_oc_det", new Integer(0));
			dataset.fieldValue("ref_oc", infRecDet.getRemitoDet().getRemito_cab().getCodigo());
		}
		else {
			dataset.fieldValue("comprado_uc", new Integer(0));
		    dataset.fieldValue("recibido_uc", new Integer(0));
		    dataset.fieldValue("pend_recep_uc", new Integer(0));
			dataset.fieldValue("oid_oc", new Integer(0));
			dataset.fieldValue("codigo_oc", "");
			dataset.fieldValue("oid_oc_det", new Integer(0));
			dataset.fieldValue("ref_oc", "");
		}
		
	}

}
