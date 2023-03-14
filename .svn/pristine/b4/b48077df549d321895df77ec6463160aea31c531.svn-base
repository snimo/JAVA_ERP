package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerGrupoDetalleVenta extends Operation { 

  public TraerGrupoDetalleVenta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoDetalleVenta grupodetalleventa = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupodetalleventa = GrupoDetalleVenta.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupodetalleventa = GrupoDetalleVenta.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoDetalleVenta = getDataSetGrupoDetalleVenta();
    if (grupodetalleventa != null) { 
        cargarRegistroGrupoDetalleVenta(datasetGrupoDetalleVenta, 
                         grupodetalleventa.getOIDInteger(),
                         grupodetalleventa.getCodigo(),
                         grupodetalleventa.getDescripcion(),
                         grupodetalleventa.isActivo());
    }
    writeCliente(datasetGrupoDetalleVenta);
  }

  private IDataSet getDataSetGrupoDetalleVenta() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoDetalleVenta");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoDetalleVenta(IDataSet dataset, 
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
