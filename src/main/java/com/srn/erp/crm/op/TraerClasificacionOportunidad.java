package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.ClasificacionOportunidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerClasificacionOportunidad extends Operation { 

  public TraerClasificacionOportunidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ClasificacionOportunidad clasifOpor = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       clasifOpor = ClasificacionOportunidad.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       clasifOpor = ClasificacionOportunidad.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetClasifOpor = getDataSetClasifOpor();
    if (clasifOpor != null) { 
        cargarRegistroClasifOpor(datasetClasifOpor, 
                         clasifOpor.getCodigo(),
                         clasifOpor.getDescripcion(),
                         clasifOpor.isActivo(),
                         clasifOpor.getOIDInteger());
    }
    writeCliente(datasetClasifOpor);
  }

  private IDataSet getDataSetClasifOpor() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TClasifOpor");
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_clasif_opor", Field.INTEGER, 0)); 
    return dataset;
  }

  private void cargarRegistroClasifOpor(IDataSet dataset, 
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Integer oid_clasif_opor) {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("oid_clasif_opor", oid_clasif_opor);
  }
}
