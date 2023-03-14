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

public class TraerEstadSujTurnos extends Operation { 

  public TraerEstadSujTurnos() { 
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
		  
		  if (reserva.getSujeto1()!=null)
		  cargarEstadistica(ds, 
				  reserva.getEntidad_tablero().getEntidad_turno().getCodigo(), 
				  reserva.getHorario_tablero().getHorario(), 
				  getPeriodo(reserva.getTablero().getFecha()), 
				  reserva.getTablero().getFecha(), 
				  Fecha.getNombreDiaSemana(reserva.getTablero().getFecha()),
				  new Integer(1),
				  reserva.getSujeto1().getRazon_social(),
				  reserva.getSujeto1().getCodigo(),
				  reserva.getSujeto1().getCategoriaSujetoTurno().getDescripcion()
				  );
		  
		  
		  if (reserva.getSujeto2()!=null)
			  cargarEstadistica(ds, 
					  reserva.getEntidad_tablero().getEntidad_turno().getCodigo(), 
					  reserva.getHorario_tablero().getHorario(), 
					  getPeriodo(reserva.getTablero().getFecha()), 
					  reserva.getTablero().getFecha(), 
					  Fecha.getNombreDiaSemana(reserva.getTablero().getFecha()),
					  new Integer(1),
					  reserva.getSujeto2().getRazon_social(),
					  reserva.getSujeto2().getCodigo(),
					  reserva.getSujeto2().getCategoriaSujetoTurno().getDescripcion());		  
		  
		  if (reserva.getSujeto3()!=null)
			  cargarEstadistica(ds, 
					  reserva.getEntidad_tablero().getEntidad_turno().getCodigo(), 
					  reserva.getHorario_tablero().getHorario(), 
					  getPeriodo(reserva.getTablero().getFecha()), 
					  reserva.getTablero().getFecha(), 
					  Fecha.getNombreDiaSemana(reserva.getTablero().getFecha()),
					  new Integer(1),
					  reserva.getSujeto3().getRazon_social(),
					  reserva.getSujeto3().getCodigo(),
					  reserva.getSujeto3().getCategoriaSujetoTurno().getDescripcion());		  
		  
		  if (reserva.getSujeto4()!=null)
			  cargarEstadistica(ds, 
					  reserva.getEntidad_tablero().getEntidad_turno().getCodigo(), 
					  reserva.getHorario_tablero().getHorario(), 
					  getPeriodo(reserva.getTablero().getFecha()), 
					  reserva.getTablero().getFecha(), 
					  Fecha.getNombreDiaSemana(reserva.getTablero().getFecha()),
					  new Integer(1),
					  reserva.getSujeto4().getRazon_social(),
					  reserva.getSujeto4().getCodigo(),
					  reserva.getSujeto4().getCategoriaSujetoTurno().getDescripcion());		  
		  
		  if (reserva.getMotivo()!=null)
			  cargarEstadistica(ds, 
					  reserva.getEntidad_tablero().getEntidad_turno().getCodigo(), 
					  reserva.getHorario_tablero().getHorario(), 
					  getPeriodo(reserva.getTablero().getFecha()), 
					  reserva.getTablero().getFecha(), 
					  Fecha.getNombreDiaSemana(reserva.getTablero().getFecha()),
					  new Integer(1),
					  reserva.getMotivo().getDescripcion(),
					  reserva.getMotivo().getCodigo(),
					  "Motivos");		  
		  
	  }
	  writeCliente(ds);
  }

  private IDataSet getDSEstadistica() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstadisticaTurnosSujetos");
    dataset.fieldDef(new Field("cod_entidad", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("horario", Field.STRING, 13));
    dataset.fieldDef(new Field("periodo", Field.STRING, 7));
    dataset.fieldDef(new Field("fecha", Field.STRING, 0));
    dataset.fieldDef(new Field("dia", Field.STRING, 20));
    dataset.fieldDef(new Field("turno", Field.INTEGER, 0));
    dataset.fieldDef(new Field("sujeto", Field.STRING, 50));
    dataset.fieldDef(new Field("nro", Field.STRING, 20));
    dataset.fieldDef(new Field("categoria", Field.STRING, 50));
    
    return dataset;
  }

  private void cargarEstadistica(IDataSet dataset, 
                         String codEntidad,
                         String horario,
                         String periodo,
                         java.util.Date fecha,
                         String dia,
                         Integer turno,
                         String sujeto,
                         String nro,
                         String categoria) throws BaseException {
    dataset.append();
    dataset.fieldValue("cod_entidad", codEntidad); 
    dataset.fieldValue("horario", horario);
    dataset.fieldValue("periodo", periodo);
    dataset.fieldValue("fecha", Fecha.getddmmyyyy(fecha));
    dataset.fieldValue("dia", dia);
    dataset.fieldValue("turno", turno);
    dataset.fieldValue("sujeto", sujeto);
    dataset.fieldValue("nro", nro);
    dataset.fieldValue("categoria", categoria);
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
