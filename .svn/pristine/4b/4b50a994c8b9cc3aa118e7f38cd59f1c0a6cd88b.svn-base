package com.srn.erp.ctasAPagar.bm;

import java.util.List;

import com.srn.erp.ctasAPagar.da.DBComproProvVtoFijo;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComproProvVtoFijo extends ObjetoLogico {

  public ComproProvVtoFijo() {
  }

  public static String NICKNAME = "cap.ComproProvVtoFijo";

  private ComproCab comprobante;
  private java.util.Date fecha;
  private Double porcentaje;
  private Boolean activo;

  public ComproCab getComprobante() throws BaseException {
    supportRefresh();
    return comprobante;
  }

  public void setComprobante(ComproCab aComprobante) {
    this.comprobante =  aComprobante;
  }

  public java.util.Date getFecha() throws BaseException {
    supportRefresh();
    return fecha;
  }

  public void setFecha(java.util.Date aFecha) {
    this.fecha =  aFecha;
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

 public static ComproProvVtoFijo findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ComproProvVtoFijo) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ComproProvVtoFijo findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ComproProvVtoFijo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(fecha, "Debe ingresar el Vencimiento");
    Validar.noNulo(porcentaje, "Debe ingresar el Porcentaje");
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
  
  public static List getVtosFijos(ComproCab comproCab, ISesion aSesion) throws BaseException {
		return DBComproProvVtoFijo.getVtosFijos(comproCab,aSesion);
	}  

}
