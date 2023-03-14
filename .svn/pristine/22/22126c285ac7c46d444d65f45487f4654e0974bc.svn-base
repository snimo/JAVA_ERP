package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.LogImpSujTurno;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TrartLogImpSujTurnos extends Operation { 

  public TrartLogImpSujTurnos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet ds = this.getDataSetLogImpSujTur();
    
    Iterator iterLogs = null;
    
    if (mapaDatos.containsKey("fecha"))
    	iterLogs = LogImpSujTurno.getLogs(mapaDatos.getDate("fecha"), this.getSesion()).iterator();
    else
    	iterLogs = LogImpSujTurno.getLogsUltimaCorrida(this.getSesion()).iterator();
    while (iterLogs.hasNext()) {
    	LogImpSujTurno log = (LogImpSujTurno) iterLogs.next();
    	cargarRegistro(ds, log.getOIDInteger(), log.getFecha(), log.getDescripcion());
    }
    
    writeCliente(ds);
  }

  private void cargarRegistro(IDataSet dataset, 
                         Integer oid,
                         java.util.Date fecha,
                         String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("fecha", fecha);
    dataset.fieldValue("descripcion", descripcion);
  }
  
  private IDataSet getDataSetLogImpSujTur() {
	IDataSet dataset = new TDataSet();
	dataset.create("TLogsImportacion");
	dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
	dataset.fieldDef(new Field("fecha", Field.DATE, 0));
	dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
	return dataset;
  }
  
}
