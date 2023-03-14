package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.DeudaPorConcTurno;
import com.srn.erp.turnos.bm.GrupoConceptoTurno;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveDeudaPorConcTurno extends Operation { 

  public SaveDeudaPorConcTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TDeudaPorConcTurno"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        DeudaPorConcTurno deudaporconcturno = DeudaPorConcTurno.findByOid(dataset.getInteger("oid_deuda_conc"),getSesion());
        deudaporconcturno.setDescripcion(dataset.getString("descripcion"));
        deudaporconcturno.setComportamiento(dataset.getString("comportamiento"));
        deudaporconcturno.setMax_dias_atraso(dataset.getInteger("max_dias_atraso"));
        deudaporconcturno.setMax_deuda(dataset.getDouble("max_deuda"));
        deudaporconcturno.setActivo(dataset.getBoolean("activo"));
        deudaporconcturno.setCantMaxPeriDeuda(dataset.getInteger("cant_max_peri_deu"));
        
        
        IDataSet dsConceptos = dataset.getDataSet("TConceptos");
        dsConceptos.first();
        while (!dsConceptos.EOF()) {
        	GrupoConceptoTurno grupoConcTurno = GrupoConceptoTurno.getGrupoConceptoTurno(deudaporconcturno, dsConceptos.getString("concepto"), this.getSesion());
        	if (grupoConcTurno == null)
        		grupoConcTurno = (GrupoConceptoTurno) GrupoConceptoTurno.getNew(GrupoConceptoTurno.NICKNAME, this.getSesion());
        	grupoConcTurno.setDeuda_por_concepto(deudaporconcturno);
        	grupoConcTurno.setConcepto(dsConceptos.getString("concepto"));
        	if (dsConceptos.getBoolean("activo").booleanValue()==false)
        		grupoConcTurno.delete();
        	
        	deudaporconcturno.addGrupoConceptoTurno(grupoConcTurno);
        	
        	dsConceptos.next();
        }
        
        addTransaccion(deudaporconcturno);
        dataset.next();
    }
  }
  
}
