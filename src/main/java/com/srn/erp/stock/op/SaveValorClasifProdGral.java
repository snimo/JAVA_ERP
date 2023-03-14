package com.srn.erp.stock.op;

import com.srn.erp.compras.bm.PrecioCompraPorClasifArt;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.stock.bm.ConceptoImpuestoProducto;
import com.srn.erp.stock.bm.CostoProductoGral;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.FactConvProdGral;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.stock.bm.SeguimientoStock;
import com.srn.erp.stock.bm.TipoProducto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ConfProdGralPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PrecioPorEstrucLP;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveValorClasifProdGral extends Operation {

  ClasificadorEntidad clasif = null;	
	
  public SaveValorClasifProdGral() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	clasif = Producto.getClasifProductoGeneral(this.getSesion());
    IDataSet dataset = mapaDatos.getDataSet("TValorClasificador");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
    	  
    	ValorClasifEntProdGen valorClasifEntidad =
        	ValorClasifEntProdGen.findByOid(dataset.getInteger("oid_val_clasif"),getSesion());
        valorClasifEntidad.setClasificador_entidad(clasif);
        Integer utlNroIten = ValorClasificadorEntidad.getUltimoNroItem(this.getSesion(), clasif);
        int proxNro = utlNroIten.intValue() + 1; 
        valorClasifEntidad.setOid_item(new Integer(proxNro));
        valorClasifEntidad.setCodigo(dataset.getString("codigo"));
        valorClasifEntidad.setDescripcion(dataset.getString("descripcion"));
        valorClasifEntidad.setOid_item_padre(new Integer(-1));
        valorClasifEntidad.setActivo(dataset.getBoolean("activo"));
        valorClasifEntidad.setOrden(new Integer(0));
        valorClasifEntidad.setTipo(ValorClasificadorEntidad.TIPO_TITULO);
        valorClasifEntidad.setCodigoDesde(null);
        valorClasifEntidad.setCodigoHasta(null);

        
        ExtensionProdGen extensionProdGral = null;
        
        if (valorClasifEntidad.isActivo().booleanValue()==false)
          valorClasifEntidad.delete();
        
        IDataSet dsExtensionProd = dataset.getDataSet("TExtensionProdGral");
        dsExtensionProd.first();
        while (!dsExtensionProd.EOF()) {
        	extensionProdGral =
        		ExtensionProdGen.findByOid(dsExtensionProd.getInteger("oid_extension_pg"), this.getSesion());
        	extensionProdGral.setValor_clasif_ent(valorClasifEntidad);
        	extensionProdGral.setClasificador(valorClasifEntidad.getClasificador_entidad());
        	extensionProdGral.setConc_fact_prov(ConcFactProv.findByOidProxy(dsExtensionProd.getInteger("oid_conc_fact_prov"),this.getSesion()));
        	
        	extensionProdGral.setUMVta(UnidadMedida.findByOidProxy(dsExtensionProd.getInteger("oid_um_vtas"),this.getSesion()));
        	extensionProdGral.setUMProd(UnidadMedida.findByOidProxy(dsExtensionProd.getInteger("oid_um_prod"),this.getSesion()));
        	extensionProdGral.setUMCompra(UnidadMedida.findByOidProxy(dsExtensionProd.getInteger("oid_um_compra"),this.getSesion()));
        	extensionProdGral.setLTEntrega(dsExtensionProd.getInteger("lt_entrega"));
        	extensionProdGral.setPrecioNoDefEnLP(dsExtensionProd.getBoolean("prec_no_def_lp"));
        	extensionProdGral.setModifPrecioFact(dsExtensionProd.getBoolean("modif_prec_fact"));
        	extensionProdGral.setCantDecPrecio(dsExtensionProd.getInteger("cant_dec_precio"));
        	
        	extensionProdGral.setTipoProducto(TipoProducto.findByOidProxy(dsExtensionProd.getInteger("oid_tipo_prod"),this.getSesion()));
        	extensionProdGral.setComprable(dsExtensionProd.getBoolean("comprable"));
        	extensionProdGral.setVendible(dsExtensionProd.getBoolean("vendible"));
        	extensionProdGral.setStockeable(dsExtensionProd.getBoolean("stockeable"));
        	extensionProdGral.setProdPropia(dsExtensionProd.getBoolean("prod_propia"));
        	extensionProdGral.setImportado(dsExtensionProd.getBoolean("importado"));
        	
        	extensionProdGral.setUMStockPpal(UnidadMedida.findByOidProxy(dsExtensionProd.getInteger("oid_um_stock_ppal"),this.getSesion()));
        	extensionProdGral.setUMStockAlt(UnidadMedida.findByOidProxy(dsExtensionProd.getInteger("oid_um_stock_alt"),this.getSesion()));
        	extensionProdGral.setLlevaSerie(dsExtensionProd.getBoolean("lleva_serie"));
        	extensionProdGral.setLlevaPartida(dsExtensionProd.getBoolean("lleva_partida"));
        	extensionProdGral.setSeguiStock(dsExtensionProd.getBoolean("segui_stock"));
        	
        	extensionProdGral.setSaldoFacturaSenia(dsExtensionProd.getBoolean("es_sal_fact_senia"));
        	extensionProdGral.setEsSenia(dsExtensionProd.getBoolean("es_senia"));
        	extensionProdGral.setCuentaImputableVentas(CuentaImputable.findByOidProxy(dsExtensionProd.getInteger("oid_impu_vta"),this.getSesion()));
        	
        	extensionProdGral.setHabNCInt(dsExtensionProd.getBoolean("hab_nc_int"));
        	extensionProdGral.setHabNDInt(dsExtensionProd.getBoolean("hab_nd_int"));
        	
        	extensionProdGral.setSuscPercIBCapFed(dsExtensionProd.getBoolean("calc_perc_ib_cf"));
        	extensionProdGral.setSuscPercIBBsAs(dsExtensionProd.getBoolean("calc_perc_ib_ba"));
        	extensionProdGral.setSuscPercIVA(dsExtensionProd.getBoolean("calc_perc_iva"));
        	extensionProdGral.setSistemaCalidad(dsExtensionProd.getBoolean("sistema_calidad"));
        	
        	extensionProdGral.setPorcCumpOC(dsExtensionProd.getDouble("porc_cump_oc"));
        	extensionProdGral.setCuentaCompras(Cuenta.findByOidProxy(dsExtensionProd.getInteger("oid_cuenta_compras"),this.getSesion()));
        	extensionProdGral.setPorcTolRecep(dsExtensionProd.getDouble("porc_tol_recep"));
        	extensionProdGral.setLTProveedor(dsExtensionProd.getInteger("lt_entrega_prov"));
        	
        	extensionProdGral.setTomarPrecioOC1(dsExtensionProd.getString("tomar_precio_oc_1"));
        	extensionProdGral.setTomarPrecioOC2(dsExtensionProd.getString("tomar_precio_oc_2"));
        	extensionProdGral.setTomarPrecioOC3(dsExtensionProd.getString("tomar_precio_oc_3"));
        	extensionProdGral.setTomarPrecioOC4(dsExtensionProd.getString("tomar_precio_oc_4"));
        	
        	extensionProdGral.setFormaCalcCosto(dsExtensionProd.getString("forma_calc_costo"));
        	extensionProdGral.setProveedorCosto(Proveedor.findByOidProxy(dsExtensionProd.getInteger("oid_prov_costo"),this.getSesion()));
        	extensionProdGral.setComoObtenerCosto(dsExtensionProd.getString("como_obtener_costo"));
        	
        	
        	
        	valorClasifEntidad.setExtensionProdGen(extensionProdGral);
        	dsExtensionProd.next();
        }
        
        IDataSet dsCostosProd = dataset.getDataSet("TCostosProdGral");
        dsCostosProd.first();
        while (!dsCostosProd.EOF()) {
        	CostoProductoGral costoProductoGral =
        		CostoProductoGral.findByOid(dsCostosProd.getInteger("oid_costo_prodgral"), this.getSesion());
        	costoProductoGral.setVal_clasif_ent(valorClasifEntidad);
        	costoProductoGral.setClasificador(valorClasifEntidad.getClasificador_entidad());
        	costoProductoGral.setFec_ult_costo(dsCostosProd.getDate("fec_ult_costo"));
        	costoProductoGral.setMoneda(Moneda.findByOidProxy(dsCostosProd.getInteger("oid_moneda"), this.getSesion()));
        	costoProductoGral.setCantidad((dsCostosProd.getMoney("cantidad")));
        	costoProductoGral.setUm(UnidadMedida.findByOidProxy(dsCostosProd.getInteger("oid_um"), this.getSesion()));
        	costoProductoGral.setCosto((dsCostosProd.getMoney("costo")));
        	costoProductoGral.setActivo(dsCostosProd.getBoolean("activo"));
        	valorClasifEntidad.addCostoProductoGral(costoProductoGral);
        	
        	if (dsCostosProd.getBoolean("activo").booleanValue()==false)
        		costoProductoGral.delete();
        	
        	dsCostosProd.next();
        	
        }
        
        IDataSet dsConfProdPorLP = dataset.getDataSet("TConfProdGralPorLP");
        dsConfProdPorLP.first();
        while (!dsConfProdPorLP.EOF()) {
          ListaPrecios lp = ListaPrecios.findByOidProxy(dsConfProdPorLP.getInteger("oid_lista_precio"), this.getSesion());
          
          ConfProdGralPorLP confProdPorLP = ConfProdGralPorLP.getConfProdPorLP(valorClasifEntidad,lp, this.getSesion());
          if (confProdPorLP == null) {
        	  confProdPorLP = (ConfProdGralPorLP) ConfProdGralPorLP.getNew(ConfProdGralPorLP.NICKNAME, this.getSesion());
        	  confProdPorLP.setValor_clasif_ent(valorClasifEntidad);
        	  confProdPorLP.setClasificador(valorClasifEntidad.getClasificador_entidad());
        	  confProdPorLP.setLista_precios(lp);
          }
          confProdPorLP.setPorc_rent_sug(dsConfProdPorLP.getMoney("porc_rent_sug"));
          
          // Si se introdujo un cambio hacer la actualizacion del precio          
          if ((dsConfProdPorLP.getMoney("nuevo_precio_vta")!=null) && (dsConfProdPorLP.getMoney("nuevo_precio_vta").doubleValue()!=0)) {
    			PrecioPorEstrucLP lpDet =
          			lp.getPrecioPorClasifArt(valorClasifEntidad);
      			if (lpDet == null)
      				lpDet = (PrecioPorEstrucLP) PrecioPorEstrucLP.getNew(PrecioPorEstrucLP.NICKNAME, this.getSesion());
      			lpDet.setLista_precios(lp);
      			lpDet.setValor_clasif_art2(valorClasifEntidad);
      			UnidadMedida um = UnidadMedida.findByOidProxy(dsConfProdPorLP.getInteger("oid_um_pv"), this.getSesion());
      			if (um == null)
      				um = extensionProdGral.getUMVta();
      			lpDet.setUnidad_medida(um);
      			if (dsConfProdPorLP.getDouble("cant_pv")==null)
      				lpDet.setCantidad(new Double(1));
      			else
      				lpDet.setCantidad(dsConfProdPorLP.getDouble("cant_pv"));
      			lpDet.setMoneda(Moneda.findByOidProxy(dsConfProdPorLP.getInteger("oid_moneda_pv"), this.getSesion()));
      			if (lp.isIncluyeIVA())
      				lpDet.setPrecio(dsConfProdPorLP.getDouble("nuevo_precio_vta_con_iva"));
      			else
      				lpDet.setPrecio(dsConfProdPorLP.getDouble("nuevo_precio_vta"));
      			lpDet.setActivo(new Boolean(true));
      			lpDet.setFecUltAct(Fecha.getFechaActual());
      			valorClasifEntidad.addPreciosLista(lpDet);
        	  
          }
          
          valorClasifEntidad.addConfPorLP(confProdPorLP);
          dsConfProdPorLP.next();
        }
        
        IDataSet dsFactConv = dataset.getDataSet("TFactConvProdGral");
        dsFactConv.first();
        while (!dsFactConv.EOF()) {
          FactConvProdGral factConvProdGral = FactConvProdGral.findByOid(dsFactConv.getInteger("oid_equiv_pg"), this.getSesion());
          factConvProdGral.setUnidad_origen(UnidadMedida.findByOidProxy(dsFactConv.getInteger("oid_um_ori"), this.getSesion()));
          factConvProdGral.setValClasifEnt(valorClasifEntidad);
          factConvProdGral.setUnidad_destino(UnidadMedida.findByOidProxy(dsFactConv.getInteger("oid_um_dest"), this.getSesion()));
          factConvProdGral.setFact_conv(dsFactConv.getMoney("fact_conv"));
          if (dsFactConv.getBoolean("activo").booleanValue()==false)
        	  factConvProdGral.delete();
          valorClasifEntidad.addFactConvProdGral(factConvProdGral);
          dsFactConv.next();
        }
        
        IDataSet dsSeguiStock = dataset.getDataSet("TSeguimientoStock");
        dsSeguiStock.first();
        while (!dsSeguiStock.EOF()) {
          SeguimientoStock seguiStock = SeguimientoStock.findByOid(dsSeguiStock.getInteger("oid_segui_stock"), this.getSesion());
          seguiStock.setAgrupador_deposito(AgrupadorDeposito.findByOidProxy(dsSeguiStock.getInteger("oid_agrupador_depo"), this.getSesion()));
          seguiStock.setPunto_pedido(dsSeguiStock.getMoney("punto_pedido"));
          seguiStock.setStock_deseado(dsSeguiStock.getMoney("stock_deseado"));
          seguiStock.setValClasifEnt(ValorClasificadorEntidad.findByOidProxy(dsSeguiStock.getInteger("oid_val_clasif_ent"), this.getSesion()));
          if (dsSeguiStock.getBoolean("activo")==false)
        	  seguiStock.delete();
          valorClasifEntidad.addSeguimientoStock(seguiStock);
          dsSeguiStock.next();
        }
        
        
        IDataSet dsProdProv = dataset.getDataSet("TProductoProveedor");
        dsProdProv.first();
        while (!dsProdProv.EOF()) {
        	ProductoProveedor productoProveedor = 
        		ProductoProveedor.findByOid(dsProdProv.getInteger("oid_prod_prov"), this.getSesion());
        	productoProveedor.setClasifProdGeneral(ClasificadorEntidad.findByOidProxy(dsProdProv.getInteger("oid_clasif"), this.getSesion()));
        	productoProveedor.setValClasifProdGeneral(ValorClasificadorEntidad.findByOidProxy(dsProdProv.getInteger("oid_val_clasif"), this.getSesion()));
        	productoProveedor.setProveedor(Proveedor.findByOidProxy(dsProdProv.getInteger("oid_proveedor"), this.getSesion()));
        	productoProveedor.setPrioridadCompra(dsProdProv.getInteger("prioridad"));
        	productoProveedor.setCod_prod_prov(dsProdProv.getString("cod_prod_prov"));
        	productoProveedor.setUmcpra(UnidadMedida.findByOidProxy(dsProdProv.getInteger("oid_um_cpra"), this.getSesion()));
        	productoProveedor.setLote_minimo(dsProdProv.getMoney("lote_minimo"));
        	productoProveedor.setMultiplo(dsProdProv.getMoney("multiplo"));
        	productoProveedor.setLt_ent_dias(dsProdProv.getInteger("lt_ent_dias"));
        	productoProveedor.setCod_prod_prov(dsProdProv.getString("cod_prod_prov"));
        	productoProveedor.setTipoAcuerdo(TipoAcuerdo.findByOidProxy(dsProdProv.getInteger("oid_tipo_acuerdo"), this.getSesion()));
        	productoProveedor.setMoneda(Moneda.findByOidProxy(dsProdProv.getInteger("oid_moneda"), this.getSesion()));
        	productoProveedor.setCosto(dsProdProv.getMoney("costo"));
        	productoProveedor.setFecVig(dsProdProv.getDate("fec_vig"));
        	productoProveedor.setActivo(dsProdProv.getBoolean("activo").booleanValue());
        	productoProveedor.setPrecioCompraPorClasifArt(PrecioCompraPorClasifArt.findByOid(dsProdProv.getInteger("oid_precio_clasif"), this.getSesion()));
        	
        	if (!productoProveedor.isActivo())
        		productoProveedor.delete();
        	
        	
        	valorClasifEntidad.addProductoProveedor(productoProveedor);
        	
        	dsProdProv.next();
        }
        
        IDataSet dsProdStock = dataset.getDataSet("TProductoStock");
        dsProdStock.first();
        while (!dsProdStock.EOF()) {
        	
        	Producto producto = Producto.findByOid(dsProdStock.getInteger("oid"),this.getSesion());
        	producto.setCodigo(dsProdStock.getString("cod_prod_stock"));
        	producto.setDescripcion(dsProdStock.getString("desc_prod_stock"));
        	producto.setDesc_abrev(dsProdStock.getString("desc_abrev"));
        	producto.setSinonimo(dsProdStock.getString("sinonimo"));
        	producto.setCodigo_barra(dsProdStock.getString("codigo_barra"));
        	producto.setActivo(dsProdStock.getBoolean("activo"));
        	
        	grabarValoresClasifProdStock(producto,dsProdStock);
        	
        	valorClasifEntidad.addProducto(producto);
        	
        	dsProdStock.next();
        }
        
        IDataSet dsConcImpu = dataset.getDataSet("TConceptoImpuestoProducto");
        dsConcImpu.first();
        while (!dsConcImpu.EOF()) {
        	
        	ConceptoImpuestoProducto concImpuProd = ConceptoImpuestoProducto.findByOid(dsConcImpu.getInteger("oid_conc_impu_prod"),this.getSesion());
        	concImpuProd.setProducto(null);
        	concImpuProd.setValClasifEnt(ValorClasificadorEntidad.findByOidProxy(dsConcImpu.getInteger("oid_val_clasif_ent"), this.getSesion()));
        	concImpuProd.setConcepto_impuesto(ConceptoImpuesto.findByOidProxy(dsConcImpu.getInteger("oid_conc_impu"), this.getSesion()));
        	concImpuProd.setFecha_vigencia(dsConcImpu.getDate("fecha_vigencia"));
        	if (!dsConcImpu.getBoolean("activo").booleanValue())
        		concImpuProd.delete();
        	valorClasifEntidad.addConceptoImpuesto(concImpuProd);
        	
        	dsConcImpu.next();
        }
        
        grabarValoresClasif(valorClasifEntidad,dataset);
        
        addTransaccion(valorClasifEntidad);
        dataset.next();
    }
  }
  
  private void grabarValoresClasif(ValorClasifEntProdGen valorClasifEntidad,IDataSet dsValorClasif) throws BaseException {
	  
	    // Se se va a grabar un clasificador y no existe la extension darla de alta
	    if (valorClasifEntidad.getExtensionProdGen() == null) {
	    	ExtensionProdGen extProdGral = (ExtensionProdGen) ExtensionProdGen.getNew(ExtensionProdGen.NICKNAME, this.getSesion());
	    	extProdGral.setClasificador(valorClasifEntidad.getClasificador_entidad());
	    	extProdGral.setValor_clasif_ent(valorClasifEntidad);
	    	valorClasifEntidad.setExtensionProdGen(extProdGral);
	    }
	    IDataSet dsValClasif = dsValorClasif.getDataSet("TValoresClasifProdGral");
	    dsValClasif.first();
	    while (!dsValClasif.EOF()) {
	    	valorClasifEntidad.getExtensionProdGen().addOidValorClasif(dsValClasif.getInteger("nro_clasif"),
	                                 				 dsValClasif.getInteger("oid_val_clasif_ent"));
	      dsValClasif.next();
	    }
  }
  
  private void grabarValoresClasifProdStock(Producto producto,IDataSet ds) throws BaseException {
	    IDataSet dsValClasif = ds.getDataSet("TValoresClasificadores");
	    dsValClasif.first();
	    while (!dsValClasif.EOF()) {
	      producto.addOidValorClasif(dsValClasif.getInteger("nro_clasif"),
	                                 dsValClasif.getInteger("oid_val_clasif_ent"));
	      dsValClasif.next();
	    }
	    
	  }
  
  

}
