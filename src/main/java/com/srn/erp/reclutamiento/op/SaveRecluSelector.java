package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluSelector;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluSelector extends Operation { 

  public SaveRecluSelector() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluSelector"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluSelector recluselector = RecluSelector.findByOid(dataset.getInteger("oid_selector"),getSesion());
        recluselector.setOID(dataset.getInteger("oid_selector"));
        recluselector.setCodigo(dataset.getString("codigo"));
        recluselector.setDescripcion(dataset.getString("descripcion"));
        recluselector.setUsuario(Usuario.findByOidProxy(dataset.getInteger("oid_usuario"), this.getSesion()));
        recluselector.setActivo(dataset.getBoolean("activo"));
        addTransaccion(recluselector);
        dataset.next();
    }
  }
  
}
