package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.MotivoDecisionAdjudicacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivoDecisionAdjudicacion extends Operation { 

  public TraerMotivoDecisionAdjudicacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoDecisionAdjudicacion motivodecisionadjudicacion = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivodecisionadjudicacion = MotivoDecisionAdjudicacion.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivodecisionadjudicacion = MotivoDecisionAdjudicacion.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivoDecisionAdjudicacion = getDataSetMotivoDecisionAdjudicacion();
    if (motivodecisionadjudicacion != null) { 
        cargarRegistroMotivoDecisionAdjudicacion(datasetMotivoDecisionAdjudicacion, 
                         motivodecisionadjudicacion.getOIDInteger(),
                         motivodecisionadjudicacion.getCodigo(),
                         motivodecisionadjudicacion.getDescripcion(),
                         motivodecisionadjudicacion.isActivo());
    }
    writeCliente(datasetMotivoDecisionAdjudicacion);
  }

  private IDataSet getDataSetMotivoDecisionAdjudicacion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoDecisionAdjudicacion");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 30)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotivoDecisionAdjudicacion(IDataSet dataset, 
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
