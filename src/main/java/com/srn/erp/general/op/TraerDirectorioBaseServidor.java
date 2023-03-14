package com.srn.erp.general.op;

import com.srn.erp.general.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerDirectorioBaseServidor extends Operation { 

  public TraerDirectorioBaseServidor() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    DirectorioBaseServidor directoriobaseservidor = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       directoriobaseservidor = DirectorioBaseServidor.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       directoriobaseservidor = DirectorioBaseServidor.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetDirectorioBaseServidor = getDataSetDirectorioBaseServidor();
    if (directoriobaseservidor != null) { 
        cargarRegistroDirectorioBaseServidor(datasetDirectorioBaseServidor, 
                         directoriobaseservidor.getOIDInteger(),
                         directoriobaseservidor.getCodigo(),
                         directoriobaseservidor.getDescripcion(),
                         directoriobaseservidor.isActivo());
    }
    writeCliente(datasetDirectorioBaseServidor);
  }

  private IDataSet getDataSetDirectorioBaseServidor() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TDirectorioBaseServidor");
    dataset.fieldDef(new Field("oid_dir_base", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroDirectorioBaseServidor(IDataSet dataset, 
                         Integer oid_dir_base,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_dir_base", oid_dir_base);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
