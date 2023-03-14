package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRemito extends Operation {

	public TraerRemito() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		RemitoCab remitocab = null;
		Integer oid = mapaDatos.getInteger("oid");
		remitocab = RemitoCab.findByOid(oid, getSesion());

		IDataSet datasetRemitoCab = getDataSetRemitoCab();
		IDataSet datasetMovStk = getDataSetMovStock();
		IDataSet datasetTipoRto = getDataSetTipoRto();
		IDataSet datasetRemitoDet = getDataSetRemitoDet();
		
		if (remitocab != null)
			cargarRegistroRemitoCab(datasetRemitoCab, remitocab);
		cargarRegistroMovStock(datasetMovStk, remitocab.getTipoConfMov().getOIDInteger(), remitocab.getTipoConfMov()
				.getCodigo(), remitocab.getTipoConfMov().getDescripcion(), remitocab.getTipoConfMov().isActivo(), remitocab
				.getComportamientoRto(), new Boolean(true), remitocab.getTipoConfMov().getOIDInteger());
		cargarRegistroTipoRemito(datasetTipoRto, new Integer(1), remitocab.getComportamientoRto(), RemitoCab
				.getTipoRemito(remitocab.getComportamientoRto()), new Boolean(true), new Boolean(true));
		Iterator iterDetallesRemito = remitocab.getDetalles().iterator();
		while (iterDetallesRemito.hasNext()) {
			RemitoDet remitoDet = (RemitoDet) iterDetallesRemito.next();
			cargarRegistroRemitoDet(datasetRemitoDet,remitoDet);
		}
		writeCliente(datasetRemitoDet);
		writeCliente(datasetTipoRto);
		writeCliente(datasetMovStk);
		writeCliente(datasetRemitoCab);
	}

	private void cargarRegistroMovStock(IDataSet dataset, Integer oid, String codigo, String descripcion, Boolean activo,
			String codigo_compo_rto, Boolean usarPorDefecto, Integer oidTipoConfMov) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("codigo_compo_rto", codigo_compo_rto);
		dataset.fieldValue("usar_por_defecto", usarPorDefecto);
		dataset.fieldValue("oid_tipo_conf_mov", oidTipoConfMov);
	}

	private IDataSet getDataSetMovStock() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMovStock");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("codigo_compo_rto", Field.STRING, 50));
		dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroTipoRemito(IDataSet dataset, Integer oid, String codigo, String descripcion,
			Boolean activo, Boolean usarPorDefecto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("usar_por_defecto", usarPorDefecto);
	}

	private IDataSet getDataSetTipoRto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoRto");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetRemitoDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRemitoDet");
		dataset.fieldDef(new Field("oid_remito_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_remito_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_desp", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_desp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_motivo_devolucion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ped_depo_det", Field.INTEGER, 0));
		return dataset;
	}	

	private IDataSet getDataSetRemitoCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRemitoCab");
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc", Field.STRING, 20));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("compo_rto", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_remito_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("destinatario", Field.STRING, 50));
		dataset.fieldDef(new Field("destino", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_depo_dest", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_uni_edi_dest", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_uni_org_dest", Field.STRING, 0));
		dataset.fieldDef(new Field("pend_fact", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("calle_y_nro", Field.STRING, 50));
		dataset.fieldDef(new Field("localidad", Field.STRING, 50));
		dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		dataset.fieldDef(new Field("nro_interno", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oc", Field.STRING, 50));
		dataset.fieldDef(new Field("pedido", Field.STRING, 50));
		return dataset;
	}
	
	private void cargarRegistroRemitoDet(IDataSet dataset, RemitoDet remitoDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_remito_det", remitoDet.getOIDInteger());
		dataset.fieldValue("oid_remito_cab", remitoDet.getRemito_cab().getOIDInteger());
		dataset.fieldValue("oid_producto", remitoDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", remitoDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", remitoDet.getProducto().getDescripcion());
		dataset.fieldValue("cant_desp", remitoDet.getCant_desp());
		dataset.fieldValue("oid_um_desp", remitoDet.getUnidad_desp().getOIDInteger());
		dataset.fieldValue("comentario", remitoDet.getComentario());
		dataset.fieldValue("activo", remitoDet.isActivo());
		if (remitoDet.getMotivoDevolucion()!=null)
			dataset.fieldValue("oid_motivo_devolucion", remitoDet.getMotivoDevolucion().getOIDInteger());
		else
			dataset.fieldValue("oid_motivo_devolucion", "");
		if (remitoDet.getPedidoDepositoDet()!=null)
			dataset.fieldValue("oid_ped_depo_det", remitoDet.getPedidoDepositoDet().getOIDInteger());
		else
			dataset.fieldValue("oid_ped_depo_det", "");
	}
	

	private void cargarRegistroRemitoCab(IDataSet dataset, RemitoCab remitoCab) throws BaseException {
		dataset.append();

		dataset.fieldValue("oid_talonario", remitoCab.getTalonario().getOIDInteger());
		dataset.fieldValue("oid_tc", remitoCab.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_tc", remitoCab.getTipoCompro().getCodigo());
		dataset.fieldValue("letra", remitoCab.getLetra());
		dataset.fieldValue("oid_lug_emi", remitoCab.getLugarEmision().getOIDInteger());
		dataset.fieldValue("nro_lug_emi", remitoCab.getLugarEmision().getLugemi());
		dataset.fieldValue("nro_ext", remitoCab.getNroExt());
		dataset.fieldValue("fecha", remitoCab.getEmision());
		dataset.fieldValue("oid_tipo_conf_mov", remitoCab.getTipoConfMov().getOIDInteger());
		dataset.fieldValue("compo_rto", remitoCab.getComportamientoRto());
		if (remitoCab.getSujeto() != null) {
			dataset.fieldValue("oid_sujeto", remitoCab.getSujeto().getOIDInteger());
			dataset.fieldValue("cod_sujeto", remitoCab.getSujeto().getCodigo());
			dataset.fieldValue("rz_sujeto", remitoCab.getSujeto().getRazon_social());
		}
		else {
			if (remitoCab.getProveedor() != null) {
				dataset.fieldValue("oid_sujeto", remitoCab.getProveedor().getOIDInteger());
				dataset.fieldValue("cod_sujeto", remitoCab.getProveedor().getCodigo());
				dataset.fieldValue("rz_sujeto", remitoCab.getProveedor().getRazonsocial());
			} else if (remitoCab.getDepo_destino() != null) {
				dataset.fieldValue("oid_sujeto", remitoCab.getDepo_destino().getOIDInteger());
				dataset.fieldValue("cod_sujeto", remitoCab.getDepo_destino().getCodigo());
				dataset.fieldValue("rz_sujeto", remitoCab.getDepo_destino().getDescripcion());
			}
			else {
				dataset.fieldValue("oid_sujeto", 0);
				dataset.fieldValue("cod_sujeto", "");
				dataset.fieldValue("rz_sujeto", "");
			}
		}

		dataset.fieldValue("oid_remito_cab", remitoCab.getOIDInteger());

		dataset.fieldValue("destinatario", remitoCab.getDestinatario());
		dataset.fieldValue("destino", remitoCab.getDestino());
		if (remitoCab.getDepo_destino() != null)
			dataset.fieldValue("oid_depo_dest", remitoCab.getDepo_destino().getOIDInteger());
		else
			dataset.fieldValue("oid_depo_dest", 0);
		if (remitoCab.getUni_edi_dest() != null)
			dataset.fieldValue("oid_uni_edi_dest", remitoCab.getUni_edi_dest().getOIDInteger());
		else
			dataset.fieldValue("oid_uni_edi_dest", 0);
		if (remitoCab.getUni_org_dest() != null)
			dataset.fieldValue("oid_uni_org_dest", remitoCab.getUni_org_dest().getOIDInteger());
		else
			dataset.fieldValue("oid_uni_org_dest", 0);
		dataset.fieldValue("pend_fact", remitoCab.isPend_fact());
		if (remitoCab.getCalle_y_nro() != null)
			dataset.fieldValue("calle_y_nro", remitoCab.getCalle_y_nro());
		else
			dataset.fieldValue("calle_y_nro", "");
		dataset.fieldValue("localidad", remitoCab.getLocalidad());
		dataset.fieldValue("codigo_postal", remitoCab.getCodigo_postal());

		if (remitoCab.getProvincia() != null)
			dataset.fieldValue("oid_provincia", remitoCab.getProvincia().getOIDInteger());
		else
			dataset.fieldValue("oid_provincia", 0);

		if (remitoCab.getPais() != null)
			dataset.fieldValue("oid_pais", remitoCab.getPais().getOIDInteger());
		else
			dataset.fieldValue("oid_pais", 0);

		dataset.fieldValue("activo", remitoCab.isActivo());
		dataset.fieldValue("comentario", remitoCab.getComentario());
		dataset.fieldValue("nro_interno", remitoCab.getNroInterno());
		dataset.fieldValue("oc", remitoCab.getReferencia1());
		dataset.fieldValue("pedido", remitoCab.getReferencia2());
		

	}
}
