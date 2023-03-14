package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CicloPresupuestal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerParaSeleccionarCicloPresu extends Operation { 

	private int secu = 0;
	
  public TraerParaSeleccionarCicloPresu() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet dsCicloPresu = this.getDSCicloPresupuestal();
  	
  	Iterator iterCicloPresu = 
  		CicloPresupuestal.getCiclosActivosOrdenadasParaPresentar(this.getSesion()).iterator();
  	while (iterCicloPresu.hasNext()) {
  		CicloPresupuestal ciclo = (CicloPresupuestal) iterCicloPresu.next();
  		cargarRegistro(dsCicloPresu,ciclo);
  	}
  	
    writeCliente(dsCicloPresu);
    
  }

  private IDataSet getDSCicloPresupuestal() {
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCicloPresupuestal");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo",Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
    return dataset;
  }
  
  private void cargarRegistro(IDataSet dataset, 
      												CicloPresupuestal ciclo) throws BaseException {
  	dataset.append();
  	dataset.fieldValue("oid", ciclo.getOID());
  	dataset.fieldValue("codigo",ciclo.getCodigo());
  	dataset.fieldValue("descripcion", ciclo.getDescripcion());
  	dataset.fieldValue("orden",new Integer(++secu));
 } 	
  
  
  
}
