package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerMotVisFalRRHH extends Operation { 

  public TraerMotVisFalRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotVisFalRRHH motvisfalrrhh = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motvisfalrrhh = MotVisFalRRHH.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motvisfalrrhh = MotVisFalRRHH.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotVisFalRRHH = getDataSetMotVisFalRRHH();
    if (motvisfalrrhh != null) { 
        cargarRegistroMotVisFalRRHH(datasetMotVisFalRRHH, 
                         motvisfalrrhh.getOIDInteger(),
                         motvisfalrrhh.getCodigo(),
                         motvisfalrrhh.getDescripcion(),
                         motvisfalrrhh.isActivo());
    }
    writeCliente(datasetMotVisFalRRHH);
  }

  private IDataSet getDataSetMotVisFalRRHH() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotVisFalRRHH");
    dataset.fieldDef(new Field("oid_mot_vis_fall", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotVisFalRRHH(IDataSet dataset, 
                         Integer oid_mot_vis_fall,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_mot_vis_fall", oid_mot_vis_fall);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
