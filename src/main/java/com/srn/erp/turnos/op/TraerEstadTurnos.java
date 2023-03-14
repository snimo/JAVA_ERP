package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.ReservaTableroTurno;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadTurnos extends Operation { 

  public TraerEstadTurnos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  java.util.Date fechaDesde = mapaDatos.getDate("fecha_desde");
	  java.util.Date fechaHasta = mapaDatos.getDate("fecha_hasta");
	  String comportamiento = mapaDatos.getString("comportamiento"); 
	  
	  IDataSet ds = this.getDSEstadistica();
	  Iterator iterEstad = 
		  ReservaTableroTurno.getEstadisticas(fechaDesde, fechaHasta, comportamiento, this.getSesion()).iterator();
	  while (iterEstad.hasNext()) {
		  ReservaTableroTurno reserva = (ReservaTableroTurno) iterEstad.next();
		  cargarEstadistica(ds, 
				  reserva.getEntidad_tablero().getEntidad_turno().getCodigo(), 
				  reserva.getHorario_tablero().getHorario(), 
				  getPeriodo(reserva.getTablero().getFecha()), 
				  reserva.getTablero().getFecha(), 
				  Fecha.getNombreDiaSemana(reserva.getTablero().getFecha()), 
				  new Integer(1),
				  reserva.getDescMotivoTurno());
	  }
	  writeCliente(ds);
  }

  private IDataSet getDSEstadistica() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstadisticaTurnos");
    dataset.fieldDef(new Field("cod_entidad", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("horario", Field.STRING, 13));
    dataset.fieldDef(new Field("periodo", Field.STRING, 7));
    dataset.fieldDef(new Field("fecha", Field.STRING, 0));
    dataset.fieldDef(new Field("dia", Field.STRING, 20));
    dataset.fieldDef(new Field("turno", Field.INTEGER, 0));
    dataset.fieldDef(new Field("motivo", Field.STRING, 50));
    return dataset;
  }

  private void cargarEstadistica(IDataSet dataset, 
                         String codEntidad,
                         String horario,
                         String periodo,
                         java.util.Date fecha,
                         String dia,
                         Integer turno,
                         String motivo) throws BaseException {
    dataset.append();
    dataset.fieldValue("cod_entidad", codEntidad); 
    dataset.fieldValue("horario", horario);
    dataset.fieldValue("periodo", periodo);
    dataset.fieldValue("fecha", Fecha.getddmmyyyy(fecha));
    dataset.fieldValue("dia", dia);
    dataset.fieldValue("turno", turno);
    dataset.fieldValue("motivo", motivo);
  }
  
  private String getPeriodo(java.util.Date fecha) {
	int anio = Fecha.getAnio(fecha);
	int mes = Fecha.getMes(fecha);
	if (mes<=9) 
		return anio+".0"+mes;
	else
		return anio+"."+mes;
  }
  
}
