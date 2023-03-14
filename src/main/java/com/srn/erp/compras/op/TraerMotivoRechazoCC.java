package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.MotivoRechazoCC;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivoRechazoCC extends Operation {

  public TraerMotivoRechazoCC() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    MotivoRechazoCC motivoRechazoCC = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       motivoRechazoCC = MotivoRechazoCC.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       motivoRechazoCC = MotivoRechazoCC.findByCodigo(codigo, getSesion());
    }

    IDataSet dsMotivoRechazo = getDataSetMotivoRechazo();
    if (motivoRechazoCC != null) 
    	cargarRegistroMotivoRechazo(dsMotivoRechazo,motivoRechazoCC);    
    writeCliente(dsMotivoRechazo);
    
  }

  private IDataSet getDataSetMotivoRechazo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TMotivoRechazoCC");
    dataset.fieldDef(new Field("oid_mot_rec_cc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroMotivoRechazo(IDataSet dataset,
                         MotivoRechazoCC motivoRechazoCC) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_mot_rec_cc", motivoRechazoCC.getOIDInteger());
    dataset.fieldValue("codigo", motivoRechazoCC.getCodigo());
    dataset.fieldValue("descripcion", motivoRechazoCC.getDescripcion());
    dataset.fieldValue("activo", motivoRechazoCC.isActivo());
  }

  
}
