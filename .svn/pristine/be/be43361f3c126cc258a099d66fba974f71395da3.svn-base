package com.srn.erp.general.op;

import com.srn.erp.general.bm.MotivoComprobante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoComprobante extends Operation { 

  public SaveMotivoComprobante() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoComprobante"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoComprobante motivocomprobante = MotivoComprobante.findByOid(dataset.getInteger("oid_motivo_compro"),getSesion());
        motivocomprobante.setOID(dataset.getInteger("oid_motivo_compro"));
        motivocomprobante.setCodigo(dataset.getString("codigo"));
        motivocomprobante.setDescripcion(dataset.getString("descripcion"));
        motivocomprobante.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivocomprobante);
        dataset.next();
    }
  }
  
}
