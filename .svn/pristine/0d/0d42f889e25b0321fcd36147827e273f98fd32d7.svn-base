package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerClaseSindicato extends Operation { 

  public TraerClaseSindicato() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ClaseSindicato clasesindicato = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       clasesindicato = ClaseSindicato.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       clasesindicato = ClaseSindicato.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetClaseSindicato = getDataSetClaseSindicato();
    if (clasesindicato != null) { 
        cargarRegistroClaseSindicato(datasetClaseSindicato, 
                         clasesindicato.getOIDInteger(),
                         clasesindicato.getCodigo(),
                         clasesindicato.getDescripcion(),
                         clasesindicato.isActivo());
    }
    writeCliente(datasetClaseSindicato);
  }

  private IDataSet getDataSetClaseSindicato() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TClaseSindicato");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroClaseSindicato(IDataSet dataset, 
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
