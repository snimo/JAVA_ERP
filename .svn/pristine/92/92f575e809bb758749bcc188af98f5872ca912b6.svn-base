package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerMotivoEgresoEmp extends Operation { 

  public TraerMotivoEgresoEmp() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoEgresoEmp motivoegresoemp = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivoegresoemp = MotivoEgresoEmp.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivoegresoemp = MotivoEgresoEmp.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivoEgresoEmp = getDataSetMotivoEgresoEmp();
    if (motivoegresoemp != null) { 
        cargarRegistroMotivoEgresoEmp(datasetMotivoEgresoEmp, 
                         motivoegresoemp.getOIDInteger(),
                         motivoegresoemp.getCodigo(),
                         motivoegresoemp.getDescripcion(),
                         motivoegresoemp.isActivo());
    }
    writeCliente(datasetMotivoEgresoEmp);
  }

  private IDataSet getDataSetMotivoEgresoEmp() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoEgresoEmp");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotivoEgresoEmp(IDataSet dataset, 
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
