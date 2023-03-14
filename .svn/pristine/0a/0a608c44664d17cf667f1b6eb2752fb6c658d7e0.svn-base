package com.srn.erp.contabilidad.bm;

import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;

public class RenglonAsiento {

  public static int DEBE = 1;
  public static int HABER = -1;

  private CuentaImputable cuentaImputable;
  private int d_h = 0;

  private int d_h_mon_loc     = 0;
  private int d_h_mon_loc_aju = 0;
  private int d_h_mon_ext_1   = 0;
  private int d_h_mon_ext_2   = 0;

  private Moneda monedaOri;
  private Money importeOri;
  private ValorCotizacion cotizOri;

  private Money impoLocHist;
  private Money impoLocAju;
  private Money impoMonExt1;
  private Money impoMonExt2;

  private String comentario;
  private Integer cantidad;

  private ValorCotizacion cotizMonExt1;
  private ValorCotizacion cotizMonExt2;

  public RenglonAsiento() {
    cantidad = new Integer(0);
  }

  public void setCotizOri(ValorCotizacion aCotizOri) {
    this.cotizOri = aCotizOri;
  }

  public ValorCotizacion getCotizOri() {
    return cotizOri;
  }

  public CuentaImputable getCuentaImputable() {
    return cuentaImputable;
  }

  public Money getImporteOri() {
    return importeOri;
  }

  public int getD_H() {
    return d_h;
  }

  public String getComentario() {
    return comentario;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  public void setCuentaImputable(CuentaImputable cuentaImputable) {
    this.cuentaImputable = cuentaImputable;
  }

  public void setImporteOri(Money importeOri) {
    this.importeOri = importeOri;
  }

  public void setD_H(int d_h) {
    this.d_h = d_h;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public void setMonedaOri(Moneda monedaOri) {
    this.monedaOri = monedaOri;
  }

  public void setImpoLocHist(Money impoLocHist) throws BaseException {
    this.impoLocHist = impoLocHist;
  }

  public void setImpoLocHist(Money impoLocHist,
                             int d_h_mon_loc) throws BaseException {
    this.d_h_mon_loc = d_h_mon_loc;
    this.impoLocHist = impoLocHist;
  }

  public void setImpoLocAju(Money impoLocAju) throws BaseException {
    this.impoLocAju = impoLocAju;
  }

  public void setImpoLocAju(Money impoLocAju,
                            int d_h_mon_loc_aju) throws BaseException {
    this.d_h_mon_loc_aju = d_h_mon_loc_aju;
    this.impoLocAju = impoLocAju;
  }

  public void setImpoMonExt1(Money impoMonExt1) throws BaseException {
    this.impoMonExt1 = impoMonExt1;
  }

  public void setImpoMonExt1(Money impoMonExt1,
                             int d_h_mon_ext_1) throws BaseException {
    this.d_h_mon_ext_1 = d_h_mon_ext_1;
    this.impoMonExt1 = impoMonExt1;
  }

  public void setImpoMonExt2(Money impoMonExt2) {
    this.impoMonExt2 = impoMonExt2;
  }

  public void setImpoMonExt2(Money impoMonExt2,
                             int d_h_mon_ext_2) {
    this.d_h_mon_ext_2 = d_h_mon_ext_2;
    this.impoMonExt2 = impoMonExt2;
  }


  public Integer getCantidad() {
    return cantidad;
  }

  public Moneda getMonedaOri() {
    return monedaOri;
  }

  public Money getImpoMonExt2() {
    return impoMonExt2;
  }

  public Money getImpoLocHist() {
    return impoLocHist;
  }

  public Money getImpoLocAju() {
    return impoLocAju;
  }

  public Money getImpoMonExt1() {
    return impoMonExt1;
  }

  public void setCotizMonExt1(ValorCotizacion aCotizMonExt1) throws BaseException {
    this.cotizMonExt1 = aCotizMonExt1;
  }

  public void setCotizMonExt2(ValorCotizacion aCotizMonExt2) {
    this.cotizMonExt2 = aCotizMonExt2;
  }

  public ValorCotizacion getCotizMonExt1() {
    return cotizMonExt1;
  }

  public ValorCotizacion getCotizMonExt2() {
    return cotizMonExt2;
  }

  public int get_d_h_mon_loc() {
    return d_h_mon_loc;
  }

  public int get_d_h_mon_loc_aju() {
    return d_h_mon_loc_aju;
  }

  public int get_d_h_mon_ext_1() {
    return d_h_mon_ext_1;
  }

  public int get_d_h_mon_ext_2() {
    return d_h_mon_ext_2;
  }



}
