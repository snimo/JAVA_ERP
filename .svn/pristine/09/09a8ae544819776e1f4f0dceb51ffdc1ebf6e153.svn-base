package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizDetPorProv;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProvDet;
import com.srn.erp.compras.bm.SolicitudCotizProveedor;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSolicitudCotizProvCab extends Operation { 
	
  SolicitudCotizProvCab solicitudcotizprovcab = null;
  
  public SaveSolicitudCotizProvCab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TSolicitudCotizProvCab"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        solicitudcotizprovcab = SolicitudCotizProvCab.findByOid(dataset.getInteger("oid_cco_sol_cotiz"),getSesion());
        solicitudcotizprovcab.setOID(dataset.getInteger("oid_cco_sol_cotiz"));
        
        // Set datos del comrobante
        solicitudcotizprovcab.setContabiliza(false);
        solicitudcotizprovcab.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        solicitudcotizprovcab.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        solicitudcotizprovcab.setLetra(dataset.getString("letra"));
        solicitudcotizprovcab.setLugarEmision(LugarEmision.findByOidProxy(dataset.getInteger("oid_lug_emi"),getSesion()));
        solicitudcotizprovcab.setNroext(dataset.getInteger("nro_ext"));
        solicitudcotizprovcab.setEmision(dataset.getDate("fec_emision"));
        solicitudcotizprovcab.setComentario(dataset.getString("comentario"));
        
        solicitudcotizprovcab.setFec_tope_ent_sol(dataset.getDate("fec_tope_ent_sol"));
        solicitudcotizprovcab.setObs_detalladas(dataset.getString("obs_detalladas"));
        solicitudcotizprovcab.setActivo(dataset.getBoolean("activo"));
        if (!solicitudcotizprovcab.isActivo().booleanValue())
        	solicitudcotizprovcab.delete();
        
        
        // Solitud Cotizacion Proveedores
        IDataSet dsSolicitudProveedor = dataset.getDataSet("TSolicitudCotizProveedor");
        dsSolicitudProveedor.first();
        while (!dsSolicitudProveedor.EOF()) {
        	SolicitudCotizProveedor solicitudCotizProveedor = 
        		SolicitudCotizProveedor.findByOid(dsSolicitudProveedor.getInteger("oid_sol_cotiz_prov"),getSesion());
        	solicitudCotizProveedor.setSolicitud_cotizacion(solicitudcotizprovcab);
        	solicitudCotizProveedor.setProveedor(Proveedor.findByOidProxy(dsSolicitudProveedor.getInteger("oid_proveedor"),getSesion()));
        	solicitudcotizprovcab.addCotizacionProveedor(solicitudCotizProveedor);
        	dsSolicitudProveedor.next();
        }
        
        // Productos a Cotizar
        IDataSet dsProductosACotizar = dataset.getDataSet("TSolicitudCotizProvDet");
        dsProductosACotizar.first();
        while (!dsProductosACotizar.EOF()) {
        	SolicitudCotizProvDet solCotizProvDet = SolicitudCotizProvDet.findByOid(dsProductosACotizar.getInteger("oid_sol_cotiz_det"),getSesion());
        	solCotizProvDet.setSolicitud_cotiz_proveedor(solicitudcotizprovcab);
        	solCotizProvDet.setNro_item(dsProductosACotizar.getInteger("nro_item"));
        	solCotizProvDet.setProducto(Producto.findByOidProxy(dsProductosACotizar.getInteger("oid_producto"),getSesion()));
        	solCotizProvDet.setFec_entrega(dsProductosACotizar.getDate("fec_ent"));
        	solCotizProvDet.setCant_requerida(dsProductosACotizar.getDouble("cant_requerida"));
        	solCotizProvDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsProductosACotizar.getInteger("oid_um"),getSesion()));
        	solCotizProvDet.setObs_sol_cotiz(dsProductosACotizar.getString("obs_sol_cotiz"));
        	solCotizProvDet.setAnulado(dsProductosACotizar.getBoolean("anulado"));
        	solicitudcotizprovcab.addProductoACotizar(solCotizProvDet);
        	dsProductosACotizar.next();
        }
        
        // Productos Cotizados por Proveedor
        IDataSet dsProductosCotizProv = dataset.getDataSet("TSolicitudCotizDetPorProv");
        dsProductosCotizProv.first();
        while (!dsProductosCotizProv.EOF()) {
        	SolicitudCotizDetPorProv solCotizDetPorProv = SolicitudCotizDetPorProv.findByOid(dsProductosCotizProv.getInteger("oid_cotiz_det_prov"),getSesion());
        	solCotizDetPorProv.setSolicitudCotizacion(solicitudcotizprovcab);
        	solCotizDetPorProv.setSolicitud_cotiz_prov(solicitudcotizprovcab.getSolicitudCotizProveedor(dsProductosCotizProv.getInteger("oid_sol_cotiz_prov")));
        	solCotizDetPorProv.setSolicitud_cotiz_det(solicitudcotizprovcab.getSolicitudCotizProvDet(dsProductosCotizProv.getInteger("oid_sol_cotiz_det")));
        	solCotizDetPorProv.setCant_a_cotizar(dsProductosCotizProv.getDouble("cant_a_cotizar"));
        	solCotizDetPorProv.setOid_um_cpra(UnidadMedida.findByOidProxy(dsProductosCotizProv.getInteger("oid_um_cpra"),getSesion()));
        	solCotizDetPorProv.setCotizar(dsProductosCotizProv.getBoolean("cotizar"));
        	solCotizDetPorProv.setObs_art_prov(dsProductosCotizProv.getString("obs_art_prov"));
        	solicitudcotizprovcab.addCotizacionProductoProveedor(solCotizDetPorProv);
        	dsProductosCotizProv.next();
        }
        
        addTransaccion(solicitudcotizprovcab);
        dataset.next();
    }
  }
  
  
  
  protected void afterSave() throws BaseException {

      InformarComprobante infoCompro = new InformarComprobante(
    		  solicitudcotizprovcab.getOIDInteger(),
    		  solicitudcotizprovcab.getDescripcion());

      writeCliente(infoCompro.getDataSetInfoCompro());

  }  
  
}
