package com.srn.erp.pagos.bm;

import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class CertificadoRetIVADet extends ObjetoLogico {

  public CertificadoRetIVADet() {
  }

  public static String NICKNAME = "pag.CertificadoRetIVADet";

  private ComproCab certificado;
  private Money montoNOImponible;
  private Money montoGravado;
  private Money pagoNeto;
  private Money porcRet;
  private Money montoRetMin;
  private Money baseParaRetener;
  private Money pagoAcum;
  private Money retAcum;
  private Money ImpuestoRetenido;
  private ConceptoImpuesto ConceptoImpuesto;
  private ComproProveedorBase comproProveedorBase;
  private Money montoFijo;

  public ComproCab getCertificado() throws BaseException {
    supportRefresh();
    return certificado;
  }

  public void setCertificado(ComproCab aCertificado) {
    this.certificado =  aCertificado;
  }

  public Money getMontonoimponible() throws BaseException {
    supportRefresh();
    return montoNOImponible;
  }

  public void setMontonoimponible(Money aMontonoimponible) {
    this.montoNOImponible =  aMontonoimponible;
  }

  public Money getMontogravado() throws BaseException {
    supportRefresh();
    return montoGravado;
  }

  public void setMontogravado(Money aMontogravado) {
    this.montoGravado =  aMontogravado;
  }

  public Money getPagoneto() throws BaseException {
    supportRefresh();
    return pagoNeto;
  }

  public void setPagoneto(Money aPagoneto) {
    this.pagoNeto =  aPagoneto;
  }

  public Money getPorcret() throws BaseException {
    supportRefresh();
    return porcRet;
  }

  public void setPorcret(Money aPorcret) {
    this.porcRet =  aPorcret;
  }

  public Money getMontoretmin() throws BaseException {
    supportRefresh();
    return montoRetMin;
  }

  public void setMontoretmin(Money aMontoretmin) {
    this.montoRetMin =  aMontoretmin;
  }

  public Money getBasepararetener() throws BaseException {
    supportRefresh();
    return baseParaRetener;
  }

  public void setBasepararetener(Money aBasepararetener) {
    this.baseParaRetener =  aBasepararetener;
  }

  public Money getPagoacum() throws BaseException {
    supportRefresh();
    return pagoAcum;
  }

  public void setPagoacum(Money aPagoacum) {
    this.pagoAcum =  aPagoacum;
  }

  public Money getRetacum() throws BaseException {
    supportRefresh();
    return retAcum;
  }

  public void setRetacum(Money aRetacum) {
    this.retAcum =  aRetacum;
  }

  public Money getImpuestoretenido() throws BaseException {
    supportRefresh();
    return ImpuestoRetenido;
  }

  public void setImpuestoretenido(Money aImpuestoretenido) {
    this.ImpuestoRetenido =  aImpuestoretenido;
  }

  public ConceptoImpuesto getConceptoimpuesto() throws BaseException {
    supportRefresh();
    return ConceptoImpuesto;
  }

  public void setConceptoimpuesto(ConceptoImpuesto aConceptoimpuesto) {
    this.ConceptoImpuesto =  aConceptoimpuesto;
  }

  public ComproProveedorBase getComproproveedorBase() throws BaseException {
    supportRefresh();
    return comproProveedorBase;
  }

  public void setComproproveedorBase(ComproProveedorBase aComproproveedor) {
    this.comproProveedorBase =  aComproproveedor;
  }

  public Money getMontofijo() throws BaseException {
    supportRefresh();
    return montoFijo;
  }

  public void setMontofijo(Money aMontofijo) {
    this.montoFijo =  aMontofijo;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static CertificadoRetIVADet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CertificadoRetIVADet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CertificadoRetIVADet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CertificadoRetIVADet) getObjectByCodigo(NICKNAME,codigo,aSesion);
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

}
