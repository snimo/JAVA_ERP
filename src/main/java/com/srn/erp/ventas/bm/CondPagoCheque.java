package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBCondPagoCheque;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CondPagoCheque extends ObjetoLogico {

  public CondPagoCheque() {
  }

  public static String NICKNAME = "ve.CondPagoCheque";

  private CondicionPago condicion_pago;
  private Integer dia_desde;
  private Integer dia_hasta;
  private Porcentaje porc_dto;
  private Porcentaje porc_recar;

  public CondicionPago getCondicion_pago() throws BaseException {
    supportRefresh();
    return condicion_pago;
  }

  public void setCondicion_pago(CondicionPago aCondicion_pago) {
    this.condicion_pago =  aCondicion_pago;
  }

  public Integer getDia_desde() throws BaseException {
    supportRefresh();
    return dia_desde;
  }

  public void setDia_desde(Integer aDia_desde) {
    this.dia_desde =  aDia_desde;
  }

  public Integer getDia_hasta() throws BaseException {
    supportRefresh();
    return dia_hasta;
  }

  public void setDia_hasta(Integer aDia_hasta) {
    this.dia_hasta =  aDia_hasta;
  }

  public Porcentaje getPorc_dto() throws BaseException {
    supportRefresh();
    return porc_dto;
  }

  public void setPorc_dto(Porcentaje aPorc_dto) {
    this.porc_dto =  aPorc_dto;
  }

  public Porcentaje getPorc_recar() throws BaseException {
    supportRefresh();
    return porc_recar;
  }

  public void setPorc_recar(Porcentaje aPorc_recar) {
    this.porc_recar =  aPorc_recar;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static CondPagoCheque findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CondPagoCheque) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CondPagoCheque findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CondPagoCheque) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(condicion_pago, "Debe ingresar la Condición de Pago");
    Validar.noNulo(dia_desde, "Debe ingresar la dia desde");
    Validar.noNulo(dia_hasta, "Debe ingresar la día hasta");
    Validar.noNulo(porc_dto, "Debe ingresar el Porc. Descuento");
    Validar.noNulo(porc_recar, "Debe ingresar el Porc. Recargo");
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

  public static List getChequesCondPago(CondicionPago condPago,
                                        ISesion aSesion) throws BaseException {
    return DBCondPagoCheque.getChequesCondPago(condPago,aSesion);
  }


}
