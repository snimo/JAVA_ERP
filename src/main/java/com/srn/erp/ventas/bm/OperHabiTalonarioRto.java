package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.ventas.da.DBOperHabiTalonarioRto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class OperHabiTalonarioRto extends ObjetoLogico {

  public OperHabiTalonarioRto() {
  }

  public static String NICKNAME = "ve.OperHabiTalonarioRto";

  private ConfigTalonarioRto config_talonario_rto;
  private String tipo_rto;
  private Boolean usarPorDefecto;

  private List comportamientosStock = new ArrayList();
  private boolean readComportamientosStock = true;


  public Boolean isUsarPorDefecto() throws BaseException {
    supportRefresh();
    return usarPorDefecto;
  }

  public void setUsarPorDefecto(Boolean aUsarPorDefecto) {
    this.usarPorDefecto = aUsarPorDefecto;
  }

  public ConfigTalonarioRto getConfig_talonario_rto() throws BaseException {
    supportRefresh();
    return config_talonario_rto;
  }

  public void setConfig_talonario_rto(ConfigTalonarioRto aConfig_talonario_rto) {
    this.config_talonario_rto =  aConfig_talonario_rto;
  }

  public String getTipo_rto() throws BaseException {
    supportRefresh();
    return tipo_rto;
  }

  public void setTipo_rto(String aTipo_rto) {
    this.tipo_rto =  aTipo_rto;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static OperHabiTalonarioRto findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (OperHabiTalonarioRto) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static OperHabiTalonarioRto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (OperHabiTalonarioRto) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static OperHabiTalonarioRto findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (OperHabiTalonarioRto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(config_talonario_rto, "Debe ingresar la Configuración del Talonario Remit");
    Validar.noNulo(tipo_rto, "Debe ingresar el Tipo de Remito");
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

  public static OperHabiTalonarioRto getOperHabilitada(ConfigTalonarioRto configTalonarioRto,
                                                       String tipoRemito,
                                                       ISesion aSesion)
                                                       throws BaseException {
     return DBOperHabiTalonarioRto.getOperHabilitada(configTalonarioRto,tipoRemito,aSesion);
   }

  public static List getOperacionesHabilitadas(ConfigTalonarioRto configTalonarioRto,
                                                ISesion aSesion) throws BaseException {
     return DBOperHabiTalonarioRto.getOperacionesHabilitadas(configTalonarioRto,aSesion);
  }

  public List getComportamientosStock() throws BaseException {
    if (readComportamientosStock) {
      List listaCompoStock = CompoStkTalonarioRto.getComportamientosStock(this,getSesion());
      comportamientosStock.addAll(listaCompoStock);
      readComportamientosStock = false;
    }
    return comportamientosStock;
  }

  public void addComportamientoStock(CompoStkTalonarioRto compoStkTalonarioRto) throws BaseException {
    compoStkTalonarioRto.setOper_tal_rto(this);
    comportamientosStock.add(compoStkTalonarioRto);
  }

  public void afterSave() throws BaseException {
    Iterator iterCompoStock = comportamientosStock.iterator();
    while (iterCompoStock.hasNext()) {
      CompoStkTalonarioRto compoStkTalonarioRto = (CompoStkTalonarioRto) iterCompoStock.next();
      compoStkTalonarioRto.save();
      compoStkTalonarioRto = null;
    }
    iterCompoStock = null;
  }



}
