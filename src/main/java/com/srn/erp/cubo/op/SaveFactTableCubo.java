package com.srn.erp.cubo.op;

import com.srn.erp.cubo.bm.FactTableCubo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.xlook.bm.Select;

public class SaveFactTableCubo extends Operation { 

  public SaveFactTableCubo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TFactTableCubo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        FactTableCubo facttablecubo = FactTableCubo.findByOid(dataset.getInteger("oid_fact_table"),getSesion());
        facttablecubo.setOID(dataset.getInteger("oid_fact_table"));
        facttablecubo.setCodigo(dataset.getString("codigo"));
        facttablecubo.setDescripcion(dataset.getString("descripcion"));
        facttablecubo.setSelect(Select.findByOid(dataset.getInteger("oid_select"),getSesion()));
        facttablecubo.setTipo_fact_table(dataset.getString("tipo_fact_table"));
        facttablecubo.setNombre_oper(dataset.getString("nombre_oper"));
        facttablecubo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(facttablecubo);
        dataset.next();
    }
  }
  
}
