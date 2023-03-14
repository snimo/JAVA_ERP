package com.srn.erp.stock.bm;

import java.util.Date;

import com.srn.erp.stock.da.DBPeriodoStockReal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PeriodoStockReal extends ObjetoLogico {

  public PeriodoStockReal() {
  }

  public static String NICKNAME = "st.PeriodoStockReal";

  private String codigo;
  private String descripcion;
  private Date fechaDesde;
  private Date fechaHasta;
  private String tipo;
  private Boolean activo;

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion =  aDescripcion;
  }

  public Date getFechadesde() throws BaseException {
    supportRefresh();
    return fechaDesde;
  }

  public void setFechadesde(Date aFechadesde) {
    this.fechaDesde =  aFechadesde;
  }

  public Date getFechahasta() throws BaseException {
    supportRefresh();
    return fechaHasta;
  }

  public void setFechahasta(Date aFechahasta) {
    this.fechaHasta =  aFechahasta;
  }

  public String getTipo() throws BaseException {
    supportRefresh();
    return tipo;
  }

  public void setTipo(String aTipo) {
    this.tipo =  aTipo;
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

 public static PeriodoStockReal findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (PeriodoStockReal) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static PeriodoStockReal findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (PeriodoStockReal) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static PeriodoStockReal findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (PeriodoStockReal) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar un código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(fechaDesde, "Debe ingresar la Fecha Desde");
    Validar.noNulo(fechaHasta, "Debe Ingresar la Fecha Hasta");
    Validar.noNulo(tipo, "Debe ingresar el Tipo de Período");
   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El período debe estar en modo activo");

 }

 public static PeriodoStockReal getPeriodoStockReal(java.util.Date fecha,
                                                    ISesion aSesion)
                                                    throws BaseException {
   return DBPeriodoStockReal.getPeriodoStockReal(fecha,aSesion);
 }


}
