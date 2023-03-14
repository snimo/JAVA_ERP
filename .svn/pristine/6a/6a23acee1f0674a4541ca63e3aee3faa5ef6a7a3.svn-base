package com.srn.erp.cubo.op;

import com.srn.erp.cubo.bm.DimensionCubo;
import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;
import framework.xlook.bm.Select;

public class TraerDimensionCubo extends Operation { 

  public TraerDimensionCubo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    DimensionCubo dimensioncubo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       dimensioncubo = DimensionCubo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       dimensioncubo = DimensionCubo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetDimensionCubo = getDataSetDimensionCubo();
    if (dimensioncubo != null) { 
        cargarRegistroDimensionCubo(datasetDimensionCubo, 
                         dimensioncubo.getOIDInteger(),
                         dimensioncubo.getCodigo(),
                         dimensioncubo.getDescripcion(),
                         dimensioncubo.getTipo_dimension(),
                         dimensioncubo.getSelect(),
                         dimensioncubo.getNombre_oper(),
                         dimensioncubo.getClasificador_entidad(),
                         dimensioncubo.isActivo());
    }
    writeCliente(datasetDimensionCubo);
  }

  private IDataSet getDataSetDimensionCubo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TDimensionCubo");
    dataset.fieldDef(new Field("oid_dimension", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 30)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("tipo_dimension", Field.STRING, 20)); 
    dataset.fieldDef(new Field("oid_select", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_select", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_select", Field.STRING, 50));
    dataset.fieldDef(new Field("nombre_oper", Field.STRING, 50)); 
    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_clasif_ent", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_clasif_ent", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroDimensionCubo(IDataSet dataset, 
                         Integer oid_dimension,
                         String codigo,
                         String descripcion,
                         String tipo_dimension,
                         Select select,
                         String nombre_oper,
                         ClasificadorEntidad clasificador,
                         Boolean activo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_dimension", oid_dimension);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("tipo_dimension", tipo_dimension);
    if (select!=null) {
      dataset.fieldValue("oid_select", select.getOIDInteger());
      dataset.fieldValue("cod_select", select.getCodigo());
      dataset.fieldValue("desc_select", select.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_select", 0);
      dataset.fieldValue("cod_select", "");
      dataset.fieldValue("desc_select", "");    	
    }
    dataset.fieldValue("nombre_oper", nombre_oper);
    if (clasificador!=null) {
      dataset.fieldValue("oid_clasif_ent", clasificador.getOIDInteger());
      dataset.fieldValue("cod_clasif_ent", clasificador.getCodigo());
      dataset.fieldValue("desc_clasif_ent", clasificador.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_clasif_ent", 0);
      dataset.fieldValue("cod_clasif_ent", "");
      dataset.fieldValue("desc_clasif_ent", "");
    }
    dataset.fieldValue("activo", activo);
  }
  
}
