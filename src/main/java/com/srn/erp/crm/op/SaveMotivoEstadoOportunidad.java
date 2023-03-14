package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.MotivoEstadoOportunidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoEstadoOportunidad extends Operation { 

  public SaveMotivoEstadoOportunidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoEstadoOportunidad"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoEstadoOportunidad motivoestadooportunidad = MotivoEstadoOportunidad.findByOid(dataset.getInteger("oid_est_mot_opor"),getSesion());
        motivoestadooportunidad.setOID(dataset.getInteger("oid_est_mot_opor"));
        motivoestadooportunidad.setCodigo(dataset.getString("codigo"));
        motivoestadooportunidad.setDescripcion(dataset.getString("descripcion"));
        motivoestadooportunidad.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivoestadooportunidad);
        dataset.next();
    }
  }
  
}
