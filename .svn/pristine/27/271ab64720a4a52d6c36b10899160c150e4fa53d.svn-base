package com.srn.erp.pagos.op;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CatRetIVA;
import com.srn.erp.pagos.bm.RetCabIVA;
import com.srn.erp.pagos.bm.RetCabIVADet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTablaRetIVA extends Operation {

  public SaveTablaRetIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TRetCabIVA");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        RetCabIVA retcabiva = RetCabIVA.findByOid(dataset.getInteger("oid_ret_cab_iva"),getSesion());
        retcabiva.setOID(dataset.getInteger("oid_ret_cab_iva"));
        retcabiva.setCatretiva(CatRetIVA.findByOidProxy(dataset.getInteger("oid_cat_ret_iva"),getSesion()));
        retcabiva.setConcimpu(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu"),getSesion()));
        retcabiva.setMontonoimpo(dataset.getMoney("monto_no_impo"));
        retcabiva.setMontoretmin(dataset.getMoney("monto_ret_min"));
        retcabiva.setFecvigdesde(dataset.getDate("fec_vig_desde"));
        retcabiva.setActivo(dataset.getBoolean("activo"));

        IDataSet dsDetalles = dataset.getDataSet("TRetCabIVADet");
        dsDetalles.first();
        while (!dsDetalles.EOF()) {
          RetCabIVADet retCabIVADet = RetCabIVADet.findByOid(dsDetalles.getInteger("oid_ret_det_iva"),getSesion());
          retCabIVADet.setRetcabiva(retcabiva);
          retCabIVADet.setMontodesde(dsDetalles.getMoney("monto_desde"));
          retCabIVADet.setMontohasta(dsDetalles.getMoney("monto_hasta"));
          retCabIVADet.setPorc(dsDetalles.getMoney("porc"));
          retCabIVADet.setMontofijo(dsDetalles.getMoney("monto_fijo"));
          retcabiva.addDetalleRetIVA(retCabIVADet);
          dsDetalles.next();
        }

        addTransaccion(retcabiva);
        dataset.next();
    }
  }

}
