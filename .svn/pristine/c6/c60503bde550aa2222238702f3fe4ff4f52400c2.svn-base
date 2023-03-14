package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.Partida;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPartida extends Operation {

  public TraerPartida() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Partida partida = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       partida = Partida.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       partida = Partida.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetPartida = getDataSetPartida();
    if (partida != null) {
        cargarRegistroPartida(datasetPartida,
                         partida.getOIDInteger(),
                         partida.getCodigo(),
                         partida.getDescripcion(),
                         partida.getNro(),
                         partida.getFec_inicio(),
                         partida.getFec_vto(),
                         partida.isActivo());
    }
    writeCliente(datasetPartida);
  }

  private IDataSet getDataSetPartida() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPartida");
    dataset.fieldDef(new Field("oid_partida", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("nro", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_inicio", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_vto", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroPartida(IDataSet dataset,
                         Integer oid_partida,
                         String codigo,
                         String descripcion,
                         Integer nro,
                         java.util.Date fec_inicio,
                         java.util.Date fec_vto,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_partida", oid_partida);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("nro", nro);
    dataset.fieldValue("fec_inicio",Fecha.getddmmyyyy(fec_inicio));
    dataset.fieldValue("fec_vto", Fecha.getddmmyyyy(fec_vto));
    dataset.fieldValue("activo", activo);
  }
}
