package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.ReservaTableroTurno;
import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerImpresionTurno extends Operation { 

  public TraerImpresionTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	TableroTurnos 	tablero =  TableroTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero"), this.getSesion());
	TableroEntidadTurnos tableroEntidadTurnos =  TableroEntidadTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_entidad"), this.getSesion());
	TableroHorarioTurnos tableroHorario = TableroHorarioTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_horario"), this.getSesion());
	
	ReservaTableroTurno reserva = tablero.getReserva(tableroEntidadTurnos, tableroHorario);
	
	if (reserva == null)
		throw new ExceptionValidation(null,"No existe reserva");
	
	IDataSet ds = this.getDSImpresionTurno();
	cargarRegistro(ds, reserva);
	writeCliente(ds);
	
	
  }

  private IDataSet getDSImpresionTurno() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TImpresionTurno");
    dataset.fieldDef(new Field("titulo", Field.STRING, 100));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("tablero_de", Field.STRING, 100));
    dataset.fieldDef(new Field("entidad", Field.STRING, 100));
    dataset.fieldDef(new Field("horario", Field.STRING, 100));
    dataset.fieldDef(new Field("contenido", Field.MEMO, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
		  				 ReservaTableroTurno reserva	
                         ) throws BaseException {
    dataset.append();
    dataset.fieldValue("titulo", ValorParametro.findByCodigoParametro("TITU_IMPRESION_TURNO", this.getSesion()).getValorCadena());
    dataset.fieldValue("fecha", reserva.getTablero().getFecha());
    dataset.fieldValue("tablero_de", reserva.getTablero().getDescripcion());
    dataset.fieldValue("entidad", reserva.getEntidad_tablero().getEntidad_turno().getCodigo());
    dataset.fieldValue("horario", reserva.getHorario_tablero().getHorario());
    dataset.fieldValue("contenido", reserva.getPresentacion());
    
    
  }
}
