package com.srn.erp.contabilidad.op;

import java.util.Date;

import com.srn.erp.contabilidad.bm.AsientoManual;
import com.srn.erp.contabilidad.bm.AsientoManualDet;
import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAsientoManual extends Operation {

  AsientoManual asientoManual = null;

  public SaveAsientoManual() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	HashTableDatos listaCotiz = null;
	if (mapaDatos.containsKey("TCotizaciones"))
		listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));  
	  
    IDataSet datasetAsiCab = mapaDatos.getDataSet("TAsientoCab");
    datasetAsiCab.first();
    while (!datasetAsiCab.EOF()) {


    	Integer oid                  = datasetAsiCab.getInteger("oid");
    	asientoManual = AsientoManual.findByOid(oid,getSesion());
      
      // Verificar si se trata de una anulacion de asiento
      if ((!asientoManual.isNew()) && 
      		(asientoManual.isActivo().booleanValue()) && 
      		(datasetAsiCab.getBoolean("activo").booleanValue()==false)) {
      	asientoManual.delete();
      	this.addTransaccion(asientoManual);
      	datasetAsiCab.next();
      	continue;
      }
    	
    	Integer oidTC                = datasetAsiCab.getInteger("oid_tc");
      Date fecEmision              = datasetAsiCab.getDate("fec_emision");
      Date fecImputacion           = datasetAsiCab.getDate("fec_imputacion");
      Integer oidMoneda            = datasetAsiCab.getInteger("oid_moneda");
      String comentario            = datasetAsiCab.getString("comentario");
      Boolean noConvertir          = datasetAsiCab.getBoolean("no_convertir");
      ValorCotizacion cotizacion   = datasetAsiCab.getCotizacion("cotizacion");
      
      Integer oidTalonario         = datasetAsiCab.getInteger("oid_talonario");
      String letra                 = datasetAsiCab.getString("letra");
      Integer oidLugEmi            = datasetAsiCab.getInteger("oid_lug_emi");
      Integer nroExt 			   = datasetAsiCab.getInteger("nro_ext");

      asientoManual.addCotizacionesMonedas(listaCotiz);
      asientoManual.setContabiliza(AsientoManual.contabilizarComprobante(getSesion()));
      asientoManual.setTalonario(Talonario.findByOidProxy(oidTalonario,getSesion()));
      asientoManual.setTipoCompro(TipoComprobante.findByOidProxy(oidTC,getSesion()));
      asientoManual.setLetra(letra);
      asientoManual.setLugarEmision(LugarEmision.findByOidProxy(oidLugEmi,getSesion()));
      asientoManual.setNroext(nroExt);
      asientoManual.setEmision(fecEmision);
      asientoManual.setImputacion(fecImputacion);
      asientoManual.setComentario(comentario);
      asientoManual.setNoContaOtrasMonedas(noConvertir);
      asientoManual.setMoneda(Moneda.findByOidProxy(oidMoneda,getSesion()));
      if (Moneda.findByOid(oidMoneda,getSesion()).isMonedaCursoLegal())
    	  asientoManual.setCotizacion(new ValorCotizacion(1.0));
      else
    	  asientoManual.setCotizacion(cotizacion);
    	  
      asientoManual.setTipoCambio(ComproConta.getTipoCambioContable(getSesion()));
      asientoManual.setActivo(new Boolean(true));      
      IDataSet dataSetAsientoDet = datasetAsiCab.getDataSet("TAsientoDet");
      dataSetAsientoDet.first();
      while (!dataSetAsientoDet.EOF()) {
        AsientoManualDet asientoManualDet = asientoManual.addDetalle();
        asientoManualDet.setSecu(dataSetAsientoDet.getInteger("secu"));
        asientoManualDet.setCuentaImputable(
            CuentaImputable.findByOidProxy(dataSetAsientoDet.getInteger("oid_ana_imp"),
                                           getSesion()));
        asientoManualDet.setImporteDebe(dataSetAsientoDet.getMoney("debe"));
        asientoManualDet.setImporteHaber(dataSetAsientoDet.getMoney("haber"));
        asientoManualDet.setComentario(dataSetAsientoDet.getString("comentario"));
        dataSetAsientoDet.next();
      }
      addTransaccion(asientoManual);
      datasetAsiCab.next();

    }

  }

  protected void afterSave() throws BaseException {
  	InformarComprobante infoCompro = null;
  	if (asientoManual!=null) {
      infoCompro = new InformarComprobante(
        asientoManual.getOIDInteger(),
        asientoManual.getDescripcion());
  	}
  	
  	if (infoCompro!=null)
  		writeCliente(infoCompro.getDataSetInfoCompro());

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
