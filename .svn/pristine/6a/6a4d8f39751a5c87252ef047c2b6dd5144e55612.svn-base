package com.srn.erp.pagos.op;

import com.srn.erp.pagos.bm.PeriRetGan;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.Validar;
import framework.request.bl.XML.IDataSet;

public class SavePeriRetGan extends Operation {

  public SavePeriRetGan() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TPeriRetGan");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        PeriRetGan periretgan = PeriRetGan.findByOid(dataset.getInteger("oid_peri_ret_gan"),getSesion());
        periretgan.setOID(dataset.getInteger("oid_peri_ret_gan"));
        periretgan.setFecdesde(dataset.getDate("fec_desde"));
        periretgan.setFechasta(dataset.getDate("fec_hasta"));
        periretgan.setDescripcion(dataset.getString("descripcion"));
        Validar.noNulo(dataset.getDate("fec_desde"),"Debe ingresar la fecha desde");
        Validar.noNulo(dataset.getDate("fec_hasta"),"Debe ingresar la fecha hasta");
        periretgan.setCodinterno(Fecha.getddmmyyyy(dataset.getDate("fec_desde"))+
                                 "_"+
                                 Fecha.getddmmyyyy(dataset.getDate("fec_hasta")));
        periretgan.setActivo(dataset.getBoolean("activo"));

        addTransaccion(periretgan);
        dataset.next();
    }
  }

}
