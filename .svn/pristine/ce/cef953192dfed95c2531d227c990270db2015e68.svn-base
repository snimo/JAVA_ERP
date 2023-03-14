package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRtoIntDepoPendRecep extends Operation {

  public TraerRtoIntDepoPendRecep() {
  }
  
  private int secu= -1000000;

  public void execute(MapDatos mapaDatos) throws BaseException {

	Integer oidCCOCab = mapaDatos.getInteger("oid_cco");  
    IDataSet ds = getDataSetRtoPendRecep();
    
    RemitoCab remito = RemitoCab.findByOid(mapaDatos.getInteger("oid_cco_rto"), this.getSesion());
    
    Iterator iterDetRtosPendRecep =
    	remito.getDetallesPendRecep().iterator();
    while (iterDetRtosPendRecep.hasNext()) {
    	RemitoDet remitoDet = (RemitoDet) iterDetRtosPendRecep.next();
    	cargarRegistroRtoPendRecep(ds, oidCCOCab, remitoDet);
    }
    
    writeCliente(ds);
  }

  private IDataSet getDataSetRtoPendRecep() {
    IDataSet dataset = new TDataSet();
    dataset.create("TInformeRecepcionDet");
    dataset.fieldDef(new Field("oid_inf_rec_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_inf_rec", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("desc_adic_producto", Field.MEMO, 0));
    dataset.fieldDef(new Field("oid_um_stk", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cant_recep_us", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_um_cpra", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cant_recep_uc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("ref_oc", Field.STRING, 100));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    dataset.fieldDef(new Field("oid_remito_det", Field.INTEGER, 0));
    return dataset;
  }


  private void cargarRegistroRtoPendRecep(IDataSet dataset,
		  				 Integer oidCab,
                         RemitoDet remitoDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_inf_rec_det", --secu);
    dataset.fieldValue("oid_inf_rec", oidCab);
    dataset.fieldValue("oid_producto", remitoDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", remitoDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", remitoDet.getProducto().getDescripcion());
    dataset.fieldValue("desc_adic_producto", remitoDet.getComentario());
    dataset.fieldValue("oid_um_stk", remitoDet.getUnidad_desp().getOIDInteger());
    dataset.fieldValue("cant_recep_us", remitoDet.getCantPendRecep());
    dataset.fieldValue("oid_um_cpra", remitoDet.getUnidad_desp().getOIDInteger());
    dataset.fieldValue("cant_recep_uc", remitoDet.getCantPendRecep());
    dataset.fieldValue("activo", remitoDet.isActivo());
    dataset.fieldValue("ref_oc", remitoDet.getCodigo());
    dataset.fieldValue("comentario", remitoDet.getComentario());
    dataset.fieldValue("oid_remito_det", remitoDet.getOIDInteger());
    
  }


}
