package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerPredioExcluido extends Operation { 

  public TraerPredioExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    PredioExcluido predioexcluido = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       predioexcluido = PredioExcluido.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       predioexcluido = PredioExcluido.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPredioExcluido = getDataSetPredioExcluido();
    if (predioexcluido != null) { 
        cargarRegistroPredioExcluido(datasetPredioExcluido, 
                         predioexcluido.getOIDInteger(),
                         predioexcluido.getCodigo(),
                         predioexcluido.getDescripcion(),
                         predioexcluido.isActivo());
    }
    writeCliente(datasetPredioExcluido);
  }

  private IDataSet getDataSetPredioExcluido() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPredioExcluido");
    dataset.fieldDef(new Field("id_predio", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroPredioExcluido(IDataSet dataset, 
                         Integer id_predio,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("id_predio", id_predio);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
