package com.srn.erp.impuestos.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.impuestos.da.DBTasaImpInt;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TasaImpInt extends ObjetoLogico {

  public TasaImpInt() {
  }

  public static String NICKNAME = "im.TasaImpInt";

  private ConceptoImpuesto conceptoImpuesto;
  private Date fecVigencia;
  private Double porc;
  private Double montoMinimo;
  private Boolean activo;

  public ConceptoImpuesto getConceptoimpuesto() throws BaseException {
    supportRefresh();
    return conceptoImpuesto;
  }

  public void setConceptoimpuesto(ConceptoImpuesto aConceptoimpuesto) {
    this.conceptoImpuesto =  aConceptoimpuesto;
  }

  public Date getFecvigencia() throws BaseException {
    supportRefresh();
    return fecVigencia;
  }

  public void setFecvigencia(Date aFecvigencia) {
    this.fecVigencia =  aFecvigencia;
  }

  public Double getPorc() throws BaseException {
    supportRefresh();
    return porc;
  }

  public void setPorc(Double aPorc) {
    this.porc =  aPorc;
  }

  public Double getMontominimo() throws BaseException {
    supportRefresh();
    return montoMinimo;
  }

  public void setMontominimo(Double aMontominimo) {
    this.montoMinimo =  aMontominimo;
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

 public static TasaImpInt findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (TasaImpInt) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static TasaImpInt findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (TasaImpInt) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(conceptoImpuesto, "Debe ingresarse el Concepto de Impuesto");
    Validar.noNulo(fecVigencia, "Debe ingresarse la Fecha de Vigencia");
    Validar.noNulo(porc, "Debe ingresarse el Porcentaje");
    Validar.noNulo(montoMinimo, "Debe ingresarse el Monto Mínimo");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La Tasa de Imp. Int. debe ingresarse en modo activo");

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

  public static List getTasasImpIntByConcImpu(ConceptoImpuesto conceptoImpuesto,
                                              ISesion aSesion) throws BaseException {
    return DBTasaImpInt.getTasasImpIntByConcImpu(conceptoImpuesto,aSesion);
  }

  public static TasaImpInt getTasaVigenteImpInt(ConceptoImpuesto conceptoImpuesto,
                                                java.util.Date fecha,
                                                ISesion aSesion) throws BaseException {
    List listaTasas =
        DBTasaImpInt.getTasaVigenteByConcImpu(conceptoImpuesto,fecha,aSesion);
    if (listaTasas.size() == 0)
      return null;
    else
      return (TasaImpInt)listaTasas.get(0);
  }





}
