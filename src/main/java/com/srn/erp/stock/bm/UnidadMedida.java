package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBUnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UnidadMedida extends ObjetoLogico {

  public UnidadMedida() {
  }

  public static String NICKNAME = "st.UnidadMedida";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private String labelImpresion;

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }
  
  public String getLabelImpresion() throws BaseException {
    supportRefresh();
    return this.labelImpresion;
  }

  public void setLabelImpresion(String aLabelImpresion) {
    this.labelImpresion =  aLabelImpresion;
  }
  

  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion =  aDescripcion;
  }

  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) {
    this.activo =  aActivo;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static UnidadMedida findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (UnidadMedida) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static UnidadMedida findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (UnidadMedida) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static UnidadMedida findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (UnidadMedida) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(labelImpresion, "Debe ingresar la etiqueta de Impresión");
    Validar.noNulo(activo, "");
 }

 public static List getAllUnidadesDeMedida(ISesion aSesion) throws BaseException {
   return DBUnidadMedida.getAllUnidadesDeMedida(aSesion);
 }
 
 public static UnidadMedida getSugerenciaUMCompra(ISesion aSesion) throws BaseException {
   Integer oidUM =
       ValorParametro.findByCodigoParametro("UM_COMPRA_DEF_ABM_PROD",aSesion).getOidObjNeg();
   UnidadMedida unidadMedida = UnidadMedida.findByOid(oidUM,aSesion);
   return unidadMedida;
 }
 
 public static UnidadMedida getSugerenciaUMVenta(ISesion aSesion) throws BaseException {
   Integer oidUM =
       ValorParametro.findByCodigoParametro("UM_VTA_DEF_ABM_PROD",aSesion).getOidObjNeg();
   UnidadMedida unidadMedida = UnidadMedida.findByOid(oidUM,aSesion);
   return unidadMedida;
 }
 
 public static UnidadMedida getSugerenciaUMStockPPal(ISesion aSesion) throws BaseException {
   Integer oidUM =
       ValorParametro.findByCodigoParametro("UM_STOCK_PPAL_ABM_PROD",aSesion).getOidObjNeg();
   UnidadMedida unidadMedida = UnidadMedida.findByOid(oidUM,aSesion);
   return unidadMedida;
 } 
 
 public static UnidadMedida getSugerenciaUMStockAlt(ISesion aSesion) throws BaseException {
   Integer oidUM =
       ValorParametro.findByCodigoParametro("UM_STOCK_ALT_ABM_PROD",aSesion).getOidObjNeg();
   UnidadMedida unidadMedida = UnidadMedida.findByOid(oidUM,aSesion);
   return unidadMedida;
 }
 
 public static UnidadMedida getSugerenciaUMProduccion(ISesion aSesion) throws BaseException {
   Integer oidUM =
       ValorParametro.findByCodigoParametro("UM_PROD_DEF_ABM_PROD",aSesion).getOidObjNeg();
   UnidadMedida unidadMedida = UnidadMedida.findByOid(oidUM,aSesion);
   return unidadMedida;
 } 
 
 public static UnidadMedida getUMDefaultCostoProducto(ISesion aSesion) throws BaseException {
	Integer oidUM =
	       ValorParametro.findByCodigoParametro("UM_DEF_COSTO_PROD",aSesion).getOidObjNeg();
	UnidadMedida unidadMedida = UnidadMedida.findByOid(oidUM,aSesion);
	return unidadMedida;
 } 
 
 public static UnidadMedida getUMDefaultPrecioVenta(ISesion aSesion) throws BaseException {
		Integer oidUM =
		       ValorParametro.findByCodigoParametro("UM_DEF_PREC_VTA",aSesion).getOidObjNeg();
		UnidadMedida unidadMedida = UnidadMedida.findByOid(oidUM,aSesion);
		return unidadMedida;
 } 
 
 
 


}
