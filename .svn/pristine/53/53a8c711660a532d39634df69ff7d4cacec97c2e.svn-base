package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBComproContaConsulta;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class ComproContaConsulta extends ObjetoLogico {

  public ComproContaConsulta() {
  }

  public static String NICKNAME = "cg.ComproContaConsulta";

  private java.util.Date emision;
  private java.util.Date imputacion;
  private String comentario;
  private Boolean anulado;
  private String tipoCompro;
  private String letra;
  private Integer lugEmi;
  private Integer nroExt;

  public java.util.Date getEmision() throws BaseException {
    supportRefresh();
    return emision;
  }

  public void setEmision(java.util.Date aEmision) {
    this.emision =  aEmision;
  }

  public String getTC() throws BaseException {
    supportRefresh();
    return tipoCompro;
  }

  public void setTC(String tc) {
    this.tipoCompro = tc;
  }

  public String getLetra() throws BaseException {
    supportRefresh();
    return letra;
  }

  public void setLetra(String letra) {
    this.letra = letra;
  }

  public Integer getLugEmi() throws BaseException {
    supportRefresh();
    return lugEmi;
  }

  public void setLugEmi(Integer lugEmi) {
    this.lugEmi = lugEmi;
  }

  public Integer getNroExt() throws BaseException {
    supportRefresh();
    return nroExt;
  }

  public void setNroExt(Integer nroExt) {
    this.nroExt = nroExt;
  }

  public java.util.Date getImputacion() throws BaseException {
    supportRefresh();
    return imputacion;
  }

  public void setImputacion(java.util.Date aImputacion) {
    this.imputacion =  aImputacion;
  }

  public String getComentario() throws BaseException {
    supportRefresh();
    return comentario;
  }

  public void setComentario(String aComentario) {
    this.comentario =  aComentario;
  }

  public Boolean isAnulado() throws BaseException {
    supportRefresh();
    return anulado;
  }

  public void setAnulado(Boolean aAnulado) {
    this.anulado =  aAnulado;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static ComproContaConsulta findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ComproContaConsulta) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ComproContaConsulta findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ComproContaConsulta) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
 }

  /**
   * isActivo
   *
   * @return Boolean
   */
  public Boolean isActivo() {
    return null;
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  public static List getComprobantes(Cuenta cuenta,
                                     Componente componente,
                                     ValorCompo valorCompo,
                                     java.util.Date fecImputacDesde,
                                     java.util.Date fecImputacHasta,
                                     ComproCab comproCab,
                                     TipoComprobante tipoComprobante,
                                     ISesion aSesion)
                                     throws BaseException {
    return DBComproContaConsulta.getComprobantes(
      cuenta,componente,valorCompo,
      fecImputacDesde,fecImputacHasta,
      comproCab,tipoComprobante,aSesion);

  }


}
