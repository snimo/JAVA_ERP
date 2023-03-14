package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CondCompraImportacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCondCompraImportacion extends Operation { 

  public SaveCondCompraImportacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCondCompraImportacion"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CondCompraImportacion condcompraimportacion = CondCompraImportacion.findByOid(dataset.getInteger("oid_cond_cpra_imp"),getSesion());
        condcompraimportacion.setOID(dataset.getInteger("oid_cond_cpra_imp"));
        condcompraimportacion.setCodigo(dataset.getString("codigo"));
        condcompraimportacion.setDescripcion(dataset.getString("descripcion"));
        condcompraimportacion.setActivo(dataset.getBoolean("activo"));
        addTransaccion(condcompraimportacion);
        dataset.next();
    }
  }
  
}
