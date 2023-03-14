package com.srn.erp.contabilidad.bm;

import java.util.Iterator;

import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.CotizacionesConta;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class CalcImportesContables  {

  private CotizacionesConta contizacionesConta = null;
  private ISesion sesion = null;
  private java.util.Date fecha = null;
  private Moneda monedaOri = null;

  private ValorCotizacion valorCotizMonLoc = null;
  private ValorCotizacion valorCotizMonLocAju = null;
  private ValorCotizacion valorCotizMonExt1 = null;
  private ValorCotizacion valorCotizMonExt2 = null;
  
  private TipoCambio tipoCambio;

  public void addCotizacion(ValorCotizacion valorCotizacion,Moneda moneda) throws BaseException {
	if ((valorCotizacion == null) || (moneda == null)) return;   
    contizacionesConta.addCotizacion(moneda,valorCotizacion);
  }
  
  public void addCotizaciones(HashTableDatos cotizaciones) throws BaseException {
	  Iterator iterCotiz = cotizaciones.keySet().iterator();
	  while (iterCotiz.hasNext()) {
		  Moneda moneda = (Moneda) iterCotiz.next();
		  ValorCotizacion valorCotiz = (ValorCotizacion) cotizaciones.get(moneda);
		  contizacionesConta.addCotizacion(moneda,valorCotiz);
	  }
  }

  public CalcImportesContables(ISesion aSesion,java.util.Date fecha) throws BaseException {
    sesion = aSesion;
    contizacionesConta = new CotizacionesConta(sesion);
    contizacionesConta.init();
    contizacionesConta.setFecha(fecha);
    this.fecha = fecha;
  }

  public CalcImportesContables(ISesion aSesion,java.util.Date fecha , CotizacionesConta aCotizConta) throws BaseException {
    sesion = aSesion;
    contizacionesConta = aCotizConta;
    contizacionesConta.init();
    contizacionesConta.setFecha(fecha);
    this.fecha = fecha;
  }

  public Money getImpoMonLoc() throws BaseException {
    // Ubicar la moneda local
    //Moneda monedaLocal = Moneda.getMonedaCursoLegal(sesion);
    return null;
  }
  
  public void setTipoCambio(TipoCambio aTipoCambio) {
	this.tipoCambio = aTipoCambio;
  }
  
  public TipoCambio getTipoCambio() throws BaseException {
	if (this.tipoCambio!=null)
	  return this.tipoCambio;
	else
	  return TipoCambio.getTipoCambioDefaultConta(sesion);
  }

  public ImportesContables getImportesContables(Money importe,
                                                Moneda moneda) throws BaseException {
	monedaOri = moneda;  
    // Calcular el Importe en Moneda Local
    Money impoLoc    = getImporteMonedaLocal(importe,moneda);
    Money impoLocAju = getImporteMonedaLocalAju(importe,moneda);
    Money impoExt1   = getImporteMonedaExt1(importe,moneda);
    Money impoExt2   = getImporteMonedaExt2(importe,moneda);
    ImportesContables importesContables =
        new ImportesContables(impoLoc,impoLocAju,impoExt1,impoExt2);
    importesContables.setValorCotizMonLoc(valorCotizMonLoc);
    importesContables.setValorCotizMonLocAju(valorCotizMonLocAju);
    importesContables.setValorCotizMonExt1(valorCotizMonExt1);
    importesContables.setValorCotizMonExt2(valorCotizMonExt2);
    return importesContables;
  }

  private Money getImporteMonedaLocal(Money importe,Moneda moneda) throws BaseException {
    valorCotizMonLoc = contizacionesConta.getCotizacionMoneda(moneda);
    return Cotizacion.getImporteMonedaLocal(valorCotizMonLoc,importe);
  }

  private Money getImporteMonedaLocalAju(Money importe,Moneda moneda) throws BaseException {
    valorCotizMonLocAju = contizacionesConta.getCotizacionMoneda(moneda);
    return Cotizacion.getImporteMonedaLocal(valorCotizMonLocAju,importe);
  }

  private Money getImporteMonedaExt1(Money importe,Moneda moneda) throws BaseException {
    valorCotizMonExt1 = contizacionesConta.getCotizMonedaExt1();
    ValorCotizacion valorCotiz = contizacionesConta.getCotizacionMoneda(moneda);
    if (moneda.getOID()==Moneda.getMonedaExt1(sesion).getOID())
      return importe;
    else
      return Cotizacion.getImpoMonedaExt1(fecha,
    		  							  getTipoCambio(),
                                          moneda,
                                          importe,
                                          valorCotiz,
                                          valorCotizMonExt1,
                                          sesion);
  }

  private Money getImporteMonedaExt2(Money importe,Moneda moneda) throws BaseException {
    valorCotizMonExt2 = contizacionesConta.getCotizMonedaExt2();
    ValorCotizacion valorCotizacion = contizacionesConta.getCotizacionMoneda(moneda);
    if (moneda.getOID()==Moneda.getMonedaExt2(sesion).getOID())
      return importe;
    else
      return Cotizacion.getImpoMonedaExt2(fecha,
                                   getTipoCambio(),
                                   moneda,
                                   importe,
                                   valorCotizacion,
                                   valorCotizMonExt2,
                                   sesion);
  }
  
  public ValorCotizacion getValorCotizMonedaOri() throws BaseException {
	  return contizacionesConta.getCotizacionMoneda(monedaOri);
  }




}
