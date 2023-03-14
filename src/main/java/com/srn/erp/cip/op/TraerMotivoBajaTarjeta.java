package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerMotivoBajaTarjeta extends Operation { 

  public TraerMotivoBajaTarjeta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoBajaTarjeta motivobajatarjeta = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivobajatarjeta = MotivoBajaTarjeta.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivobajatarjeta = MotivoBajaTarjeta.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivoBajaTarjeta = getDataSetMotivoBajaTarjeta();
    if (motivobajatarjeta != null) { 
        cargarRegistroMotivoBajaTarjeta(datasetMotivoBajaTarjeta,motivobajatarjeta);
    }
    writeCliente(datasetMotivoBajaTarjeta);
  }

  private IDataSet getDataSetMotivoBajaTarjeta() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoBajaTarjeta");
    dataset.fieldDef(new Field("oid_mot_baj_tar", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotivoBajaTarjeta(IDataSet dataset, 
                          MotivoBajaTarjeta motivo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_mot_baj_tar", motivo.getOIDInteger());
    dataset.fieldValue("codigo", motivo.getCodigo());
    dataset.fieldValue("descripcion", motivo.getDescripcion());
    dataset.fieldValue("activo", motivo.isActivo());
  }
}
