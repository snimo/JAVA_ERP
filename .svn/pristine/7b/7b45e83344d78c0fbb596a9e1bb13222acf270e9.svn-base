package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.PeriodoStockReal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePeriodoStockReal extends Operation {

  public SavePeriodoStockReal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TPeriodoStockReal");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        PeriodoStockReal periodoStockReal = PeriodoStockReal.findByOid(dataset.getInteger("oid_peri_stk_real"),getSesion());
        periodoStockReal.setOID(dataset.getInteger("oid_peri_stk_real"));
        periodoStockReal.setCodigo(dataset.getString("codigo"));
        periodoStockReal.setDescripcion(dataset.getString("descripcion"));
        periodoStockReal.setFechadesde(dataset.getDate("fecha_desde"));
        periodoStockReal.setFechahasta(dataset.getDate("fecha_hasta"));
        periodoStockReal.setTipo(dataset.getString("tipo"));
        periodoStockReal.setActivo(dataset.getBoolean("activo"));
        addTransaccion(periodoStockReal);
        dataset.next();
    }
  }

}
