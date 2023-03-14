package com.srn.erp.mensajero.bl.Factory;

import com.srn.erp.mensajero.bm.MensajeCab;
import com.srn.erp.mensajero.da.DBMensajeCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryMensajeCab extends FactoryObjetoLogico { 

  public FactoryMensajeCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MensajeCab mensajecab = (MensajeCab) objLog;
    mensajecab.setOID(db.getInteger(DBMensajeCab.OID_MENS_CAB));
    mensajecab.setIdentificador(db.getString(DBMensajeCab.IDENTIFICADOR));
    mensajecab.setAsunto(db.getString(DBMensajeCab.ASUNTO));
    mensajecab.setCuerpo(db.getString(DBMensajeCab.CUERPO));
    mensajecab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBMensajeCab.OID_USUARIO),getSesion()));
    mensajecab.setFec_envio(db.getDate(DBMensajeCab.FEC_ENVIO));
    mensajecab.setHor_envio(db.getString(DBMensajeCab.HOR_ENVIO));
    mensajecab.setEnviar_mail(db.getBoolean(DBMensajeCab.ENVIAR_MAIL));
    mensajecab.setImportancia(db.getString(DBMensajeCab.IMPORTANCIA));
    mensajecab.setSolicitar_conf_lec(db.getBoolean(DBMensajeCab.SOLICITAR_CONF_LEC));
    mensajecab.setActivo(db.getBoolean(DBMensajeCab.ACTIVO));
    mensajecab.setEnviar_pop_up(db.getBoolean(DBMensajeCab.ENVIAR_POP_UP));
    mensajecab.setDur_seg_pop_up(db.getInteger(DBMensajeCab.DUR_SEG_POP_UP));
    mensajecab.setEnviar_mens_int(db.getBoolean(DBMensajeCab.ENVIAR_MENS_INT));
    mensajecab.setEnviar_chat(db.getBoolean(DBMensajeCab.ENVIAR_CHAT));
    mensajecab.setSend_to_all_connec(db.getBoolean(DBMensajeCab.SEND_TO_ALL_CONNEC));

  }
}
