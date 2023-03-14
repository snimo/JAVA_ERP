package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.EstadoDeposito;
import com.srn.erp.stock.bm.InventarioCab;
import com.srn.erp.stock.bm.InventarioDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInventario extends Operation {

  public TraerInventario() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
    InventarioCab inventario = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       inventario = InventarioCab.findByOid(oid, getSesion());
    }

    IDataSet datasetInvCab = getDataSetInvCab();
    IDataSet datasetInvDet = getDataSetInvDet();
    
    
    
    if (inventario != null) {
    	
    	cargarRegistroInvCab(datasetInvCab,inventario);
    	
    	Iterator iterDetalles = 
    		inventario.getDetalles().iterator();
    	while (iterDetalles.hasNext()) {
    		InventarioDet invDet = (InventarioDet) iterDetalles.next();
    		cargarRegistroInvDet(datasetInvDet, invDet);
    	}
    	
    }
    writeCliente(datasetInvCab);
    writeCliente(datasetInvDet);
  }

  private IDataSet getDataSetDeposito() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDeposito");
    dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("compo_depo", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroEstadoDeposito(IDataSet dataset,
                                            EstadoDeposito estadoDeposito) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_estado_depo", estadoDeposito.getOIDInteger());
    dataset.fieldValue("oid_deposito", estadoDeposito.getDeposito().getOIDInteger());
    dataset.fieldValue("oid_estado_stock", estadoDeposito.getEstado_stock().getOIDInteger());
    dataset.fieldValue("allow_saldo_neg", estadoDeposito.isAllow_saldo_neg());
    dataset.fieldValue("oid_agrup_estado", estadoDeposito.getAgrupadorEstadoStock().getOIDInteger());
    dataset.fieldValue("activo",new Boolean(true));
  }


  private IDataSet getDataSetInvCab() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTomaInventario");
    dataset.fieldDef(new Field("oid_inventario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha_inventario", Field.DATE, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
    return dataset;
  }
  
  private IDataSet getDataSetInvDet() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TDetInventario");
	    dataset.fieldDef(new Field("oid_det_inventario", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_inventario", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
	    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_um", Field.STRING, 50));
	    dataset.fieldDef(new Field("fisico", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("sin_stock", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("conteo", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("diferencia", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
	    return dataset;
	  }
  


  private void cargarRegistroInvCab(IDataSet dataset,
                         InventarioCab inventarioCab) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_inventario", inventarioCab.getOIDInteger());
    dataset.fieldValue("oid_deposito", inventarioCab.getDeposito().getOIDInteger());
    dataset.fieldValue("fecha_inventario", inventarioCab.getFec_inventario());
    dataset.fieldValue("activo", inventarioCab.isActivo());
    dataset.fieldValue("observacion", inventarioCab.getComentario());
  }
  
  private void cargarRegistroInvDet(IDataSet dataset,
          InventarioDet inventarioDet) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_det_inventario", inventarioDet.getOIDInteger());
	  dataset.fieldValue("oid_inventario", inventarioDet.getInventario_cab().getOIDInteger());
	  dataset.fieldValue("oid_producto", inventarioDet.getProducto().getOIDInteger());
	  dataset.fieldValue("cod_producto", inventarioDet.getProducto().getCodigo());
	  dataset.fieldValue("desc_producto", inventarioDet.getProducto().getDescripcion());
	  if (inventarioDet.getProducto().getUm_stk()!=null) {
	    dataset.fieldValue("oid_um", inventarioDet.getProducto().getUm_stk().getOIDInteger());
	    dataset.fieldValue("cod_um", inventarioDet.getProducto().getUm_stk().getCodigo());
	  } else {
		    dataset.fieldValue("oid_um", new Integer(0));
		    dataset.fieldValue("cod_um", "");
	  }
	  dataset.fieldValue("fisico", inventarioDet.getFisico());
	  dataset.fieldValue("sin_stock", inventarioDet.isSin_stock());
	  dataset.fieldValue("conteo", inventarioDet.getConteo());
	  dataset.fieldValue("diferencia", inventarioDet.getAju_stock());
	  dataset.fieldValue("observacion", inventarioDet.getObservacion());
  }
  


}
