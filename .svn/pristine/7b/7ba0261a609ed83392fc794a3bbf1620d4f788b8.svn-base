package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.TipoAcuerdo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoAcuerdo extends Operation { 

  public TraerTipoAcuerdo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoAcuerdo tipoacuerdo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tipoacuerdo = TipoAcuerdo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tipoacuerdo = TipoAcuerdo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoAcuerdo = getDataSetTipoAcuerdo();
    if (tipoacuerdo != null) { 
        cargarRegistroTipoAcuerdo(datasetTipoAcuerdo, 
                         tipoacuerdo.getOIDInteger(),
                         tipoacuerdo.getCodigo(),
                         tipoacuerdo.getDescripcion(),
                         tipoacuerdo.getTipo_acuerdo(),
                         tipoacuerdo.isActivo());
    }
    writeCliente(datasetTipoAcuerdo);
  }

  private IDataSet getDataSetTipoAcuerdo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTiposAcuerdos");
    dataset.fieldDef(new Field("oid_tipo_acuerdo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("tipo_acuerdo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoAcuerdo(IDataSet dataset, 
                         Integer oid_tipo_acuerdo,
                         String codigo,
                         String descripcion,
                         String tipo_acuerdo,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_acuerdo", oid_tipo_acuerdo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("tipo_acuerdo", tipo_acuerdo);
    dataset.fieldValue("activo", activo);
  }
}
