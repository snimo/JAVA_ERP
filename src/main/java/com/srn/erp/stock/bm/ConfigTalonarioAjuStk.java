package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.da.DBConfigTalonarioAjuStk;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfigTalonarioAjuStk extends ObjetoLogico {

  public ConfigTalonarioAjuStk() {
  }

  public static String NICKNAME = "st.ConfigTalonarioAjuStk";

  private Talonario talonario;
  private Boolean activo;

  private List operacionesHabilitadas = new ArrayList();
  private boolean readOperacionesHabilitadas = true;

  public Talonario getTalonario() throws BaseException {
    supportRefresh();
    return talonario;
  }

  public void setTalonario(Talonario aTalonario) {
    this.talonario =  aTalonario;
  }

  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) {
    this.activo =  aActivo;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static ConfigTalonarioAjuStk findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ConfigTalonarioAjuStk) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ConfigTalonarioAjuStk findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (ConfigTalonarioAjuStk) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static ConfigTalonarioAjuStk findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ConfigTalonarioAjuStk) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(talonario, "Debe ingresar el Talonario");
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

  public List getOperacionesHabilitadas() throws BaseException {
    if (readOperacionesHabilitadas) {
      List listaOperHab = OperHabiTalonarioAjuStk.getOperHabiTalonarioAjuStk(this,getSesion());
      operacionesHabilitadas.addAll(listaOperHab);
      readOperacionesHabilitadas = false;
    }
    return operacionesHabilitadas;
  }

  public void addOperacionHabilitada(OperHabiTalonarioAjuStk operHabiTaloAjuStk) throws BaseException {
    operHabiTaloAjuStk.setConf_tal_aju_stk(this);
    operacionesHabilitadas.add(operHabiTaloAjuStk);
  }

  public void afterSave() throws BaseException {
    Iterator iterOperHabi = operacionesHabilitadas.iterator();
    while (iterOperHabi.hasNext()) {
      OperHabiTalonarioAjuStk operHabiTaloAjuStk = (OperHabiTalonarioAjuStk) iterOperHabi.next();
      operHabiTaloAjuStk.save();
      operHabiTaloAjuStk = null;
    }
    iterOperHabi = null;
  }

  public static ConfigTalonarioAjuStk getConfigTalonarioAjuStk(Talonario talonario,
                                                               ISesion aSesion)
                                                      throws BaseException {
    return DBConfigTalonarioAjuStk.getConfigTalonarioAjuStk(talonario,aSesion);
  }



}
