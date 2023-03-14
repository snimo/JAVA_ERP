package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTipoPeriodo extends Operation { 

  public TraerTipoPeriodo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoPeriodo tipoperiodo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tipoperiodo = TipoPeriodo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tipoperiodo = TipoPeriodo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoPeriodo = getDataSetTipoPeriodo();
    if (tipoperiodo != null) { 
        cargarRegistroTipoPeriodo(datasetTipoPeriodo, 
                         tipoperiodo.getOIDInteger(),
                         tipoperiodo.getCodigo(),
                         tipoperiodo.getDescripcion(),
                         tipoperiodo.isActivo());
    }
    writeCliente(datasetTipoPeriodo);
  }

  private IDataSet getDataSetTipoPeriodo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoPeriodo");
    dataset.fieldDef(new Field("oid_tipo_peri", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoPeriodo(IDataSet dataset, 
                         Integer oid_tipo_peri,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_peri", oid_tipo_peri);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
