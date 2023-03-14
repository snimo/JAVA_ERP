package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerMotivoEstadoPresuCliente extends Operation { 

  public TraerMotivoEstadoPresuCliente() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoEstadoPresuCliente motivoestadopresucliente = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivoestadopresucliente = MotivoEstadoPresuCliente.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivoestadopresucliente = MotivoEstadoPresuCliente.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivoEstadoPresuCliente = getDataSetMotivoEstadoPresuCliente();
    if (motivoestadopresucliente != null) { 
        cargarRegistroMotivoEstadoPresuCliente(datasetMotivoEstadoPresuCliente, 
                         motivoestadopresucliente.getOIDInteger(),
                         motivoestadopresucliente.getCodigo(),
                         motivoestadopresucliente.getDescripcion(),
                         motivoestadopresucliente.isActivo());
    }
    writeCliente(datasetMotivoEstadoPresuCliente);
  }

  private IDataSet getDataSetMotivoEstadoPresuCliente() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoEstadoPresuCliente");
    dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotivoEstadoPresuCliente(IDataSet dataset, 
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
