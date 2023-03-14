package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTurnosLibresActivosTablero extends Operation { 

  public TraerTurnosLibresActivosTablero() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	IDataSet ds = this.getDataSet();
	TableroTurnos tablero = TableroTurnos.findByOid(mapaDatos.getInteger("oid_tablero"), this.getSesion());
	Iterator iterEntidades = tablero.getEntidades().iterator();
	while (iterEntidades.hasNext()) {
		TableroEntidadTurnos tableroEntidad = (TableroEntidadTurnos) iterEntidades.next();
		cargarRegistro(ds, tablero, tableroEntidad);
	}
	writeCliente(ds);
	  
  }

  private IDataSet getDataSet() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTurnosLibres");
    dataset.fieldDef(new Field("oid_tablero", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tablero_entidad", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_entidad", Field.STRING, 20));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    for (int i=1;i<=100;++i)
    	dataset.fieldDef(new Field("horario_"+i, Field.STRING, 13));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         TableroTurnos tablero,
                         TableroEntidadTurnos tableroEntidad) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tablero", tablero.getOIDInteger());
    dataset.fieldValue("oid_tablero_entidad", tableroEntidad.getOIDInteger());
    dataset.fieldValue("desc_entidad", tableroEntidad.getEntidad_turno().getCodigo());
    dataset.fieldValue("orden", tableroEntidad.getSecu());
        
    int i=1;
    Iterator iterHorarios = tablero.getHorariosLibresActivos(tableroEntidad).iterator();
    while (iterHorarios.hasNext()) {
    	TableroHorarioTurnos tableroHorario = (TableroHorarioTurnos) iterHorarios.next();
    	dataset.fieldValue("horario_"+i,tableroHorario.getHorario());
    	++i;
    }
    for (int j=i;j<=100;++j) 
    	dataset.fieldValue("horario_"+j,"");
    
  }
  
}
