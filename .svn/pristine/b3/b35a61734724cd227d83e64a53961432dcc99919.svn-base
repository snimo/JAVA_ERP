package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.ventas.da.DBOperHabiTalonarioFactClie;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class OperHabiTalonarioFactClie extends ObjetoLogico {

  public OperHabiTalonarioFactClie() {
  }

  public static String NICKNAME = "ve.OperHabiTalonarioFactClie";

  private ConfigTalonarioFactClie conf_tal_fact_clie;
  private String tipo_facturacion;
  private Boolean usar_por_defecto;

  private List comportamientosStkFactClie = new ArrayList();
  private boolean readComportamientosStkTalFactClie = true;

  public ConfigTalonarioFactClie getConf_tal_fact_clie() throws BaseException {
    supportRefresh();
    return conf_tal_fact_clie;
  }

  public void setConf_tal_fact_clie(ConfigTalonarioFactClie aConf_tal_fact_clie) {
    this.conf_tal_fact_clie =  aConf_tal_fact_clie;
  }

  public String getTipo_facturacion() throws BaseException {
    supportRefresh();
    return tipo_facturacion;
  }

  public void setTipo_facturacion(String aTipo_facturacion) {
    this.tipo_facturacion =  aTipo_facturacion;
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

 public static OperHabiTalonarioFactClie findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (OperHabiTalonarioFactClie) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static OperHabiTalonarioFactClie findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (OperHabiTalonarioFactClie) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static OperHabiTalonarioFactClie findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (OperHabiTalonarioFactClie) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(conf_tal_fact_clie, "Debe Ingresar la Configuración del Talonario");
    Validar.noNulo(tipo_facturacion, "Debe ingresar la Operación de Facturación");
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

  public static List getOperHabiTalonarioFactClie(ConfigTalonarioFactClie configTalFactClie,
                                                  ISesion aSesion)
                                                  throws BaseException {
    return DBOperHabiTalonarioFactClie.getOperHabiTalonarioFactClie(configTalFactClie,aSesion);
  }

  public static OperHabiTalonarioFactClie getOperHabiTalonarioFactClie(ConfigTalonarioFactClie configTalonarioFactClie,
                                                                       String tipoFacturacion,
                                                                       ISesion aSesion)
                                                      throws BaseException {
    return DBOperHabiTalonarioFactClie.getOperHabiTalonarioFactClie(configTalonarioFactClie,
                                                                    tipoFacturacion,
                                                                    aSesion);
  }

  public List getComportamientosStkFactClie() throws BaseException {
    if (readComportamientosStkTalFactClie) {
      List listaComportamientos = CompoStkTalonarioFactClie.getCompoStkTalonarioFactClie(this,getSesion());
      comportamientosStkFactClie.addAll(listaComportamientos);
      readComportamientosStkTalFactClie = false;
    }
    return comportamientosStkFactClie;
  }

  public void addCompoStkTalFactClie(CompoStkTalonarioFactClie compoStkTalonarioFactClie) throws BaseException {
    compoStkTalonarioFactClie.setOper_tal_fact_clie(this);
    comportamientosStkFactClie.add(compoStkTalonarioFactClie);
  }

  public void afterSave() throws BaseException {
    Iterator iterCompoStkTalonarioFactClie = comportamientosStkFactClie.iterator();
    while (iterCompoStkTalonarioFactClie.hasNext()) {
      CompoStkTalonarioFactClie compoStkTalonarioFactClie = (CompoStkTalonarioFactClie) iterCompoStkTalonarioFactClie.next();
      compoStkTalonarioFactClie.save();
      compoStkTalonarioFactClie = null;
    }
    iterCompoStkTalonarioFactClie = null;
  }



}
