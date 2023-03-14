package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.MotivoNovedadExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivoNovedadExcluido extends Operation { 

  public TraerMotivoNovedadExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoNovedadExcluido motivonovedadexcluido = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivonovedadexcluido = MotivoNovedadExcluido.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivonovedadexcluido = MotivoNovedadExcluido.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivoNovedadExcluido = getDataSetMotivoNovedadExcluido();
    if (motivonovedadexcluido != null) { 
        cargarRegistroMotivoNovedadExcluido(datasetMotivoNovedadExcluido, 
                         motivonovedadexcluido.getOIDInteger(),
                         motivonovedadexcluido.getCodigo(),
                         motivonovedadexcluido.getDescripcion(),
                         motivonovedadexcluido.isActivo());
    }
    writeCliente(datasetMotivoNovedadExcluido);
  }

  private IDataSet getDataSetMotivoNovedadExcluido() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoNovedadExcluido");
    dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotivoNovedadExcluido(IDataSet dataset, 
                         Integer oid_motivo,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_motivo", oid_motivo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
