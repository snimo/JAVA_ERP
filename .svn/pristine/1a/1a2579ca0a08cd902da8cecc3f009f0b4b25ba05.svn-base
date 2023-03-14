package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerUniNegConciTar extends Operation { 

  public TraerUniNegConciTar() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    UniNegConciTar uninegconcitar = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       uninegconcitar = UniNegConciTar.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       uninegconcitar = UniNegConciTar.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetUniNegConciTar = getDataSetUniNegConciTar();
    if (uninegconcitar != null) { 
        cargarRegistroUniNegConciTar(datasetUniNegConciTar,uninegconcitar);
    }
    writeCliente(datasetUniNegConciTar);
  }

  private IDataSet getDataSetUniNegConciTar() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TUniNegConciTar");
    dataset.fieldDef(new Field("oid_uni_neg", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("acob_cta_tarj", Field.STRING, 50));
    dataset.fieldDef(new Field("acob_cta_tarj_c1", Field.STRING, 50));
    dataset.fieldDef(new Field("acob_cta_tarj_c2", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroUniNegConciTar(IDataSet dataset, 
                         UniNegConciTar uniNeg) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_uni_neg", uniNeg.getOIDInteger());
    dataset.fieldValue("descripcion", uniNeg.getDescripcion());
    dataset.fieldValue("oid_empresa", uniNeg.getEmpresa().getOIDInteger());
    dataset.fieldValue("activo", uniNeg.isActivo());
    dataset.fieldValue("acob_cta_tarj", uniNeg.getCtaTarjetaACobrar());
    dataset.fieldValue("acob_cta_tarj_c1", uniNeg.getCtaTarjetaACobrarC1());
    dataset.fieldValue("acob_cta_tarj_c2", uniNeg.getCtaTarjetaACobrarC2());
    
  }
}
