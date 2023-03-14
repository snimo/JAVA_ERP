package com.srn.erp.ctasAPagar.op;

import java.util.Date;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProv;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProvDet;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAplicComproProv extends Operation {

  AplicacionComproProv aplicacionComproProv = null;
  HashTableDatos listaCotiz = null;

  public SaveAplicComproProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	 listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));
	  
	Talonario talonario = Talonario.findByOidProxy(mapaDatos.getInteger("oid_talonario"),getSesion());
	Date fecEmision 	= mapaDatos.getDate("fec_emision");
	Integer nroExt      = mapaDatos.getInteger("nro_ext");
	
    IDataSet dsAplicRealizadas = mapaDatos.getDataSet("TAplicacionesRealizadas");
    dsAplicRealizadas.first();
    while (!dsAplicRealizadas.EOF()) {

      aplicacionComproProv = AplicacionComproProv.findByOid(dsAplicRealizadas.getInteger("oid"),getSesion());
      aplicacionComproProv.addCotizacionesMonedas(listaCotiz);
      aplicacionComproProv.setContabiliza(AplicacionComproProv.contabilizarComprobante(getSesion()));
      aplicacionComproProv.setTalonario(talonario);
      aplicacionComproProv.setTipoCompro(talonario.getTipo_comprobante());
      aplicacionComproProv.setEmision(fecEmision);
      aplicacionComproProv.setImputacion(fecEmision);
      aplicacionComproProv.setComentario("");
      aplicacionComproProv.setNroext(nroExt);
      aplicacionComproProv.setProveedor(Proveedor.findByOidProxy(dsAplicRealizadas.getInteger("oid_proveedor"),getSesion()));
      aplicacionComproProv.setNoContaOtrasMonedas(new Boolean(false));
      aplicacionComproProv.setActivo(new Boolean(true));
      aplicacionComproProv.setAllowDesaplicar(true);
      

      
      AplicacionComproProvDet aplicComproProvDet =
          aplicacionComproProv.addDetalle();
      aplicComproProvDet.setTranprovvto(TranProvVto.findByOidProxy(dsAplicRealizadas.getInteger("oid_tran_vto"),getSesion()));
      aplicComproProvDet.setAplicmonedaori(dsAplicRealizadas.getMoney("importe"));
      aplicComproProvDet.setCotizmonoricont(dsAplicRealizadas.getCotizacion("cotiz_mon_ori"));
      aplicComproProvDet.setCotizmonext1cont(dsAplicRealizadas.getCotizacion("cotiz_mon_ext1"));
      aplicComproProvDet.setCotizmonext2cont(dsAplicRealizadas.getCotizacion("cotiz_mon_ext2"));
      aplicComproProvDet.setCotizmonorihoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ori_hoy"));
      aplicComproProvDet.setCotizmonext1hoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ext1_hoy"));
      aplicComproProvDet.setCotizmonext2hoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ext2_hoy"));
      aplicComproProvDet.setNroRelacion(dsAplicRealizadas.getInteger("oid"));
      aplicComproProvDet.setComproAplicOri(ComproCab.findByOidProxyCompro(dsAplicRealizadas.getInteger("oid_cco_ori_1"),getSesion()));
      aplicComproProvDet.setTranprovvtoAplic(TranProvVto.findByOidProxy(dsAplicRealizadas.getInteger("oid_tran_vto_1"),getSesion()));

      AplicacionComproProvDet aplicComproProvDet1 =
          aplicacionComproProv.addDetalle();
      aplicComproProvDet1.setTranprovvto(TranProvVto.findByOidProxy(dsAplicRealizadas.getInteger("oid_tran_vto_1"),getSesion()));
      aplicComproProvDet1.setAplicmonedaori(dsAplicRealizadas.getMoney("importe_1"));
      aplicComproProvDet1.setCotizmonoricont(dsAplicRealizadas.getCotizacion("cotiz_mon_ori_1"));
      aplicComproProvDet1.setCotizmonext1cont(dsAplicRealizadas.getCotizacion("cotiz_mon_ext1_1"));
      aplicComproProvDet1.setCotizmonext2cont(dsAplicRealizadas.getCotizacion("cotiz_mon_ext2_1"));
      aplicComproProvDet1.setCotizmonorihoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ori_hoy_1"));
      aplicComproProvDet1.setCotizmonext1hoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ext1_hoy_1"));
      aplicComproProvDet1.setCotizmonext2hoy(dsAplicRealizadas.getCotizacion("cotiz_mon_ext2_hoy_1"));
      aplicComproProvDet1.setNroRelacion(dsAplicRealizadas.getInteger("oid"));
      aplicComproProvDet1.setComproAplicOri(ComproCab.findByOidProxyCompro(dsAplicRealizadas.getInteger("oid_cco_ori"),getSesion()));
      aplicComproProvDet1.setTranprovvtoAplic(TranProvVto.findByOidProxy(dsAplicRealizadas.getInteger("oid_tran_vto"),getSesion()));
      
      if ((aplicComproProvDet.getTranprovvto().getSaldo().doubleValue()>0) && (aplicComproProvDet1.getTranprovvto().getSaldo().doubleValue()>0))
      	throw new ExceptionValidation(null,"No se puede aplicar dos comprobantes con el mismo signo de saldo.");
      
      if ((aplicComproProvDet.getTranprovvto().getSaldo().doubleValue()<0) && (aplicComproProvDet1.getTranprovvto().getSaldo().doubleValue()<0))
        	throw new ExceptionValidation(null,"No se puede aplicar dos comprobantes con el mismo signo de saldo.");
      
      if (aplicComproProvDet.getTranprovvto().getTranprov().getProveedor().getOID()
    		  !=aplicComproProvDet1.getTranprovvto().getTranprov().getProveedor().getOID())
    	  throw new ExceptionValidation(null,"Los comprobantes a aplicar corresponden a diferentes Proveedores");
    	  
      

      addTransaccion(aplicacionComproProv);
      dsAplicRealizadas.next();

    }

  }

  protected void afterSave() throws BaseException {

      InformarComprobante infoCompro = new InformarComprobante(
        aplicacionComproProv.getOIDInteger(),
        aplicacionComproProv.getDescripcion());

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
