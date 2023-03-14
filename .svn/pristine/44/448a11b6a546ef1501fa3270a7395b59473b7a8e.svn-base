package com.srn.erp.general.op;

import framework.applicarionServer.bm.Parametros.Parametro;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveParamImple extends Operation {

  public SaveParamImple() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TParamImpleSist");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
    while (!dataset.EOF()) {
    	setParamOidObjNeg(dataset,"TIPO_PROD_DEF_ABM_PROD",dataset.getInteger("oid_tipo_prod"));
    	setParamBoolean(dataset,"ES_COMPRABLE_DEF_ABM_PROD",dataset.getBoolean("es_comprable"));
    	setParamBoolean(dataset,"ES_VENDIBLE_DEF_ABM_PROD",dataset.getBoolean("es_vendible"));
    	setParamBoolean(dataset,"ES_STOCKEABLE_DEF_ABM_PROD",dataset.getBoolean("es_stockeable"));
    	setParamBoolean(dataset,"COD_SKU_NUMERICO",dataset.getBoolean("cod_sku_numerico"));
    	setParamOidObjNeg(dataset,"UM_COMPRA_DEF_ABM_PROD",dataset.getInteger("oid_um_compra_alta_prod"));
    	setParamOidObjNeg(dataset,"UM_VTA_DEF_ABM_PROD",dataset.getInteger("oid_um_venta_alta_prod"));
    	setParamOidObjNeg(dataset,"UM_STOCK_PPAL_ABM_PROD",dataset.getInteger("oid_um_stock_alta_prod"));
    	setParamOidObjNeg(dataset,"UM_STOCK_ALT_ABM_PROD",dataset.getInteger("oid_um_stock_alt_alta_prod"));
    	setParamOidObjNeg(dataset,"UM_PROD_DEF_ABM_PROD",dataset.getInteger("oid_um_prod_alta_prod"));
    	setParamInteger(dataset,"CANT_DEC_PV_DEF_ABM_PROD",dataset.getInteger("cant_dec_def_abm_prod"));
    	setParamOidObjNeg(dataset,"CONC_IMP_IVA_DEF_ABM_PROD",dataset.getInteger("oid_conc_imp_iva_def_abm_prod"));
    	
    	dataset.next();
    }
  }
  
  private void setParamOidObjNeg(IDataSet ds,String codigoParametro, Integer oidObjNeg) throws BaseException {
	  
	  Parametro parametro = Parametro.findByCodigo(codigoParametro,this.getSesion());
	  ValorParametro valorParametro = ValorParametro.findByParametro(parametro, getSesion());
	  if (valorParametro == null)
		  valorParametro = (ValorParametro)ValorParametro.getNew(ValorParametro.NICKNAME, this.getSesion());
	  valorParametro.setParametro(parametro);
	  valorParametro.setOidObjNeg(oidObjNeg);
	  valorParametro.setActivo(new Boolean(true));
	  valorParametro.setOidSucursal(new Integer(0));
	  valorParametro.setOidUsuario(new Integer(0));
	  if (oidObjNeg==null)
		  valorParametro.delete();
	  addTransaccion(valorParametro);
		  
  }
  
  private void setParamBoolean(IDataSet ds,String codigoParametro, Boolean valor) throws BaseException {
	  
	  Parametro parametro = Parametro.findByCodigo(codigoParametro,this.getSesion());
	  ValorParametro valorParametro = ValorParametro.findByParametro(parametro, getSesion());
	  if (valorParametro == null)
		  valorParametro = (ValorParametro)ValorParametro.getNew(ValorParametro.NICKNAME, this.getSesion());
	  valorParametro.setParametro(parametro);
	  if ((valor!=null) && (valor.booleanValue()==true))
		  valorParametro.setValorCadena("Si");
	  else
		  valorParametro.setValorCadena("No");
	  valorParametro.setActivo(new Boolean(true));
	  valorParametro.setOidSucursal(new Integer(0));
	  valorParametro.setOidUsuario(new Integer(0));
	  addTransaccion(valorParametro);
		  
  }
  
  private void setParamDouble(IDataSet ds,String codigoParametro, Double valor) throws BaseException {
	  
	  Parametro parametro = Parametro.findByCodigo(codigoParametro,this.getSesion());
	  ValorParametro valorParametro = ValorParametro.findByParametro(parametro, getSesion());
	  if (valorParametro == null)
		  valorParametro = (ValorParametro)ValorParametro.getNew(ValorParametro.NICKNAME, this.getSesion());
	  valorParametro.setParametro(parametro);
	  valorParametro.setValorDecimal(valor);
	  valorParametro.setActivo(new Boolean(true));
	  valorParametro.setOidSucursal(new Integer(0));
	  valorParametro.setOidUsuario(new Integer(0));
	  addTransaccion(valorParametro);
		  
  }  
  
  private void setParamInteger(IDataSet ds,String codigoParametro, Integer valor) throws BaseException {
	  
	  Parametro parametro = Parametro.findByCodigo(codigoParametro,this.getSesion());
	  ValorParametro valorParametro = ValorParametro.findByParametro(parametro, getSesion());
	  if (valorParametro == null)
		  valorParametro = (ValorParametro)ValorParametro.getNew(ValorParametro.NICKNAME, this.getSesion());
	  valorParametro.setParametro(parametro);
	  valorParametro.setValorEntero(valor);
	  valorParametro.setActivo(new Boolean(true));
	  valorParametro.setOidSucursal(new Integer(0));
	  valorParametro.setOidUsuario(new Integer(0));
	  addTransaccion(valorParametro);
		  
  }  
  

}
