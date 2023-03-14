package com.srn.erp.bienUso.op;

import com.srn.erp.bienUso.bm.SistemaValuacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSistemaValuacion extends Operation { 

  public TraerSistemaValuacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    SistemaValuacion sistemavaluacion = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       sistemavaluacion = SistemaValuacion.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       sistemavaluacion = SistemaValuacion.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetSistemaValuacion = getDataSetSistemaValuacion();
    if (sistemavaluacion != null) { 
        cargarRegistroSistemaValuacion(datasetSistemaValuacion, 
                         sistemavaluacion);
    }
    writeCliente(datasetSistemaValuacion);
  }

  private IDataSet getDataSetSistemaValuacion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TSistemaValuacion");
    dataset.fieldDef(new Field("oid_sist_val", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30)); 
    dataset.fieldDef(new Field("tipo_amort", Field.STRING, 4)); 
    dataset.fieldDef(new Field("contable", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("aju_inf", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_indice", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroSistemaValuacion(IDataSet dataset,SistemaValuacion sistVal) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_sist_val", sistVal.getOIDInteger());
    dataset.fieldValue("codigo", sistVal.getCodigo());
    dataset.fieldValue("descripcion", sistVal.getDescripcion());
    dataset.fieldValue("tipo_amort", sistVal.getTipo_amort());
    dataset.fieldValue("contable", sistVal.isContable());
    dataset.fieldValue("aju_inf", sistVal.isAju_inf());
    dataset.fieldValue("oid_moneda", sistVal.getMoneda().getOIDInteger());
    if (sistVal.getIndice()!=null)
      dataset.fieldValue("oid_indice", sistVal.getIndice().getOIDInteger());
    else
      dataset.fieldValue("oid_indice", 0);
    dataset.fieldValue("activo", sistVal.isActivo());
  }
}
