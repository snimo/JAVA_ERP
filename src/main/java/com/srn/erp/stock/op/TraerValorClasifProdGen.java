package com.srn.erp.stock.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.PrecioCompraPorClasifArt;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Precio;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.TasaIVA;
import com.srn.erp.stock.bm.ConceptoImpuestoProducto;
import com.srn.erp.stock.bm.CostoProductoGral;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.FactConvProdGral;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.stock.bm.SeguimientoStock;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ConfProdGralPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PrecioPorEstrucLP;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValorClasifProdGen extends Operation {

	HashTableDatos preciosCompra = new HashTableDatos();
	HashTableDatos listaCotiz = null;

	public TraerValorClasifProdGen() {
	}

	private int oid = -1;

	public static String NICKNAME = "ge.ValorClasifEntProdGen";

	public void execute(MapDatos mapaDatos) throws BaseException {

		listaCotiz = this.getListaCotizaciones();

		if (mapaDatos.containsKey("iniClasifProdStock")) {
			iniClasifProdStock(mapaDatos);
			return;
		}

		if (mapaDatos.containsKey("inicializarClasificadores")) {
			inicializarClasif(mapaDatos);
			return;
		}

		ClasificadorEntidad clasifEnt = Producto.getClasifProductoGeneral(this.getSesion());
		ValorClasifEntProdGen valor = null;

		Integer oid = mapaDatos.getInteger("oid");
		valor = ValorClasifEntProdGen.findByOid(oid, this.getSesion());

		IDataSet ds = this.getDataSet();
		IDataSet dsProdProv = this.getDataProdProv();
		IDataSet dsExtension = this.getDataSetExtProdGral();
		IDataSet dsCostos = getDataSetCostoProductoGral();
		IDataSet dsConfPrecios = getDataSetConfProdGralPorLP();
		IDataSet dsValoresClasif = getDataSetValClasif();
		IDataSet dsFactConv = getDataSetFactConvProdGral();
		IDataSet dsProdStock = this.getDataSetProdStock();
		IDataSet dsValesClasifProdStock = getDataSetValClasifProdStock();
		IDataSet dsSeguiStock = getDataSetSeguiStock();
		IDataSet dsConcImpu = getDataSetConceptoImpuestoProducto();

		cargarRegistroValClasif(ds, valor);

		Iterator iterProdProv = ProductoProveedor.getProductosProveedor(valor.getClasificador_entidad(), valor, this.getSesion())
				.iterator();

		cargarPreciosCompra(valor);

		while (iterProdProv.hasNext()) {
			ProductoProveedor prodProv = (ProductoProveedor) iterProdProv.next();
			cargarRegistroProdProv(dsProdProv, prodProv);
		}

		if (valor.getExtensionProdGen() != null)
			cargarRegistroExtension(dsExtension, valor.getExtensionProdGen());

		Iterator iterCostos = valor.getCostosProductosGeneral().iterator();
		while (iterCostos.hasNext()) {
			CostoProductoGral costo = (CostoProductoGral) iterCostos.next();
			cargarRegistroCostoProdGral(dsCostos, costo);
		}

		CostoProductoGral costoProducto = valor.getExtensionProdGen().getCosto(Fecha.getFechaActual());
		Iterator iterLP = ListaPrecios.getTodasLasListas(this.getSesion()).iterator();
		while (iterLP.hasNext()) {
			Money porcRentSug = new Money(0);
			ListaPrecios lp = (ListaPrecios) iterLP.next();
			ConfProdGralPorLP confProdPorLP = ConfProdGralPorLP.getConfProdPorLP(valor, lp, this.getSesion());
			if (confProdPorLP != null)
				porcRentSug = confProdPorLP.getPorc_rent_sug();
			cargarRegistroConfPorLP(dsConfPrecios, costoProducto, valor, lp, porcRentSug);
		}

		Iterator iterFactConv = FactConvProdGral.getFactoresConv(valor, getSesion()).iterator();
		while (iterFactConv.hasNext()) {
			FactConvProdGral factConvProdGral = (FactConvProdGral) iterFactConv.next();
			cargarRegistroFactConv(dsFactConv, factConvProdGral);
		}

		Iterator iterProductos = valor.getProductos().iterator();
		while (iterProductos.hasNext()) {
			Producto producto = (Producto) iterProductos.next();
			cargarRegProdStock(dsProdStock, producto);
			traerValoresDatosClasif(dsValesClasifProdStock, producto);
		}

		Iterator iterSeguiStock = valor.getSeguimientosStock().iterator();
		while (iterSeguiStock.hasNext()) {
			SeguimientoStock seguiStock = (SeguimientoStock) iterSeguiStock.next();
			cargarRegSeguiStock(dsSeguiStock, seguiStock);
		}

		Iterator iterConcImpu = valor.getConceptosImpuestos().iterator();
		while (iterConcImpu.hasNext()) {
			ConceptoImpuestoProducto concImpuProd = (ConceptoImpuestoProducto) iterConcImpu.next();
			cargarRegConcImpuProd(dsConcImpu, concImpuProd);
		}

		traerValoresDatosClasif(dsValoresClasif, valor);

		writeCliente(ds);
		writeCliente(dsProdProv);
		writeCliente(dsExtension);
		writeCliente(dsCostos);
		writeCliente(dsConfPrecios);
		writeCliente(dsValoresClasif);
		writeCliente(dsFactConv);
		writeCliente(dsProdStock);
		writeCliente(dsValesClasifProdStock);
		writeCliente(dsSeguiStock);
		writeCliente(dsConcImpu);

	}

	private void cargarRegistroCostoProdGral(IDataSet dataset, CostoProductoGral costo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_costo_prodgral", costo.getOIDInteger());
		dataset.fieldValue("oid_val_clasif_ent", costo.getVal_clasif_ent().getOIDInteger());
		dataset.fieldValue("oid_clasif_ent", costo.getVal_clasif_ent().getClasificador_entidad().getOIDInteger());
		dataset.fieldValue("fec_ult_costo", costo.getFec_ult_costo());
		dataset.fieldValue("oid_moneda", costo.getMoneda().getOIDInteger());
		dataset.fieldValue("cantidad", costo.getCantidad());
		dataset.fieldValue("oid_um", costo.getUm().getOIDInteger());
		dataset.fieldValue("costo", costo.getCosto());
		dataset.fieldValue("activo", costo.isActivo());
	}

	private void cargarRegistroExtension(IDataSet dsExtension, ExtensionProdGen extensionProd) throws BaseException {
		dsExtension.append();
		if (extensionProd != null) {
			dsExtension.fieldValue("oid_extension_pg", extensionProd.getOIDInteger());
			dsExtension.fieldValue("oid_val_clasif_ent", extensionProd.getValor_clasif_ent().getOIDInteger());
			dsExtension.fieldValue("oid_clasif_ent", extensionProd.getValor_clasif_ent().getClasificador_entidad().getOIDInteger());
			ConcFactProv concFactProv = extensionProd.getConc_fact_prov();
			if (concFactProv != null) {
				dsExtension.fieldValue("oid_conc_fact_prov", concFactProv.getOIDInteger());
				dsExtension.fieldValue("cod_conc_fact_prov", concFactProv.getCodigo());
				dsExtension.fieldValue("desc_conc_fact_prov", concFactProv.getDescripcion());
			} else {
				dsExtension.fieldValue("oid_conc_fact_prov", new Integer(0));
				dsExtension.fieldValue("cod_conc_fact_prov", "");
				dsExtension.fieldValue("desc_conc_fact_prov", "");
			}

			if (extensionProd.getUMVta() != null)
				dsExtension.fieldValue("oid_um_vtas", extensionProd.getUMVta().getOIDInteger());
			else
				dsExtension.fieldValue("oid_um_vtas", new Integer(0));

			if (extensionProd.getUMProd() != null)
				dsExtension.fieldValue("oid_um_prod", extensionProd.getUMProd().getOIDInteger());
			else
				dsExtension.fieldValue("oid_um_prod", new Integer(0));

			if (extensionProd.getUMCompra() != null)
				dsExtension.fieldValue("oid_um_compra", extensionProd.getUMCompra().getOIDInteger());
			else
				dsExtension.fieldValue("oid_um_compra", new Integer(0));
			dsExtension.fieldValue("lt_entrega", extensionProd.getLTEntrega());
			dsExtension.fieldValue("prec_no_def_lp", extensionProd.isPrecioNoDefEnLP());
			dsExtension.fieldValue("modif_prec_fact", extensionProd.isModifPrecioFact());
			dsExtension.fieldValue("cant_dec_precio", extensionProd.getCantDecPrecio());

			if (extensionProd.getTipoProducto() != null)
				dsExtension.fieldValue("oid_tipo_prod", extensionProd.getTipoProducto().getOIDInteger());
			else
				dsExtension.fieldValue("oid_tipo_prod", new Integer(0));
			dsExtension.fieldValue("comprable", extensionProd.isComprable());
			dsExtension.fieldValue("vendible", extensionProd.isVendible());
			dsExtension.fieldValue("stockeable", extensionProd.isStockeable());
			dsExtension.fieldValue("prod_propia", extensionProd.isProdPropia());
			dsExtension.fieldValue("importado", extensionProd.isImportado());

			if (extensionProd.getUMStockPpal() != null)
				dsExtension.fieldValue("oid_um_stock_ppal", extensionProd.getUMStockPpal().getOIDInteger());
			else
				dsExtension.fieldValue("oid_um_stock_ppal", new Integer(0));
			if (extensionProd.getUMStockAlt() != null)
				dsExtension.fieldValue("oid_um_stock_alt", extensionProd.getUMStockAlt().getOIDInteger());
			else
				dsExtension.fieldValue("oid_um_stock_alt", new Integer(0));
			dsExtension.fieldValue("lleva_serie", extensionProd.isLlevaSerie());
			dsExtension.fieldValue("lleva_partida", extensionProd.isLlevaPartida());
			dsExtension.fieldValue("segui_stock", extensionProd.isSeguiStock());

			dsExtension.fieldValue("es_sal_fact_senia", extensionProd.isSaldoFacturaSenia());
			dsExtension.fieldValue("es_senia", extensionProd.isSenia());
			if (extensionProd.getCuentaImputableVentas() != null) {
				dsExtension.fieldValue("oid_impu_vta", extensionProd.getCuentaImputableVentas().getOID());
				dsExtension.fieldValue("cod_impu_vta", extensionProd.getCuentaImputableVentas().getCodigoCuentaMasCodigosValCompo());
				dsExtension.fieldValue("desc_impu_vta", extensionProd.getCuentaImputableVentas().getDescCuentaMasDescValCompo());
			} else {
				dsExtension.fieldValue("oid_impu_vta", new Integer(0));
				dsExtension.fieldValue("cod_impu_vta", "");
				dsExtension.fieldValue("desc_impu_vta", "");
			}

			dsExtension.fieldValue("hab_nd_int", extensionProd.isHabNDInt());
			dsExtension.fieldValue("hab_nc_int", extensionProd.isHabNCInt());

			dsExtension.fieldValue("calc_perc_ib_cf", extensionProd.isSuscPercIBCapFed());
			dsExtension.fieldValue("calc_perc_ib_ba", extensionProd.isSuscPercIBBsAs());
			dsExtension.fieldValue("calc_perc_iva", extensionProd.isSuscPercIVA());

			dsExtension.fieldValue("sistema_calidad", extensionProd.isSistemaCalidad());

			dsExtension.fieldValue("porc_cump_oc", extensionProd.getPorcCumpOC());
			if (extensionProd.getCuentaCompras() != null) {
				dsExtension.fieldValue("oid_cuenta_compras", extensionProd.getCuentaCompras().getOIDInteger());
				dsExtension.fieldValue("cod_cuenta_compras", extensionProd.getCuentaCompras().getCodigo());
				dsExtension.fieldValue("desc_cuenta_compras", extensionProd.getCuentaCompras().getDescripcion());
			} else {
				dsExtension.fieldValue("oid_cuenta_compras", new Integer(0));
				dsExtension.fieldValue("cod_cuenta_compras", "");
				dsExtension.fieldValue("desc_cuenta_compras", "");
			}

			dsExtension.fieldValue("porc_tol_recep", extensionProd.getPorcTolRecep());
			dsExtension.fieldValue("lt_entrega_prov", extensionProd.getLTEntregaProv());

			dsExtension.fieldValue("tomar_precio_oc_1", extensionProd.getTomarPrecioOC1());
			dsExtension.fieldValue("tomar_precio_oc_2", extensionProd.getTomarPrecioOC2());
			dsExtension.fieldValue("tomar_precio_oc_3", extensionProd.getTomarPrecioOC3());
			dsExtension.fieldValue("tomar_precio_oc_4", extensionProd.getTomarPrecioOC4());

			dsExtension.fieldValue("forma_calc_costo", extensionProd.getFormaCalcCosto());
			if (extensionProd.getProveedorCosto() != null) {
				dsExtension.fieldValue("oid_prov_costo", extensionProd.getProveedorCosto().getOIDInteger());
				dsExtension.fieldValue("cod_prov_costo", extensionProd.getProveedorCosto().getCodigo());
				dsExtension.fieldValue("desc_prov_costo", extensionProd.getProveedorCosto().getDescripcion());
			} else {
				dsExtension.fieldValue("oid_prov_costo", 0);
				dsExtension.fieldValue("cod_prov_costo", "");
				dsExtension.fieldValue("desc_prov_costo", "");
			}
			dsExtension.fieldValue("como_obtener_costo", extensionProd.getComoObtenerCosto());

		}
	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValorClasificador");
		dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetExtProdGral() {
		IDataSet dataset = new TDataSet();
		dataset.create("TExtensionProdGral");
		dataset.fieldDef(new Field("oid_extension_pg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_fact_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_conc_fact_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_conc_fact_prov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_um_vtas", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lt_entrega", Field.INTEGER, 0));
		dataset.fieldDef(new Field("prec_no_def_lp", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("modif_prec_fact", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cant_dec_precio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("vendible", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("stockeable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("prod_propia", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("importado", Field.BOOLEAN, 0));

		dataset.fieldDef(new Field("oid_um_stock_ppal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_stock_alt", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lleva_serie", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("lleva_partida", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("segui_stock", Field.BOOLEAN, 0));

		dataset.fieldDef(new Field("es_sal_fact_senia", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("es_senia", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_impu_vta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_impu_vta", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_impu_vta", Field.STRING, 255));
		dataset.fieldDef(new Field("hab_nd_int", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("hab_nc_int", Field.BOOLEAN, 0));

		dataset.fieldDef(new Field("calc_perc_ib_cf", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("calc_perc_ib_ba", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("calc_perc_iva", Field.BOOLEAN, 0));

		dataset.fieldDef(new Field("sistema_calidad", Field.BOOLEAN, 0));

		dataset.fieldDef(new Field("porc_cump_oc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_cuenta_compras", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_cuenta_compras", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_cuenta_compras", Field.STRING, 100));
		dataset.fieldDef(new Field("porc_tol_recep", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("lt_entrega_prov", Field.INTEGER, 0));

		dataset.fieldDef(new Field("tomar_precio_oc_1", Field.STRING, 20));
		dataset.fieldDef(new Field("tomar_precio_oc_2", Field.STRING, 20));
		dataset.fieldDef(new Field("tomar_precio_oc_3", Field.STRING, 20));
		dataset.fieldDef(new Field("tomar_precio_oc_4", Field.STRING, 20));

		dataset.fieldDef(new Field("forma_calc_costo", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_prov_costo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov_costo", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_prov_costo", Field.STRING, 100));
		dataset.fieldDef(new Field("como_obtener_costo", Field.STRING, 100));

		return dataset;
	}

	private IDataSet getDataProdProv() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProductoProveedor");
		dataset.fieldDef(new Field("oid_prod_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_prod_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_cpra", Field.INTEGER, 50));
		dataset.fieldDef(new Field("lote_minimo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("multiplo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("lt_ent_dias", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("prioridad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_acuerdo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("costo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_vig", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_precio_clasif", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroProdProv(IDataSet dataset, ProductoProveedor prodProv) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_prod_prov", prodProv.getOIDInteger());
		dataset.fieldValue("oid_clasif", prodProv.getClasifProdGeneral().getOIDInteger());
		dataset.fieldValue("oid_val_clasif", prodProv.getValClasifProdGeneral().getOIDInteger());
		dataset.fieldValue("oid_proveedor", prodProv.getProveedor().getOIDInteger());
		dataset.fieldValue("codigo_proveedor", prodProv.getProveedor().getCodigo());
		dataset.fieldValue("rs_proveedor", prodProv.getProveedor().getRazonsocial());
		dataset.fieldValue("cod_prod_prov", prodProv.getCod_prod_prov());
		if (prodProv.getUmcpra() != null)
			dataset.fieldValue("oid_um_cpra", prodProv.getUmcpra().getOIDInteger());
		else
			dataset.fieldValue("oid_um_cpra", new Integer(0));

		dataset.fieldValue("lote_minimo", prodProv.getLote_minimo());
		dataset.fieldValue("multiplo", prodProv.getMultiplo());
		dataset.fieldValue("activo", true);
		dataset.fieldValue("lt_ent_dias", prodProv.getLt_ent_dias());
		dataset.fieldValue("orden", new Integer(0));
		dataset.fieldValue("prioridad", prodProv.getPrioridadCompra());
		if (prodProv.getTipoAcuerdo() != null)
			dataset.fieldValue("oid_tipo_acuerdo", prodProv.getTipoAcuerdo().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_acuerdo", "");

		// Obtener el Ultimo precio de compra

		//PrecioCompraPorClasifArt precioCompra = getPrecioCompraBy(prodProv.getTipoAcuerdo(), prodProv.getProveedor());
		
		PrecioCompraPorClasifArt precioCompra = PrecioCompraPorClasifArt.getPrecioCompraPorClasifArt(prodProv, this.getSesion());

		if (precioCompra != null) {
			dataset.fieldValue("oid_moneda", precioCompra.getMoneda().getOIDInteger());
			dataset.fieldValue("costo", precioCompra.getPrecio());
			dataset.fieldValue("fec_vig", precioCompra.getFechaVigencia());
			dataset.fieldValue("oid_precio_clasif", precioCompra.getOIDInteger());
		} else {
			dataset.fieldValue("oid_moneda", "");
			dataset.fieldValue("costo", "");
			dataset.fieldValue("fec_vig", "");
			dataset.fieldValue("oid_precio_clasif", "");
		}

	}

	private void cargarRegistroValClasif(IDataSet dataset, ValorClasificadorEntidad valClasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_val_clasif", valClasifEnt.getOIDInteger());
		dataset.fieldValue("codigo", valClasifEnt.getCodigo());
		dataset.fieldValue("descripcion", valClasifEnt.getDescripcion());
		dataset.fieldValue("activo", valClasifEnt.isActivo());
	}

	private IDataSet getDataSetCostoProductoGral() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TCostosProdGral");
		dataset.fieldDef(new Field("oid_costo_prodgral", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_ult_costo", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("costo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetConfProdGralPorLP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConfProdGralPorLP");
		dataset.fieldDef(new Field("oid_conf_prod_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_lista_precio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_lista_precio", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("porc_rent_sug", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));

		dataset.fieldDef(new Field("fec_ult_costo", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_moneda_costo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_costo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_costo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("costo", Field.CURRENCY, 0));

		dataset.fieldDef(new Field("fec_ult_pv", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_moneda_pv", Field.DATE, 0));
		dataset.fieldDef(new Field("cant_pv", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_pv", Field.INTEGER, 0));
		dataset.fieldDef(new Field("precio_venta", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_venta_con_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_rent_actual", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nuevo_porc_rent", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nuevo_precio_vta", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cod_lista_precio", Field.STRING, 50));

		return dataset;
	}

	private void cargarRegistroConfPorLP(
			IDataSet dataset, 
			CostoProductoGral costoProducto, 
			ValorClasifEntProdGen valor,
			ListaPrecios listaPrecios, 
			Money porcRent) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_conf_prod_lp", listaPrecios.getOID() * -1);
		dataset.fieldValue("oid_lista_precio", listaPrecios.getOIDInteger());
		dataset.fieldValue("desc_lista_precio", listaPrecios.getDescripcion());
		dataset.fieldValue("oid_clasif_ent", valor.getClasificador_entidad().getOIDInteger());
		dataset.fieldValue("porc_rent_sug", porcRent);
		dataset.fieldValue("oid_val_clasif_ent", valor.getOIDInteger());

		List listaPrecioPorEstrucLP = PrecioPorEstrucLP.getConsultaMasivaProductos(
				listaPrecios, 
				valor.getOIDInteger(), null, null, null,
				null, false, true, false, false, false, null, this.getSesion());
		
		PrecioPorEstrucLP lpDet = null;
		java.util.Date fechaActual = Fecha.getFechaDiaPosterior(Fecha.getFechaActual());
		Iterator iterListaPrecioVig = 
			listaPrecioPorEstrucLP.iterator();
		while (iterListaPrecioVig.hasNext()) {
			PrecioPorEstrucLP precioPorEstrucLP = (PrecioPorEstrucLP) iterListaPrecioVig.next();
			if (precioPorEstrucLP.getFecUltAct().before(fechaActual)) {
				if (lpDet == null)
					lpDet = precioPorEstrucLP;
				else {
					if (lpDet.getFecUltAct().before(precioPorEstrucLP.getFecUltAct()))
						lpDet = precioPorEstrucLP;
				}
			}
			
		}
		
		if (costoProducto != null) {
			dataset.fieldValue("fec_ult_costo", costoProducto.getFec_ult_costo());
			dataset.fieldValue("oid_moneda_costo", costoProducto.getMoneda().getOIDInteger());
			dataset.fieldValue("cant_costo", costoProducto.getCantidad());
			dataset.fieldValue("oid_um_costo", costoProducto.getUm().getOIDInteger());
			Money costo = costoProducto.getCosto();
			dataset.fieldValue("costo", costo);
		} else {
			dataset.fieldValue("fec_ult_costo", Fecha.FECHA_NULA());
			dataset.fieldValue("oid_moneda_costo", Moneda.getMonedaDefaultCostoProducto(this.getSesion()).getOIDInteger());
			dataset.fieldValue("cant_costo", new Money(1));
			if (valor.getExtensionProdGen().getUMCompra() != null)
				dataset.fieldValue("oid_um_costo", valor.getExtensionProdGen().getUMCompra().getOIDInteger());
			else
				dataset.fieldValue("oid_um_costo", Moneda.getMonedaDefaultCostoProducto(this.getSesion()).getOIDInteger());
			Money costo = new Money(0);
			dataset.fieldValue("costo", costo);

		}

		if (lpDet != null) {
			dataset.fieldValue("fec_ult_pv", Fecha.FECHA_NULA());
			dataset.fieldValue("oid_moneda_pv", lpDet.getMoneda().getOIDInteger());
			dataset.fieldValue("cant_pv", lpDet.getCantidad());
			dataset.fieldValue("oid_um_pv", lpDet.getUnidad_medida().getOIDInteger());

			Precio precioSinIVA = lpDet.getValorClasifProdGral().getPrecioSinIVA(lpDet, Fecha.getFechaActual());

			if (precioSinIVA != null)
				dataset.fieldValue("precio_venta", precioSinIVA.getImporte());
			else
				dataset.fieldValue("precio_venta", "");

			Precio precioConIVA = lpDet.getValorClasifProdGral().getPrecioConIVA(lpDet, Fecha.getFechaActual());

			if (precioConIVA != null)
				dataset.fieldValue("precio_venta_con_iva", precioConIVA.getImporte());
			else
				dataset.fieldValue("precio_venta_con_iva", "");

			// Debe tener en cuenta las Monedas y las cantidades

			dataset.fieldValue("porc_rent_actual", getCalcPorcRent(valor.getExtensionProdGen(), costoProducto, lpDet, precioSinIVA.getImporte()));

			ConfProdGralPorLP confProdPorLP = valor.getExtensionProdGen().getConfProdLP(listaPrecios);

			if (confProdPorLP != null)
				dataset.fieldValue("nuevo_porc_rent", confProdPorLP.getPorc_rent_sug());
			else
				dataset.fieldValue("nuevo_porc_rent", new Money(0));

			dataset.fieldValue("nuevo_precio_vta", new Money(0));

			ConceptoImpuestoProducto concImpuProd = lpDet.getValorClasifProdGral().getConcImpuIVAProdVigAFecha(Fecha.getFechaActual());

			if ((concImpuProd != null) && (concImpuProd.getConcepto_impuesto() != null)) {
				TasaIVA tasaIVA = concImpuProd.getConcepto_impuesto().getTasaVigenteIVA(Fecha.getFechaActual(), this.getSesion());
				if (tasaIVA != null)
					dataset.fieldValue("porc_iva", tasaIVA.getPorcentaje());
				else
					dataset.fieldValue("porc_iva", new Money(0));
			} else
				dataset.fieldValue("porc_iva", new Money(0));

		} else {
			dataset.fieldValue("fec_ult_pv", Fecha.FECHA_NULA());

			dataset.fieldValue("oid_moneda_pv", Moneda.getMonedaDefaultPrecioVta(this.getSesion()).getOIDInteger());
			dataset.fieldValue("cant_pv", new Money(1));
			if (valor.getExtensionProdGen().getUMVta() != null)
				dataset.fieldValue("oid_um_pv", valor.getExtensionProdGen().getUMVta().getOIDInteger());
			else {
				UnidadMedida umDefPrecioVta = UnidadMedida.getUMDefaultPrecioVenta(this.getSesion());
				dataset.fieldValue("oid_um_pv", umDefPrecioVta.getOIDInteger());
			}
			dataset.fieldValue("precio_venta", new Money(0));
			dataset.fieldValue("precio_venta_con_iva", new Money(0));
			dataset.fieldValue("porc_rent_actual", new Money(0));

			ConfProdGralPorLP confProdPorLP = valor.getExtensionProdGen().getConfProdLP(listaPrecios);

			if (confProdPorLP != null)
				dataset.fieldValue("nuevo_porc_rent", confProdPorLP.getPorc_rent_sug());
			else
				dataset.fieldValue("nuevo_porc_rent", new Money(0));
			dataset.fieldValue("nuevo_precio_vta", new Money(0));

			ConceptoImpuestoProducto concImpuProd = valor.getExtensionProdGen().getValorClasifProdGral().getConcImpuIVAProdVigAFecha(Fecha.getFechaActual());

			if ((concImpuProd != null) && (concImpuProd.getConcepto_impuesto() != null)) {
				TasaIVA tasaIVA = concImpuProd.getConcepto_impuesto().getTasaVigenteIVA(Fecha.getFechaActual(), this.getSesion());
				if (tasaIVA != null)
					dataset.fieldValue("porc_iva", tasaIVA.getPorcentaje());
				else
					dataset.fieldValue("porc_iva", new Money(0));
			} else
				dataset.fieldValue("porc_iva", new Money(0));

		}
		
		dataset.fieldValue("cod_lista_precio" , listaPrecios.getCodigo());
		
	}

	private void inicializarClasif(MapDatos mapaDatos) throws BaseException {
		IDataSet dsClasifEnt = getDataSetClasificadorEntidad();
		Iterator iterClasifEnt = ExtensionProdGen.getClasificadoresEntidadActivos(getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
			if (Producto.getClasifProductoGeneral(this.getSesion()).getOID() == clasifEnt.getOID())
				continue;

			cargarRegistroClasificadorEntidad(dsClasifEnt, clasifEnt);
		}
		writeCliente(dsClasifEnt);
	}

	private void iniClasifProdStock(MapDatos mapaDatos) throws BaseException {
		IDataSet dsClasifEnt = getDataSetTempValClasifProdStock();
		Integer oidProducto = mapaDatos.getInteger("oid_producto");
		Iterator iterClasifEnt = Producto.getClasificadoresEntidadActivos(getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
			if (Producto.getClasifProductoGeneral(this.getSesion()).getOID() == clasifEnt.getOID())
				continue;
			cargarRegistroClasificadorEntidadProdStock(dsClasifEnt, oidProducto, clasifEnt);
		}
		writeCliente(dsClasifEnt);
	}

	private IDataSet getDataSetClasificadorEntidad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TClasificadorEntidad");
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname", Field.STRING, 30));
		dataset.fieldDef(new Field("obligatorio", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_clasif", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroClasificadorEntidad(IDataSet dataset, ClasificadorEntidad clasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_clasif_ent", clasifEnt.getOIDInteger());
		dataset.fieldValue("codigo", clasifEnt.getCodigo());
		dataset.fieldValue("descripcion", clasifEnt.getDescripcion());
		dataset.fieldValue("nickname", clasifEnt.getNickname());
		dataset.fieldValue("obligatorio", clasifEnt.isObligatorio());
		dataset.fieldValue("activo", clasifEnt.isActivo());
		dataset.fieldValue("nro_clasif", clasifEnt.getNroClasif());
		dataset.fieldValue("oid_grupo_clasif", clasifEnt.getGrupo().getOIDInteger());
		dataset.fieldValue("cod_grupo_clasif", clasifEnt.getGrupo().getCodigo());
		dataset.fieldValue("desc_grupo_clasif", clasifEnt.getGrupo().getDescripcion());

	}

	private void cargarRegistroClasificadorEntidadProdStock(IDataSet dataset, Integer oidProducto, ClasificadorEntidad clasifEnt)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_valor_clasif", --oid);
		dataset.fieldValue("oid_producto", oidProducto);
		dataset.fieldValue("oid_clasif_ent", clasifEnt.getOIDInteger());
		dataset.fieldValue("oid_val_clasif_ent", new Integer(0));
		dataset.fieldValue("nro_clasif", clasifEnt.getNroClasif());
		dataset.fieldValue("desc_grupo_clasif", clasifEnt.getGrupo().getDescripcion());
		dataset.fieldValue("cod_valor", "");
		dataset.fieldValue("desc_valor", "");
		dataset.fieldValue("nickname", Producto.NICKNAME);
		dataset.fieldValue("activo", true);
		dataset.fieldValue("desc_clasificador", clasifEnt.getDescripcion());
	}

	private IDataSet getDataSetValClasif() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresClasifProdGral");
		dataset.fieldDef(new Field("oid_valor_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_padre", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_valor", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_valor", Field.STRING, 100));
		dataset.fieldDef(new Field("nickname", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("desc_clasificador", Field.STRING, 100));

		return dataset;
	}

	private void cargarRegistroFactConv(IDataSet dataset, FactConvProdGral factConvProdGral) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_equiv_pg", factConvProdGral.getOIDInteger());
		dataset.fieldValue("oid_val_clasif_ent", factConvProdGral.getValClasifEnt().getOIDInteger());
		dataset.fieldValue("oid_um_ori", factConvProdGral.getUnidad_origen().getOIDInteger());
		dataset.fieldValue("oid_um_dest", factConvProdGral.getUnidad_destino().getOIDInteger());
		dataset.fieldValue("fact_conv", factConvProdGral.getFact_conv());
		dataset.fieldValue("activo", new Boolean(true));
	}

	private void cargarDSValClasif(IDataSet dataset, Integer oidValorClasif, Integer oid_val_clasif_padre, Integer oidClasifEnt,
			Integer oidValClasifEnt, Integer nroClasif, String descGrupoClasif, String codValor, String descValor, String nickname,
			Boolean activo, String descClasificador) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_valor_clasif", oidValorClasif);
		dataset.fieldValue("oid_val_clasif_padre", oid_val_clasif_padre);
		dataset.fieldValue("oid_clasif_ent", oidClasifEnt);
		dataset.fieldValue("oid_val_clasif_ent", oidValClasifEnt);
		dataset.fieldValue("nro_clasif", nroClasif);
		dataset.fieldValue("desc_grupo_clasif", descGrupoClasif);
		dataset.fieldValue("cod_valor", codValor);
		dataset.fieldValue("desc_valor", descValor);
		dataset.fieldValue("nickname", nickname);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("desc_clasificador", descClasificador);
	}

	private void traerValoresDatosClasif(IDataSet ds, ValorClasifEntProdGen aValor) throws BaseException {
		int oid = 0;
		Iterator iterClasifEnt = ExtensionProdGen.getClasificadoresEntidadActivos(this.getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
			if (Producto.getClasifProductoGeneral(this.getSesion()).getOID() == clasifEnt.getOID())
				continue;

			IValorClasificadorEntidad valClasifEntidad = null;
			if (aValor.getExtensionProdGen() != null)
				valClasifEntidad = aValor.getExtensionProdGen().getValorClasifEnt(clasifEnt);
			if (valClasifEntidad != null)
				cargarDSValClasif(ds, new Integer(++oid), aValor.getOIDInteger(), clasifEnt.getOIDInteger(), new Integer(valClasifEntidad
						.getOID()), clasifEnt.getNroClasif(), clasifEnt.getGrupo().getDescripcion(), valClasifEntidad.getCodigo(),
						valClasifEntidad.getDescripcion(), clasifEnt.getNickname(), new Boolean(true), clasifEnt.getDescripcion());
			else
				cargarDSValClasif(ds, new Integer(++oid), aValor.getOIDInteger(), clasifEnt.getOIDInteger(), new Integer(-1), clasifEnt
						.getNroClasif(), clasifEnt.getGrupo().getDescripcion(), "", "", clasifEnt.getNickname(), new Boolean(true),
						clasifEnt.getDescripcion());
		}

	}

	private void traerValoresDatosClasif(IDataSet ds, Producto aProducto) throws BaseException {
		int oid = 0;
		Iterator iterClasifEnt = aProducto.getClasificadoresEntidadActivos().iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();

			if (Producto.getClasifProductoGeneral(this.getSesion()).getOID() == clasifEnt.getOID())
				continue;

			IValorClasificadorEntidad valClasifEntidad = aProducto.getValorClasifEnt(clasifEnt);
			ValorClasificadorEntidad valClasifEnt = null;
			if (valClasifEntidad != null)
				valClasifEnt = ValorClasificadorEntidad.findByOid(valClasifEntidad.getOID(), this.getSesion());
			cargarDSValClasif(ds, ++oid, aProducto, clasifEnt, valClasifEnt);
		}

	}

	private IDataSet getDataSetFactConvProdGral() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFactConvProdGral");
		dataset.fieldDef(new Field("oid_equiv_pg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_ori", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_dest", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fact_conv", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetProdStock() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProductoStock");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_prod_stock", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prod_stock", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_prod_stock", Field.STRING, 200));
		dataset.fieldDef(new Field("desc_abrev", Field.STRING, 200));
		dataset.fieldDef(new Field("sinonimo", Field.STRING, 50));
		dataset.fieldDef(new Field("codigo_barra", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegProdStock(IDataSet dataset, Producto producto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", producto.getOIDInteger());
		dataset.fieldValue("oid_val_clasif", producto.getValorClasifProdGen().getOIDInteger());
		dataset.fieldValue("oid_prod_stock", producto.getOIDInteger());
		dataset.fieldValue("cod_prod_stock", producto.getCodigo());
		dataset.fieldValue("desc_prod_stock", producto.getDescripcion());
		dataset.fieldValue("desc_abrev", producto.getDesc_abrev());
		dataset.fieldValue("sinonimo", producto.getSinonimo());
		dataset.fieldValue("codigo_barra", producto.getCodigo_barra());
		dataset.fieldValue("activo", producto.isActivo());
	}

	private IDataSet getDataSetValClasifProdStock() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresClasificadores");
		dataset.fieldDef(new Field("oid_valor_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_valor", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_valor", Field.STRING, 100));
		dataset.fieldDef(new Field("nickname", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("desc_clasificador", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetTempValClasifProdStock() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTempValoresClasificadores");
		dataset.fieldDef(new Field("oid_valor_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_valor", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_valor", Field.STRING, 100));
		dataset.fieldDef(new Field("nickname", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("desc_clasificador", Field.STRING, 100));
		return dataset;
	}

	private void cargarDSValClasif(IDataSet dataset, int secu, Producto producto, ClasificadorEntidad clasifEnt,
			ValorClasificadorEntidad valor) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_valor_clasif", secu);
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("oid_clasif_ent", clasifEnt.getOIDInteger());
		if (valor != null)
			dataset.fieldValue("oid_val_clasif_ent", valor.getOIDInteger());
		else
			dataset.fieldValue("oid_val_clasif_ent", new Integer(0));
		dataset.fieldValue("nro_clasif", clasifEnt.getNroClasif());
		dataset.fieldValue("desc_grupo_clasif", clasifEnt.getGrupo().getDescripcion());
		if (valor != null) {
			dataset.fieldValue("cod_valor", valor.getCodigo());
			dataset.fieldValue("desc_valor", valor.getDescripcion());
		} else {
			dataset.fieldValue("cod_valor", "");
			dataset.fieldValue("desc_valor", "");
		}
		dataset.fieldValue("nickname", clasifEnt.getNickname());
		dataset.fieldValue("activo", new Boolean(true));
		dataset.fieldValue("desc_clasificador", clasifEnt.getDescripcion());
	}

	private IDataSet getDataSetSeguiStock() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSeguimientoStock");
		dataset.fieldDef(new Field("oid_segui_stock", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_agrupador_depo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_agrupador_depo", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_agrupador_depo", Field.STRING, 100));
		dataset.fieldDef(new Field("punto_pedido", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("stock_deseado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegConcImpuProd(IDataSet ds, ConceptoImpuestoProducto concImpuProd) throws BaseException {
		ds.append();
		ds.fieldValue("oid_conc_impu_prod", concImpuProd.getOIDInteger());
		ds.fieldValue("oid_val_clasif_ent", concImpuProd.getValClasifEnt().getOIDInteger());
		ds.fieldValue("oid_conc_impu", concImpuProd.getConcepto_impuesto().getOIDInteger());
		ds.fieldValue("cod_conc_impu", concImpuProd.getConcepto_impuesto().getCodigo());
		ds.fieldValue("desc_conc_impu", concImpuProd.getConcepto_impuesto().getDescripcion());
		ds.fieldValue("fecha_vigencia", concImpuProd.getFecha_vigencia());
		ds.fieldValue("activo", new Boolean(true));

	}

	private void cargarRegSeguiStock(IDataSet ds, SeguimientoStock seguiStock) throws BaseException {
		ds.append();
		ds.fieldValue("oid_segui_stock", seguiStock.getOIDInteger());
		ds.fieldValue("oid_val_clasif_ent", seguiStock.getValClasifEnt().getOIDInteger());
		ds.fieldValue("oid_agrupador_depo", seguiStock.getAgrupador_deposito().getOIDInteger());
		ds.fieldValue("cod_agrupador_depo", seguiStock.getAgrupador_deposito().getCodigo());
		ds.fieldValue("desc_agrupador_depo", seguiStock.getAgrupador_deposito().getDescripcion());
		ds.fieldValue("punto_pedido", seguiStock.getPunto_pedido());
		ds.fieldValue("stock_deseado", seguiStock.getStock_deseado());
		ds.fieldValue("activo", new Boolean(true));
	}

	private IDataSet getDataSetConceptoImpuestoProducto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConceptoImpuestoProducto");
		dataset.fieldDef(new Field("oid_conc_impu_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_conc_impu", Field.STRING, 20));
		dataset.fieldDef(new Field("desc_conc_impu", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha_vigencia", Field.STRING, 10));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private String getClavePrecioCompra(PrecioCompraPorClasifArt precioCompraClasifArt) throws BaseException {
		return precioCompraClasifArt.getAcuerdo_lp().getTipo_acuerdo().getOIDInteger() + "_"
				+ precioCompraClasifArt.getAcuerdo_lp().getProveedor().getOIDInteger() + "_"
				+ Fecha.getddmmyyyy(precioCompraClasifArt.getFechaVigencia());
	}

	private void cargarPreciosCompra(ValorClasifEntProdGen valorClasifEntProdGral) throws BaseException {

		// Traer todos los acuerdos de Precios para un producto General
		Iterator iterAcuerdosLP = AcuerdoLP.getAcuerdosLPByValClasifEntProd(valorClasifEntProdGral, this.getSesion()).iterator();
		while (iterAcuerdosLP.hasNext()) {
			AcuerdoLP acuerdoLP = (AcuerdoLP) iterAcuerdosLP.next();
			// Por cada acuerdo traer el Precio Vigente a una Fecha
			PrecioCompraPorClasifArt precioCompraPorClasifArt = PrecioCompraPorClasifArt.getPrecioClasifArtVigentesAFecha(acuerdoLP,
					valorClasifEntProdGral, this.getSesion());
			String clave = getClavePrecioCompra(precioCompraPorClasifArt.getAcuerdo_lp().getTipo_acuerdo(), precioCompraPorClasifArt
					.getAcuerdo_lp().getProveedor());
			preciosCompra.put(clave, precioCompraPorClasifArt);
		}

	}

	private PrecioCompraPorClasifArt getPrecioCompraBy(TipoAcuerdo tipoAcuerdo, Proveedor proveedor) throws BaseException {
		String clave = getClavePrecioCompra(tipoAcuerdo, proveedor);
		return (PrecioCompraPorClasifArt) preciosCompra.get(clave);
	}

	private String getClavePrecioCompra(TipoAcuerdo tipoAcuerdo, Proveedor proveedor) throws BaseException {
		return tipoAcuerdo.getOIDInteger() + "_" + proveedor.getOIDInteger();
	}

	public Money getCalcPorcRent(ExtensionProdGen producto, CostoProductoGral costoProducto, PrecioPorEstrucLP lpDet, Money precioSinIVA)
			throws BaseException {

		Money costo = new Money(0);
		if ((costoProducto != null) && (lpDet != null)) {
			costo = producto.getCostoConvAUMVta(costoProducto.getCosto(), costoProducto.getCantidad(), costoProducto.getUm(), new Money(
					lpDet.getCantidad()), lpDet.getUnidad_medida());
			ValorCotizacion valorCotizOri = this.getCotizacionMoneda(costoProducto.getMoneda());
			ValorCotizacion valorCotizDest = this.getCotizacionMoneda(lpDet.getMoneda());

			if (valorCotizOri == null)
				throw new ExceptionValidation(null, "No se pudo encontrar la cotización para la moneda "
						+ costoProducto.getMoneda().getDescripcion());
			if (valorCotizDest == null)
				throw new ExceptionValidation(null, "No se pudo encontrar la cotización para la moneda "
						+ lpDet.getMoneda().getDescripcion());
			costo = getConvAMoneda(costo, valorCotizOri, valorCotizDest);
		}
		CalculadorMoney calcPorcRentActual = new CalculadorMoney(precioSinIVA);
		calcPorcRentActual.restar(costo);

		Money porcRent = new Money(0);
		if (costo.doubleValue() != 0) {
			calcPorcRentActual.dividirPor(costo);
			calcPorcRentActual.multiplicarPor(new Money(100));
			porcRent = calcPorcRentActual.getResultMoney();
		}

		return porcRent;

	}

	private ValorCotizacion getCotizacionMoneda(Moneda moneda) throws BaseException {
		if (moneda.isMonedaCursoLegal())
			return new ValorCotizacion(1);
		ValorCotizacion valorCotiz = (ValorCotizacion) listaCotiz.get(moneda.getOIDInteger());
		if (valorCotiz == null)
			throw new ExceptionValidation(null, "No de pudo obtener la cotización de la moneda " + moneda.getDescripcion());
		return valorCotiz;
	}

	private HashTableDatos getListaCotizaciones() throws BaseException {
		return (HashTableDatos) Cotizacion.getListaCotizacionesPorOidMoneda(Fecha.getFechaActual(), TipoCambio
				.getTipoCambioFormacionPrecio(this.getSesion()), this.getSesion());
	}

	public Money getConvAMoneda(Money importeOri, ValorCotizacion monedaOri, ValorCotizacion monedaDest) throws BaseException {
		if ((monedaOri == null) || (monedaDest == null))
			throw new ExceptionValidation(null, "No se pudo obtener la cotización de una moneda.");
		return Cotizacion.convertir(importeOri, monedaOri, monedaDest);
	}

}
