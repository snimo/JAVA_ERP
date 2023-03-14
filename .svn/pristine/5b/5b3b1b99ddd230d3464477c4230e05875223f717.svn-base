package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTipoPlan extends Operation { 

  public TraerTipoPlan() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoPlan tipoplan = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tipoplan = TipoPlan.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tipoplan = TipoPlan.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoPlan = getDataSetTipoPlan();
    if (tipoplan != null) { 
        cargarRegistroTipoPlan(datasetTipoPlan, 
                         tipoplan.getOIDInteger(),
                         tipoplan.getCodigo(),
                         tipoplan.getDescripcion(),
                         tipoplan.isActivo());
    }
    writeCliente(datasetTipoPlan);
  }

  private IDataSet getDataSetTipoPlan() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoPlan");
    dataset.fieldDef(new Field("oid_tipo_plan", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoPlan(IDataSet dataset, 
                         Integer oid_tipo_plan,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_plan", oid_tipo_plan);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
