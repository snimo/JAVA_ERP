package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.da.DBOperHabiTalonarioAjuStk;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class OperHabiTalonarioAjuStk extends ObjetoLogico {

  public OperHabiTalonarioAjuStk() {
  }

  public static String NICKNAME = "st.OperHabiTalonarioAjuStk";

  private ConfigTalonarioAjuStk conf_tal_aju_stk;
  private String tipo_aju_stk;
  private Boolean usar_por_defecto;

  private List comportamientosStkTalAju = new ArrayList();
  private boolean readComportamientosStkTalAju = true;

  public ConfigTalonarioAjuStk getConf_tal_aju_stk() throws BaseException {
    supportRefresh();
    return conf_tal_aju_stk;
  }

  public void setConf_tal_aju_stk(ConfigTalonarioAjuStk aConf_tal_aju_stk) {
    this.conf_tal_aju_stk =  aConf_tal_aju_stk;
  }

  public String getTipo_aju_stk() throws BaseException {
    supportRefresh();
    return tipo_aju_stk;
  }

  public void setTipo_aju_stk(String aTipo_aju_stk) {
    this.tipo_aju_stk =  aTipo_aju_stk;
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

 public static OperHabiTalonarioAjuStk findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (OperHabiTalonarioAjuStk) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static OperHabiTalonarioAjuStk findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (OperHabiTalonarioAjuStk) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static OperHabiTalonarioAjuStk findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (OperHabiTalonarioAjuStk) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(conf_tal_aju_stk, "Debe ingresar la configuración del Talonario");
    Validar.noNulo(tipo_aju_stk, "Debe ingresar el Tipo de Ajuste de Stock");
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

  public static List getOperHabiTalonarioAjuStk(ConfigTalonarioAjuStk configTalAjuStk,
                                                ISesion aSesion) throws BaseException {
    return DBOperHabiTalonarioAjuStk.getOperHabiTalonarioAjuStk(configTalAjuStk,aSesion);
  }

  public List getComportamientosStkAju() throws BaseException {
    if (readComportamientosStkTalAju) {
      List listaComportamientos = CompoStkTalonarioAjuStk.getCompoStkTalonarioAjuStk(this,getSesion());
      comportamientosStkTalAju.addAll(listaComportamientos);
      readComportamientosStkTalAju = false;
    }
    return comportamientosStkTalAju;
  }

  public void addCompoStkTalAju(CompoStkTalonarioAjuStk compoStkTalonarioAju) throws BaseException {
    compoStkTalonarioAju.setOper_habi_tal_ajustk(this);
    comportamientosStkTalAju.add(compoStkTalonarioAju);
  }

  public void afterSave() throws BaseException {
    Iterator iterCompoStkTalonarioAju = comportamientosStkTalAju.iterator();
    while (iterCompoStkTalonarioAju.hasNext()) {
      CompoStkTalonarioAjuStk compoStkTalonarioAju = (CompoStkTalonarioAjuStk) iterCompoStkTalonarioAju.next();
      compoStkTalonarioAju.save();
      compoStkTalonarioAju = null;
    }
    iterCompoStkTalonarioAju = null;
  }


  public static OperHabiTalonarioAjuStk getOperHabiTalonarioAjuStk(ConfigTalonarioAjuStk configTalonarioAjuStk,
                                                                   String tipoAjuSttk,
                                                                   ISesion aSesion)
                                                      throws BaseException {
    return DBOperHabiTalonarioAjuStk.getOperHabiTalonarioAjuStk(configTalonarioAjuStk,tipoAjuSttk,aSesion);
  }




}
