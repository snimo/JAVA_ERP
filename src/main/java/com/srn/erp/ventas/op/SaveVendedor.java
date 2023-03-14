package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Vendedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveVendedor extends Operation {

  public SaveVendedor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TVendedor");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Vendedor vendedor = Vendedor.findByOid(dataset.getInteger("oid_vendedor"),getSesion());
        vendedor.setOID(dataset.getInteger("oid_vendedor"));
        vendedor.setCodigo(dataset.getString("codigo"));
        vendedor.setApellido(dataset.getString("apellido"));
        vendedor.setNombre(dataset.getString("nombre"));
        vendedor.setActivo(dataset.getBoolean("activo"));
        vendedor.setMail(dataset.getString("mail"));
        vendedor.setTelefono(dataset.getString("telefono"));
        addTransaccion(vendedor);
        dataset.next();
    }
  }

}
