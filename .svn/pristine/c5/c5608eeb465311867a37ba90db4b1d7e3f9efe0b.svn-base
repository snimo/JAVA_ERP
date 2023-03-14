package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.ventas.da.DBConfigTalonarioRto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfigTalonarioRto extends ObjetoLogico {

  public ConfigTalonarioRto() {
  }

  public static String NICKNAME = "ve.ConfigTalonarioRto";

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

 public static ConfigTalonarioRto findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ConfigTalonarioRto) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ConfigTalonarioRto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (ConfigTalonarioRto) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static ConfigTalonarioRto findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ConfigTalonarioRto) getObjectByCodigo(NICKNAME,codigo,aSesion);
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
      List listaOperHabi = OperHabiTalonarioRto.getOperacionesHabilitadas(this,getSesion());
      operacionesHabilitadas.addAll(listaOperHabi);
      readOperacionesHabilitadas = false;
    }
    return operacionesHabilitadas;
  }

  public void addOperacionHabilitada(OperHabiTalonarioRto operHabiTalonarioRto) throws BaseException {
    operHabiTalonarioRto.setConfig_talonario_rto(this);
    operacionesHabilitadas.add(operHabiTalonarioRto);
  }

  public void afterSave() throws BaseException {
    Iterator iterOperHabilitadas = operacionesHabilitadas.iterator();
    while (iterOperHabilitadas.hasNext()) {
      OperHabiTalonarioRto operHabilitada = (OperHabiTalonarioRto) iterOperHabilitadas.next();
      operHabilitada.save();
      operHabilitada = null;
    }
    iterOperHabilitadas = null;
  }

  public static ConfigTalonarioRto getConfigTalonarioRto(Talonario talonario,
                                                         ISesion aSesion)
                                                      throws BaseException {
    return DBConfigTalonarioRto.getConfigTalonarioRto(talonario,aSesion);

  }


}
