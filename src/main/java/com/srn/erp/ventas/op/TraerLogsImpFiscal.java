package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.LogImpresoraFiscal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLogsImpFiscal extends Operation {

  public TraerLogsImpFiscal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    
  	if (!(mapaDatos.containsKey("fec_desde")))
  			throw new ExceptionValidation(null,"Debe ingresar la fecha desde");
  			
  	if (!(mapaDatos.containsKey("fec_hasta")))
			throw new ExceptionValidation(null,"Debe ingresar la fecha hasta");
  	
  	Iterator iterLogs =
  	LogImpresoraFiscal.getLogsByFecha(
  		mapaDatos.getDate("fec_desde"),
  		mapaDatos.getDate("fec_hasta"),
  		this.getSesion()).iterator();
  	
  	IDataSet ds = this.getDataSet();
  	
  	while (iterLogs.hasNext()) {
  		LogImpresoraFiscal log = (LogImpresoraFiscal) iterLogs.next();
  		cargarRegistro(ds,log);
  	}
  	
  	writeCliente(ds);
  	
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TLogsImpFiscal");
    dataset.fieldDef(new Field("oid_log_imp_fiscal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_impresion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("hora", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("linea", Field.STRING, 0));
    dataset.fieldDef(new Field("nro_error", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         LogImpresoraFiscal log) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_log_imp_fiscal", log.getOIDInteger());
    dataset.fieldValue("oid_cco", log.getOid_cco());
    dataset.fieldValue("nro_impresion", log.getNro_impresion());
    dataset.fieldValue("fecha", log.getFecha());
    dataset.fieldValue("hora", log.getHora());
    dataset.fieldValue("oid_usuario", log.getOid_usuario());
    dataset.fieldValue("linea", log.getLinea());
    dataset.fieldValue("nro_error", log.getNro_error());
    dataset.fieldValue("oid_sucursal", log.getOid_sucursal());
  }
}
