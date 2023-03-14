package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.AgrupadorDeposito;
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
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveProducto extends Operation {

  public SaveProducto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TProducto");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Producto producto = Producto.findByOid(dataset.getInteger("oid_producto"),getSesion());
        producto.setOID(dataset.getInteger("oid_producto"));
        producto.setCodigo(dataset.getString("codigo"));
        producto.setDescripcion(dataset.getString("descripcion"));
        producto.setDesc_abrev(dataset.getString("desc_abrev"));
        producto.setComprable(dataset.getBoolean("comprable"));
        producto.setVendible(dataset.getBoolean("vendible"));
        producto.setStockeable(dataset.getBoolean("stockeable"));
        producto.setProd_propia(dataset.getBoolean("prod_propia"));
        producto.setImportado(dataset.getBoolean("importado"));
        producto.setSinonimo(dataset.getString("sinonimo"));
        producto.setCodigo_barra(dataset.getString("codigo_barra"));
        producto.setUm_vta(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_vta"),getSesion()));
        producto.setUm_stk(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_stk"),getSesion()));
        producto.setUm_stk_alt(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_stk_alt"),getSesion()));
        producto.setUm_cpra(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_cpra"),getSesion()));
        producto.setUm_prod(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_prod"),getSesion()));
        producto.setTolerancia_recep(dataset.getMoney("tolerancia_recep"));
        producto.setPorc_cump_oc(dataset.getMoney("porc_cump_oc"));
        producto.setSistema_calidad(dataset.getBoolean("sistema_calidad"));
        producto.setCuenta_cpra(Cuenta.findByOidProxy(dataset.getInteger("oid_ana_con_cpra"),getSesion()));
        producto.setModif_ai_cpra(dataset.getBoolean("modif_ai_cpra"));
        producto.setActivo(dataset.getBoolean("activo"));
        producto.setTipoproducto(TipoProducto.findByOidProxy(dataset.getInteger("oid_tipo_prod"),getSesion()));
        producto.setLt_entrega(dataset.getInteger("lt_entrega"));
        producto.setConcFactProv(ConcFactProv.findByOidProxy(dataset.getInteger("oid_conc_fact_prov"),getSesion()));
        producto.setLlevaPartida(dataset.getBoolean("lleva_partida"));
        producto.setLlevaSerie(dataset.getBoolean("lleva_serie"));
        producto.setCuentaVenta(CuentaImputable.findByOidProxy(dataset.getInteger("oid_cuenta_vta"),getSesion()));
        producto.setCantDecPrecioVta(dataset.getInteger("cant_dec_pv"));
        producto.setLeadTimeVta(dataset.getInteger("lead_time_vta"));
        producto.setPrecioNoDefLP(dataset.getBoolean("precio_no_def_lp").booleanValue());
        producto.setHabilitadaNotaDebitoInterna(dataset.getBoolean("hab_nd_int").booleanValue());
        producto.setHabilitadaNotaCreditoInterna(dataset.getBoolean("hab_nc_int").booleanValue());
        producto.setCalcPercIBBsAs(dataset.getBoolean("calc_perc_ib_ba").booleanValue());
        producto.setCalcPercIBCapFed(dataset.getBoolean("calc_perc_ib_cf").booleanValue());
        producto.setCalcPercIVA(dataset.getBoolean("calc_perc_iva").booleanValue());
        producto.setModifPrecioFactura(dataset.getBoolean("modif_precio_fact").booleanValue());
        producto.setSeguimientoStock(dataset.getBoolean("segui_stock").booleanValue());
        producto.setUsaParaSaldoPendFactSenia(dataset.getBoolean("usar_saldo_pend_fact_senia").booleanValue());
        producto.setIsSeniaFactura(dataset.getBoolean("es_senia_factura").booleanValue());
        producto.setTomarPrecioOC1(dataset.getString("tomar_precio_oc_1"));
        producto.setTomarPrecioOC2(dataset.getString("tomar_precio_oc_2"));
        producto.setTomarPrecioOC3(dataset.getString("tomar_precio_oc_3"));
        producto.setTomarPrecioOC4(dataset.getString("tomar_precio_oc_4"));
        producto.setFormaCalcCosto(dataset.getString("forma_calc_costo"));
        producto.setProveedorCosto(Proveedor.findByOidProxy(dataset.getInteger("oid_prov_costo"),getSesion()));
        
        IDataSet dsProductoProveedor = dataset.getDataSet("TProductoProveedor");
        dsProductoProveedor.first();
        while (!dsProductoProveedor.EOF()) {
          ProductoProveedor productoProveedor =
              (ProductoProveedor)ProductoProveedor.findByOid(dsProductoProveedor.getInteger("oid_prod_prov"),getSesion());
          productoProveedor.setProducto(producto);
          productoProveedor.setProveedor(Proveedor.findByOidProxy(dsProductoProveedor.getInteger("oid_proveedor"),getSesion()));
          productoProveedor.setCod_prod_prov(dsProductoProveedor.getString("cod_prod_prov"));
          productoProveedor.setUmcpra(UnidadMedida.findByOidProxy(dsProductoProveedor.getInteger("oid_um_cpra"),getSesion()));
          productoProveedor.setLote_minimo(dsProductoProveedor.getMoney("lote_minimo"));
          productoProveedor.setMultiplo(dsProductoProveedor.getMoney("multiplo"));
          productoProveedor.setLt_ent_dias(dsProductoProveedor.getInteger("lt_ent_dias"));
          productoProveedor.setPrioridadCompra(dsProductoProveedor.getInteger("prioridad"));
          producto.addProductoProveedor(productoProveedor);
          
          IDataSet dsFactConvProv = dsProductoProveedor.getDataSet("TFactConvProv");
          dsFactConvProv.first();
          while (!dsFactConvProv.EOF()) {
        	  FactorConversionProveedor factConvProv = FactorConversionProveedor.findByOid(dsFactConvProv.getInteger("oid_fact_conv_prov"),getSesion());
        	  factConvProv.setUnidad_medida(UnidadMedida.findByOidProxy(dsFactConvProv.getInteger("oid_um"),getSesion()));
        	  factConvProv.setProducto_proveedor(productoProveedor);
        	  factConvProv.setFactor_conversion(dsFactConvProv.getDouble("fact_conv"));
        	  if (!dsFactConvProv.getBoolean("activo").booleanValue())
        		  factConvProv.delete();
        	  productoProveedor.addFactorConversionProveedor(factConvProv);
        	  dsFactConvProv.next();
          }
          
          
          dsProductoProveedor.next();
        }

        IDataSet dsConceptosImpuestos = dataset.getDataSet("TConceptoImpuestoProducto");
        dsConceptosImpuestos.first();
        while (!dsConceptosImpuestos.EOF()) {
          ConceptoImpuestoProducto conceptoImpuestoProducto =
              (ConceptoImpuestoProducto)ConceptoImpuestoProducto.findByOid(dsConceptosImpuestos.getInteger("oid_conc_impu_prod"),getSesion());
          conceptoImpuestoProducto.setProducto(producto);
          conceptoImpuestoProducto.setConcepto_impuesto(ConceptoImpuesto.findByOidProxy(dsConceptosImpuestos.getInteger("oid_conc_impu"),getSesion()));
          conceptoImpuestoProducto.setFecha_vigencia(dsConceptosImpuestos.getDate("fecha_vigencia"));
          if (dsConceptosImpuestos.getBoolean("activo").booleanValue()==false)
        	  conceptoImpuestoProducto.delete();
          producto.addConceptoImpuesto(conceptoImpuestoProducto);
          dsConceptosImpuestos.next();
        }
        
        
        
        IDataSet dsCostosProducto = dataset.getDataSet("TCostoProducto");
        dsCostosProducto.first();
        while (!dsCostosProducto.EOF()) {
          CostoProducto costoProducto =
              (CostoProducto)CostoProducto.findByOid(dsCostosProducto.getInteger("oid_costo_producto"),getSesion());
          
          costoProducto.setProducto(producto);
          costoProducto.setFec_ult_costo(dsCostosProducto.getDate("fec_ult_costo"));
          costoProducto.setMoneda(Moneda.findByOidProxy(dsCostosProducto.getInteger("oid_moneda"), this.getSesion()));
          costoProducto.setCantidad(dsCostosProducto.getDouble("cantidad"));
          costoProducto.setUnidad_medida(UnidadMedida.findByOidProxy(dsCostosProducto.getInteger("oid_um"), this.getSesion()));
          costoProducto.setCosto(dsCostosProducto.getMoney("costo"));
          costoProducto.setActivo(dsCostosProducto.getBoolean("activo"));
          
          if (!costoProducto.isActivo())
        	  costoProducto.delete();
          
          
          producto.addCostoProducto(costoProducto);
          
          dsCostosProducto.next();
        }
        

        IDataSet dsConversionUM = dataset.getDataSet("TConversionUMProducto");
        dsConversionUM.first();
        while (!dsConversionUM.EOF()) {
          ConversionUMProducto conversionUMProducto =
              (ConversionUMProducto)ConversionUMProducto.findByOid(dsConversionUM.getInteger("oid_equiv_prod"),getSesion());
          conversionUMProducto.setProducto(producto);
          conversionUMProducto.setUnidad_medida_origen(UnidadMedida.findByOidProxy(dsConversionUM.getInteger("oid_um_origen"),getSesion()));
          conversionUMProducto.setUnidad_medida_dest(UnidadMedida.findByOidProxy(dsConversionUM.getInteger("oid_um_destino"),getSesion()));
          conversionUMProducto.setFact_conv(dsConversionUM.getDouble("fact_conv"));
          producto.addConversionUM(conversionUMProducto);
          dsConversionUM.next();
        }
        
        IDataSet dsConfProdPorLP = dataset.getDataSet("TConfProdPorLP");
        dsConfProdPorLP.first();
        while (!dsConfProdPorLP.EOF()) {
          ListaPrecios lp = ListaPrecios.findByOidProxy(dsConfProdPorLP.getInteger("oid_precio_cab"), this.getSesion());
          ConfProdPorLP confProdPorLP = ConfProdPorLP.getConfProdLP(producto, lp, this.getSesion());
          if (confProdPorLP == null) {
        	  confProdPorLP = (ConfProdPorLP) ConfProdPorLP.getNew(ConfProdPorLP.NICKNAME, this.getSesion());
        	  confProdPorLP.setProducto(producto);
        	  confProdPorLP.setLista_precios(lp);
          }
          confProdPorLP.setPorc_rent_sug(dsConfProdPorLP.getDouble("porc_rent_sug"));
          producto.addConfProdPorLP(confProdPorLP);
          dsConfProdPorLP.next();
        }
        
        
        IDataSet dsSeguiStock = dataset.getDataSet("TSeguimientoStock");
        dsSeguiStock.first();
        while (!dsSeguiStock.EOF()) {
        	SeguimientoStock segui = SeguimientoStock.findByOid(dsSeguiStock.getInteger("oid_segui_stock"), this.getSesion());
        	segui.setProducto(producto);
        	segui.setAgrupador_deposito(AgrupadorDeposito.findByOidProxy(dsSeguiStock.getInteger("oid_agrupador_depo"),getSesion()));
        	segui.setPunto_pedido(dsSeguiStock.getMoney("punto_pedido"));
        	segui.setStock_deseado(dsSeguiStock.getMoney("stock_deseado"));
        	
        	if (dsSeguiStock.getBoolean("activo").booleanValue()==false)
        		segui.delete();
        	
        	producto.addSeguimientoStock(segui);
        	
        	dsSeguiStock.next();
        }
        
        

        valoresAtributos(producto,dataset);
        grabarValoresClasif(producto,dataset);

        addTransaccion(producto);
        dataset.next();
    }
  }

  private void grabarValoresClasif(Producto producto,IDataSet dsSujeto) throws BaseException {
    IDataSet dsValClasif = dsSujeto.getDataSet("TValoresClasificadores");
    dsValClasif.first();
    while (!dsValClasif.EOF()) {
      producto.addOidValorClasif(dsValClasif.getInteger("nro_clasif"),
                                 dsValClasif.getInteger("oid_val_clasif_ent"));
      dsValClasif.next();
    }
  }
  
  private void valoresAtributos(Producto producto,IDataSet dsProducto) throws BaseException {
  	IDataSet dsAtriProd = dsProducto.getDataSet("TValoresAtributos");
  	
  	dsAtriProd.first();
  	while (!dsAtriProd.EOF()) {
  		
  		// Verificar si es un Grupo de Atributo Variables
  		Iterator gruposAtriVar = producto.getGruposAtributosVariables().iterator();
  		while (gruposAtriVar.hasNext()) {
  			
  			GrupoAtributoEntidadVar grupoAtriVar = (GrupoAtributoEntidadVar) gruposAtriVar.next();
  			String  campo              = "TP_OID_"+grupoAtriVar.getOIDInteger().toString();
  			Integer oidGrupoAtriEnVar  = dsAtriProd.getInteger(campo);
  			
  			GrupoDeAtributos grupoDeAtributos = GrupoDeAtributos.findByOid(oidGrupoAtriEnVar,this.getSesion());
  			producto.getValoresAtributos().addGrupoAtributoEntidadVar(grupoAtriVar,grupoDeAtributos);
  			
  		}
  		
  		Iterator iterAtributos = producto.getAtributos().iterator();
  		while (iterAtributos.hasNext()) {
  			Atributo atributo = (Atributo) iterAtributos.next();
  			
  			// Si es un componente
  			if (atributo.isValorCompo()) {
  				String  campo          = "COM_OID_"+atributo.getOIDInteger().toString();
  				Integer oidValorCompo  = dsAtriProd.getInteger(campo);
  				IObjetoLogico objLogCompo = atributo.getCompo().getValorCompo(oidValorCompo);
  				producto.getValoresAtributos().addValor(atributo,objLogCompo);
  			}  
  			
  			// Si es un entero
  			if (atributo.isEntero()) {
  				String  campo          = "INT_"+atributo.getOIDInteger().toString();
  				Integer valorEntero  = dsAtriProd.getInteger(campo);
  				producto.getValoresAtributos().addValor(atributo,valorEntero);
  			}
  			
  			// Si es un String
  			if (atributo.isString()) {
  				String  campo          = "TXT_"+atributo.getOIDInteger().toString();
  				String valorString  = dsAtriProd.getString(campo);
  				producto.getValoresAtributos().addValor(atributo,valorString);
  			} 
  			
  			// Si es un Double
  			if (atributo.isDecimal()) {
  				String  campo          = "DEC_"+atributo.getOIDInteger().toString();
  				Double valorDouble     = dsAtriProd.getDouble(campo);
  				producto.getValoresAtributos().addValor(atributo,valorDouble);
  			}
  			
  			// Si es un Double
  			if (atributo.isFecha()) {
  				String  campo              = "FEC_"+atributo.getOIDInteger().toString();
  				java.util.Date valorFecha  = dsAtriProd.getDate(campo);
  				producto.getValoresAtributos().addValor(atributo,valorFecha);
  			}  
  			  			
  		}
  		
  		
  	
  		
  		dsAtriProd.next();
  	}  		    	
  }


}
