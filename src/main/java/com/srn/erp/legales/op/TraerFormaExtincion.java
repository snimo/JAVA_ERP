package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerFormaExtincion extends Operation { 

  public TraerFormaExtincion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    FormaExtincion formaextincion = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       formaextincion = FormaExtincion.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       formaextincion = FormaExtincion.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetFormaExtincion = getDataSetFormaExtincion();
    if (formaextincion != null) { 
        cargarRegistroFormaExtincion(datasetFormaExtincion, 
                         formaextincion.getOIDInteger(),
                         formaextincion.getCodigo(),
                         formaextincion.getDescripcion(),
                         formaextincion.isActivo());
    }
    writeCliente(datasetFormaExtincion);
  }

  private IDataSet getDataSetFormaExtincion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TFormaExtincion");
    dataset.fieldDef(new Field("oid_forma_extincion", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroFormaExtincion(IDataSet dataset, 
                         Integer oid_forma_exti,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_forma_extincion", oid_forma_exti);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
