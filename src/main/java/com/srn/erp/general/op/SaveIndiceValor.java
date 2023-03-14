package com.srn.erp.general.op;

import com.srn.erp.general.bm.Indice;
import com.srn.erp.general.bm.IndiceValor;
import com.srn.erp.general.bm.Periodo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveIndiceValor extends Operation {

  public SaveIndiceValor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TValIndice");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        IndiceValor indiceValor = IndiceValor.findByOid(dataset.getInteger("oid_indice_val"),getSesion());
        indiceValor.setIndice(Indice.findByOid(dataset.getInteger("oid_indice"),getSesion()));
        indiceValor.setPeri(Periodo.findByOid(dataset.getInteger("oid_peri"),getSesion()));
        indiceValor.setValor(dataset.getDouble("indice"));
        indiceValor.setActivo(dataset.getBoolean("activo"));
        addTransaccion(indiceValor);
        dataset.next();
    }
  }

}
