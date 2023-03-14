package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.da.DBRetCabIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RetCabIVA extends ObjetoLogico {

  public RetCabIVA() {
  }

  public static String NICKNAME = "pag.RetCabIVA";

  private CatRetIVA catRetIVA;
  private ConceptoImpuesto concImpu;
  private Money montoNOImpo;
  private Money montoRetMin;
  private Date fecVigDesde;
  private Boolean activo;

  private List retCabIVADetalles = new ArrayList();
  private boolean readDetIVA = true;

  public CatRetIVA getCatretiva() throws BaseException {
    supportRefresh();
    return catRetIVA;
  }

  public void setCatretiva(CatRetIVA aCatretiva) {
    this.catRetIVA =  aCatretiva;
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

 public static RetCabIVA findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (RetCabIVA) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static RetCabIVA findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (RetCabIVA) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }


 public static RetCabIVA findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (RetCabIVA) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(catRetIVA, "Debe ingresar la Categoría de Retención de IVA");
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

  public List getDetallesRetIVA() throws BaseException {
    if (readDetIVA) {
      List listaDetalles = RetCabIVADet.getRetIVADetByRetIVACab(this,getSesion());
      retCabIVADetalles.addAll(listaDetalles);
      readDetIVA = false;
    }
    return retCabIVADetalles;
  }

  public void addDetalleRetIVA(RetCabIVADet detalleRetIVA) throws BaseException {
    detalleRetIVA.setRetcabiva(this);
    retCabIVADetalles.add(detalleRetIVA);
  }

  public void afterSave() throws BaseException {
    Iterator iterRetIVADetalles = retCabIVADetalles.iterator();
    while (iterRetIVADetalles.hasNext()) {
      RetCabIVADet retCabIVADet = (RetCabIVADet) iterRetIVADetalles.next();
      retCabIVADet.save();
      retCabIVADet = null;
    }
    iterRetIVADetalles = null;
  }

  public static List getAllRetIVACab(ISesion aSesion) throws BaseException {
    return DBRetCabIVA.getAllRetIVACab(aSesion);
  }



}
