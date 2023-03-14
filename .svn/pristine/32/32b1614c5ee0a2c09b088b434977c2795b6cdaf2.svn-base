package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.da.DBRetCabGan;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RetCabGan extends ObjetoLogico {

  public RetCabGan() {
  }

  public static String NICKNAME = "pag.RetCabGan";

  private CatRetGan catRetGan;
  private ConceptoImpuesto concImpu;
  private Money montoNOImpo;
  private Money montoRetMin;
  private Date fecVigDesde;
  private Boolean activo;

  private List retCabGanDetalles = new ArrayList();
  private boolean readDetGan = true;

  public CatRetGan getCatretgan() throws BaseException {
    supportRefresh();
    return catRetGan;
  }

  public void setCatretgan(CatRetGan aCatretgan) {
    this.catRetGan =  aCatretgan;
  }

  public ConceptoImpuesto getConcimpu() throws BaseException {
    supportRefresh();
    return concImpu;
  }

  public void setConcimpu(ConceptoImpuesto aConcimpu) {
    this.concImpu =  aConcimpu;
  }

  public Money getMontonoimpo() throws BaseException {
    supportRefresh();
    return montoNOImpo;
  }

  public void setMontonoimpo(Money aMontonoimpo) {
    this.montoNOImpo =  aMontonoimpo;
  }

  public Money getMontoretmin() throws BaseException {
    supportRefresh();
    return montoRetMin;
  }

  public void setMontoretmin(Money aMontoretmin) {
    this.montoRetMin =  aMontoretmin;
  }

  public Date getFecvigdesde() throws BaseException {
    supportRefresh();
    return fecVigDesde;
  }

  public void setFecvigdesde(Date aFecvigdesde) {
    this.fecVigDesde =  aFecvigdesde;
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

 public static RetCabGan findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (RetCabGan) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static RetCabGan findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (RetCabGan) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }


 public static RetCabGan findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (RetCabGan) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(catRetGan, "Debe ingresar la Categoría de Retención de Gan.");
    Validar.noNulo(concImpu, "Debe Ingresar el Concepto de Impuesto");
    Validar.noNulo(montoNOImpo, "Debe Ingresar el Monto no Imponible");
    Validar.noNulo(montoRetMin, "Debe ingresar el Monto de Retención Mínima");
    Validar.noNulo(fecVigDesde, "Debe Ingresar la Fecha de Vigencia");
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

  public static List getAllRetGanCab(ISesion aSesion) throws BaseException {
    return DBRetCabGan.getAllRetGanCab(aSesion);
  }

  public List getDetallesRetGan() throws BaseException {
    if (readDetGan) {
      List listaDetalles = RetCabGanDet.getRetGanDetByRetGanCab(this,getSesion());
      retCabGanDetalles.addAll(listaDetalles);
      readDetGan = false;
    }
    return retCabGanDetalles;
  }

  public void addDetalleRetGan(RetCabGanDet detalleRetGan) throws BaseException {
    detalleRetGan.setRetcabgan(this);
    retCabGanDetalles.add(detalleRetGan);
  }

  public void afterSave() throws BaseException {
    Iterator iterRetGanDetalles = retCabGanDetalles.iterator();
    while (iterRetGanDetalles.hasNext()) {
      RetCabGanDet retCabGanDet = (RetCabGanDet) iterRetGanDetalles.next();
      retCabGanDet.save();
      retCabGanDet = null;
    }
    iterRetGanDetalles = null;
  }

  public static RetCabGan getRetGanCab(CatRetGan catRetGan,
                                       ConceptoImpuesto conceptoImpuesto,
                                       java.util.Date fecha,
                                       ISesion aSesion) throws BaseException {
   return DBRetCabGan.getRetGanCab(catRetGan,conceptoImpuesto,fecha,aSesion);
  }

  public RetCabGanDet getRetGanDet(Money monto) throws BaseException {
    return RetCabGanDet.getRetCabGanDet(this,monto,getSesion());
  }





}
