package com.srn.erp.tesoreria.op;

import com.srn.erp.tesoreria.bm.Ticket;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTicket extends Operation {

  public TraerTicket() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Ticket ticket = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       ticket = Ticket.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       ticket = Ticket.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTicket = getDataSetTicket();
    if (ticket != null) {
        cargarRegistroTicket(datasetTicket,
                         ticket.getOIDInteger(),
                         ticket.getCodigo(),
                         ticket.getDescripcion(),
                         ticket.isActivo());
    }
    writeCliente(datasetTicket);
  }

  private IDataSet getDataSetTicket() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTicket");
    dataset.fieldDef(new Field("oid_ticket", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTicket(IDataSet dataset,
                         Integer oid_ticket,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_ticket", oid_ticket);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
