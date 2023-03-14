package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.AsientoManual;
import com.srn.erp.contabilidad.bm.AsientoManualDet;
import com.srn.erp.general.bm.Talonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAsientoManual extends Operation {

  public TraerAsientoManual() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

  	Integer oid = mapaDatos.getInteger("oid");
    AsientoManual asiento = asiento = AsientoManual.findByOid(oid, getSesion());
    
    IDataSet dsTal = this.getDataSetTalonario();
    IDataSet dsCab = this.getDataSetCab();
    IDataSet dsDet = this.getDataSetDet();
    
    cargarRegistroTal(dsTal,asiento.getTalonario());
    cargarRegistroCab(dsCab,asiento);
    Iterator iterAsientosDet = asiento.getDetalles().iterator();
    while (iterAsientosDet.hasNext()) {
    	AsientoManualDet asiDet = (AsientoManualDet) iterAsientosDet.next();
    	cargarRegistroDet(dsDet,asiDet);
    }
    
    writeCliente(dsTal);
    writeCliente(dsCab);
    writeCliente(dsDet);
  }
  
  private void cargarRegistroCab(IDataSet dsCab, AsientoManual asiento) throws BaseException {
  	dsCab.append();
  	dsCab.fieldValue("oid", asiento.getOIDInteger());
  	dsCab.fieldValue("comprobante", asiento.getCodigo());
  	dsCab.fieldValue("oid_tc", asiento.getTipoCompro().getOIDInteger());
  	dsCab.fieldValue("cod_tc", asiento.getTipoCompro().getCodigo());
  	dsCab.fieldValue("tc_ext", asiento.getTcExt());
  	dsCab.fieldValue("desc_tc", asiento.getTipoCompro().getDescripcion());
  	dsCab.fieldValue("letra", asiento.getLetra());
  	dsCab.fieldValue("oid_lug_emi", asiento.getLugarEmision().getOIDInteger());
  	dsCab.fieldValue("lug_emi", asiento.getLugarEmision().getLugemi());
  	dsCab.fieldValue("nro_ext", asiento.getNroExt());
  	dsCab.fieldValue("fec_emision", asiento.getEmision());
  	dsCab.fieldValue("fec_imputacion", asiento.getImputac());
  	dsCab.fieldValue("oid_moneda", asiento.getMoneda().getOIDInteger());
  	dsCab.fieldValue("comentario", asiento.getComentario());
  	dsCab.fieldValue("no_convertir", asiento.getNoContaOtrasMonedas());
  	dsCab.fieldValue("oid_talonario", asiento.getTalonario().getOIDInteger());
  	dsCab.fieldValue("cotizacion", asiento.getCotizacion());
  	dsCab.fieldValue("activo", asiento.isActivo());
  	
  	
  }
  
  private IDataSet getDataSetTalonario() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TTalonarios");
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.INTEGER, 0));
    return dataset;
  }
  
  private void cargarRegistroTal(IDataSet ds,Talonario talonario) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid_talonario", talonario.getOIDInteger());
  	ds.fieldValue("codigo", talonario.getCodigo());
  	ds.fieldValue("descripcion", talonario.getDescripcion());
  }

  private IDataSet getDataSetCab() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAsientoCab");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tc", Field.STRING, 50));
    dataset.fieldDef(new Field("tc_ext", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_tc", Field.STRING, 100));
    dataset.fieldDef(new Field("letra", Field.STRING, 5));
    dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_imputacion", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_moneda", Field.DATE, 0));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    dataset.fieldDef(new Field("no_convertir", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  
  private IDataSet getDataSetDet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAsientoDet");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ana_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_ana_imp", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ana_imp", Field.STRING, 255));
    dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    return dataset;
  }
  
  private void cargarRegistroDet(IDataSet dsDet, AsientoManualDet asientoDet) throws BaseException {
  	dsDet.append();
  	dsDet.fieldValue("oid", asientoDet.getOIDInteger());
  	dsDet.fieldValue("secu",asientoDet.getSecu());
  	dsDet.fieldValue("oid_ana_imp", asientoDet.getCuentaImputable().getOIDInteger());
  	dsDet.fieldValue("codigo_ana_imp", asientoDet.getCuentaImputable().getCodigoCuentaMasCodigosValCompo());
  	dsDet.fieldValue("desc_ana_imp", asientoDet.getCuentaImputable().getDescCuentaMasDescValCompo());
  	if (asientoDet.getSigno().intValue()==1) {
  		dsDet.fieldValue("debe", asientoDet.getImporte()); 
  	  dsDet.fieldValue("haber", "");
  	} else {
  		dsDet.fieldValue("debe", ""); 
  	  dsDet.fieldValue("haber", asientoDet.getImporte());
  	}
  	dsDet.fieldValue("comentario", asientoDet.getComentario());
  }
  
  

}
