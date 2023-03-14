package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.Partida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePartida extends Operation {

  public SavePartida() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TPartida");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Partida partida = Partida.findByOid(dataset.getInteger("oid_partida"),getSesion());
        partida.setOID(dataset.getInteger("oid_partida"));
        partida.setCodigo(dataset.getString("codigo"));
        partida.setDescripcion(dataset.getString("descripcion"));
        partida.setNro(dataset.getInteger("nro"));
        partida.setFec_inicio(dataset.getDate("fec_inicio"));
        partida.setFec_vto(dataset.getDate("fec_vto"));
        partida.setActivo(dataset.getBoolean("activo"));
        addTransaccion(partida);
        dataset.next();
    }
  }

}
