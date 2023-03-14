package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerGradoLegajo extends Operation { 

  public TraerGradoLegajo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GradoLegajo gradolegajo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       gradolegajo = GradoLegajo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       gradolegajo = GradoLegajo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGradoLegajo = getDataSetGradoLegajo();
    if (gradolegajo != null) { 
        cargarRegistroGradoLegajo(datasetGradoLegajo, 
                         gradolegajo.getOIDInteger(),
                         gradolegajo.getCodigo(),
                         gradolegajo.getDescripcion(),
                         gradolegajo.isActivo());
    }
    writeCliente(datasetGradoLegajo);
  }

  private IDataSet getDataSetGradoLegajo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGradoLegajo");
    dataset.fieldDef(new Field("oid_grado_leg", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGradoLegajo(IDataSet dataset, 
                         Integer oid_grado_leg,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_grado_leg", oid_grado_leg);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
