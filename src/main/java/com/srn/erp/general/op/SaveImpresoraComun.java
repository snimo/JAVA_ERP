package com.srn.erp.general.op;

import com.srn.erp.general.bm.ImpresoraComun;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveImpresoraComun extends Operation {

  public SaveImpresoraComun() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TImpresoraComun");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ImpresoraComun impresoracomun = ImpresoraComun.findByOid(dataset.getInteger("oid_imp_comun"),getSesion());
        impresoracomun.setOID(dataset.getInteger("oid_imp_comun"));
        impresoracomun.setCodigo(dataset.getString("codigo"));
        impresoracomun.setDescripcion(dataset.getString("descripcion"));
        impresoracomun.setImpresora_sistema(dataset.getString("impresora_sistema"));
        impresoracomun.setActivo(dataset.getBoolean("activo"));
        impresoracomun.setUnidadOrganizativa(UnidadOrganizativa.findByOidProxy(dataset.getInteger("oid_uni_org"),getSesion()));
        addTransaccion(impresoracomun);
        dataset.next();
    }
  }

}
