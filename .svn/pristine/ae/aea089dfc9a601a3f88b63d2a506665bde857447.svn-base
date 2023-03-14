package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveRecluSectores extends Operation { 

  public SaveRecluSectores() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluSectores"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluSectores reclusectores = RecluSectores.findByOid(dataset.getInteger("oid_sector"),getSesion());
        reclusectores.setOID(dataset.getInteger("oid_sector"));
        reclusectores.setCodigo(dataset.getString("codigo"));
        reclusectores.setDescripcion(dataset.getString("descripcion"));
        reclusectores.setActivo(dataset.getBoolean("activo"));
        addTransaccion(reclusectores);
        dataset.next();
    }
  }
  
}
