package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.MotDifPagoExc;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoDiferenciaPagoExcluido extends Operation { 

  public SaveMotivoDiferenciaPagoExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoDiferenciaPagoExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotDifPagoExc motivodiferenciapagoexcluido = MotDifPagoExc.findByOid(dataset.getInteger("oid_mot_dif_imp"),getSesion());
        motivodiferenciapagoexcluido.setOID(dataset.getInteger("oid_mot_dif_imp"));
        motivodiferenciapagoexcluido.setCodigo(dataset.getString("codigo"));
        motivodiferenciapagoexcluido.setDescripcion(dataset.getString("descripcion"));
        motivodiferenciapagoexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivodiferenciapagoexcluido);
        dataset.next();
    }
  }
  
}
