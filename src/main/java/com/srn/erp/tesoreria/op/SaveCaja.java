package com.srn.erp.tesoreria.op;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.Caja;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCaja extends Operation {

  public SaveCaja() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCaja");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Caja caja = Caja.findByOid(dataset.getInteger("oid_caja"),getSesion());
        caja.setOID(dataset.getInteger("oid_caja"));
        caja.setCodigo(dataset.getString("codigo"));
        caja.setDescripcion(dataset.getString("descripcion"));
        caja.setUnidadorganizativa(UnidadOrganizativa.findByOidProxy(dataset.getInteger("oid_uni_org"),getSesion()));
        caja.setCompo(dataset.getString("compo"));
        caja.setActivo(dataset.getBoolean("activo"));
        caja.setTipoCierreApertura(dataset.getString("tipo_cie_aper"));
        addTransaccion(caja);
        dataset.next();
    }
  }

}
