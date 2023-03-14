package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.ventas.da.DBRemitoDetMovStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RemitoDetMovStock extends ObjetoLogico {

  public RemitoDetMovStock() {
  }

  public static String NICKNAME = "ve.RemitoDetMovStock";

  private RemitoDet remito_detalle;
  private UbicacionDeposito ubicacion_deposito;
  private Producto producto;
  private Deposito deposito;
  private String tipo_mov;
  private EstadoStock estado_stock;
  private Boolean activo;
  private Boolean afectaStkFisico;

  public Boolean isAfectaStkFisico() throws BaseException {
    supportRefresh();
    return afectaStkFisico;
  }

  public void setAfectaStkFisico(Boolean aAfectaStkFisico) throws BaseException {
    this.afectaStkFisico = aAfectaStkFisico;
  }

  public RemitoDet getRemito_detalle() throws BaseException {
    supportRefresh();
    return remito_detalle;
  }

  public void setRemito_detalle(RemitoDet aRemito_detalle) {
    this.remito_detalle =  aRemito_detalle;
  }

  public UbicacionDeposito getUbicacion_deposito() throws BaseException {
    supportRefresh();
    return ubicacion_deposito;
  }

  public void setUbicacion_deposito(UbicacionDeposito aUbicacion_deposito) {
    this.ubicacion_deposito =  aUbicacion_deposito;
  }

  public Producto getProducto() throws BaseException {
    supportRefresh();
    return producto;
  }

  public void setProducto(Producto aProducto) {
    this.producto =  aProducto;
  }

  public Deposito getDeposito() throws BaseException {
    supportRefresh();
    return deposito;
  }

  public void setDeposito(Deposito aDeposito) {
    this.deposito =  aDeposito;
  }

  public String getTipo_mov() throws BaseException {
    supportRefresh();
    return tipo_mov;
  }

  public Integer getSigno() throws BaseException {
    if (getTipo_mov().equals(IStockeable.ENTRADA))
      return new Integer(1);
    else
      return new Integer(-1);
  }

  public void setTipo_mov(String aTipo_mov) {
    this.tipo_mov =  aTipo_mov;
  }

  public EstadoStock getEstado_stock() throws BaseException {
    supportRefresh();
    return estado_stock;
  }

  public void setEstado_stock(EstadoStock aEstado_stock) {
    this.estado_stock =  aEstado_stock;
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

 public static RemitoDetMovStock findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (RemitoDetMovStock) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static RemitoDetMovStock findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (RemitoDetMovStock) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(remito_detalle, "Debe ingresar el detalle del Remito");
    Validar.noNulo(ubicacion_deposito, "Debe ingresar la Ubicación del Depósito");
    Validar.noNulo(producto, "Debe ingresar el Producto");
    Validar.noNulo(deposito, "Debe ingresar el Depósito");
    Validar.noNulo(tipo_mov, "Debe ingresar el Tipo de Movimiento");
    Validar.noNulo(estado_stock, "Debe ingresar el Estado de Stock");
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

  public static List getDetallesMovStock(RemitoDet remitoDet,
                                          ISesion aSesion) throws BaseException {
    return DBRemitoDetMovStock.getRemitoDetMovStock(remitoDet,aSesion);
  }


}
