package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTipoNariz extends Operation { 

  public SaveTipoNariz() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoNariz"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoNariz tiponariz = TipoNariz.findByOid(dataset.getInteger("oid_tipo_nariz"),getSesion());
        tiponariz.setOID(dataset.getInteger("oid_tipo_nariz"));
        tiponariz.setCodigo(dataset.getString("codigo"));
        tiponariz.setDescripcion(dataset.getString("descripcion"));
        tiponariz.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tiponariz);
        dataset.next();
    }
  }
  
}
