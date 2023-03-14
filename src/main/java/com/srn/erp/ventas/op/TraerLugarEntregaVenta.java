package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerLugarEntregaVenta extends Operation { 

  public TraerLugarEntregaVenta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    LugarEntregaVenta lugarentregaventa = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       lugarentregaventa = LugarEntregaVenta.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       lugarentregaventa = LugarEntregaVenta.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetLugarEntregaVenta = getDataSetLugarEntregaVenta();
    if (lugarentregaventa != null) { 
        cargarRegistroLugarEntregaVenta(datasetLugarEntregaVenta, 
                         lugarentregaventa.getOIDInteger(),
                         lugarentregaventa.getCodigo(),
                         lugarentregaventa.getDescripcion(),
                         lugarentregaventa.isActivo());
    }
    writeCliente(datasetLugarEntregaVenta);
  }

  private IDataSet getDataSetLugarEntregaVenta() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TLugarEntregaVenta");
    dataset.fieldDef(new Field("oid_lugar_ent_vta", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 30)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroLugarEntregaVenta(IDataSet dataset, 
                         Integer oid_lugar_ent_vta,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_lugar_ent_vta", oid_lugar_ent_vta);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
