package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.CotizacionDet;
import com.srn.erp.ventas.bm.EstadoPresupuestoCliente;
import com.srn.erp.ventas.bm.MotivoEstadoPresuCliente;
import com.srn.erp.ventas.bm.ObsCodifPresuCab;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCotizacion extends Operation {

	public TraerCotizacion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		CotizacionCab cotizacioncab = null;
		Integer oid = mapaDatos.getInteger("oid");
		cotizacioncab = CotizacionCab.findByOid(oid, getSesion());

		IDataSet dasasetDetalles = getDataSetCotizacionDet();
		IDataSet datasetCotizacionCab = getDataSetCotizacionCab();
		IDataSet datasetItemsABorrar = getDataSetItemsABorrar();
		IDataSet datasetObsCodif = this.getDataSetObsCodifPresuCab();

		if (cotizacioncab != null) {
			
			cargarRegistroCotizacionCab(datasetCotizacionCab, cotizacioncab);
			enviarDetallesCotizacion(dasasetDetalles, cotizacioncab);
			enviarObsCodif(datasetObsCodif,cotizacioncab);
			
		}
		writeCliente(datasetCotizacionCab);
		writeCliente(dasasetDetalles);
		writeCliente(datasetItemsABorrar);
		writeCliente(datasetObsCodif);
	}
	
	public void enviarObsCodif(IDataSet dasasetObs, CotizacionCab cotizacionCab) throws BaseException {
		Iterator iterDetalles = cotizacionCab.getObservacionesCodificadas().iterator();
		while (iterDetalles.hasNext()) {
			ObsCodifPresuCab obs = (ObsCodifPresuCab) iterDetalles.next();
			if (!obs.isActivo().booleanValue())
				continue;
			cargarRegistroObsCodifPresuCab(dasasetObs,obs);
		}

	}


	public void enviarDetallesCotizacion(IDataSet dasasetDetalles, CotizacionCab cotizacionCab) throws BaseException {
		Iterator iterDetalles = cotizacionCab.getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			CotizacionDet cotizacionDet = (CotizacionDet) iterDetalles.next();
			if (cotizacionDet.isAnulado().booleanValue())
				continue;
			cargarRegistroCotizacionDet(dasasetDetalles, cotizacionCab, cotizacionDet);
		}

	}

	private IDataSet getDataSetItemsABorrar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TItemsABorrar");
		dataset.fieldDef(new Field("oid_presu_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_presu", Field.INTEGER, 0));
		return dataset;
	}

	private IDataSet getDataSetCotizacionCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPresuCab");
		dataset.fieldDef(new Field("oid_cco_presu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_cliente", Field.STRING, 30));
		dataset.fieldDef(new Field("rz_cliente", Field.STRING, 100));
		dataset.fieldDef(new Field("letra", Field.STRING, 0));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
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

		dataset.fieldDef(new Field("impre_bruto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_porc_dto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_descuento", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_porc_recar", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_recargo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_neto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_perc_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_imp_internos", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_perc_ib", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_contacto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_contacto", Field.STRING, 100));
		dataset.fieldDef(new Field("nom_y_ape_contacto", Field.STRING, 200));

		dataset.fieldDef(new Field("oid_conc_impu_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_ib", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_validez", Field.DATE, 0));
		dataset.fieldDef(new Field("cotiz_moneda_fact", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compor_cotiz_fact", Field.STRING, 20));

		dataset.fieldDef(new Field("iva_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_iva_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_iva_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("iva_2_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_estado_presu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_estado_presu", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_estado_presu", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_motivo_estado", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_motivo_estado", Field.STRING, 100));

		return dataset;
	}

	private void cargarRegistroCotizacionDet(IDataSet dataset, CotizacionCab cotizacionCab, CotizacionDet cotizacionDet)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("nro_renglon", cotizacionDet.getNroRenglon());
		dataset.fieldValue("oid_presu_det", cotizacionDet.getOIDInteger());
		dataset.fieldValue("oid_cco_presu", cotizacionDet.getCotizacion().getOIDInteger());
		dataset.fieldValue("oid_art", cotizacionDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", cotizacionDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", cotizacionDet.getProducto().getDescripcion());
		dataset.fieldValue("oid_um_ori", cotizacionDet.getUni_med_ori().getOIDInteger());
		dataset.fieldValue("cantidad", cotizacionDet.getCant_um_ori());
		dataset.fieldValue("precio", cotizacionDet.getPrecio());
		dataset.fieldValue("precio_lista", cotizacionDet.getPrecio_lista());
		dataset.fieldValue("precio_sugerido", new Money(0));
		dataset.fieldValue("precio_bonif", cotizacionDet.getPrecio_bonif());
		dataset.fieldValue("importe", cotizacionDet.getImporte());
		dataset.fieldValue("oid_moneda", cotizacionDet.getMoneda().getOIDInteger());
		dataset.fieldValue("activo", cotizacionDet.isActivo());
		dataset.fieldValue("bonif1", cotizacionDet.getBonif1());
		dataset.fieldValue("bonif2", cotizacionDet.getBonif2());
		dataset.fieldValue("bonif3", cotizacionDet.getBonif3());
		dataset.fieldValue("comentario", cotizacionDet.getComentario());
		dataset.fieldValue("fec_entrega", cotizacionDet.getFechaEntrega());
		dataset.fieldValue("activo", new Boolean(true));

		if (cotizacionDet.getConcImpuIVA() != null)
			dataset.fieldValue("oid_conc_imp_iva", cotizacionDet.getConcImpuIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_iva", new Integer(0));
		if (cotizacionDet.getConcImpuPercIVA() != null)
			dataset.fieldValue("oid_conc_imp_perc_iva", cotizacionDet.getConcImpuPercIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
		if (cotizacionDet.getConcImpuInt() != null)
			dataset.fieldValue("oid_conc_imp_int", cotizacionDet.getConcImpuInt().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_int", new Integer(0));
		if (cotizacionDet.getConcImpuPercIB() != null)
			dataset.fieldValue("oid_conc_imp_perc_ib", cotizacionDet.getConcImpuPercIB().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_perc_ib", new Integer(0));
		dataset.fieldValue("dias_entrega", cotizacionDet.getDiasEntrega());

	}

	private IDataSet getDataSetCotizacionDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPresuDet");
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_presu_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_presu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_art", Field.INTEGER, 0));
		;
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		;
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_um_ori", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_lista", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_sugerido", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("bonif1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("bonif2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("bonif3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("fec_entrega", Field.DATE, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_conc_imp_iva", Field.INTEGER, 0));
		;
		dataset.fieldDef(new Field("oid_conc_imp_perc_iva", Field.INTEGER, 0));
		;
		dataset.fieldDef(new Field("oid_conc_imp_int", Field.INTEGER, 0));
		;
		dataset.fieldDef(new Field("oid_conc_imp_perc_ib", Field.INTEGER, 0));
		;
		dataset.fieldDef(new Field("dias_entrega", Field.INTEGER, 0));
		;

		return dataset;
	}

	private void cargarRegistroCotizacionCab(IDataSet dataset, CotizacionCab cotizacionCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cco_presu", cotizacionCab.getOIDInteger());
		dataset.fieldValue("oid_talonario", cotizacionCab.getTalonario().getOIDInteger());
		dataset.fieldValue("cod_tc", cotizacionCab.getTcExt());
		dataset.fieldValue("oid_tc", cotizacionCab.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_cliente", cotizacionCab.getSujeto().getCodigo());
		dataset.fieldValue("rz_cliente", cotizacionCab.getSujeto().getRazon_social());
		dataset.fieldValue("letra", cotizacionCab.getLetra());
		dataset.fieldValue("lug_emi", cotizacionCab.getLugarEmision().getLugemi());
		dataset.fieldValue("nro_ext", cotizacionCab.getNroExt());
		dataset.fieldValue("oid_cliente", cotizacionCab.getSujeto().getOIDInteger());
		dataset.fieldValue("oid_moneda", cotizacionCab.getMoneda().getOIDInteger());
		dataset.fieldValue("cotizacion", cotizacionCab.getCotizacion().doubleValue());
		dataset.fieldValue("mercado", cotizacionCab.getMercado());
		dataset.fieldValue("porc_bonif_cli", cotizacionCab.getPorc_bonif_cli());
		dataset.fieldValue("porc_reca_cli", cotizacionCab.getPorc_reca_cli());
		dataset.fieldValue("bonif_cli_cascada", cotizacionCab.isBonif_cli_cascada());
		dataset.fieldValue("reca_cli_cascada", cotizacionCab.isReca_cli_cascada());
		dataset.fieldValue("oid_precio_cab", cotizacionCab.getLista_precios().getOIDInteger());
		dataset.fieldValue("cod_lp", cotizacionCab.getLista_precios().getCodigo());
		dataset.fieldValue("desc_lp", cotizacionCab.getLista_precios().getDescripcion());
		if (cotizacionCab.getCondicionPago() != null) {
			dataset.fieldValue("oid_cond_pago", cotizacionCab.getCondicionPago().getOIDInteger());
			dataset.fieldValue("cod_cond_pago", cotizacionCab.getCondicionPago().getCodigo());
			dataset.fieldValue("desc_cond_pago", cotizacionCab.getCondicionPago().getDescripcion());
		} else {
			dataset.fieldValue("oid_cond_pago", 0);
			dataset.fieldValue("cod_cond_pago", "");
			dataset.fieldValue("desc_cond_pago", "");
		}
		dataset.fieldValue("oid_vendedor", cotizacionCab.getVendedor().getOIDInteger());
		dataset.fieldValue("cod_vendedor", cotizacionCab.getVendedor().getCodigo());
		dataset.fieldValue("desc_vendedor", cotizacionCab.getVendedor().getApellido() + " - " + cotizacionCab.getVendedor().getNombre());

		if (cotizacionCab.getDomicilio_entrega() != null) {
			dataset.fieldValue("oid_uni_edi", cotizacionCab.getDomicilio_entrega().getOID());
			dataset.fieldValue("cod_uni_edi", cotizacionCab.getDomicilio_entrega().getCodigo());
			dataset.fieldValue("desc_uni_edi", cotizacionCab.getDomicilio_entrega().getDescripcion());
		} else {
			dataset.fieldValue("oid_uni_edi", new Integer(0));
			dataset.fieldValue("cod_uni_edi", "");
			dataset.fieldValue("desc_uni_edi", "");
		}

		dataset.fieldValue("porc_bonif_cp", cotizacionCab.getPorc_bonif_cp());
		dataset.fieldValue("porc_reca_cp", cotizacionCab.getPorc_reca_cp());
		dataset.fieldValue("bonif_cp_cascada", cotizacionCab.isBonif_cp_cascada());
		dataset.fieldValue("reca_cp_cascada", cotizacionCab.isReca_cp_cascada());
		dataset.fieldValue("observado", cotizacionCab.isObservado());
		dataset.fieldValue("comentario", cotizacionCab.getComentario());
		dataset.fieldValue("fec_emision", cotizacionCab.getEmision());
		dataset.fieldValue("activo", cotizacionCab.isActivo());
		if (cotizacionCab.getTransporte() != null) {
			dataset.fieldValue("oid_transporte", cotizacionCab.getTransporte().getOIDInteger());
			dataset.fieldValue("cod_transporte", cotizacionCab.getTransporte().getCodigo());
			dataset.fieldValue("desc_transporte", cotizacionCab.getTransporte().getDescripcion());
		} else {
			dataset.fieldValue("oid_transporte", 0);
			dataset.fieldValue("cod_transporte", "");
			dataset.fieldValue("desc_transporte", "");
		}
		dataset.fieldValue("oid_moneda_fact", cotizacionCab.getMonedaFact().getOIDInteger());

		if (cotizacionCab.getFormaEntrega() != null) {
			dataset.fieldValue("oid_forma_entrega", cotizacionCab.getFormaEntrega().getOIDInteger());
			dataset.fieldValue("cod_forma_entrega", cotizacionCab.getFormaEntrega().getCodigo());
			dataset.fieldValue("desc_forma_entrega", cotizacionCab.getFormaEntrega().getDescripcion());
		} else {
			dataset.fieldValue("oid_forma_entrega", 0);
			dataset.fieldValue("cod_forma_entrega", "");
			dataset.fieldValue("desc_forma_entrega", "");
		}
		dataset.fieldValue("orden_compra", cotizacionCab.getOrdenDeCompra());

		dataset.fieldValue("impre_bruto", cotizacionCab.getImpre_bruto());
		dataset.fieldValue("impre_porc_dto", cotizacionCab.getImprePorcBonif());
		dataset.fieldValue("impre_descuento", cotizacionCab.getImpre_bonif());
		dataset.fieldValue("impre_porc_recar", cotizacionCab.getImprePorcRecar());
		dataset.fieldValue("impre_recargo", cotizacionCab.getImpre_recar());
		dataset.fieldValue("impre_neto", cotizacionCab.getImpre_neto());
		dataset.fieldValue("impre_iva", cotizacionCab.getImpre_iva());
		dataset.fieldValue("impre_perc_iva", cotizacionCab.getImpre_perc_iva());
		dataset.fieldValue("impre_imp_internos", cotizacionCab.getImpre_imp_int());
		dataset.fieldValue("impre_perc_ib", cotizacionCab.getImpre_perc_ib());
		dataset.fieldValue("impre_total", cotizacionCab.getImpre_total());

		if (cotizacionCab.getContactoSujeto() != null) {
			dataset.fieldValue("oid_contacto", cotizacionCab.getContactoSujeto().getOIDInteger());
			dataset.fieldValue("cod_contacto", cotizacionCab.getContactoSujeto().getDescripcion());
			dataset.fieldValue("nom_y_ape_contacto", cotizacionCab.getContactoSujeto().getNombreYApellido());
		} else {
			dataset.fieldValue("oid_contacto", new Integer(0));
			dataset.fieldValue("cod_contacto", "");
			dataset.fieldValue("nom_y_ape_contacto", "");
		}

		if (cotizacionCab.getConcImpuIVA() != null)
			dataset.fieldValue("oid_conc_impu_iva", cotizacionCab.getConcImpuIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_iva", new Integer(0));
		if (cotizacionCab.getConcImpuPercIVA() != null)
			dataset.fieldValue("oid_conc_impu_perc_iva", cotizacionCab.getConcImpuPercIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_perc_iva", new Integer(0));
		if (cotizacionCab.getConcImpuPercIB() != null)
			dataset.fieldValue("oid_conc_impu_perc_ib", cotizacionCab.getConcImpuPercIB().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_perc_ib", new Integer(0));
		if (cotizacionCab.getConcImpInt() != null)
			dataset.fieldValue("oid_conc_impu_int", cotizacionCab.getConcImpInt().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_int", new Integer(0));

		dataset.fieldValue("fec_validez", cotizacionCab.getFecValidez());
		dataset.fieldValue("cotiz_moneda_fact", cotizacionCab.getCotizMonFact());
		dataset.fieldValue("compor_cotiz_fact", cotizacionCab.getComporCotizFact());

		dataset.fieldValue("iva_2", cotizacionCab.getIva2());
		dataset.fieldValue("impre_iva_2", cotizacionCab.getImpre_iva2());
		if (cotizacionCab.getConcImpuIVA2() != null)
			dataset.fieldValue("oid_conc_iva_2", cotizacionCab.getConcImpuIVA2().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_iva_2", new Integer(0));
		dataset.fieldValue("iva_2_mon_loc", cotizacionCab.getIVA2MonLoc());

		if (cotizacionCab.getEstadoPresupuestoCliente() != null) {
			dataset.fieldValue("oid_estado_presu", cotizacionCab.getEstadoPresupuestoCliente().getOIDInteger());
			dataset.fieldValue("cod_estado_presu", cotizacionCab.getEstadoPresupuestoCliente().getCodigo());
			dataset.fieldValue("desc_estado_presu", cotizacionCab.getEstadoPresupuestoCliente().getDescripcion());
		} else {
			dataset.fieldValue("oid_estado_presu", "");
			dataset.fieldValue("cod_estado_presu", "");
			dataset.fieldValue("desc_estado_presu", "");
		}

		if (cotizacionCab.getMotivoEstadoPresuCliente() != null) {
			dataset.fieldValue("oid_motivo_estado", cotizacionCab.getMotivoEstadoPresuCliente().getOIDInteger());
			dataset.fieldValue("cod_motivo_estado", cotizacionCab.getMotivoEstadoPresuCliente().getCodigo());
			dataset.fieldValue("desc_motivo_estado", cotizacionCab.getMotivoEstadoPresuCliente().getDescripcion());
		} else {
			dataset.fieldValue("oid_motivo_estado", "");
			dataset.fieldValue("cod_motivo_estado", "");
			dataset.fieldValue("desc_motivo_estado", "");
		}

	}

	private IDataSet getDataSetObsCodifPresuCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TObsCodifPresuCab");
		dataset.fieldDef(new Field("oid_obs_codif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_presu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_obs_cod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 5000));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroObsCodifPresuCab(
			IDataSet dataset,
			ObsCodifPresuCab obsCodif) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_obs_codif", obsCodif.getOIDInteger());
		dataset.fieldValue("oid_cco_presu", obsCodif.getPresupuesto().getOIDInteger());
		dataset.fieldValue("orden", obsCodif.getOrden());
		dataset.fieldValue("oid_obs_cod", obsCodif.getObs_codificada().getOIDInteger());
		dataset.fieldValue("codigo", obsCodif.getObs_codificada().getCodigo());
		dataset.fieldValue("descripcion", obsCodif.getObs_codificada().getDescripcion());
		dataset.fieldValue("activo", obsCodif.isActivo());
	}

}
