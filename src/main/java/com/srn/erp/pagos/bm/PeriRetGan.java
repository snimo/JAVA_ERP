package com.srn.erp.pagos.bm;

import java.util.Date;

import com.srn.erp.pagos.da.DBPeriRetGan;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class PeriRetGan extends ObjetoLogico {

  public PeriRetGan() {
  }

  public static String NICKNAME = "pag.PeriRetGan";

  private Date fecDesde;
  private Date fecHasta;
  private String descripcion;
  private String codInterno;
  private Boolean activo;

  public Date getFecdesde() throws BaseException {
    supportRefresh();
    return fecDesde;
  }

  public void setFecdesde(Date aFecdesde) {
    this.fecDesde =  aFecdesde;
  }

  public Date getFechasta() throws BaseException {
    supportRefresh();
    return fecHasta;
  }

  public void setFechasta(Date aFechasta) {
    this.fecHasta =  aFechasta;
  }

  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion =  aDescripcion;
  }

  public String getCodinterno() throws BaseException {
    supportRefresh();
    return codInterno;
  }

  public void setCodinterno(String aCodinterno) {
    this.codInterno =  aCodinterno;
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

 public static PeriRetGan findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (PeriRetGan) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static PeriRetGan findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (PeriRetGan) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static PeriRetGan findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (PeriRetGan) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
 }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  public static PeriRetGan getPeriRetGan(java.util.Date fecha,
                                        ISesion aSesion) throws BaseException {
    return DBPeriRetGan.getPeriRetGan(fecha,aSesion);
  }




}
