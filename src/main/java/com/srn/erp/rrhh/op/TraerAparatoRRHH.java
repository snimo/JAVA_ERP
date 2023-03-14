package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerAparatoRRHH extends Operation { 

  public TraerAparatoRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    AparatoRRHH aparatorrhh = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       aparatorrhh = AparatoRRHH.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       aparatorrhh = AparatoRRHH.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetAparatoRRHH = getDataSetAparatoRRHH();
    if (aparatorrhh != null) { 
        cargarRegistroAparatoRRHH(datasetAparatoRRHH, 
                         aparatorrhh.getOIDInteger(),
                         aparatorrhh.getCosigo(),
                         aparatorrhh.getDescripcion(),
                         aparatorrhh.isActivo());
    }
    writeCliente(datasetAparatoRRHH);
  }

  private IDataSet getDataSetAparatoRRHH() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAparatoRRHH");
    dataset.fieldDef(new Field("oid_aparato", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroAparatoRRHH(IDataSet dataset, 
                         Integer oid_aparato,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_aparato", oid_aparato);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
