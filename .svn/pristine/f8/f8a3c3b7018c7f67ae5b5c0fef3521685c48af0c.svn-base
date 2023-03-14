package com.srn.erp.ctasAPagar.bm;

import java.util.List;

import com.srn.erp.ctasAPagar.da.DBComproProvTotImpu;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class ComproProvTotImpu extends ObjetoLogico {

  public ComproProvTotImpu() {
  }

  public static String NICKNAME = "cap.ComproProvTotImpu";

  private ComproCab comprobante;
  private ConceptoImpuesto conceptoImpuesto;
  private Money importeMonedaOri;
  private Money importeMonedaLocal;

  public ComproCab getComprobante() throws BaseException {
    supportRefresh();
    return comprobante;
  }

  public void setComprobante(ComproCab aComprobante) {
    this.comprobante =  aComprobante;
  }

  public ConceptoImpuesto getConceptoImpuesto() throws BaseException {
    supportRefresh();
    return conceptoImpuesto;
  }

  public void setConceptoImpuesto(ConceptoImpuesto aConceptoImpuesto) {
    this.conceptoImpuesto =  aConceptoImpuesto;
  }

  public Money getImporteMonedaOri() throws BaseException {
    supportRefresh();
    return importeMonedaOri;
  }

  public void setImporteMonedaOri(Money aImportemonedaori) {
    this.importeMonedaOri =  aImportemonedaori;
  }

  public Money getImporteMonedaLocal() throws BaseException {
    supportRefresh();
    return importeMonedaLocal;
  }

  public void setImporteMonedaLocal(Money aImportemonedalocal) {
    this.importeMonedaLocal =  aImportemonedalocal;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static ComproProvTotImpu findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ComproProvTotImpu) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ComproProvTotImpu findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ComproProvTotImpu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
 }

  /**
   * isActivo
   *
   * @return Boolean
   */
  public Boolean isActivo() {
    return null;
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

  public static List getImpuestosByCompro(ComproCab comproCab,
                                          ISesion aSesion) throws BaseException {
    return DBComproProvTotImpu.getImpuestosByCompro(comproCab,aSesion);
  }


}
