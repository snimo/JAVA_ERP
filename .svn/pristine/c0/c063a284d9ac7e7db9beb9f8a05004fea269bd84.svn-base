package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerPlanta extends Operation { 

  public TraerPlanta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    Planta planta = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       planta = Planta.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       planta = Planta.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPlanta = getDataSetPlanta();
    if (planta != null) { 
        cargarRegistroPlanta(datasetPlanta, 
                         planta.getOIDInteger(),
                         planta.getCodigo(),
                         planta.getDescripcion(),
                         planta.isActivo());
    }
    writeCliente(datasetPlanta);
  }

  private IDataSet getDataSetPlanta() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPlanta");
    dataset.fieldDef(new Field("oid_planta", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroPlanta(IDataSet dataset, 
                         Integer oid_planta,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_planta", oid_planta);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
