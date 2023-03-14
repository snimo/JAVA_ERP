package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.ColumnaLibroIVA;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveColumnaLibroIVA extends Operation {

  public SaveColumnaLibroIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TColumnaLibroIVA");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ColumnaLibroIVA columnalibroiva = ColumnaLibroIVA.findByOid(dataset.getInteger("oid_col_libro_iva"),getSesion());
        columnalibroiva.setOID(dataset.getInteger("oid_col_libro_iva"));
        columnalibroiva.setCodigo(dataset.getString("codigo"));
        columnalibroiva.setDescripcion(dataset.getString("descripcion"));
        columnalibroiva.setColumna(dataset.getInteger("columna"));
        columnalibroiva.setActivo(dataset.getBoolean("activo"));
        columnalibroiva.setUsarIVACompras(dataset.getBoolean("usar_iva_cpras"));
        columnalibroiva.setUsarIVAVentas(dataset.getBoolean("usar_iva_vtas"));
        addTransaccion(columnalibroiva);
        dataset.next();
    }
  }

}
