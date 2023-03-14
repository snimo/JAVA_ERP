package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.ComproAjusteStk;
import com.srn.erp.stock.bm.ComproAjusteStkDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComprobanteAjusteStk extends Operation {

  public TraerComprobanteAjusteStk() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	
  	int secu = 0;
  	Integer oid = mapaDatos.getInteger("oid");
  	ComproAjusteStk comproAjuStk =
  		ComproAjusteStk.findByOid(oid,this.getSesion());
  	
  	IDataSet dsCab = getDSComproCab();
  	IDataSet dsDet = getDSComproDet();
  	IDataSet dsCompoStk = getDSCompoStk();
  	IDataSet dsTal = getDSTalonario();
  	
  	cargarCompoStk(dsCompoStk,comproAjuStk);
  	cargarRegCab(dsCab,comproAjuStk);
  	cargarTalonario(dsTal,comproAjuStk);
  	
  	Iterator iterDet = comproAjuStk.getDetalles().iterator();
  	while (iterDet.hasNext()) {
  		ComproAjusteStkDet comproAjuDet = (ComproAjusteStkDet) iterDet.next();
  		++secu;
  		cargarRegCabDet(dsDet,comproAjuDet, new Integer(secu));
  	}
  	
  	
  	writeCliente(dsCompoStk);
  	writeCliente(dsCab);
  	writeCliente(dsDet);
  	writeCliente(dsTal);
  	
  }
  
  
  private void cargarTalonario(IDataSet ds,ComproAjusteStk comproCab) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid_talonario",comproCab.getTalonario().getOIDInteger());
  	ds.fieldValue("codigo",comproCab.getTalonario().getCodigo());
  	ds.fieldValue("descripcion",comproCab.getTalonario().getDescripcion());
  }
  
  private void cargarRegCab(IDataSet ds,ComproAjusteStk comproCab) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid_aju_stk_cab", comproCab.getOIDInteger());
  	ds.fieldValue("oid_talonario", comproCab.getTalonario().getOIDInteger());
  	ds.fieldValue("oid_tc", comproCab.getTipoCompro().getOIDInteger());
  	ds.fieldValue("cod_tc", comproCab.getTipoCompro().getCodigo());
  	ds.fieldValue("letra", comproCab.getLetra());
  	ds.fieldValue("oid_lug_emi", comproCab.getLugarEmision().getLugemi());
  	ds.fieldValue("lug_emi", comproCab.getNroLugEmision());
  	ds.fieldValue("nro_ext", comproCab.getNroExt());
  	ds.fieldValue("fec_emision", comproCab.getEmision());
  	ds.fieldValue("tipo_aju_stk", comproCab.getTipo_aju_stk());
  	ds.fieldValue("observacion", comproCab.getComentario());
  	ds.fieldValue("oid_compo_stk_aju",comproCab.getCompoStkTalonarioAjuStk().getOIDInteger());
  	ds.fieldValue("oid_tipo_conf_mov",comproCab.getTipo_conf_mov().getOIDInteger());
  	ds.fieldValue("activo", comproCab.isActivo());
  }
  
  private void cargarCompoStk(IDataSet ds,ComproAjusteStk comproCab) throws BaseException {
  	
  	if (comproCab.getTipo_conf_mov() == null) return;
  	
  	ds.append();
  	ds.fieldValue("oid_compo_stk_aju", new Integer(0));
  	ds.fieldValue("oid_oper_aju_stk", new Integer(0));
  	ds.fieldValue("oid_tipo_conf_mov", comproCab.getTipo_conf_mov().getOIDInteger());
  	ds.fieldValue("cod_tipo_conf_mov", comproCab.getTipo_conf_mov().getCodigo());
  	ds.fieldValue("desc_tipo_conf_mov",comproCab.getTipo_conf_mov().getDescripcion());
  	ds.fieldValue("habilitado", new Boolean(true));
  	ds.fieldValue("usar_por_defecto", new Boolean(true));
  }
  

  private IDataSet getDSComproCab() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComproAjuStkCab");
    dataset.fieldDef(new Field("oid_aju_stk_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tc",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tc",Field.STRING, 10));
    dataset.fieldDef(new Field("letra",Field.STRING, 5));
    dataset.fieldDef(new Field("oid_lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision",Field.DATE, 0));
    dataset.fieldDef(new Field("tipo_aju_stk", Field.STRING, 50));
    dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
    dataset.fieldDef(new Field("oid_compo_stk_aju",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_conf_mov",Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    return dataset;
  }
  
  private void cargarRegCabDet(IDataSet ds,
  		                         ComproAjusteStkDet comproDet,
  		                         Integer nroItem) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid_aju_stk_det", comproDet.getOIDInteger());
  	ds.fieldValue("oid_aju_stk_cab", comproDet.getAjuste_stock_cab().getOIDInteger());
  	ds.fieldValue("oid_producto", comproDet.getProducto().getOIDInteger());
  	ds.fieldValue("cod_producto", comproDet.getProducto().getCodigo());
  	ds.fieldValue("desc_producto", comproDet.getProducto().getDescripcion());
  	ds.fieldValue("cantidad", comproDet.getCantidad());
  	ds.fieldValue("oid_um_carga", comproDet.getUm_carga().getOIDInteger());
  	ds.fieldValue("activo", comproDet.isActivo());
  	ds.fieldValue("observaciones", comproDet.getObservaciones());
  	ds.fieldValue("cod_mov_stock", "");
  	if (comproDet.getCompo_stk_aju()!=null)
  		ds.fieldValue("oid_compo_stk_aju", comproDet.getCompo_stk_aju().getOIDInteger());
  	else
  		ds.fieldValue("oid_compo_stk_aju", new Integer(0));
  	if (comproDet.getTipo_conf_mov()!=null)
  		ds.fieldValue("oid_tipo_conf_mov", comproDet.getTipo_conf_mov().getOIDInteger());
  	else
  		ds.fieldValue("oid_tipo_conf_mov", new Integer(0));
  	ds.fieldValue("item", nroItem);
  }
  
  
  private IDataSet getDSComproDet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComproAjuStkDet");
    dataset.fieldDef(new Field("oid_aju_stk_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_aju_stk_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_um_carga", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("observaciones", Field.MEMO, 0));
    dataset.fieldDef(new Field("cod_mov_stock", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_compo_stk_aju", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
     dataset.fieldDef(new Field("item", Field.INTEGER, 0));
    return dataset;
  }
  
  private IDataSet getDSCompoStk() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComportamientosStock");
    dataset.fieldDef(new Field("oid_compo_stk_aju", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_oper_aju_stk",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_conf_mov",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_conf_mov",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_tipo_conf_mov",Field.STRING, 100));
    dataset.fieldDef(new Field("habilitado",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_por_defecto",Field.BOOLEAN, 0));
    return dataset;
  }
  
  private IDataSet getDSTalonario() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTalonario");
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo",Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion",Field.STRING, 100));
    return dataset;
  }
  
  
  
  
  
}
