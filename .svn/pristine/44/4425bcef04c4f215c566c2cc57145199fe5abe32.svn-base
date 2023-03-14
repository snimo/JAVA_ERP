package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBUbiDepoHabTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UbiDepoHabTalonario extends ObjetoLogico {

  public UbiDepoHabTalonario() {
  }

  public static String NICKNAME = "st.UbiDepoHabTalonario";

  private MovStockTalonarioDeposito mov_stk_tal;
  private UbicacionDeposito ubicacion_deposito;
  private Boolean habilitado;
  private Boolean incluye_hijos;
  private Boolean usar_por_defecto;
  private Boolean activo;
  

  public MovStockTalonarioDeposito getMov_stk_tal() throws BaseException {
    supportRefresh();
    return mov_stk_tal;
  }

  public void setMov_stk_tal(MovStockTalonarioDeposito aMov_stk_tal) {
    this.mov_stk_tal =  aMov_stk_tal;
  }

  public UbicacionDeposito getUbicacion_deposito() throws BaseException {
    supportRefresh();
    return ubicacion_deposito;
  }

  public void setUbicacion_deposito(UbicacionDeposito aUbicacion_deposito) {
    this.ubicacion_deposito =  aUbicacion_deposito;
  }

  public Boolean isHabilitado() throws BaseException {
    supportRefresh();
    return habilitado;
  }

  public void setHabilitado(Boolean aHabilitado) {
    this.habilitado =  aHabilitado;
  }

  public Boolean isIncluye_hijos() throws BaseException {
    supportRefresh();
    return incluye_hijos;
  }

  public void setIncluye_hijos(Boolean aIncluye_hijos) {
    this.incluye_hijos =  aIncluye_hijos;
  }

  public Boolean isUsar_por_defecto() throws BaseException {
    supportRefresh();
    return usar_por_defecto;
  }

  public void setUsar_por_defecto(Boolean aUsar_por_defecto) {
    this.usar_por_defecto =  aUsar_por_defecto;
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

 public static UbiDepoHabTalonario findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (UbiDepoHabTalonario) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static UbiDepoHabTalonario findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (UbiDepoHabTalonario) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(mov_stk_tal, "Debe ingresar el Movimiento de Stock");
    Validar.noNulo(ubicacion_deposito, "Debe ingresar la Ubicación del Depósito");
    Validar.noNulo(habilitado, "Debe ingresar si esta habilitado");
    Validar.noNulo(incluye_hijos, "Debe ingresar si inclye sub-ubicaciones");
    Validar.noNulo(usar_por_defecto, "Debe indicar si la ubicación de usa por Defecto");
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

  public static List getUbicacionesHabilitadas(MovStockTalonarioDeposito movStockTalDepo,
                                              ISesion aSesion) throws BaseException {
    return DBUbiDepoHabTalonario.getUbicacionesHabilitadas(movStockTalDepo,aSesion);
  }

  public static UbiDepoHabTalonario getUbiDepoHabTalonario(MovStockTalonarioDeposito movStockTalDepo,
                                                           UbicacionDeposito ubicacionDeposito,
                                                           ISesion aSesion)
                                                           throws BaseException {
    return DBUbiDepoHabTalonario.getUbiDepoHabTalonario(movStockTalDepo,ubicacionDeposito,aSesion);
  }

}
