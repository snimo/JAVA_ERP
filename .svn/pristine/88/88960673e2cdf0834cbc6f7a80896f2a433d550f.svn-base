package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerOrdenFabricacion extends Operation { 

  public TraerOrdenFabricacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

	OrdenFabricacion ordenfabricacion = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       ordenfabricacion = OrdenFabricacion.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       ordenfabricacion = OrdenFabricacion.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetOrdenFabricacion = getDataSetOrdenFabricacion();
    IDataSet datasetAltFab = getDataSetAltFab();
    
    if (ordenfabricacion != null) {  
        cargarRegistroOrdenFabricacion(datasetOrdenFabricacion,ordenfabricacion);
        cargarRegistroAltFab(datasetAltFab, ordenfabricacion.getAlternativa_fabricacion());
    }
    
    writeCliente(datasetOrdenFabricacion);
    writeCliente(datasetAltFab);
    
  }

  private IDataSet getDataSetOrdenFabricacion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TOrdenFabricacion");
    dataset.fieldDef(new Field("oid_alter_fabri",Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha",Field.DATE, 0));
    dataset.fieldDef(new Field("oid_orden_fab", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tc", Field.STRING, 10));
    dataset.fieldDef(new Field("letra", Field.STRING, 5));
    dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("oid_um", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("oid_usu_aprob", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("fec_aprob", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("fec_ini_est", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("fec_fin_est", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("obs_ord_fab", Field.STRING, 5000)); 
    dataset.fieldDef(new Field("oid_planta", Field.STRING, 0)); 
    dataset.fieldDef(new Field("oid_alter_fabri", Field.STRING, 0)); 
    dataset.fieldDef(new Field("cant_producida", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("cerrada", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("pend_producir", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("estado_aprobacion", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("tipo_orden", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
    dataset.fieldDef(new Field("obs_ord_fab", Field.MEMO, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    
    return dataset;
  }

  private void cargarRegistroOrdenFabricacion(IDataSet dataset,
		  				 OrdenFabricacion orden) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_alter_fabri", orden.getAlternativa_fabricacion().getOIDInteger());
    dataset.fieldValue("fecha", orden.getEmision());
    dataset.fieldValue("oid_orden_fab", orden.getOIDInteger());
    dataset.fieldValue("oid_talonario", orden.getTalonario().getOIDInteger());
    dataset.fieldValue("oid_tc", orden.getTipoCompro().getOIDInteger());
    dataset.fieldValue("cod_tc", orden.getTipoCompro().getCodigo());
    dataset.fieldValue("letra", orden.getLetra());
    dataset.fieldValue("oid_lug_emi", orden.getLugarEmision().getOIDInteger());
    dataset.fieldValue("nro_lug_emi", orden.getNroLugEmision());
    dataset.fieldValue("nro_ext", orden.getNroExt());
    dataset.fieldValue("oid_producto", orden.getProducto().getOIDInteger());
    dataset.fieldValue("cantidad", orden.getCantidad());
    dataset.fieldValue("oid_um", orden.getUnidad_medida().getOIDInteger());
    dataset.fieldValue("oid_usu_aprob", orden.getUsuario_aprobacion().getOIDInteger());
    dataset.fieldValue("fec_aprob", orden.getFecha_aprobacion());
    dataset.fieldValue("fec_ini_est", orden.getFec_ini_est());
    dataset.fieldValue("fec_fin_est", orden.getFec_fin_est());
    dataset.fieldValue("obs_ord_fab", orden.getObs_ord_fab());
    dataset.fieldValue("oid_planta", orden.getPlanta().getOIDInteger());
    dataset.fieldValue("oid_alter_fabri", orden.getAlternativa_fabricacion().getOIDInteger());
    dataset.fieldValue("cant_producida", orden.getCant_producida());
    dataset.fieldValue("cerrada", orden.isCerrada());
    dataset.fieldValue("pend_producir", orden.isPend_producir());
    dataset.fieldValue("estado_aprobacion", orden.isEstado_aprobacion());
    dataset.fieldValue("tipo_orden", orden.getTipoOrden());
    dataset.fieldValue("oid_producto", orden.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", orden.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", orden.getProducto().getDescripcion());
    dataset.fieldValue("obs_ord_fab", orden.getObs_ord_fab());
    dataset.fieldValue("activo", orden.isActivo());
    
  }
  
  private IDataSet getDataSetAltFab() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TAltFabProd");
	    dataset.fieldDef(new Field("oid_alter_fabri",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_rec_cab",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("alternativa",Field.STRING, 100));
	    return dataset;
  }
  
  private void cargarRegistroAltFab(
		  	 IDataSet dataset,
			 AlternativaFabricacion alternativa) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_alter_fabri", alternativa.getOIDInteger());
	  dataset.fieldValue("oid_rec_cab", alternativa.getReceta().getOIDInteger());
	  dataset.fieldValue("alternativa", alternativa.getAlternativa());
  }
  
  
  
}
