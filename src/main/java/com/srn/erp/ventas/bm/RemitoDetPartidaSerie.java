package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.stock.bm.Partida;
import com.srn.erp.stock.bm.Serie;
import com.srn.erp.ventas.da.DBRemitoDetPartidaSerie;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RemitoDetPartidaSerie extends ObjetoLogico {

  public RemitoDetPartidaSerie() {
  }

  public static String NICKNAME = "ve.RemitoDetPartidaSerie";

  private RemitoDet remito_detalle;
  private Partida partida;
  private Serie serie;
  private Double cantidad;
  private Boolean activo;

  public RemitoDet getRemito_detalle() throws BaseException {
    supportRefresh();
    return remito_detalle;
  }

  public void setRemito_detalle(RemitoDet aRemito_detalle) {
    this.remito_detalle =  aRemito_detalle;
  }

  public Partida getPartida() throws BaseException {
    supportRefresh();
    return partida;
  }

  public void setPartida(Partida aPartida) {
    this.partida =  aPartida;
  }

  public Serie getSerie() throws BaseException {
    supportRefresh();
    return serie;
  }

  public void setSerie(Serie aSerie) {
    this.serie =  aSerie;
  }

  public Double getCantidad() throws BaseException {
    supportRefresh();
    return cantidad;
  }

  public void setCantidad(Double aCantidad) {
    this.cantidad =  aCantidad;
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

 public static RemitoDetPartidaSerie findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (RemitoDetPartidaSerie) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static RemitoDetPartidaSerie findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (RemitoDetPartidaSerie) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(remito_detalle, "Debe ingresar el detatte del Remito");
    Validar.noNulo(cantidad, "Debe ingresar la cantidad");
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

  public static List getRemitoDetPartidasSeries(RemitoDet remitoDet,
                                                ISesion aSesion) throws BaseException {
    return DBRemitoDetPartidaSerie.getRemitoDetPartidasSeries(remitoDet,aSesion);
  }


}
