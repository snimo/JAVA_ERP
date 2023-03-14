package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.TipoUPC;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoUPC extends Operation { 

  public SaveTipoUPC() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoUPC"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoUPC tipoupc = TipoUPC.findByOid(dataset.getInteger("oid_tipo_upc"),getSesion());
        tipoupc.setOID(dataset.getInteger("oid_tipo_upc"));
        tipoupc.setCodigo(dataset.getString("codigo"));
        tipoupc.setDescripcion(dataset.getString("descripcion"));
        tipoupc.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipoupc);
        dataset.next();
    }
  }
  
}
