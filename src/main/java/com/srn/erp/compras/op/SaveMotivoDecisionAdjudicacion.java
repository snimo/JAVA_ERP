package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.MotivoDecisionAdjudicacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoDecisionAdjudicacion extends Operation { 

  public SaveMotivoDecisionAdjudicacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoDecisionAdjudicacion"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoDecisionAdjudicacion motivodecisionadjudicacion = MotivoDecisionAdjudicacion.findByOid(dataset.getInteger("oid"),getSesion());
        motivodecisionadjudicacion.setOID(dataset.getInteger("oid"));
        motivodecisionadjudicacion.setCodigo(dataset.getString("codigo"));
        motivodecisionadjudicacion.setDescripcion(dataset.getString("descripcion"));
        motivodecisionadjudicacion.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivodecisionadjudicacion);
        dataset.next();
    }
  }
  
}
