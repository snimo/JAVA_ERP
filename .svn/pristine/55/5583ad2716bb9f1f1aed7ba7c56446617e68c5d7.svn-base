package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.TipoAcuerdo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoAcuerdo extends Operation { 

  public SaveTipoAcuerdo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTiposAcuerdos"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoAcuerdo tipoacuerdo = TipoAcuerdo.findByOid(dataset.getInteger("oid_tipo_acuerdo"),getSesion());
        tipoacuerdo.setOID(dataset.getInteger("oid_tipo_acuerdo"));
        tipoacuerdo.setCodigo(dataset.getString("codigo"));
        tipoacuerdo.setDescripcion(dataset.getString("descripcion"));
        tipoacuerdo.setTipo_acuerdo(dataset.getString("tipo_acuerdo"));
        tipoacuerdo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipoacuerdo);
        dataset.next();
    }
  }
  
}
