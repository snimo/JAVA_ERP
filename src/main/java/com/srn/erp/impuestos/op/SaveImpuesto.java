package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.Impuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveImpuesto extends Operation {

  public SaveImpuesto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TImpuesto");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Impuesto impuesto = Impuesto.findByOid(dataset.getInteger("oid_impuesto"),getSesion());
        impuesto.setOID(dataset.getInteger("oid_impuesto"));
        impuesto.setCodigo(dataset.getString("codigo"));
        impuesto.setDescripcion(dataset.getString("descripcion"));
        impuesto.setCompo(dataset.getString("compo"));
        impuesto.setActivo(dataset.getBoolean("activo"));
        impuesto.setVentas(dataset.getBoolean("ventas"));
        impuesto.setCompras(dataset.getBoolean("compras"));
        addTransaccion(impuesto);
        dataset.next();
    }
  }

}
