package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.ventas.da.DBCondPagoUniOrg;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CondPagoUniOrg extends ObjetoLogico {

  public CondPagoUniOrg() {
  }

  public static String NICKNAME = "ve.CondPagoUniOrg";

  private CondicionPago condicion_pago;
  private UnidadOrganizativa unidad_organizativa;

  public CondicionPago getCondicion_pago() throws BaseException {
    supportRefresh();
    return condicion_pago;
  }

  public void setCondicion_pago(CondicionPago aCondicion_pago) {
    this.condicion_pago =  aCondicion_pago;
  }

  public UnidadOrganizativa getUnidad_organizativa() throws BaseException {
    supportRefresh();
    return unidad_organizativa;
  }

  public void setUnidad_organizativa(UnidadOrganizativa aUnidad_organizativa) {
    this.unidad_organizativa =  aUnidad_organizativa;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static CondPagoUniOrg findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CondPagoUniOrg) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CondPagoUniOrg findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CondPagoUniOrg) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(condicion_pago, "Debe ingresar la condición de Pago");
    Validar.noNulo(unidad_organizativa, "Debe ingresar la unidad organizativa");
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

  public static List getUniOrgCondPago(CondicionPago condicionPago,
                                       ISesion aSesion) throws BaseException {
    return DBCondPagoUniOrg.getUniOrgCondPago(condicionPago,aSesion);
  }

  public static CondPagoUniOrg getCondPagoUniOrg(CondicionPago condPago,
                                                 UnidadOrganizativa uniOrg,
                                                 ISesion aSesion)
                                                      throws BaseException {

    return DBCondPagoUniOrg.getCondPagoUniOrg(condPago,uniOrg,aSesion);
  }



}
