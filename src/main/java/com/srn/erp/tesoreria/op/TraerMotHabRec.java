package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.general.bm.MotivoTC;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotHabRec extends Operation {

  public TraerMotHabRec() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	String tipoOper = mapaDatos.getString("tipo_oper");
  	if (tipoOper.equals("INGVAR")) 
  		traerMotHabIngVar();
  	else if (tipoOper.equals("COBCLIE"))
  					traerMotHabCobCli();
  }
  
  private void traerMotHabIngVar() throws BaseException {
  	IDataSet ds = getDataSetMotHab();
  	
  	Iterator iterMotivoTC = MotivoTC.getMotivosRecibos(this.getSesion()).iterator();
  	while (iterMotivoTC.hasNext()) {
  		MotivoTC motivoTC = (MotivoTC) iterMotivoTC.next();
  		if (motivoTC.isHabilitadoIngVar())
  			cargarRegistro(ds,motivoTC);
  	}
  	
  	
  	writeCliente(ds);
  }
  
  private void traerMotHabCobCli() throws BaseException {
  	IDataSet ds = getDataSetMotHab();
  	
  	Iterator iterMotivoTC = MotivoTC.getMotivosRecibos(this.getSesion()).iterator();
  	while (iterMotivoTC.hasNext()) {
  		MotivoTC motivoTC = (MotivoTC) iterMotivoTC.next();
  		if (motivoTC.isHabilitadoCobCli())
  			cargarRegistro(ds,motivoTC);
  	}
  	
  	writeCliente(ds);
  }
  
  
  private IDataSet getDataSetMotHab() {
    IDataSet dataset = new TDataSet();
    dataset.create("TMotivoTC");
    dataset.fieldDef(new Field("oid_motivo_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_motivo_compro", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_motivo_compro", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_motivo_compro", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  
  private void cargarRegistro(IDataSet ds,MotivoTC motivoTC) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid_motivo_tc", motivoTC.getOIDInteger());
  	ds.fieldValue("oid_motivo_compro", motivoTC.getMotivo_comprobante().getOIDInteger());
  	ds.fieldValue("cod_motivo_compro", motivoTC.getMotivo_comprobante().getCodigo());
  	ds.fieldValue("desc_motivo_compro", motivoTC.getMotivo_comprobante().getDescripcion());
  	ds.fieldValue("oid_tc", motivoTC.getTipo_comprobate().getOIDInteger());
  	ds.fieldValue("activo", motivoTC.isActivo());
  	
  }
  


}
