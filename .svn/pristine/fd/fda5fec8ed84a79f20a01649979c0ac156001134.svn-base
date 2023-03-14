package com.srn.erp.general.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCotizacionesAFecha extends Operation {

  public TraerCotizacionesAFecha() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    // Asignar la Fecha
    Date fecha = null;
    if (!mapaDatos.containsKey("fecha"))
    	fecha = Fecha.getFechaActual();
    else
        fecha = mapaDatos.getDate("fecha");
    
    // Asignar el Tipo de Cambio
    TipoCambio tipoCambio = null;
    Integer oidTipoCambio = null;
    if (!mapaDatos.containsKey("oid_tipo_cambio"))
    	tipoCambio = TipoCambio.getTipoCambioDefaultConta(getSesion());
    else
    	tipoCambio = TipoCambio.findByOid(mapaDatos.getInteger("oid_tipo_cambio"),getSesion());
    
    IDataSet dataSetFiltro = getDataSetCotizFiltro();
    IDataSet dataSetCotizaciones = getDataSetCotizacion();
    
    cargarRegistroFiltro(dataSetFiltro,fecha,tipoCambio);
    
    Iterator iterMonedas = Moneda.getAllActivos(getSesion()).iterator();
    while (iterMonedas.hasNext()) {
    	Moneda moneda = (Moneda) iterMonedas.next();
    	if (Moneda.getMonedaCursoLegal(getSesion()).getOID() == moneda.getOID()) continue;
    	ValorCotizacion valorCotizacion = moneda.getCotizacionNotFoundCero(tipoCambio,fecha);
    	cargarRegistroCotizacion(dataSetCotizaciones,moneda,valorCotizacion);
    }
    
    writeCliente(dataSetCotizaciones);
    writeCliente(dataSetFiltro);
  }

  private IDataSet getDataSetCotizacion() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCotizaciones");
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
    return dataset;
  }
  
  private IDataSet getDataSetCotizFiltro() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TCotizFiltros");
	    dataset.fieldDef(new Field("fecha",Field.DATE, 0));
	    dataset.fieldDef(new Field("oid_tipo_cambio", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_tipo_cambio", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_tipo_cambio", Field.STRING, 100));
	    return dataset;
	  }  

  private void cargarRegistroCotizacion(IDataSet dataset,
		  								Moneda moneda,
		  								ValorCotizacion valorCotizacion)  throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_moneda", moneda.getOIDInteger());
    dataset.fieldValue("codigo", moneda.getCodigo());
    dataset.fieldValue("descripcion", moneda.getDescripcion());
    dataset.fieldValue("cotizacion", valorCotizacion.doubleValue());
  }
  
  private void cargarRegistroFiltro(IDataSet dataset,
			java.util.Date fecha,
			TipoCambio tipoCambio)  throws BaseException {
	dataset.append();
	dataset.fieldValue("fecha", Fecha.getddmmyyyy(fecha));
	dataset.fieldValue("oid_tipo_cambio", tipoCambio.getOIDInteger());
	dataset.fieldValue("cod_tipo_cambio", tipoCambio.getCodigo());
	dataset.fieldValue("desc_tipo_cambio", tipoCambio.getDescripcion());
}  
  
}
