package com.srn.erp.general.op;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.TipoProducto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerParamImple extends Operation { 

  public TraerParamImple() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet ds = getDataSetParamImple();
	cargarRegistro(ds);
	writeCliente(ds);
	
  }

  private IDataSet getDataSetParamImple() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TParamImpleSist");
    dataset.fieldDef(new Field("oid_tipo_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_prod", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_tipo_prod", Field.STRING, 255));
    
    dataset.fieldDef(new Field("es_comprable", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_vendible", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_stockeable", Field.BOOLEAN, 0));
    
    dataset.fieldDef(new Field("oid_tipo_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_prod", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_tipo_prod", Field.STRING, 255));
    
    dataset.fieldDef(new Field("oid_um_compra_alta_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_um_compra_alta_prod", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_um_compra_alta_prod", Field.STRING, 255));
    
    dataset.fieldDef(new Field("oid_um_venta_alta_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_um_venta_alta_prod", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_um_venta_alta_prod", Field.STRING, 255));    
    
    dataset.fieldDef(new Field("oid_um_stock_alta_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_um_stock_alta_prod", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_um_stock_alta_prod", Field.STRING, 255));    
    
    dataset.fieldDef(new Field("oid_um_stock_alt_alta_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_um_stock_alt_alta_prod", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_um_stock_alt_alta_prod", Field.STRING, 255));
    
    dataset.fieldDef(new Field("oid_um_prod_alta_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_um_prod_alta_prod", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_um_prod_alta_prod", Field.STRING, 255));    
    
    dataset.fieldDef(new Field("cant_dec_def_abm_prod", Field.INTEGER, 0));
    
    dataset.fieldDef(new Field("oid_conc_imp_iva_def_abm_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_conc_imp_iva_def_abm_prod", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_conc_imp_iva_def_abm_prod", Field.STRING, 255));
    
    dataset.fieldDef(new Field("cod_sku_numerico", Field.BOOLEAN, 0));
    
    
    
    
    
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset) throws BaseException {
    dataset.append();
    
    
    try {
    	TipoProducto tipoProducto = TipoProducto.getTipoProductoDefault(this.getSesion()); 
    	dataset.fieldValue("oid_tipo_prod", tipoProducto.getOIDInteger());
    	dataset.fieldValue("cod_tipo_prod", tipoProducto.getCodigo());
    	dataset.fieldValue("desc_tipo_prod", tipoProducto.getDescripcion());
    }
    catch (Exception e) {
    	dataset.fieldValue("oid_tipo_prod", new Integer(0));
    	dataset.fieldValue("cod_tipo_prod", "");
    	dataset.fieldValue("desc_tipo_prod", "");
    }
    
    try {
    	dataset.fieldValue("es_comprable", Producto.isSugerirProdComprable(this.getSesion()));
    }
    catch (Exception e) {
    	dataset.fieldValue("es_comprable", false);
    }
    
    try {
    	dataset.fieldValue("es_vendible", Producto.isSugerirProdVendible(this.getSesion()));
    }
    catch (Exception e) {
    	dataset.fieldValue("es_vendible", false);
    }
    
    try {
    	dataset.fieldValue("es_stockeable", Producto.isSugerirProdStockeable(this.getSesion()));
    }
    catch (Exception e) {
    	dataset.fieldValue("es_stockeable", false);
    }    
    
    try {
    	UnidadMedida um = UnidadMedida.getSugerenciaUMCompra(this.getSesion()); 
    	dataset.fieldValue("oid_um_compra_alta_prod", um.getOIDInteger());
    	dataset.fieldValue("cod_um_compra_alta_prod", um.getCodigo());
    	dataset.fieldValue("desc_um_compra_alta_prod", um.getDescripcion());
    }
    catch (Exception e) {
    	dataset.fieldValue("oid_um_compra_alta_prod", new Integer(0));
    	dataset.fieldValue("cod_um_compra_alta_prod", "");
    	dataset.fieldValue("desc_um_compra_alta_prod", "");
    }
    
    try {
    	UnidadMedida um = UnidadMedida.getSugerenciaUMVenta(this.getSesion()); 
    	dataset.fieldValue("oid_um_venta_alta_prod", um.getOIDInteger());
    	dataset.fieldValue("cod_um_venta_alta_prod", um.getCodigo());
    	dataset.fieldValue("desc_um_venta_alta_prod", um.getDescripcion());
    }
    catch (Exception e) {
    	dataset.fieldValue("oid_um_venta_alta_prod", new Integer(0));
    	dataset.fieldValue("cod_um_venta_alta_prod", "");
    	dataset.fieldValue("desc_um_venta_alta_prod", "");
    }    
    
    try {
    	UnidadMedida um = UnidadMedida.getSugerenciaUMStockPPal(this.getSesion()); 
    	dataset.fieldValue("oid_um_stock_alta_prod", um.getOIDInteger());
    	dataset.fieldValue("cod_um_stock_alta_prod", um.getCodigo());
    	dataset.fieldValue("desc_um_stock_alta_prod", um.getDescripcion());
    }
    catch (Exception e) {
    	dataset.fieldValue("oid_um_stock_alta_prod", new Integer(0));
    	dataset.fieldValue("cod_um_stock_alta_prod", "");
    	dataset.fieldValue("desc_um_stock_alta_prod", "");
    }    
    
    try {
    	UnidadMedida um = UnidadMedida.getSugerenciaUMStockAlt(this.getSesion()); 
    	dataset.fieldValue("oid_um_stock_alt_alta_prod", um.getOIDInteger());
    	dataset.fieldValue("cod_um_stock_alt_alta_prod", um.getCodigo());
    	dataset.fieldValue("desc_um_stock_alt_alta_prod", um.getDescripcion());
    }
    catch (Exception e) {
    	dataset.fieldValue("oid_um_stock_alt_alta_prod", new Integer(0));
    	dataset.fieldValue("cod_um_stock_alt_alta_prod", "");
    	dataset.fieldValue("desc_um_stock_alt_alta_prod", "");
    }    
    
    try {
    	UnidadMedida um = UnidadMedida.getSugerenciaUMProduccion(this.getSesion()); 
    	dataset.fieldValue("oid_um_prod_alta_prod", um.getOIDInteger());
    	dataset.fieldValue("cod_um_prod_alta_prod", um.getCodigo());
    	dataset.fieldValue("desc_um_prod_alta_prod", um.getDescripcion());
    }
    catch (Exception e) {
    	dataset.fieldValue("oid_um_prod_alta_prod", new Integer(0));
    	dataset.fieldValue("cod_um_prod_alta_prod", "");
    	dataset.fieldValue("desc_um_prod_alta_prod", "");
    }    
    
    try {
    	Integer cantDecimales = ValorParametro.findByCodigoParametro(
			"CANT_DEC_PV_DEF_ABM_PROD", this.getSesion()).getValorEntero();
    	dataset.fieldValue("cant_dec_def_abm_prod", cantDecimales);
    } catch(Exception e) {
    	dataset.fieldValue("cant_dec_def_abm_prod", new Integer(0));
    }
    
    try {
    	ConceptoImpuesto conc = ConceptoImpuesto.getSugerenciaConcImpIVA(this.getSesion()); 
    	dataset.fieldValue("oid_conc_imp_iva_def_abm_prod", conc.getOIDInteger());
    	dataset.fieldValue("cod_conc_imp_iva_def_abm_prod", conc.getCodigo());
    	dataset.fieldValue("desc_conc_imp_iva_def_abm_prod", conc.getDescripcion());
    }
    catch (Exception e) {
    	dataset.fieldValue("oid_conc_imp_iva_def_abm_prod", new Integer(0));
    	dataset.fieldValue("cod_conc_imp_iva_def_abm_prod", "");
    	dataset.fieldValue("desc_conc_imp_iva_def_abm_prod", "");
    }    
    
    try {
    	dataset.fieldValue("cod_sku_numerico" , Producto.isCodigoNumerico(this.getSesion()));
    } catch(Exception e) {
    	dataset.fieldValue("cod_sku_numerico" , new Boolean(false));
    }
    
    
  }
  
  
}
