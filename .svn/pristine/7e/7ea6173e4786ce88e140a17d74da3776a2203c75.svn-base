package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.pagos.da.DBRetCabIBDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RetCabIBDet extends ObjetoLogico {

  public RetCabIBDet() {
  }

  public static String NICKNAME = "pag.RetCabIBDet";

  private RetCabIB retCabIB;
  private Money montoDesde;
  private Money montoHasta;
  private Money porc;
  private Money montoFijo;

  public RetCabIB getRetcabib() throws BaseException {
    supportRefresh();
    return retCabIB;
  }

  public void setRetcabib(RetCabIB aRetcabib) {
    this.retCabIB =  aRetcabib;
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

 public static RetCabIBDet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (RetCabIBDet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static RetCabIBDet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (RetCabIBDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
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

  public static List getRetIBDetByRetIBCab(RetCabIB retIBCab,
                                           ISesion aSesion) throws BaseException {
    return DBRetCabIBDet.getRetIBDetByRetIBCab(retIBCab,aSesion);
  }


}
