package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerEnfermedadRRHH extends Operation { 

  public TraerEnfermedadRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EnfermedadRRHH enfermedadrrhh = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       enfermedadrrhh = EnfermedadRRHH.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       enfermedadrrhh = EnfermedadRRHH.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEnfermedadRRHH = getDataSetEnfermedadRRHH();
    if (enfermedadrrhh != null) { 
        cargarRegistroEnfermedadRRHH(datasetEnfermedadRRHH, 
                         enfermedadrrhh.getOIDInteger(),
                         enfermedadrrhh.getCodigo(),
                         enfermedadrrhh.getDescripcion(),
                         enfermedadrrhh.isActivo());
    }
    writeCliente(datasetEnfermedadRRHH);
  }

  private IDataSet getDataSetEnfermedadRRHH() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEnfermedadRRHH");
    dataset.fieldDef(new Field("oid_enfermedad", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroEnfermedadRRHH(IDataSet dataset, 
                         Integer oid_enfermedad,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_enfermedad", oid_enfermedad);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
