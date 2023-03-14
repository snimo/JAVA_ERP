package com.srn.erp.pagos.bm;

import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.CotizacionesConta;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RetencionConcImpuOP extends ObjetoLogico {

  public RetencionConcImpuOP() {
  }

  private CotizacionesConta cotizacionesConta = null;

  public static String NICKNAME = "pag.RetencionConcImpuOP";

  private ComproCab comprobante;
  private ConceptoImpuesto concImpuesto;
  private Money impoMonPago;
  private Money impoMonLocal;
  private ImportesContables importeContable;
  private Moneda monedaPago;

  public void setMonedaPago(Moneda moneda) throws BaseException {
    this.monedaPago = moneda;
  }

  public Moneda getMonedaPago() throws BaseException {
    return monedaPago;
  }

  private Money getImpoMonExt1() throws BaseException {
    if (getMonedaPago().getOID()==Moneda.getMonedaExt1(getSesion()).getOID())
      return getImpomonpago();
    else {
      CalculadorMoney calcImpoMonExt1 = new CalculadorMoney(getImpomonlocal());
      ValorCotizacion valorCotizMonExt1 =
          getCotizacionesConta().getCotizacionMoneda(Moneda.getMonedaExt1(getSesion()));
      calcImpoMonExt1.dividirPor(valorCotizMonExt1);
      return calcImpoMonExt1.getResultMoney();
    }
  }

  private Money getImpoMonExt2() throws BaseException {
    if (getMonedaPago().getOID()==Moneda.getMonedaExt2(getSesion()).getOID())
      return getImpomonpago();
    else {
      CalculadorMoney calcImpoMonExt2 = new CalculadorMoney(getImpomonlocal());
      ValorCotizacion valorCotizMonExt2 =
          getCotizacionesConta().getCotizacionMoneda(Moneda.getMonedaExt2(getSesion()));
      calcImpoMonExt2.dividirPor(valorCotizMonExt2);
      return calcImpoMonExt2.getResultMoney();
    }
  }

  public ImportesContables getImportesContables() throws BaseException {
    supportRefresh();
    // Calcular los Importes Contables
    if (importeContable == null)
      importeContable = new ImportesContables(getSesion());
    importeContable.setImpoMonLoc(getImpomonlocal());
    importeContable.setImpoMonLocAju(getImpomonlocal());
    importeContable.setImpoMonExt1(getImpoMonExt1());
    importeContable.setImpoMonExt2(getImpoMonExt2());
    return importeContable;
  }

  public void setImportesContables(ImportesContables aImportesContables) throws BaseException {
    this.importeContable = aImportesContables;
  }


  public ComproCab getComprobante() throws BaseException {
    supportRefresh();
    return comprobante;
  }

  public void setComprobante(ComproCab aComprobante) {
    this.comprobante =  aComprobante;
  }

  public ConceptoImpuesto getConcimpuesto() throws BaseException {
    supportRefresh();
    return concImpuesto;
  }

  public void setConcimpuesto(ConceptoImpuesto aConcimpuesto) {
    this.concImpuesto =  aConcimpuesto;
  }

  public Money getImpomonpago() throws BaseException {
    supportRefresh();
    return impoMonPago;
  }

  public void setImpomonpago(Money aImpomonpago) {
    this.impoMonPago =  aImpomonpago;
  }

  public Money getImpomonlocal() throws BaseException {
    supportRefresh();
    return impoMonLocal;
  }

  public void setImpomonlocal(Money aImpomonlocal) {
    this.impoMonLocal =  aImpomonlocal;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static RetencionConcImpuOP findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (RetencionConcImpuOP) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static RetencionConcImpuOP findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (RetencionConcImpuOP) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(comprobante, "Debe ingresar el Comprobante");
    Validar.noNulo(concImpuesto, "Debe ingresar el Concepto de Impuesto de Retención");
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

  private CotizacionesConta getCotizacionesConta() throws BaseException {
    if (cotizacionesConta == null) {
      cotizacionesConta = new CotizacionesConta(getSesion());
      cotizacionesConta.init();
    }
    return cotizacionesConta;
  }

  public void setCotizacionesConta(CotizacionesConta cotizacionesConta) throws BaseException {
    this.cotizacionesConta = cotizacionesConta;
  }


}
