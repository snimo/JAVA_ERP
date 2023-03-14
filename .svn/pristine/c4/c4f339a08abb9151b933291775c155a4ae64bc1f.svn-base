package com.srn.erp.ctasACobrar.bm;

import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;

public class AplicacionComproClieDet extends ObjetoLogico {

  public AplicacionComproClieDet() {
  }

  public static String NICKNAME = "cac.AplicacionComproClieDet";

  private ComproCab comproCab;
  private TranClieVto tranClieVto;
  private Money aplicMonedaOri;
  private ValorCotizacion cotizMonOriCont;
  private ValorCotizacion cotizMonExt1Cont;
  private ValorCotizacion cotizMonExt2Cont;
  private ValorCotizacion cotizMonOriHoy;
  private ValorCotizacion cotizMonExt1Hoy;
  private ValorCotizacion cotizMonExt2Hoy;
  private Integer nroRelacion;
  private ComproCab comproAplicOri;
  private TranClieVto tranClieVtoAplic;

  public ComproCab getComprocab() throws BaseException {
    supportRefresh();
    return comproCab;
  }

  public void setComprocab(ComproCab aComprocab) {
    this.comproCab =  aComprocab;
  }

  public ComproCab getComproAplicOri() throws BaseException {
    supportRefresh();
    return comproAplicOri;
  }

  public void setComproAplicOri(ComproCab aComproAplicOri) {
    this.comproAplicOri =  aComproAplicOri;
  }


  public Integer getNroRelacion() throws BaseException {
    supportRefresh();
    return nroRelacion;
  }

  public void setNroRelacion(Integer aNroRelacion) throws BaseException {
    this.nroRelacion = aNroRelacion;
  }

  public TranClieVto getTranClieVto() throws BaseException {
    supportRefresh();
    return tranClieVto;
  }

  public void setTranClieVto(TranClieVto aTranClieVto) {
    this.tranClieVto =  aTranClieVto;
  }

  public TranClieVto getTranClieVtoAplic() throws BaseException {
    supportRefresh();
    return tranClieVtoAplic;
  }

  public void setTranClieVtoAplic(TranClieVto aTranClieVtoAplic) {
    this.tranClieVtoAplic =  aTranClieVtoAplic;
  }

  public Money getAplicmonedaori() throws BaseException {
    supportRefresh();
    return aplicMonedaOri;
  }

  public void setAplicmonedaori(Money aAplicmonedaori) {
    this.aplicMonedaOri =  aAplicmonedaori;
  }

  public ValorCotizacion getCotizmonoricont() throws BaseException {
    supportRefresh();
    return cotizMonOriCont;
  }

  public void setCotizmonoricont(ValorCotizacion aCotizmonoricont) {
    this.cotizMonOriCont =  aCotizmonoricont;
  }

  public ValorCotizacion getCotizmonext1cont() throws BaseException {
    supportRefresh();
    return cotizMonExt1Cont;
  }

  public void setCotizmonext1cont(ValorCotizacion aCotizmonext1cont) {
    this.cotizMonExt1Cont =  aCotizmonext1cont;
  }

  public ValorCotizacion getCotizmonext2cont() throws BaseException {
    supportRefresh();
    return cotizMonExt2Cont;
  }

  public void setCotizmonext2cont(ValorCotizacion aCotizmonext2cont) {
    this.cotizMonExt2Cont =  aCotizmonext2cont;
  }

  public ValorCotizacion getCotizmonorihoy() throws BaseException {
    supportRefresh();
    return cotizMonOriHoy;
  }

  public void setCotizmonorihoy(ValorCotizacion aCotizmonorihoy) {
    this.cotizMonOriHoy =  aCotizmonorihoy;
  }

  public ValorCotizacion getCotizmonext1hoy() throws BaseException {
    supportRefresh();
    return cotizMonExt1Hoy;
  }

  public void setCotizmonext1hoy(ValorCotizacion aCotizmonext1hoy) {
    this.cotizMonExt1Hoy =  aCotizmonext1hoy;
  }

  public ValorCotizacion getCotizmonext2hoy() throws BaseException {
    supportRefresh();
    return cotizMonExt2Hoy;
  }

  public void setCotizmonext2hoy(ValorCotizacion aCotizmonext2hoy) {
    this.cotizMonExt2Hoy =  aCotizmonext2hoy;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static AplicacionComproClieDet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (AplicacionComproClieDet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static AplicacionComproClieDet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (AplicacionComproClieDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
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

}
