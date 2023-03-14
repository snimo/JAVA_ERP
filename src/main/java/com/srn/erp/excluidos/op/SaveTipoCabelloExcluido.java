package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.TipoCabelloExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoCabelloExcluido extends Operation { 

  public SaveTipoCabelloExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoCabelloExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoCabelloExcluido tipocabelloexcluido = TipoCabelloExcluido.findByOid(dataset.getInteger("oid_tipo_cabello"),getSesion());
        tipocabelloexcluido.setOID(dataset.getInteger("oid_tipo_cabello"));
        tipocabelloexcluido.setCodigo(dataset.getString("codigo"));
        tipocabelloexcluido.setDescripcion(dataset.getString("descripcion"));
        tipocabelloexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipocabelloexcluido);
        dataset.next();
    }
  }
  
}
