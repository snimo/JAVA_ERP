package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoNovedadExcluido extends Operation { 

  public SaveMotivoNovedadExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoNovedadExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoNovedadExcluido motivonovedadexcluido = MotivoNovedadExcluido.findByOid(dataset.getInteger("oid_motivo"),getSesion());
        motivonovedadexcluido.setOID(dataset.getInteger("oid_motivo"));
        motivonovedadexcluido.setCodigo(dataset.getString("codigo"));
        motivonovedadexcluido.setDescripcion(dataset.getString("descripcion"));
        motivonovedadexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivonovedadexcluido);
        dataset.next();
    }
  }
  
}
