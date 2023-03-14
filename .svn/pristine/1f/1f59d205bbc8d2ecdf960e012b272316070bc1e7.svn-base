package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import com.srn.erp.mensajero.bm.MiSenialONLINE;

import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveAlturaExcluido extends Operation { 

  public SaveAlturaExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TAlturaExcluido"); 
    procesarRegistros(dataset); 
    
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        AlturaExcluido alturaexcluido = AlturaExcluido.findByOid(dataset.getInteger("oid_altura"),getSesion());
        alturaexcluido.setOID(dataset.getInteger("oid_altura"));
        alturaexcluido.setCodigo(dataset.getString("codigo"));
        alturaexcluido.setDescripcion(dataset.getString("descripcion"));
        alturaexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(alturaexcluido);
        dataset.next();
    }
  }
  
}
