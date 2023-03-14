package com.srn.erp.ctasAPagar.bm;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TranProv extends ObjetoLogico {

  public TranProv() {
  }

  public static String NICKNAME = "cap.TranProv";

  private ComproCab comprobante;
  private TipoCtaCteProv tipoCuenta;
  private Money importe;
  private Money saldo;
  private Proveedor proveedor;
  private Boolean pendiente;
  private java.util.Date imputac;
  private java.util.Date emision;
  private java.util.Date base;
  private Moneda moneda;
  private ValorCotizacion cotizMonedaOri;
  private ValorCotizacion cotizMonedaExt1;
  private ValorCotizacion cotizMonedaExt2;
  private ValorCotizacion cotizMonedaOriCon;
  private ValorCotizacion cotizMonedaExt1Con;
  private ValorCotizacion cotizMonedaExt2Con;

  public ComproCab getComprobante() throws BaseException {
    supportRefresh();
    return comprobante;
  }

  public void setComprobante(ComproCab aComprobante) {
    this.comprobante =  aComprobante;
  }

  public TipoCtaCteProv getTipocuenta() throws BaseException {
    supportRefresh();
    return tipoCuenta;
  }

  public void setTipocuenta(TipoCtaCteProv aTipocuenta) {
    this.tipoCuenta =  aTipocuenta;
  }

  public Money getImporte() throws BaseException {
    supportRefresh();
    return importe;
  }

  public void setImporte(Money aImporte) {
    this.importe =  aImporte;
  }

  public Money getSaldo() throws BaseException {
    supportRefresh();
    return saldo;
  }

  public void setSaldo(Money aSaldo) {
    this.saldo =  aSaldo;
  }

  public Proveedor getProveedor() throws BaseException {
    supportRefresh();
    return proveedor;
  }

  public void setProveedor(Proveedor aProveedor) {
    this.proveedor =  aProveedor;
  }

  public Boolean isPendiente() throws BaseException {
    supportRefresh();
    return pendiente;
  }

  public void setPendiente(Boolean aPendiente) {
    this.pendiente =  aPendiente;
  }

  public java.util.Date getImputac() throws BaseException {
    supportRefresh();
    return imputac;
  }

  public void setImputac(java.util.Date aImputac) {
    this.imputac =  aImputac;
  }

  public java.util.Date getEmision() throws BaseException {
    supportRefresh();
    return emision;
  }

  public void setEmision(java.util.Date aEmision) {
    this.emision =  aEmision;
  }

  public java.util.Date getBase() throws BaseException {
    supportRefresh();
    return base;
  }

  public void setBase(java.util.Date aBase) {
    this.base =  aBase;
  }

  public Moneda getMoneda() throws BaseException {
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) {
    this.moneda =  aMoneda;
  }

  public ValorCotizacion getCotizmonedaori() throws BaseException {
    supportRefresh();
    return cotizMonedaOri;
  }

  public void setCotizmonedaori(ValorCotizacion aCotizmonedaori) {
    this.cotizMonedaOri =  aCotizmonedaori;
  }

  public ValorCotizacion getCotizmonedaext1() throws BaseException {
    supportRefresh();
    return cotizMonedaExt1;
  }

  public void setCotizmonedaext1(ValorCotizacion aCotizmonedaext1) {
    this.cotizMonedaExt1 =  aCotizmonedaext1;
  }

  public ValorCotizacion getCotizmonedaext2() throws BaseException {
    supportRefresh();
    return cotizMonedaExt2;
  }

  public void setCotizmonedaext2(ValorCotizacion aCotizmonedaext2) {
    this.cotizMonedaExt2 =  aCotizmonedaext2;
  }

  public ValorCotizacion getCotizmonedaoricon() throws BaseException {
    supportRefresh();
    return cotizMonedaOriCon;
  }

  public void setCotizmonedaoricon(ValorCotizacion aCotizmonedaoricon) {
    this.cotizMonedaOriCon =  aCotizmonedaoricon;
  }

  public ValorCotizacion getCotizmonedaext1con() throws BaseException {
    supportRefresh();
    return cotizMonedaExt1Con;
  }

  public void setCotizmonedaext1con(ValorCotizacion aCotizmonedaext1con) {
    this.cotizMonedaExt1Con =  aCotizmonedaext1con;
  }

  public ValorCotizacion getCotizmonedaext2con() throws BaseException {
    supportRefresh();
    return cotizMonedaExt2Con;
  }

  public void setCotizmonedaext2con(ValorCotizacion aCotizmonedaext2con) {
    this.cotizMonedaExt2Con =  aCotizmonedaext2con;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static TranProv findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (TranProv) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static TranProv findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (TranProv) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static TranProv findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (TranProv) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(comprobante, "Debe ingresar el Comprobante");
    Validar.noNulo(tipoCuenta, "Debe ingresar el tipo de cuenta");
    Validar.noNulo(importe, "Debe ingresar el Importe");
    Validar.noNulo(proveedor, "Debe ingresar el Proveedor");
    Validar.noNulo(imputac, "Debe Ingresar la Fecha de Imputación");
    Validar.noNulo(emision, "Debe Ingresar la Fecha de Emisión");
    Validar.noNulo(base, "Debe ingresar la Fecha Base");
    Validar.noNulo(moneda, "Debe ingresar la Moneda");
    Validar.noNulo(cotizMonedaOri, "Debe Ingresar la Cotización Moneda Local");
    Validar.noNulo(cotizMonedaExt1, "Debe Ingresar la Cotización Moneda Extranjera 1");
    Validar.noNulo(cotizMonedaExt2, "Debe Ingresar la Cotización Moneda Extranjera 2");
    Validar.noNulo(cotizMonedaOriCon, "Debe Ingresar la Cotización Moneda Local Contable");
    Validar.noNulo(cotizMonedaExt1Con, "Debe ingresar la Cotización Moneda Ext. 1 Contable");
    Validar.noNulo(cotizMonedaExt2Con, "Debe ingresar la Cotización Moneda Ext. 2 Contable");
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

}
