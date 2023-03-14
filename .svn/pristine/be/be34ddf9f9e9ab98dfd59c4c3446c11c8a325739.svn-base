package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.MotivoVisita;
import com.srn.erp.cip.bm.PermisoVisita;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.cip.da.DBPermisoVisita;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPermisoVisita extends FactoryObjetoLogico { 

  public FactoryPermisoVisita() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PermisoVisita permisovisita = (PermisoVisita) objLog;
    permisovisita.setOID(db.getInteger(DBPermisoVisita.OID_PERM_VISITA));
    permisovisita.setPrioridad(db.getInteger(DBPermisoVisita.PRIORIDAD));
    permisovisita.setVisita(Visita.findByOidProxy(db.getInteger(DBPermisoVisita.OID_VISITA),getSesion()));
    permisovisita.setPermiso(db.getString(DBPermisoVisita.PERMISO));
    permisovisita.setFec_hor_desde(db.getDateTime(DBPermisoVisita.FEC_HOR_DESDE));
    permisovisita.setFec_hor_hasta(db.getDateTime(DBPermisoVisita.FEC_HOR_HASTA));
    permisovisita.setGrupo_puerta(GrupoPuerta.findByOidProxy(db.getInteger(DBPermisoVisita.OID_GRUPO_PUERTA),getSesion()));
    permisovisita.setActivo(db.getBoolean(DBPermisoVisita.ACTIVO));
    permisovisita.setTarjeta(TarjetaCIP.findByOidProxy(db.getInteger(DBPermisoVisita.OID_TARJETA),getSesion()));
    permisovisita.setSentido(db.getString(DBPermisoVisita.SENTIDO));
    permisovisita.setMotivoVisita(MotivoVisita.findByOidProxy(db.getInteger(DBPermisoVisita.MOTIVO_VISITA),getSesion()));
    permisovisita.setComentario(db.getString(DBPermisoVisita.COMENTARIO));
    permisovisita.setVisitaA(Legajo.findByOidProxy(db.getInteger(DBPermisoVisita.OID_VISITA_A),getSesion()));
    permisovisita.setAutoriza(Legajo.findByOidProxy(db.getInteger(DBPermisoVisita.OID_AUTORIZA),getSesion()));
  }
}
