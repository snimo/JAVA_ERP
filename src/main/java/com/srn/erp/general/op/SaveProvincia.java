package com.srn.erp.general.op;

import com.srn.erp.general.bm.Provincia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveProvincia extends Operation {

  public SaveProvincia() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TProvincia");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Provincia provincia = Provincia.findByOid(dataset.getInteger("oid_provincia"),getSesion());
        provincia.setOID(dataset.getInteger("oid_provincia"));
        provincia.setCodigo(dataset.getString("codigo"));
        provincia.setDescripcion(dataset.getString("descripcion"));
        provincia.setActivo(dataset.getBoolean("activo"));
        provincia.setEsBuenosAires(dataset.getBoolean("es_bs_as").booleanValue());
        provincia.setEsCapitalFederal(dataset.getBoolean("es_cap_fed").booleanValue());
        provincia.setCalcPercIBBA(dataset.getBoolean("calc_perc_ib_ba").booleanValue());
        addTransaccion(provincia);
        dataset.next();
    }
  }

}
