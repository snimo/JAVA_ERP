package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.InformeControlCalidad;
import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.bm.MotivoRechazoInfCC;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInformeControlCalidad extends Operation {

	public TraerInformeControlCalidad() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		InformeControlCalidad infCC = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			infCC = InformeControlCalidad.findByOid(oid,
					getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			infCC = (InformeControlCalidad)InformeControlCalidad.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetInformeControlCalidad = getDataSetInformeControlCalidad();
		IDataSet datasetInformeControlCalidadDet = getDataSetInformeControlCalidadDet();
		IDataSet datasetMotivosRechazos = getDataSetMotivosRechazos();
		
		cargarRegistroInformeControlCalidad(datasetInformeControlCalidad,infCC);
		Iterator iterInfCC = infCC.getDetallesInfCC().iterator();
		while (iterInfCC.hasNext()) {
			InformeControlCalidadDet infCCDet = (InformeControlCalidadDet) iterInfCC.next();
			cargarRegistroInformeControlCalidadDet(datasetInformeControlCalidadDet,infCCDet);
			Iterator iterMovRechazos = infCCDet.getMotivosRechazos().iterator();
			while (iterMovRechazos.hasNext()) {
				MotivoRechazoInfCC motivoRechazoInfCC = (MotivoRechazoInfCC) iterMovRechazos.next();
				cargarRegistroMotRechazo(datasetMotivosRechazos,infCCDet,motivoRechazoInfCC);
			}
		}
		
		writeCliente(datasetInformeControlCalidad);
		writeCliente(datasetInformeControlCalidadDet);
		writeCliente(datasetMotivosRechazos);
		
	}

	private IDataSet getDataSetInformeControlCalidad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInformeControlCalidad");
		dataset.fieldDef(new Field("oid_inf_cc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc", Field.STRING, 20));
		dataset.fieldDef(new Field("letra",Field.STRING, 1));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
		return dataset;
	}
	

	private void cargarRegistroInformeControlCalidad(IDataSet dataset,
			InformeControlCalidad infCC) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_inf_cc", infCC.getOIDInteger());
		dataset.fieldValue("oid_talonario", infCC.getTalonario().getOIDInteger());
		dataset.fieldValue("oid_tc", infCC.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_tc", infCC.getTipoCompro().getCodigo());
		dataset.fieldValue("letra",infCC.getLetra());
		dataset.fieldValue("oid_lug_emi", infCC.getLugarEmision().getOIDInteger());
		dataset.fieldValue("lug_emi", infCC.getLugarEmision().getLugemi());
		dataset.fieldValue("nro_ext",infCC.getNroExt());
		dataset.fieldValue("fec_emision", infCC.getImputac());
		dataset.fieldValue("comentario", infCC.getComentario());
		dataset.fieldValue("activo",infCC.isActivo());
	}	

	private IDataSet getDataSetInformeControlCalidadDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInformeControlCalidadDet");
		dataset.fieldDef(new Field("oid_cc_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_inf_cc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_inf_rec_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ok_us", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("rechazos_us", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("cant_ret_prov_uc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_ret_prov_us", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pend_ret_prov", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov" , Field.STRING, 50));
		dataset.fieldDef(new Field("rs_prov" , Field.STRING, 100));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto" , Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto" , Field.STRING, 100));
		dataset.fieldDef(new Field("desc_adic_producto", Field.STRING, 255));
		dataset.fieldDef(new Field("articulo_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_stk", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_recep_us", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pend_cc_us", Field.CURRENCY, 0));
		
		
		
		return dataset;
	}

	private void cargarRegistroInformeControlCalidadDet(IDataSet dataset,
			InformeControlCalidadDet infCCDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cc_det", infCCDet.getOIDInteger());
		dataset.fieldValue("oid_inf_cc", infCCDet.getInforme_cc().getOIDInteger());
		dataset.fieldValue("oid_inf_rec_det", infCCDet.getInforme_recepcion_det().getOIDInteger());
		dataset.fieldValue("ok_us", infCCDet.getCant_ok_us());
		dataset.fieldValue("rechazos_us", infCCDet.getCant_mal_us());
		dataset.fieldValue("comentario", infCCDet.getObservaciones());
		dataset.fieldValue("cant_ret_prov_uc", infCCDet.getCant_ret_prov_uc());
		dataset.fieldValue("cant_ret_prov_us", infCCDet.getCant_ret_prov_us());
		dataset.fieldValue("pend_ret_prov", infCCDet.isPend_ret_prov());
		dataset.fieldValue("anulado", infCCDet.isAnulado());
		Proveedor proveedor = infCCDet.getInforme_recepcion_det().getInforme_recepcion().getProveedor();
		dataset.fieldValue("oid_prov", proveedor.getOIDInteger());
		dataset.fieldValue("cod_prov" , proveedor.getCodigo());
		dataset.fieldValue("rs_prov" , proveedor.getRazonsocial());
		Producto producto = infCCDet.getInforme_recepcion_det().getProducto();
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("cod_producto" , producto.getCodigo());
		dataset.fieldValue("desc_producto" , producto.getDescripcion());
		dataset.fieldValue("desc_adic_producto", "");
		if (producto.getProductoProveedor(proveedor)!=null)
			dataset.fieldValue("articulo_proveedor", producto.getProductoProveedor(proveedor).getCodigo());
		else
			dataset.fieldValue("articulo_proveedor", "");
		dataset.fieldValue("oid_um_stk",infCCDet.getInforme_recepcion_det().getUnidadMedidaStock().getOIDInteger());
		dataset.fieldValue("cant_recep_us",infCCDet.getInforme_recepcion_det().getCant_rec_en_us());
		dataset.fieldValue("pend_cc_us", new Double(0));
	}
	
	private IDataSet getDataSetMotivosRechazos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivosRechazoInfCC");
		dataset.fieldDef(new Field("oid_mot_rech_cc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cc_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_mal_us", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		return dataset;
	}
	
	private void cargarRegistroMotRechazo(IDataSet dataset, InformeControlCalidadDet infCCDet,
			MotivoRechazoInfCC motRechInfCC) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_mot_rech_cc", motRechInfCC.getOIDInteger());
		dataset.fieldValue("oid_cc_det", infCCDet.getOIDInteger());
		dataset.fieldValue("cant_mal_us", motRechInfCC.getCant_mal_us());
		dataset.fieldValue("oid_motivo", motRechInfCC.getMotivoRechazoCC().getOIDInteger());
	}	
	
}
