package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.TipoProducto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoProducto extends Operation {

  public SaveTipoProducto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTipoProducto");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        TipoProducto tipoproducto = TipoProducto.findByOid(dataset.getInteger("oid_tipo_prod"),getSesion());
        tipoproducto.setOID(dataset.getInteger("oid_tipo_prod"));
        tipoproducto.setCodigo(dataset.getString("codigo"));
        tipoproducto.setDescripcion(dataset.getString("descripcion"));
        tipoproducto.setComportamiento(dataset.getString("compo"));
        tipoproducto.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipoproducto);
        dataset.next();
    }
  }

}
