package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SavePlantillaHorariosTurno extends Operation { 

  public SavePlantillaHorariosTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTurnoPlantillaHorCab"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TurnoPlantillaHorCab turnoplantillahorcab = TurnoPlantillaHorCab.findByOid(dataset.getInteger("oid_plant_hor"),getSesion());
        turnoplantillahorcab.setOID(dataset.getInteger("oid_plant_hor"));
        turnoplantillahorcab.setDescripcion(dataset.getString("descripcion"));
        turnoplantillahorcab.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsDet = dataset.getDataSet("TTurnoPlantillaHorDet");
        dsDet.first();
        while (!dsDet.EOF()) {
        	TurnoPlantillaHorDet turnoplantillahordet = TurnoPlantillaHorDet.findByOid(dsDet.getInteger("oid_plant_hor_det"),getSesion());
        	turnoplantillahordet.setPlantilla_horario(turnoplantillahorcab);
        	turnoplantillahordet.setHorario(dsDet.getString("horario"));
        	turnoplantillahordet.setActivo(dsDet.getBoolean("activo"));
        	if (!turnoplantillahordet.isActivo().booleanValue())
        		turnoplantillahordet.delete();
        	
        	turnoplantillahorcab.addPlantillaHorDet(turnoplantillahordet);
        	
        	dsDet.next();
        }
        
        
        
        addTransaccion(turnoplantillahorcab);
        dataset.next();
    }
  }
  
}
