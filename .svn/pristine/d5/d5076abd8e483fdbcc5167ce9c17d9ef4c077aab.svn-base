package com.srn.erp.pagos.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.da.DBPorcLibRetIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PorcLibRetIVA extends ObjetoLogico {

  public PorcLibRetIVA() {
  }

  public static String NICKNAME = "pag.PorcLibRetIVA";

  private SujetoImpositivo sujetoImpositivo;
  private Date fechaDesde;
  private Date fechaHasta;
  private Money porcentaje;
  private Boolean activo;
  private String decreto;

  public SujetoImpositivo getSujetoimpositivo() throws BaseException {
    supportRefresh();
    return sujetoImpositivo;
  }

  public void setSujetoimpositivo(SujetoImpositivo aSujetoimpositivo) {
    this.sujetoImpositivo =  aSujetoimpositivo;
  }

  public Date getFechadesde() throws BaseException {
    supportRefresh();
    return fechaDesde;
  }

  public void setFechadesde(Date aFechadesde) {
    this.fechaDesde =  aFechadesde;
  }

  public Date getFechahasta() throws BaseException {
    supportRefresh();
    return fechaHasta;
  }

  public void setFechahasta(Date aFechahasta) {
    this.fechaHasta =  aFechahasta;
  }

  public Money getPorcentaje() throws BaseException {
    supportRefresh();
    return porcentaje;
  }

  public void setPorcentaje(Money aPorcentaje) {
    this.porcentaje =  aPorcentaje;
  }

  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) {
    this.activo =  aActivo;
  }

  public String getDecreto() throws BaseException {
    supportRefresh();
    return decreto;
  }

  public void setDecreto(String aDecreto) {
    this.decreto =  aDecreto;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static PorcLibRetIVA findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (PorcLibRetIVA) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static PorcLibRetIVA findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (PorcLibRetIVA) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(sujetoImpositivo, "Debe ingresar el Sujeto Impositivo");
    Validar.noNulo(fechaDesde, "Debe ingresar la Fecha Desde");
    Validar.noNulo(fechaHasta, "Debe ingresar la Fecha Hasta");
    Validar.noNulo(porcentaje, "Debe ingresar el Porcentaje");
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

  public static List getPorcentajesLibRetIVA(SujetoImpositivo sujetoImpositivo,
                                             ISesion aSesion) throws BaseException {
    return DBPorcLibRetIVA.getPorcentajesLibRetIVA(sujetoImpositivo,aSesion);
  }


}
