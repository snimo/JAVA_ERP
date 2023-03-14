package com.srn.erp.pagos.op;

import com.srn.erp.pagos.bm.PeriRetIVA;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.Validar;
import framework.request.bl.XML.IDataSet;

public class SavePeriRetIVA extends Operation {

  public SavePeriRetIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TPeriRetIVA");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        PeriRetIVA periretiva = PeriRetIVA.findByOid(dataset.getInteger("oid_peri_ret_iva"),getSesion());
        periretiva.setOID(dataset.getInteger("oid_peri_ret_iva"));
        periretiva.setFecdesde(dataset.getDate("fec_desde"));
        periretiva.setFechasta(dataset.getDate("fec_hasta"));
        periretiva.setDescripcion(dataset.getString("descripcion"));
        Validar.noNulo(dataset.getDate("fec_desde"),"Debe ingresar la fecha desde");
        Validar.noNulo(dataset.getDate("fec_hasta"),"Debe ingresar la fecha hasta");
        periretiva.setCodinterno(Fecha.getddmmyyyy(dataset.getDate("fec_desde"))+
                                 "_"+
                                 Fecha.getddmmyyyy(dataset.getDate("fec_hasta")));
        periretiva.setActivo(dataset.getBoolean("activo"));
        addTransaccion(periretiva);
        dataset.next();
    }
  }

}
