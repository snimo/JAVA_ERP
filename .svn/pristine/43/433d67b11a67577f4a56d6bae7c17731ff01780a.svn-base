package com.srn.erp.pagos.op;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CatRetIB;
import com.srn.erp.pagos.bm.RetCabIB;
import com.srn.erp.pagos.bm.RetCabIBDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTablaRetIB extends Operation {

  public SaveTablaRetIB() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TRetCabIB");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        RetCabIB retcabib = RetCabIB.findByOid(dataset.getInteger("oid_ret_cab_ib"),getSesion());
        retcabib.setOID(dataset.getInteger("oid_ret_cab_ib"));
        retcabib.setCatretIB(CatRetIB.findByOidProxy(dataset.getInteger("oid_cat_ret_ib"),getSesion()));
        retcabib.setConcimpu(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu"),getSesion()));
        retcabib.setMontonoimpo(dataset.getMoney("monto_no_impo"));
        retcabib.setMontoretmin(dataset.getMoney("monto_ret_min"));
        retcabib.setFecvigdesde(dataset.getDate("fec_vig_desde"));
        retcabib.setActivo(dataset.getBoolean("activo"));
        IDataSet dsDetalles = dataset.getDataSet("TRetCabIBDet");
        dsDetalles.first();
        while (!dsDetalles.EOF()) {
          RetCabIBDet retCabIBDet = RetCabIBDet.findByOid(dsDetalles.getInteger("oid_ret_det_ib"),getSesion());
          retCabIBDet.setRetcabib(retcabib);
          retCabIBDet.setMontodesde(dsDetalles.getMoney("monto_desde"));
          retCabIBDet.setMontohasta(dsDetalles.getMoney("monto_hasta"));
          retCabIBDet.setPorc(dsDetalles.getMoney("porc"));
          retCabIBDet.setMontofijo(dsDetalles.getMoney("monto_fijo"));
          retcabib.addDetalleRetIB(retCabIBDet);
          dsDetalles.next();
        }

        addTransaccion(retcabib);
        dataset.next();
    }
  }

}
