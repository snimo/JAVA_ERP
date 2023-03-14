package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerMarcaExcluido extends Operation { 

  public TraerMarcaExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MarcaExcluido marcaexcluido = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       marcaexcluido = MarcaExcluido.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       marcaexcluido = MarcaExcluido.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMarcaExcluido = getDataSetMarcaExcluido();
    if (marcaexcluido != null) { 
        cargarRegistroMarcaExcluido(datasetMarcaExcluido, 
                         marcaexcluido.getOIDInteger(),
                         marcaexcluido.getCodigo(),
                         marcaexcluido.getDescripcion(),
                         marcaexcluido.isActivo());
    }
    writeCliente(datasetMarcaExcluido);
  }

  private IDataSet getDataSetMarcaExcluido() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMarcaExcluido");
    dataset.fieldDef(new Field("oid_marca", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMarcaExcluido(IDataSet dataset, 
                         Integer oid_marca,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_marca", oid_marca);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
