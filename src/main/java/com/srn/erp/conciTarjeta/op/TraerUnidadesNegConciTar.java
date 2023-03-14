package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.UniNegConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerUnidadesNegConciTar extends Operation { 

  public TraerUnidadesNegConciTar() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet datasetUniNegConciTar = getDataSetUniNegConciTar();
    Iterator iterUniNeg =
    	UniNegConciTar.getAllActivos(this.getSesion()).iterator();
    while (iterUniNeg.hasNext()) {
    	UniNegConciTar uniNeg = (UniNegConciTar) iterUniNeg.next();
    	cargarRegistroUniNegConciTar(datasetUniNegConciTar, uniNeg);
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
    return dataset;
  }

  private void cargarRegistroUniNegConciTar(IDataSet dataset, 
                         UniNegConciTar uniNeg) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_uni_neg", uniNeg.getOIDInteger());
    dataset.fieldValue("descripcion", uniNeg.getDescripcion());
    dataset.fieldValue("oid_empresa", uniNeg.getEmpresa().getOIDInteger());
    dataset.fieldValue("activo", uniNeg.isActivo());
  }
}
