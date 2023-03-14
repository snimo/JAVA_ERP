package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.pagos.da.DBRetCabGanDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RetCabGanDet extends ObjetoLogico {

  public RetCabGanDet() {
  }

  public static String NICKNAME = "pag.RetCabGanDet";

  private RetCabGan retCabGan;
  private Money montoDesde;
  private Money montoHasta;
  private Money porc;
  private Money montoFijo;

  public RetCabGan getRetcabgan() throws BaseException {
    supportRefresh();
    return retCabGan;
  }

  public void setRetcabgan(RetCabGan aRetcabgan) {
    this.retCabGan =  aRetcabgan;
  }

  public Money getMontodesde() throws BaseException {
    supportRefresh();
    return montoDesde;
  }

  public void setMontodesde(Money aMontodesde) {
    this.montoDesde =  aMontodesde;
  }

  public Money getMontohasta() throws BaseException {
    supportRefresh();
    return montoHasta;
  }

  public void setMontohasta(Money aMontohasta) {
    this.montoHasta =  aMontohasta;
  }

  public Money getPorc() throws BaseException {
    supportRefresh();
    return porc;
  }

  public void setPorc(Money aPorc) {
    this.porc =  aPorc;
  }

  public Money getMontofijo() throws BaseException {
    supportRefresh();
    return montoFijo;
  }

  public void setMontofijo(Money aMontofijo) {
    this.montoFijo =  aMontofijo;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static RetCabGanDet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (RetCabGanDet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static RetCabGanDet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (RetCabGanDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
   Validar.noNulo(montoDesde, "Debe ingresar el Monto Desde");
   Validar.noNulo(montoHasta, "Debe ingresar el Monto Hasta");
   Validar.noNulo(porc, "Debe ingresar el Porcentaje");
   Validar.noNulo(montoFijo, "Debe ingresar el Monto Fijo");
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

  public static List getRetGanDetByRetGanCab(RetCabGan retGanCab,
                                             ISesion aSesion) throws BaseException {
    return DBRetCabGanDet.getRetGanDetByRetGanCab(retGanCab,aSesion);
  }

  public static RetCabGanDet getRetCabGanDet(RetCabGan retCabGan,Money monto,ISesion aSesion) throws BaseException {
    return DBRetCabGanDet.getRetGanDetByRetGanCabyMonto(retCabGan,monto,aSesion);
  }




}
