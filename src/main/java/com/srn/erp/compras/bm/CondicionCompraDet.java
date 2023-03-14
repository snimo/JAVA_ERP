package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBCondicionCompraDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CondicionCompraDet extends ObjetoLogico {

  public CondicionCompraDet() {
  }

  public static String NICKNAME = "cp.CondicionCompraDet";

  private CondicionCompra condicionCompra;
  private String unidadVenc;
  private Integer cantidad;
  private Integer nroCuota;
  private Double porcentaje;
  private Boolean activo;

  public CondicionCompra getCondicioncompra() throws BaseException {
    supportRefresh();
    return condicionCompra;
  }

  public void setCondicioncompra(CondicionCompra aCondicioncompra) {
    this.condicionCompra =  aCondicioncompra;
  }

  public String getUnidadvenc() throws BaseException {
    supportRefresh();
    return unidadVenc;
  }

  public void setUnidadvenc(String aUnidadvenc) {
    this.unidadVenc =  aUnidadvenc;
  }

  public Integer getCantidad() throws BaseException {
    supportRefresh();
    return cantidad;
  }

  public void setCantidad(Integer aCantidad) {
    this.cantidad =  aCantidad;
  }

  public Integer getNrocuota() throws BaseException {
    supportRefresh();
    return nroCuota;
  }

  public void setNrocuota(Integer aNrocuota) {
    this.nroCuota =  aNrocuota;
  }

  public Double getPorcentaje() throws BaseException {
    supportRefresh();
    return porcentaje;
  }

  public void setPorcentaje(Double aPorcentaje) {
    this.porcentaje =  aPorcentaje;
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

 public static CondicionCompraDet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CondicionCompraDet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CondicionCompraDet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CondicionCompraDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(condicionCompra, "Debe ingresar el código");
    Validar.noNulo(unidadVenc, "Debe ingresar la Descripción");
    Validar.noNulo(cantidad, "Debe ingresar la cantidad");
    Validar.noNulo(nroCuota, "Debe ingresar el Nro. de Cuota");
    Validar.noNulo(porcentaje, "Debe Ingresar el Porcentaje");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La Condición de compra detalle debe ingresarse en modo activo");

 }

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

  public static List getCondicionesCompraDet(CondicionCompra condicionCompra,
                                           ISesion aSesion) throws BaseException {
    return DBCondicionCompraDet.getCondicionCompraDet(condicionCompra,aSesion);
  }

  public boolean isDias() throws BaseException {
    if (getUnidadvenc().equals("DIAS"))
      return true;
    else
      return false;
  }

  public boolean isMeses() throws BaseException {
    if (getUnidadvenc().equals("MESES"))
      return true;
    else
      return false;
  }




}
