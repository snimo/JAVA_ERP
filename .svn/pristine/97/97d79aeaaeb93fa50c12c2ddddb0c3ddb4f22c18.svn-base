package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.ventas.da.DBRemitoCabMovStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RemitoCabMovStock extends ObjetoLogico {

  public RemitoCabMovStock() {
  }

  public static String NICKNAME = "ve.RemitoCabMovStock";

  private RemitoCab remito_cabecera;
  private Deposito deposito;
  private String tipo_movi;
  private EstadoStock estado_stock;
  private UbicacionDeposito ubicacion_deposito;
  private Boolean activo;
  private Boolean afectaStkFisico;

  public Integer getSigno() throws BaseException {
    if (getTipo_movi().equals(IStockeable.ENTRADA))
      return new Integer(1);
    else
      return new Integer(-1);
  }

  public Boolean isAfectaStkFisico() throws BaseException {
    return this.afectaStkFisico;
  }

  public void setAfectaStockFisico(Boolean aAfectaStockFisico) throws BaseException {
    this.afectaStkFisico = aAfectaStockFisico;
  }

  public RemitoCab getRemito_cabecera() throws BaseException {
    supportRefresh();
    return remito_cabecera;
  }

  public void setRemito_cabecera(RemitoCab aRemito_cabecera) {
    this.remito_cabecera =  aRemito_cabecera;
  }

  public Deposito getDeposito() throws BaseException {
    supportRefresh();
    return deposito;
  }

  public void setDeposito(Deposito aDeposito) {
    this.deposito =  aDeposito;
  }

  public String getTipo_movi() throws BaseException {
    supportRefresh();
    return tipo_movi;
  }

  public void setTipo_movi(String aTipo_movi) {
    this.tipo_movi =  aTipo_movi;
  }

  public EstadoStock getEstado_stock() throws BaseException {
    supportRefresh();
    return estado_stock;
  }

  public void setEstado_stock(EstadoStock aEstado_stock) {
    this.estado_stock =  aEstado_stock;
  }

  public UbicacionDeposito getUbicacion_deposito() throws BaseException {
    supportRefresh();
    return ubicacion_deposito;
  }

  public void setUbicacion_deposito(UbicacionDeposito aUbicacion_deposito) {
    this.ubicacion_deposito =  aUbicacion_deposito;
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

 public static RemitoCabMovStock findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (RemitoCabMovStock) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static RemitoCabMovStock findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (RemitoCabMovStock) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(remito_cabecera, "Debe ingresar el Remito");
    Validar.noNulo(deposito, "Debe ingresar el Depósito");
    Validar.noNulo(tipo_movi, "Debe ingresar el Tipo de Movimiento");
    Validar.noNulo(estado_stock, "Debe ingresar el Estado de Stock");
    Validar.noNulo(ubicacion_deposito, "Debe ingresar la Ubicación del Depósito");
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

  public static List getMovimientosStock(RemitoCab remitoCab,
                                         ISesion aSesion) throws BaseException {
    return DBRemitoCabMovStock.getMovimientosStock(remitoCab,aSesion);
  }


}
