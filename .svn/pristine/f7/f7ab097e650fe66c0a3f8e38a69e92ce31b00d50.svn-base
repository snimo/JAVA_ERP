package com.srn.erp.contabilidad.bm;

import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorCotizacion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class CalcDifCambio {

  ISesion sesion                          = null;
  Money  impoAplic                        = null;
  ValorCotizacion cotizMonOrigenConta     = null;
  ValorCotizacion cotizMonExt1Conta       = null;
  ValorCotizacion cotizMonExt2Conta       = null;
  ValorCotizacion cotizMonOrigenHoy       = null;
  ValorCotizacion cotizMonExt1Hoy         = null;
  ValorCotizacion cotizMonExt2Hoy         = null;

  ImportesContables debitosImportesConta  = new ImportesContables(new Money(0),
                                                                  new Money(0),
                                                                  new Money(0),
                                                                  new Money(0));
   ImportesContables creditosImportesConta = new ImportesContables(new Money(0),
                                                                   new Money(0),
                                                                   new Money(0),
                                                                   new Money(0));
   ImportesContables debitosDifCambio      = new ImportesContables(new Money(0),
                                                                   new Money(0),
                                                                   new Money(0),
                                                                   new Money(0));
   ImportesContables creditosDifCambio     = new ImportesContables(new Money(0),
                                                                   new Money(0),
                                                                   new Money(0),
                                                                   new Money(0));
   ImportesContables importesAHoy          = new ImportesContables(new Money(0),
                                                                   new Money(0),
                                                                   new Money(0),
                                                                   new Money(0));

  public CalcDifCambio(ISesion aSesion) throws BaseException {
    this.sesion = aSesion;
  }

  public void setImporteAplicacion(Money impoAplic) throws BaseException {
    this.impoAplic = impoAplic;
  }

  public void setCotizMonOrigenConta(ValorCotizacion cotizMonOrigenConta) throws BaseException {
    this.cotizMonOrigenConta = cotizMonOrigenConta;
  }

  public void setCotizMonExt1Conta(ValorCotizacion cotizMonExt1Conta) throws BaseException {
    this.cotizMonExt1Conta = cotizMonExt1Conta;
  }

  public void setCotizMonExt2Conta(ValorCotizacion cotizMonExt2Conta) throws BaseException {
    this.cotizMonExt2Conta = cotizMonExt2Conta;
  }

  public void setCotizMonOrigenHoy(ValorCotizacion cotizMonOrigenHoy) throws BaseException {
    this.cotizMonOrigenHoy = cotizMonOrigenHoy;
  }

  public void setCotizMonExt1Hoy(ValorCotizacion cotizMonExt1Hoy) throws BaseException {
    this.cotizMonExt1Hoy = cotizMonExt1Hoy;
  }

  public void setCotizMonExt2Hoy(ValorCotizacion cotizMonExt2Hoy) throws BaseException {
    this.cotizMonExt2Hoy = cotizMonExt2Hoy;
  }

  public void calcular() throws BaseException {


    // Obtener la Imputacion en Moneda Local
    CalculadorCotizacion calcMontoImputacLoc = new CalculadorCotizacion(impoAplic);
    calcMontoImputacLoc.multiplicarPor(cotizMonOrigenConta);
    calcMontoImputacLoc.dividirPor(new Money(1));

    // Obtener la Imputacion en Moneda Extranjera 1
    CalculadorCotizacion calcMontoImputacExt1 = new CalculadorCotizacion(impoAplic);
    calcMontoImputacExt1.multiplicarPor(cotizMonOrigenConta);
    calcMontoImputacExt1.dividirPor(cotizMonExt1Conta);

    // Obtener la Imputacion en Moneda Extranjera 2
    CalculadorCotizacion calcMontoImputacExt2 = new CalculadorCotizacion(impoAplic);
    calcMontoImputacExt2.multiplicarPor(cotizMonOrigenConta);
    calcMontoImputacExt2.dividirPor(cotizMonExt2Conta);


    if (impoAplic.doubleValue()<0) { // Debitar
      debitosImportesConta = new ImportesContables(
                                   new Money(Math.abs(calcMontoImputacLoc.getResult())),
                                   new Money(Math.abs(calcMontoImputacLoc.getResult())),
                                   new Money(Math.abs(calcMontoImputacExt1.getResult())),
                                   new Money(Math.abs(calcMontoImputacExt2.getResult())));
    }
    else { // Acreditar
      creditosImportesConta = new ImportesContables(
                                   new Money(Math.abs(calcMontoImputacLoc.getResult())),
                                   new Money(Math.abs(calcMontoImputacLoc.getResult())),
                                   new Money(Math.abs(calcMontoImputacExt1.getResult())),
                                   new Money(Math.abs(calcMontoImputacExt2.getResult())));
    }

    // Obtener la Imputacion en Moneda Local
    CalculadorCotizacion calcMontoImputacLocAHoy = new CalculadorCotizacion(impoAplic);
    if (cotizMonOrigenHoy.doubleValue() == 0)
    	throw new ExceptionValidation(null,"Debe ingresar la cotización de la moneda Origen");
    
    calcMontoImputacLocAHoy.multiplicarPor(cotizMonOrigenHoy);
    calcMontoImputacLocAHoy.dividirPor(new Money(1));

    // Obtener la Imputacion en Moneda Ext1
    CalculadorCotizacion calcMontoImputacExt1AHoy = new CalculadorCotizacion(impoAplic);
    calcMontoImputacExt1AHoy.multiplicarPor(cotizMonOrigenHoy);
    
    if (cotizMonExt1Hoy.doubleValue() == 0)
    	throw new ExceptionValidation(null,"Debe ingresar la cotización de la moneda "+Moneda.getMonedaExt1(sesion).getDescripcion());
    calcMontoImputacExt1AHoy.dividirPor(cotizMonExt1Hoy);

    // Obtener la Imputacion en Moneda Ext2
    CalculadorCotizacion calcMontoImputacExt2AHoy = new CalculadorCotizacion(impoAplic);
    calcMontoImputacExt2AHoy.multiplicarPor(cotizMonOrigenHoy);
    if (cotizMonExt2Hoy.doubleValue() == 0)
    	throw new ExceptionValidation(null,"Debe ingresar la cotización de la moneda "+Moneda.getMonedaExt2(sesion).getDescripcion());
    
    calcMontoImputacExt2AHoy.dividirPor(cotizMonExt2Hoy);

    importesAHoy =  new ImportesContables(
                                   new Money(Math.abs(calcMontoImputacLocAHoy.getResult())),
                                   new Money(Math.abs(calcMontoImputacLocAHoy.getResult())),
                                   new Money(Math.abs(calcMontoImputacExt1AHoy.getResult())),
                                   new Money(Math.abs(calcMontoImputacExt2AHoy.getResult())));

    // Restar el Valor Actual menor el Valor Origen
    CalculadorMoney calcValorActualMenosValorOrigenMonLoc = new CalculadorMoney(importesAHoy.getImpoMonLoc());
    calcValorActualMenosValorOrigenMonLoc.restar(new Money(Math.abs(calcMontoImputacLoc.getResult())));

    CalculadorMoney calcValorActualMenosValorOrigenMonExt1 = new CalculadorMoney(importesAHoy.getImpoMonExt1());
    calcValorActualMenosValorOrigenMonExt1.restar(new Money(Math.abs(calcMontoImputacExt1.getResult())));

    CalculadorMoney calcValorActualMenosValorOrigenMonExt2 = new CalculadorMoney(importesAHoy.getImpoMonExt2());
    calcValorActualMenosValorOrigenMonExt2.restar(new Money(Math.abs(calcMontoImputacExt2.getResult())));

    if (impoAplic.doubleValue()<0) { // Debitar

      if (calcValorActualMenosValorOrigenMonLoc.getResult()>0) {
        debitosDifCambio.setImpoMonLoc(new Money(Math.abs(
            calcValorActualMenosValorOrigenMonLoc.getResult())));
        debitosDifCambio.setImpoMonLocAju(new Money(Math.abs(
            calcValorActualMenosValorOrigenMonLoc.getResult())));
      }
      else {
        creditosDifCambio.setImpoMonLoc(new Money(Math.abs(
            calcValorActualMenosValorOrigenMonLoc.getResult())));
        creditosDifCambio.setImpoMonLocAju(new Money(Math.abs(
            calcValorActualMenosValorOrigenMonLoc.getResult())));
      }

      if (calcValorActualMenosValorOrigenMonExt1.getResult()>0)
        debitosDifCambio.setImpoMonExt1(new Money(Math.abs(calcValorActualMenosValorOrigenMonExt1.getResult())));
      else
        creditosDifCambio.setImpoMonExt1(new Money(Math.abs(calcValorActualMenosValorOrigenMonExt1.getResult())));

      if (calcValorActualMenosValorOrigenMonExt2.getResult()>0)
        debitosDifCambio.setImpoMonExt2(new Money(Math.abs(calcValorActualMenosValorOrigenMonExt2.getResult())));
      else
        creditosDifCambio.setImpoMonExt2(new Money(Math.abs(calcValorActualMenosValorOrigenMonExt2.getResult())));

    }
    else {

      if (calcValorActualMenosValorOrigenMonLoc.getResult()<0) {
        debitosDifCambio.setImpoMonLoc(new Money(Math.abs(
            calcValorActualMenosValorOrigenMonLoc.getResult())));
        debitosDifCambio.setImpoMonLocAju(new Money(Math.abs(
            calcValorActualMenosValorOrigenMonLoc.getResult())));
      }
      else {
        creditosDifCambio.setImpoMonLoc(new Money(Math.abs(
            calcValorActualMenosValorOrigenMonLoc.getResult())));
        creditosDifCambio.setImpoMonLocAju(new Money(Math.abs(
            calcValorActualMenosValorOrigenMonLoc.getResult())));
      }

      if (calcValorActualMenosValorOrigenMonExt1.getResult()<0)
        debitosDifCambio.setImpoMonExt1(new Money(Math.abs(calcValorActualMenosValorOrigenMonExt1.getResult())));
      else
        creditosDifCambio.setImpoMonExt1(new Money(Math.abs(calcValorActualMenosValorOrigenMonExt1.getResult())));

      if (calcValorActualMenosValorOrigenMonExt2.getResult()<0)
        debitosDifCambio.setImpoMonExt2(new Money(Math.abs(calcValorActualMenosValorOrigenMonExt2.getResult())));
      else
        creditosDifCambio.setImpoMonExt2(new Money(Math.abs(calcValorActualMenosValorOrigenMonExt2.getResult())));
    }
  }

  public ImportesContables getDebitosImportesConta() throws BaseException {
    return debitosImportesConta;
  }

  public ImportesContables getCreditosImportesConta() throws BaseException {
    return creditosImportesConta;
  }

  public ImportesContables getDebitosDifCambio() throws BaseException {
    return debitosDifCambio;
  }

  public ImportesContables getCreditosDifCambio() throws BaseException {
    return creditosDifCambio;
  }


}
