package com.srn.erp.general.op;

import com.srn.erp.general.bm.Periodo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePeriodo extends Operation {

  public SavePeriodo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TPeriodo");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Periodo periodo = Periodo.findByOid(dataset.getInteger("oid_peri"),getSesion());
        periodo.setOID(dataset.getInteger("oid_peri"));
        periodo.setCodigo(dataset.getString("codigo"));
        periodo.setDescripcion(dataset.getString("descripcion"));
        periodo.setFechadesde(dataset.getDate("fecha_desde"));
        periodo.setFechahasta(dataset.getDate("fecha_hasta"));
        periodo.setTipo(dataset.getString("tipo"));
        periodo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(periodo);
        dataset.next();
    }
  }

}
