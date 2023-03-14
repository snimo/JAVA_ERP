package com.srn.erp.tesoreria.op;

import com.srn.erp.tesoreria.bm.Ticket;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTicket extends Operation {

  public SaveTicket() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTicket");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Ticket ticket = Ticket.findByOid(dataset.getInteger("oid_ticket"),getSesion());
        ticket.setOID(dataset.getInteger("oid_ticket"));
        ticket.setCodigo(dataset.getString("codigo"));
        ticket.setDescripcion(dataset.getString("descripcion"));
        ticket.setActivo(dataset.getBoolean("activo"));
        addTransaccion(ticket);
        dataset.next();
    }
  }

}
