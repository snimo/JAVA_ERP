package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImpresionInfRec extends Operation {

	public ImpresionInfRec() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsInfRec = this.getDataSetInfRec();
		IDataSet dsInfRecDet = this.getDataSetInfRecDet();

		InformeRecepcion infRec = InformeRecepcion.findByOid(mapaDatos.getInteger("oid_cco"), getSesion());
		cargarRegistroInfRec(dsInfRec, infRec);
		Iterator iterDetInfRec = infRec.getDetallesInfRec().iterator();
		while (iterDetInfRec.hasNext()) {
			InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterDetInfRec.next();
			cargarRegistroInfRecDet(dsInfRecDet, infRecDet);
		}
		writeCliente(dsInfRec);
		writeCliente(dsInfRecDet);
	}

	private void cargarRegistroInfRec(IDataSet dataset, InformeRecepcion infRec) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cco", infRec.getOID());
		dataset.fieldValue("comprobante", infRec.getCodigo());
		dataset.fieldValue("tc", infRec.getTipoCompro().getCodigo());
		dataset.fieldValue("letra", infRec.getLetra());
		dataset.fieldValue("lug_emi", infRec.getNroLugEmision());
		dataset.fieldValue("nro_ext", infRec.getNroExt());
		dataset.fieldValue("fecha", infRec.getEmision());
		dataset.fieldValue("cod_prov", infRec.getProveedor().getCodigo());
		dataset.fieldValue("razon_social_prov", infRec.getProveedor().getRazonsocial());
		dataset.fieldValue("remito", infRec.getRemito_prov());
		dataset.fieldValue("comentario", infRec.getComentario());
	}

	private void cargarRegistroInfRecDet(IDataSet dataset, InformeRecepcionDet infRecDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_inf_rec_det", infRecDet.getOIDInteger());
		dataset.fieldValue("oid_cco_inf_rec", infRecDet.getInforme_recepcion().getOIDInteger());
		dataset.fieldValue("nro_item", infRecDet.getNro_item());
		dataset.fieldValue("oid_producto", infRecDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", infRecDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", infRecDet.getProducto().getDesc_abrev());
		dataset.fieldValue("um_stock", infRecDet.getUnidadMedidaStock().getCodigo());
		dataset.fieldValue("cant_um_stock", infRecDet.getCant_rec_en_us());
		dataset.fieldValue("um_compra", infRecDet.getUnidadMedidaCompra().getCodigo());
		dataset.fieldValue("cant_um_compra", infRecDet.getCant_rec_en_uc());
		dataset.fieldValue("comentario", infRecDet.getComentario());
		if (infRecDet.getOrdenDeCompraDet()!=null)
			dataset.fieldValue("oc", "Recepciones "+infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getCodigo());
		else
			dataset.fieldValue("oc", "");
	}

	private IDataSet getDataSetInfRec() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInfRec");
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("tc", Field.STRING, 10));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("cod_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("razon_social_prov", Field.STRING, 100));
		dataset.fieldDef(new Field("remito", Field.STRING, 50));
		dataset.fieldDef(new Field("comentario", Field.STRING, 5000));
		return dataset;
	}

	private IDataSet getDataSetInfRecDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInfRecDet");
		dataset.fieldDef(new Field("oid_inf_rec_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_inf_rec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_item", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
		dataset.fieldDef(new Field("um_stock", Field.STRING, 20));
		dataset.fieldDef(new Field("cant_um_stock", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("um_compra", Field.STRING, 20));
		dataset.fieldDef(new Field("cant_um_compra", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("oc", Field.STRING, 50));
		return dataset;
	}

}
