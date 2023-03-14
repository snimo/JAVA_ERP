package com.srn.erp.ctasACobrar.op;

import java.util.Date;

import com.srn.erp.ctasACobrar.bm.AplicacionComproClie;
import com.srn.erp.ctasACobrar.bm.AplicacionComproClieDet;
import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAplicComproClie extends Operation {

  AplicacionComproClie aplicacionComproClie = null;
  HashTableDatos listaCotiz = null;

  public SaveAplicComproClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	 listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));
	  
	Talonario talonario = Talonario.findByOidProxy(mapaDatos.getInteger("oid_talonario"),getSesion());
	Date fecEmision 	= mapaDatos.getDate("fec_emision");
	Integer nroExt      = mapaDatos.getInteger("nro_ext");
	
    IDataSet dsAplicRealizadas = mapaDatos.getDataSet("TAplicacionesRealizadas");
    dsAplicRealizadas.first();
    while (!dsAplicRealizadas.EOF()) {

      aplicacionComproClie = AplicacionComproClie.findByOid(dsAplicRealizadas.getInteger("oid"),getSesion());
      aplicacionComproClie.addCotizacionesMonedas(listaCotiz);
      aplicacionComproClie.setContabiliza(AplicacionComproProv.contabilizarComprobante(getSesion()));
      aplicacionComproClie.setTalonario(talonario);
      aplicacionComproClie.setTipoCompro(talonario.getTipo_comprobante());
      aplicacionComproClie.setEmision(fecEmision);
      aplicacionComproClie.setImputacion(fecEmision);
      aplicacionComproClie.setComentario("");
      aplicacionComproClie.setNroext(nroExt);
      aplicacionComproClie.setSujeto(Sujeto.findByOidProxy(dsAplicRealizadas.getInteger("oid_cliente"),getSesion()));
      aplicacionComproClie.setNoContaOtrasMonedas(new Boolean(false));
      aplicacionComproClie.setActivo(new Boolean(true));
      aplicacionComproClie.setAllowDesaplicar(new Boolean(true));

      
      AplicacionComproClieDet aplicComproClieDet =
          aplicacionComproClie.addDetalle();
      
      TranClieVto tranVtoClie = 
      	TranClieVto.findByOidProxy(dsAplicRealizadas.getInteger("oid_tran_vto"),getSesion());
      TranClieVto tranVtoClie1 = 
      	TranClieVto.findByOidProxy(dsAplicRealizadas.getInteger("oid_tran_vto_1"),getSesion());
      Money impoAplic = dsAplicRealizadas.getMoney("importe");
      Money impoAplic1 = dsAplicRealizadas.getMoney("importe_1");
      
      	// Definir que los saldos de los comprobantes sean opuestos
      	if (((tranVtoClie.getSaldo().doubleValue()>0 &&
      			tranVtoClie1.getSaldo().doubleValue()>0))
      		||
      		((tranVtoClie.getSaldo().doubleValue()<0 &&
        			tranVtoClie1.getSaldo().doubleValue()<0)))
      		throw new ExceptionValidation(null,"Los comprobantes seleccionados no pueden aplicarse");
            
      aplicComproClieDet.setTranClieVto(tranVtoClie);
      aplicComproClieDet.setAplicmonedaori(dsAplicRealizadas.getMoney("importe"));
      aplicComproClieDet.setCotizmonoricont(dsAplicRealizadas.getCotizacion("cotiz_mon_ori"));
      aplicComproClieDet.setCotizmonext1cont(dsAplicRealizadas.getCotizacion("cotiz_mon_ext1"));
      aplicComproClieDet.setCotizmonext2cont(dsAplicRealizadas.getCotizacion("cotiz_mon_ext2"));
      aplicComproClieDet.setCotizmonorihoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ori_hoy"));
      aplicComproClieDet.setCotizmonext1hoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ext1_hoy"));
      aplicComproClieDet.setCotizmonext2hoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ext2_hoy"));
      aplicComproClieDet.setNroRelacion(dsAplicRealizadas.getInteger("oid"));
      aplicComproClieDet.setComproAplicOri(ComproCab.findByOidProxyCompro(dsAplicRealizadas.getInteger("oid_cco_ori_1"),getSesion()));
      aplicComproClieDet.setTranClieVtoAplic(tranVtoClie);

      AplicacionComproClieDet aplicComproClieDet1 =
    	  aplicacionComproClie.addDetalle();
      aplicComproClieDet1.setTranClieVto(TranClieVto.findByOidProxy(dsAplicRealizadas.getInteger("oid_tran_vto_1"),getSesion()));
      aplicComproClieDet1.setAplicmonedaori(dsAplicRealizadas.getMoney("importe_1"));
      aplicComproClieDet1.setCotizmonoricont(dsAplicRealizadas.getCotizacion("cotiz_mon_ori_1"));
      aplicComproClieDet1.setCotizmonext1cont(dsAplicRealizadas.getCotizacion("cotiz_mon_ext1_1"));
      aplicComproClieDet1.setCotizmonext2cont(dsAplicRealizadas.getCotizacion("cotiz_mon_ext2_1"));
      aplicComproClieDet1.setCotizmonorihoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ori_hoy_1"));
      aplicComproClieDet1.setCotizmonext1hoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ext1_hoy_1"));
      aplicComproClieDet1.setCotizmonext2hoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ext2_hoy_1"));
      aplicComproClieDet1.setNroRelacion(dsAplicRealizadas.getInteger("oid"));
      aplicComproClieDet1.setComproAplicOri(ComproCab.findByOidProxyCompro(dsAplicRealizadas.getInteger("oid_cco_ori"),getSesion()));
      aplicComproClieDet1.setTranClieVtoAplic(TranClieVto.findByOidProxy(dsAplicRealizadas.getInteger("oid_tran_vto"),getSesion()));

      if (aplicComproClieDet.getTranClieVto().getTran_clie().getSujeto().getOID()
    		  !=aplicComproClieDet1.getTranClieVto().getTran_clie().getSujeto().getOID())
    	  throw new ExceptionValidation(null,"Los comprobantes a aplicar corresponden a diferentes Clientes");
      
      addTransaccion(aplicacionComproClie);
      dsAplicRealizadas.next();

    }

  }

  protected void afterSave() throws BaseException {

      InformarComprobante infoCompro = new InformarComprobante(
        aplicacionComproClie.getOIDInteger(),
        aplicacionComproClie.getDescripcion());

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
