package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.CotizacionProveedorCab;
import com.srn.erp.compras.bm.CotizacionProveedorDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizDetPorProv;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCotizacionProveedorCab extends Operation { 

  private CotizacionProveedorCab cotizacionproveedorcab = null;	
	
  public SaveCotizacionProveedorCab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCotizacionProveedorCab"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        cotizacionproveedorcab = CotizacionProveedorCab.findByOid(dataset.getInteger("oid_cotiz_prov_cab"),getSesion());
        cotizacionproveedorcab.setOID(dataset.getInteger("oid_cotiz_prov_cab"));
        
        // Set datos del comrobante
        cotizacionproveedorcab.setContabiliza(false);
        cotizacionproveedorcab.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        cotizacionproveedorcab.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        cotizacionproveedorcab.setLetra(dataset.getString("letra"));
        cotizacionproveedorcab.setLugarEmision(LugarEmision.findByOidProxy(dataset.getInteger("oid_lug_emi"),getSesion()));
        cotizacionproveedorcab.setNroext(dataset.getInteger("nro_ext"));
        cotizacionproveedorcab.setEmision(dataset.getDate("fec_emision"));
        cotizacionproveedorcab.setComentario(dataset.getString("comentario"));
        
        cotizacionproveedorcab.setSolicitud_cotiz_prov(SolicitudCotizProvCab.findByOidProxy(dataset.getInteger("oid_sol_cotiz_prov"),getSesion()));
        cotizacionproveedorcab.setProveedor(Proveedor.findByOidProxy(dataset.getInteger("oid_proveedor"),getSesion()));
        cotizacionproveedorcab.setVigencia_desde(dataset.getDate("vigencia_desde"));
        cotizacionproveedorcab.setVigencia_hasta(dataset.getDate("vigencia_hasta"));
        cotizacionproveedorcab.setCond_pago_1(CondicionCompra.findByOidProxy(dataset.getInteger("oid_cond_pago_1"),getSesion()));
        cotizacionproveedorcab.setDto_cond_pago_1(dataset.getMoney("dto_cond_pago_1"));
        cotizacionproveedorcab.setCond_pago_2(CondicionCompra.findByOidProxy(dataset.getInteger("oid_cond_pago_2"),getSesion()));
        cotizacionproveedorcab.setDto_cond_pago_2(dataset.getMoney("dto_cond_pago_2"));
        cotizacionproveedorcab.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
        cotizacionproveedorcab.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsCotizacionDet = dataset.getDataSet("TCotizacionProveedorDet");
        dsCotizacionDet.first();
        while (!dsCotizacionDet.EOF()) {
        	CotizacionProveedorDet cotizProvDet = 
        		CotizacionProveedorDet.findByOid(dsCotizacionDet.getInteger("oid_cotiz_prov_det"),getSesion());
        	cotizProvDet.setCotizacion_det_prov(SolicitudCotizDetPorProv.findByOidProxy(dsCotizacionDet.getInteger("oid_cotiz_det_prov"),getSesion())); 
        	cotizProvDet.setNroItem(dsCotizacionDet.getInteger("nro_item_sol_cotiz"));
        	cotizProvDet.setCotizacion_proveedor(cotizacionproveedorcab);
        	cotizProvDet.setProducto(Producto.findByOidProxy(dsCotizacionDet.getInteger("oid_art_sol_cotiz"),getSesion()));
        	cotizProvDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsCotizacionDet.getInteger("oid_um"),getSesion()));
        	cotizProvDet.setCant_presu(dsCotizacionDet.getDouble("cant_presu"));
        	cotizProvDet.setMoneda(Moneda.findByOidProxy(dsCotizacionDet.getInteger("oid_moneda"),getSesion()));
        	cotizProvDet.setPrecio(dsCotizacionDet.getMoney("precio"));
        	cotizProvDet.setFec_ent(dsCotizacionDet.getDate("fec_ent"));
        	cotizProvDet.setComentario(dsCotizacionDet.getString("comentario"));
        	cotizProvDet.setCond_pago_1(CondicionCompra.findByOidProxy(dsCotizacionDet.getInteger("oid_cond_pago_1"),getSesion()));
        	cotizProvDet.setDto_cond_pago_1(dsCotizacionDet.getDouble("dto_cond_pago_1"));
        	cotizProvDet.setCond_pago_2(CondicionCompra.findByOidProxy(dsCotizacionDet.getInteger("oid_cond_pago_2"),getSesion()));
        	cotizProvDet.setDto_cond_pago_2(dsCotizacionDet.getDouble("dto_cond_pago_2"));
        	cotizProvDet.setAnulado(dsCotizacionDet.getBoolean("anulado"));
        	cotizacionproveedorcab.addDetalle(cotizProvDet);
        	dsCotizacionDet.next();
        }
        addTransaccion(cotizacionproveedorcab);
        dataset.next();
    }
  }
  
  protected void afterSave() throws BaseException {

	  if (cotizacionproveedorcab!=null) {
        InformarComprobante infoCompro = new InformarComprobante(
    		  cotizacionproveedorcab.getOIDInteger(),
    		  cotizacionproveedorcab.getDescripcion());
        writeCliente(infoCompro.getDataSetInfoCompro());
	  }

  }  
  
}
