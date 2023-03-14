package com.srn.erp.general.bm;

import java.util.Hashtable;
import java.util.Iterator;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class CotizacionesConta  {

  ISesion sesion = null;
  Hashtable listaCotizaciones = new Hashtable();

  private java.util.Date fecha;

  public void init() throws BaseException {
    listaCotizaciones.clear();
  }

  public void addCotizacion(Moneda moneda,
                            ValorCotizacion valorCotizacion)
      throws BaseException {
    if (listaCotizaciones.get(moneda.getOIDInteger())==null)
      listaCotizaciones.put(moneda.getOIDInteger(),valorCotizacion);
  }

  public ValorCotizacion getCotizacionMoneda(Moneda moneda) throws BaseException {
    if (moneda.getOID()==Moneda.getMonedaCursoLegal(sesion).getOID())
      return new ValorCotizacion(1);
    else {
      ValorCotizacion valorCotizacion =
          (ValorCotizacion) listaCotizaciones.get(moneda.getOIDInteger());
      if (valorCotizacion == null)
        valorCotizacion = Cotizacion.getCotizacion(fecha, moneda, sesion);
      return valorCotizacion;
    }
  }

  public CotizacionesConta(ISesion aSesion) {
    this.sesion = aSesion;
  }

  public ValorCotizacion getCotizMonedaLocal() throws BaseException {
    return getCotizacionMoneda(Moneda.getMonedaCursoLegal(sesion));
  }

  public ValorCotizacion getCotizMonedaExt1() throws BaseException {
    return getCotizacionMoneda(Moneda.getMonedaExt1(sesion));
  }

  public ValorCotizacion getCotizMonedaExt2() throws BaseException {
    return getCotizacionMoneda(Moneda.getMonedaExt2(sesion));
  }

  public void setFecha(java.util.Date aFecha) throws BaseException {
    this.fecha = aFecha;
  }
  
  public void addCotizaciones(HashTableDatos cotizaciones) throws BaseException {
	  Iterator iterCotiz = cotizaciones.keySet().iterator();
	  while (iterCotiz.hasNext()) {
		  Moneda moneda = (Moneda) iterCotiz.next();
		  ValorCotizacion valorCotiz = (ValorCotizacion) cotizaciones.get(moneda);
		  listaCotizaciones.put(moneda.getOIDInteger(),valorCotiz);
	  }
  }  
  
  



}
