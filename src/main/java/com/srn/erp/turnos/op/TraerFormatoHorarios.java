package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.TurnoPlantillaHorCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFormatoHorarios extends Operation { 

  public TraerFormatoHorarios() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSetHorariosFormateados();
	  
	  Integer oid = mapaDatos.getInteger("oid_plantilla_horarios");
	  TurnoPlantillaHorCab turnoPlantilla = TurnoPlantillaHorCab.findByOid(oid, this.getSesion());
	  Iterator iterHorariosFormateados = turnoPlantilla.getHorariosFormateados().iterator();
	  while (iterHorariosFormateados.hasNext()) {
		  String horarioFormateado = (String) iterHorariosFormateados.next();
		  cargarRegistro(ds, horarioFormateado);
	  }
	  
	  
	  writeCliente(ds);
  }

  private IDataSet getDataSetHorariosFormateados() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("THorariosFormateados");
    dataset.fieldDef(new Field("horario", Field.STRING, 13)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         String horario) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("horario", horario);
  }
}
