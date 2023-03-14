package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveEstrucTableroTurnosCab extends Operation { 

  public SaveEstrucTableroTurnosCab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEstrucTableroTurnosCab"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EstrucTableroTurnosCab estructableroturnoscab = EstrucTableroTurnosCab.findByOid(dataset.getInteger("oid_estruc_tab_tur"),getSesion());
        estructableroturnoscab.setDescripcion(dataset.getString("descripcion"));
        estructableroturnoscab.setActivo(dataset.getBoolean("activo"));
        estructableroturnoscab.setComportamiento(dataset.getString("comportamiento"));
        
        IDataSet dsDet = dataset.getDataSet("TEstrucTableroTurnosDet");
        dsDet.first();
        while (!dsDet.EOF()) {
        	EstrucTableroTurnosDet estrucTableroTurnoDet = EstrucTableroTurnosDet.findByOid(dsDet.getInteger("oid_estruc_det"), this.getSesion());
        	estrucTableroTurnoDet.setEstruc_tab_cab(estructableroturnoscab);
        	estrucTableroTurnoDet.setParte_tablero(ParteTablero.findByOidProxy(dsDet.getInteger("oid_parte_tablero"), this.getSesion()));
        	estrucTableroTurnoDet.setSecu(dsDet.getInteger("secu"));
        	estrucTableroTurnoDet.setActivo(dsDet.getBoolean("activo"));
        	if (!estrucTableroTurnoDet.isActivo())
        		estrucTableroTurnoDet.delete();
        	estructableroturnoscab.addDetalle(estrucTableroTurnoDet);
        	dsDet.next();
        }
        
        
        
        addTransaccion(estructableroturnoscab);
        dataset.next();
    }
  }
  
}
