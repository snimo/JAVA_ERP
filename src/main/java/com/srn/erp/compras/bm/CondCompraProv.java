package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBCondCompraProv;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CondCompraProv extends ObjetoLogico {

  public CondCompraProv() {
  }

  public static String NICKNAME = "cp.CondCompraProv";

  private Proveedor proveedor;
  private CondicionCompra condCompra;
  private Double descuento;
  private Double recargo;
  private Boolean esPorDefecto;
  private Boolean activo;

  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) {
    this.activo =  aActivo;
  }


  public Boolean isPorDefecto() throws BaseException {
    supportRefresh();
    return esPorDefecto;
  }

  public void setPorDefecto(Boolean aEsPorDefecto) {
    this.esPorDefecto =  aEsPorDefecto;
  }


  public Proveedor getProveedor() throws BaseException {
    supportRefresh();
    return proveedor;
  }

  public void setProveedor(Proveedor aProveedor) {
    this.proveedor =  aProveedor;
  }

  public CondicionCompra getCondcompra() throws BaseException {
    supportRefresh();
    return condCompra;
  }

  public void setCondcompra(CondicionCompra aCondcompra) {
    this.condCompra =  aCondcompra;
  }

  public Double getDescuento() throws BaseException {
    supportRefresh();
    return descuento;
  }

  public void setDescuento(Double aDescuento) {
    this.descuento =  aDescuento;
  }

  public Double getRecargo() throws BaseException {
    supportRefresh();
    return recargo;
  }

  public void setRecargo(Double aRecargo) {
    this.recargo =  aRecargo;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static CondCompraProv findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CondCompraProv) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CondCompraProv findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CondCompraProv) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(proveedor, "Debe ingresarse el Proveedor");
    Validar.noNulo(condCompra, "Debe ingresarse la condición de Compra");
    Validar.noNulo(descuento, "Debe ingresarse el descuento");
    Validar.noNulo(recargo, "Debe ingresarse el recargo");
 }

  /**
   * isActivo
   *
   * @return Boolean
   */
  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  public static List getCondCompraByProveedor(Proveedor proveedor,
                                              ISesion aSesion) throws BaseException {

    return DBCondCompraProv.getCondCompraByProveedor(proveedor,aSesion);
  }


}
