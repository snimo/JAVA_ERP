package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.TipoUnidadEdilicia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoUnidadEdilicia extends Operation {

  public SaveTipoUnidadEdilicia() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTipoUnidadEdilicia");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        TipoUnidadEdilicia tipounidadedilicia = TipoUnidadEdilicia.findByOid(dataset.getInteger("oid_tipo_uni_edi"),getSesion());
        tipounidadedilicia.setOID(dataset.getInteger("oid_tipo_uni_edi"));
        tipounidadedilicia.setCodigo(dataset.getString("codigo"));
        tipounidadedilicia.setDescripcion(dataset.getString("descripcion"));
        tipounidadedilicia.setComportamiento(dataset.getString("compo"));
        tipounidadedilicia.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipounidadedilicia);
        dataset.next();
    }
  }

}
