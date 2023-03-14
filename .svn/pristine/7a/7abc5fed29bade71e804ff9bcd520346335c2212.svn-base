package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.PeligrosidadExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPeligrosidadExcluido extends Operation { 

  public TraerPeligrosidadExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    PeligrosidadExcluido peligrosidadexcluido = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       peligrosidadexcluido = PeligrosidadExcluido.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       peligrosidadexcluido = PeligrosidadExcluido.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPeligrosidadExcluido = getDataSetPeligrosidadExcluido();
    if (peligrosidadexcluido != null) { 
        cargarRegistroPeligrosidadExcluido(datasetPeligrosidadExcluido, 
                         peligrosidadexcluido.getOIDInteger(),
                         peligrosidadexcluido.getCodigo(),
                         peligrosidadexcluido.getDescripcion(),
                         peligrosidadexcluido.getGrado(),
                         peligrosidadexcluido.isActivo(),
                         peligrosidadexcluido.getColor()
                         );
    }
    writeCliente(datasetPeligrosidadExcluido);
  }

  private IDataSet getDataSetPeligrosidadExcluido() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPeligrosidadExcluido");
    dataset.fieldDef(new Field("oid_peligrosidad", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("grado", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("color", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroPeligrosidadExcluido(IDataSet dataset, 
                         Integer oid_peligrosidad,
                         String codigo,
                         String descripcion,
                         Integer grado,
                         Boolean activo,
                         String color) {
    dataset.append(); 
    dataset.fieldValue("oid_peligrosidad", oid_peligrosidad);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("grado", grado);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("color", color);
  }
}
