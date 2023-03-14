package com.srn.erp.presupuesto.op;


import com.srn.erp.presupuesto.bm.Metrica;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMetrica extends Operation { 

  public TraerMetrica() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    Metrica metrica = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       metrica = Metrica.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       metrica = Metrica.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMetrica = getDataSetMetrica();
    if (metrica != null) { 
        cargarRegistroMetrica(datasetMetrica, 
                         metrica.getOIDInteger(),
                         metrica.getCodigo(),
                         metrica.getDescripcion(),
                         metrica.getTipo(),
                         metrica.getCant_decimales(),
                         metrica.getMascara_display(),
                         metrica.isActivo());
    }
    writeCliente(datasetMetrica);
  }

  private IDataSet getDataSetMetrica() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMetrica");
    dataset.fieldDef(new Field("oid_metrica", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("tipo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("cant_decimales", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("mascara_display", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMetrica(IDataSet dataset, 
                         Integer oid_metrica,
                         String codigo,
                         String descripcion,
                         String tipo,
                         Integer cant_decimales,
                         String mascara_display,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_metrica", oid_metrica);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("tipo", tipo);
    dataset.fieldValue("cant_decimales", cant_decimales);
    dataset.fieldValue("mascara_display", mascara_display);
    dataset.fieldValue("activo", activo);
  }
}
