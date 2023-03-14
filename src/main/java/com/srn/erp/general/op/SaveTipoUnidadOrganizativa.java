package com.srn.erp.general.op;

import com.srn.erp.general.bm.TipoUnidadOrganizativa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoUnidadOrganizativa extends Operation {

  public SaveTipoUnidadOrganizativa() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTipoUnidadOrganizativa");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        TipoUnidadOrganizativa tipounidadorganizativa = TipoUnidadOrganizativa.findByOid(dataset.getInteger("oid_tipo_uni_org"),getSesion());
        tipounidadorganizativa.setOID(dataset.getInteger("oid_tipo_uni_org"));
        tipounidadorganizativa.setCodigo(dataset.getString("codigo"));
        tipounidadorganizativa.setDescripcion(dataset.getString("descripcion"));
        tipounidadorganizativa.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipounidadorganizativa);
        dataset.next();
    }
  }

}
