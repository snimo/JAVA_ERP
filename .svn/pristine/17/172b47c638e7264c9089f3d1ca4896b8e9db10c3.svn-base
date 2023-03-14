package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.PeriodoPresupuestario;
import com.srn.erp.presupuesto.bm.TipoPeriodo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePeriodoPresupuestario extends Operation { 

  public SavePeriodoPresupuestario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoPeriodo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
      dataset.first(); 
      while (!dataset.EOF()) { 
      	
      	// Leer la informacion de los Periodos
      	IDataSet dsPeriodo = dataset.getDataSet("TPeriodos");
      	dsPeriodo.first();
      	while (!dsPeriodo.EOF()) {
      		
      		PeriodoPresupuestario periodo = 
      			PeriodoPresupuestario.findByOid(dsPeriodo.getInteger("oid_peri"),this.getSesion());
      		periodo.setCodigo(dsPeriodo.getString("codigo"));
      		periodo.setDescripcion(dsPeriodo.getString("descripcion"));
      		periodo.setTipo_periodo(TipoPeriodo.findByOidProxy(dsPeriodo.getInteger("oid_tipo_peri"),this.getSesion()));
      		periodo.setFec_desde(dsPeriodo.getDate("fec_desde"));
      		periodo.setFec_hasta(dsPeriodo.getDate("fec_hasta"));
      		periodo.setActivo(dsPeriodo.getBoolean("activo"));
      		if (periodo.isActivo().booleanValue()==false)
      			periodo.anular();
      		
      		addTransaccion(periodo);
      		
      		dsPeriodo.next();
      	}
      dataset.next();	
      }
  }
  
  
  
}
