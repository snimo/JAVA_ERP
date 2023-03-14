package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.Caja;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCajasOperativasActivas extends Operation {

  public TraerCajasOperativasActivas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetCaja = getDataSetCaja();
    Iterator iterCajas = 
    	Caja.getCajasOperativasActivo(this.getSesion()).iterator();
    while (iterCajas.hasNext()) {
    	Caja caja = (Caja) iterCajas.next();
    	cargarRegistroCaja(datasetCaja, caja);
    }
    writeCliente(datasetCaja);
  }

  private IDataSet getDataSetCaja() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCajasOperativas");
    dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_caja", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_caja", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroCaja(IDataSet dataset,
                         Caja caja) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_caja", caja.getOIDInteger());
    dataset.fieldValue("cod_caja", caja.getCodigo());
    dataset.fieldValue("desc_caja", caja.getDescripcion());
  }
}
