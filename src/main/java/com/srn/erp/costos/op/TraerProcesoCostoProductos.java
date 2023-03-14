package com.srn.erp.costos.op;

import com.srn.erp.costos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerProcesoCostoProductos extends Operation { 

  public TraerProcesoCostoProductos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ProcesoCostoProductos procesocostoproductos = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       procesocostoproductos = ProcesoCostoProductos.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       procesocostoproductos = ProcesoCostoProductos.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetProcesoCostoProductos = getDataSetProcesoCostoProductos();
    if (procesocostoproductos != null) { 
        cargarRegistroProcesoCostoProductos(datasetProcesoCostoProductos, 
                         procesocostoproductos);
    }
    writeCliente(datasetProcesoCostoProductos);
  }

  private IDataSet getDataSetProcesoCostoProductos() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TProcesoCostoProductos");
    dataset.fieldDef(new Field("oid_proceso_costo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("fec_ejecucion", Field.STRING, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("hora_ejecucion", Field.STRING, 5)); 
    dataset.fieldDef(new Field("oid_usuario", Field.STRING, 0)); 
    dataset.fieldDef(new Field("fec_costo", Field.STRING, 0)); 
    dataset.fieldDef(new Field("fec_desde", Field.STRING, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("fec_hasta", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroProcesoCostoProductos(IDataSet dataset, 
                         ProcesoCostoProductos proceso) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_proceso_costo", proceso.getOIDInteger());
    dataset.fieldValue("codigo", proceso.getCodigo());
    dataset.fieldValue("fec_ejecucion", proceso.getFec_ejecucion());
    dataset.fieldValue("descripcion", proceso.getDescripcion());
    dataset.fieldValue("hora_ejecucion", proceso.getHora_ejecucion());
    dataset.fieldValue("oid_usuario", proceso.getUsuario().getOIDInteger());
    dataset.fieldValue("fec_costo", proceso.getFecha_costo());
    dataset.fieldValue("fec_desde", proceso.getFec_desde());
    dataset.fieldValue("activo", proceso.isActivo());
    dataset.fieldValue("fec_hasta", proceso.getFec_hasta());
  }
}
