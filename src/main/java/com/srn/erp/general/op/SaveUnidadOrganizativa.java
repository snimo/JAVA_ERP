package com.srn.erp.general.op;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.TipoUnidadOrganizativa;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveUnidadOrganizativa extends Operation {

  public SaveUnidadOrganizativa() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TUnidadOrganizativa");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        UnidadOrganizativa unidadorganizativa = UnidadOrganizativa.findByOid(dataset.getInteger("oid_uni_org"),getSesion());
        unidadorganizativa.setOID(dataset.getInteger("oid_uni_org"));
        unidadorganizativa.setCodigo(dataset.getString("codigo"));
        unidadorganizativa.setDescripcion(dataset.getString("descripcion"));
        unidadorganizativa.setTipounidadorganizativa(TipoUnidadOrganizativa.findByOidProxy(dataset.getInteger("oid_tipo_uni_org"),getSesion()));
        unidadorganizativa.setActivo(dataset.getBoolean("activo"));
        unidadorganizativa.setSucursal(Sucursal.findByOidProxy(dataset.getInteger("oid_sucursal"),getSesion()));
        addTransaccion(unidadorganizativa);
        dataset.next();
    }
  }

}
