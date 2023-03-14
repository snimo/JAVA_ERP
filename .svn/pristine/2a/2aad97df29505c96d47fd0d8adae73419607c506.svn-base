package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.da.DBCertificadoRetGanDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class CertificadoRetGanDet extends ObjetoLogico {

  public CertificadoRetGanDet() {
  }

  public static String NICKNAME = "pag.CertificadoRetGanDet";

  private ConceptoImpuesto conceptoImpuesto;
  private Money montoNOImponible;
  private CertificadoRetGanCab certificado;
  private Money montoGravado;
  private Money pagoNeto;
  private Money porcentaje;
  private Money montoRetMinima;
  private Money baseParaRetener;
  private Money pagoAcum;
  private Money retAcum;
  private Money impuestoRetenido;
  private Money montoFijo;
  private ImportesContables retencionesContables;

  public void setRetencionesContables(ImportesContables aRetencionesContables) throws BaseException {
    retencionesContables = aRetencionesContables;
  }

  public ImportesContables getRetencionesContables() throws BaseException {
    return retencionesContables;
  }

  public ConceptoImpuesto getConceptoimpuesto() throws BaseException {
    supportRefresh();
    return conceptoImpuesto;
  }

  public void setConceptoimpuesto(ConceptoImpuesto aConceptoimpuesto) {
    this.conceptoImpuesto =  aConceptoimpuesto;
  }

  public Money getMontonoimponible() throws BaseException {
    supportRefresh();
    return montoNOImponible;
  }

  public void setMontonoimponible(Money aMontonoimponible) {
    this.montoNOImponible =  aMontonoimponible;
  }

  public CertificadoRetGanCab getCertificado() throws BaseException {
    supportRefresh();
    return certificado;
  }

  public void setCertificado(CertificadoRetGanCab aCertificado) {
    this.certificado =  aCertificado;
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

  public Money getPorcentaje() throws BaseException {
    supportRefresh();
    return porcentaje;
  }

  public void setPorcentaje(Money aPorcentaje) {
    this.porcentaje =  aPorcentaje;
  }

  public Money getMontoretminima() throws BaseException {
    supportRefresh();
    return montoRetMinima;
  }

  public void setMontoretminima(Money aMontoretminima) {
    this.montoRetMinima =  aMontoretminima;
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
    return impuestoRetenido;
  }

  public void setImpuestoretenido(Money aImpuestoretenido) {
    this.impuestoRetenido =  aImpuestoretenido;
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

 public static CertificadoRetGanDet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CertificadoRetGanDet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CertificadoRetGanDet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CertificadoRetGanDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
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

  public static List getDetallesCertificado(CertificadoRetGanCab certRetGanCab,
                                            ISesion aSesion) throws BaseException {
    return DBCertificadoRetGanDet.getDetallesCertificado(certRetGanCab,aSesion);
  }

  public void grabarAcumulacionRetenciones(ConceptoImpuesto conceptoImpuesto,
                                           Money montoGravado,
                                           Money montoRetenido) throws BaseException {

    PagoAcumRetGan acumRetGan =
        PagoAcumRetGan.getPagoAcumRetGan(certificado.getProveedor().getSujetoimpositivo(),
                                         certificado.getPeriretgan(),
                                         conceptoImpuesto,
                                         getSesion());
    if (acumRetGan == null) {
      acumRetGan = (PagoAcumRetGan) PagoAcumRetGan.getNew(PagoAcumRetGan.NICKNAME,getSesion());
      acumRetGan.setSujetoimpositivo(certificado.getProveedor().getSujetoimpositivo());
      acumRetGan.setPeriretgan(certificado.getPeriretgan());
      acumRetGan.setConcimpuesto(conceptoImpuesto);
      acumRetGan.setPagoacum(new Money(0));
      acumRetGan.setPagoretenido(new Money(0));
      acumRetGan.setActivo(new Boolean(true));
    }

    CalculadorMoney totMonAcumPagado = new CalculadorMoney(montoGravado);
    totMonAcumPagado.sumar(acumRetGan.getPagoacum());
    acumRetGan.setPagoacum(totMonAcumPagado.getResultMoney());

    CalculadorMoney totMonAcumRetenido = new CalculadorMoney(montoRetenido);
    totMonAcumRetenido.sumar(acumRetGan.getPagoretenido());
    acumRetGan.setPagoretenido(totMonAcumRetenido.getResultMoney());

    acumRetGan.save();

  }

  public void afterSave() throws BaseException {
    grabarAcumulacionRetenciones(getConceptoimpuesto(),
                                 getMontogravado(),
                                 getImpuestoretenido());
  }




}
