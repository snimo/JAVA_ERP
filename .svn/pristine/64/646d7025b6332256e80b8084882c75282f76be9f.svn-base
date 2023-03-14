package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoDeposito;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadoStockDeposito extends Operation {

  public TraerEstadoStockDeposito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetEstadosDeposito = getDataSetEstadoStock();
    Deposito deposito =  Deposito.findByOid(mapaDatos.getInteger("oid"),getSesion());
    Iterator iterEstadosDeposito = deposito.getEstadosDeposito().iterator();
    while (iterEstadosDeposito.hasNext()) {
      EstadoDeposito estadoDeposito = (EstadoDeposito) iterEstadosDeposito.next();
      cargarEstadoStock(datasetEstadosDeposito,estadoDeposito);
    }
    writeCliente(datasetEstadosDeposito);
  }

  private IDataSet getDataSetEstadoStock() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEstadosDeposito");
    dataset.fieldDef(new Field("oid_estado_depo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_deposito",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_estado_stock",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_estado_stock",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_estado_stock",Field.STRING, 100));
    dataset.fieldDef(new Field("allow_saldo_neg",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_agrup_estado",Field.INTEGER, 0));
    
    return dataset;
  }

  private void cargarEstadoStock(IDataSet dataset,
                                 EstadoDeposito estadoDeposito) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_estado_depo", estadoDeposito.getOIDInteger());
    dataset.fieldValue("oid_deposito",estadoDeposito.getDeposito().getOIDInteger());
    dataset.fieldValue("oid_estado_stock",estadoDeposito.getEstado_stock().getOIDInteger());
    dataset.fieldValue("cod_estado_stock",estadoDeposito.getEstado_stock().getCodigo());
    dataset.fieldValue("desc_estado_stock",estadoDeposito.getEstado_stock().getDescripcion());
    dataset.fieldValue("allow_saldo_neg",estadoDeposito.isAllow_saldo_neg());
    dataset.fieldValue("activo", new Boolean(true));
    dataset.fieldValue("oid_agrup_estado",estadoDeposito.getAgrupadorEstadoStock().getOIDInteger());
  }
}
