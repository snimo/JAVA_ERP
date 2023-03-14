package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.SensacionCierreOportunidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSensacionCierreOportunidad extends Operation { 

  public TraerSensacionCierreOportunidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    SensacionCierreOportunidad sensacioncierreoportunidad = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       sensacioncierreoportunidad = SensacionCierreOportunidad.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       sensacioncierreoportunidad = SensacionCierreOportunidad.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetSensacionCierreOportunidad = getDataSetSensacionCierreOportunidad();
    if (sensacioncierreoportunidad != null) { 
        cargarRegistroSensacionCierreOportunidad(datasetSensacionCierreOportunidad, 
                         sensacioncierreoportunidad.getOIDInteger(),
                         sensacioncierreoportunidad.getCodigo(),
                         sensacioncierreoportunidad.getDescripcion(),
                         sensacioncierreoportunidad.isActivo());
    }
    writeCliente(datasetSensacionCierreOportunidad);
  }

  private IDataSet getDataSetSensacionCierreOportunidad() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TSensacionCierreOportunidad");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 10)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroSensacionCierreOportunidad(IDataSet dataset, 
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
