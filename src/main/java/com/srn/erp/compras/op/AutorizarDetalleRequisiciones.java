package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.RequisicionDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class AutorizarDetalleRequisiciones extends Operation {

  public AutorizarDetalleRequisiciones() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TDetalleRequisiciones");
    autorizarDetRequisiciones(dataset);
  }

  private void autorizarDetRequisiciones(IDataSet dataset) throws BaseException {
    dataset.first();
    while (!dataset.EOF()) {
      Integer oidReqDet = dataset.getInteger("oid_req_det");
      RequisicionDet requisicionDet = RequisicionDet.findByOid(oidReqDet,getSesion());
      requisicionDet.autorizar();
      addTransaccion(requisicionDet);  
      dataset.next();
    }
  }

}
