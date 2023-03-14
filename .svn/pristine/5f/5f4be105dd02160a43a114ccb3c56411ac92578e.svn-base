package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerEstadoPresupuestoCliente extends Operation { 

  public TraerEstadoPresupuestoCliente() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EstadoPresupuestoCliente estadopresupuestocliente = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       estadopresupuestocliente = EstadoPresupuestoCliente.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       estadopresupuestocliente = EstadoPresupuestoCliente.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEstadoPresupuestoCliente = getDataSetEstadoPresupuestoCliente();
    if (estadopresupuestocliente != null) { 
        cargarRegistroEstadoPresupuestoCliente(datasetEstadoPresupuestoCliente, 
                         estadopresupuestocliente.getOIDInteger(),
                         estadopresupuestocliente.getCodigo(),
                         estadopresupuestocliente.getDescripcion(),
                         estadopresupuestocliente.isActivo());
    }
    writeCliente(datasetEstadoPresupuestoCliente);
  }

  private IDataSet getDataSetEstadoPresupuestoCliente() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstadoPresupuestoCliente");
    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroEstadoPresupuestoCliente(IDataSet dataset, 
                         Integer oid_estado,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_estado", oid_estado);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
