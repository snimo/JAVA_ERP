package com.srn.erp.mensajero.bl.Factory;

import com.srn.erp.mensajero.bm.InboxMensUsu;
import com.srn.erp.mensajero.bm.MensajeCab;
import com.srn.erp.mensajero.da.DBInboxMensUsu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryInboxMensUsu extends FactoryObjetoLogico { 

  public FactoryInboxMensUsu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    InboxMensUsu inboxmensusu = (InboxMensUsu) objLog;
    inboxmensusu.setOID(db.getInteger(DBInboxMensUsu.OID_INBOX_USU));
    inboxmensusu.setUsuario(Usuario.findByOidProxy(db.getInteger(DBInboxMensUsu.OID_USUARIO),getSesion()));
    inboxmensusu.setMensaje(MensajeCab.findByOidProxy(db.getInteger(DBInboxMensUsu.OID_MENS_CAB),getSesion()));
    inboxmensusu.setLeido(db.getBoolean(DBInboxMensUsu.LEIDO));
    inboxmensusu.setEliminado(db.getBoolean(DBInboxMensUsu.ELIMINADO));
    inboxmensusu.setDepurado(db.getBoolean(DBInboxMensUsu.DEPURADO));
    inboxmensusu.setFec_recibido(db.getDate(DBInboxMensUsu.FEC_RECIBIDO));
    inboxmensusu.setHora_recibido(db.getString(DBInboxMensUsu.HORA_RECIBIDO));
    inboxmensusu.setActivo(db.getBoolean(DBInboxMensUsu.ACTIVO));

  }
}
