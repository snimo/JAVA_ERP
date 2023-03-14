package com.srn.erp.ventas.op;

import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.Impuesto;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.impuestos.bm.TasaIVA;
import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.ventas.bm.BonifRecarSujeto;
import com.srn.erp.ventas.bm.CalculadorFactura;
import com.srn.erp.ventas.bm.CalculadorItemFactura;
import com.srn.erp.ventas.bm.CalculadorItemVenta;
import com.srn.erp.ventas.bm.CompoStkTalonarioFactClie;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.ConfigTalonarioFactClie;
import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.CotizacionDet;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.bm.FechaFacturacionSucursal;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.OperHabiTalonarioFactClie;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.PrecioEnLP;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.TipoOperFacturacion;
import com.srn.erp.ventas.bm.TipoOperNCFinancieraClie;
import com.srn.erp.ventas.bm.TipoOperNDFinancieraClie;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class OperFacturacion extends Operation {

	private int secu = -1000000;

	private HashTableDatos listaCotizaciones = new HashTableDatos();

	private static final String REQ_TIPOS_OPER_FACTU = "TIPOS_OPER";

	private static final String REQ_TIPOS_OPER_ND = "TIPOS_OPER_ND";

	private static final String REQ_TIPOS_OPER_NC = "TIPOS_OPER_NC";

	private static final String REQ_TIPOS_MOV_STOCK = "TIPOS_MOV_STK";
	
	private static final String REQ_TIPOS_MOV_STOCK_SIN_DESP = "TIPOS_MOV_STK_SIN_DESP";

	private static final String REQ_TIPOS_CLIENTE = "TIPOS_CLIENTE";

	private static final String REQ_FEC_FACTU = "FECHA_FACTURACION";

	private static final String REQUERIMIENTO = "REQUERIMIENTO";

	private static final String REQ_CAJAS_OPER = "CAJAS_OPER";

	private static final String REQ_FECHA_CAJA = "FECHA_CAJA";

	private static final String REQ_TAL_FACT_CLIE = "TAL_FACT_CLIE";

	private static final String REQ_TAL_ND_CLIE = "TAL_ND_CLIE";

	private static final String REQ_TAL_NC_CLIE = "TAL_NC_CLIE";

	private static final String REQ_TIPOS_COMPRO = "TIPOS_COMPRO";

	private static final String REQ_LISTA_PRECIOS = "LISTA_PRECIOS";

	private static final String REQ_UNI_MED_VTA = "UNI_MED_VTA";

	private static final String REQ_PRECIO_PRODUCTO = "PRECIO_PRODUCTO";

	private static final String REQ_CALC_TOTALES = "CALC_TOT_FACT";

	private static final String REQ_BONIF_RECAR_CLI = "BONIF_RECAR_CLIENTE";

	private static final String REQ_BONIF_FORMA_PAG = "BONIF_RECAR_FP";

	private static final String REQ_DATOS_CLIENTE = "DATOS_CLIENTE";

	private static final String REQ_TAL_HAB_SEGUN_OPER = "TAL_HAB_SEGUN_OPE";

	private static final String REQ_PEDIDO_PARA_FACT = "PEDIDO_PARA_FACT";

	private static final String REQ_SUG_PROX_NRO = "SUG_PROX_NRO";

	private static final String REL_LUG_EMI_NRO_EXT = "LUG_EMI_NRO_EXT";

	private static final String REQ_VAL_DATOS_CAB_FACT = "VAL_DAT_CAB_FACT";

	private static final String ARMAR_CAB_NOTA_CREDITO = "ARMAR_CAB_NC";
	
	private static final String ARMAR_CAB_FACT_SALDO_SENIA = "ARMAR_CAB_FACT_SALDO_SENIA";
	
	

	private static final String REQ_REM_PEND_FACT = "RTO_PEND_FACT";

	private static final String REQ_COMPOR_COTIZ_FACT = "COMPOR_COTIZ_FACT";

	private static final String REQ_PRESU_PARA_PED = "PRESU_PARA_PED";

	private static final String REQ_INI_FACT_VTA_MOS = "INI_FACT_VTA_MOS";

	public OperFacturacion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		procesarRequerimiento(mapaDatos);
	}

	private void procesarRequerimiento(MapDatos mapaDatos) throws BaseException {
		if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_TIPOS_OPER_FACTU))
			requerimientoTiposOperacionFactu(mapaDatos);
		if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_TIPOS_OPER_ND))
			requerimientoTiposOperacionND(mapaDatos);
		if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_TIPOS_OPER_NC))
			requerimientoTiposOperacionNC(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_TIPOS_MOV_STOCK))
			requerimientoTiposMovStk(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_TIPOS_MOV_STOCK_SIN_DESP))
			requerimientoTiposMovStkSinDesp(mapaDatos);		
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_TIPOS_CLIENTE))
			requerimientoTiposCliente(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_FEC_FACTU))
			requerimientoFechaFacturacion(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_CAJAS_OPER))
			requerimientoCajasOpeHabilitadas(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_FECHA_CAJA))
			requerimientoFechaCaja(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_TAL_FACT_CLIE))
			requerimientoTalFactClie(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_TAL_ND_CLIE))
			requerimientoTalNDClie(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_TAL_NC_CLIE))
			requerimientoTalNCClie(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_TIPOS_COMPRO))
			requerimientoTiposCompro(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_LISTA_PRECIOS))
			requerimientoListaPrecios(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_UNI_MED_VTA))
			requerimientoUnidadMedidaVta(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_PRECIO_PRODUCTO))
			requerimientoPrecioProducto(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_CALC_TOTALES))
			requerimientoCalcTotFact(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_BONIF_RECAR_CLI))
			bonificacionesRecargosClientes(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_BONIF_FORMA_PAG))
			bonificacionesRecargosFormaPago(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_DATOS_CLIENTE))
			datosCliente(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(
				REQ_TAL_HAB_SEGUN_OPER))
			talonariosHabSegunOper(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO)
				.equals(REQ_PEDIDO_PARA_FACT))
			enviarPedidoParaFacturar(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_SUG_PROX_NRO))
			enviarSugerenciaProxNro(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REL_LUG_EMI_NRO_EXT))
			enviarSugerenciaLugEmiNroExt(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(
				REQ_VAL_DATOS_CAB_FACT))
			validarCabeceraFactMostrador(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(
				ARMAR_CAB_NOTA_CREDITO))
			ArmarCabeceraNC(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(
				ARMAR_CAB_FACT_SALDO_SENIA))
			ArmarCabeceraFactSaldoSenia(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_REM_PEND_FACT))
			enviarRemitoPendFact(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(
				REQ_COMPOR_COTIZ_FACT))
			enviarComportamientosCotizFact(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO).equals(REQ_PRESU_PARA_PED))
			enviarPresupuestoParaPedido(mapaDatos);
		else if (mapaDatos.getString(REQUERIMIENTO)
				.equals(REQ_INI_FACT_VTA_MOS))
			enviarIniFactVtaMostrador(mapaDatos);

	}

	private IDataSet getDSIniFactVtaMos() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TIniFactVtaMos");
		dataset.fieldDef(new Field("tipo_oper_factu", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_cliente", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
		return dataset;

	}

	private void cargarDSIniFactVtaMos(IDataSet ds, String tipoOperFact,
			String tipoCliente, Caja caja) throws BaseException {
		ds.append();
		ds.fieldValue("tipo_oper_factu", tipoOperFact);
		ds.fieldValue("tipo_cliente", tipoCliente);
		ds.fieldValue("oid_caja", caja.getOIDInteger());

	}

	private void enviarIniFactVtaMostrador(MapDatos mapaDatos)
			throws BaseException {
		IDataSet dsIniFactVtaMos = this.getDSIniFactVtaMos();
		cargarDSIniFactVtaMos(dsIniFactVtaMos, "FACT_MOST", "OCASIONAL", Caja
				.getCajaDefVtaMostrador(this.getSesion()));
		writeCliente(dsIniFactVtaMos);
	}

	private void enviarPresupuestoParaPedido(MapDatos mapaDatos)
			throws BaseException {

		CotizacionCab presu = CotizacionCab.findByOid(mapaDatos
				.getInteger("oid_cco_presu"), this.getSesion());

		Talonario talonario = null;
		if (mapaDatos.containsKey("oid_talonario"))
			talonario = Talonario.findByOid(mapaDatos
					.getInteger("oid_talonario"), this.getSesion());
		String ordenCompra = mapaDatos.getString("orden_compra");
		java.util.Date fecEmision = null;
		if (mapaDatos.containsKey("fec_emision"))
			fecEmision = mapaDatos.getDate("fec_emision");

		IDataSet dsPedCab = this.getDataSetPedidoCab();
		IDataSet dsPedDet = this.getDataSetPedidoDet();

		cargarPresuParaPedido(dsPedCab, dsPedDet, presu, talonario,
				ordenCompra, fecEmision);

		writeCliente(dsPedCab);
		writeCliente(dsPedDet);

	}

	private void cargarPresuParaPedido(IDataSet dsPedCab, IDataSet dsPedDet,
			CotizacionCab presu, Talonario talonario, String ordenCompra,
			java.util.Date fecEmision) throws BaseException {

		dsPedCab.append();
		dsPedCab.fieldValue("oid_cco_ped", new Integer(-1)); // -1 es Porque es
																// un nuevo
																// pedido

		if (talonario != null) {
			dsPedCab.fieldValue("oid_talonario", talonario.getOIDInteger()); // No
																				// se
																				// asigna
																				// talona
			dsPedCab.fieldValue("cod_tc", talonario.getTipo_comprobante()
					.getCodigo());
			dsPedCab.fieldValue("oid_tc", talonario.getTipo_comprobante()
					.getOIDInteger());
		} else {
			dsPedCab.fieldValue("oid_talonario", new Integer(0)); // No se
																	// asigna
																	// talona
			dsPedCab.fieldValue("cod_tc", "");
			dsPedCab.fieldValue("oid_tc", new Integer(0));
		}

		dsPedCab.fieldValue("cod_cliente", presu.getSujeto().getCodigo());
		dsPedCab.fieldValue("rz_cliente", presu.getSujeto().getRazon_social());

		if (talonario != null) {
			dsPedCab.fieldValue("letra", talonario.getLetra());
			dsPedCab.fieldValue("lug_emi", talonario.getLugar_emision()
					.getLugemi());
			dsPedCab.fieldValue("nro_ext",
					talonario.getNro_actual().intValue() + 1);
		} else {
			dsPedCab.fieldValue("letra", "");
			dsPedCab.fieldValue("lug_emi", new Integer(0));
			dsPedCab.fieldValue("nro_ext", new Integer(0));
		}
		dsPedCab.fieldValue("oid_cliente", presu.getSujeto().getOIDInteger());
		dsPedCab.fieldValue("oid_moneda", presu.getMoneda().getOIDInteger());
		dsPedCab.fieldValue("cotizacion", presu.getCotizacion().doubleValue());
		dsPedCab.fieldValue("cotiz_mon_fact", presu.getCotizMonFact());
		dsPedCab.fieldValue("mercado", presu.getMercado());
		dsPedCab.fieldValue("porc_bonif_cli", presu.getPorc_bonif_cli());
		dsPedCab.fieldValue("porc_reca_cli", presu.getPorc_reca_cli());
		dsPedCab.fieldValue("bonif_cli_cascada", presu.isBonif_cli_cascada());
		dsPedCab.fieldValue("reca_cli_cascada", presu.isReca_cli_cascada());
		dsPedCab.fieldValue("oid_precio_cab", presu.getLista_precios()
				.getOIDInteger());
		dsPedCab.fieldValue("cod_lp", presu.getLista_precios().getCodigo());
		dsPedCab.fieldValue("desc_lp", presu.getLista_precios()
				.getDescripcion());
		if (presu.getCondicionPago() != null) {
			dsPedCab.fieldValue("oid_cond_pago", presu.getCondicionPago()
					.getOIDInteger());
			dsPedCab.fieldValue("cod_cond_pago", presu.getCondicionPago()
					.getCodigo());
			dsPedCab.fieldValue("desc_cond_pago", presu.getCondicionPago()
					.getDescripcion());
		} else {
			dsPedCab.fieldValue("oid_cond_pago", 0);
			dsPedCab.fieldValue("cod_cond_pago", "");
			dsPedCab.fieldValue("desc_cond_pago", "");
		}
		dsPedCab
				.fieldValue("oid_vendedor", presu.getVendedor().getOIDInteger());
		dsPedCab.fieldValue("cod_vendedor", presu.getVendedor().getCodigo());
		dsPedCab.fieldValue("desc_vendedor", presu.getVendedor().getApellido()
				+ " - " + presu.getVendedor().getNombre());

		if (presu.getDomicilio_entrega() != null) {
			dsPedCab.fieldValue("oid_uni_edi", presu.getDomicilio_entrega()
					.getOID());
			dsPedCab.fieldValue("cod_uni_edi", presu.getDomicilio_entrega()
					.getCodigo());
			dsPedCab.fieldValue("desc_uni_edi", presu.getDomicilio_entrega()
					.getDescripcion());
		} else {
			dsPedCab.fieldValue("oid_uni_edi", new Integer(0));
			dsPedCab.fieldValue("cod_uni_edi", "");
			dsPedCab.fieldValue("desc_uni_edi", "");
		}

		dsPedCab.fieldValue("porc_bonif_cp", presu.getPorc_bonif_cp());
		dsPedCab.fieldValue("porc_reca_cp", presu.getPorc_reca_cp());
		dsPedCab.fieldValue("bonif_cp_cascada", presu.isBonif_cp_cascada());
		dsPedCab.fieldValue("reca_cp_cascada", presu.isReca_cp_cascada());
		dsPedCab.fieldValue("observado", presu.isObservado());
		dsPedCab.fieldValue("comentario", presu.getComentario());

		if (fecEmision != null)
			dsPedCab.fieldValue("fec_emision", fecEmision);
		else
			dsPedCab.fieldValue("fec_emision", Fecha.getFechaActual());

		dsPedCab.fieldValue("activo", presu.isActivo());

		if (presu.getTransporte() != null) {
			dsPedCab.fieldValue("oid_transporte", presu.getTransporte()
					.getOIDInteger());
			dsPedCab.fieldValue("cod_transporte", presu.getTransporte()
					.getCodigo());
			dsPedCab.fieldValue("desc_transporte", presu.getTransporte()
					.getDescripcion());
		} else {
			dsPedCab.fieldValue("oid_transporte", 0);
			dsPedCab.fieldValue("cod_transporte", "");
			dsPedCab.fieldValue("desc_transporte", "");
		}

		dsPedCab.fieldValue("oid_moneda_fact", presu.getMonedaFact()
				.getOIDInteger());

		if (presu.getFormaEntrega() != null) {
			dsPedCab.fieldValue("oid_forma_entrega", presu.getFormaEntrega()
					.getOIDInteger());
			dsPedCab.fieldValue("cod_forma_entrega", presu.getFormaEntrega()
					.getCodigo());
			dsPedCab.fieldValue("desc_forma_entrega", presu.getFormaEntrega()
					.getDescripcion());
		} else {
			dsPedCab.fieldValue("oid_forma_entrega", 0);
			dsPedCab.fieldValue("cod_forma_entrega", "");
			dsPedCab.fieldValue("desc_forma_entrega", "");
		}

		if (ordenCompra.length() > 0)
			dsPedCab.fieldValue("orden_compra", ordenCompra);
		else
			dsPedCab.fieldValue("orden_compra", presu.getOrdenDeCompra());
		dsPedCab.fieldValue("compor_cotiz_fact", presu.getComporCotizFact());

		dsPedCab.fieldValue("impre_bruto", presu.getImpre_bruto());
		dsPedCab.fieldValue("impre_porc_dto", presu.getImprePorcBonif());
		dsPedCab.fieldValue("impre_descuento", presu.getImpre_bonif());
		dsPedCab.fieldValue("impre_porc_recar", presu.getImprePorcRecar());
		dsPedCab.fieldValue("impre_recargo", presu.getImpre_recar());
		dsPedCab.fieldValue("impre_neto", presu.getImpre_neto());
		dsPedCab.fieldValue("impre_iva", presu.getImpre_iva());
		dsPedCab.fieldValue("impre_perc_iva", presu.getImpre_perc_iva());
		dsPedCab.fieldValue("impre_imp_internos", presu.getImpre_imp_int());
		dsPedCab.fieldValue("impre_perc_ib", presu.getImpre_perc_ib());
		dsPedCab.fieldValue("impre_total", presu.getImpre_total());

		if (presu.getContactoSujeto() != null) {
			dsPedCab.fieldValue("oid_contacto", presu.getContactoSujeto()
					.getOIDInteger());
			dsPedCab.fieldValue("nom_y_ape_contacto", presu.getContactoSujeto()
					.getNombreYApellido());
		} else {
			dsPedCab.fieldValue("oid_contacto", new Integer(0));
			dsPedCab.fieldValue("nom_y_ape_contacto", "");
		}

		if (presu.getConcImpuIVA() != null)
			dsPedCab.fieldValue("oid_conc_impu_iva", presu.getConcImpuIVA()
					.getOIDInteger());
		else
			dsPedCab.fieldValue("oid_conc_impu_iva", new Integer(0));
		if (presu.getConcImpuPercIVA() != null)
			dsPedCab.fieldValue("oid_conc_impu_perc_iva", presu
					.getConcImpuPercIVA().getOIDInteger());
		else
			dsPedCab.fieldValue("oid_conc_impu_perc_iva", new Integer(0));
		if (presu.getConcImpuPercIB() != null)
			dsPedCab.fieldValue("oid_conc_impu_perc_ib", presu
					.getConcImpuPercIB().getOIDInteger());
		else
			dsPedCab.fieldValue("oid_conc_impu_perc_ib", new Integer(0));
		if (presu.getConcImpInt() != null)
			dsPedCab.fieldValue("oid_conc_impu_int", presu.getConcImpInt()
					.getOIDInteger());
		else
			dsPedCab.fieldValue("oid_conc_impu_int", new Integer(0));

		dsPedCab.fieldValue("oid_cco_presu", presu.getOIDInteger());
		dsPedCab.fieldValue("nro_presu", presu.getNroExt());

		cargarDetallesPedido(dsPedDet, presu);

	}

	private void cargarDetallesPedido(IDataSet dataset, CotizacionCab presu)
			throws BaseException {

		int secu = 0;
		int nuevoOID = 0;

		Iterator iterDetalles = presu.getDetalles().iterator();
		while (iterDetalles.hasNext()) {

			CotizacionDet presuDet = (CotizacionDet) iterDetalles.next();
			if (presuDet.isAnulado().booleanValue())
				continue;
			++secu;

			dataset.append();
			dataset.fieldValue("nro_renglon", new Integer(secu));
			--nuevoOID;
			dataset.fieldValue("oid_ped_det", new Integer(nuevoOID));
			dataset.fieldValue("oid_cco_ped", new Integer(-1));
			dataset.fieldValue("oid_art", presuDet.getProducto()
					.getOIDInteger());
			dataset.fieldValue("cod_producto", presuDet.getProducto()
					.getCodigo());
			dataset.fieldValue("desc_producto", presuDet.getProducto()
					.getDescripcion());
			dataset.fieldValue("oid_um_ori", presuDet.getUni_med_ori()
					.getOIDInteger());
			dataset.fieldValue("cantidad", presuDet.getCant_um_ori());
			dataset.fieldValue("precio", presuDet.getPrecio());
			dataset.fieldValue("precio_lista", presuDet.getPrecio_lista());
			dataset.fieldValue("precio_sugerido", new Money(0));
			dataset.fieldValue("precio_bonif", presuDet.getPrecio_bonif());
			dataset.fieldValue("oid_moneda", presuDet.getMoneda()
					.getOIDInteger());
			dataset.fieldValue("activo", new Boolean(true));
			dataset.fieldValue("bonif1", presuDet.getBonif1());
			dataset.fieldValue("bonif2", presuDet.getBonif2());
			dataset.fieldValue("bonif3", presuDet.getBonif3());
			dataset.fieldValue("comentario", presuDet.getComentario());
			dataset.fieldValue("fec_entrega", Fecha.getFechaActual());

			if (presuDet.getConcImpuIVA() != null)
				dataset.fieldValue("oid_conc_imp_iva", presuDet
						.getConcImpuIVA().getOIDInteger());
			else
				dataset.fieldValue("oid_conc_imp_iva", new Integer(0));
			if (presuDet.getConcImpuPercIVA() != null)
				dataset.fieldValue("oid_conc_imp_perc_iva", presuDet
						.getConcImpuPercIVA().getOIDInteger());
			else
				dataset.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
			if (presuDet.getConcImpuInt() != null)
				dataset.fieldValue("oid_conc_imp_int", presuDet
						.getConcImpuInt().getOIDInteger());
			else
				dataset.fieldValue("oid_conc_imp_int", new Integer(0));
			if (presuDet.getConcImpuPercIB() != null)
				dataset.fieldValue("oid_conc_imp_perc_ib", presuDet
						.getConcImpuPercIB().getOIDInteger());
			else
				dataset.fieldValue("oid_conc_imp_perc_ib", new Integer(0));

			dataset.fieldValue("importe", presuDet.getImporte());

		}

	}

	private void enviarRemitoPendFact(MapDatos mapaDatos) throws BaseException {

		IDataSet dsCotizaciones = mapaDatos.getDataSet("TCotizaciones");
		cargarCotizaciones(dsCotizaciones);

		// Convertir los Valores a la Moneda de Facturacion

		Integer oid = mapaDatos.getInteger("oid_cco");
		RemitoCab remito = RemitoCab.findByOid(oid, this.getSesion());

		CalculadorFactura calcFactura = new CalculadorFactura(this.getSesion());
		calcFactura.setFecha(mapaDatos.getDate("fecha"));
		calcFactura.setSujeto(remito.getSujeto());
		calcFactura.setProvincia(remito.getProvincia());
		calcFactura.setMoneda(remito.getMonedaAUsarParaFact());
		calcFactura.setCotizacion(this.getValorCotizacion(remito
				.getMonedaAUsarParaFact()));

		PedidoCab pedido = remito.getFirsPedido();

		if (remito.isTomarLasCotizDelPedidoAlFact()) {
			// Actualizar las cotizacion
			setValorCotizacion(pedido.getMoneda(), pedido.getCotizacion());
			setValorCotizacion(pedido.getMonedaFact(), pedido.getCotizMonFact());
		}

		// Obtener la Moneda o del Pedido
		// ValorCotizacion cotizMonPed =
		// this.getValorCotizacion(pedido.getMoneda());

		// Obtener la Moneda de Facturacion
		ValorCotizacion cotizMonFact = this.getValorCotizacion(remito
				.getMonedaAUsarParaFact());

		// Obtener los Detalles del Remito pendientes de Factura
		Iterator iterDetPendFact = remito.getDetallesPendFact().iterator();
		while (iterDetPendFact.hasNext()) {

			RemitoDet remitoDet = (RemitoDet) iterDetPendFact.next();
			CalculadorItemFactura calcItemFact = calcFactura.addItemFact();
			calcItemFact.setProducto(remitoDet.getProducto());
			calcItemFact.setCantidad(new Money(remitoDet.getCantPendFact()
					.doubleValue()));

			calcItemFact.setConcImpuIVA(remitoDet.getProducto().getConcImpuIVA(
					calcFactura.getFecha()));
			calcItemFact.setConcImpuPercIVA(remitoDet.getProducto()
					.getConcImpuPercIVA(calcFactura.getFecha()));
			calcItemFact.setConcImpuImpInt(remitoDet.getProducto()
					.getConcImpuInterno(calcFactura.getFecha()));
			calcItemFact.setConcImpuPercIB(remitoDet.getProducto()
					.getConcImpuPercIB(calcFactura.getFecha()));

			PrecioEnLP precioListaRemito = remitoDet
					.getPrecioListaSinIVAParaFact(calcFactura.getFecha());
			if (precioListaRemito == null)
				throw new ExceptionValidation(null,
						"No se pudo obtener el precio de lista para el producto "
								+ remitoDet.getProducto().getCodigo() + "-"
								+ remitoDet.getProducto().getDescripcion());

			ValorCotizacion cotizMonPLRto = this
					.getValorCotizacion(precioListaRemito.getMoneda());

			Money precioListaFactura = Cotizacion.convertir(precioListaRemito
					.getPrecio(), cotizMonPLRto, cotizMonFact);

			calcItemFact.setPrecioLista(precioListaFactura);

			// Obtener el precio
			PrecioEnLP precioFactura = remitoDet
					.getPrecioATomarParaFact(calcFactura.getFecha());
			ValorCotizacion cotizPrecioFact = this
					.getValorCotizacion(precioFactura.getMoneda());

			Money precioFacturaMonFact = Cotizacion.convertir(precioFactura
					.getPrecio(), cotizPrecioFact, cotizMonFact);

			calcItemFact.setPrecio(precioFacturaMonFact);

			// Calcular importe: Precio Neto x Cant. Pend. Facturacion
			// CalculadorMoney calcImporte = new
			// CalculadorMoney(precioNetoBonif);
			// calcImporte.multiplicarPor(calcItemFact.getCantidad());
			// calcItemFact.setImporte(calcImporte.getResultMoney());

			// Por ahora trabajara solo con una bonificacion
			if (remitoDet.getPedidoDet() != null) {
				calcItemFact.setPorcBonif1(new Porcentaje(remitoDet
						.getPedidoDet().getBonif1().doubleValue()));
				// calcItemFact.setPorcBonif2(new
				// Porcentaje(remitoDet.getPedidoDet().getBonif2().doubleValue()));
				// calcItemFact.setPorcBonif3(new
				// Porcentaje(remitoDet.getPedidoDet().getBonif3().doubleValue()));
			} else {
				Sujeto sujeto = remitoDet.getRemito_cab().getSujeto();
				calcItemFact.setPorcBonif1(remitoDet.getProducto()
						.getPorcDtoProducto(sujeto, null,
								calcFactura.getFecha()));
			}

			calcItemFact.setRemitoDet(remitoDet);

		}
		calcFactura.calcular();

		IDataSet ds = getDSRemitoParaFact();
		IDataSet dsDet = getDSRemitoDetParaFact();

		cargarRegistroRtoParaFact(ds, dsDet, dsCotizaciones, remito,
				calcFactura);

		writeCliente(ds);
		writeCliente(dsDet);

	}

	
	private void ArmarCabeceraFactSaldoSenia(MapDatos mapaDatos) throws BaseException {

		Integer oid = mapaDatos.getInteger("oid_cco");
		FacturaCab factura = FacturaCab.findByOid(oid, this.getSesion());

		IDataSet ds = getDSCabNC();
		IDataSet dsDet = getDSDetNC();

		cargarRegistroFactSaldoSenia(ds, dsDet, factura);

		writeCliente(ds);
		writeCliente(dsDet);

	}
	
	
	private void ArmarCabeceraNC(MapDatos mapaDatos) throws BaseException {

		Integer oid = mapaDatos.getInteger("oid_cco");
		FacturaCab factura = FacturaCab.findByOid(oid, this.getSesion());

		IDataSet ds = getDSCabNC();
		IDataSet dsDet = getDSDetNC();

		IDataSet dsDetFac = mapaDatos.getDataSet("TDetNC");

		cargarRegistroCabNC(ds, dsDetFac, dsDet, factura);

		writeCliente(ds);
		writeCliente(dsDet);

	}

	private void cargarRegistroRtoParaFact(IDataSet ds, IDataSet dsDet,
			IDataSet dsCotizaciones, RemitoCab remito,
			CalculadorFactura calculadorFactura) throws BaseException {

		java.util.Date fechaFacturacion = FacturaCab
				.getFechaAUsarParaFacturar(this.getSesion());

		ds.append();
		ds.fieldValue("oid_cco", new Integer(-1));
		ds.fieldValue("oid_caja", Caja.getCajaDefVtaMostrador(this.getSesion())
				.getOIDInteger());
		ds.fieldValue("oid_cco_fact", new Integer(0));
		ds.fieldValue("fec_emision", fechaFacturacion);
		ds.fieldValue("tipo_oper_factu", TipoOperFacturacion.FACT_REM);
		ds.fieldValue("tipo_cliente", "HABITUAL");
		ds.fieldValue("oid_cliente", remito.getSujeto().getOIDInteger());
		ds.fieldValue("cod_cliente", remito.getSujeto().getCodigo());
		ds.fieldValue("rz_cliente", remito.getSujeto().getRazon_social());

		Vendedor vendedor = remito.getVendedorAUsarParaFact();

		ds.fieldValue("oid_vendedor", vendedor.getOIDInteger());
		ds.fieldValue("cod_vendedor", vendedor.getCodigo());
		ds.fieldValue("rz_vendedor", vendedor.getNombreyApellido());

		ListaPrecios listaPrecios = remito.getLPAUsarParaFact(FacturaCab
				.getFechaAUsarParaFacturar(this.getSesion()));

		ds.fieldValue("oid_lp", listaPrecios.getOIDInteger());
		ds.fieldValue("cod_lp", listaPrecios.getCodigo());
		ds.fieldValue("desc_lp", listaPrecios.getDescripcion());

		Moneda monedaFacturacion = remito.getMonedaAUsarParaFact();
		CondicionPago condPago = remito.getCondPagoAUsarParaFact();

		ds.fieldValue("oid_cond_pago", condPago.getOIDInteger());

		ds.fieldValue("oid_moneda", remito.getMonedaAUsarParaFact()
				.getOIDInteger());

		ValorCotizacion cotizMonFact = this
				.getValorCotizacion(monedaFacturacion);
		if (cotizMonFact == null)
			throw new ExceptionValidation(null,
					"No se pudo obtener la cotización para la moneda "
							+ monedaFacturacion.getDescripcion());

		ds.fieldValue("cotizacion", cotizMonFact);

		Provincia provincia = remito.getProvinciaAUsarParaFact();

		ds.fieldValue("oid_provincia", provincia.getOIDInteger());
		ds.fieldValue("cod_provincia", provincia.getCodigo());
		ds.fieldValue("desc_provincia", provincia.getDescripcion());
		ds.fieldValue("comentario", "");
		ds.fieldValue("remitos_facturados", remito.getCodigo());

		PedidoCab pedido = remito.getFirstPedido();

		if (pedido != null) {
			ds.fieldValue("oid_cco_ped", pedido.getOIDInteger());
			ds.fieldValue("nro_ext_ped", pedido.getNroExt());
			ds.fieldValue("oc", pedido.getOrdenDeCompra());
			if (pedido.getProyecto()!=null) {
				ds.fieldValue("oid_proyecto", pedido.getProyecto().getOIDInteger());
				ds.fieldValue("cod_proyecto", pedido.getProyecto().getCodigo());
			} else {
				ds.fieldValue("oid_proyecto", 0);
				ds.fieldValue("cod_proyecto", "");
			}
		} else {
			ds.fieldValue("oid_cco_ped", new Integer(0));
			ds.fieldValue("nro_ext_ped", "");
			ds.fieldValue("oc", "");
			ds.fieldValue("oid_proyecto", 0);
			ds.fieldValue("cod_proyecto", "");
		}

		int nroOrden = 0;
		Iterator iterItems = calculadorFactura.getItems().iterator();
		while (iterItems.hasNext()) {
			++nroOrden;
			CalculadorItemFactura calcItemFactura = (CalculadorItemFactura) iterItems
					.next();
			cargarRegistroRtoDetPendFact(nroOrden, dsDet, listaPrecios,
					fechaFacturacion, monedaFacturacion, cotizMonFact,
					dsCotizaciones, calcItemFactura);
		}

	}

	private void cargarRegistroRtoDetPendFact(int nroOrden, IDataSet ds,
			ListaPrecios listaPrecios, Date fechaFacturacion, Moneda moneda,
			ValorCotizacion cotizacion, IDataSet dsCotizaciones,
			CalculadorItemFactura calcItemFact) throws BaseException {

		PedidoDet pedidoDet = calcItemFact.getRemitoDet().getPedidoDet();

		if (pedidoDet != null) {

			ds.append();
			ds.fieldValue("oid_cco_det", new Integer(--secu));
			ds.fieldValue("oid_cco", new Integer(-1));
			ds.fieldValue("orden", nroOrden);
			ds.fieldValue("oid_art", calcItemFact.getRemitoDet().getProducto()
					.getOIDInteger());
			ds.fieldValue("cod_art", calcItemFact.getRemitoDet().getProducto()
					.getCodigo());
			ds.fieldValue("desc_art", calcItemFact.getRemitoDet().getProducto()
					.getDescripcion());
			ds.fieldValue("oid_tipo_conf_mov", new Integer(0));
			ds.fieldValue("cantidad", calcItemFact.getCantidad());
			ds.fieldValue("oid_uni_med", calcItemFact.getRemitoDet()
					.getUnidad_desp().getOIDInteger());
			ds.fieldValue("cod_uni_med", calcItemFact.getRemitoDet()
					.getUnidad_desp().getCodigo());
			ds.fieldValue("precio", calcItemFact.getPrecioNetoBonif());
			ds.fieldValue("importe", calcItemFact.getImporte());
			ds.fieldValue("comentario", calcItemFact.getRemitoDet().getComentario());
			ds.fieldValue("precio_lista", calcItemFact.getPrecioLista());
			ds.fieldValue("precio_lista_bonif", calcItemFact.getPrecioLista());
			ds.fieldValue("porc_bonif_1", calcItemFact.getPorcBonif1());
			ds.fieldValue("porc_bonif_2", calcItemFact.getPorcBonif2());
			ds.fieldValue("porc_bonif_3", calcItemFact.getPorcBonif3());

			ds.fieldValue("precio_bonif", calcItemFact.getPrecioNetoBonif());
			ds.fieldValue("nro_renglon", nroOrden);
			ds.fieldValue("precio_factura", calcItemFact.getPrecio());
			ds.fieldValue("porc_bonif_1_ori", calcItemFact.getPorcBonif1());

			if (calcItemFact.getConcImpuIVA() != null)
				ds.fieldValue("oid_conc_imp_iva", calcItemFact.getConcImpuIVA()
						.getOIDInteger());
			else
				ds.fieldValue("oid_conc_imp_iva", new Integer(0));

			if (calcItemFact.getConcImpuPercIVA() != null)
				ds.fieldValue("oid_conc_imp_perc_iva", calcItemFact
						.getConcImpuPercIVA().getOIDInteger());
			else
				ds.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
			if (calcItemFact.getConcImpuImpInt() != null)
				ds.fieldValue("oid_conc_imp_int", calcItemFact
						.getConcImpuImpInt().getOIDInteger());
			else
				ds.fieldValue("oid_conc_imp_int", new Integer(0));
			if (pedidoDet.getConcImpuPercIB() != null)
				ds.fieldValue("oid_conc_imp_perc_ib", pedidoDet
						.getConcImpuPercIB().getOIDInteger());
			else
				ds.fieldValue("oid_conc_imp_perc_ib", new Integer(0));
			if (calcItemFact.getRemitoDet() != null)
				ds.fieldValue("oid_cco_rem_det", calcItemFact.getRemitoDet()
						.getOIDInteger());
			else
				ds.fieldValue("oid_cco_rem_det", new Integer(0));
			ds.fieldValue("oid_cco_ped_det", pedidoDet.getOIDInteger());
			ds.fieldValue("activo", new Boolean(true));
			ds
					.fieldValue("importe_neto_gravado", calcItemFact
							.getNetoGravado());
			ds.fieldValue("importe_neto_no_gravado", calcItemFact
					.getNetoNoGravado());
			ds.fieldValue("tasa_iva", calcItemFact.getTasaIVA());
			ds.fieldValue("iva", calcItemFact.getIVA());

		} else {

			RemitoDet remitoDet = calcItemFact.getRemitoDet();

			ds.append();
			ds.fieldValue("oid_cco_det", new Integer(--secu));
			ds.fieldValue("oid_cco", new Integer(-1));
			ds.fieldValue("orden", remitoDet.getOIDInteger());
			ds.fieldValue("oid_art", remitoDet.getProducto().getOIDInteger());
			ds.fieldValue("cod_art", remitoDet.getProducto().getCodigo());
			ds.fieldValue("desc_art", remitoDet.getProducto().getDescripcion());
			ds.fieldValue("oid_tipo_conf_mov", new Integer(0));
			ds.fieldValue("cantidad", remitoDet.getCantPendFact());
			ds.fieldValue("oid_uni_med", remitoDet.getUnidad_desp()
					.getOIDInteger());
			ds
					.fieldValue("cod_uni_med", remitoDet.getUnidad_desp()
							.getCodigo());

			PrecioEnLP precioFactura =

			remitoDet.getProducto().getPrecioFactura(listaPrecios,
					remitoDet.getRemito_cab().getSujeto(), fechaFacturacion);

			ValorCotizacion valorOrigenPrecio = getValorCotizacion(precioFactura
					.getMoneda());
			ValorCotizacion valorDestinoPrecio = getValorCotizacion(moneda);
			Money precioConvertido = Cotizacion.convertir(precioFactura
					.getPrecio(), valorOrigenPrecio, valorDestinoPrecio);
			precioFactura.setPrecio(precioConvertido);
			precioFactura.setMoneda(moneda);

			Porcentaje porcBonif1 = CalculadorItemVenta.getPorcBonif(1,
					remitoDet.getRemito_cab().getSujeto(), remitoDet
							.getProducto(), remitoDet.getRemito_cab()
							.getCondPagoAUsarParaFact(), 0, 0,
					fechaFacturacion, this.getSesion());

			Porcentaje porcBonif2 = CalculadorItemVenta.getPorcBonif(2,
					remitoDet.getRemito_cab().getSujeto(), remitoDet
							.getProducto(), remitoDet.getRemito_cab()
							.getCondPagoAUsarParaFact(), 0, 0,
					fechaFacturacion, this.getSesion());

			Porcentaje porcBonif3 = CalculadorItemVenta.getPorcBonif(3,
					remitoDet.getRemito_cab().getSujeto(), remitoDet
							.getProducto(), remitoDet.getRemito_cab()
							.getCondPagoAUsarParaFact(), 0, 0,
					fechaFacturacion, this.getSesion());

			ds.fieldValue("precio", precioFactura.getPrecio());

			Porcentaje porc = CalculadorItemVenta.getPorcBonificacion(false,
					porcBonif1, porcBonif2, porcBonif3);

			Money precioLista = CalculadorItemVenta.getPrecioLista(
					listaPrecios, remitoDet.getProducto(), moneda,
					listaCotizaciones);

			Money precioListaBonif = CalculadorItemVenta.getPrecioBonif(
					precioLista, porc);

			Money importe = CalculadorItemVenta.getPrecioPorCantidad(
					precioListaBonif, new Money(remitoDet.getCantPendFact()
							.doubleValue()));

			ds.fieldValue("importe", importe);
			ds.fieldValue("comentario", remitoDet.getComentario());

			ds.fieldValue("precio_lista", precioLista);

			ds.fieldValue("precio_lista_bonif", precioListaBonif);
			ds.fieldValue("porc_bonif_1", porcBonif1);
			ds.fieldValue("porc_bonif_2", porcBonif2);
			ds.fieldValue("porc_bonif_3", porcBonif3);
			ds.fieldValue("precio_bonif", precioListaBonif);
			ds.fieldValue("nro_renglon", nroOrden);
			ds.fieldValue("precio_factura", precioFactura.getPrecio());
			ds.fieldValue("porc_bonif_1_ori", porcBonif1);

			ConceptoImpuesto concImpIVA = remitoDet.getProducto()
					.getConcImpuIVA(fechaFacturacion);
			ConceptoImpuesto concImpPercIVA = remitoDet.getProducto()
					.getConcImpuPercIVA(fechaFacturacion);
			ConceptoImpuesto concImpInt = remitoDet.getProducto()
					.getConcImpuInterno(fechaFacturacion);
			ConceptoImpuesto concImpPercIB = remitoDet.getProducto()
					.getConcImpuPercIB(fechaFacturacion);

			if (concImpIVA != null)
				ds.fieldValue("oid_conc_imp_iva", concImpIVA.getOIDInteger());
			else
				ds.fieldValue("oid_conc_imp_iva", new Integer(0));
			if (concImpPercIVA != null)
				ds.fieldValue("oid_conc_imp_perc_iva", concImpPercIVA
						.getOIDInteger());
			else
				ds.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
			if (concImpInt != null)
				ds.fieldValue("oid_conc_imp_int", concImpInt.getOIDInteger());
			else
				ds.fieldValue("oid_conc_imp_int", new Integer(0));
			if (concImpPercIB != null)
				ds.fieldValue("oid_conc_imp_perc_ib", concImpPercIB
						.getOIDInteger());
			else
				ds.fieldValue("oid_conc_imp_perc_ib", new Integer(0));
			ds.fieldValue("oid_cco_rem_det", remitoDet.getOIDInteger());
			ds.fieldValue("oid_cco_ped_det", new Integer(0));
			ds.fieldValue("activo", new Boolean(true));
			ds
					.fieldValue("importe_neto_gravado", calcItemFact
							.getNetoGravado());
			ds.fieldValue("importe_neto_no_gravado", calcItemFact
					.getNetoNoGravado());
			ds.fieldValue("tasa_iva", calcItemFact.getTasaIVA());
			ds.fieldValue("iva", calcItemFact.getIVA());

		}

	}

	private void cargarRegistroCabNC(IDataSet ds, IDataSet dsDetFac,
			IDataSet dsDetNC, FacturaCab factura) throws BaseException {
		
		
		
		
		ds.append();
		// Se manda el oid_cco en -1, para que se cree un nuevo registro
		ds.fieldValue("oid_cco", new Integer(-1));

		ds.fieldValue("oid_caja", Caja.getCajaDefVtaMostrador(this.getSesion())
				.getOIDInteger());
		ds.fieldValue("oid_cco_fact", factura.getOIDInteger());

		Sucursal sucursal = Sucursal.findByOidProxy(getSesion().getLogin()
				.getOidSucursal(), getSesion());
		FechaFacturacionSucursal fechaFactu = FechaFacturacionSucursal
				.getFechaFacturacion(sucursal, getSesion());
		if (fechaFactu == null)
			throw new ExceptionValidation(null,
					"No se pudo obtener la Fecha de Facturación");

		ds.fieldValue("fec_emision", fechaFactu.getFecha_actual());
		ds.fieldValue("tipo_oper_factu", TipoOperFacturacion.NC_MOST);
		ds.fieldValue("tipo_cliente", factura.getTipo_cliente());
		ds.fieldValue("oid_cliente", factura.getSujeto().getOIDInteger());
		ds.fieldValue("cod_cliente", factura.getSujeto().getCodigo());
		ds.fieldValue("rz_cliente", factura.getSujeto().getRazon_social());

		if (factura.getVendedor() != null) {
			ds
					.fieldValue("oid_vendedor", factura.getVendedor()
							.getOIDInteger());
			ds.fieldValue("cod_vendedor", factura.getVendedor().getCodigo());
			ds.fieldValue("rz_vendedor", factura.getVendedor()
					.getNombreyApellido());
		} else {
			ds.fieldValue("oid_vendedor", new Integer(0));
			ds.fieldValue("cod_vendedor", "");
			ds.fieldValue("rz_vendedor", "");
		}

		ds.fieldValue("oid_lp", factura.getLista_precios().getOIDInteger());
		ds.fieldValue("cod_lp", factura.getLista_precios().getCodigo());
		ds.fieldValue("desc_lp", factura.getLista_precios().getDescripcion());
		ds.fieldValue("oid_cond_pago", factura.getCond_pago().getOIDInteger());
		ds.fieldValue("oid_moneda", factura.getMoneda().getOIDInteger());
		ds.fieldValue("cotizacion", factura.getCotizacion());
		if (factura.getProvincia() != null) {
			ds.fieldValue("oid_provincia", factura.getProvincia()
					.getOIDInteger());
			ds.fieldValue("cod_provincia", factura.getProvincia().getCodigo());
			ds.fieldValue("desc_provincia", factura.getProvincia()
					.getDescripcion());
		} else {
			ds.fieldValue("oid_provincia", new Integer(0));
			ds.fieldValue("cod_provincia", "");
			ds.fieldValue("desc_provincia", "");
		}
		ds.fieldValue("comentario", "");
		ds.fieldValue("factura", factura.getCodigo());
		ds.fieldValue("oid_cco_fact_senia", new Integer(0));
		ds.fieldValue("oid_tipo_conf_mov", new Integer(0));
		ds.fieldValue("fact_actu_stock", factura.tieneMovStock());

		dsDetFac.first();
		int orden = 1;
		while (!dsDetFac.EOF()) {

			FacturaDet facturaDet = FacturaDet.findByOid(dsDetFac
					.getInteger("oid_cco_det_fact"), this.getSesion());

			dsDetNC.append();

			dsDetNC.fieldValue("oid_cco_det", new Integer(--secu));
			dsDetNC.fieldValue("oid_cco", new Integer(-1));
			dsDetNC.fieldValue("orden", facturaDet.getOIDInteger());
			dsDetNC.fieldValue("oid_art", facturaDet.getProducto()
					.getOIDInteger());
			dsDetNC.fieldValue("cod_art", facturaDet.getProducto().getCodigo());
			dsDetNC.fieldValue("desc_art", facturaDet.getProducto()
					.getDescripcion());
			dsDetNC.fieldValue("oid_tipo_conf_mov", new Integer(0));
			dsDetNC.fieldValue("cantidad", facturaDet.getCantidad());
			dsDetNC.fieldValue("oid_uni_med", facturaDet.getUnidad_medida()
					.getOIDInteger());
			dsDetNC.fieldValue("cod_uni_med", facturaDet.getUnidad_medida()
					.getCodigo());
			dsDetNC.fieldValue("precio", facturaDet.getPrecio_ingresado());
			dsDetNC.fieldValue("importe", facturaDet.getImporte());
			dsDetNC.fieldValue("comentario", facturaDet.getComentario());
			dsDetNC.fieldValue("precio_lista", facturaDet.getPrecio_lista());
			dsDetNC.fieldValue("precio_lista_bonif", facturaDet
					.getPrecio_bonificado());
			dsDetNC.fieldValue("porc_bonif_1", facturaDet.getPorc_bonif_1());
			dsDetNC.fieldValue("porc_bonif_2", facturaDet.getPorc_bonif_2());
			dsDetNC.fieldValue("porc_bonif_3", facturaDet.getPorc_bonif_3());
			dsDetNC.fieldValue("precio_bonif", facturaDet
					.getPrecio_bonificado());
			dsDetNC.fieldValue("nro_renglon", new Integer(orden));
			dsDetNC.fieldValue("precio_factura", facturaDet
					.getPrecio_ingresado());
			dsDetNC
					.fieldValue("porc_bonif_1_ori", facturaDet
							.getPorc_bonif_1());
			if (facturaDet.getConcImpuIVA() != null)
				dsDetNC.fieldValue("oid_conc_imp_iva", facturaDet
						.getConcImpuIVA().getOIDInteger());
			else
				dsDetNC.fieldValue("oid_conc_imp_iva", new Integer(0));
			if (facturaDet.getConcImpuPercIVA() != null)
				dsDetNC.fieldValue("oid_conc_imp_perc_iva", facturaDet
						.getConcImpuPercIVA().getOIDInteger());
			else
				dsDetNC.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
			if (facturaDet.getConcImpuInt() != null)
				dsDetNC.fieldValue("oid_conc_imp_int", facturaDet
						.getConcImpuInt().getOIDInteger());
			else
				dsDetNC.fieldValue("oid_conc_imp_int", new Integer(0));
			if (facturaDet.getConcImpuPercIB() != null)
				dsDetNC.fieldValue("oid_conc_imp_perc_ib", facturaDet
						.getConcImpuPercIB().getOIDInteger());
			else
				dsDetNC.fieldValue("oid_conc_imp_perc_ib", new Integer(0));
			if (facturaDet.getRemitoDet()!=null)
				dsDetNC.fieldValue("oid_cco_rem_det", facturaDet.getRemitoDet().getOIDInteger());
			else
				dsDetNC.fieldValue("oid_cco_rem_det", new Integer(0));
			dsDetNC.fieldValue("oid_cco_ped_det", new Integer(0));
			dsDetNC.fieldValue("activo", new Boolean(true));
			dsDetNC.fieldValue("importe_neto_gravado", facturaDet
					.getNetoGravado());
			dsDetNC.fieldValue("importe_neto_no_gravado", facturaDet
					.getNetoNoGravado());
			dsDetNC.fieldValue("tasa_iva", facturaDet.getTasaIVA());
			dsDetNC.fieldValue("iva", facturaDet.getIVA());

			dsDetFac.next();
			++orden;
		}

	}
	
	private void cargarRegistroFactSaldoSenia(IDataSet ds, IDataSet dsDetNC, FacturaCab factura) throws BaseException {
		ds.append();
		// Se manda el oid_cco en -1, para que se cree un nuevo registro
		ds.fieldValue("oid_cco", new Integer(-1));

		ds.fieldValue("oid_caja", Caja.getCajaDefVtaMostrador(this.getSesion())
				.getOIDInteger());
		ds.fieldValue("oid_cco_fact", factura.getOIDInteger());

		Sucursal sucursal = Sucursal.findByOidProxy(getSesion().getLogin()
				.getOidSucursal(), getSesion());
		FechaFacturacionSucursal fechaFactu = FechaFacturacionSucursal
				.getFechaFacturacion(sucursal, getSesion());
		if (fechaFactu == null)
			throw new ExceptionValidation(null,
					"No se pudo obtener la Fecha de Facturación");

		ds.fieldValue("fec_emision", fechaFactu.getFecha_actual());
		ds.fieldValue("tipo_oper_factu", TipoOperFacturacion.FACT_SS);
		ds.fieldValue("tipo_cliente", factura.getTipo_cliente());
		ds.fieldValue("oid_cliente", factura.getSujeto().getOIDInteger());
		ds.fieldValue("cod_cliente", factura.getSujeto().getCodigo());
		ds.fieldValue("rz_cliente", factura.getSujeto().getRazon_social());

		if (factura.getVendedor() != null) {
			ds
					.fieldValue("oid_vendedor", factura.getVendedor()
							.getOIDInteger());
			ds.fieldValue("cod_vendedor", factura.getVendedor().getCodigo());
			ds.fieldValue("rz_vendedor", factura.getVendedor()
					.getNombreyApellido());
		} else {
			ds.fieldValue("oid_vendedor", new Integer(0));
			ds.fieldValue("cod_vendedor", "");
			ds.fieldValue("rz_vendedor", "");
		}

		ds.fieldValue("oid_lp", factura.getLista_precios().getOIDInteger());
		ds.fieldValue("cod_lp", factura.getLista_precios().getCodigo());
		ds.fieldValue("desc_lp", factura.getLista_precios().getDescripcion());
		ds.fieldValue("oid_cond_pago", factura.getCond_pago().getOIDInteger());
		ds.fieldValue("oid_moneda", factura.getMoneda().getOIDInteger());
		ds.fieldValue("cotizacion", factura.getCotizacion());
		if (factura.getProvincia() != null) {
			ds.fieldValue("oid_provincia", factura.getProvincia()
					.getOIDInteger());
			ds.fieldValue("cod_provincia", factura.getProvincia().getCodigo());
			ds.fieldValue("desc_provincia", factura.getProvincia()
					.getDescripcion());
		} else {
			ds.fieldValue("oid_provincia", new Integer(0));
			ds.fieldValue("cod_provincia", "");
			ds.fieldValue("desc_provincia", "");
		}
		ds.fieldValue("comentario", "");
		ds.fieldValue("factura", factura.getCodigo());
		ds.fieldValue("oid_cco_fact_senia", factura.getOIDInteger());
		ds.fieldValue("oid_tipo_conf_mov", new Integer(0));
		ds.fieldValue("fact_actu_stock", factura.tieneMovStock());
		

		
		Iterator iterItemsFactu = 
			factura.getItemsFactura().iterator();
		int orden = 1;
		while (iterItemsFactu.hasNext()) {
			FacturaDet facturaDet = (FacturaDet) iterItemsFactu.next();
			dsDetNC.append();

			dsDetNC.fieldValue("oid_cco_det", new Integer(--secu));
			dsDetNC.fieldValue("oid_cco", new Integer(-1));
			dsDetNC.fieldValue("orden", facturaDet.getOIDInteger());
			
			
			Producto producto = facturaDet.getProducto();
			
			if (producto.isSeUsaParaSaldoPendFactSenia().booleanValue())
				producto = Producto.getProductoSeniaFactura(this.getSesion());
			
			dsDetNC.fieldValue("oid_art", producto.getOIDInteger());
			dsDetNC.fieldValue("cod_art", producto.getCodigo());
			dsDetNC.fieldValue("desc_art", producto.getDescripcion());
			dsDetNC.fieldValue("oid_tipo_conf_mov", new Integer(0));
			dsDetNC.fieldValue("cantidad", facturaDet.getCantidad());
			dsDetNC.fieldValue("oid_uni_med", facturaDet.getUnidad_medida()
					.getOIDInteger());
			dsDetNC.fieldValue("cod_uni_med", facturaDet.getUnidad_medida()
					.getCodigo());
			dsDetNC.fieldValue("precio", facturaDet.getPrecio_ingresado());
			
			if (facturaDet.getProducto().isSeUsaParaSaldoPendFactSenia().booleanValue()) {
				dsDetNC.fieldValue("comentario", factura.getCodigo());
				if (factura.getSujeto().getSujeto_impositivo().getCategiva().isDiscriminaIVA().booleanValue()==false) {
					dsDetNC.fieldValue("importe", factura.getTotal());
					
					dsDetNC.fieldValue("precio_lista", factura.getTotal());
					dsDetNC.fieldValue("precio_lista_bonif", factura.getTotal());
					dsDetNC.fieldValue("porc_bonif_1", new Porcentaje(0));
					dsDetNC.fieldValue("porc_bonif_2", new Porcentaje(0));
					dsDetNC.fieldValue("porc_bonif_3", new Porcentaje(0));
					dsDetNC.fieldValue("precio_bonif", factura.getTotal());
					dsDetNC.fieldValue("nro_renglon", new Integer(orden));
					dsDetNC.fieldValue("precio_factura", factura.getTotal());
					dsDetNC.fieldValue("porc_bonif_1_ori", new Porcentaje(0));
					if (facturaDet.getConcImpuIVA() != null)
						dsDetNC.fieldValue("oid_conc_imp_iva", facturaDet
								.getConcImpuIVA().getOIDInteger());
					else
						dsDetNC.fieldValue("oid_conc_imp_iva", new Integer(0));
					if (facturaDet.getConcImpuPercIVA() != null)
						dsDetNC.fieldValue("oid_conc_imp_perc_iva", facturaDet
								.getConcImpuPercIVA().getOIDInteger());
					else
						dsDetNC.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
					if (facturaDet.getConcImpuInt() != null)
						dsDetNC.fieldValue("oid_conc_imp_int", facturaDet
								.getConcImpuInt().getOIDInteger());
					else
						dsDetNC.fieldValue("oid_conc_imp_int", new Integer(0));
					if (facturaDet.getConcImpuPercIB() != null)
						dsDetNC.fieldValue("oid_conc_imp_perc_ib", facturaDet
								.getConcImpuPercIB().getOIDInteger());
					else
						dsDetNC.fieldValue("oid_conc_imp_perc_ib", new Integer(0));
					dsDetNC.fieldValue("oid_cco_rem_det", new Integer(0));
					dsDetNC.fieldValue("oid_cco_ped_det", new Integer(0));
					dsDetNC.fieldValue("activo", new Boolean(true));
					dsDetNC.fieldValue("importe_neto_gravado", factura.getNetoGravado());
					dsDetNC.fieldValue("importe_neto_no_gravado", factura.getNetoNoGravado());
					dsDetNC.fieldValue("tasa_iva", facturaDet.getTasaIVA());
					dsDetNC.fieldValue("iva", facturaDet.getIVA());
					
					
				} else {
					dsDetNC.fieldValue("importe", factura.getNeto());
					
					dsDetNC.fieldValue("precio_lista", factura.getNeto());
					dsDetNC.fieldValue("precio_lista_bonif", factura.getNeto());
					dsDetNC.fieldValue("porc_bonif_1", new Porcentaje(0));
					dsDetNC.fieldValue("porc_bonif_2", new Porcentaje(0));
					dsDetNC.fieldValue("porc_bonif_3", new Porcentaje(0));
					dsDetNC.fieldValue("precio_bonif", factura.getNeto());
					dsDetNC.fieldValue("nro_renglon", new Integer(orden));
					dsDetNC.fieldValue("precio_factura", factura.getNeto());
					dsDetNC.fieldValue("porc_bonif_1_ori", new Porcentaje(0));
					if (facturaDet.getConcImpuIVA() != null)
						dsDetNC.fieldValue("oid_conc_imp_iva", facturaDet
								.getConcImpuIVA().getOIDInteger());
					else
						dsDetNC.fieldValue("oid_conc_imp_iva", new Integer(0));
					if (facturaDet.getConcImpuPercIVA() != null)
						dsDetNC.fieldValue("oid_conc_imp_perc_iva", facturaDet
								.getConcImpuPercIVA().getOIDInteger());
					else
						dsDetNC.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
					if (facturaDet.getConcImpuInt() != null)
						dsDetNC.fieldValue("oid_conc_imp_int", facturaDet
								.getConcImpuInt().getOIDInteger());
					else
						dsDetNC.fieldValue("oid_conc_imp_int", new Integer(0));
					if (facturaDet.getConcImpuPercIB() != null)
						dsDetNC.fieldValue("oid_conc_imp_perc_ib", facturaDet
								.getConcImpuPercIB().getOIDInteger());
					else
						dsDetNC.fieldValue("oid_conc_imp_perc_ib", new Integer(0));
					dsDetNC.fieldValue("oid_cco_rem_det", new Integer(0));
					dsDetNC.fieldValue("oid_cco_ped_det", new Integer(0));
					dsDetNC.fieldValue("activo", new Boolean(true));
					dsDetNC.fieldValue("importe_neto_gravado", factura.getNetoGravado());
					dsDetNC.fieldValue("importe_neto_no_gravado", factura.getNetoNoGravado());
					dsDetNC.fieldValue("tasa_iva", facturaDet.getTasaIVA());
					dsDetNC.fieldValue("iva", facturaDet.getIVA());
					
				}
				
			}
			else {
				dsDetNC.fieldValue("comentario", facturaDet.getComentario());
				dsDetNC.fieldValue("importe", facturaDet.getImporte());
				
				dsDetNC.fieldValue("precio_lista", facturaDet.getPrecio_lista());
				dsDetNC.fieldValue("precio_lista_bonif", facturaDet
						.getPrecio_bonificado());
				dsDetNC.fieldValue("porc_bonif_1", facturaDet.getPorc_bonif_1());
				dsDetNC.fieldValue("porc_bonif_2", facturaDet.getPorc_bonif_2());
				dsDetNC.fieldValue("porc_bonif_3", facturaDet.getPorc_bonif_3());
				dsDetNC.fieldValue("precio_bonif", facturaDet
						.getPrecio_bonificado());
				dsDetNC.fieldValue("nro_renglon", new Integer(orden));
				dsDetNC.fieldValue("precio_factura", facturaDet
						.getPrecio_ingresado());
				dsDetNC
						.fieldValue("porc_bonif_1_ori", facturaDet
								.getPorc_bonif_1());
				if (facturaDet.getConcImpuIVA() != null)
					dsDetNC.fieldValue("oid_conc_imp_iva", facturaDet
							.getConcImpuIVA().getOIDInteger());
				else
					dsDetNC.fieldValue("oid_conc_imp_iva", new Integer(0));
				if (facturaDet.getConcImpuPercIVA() != null)
					dsDetNC.fieldValue("oid_conc_imp_perc_iva", facturaDet
							.getConcImpuPercIVA().getOIDInteger());
				else
					dsDetNC.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
				if (facturaDet.getConcImpuInt() != null)
					dsDetNC.fieldValue("oid_conc_imp_int", facturaDet
							.getConcImpuInt().getOIDInteger());
				else
					dsDetNC.fieldValue("oid_conc_imp_int", new Integer(0));
				if (facturaDet.getConcImpuPercIB() != null)
					dsDetNC.fieldValue("oid_conc_imp_perc_ib", facturaDet
							.getConcImpuPercIB().getOIDInteger());
				else
					dsDetNC.fieldValue("oid_conc_imp_perc_ib", new Integer(0));
				dsDetNC.fieldValue("oid_cco_rem_det", new Integer(0));
				dsDetNC.fieldValue("oid_cco_ped_det", new Integer(0));
				dsDetNC.fieldValue("activo", new Boolean(true));
				dsDetNC.fieldValue("importe_neto_gravado", facturaDet
						.getNetoGravado());
				dsDetNC.fieldValue("importe_neto_no_gravado", facturaDet
						.getNetoNoGravado());
				dsDetNC.fieldValue("tasa_iva", facturaDet.getTasaIVA());
				dsDetNC.fieldValue("iva", facturaDet.getIVA());
				
				
			}
			

			++orden;
			
			
		}
		

	}
	

	private IDataSet getDSCabNC() {

		IDataSet dataset = new TDataSet();
		dataset.create("TFacturaCab");

		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("tipo_oper_factu", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_cliente", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_cliente", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_cliente", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_vendedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_vendedor", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_lp", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_lp", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_provincia", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_provincia", Field.STRING, 100));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("factura", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cco_fact_senia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_conf_mov",Field.INTEGER, 0));
		dataset.fieldDef(new Field("fact_actu_stock",Field.BOOLEAN, 0));
		

		return dataset;
	}

	private IDataSet getDSRemitoParaFact() {

		IDataSet dataset = new TDataSet();
		dataset.create("TFacturaCab");

		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("tipo_oper_factu", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_cliente", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_cliente", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_cliente", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_vendedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_vendedor", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_lp", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_lp", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_provincia", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_provincia", Field.STRING, 100));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("remitos_facturados", Field.STRING, 500));
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oc", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_proyecto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proyecto", Field.STRING, 50));
		return dataset;
	}

	private IDataSet getDSDetNC() {

		IDataSet dataset = new TDataSet();
		dataset.create("TFacturaDet");

		dataset.fieldDef(new Field("oid_cco_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_art", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_art", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_art", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_uni_med", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_uni_med", Field.STRING, 50));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		dataset.fieldDef(new Field("precio_lista", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_lista_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("precio_factura", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_1_ori", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_imp_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_perc_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_perc_ib", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_rem_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_ped_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("importe_neto_gravado", Field.CURRENCY, 0));
		dataset
				.fieldDef(new Field("importe_neto_no_gravado", Field.CURRENCY,
						0));
		dataset.fieldDef(new Field("tasa_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("iva", Field.CURRENCY, 0));

		return dataset;

	}

	private IDataSet getDSRemitoDetParaFact() {

		IDataSet dataset = new TDataSet();
		dataset.create("TFacturaDet");

		dataset.fieldDef(new Field("oid_cco_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_art", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_art", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_art", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_uni_med", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_uni_med", Field.STRING, 50));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		dataset.fieldDef(new Field("precio_lista", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_lista_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("precio_factura", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_1_ori", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_imp_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_perc_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_perc_ib", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_rem_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_ped_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("importe_neto_gravado", Field.CURRENCY, 0));
		dataset
				.fieldDef(new Field("importe_neto_no_gravado", Field.CURRENCY,
						0));
		dataset.fieldDef(new Field("tasa_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("iva", Field.CURRENCY, 0));

		return dataset;

	}

	private void validarCabeceraFactMostrador(MapDatos mapaDatos)
			throws BaseException {
		IDataSet ds = mapaDatos.getDataSet("TFacturaCab");
		ds.first();
		while (!ds.EOF()) {

			Integer oidCliente = ds.getInteger("oid_cliente");
			Sujeto sujeto = Sujeto.findByOid(oidCliente, this.getSesion());

			if (sujeto == null)
				throw new ExceptionValidation(null, "Debe ingresar el Cliente");

			Integer oidCondPago = ds.getInteger("oid_cond_pago");
			CondicionPago condicionPago = CondicionPago.findByOid(oidCondPago,
					this.getSesion());

			if (condicionPago == null)
				throw new ExceptionValidation(null,
						"Debe ingresar la condición de Pago");

			// Validar si se puede facturar en CtaCte
			if (condicionPago.isCtaCte()
					&& (sujeto.isHabilitarLimiteCredito().booleanValue() == false))
				throw new ExceptionValidation(null,
						"El cliente no se encuentra habilitado para operar en Cuenta Corriente");

			ds.next();
		}

	}

	private void enviarSugerenciaLugEmiNroExt(MapDatos mapaDatos)
			throws BaseException {

		LugarEmision lugEmi = LugarEmision.findByOid(mapaDatos
				.getInteger("oid_lug_emi"), this.getSesion());

		Integer nroExterno = mapaDatos.getInteger("nro_ext");

		IDataSet dsFormatoLugEmiNroExt = this.getFormatoLugEmiNroExt();

		String lugEmiNroExt = ComproCab.getLugEmiNroExt(lugEmi.getLugemi(),
				nroExterno);

		dsFormatoLugEmiNroExt.append();
		dsFormatoLugEmiNroExt.fieldValue("lug_emi_nro_ext", lugEmiNroExt);

		writeCliente(dsFormatoLugEmiNroExt);

	}

	private void enviarSugerenciaProxNro(MapDatos mapaDatos)
			throws BaseException {

		Talonario talonario = Talonario.findByOid(mapaDatos
				.getInteger("oid_talonario"), this.getSesion());

		IDataSet dsSugProxNro = this.getSugProxNro();
		cargarSugProxNro(dsSugProxNro, talonario);
		writeCliente(dsSugProxNro);

	}

	private void enviarPedidoParaFacturar(MapDatos mapaDatos)
			throws BaseException {

		boolean incluirItems = false;
		if (mapaDatos.containsKey("incluir_items"))
			incluirItems = true;

		String tipoOperFactu = "";
		if (mapaDatos.containsKey("tipo_oper_factu"))
			tipoOperFactu = mapaDatos.getString("tipo_oper_factu");

		PedidoCab pedidoCab = PedidoCab.findByOid(mapaDatos
				.getInteger("oid_cco_ped"), this.getSesion());

		IDataSet dsPedidoCab = getPedidoCabAFacturar();
		IDataSet dsPedidoDet = getPedidoDetAFacturar();

		cargarPedidoAFact(tipoOperFactu, pedidoCab, dsPedidoCab, dsPedidoDet,
				incluirItems);

		writeCliente(dsPedidoCab);
		writeCliente(dsPedidoDet);

	}

	private void cargarPedidoAFact(String tipoOperFactu, PedidoCab pedidoCab,
			IDataSet ds, IDataSet dsDet, boolean incluirItems)
			throws BaseException {
		ds.append();
		// Se manda el oid_cco en -1, para que se cree un nuevo registro
		ds.fieldValue("oid_cco", new Integer(-1));

		ds.fieldValue("oid_caja", Caja.getCajaDefVtaMostrador(this.getSesion())
				.getOIDInteger());
		ds.fieldValue("oid_cco_fact", new Integer(0));

		Sucursal sucursal = Sucursal.findByOidProxy(getSesion().getLogin()
				.getOidSucursal(), getSesion());
		FechaFacturacionSucursal fechaFactu = FechaFacturacionSucursal
				.getFechaFacturacion(sucursal, getSesion());
		if (fechaFactu == null)
			throw new ExceptionValidation(null,
					"No se pudo obtener la Fecha de Facturación");

		ds.fieldValue("fec_emision", fechaFactu.getFecha_actual());

		if (tipoOperFactu.length() != 0)
			ds.fieldValue("tipo_oper_factu", tipoOperFactu);
		else
			ds.fieldValue("tipo_oper_factu", TipoOperFacturacion.FACT_MOST);
		ds.fieldValue("tipo_cliente", "HABITUAL");
		ds.fieldValue("oid_cliente", pedidoCab.getSujeto().getOIDInteger());
		ds.fieldValue("cod_cliente", pedidoCab.getSujeto().getCodigo());
		ds.fieldValue("rz_cliente", pedidoCab.getSujeto().getRazon_social());

		if (pedidoCab.getVendedor() != null) {
			ds.fieldValue("oid_vendedor", pedidoCab.getVendedor()
					.getOIDInteger());
			ds.fieldValue("cod_vendedor", pedidoCab.getVendedor().getCodigo());
			ds.fieldValue("rz_vendedor", pedidoCab.getVendedor()
					.getNombreyApellido());
		} else {
			ds.fieldValue("oid_vendedor", new Integer(0));
			ds.fieldValue("cod_vendedor", "");
			ds.fieldValue("rz_vendedor", "");
		}

		ds.fieldValue("oid_lp", pedidoCab.getLista_precios().getOIDInteger());
		ds.fieldValue("cod_lp", pedidoCab.getLista_precios().getCodigo());
		ds.fieldValue("desc_lp", pedidoCab.getLista_precios().getDescripcion());
		ds.fieldValue("oid_cond_pago", pedidoCab.getCondicionPago()
				.getOIDInteger());
		ds.fieldValue("oid_moneda", pedidoCab.getMonedaFact().getOIDInteger());
		ValorCotizacion cotizacion = Cotizacion.getCotizacion(fechaFactu
				.getFecha_actual(), TipoCambio.getTipoCambioVentaMostrador(this
				.getSesion()), pedidoCab.getMonedaFact(), this.getSesion());
		ds.fieldValue("cotizacion", cotizacion);

		Provincia provincia = Provincia.getProvinciaDefaultVtaMos(this
				.getSesion());

		if (provincia != null) {
			ds.fieldValue("oid_provincia", provincia.getOIDInteger());
			ds.fieldValue("cod_provincia", provincia.getCodigo());
			ds.fieldValue("desc_provincia", provincia.getDescripcion());
		} else {
			ds.fieldValue("oid_provincia", new Integer(0));
			ds.fieldValue("cod_provincia", "");
			ds.fieldValue("desc_provincia", "");
		}
		ds.fieldValue("comentario", pedidoCab.getComentario());
		ds.fieldValue("oid_cco_ped", pedidoCab.getOIDInteger());
		ds.fieldValue("nro_ext_ped", pedidoCab.getNroExt());
		ds.fieldValue("oc", pedidoCab.getOrdenDeCompra());
		
		if (pedidoCab.getProyecto()!=null) {
			ds.fieldValue("oid_proyecto", pedidoCab.getProyecto().getOIDInteger());
			ds.fieldValue("cod_proyecto", pedidoCab.getProyecto().getCodigo());
		} else {
			ds.fieldValue("oid_proyecto", new Integer(0));
			ds.fieldValue("cod_proyecto", "");
		}

		// Devolver los Detalles
		if (incluirItems == false)
			return;
		Iterator iterPedDetPendFact = pedidoCab
				.getDetallesPendientesDeFacturar().iterator();
		while (iterPedDetPendFact.hasNext()) {
			PedidoDet pedidoDet = (PedidoDet) iterPedDetPendFact.next();
			cargarRegPedDetAFacturar(dsDet, pedidoDet);
		}

	}

	private IDataSet getPedidoCabAFacturar() {

		IDataSet dataset = new TDataSet();
		dataset.create("TFacturaCab");

		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("tipo_oper_factu", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_cliente", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_cliente", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_cliente", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_vendedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_vendedor", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_lp", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_lp", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_provincia", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_provincia", Field.STRING, 100));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oc", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_proyecto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proyecto", Field.STRING, 50));

		return dataset;
	}

	private IDataSet getPedidoDetAFacturar() {

		IDataSet dataset = new TDataSet();
		dataset.create("TFacturaDet");

		dataset.fieldDef(new Field("oid_cco_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_art", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_art", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_art", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_uni_med", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_uni_med", Field.STRING, 50));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		dataset.fieldDef(new Field("precio_lista", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_lista_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("precio_factura", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_1_ori", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_imp_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_perc_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_perc_ib", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_rem_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_ped_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegPedDetAFacturar(IDataSet ds, PedidoDet pedidoDet)
			throws BaseException {

		ds.append();

		ds.fieldValue("oid_cco_det", new Integer(--secu));
		ds.fieldValue("oid_cco", new Integer(-1));
		ds.fieldValue("orden", pedidoDet.getNroRenglon());
		ds.fieldValue("oid_art", pedidoDet.getProducto().getOIDInteger());
		ds.fieldValue("cod_art", pedidoDet.getProducto().getCodigo());
		ds.fieldValue("desc_art", pedidoDet.getProducto().getDescripcion());
		ds.fieldValue("oid_tipo_conf_mov", new Integer(0));
		ds.fieldValue("cantidad", pedidoDet.getCanPendFactUniOri());
		ds
				.fieldValue("oid_uni_med", pedidoDet.getUni_med_ori()
						.getOIDInteger());
		ds.fieldValue("cod_uni_med", pedidoDet.getUni_med_ori().getCodigo());
		ds.fieldValue("precio", pedidoDet.getPrecio());
		ds.fieldValue("importe", pedidoDet.getImporte());
		ds.fieldValue("comentario", pedidoDet.getComentario());
		ds.fieldValue("precio_lista", pedidoDet.getPrecio_lista());
		ds.fieldValue("precio_lista_bonif", pedidoDet.getPrecioSugerido());
		ds.fieldValue("porc_bonif_1", pedidoDet.getBonif1());
		ds.fieldValue("porc_bonif_2", pedidoDet.getBonif2());
		ds.fieldValue("porc_bonif_3", pedidoDet.getBonif3());
		ds.fieldValue("precio_bonif", pedidoDet.getPrecio_bonif());
		ds.fieldValue("nro_renglon", pedidoDet.getNroRenglon());
		ds.fieldValue("precio_factura", pedidoDet.getPrecio());
		ds.fieldValue("porc_bonif_1_ori", pedidoDet.getBonif1());
		if (pedidoDet.getConcImpuIVA() != null)
			ds.fieldValue("oid_conc_imp_iva", pedidoDet.getConcImpuIVA()
					.getOIDInteger());
		else
			ds.fieldValue("oid_conc_imp_iva", new Integer(0));
		if (pedidoDet.getConcImpuPercIVA() != null)
			ds.fieldValue("oid_conc_imp_perc_iva", pedidoDet
					.getConcImpuPercIVA().getOIDInteger());
		else
			ds.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
		if (pedidoDet.getConcImpuInt() != null)
			ds.fieldValue("oid_conc_imp_int", pedidoDet.getConcImpuInt()
					.getOIDInteger());
		else
			ds.fieldValue("oid_conc_imp_int", new Integer(0));
		if (pedidoDet.getConcImpuPercIB() != null)
			ds.fieldValue("oid_conc_imp_perc_ib", pedidoDet.getConcImpuPercIB()
					.getOIDInteger());
		else
			ds.fieldValue("oid_conc_imp_perc_ib", new Integer(0));
		ds.fieldValue("oid_cco_rem_det", new Integer(0));
		ds.fieldValue("oid_cco_ped_det", pedidoDet.getOIDInteger());
		ds.fieldValue("activo", new Boolean(true));

	}

	private void enviarComportamientosCotizFact(MapDatos mapaDatos)
			throws BaseException {

		IDataSet dataset = new TDataSet();
		dataset.create("TComporCotizFact");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));

		Iterator iterComporCotizFact = PedidoCab.getComportamientosCotizFact()
				.keySet().iterator();
		while (iterComporCotizFact.hasNext()) {
			String codigo = (String) iterComporCotizFact.next();
			String descripcion = (String) PedidoCab
					.getComportamientosCotizFact().get(codigo);
			dataset.append();
			dataset.fieldValue("codigo", codigo);
			dataset.fieldValue("descripcion", descripcion);
		}

		writeCliente(dataset);

	}

	private void talonariosHabSegunOper(MapDatos mapaDatos)
			throws BaseException {

		IDataSet dsTalonariosFactClie = getDataSetTalFactClie();
		Sujeto cliente = Sujeto.findByOid(mapaDatos.getInteger("oid_cliente"),
				getSesion());

		if (cliente == null)
			throw new ExceptionValidation(null, "Debe ingresar un cliente");

		if (cliente.getSujeto_impositivo() == null)
			throw new ExceptionValidation(null, "El cliente "
					+ cliente.getRazon_social()
					+ " no tiene un sujeto impositivo asociado");

		if (cliente.getSujeto_impositivo().getCategiva() == null)
			throw new ExceptionValidation(null, "El cliente "
					+ cliente.getRazon_social()
					+ " no tiene una categoría de IVA asociada");

		List talonarios = null;

		if (mapaDatos.getString("tipoOper").equals(""))
			throw new ExceptionValidation(null,
					"Debe ingresar el tipo de operación");

		if ((mapaDatos.getString("tipoOper")
				.equals(TipoOperFacturacion.FACT_MOST))
				|| (mapaDatos.getString("tipoOper")
						.equals(TipoOperFacturacion.FACT_ANT))
				|| (mapaDatos.getString("tipoOper")
						.equals(TipoOperFacturacion.FACT_SS))
				|| (mapaDatos.getString("tipoOper")
						.equals(TipoOperFacturacion.FACT_REM))
				|| (mapaDatos.getString("tipoOper")
						.equals(TipoOperFacturacion.FACT_PED)))
			talonarios = cliente.getSujeto_impositivo().getCategiva()
					.getTalonariosFactSegunUniOrg();
		else if (mapaDatos.getString("tipoOper").equals(
				TipoOperFacturacion.NC_MOST))
			talonarios = cliente.getSujeto_impositivo().getCategiva()
					.getTalonariosNCSegunUniOrg();
		else if (mapaDatos.getString("tipoOper").equals(
				TipoOperFacturacion.ND_INTERNA))
			talonarios = cliente.getSujeto_impositivo().getCategiva()
					.getTalonariosNDISegunUniOrg();
		else if (mapaDatos.getString("tipoOper").equals(
				TipoOperFacturacion.NC_INTERNA))
			talonarios = cliente.getSujeto_impositivo().getCategiva()
					.getTalonariosNCISegunUniOrg();
		else if (mapaDatos.getString("tipoOper").equals(
				TipoOperFacturacion.NOTA_DEBITO))
			talonarios = cliente.getSujeto_impositivo().getCategiva()
					.getTalonariosNDSegunUniOrg();

		if (talonarios != null) {
			Iterator iterTalonarios = talonarios.iterator();
			while (iterTalonarios.hasNext()) {
				Talonario talonario = (Talonario) iterTalonarios.next();
				cargarTalFactClie(dsTalonariosFactClie, talonario, cliente
						.getSujeto_impositivo().getCategiva().isDiscriminaIVA());
			}
		}
		writeCliente(dsTalonariosFactClie);

	}

	private void requerimientoTalFactClie(MapDatos mapaDatos)
			throws BaseException {

		IDataSet dsTalonariosFactClie = getDataSetTalFactClie();
		Sujeto cliente = Sujeto.findByOid(mapaDatos.getInteger("oid_cliente"),
				getSesion());

		if (cliente == null)
			throw new ExceptionValidation(null, "Debe ingresar un cliente");

		if (cliente.getSujeto_impositivo() == null)
			throw new ExceptionValidation(null, "El cliente "
					+ cliente.getRazon_social()
					+ " no tiene un sujeto impositivo asociado");

		if (cliente.getSujeto_impositivo().getCategiva() == null)
			throw new ExceptionValidation(null, "El cliente "
					+ cliente.getRazon_social()
					+ " no tiene una categoría de IVA asociada");

		List talonarios = cliente.getSujeto_impositivo().getCategiva()
				.getTalonariosFactSegunUniOrg();
		Iterator iterTalonarios = talonarios.iterator();
		while (iterTalonarios.hasNext()) {
			Talonario talonario = (Talonario) iterTalonarios.next();
			cargarTalFactClie(dsTalonariosFactClie, talonario, cliente
					.getSujeto_impositivo().getCategiva().isDiscriminaIVA());
		}
		writeCliente(dsTalonariosFactClie);
	}

	private void requerimientoTalNDClie(MapDatos mapaDatos)
			throws BaseException {

		IDataSet dsTalonariosNDClie = getDataSetTalFactClie();
		Sujeto cliente = Sujeto.findByOid(mapaDatos.getInteger("oid_cliente"),
				getSesion());

		if (cliente == null)
			throw new ExceptionValidation(null, "Debe ingresar un cliente");

		if (cliente.getSujeto_impositivo() == null)
			throw new ExceptionValidation(null, "El cliente "
					+ cliente.getRazon_social()
					+ " no tiene un sujeto impositivo asociado");

		if (cliente.getSujeto_impositivo().getCategiva() == null)
			throw new ExceptionValidation(null, "El cliente "
					+ cliente.getRazon_social()
					+ " no tiene una categoría de IVA asociada");

		List talonarios = cliente.getSujeto_impositivo().getCategiva()
				.getTalonariosNDSegunUniOrg();
		Iterator iterTalonarios = talonarios.iterator();
		while (iterTalonarios.hasNext()) {
			Talonario talonario = (Talonario) iterTalonarios.next();
			cargarTalFactClie(dsTalonariosNDClie, talonario, cliente
					.getSujeto_impositivo().getCategiva().isDiscriminaIVA());
		}
		writeCliente(dsTalonariosNDClie);
	}

	private void requerimientoTalNCClie(MapDatos mapaDatos)
			throws BaseException {

		IDataSet dsTalonariosNCClie = getDataSetTalFactClie();
		Sujeto cliente = Sujeto.findByOid(mapaDatos.getInteger("oid_cliente"),
				getSesion());

		if (cliente == null)
			throw new ExceptionValidation(null, "Debe ingresar un cliente");

		if (cliente.getSujeto_impositivo() == null)
			throw new ExceptionValidation(null, "El cliente "
					+ cliente.getRazon_social()
					+ " no tiene un sujeto impositivo asociado");

		if (cliente.getSujeto_impositivo().getCategiva() == null)
			throw new ExceptionValidation(null, "El cliente "
					+ cliente.getRazon_social()
					+ " no tiene una categoría de IVA asociada");

		List talonarios = cliente.getSujeto_impositivo().getCategiva()
				.getTalonariosNCSegunUniOrg();
		Iterator iterTalonarios = talonarios.iterator();
		while (iterTalonarios.hasNext()) {
			Talonario talonario = (Talonario) iterTalonarios.next();
			cargarTalFactClie(dsTalonariosNCClie, talonario, cliente
					.getSujeto_impositivo().getCategiva().isDiscriminaIVA());
		}
		writeCliente(dsTalonariosNCClie);
	}

	private void requerimientoUnidadMedidaVta(MapDatos mapaDatos)
			throws BaseException {
		IDataSet dsUniMedVta = getDataSetUniMedVta();
		Producto producto = Producto.findByOid(mapaDatos
				.getInteger("oid_producto"), getSesion());
		cargarUniMedVta(dsUniMedVta, producto.getUm_vta());
		writeCliente(dsUniMedVta);
	}

	private IDataSet getDataSetUniMedVta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TUnidadMedidaVta");
		dataset.fieldDef(new Field("oid_uni_med", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private void cargarUniMedVta(IDataSet dataset, UnidadMedida unidadMedida)
			throws BaseException {
		dataset.append();
		if (unidadMedida != null) {
			dataset.fieldValue("oid_uni_med", unidadMedida.getOIDInteger());
			dataset.fieldValue("codigo", unidadMedida.getCodigo());
			dataset.fieldValue("descripcion", unidadMedida.getDescripcion());
		} else
			throw new ExceptionValidation(
					"El Producto seleccionado no tiene unidad de venta asociada");
	}

	private void bonificacionesRecargosFormaPago(MapDatos mapaDatos)
			throws BaseException {

		int dias = mapaDatos.getInteger("dias").intValue();
		int cuotas = mapaDatos.getInteger("cuotas").intValue();
		Integer oidCondPago = mapaDatos.getInteger("oid_cond_pago");

		if (oidCondPago.intValue() == 0)
			return;

		CondicionPago condPago = CondicionPago.findByOidProxy(oidCondPago,
				getSesion());

		IDataSet dataset = new TDataSet();
		dataset.create("TBonifRecarFormaPago");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("bonificacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("recargo", Field.CURRENCY, 0));

		dataset.append();
		dataset.fieldValue("secu", new Integer(1));
		dataset.fieldValue("bonificacion", condPago.getPorcBonif(cuotas, dias));
		dataset.fieldValue("recargo", condPago.getPorcRecar(cuotas, dias));

		writeCliente(dataset);

	}

	private void datosCliente(MapDatos mapaDatos) throws BaseException {

		Integer oidSujeto = mapaDatos.getInteger("oid_sujeto");
		Sujeto sujeto = Sujeto.findByOid(oidSujeto, getSesion());

		IDataSet dataset = new TDataSet();
		dataset.create("TDatosSujeto");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("bonif_en_cascada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_mon_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_vendedor", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_forma_pago", Field.INTEGER, 0));

		dataset.append();
		dataset.fieldValue("secu", new Integer(1));
		dataset.fieldValue("bonif_en_cascada", sujeto.isBonifEnCascada());
		if (sujeto.getMonedaFactura() != null)
			dataset.fieldValue("oid_mon_fact", sujeto.getMonedaFactura()
					.getOIDInteger());
		else
			dataset.fieldValue("oid_mon_fact", new Integer(0));

		if (sujeto.getVendedor_comercial() != null) {
			dataset.fieldValue("oid_vendedor", sujeto.getVendedor_comercial()
					.getOIDInteger());
			dataset.fieldValue("cod_vendedor", sujeto.getVendedor_comercial()
					.getCodigo());
		} else {

			Vendedor vendedor = Vendedor.getVendedorDefVtaMostrador(this
					.getSesion());
			if (vendedor != null) {
				dataset.fieldValue("oid_vendedor", vendedor.getOIDInteger());
				dataset.fieldValue("cod_vendedor", vendedor.getCodigo());
			} else {
				dataset.fieldValue("oid_vendedor", new Integer(0));
				dataset.fieldValue("cod_vendedor", "");
			}
		}

		if (sujeto.getCondicionPago() != null)
			dataset.fieldValue("oid_forma_pago", sujeto.getCondicionPago()
					.getOIDInteger());
		else {
			CondicionPago condPago = CondicionPago
					.getCondicionPagoDefaultVtaMostrador(this.getSesion());
			if (condPago != null)
				dataset.fieldValue("oid_forma_pago", condPago.getOIDInteger());
			else
				dataset.fieldValue("oid_forma_pago", new Integer(0));
		}

		writeCliente(dataset);

	}

	private void bonificacionesRecargosClientes(MapDatos mapaDatos)
			throws BaseException {
		// Bonificaciones Recargos Clientes
		java.util.Date fecha = mapaDatos.getDate("fecha");
		Sujeto sujeto = Sujeto.findByOidProxy(mapaDatos
				.getInteger("oid_sujeto"), getSesion());
		BonifRecarSujeto bonifRecarSuj = sujeto.getBonifRecar(fecha);

		Porcentaje porcDto = new Porcentaje(0);
		Porcentaje porcRecar = new Porcentaje(0);

		if (bonifRecarSuj != null) {
			porcDto = bonifRecarSuj.getPorcDto();
			porcRecar = bonifRecarSuj.getPorcRecar();
		}

		IDataSet dsBonifRecarClie = getBonifRecarCliente();
		cargarBonifRecarCliente(dsBonifRecarClie, new Integer(1), sujeto,
				porcDto, porcRecar);

		writeCliente(dsBonifRecarClie);

	}

	private IDataSet getBonifRecarCliente() {
		IDataSet dataset = new TDataSet();
		dataset.create("TBonifRecarCliente");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("porc_bonificacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_recargo", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarBonifRecarCliente(IDataSet dataset, Integer oid,
			Sujeto sujeto, Porcentaje porcBonifCliente,
			Porcentaje porcRecarCliente) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", new Integer(1));
		dataset.fieldValue("oid_sujeto", sujeto.getOIDInteger());
		dataset.fieldValue("porc_bonificacion", porcBonifCliente
				.getBigDecimal().doubleValue());
		dataset.fieldValue("porc_recargo", porcRecarCliente.getBigDecimal()
				.doubleValue());
	}

	private void requerimientoCajasOpeHabilitadas(MapDatos mapaDatos)
			throws BaseException {
		IDataSet dsCajaOperativa = getDataSetCajasOperativasHab();
		List cajas = Caja.getCajasOperativasHab(getSesion());
		Iterator iterCajas = cajas.iterator();
		while (iterCajas.hasNext()) {
			Caja caja = (Caja) iterCajas.next();
			cargarCajaOperativa(dsCajaOperativa, caja.getOIDInteger(), caja
					.getCodigo(), caja.getDescripcion());
		}
		writeCliente(dsCajaOperativa);
	}

	private void requerimientoCalcTotFact(MapDatos mapaDatos)
			throws BaseException {
		
		
		IDataSet dsFactCab = mapaDatos.getDataSet("TFacturaCab");
		IDataSet dsFactDet = mapaDatos.getDataSet("TFacturaDet");

		Provincia provincia = null;

		dsFactCab.first();
		if (dsFactCab.EOF())
			return;
		if (dsFactCab.getDate("fec_emision") == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha");
		if ((dsFactCab.getInteger("oid_cliente") == null)
				|| (dsFactCab.getInteger("oid_cliente").intValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el cliente");
		if (dsFactCab.containstAttribute("oid_provincia")) {
			if (dsFactCab.getInteger("oid_provincia") == null)
				throw new ExceptionValidation(null,
						"Debe ingresar una provincia");
			provincia = Provincia.findByOid(dsFactCab
					.getInteger("oid_provincia"), getSesion());
		} else if (dsFactCab.containstAttribute("oid_uni_edi")) {
			if ((dsFactCab.getInteger("oid_uni_edi") != null)
					&& (dsFactCab.getInteger("oid_uni_edi").intValue() != 0)) {
				UnidadEdilicia unidadEdilicia = UnidadEdilicia.findByOid(
						dsFactCab.getInteger("oid_uni_edi"), this.getSesion());
				if (unidadEdilicia.getProvincia() == null)
					throw new ExceptionValidation(null,
							"Debe ingresar la provincia del Domicilio de Entrega");
				provincia = unidadEdilicia.getProvincia();
			}
		}

		if (provincia == null)
			provincia = Provincia.getProvinciaDefaultVtaMos(this.getSesion());

		Sujeto sujeto = Sujeto.findByOid(dsFactCab.getInteger("oid_cliente"),
				getSesion());
		java.util.Date fecEmision = dsFactCab.getDate("fec_emision");

		CalculadorFactura calcFactura = new CalculadorFactura(this.getSesion());

		if (((dsFactCab.containstAttribute("senia"))
				&& (dsFactCab.getMoney("senia") != null)
				&& (dsFactCab.getMoney("senia").doubleValue() > 0) && (dsFactCab
				.getString("tipo_oper_factu").equals("FACT_ANT")))) {
			calcFactura.setSenia(dsFactCab.getMoney("senia"));
			calcFactura.setCalcSaldoPendPagoPorSenia(true);
		} else {
			calcFactura.setSenia(new Money(0));
			calcFactura.setCalcSaldoPendPagoPorSenia(false);
		}
		calcFactura.setFecha(fecEmision);
		calcFactura.setSujeto(sujeto);
		calcFactura.setProvincia(provincia);
		calcFactura.setCotizacion(dsFactCab.getCotizacion("cotizacion"));
		dsFactDet.first();
		while (!dsFactDet.EOF()) {

			if (dsFactDet.getBoolean("activo").booleanValue() == false) {
				dsFactDet.next();
				continue;
			}

			if (dsFactDet.getInteger("oid_art") == null) {
				dsFactDet.next();
				continue;
			}
			
			CalculadorItemFactura itemFactura = calcFactura.addItemFact();
			if (dsFactDet.containstAttribute("oid_cco_det"))
				itemFactura.setOidDet(dsFactDet.getInteger("oid_cco_det"));
			else if (dsFactDet.containstAttribute("oid_ped_det"))
				itemFactura.setOidDet(dsFactDet.getInteger("oid_ped_det"));
			else if (dsFactDet.containstAttribute("oid_presu_det"))
				itemFactura.setOidDet(dsFactDet.getInteger("oid_presu_det"));

			itemFactura.setCantidad(dsFactDet.getMoney("cantidad"));

			if (dsFactDet.containstAttribute("precio_factura"))
				itemFactura.setPrecio(dsFactDet.getMoney("precio_factura"));
			else
				itemFactura.setPrecio(dsFactDet.getMoney("precio"));

			itemFactura.setProducto(Producto.findByOidProxy(dsFactDet
					.getInteger("oid_art"), this.getSesion()));

			if (dsFactDet.containstAttribute("bonif1"))
				itemFactura.setPorcBonif1(dsFactDet.getPorcentaje("bonif1"));
			else if (dsFactDet.containstAttribute("porc_bonif_1"))
				itemFactura.setPorcBonif1(dsFactDet
						.getPorcentaje("porc_bonif_1"));
			;

			if (dsFactDet.containstAttribute("bonif2"))
				itemFactura.setPorcBonif2(dsFactDet.getPorcentaje("bonif2"));
			else if (dsFactDet.containstAttribute("porc_bonif_2"))
				itemFactura.setPorcBonif2(dsFactDet
						.getPorcentaje("porc_bonif_2"));
			;

			if (dsFactDet.containstAttribute("bonif3"))
				itemFactura.setPorcBonif3(dsFactDet.getPorcentaje("bonif3"));
			else if (dsFactDet.containstAttribute("porc_bonif_3"))
				itemFactura.setPorcBonif3(dsFactDet
						.getPorcentaje("porc_bonif_3"));
			;

			// itemFactura.setPrecioFactura(dsFactDet.getMoney("precio_factura"));
			// itemFactura.setImporte(dsFactDet.getMoney("importe"));
			// itemFactura.setPrecioNetoBonif()

			ConceptoImpuesto concImpuIVA = ConceptoImpuesto.findByOidProxy(
					dsFactDet.getInteger("oid_conc_imp_iva"), getSesion());
			ConceptoImpuesto concImpuPercIVA = ConceptoImpuesto.findByOidProxy(
					dsFactDet.getInteger("oid_conc_imp_perc_iva"), getSesion());
			ConceptoImpuesto concImpuInterno = ConceptoImpuesto.findByOidProxy(
					dsFactDet.getInteger("oid_conc_imp_int"), getSesion());
			ConceptoImpuesto concImpuPercIB = ConceptoImpuesto.findByOidProxy(
					dsFactDet.getInteger("oid_conc_imp_perc_ib"), getSesion());

			itemFactura.setConcImpuIVA(concImpuIVA);
			itemFactura.setConcImpuPercIVA(concImpuPercIVA);
			itemFactura.setConcImpuImpInt(concImpuInterno);
			itemFactura.setConcImpuPercIB(concImpuPercIB);

			dsFactDet.next();
		}

		calcFactura.calcular();
		IDataSet dataset = calcFactura.enviarDatos();
		IDataSet datasetDet = calcFactura.enviarDatosDet();

		writeCliente(dataset);
		writeCliente(datasetDet);

	}

	private void calcTotFactSinDiscIVA(IDataSet dsFactCab, IDataSet dsFactDet,
			IDataSet dsImpuDet) throws BaseException {
		CalculadorMoney totBruto = new CalculadorMoney(new NumeroBase(0));
		dsFactDet.first();
		while (!dsFactDet.EOF()) {
			totBruto.sumar(dsFactDet.getMoney("importe"));
			dsFactDet.next();
		}

	}

	private void cargarSugProxNro(IDataSet ds, Talonario talonario)
			throws BaseException {
		ds.append();
		ds.fieldValue("oid_talonario", talonario.getOIDInteger());
		ds.fieldValue("proximo_numero",
				talonario.getNro_actual().intValue() + 1);
	}

	private IDataSet getSugProxNro() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProxNroSug");
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("proximo_numero", Field.INTEGER, 0));
		return dataset;
	}

	private IDataSet getFormatoLugEmiNroExt() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFormatoLugEmiNroExt");
		dataset.fieldDef(new Field("lug_emi_nro_ext", Field.STRING, 50));
		return dataset;
	}

	private IDataSet getTotFact() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTotFact");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tot_bruto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("descuento", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_dto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("recargo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_reca", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("iva1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("iva2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("imp_int", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("perc_ib", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("neto", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarTotalFactura(IDataSet dataset, Integer oid,
			Money totalBruto, Money descuento, Porcentaje porcDto,
			Money recargo, Porcentaje porcReca, Money iva1, Money iva2,
			Money impInt, Money percIB, Money neto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("tot_bruto", totalBruto);
		dataset.fieldValue("descuento", descuento);
		dataset.fieldValue("porc_dto", porcDto);
		dataset.fieldValue("recargo", recargo);
		dataset.fieldValue("porc_reca", porcReca);
		dataset.fieldValue("iva1", iva1);
		dataset.fieldValue("iva2", iva2);
		dataset.fieldValue("imp_int", impInt);
		dataset.fieldValue("perc_ib", percIB);
		dataset.fieldValue("neto", neto);
	}

	private void requerimientoListaPrecios(MapDatos mapaDatos)
			throws BaseException {

		Integer oidCliente = mapaDatos.getInteger("oid_cliente");
		java.util.Date fecha = mapaDatos.getDate("fecha");
		IDataSet dsListaPrecios = getDataSetListaPrecios();

		Sujeto sujeto = Sujeto.findByOid(oidCliente, getSesion());
		List listasDePrecios = sujeto.getListasPreciosVigentesMasHab(fecha);
		Iterator iterListaPrecios = listasDePrecios.iterator();
		while (iterListaPrecios.hasNext()) {
			ListaPrecios listaPrecios = (ListaPrecios) iterListaPrecios.next();
			cargarListaPrecios(dsListaPrecios, listaPrecios.getOIDInteger(),
					listaPrecios.getCodigo(), listaPrecios.getDescripcion());
		}
		writeCliente(dsListaPrecios);
	}

	private void requerimientoTiposCliente(MapDatos mapaDatos)
			throws BaseException {
		IDataSet tipoDataSetCliente = getDataSetTiposCliente();
		cargarTipoCliente(tipoDataSetCliente, new Integer(1), "HABITUAL",
				"Habitual");
		cargarTipoCliente(tipoDataSetCliente, new Integer(2), "OCASIONAL",
				"Ocasional");
		writeCliente(tipoDataSetCliente);
	}

	private void requerimientoFechaFacturacion(MapDatos mapaDatos)
			throws BaseException {

		Sucursal sucursal = Sucursal.findByOidProxy(getSesion().getLogin()
				.getOidSucursal(), getSesion());
		FechaFacturacionSucursal fechaFactu = FechaFacturacionSucursal
				.getFechaFacturacion(sucursal, getSesion());
		if (fechaFactu == null)
			throw new ExceptionValidation(null,
					"No se pudo obtener la Fecha de Facturación");
		IDataSet dsFechaFactu = getDataSetFechaFacturacion();
		cargarFechaFacturacion(dsFechaFactu, new Integer(1), fechaFactu
				.getFecha_actual());
		writeCliente(dsFechaFactu);
	}

	private void requerimientoPrecioProducto(MapDatos mapaDatos)
			throws BaseException {

		Integer oid = mapaDatos.getInteger("oid_producto");
		Integer oidLP = mapaDatos.getInteger("oid_lp");
		java.util.Date fecEmision = mapaDatos.getDate("fec_emision");
		Integer oidMoneda = mapaDatos.getInteger("oid_moneda");
		Integer oidSujeto = mapaDatos.getInteger("oid_sujeto");

		if ((oidMoneda == null) || (oidMoneda.intValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar la Moneda");

		if (fecEmision == null)
			throw new ExceptionValidation(null,
					"Debe ingresar la Fecha de Emisión");

		if ((oid == null) || (oid.intValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar un Producto");

		if ((oidSujeto == null) || (oidSujeto.intValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar un cliente");

		if ((oidLP == null) || (oidLP.intValue() == 0))
			throw new ExceptionValidation(null,
					"Debe ingresar una Lista de Precios");

		listaCotizaciones.clear();
		cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));

		Producto producto = Producto.findByOidProxy(oid, getSesion());
		ListaPrecios listaPrecios = ListaPrecios.findByOidProxy(oidLP,
				getSesion());
		Moneda moneda = Moneda.findByOidProxy(oidMoneda, getSesion());
		Sujeto sujeto = Sujeto.findByOidProxy(oidSujeto, getSesion());

		ConceptoImpuesto concImpuestoIVA = producto.getConcImpuIVA(fecEmision);

		if (!listaPrecios.isVigenteAFecha(fecEmision))
			throw new ExceptionValidation(null,
					"La lista de Precios no se encuentra vigente");

		Double porcIVA = new Double(0);
		TasaIVA tasaIVA = producto.getTasaIVA(sujeto, fecEmision);
		if (tasaIVA != null)
			porcIVA = tasaIVA.getPorcentaje();

		ConceptoImpuesto concImpuPercIVA = producto
				.getConcImpuPercIVA(fecEmision);
		ConceptoImpuesto concImpuInternos = producto
				.getConcImpuInterno(fecEmision);
		ConceptoImpuesto concImpuPercIB = producto
				.getConcImpuPercIB(fecEmision);
		ConceptoImpuesto concImpuIVA = producto.getConcImpuIVA(fecEmision);

		Porcentaje porcDto = producto.getPorcDtoProducto(sujeto, null,
				fecEmision);
		listaPrecios.validarPrecioEnLP(producto);

		Money impuIVAProd = new Money(0);
		PrecioEnLP precioListaSinIVA = producto.getPrecioListaSinIVA(
				listaPrecios, null, fecEmision);
		if (precioListaSinIVA != null)
			impuIVAProd = producto.getCalcularIVA(fecEmision, precioListaSinIVA
					.getPrecio());

		Money impuInterno = new Money(0);
		if (precioListaSinIVA != null)
			impuInterno = producto.getCalcImpuInterno(fecEmision,
					precioListaSinIVA.getPrecio());

		PrecioEnLP precioFactura = producto.getPrecioFactura(listaPrecios,
				sujeto, fecEmision);
		PrecioEnLP precioSinIVA = producto.getPrecioListaSinIVA(listaPrecios,
				null, fecEmision);

		IDataSet dsDefPrecioFactArt = getDataSetDefPrecArt();
		IDataSet dataSetImpuestosProductos = getDataSetImpuestosProducto();

		Money precioFact = new Money(0);
		if (precioFactura != null)
			precioFact = precioFactura.getPrecio();

		Money precioSIVA = new Money(0);
		if (precioSinIVA != null)
			precioSIVA = precioSinIVA.getPrecio();

		cargarRegistroPrecioProducto(dsDefPrecioFactArt, listaPrecios,
				producto, moneda, precioSinIVA, precioFact, precioSIVA,
				porcDto, concImpuestoIVA, concImpuPercIVA, concImpuPercIB,
				concImpuInternos);

		cargarImpuProducto(dataSetImpuestosProductos, new Integer(1),
				concImpuIVA, impuIVAProd, Impuesto.CODIGO_IVA, new Porcentaje(
						porcIVA.doubleValue()));

		cargarImpuProducto(dataSetImpuestosProductos, new Integer(2),
				concImpuInternos, impuInterno, Impuesto.CODIGO_IMP_INT,
				new Porcentaje(0));

		writeCliente(dsDefPrecioFactArt);
		writeCliente(dataSetImpuestosProductos);

	}

	private Money getCalcPrecioListaBonif(Money precioLista, Porcentaje bonif)
			throws BaseException {
		if ((bonif == null) || (bonif.doubleValue() == 0))
			return precioLista;
		else {
			CalculadorMoney calcPorc = new CalculadorMoney(bonif);
			calcPorc.dividirPor(new NumeroBase(100));

			CalculadorMoney calcPorcComplemento = new CalculadorMoney(
					new NumeroBase(1));
			calcPorcComplemento.restar(calcPorc.getResultMoney());

			CalculadorMoney precioBonif = new CalculadorMoney(precioLista);
			precioBonif.multiplicarPor(calcPorcComplemento.getResultMoney());

			return precioBonif.getResultMoney();
		}
	}

	private Money calcImpuIVAProducto(Producto producto, java.util.Date fecha,
			Money precio) throws BaseException {
		ConceptoImpuesto concImpIVA = producto.getConcImpuIVA(fecha);
		Money impuestoIVA = null;
		if (concImpIVA != null)
			impuestoIVA = concImpIVA.getCalcImpuesto(fecha, precio);
		else
			impuestoIVA = new Money(0);
		return impuestoIVA;
	}

	private Money calcImpuPercIVAProducto(SujetoImpositivo sujetoImpositivo,
			Producto producto, java.util.Date fecha, Money precio)
			throws BaseException {
		Money impuestoIVA = new Money(0);
		if (sujetoImpositivo == null)
			return new Money(0);
		if (sujetoImpositivo.getCategiva() == null)
			return new Money(0);
		if (sujetoImpositivo.getCategiva().isCalcPercIVA().booleanValue()) {
			ConceptoImpuesto concImpPercIVA = sujetoImpositivo.getCategiva()
					.getConcImpuestoIVA();
			if (concImpPercIVA != null)
				impuestoIVA = concImpPercIVA.getCalcImpuesto(fecha, precio);
			else
				impuestoIVA = new Money(0);
			return impuestoIVA;
		} else
			return impuestoIVA;
	}

	private Money calcPercIB(Producto producto, Date fecha, Money precio,
			Provincia provincia, Sujeto sujeto) throws BaseException {
		ConceptoImpuesto concImpu = producto.getConcImpuPercIB(fecha);

		if (concImpu == null)
			return new Money(0);

		if (sujeto.getSujeto_impositivo() == null)
			return new Money(0);

		if (sujeto.getSujeto_impositivo().getCategib() == null)
			return new Money(0);

		Money impuPercIB = concImpu.getImpuestoPercIB(fecha, provincia, sujeto
				.getSujeto_impositivo().getCategib(), precio);
		return impuPercIB;
	}

	private PrecioEnLP getPrecioProductoEnLP(Producto producto,
			ListaPrecios listaPrecios) throws BaseException {

		PrecioEnLP precio = listaPrecios.getPrecioLista(producto);

		if ((precio == null)
				&& (producto.isPrecioNoDefLP() == false)
				&& (FacturaCab.isPermitirFactVtaMosSinPrecio(this.getSesion()) == false))
			throw new ExceptionValidation(null,
					"No se pudo obtener el Precio para el producto "
							+ producto.getDescripcion()
							+ " y la lista de precios "
							+ listaPrecios.getDescripcion());
		return precio;

	}

	private CategoriaIVA getCategoriaIVA(Sujeto cliente) throws BaseException {
		if (cliente.getSujeto_impositivo() == null)
			throw new ExceptionValidation(null, "El cliente "
					+ cliente.getRazon_social()
					+ " no tiene un sujeto impositivo asociado");
		if (cliente.getSujeto_impositivo().getCategiva() == null)
			throw new ExceptionValidation(null, "El cliente "
					+ cliente.getRazon_social()
					+ " no tiene una categoría de IVA asociada");
		return cliente.getSujeto_impositivo().getCategiva();
	}

	private IDataSet getDataSetPrecioProducto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPrecioProducto");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_lista", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_lista_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_calc_impo", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarPrecioProducto(IDataSet dataset, Integer oid,
			Money precio, Money precioLista, Money precioListaBonif,
			Money precioCalcImporte) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("precio", precio);
		dataset.fieldValue("precio_lista", precioLista);
		dataset.fieldValue("precio_lista_bonif", precioListaBonif);
		dataset.fieldValue("precio_calc_impo", precioCalcImporte);
	}

	private IDataSet getDataSetImpuestosProducto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TImpuProducto");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("impo_impu", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tipo_impuesto", Field.STRING, 20));
		dataset.fieldDef(new Field("porc_impuesto", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarImpuProducto(IDataSet dataset, Integer oid,
			ConceptoImpuesto concImpu, Money importe, String tipoImpuesto,
			Porcentaje porcImpu) throws BaseException {
		if (importe == null)
			return;
		if (importe.doubleValue() == 0)
			return;
		dataset.append();
		dataset.fieldValue("oid", oid);
		if (concImpu != null)
			dataset.fieldValue("oid_conc_impu", concImpu.getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu", new Integer(0));
		dataset.fieldValue("impo_impu", importe);
		dataset.fieldValue("tipo_impuesto", tipoImpuesto);
		dataset.fieldValue("porc_impuesto", porcImpu);
	}

	private void requerimientoFechaCaja(MapDatos mapaDatos)
			throws BaseException {
		IDataSet ds = getDataSetFechaCaja();
		Caja caja = Caja.findByOid(mapaDatos.getInteger("oid_caja"),
				getSesion());
		if (caja.getFechaCaja() == null)
			throw new ExceptionValidation(null,
					"No se pudo obtener la fecha de Caja:"
							+ caja.getDescripcion());
		cargarFechaCaja(ds, new Integer(1), caja.getFechaCaja());
		writeCliente(ds);
	}

	private void requerimientoTiposMovStk(MapDatos mapaDatos)
			throws BaseException {

		IDataSet dataSetTiposConfMov = getTiposConfMov();
		Talonario talonario = Talonario.findByOid(mapaDatos
				.getInteger("oid_talonario"), getSesion());
		String tipoOperFactu = mapaDatos.getString("tipo_facturacion");
		ConfigTalonarioFactClie confTalFactClie = ConfigTalonarioFactClie
				.getConfigTalonarioFactClie(talonario, getSesion());
		if (confTalFactClie == null)
			writeCliente(dataSetTiposConfMov);
		else
			traerTiposMovStk(dataSetTiposConfMov, confTalFactClie,
					tipoOperFactu);
	}
	
	private void requerimientoTiposMovStkSinDesp(MapDatos mapaDatos)
		throws BaseException {
		IDataSet dataSetTiposConfMov = getTiposConfMovAux();
		Talonario talonario = Talonario.findByOid(mapaDatos.getInteger("oid_talonario"), getSesion());
		String tipoOperFactu = mapaDatos.getString("tipo_facturacion");
		ConfigTalonarioFactClie confTalFactClie = ConfigTalonarioFactClie.getConfigTalonarioFactClie(talonario, getSesion());
		if (confTalFactClie == null) {
			writeCliente(dataSetTiposConfMov);
			return;
		}
		else {
			
			Iterator iterOperHab = confTalFactClie.getOperacionesHabilitadas().iterator();
			boolean encontro = false;
			OperHabiTalonarioFactClie operHab = null;
			while (iterOperHab.hasNext()) {
				operHab = (OperHabiTalonarioFactClie) iterOperHab.next();
				if (operHab.getTipo_facturacion().equals(tipoOperFactu)) {
					encontro = true;
					break;
				}
				if (encontro == false) {
					writeCliente(dataSetTiposConfMov);
					return;
				}
				
			}
			
			Iterator iterCompoStkFactClie = operHab.getComportamientosStkFactClie().iterator();
			while (iterCompoStkFactClie.hasNext()) {
				CompoStkTalonarioFactClie compoStkTalFactClie = (CompoStkTalonarioFactClie) iterCompoStkFactClie.next();
				if (compoStkTalFactClie.getTipo_conf_mov().isTipoMovSinDespacho()) {
					dataSetTiposConfMov.append();
					dataSetTiposConfMov.fieldValue("oid_tipo_conf_mov", compoStkTalFactClie.getTipo_conf_mov().getOIDInteger());
					dataSetTiposConfMov.fieldValue("oid_conf_mov_stk", compoStkTalFactClie.getTipo_conf_mov().getConf_mov_stk().getOIDInteger());
					dataSetTiposConfMov.fieldValue("oid_compo_stk_fact", compoStkTalFactClie.getOIDInteger());
					dataSetTiposConfMov.fieldValue("oid_oper_tal_fact", operHab.getOIDInteger());
					dataSetTiposConfMov.fieldValue("usar_por_defecto", compoStkTalFactClie.isUsar_por_defecto());
					dataSetTiposConfMov.fieldValue("codigo", compoStkTalFactClie.getTipo_conf_mov().getCodigo());
					dataSetTiposConfMov.fieldValue("descripcion", compoStkTalFactClie.getTipo_conf_mov().getDescripcion());
					writeCliente(dataSetTiposConfMov);
					return;
				}
				
			}
			
			
			
			
		}
		writeCliente(dataSetTiposConfMov);
		
	}	
	
	private void traerTiposMovStk(IDataSet dataSetTiposConfMov,
			ConfigTalonarioFactClie confTalFactClie, String tipoFacturacion)
			throws BaseException {

		Iterator iterOperHab = confTalFactClie.getOperacionesHabilitadas()
				.iterator();
		boolean encontro = false;
		OperHabiTalonarioFactClie operHab = null;
		while (iterOperHab.hasNext()) {
			operHab = (OperHabiTalonarioFactClie) iterOperHab.next();
			if (operHab.getTipo_facturacion().equals(tipoFacturacion)) {
				encontro = true;
				break;
			}
		}
		if (encontro == false)
			writeCliente(dataSetTiposConfMov);
		else
			traerTiposConfMovStk(dataSetTiposConfMov, operHab);
	}

	private void traerTiposConfMovStk(IDataSet dataSetTiposConfMov,
			OperHabiTalonarioFactClie operHab) throws BaseException {
		if (operHab.getComportamientosStkFactClie().isEmpty())
			writeCliente(dataSetTiposConfMov);
		else {
			Iterator iterCompoStkFactClie = operHab
					.getComportamientosStkFactClie().iterator();
			while (iterCompoStkFactClie.hasNext()) {
				CompoStkTalonarioFactClie compoStkTalFactClie = (CompoStkTalonarioFactClie) iterCompoStkFactClie
						.next();
				if (compoStkTalFactClie.getTipo_conf_mov() == null)
					continue;
				if (compoStkTalFactClie.getTipo_conf_mov().getConf_mov_stk() == null)
					continue;
				cargarTiposConfMov(dataSetTiposConfMov, compoStkTalFactClie
						.getTipo_conf_mov().getOIDInteger(),
						compoStkTalFactClie.getTipo_conf_mov()
								.getConf_mov_stk().getOIDInteger(),
						compoStkTalFactClie.getOIDInteger(), operHab
								.getOIDInteger(), compoStkTalFactClie
								.isUsar_por_defecto(), compoStkTalFactClie
								.getTipo_conf_mov().getCodigo(),
						compoStkTalFactClie.getTipo_conf_mov().getDescripcion());
			}
			writeCliente(dataSetTiposConfMov);
		}
	}

	private void requerimientoTiposOperacionFactu(MapDatos mapaDatos)
			throws BaseException {
		int oid = 0;
		IDataSet dataSetTiposOper = getTiposOperFacturacion();
		Hashtable tipos = TipoOperFacturacion.getTipos();
		Iterator iterTiposOper = tipos.keySet().iterator();
		while (iterTiposOper.hasNext()) {
			String codigo = (String) iterTiposOper.next();
			String descripcion = (String) tipos.get(codigo);
			cargarTiposOperFacturacion(dataSetTiposOper, new Integer(++oid),
					codigo, descripcion);
		}
		writeCliente(dataSetTiposOper);
	}

	private void requerimientoTiposOperacionND(MapDatos mapaDatos)
			throws BaseException {
		int oid = 0;
		IDataSet dataSetTiposOper = getTiposOperFacturacion();
		Hashtable tipos = TipoOperNDFinancieraClie.getTipos();
		Iterator iterTiposOper = tipos.keySet().iterator();
		while (iterTiposOper.hasNext()) {
			String codigo = (String) iterTiposOper.next();
			String descripcion = (String) tipos.get(codigo);
			cargarTiposOperFacturacion(dataSetTiposOper, new Integer(++oid),
					codigo, descripcion);
		}
		writeCliente(dataSetTiposOper);
	}

	private void requerimientoTiposOperacionNC(MapDatos mapaDatos)
			throws BaseException {
		int oid = 0;
		IDataSet dataSetTiposOper = getTiposOperFacturacion();
		Hashtable tipos = TipoOperNCFinancieraClie.getTipos();
		Iterator iterTiposOper = tipos.keySet().iterator();
		while (iterTiposOper.hasNext()) {
			String codigo = (String) iterTiposOper.next();
			String descripcion = (String) tipos.get(codigo);
			cargarTiposOperFacturacion(dataSetTiposOper, new Integer(++oid),
					codigo, descripcion);
		}
		writeCliente(dataSetTiposOper);
	}

	private void requerimientoTiposCompro(MapDatos mapaDatos)
			throws BaseException {
		IDataSet dsTiposCompro = getTiposCompro();
		cargarTipoCompro(dsTiposCompro, new Integer(1),
				IdentificacionTipoComprobante.COMPRO_FACTURA_CLIENTE, "FACTURA");
		cargarTipoCompro(dsTiposCompro, new Integer(2),
				IdentificacionTipoComprobante.COMPRO_ND_CLIENTE, "NOTA DEBITO");
		cargarTipoCompro(dsTiposCompro, new Integer(3),
				IdentificacionTipoComprobante.COMPRO_NC_CLIENTE, "DEVOLUCION");
		writeCliente(dsTiposCompro);
	}

	private IDataSet getTiposCompro() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposCompro");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private void cargarTipoCompro(IDataSet dataset, Integer oid, String codigo,
			String descripcion) {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

	private IDataSet getTiposOperFacturacion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposOperFacturacion");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private void cargarTiposOperFacturacion(IDataSet dataset, Integer oid,
			String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

	private IDataSet getTiposConfMov() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposConfMov");
		dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conf_mov_stk", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_compo_stk_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_oper_tal_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getTiposConfMovAux() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposConfMovAux");
		dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conf_mov_stk", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_compo_stk_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_oper_tal_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	

	private IDataSet getDataSetTiposCliente() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposCliente");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 10));
		return dataset;
	}

	private IDataSet getDataSetFechaFacturacion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFechaFacturacion");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha_facturacion", Field.DATE, 0));
		return dataset;
	}

	private IDataSet getDataSetFechaCaja() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFechaCaja");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha_caja", Field.STRING, 10));
		return dataset;
	}

	private IDataSet getDataSetCajasOperativasHab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCajasOperativas");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private IDataSet getDataSetTalFactClie() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTalFactClie");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc", Field.STRING, 50));
		dataset.fieldDef(new Field("letra", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_automatica", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("disc_iva", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("primer_nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ultimo_nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_actual", Field.INTEGER, 0));
		dataset.fieldDef(new Field("impresora_fiscal", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("driver", Field.STRING, 20));
		dataset.fieldDef(new Field("puerto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("baudios", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_copias", Field.INTEGER, 0));
		return dataset;
	}

	private IDataSet getDataSetListaPrecios() {
		IDataSet dataset = new TDataSet();
		dataset.create("TListaPrecios");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 100));
		return dataset;
	}

	private void cargarCajaOperativa(IDataSet dataset, Integer oid,
			String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

	private void cargarTalFactClie(IDataSet dataset, Talonario talonario,
			Boolean isIVADisc) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", talonario.getOID());
		dataset.fieldValue("codigo", talonario.getCodigo());
		dataset.fieldValue("descripcion", talonario.getDescripcion());
		dataset.fieldValue("oid_tc", talonario.getTipo_comprobante()
				.getOIDInteger());
		dataset.fieldValue("cod_tc", talonario.getTipo_comprobante()
				.getCodigo());
		dataset.fieldValue("letra", talonario.getLetra());
		dataset.fieldValue("oid_lug_emi", talonario.getLugar_emision()
				.getOIDInteger());
		dataset.fieldValue("nro_lug_emi", talonario.getLugar_emision()
				.getLugemi());
		dataset.fieldValue("nro_automatica", talonario.isNro_automatica());
		dataset.fieldValue("disc_iva", isIVADisc);
		dataset.fieldValue("primer_nro", talonario.getPrimer_nro());
		dataset.fieldValue("ultimo_nro", talonario.getUltimo_nro());
		dataset.fieldValue("nro_actual", talonario.getNro_actual());

		if (talonario.getImpresora_fiscal() != null) {

			if (talonario.isUsaImpresoraFiscal())
				dataset.fieldValue("impresora_fiscal", new Boolean(true));
			else
				dataset.fieldValue("impresora_fiscal", new Boolean(false));
			if (talonario.getImpresora_fiscal() != null) {
				dataset.fieldValue("driver", talonario.getImpresora_fiscal()
						.getDriver());
				dataset.fieldValue("puerto", talonario.getImpresora_fiscal()
						.getPuerto());
				dataset.fieldValue("baudios", talonario.getImpresora_fiscal()
						.getBaudios());
			} else {
				dataset.fieldValue("driver", "");
				dataset.fieldValue("puerto", 0);
				dataset.fieldValue("baudios", 0);
			}
		} else {
			dataset.fieldValue("impresora_fiscal", new Boolean(false));
			dataset.fieldValue("driver", "");
			dataset.fieldValue("puerto", 0);
			dataset.fieldValue("baudios", 0);
		}
		dataset.fieldValue("cant_copias", talonario.getCantCopias());

	}

	private void cargarFechaFacturacion(IDataSet dataset, Integer oid,
			java.util.Date fecha) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("fecha_facturacion", Fecha.getddmmyyyy(fecha));
	}

	private void cargarFechaCaja(IDataSet dataset, Integer oid,
			java.util.Date fecha) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("fecha_caja", Fecha.getddmmyyyy(fecha));
	}

	private void cargarTipoCliente(IDataSet dataset, Integer oid,
			String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

	private void cargarListaPrecios(IDataSet dataset, Integer oid,
			String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", new Boolean(true));
	}

	private void cargarTiposConfMov(IDataSet dataset, Integer oidTipoConfMov,
			Integer oidConfMovStk, Integer oidCompoStkFact,
			Integer oidOperTalFact, Boolean usarPorDefecto, String codigo,
			String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_tipo_conf_mov", oidTipoConfMov);
		dataset.fieldValue("oid_conf_mov_stk", oidConfMovStk);
		dataset.fieldValue("oid_compo_stk_fact", oidCompoStkFact);
		dataset.fieldValue("oid_oper_tal_fact", oidOperTalFact);
		dataset.fieldValue("usar_por_defecto", usarPorDefecto);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

	private void cargarCotizaciones(IDataSet dsCotizaciones)
			throws BaseException {
		dsCotizaciones.first();
		while (!dsCotizaciones.EOF()) {
			listaCotizaciones.put(dsCotizaciones.getInteger("oid_moneda"),
					dsCotizaciones.getCotizacion("cotizacion"));
			dsCotizaciones.next();
		}
	}

	private ValorCotizacion getValorCotizacion(Moneda moneda)
			throws BaseException {
		if (moneda.isMonedaCursoLegal())
			return new ValorCotizacion(1.0);
		ValorCotizacion valorCotizacion = (ValorCotizacion) listaCotizaciones
				.get(moneda.getOIDInteger());
		if (valorCotizacion == null)
			throw new ExceptionValidation(null,
					"No se pudo encontrar cotización para la moneda "
							+ moneda.getDescripcion());
		return valorCotizacion;
	}

	public void setValorCotizacion(Moneda moneda, ValorCotizacion valorCotiz)
			throws BaseException {
		listaCotizaciones.put(moneda.getOIDInteger(), valorCotiz);
	}

	private IDataSet getDataSetDefPrecArt() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPrecioArticulo");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_vta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_pl", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_lista", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_sugerido", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_factura", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_perc_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_imp_perc_ib", Field.INTEGER, 0));

		return dataset;
	}

	private void cargarRegistroPrecioProducto(IDataSet dataset,
			ListaPrecios lp, Producto producto, Moneda moneda,
			PrecioEnLP precioEnLP, Money precioFactura, Money precioSinIVA,
			Porcentaje porcDto, ConceptoImpuesto concImpuIVA,
			ConceptoImpuesto concImpuPercIVA, ConceptoImpuesto concImpuPercIB,
			ConceptoImpuesto concImpInt) throws BaseException {

		if (producto.getUm_vta() == null)
			throw new ExceptionValidation(null,
					"Falta Definir una unidad de Venta para el producto "
							+ producto.getCodigo() + " - "
							+ producto.getDescripcion());

		if (lp == null)
			throw new ExceptionValidation(null,
					"Falta ingresar una lista de Precios");

		if ((precioEnLP == null)
				&& (producto.isPrecioNoDefLP() == false)
				&& (FacturaCab.isPermitirFactVtaMosSinPrecio(this.getSesion()) == false))
			throw new ExceptionValidation(null,
					"Falta definir precio para el producto "
							+ producto.getCodigo() + " - "
							+ producto.getDescripcion()
							+ " en la lista de Precios " + lp.getDescripcion()
							+ " en la unidad de venta "
							+ producto.getUm_vta().getDescripcion());

		dataset.append();
		dataset.fieldValue("oid", 1);
		dataset.fieldValue("oid_um_vta", producto.getUm_vta().getOID());
		if (precioEnLP != null) {
			dataset.fieldValue("oid_um_pl", precioEnLP.getUm().getOID());
			dataset.fieldValue("cantidad", precioEnLP.getCantidad());
		} else {
			dataset.fieldValue("oid_um_pl", producto.getUm_vta()
					.getOIDInteger());
			dataset.fieldValue("cantidad", new Integer(1));
		}

		Money precioLista = null;
		if (precioEnLP != null)
			precioLista = Cotizacion.convertir(precioSinIVA,
					getValorCotizacion(precioEnLP.getMoneda()),
					getValorCotizacion(moneda));
		else
			precioLista = new Money(0);

		CalculadorMoney calcPrecioUnitario = new CalculadorMoney(precioLista);
		if (precioEnLP != null)
			calcPrecioUnitario.dividirPor(new Money(precioEnLP.getCantidad()
					.doubleValue()));
		dataset.fieldValue("precio_lista", calcPrecioUnitario.getResultMoney());
		if (porcDto != null)
			dataset.fieldValue("porc_bonif1", porcDto.doubleValue());
		else
			dataset.fieldValue("porc_bonif1", 0);
		dataset.fieldValue("precio_sugerido", precioLista);
		dataset.fieldValue("precio_factura", precioFactura);
		if (precioEnLP != null)
			dataset.fieldValue("oid_moneda", precioEnLP.getMoneda()
					.getOIDInteger());
		else
			dataset.fieldValue("oid_moneda", Moneda.getMonedaCursoLegal(
					this.getSesion()).getOIDInteger());
		if (concImpuIVA != null)
			dataset.fieldValue("oid_conc_imp_iva", concImpuIVA.getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_iva", new Integer(0));
		if (concImpuPercIB != null)
			dataset.fieldValue("oid_conc_imp_perc_iva", concImpuPercIB
					.getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
		if (concImpInt != null)
			dataset.fieldValue("oid_conc_imp_int", concImpInt.getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_int", new Integer(0));
		if (concImpuPercIB != null)
			dataset.fieldValue("oid_conc_imp_perc_ib", concImpuPercIB
					.getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_perc_ib", new Integer(0));

	}

	private IDataSet getDataSetPedidoCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPedidoCab");
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
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
		dataset.fieldDef(new Field("impre_perc_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_imp_internos", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_perc_ib", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_contacto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nom_y_ape_contacto", Field.STRING, 200));

		dataset.fieldDef(new Field("oid_conc_impu_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_ib", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu_int", Field.INTEGER, 0));

		dataset.fieldDef(new Field("oid_cco_presu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_presu", Field.INTEGER, 0));

		return dataset;
	}

	private IDataSet getDataSetPedidoDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPedidoDet");
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
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
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("bonif1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("bonif2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("bonif3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("fec_entrega", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_conc_imp_iva", Field.INTEGER, 0));
		;
		dataset.fieldDef(new Field("oid_conc_imp_perc_iva", Field.INTEGER, 0));
		;
		dataset.fieldDef(new Field("oid_conc_imp_int", Field.INTEGER, 0));
		;
		dataset.fieldDef(new Field("oid_conc_imp_perc_ib", Field.INTEGER, 0));
		;
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		;

		return dataset;
	}

}
