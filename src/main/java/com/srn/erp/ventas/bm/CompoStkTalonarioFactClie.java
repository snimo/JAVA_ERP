package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.da.DBCompoStkTalonarioFactClie;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CompoStkTalonarioFactClie extends ObjetoLogico {

  public CompoStkTalonarioFactClie() {
  }

  public static String NICKNAME = "ve.CompoStkTalonarioFactClie";

  private OperHabiTalonarioFactClie oper_tal_fact_clie;
  private TipoConfMovStkTalonario tipo_conf_mov;
  private Boolean usar_por_defecto;

  public OperHabiTalonarioFactClie getOper_tal_fact_clie() throws BaseException {
    supportRefresh();
    return oper_tal_fact_clie;
  }

  public void setOper_tal_fact_clie(OperHabiTalonarioFactClie aOper_tal_fact_clie) {
    this.oper_tal_fact_clie =  aOper_tal_fact_clie;
  }

  public TipoConfMovStkTalonario getTipo_conf_mov() throws BaseException {
    supportRefresh();
    return tipo_conf_mov;
  }

  public void setTipo_conf_mov(TipoConfMovStkTalonario aTipo_conf_mov) {
    this.tipo_conf_mov =  aTipo_conf_mov;
  }

  public Boolean isUsar_por_defecto() throws BaseException {
    supportRefresh();
    return usar_por_defecto;
  }

  public void setUsar_por_defecto(Boolean aUsar_por_defecto) {
    this.usar_por_defecto =  aUsar_por_defecto;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static CompoStkTalonarioFactClie findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CompoStkTalonarioFactClie) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static CompoStkTalonarioFactClie findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
   return (CompoStkTalonarioFactClie) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }
 

 public static CompoStkTalonarioFactClie findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CompoStkTalonarioFactClie) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(oper_tal_fact_clie, "Debe Ingresar la Configuración del Talonario");
    Validar.noNulo(tipo_conf_mov, "Debe ingresar la Operación de Facturación");
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

  public static List getCompoStkTalonarioFactClie(OperHabiTalonarioFactClie operHab,
                                                  ISesion aSesion) throws BaseException {
    return DBCompoStkTalonarioFactClie.getCompoStkTalonarioFactClie(operHab,aSesion);
  }

  public static CompoStkTalonarioFactClie getCompoStkTalonarioFactClie(OperHabiTalonarioFactClie operHabTalFactClie,
                                                                   TipoConfMovStkTalonario tipoConfMov,
                                                                   ISesion aSesion)
                                                      throws BaseException {
    return DBCompoStkTalonarioFactClie.getCompoStkTalonarioFactClie(operHabTalFactClie,tipoConfMov,aSesion);
  }


}
