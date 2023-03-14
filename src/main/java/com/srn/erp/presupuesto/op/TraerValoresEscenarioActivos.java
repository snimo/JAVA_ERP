package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.ValorEscenario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresEscenarioActivos extends Operation {

	public TraerValoresEscenarioActivos() {
	}
	

	public void execute(MapDatos mapaDatos) throws BaseException {

			IDataSet dsValorEscenarios = this.getDataSetValoresEscenariosActivos();
		
		  Iterator iterValoresEsce = 
		  	ValorEscenario.getValoresByUltimoNivelActivos(this.getSesion()).iterator();
		  while (iterValoresEsce.hasNext()) {
		  	ValorEscenario valorEscenario = (ValorEscenario) iterValoresEsce.next();
		  	cargarRegistroValorEscenario(dsValorEscenarios,valorEscenario);
		  }
		  
		  writeCliente(dsValorEscenarios);
		  
	}
	
  private IDataSet getDataSetValoresEscenariosActivos() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValoresEscenario");
    dataset.fieldDef(new Field("oid_valor_escenario", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroValorEscenario(IDataSet dataset, 
                                            ValorEscenario valorEscenario) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_valor_escenario", valorEscenario.getOIDInteger()); 
    dataset.fieldValue("codigo", valorEscenario.getCodigo());
    dataset.fieldValue("descripcion", valorEscenario.getDescripcion());
    dataset.fieldValue("activo", valorEscenario.isActivo());
  }  
	


}
