package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluSectores;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluSectores extends Operation { 

  public TraerRecluSectores() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluSectores reclusectores = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclusectores = RecluSectores.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclusectores = RecluSectores.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluSectores = getDataSetRecluSectores();
    if (reclusectores != null) { 
        cargarRegistroRecluSectores(datasetRecluSectores, 
                         reclusectores.getOIDInteger(),
                         reclusectores.getCodigo(),
                         reclusectores.getDescripcion(),
                         reclusectores.isActivo());
    }
    writeCliente(datasetRecluSectores);
  }

  private IDataSet getDataSetRecluSectores() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluSectores");
    dataset.fieldDef(new Field("oid_sector", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluSectores(IDataSet dataset, 
                         Integer oid_sector,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_sector", oid_sector);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
