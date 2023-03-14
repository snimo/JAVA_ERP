package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.MotivoRechazoCC;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoRechazoCC extends Operation {

  public SaveMotivoRechazoCC() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TMotivoRechazoCC");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        MotivoRechazoCC motivoRechazoCC = MotivoRechazoCC.findByOid(dataset.getInteger("oid_mot_rec_cc"),getSesion());
        motivoRechazoCC.setOID(dataset.getInteger("oid_mot_rec_cc"));
        motivoRechazoCC.setCodigo(dataset.getString("codigo"));
        motivoRechazoCC.setDescripcion(dataset.getString("descripcion"));
        motivoRechazoCC.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivoRechazoCC);
        dataset.next();
    }
  }

}
