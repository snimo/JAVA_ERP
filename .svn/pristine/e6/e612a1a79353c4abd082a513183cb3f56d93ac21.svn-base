package com.srn.erp.ctacte.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoCtaCteClie extends ObjetoLogico {

  public TipoCtaCteClie() {
  }

  public static String NICKNAME = "cc.TipoCtaCteClie";

  private String codigo;
  private String descripcion;
  private Boolean activo;

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
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

 public static TipoCtaCteClie findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (TipoCtaCteClie) getObjectByOid(NICKNAME,oid,aSesion);
 }
 
 public static TipoCtaCteClie findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
   return (TipoCtaCteClie) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static TipoCtaCteClie findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (TipoCtaCteClie) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public static TipoCtaCteClie getTipoCtaCteClie(ISesion aSesion) throws BaseException {
	   Integer oidTipoCtaCteClie =
	       ValorParametro.findByCodigoParametro("TIPO_CTACTE_FACT_MOS",aSesion).getOidObjNeg();
	   TipoCtaCteClie tipoCtaCteClie = TipoCtaCteClie.findByOid(oidTipoCtaCteClie,aSesion);
	   return tipoCtaCteClie;
 }
 
 public static TipoCtaCteClie getTipoCtaCteClieAnticipoCliente(ISesion aSesion) throws BaseException {
   Integer oidTipoCtaCteClie =
       ValorParametro.findByCodigoParametro("TIPO_CTA_CLIE_PAGOS_A_CTA",aSesion).getOidObjNeg();
   TipoCtaCteClie tipoCtaCteClie = TipoCtaCteClie.findByOid(oidTipoCtaCteClie,aSesion);
   return tipoCtaCteClie;
}
 
 
 
 

}
