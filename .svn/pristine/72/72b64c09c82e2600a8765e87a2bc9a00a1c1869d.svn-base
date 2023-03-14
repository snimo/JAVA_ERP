package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CotizacionProveedorDet;
import com.srn.erp.compras.bm.Proveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SugerirCantCotProv extends Operation {

  public SugerirCantCotProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
		procesarCotProvDet(mapaDatos);
		  
	  }
	  
	  private void procesarCotProvDet(MapDatos mapaDatos) throws BaseException {
			CotizacionProveedorDet cotProvDet = CotizacionProveedorDet.findByOid(mapaDatos.getInteger("oid_cot_prov_det"), this.getSesion());  		  
		    IDataSet ds = getDS();
		    cargarRegistro(ds, cotProvDet);
		    writeCliente(ds);
	  }
	  
	    private IDataSet getDS() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TSugerirOC");
	    dataset.fieldDef(new Field("oid_cot_prov_det", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_cot_prov", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_req_det", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_cco_req", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
	    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fec_requerida", Field.DATE, 0));
	    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
	    dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
	    dataset.fieldDef(new Field("referencia", Field.STRING, 100));
	    
	    return dataset;
	  }

	  private void cargarRegistro(IDataSet dataset,
	                         CotizacionProveedorDet cotProvDet) throws BaseException {
	    dataset.append();
	    dataset.fieldValue("oid_cot_prov_det", cotProvDet.getOIDInteger());
	    dataset.fieldValue("oid_cot_prov", cotProvDet.getCotizacion_proveedor().getOIDInteger());
	    dataset.fieldValue("oid_req_det", "");
	    dataset.fieldValue("oid_cco_req", "");
	    dataset.fieldValue("oid_ped_det", "");
	    dataset.fieldValue("oid_cco_ped", "");    
	    dataset.fieldValue("oid_producto", cotProvDet.getProducto().getOIDInteger());
	    dataset.fieldValue("cod_producto", cotProvDet.getProducto().getCodigo());
	    dataset.fieldValue("desc_producto", cotProvDet.getProducto().getDescripcion());
	    dataset.fieldValue("cantidad", cotProvDet.getCant_presu());
	    if (cotProvDet.getUnidad_medida()!=null)
	    	dataset.fieldValue("oid_um", cotProvDet.getUnidad_medida().getOIDInteger());
	    else if (cotProvDet.getProducto().getUm_cpra()!=null)
	    	dataset.fieldValue("oid_um", cotProvDet.getProducto().getUm_cpra().getOIDInteger());
	    else
	    	dataset.fieldValue("oid_um", "");
	    dataset.fieldValue("fec_requerida", cotProvDet.getFec_ent());
	    
	    Proveedor proveedor = cotProvDet.getCotizacion_proveedor().getProveedor();
	    
	    if (proveedor!=null) {
	    	dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
	    	dataset.fieldValue("cod_proveedor", proveedor.getCodigo());
	    	dataset.fieldValue("rs_proveedor", proveedor.getRazonsocial());
	    } else {
	    	dataset.fieldValue("oid_proveedor", "");
	    	dataset.fieldValue("cod_proveedor", "");
	    	dataset.fieldValue("rs_proveedor", "");
	    }
	    dataset.fieldValue("referencia", cotProvDet.getCotizacion_proveedor().getCodigo()+"/"+cotProvDet.getNroItem());
	    	
	  }
	  
  
}
