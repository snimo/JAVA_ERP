package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerMotivoDevolucionCliente extends Operation { 

  public TraerMotivoDevolucionCliente() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoDevolucionCliente motivodevolucioncliente = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivodevolucioncliente = MotivoDevolucionCliente.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivodevolucioncliente = MotivoDevolucionCliente.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivoDevolucionCliente = getDataSetMotivoDevolucionCliente();
    if (motivodevolucioncliente != null) { 
        cargarRegistroMotivoDevolucionCliente(datasetMotivoDevolucionCliente, 
                         motivodevolucioncliente.getOIDInteger(),
                         motivodevolucioncliente.getCodigo(),
                         motivodevolucioncliente.getDescripcion(),
                         motivodevolucioncliente.isActivo());
    }
    writeCliente(datasetMotivoDevolucionCliente);
  }

  private IDataSet getDataSetMotivoDevolucionCliente() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoDevolucionCliente");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotivoDevolucionCliente(IDataSet dataset, 
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
