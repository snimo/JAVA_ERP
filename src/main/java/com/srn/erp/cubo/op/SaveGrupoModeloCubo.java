package com.srn.erp.cubo.op;

import com.srn.erp.cubo.bm.GrupoModeloCubo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoModeloCubo extends Operation {

  public SaveGrupoModeloCubo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TGrupoModeloCubo");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {

        GrupoModeloCubo grupoModeloCubo = GrupoModeloCubo.findByOid(dataset.getInteger("oid_grupo_modelo"),getSesion());
        grupoModeloCubo.setOID(dataset.getInteger("oid_grupo_modelo"));
        grupoModeloCubo.setCodigo(dataset.getString("codigo"));
        grupoModeloCubo.setDescripcion(dataset.getString("descripcion"));
        grupoModeloCubo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(grupoModeloCubo);
        dataset.next();
    }
  }

}
