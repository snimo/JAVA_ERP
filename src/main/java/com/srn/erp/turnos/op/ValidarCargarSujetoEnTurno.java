package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class ValidarCargarSujetoEnTurno extends Operation { 

  public ValidarCargarSujetoEnTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	TableroTurnos 	tablero =  TableroTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero"), this.getSesion());
	TableroEntidadTurnos tableroEntidadTurnos =  TableroEntidadTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_entidad"), this.getSesion());
	TableroHorarioTurnos tableroEntidadHorario =  TableroHorarioTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_horario"), this.getSesion());
	String sujeto = (String) mapaDatos.getString("sujeto");
	
	if (sujeto.trim().equals("")) return;
	
	StringBuffer detalleErrores = new StringBuffer("");
	
	tablero.validarPonerTurno(sujeto,tableroEntidadTurnos,tableroEntidadHorario,false,detalleErrores);
	
	if (detalleErrores.length()>0)
		throw new ExceptionValidation(null,detalleErrores.toString());
	
  }
	
}
