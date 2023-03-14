package com.srn.erp.ctasAPagar.bm;

import java.util.List;

import com.srn.erp.ctasAPagar.da.DBConcFactProvImp;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConcFactProvImp extends ObjetoLogico {

  public ConcFactProvImp() {
  }

  public static String NICKNAME = "cap.ConcFactProvImp";

  private ConcFactProv concFactProv;
  private ConceptoImpuesto concImpuesto;
  private Boolean calculaEnFact;
  private Boolean calculaEnOP;
  private Boolean activo;

  public ConcFactProv getConcFactProv() throws BaseException {
    supportRefresh();
    return concFactProv;
  }

  public void setConcFactProv(ConcFactProv aConcfactprov) {
    this.concFactProv =  aConcfactprov;
  }

  public ConceptoImpuesto getConcImpuesto() throws BaseException {
    supportRefresh();
    return concImpuesto;
  }

  public void setConcImpuesto(ConceptoImpuesto aConcimpuesto) {
    this.concImpuesto =  aConcimpuesto;
  }

  public Boolean isCalculaEnFact() throws BaseException {
    supportRefresh();
    return calculaEnFact;
  }

  public void setCalculaEnFact(Boolean aCalculaenfact) {
    this.calculaEnFact =  aCalculaenfact;
  }

  public Boolean isCalculaEnOP() throws BaseException {
    supportRefresh();
    return calculaEnOP;
  }

  public void setCalculaEnOP(Boolean aCalculaenop) {
    this.calculaEnOP =  aCalculaenop;
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

 public static ConcFactProvImp findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ConcFactProvImp) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static ConcFactProvImp findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (ConcFactProvImp) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static ConcFactProvImp findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ConcFactProvImp) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(concFactProv, "Debe ingresar  el concepto de Factura");
    Validar.noNulo(concImpuesto, "Debe ingresar el concepto de impuesto");
    Validar.noNulo(calculaEnFact, "Debe indicar si se calcula en la Factura");
    Validar.noNulo(calculaEnOP, "Debe indicar si se calcula en la OP");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El concepto de impuesto debe ingresarse en modo activo");

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

  public static List getConcFactProvImpByConcFactProv(ConcFactProv concFactProv,
      ISesion aSesion) throws BaseException {
    return DBConcFactProvImp.getConcFactProvImpByConcFactProv(
               concFactProv,
               aSesion);
  }

  public static List getConcFactProvImpByConcFactProvAct(ConcFactProv concFactProv,
      ISesion aSesion) throws BaseException {
    return DBConcFactProvImp.getConcFactProvImpByConcFactProvAct(
               concFactProv,
               aSesion);
  }



}
