package com.srn.erp.general.op;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveLugarEmision extends Operation {

  public SaveLugarEmision() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TLugarEmision");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        LugarEmision lugaremision = LugarEmision.findByOid(dataset.getInteger("oid_lug_emi"),getSesion());
        lugaremision.setOID(dataset.getInteger("oid_lug_emi"));
        lugaremision.setLugemi(dataset.getInteger("lug_emi"));
        lugaremision.setDescripcion(dataset.getString("descripcion"));
        lugaremision.setUnidadorganizativa(UnidadOrganizativa.findByOidProxy(dataset.getInteger("oid_uni_org"),getSesion()));
        lugaremision.setActivo(dataset.getBoolean("activo"));
        addTransaccion(lugaremision);
        dataset.next();
    }
  }

}
