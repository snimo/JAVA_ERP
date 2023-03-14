package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTipoRecurso extends Operation { 

  public TraerTipoRecurso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoRecurso tiporecurso = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tiporecurso = TipoRecurso.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tiporecurso = TipoRecurso.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoRecurso = getDataSetTipoRecurso();
    if (tiporecurso != null) { 
        cargarRegistroTipoRecurso(datasetTipoRecurso, 
                         tiporecurso.getOIDInteger(),
                         tiporecurso.getCodigo(),
                         tiporecurso.getDescripcion(),
                         tiporecurso.isActivo());
    }
    writeCliente(datasetTipoRecurso);
  }

  private IDataSet getDataSetTipoRecurso() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoRecurso");
    dataset.fieldDef(new Field("oid_tipo_recurso", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoRecurso(IDataSet dataset, 
                         Integer oid_tipo_recurso,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_recurso", oid_tipo_recurso);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
