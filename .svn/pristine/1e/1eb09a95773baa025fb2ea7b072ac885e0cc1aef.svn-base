package com.srn.erp.pagos.bm;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.da.DBPagoAcumRetGan;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class PagoAcumRetGan extends ObjetoLogico {

  public PagoAcumRetGan() {
  }

  public static String NICKNAME = "pag.PagoAcumRetGan";

  private SujetoImpositivo sujetoImpositivo;
  private PeriRetGan periRetGan;
  private ConceptoImpuesto concImpuesto;
  private Money pagoAcum;
  private Money pagoRetenido;
  private Boolean activo;

  public SujetoImpositivo getSujetoimpositivo() throws BaseException {
    supportRefresh();
    return sujetoImpositivo;
  }

  public void setSujetoimpositivo(SujetoImpositivo aSujetoimpositivo) {
    this.sujetoImpositivo =  aSujetoimpositivo;
  }

  public PeriRetGan getPeriretgan() throws BaseException {
    supportRefresh();
    return periRetGan;
  }

  public void setPeriretgan(PeriRetGan aPeriretgan) {
    this.periRetGan =  aPeriretgan;
  }

  public ConceptoImpuesto getConcimpuesto() throws BaseException {
    supportRefresh();
    return concImpuesto;
  }

  public void setConcimpuesto(ConceptoImpuesto aConcimpuesto) {
    this.concImpuesto =  aConcimpuesto;
  }

  public Money getPagoacum() throws BaseException {
    supportRefresh();
    return pagoAcum;
  }

  public void setPagoacum(Money aPagoacum) {
    this.pagoAcum =  aPagoacum;
  }

  public Money getPagoretenido() throws BaseException {
    supportRefresh();
    return pagoRetenido;
  }

  public void setPagoretenido(Money aPagoretenido) {
    this.pagoRetenido =  aPagoretenido;
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

 public static PagoAcumRetGan findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (PagoAcumRetGan) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static PagoAcumRetGan findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (PagoAcumRetGan) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
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

  public static PagoAcumRetGan getPagoAcumRetGan(SujetoImpositivo sujetoImpositivo,
                                                 PeriRetGan periRetGan,
                                                 ConceptoImpuesto conceptoImpuesto,
                                                 ISesion aSesion) throws BaseException {
    return DBPagoAcumRetGan.getPagoAcumRetGan(sujetoImpositivo,
                                              periRetGan,
                                              conceptoImpuesto,
                                              aSesion);
  }


}
