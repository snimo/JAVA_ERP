package com.srn.erp.contabilidad.bm;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;

public class ImportesContables {

  private Money impoMonLoc;
  private Money impoMonLocAju;
  private Money impoMonExt1;
  private Money impoMonExt2;

  private ValorCotizacion valorCotizMonLoc = null;
  private ValorCotizacion valorCotizMonLocAju = null;
  private ValorCotizacion valorCotizMonExt1 = null;
  private ValorCotizacion valorCotizMonExt2 = null;

  public void setValorCotizMonLoc(ValorCotizacion aValorCotizMonLoc) throws BaseException {
    this.valorCotizMonLoc = valorCotizMonLoc;
  }

  public ValorCotizacion getValorCotixMonLoc() throws BaseException {
    return valorCotizMonLoc;
  }

  public void setValorCotizMonLocAju(ValorCotizacion aValorCotizMonLocAju) throws BaseException {
    this.valorCotizMonLocAju = aValorCotizMonLocAju;
  }

  public ValorCotizacion getValorCotizMonLocAju() throws BaseException {
    return valorCotizMonLocAju;
  }

  public void setValorCotizMonExt1(ValorCotizacion aValorCotizMonExt1) throws BaseException {
    this.valorCotizMonExt1 = aValorCotizMonExt1;
  }

  public ValorCotizacion getValorCotizMonExt1() throws BaseException {
    return valorCotizMonExt1;
  }

  public void setValorCotizMonExt2(ValorCotizacion aValorCotizMonExt2) throws BaseException {
    this.valorCotizMonExt2 = aValorCotizMonExt2;
  }

  public ValorCotizacion getValorCotizMonExt2() throws BaseException {
    return valorCotizMonExt2;
  }


  protected ISesion sesion;

  public ImportesContables(Money impoMonLoc,
                          Money impoMonLocAju,
                          Money impoMonExt1,
                          Money impoMonExt2) {
    this.impoMonLoc    = impoMonLoc;
    this.impoMonLocAju = impoMonLocAju;
    this.impoMonExt1   = impoMonExt1;
    this.impoMonExt2   = impoMonExt2;
  }

  public ImportesContables(ISesion aSesion) throws BaseException {
    this.sesion = aSesion;
  }


  public Money getImpoMonLoc() throws BaseException {
    //
    return impoMonLoc;
  }

  public Money getImpoMonLocAju() throws BaseException {
    return impoMonLocAju;
  }

  public Money getImpoMonExt1() throws BaseException {
    return impoMonExt1;
  }

  public Money getImpoMonExt2() throws BaseException {
    return impoMonExt2;
  }

  public void setImpoMonLoc(Money impoMonLoc) throws BaseException {
    this.impoMonLoc = impoMonLoc;
  }


  public void setImpoMonLocAju(Money impoMonLocAju) throws BaseException {
    this.impoMonLocAju = impoMonLocAju;
  }

  public void  setImpoMonExt1(Money impoMonExt1) throws BaseException {
    this.impoMonExt1 = impoMonExt1;
  }

  public void  setImpoMonExt2(Money impoMonExt2) throws BaseException {
    this.impoMonExt2 = impoMonExt2;
  }
  /**
   * ImportesContables
   */

}
