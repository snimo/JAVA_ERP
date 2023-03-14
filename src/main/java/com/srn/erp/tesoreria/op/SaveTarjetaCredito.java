package com.srn.erp.tesoreria.op;

import com.srn.erp.tesoreria.bm.TarjetaCredito;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTarjetaCredito extends Operation {

  public SaveTarjetaCredito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTarjetaCredito");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        TarjetaCredito tarjetacredito = TarjetaCredito.findByOid(dataset.getInteger("oid_tar_credito"),getSesion());
        tarjetacredito.setOID(dataset.getInteger("oid_tar_credito"));
        tarjetacredito.setCodigo(dataset.getString("codigo"));
        tarjetacredito.setDescripcion(dataset.getString("descripcion"));
        tarjetacredito.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tarjetacredito);
        dataset.next();
    }
  }

}
