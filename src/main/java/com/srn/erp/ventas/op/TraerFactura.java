package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.bm.PedidoCab;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFactura extends Operation {

	public TraerFactura() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		FacturaCab facturaCab = null;
		Integer oid = mapaDatos.getInteger("oid");
		facturaCab = FacturaCab.findByOid(oid, getSesion());

		IDataSet dasasetDetalles = getDataSetFacturaDet();
		IDataSet datasetFacturaCab = getDataSetFacturaCab();
		IDataSet datasetTalonario = getDataSetTalFactClie();
			
		
		cargarRegistroFacturaCab(datasetFacturaCab,facturaCab);
		enviarDetallesFactura(dasasetDetalles,facturaCab);
		cargarRegistroTalonario(datasetTalonario,facturaCab.getTalonario());
		
		writeCliente(datasetFacturaCab);
		writeCliente(dasasetDetalles);
		writeCliente(datasetTalonario);
	}

	public void enviarDetallesFactura(IDataSet dasasetDetalles,
																		FacturaCab facturaCab) throws BaseException {
		int nroOrden = 1;
		Iterator iterDetalles = facturaCab.getItemsFactura().iterator();
		while (iterDetalles.hasNext()) {
			FacturaDet facturaDet = (FacturaDet) iterDetalles.next();
			cargarRegistroFacturaDet(dasasetDetalles,
					                     facturaCab, 
					                     facturaDet,
					                     nroOrden);
			++nroOrden;
		}

	}
	
	private IDataSet getDataSetFacturaDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFacturaDet");
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_art", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_art", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_art" , Field.STRING, 200));
		dataset.fieldDef(new Field("cantidad" , Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_uni_med" , Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_uni_med" , Field.STRING, 50));
		dataset.fieldDef(new Field("precio_factura", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_1",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_2",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_3",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_bonif",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo" , Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("read_only" , Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("importe_neto_gravado" , Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe_neto_no_gravado" , Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tasa_iva" , Field.CURRENCY, 0));
		dataset.fieldDef(new Field("iva" , Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario" , Field.STRING, 255));
		return dataset;
	}	

	private IDataSet getDataSetFacturaCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFacturaCab");		
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_oper_factu", Field.STRING,50));
		dataset.fieldDef(new Field("oid_compo_stk_fac", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_cliente" , Field.STRING,50));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_cliente", Field.INTEGER,0));
		dataset.fieldDef(new Field("cod_cliente", Field.STRING,50));
		dataset.fieldDef(new Field("rz_cliente", Field.STRING,100));
		dataset.fieldDef(new Field("oid_proyecto", Field.INTEGER,0));
		dataset.fieldDef(new Field("cod_proyecto", Field.STRING,50));
		dataset.fieldDef(new Field("desc_proyecto", Field.STRING,100));
		dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_vendedor", Field.STRING,50));
		dataset.fieldDef(new Field("rz_vendedor", Field.STRING,100));
		dataset.fieldDef(new Field("oid_talonario" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("oid_tc" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("cod_tc" , Field.STRING,50));
		dataset.fieldDef(new Field("letra" , Field.STRING , 1));
		dataset.fieldDef(new Field("oid_lug_emi" , Field.INTEGER , 0)); 
		dataset.fieldDef(new Field("nro_lug_emi" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("nro_ext" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("oid_lp" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("cod_lp" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("desc_lp" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("comentario" , Field.STRING , 5000));
		dataset.fieldDef(new Field("oid_caja" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("fec_caja" , Field.DATE , 0));
		dataset.fieldDef(new Field("oper_factu" , Field.STRING , 50));
		dataset.fieldDef(new Field("tipo_compo_compro" , Field.STRING , 50));
		dataset.fieldDef(new Field("oid_tipo_conf_mov" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("oid_provincia" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("cod_provincia" , Field.STRING , 50));
		dataset.fieldDef(new Field("desc_provincia" , Field.STRING , 100));
		dataset.fieldDef(new Field("oid_cond_pago" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("compo_cond_pago" , Field.STRING , 50));
		dataset.fieldDef(new Field("disc_iva" , Field.BOOLEAN , 0));
		dataset.fieldDef(new Field("bruto" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("oid_moneda" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("cotizacion" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("porc_bonif_cli" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("porc_reca_cli" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("cuotas" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("dias" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("porc_bonif_fp" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("porc_recar_fp" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("total_bruto" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("porc_dto" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("descuento" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("recargo" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("porc_recar" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("total_neto" ,  Field.CURRENCY , 0));
		dataset.fieldDef(new Field("imp_internos" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("perc_ib_ba" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("perc_ib_cf" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("iva" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("perc_iva" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("total_total" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("bruto_mon_loc" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("porc_dto_mon_loc" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("dto_mon_loc" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("recargo_mon_loc" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("porc_recar_mon_loc" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("neto_mon_local" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("imp_int_mon_loc" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("perc_ib_mon_loc" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("iva_mon_loc" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("perc_iva_mon_loc" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("total_mon_loc" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_bruto" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_porc_dto" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_descuento" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_porc_recar" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_recargo" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_neto" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_iva" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_iva_2" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_perc_iva" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_imp_internos" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_perc_ib_ba" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_perc_ib_cf" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("impre_total" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("oid_conc_impu_iva" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_iva" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_ib" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("oid_conc_impu_int" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("neto_gravado" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("neto_no_gravado" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("porc_bonif_cli_ori" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("porc_reca_cli_ori" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("porc_bonif_fp_ori" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("porc_reca_fp_ori" , Field.CURRENCY , 0));
		dataset.fieldDef(new Field("oid_motivo_compro" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("oid_cco_ped" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("nro_ext_ped" , Field.INTEGER , 0));
		dataset.fieldDef(new Field("activo" , Field.BOOLEAN , 0));
		dataset.fieldDef(new Field("remitos_facturados" , Field.STRING, 255));
		dataset.fieldDef(new Field("oc" , Field.STRING, 50));
		dataset.fieldDef(new Field("factura" , Field.STRING, 50));
		dataset.fieldDef(new Field("comportamiento_tc" , Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistroFacturaDet(IDataSet dataset, 
			                                  FacturaCab facturaCab, 
			                                  FacturaDet facturaDet,
			                                  int nroOrden) throws BaseException {
		dataset.append();
		dataset.fieldValue("nro_renglon", new Integer(nroOrden));
		dataset.fieldValue("oid_cco_det", facturaDet.getOIDInteger());
		dataset.fieldValue("oid_cco", facturaCab.getOIDInteger());
		dataset.fieldValue("orden", new Integer(nroOrden));
		if (facturaDet.getProducto()!=null) {
		  dataset.fieldValue("oid_art", facturaDet.getProducto().getOIDInteger());
		  dataset.fieldValue("cod_art", facturaDet.getProducto().getCodigo());
		  dataset.fieldValue("desc_art" , facturaDet.getDescripcion());
		} else {
		  dataset.fieldValue("oid_art", new Integer(0));
		  dataset.fieldValue("cod_art", "");
		  dataset.fieldValue("desc_art" , "");
		}
		dataset.fieldValue("cantidad" , facturaDet.getCantidad());
		if (facturaDet.getUnidad_medida()!=null) {
		  dataset.fieldValue("oid_uni_med" , facturaDet.getUnidad_medida().getOIDInteger());
		  dataset.fieldValue("cod_uni_med" , facturaDet.getUnidad_medida().getCodigo());
		} else {
		  dataset.fieldValue("oid_uni_med" , new Integer(0));
		  dataset.fieldValue("cod_uni_med" , "");
		}
		dataset.fieldValue("precio_factura", facturaDet.getPrecio_ingresado());
		dataset.fieldValue("porc_bonif_1",facturaDet.getPorc_bonif_1());
		dataset.fieldValue("porc_bonif_2",facturaDet.getPorc_bonif_2());
		dataset.fieldValue("porc_bonif_3",facturaDet.getPorc_bonif_3());
		dataset.fieldValue("precio_bonif",facturaDet.getPrecio_bonificado());
		dataset.fieldValue("importe",facturaDet.getImporte());
		dataset.fieldValue("activo" , new Boolean(!facturaDet.isAnulado().booleanValue()));
		dataset.fieldValue("read_only" , new Boolean(true));
		dataset.fieldValue("importe_neto_gravado" , facturaDet.getNetoGravado());
		dataset.fieldValue("importe_neto_no_gravado" , facturaDet.getNetoNoGravado());
		dataset.fieldValue("tasa_iva" , facturaDet.getTasaIVA());
		dataset.fieldValue("iva" , facturaDet.getIVA());
		dataset.fieldValue("comentario" , facturaDet.getComentario());
		
	}

	private void cargarRegistroFacturaCab(IDataSet dataset,
			                                  FacturaCab facturaCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cco", facturaCab.getOIDInteger());
		dataset.fieldValue("tipo_oper_factu", facturaCab.getTipo_oper());
		if (facturaCab.getCompo_stk_fact()!=null)
			dataset.fieldValue("oid_compo_stk_fac", facturaCab.getCompo_stk_fact().getOIDInteger());
		else
			dataset.fieldValue("oid_compo_stk_fac", new Integer(0));
		dataset.fieldValue("tipo_cliente" , facturaCab.getTipo_cliente());
		dataset.fieldValue("fec_emision", facturaCab.getEmision());
		
		if (facturaCab.getSujeto()!=null) {
		  dataset.fieldValue("oid_cliente", facturaCab.getSujeto().getOIDInteger());
		  dataset.fieldValue("cod_cliente", facturaCab.getSujeto().getCodigo());
		  dataset.fieldValue("rz_cliente", facturaCab.getSujeto().getRazon_social());
		} else {
		  dataset.fieldValue("oid_cliente", new Integer(0));
		  dataset.fieldValue("cod_cliente", "");
		  dataset.fieldValue("rz_cliente", "");
		}
		
		if (facturaCab.getProyecto()!=null) {
			dataset.fieldValue("oid_proyecto", facturaCab.getProyecto().getOIDInteger());
			dataset.fieldValue("cod_proyecto", facturaCab.getProyecto().getCodigo());
			dataset.fieldValue("desc_proyecto", facturaCab.getProyecto().getDescripcion());
		} else {
			dataset.fieldValue("oid_proyecto", new Integer(0));
			dataset.fieldValue("cod_proyecto", "");
			dataset.fieldValue("desc_proyecto", "");
		}
		
		if (facturaCab.getVendedor()!=null) {
		  dataset.fieldValue("oid_vendedor", facturaCab.getVendedor().getOIDInteger());
		  dataset.fieldValue("cod_vendedor", facturaCab.getVendedor().getCodigo());
		  dataset.fieldValue("rz_vendedor", facturaCab.getVendedor().getNombreyApellido());
		} else {
		  dataset.fieldValue("oid_vendedor", new Integer(0));
		  dataset.fieldValue("cod_vendedor", "");
		  dataset.fieldValue("rz_vendedor", "");
		}
		
		dataset.fieldValue("oid_talonario" , facturaCab.getTalonario().getOIDInteger());
		dataset.fieldValue("oid_tc" , facturaCab.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_tc" , facturaCab.getTipoCompro().getCodigo());
		dataset.fieldValue("letra" , facturaCab.getLetra());
		dataset.fieldValue("oid_lug_emi" , facturaCab.getLugarEmision().getOIDInteger()); 
		dataset.fieldValue("nro_lug_emi" , facturaCab.getNroLugEmision());
		dataset.fieldValue("nro_ext" , facturaCab.getNroExt());
		dataset.fieldValue("oid_lp" , facturaCab.getLista_precios().getOIDInteger());
		dataset.fieldValue("cod_lp" , facturaCab.getLista_precios().getCodigo());			
		dataset.fieldValue("desc_lp" , facturaCab.getLista_precios().getDescripcion());
		dataset.fieldValue("comentario" , facturaCab.getComentario());
		if (facturaCab.getCaja()!=null) {
		  dataset.fieldValue("oid_caja" , facturaCab.getCaja().getOIDInteger());
		  dataset.fieldValue("fec_caja" , facturaCab.getFec_caja());
		} else {
		  dataset.fieldValue("oid_caja" , new Integer(0));
		  dataset.fieldValue("fec_caja" , Fecha.FECHA_NULA());
		}
		dataset.fieldValue("oper_factu" , facturaCab.getTipo_oper());
		dataset.fieldValue("tipo_compo_compro" , facturaCab.getTipoCompro().getIdentificacion());
		if (facturaCab.getTipoConfMovStkTalonario()!=null)
			dataset.fieldValue("oid_tipo_conf_mov" , facturaCab.getTipoConfMovStkTalonario().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_conf_mov" , new Integer(0));
			
		if (facturaCab.getProvincia()!=null) {
		  dataset.fieldValue("oid_provincia" , facturaCab.getProvincia().getOIDInteger());
		  dataset.fieldValue("cod_provincia" , facturaCab.getProvincia().getCodigo());
		  dataset.fieldValue("desc_provincia" , facturaCab.getProvincia().getDescripcion());
		} else {
		  dataset.fieldValue("oid_provincia" , new Integer(0));
		  dataset.fieldValue("cod_provincia" , "");
		  dataset.fieldValue("desc_provincia" , "");
		}
		
		if (facturaCab.getCond_pago()!=null) {
		  dataset.fieldValue("oid_cond_pago" , facturaCab.getCond_pago().getOIDInteger());
		  dataset.fieldValue("compo_cond_pago" , facturaCab.getCond_pago().getComportamiento());
		} else {
		  dataset.fieldValue("oid_cond_pago" , new Integer(0));
		  dataset.fieldValue("compo_cond_pago" , "");
		}
		
		if ((facturaCab.getSujeto_impositivo()!=null) && (facturaCab.getSujeto_impositivo().getCategiva()!=null))
			dataset.fieldValue("disc_iva" , facturaCab.getSujeto_impositivo().getCategiva().isDiscriminaIVA());
		else
			dataset.fieldValue("disc_iva" , new Boolean(false));
		dataset.fieldValue("bruto" , facturaCab.getBruto());
		dataset.fieldValue("oid_moneda" , facturaCab.getMoneda().getOIDInteger());
		dataset.fieldValue("cotizacion" , facturaCab.getCotizacion());
		dataset.fieldValue("porc_bonif_cli" , facturaCab.getPorc_bonif_cli());
		dataset.fieldValue("porc_reca_cli" , facturaCab.getPorc_recar_cli());
		dataset.fieldValue("cuotas" , new Integer(0));
		dataset.fieldValue("dias" , new Integer(0));
		dataset.fieldValue("porc_bonif_fp" , facturaCab.getPorc_bonif_cp());
		dataset.fieldValue("porc_recar_fp" , facturaCab.getPorc_recar_cp());
		dataset.fieldValue("total_bruto" , facturaCab.getBruto());
		dataset.fieldValue("porc_dto" , facturaCab.getPorc_dto());
		dataset.fieldValue("descuento" , facturaCab.getDescuento());
		dataset.fieldValue("recargo" , facturaCab.getRecargo());
		dataset.fieldValue("porc_recar" , facturaCab.getPorc_recar());
		dataset.fieldValue("total_neto" ,  facturaCab.getNeto());
		dataset.fieldValue("imp_internos" , facturaCab.getImp_internos());
		dataset.fieldValue("perc_ib_ba" , facturaCab.getPercIBBsAs());
		dataset.fieldValue("perc_ib_cf" , facturaCab.getPercIBCapFed());
		dataset.fieldValue("iva" , facturaCab.getIva());
		dataset.fieldValue("perc_iva" , facturaCab.getPerc_iva());
		dataset.fieldValue("total_total" , facturaCab.getTotal());
		dataset.fieldValue("bruto_mon_loc" , facturaCab.getBrutoMonLoc());
		dataset.fieldValue("porc_dto_mon_loc" , facturaCab.getPorcDtoMonLoc());
		dataset.fieldValue("dto_mon_loc" , facturaCab.getDtoMonLoc());
		dataset.fieldValue("recargo_mon_loc" , facturaCab.getRecargoMonLoc());
		dataset.fieldValue("porc_recar_mon_loc" , facturaCab.getPorcRecarMonLoc());
		dataset.fieldValue("neto_mon_local" , facturaCab.getNetoMonedaLocal());
		dataset.fieldValue("imp_int_mon_loc" , facturaCab.getImpuIntMonLoc());
		dataset.fieldValue("perc_ib_mon_loc" , facturaCab.getPercIBMonLoc());
		dataset.fieldValue("iva_mon_loc" , facturaCab.getIVAMonLoc());
		dataset.fieldValue("perc_iva_mon_loc" , facturaCab.getPercIVAMonLoc());
		dataset.fieldValue("total_mon_loc" , facturaCab.getTotMonLoc());
		dataset.fieldValue("impre_bruto" , facturaCab.getImpre_bruto());
		dataset.fieldValue("impre_porc_dto" , facturaCab.getImprePorcBonif());
		dataset.fieldValue("impre_descuento" , facturaCab.getImpre_bonif());
		dataset.fieldValue("impre_porc_recar" , facturaCab.getImprePorcRecar());
		dataset.fieldValue("impre_recargo" , facturaCab.getImpre_recar());
		dataset.fieldValue("impre_neto" , facturaCab.getImpre_neto());
		dataset.fieldValue("impre_iva" , facturaCab.getImpre_iva());
		dataset.fieldValue("impre_iva_2" , facturaCab.getImpre_iva2());
		dataset.fieldValue("impre_perc_iva" , facturaCab.getImpre_perc_iva());
		dataset.fieldValue("impre_imp_internos" , facturaCab.getImpre_imp_int());
		dataset.fieldValue("impre_perc_ib_ba" , facturaCab.getImprePercIBBsAs());
		dataset.fieldValue("impre_perc_ib_cf" , facturaCab.getImprePercIBCapFed());
		dataset.fieldValue("impre_total" , facturaCab.getImpre_total());
		if (facturaCab.getConcImpuIVA()!=null)
			dataset.fieldValue("oid_conc_impu_iva" , facturaCab.getConcImpuIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_iva" , new Integer(0));
		if (facturaCab.getConcImpuPercIVA()!=null)
			dataset.fieldValue("oid_conc_impu_perc_iva" , facturaCab.getConcImpuPercIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_perc_iva" , new Integer(0));
		if (facturaCab.getConcImpuPercIB()!=null)
			dataset.fieldValue("oid_conc_impu_perc_ib" , facturaCab.getConcImpuPercIB().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_perc_ib" , new Integer(0));
		if (facturaCab.getConcImpInt()!=null)
			dataset.fieldValue("oid_conc_impu_int" , facturaCab.getConcImpInt().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_int" , new Integer(0));
		dataset.fieldValue("neto_gravado" , facturaCab.getNetoGravado());
		dataset.fieldValue("neto_no_gravado" , facturaCab.getNetoNoGravado());
		dataset.fieldValue("porc_bonif_cli_ori" , facturaCab.getPorc_bonif_cli());
		dataset.fieldValue("porc_reca_cli_ori" , facturaCab.getRecargo());
		dataset.fieldValue("porc_bonif_fp_ori" , facturaCab.getPorc_bonif_cp());
		dataset.fieldValue("porc_reca_fp_ori" , facturaCab.getRecargo());
		if (facturaCab.getMotivoComprobante()!=null)
			dataset.fieldValue("oid_motivo_compro" , facturaCab.getMotivoComprobante().getOIDInteger());
		else
			dataset.fieldValue("oid_motivo_compro" , new Integer(0));
		dataset.fieldValue("oid_cco_ped" , new Integer(0));
		
		PedidoCab pedido = facturaCab.getFirstPedido();
		
		if (pedido!=null)
			dataset.fieldValue("nro_ext_ped" , pedido.getNroExt());
		else
			dataset.fieldValue("nro_ext_ped" , new Integer(0));
			
		dataset.fieldValue("activo" , facturaCab.isActivo());
		
		dataset.fieldValue("remitos_facturados", facturaCab.getRemitosFacturados());
		dataset.fieldValue("oc", facturaCab.getOC());
		dataset.fieldValue("factura", facturaCab.getFactura());
		dataset.fieldValue("comportamiento_tc", facturaCab.getComportamiento());
		
	}
	
	private IDataSet getDataSetTalFactClie() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTalFactClie");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc", Field.STRING, 50));
		dataset.fieldDef(new Field("letra", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_automatica", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("primer_nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ultimo_nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_actual", Field.INTEGER, 0));
		dataset.fieldDef(new Field("impresora_fiscal", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("driver", Field.STRING, 255));
		dataset.fieldDef(new Field("puerto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("baudios", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_copias", Field.INTEGER, 0));
		return dataset;
	}
	
	private void cargarRegistroTalonario(IDataSet dsTalonario,Talonario talonario) throws BaseException {
		dsTalonario.append();
		dsTalonario.fieldValue("oid", talonario.getOIDInteger());
		dsTalonario.fieldValue("codigo", talonario.getCodigo());
		dsTalonario.fieldValue("descripcion", talonario.getDescripcion());
		dsTalonario.fieldValue("oid_tc", talonario.getTipo_comprobante().getOIDInteger());
		dsTalonario.fieldValue("cod_tc", talonario.getTipo_comprobante().getCodigo());
		dsTalonario.fieldValue("letra", talonario.getLetra());
		dsTalonario.fieldValue("oid_lug_emi", talonario.getLugar_emision().getOIDInteger());
		dsTalonario.fieldValue("nro_lug_emi", talonario.getLugar_emision().getLugemi());
		dsTalonario.fieldValue("nro_automatica", talonario.isNro_automatica());
		dsTalonario.fieldValue("primer_nro", talonario.getPrimer_nro());
		dsTalonario.fieldValue("ultimo_nro", talonario.getUltimo_nro());
		dsTalonario.fieldValue("nro_actual", talonario.getNro_actual());
		dsTalonario.fieldValue("impresora_fiscal", talonario.isUsaImpresoraFiscal());
		if (talonario.getImpresora_fiscal()!=null) {
			dsTalonario.fieldValue("driver", talonario.getImpresora_fiscal().getDriver());
		    dsTalonario.fieldValue("puerto", talonario.getImpresora_fiscal().getPuerto());
		    dsTalonario.fieldValue("baudios", talonario.getImpresora_fiscal().getBaudios());
		}
		else {
			dsTalonario.fieldValue("driver", "");
		    dsTalonario.fieldValue("puerto", 0);
		    dsTalonario.fieldValue("baudios", 0);
		}
		
		dsTalonario.fieldValue("cant_copias", talonario.getCantCopias());
		
	}
	

}
