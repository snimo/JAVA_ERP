package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.da.DBRetCabIB;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RetCabIB extends ObjetoLogico {

  public RetCabIB() {
  }

  public static String NICKNAME = "pag.RetCabIB";

  private CatRetIB catRetIB;
  private ConceptoImpuesto concImpu;
  private Money montoNOImpo;
  private Money montoRetMin;
  private Date fecVigDesde;
  private Boolean activo;

  private List retCabIBDetalles = new ArrayList();
  private boolean readDetIB = true;

  public CatRetIB getCatretIB() throws BaseException {
    supportRefresh();
    return catRetIB;
  }

  public void setCatretIB(CatRetIB aCatretIB) {
    this.catRetIB =  aCatretIB;
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

 public static RetCabIB findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (RetCabIB) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static RetCabIB findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (RetCabIB) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static RetCabIB findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (RetCabIB) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(catRetIB, "Debe ingresar la Categoría de Retención de IB");
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

  public List getDetallesRetIB() throws BaseException {
    if (readDetIB) {
      List listaDetalles = RetCabIBDet.getRetIBDetByRetIBCab(this,getSesion());
      retCabIBDetalles.addAll(listaDetalles);
      readDetIB = false;
    }
    return retCabIBDetalles;
  }

  public void addDetalleRetIB(RetCabIBDet detalleRetIB) throws BaseException {
    detalleRetIB.setRetcabib(this);
    retCabIBDetalles.add(detalleRetIB);
  }

  public void afterSave() throws BaseException {
    Iterator iterRetIBDetalles = retCabIBDetalles.iterator();
    while (iterRetIBDetalles.hasNext()) {
      RetCabIBDet retCabIBDet = (RetCabIBDet) iterRetIBDetalles.next();
      retCabIBDet.save();
      retCabIBDet = null;
    }
    iterRetIBDetalles = null;
  }

  public static List getAllRetIBCab(ISesion aSesion) throws BaseException {
    return DBRetCabIB.getAllRetIBCab(aSesion);
  }

}
