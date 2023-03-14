package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.RequisicionDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRequisicion extends Operation {

	public TraerRequisicion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		RequisicionCab requisicioncab = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			requisicioncab = RequisicionCab.findByOid(oid, getSesion());			
		}

		IDataSet datasetRequisicionCab = getDataSetRequisicionCab();
		IDataSet datasetRequisicionDet = getDataSetRequisicionDet();
		if (requisicioncab != null) {
			cargarRegistroRequisicionCab(datasetRequisicionCab, requisicioncab);
			Iterator iterRequisicionDet = requisicioncab.getRequisicionesDet().iterator();
			while (iterRequisicionDet.hasNext()) {
				RequisicionDet requisicionDet = (RequisicionDet) iterRequisicionDet.next();
				cargarRegistroRequisicionDet(datasetRequisicionDet,requisicioncab,requisicionDet);
			}
		}
		writeCliente(datasetRequisicionCab);
		writeCliente(datasetRequisicionDet);
	}

	private IDataSet getDataSetRequisicionCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRequisicionCab");
		dataset.fieldDef(new Field("oid_cco_requi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc", Field.STRING, 20));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
		dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nombre", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_sector_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_requerida", Field.STRING, 10));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("anulado", Field.BOOLEAN,0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN,0));
		return dataset;
	}

	private IDataSet getDataSetRequisicionDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRequisicionDet");
		dataset.fieldDef(new Field("oid_req_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_requi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_adic_sku", Field.STRING, 255));
		dataset.fieldDef(new Field("cant_solicitada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_solicitada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_comprada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_req", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
		dataset.fieldDef(new Field("fec_requerida", Field.STRING, 10));
		dataset.fieldDef(new Field("fec_entrega", Field.STRING, 10));
		dataset.fieldDef(new Field("decision_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("anulada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("solo_cotizar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("pend_sol_cotiz", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("estado_autorizacion",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proveedor",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor",Field.STRING, 50));
		dataset.fieldDef(new Field("rs_proveedor",Field.STRING, 100));
		dataset.fieldDef(new Field("oid_cco_ref",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_ref_det",Field.INTEGER, 0));
		dataset.fieldDef(new Field("nickname_compro_ref",Field.STRING, 100));
		dataset.fieldDef(new Field("referencia",Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroRequisicionCab(IDataSet dataset,
			RequisicionCab requisicionCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cco_requi", requisicionCab.getOIDInteger());
		dataset.fieldValue("oid_talonario", requisicionCab.getTalonario()
				.getOIDInteger());
		dataset.fieldValue("oid_tc", requisicionCab.getTipoCompro()
				.getOIDInteger());
		dataset.fieldValue("cod_tc", requisicionCab.getTcExt());
		dataset.fieldValue("letra", requisicionCab.getLetra());
		dataset.fieldValue("oid_lug_emi", requisicionCab.getLugarEmision()
				.getOIDInteger());
		dataset.fieldValue("lug_emi", requisicionCab.getLugarEmision()
				.getLugemi());
		dataset.fieldValue("nro_ext", requisicionCab.getNroExt());
		dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(requisicionCab.getEmision()));
		dataset.fieldValue("oid_usuario", requisicionCab.getUsuario()
				.getOIDInteger());
		dataset.fieldValue("ape_y_nombre", requisicionCab.getUsuario()
				.getApellidoyNombre());
		dataset.fieldValue("oid_sector_compra", requisicionCab
				.getSectorCompra().getOIDInteger());
		dataset.fieldValue("fec_requerida", Fecha.FECHA_NULA());
		dataset.fieldValue("comentario", requisicionCab.getComentario());
		dataset.fieldValue("anulado",new Boolean(!requisicionCab.isActivo().booleanValue()));
		dataset.fieldValue("activo",requisicionCab.isActivo().booleanValue());
	}

	private void cargarRegistroRequisicionDet(IDataSet dataset,
			RequisicionCab requisicionCab,
			RequisicionDet requisicionDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_req_det", requisicionDet.getOIDInteger());
		dataset.fieldValue("oid_cco_requi", requisicionCab.getOIDInteger());
		dataset.fieldValue("nro_renglon", requisicionDet.getRenglon());
		dataset.fieldValue("codigo_producto", requisicionDet.getProducto().getCodigo());
		dataset.fieldValue("oid_producto", requisicionDet.getProducto().getOIDInteger());
		dataset.fieldValue("desc_producto", requisicionDet.getProducto().getDescripcion());
		if (requisicionDet.getDesc_adic_sku()!=null)
		  dataset.fieldValue("desc_adic_sku", requisicionDet.getDesc_adic_sku());
		else
		  dataset.fieldValue("desc_adic_sku", "");				
		dataset.fieldValue("cant_solicitada", requisicionDet.getCant_solicitada());
		dataset.fieldValue("cant_comprada", requisicionDet.getCan_comprada());
		dataset.fieldValue("oid_um_req", requisicionDet.getUnidad_medida_req().getOIDInteger());
		dataset.fieldValue("fec_emision",Fecha.getddmmyyyy(requisicionDet.getFec_emision()));
		dataset.fieldValue("fec_requerida",Fecha.getddmmyyyy(requisicionDet.getFec_requerida()));
		if (requisicionDet.getFec_entrega()!=null)
		  dataset.fieldValue("fec_entrega", Fecha.getddmmyyyy(requisicionDet.getFec_entrega()));
		else
		  dataset.fieldValue("fec_entrega", Fecha.FECHA_NULA());
		dataset.fieldValue("decision_autoriz", requisicionDet.getDecision_autoriz());
		dataset.fieldValue("anulada", requisicionDet.isAnulada());
		dataset.fieldValue("solo_cotizar", requisicionDet.isSolo_cotizar());
		if (requisicionDet.getComentario()!=null)
		  dataset.fieldValue("comentario", requisicionDet.getComentario());
		else
		  dataset.fieldValue("comentario", "");
		dataset.fieldValue("pend_sol_cotiz", requisicionDet.isPend_sol_cotiz());	
		dataset.fieldValue("estado_autorizacion", requisicionDet.getDecision_autoriz());
		
		if (requisicionDet.getProveedor()!=null) {
			dataset.fieldValue("oid_proveedor", requisicionDet.getProveedor().getOIDInteger());
			dataset.fieldValue("cod_proveedor", requisicionDet.getProveedor().getCodigo());
			dataset.fieldValue("rs_proveedor", requisicionDet.getProveedor().getRazonsocial());
		} else {
			dataset.fieldValue("oid_proveedor", "");
			dataset.fieldValue("cod_proveedor", "");
			dataset.fieldValue("rs_proveedor", "");
		}
		
		dataset.fieldValue("oid_cco_ref", requisicionDet.getOidComproRef());
		dataset.fieldValue("oid_cco_ref_det", requisicionDet.getOidComproRefDet());
		dataset.fieldValue("nickname_compro_ref", requisicionDet.getNickNameTipoComproRef());
		dataset.fieldValue("referencia", requisicionDet.getReferencia());
		
		
		
	}

}
