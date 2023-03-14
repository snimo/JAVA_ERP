package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveCicloPresupuestal extends Operation { 

  public SaveCicloPresupuestal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCicloPresupuestal"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CicloPresupuestal ciclopresupuestal = CicloPresupuestal.findByOid(dataset.getInteger("oid_ciclo"),getSesion());
        ciclopresupuestal.setOID(dataset.getInteger("oid_ciclo"));
        ciclopresupuestal.setCodigo(dataset.getString("codigo"));
        ciclopresupuestal.setDescripcion(dataset.getString("descripcion"));
        ciclopresupuestal.setObservacion(dataset.getString("observacion"));
        ciclopresupuestal.setNro_orden_visual(dataset.getInteger("nro_orden_visual"));
        ciclopresupuestal.setActivo(dataset.getBoolean("activo"));
        ciclopresupuestal.setFechaInicioPlanif(dataset.getDate("fecha_inicio_planif"));
        ciclopresupuestal.setTipo_ciclo(TipoCiclo.findByOidProxy(dataset.getInteger("oid_tipo_ciclo"),this.getSesion()));
        addTransaccion(ciclopresupuestal);
        dataset.next();
    }
  }
  
}
