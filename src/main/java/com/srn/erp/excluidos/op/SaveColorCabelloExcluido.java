package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.ColorCabelloExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveColorCabelloExcluido extends Operation { 

  public SaveColorCabelloExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TColorCabelloExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ColorCabelloExcluido colorcabelloexcluido = ColorCabelloExcluido.findByOid(dataset.getInteger("oid_color"),getSesion());
        colorcabelloexcluido.setOID(dataset.getInteger("oid_color"));
        colorcabelloexcluido.setCodigo(dataset.getString("codigo"));
        colorcabelloexcluido.setDescripcion(dataset.getString("descripcion"));
        colorcabelloexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(colorcabelloexcluido);
        dataset.next();
    }
  }
  
}
