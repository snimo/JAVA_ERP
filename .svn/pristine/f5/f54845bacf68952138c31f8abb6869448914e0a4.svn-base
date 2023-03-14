package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTableroTurnos extends Operation { 

  public SaveTableroTurnos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TParteTablero"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ParteTablero partetablero = ParteTablero.findByOid(dataset.getInteger("oid_parte_tablero"),getSesion());
        partetablero.setOID(dataset.getInteger("oid_parte_tablero"));
        partetablero.setDescripcion(dataset.getString("descripcion"));
        partetablero.setLunes(dataset.getBoolean("lunes"));
        partetablero.setMartes(dataset.getBoolean("martes"));
        partetablero.setMiercoles(dataset.getBoolean("miercoles"));
        partetablero.setJueves(dataset.getBoolean("jueves"));
        partetablero.setViernes(dataset.getBoolean("viernes"));
        partetablero.setSabado(dataset.getBoolean("sabado"));
        partetablero.setDomingo(dataset.getBoolean("domingo"));
        partetablero.setActivo(dataset.getBoolean("activo"));
        addTransaccion(partetablero);
        
        IDataSet dsTablero = dataset.getDataSet("Tablero");
        dsTablero.first();
        while (!dsTablero.EOF()) {
        	
        	
        	EntidadTurno entidadTurno = EntidadTurno.findByOidProxy(dsTablero.getInteger("oid_entidad"), this.getSesion());
        	EntidadParteTableroTurnos entidadParteTablero = partetablero.getEntidadParteTablero(entidadTurno, this.getSesion());
        	if (entidadParteTablero == null)
        		entidadParteTablero = (EntidadParteTableroTurnos) EntidadParteTableroTurnos.getNew(EntidadParteTableroTurnos.NICKNAME, this.getSesion());
        	entidadParteTablero.setEntidad_turno(entidadTurno);
        	entidadParteTablero.setParte_tablero(partetablero);
        	entidadParteTablero.setActivo(true);
        	entidadParteTablero.setOrden(dsTablero.getInteger("secu"));
        	partetablero.addEntidad(entidadParteTablero);
        	
        	dsTablero.next();
        }
        
        dataset.next();
    }
  }
  
}
