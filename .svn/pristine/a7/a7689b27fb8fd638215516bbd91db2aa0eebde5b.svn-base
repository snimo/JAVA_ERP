package com.srn.erp.general.op;

import com.srn.erp.general.bm.ImpresoraFiscal;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveImpresoraFiscal extends Operation {

  public SaveImpresoraFiscal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TImpresoraFiscal");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ImpresoraFiscal impresorafiscal = ImpresoraFiscal.findByOid(dataset.getInteger("oid_imp_fiscal"),getSesion());
        impresorafiscal.setOID(dataset.getInteger("oid_imp_fiscal"));
        impresorafiscal.setCodigo(dataset.getString("codigo"));
        impresorafiscal.setDescripcion(dataset.getString("descripcion"));
        impresorafiscal.setCompo_imp_fiscal(dataset.getString("compo_imp_fiscal"));
        impresorafiscal.setActivo(dataset.getBoolean("activo"));
        impresorafiscal.setUnidadOrganizativa(UnidadOrganizativa.findByOidProxy(dataset.getInteger("oid_uni_org"),getSesion()));
        impresorafiscal.setPuerto(dataset.getInteger("puerto"));
        impresorafiscal.setBaudios(dataset.getInteger("baudios"));
        impresorafiscal.setDriver(dataset.getString("driver"));
        impresorafiscal.setComportamiento(dataset.getString("compo_impresion"));
        impresorafiscal.setPathGenArchivo(dataset.getString("path_gen_arch_imp"));
        
        addTransaccion(impresorafiscal);
        dataset.next();
    }
  }

}
