package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerMedicoRRHH extends Operation { 

  public TraerMedicoRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MedicoRRHH medicorrhh = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       medicorrhh = MedicoRRHH.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       medicorrhh = MedicoRRHH.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMedicoRRHH = getDataSetMedicoRRHH();
    if (medicorrhh != null) { 
        cargarRegistroMedicoRRHH(datasetMedicoRRHH, 
                         medicorrhh.getOIDInteger(),
                         medicorrhh.getCodigo(),
                         medicorrhh.getDescripcion(),
                         medicorrhh.isActivo());
    }
    writeCliente(datasetMedicoRRHH);
  }

  private IDataSet getDataSetMedicoRRHH() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMedicoRRHH");
    dataset.fieldDef(new Field("oid_medico", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMedicoRRHH(IDataSet dataset, 
                         Integer oid_medico,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_medico", oid_medico);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
