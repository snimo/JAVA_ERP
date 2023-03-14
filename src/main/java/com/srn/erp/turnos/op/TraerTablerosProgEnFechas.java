package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.EstrucTableroTurnosCab;
import com.srn.erp.turnos.bm.TableroTurnos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTablerosProgEnFechas extends Operation { 

  public TraerTablerosProgEnFechas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
	java.util.Date fechaDesde = mapaDatos.getDate("fecha_desde");  
	java.util.Date fechaHasta = mapaDatos.getDate("fecha_hasta");
	
	EstrucTableroTurnosCab estrucTablero = EstrucTableroTurnosCab.findByOid(mapaDatos.getInteger("oid_estruc_tablero"), this.getSesion()); 
	String comportamiento = estrucTablero.getComportamiento();
	
	IDataSet ds = this.getDataSetTableros();
	
	Iterator iterTableros = TableroTurnos.getTableros(fechaDesde, fechaHasta, comportamiento, this.getSesion()).iterator();
	while (iterTableros.hasNext()) {
		TableroTurnos tableroTurnos = (TableroTurnos) iterTableros.next();
		cargarRegistro(ds,tableroTurnos);
	}
	
	writeCliente(ds);
    
  }

  private IDataSet getDataSetTableros() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTablerosProgramados");
    dataset.fieldDef(new Field("oid_tablero_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20));
    return dataset;
  }
  

  private void cargarRegistro(IDataSet dataset,TableroTurnos tablero 
                         ) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tablero_cab", tablero.getOIDInteger());
    dataset.fieldValue("descripcion", tablero.getDescripcion());
    dataset.fieldValue("fecha", tablero.getFecha());
    dataset.fieldValue("comportamiento", tablero.getComportamiento());
    
  }
}
