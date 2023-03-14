package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.TipoPresupuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoPresupuesto extends Operation { 

  public TraerTipoPresupuesto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoPresupuesto tipopresupuesto = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tipopresupuesto = TipoPresupuesto.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tipopresupuesto = TipoPresupuesto.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoPresupuesto = getDataSetTipoPresupuesto();
    if (tipopresupuesto != null) { 
        cargarRegistroTipoPresupuesto(datasetTipoPresupuesto, 
                         tipopresupuesto.getOIDInteger(),
                         tipopresupuesto.getCodigo(),
                         tipopresupuesto.getDescripcion(),
                         tipopresupuesto.isActivo());
    }
    writeCliente(datasetTipoPresupuesto);
  }

  private IDataSet getDataSetTipoPresupuesto() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoPresupuesto");
    dataset.fieldDef(new Field("oid_tipo_presu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoPresupuesto(IDataSet dataset, 
                         Integer oid_tipo_presu,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_presu", oid_tipo_presu);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
