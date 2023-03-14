package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.da.DBCompoStkTalonarioRto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CompoStkTalonarioRto extends ObjetoLogico {

  public CompoStkTalonarioRto() {
  }

  public static String NICKNAME = "ve.CompoStkTalonarioRto";

  private OperHabiTalonarioRto oper_tal_rto;
  private TipoConfMovStkTalonario tipo_conf_mov;
  private Boolean usarPorDefecto;


  public Boolean isUsarPorDefecto() throws BaseException {
    supportRefresh();
    return usarPorDefecto;
  }

  public void setUsarPorDefecto(Boolean aUsarPorDefecto) throws BaseException {
    this.usarPorDefecto = aUsarPorDefecto;
  }

  public OperHabiTalonarioRto getOper_tal_rto() throws BaseException {
    supportRefresh();
    return oper_tal_rto;
  }

  public void setOper_tal_rto(OperHabiTalonarioRto aOper_tal_rto) {
    this.oper_tal_rto =  aOper_tal_rto;
  }

  public TipoConfMovStkTalonario getTipo_conf_mov() throws BaseException {
    supportRefresh();
    return tipo_conf_mov;
  }

  public void setTipo_conf_mov(TipoConfMovStkTalonario aTipo_conf_mov) {
    this.tipo_conf_mov =  aTipo_conf_mov;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static CompoStkTalonarioRto findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CompoStkTalonarioRto) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CompoStkTalonarioRto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (CompoStkTalonarioRto) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static CompoStkTalonarioRto findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CompoStkTalonarioRto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(oper_tal_rto, "Debe ingresar la Operación del Remito");
    Validar.noNulo(tipo_conf_mov, "Debe ingresar el Tipo de Movimiento de Stock");
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

  public static List getComportamientosStock(OperHabiTalonarioRto operHabiTalRto,
                                             ISesion aSesion) throws BaseException {
    return DBCompoStkTalonarioRto.getComportamientosStock(operHabiTalRto,aSesion);
  }

  public static CompoStkTalonarioRto getComportamientoStkTalonarioRto(
                                                      OperHabiTalonarioRto operHabiTalRto,
                                                      TipoConfMovStkTalonario tipo,
                                                      ISesion aSesion)
                                                      throws BaseException {
    return DBCompoStkTalonarioRto.getComportamientoStkTalonarioRto(operHabiTalRto,tipo,aSesion);
  }



}
