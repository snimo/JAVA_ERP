package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class ProgramarTableroTurnos extends Operation { 

  public ProgramarTableroTurnos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TInput"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) {
    	  
    	java.util.Date fecDesde = dataset.getDate("fec_desde");  
    	java.util.Date fecHasta = dataset.getDate("fec_hasta");
    	
    	if (!fecDesde.before((Fecha.getFechaMasDias(fecHasta,1))))
    		throw new ExceptionValidation(null,"La fecha hasta debe ser mayor a la fecha desde");
    	
    	EstrucTableroTurnosCab  estrucTablero = EstrucTableroTurnosCab.findByOid(dataset.getInteger("oid_estruc_tablero"), this.getSesion());
    	
    	// Recorrer todas las Fechas
    	java.util.Date fechaAProg = fecDesde;
    	while (fechaAProg.before(Fecha.getFechaMasDias(fecHasta,1))) {
    		TableroTurnos tablero = TableroTurnos.programarTablero(fechaAProg, estrucTablero, false , this.getSesion());
    		if (tablero!=null)
    			this.addTransaccion(tablero);
    		fechaAProg = Fecha.getFechaMasDias(fechaAProg, 1);
    	}
    	
        dataset.next();
    }
  }
  
}
