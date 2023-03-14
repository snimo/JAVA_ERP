package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.TipoCampania;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoCampania extends Operation { 

  public SaveTipoCampania() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoCampania"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoCampania tipocampania = TipoCampania.findByOid(dataset.getInteger("oid_tipo_camp"),getSesion());
        tipocampania.setCodigo(dataset.getString("codigo"));
        tipocampania.setDescripcion(dataset.getString("descripcion"));
        tipocampania.setActivo(dataset.getBoolean("activo"));
        tipocampania.setOID(dataset.getInteger("oid_tipo_camp"));
        addTransaccion(tipocampania);
        dataset.next();
    }
  }
  
}
