package com.srn.erp.ctasAPagar.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctasAPagar.da.DBComproProvDetCtaImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComproProvDetCtaImpu extends ObjetoLogico {

  public ComproProvDetCtaImpu() {
  }

  public static String NICKNAME = "cap.ComproProvDetCtaImpu";

  private CuentaImputable cuentaImputable;
  private Double importe;
  private ComproProveedorDet comproProvDet;
  private Boolean activo;
  private String comentario;

  public CuentaImputable getCuentaimputable() throws BaseException {
    supportRefresh();
    return cuentaImputable;
  }

  public void setCuentaimputable(CuentaImputable aCuentaimputable) {
    this.cuentaImputable =  aCuentaimputable;
  }
  
  public String getComentario() throws BaseException {
    supportRefresh();
    return this.comentario;
  }

  public void setComentario(String aComentario) {
    this.comentario =  aComentario;
  }
  

  public Double getImporte() throws BaseException {
    supportRefresh();
    return importe;
  }

  public void setImporte(Double aImporte) {
    this.importe =  aImporte;
  }

  public ComproProveedorDet getComproprovdet() throws BaseException {
    supportRefresh();
    return comproProvDet;
  }

  public void setComproprovdet(ComproProveedorDet aComproprovdet) {
    this.comproProvDet =  aComproprovdet;
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

 public static ComproProvDetCtaImpu findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ComproProvDetCtaImpu) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ComproProvDetCtaImpu findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ComproProvDetCtaImpu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(cuentaImputable, "Debe ingresar la cuenta contable");
    Validar.noNulo(importe, "Debe ingresar el Importe");
    Validar.noNulo(comproProvDet, "Debe ingresar el Detalle del Comprobante");
 }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }
  
  public static List getImputacionesContablesConcepto(ComproProveedorDet comproProvDet,
      ISesion aSesion) throws BaseException {
  	return DBComproProvDetCtaImpu.getImputacionesContablesConcepto(comproProvDet,aSesion);
  }
  

}
