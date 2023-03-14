package com.srn.erp.impuestos.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.impuestos.da.DBTasaIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TasaIVA extends ObjetoLogico {

  public TasaIVA() {
  }

  public static String NICKNAME = "im.TasaIVA";

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

 public static TasaIVA findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (TasaIVA) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static TasaIVA findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (TasaIVA) getObjectByCodigo(NICKNAME,codigo,aSesion);
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

  public static List getTasasIVAByConceptoImpu(ConceptoImpuesto conceptoImpuesto,
                                               ISesion aSesion) throws BaseException {
    return DBTasaIVA.getTasasIVAByConceptoImpu(conceptoImpuesto,aSesion);
  }

  public static TasaIVA getTasaVigenteIVA(ConceptoImpuesto conceptoImpuesto,
                                          java.util.Date fecha,
                                          ISesion aSesion) throws BaseException {
    List listaTasas =
        DBTasaIVA.getTasaVigenteByConcImpu(conceptoImpuesto,fecha,aSesion);
    if (listaTasas.size() == 0)
      return null;
    else
      return (TasaIVA)listaTasas.get(0);
  }

}
