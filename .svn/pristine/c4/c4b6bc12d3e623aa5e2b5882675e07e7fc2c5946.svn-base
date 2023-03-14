package com.srn.erp.bancos.op;

import com.srn.erp.bancos.bm.NotaBancaria;
import com.srn.erp.bancos.bm.NotaBancariaDet;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveNotaBancaria extends Operation {

  NotaBancaria notaBancaria = null;
  HashTableDatos listaCotiz = null;

  public SaveNotaBancaria() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));
    IDataSet dataset = mapaDatos.getDataSet("TNotaBancaria");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        notaBancaria = NotaBancaria.findByOid(dataset.getInteger("oid_nota_bancaria"),getSesion());
        notaBancaria.addCotizacionesMonedas(listaCotiz);
        notaBancaria.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        notaBancaria.setContabiliza(true);
        notaBancaria.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        notaBancaria.setLetra(ComproCab.getLetraDefault(getSesion()));
        notaBancaria.setLugarEmision(ComproCab.getLugEmiDafault(getSesion()));
        notaBancaria.setEmision(dataset.getDate("fecha"));
        notaBancaria.setComentario(dataset.getString("comentario"));
        notaBancaria.setImputac(dataset.getDate("fecha"));
        notaBancaria.setMoneda_cta(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
        notaBancaria.setCuenta_bancaria(CuentaBancaria.findByOidProxy(dataset.getInteger("oid_cta_bancaria"),getSesion()));
        notaBancaria.setCotizacion(dataset.getCotizacion("cotizacion"));
        notaBancaria.setTot_mon_cta(dataset.getMoney("tot_mon_cta"));
        notaBancaria.setActivo(new Boolean(true));
        procesarDetalles(dataset);
        
        addTransaccion(notaBancaria);
        dataset.next();
    }
  }
  
  public void procesarDetalles(IDataSet dataset) throws BaseException {
  	IDataSet dsDetalles = dataset.getDataSet("TNotaBancariaDet");
  	dsDetalles.first();
  	while (!dsDetalles.EOF()) {
  		NotaBancariaDet notaBancariaDet = NotaBancariaDet.findByOid(dsDetalles.getInteger("oid_nd_nc_det"),getSesion());
  		notaBancariaDet.setNota_bancaria(notaBancaria);  		
  		notaBancariaDet.setCuenta_imputable(CuentaImputable.findByOidProxy(dsDetalles.getInteger("oid_ai"),getSesion()));
  		notaBancariaDet.setDebe(dsDetalles.getMoney("debe"));
  		notaBancariaDet.setHaber(dsDetalles.getMoney("haber"));
  		notaBancariaDet.setComentario(dsDetalles.getString("comentario"));
  		notaBancaria.addDetalle(notaBancariaDet);
  		dsDetalles.next();
  	}
  	
  }
  
 
  protected void afterSave() throws BaseException {

      InformarComprobante infoCompro = new InformarComprobante(
      		notaBancaria.getOIDInteger(),
      		notaBancaria.getDescripcion());

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
