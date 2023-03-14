package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.OrdenDeCompraDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerOrdenDeCompra extends Operation {

	public TraerOrdenDeCompra() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		OrdenDeCompraCab ordendecompracab = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			ordendecompracab = OrdenDeCompraCab.findByOid(oid, getSesion());
		}

		IDataSet datasetOrdenDeCompraCab = getDataSetOrdenDeCompraCab();
		IDataSet datasetOrdenDeCompraDet = getDataSetOrdenDeCompraDet();
		IDataSet datasetItemsABorrar = getDataSetItemsABorrar();

		if (ordendecompracab != null) {
			cargarRegistroOrdenDeCompraCab(datasetOrdenDeCompraCab,ordendecompracab);
			Iterator iterOCDet = ordendecompracab.getDetallesOC().iterator();
			while (iterOCDet.hasNext()) {
				OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterOCDet.next();
				if (ocDet.isAnulado().booleanValue()) continue;
				cargarRegistroOrdenDeCompraDet(datasetOrdenDeCompraDet, ocDet);
			}
		}
		
		writeCliente(datasetOrdenDeCompraCab);
		writeCliente(datasetOrdenDeCompraDet);
		writeCliente(datasetItemsABorrar);
		
	}

	private IDataSet getDataSetOrdenDeCompraCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOCCab");
		dataset.fieldDef(new Field("oid_oc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_oc", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc", Field.STRING, 50));
		dataset.fieldDef(new Field("letra", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_prov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("dto_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("en_cascada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_via_despacho", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_cond_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("tomar_precios_de", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_requisicion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext_requisicion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_requisicion", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_cotiz_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext_cotiz_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ext_cotiz_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("porc_recargo",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_sector_compra",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_lugar_entrega", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_lug_entrega", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_lugar_entrega", Field.STRING, 255));
		dataset.fieldDef(new Field("agrupa_items_impre", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("estado_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("leyenda_estado_autoriz", Field.STRING, 100));
		dataset.fieldDef(new Field("roles_pend_autoriz", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroOrdenDeCompraCab(IDataSet dataset,
			OrdenDeCompraCab ordenCompra) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_oc", ordenCompra.getOIDInteger());
		dataset.fieldValue("tipo_oc", ordenCompra.getTipo());
		dataset.fieldValue("oid_talonario", ordenCompra.getTalonario()
				.getOIDInteger());
		dataset.fieldValue("oid_tc", ordenCompra.getTipoCompro()
				.getOIDInteger());
		dataset.fieldValue("cod_tc", ordenCompra.getTipoCompro().getCodigo());
		dataset.fieldValue("letra", ordenCompra.getLetra());
		dataset.fieldValue("oid_lug_emi", ordenCompra.getLugarEmision()
				.getOIDInteger());
		dataset
				.fieldValue("lug_emi", ordenCompra.getLugarEmision()
						.getLugemi());
		dataset.fieldValue("nro_ext", ordenCompra.getNroExt());
		dataset.fieldValue("fec_emision", ordenCompra.getEmision());
		dataset.fieldValue("oid_prov", ordenCompra.getProveedor()
				.getOIDInteger());
		dataset.fieldValue("cod_prov", ordenCompra.getProveedor().getCodigo());
		dataset.fieldValue("rs_prov", ordenCompra.getProveedor()
				.getRazonsocial());
		dataset.fieldValue("oid_moneda", ordenCompra.getMoneda()
				.getOIDInteger());
		dataset.fieldValue("oid_cond_pago", ordenCompra.getCond_pago_1()
				.getOIDInteger());
		dataset.fieldValue("activo", ordenCompra.isActivo());
		dataset.fieldValue("dto_1", ordenCompra.getDto_1_1());
		dataset.fieldValue("dto_2", ordenCompra.getDto_1_2());
		dataset.fieldValue("dto_3", ordenCompra.getDto_1_3());
		dataset.fieldValue("en_cascada", ordenCompra.isDtoEnCascada());
		dataset
				.fieldValueOID("oid_via_despacho", ordenCompra
						.getVia_despacho());
		dataset.fieldValue("comentario", ordenCompra.getComentario());
		dataset.fieldValueOID("oid_cond_compra", ordenCompra
				.getCond_compra_importacion());
		dataset.fieldValue("anulado", new Boolean(!ordenCompra.isActivo()
				.booleanValue()));
		dataset
				.fieldValue("tomar_precios_de", ordenCompra
						.getTomar_precio_de());
		dataset.fieldValue("oid_requisicion", new Integer(0));
		dataset.fieldValue("nro_ext_requisicion", "");
		dataset.fieldValue("cod_requisicion", "");
		dataset.fieldValue("oid_cotiz_prov", new Integer(0));
		dataset.fieldValue("nro_ext_cotiz_prov", new Integer(0));
		dataset.fieldValue("cod_ext_cotiz_prov", new Integer(0));
		dataset.fieldValue("porc_recargo", ordenCompra.getPorcRecargo());
		if (ordenCompra.getSectorCompra()!=null)
		  dataset.fieldValue("oid_sector_compra",ordenCompra.getSectorCompra().getOIDInteger());
		else
			dataset.fieldValue("oid_sector_compra",0);
		if (ordenCompra.getCotizacion()!=null)
		  dataset.fieldValue("cotizacion",ordenCompra.getCotizacion().doubleValue());
		else
			dataset.fieldValue("cotizacion",0);

		if (ordenCompra.getLugarEntrega()!=null) {
			dataset.fieldValue("oid_lugar_entrega",ordenCompra.getLugarEntrega().getOIDInteger());
			dataset.fieldValue("cod_lug_entrega", ordenCompra.getLugarEntrega().getCodigo());					
			dataset.fieldValue("desc_lugar_entrega", ordenCompra.getLugarEntrega().getDescripcion());
		}
		else {
			dataset.fieldValue("oid_lugar_entrega",new Integer(0));
			dataset.fieldValue("cod_lug_entrega","");
			dataset.fieldValue("desc_lugar_entrega","");
		}
		dataset.fieldValue("agrupa_items_impre", ordenCompra.isAgrupaItemsImpresion());
		dataset.fieldValue("estado_autoriz", ordenCompra.getEstado_autorizacion());
		dataset.fieldValue("leyenda_estado_autoriz", ordenCompra.getLeyendaImpresionEstadoAutoriz());
		if (ordenCompra.isPendAutorizar())
			dataset.fieldValue("roles_pend_autoriz", ordenCompra.getRolesOCPendAut());
		else
			dataset.fieldValue("roles_pend_autoriz", "");
		
		
	}

	private IDataSet getDataSetOrdenDeCompraDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOCDet");
		dataset.fieldDef(new Field("oid_oc_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_oc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_adic_producto", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_um_cpra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_cpra", Field.STRING, 50));
		dataset.fieldDef(new Field("cant_comprada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("desc_moneda", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_item", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("dto_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("en_cascada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fuente_origen", Field.STRING, 50));
		dataset.fieldDef(new Field("porc_recar", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tipo_recar_dto", Field.STRING, 10));
		dataset.fieldDef(new Field("porc_dto_recar", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_requerida", Field.DATE, 0));
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ref_det_pedido", Field.STRING, 1000));
		dataset.fieldDef(new Field("nro_item_pedido", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fuente_origen", Field.STRING, 100));
		dataset.fieldDef(new Field("precio_neto", Field.CURRENCY, 0));
		
		
		return dataset;
	}

	private void cargarRegistroOrdenDeCompraDet(IDataSet dataset,
			OrdenDeCompraDet ordenCompraDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_oc_det", ordenCompraDet.getOIDInteger());
		dataset.fieldValue("oid_oc", ordenCompraDet.getOrden_de_compra()
				.getOIDInteger());
		dataset.fieldValue("oid_producto", ordenCompraDet.getProducto()
				.getOIDInteger());
		dataset.fieldValue("cod_producto", ordenCompraDet.getProducto()
				.getCodigo());
		dataset.fieldValue("desc_producto", ordenCompraDet.getProducto().getDescripcion());
		dataset.fieldValue("desc_adic_producto", ordenCompraDet
				.getDesc_adic_sku());
		dataset.fieldValue("activo", new Boolean(!ordenCompraDet.isAnulado().booleanValue()));
		dataset.fieldValue("oid_um_cpra", ordenCompraDet.getUnidad_compra()
				.getOIDInteger());
		dataset.fieldValue("cod_um_cpra", ordenCompraDet.getUnidad_compra()
				.getCodigo());
		dataset.fieldValue("cant_comprada", ordenCompraDet
				.getCant_comprada_uc());
		dataset.fieldValue("oid_moneda", ordenCompraDet.getMoneda()
				.getOIDInteger());
		dataset.fieldValue("precio", ordenCompraDet.getPrecio());
		dataset.fieldValue("desc_moneda", ordenCompraDet.getMoneda()
				.getDescripcion());
		dataset.fieldValue("nro_item", ordenCompraDet.getNro_item());
		dataset.fieldValue("comentario", ordenCompraDet.getComentario());
		dataset.fieldValue("dto_1", ordenCompraDet.getDto1());
		dataset.fieldValue("dto_2", ordenCompraDet.getDto2());
		dataset.fieldValue("dto_3", ordenCompraDet.getDto3());
		dataset.fieldValue("en_cascada", ordenCompraDet.isEnCascada());
		;
		dataset.fieldValue("fuente_origen", ordenCompraDet
				.getFuente_precio_sug());
		dataset.fieldValue("porc_recar",  ordenCompraDet.getPorcRecar());
		dataset.fieldValue("tipo_recar_dto",ordenCompraDet.getTipoRecarDto());
		dataset.fieldValue("porc_dto_recar",ordenCompraDet.getPorcDtoRecar());
		dataset.fieldValue("fec_requerida", ordenCompraDet.getFecRequerida());
		dataset.fieldValue("total", ordenCompraDet.getTotal());
		
		if (ordenCompraDet.getPedidoCab()!=null)
			dataset.fieldValue("oid_cco_ped", ordenCompraDet.getPedidoCab().getOID());
		else
			dataset.fieldValue("oid_cco_ped", new Integer(0));
		
		if (ordenCompraDet.getPedidoDet()!=null)
			dataset.fieldValue("oid_ped_det", ordenCompraDet.getPedidoDet().getOIDInteger());
		else
			dataset.fieldValue("oid_ped_det", new Integer(0));
		
		if (ordenCompraDet.getPedidoCab()!=null)
			dataset.fieldValue("nro_ext_ped", ordenCompraDet.getPedidoCab().getNroExt());
		else
			dataset.fieldValue("nro_ext_ped", new Integer(0));
		
		if (ordenCompraDet.getPedidoDet()!=null) 
			dataset.fieldValue("ref_det_pedido", ordenCompraDet.getPedidoDet().getDescripcion());
		else
		 if (ordenCompraDet.getRequisicionDet()!=null) 
			dataset.fieldValue("ref_det_pedido", ordenCompraDet.getRequisicionDet().getRequisicion().getCodigo()+"/"+ordenCompraDet.getRequisicionDet().getRenglon());
		 else if (ordenCompraDet.getPedidoCab()!=null)
			 dataset.fieldValue("ref_det_pedido", ordenCompraDet.getPedidoCab().getCodigo());
		else
			dataset.fieldValue("ref_det_pedido", "");
		
		if (ordenCompraDet.getPedidoDet()!=null)
			dataset.fieldValue("nro_item_pedido", ordenCompraDet.getPedidoDet().getNroRenglon());
		else
			dataset.fieldValue("nro_item_pedido", 0);
		
		dataset.fieldValue("fuente_origen", ordenCompraDet.getFuente_precio_sug());
		dataset.fieldValue("precio_neto", ordenCompraDet.getPrecio_neto_bonif());
	}

	
	private IDataSet getDataSetItemsABorrar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TItemsABorrar");
		dataset.fieldDef(new Field("oid_oc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_oc_det", Field.INTEGER, 0));
		return dataset;
	}	
	
	
}
