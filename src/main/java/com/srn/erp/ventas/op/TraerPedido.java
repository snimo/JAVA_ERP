package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.ObsCodifPedidoCab;
import com.srn.erp.ventas.bm.ObsCodifPresuCab;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPedido extends Operation {

	public TraerPedido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		PedidoCab pedidocab = null;
		Integer oid = mapaDatos.getInteger("oid");
		pedidocab = PedidoCab.findByOid(oid, getSesion());

		IDataSet dasasetDetalles = getDataSetPedidoDet();
		IDataSet datasetPedidoCab = getDataSetPedidoCab();
		IDataSet datasetItemsABorrar = getDataSetItemsABorrar();
		IDataSet datasetObsCodif = this.getDataSetObsCodifPedidoCab();
		
		if (pedidocab != null) {
			cargarRegistroPedidoCab(datasetPedidoCab,
									pedidocab);
			enviarDetallesPedidos(dasasetDetalles,pedidocab);
			enviarObsCodif(datasetObsCodif,pedidocab);

		}
		writeCliente(datasetPedidoCab);
		writeCliente(dasasetDetalles);
		writeCliente(datasetItemsABorrar);
		writeCliente(datasetObsCodif);
	}

	public void enviarDetallesPedidos(IDataSet dasasetDetalles,
			PedidoCab pedidoCab) throws BaseException {
		Iterator iterDetalles = pedidoCab.getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			PedidoDet pedidoDet = (PedidoDet) iterDetalles.next();
			if (pedidoDet.isAnulado().booleanValue()) continue;
			cargarRegistroPedidoDet(dasasetDetalles,pedidoCab, pedidoDet);
		}

	}

	private IDataSet getDataSetItemsABorrar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TItemsABorrar");
		dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_oed", Field.INTEGER, 0));
		return dataset;
	}	
	
	private IDataSet getDataSetPedidoCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPedidoCab");
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc",Field.STRING, 50));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_cliente", Field.STRING, 30));
		dataset.fieldDef(new Field("rz_cliente", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_proyecto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proyecto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_proyecto", Field.STRING, 100));
		dataset.fieldDef(new Field("letra", Field.STRING, 0));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_fact", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("mercado", Field.STRING, 1));
		dataset.fieldDef(new Field("porc_bonif_cli", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_reca_cli", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("bonif_cli_cascada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("reca_cli_cascada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_lp", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_lp", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_cond_pago", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_cond_pago", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_vendedor", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_vendedor", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_uni_edi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_uni_edi", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_uni_edi", Field.STRING, 50));
		dataset.fieldDef(new Field("porc_bonif_cp", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_reca_cp", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("bonif_cp_cascada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("reca_cp_cascada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("observado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_transporte", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_transporte", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_transporte", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_moneda_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_forma_entrega", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_forma_entrega", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_forma_entrega", Field.STRING, 100));
		dataset.fieldDef(new Field("orden_compra", Field.STRING, 50));
		dataset.fieldDef(new Field("compor_cotiz_fact", Field.STRING, 10));
		
		dataset.fieldDef(new Field("impre_bruto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_porc_dto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_descuento", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_porc_recar", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_recargo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_neto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_iva_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_perc_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_imp_internos", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_perc_ib", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_contacto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_contacto", Field.STRING, 50));
		dataset.fieldDef(new Field("nom_y_ape_contacto", Field.STRING, 200));

		dataset.fieldDef(new Field("oid_conc_impu_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu_iva_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_ib", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu_int", Field.INTEGER, 0));
		
		
		
		return dataset;
	}

	private void cargarRegistroPedidoDet(IDataSet dataset, PedidoCab pedidoCab, PedidoDet pedidoDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("nro_renglon", pedidoDet.getNroRenglon());
		dataset.fieldValue("oid_ped_det", pedidoDet.getOIDInteger());
		dataset.fieldValue("oid_cco_ped", pedidoCab.getOIDInteger());
		dataset.fieldValue("oid_art", pedidoDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", pedidoDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", pedidoDet.getProducto().getDescripcion());
		dataset.fieldValue("oid_um_ori", pedidoDet.getUni_med_ori().getOIDInteger());
		dataset.fieldValue("cantidad", pedidoDet.getCant_um_ori());
		dataset.fieldValue("precio", pedidoDet.getPrecio());
		dataset.fieldValue("precio_lista", pedidoDet.getPrecio_lista());
		dataset.fieldValue("precio_sugerido", new Money(0));
		dataset.fieldValue("precio_bonif", pedidoDet.getPrecio_bonif());
		dataset.fieldValue("oid_moneda", pedidoDet.getMoneda().getOIDInteger());
		dataset.fieldValue("activo", pedidoDet.isActivo());
		dataset.fieldValue("bonif1", pedidoDet.getBonif1());
		dataset.fieldValue("bonif2", pedidoDet.getBonif2());
		dataset.fieldValue("bonif3", pedidoDet.getBonif3());
		dataset.fieldValue("comentario", pedidoDet.getComentario());
		dataset.fieldValue("fec_entrega", pedidoDet.getFechaEntrega());
		dataset.fieldValue("activo", new Boolean(true));
		
		if (pedidoDet.getConcImpuIVA()!=null)
			dataset.fieldValue("oid_conc_imp_iva", pedidoDet.getConcImpuIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_iva", new Integer(0));
		if (pedidoDet.getConcImpuPercIVA()!=null)
			dataset.fieldValue("oid_conc_imp_perc_iva", pedidoDet.getConcImpuPercIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
		if (pedidoDet.getConcImpuInt()!=null)
			dataset.fieldValue("oid_conc_imp_int", pedidoDet.getConcImpuInt().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_int", new Integer(0));
		if (pedidoDet.getConcImpuPercIB()!=null)
			dataset.fieldValue("oid_conc_imp_perc_ib", pedidoDet.getConcImpuPercIB().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_perc_ib", new Integer(0));
		dataset.fieldValue("importe", pedidoDet.getImporte());
		
				
		
	}

	private IDataSet getDataSetPedidoDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPedidoDet");
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_art", Field.INTEGER, 0));;
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));;
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_um_ori", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_lista", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_sugerido", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("bonif1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("bonif2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("bonif3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("fec_entrega", Field.DATE,0));
		dataset.fieldDef(new Field("activo",Field.BOOLEAN,0));
		dataset.fieldDef(new Field("oid_conc_imp_iva", Field.INTEGER, 0));; 
		dataset.fieldDef(new Field("oid_conc_imp_perc_iva", Field.INTEGER, 0));;
		dataset.fieldDef(new Field("oid_conc_imp_int", Field.INTEGER, 0));;
		dataset.fieldDef(new Field("oid_conc_imp_perc_ib", Field.INTEGER, 0));;
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));;
		
		
		return dataset;
	}

	private void cargarRegistroPedidoCab(IDataSet dataset,PedidoCab pedidoCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cco_ped", pedidoCab.getOIDInteger());
		dataset.fieldValue("oid_talonario",pedidoCab.getTalonario().getOIDInteger());
		dataset.fieldValue("cod_tc",pedidoCab.getTcExt());
		dataset.fieldValue("oid_tc", pedidoCab.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_cliente", pedidoCab.getSujeto().getCodigo());
		dataset.fieldValue("rz_cliente", pedidoCab.getSujeto().getRazon_social());
		
		if (pedidoCab.getProyecto()!=null) {
			dataset.fieldValue("oid_proyecto", pedidoCab.getProyecto().getOIDInteger());
			dataset.fieldValue("cod_proyecto", pedidoCab.getProyecto().getCodigo());
			dataset.fieldValue("desc_proyecto", pedidoCab.getProyecto().getDescripcion());
		}	else {
			dataset.fieldValue("oid_proyecto", new Integer(0));
			dataset.fieldValue("cod_proyecto", "");
			dataset.fieldValue("desc_proyecto", "");
		}
		
		dataset.fieldValue("letra", pedidoCab.getLetra());
		dataset.fieldValue("lug_emi", pedidoCab.getLugarEmision().getLugemi());
		dataset.fieldValue("nro_ext", pedidoCab.getNroExt());
		dataset.fieldValue("oid_cliente", pedidoCab.getSujeto().getOIDInteger());
		dataset.fieldValue("oid_moneda", pedidoCab.getMoneda().getOIDInteger());
		dataset.fieldValue("cotizacion", pedidoCab.getCotizacion().doubleValue());
		dataset.fieldValue("cotiz_mon_fact", pedidoCab.getCotizMonFact().doubleValue());
		dataset.fieldValue("mercado", pedidoCab.getMercado());
		dataset.fieldValue("porc_bonif_cli", pedidoCab.getPorc_bonif_cli());
		dataset.fieldValue("porc_reca_cli", pedidoCab.getPorc_reca_cli());
		dataset.fieldValue("bonif_cli_cascada", pedidoCab.isBonif_cli_cascada());
		dataset.fieldValue("reca_cli_cascada", pedidoCab.isReca_cli_cascada());
		dataset.fieldValue("oid_precio_cab", pedidoCab.getLista_precios().getOIDInteger());
		dataset.fieldValue("cod_lp", pedidoCab.getLista_precios().getCodigo());
		dataset.fieldValue("desc_lp", pedidoCab.getLista_precios().getDescripcion());
		if (pedidoCab.getCondicionPago()!=null) {
		  dataset.fieldValue("oid_cond_pago", pedidoCab.getCondicionPago().getOIDInteger());
		  dataset.fieldValue("cod_cond_pago", pedidoCab.getCondicionPago().getCodigo());
		  dataset.fieldValue("desc_cond_pago", pedidoCab.getCondicionPago().getDescripcion());
		} else {
		  dataset.fieldValue("oid_cond_pago", 0);
		  dataset.fieldValue("cod_cond_pago", "");
		  dataset.fieldValue("desc_cond_pago", "");
		}
		dataset.fieldValue("oid_vendedor", pedidoCab.getVendedor().getOIDInteger());
		dataset.fieldValue("cod_vendedor", pedidoCab.getVendedor().getCodigo());
		dataset.fieldValue("desc_vendedor", pedidoCab.getVendedor().getApellido()+" - "+ pedidoCab.getVendedor().getNombre());
		
		if (pedidoCab.getDomicilio_entrega()!=null) {
		  dataset.fieldValue("oid_uni_edi", pedidoCab.getDomicilio_entrega().getOID());
		  dataset.fieldValue("cod_uni_edi", pedidoCab.getDomicilio_entrega().getCodigo());
		  dataset.fieldValue("desc_uni_edi", pedidoCab.getDomicilio_entrega().getDescripcion());
		} else {
		  dataset.fieldValue("oid_uni_edi", new Integer(0));
		  dataset.fieldValue("cod_uni_edi", "");
		  dataset.fieldValue("desc_uni_edi", "");
		}
		
		dataset.fieldValue("porc_bonif_cp", pedidoCab.getPorc_bonif_cp());
		dataset.fieldValue("porc_reca_cp", pedidoCab.getPorc_reca_cp());
		dataset.fieldValue("bonif_cp_cascada", pedidoCab.isBonif_cp_cascada());
		dataset.fieldValue("reca_cp_cascada", pedidoCab.isReca_cp_cascada());
		dataset.fieldValue("observado", pedidoCab.isObservado());
		dataset.fieldValue("comentario",  pedidoCab.getComentario());
		dataset.fieldValue("fec_emision", pedidoCab.getEmision());
		dataset.fieldValue("activo", pedidoCab.isActivo());
		if (pedidoCab.getTransporte()!=null) {
		  dataset.fieldValue("oid_transporte", pedidoCab.getTransporte().getOIDInteger());
		  dataset.fieldValue("cod_transporte", pedidoCab.getTransporte().getCodigo());
		  dataset.fieldValue("desc_transporte", pedidoCab.getTransporte().getDescripcion());
		} else {
		  dataset.fieldValue("oid_transporte", 0);
		  dataset.fieldValue("cod_transporte", "");
		  dataset.fieldValue("desc_transporte", "");			
		}
		dataset.fieldValue("oid_moneda_fact", pedidoCab.getMonedaFact().getOIDInteger());
		
		if (pedidoCab.getFormaEntrega()!=null) {
		  dataset.fieldValue("oid_forma_entrega", pedidoCab.getFormaEntrega().getOIDInteger());
		  dataset.fieldValue("cod_forma_entrega", pedidoCab.getFormaEntrega().getCodigo());
		  dataset.fieldValue("desc_forma_entrega", pedidoCab.getFormaEntrega().getDescripcion());
		} else {
		  dataset.fieldValue("oid_forma_entrega", 0);
		  dataset.fieldValue("cod_forma_entrega", "");
		  dataset.fieldValue("desc_forma_entrega", "");
		}
		dataset.fieldValue("orden_compra", pedidoCab.getOrdenDeCompra());
		dataset.fieldValue("compor_cotiz_fact", pedidoCab.getComporCotizFact());
		
		dataset.fieldValue("impre_bruto", pedidoCab.getImpre_bruto());
		dataset.fieldValue("impre_porc_dto", pedidoCab.getImprePorcBonif());
		dataset.fieldValue("impre_descuento", pedidoCab.getImpre_bonif());
		dataset.fieldValue("impre_porc_recar", pedidoCab.getImprePorcRecar());
		dataset.fieldValue("impre_recargo", pedidoCab.getImpre_recar());
		dataset.fieldValue("impre_neto", pedidoCab.getImpre_neto());
		dataset.fieldValue("impre_iva", pedidoCab.getImpre_iva());
		dataset.fieldValue("impre_iva_2", pedidoCab.getImpre_iva2());
		dataset.fieldValue("impre_perc_iva", pedidoCab.getImpre_perc_iva());
		dataset.fieldValue("impre_imp_internos", pedidoCab.getImpre_imp_int());
		dataset.fieldValue("impre_perc_ib", pedidoCab.getImpre_perc_ib());
		dataset.fieldValue("impre_total", pedidoCab.getImpre_total());
		
		if (pedidoCab.getContactoSujeto()!=null) {
		  dataset.fieldValue("oid_contacto", pedidoCab.getContactoSujeto().getOIDInteger());
		  dataset.fieldValue("cod_contacto", pedidoCab.getContactoSujeto().getDescripcion());
		  dataset.fieldValue("nom_y_ape_contacto", pedidoCab.getContactoSujeto().getNombreYApellido());
		} else {
		  dataset.fieldValue("oid_contacto", new Integer(0));
		  dataset.fieldValue("cod_contacto", "");
		  dataset.fieldValue("nom_y_ape_contacto","");
		}
		
		if (pedidoCab.getConcImpuIVA()!=null)
			dataset.fieldValue("oid_conc_impu_iva", pedidoCab.getConcImpuIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_iva", new Integer(0));
		
		if (pedidoCab.getConcImpuIVA2()!=null)
			dataset.fieldValue("oid_conc_impu_iva_2", pedidoCab.getConcImpuIVA2().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_iva_2", new Integer(0));
		
		
		if (pedidoCab.getConcImpuPercIVA()!=null)
			dataset.fieldValue("oid_conc_impu_perc_iva", pedidoCab.getConcImpuPercIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_perc_iva", new Integer(0));
		if (pedidoCab.getConcImpuPercIB()!=null)
			dataset.fieldValue("oid_conc_impu_perc_ib", pedidoCab.getConcImpuPercIB().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_perc_ib", new Integer(0));
		if (pedidoCab.getConcImpInt()!=null)
			dataset.fieldValue("oid_conc_impu_int", pedidoCab.getConcImpInt().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_int", new Integer(0));
		
	}
	
	private IDataSet getDataSetObsCodifPedidoCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TObsCodifPedidoCab");
		dataset.fieldDef(new Field("oid_obs_codif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_obs_cod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 5000));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroObsCodifPedidoCab(
			IDataSet dataset,
			ObsCodifPedidoCab obsCodif) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_obs_codif", obsCodif.getOIDInteger());
		dataset.fieldValue("oid_cco_ped", obsCodif.getPedido().getOIDInteger());
		dataset.fieldValue("orden", obsCodif.getOrden());
		dataset.fieldValue("oid_obs_cod", obsCodif.getObs_codificada().getOIDInteger());
		dataset.fieldValue("codigo", obsCodif.getObs_codificada().getCodigo());
		dataset.fieldValue("descripcion", obsCodif.getObs_codificada().getDescripcion());
		dataset.fieldValue("activo", obsCodif.isActivo());
	}
	
	public void enviarObsCodif(IDataSet dasasetObs, PedidoCab pedidoCab) throws BaseException {
		Iterator iterDetalles = pedidoCab.getObservacionesCodif().iterator();
		while (iterDetalles.hasNext()) {
			ObsCodifPedidoCab obs = (ObsCodifPedidoCab) iterDetalles.next();
			if (!obs.isActivo().booleanValue())
				continue;
			cargarRegistroObsCodifPedidoCab(dasasetObs,obs);
		}

	}

}
