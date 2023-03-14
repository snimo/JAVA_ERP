package com.srn.erp.ctasAPagar.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.ctasAPagar.bm.ComproProvDetCtaImpu;
import com.srn.erp.ctasAPagar.bm.ComproProvInfRecOC;
import com.srn.erp.ctasAPagar.bm.ComproProvTotImpu;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.ctasAPagar.bm.ComproProveedorDet;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComproProv extends Operation {

	public void execute(MapDatos arg0) throws BaseException {
		// TODO Auto-generated method stub

		IDataSet dsComproProv = this.getDataSetComproPro();
		IDataSet dsConceptos = this.getDataSetConceptos();
		IDataSet dsImputaciones = this.getDataSetImputaciones();
		IDataSet dsTotales = this.getDataSetTotales();
		IDataSet dsOCDet = this.getDataSetDetOC();

		Integer oid = arg0.getInteger("oid");
		ComproProveedorBase comproProv = ComproProveedor.findByComproProv(oid,
				this.getSesion());

		procesarComproPro(dsComproProv, comproProv);

		
		Iterator iterOCDetInfRecDet = comproProv.getDetallesOCDetInfRecDet().iterator();
		while (iterOCDetInfRecDet.hasNext()) {
			ComproProvInfRecOC comproProvInfRecOC = (ComproProvInfRecOC) iterOCDetInfRecDet.next();
			cargarRegistroOC(dsOCDet, comproProv.getOIDInteger(), comproProvInfRecOC);
		}
		
		Iterator iterDetalles = comproProv.getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			ComproProveedorDet comproProvDet = (ComproProveedorDet) iterDetalles
					.next();

			cargarDSConceptos(dsConceptos, comproProvDet);

			Iterator iterDetImputaciones = comproProvDet
					.getDetalleImputaciones().iterator();
			while (iterDetImputaciones.hasNext()) {
				ComproProvDetCtaImpu imputacion = (ComproProvDetCtaImpu) iterDetImputaciones
						.next();
				cargaImputacion(dsImputaciones, imputacion);
			}

		}

		agregarNetos(dsTotales, comproProv);

		Iterator iterConceptosImpuestos = comproProv.getDetallesTotImpuestos()
				.iterator();
		while (iterConceptosImpuestos.hasNext()) {
			ComproProvTotImpu comproProvTotImpu = (ComproProvTotImpu) iterConceptosImpuestos
					.next();
			cargarTotales(dsTotales, comproProvTotImpu);
		}

		writeCliente(dsComproProv);
		writeCliente(dsConceptos);
		writeCliente(dsImputaciones);
		writeCliente(dsTotales);
		writeCliente(dsOCDet);

	}

	private void cargarRegistroOC(IDataSet dataset, Integer oidCCO,
								  ComproProvInfRecOC comproProvInfRecOC) throws BaseException {
		
		OrdenDeCompraDet ocDet = comproProvInfRecOC.getOrdenDeCompraDet();
		
		if (ocDet == null) return;
		
		dataset.append();
		dataset.fieldValue("oid_producto", ocDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", ocDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", ocDet.getProducto()
				.getDescripcion());
		dataset.fieldValue("desc_adic", ocDet.getDesc_adic_sku());
		dataset
				.fieldValue("oid_oc", ocDet.getOrden_de_compra()
						.getOIDInteger());
		dataset.fieldValue("oid_oc_det", ocDet.getOIDInteger());
		dataset.fieldValue("cant_comprada_uc", ocDet.getCant_comprada_uc());
		dataset.fieldValue("cant_recibida_uc", ocDet.getCantRecepUC());
		dataset.fieldValue("cant_fact_uc", ocDet.getCantFactUC());
		dataset.fieldValue("cant_pend_fact_uc", ocDet.getCantPendFactUC());
		dataset.fieldValue("precio_oc", ocDet.getPrecio());
		dataset.fieldValue("oid_mon_oc", ocDet.getOrden_de_compra().getMoneda()
				.getOIDInteger());
		dataset.fieldValue("cod_mon_oc", ocDet.getOrden_de_compra().getMoneda()
				.getSimbolo());
		dataset.fieldValue("compro_oc", ocDet.getOrden_de_compra().getCodigo());
		dataset.fieldValue("codigo_moneda_oc", ocDet.getOrden_de_compra()
				.getMoneda().getCodigo());
		dataset.fieldValue("oid_cco", oidCCO);

		ConcFactProv concepto = ocDet.getProducto()
				.getConcFactProvCorrespondiente();
		if (concepto != null) {
			dataset.fieldValue("oid_conc_fact_prov", concepto.getOIDInteger());
			dataset
					.fieldValue("desc_conc_fact_prov", concepto
							.getDescripcion());
		} else {
			dataset.fieldValue("oid_conc_fact_prov", 0);
			dataset.fieldValue("desc_conc_fact_prov", "");
		}
		
		dataset.fieldValue("cantidad", comproProvInfRecOC.getCant_facturada());
		dataset.fieldValue("precio", comproProvInfRecOC.getPrecio_factura());
		dataset.fieldValue("importe", comproProvInfRecOC.getImpo_det_factura());
		

	}

	private void procesarComproPro(IDataSet ds, ComproProveedorBase comproProv)
			throws BaseException {
		cargarRegistroComproProv(ds, comproProv);
	}

	public TraerComproProv() {
	}

	private void agregarNetos(IDataSet ds, ComproProveedorBase comproProv)
			throws BaseException {

		if ((comproProv.getNetoGravadoMonOri() != null)
				&& (comproProv.getNetoGravadoMonOri().doubleValue() != 0)) {

			ds.append();
			ds.fieldValue("oid", new Integer(-1));
			ds.fieldValue("orden", new Integer(-2));
			ds.fieldValue("oid_conc_imp", new Integer(0));
			ds.fieldValue("desc_conc_imp", "Neto Gravado");
			ds.fieldValue("importe", comproProv.getNetoGravadoMonOri());
			ds.fieldValue("es_neto_gravado", new Boolean(true));
			ds.fieldValue("es_neto_no_gravado", new Boolean(false));
		}

		if ((comproProv.getNetoNoGravadoMonOri() != null)
				&& (comproProv.getNetoNoGravadoMonOri().doubleValue() != 0)) {
			ds.append();
			ds.fieldValue("oid", new Integer(-1));
			ds.fieldValue("orden", new Integer(-2));
			ds.fieldValue("oid_conc_imp", new Integer(0));
			ds.fieldValue("desc_conc_imp", "Neto No Gravado");
			ds.fieldValue("importe", comproProv.getNetoNoGravadoMonOri());
			ds.fieldValue("es_neto_gravado", new Boolean(false));
			ds.fieldValue("es_neto_no_gravado", new Boolean(true));
		}

	}

	private void agregarNetoNoGravado(IDataSet dsTotales,
			ComproProveedor comproProv) throws BaseException {

	}

	private IDataSet getDataSetDetOC() {
		IDataSet dataset = new TDataSet();
		dataset.create("TComproProvOC");
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
		dataset.fieldDef(new Field("desc_adic", Field.MEMO, 0));
		dataset.fieldDef(new Field("oid_oc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_oc_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_comprada_uc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_recibida_uc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_fact_uc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_pend_fact_uc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_oc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_mon_oc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_mon_oc", Field.STRING, 50));
		dataset.fieldDef(new Field("compro_oc", Field.STRING, 100));
		dataset.fieldDef(new Field("codigo_moneda_oc", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_fact_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_conc_fact_prov", Field.STRING, 100));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		
		return dataset;
	}

	private void cargarRegistroComproProv(IDataSet ds,
			ComproProveedorBase comproProv) throws BaseException {
		ds.append();
		ds.fieldValue("oid_cco", comproProv.getOIDInteger());
		ds.fieldValue("oid_tc", comproProv.getTipoCompro().getOIDInteger());
		ds.fieldValue("tc_ext", comproProv.getTcExt());
		ds.fieldValue("letra", comproProv.getLetra());
		if (comproProv.getLugarEmision() != null)
			ds.fieldValue("oid_lug_emi", comproProv.getLugarEmision()
					.getOIDInteger());
		else
			ds.fieldValue("oid_lug_emi", new Integer(0));
		ds.fieldValue("lug_emi", comproProv.getNroLugEmision());
		ds.fieldValue("nro_ext", comproProv.getNroExt());
		ds.fieldValue("fec_emision", comproProv.getEmision());
		ds.fieldValue("fec_imputac", comproProv.getImputac());
		if (comproProv.getProveedor() != null) {
			ds.fieldValue("oid_proveedor", comproProv.getProveedor()
					.getOIDInteger());
			ds.fieldValue("cod_proveedor", comproProv.getProveedor()
					.getCodigo());
			ds.fieldValue("razon_social_prov", comproProv.getProveedor()
					.getRazonsocial());
		} else {
			ds.fieldValue("oid_proveedor", new Integer(0));
			ds.fieldValue("cod_proveedor", "");
			ds.fieldValue("razon_social_prov", "");
		}
		ds.fieldValue("oid_tipo_cta_prov", comproProv.getTipoCtaCteProv()
				.getOIDInteger());
		ds.fieldValue("oid_moneda", comproProv.getMoneda().getOIDInteger());
		ds.fieldValue("importe", comproProv.getTotMonedaOri());
		ds.fieldValue("cotizacion", comproProv.getCotizacion());

		ds.fieldValue("comentario", comproProv.getComentario());
		ds.fieldValue("fec_base", comproProv.getFecbase());

		ds.fieldValue("descuento", comproProv.getDescCondPagoCC());
		ds.fieldValue("tipo_descuento", "");
		ds.fieldValue("tipo_factura", comproProv.getTipoFactura());
		ds.fieldValue("neto_gravado", comproProv.getNetoGravadoMonOri());
		ds.fieldValue("neto_no_gravado", comproProv.getNetoNoGravadoMonOri());
		if (comproProv.getSectorCompra() != null)
			ds.fieldValue("oid_sector_compra", comproProv.getSectorCompra()
					.getOIDInteger());
		else
			ds.fieldValue("oid_sector_compra", new Integer(0));

		if (comproProv.getCondPagoCC() != null)
			ds.fieldValue("oid_cond_pago_prov", comproProv.getCondPagoCC()
					.getOIDInteger());
		else
			ds.fieldValue("oid_cond_pago_prov", new Integer(0));
		ds.fieldValue("activo", comproProv.isActivo());
	}

	private IDataSet getDataSetComproPro() {
		IDataSet dataset = new TDataSet();
		dataset.create("TComproProv");
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tc_ext", Field.STRING, 50));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_imputac", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("razon_social_prov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_tipo_cta_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		dataset.fieldDef(new Field("fec_base", Field.DATE, 0));
		dataset.fieldDef(new Field("descuento", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tipo_descuento", Field.STRING, 20));
		dataset.fieldDef(new Field("tipo_factura", Field.STRING, 20));
		dataset.fieldDef(new Field("neto_gravado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("neto_no_gravado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_sector_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cond_pago_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetConceptos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConceptosCompro");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_fact_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_perc_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_perc_ib", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_internos", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_ret_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_ret_gan", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_ret_ib", Field.INTEGER, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		return dataset;
	}

	private IDataSet getDataSetImputaciones() {
		IDataSet dataset = new TDataSet();
		dataset.create("TImputacionesConcCompro");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_padre", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_ai", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_ai", Field.STRING, 255));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 1000));
		return dataset;
	}

	private IDataSet getDataSetTotales() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTotalesComproProv");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_conc_imp", Field.STRING, 100));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("es_neto_gravado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("es_neto_no_gravado", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarTotales(IDataSet ds, ComproProvTotImpu comproTotImpu)
			throws BaseException {
		ds.append();
		ds.fieldValue("oid", comproTotImpu.getOIDInteger());
		ds.fieldValue("orden", 0);
		ds.fieldValue("oid_conc_imp", comproTotImpu.getConceptoImpuesto()
				.getOIDInteger());
		ds.fieldValue("desc_conc_imp", comproTotImpu.getConceptoImpuesto()
				.getDescripcion());
		ds.fieldValue("importe", comproTotImpu.getImporteMonedaOri());
		ds.fieldValue("es_neto_gravado", new Boolean(false));
		ds.fieldValue("es_neto_no_gravado", new Boolean(false));

	}

	private void cargaImputacion(IDataSet ds,
			ComproProvDetCtaImpu comproProvDetCtaImpu) throws BaseException {
		ds.append();
		ds.fieldValue("oid", comproProvDetCtaImpu.getOID());
		ds.fieldValue("oid_padre", comproProvDetCtaImpu.getComproprovdet()
				.getOIDInteger());
		ds.fieldValue("oid_ai", comproProvDetCtaImpu.getCuentaimputable()
				.getOIDInteger());
		ds.fieldValue("codigo_ai", comproProvDetCtaImpu.getCuentaimputable()
				.getCodigoCuentaMasCodigosValCompo());
		ds.fieldValue("desc_ai", comproProvDetCtaImpu.getCuentaimputable()
				.getDescCuentaMasDescValCompo());
		ds.fieldValue("importe", comproProvDetCtaImpu.getImporte());
		ds.fieldValue("comentario", comproProvDetCtaImpu.getComentario());
		ds.fieldValue("orden", new Integer(0));
	}

	private void cargarDSConceptos(IDataSet ds, ComproProveedorDet comproProvDet)
			throws BaseException {
		ds.append();
		ds.fieldValue("oid", comproProvDet.getOIDInteger());
		ds.fieldValue("oid_conc_fact_prov", comproProvDet.getConcFactProv()
				.getOIDInteger());
		ds.fieldValue("descripcion", comproProvDet.getConcFactProv()
				.getDescripcion());
		ds.fieldValue("activo", comproProvDet.isActivo());
		ds.fieldValue("orden", comproProvDet.getSecu());

		if (comproProvDet.getImpuestoIVA() != null)
			ds.fieldValue("oid_conc_imp_iva", comproProvDet.getImpuestoIVA()
					.getOIDInteger());
		else
			ds.fieldValue("oid_conc_imp_iva", 0);

		if (comproProvDet.getImpuestoPercIVA() != null)
			ds.fieldValue("oid_conc_imp_perc_iva", comproProvDet
					.getImpuestoPercIVA().getOIDInteger());
		else
			ds.fieldValue("oid_conc_imp_perc_iva", 0);

		if (comproProvDet.getImpuestoPercIB() != null)
			ds.fieldValue("oid_conc_imp_perc_ib", comproProvDet
					.getImpuestoPercIB().getOIDInteger());
		else
			ds.fieldValue("oid_conc_imp_perc_ib", 0);

		if (comproProvDet.getImpuestoInterno() != null)
			ds.fieldValue("oid_conc_imp_internos", comproProvDet
					.getImpuestoInterno().getOIDInteger());
		else
			ds.fieldValue("oid_conc_imp_internos", 0);

		if (comproProvDet.getImpuestoRetIVA() != null)
			ds.fieldValue("oid_conc_imp_ret_iva", comproProvDet
					.getImpuestoRetIVA().getOIDInteger());
		else
			ds.fieldValue("oid_conc_imp_ret_iva", 0);

		if (comproProvDet.getImpuestoRetGan() != null)
			ds.fieldValue("oid_conc_imp_ret_gan", comproProvDet
					.getImpuestoRetGan().getOIDInteger());
		else
			ds.fieldValue("oid_conc_imp_ret_gan", 0);

		if (comproProvDet.getImpuestoRetIB() != null)
			ds.fieldValue("oid_conc_imp_ret_ib", comproProvDet
					.getImpuestoRetIB().getOIDInteger());
		else
			ds.fieldValue("oid_conc_imp_ret_ib", 0);

		ds.fieldValue("importe", comproProvDet.getImpoMonedaOri());

	}

}
