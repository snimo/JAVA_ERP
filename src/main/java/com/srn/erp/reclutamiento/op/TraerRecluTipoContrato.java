package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluTipoContrato;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluTipoContrato extends Operation { 

  public TraerRecluTipoContrato() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluTipoContrato reclutipocontrato = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclutipocontrato = RecluTipoContrato.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclutipocontrato = RecluTipoContrato.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluTipoContrato = getDataSetRecluTipoContrato();
    if (reclutipocontrato != null) { 
        cargarRegistroRecluTipoContrato(datasetRecluTipoContrato, 
                         reclutipocontrato.getOIDInteger(),
                         reclutipocontrato.getCodigo(),
                         reclutipocontrato.getDescripcion(),
                         reclutipocontrato.isActivo());
    }
    writeCliente(datasetRecluTipoContrato);
  }

  private IDataSet getDataSetRecluTipoContrato() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluTipoContrato");
    dataset.fieldDef(new Field("oid_tipo_contrato", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluTipoContrato(IDataSet dataset, 
                         Integer oid_tipo_contrato,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_contrato", oid_tipo_contrato);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
