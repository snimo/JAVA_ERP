package com.srn.erp.mensajero.bl.Factory;

import com.srn.erp.mensajero.bm.DestinoMens;
import com.srn.erp.mensajero.bm.GrupoMaquina;
import com.srn.erp.mensajero.bm.GrupoUsuMens;
import com.srn.erp.mensajero.bm.Maquina;
import com.srn.erp.mensajero.bm.MensajeCab;
import com.srn.erp.mensajero.da.DBDestinoMens;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryDestinoMens extends FactoryObjetoLogico { 

  public FactoryDestinoMens() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DestinoMens destinomens = (DestinoMens) objLog;
    destinomens.setOID(db.getInteger(DBDestinoMens.OID_MENS_DEST));
    destinomens.setMensaje(MensajeCab.findByOidProxy(db.getInteger(DBDestinoMens.OID_MENS_CAB),getSesion()));
    destinomens.setGrupo_dest_cab(GrupoUsuMens.findByOidProxy(db.getInteger(DBDestinoMens.OID_GRUPO_DEST_CAB),getSesion()));
    destinomens.setGrupo_maquina(GrupoMaquina.findByOidProxy(db.getInteger(DBDestinoMens.OID_GRUPO_MAQ),getSesion()));
    destinomens.setMaquina(Maquina.findByOidProxy(db.getInteger(DBDestinoMens.OID_MAQUINA),getSesion()));
    destinomens.setUsuario(Usuario.findByOidProxy(db.getInteger(DBDestinoMens.OID_USUARIO),getSesion()));
    destinomens.setMail(db.getString(DBDestinoMens.MAIL));
    destinomens.setActivo(db.getBoolean(DBDestinoMens.ACTIVO));

  }
}
