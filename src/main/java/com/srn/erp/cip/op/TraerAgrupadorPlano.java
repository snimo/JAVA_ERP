package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.AgrupadorPlano;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAgrupadorPlano extends Operation { 

  public TraerAgrupadorPlano() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    AgrupadorPlano agrupadorplano = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       agrupadorplano = AgrupadorPlano.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       agrupadorplano = AgrupadorPlano.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetAgrupadorPlano = getDataSetAgrupadorPlano();
    if (agrupadorplano != null) { 
        cargarRegistroAgrupadorPlano(datasetAgrupadorPlano, 
                         agrupadorplano.getOIDInteger(),
                         agrupadorplano.getCodigo(),
                         agrupadorplano.getDescripcion(),
                         agrupadorplano.getOrden(),
                         agrupadorplano.isActivo());
    }
    writeCliente(datasetAgrupadorPlano);
  }

  private IDataSet getDataSetAgrupadorPlano() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAgrupadorPlano");
    dataset.fieldDef(new Field("oid_agrup_plano", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroAgrupadorPlano(IDataSet dataset, 
                         Integer oid_agrup_plano,
                         String codigo,
                         String descripcion,
                         Integer orden,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_agrup_plano", oid_agrup_plano);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("orden", orden);
    dataset.fieldValue("activo", activo);
  }
}
