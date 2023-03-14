package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.ventas.da.DBConfigTalonarioFactClie;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfigTalonarioFactClie extends ObjetoLogico {

  public ConfigTalonarioFactClie() {
  }

  public static String NICKNAME = "ve.ConfigTalonarioFactClie";

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

 public static ConfigTalonarioFactClie findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ConfigTalonarioFactClie) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ConfigTalonarioFactClie findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (ConfigTalonarioFactClie) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static ConfigTalonarioFactClie findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ConfigTalonarioFactClie) getObjectByCodigo(NICKNAME,codigo,aSesion);
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
      List listaOperHab = OperHabiTalonarioFactClie.getOperHabiTalonarioFactClie(this,getSesion());
      operacionesHabilitadas.addAll(listaOperHab);
      readOperacionesHabilitadas = false;
    }
    return operacionesHabilitadas;
  }

  public void addOperacionHabilitada(OperHabiTalonarioFactClie aOperHabiTalonarioFactClie) throws BaseException {
    aOperHabiTalonarioFactClie.setConf_tal_fact_clie(this);
    operacionesHabilitadas.add(aOperHabiTalonarioFactClie);
  }

  public void afterSave() throws BaseException {
    Iterator iterOperHabi = operacionesHabilitadas.iterator();
    while (iterOperHabi.hasNext()) {
      OperHabiTalonarioFactClie operHabi = (OperHabiTalonarioFactClie) iterOperHabi.next();
      operHabi.save();
      operHabi = null;
    }
    iterOperHabi = null;
  }

  public static ConfigTalonarioFactClie getConfigTalonarioFactClie(Talonario talonario,
                                                                   ISesion aSesion)
                                                                   throws BaseException {
    return DBConfigTalonarioFactClie.getConfigTalonarioFactClie(talonario,aSesion);

  }



}
