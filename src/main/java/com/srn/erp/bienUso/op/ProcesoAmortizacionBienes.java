package com.srn.erp.bienUso.op;

import com.srn.erp.bienUso.bm.AmortizarBienes;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class ProcesoAmortizacionBienes extends Operation { 

  public ProcesoAmortizacionBienes() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	HashTableDatos listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));
	  
	Periodo periodo = Periodo.findByOid(mapaDatos.getInteger("oid_peri"),getSesion());
	java.util.Date fecImputacion = mapaDatos.getDate("fec_imputac");
	AmortizarBienes amortizarBienes = new AmortizarBienes();
	amortizarBienes.setFecImputac(fecImputacion);
	amortizarBienes.setPeriodo(periodo);
	amortizarBienes.setSesion(getSesion());
	amortizarBienes.setListaCotizaciones(listaCotiz);
	amortizarBienes.amortizar();
	

  }
  
  private HashTableDatos cargarCotizaciones(IDataSet dsCotizaciones) throws BaseException {
	  HashTableDatos listaCotizaciones = new HashTableDatos();
	  dsCotizaciones.first();
	  while (!dsCotizaciones.EOF()) {
		  Moneda moneda              = Moneda.findByOidProxy(dsCotizaciones.getInteger("oid_moneda"),getSesion());
		  ValorCotizacion valorCotiz = dsCotizaciones.getCotizacion("cotizacion");
		  listaCotizaciones.put(moneda,valorCotiz);
		  dsCotizaciones.next();
	  }
	  return listaCotizaciones;
  }
  

  
}
