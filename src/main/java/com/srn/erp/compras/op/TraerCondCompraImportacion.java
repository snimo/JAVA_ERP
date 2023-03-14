package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CondCompraImportacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCondCompraImportacion extends Operation { 

  public TraerCondCompraImportacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    CondCompraImportacion condcompraimportacion = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       condcompraimportacion = CondCompraImportacion.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       condcompraimportacion = CondCompraImportacion.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCondCompraImportacion = getDataSetCondCompraImportacion();
    if (condcompraimportacion != null) { 
        cargarRegistroCondCompraImportacion(datasetCondCompraImportacion, 
                         condcompraimportacion.getOIDInteger(),
                         condcompraimportacion.getCodigo(),
                         condcompraimportacion.getDescripcion(),
                         condcompraimportacion.isActivo());
    }
    writeCliente(datasetCondCompraImportacion);
  }

  private IDataSet getDataSetCondCompraImportacion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCondCompraImportacion");
    dataset.fieldDef(new Field("oid_cond_cpra_imp", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroCondCompraImportacion(IDataSet dataset, 
                         Integer oid_cond_cpra_imp,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_cond_cpra_imp", oid_cond_cpra_imp);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
