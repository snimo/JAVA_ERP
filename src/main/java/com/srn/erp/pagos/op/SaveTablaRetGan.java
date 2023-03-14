package com.srn.erp.pagos.op;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CatRetGan;
import com.srn.erp.pagos.bm.RetCabGan;
import com.srn.erp.pagos.bm.RetCabGanDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTablaRetGan extends Operation {

  public SaveTablaRetGan() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TRetCabGan");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        RetCabGan retcabgan = RetCabGan.findByOid(dataset.getInteger("oid_ret_cab_gan"),getSesion());
        retcabgan.setOID(dataset.getInteger("oid_ret_cab_gan"));
        retcabgan.setCatretgan(CatRetGan.findByOidProxy(dataset.getInteger("oid_cat_ret_gan"),getSesion()));
        retcabgan.setConcimpu(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu"),getSesion()));
        retcabgan.setMontonoimpo(dataset.getMoney("monto_no_impo"));
        retcabgan.setMontoretmin(dataset.getMoney("monto_ret_min"));
        retcabgan.setFecvigdesde(dataset.getDate("fec_vig_desde"));
        retcabgan.setActivo(dataset.getBoolean("activo"));

        IDataSet dsDetalles = dataset.getDataSet("TRetCabGanDet");
        dsDetalles.first();
        while (!dsDetalles.EOF()) {
          RetCabGanDet retCabGanDet = RetCabGanDet.findByOid(dsDetalles.getInteger("oid_ret_det_gan"),getSesion());
          retCabGanDet.setRetcabgan(retcabgan);
          retCabGanDet.setMontodesde(dsDetalles.getMoney("monto_desde"));
          retCabGanDet.setMontohasta(dsDetalles.getMoney("monto_hasta"));
          retCabGanDet.setPorc(dsDetalles.getMoney("porc"));
          retCabGanDet.setMontofijo(dsDetalles.getMoney("monto_fijo"));
          retcabgan.addDetalleRetGan(retCabGanDet);
          dsDetalles.next();
        }


        addTransaccion(retcabgan);
        dataset.next();
    }
  }

}
