package com.srn.erp.ctasAPagar.bm;

import java.util.List;

import com.srn.erp.ctasAPagar.da.DBComproProveedorImpu;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComproProveedorImpu extends ObjetoLogico {

  public ComproProveedorImpu() {
  }

  public static String NICKNAME = "cap.ComproProveedorImpu";

  private ComproProveedorDet comproProveedorDet;
  private ConceptoImpuesto conceptoImpuesto;
  private Boolean activo;

  public ComproProveedorDet getComproProveedorDet() throws BaseException {
    supportRefresh();
    return comproProveedorDet;
  }

  public void setComproProveedorDet(ComproProveedorDet aComproproveedordet) {
    this.comproProveedorDet =  aComproproveedordet;
  }

  public ConceptoImpuesto getConceptoImpuesto() throws BaseException {
    supportRefresh();
    return conceptoImpuesto;
  }

  public void setConceptoImpuesto(ConceptoImpuesto aConceptoImpuesto) {
    this.conceptoImpuesto =  aConceptoImpuesto;
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

 public static ComproProveedorImpu findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ComproProveedorImpu) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ComproProveedorImpu findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ComproProveedorImpu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(comproProveedorDet, "Debe ingresar el Detalle del Comprobante");
    Validar.noNulo(conceptoImpuesto, "Debe ingresar el Impuesto");
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

  public static List getImpuestosComprobanteByConcepto(ComproProveedorDet comproProvDet,
                                            ISesion aSesion) throws BaseException {
    return DBComproProveedorImpu.getImpuestosByConcepto(comproProvDet,aSesion);
  }


}
