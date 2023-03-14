package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.Ticket;
import com.srn.erp.tesoreria.da.DBTicket;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTicket extends FactoryObjetoLogico {

  public FactoryTicket() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Ticket ticket = (Ticket) objLog;
    ticket.setOID(db.getInteger(DBTicket.OID_TICKET));
    ticket.setCodigo(db.getString(DBTicket.CODIGO));
    ticket.setDescripcion(db.getString(DBTicket.DESCRIPCION));
    ticket.setActivo(db.getBoolean(DBTicket.ACTIVO));

  }
}
