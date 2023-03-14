package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.MotivoEstadoOportunidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivoEstadoOportunidad extends Operation { 

  public TraerMotivoEstadoOportunidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoEstadoOportunidad motivoestadooportunidad = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivoestadooportunidad = MotivoEstadoOportunidad.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivoestadooportunidad = MotivoEstadoOportunidad.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivoEstadoOportunidad = getDataSetMotivoEstadoOportunidad();
    if (motivoestadooportunidad != null) { 
        cargarRegistroMotivoEstadoOportunidad(datasetMotivoEstadoOportunidad, 
                         motivoestadooportunidad.getOIDInteger(),
                         motivoestadooportunidad.getCodigo(),
                         motivoestadooportunidad.getDescripcion(),
                         motivoestadooportunidad.isActivo());
    }
    writeCliente(datasetMotivoEstadoOportunidad);
  }

  private IDataSet getDataSetMotivoEstadoOportunidad() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoEstadoOportunidad");
    dataset.fieldDef(new Field("oid_est_mot_opor", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotivoEstadoOportunidad(IDataSet dataset, 
                         Integer oid_est_mot_opor,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_est_mot_opor", oid_est_mot_opor);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
