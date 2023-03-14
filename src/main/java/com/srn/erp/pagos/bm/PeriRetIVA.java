package com.srn.erp.pagos.bm;

import java.util.Date;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PeriRetIVA extends ObjetoLogico {

  public PeriRetIVA() {
  }

  public static String NICKNAME = "pag.PeriRetIVA";

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

 public static PeriRetIVA findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (PeriRetIVA) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static PeriRetIVA findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (PeriRetIVA) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static PeriRetIVA findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (PeriRetIVA) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
   Validar.noNulo(fecDesde, "Debe ingresar la fecha Desde");
   Validar.noNulo(fecHasta, "Debe ingresar la fecha Hasta");
   Validar.noNulo(descripcion, "Debe ingresar la descripción");
 }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

}
