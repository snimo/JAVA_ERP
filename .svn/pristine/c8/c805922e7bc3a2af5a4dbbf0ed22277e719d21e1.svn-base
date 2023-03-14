package com.srn.erp.impuestos.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.da.DBTasaPercIB;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TasaPercIB extends ObjetoLogico {

  public TasaPercIB() {
  }

  public static String NICKNAME = "im.TasaPercIB";

  private ConceptoImpuesto conceptoImpuesto;
  private Date fecVigencia;
  private Double porc;
  private Provincia provincia;
  private Double montoMinimo;
  private CategoriaIB categIB;
  private Boolean activo;
  private CuentaImputable cuentaImputable;

  public ConceptoImpuesto getConceptoImpuesto() throws BaseException {
    supportRefresh();
    return conceptoImpuesto;
  }

  public void setConceptoImpuesto(ConceptoImpuesto aConceptoimpuesto) {
    this.conceptoImpuesto =  aConceptoimpuesto;
  }
  
  public CuentaImputable getCuentaImputable() throws BaseException {
	supportRefresh();
	return cuentaImputable;
  }

  public void setCuentaImputable(CuentaImputable aCuentaImputable) {
	this.cuentaImputable =  aCuentaImputable;
  }

  public Date getFecVigencia() throws BaseException {
    supportRefresh();
    return fecVigencia;
  }

  public void setFecVigencia(Date aFecvigencia) {
    this.fecVigencia =  aFecvigencia;
  }

  public Double getPorc() throws BaseException {
    supportRefresh();
    return porc;
  }

  public void setPorc(Double aPorc) {
    this.porc =  aPorc;
  }

  public Provincia getProvincia() throws BaseException {
    supportRefresh();
    return provincia;
  }

  public void setProvincia(Provincia aProvincia) {
    this.provincia =  aProvincia;
  }

  public Double getMontoMinimo() throws BaseException {
    supportRefresh();
    return montoMinimo;
  }

  public void setMontoMinimo(Double aMontominimo) {
    this.montoMinimo =  aMontominimo;
  }

  public CategoriaIB getCategIB() throws BaseException {
    supportRefresh();
    return categIB;
  }

  public void setCategIB(CategoriaIB aCategib) {
    this.categIB =  aCategib;
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

 public static TasaPercIB findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (TasaPercIB) getObjectByOid(NICKNAME,oid,aSesion);
 }

 public static TasaPercIB findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
   return (TasaPercIB) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }


 public static TasaPercIB findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (TasaPercIB) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La Tasa de Perc. de IB debe ingresarse en modo activo");

   Validar.noNulo(conceptoImpuesto, "Debe ingresar el Concepto de Impuesto");
   Validar.noNulo(fecVigencia, "Debe ingresar la fecha de Vigencia");
   Validar.noNulo(porc, "Debe ingresar el Porcentaje");
   Validar.noNulo(provincia, "Debe ingresar la Provincia");
   Validar.noNulo(montoMinimo, "Debe ingresar el Monto Mínimo");
   Validar.noNulo(categIB, "Debe ingresar la Categoría de IB");

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

  public static List getTasasPercIBByConcImpu(ConceptoImpuesto conceptoImpuesto,
                                              ISesion aSesion) throws BaseException {
    return DBTasaPercIB.getTasasPercIBByConcImpu(conceptoImpuesto,aSesion);
  }

  public static TasaPercIB getTasaVigentePercIB(ConceptoImpuesto conceptoImpuesto,
                                                java.util.Date fecha,
                                                Provincia provincia,
                                                CategoriaIB categoriaIB,
                                                ISesion aSesion) throws BaseException {
	if ((provincia == null) || (categoriaIB == null))
		return null;
    List listaTasas =
        DBTasaPercIB.getTasaVigenteByConcImpu(conceptoImpuesto,
                                              provincia,
                                              categoriaIB,
                                              fecha,
                                              aSesion);
    if (listaTasas.size() == 0)
      return null;
    else
      return (TasaPercIB)listaTasas.get(0);
  }



}
