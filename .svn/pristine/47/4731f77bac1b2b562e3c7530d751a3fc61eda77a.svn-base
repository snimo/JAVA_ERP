package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerMotivoFaltaRRHH extends Operation { 

  public TraerMotivoFaltaRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoFaltaRRHH motivofaltarrhh = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivofaltarrhh = MotivoFaltaRRHH.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivofaltarrhh = MotivoFaltaRRHH.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivoFaltaRRHH = getDataSetMotivoFaltaRRHH();
    if (motivofaltarrhh != null) { 
        cargarRegistroMotivoFaltaRRHH(datasetMotivoFaltaRRHH, 
                         motivofaltarrhh.getOIDInteger(),
                         motivofaltarrhh.getCodigo(),
                         motivofaltarrhh.getDescripcion(),
                         motivofaltarrhh.isActivo());
    }
    writeCliente(datasetMotivoFaltaRRHH);
  }

  private IDataSet getDataSetMotivoFaltaRRHH() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoFaltaRRHH");
    dataset.fieldDef(new Field("oid_mot_falta", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotivoFaltaRRHH(IDataSet dataset, 
                         Integer oid_mot_falta,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_mot_falta", oid_mot_falta);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
