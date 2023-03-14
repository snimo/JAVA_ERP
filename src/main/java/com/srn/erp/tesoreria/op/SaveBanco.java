package com.srn.erp.tesoreria.op;

import com.srn.erp.tesoreria.bm.Banco;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveBanco extends Operation {

  public SaveBanco() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TBanco");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Banco banco = Banco.findByOid(dataset.getInteger("oid_banco"),getSesion());
        banco.setOID(dataset.getInteger("oid_banco"));
        banco.setCodigo(dataset.getString("codigo"));
        banco.setDescripcion(dataset.getString("descripcion"));
        banco.setActivo(dataset.getBoolean("activo"));
        addTransaccion(banco);
        dataset.next();
    }
  }

}
