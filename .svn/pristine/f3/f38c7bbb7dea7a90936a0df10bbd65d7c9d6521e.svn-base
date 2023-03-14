package com.srn.erp.impuestos.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.impuestos.da.DBTasaPercIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TasaPercIVA extends ObjetoLogico {

  public TasaPercIVA() {
  }

  public static String NICKNAME = "im.TasaPercIVA";

  private ConceptoImpuesto concImpuesto;
  private Date fechaVigencia;
  private Double porcentaje;
  private Boolean activo;

  public ConceptoImpuesto getConcimpuesto() throws BaseException {
    supportRefresh();
    return concImpuesto;
  }

  public void setConcimpuesto(ConceptoImpuesto aConcimpuesto) {
    this.concImpuesto =  aConcimpuesto;
  }

  public Date getFechavigencia() throws BaseException {
    supportRefresh();
    return fechaVigencia;
  }

  public void setFechavigencia(Date aFechavigencia) {
    this.fechaVigencia =  aFechavigencia;
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

 public static TasaPercIVA findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (TasaPercIVA) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static TasaPercIVA findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (TasaPercIVA) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(concImpuesto, "Debe ingresar el Concepto de Impuesto");
    Validar.noNulo(fechaVigencia, "Debe ingresar la fecha de Vigencia");
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

  public static List getTasasPercIVAByConceptoImpu(ConceptoImpuesto conceptoImpuesto,
                                               ISesion aSesion) throws BaseException {
    return DBTasaPercIVA.getTasasIVAByConceptoImpu(conceptoImpuesto,aSesion);
  }

  public static TasaPercIVA getTasaVigentePercIVA(ConceptoImpuesto conceptoImpuesto,
                                                 java.util.Date fecha,
                                                 ISesion aSesion) throws BaseException {
    List listaTasas =
        DBTasaPercIVA.getTasaVigenteByConcImpu(conceptoImpuesto,fecha,aSesion);
    if (listaTasas.size() == 0)
      return null;
    else
      return (TasaPercIVA)listaTasas.get(0);
  }



}
