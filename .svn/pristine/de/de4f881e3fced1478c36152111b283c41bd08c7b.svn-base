package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBCondPagoCuotas;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CondPagoCuotas extends ObjetoLogico {

  public CondPagoCuotas() {
  }

  public static String NICKNAME = "ve.CondPagoCuotas";

  private CondicionPago condicion_pago;
  private Integer cuota_desde;
  private Integer cuota_hasta;
  private Porcentaje porc_dto;
  private Porcentaje porc_recar;

  public CondicionPago getCondicion_pago() throws BaseException {
    supportRefresh();
    return condicion_pago;
  }

  public void setCondicion_pago(CondicionPago aCondicion_pago) {
    this.condicion_pago =  aCondicion_pago;
  }

  public Integer getCuota_desde() throws BaseException {
    supportRefresh();
    return cuota_desde;
  }

  public void setCuota_desde(Integer aCuota_desde) {
    this.cuota_desde =  aCuota_desde;
  }

  public Integer getCuota_hasta() throws BaseException {
    supportRefresh();
    return cuota_hasta;
  }

  public void setCuota_hasta(Integer aCuota_hasta) {
    this.cuota_hasta =  aCuota_hasta;
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

 public static CondPagoCuotas findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CondPagoCuotas) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CondPagoCuotas findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CondPagoCuotas) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(condicion_pago, "Debe ingresar la Condición de Pago");
    Validar.noNulo(cuota_desde, "Debe ingresar la cuota desde");
    Validar.noNulo(cuota_hasta, "Debe ingresar la cuota hasta");
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

  public static List getCuotasCondPago(CondicionPago condPago,
                                       ISesion aSesion) throws BaseException {
    return DBCondPagoCuotas.getCuotasCondPago(condPago,aSesion);
  }


}
