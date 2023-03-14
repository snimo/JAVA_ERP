package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.TipoDocumento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoDocumento extends Operation {

  public SaveTipoDocumento() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTipoDocumento");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        TipoDocumento tipodocumento = TipoDocumento.findByOid(dataset.getInteger("oid_tipo_documento"),getSesion());
        tipodocumento.setOID(dataset.getInteger("oid_tipo_documento"));
        tipodocumento.setCodigo(dataset.getString("codigo"));
        tipodocumento.setDescripcion(dataset.getString("descripcion"));
        tipodocumento.setActivo(dataset.getBoolean("activo"));
        tipodocumento.setComportamiento(dataset.getString("comportamiento"));
        tipodocumento.setCodigoFE(dataset.getInteger("codigo_fe"));
        addTransaccion(tipodocumento);
        dataset.next();
    }
  }

}
