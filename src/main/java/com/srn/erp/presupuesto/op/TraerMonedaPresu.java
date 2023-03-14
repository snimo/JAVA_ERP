package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.MonedaPresu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMonedaPresu extends Operation { 

  public TraerMonedaPresu() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MonedaPresu monedapresu = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       monedapresu = MonedaPresu.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       monedapresu = MonedaPresu.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMonedaPresu = getDataSetMonedaPresu();
    if (monedapresu != null) { 
        cargarRegistroMonedaPresu(datasetMonedaPresu, 
                         monedapresu.getOIDInteger(),
                         monedapresu.getCodigo(),
                         monedapresu.getDescripcion(),
                         monedapresu.getSimbolo(),
                         monedapresu.isActivo());
    }
    writeCliente(datasetMonedaPresu);
  }

  private IDataSet getDataSetMonedaPresu() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMonedaPresu");
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("simbol", Field.STRING, 10)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMonedaPresu(IDataSet dataset, 
                         Integer oid_moneda,
                         String codigo,
                         String descripcion,
                         String simbol,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_moneda", oid_moneda);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("simbol", simbol);
    dataset.fieldValue("activo", activo);
  }
}
