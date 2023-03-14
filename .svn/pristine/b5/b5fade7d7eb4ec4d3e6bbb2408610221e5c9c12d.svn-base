package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluNovedadPostu;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.da.DBRecluNovedadPostu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluNovedadPostu extends FactoryObjetoLogico { 

  public FactoryRecluNovedadPostu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluNovedadPostu reclunovedadpostu = (RecluNovedadPostu) objLog;
    reclunovedadpostu.setOID(db.getInteger(DBRecluNovedadPostu.OID_NOV_POSTU));
    reclunovedadpostu.setPostulante(RecluPostulante.findByOidProxy(db.getInteger(DBRecluNovedadPostu.OID_POSTULANTE),getSesion()));
    reclunovedadpostu.setFecha(db.getDate(DBRecluNovedadPostu.FECHA));
    reclunovedadpostu.setNovedad(db.getString(DBRecluNovedadPostu.NOVEDAD));
    reclunovedadpostu.setExc_fut_postu(db.getBoolean(DBRecluNovedadPostu.EXC_FUT_POSTU));
    reclunovedadpostu.setUsuario(Usuario.findByOidProxy(db.getInteger(DBRecluNovedadPostu.OID_USUARIO),getSesion()));
    reclunovedadpostu.setActivo(db.getBoolean(DBRecluNovedadPostu.ACTIVO));
    reclunovedadpostu.setFecVigencia(db.getDate(DBRecluNovedadPostu.FEC_VIGENCIA));
  }
}
