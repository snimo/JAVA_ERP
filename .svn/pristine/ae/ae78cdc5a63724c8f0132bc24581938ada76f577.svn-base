package com.srn.erp.general.op;

import com.srn.erp.general.bm.MotivoComprobante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivoComprobante extends Operation { 

  public TraerMotivoComprobante() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoComprobante motivocomprobante = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivocomprobante = MotivoComprobante.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivocomprobante = MotivoComprobante.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivoComprobante = getDataSetMotivoComprobante();
    if (motivocomprobante != null) { 
        cargarRegistroMotivoComprobante(datasetMotivoComprobante, 
                         motivocomprobante.getOIDInteger(),
                         motivocomprobante.getCodigo(),
                         motivocomprobante.getDescripcion(),
                         motivocomprobante.isActivo());
    }
    writeCliente(datasetMotivoComprobante);
  }

  private IDataSet getDataSetMotivoComprobante() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoComprobante");
    dataset.fieldDef(new Field("oid_motivo_compro", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 30)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotivoComprobante(IDataSet dataset, 
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_motivo_compro", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
