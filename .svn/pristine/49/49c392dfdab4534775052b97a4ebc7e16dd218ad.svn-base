package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.pagos.da.DBRetCabIVADet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RetCabIVADet extends ObjetoLogico {

  public RetCabIVADet() {
  }

  public static String NICKNAME = "pag.RetCabIVADet";

  private RetCabIVA retCabIVA;
  private Money montoDesde;
  private Money montoHasta;
  private Money porc;
  private Money montoFijo;

  public RetCabIVA getRetcabiva() throws BaseException {
    supportRefresh();
    return retCabIVA;
  }

  public void setRetcabiva(RetCabIVA aRetcabiva) {
    this.retCabIVA =  aRetcabiva;
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

 public static RetCabIVADet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (RetCabIVADet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static RetCabIVADet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (RetCabIVADet) getObjectByCodigo(NICKNAME,codigo,aSesion);
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

  public static List getRetIVADetByRetIVACab(RetCabIVA retIVACab,
                                             ISesion aSesion) throws BaseException {
    return DBRetCabIVADet.getRetIVADetByRetIVACab(retIVACab,aSesion);
  }


}
