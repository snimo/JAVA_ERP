package com.srn.erp.cubo.op;

import com.srn.erp.cubo.bm.FactTableCubo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;
import framework.xlook.bm.Select;

public class TraerFactTableCubo extends Operation { 

  public TraerFactTableCubo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    FactTableCubo facttablecubo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       facttablecubo = FactTableCubo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       facttablecubo = FactTableCubo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetFactTableCubo = getDataSetFactTableCubo();
    if (facttablecubo != null) { 
        cargarRegistroFactTableCubo(datasetFactTableCubo, 
                         facttablecubo.getOIDInteger(),
                         facttablecubo.getCodigo(),
                         facttablecubo.getDescripcion(),
                         facttablecubo.getSelect(),
                         facttablecubo.getTipo_fact_table(),
                         facttablecubo.getNombre_oper(),
                         facttablecubo.isActivo());
    }
    writeCliente(datasetFactTableCubo);
  }

  private IDataSet getDataSetFactTableCubo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TFactTableCubo");
    dataset.fieldDef(new Field("oid_fact_table", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("oid_select", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_select", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_select", Field.STRING, 100));
    dataset.fieldDef(new Field("tipo_fact_table", Field.STRING, 20)); 
    dataset.fieldDef(new Field("nombre_oper", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroFactTableCubo(IDataSet dataset, 
                         Integer oid_fact_table,
                         String codigo,
                         String descripcion,
                         Select select,
                         String tipo_fact_table,
                         String nombre_oper,
                         Boolean activo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_fact_table", oid_fact_table);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_select", select.getOIDInteger());
    dataset.fieldValue("cod_select", select.getCodigo());
    dataset.fieldValue("desc_select", select.getDescripcion());
    dataset.fieldValue("tipo_fact_table", tipo_fact_table);
    dataset.fieldValue("nombre_oper", nombre_oper);
    dataset.fieldValue("activo", activo);
  }
}
