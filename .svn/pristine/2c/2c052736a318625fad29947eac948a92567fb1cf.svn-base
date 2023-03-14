package com.srn.erp.pagos.op;

import com.srn.erp.pagos.bm.PeriRetIB;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.Validar;
import framework.request.bl.XML.IDataSet;

public class SavePeriRetIB extends Operation {

  public SavePeriRetIB() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TPeriRetIB");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        PeriRetIB periretib = PeriRetIB.findByOid(dataset.getInteger("oid_peri_ret_ib"),getSesion());
        periretib.setOID(dataset.getInteger("oid_peri_ret_ib"));
        periretib.setFecdesde(dataset.getDate("fec_desde"));
        periretib.setFechasta(dataset.getDate("fec_hasta"));
        periretib.setDescripcion(dataset.getString("descripcion"));
        Validar.noNulo(dataset.getDate("fec_desde"),"Debe ingresar la fecha desde");
        Validar.noNulo(dataset.getDate("fec_hasta"),"Debe ingresar la fecha hasta");
        periretib.setCodinterno(Fecha.getddmmyyyy(dataset.getDate("fec_desde"))+
                                 "_"+
                                 Fecha.getddmmyyyy(dataset.getDate("fec_hasta")));
        periretib.setActivo(dataset.getBoolean("activo"));
        addTransaccion(periretib);
        dataset.next();
    }
  }

}
