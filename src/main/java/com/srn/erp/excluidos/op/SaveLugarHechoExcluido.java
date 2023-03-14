package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveLugarHechoExcluido extends Operation { 

  public SaveLugarHechoExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TLugarHechoExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        LugarHechoExcluido lugarhechoexcluido = LugarHechoExcluido.findByOid(dataset.getInteger("oid_lugar_hecho"),getSesion());
        lugarhechoexcluido.setOID(dataset.getInteger("oid_lugar_hecho"));
        lugarhechoexcluido.setCodigo(dataset.getString("codigo"));
        lugarhechoexcluido.setDescripcion(dataset.getString("descripcion"));
        lugarhechoexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(lugarhechoexcluido);
        dataset.next();
    }
  }
  
}
