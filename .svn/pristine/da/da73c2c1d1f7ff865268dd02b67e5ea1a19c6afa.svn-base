package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.GrupoCondPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoCondPago extends Operation {

  public SaveGrupoCondPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TGrupoCondPago");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        GrupoCondPago grupocondpago = GrupoCondPago.findByOid(dataset.getInteger("oid_grupo_cp"),getSesion());
        grupocondpago.setOID(dataset.getInteger("oid_grupo_cp"));
        grupocondpago.setCodigo(dataset.getString("codigo"));
        grupocondpago.setDescripcion(dataset.getString("descripcion"));
        grupocondpago.setActivo(dataset.getBoolean("activo"));
        addTransaccion(grupocondpago);
        dataset.next();
    }
  }

}
