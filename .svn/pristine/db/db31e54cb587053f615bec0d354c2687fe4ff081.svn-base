package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.CotizacionProveedorCab;
import com.srn.erp.compras.bm.CotizacionProveedorDet;
import com.srn.erp.compras.bm.SolicitudCotizDetPorProv;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCotizacionProveedorCab extends Operation { 

  public TraerCotizacionProveedorCab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
    CotizacionProveedorCab cotizacionproveedorcab = null;
    Integer oid = mapaDatos.getInteger("oid"); 
    
    IDataSet datasetCotizacionProveedorCab = getDataSetCotizacionProveedorCab();
    IDataSet datasetCotizacionProveedorDet = getDataSetCotizacionProveedorDet();
    
    cotizacionproveedorcab = CotizacionProveedorCab.findByOid(oid,getSesion()); 
    
    if (cotizacionproveedorcab != null) { 
        cargarRegistroCotizacionProveedorCab(datasetCotizacionProveedorCab,cotizacionproveedorcab); 
        
        Iterator iterDetalles = cotizacionproveedorcab.getDetallesCotizaciones().iterator();
        while (iterDetalles.hasNext()) {
        	CotizacionProveedorDet cotizProvDet = (CotizacionProveedorDet) iterDetalles.next();
        	cargarRegistroCotizacionProveedorDet(datasetCotizacionProveedorDet,cotizacionproveedorcab,cotizProvDet);
        }
        
    }
    writeCliente(datasetCotizacionProveedorCab);
    writeCliente(datasetCotizacionProveedorDet);
  }

  private IDataSet getDataSetCotizacionProveedorCab() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCotizacionProveedorCab");
    dataset.fieldDef(new Field("oid_cotiz_prov_cab", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_talonario",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tc",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tc",Field.STRING, 50));
    dataset.fieldDef(new Field("letra",Field.STRING, 1));
    dataset.fieldDef(new Field("oid_lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision",Field.DATE, 0));
    dataset.fieldDef(new Field("comentario",Field.STRING, 255));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nro_ext_sol_cotiz",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sol_cotiz_prov", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_proveedor",Field.STRING, 50));
    dataset.fieldDef(new Field("rs_proveedor",Field.STRING, 100));
    dataset.fieldDef(new Field("vigencia_desde", Field.DATE, 0)); 
    dataset.fieldDef(new Field("vigencia_hasta", Field.DATE, 0)); 
    dataset.fieldDef(new Field("oid_cond_pago_1", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("dto_cond_pago_1", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("oid_cond_pago_2", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("dto_cond_pago_2", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroCotizacionProveedorCab(IDataSet dataset, 
                         CotizacionProveedorCab cotizProv)  throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_cotiz_prov_cab", cotizProv.getOIDInteger());
    dataset.fieldValue("oid_talonario",cotizProv.getTalonario().getOIDInteger());
    dataset.fieldValue("oid_tc",cotizProv.getTipoCompro().getOIDInteger());
    dataset.fieldValue("cod_tc",cotizProv.getTipoCompro().getCodigo());
    dataset.fieldValue("letra",cotizProv.getLetra());
    dataset.fieldValue("oid_lug_emi", cotizProv.getLugarEmision().getOIDInteger());
    dataset.fieldValue("lug_emi",cotizProv.getLugarEmision().getLugemi());
    
    dataset.fieldValue("nro_ext",cotizProv.getNroExt());
    dataset.fieldValue("fec_emision",Fecha.getddmmyyyy(cotizProv.getEmision()));
    if (cotizProv.getComentario()!=null)
      dataset.fieldValue("comentario",cotizProv.getComentario());
    else
      dataset.fieldValue("comentario","");
    dataset.fieldValue("activo",cotizProv.isActivo());
    if (cotizProv.getSolicitud_cotiz_prov()!=null)
      dataset.fieldValue("nro_ext_sol_cotiz",cotizProv.getSolicitud_cotiz_prov().getNroExt());
    else
      dataset.fieldValue("nro_ext_sol_cotiz",0);    	
    if (cotizProv.getSolicitud_cotiz_prov()!=null)
      dataset.fieldValue("oid_sol_cotiz_prov", cotizProv.getSolicitud_cotiz_prov().getOIDInteger());
    else
      dataset.fieldValue("oid_sol_cotiz_prov",0);	
    dataset.fieldValue("oid_proveedor", cotizProv.getProveedor().getOIDInteger());
    dataset.fieldValue("cod_proveedor", cotizProv.getProveedor().getCodigo());
    dataset.fieldValue("rs_proveedor", cotizProv.getProveedor().getRazonsocial());
    
    dataset.fieldValue("vigencia_desde", Fecha.getddmmyyyy(cotizProv.getVigencia_desde()));
    dataset.fieldValue("vigencia_hasta", Fecha.getddmmyyyy(cotizProv.getVigencia_hasta()));
    if (cotizProv.getCond_pago_1()!=null)
      dataset.fieldValue("oid_cond_pago_1", cotizProv.getCond_pago_1().getOIDInteger());
    else
      dataset.fieldValue("oid_cond_pago_1", 0); 
    if (cotizProv.getDto_cond_pago_1()!=null)	
      dataset.fieldValue("dto_cond_pago_1", cotizProv.getDto_cond_pago_1());
    else
      dataset.fieldValue("dto_cond_pago_1", 0);
    if (cotizProv.getCond_pago_2()!=null)
      dataset.fieldValue("oid_cond_pago_2", cotizProv.getCond_pago_2().getOIDInteger());
    else
      dataset.fieldValue("oid_cond_pago_2",0);  
    if (cotizProv.getDto_cond_pago_2()!=null)	
      dataset.fieldValue("dto_cond_pago_2", cotizProv.getDto_cond_pago_2());
    else
      dataset.fieldValue("dto_cond_pago_2", 0);
    dataset.fieldValue("oid_moneda",cotizProv.getMoneda().getOIDInteger());
    	
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

	  private void cargarRegistroCotizacionProveedorDet(IDataSet dataset,
			  				 CotizacionProveedorCab cotizProvCab,
			  				 CotizacionProveedorDet cotizProvDet) throws BaseException {
		  
	    dataset.append(); 
	    dataset.fieldValue("oid_cotiz_prov_det", cotizProvDet.getOIDInteger());
	    dataset.fieldValue("oid_cotiz_prov_cab", cotizProvCab.getOIDInteger());
	    if (cotizProvDet.getCotizacion_det_prov()!=null)
	      dataset.fieldValue("oid_cotiz_det_prov", cotizProvDet.getCotizacion_det_prov().getOIDInteger());
	    else
	      dataset.fieldValue("oid_cotiz_det_prov", 0);
	    dataset.fieldValue("nro_item_sol_cotiz",cotizProvDet.getNroItem());
	    cargarDatosSolCotizDet(dataset,cotizProvDet.getProducto(),cotizProvDet.getCotizacion_det_prov());
	    
	    dataset.fieldValue("oid_um", cotizProvDet.getUnidad_medida().getOIDInteger());
	    dataset.fieldValue("cant_presu", cotizProvDet.getCant_presu());
	    dataset.fieldValue("oid_moneda", cotizProvDet.getMoneda().getOIDInteger());
	    dataset.fieldValue("precio", cotizProvDet.getPrecio());
	    dataset.fieldValue("fec_ent",Fecha.getddmmyyyy(cotizProvDet.getFec_ent()));
	    if (cotizProvDet.getComentario()!=null) 
	      dataset.fieldValue("comentario", cotizProvDet.getComentario());
	    else
	      dataset.fieldValue("comentario", "");
	    if (cotizProvDet.getCond_pago_1()!=null)
	      dataset.fieldValue("oid_cond_pago_1", cotizProvDet.getCond_pago_1().getOIDInteger());
	    else
	      dataset.fieldValue("oid_cond_pago_1", 0);	    	
	    if (cotizProvDet.getDto_cond_pago_1()!=null)
	      dataset.fieldValue("dto_cond_pago_1", cotizProvDet.getDto_cond_pago_1());
	    else
	      dataset.fieldValue("dto_cond_pago_1", 0);
	    if (cotizProvDet.getCond_pago_2()!=null)
	      dataset.fieldValue("oid_cond_pago_2", cotizProvDet.getCond_pago_2().getOIDInteger());
	    else
	      dataset.fieldValue("oid_cond_pago_2", 0);
	    if (cotizProvDet.getDto_cond_pago_2()!=null)
	      dataset.fieldValue("dto_cond_pago_2", cotizProvDet.getDto_cond_pago_2());
	    else
	      dataset.fieldValue("dto_cond_pago_2", 0);
	    	
	    dataset.fieldValue("anulado", cotizProvDet.isAnulado());
	  } 
	  
	  private void cargarDatosSolCotizDet(IDataSet dataset,Producto producto,SolicitudCotizDetPorProv cotiz_det_prov) throws BaseException {
		  if (cotiz_det_prov!=null) {
		    dataset.fieldValue("oid_art_sol_cotiz",producto.getOIDInteger());	
		    dataset.fieldValue("cod_art_sol_cotiz",producto.getCodigo());
		    dataset.fieldValue("desc_art_sol_cotiz",producto.getDescripcion());
		    if (cotiz_det_prov.getSolicitud_cotiz_det()!=null) {
		       if (cotiz_det_prov.getSolicitud_cotiz_det().getDesc_adic_sku()!=null)	
		          dataset.fieldValue("desc_adic_art",cotiz_det_prov.getSolicitud_cotiz_det().getDesc_adic_sku());
		       else
		    	  dataset.fieldValue("desc_adic_art",""); 
		    }
		    else
		       dataset.fieldValue("desc_adic_art","");	
		    dataset.fieldValue("oid_um_sol_cotiz",cotiz_det_prov.getOid_um_cpra().getOIDInteger());
		    dataset.fieldValue("cod_um_sol_cotiz",cotiz_det_prov.getOid_um_cpra().getCodigo());
		    dataset.fieldValue("cantidad_sol_cotiz",cotiz_det_prov.getCant_a_cotizar());
		    dataset.fieldValue("fecha_ent_sol_cotiz",Fecha.getddmmyyyy(cotiz_det_prov.getSolicitud_cotiz_det().getFec_entrega()));
		    dataset.fieldValue("desc_adic_sol_cotiz",cotiz_det_prov.getObs_art_prov());
		    dataset.fieldValue("anulado_sol_cotiz",new Boolean(false));
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
