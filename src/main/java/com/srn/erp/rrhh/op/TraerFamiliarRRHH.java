package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerFamiliarRRHH extends Operation { 

  public TraerFamiliarRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    FamiliarRRHH familiarrrhh = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       familiarrrhh = FamiliarRRHH.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       familiarrrhh = FamiliarRRHH.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetFamiliarRRHH = getDataSetFamiliarRRHH();
    if (familiarrrhh != null) { 
        cargarRegistroFamiliarRRHH(datasetFamiliarRRHH, 
                         familiarrrhh.getOIDInteger(),
                         familiarrrhh.getCodigo(),
                         familiarrrhh.getDescripcion(),
                         familiarrrhh.isActivo());
    }
    writeCliente(datasetFamiliarRRHH);
  }

  private IDataSet getDataSetFamiliarRRHH() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TFamiliarRRHH");
    dataset.fieldDef(new Field("oid_familiar", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroFamiliarRRHH(IDataSet dataset, 
                         Integer oid_familiar,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_familiar", oid_familiar);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
