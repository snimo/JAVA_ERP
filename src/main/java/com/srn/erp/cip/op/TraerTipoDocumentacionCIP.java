package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.TipoDocumentacionCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoDocumentacionCIP extends Operation { 

  public TraerTipoDocumentacionCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoDocumentacionCIP tipodocumentacioncip = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tipodocumentacioncip = TipoDocumentacionCIP.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tipodocumentacioncip = TipoDocumentacionCIP.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoDocumentacionCIP = getDataSetTipoDocumentacionCIP();
    if (tipodocumentacioncip != null) { 
        cargarRegistroTipoDocumentacionCIP(datasetTipoDocumentacionCIP, 
                         tipodocumentacioncip.getOIDInteger(),
                         tipodocumentacioncip.getCodigo(),
                         tipodocumentacioncip.getDescripcion(),
                         tipodocumentacioncip.isActivo());
    }
    writeCliente(datasetTipoDocumentacionCIP);
  }

  private IDataSet getDataSetTipoDocumentacionCIP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoDocumentacionCIP");
    dataset.fieldDef(new Field("oid_tipo_docu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoDocumentacionCIP(IDataSet dataset, 
                         Integer oid_tipo_docu,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_docu", oid_tipo_docu);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
