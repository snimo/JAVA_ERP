package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBCompoStkTalonarioAjuStk;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CompoStkTalonarioAjuStk extends ObjetoLogico {

  public CompoStkTalonarioAjuStk() {
  }

  public static String NICKNAME = "st.CompoStkTalonarioAjuStk";

  private OperHabiTalonarioAjuStk oper_habi_tal_ajustk;
  private TipoConfMovStkTalonario tipo_conf_mov_tal;
  private Boolean usar_por_defecto;

  public OperHabiTalonarioAjuStk getOper_habi_tal_ajustk() throws BaseException {
    supportRefresh();
    return oper_habi_tal_ajustk;
  }

  public void setOper_habi_tal_ajustk(OperHabiTalonarioAjuStk aOper_habi_tal_ajustk) {
    this.oper_habi_tal_ajustk =  aOper_habi_tal_ajustk;
  }

  public TipoConfMovStkTalonario getTipo_conf_mov_tal() throws BaseException {
    supportRefresh();
    return tipo_conf_mov_tal;
  }

  public void setTipo_conf_mov_tal(TipoConfMovStkTalonario aTipo_conf_mov_tal) {
    this.tipo_conf_mov_tal =  aTipo_conf_mov_tal;
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

 public static CompoStkTalonarioAjuStk findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CompoStkTalonarioAjuStk) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CompoStkTalonarioAjuStk findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (CompoStkTalonarioAjuStk) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static CompoStkTalonarioAjuStk findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CompoStkTalonarioAjuStk) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(oper_habi_tal_ajustk, "Debe ingresar la Operación Habilitada");
    Validar.noNulo(tipo_conf_mov_tal, "Debe ingresar el Tipo de Configuración Talonario");
    Validar.noNulo(usar_por_defecto, "Debe indicia si se utiliza o no por defecto");
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

  public static List getCompoStkTalonarioAjuStk(OperHabiTalonarioAjuStk operHab,
                                                ISesion aSesion) throws BaseException {
    return DBCompoStkTalonarioAjuStk.getCompoStkTalonarioAjuStk(operHab,aSesion);
  }

  public static CompoStkTalonarioAjuStk getCompoStkTalonarioAjuStk(OperHabiTalonarioAjuStk operHabTalAju,
                                                                   TipoConfMovStkTalonario tipoConfMov,
                                                                   ISesion aSesion)
                                                      throws BaseException {
    return DBCompoStkTalonarioAjuStk.getCompoStkTalonarioAjuStk(operHabTalAju,tipoConfMov,aSesion);
  }
  
  public static List getCompoStkTalonarioAjuStkByTipoAjuste(String aTipoAjuste,
      ISesion aSesion) throws BaseException {
  	return DBCompoStkTalonarioAjuStk.getCompoStkTalonarioAjuStkByTipoAjuste(aTipoAjuste,aSesion);
  }  



}
