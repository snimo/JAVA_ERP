package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerFormaEntrega extends Operation { 

  public TraerFormaEntrega() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    FormaEntrega formaentrega = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       formaentrega = FormaEntrega.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       formaentrega = FormaEntrega.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetFormaEntrega = getDataSetFormaEntrega();
    if (formaentrega != null) { 
        cargarRegistroFormaEntrega(datasetFormaEntrega, 
                         formaentrega.getOIDInteger(),
                         formaentrega.getCodigo(),
                         formaentrega.getDescripcion(),
                         formaentrega.isActivo());
    }
    writeCliente(datasetFormaEntrega);
  }

  private IDataSet getDataSetFormaEntrega() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TFormaEntrega");
    dataset.fieldDef(new Field("oid_forma_entrega", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroFormaEntrega(IDataSet dataset, 
                         Integer oid_forma_entrega,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_forma_entrega", oid_forma_entrega);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
