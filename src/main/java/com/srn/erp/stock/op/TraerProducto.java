package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.ConceptoImpuestoProducto;
import com.srn.erp.stock.bm.ConversionUMProducto;
import com.srn.erp.stock.bm.CostoProducto;
import com.srn.erp.stock.bm.FactorConversionProveedor;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.stock.bm.SeguimientoStock;
import com.srn.erp.stock.bm.TipoProducto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ConfProdPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProducto extends Operation {

	public TraerProducto() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		if (mapaDatos.containsKey("inicializarClasificadores")) {
			inicializarClasif(mapaDatos);
			return;
		}

		Producto producto = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			producto = Producto.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			producto = Producto.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetProducto = getDataSetProducto();
		IDataSet datasetProductoProveedor = getDataSetProductoProveedor();
		IDataSet datasetConceptoImpuesto = getDataSetConceptoImpuestoProducto();
		IDataSet datasetConversionUMProducto = getDataSetConversionUMProducto();
		IDataSet dsValClasifEnt = getDataSetValClasif();
		IDataSet dsFactConvProv = getDataSetFactConvProv();
		IDataSet dsAtriValores  = this.getDataSetAtributosProducto(producto);
		IDataSet dsSeguiStock = this.getDataSetSeguiStock();
		IDataSet dsCostoProducto = getDataSetCostoProducto();
		IDataSet dsConfProdPorLP = this.getDataSetConfProdPorLP();

		if (producto != null) {
			cargarRegistroProducto(datasetProducto, 
					producto.getOIDInteger(),
					producto.getCodigo(), 
					producto.getDescripcion(), 
					producto.getDesc_abrev(), 
					producto.isComprable(), 
					producto.isVendible(), 
					producto.isStockeable(), 
					producto.isProd_propia(), 
					producto.isImportado(), 
					producto.getSinonimo(), 
					producto.getCodigo_barra(),
					producto.getUm_vta(), 
					producto.getUm_stk(), 
					producto.getUm_stk_alt(), 
					producto.getUm_cpra(), 
					producto.getUm_prod(), 
					producto.getTolerancia_recep(),
					producto.getPorc_cump_oc(), 
					producto.isSistema_calidad(),
					producto.getCuenta_cpra(), 
					producto.isModif_ai_cpra(), 
					producto.isActivo(), 
					producto.getTipoproducto(), 
					producto.getLt_entrega(), 
					producto.getConcFactProv(),
					producto.isLlevaPartida(), 
					producto.isLlevaSerie(),
					producto.getNro(),
					producto.getCuentaVenta() , 
					producto.getCantDecPrecioVta() , 
					producto.getLeadTimeVta(),
					producto.isPrecioNoDefLP(),
					producto.isHabilitadaNotaDebitoInterna(),
					producto.isHabilitadaNotaCreditoInterna(),
					producto.isCalcPercIBBsAs(),
					producto.isCalcPercIBCapFed(),
					producto.isCalcPercIVA(),
					producto.isModifPrecioFactura(),
					producto.isSeguimientoStock(),
					producto.isSeUsaParaSaldoPendFactSenia(),
					producto.isSeniaFactura(),
					producto.getTomarPrecioOC1(),
					producto.getTomarPrecioOC2(),
					producto.getTomarPrecioOC3(),
					producto.getTomarPrecioOC4(),
					producto.getFormaCalcCosto(),
					producto.getProveedorCosto()
					);

			// Devolver valores de Clasificadores
			traerValoresDatosClasif(dsValClasifEnt, producto);
			
			// Devolver los Valores de Atributos			
			traerValoresAtributos(dsAtriValores,producto);

			// Traer productos del Proveedor
			Iterator iterProdProv = producto.getProductosProveedor().iterator();
			while (iterProdProv.hasNext()) {
				ProductoProveedor productoProveedor = (ProductoProveedor) iterProdProv
						.next();
				cargarRegistroProductoProveedor(datasetProductoProveedor,
						productoProveedor.getOIDInteger(), producto
								.getOIDInteger(), productoProveedor
								.getProveedor().getOIDInteger(),
						productoProveedor.getProveedor().getCodigo(),
						productoProveedor.getProveedor().getRazonsocial(),
						productoProveedor.getCod_prod_prov(), 
						productoProveedor.getUmcpra(), 
						productoProveedor.getLote_minimo(), 
						productoProveedor.getMultiplo(), 
						productoProveedor.getLt_ent_dias(),
						productoProveedor.getPrioridadCompra()
						);
				
				// Enviar Factores de Conversion
				Iterator iterFactConvProv = productoProveedor.getFactoresConversionProv().iterator();
				while (iterFactConvProv.hasNext()) {
					FactorConversionProveedor factConvProv = (FactorConversionProveedor) iterFactConvProv.next();
					cargarRegistroFactConvProv(dsFactConvProv,factConvProv);
				}
				
			}

			// Traer Impuestos
			Iterator iterConcImpu = producto.getConceptosImpuestos().iterator();
			while (iterConcImpu.hasNext()) {
				ConceptoImpuestoProducto conceptoImpuestoProducto = (ConceptoImpuestoProducto) iterConcImpu
						.next();
				cargarRegistroConceptoImpuestoProducto(datasetConceptoImpuesto,
						conceptoImpuestoProducto.getOIDInteger(), producto
								.getOIDInteger(), conceptoImpuestoProducto
								.getConcepto_impuesto(),
						conceptoImpuestoProducto.getFecha_vigencia());

			}

			// Traer Factores de Conversion
			Iterator iterConversionUM = producto.getConversionesUM().iterator();
			while (iterConversionUM.hasNext()) {
				ConversionUMProducto conversionUMProducto = (ConversionUMProducto) iterConversionUM
						.next();
				cargarRegistroConversionUMProducto(datasetConversionUMProducto,
						conversionUMProducto.getOIDInteger(), producto,
						conversionUMProducto.getUnidad_medida_origen(),
						conversionUMProducto.getUnidad_medida_dest(),
						conversionUMProducto.getFact_conv());

			}
			
			// Traer Factores de Conversion
			Iterator iterCostoProducto = producto.getCostosProducto().iterator();
			while (iterCostoProducto.hasNext()) {
				CostoProducto costoProducto = (CostoProducto) iterCostoProducto.next();
				cargarRegistroCostoProducto(dsCostoProducto,costoProducto);
			}
			
			
			Iterator iterSeguiStock = producto.getSeguimientosStock().iterator();
			while (iterSeguiStock.hasNext()) {
				SeguimientoStock seguiStock = (SeguimientoStock) iterSeguiStock.next();
				cargarRegSeguiStock(dsSeguiStock, seguiStock);
			}
			
			Iterator iterLP = ListaPrecios.getTodasLasListas(this.getSesion()).iterator();
			while (iterLP.hasNext()) {
				Double porcRentSug = new Double(0);
				ListaPrecios lp = (ListaPrecios) iterLP.next();
				ConfProdPorLP confProdPorLP = producto.getConfProdPorLP(lp);
				if (confProdPorLP!=null)
					porcRentSug = confProdPorLP.getPorc_rent_sug(); 
				cargarConfProdPorLP(dsConfProdPorLP,producto,lp,porcRentSug);
			}
			
			Iterator iterCondProdPorLP = 
				producto.getSeguimientosStock().iterator();
			while (iterSeguiStock.hasNext()) {
				SeguimientoStock seguiStock = (SeguimientoStock) iterSeguiStock.next();
				cargarRegSeguiStock(dsSeguiStock, seguiStock);
			}
			

		}
		writeCliente(datasetProducto);
		writeCliente(datasetProductoProveedor);
		writeCliente(dsFactConvProv);
		writeCliente(datasetConceptoImpuesto);
		writeCliente(datasetConversionUMProducto);
		writeCliente(dsValClasifEnt);
		writeCliente(dsAtriValores);
		writeCliente(dsSeguiStock);
		writeCliente(dsCostoProducto);
		writeCliente(dsConfProdPorLP);
		
	}
	
	private void cargarConfProdPorLP(IDataSet ds,Producto producto, ListaPrecios listaPrecios, Double rentSugProd) throws BaseException {
		ds.append();
		ds.fieldValue("oid_conf_prod_lp", listaPrecios.getOIDInteger()*-1);
		ds.fieldValue("oid_producto", producto.getOIDInteger());
		ds.fieldValue("oid_precio_cab", listaPrecios.getOIDInteger());
		ds.fieldValue("porc_rent_sug", rentSugProd);
		ds.fieldValue("desc_precio_cab", listaPrecios.getDescripcion());
		
	}

	private IDataSet getDataSetProducto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProducto");
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_abrev", Field.STRING, 100));
		dataset.fieldDef(new Field("comprable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("vendible", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("stockeable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("prod_propia", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("importado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("sinonimo", Field.STRING, 20));
		dataset.fieldDef(new Field("codigo_barra", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_um_vta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_stk", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_stk_alt", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_cpra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tolerancia_recep", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_cump_oc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("sistema_calidad", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_ana_con_cpra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 50));
		dataset.fieldDef(new Field("modif_ai_cpra", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_tipo_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lt_entrega", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_fact_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_conc_fact_prov", Field.STRING, 20));
		dataset.fieldDef(new Field("desc_conc_fact_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("lleva_partida", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("lleva_serie", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cuenta_vta",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_cuenta_vta",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_cuenta_vta",Field.STRING, 100));
		dataset.fieldDef(new Field("cant_dec_pv",Field.INTEGER, 0));
		dataset.fieldDef(new Field("lead_time_vta",Field.INTEGER, 0));
		dataset.fieldDef(new Field("precio_no_def_lp",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("hab_nd_int",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("hab_nc_int",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("calc_perc_ib_ba",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("calc_perc_ib_cf",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("calc_perc_iva",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("modif_precio_fact",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("segui_stock",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("usar_saldo_pend_fact_senia",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("es_senia_factura",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("tomar_precio_oc_1",Field.STRING, 20));
		dataset.fieldDef(new Field("tomar_precio_oc_2",Field.STRING, 20));
		dataset.fieldDef(new Field("tomar_precio_oc_3",Field.STRING, 20));
		dataset.fieldDef(new Field("tomar_precio_oc_4",Field.STRING, 20));
		dataset.fieldDef(new Field("forma_calc_costo",Field.STRING, 20));
		dataset.fieldDef(new Field("oid_prov_costo",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov_costo",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_prov_costo",Field.STRING, 100));
		
		
		return dataset;
	}

	private IDataSet getDataSetProductoProveedor() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProductoProveedor");
		dataset.fieldDef(new Field("oid_prod_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_proveedor", Field.STRING, 30));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("cod_prod_prov", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_um_cpra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lote_minimo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("multiplo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("lt_ent_dias", Field.INTEGER, 0));
		dataset.fieldDef(new Field("prioridad", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroProductoProveedor(IDataSet dataset,
			Integer oid_producto_proveedor, Integer oid_producto,
			Integer oid_proveedor, String codigo_proveedor,
			String rs_proveedor, String cod_prod_prov, UnidadMedida umCompra,
			Money loteMinimo, Money multiplo, Integer lt_en_dias,Integer prioridad)
			throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_prod_prov", oid_producto_proveedor);
		dataset.fieldValue("oid_producto", oid_producto);
		dataset.fieldValue("oid_proveedor", oid_proveedor);
		dataset.fieldValue("codigo_proveedor", codigo_proveedor);
		dataset.fieldValue("rs_proveedor", rs_proveedor);
		dataset.fieldValue("cod_prod_prov", cod_prod_prov);
		if (umCompra!=null)
			dataset.fieldValue("oid_um_cpra", umCompra.getOIDInteger());
		else
			dataset.fieldValue("oid_um_cpra", "");
		dataset.fieldValue("lote_minimo", loteMinimo);
		dataset.fieldValue("multiplo", multiplo);
		dataset.fieldValue("lt_ent_dias", lt_en_dias);
		dataset.fieldValue("prioridad", prioridad);
	}

	private void cargarRegistroProducto(IDataSet dataset, Integer oid_producto,
			String codigo, String descripcion, String desc_abrev,
			Boolean comprable, Boolean vendible, Boolean stockeable,
			Boolean prod_propia, Boolean importado, String sinonimo,
			String codigo_barra, UnidadMedida oid_um_vta,
			UnidadMedida oid_um_stk, UnidadMedida oid_um_stk_alt,
			UnidadMedida oid_um_cpra, UnidadMedida oid_um_prod,
			Money tolerancia_recep, Money porc_cump_oc,
			Boolean sistema_calidad, Cuenta cuentaCompra,
			Boolean modif_ai_cpra, Boolean activo, TipoProducto oid_tipo_prod,
			Integer lt_entrega, ConcFactProv concFactProv,
			Boolean llevaPartida, Boolean llevaSerie, Integer nro, CuentaImputable cuentaVenta,
			Integer cantDecPV, Integer leadTimeVta , boolean precioNoDefLP , boolean habNDInt , boolean habNCInt,
			boolean calc_perc_ib_ba, boolean calc_perc_ib_cf, boolean calc_perc_iva, Boolean modifPrecioFact,
			Boolean seguiStock , Boolean usarSaldoPendFactSenia , 
			Boolean esSeniaFactura,
			String tomarPrecioOC1,
			String tomarPrecioOC2,
			String tomarPrecioOC3,
			String tomarPrecioOC4,
			String formaCalcCosto,
			Proveedor proveedorCosto)
			throws BaseException {
		
		dataset.append();
		dataset.fieldValue("oid_producto", oid_producto);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("desc_abrev", desc_abrev);
		dataset.fieldValue("comprable", comprable);
		dataset.fieldValue("vendible", vendible);
		dataset.fieldValue("stockeable", stockeable);
		dataset.fieldValue("prod_propia", prod_propia);
		dataset.fieldValue("importado", importado);
		dataset.fieldValue("sinonimo", sinonimo);
		dataset.fieldValue("codigo_barra", codigo_barra);

		if (oid_um_vta != null)
			dataset.fieldValue("oid_um_vta", oid_um_vta.getOID());
		else
			dataset.fieldValue("oid_um_vta", 0);

		if (oid_um_stk != null)
			dataset.fieldValue("oid_um_stk", oid_um_stk.getOID());
		else
			dataset.fieldValue("oid_um_stk", 0);

		if (oid_um_stk_alt != null)
			dataset.fieldValue("oid_um_stk_alt", oid_um_stk_alt.getOID());
		else
			dataset.fieldValue("oid_um_stk_alt", 0);

		if (oid_um_cpra != null)
			dataset.fieldValue("oid_um_cpra", oid_um_cpra.getOID());
		else
			dataset.fieldValue("oid_um_cpra", 0);

		if (oid_um_prod != null)
			dataset.fieldValue("oid_um_prod", oid_um_prod.getOID());
		else
			dataset.fieldValue("oid_um_prod", 0);

		dataset.fieldValue("tolerancia_recep", tolerancia_recep);
		dataset.fieldValue("porc_cump_oc", porc_cump_oc);
		dataset.fieldValue("sistema_calidad", sistema_calidad);
		if (cuentaCompra != null) {
			dataset.fieldValue("oid_ana_con_cpra", cuentaCompra.getOIDInteger());
			dataset.fieldValue("cod_ana_con", cuentaCompra.getCodigo());
			dataset.fieldValue("desc_ana_con", cuentaCompra.getDescripcion());
		} else {
			dataset.fieldValue("oid_ana_con_cpra", 0);
			dataset.fieldValue("cod_ana_con", "");
			dataset.fieldValue("desc_ana_con", "");
		}
		dataset.fieldValue("modif_ai_cpra", modif_ai_cpra);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("oid_tipo_prod", oid_tipo_prod.getOID());
		dataset.fieldValue("lt_entrega", lt_entrega);
		if (concFactProv != null) {
			dataset.fieldValue("oid_conc_fact_prov", concFactProv.getOID());
			dataset.fieldValue("cod_conc_fact_prov", concFactProv.getCodigo());
			dataset.fieldValue("desc_conc_fact_prov", concFactProv
					.getDescripcion());
		} else {
			dataset.fieldValue("oid_conc_fact_prov", 0);
			dataset.fieldValue("cod_conc_fact_prov", "");
			dataset.fieldValue("desc_conc_fact_prov", "");
		}
		dataset.fieldValue("lleva_partida", llevaPartida);
		dataset.fieldValue("lleva_serie", llevaSerie);
		dataset.fieldValue("nro", nro);
		if (cuentaVenta!=null) {
		      dataset.fieldValue("oid_cuenta_vta",cuentaVenta.getOIDInteger());
		      dataset.fieldValue("cod_cuenta_vta",cuentaVenta.getCodigoCuentaMasCodigosValCompo());
		      dataset.fieldValue("desc_cuenta_vta",cuentaVenta.getDescCuentaMasDescValCompo());
		} else {
			  dataset.fieldValue("oid_cuenta_vta",0);
			  dataset.fieldValue("cod_cuenta_vta","");
			  dataset.fieldValue("desc_cuenta_vta","");
		}
		
		if (cantDecPV!=null)
			dataset.fieldValue("cant_dec_pv", cantDecPV);
		else
			dataset.fieldValue("cant_dec_pv", new Integer(0));
		
		if (leadTimeVta!=null)
			dataset.fieldValue("lead_time_vta", leadTimeVta);
		else
			dataset.fieldValue("lead_time_vta", 0);
		dataset.fieldValue("precio_no_def_lp", new Boolean(precioNoDefLP));
		dataset.fieldValue("hab_nd_int", new Boolean(habNDInt));
		dataset.fieldValue("hab_nc_int", new Boolean(habNCInt));
		dataset.fieldValue("calc_perc_ib_ba", new Boolean(calc_perc_ib_ba));
		dataset.fieldValue("calc_perc_ib_cf", new Boolean(calc_perc_ib_cf));
		dataset.fieldValue("calc_perc_iva", new Boolean(calc_perc_iva));
		dataset.fieldValue("modif_precio_fact", modifPrecioFact);
		dataset.fieldValue("segui_stock", seguiStock);
		dataset.fieldValue("usar_saldo_pend_fact_senia", usarSaldoPendFactSenia);
		dataset.fieldValue("es_senia_factura", esSeniaFactura);
		dataset.fieldValue("tomar_precio_oc_1", tomarPrecioOC1);
		dataset.fieldValue("tomar_precio_oc_2", tomarPrecioOC2);
		dataset.fieldValue("tomar_precio_oc_3", tomarPrecioOC3);
		dataset.fieldValue("tomar_precio_oc_4", tomarPrecioOC4);
		dataset.fieldValue("forma_calc_costo",formaCalcCosto);
		
		if (proveedorCosto!=null) {
			dataset.fieldValue("oid_prov_costo", proveedorCosto.getOIDInteger());
			dataset.fieldValue("cod_prov_costo", proveedorCosto.getCodigo());
			dataset.fieldValue("desc_prov_costo",proveedorCosto.getRazonsocial());
		} else {
			dataset.fieldValue("oid_prov_costo", new Integer(0));
			dataset.fieldValue("cod_prov_costo", "");
			dataset.fieldValue("desc_prov_costo","");
		}
		

	}

	private IDataSet getDataSetConceptoImpuestoProducto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConceptoImpuestoProducto");
		dataset.fieldDef(new Field("oid_conc_impu_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_conc_impu", Field.STRING, 20));
		dataset.fieldDef(new Field("desc_conc_impu", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha_vigencia", Field.STRING, 10));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroConceptoImpuestoProducto(IDataSet dataset,
			Integer oid_conc_impu_prod, Integer oid_producto,
			ConceptoImpuesto conceptoImpuesto, java.util.Date fecha_vigencia)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_conc_impu_prod", oid_conc_impu_prod);
		dataset.fieldValue("oid_producto", oid_producto);
		dataset.fieldValue("oid_conc_impu", conceptoImpuesto.getOIDInteger());
		dataset.fieldValue("cod_conc_impu", conceptoImpuesto.getCodigo());
		dataset.fieldValue("desc_conc_impu", conceptoImpuesto.getDescripcion());
		dataset.fieldValue("fecha_vigencia", Fecha.getddmmyyyy(fecha_vigencia));
		dataset.fieldValue("activo", new Boolean(true));
	}

	private IDataSet getDataSetConversionUMProducto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConversionUMProducto");
		dataset.fieldDef(new Field("oid_equiv_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_origen", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_destino", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fact_conv", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarRegistroConversionUMProducto(IDataSet dataset,
			Integer oid_equiv_prod, Producto producto, UnidadMedida umOrigen,
			UnidadMedida umDestino, Double fact_conv) {
		dataset.append();
		dataset.fieldValue("oid_equiv_prod", oid_equiv_prod);
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("oid_um_origen", umOrigen.getOIDInteger());
		dataset.fieldValue("oid_um_destino", umDestino.getOIDInteger());
		dataset.fieldValue("fact_conv", fact_conv);
	}

	private IDataSet getDataSetValClasif() {
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

	private void cargarDSValClasif(IDataSet dataset, Integer oidValorClasif,
			Integer oidProducto, Integer oidClasifEnt, Integer oidValClasifEnt,
			Integer nroClasif, String descGrupoClasif, String codValor,
			String descValor, String nickname, Boolean activo,
			String descClasificador) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_valor_clasif", oidValorClasif);
		dataset.fieldValue("oid_producto", oidProducto);
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

	
	private void traerValoresAtributos(IDataSet dsAtriValores,
																		 Producto producto) throws BaseException {
		
		dsAtriValores.append();
		dsAtriValores.fieldValue("oid_producto_atri", producto.getValoresAtributos().getOIDInteger());
		dsAtriValores.fieldValue("oid_producto", producto.getOIDInteger());
		
		// Devolver los atributos de los productos
		Iterator iterAtributos = producto.getAtributos().iterator();
		while (iterAtributos.hasNext()) {
			Atributo atributo = (Atributo) iterAtributos.next();
			Object objValorAtri = producto.getValoresAtributos().getValor(atributo);
			
			// Componente
			if (atributo.isValorCompo()) {
				if (objValorAtri!=null) {
					IObjetoLogico objLog = (IObjetoLogico) objValorAtri;
					dsAtriValores.fieldValue("COM_OID_"+atributo.getOIDInteger().toString(), objLog.getOIDInteger());
					dsAtriValores.fieldValue("COM_COD_"+atributo.getOIDInteger().toString(), objLog.getCodigo());
					dsAtriValores.fieldValue("COM_DES_"+atributo.getOIDInteger().toString(), objLog.getDescripcion());					
				}
				else {
					dsAtriValores.fieldValue("COM_OID_"+atributo.getOIDInteger().toString(), 0);
					dsAtriValores.fieldValue("COM_COD_"+atributo.getOIDInteger().toString(), "");
					dsAtriValores.fieldValue("COM_DES_"+atributo.getOIDInteger().toString(), "");					
				}
			}
			
			// Entero
			if (atributo.isEntero()) {
				Integer valorEntero = (Integer) objValorAtri;
				dsAtriValores.fieldValue("INT_"+atributo.getOIDInteger().toString(), valorEntero);
			}
			
			// String
			if (atributo.isString()) {
				String valorString = (String) objValorAtri;
				dsAtriValores.fieldValue("TXT_"+atributo.getOIDInteger().toString(), valorString);
			}
				
			// Decimal
			if (atributo.isDecimal()) {
				Double valorDecimal = (Double) objValorAtri;
				dsAtriValores.fieldValue("DEC_"+atributo.getOIDInteger().toString(), valorDecimal);
			}
				
			// Fecha
			if (atributo.isFecha()) {
				java.util.Date valorFecha = (java.util.Date) objValorAtri;
				dsAtriValores.fieldValue("FEC_"+atributo.getOIDInteger().toString(), valorFecha);
			}
		}
		
		// Atributos Variables
		Iterator iterGrupoAtriVar = producto.getGruposAtributosVariables().iterator();
		while (iterGrupoAtriVar.hasNext()) {
			GrupoAtributoEntidadVar grupoAtriEntVar = (GrupoAtributoEntidadVar) iterGrupoAtriVar.next();
			GrupoDeAtributos grupoDeAtributos = producto.getValoresAtributos().getGrupoDeAtributos(grupoAtriEntVar);
			if (grupoDeAtributos!=null) {
			  dsAtriValores.fieldValue("TP_OID_"+grupoAtriEntVar.getOIDInteger(), grupoDeAtributos.getOIDInteger());
			  dsAtriValores.fieldValue("TP_COD_"+grupoAtriEntVar.getOIDInteger(), grupoDeAtributos.getCodigo());
			  dsAtriValores.fieldValue("TP_DES_"+grupoAtriEntVar.getOIDInteger(), grupoDeAtributos.getDescripcion());
			}
			else {
			  dsAtriValores.fieldValue("TP_OID_"+grupoAtriEntVar.getOIDInteger(), 0);
			  dsAtriValores.fieldValue("TP_COD_"+grupoAtriEntVar.getOIDInteger(), "");
			  dsAtriValores.fieldValue("TP_DES_"+grupoAtriEntVar.getOIDInteger(), "");
			}
		}
		
		
		
	}
	
	private void traerValoresDatosClasif(IDataSet ds, Producto aProducto)
			throws BaseException {
		int oid = 0;
		Iterator iterClasifEnt = aProducto.getClasificadoresEntidadActivos()
				.iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt
					.next();
			IValorClasificadorEntidad valClasifEntidad = aProducto
					.getValorClasifEnt(clasifEnt);
			if (valClasifEntidad != null)
				cargarDSValClasif(ds, new Integer(++oid), aProducto
						.getOIDInteger(), clasifEnt.getOIDInteger(),
						new Integer(valClasifEntidad.getOID()), clasifEnt
								.getNroClasif(), clasifEnt.getGrupo()
								.getDescripcion(),
						valClasifEntidad.getCodigo(), valClasifEntidad
								.getDescripcion(), clasifEnt.getNickname(),
						new Boolean(true), clasifEnt.getDescripcion());
			else
				cargarDSValClasif(ds, new Integer(++oid), aProducto
						.getOIDInteger(), clasifEnt.getOIDInteger(),
						new Integer(-1), clasifEnt.getNroClasif(), clasifEnt
								.getGrupo().getDescripcion(), "", "", clasifEnt
								.getNickname(), new Boolean(true), clasifEnt
								.getDescripcion());
		}

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

	private void cargarRegistroClasificadorEntidad(IDataSet dataset,
			ClasificadorEntidad clasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_clasif_ent", clasifEnt.getOIDInteger());
		dataset.fieldValue("codigo", clasifEnt.getCodigo());
		dataset.fieldValue("descripcion", clasifEnt.getDescripcion());
		dataset.fieldValue("nickname", clasifEnt.getNickname());
		dataset.fieldValue("obligatorio", clasifEnt.isObligatorio());
		dataset.fieldValue("activo", clasifEnt.isActivo());
		dataset.fieldValue("nro_clasif", clasifEnt.getNroClasif());
		dataset.fieldValue("oid_grupo_clasif", clasifEnt.getGrupo()
				.getOIDInteger());
		dataset
				.fieldValue("cod_grupo_clasif", clasifEnt.getGrupo()
						.getCodigo());
		dataset.fieldValue("desc_grupo_clasif", clasifEnt.getGrupo()
				.getDescripcion());

	}

	private void inicializarClasif(MapDatos mapaDatos) throws BaseException {
		IDataSet dsClasifEnt = getDataSetClasificadorEntidad();
		Iterator iterClasifEnt = Producto.getClasificadoresEntidadActivos(getSesion())
				.iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt
					.next();
			cargarRegistroClasificadorEntidad(dsClasifEnt, clasifEnt);
		}
		writeCliente(dsClasifEnt);
	}

	private IDataSet getDataSetFactConvProv() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFactConvProv");
		dataset.fieldDef(new Field("oid_fact_conv_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_prod_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fact_conv", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetSeguiStock() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSeguimientoStock");
		dataset.fieldDef(new Field("oid_segui_stock", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_agrupador_depo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_agrupador_depo", Field.INTEGER, 50));
		dataset.fieldDef(new Field("desc_agrupador_depo", Field.STRING, 100));
		dataset.fieldDef(new Field("punto_pedido", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("stock_deseado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetCostoProducto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCostoProducto");
		dataset.fieldDef(new Field("oid_costo_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_ult_costo",Field.DATE, 0));
		dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cantidad",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um",Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("costo",Field.CURRENCY, 0));
		return dataset;
	}
	
	private IDataSet getDataSetConfProdPorLP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConfProdPorLP");
		dataset.fieldDef(new Field("oid_conf_prod_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("porc_rent_sug", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("desc_precio_cab", Field.STRING, 100));
		return dataset;
	}
	
	
	
	private void cargarRegSeguiStock(IDataSet ds,SeguimientoStock aSegui) throws BaseException {
		ds.append();
		ds.fieldValue("oid_segui_stock", aSegui.getOIDInteger());
		ds.fieldValue("oid_producto", aSegui.getProducto().getOIDInteger());
		ds.fieldValue("oid_agrupador_depo", aSegui.getAgrupador_deposito().getOIDInteger());
		ds.fieldValue("cod_agrupador_depo", aSegui.getAgrupador_deposito().getCodigo());
		ds.fieldValue("desc_agrupador_depo", aSegui.getAgrupador_deposito().getDescripcion());
		ds.fieldValue("punto_pedido", aSegui.getPunto_pedido());
		ds.fieldValue("stock_deseado", aSegui.getStock_deseado());
		ds.fieldValue("activo", new Boolean(true));
	}
	
	
	private IDataSet getDataSetAtributosProducto(Producto producto) throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresAtributos");		
		dataset.fieldDef(new Field("oid_producto_atri", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		
		Iterator iterAtributos = producto.getAtributos().iterator();
		while (iterAtributos.hasNext()) {
			Atributo atributo = (Atributo) iterAtributos.next();
			if (atributo.isValorCompo()) {
				dataset.fieldDef(new Field("COM_OID_"+atributo.getOIDInteger().toString(), Field.INTEGER, 0));
				dataset.fieldDef(new Field("COM_COD_"+atributo.getOIDInteger().toString(), Field.STRING, 50));
				dataset.fieldDef(new Field("COM_DES_"+atributo.getOIDInteger().toString(), Field.STRING, 100));
			} 
			else
			if (atributo.isEntero()) 
				dataset.fieldDef(new Field("INT_"+atributo.getOIDInteger().toString(), Field.INTEGER, 0));
			else
				if (atributo.isString()) 
					dataset.fieldDef(new Field("TXT_"+atributo.getOIDInteger().toString(), Field.STRING, 255));
			else
				if (atributo.isDecimal()) 
					dataset.fieldDef(new Field("DEC_"+atributo.getOIDInteger().toString(), Field.CURRENCY, 0));
			else
			if (atributo.isFecha()) 
					dataset.fieldDef(new Field("FEC_"+atributo.getOIDInteger().toString(), Field.CURRENCY, 0));
		}
		
		// Atributos Variables
		Iterator iterGrupoAtriVar = producto.getGruposAtributosVariables().iterator();
		while (iterGrupoAtriVar.hasNext()) {
			GrupoAtributoEntidadVar grupoAtriEntVar = (GrupoAtributoEntidadVar) iterGrupoAtriVar.next();
			dataset.fieldDef(new Field("TP_OID_"+grupoAtriEntVar.getOIDInteger(), Field.INTEGER, 0));
			dataset.fieldDef(new Field("TP_COD_"+grupoAtriEntVar.getOIDInteger(), Field.STRING, 50));
			dataset.fieldDef(new Field("TP_DES_"+grupoAtriEntVar.getOIDInteger(), Field.STRING, 100));
		}
		
		return dataset;
	}
	
	
	private void cargarRegistroFactConvProv(IDataSet dataset,
			FactorConversionProveedor factConvProv) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_fact_conv_prov", factConvProv.getOIDInteger());
		dataset.fieldValue("oid_um", factConvProv.getUnidad_medida().getOIDInteger());
		dataset.fieldValue("oid_prod_prov",factConvProv.getProducto_proveedor().getOIDInteger());
		dataset.fieldValue("fact_conv",factConvProv.getFactor_conversion());
		dataset.fieldValue("activo",new Boolean(true));
	}
	
	private void cargarRegistroCostoProducto(IDataSet dataset,CostoProducto costo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_costo_producto", costo.getOIDInteger());
		dataset.fieldValue("oid_producto", costo.getProducto().getOIDInteger());
		dataset.fieldValue("fec_ult_costo",costo.getFec_ult_costo());
		dataset.fieldValue("oid_moneda",costo.getMoneda().getOIDInteger());
		dataset.fieldValue("cantidad",costo.getCantidad());
		dataset.fieldValue("oid_um",costo.getUnidad_medida().getOIDInteger());
		dataset.fieldValue("activo",costo.isActivo());
		dataset.fieldValue("costo",costo.getCosto());
		
		
	}
	

}
