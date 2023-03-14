package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizDetPorProv;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetallesSolCotizProv extends Operation { 

  private int oid = -1000000;	 
	
  public TraerDetallesSolCotizProv() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  
	SolicitudCotizProvCab solCotizProveedor = null;
    Integer oid = mapaDatos.getInteger("oid_sol_cotiz"); 
    Integer oidCotizProvCab = mapaDatos.getInteger("oid_cotiz_prov_cab");
    Proveedor proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion());
    
    IDataSet dsDetallesSolicitudes = getDataSetCotizacionProveedorDet();
    
    solCotizProveedor = SolicitudCotizProvCab.findByOid(oid,getSesion()); 
    
    if (solCotizProveedor != null) {
    	Iterator iterProdDetSolCotiz = solCotizProveedor.getProductosCotizProveedores().iterator();
    	while (iterProdDetSolCotiz.hasNext()) {
    		SolicitudCotizDetPorProv solCotizDetPorProv = (SolicitudCotizDetPorProv) iterProdDetSolCotiz.next();
    		// Traer las cotizaciones del Proveedor Correspondiente
    		if (solCotizDetPorProv.getSolicitud_cotiz_prov().getProveedor().getOID()==proveedor.getOID())
    		    cargarRegistroDetalleSolicitud(dsDetallesSolicitudes,oidCotizProvCab,solCotizProveedor,solCotizDetPorProv);
    	}  
    }
    writeCliente(dsDetallesSolicitudes);
  }

    private IDataSet getDataSetCotizacionProveedorDet() { 
	    IDataSet dataset = new TDataSet();
	    
	    dataset.create("TCotizacionProveedorDet");
	    dataset.fieldDef(new Field("oid_cotiz_prov_det", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_cotiz_prov_cab", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_cotiz_det_prov", Field.INTEGER, 0)); 
	    
	    // Por la Solicitud a Proveedores
	    dataset.fieldDef(new Field("nro_item_sol_cotiz",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_art_sol_cotiz",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_art_sol_cotiz",Field.STRING, 50));	    
	    dataset.fieldDef(new Field("desc_art_sol_cotiz",Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_adic_art",Field.STRING, 255));
	    dataset.fieldDef(new Field("oid_um_sol_cotiz",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_um_sol_cotiz",Field.STRING, 20));
	    dataset.fieldDef(new Field("cantidad_sol_cotiz",Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("fecha_ent_sol_cotiz",Field.DATE, 0));
	    dataset.fieldDef(new Field("desc_adic_sol_cotiz",Field.STRING, 255));
	    dataset.fieldDef(new Field("anulado_sol_cotiz",Field.BOOLEAN, 0));
	    
	    // Datos del Presupuesto del Proveedor
	    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("cant_presu", Field.CURRENCY, 0)); 
	    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("precio", Field.CURRENCY, 0)); 
	    dataset.fieldDef(new Field("fec_ent", Field.DATE, 0)); 
	    dataset.fieldDef(new Field("comentario", Field.STRING, 255)); 
	    dataset.fieldDef(new Field("oid_cond_pago_1", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("dto_cond_pago_1", Field.CURRENCY, 0)); 
	    dataset.fieldDef(new Field("oid_cond_pago_2", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("dto_cond_pago_2", Field.CURRENCY, 0)); 
	    dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0)); 
	    return dataset;
	  }

  
	  private void cargarRegistroDetalleSolicitud(IDataSet dataset,
			  				 Integer oidCotizProvCab, 	
			  				 SolicitudCotizProvCab solCotizProvCab,	
			  				 SolicitudCotizDetPorProv solCotizDetPorProv) throws BaseException {
		  
	    dataset.append(); 
	    dataset.fieldValue("oid_cotiz_prov_det", ++oid);
	    dataset.fieldValue("oid_cotiz_prov_cab", oidCotizProvCab);
	    dataset.fieldValue("oid_cotiz_det_prov", solCotizDetPorProv.getOIDInteger());
	    dataset.fieldValue("nro_item_sol_cotiz", solCotizDetPorProv.getSolicitud_cotiz_det().getNro_item());
	    	    
	    cargarDatosSolCotizDet(dataset,solCotizDetPorProv.getSolicitud_cotiz_det().getProducto(),solCotizDetPorProv);
	    
	    dataset.fieldValue("oid_um", solCotizDetPorProv.getOid_um_cpra().getOID());
	    dataset.fieldValue("cant_presu", solCotizDetPorProv.getCant_a_cotizar());
	    dataset.fieldValue("oid_moneda", 0);
	    dataset.fieldValue("precio", 0);
	    dataset.fieldValue("fec_ent",Fecha.getddmmyyyy(solCotizDetPorProv.getSolicitud_cotiz_det().getFec_entrega()));
	    dataset.fieldValue("comentario", "");
	    dataset.fieldValue("oid_cond_pago_1", 0);
	    dataset.fieldValue("dto_cond_pago_1", 0);
	    dataset.fieldValue("oid_cond_pago_2", 0);
	    dataset.fieldValue("dto_cond_pago_2", 0);
	    dataset.fieldValue("anulado", new Boolean(false));
	  } 

	  
	  private void cargarDatosSolCotizDet(IDataSet dataset,Producto producto,SolicitudCotizDetPorProv cotiz_det_prov) throws BaseException {
		  if (cotiz_det_prov!=null) {
		    dataset.fieldValue("oid_art_sol_cotiz",producto.getOIDInteger());	
		    dataset.fieldValue("cod_art_sol_cotiz",producto.getCodigo());
		    dataset.fieldValue("desc_art_sol_cotiz",producto.getDescripcion());
		    if (cotiz_det_prov.getSolicitud_cotiz_det().getDesc_adic_sku()!=null)
		       dataset.fieldValue("desc_adic_art",cotiz_det_prov.getSolicitud_cotiz_det().getDesc_adic_sku());
		    else
		       dataset.fieldValue("desc_adic_art","");	
		    dataset.fieldValue("oid_um_sol_cotiz",cotiz_det_prov.getOid_um_cpra().getOIDInteger());
		    dataset.fieldValue("cod_um_sol_cotiz",cotiz_det_prov.getOid_um_cpra().getCodigo());
		    dataset.fieldValue("cantidad_sol_cotiz",cotiz_det_prov.getCant_a_cotizar());
		    dataset.fieldValue("fecha_ent_sol_cotiz",Fecha.getddmmyyyy(cotiz_det_prov.getSolicitud_cotiz_det().getFec_entrega()));
		    dataset.fieldValue("desc_adic_sol_cotiz",cotiz_det_prov.getObs_art_prov());
		    dataset.fieldValue("anulado_sol_cotiz",cotiz_det_prov.getSolicitud_cotiz_det().isAnulado());
		  }
		  else {
		    dataset.fieldValue("oid_art_sol_cotiz",producto.getOIDInteger());	
		    dataset.fieldValue("cod_art_sol_cotiz",producto.getCodigo());
		    dataset.fieldValue("desc_art_sol_cotiz",producto.getDescripcion());
			dataset.fieldValue("desc_adic_art","");
			dataset.fieldValue("oid_um_sol_cotiz",0);
			dataset.fieldValue("cod_um_sol_cotiz","");
			dataset.fieldValue("cantidad_sol_cotiz",0);
			dataset.fieldValue("fecha_ent_sol_cotiz",Fecha.FECHA_NULA());
			dataset.fieldValue("desc_adic_sol_cotiz","");			  
			dataset.fieldValue("anulado_sol_cotiz",new Boolean(false));
		  }
	  }
  
}
