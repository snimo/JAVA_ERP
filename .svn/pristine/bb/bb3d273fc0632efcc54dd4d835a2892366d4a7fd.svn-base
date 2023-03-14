package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.MotivoFichadaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoFichadaCIP extends Operation { 

  public SaveMotivoFichadaCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoFichadaCIP"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoFichadaCIP motivofichadacip = MotivoFichadaCIP.findByOid(dataset.getInteger("oid_motivo_fichada"),getSesion());
        motivofichadacip.setOID(dataset.getInteger("oid_motivo_fichada"));
        motivofichadacip.setDescripcion(dataset.getString("descripcion"));
        motivofichadacip.setEntrada(dataset.getBoolean("entrada"));
        motivofichadacip.setRequiere_obs_ent(dataset.getBoolean("requiere_obs_ent"));
        motivofichadacip.setSalida(dataset.getBoolean("salida"));
        motivofichadacip.setRequiere_obs_sal(dataset.getBoolean("requiere_obs_sal"));
        motivofichadacip.setOrden_entrada(dataset.getInteger("orden_entrada"));
        motivofichadacip.setOrden_salida(dataset.getInteger("orden_salida"));
        motivofichadacip.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivofichadacip);
        dataset.next();
    }
  }
  
}
