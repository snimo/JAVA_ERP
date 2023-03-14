package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.MotivosNovCIP;
import com.srn.erp.cip.bm.NovedadPermisoCIP;
import com.srn.erp.cip.da.DBNovedadPermisoCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryNovedadPermisoCIP extends FactoryObjetoLogico { 

  public FactoryNovedadPermisoCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    NovedadPermisoCIP novedadpermisocip = (NovedadPermisoCIP) objLog;
    novedadpermisocip.setOID(db.getInteger(DBNovedadPermisoCIP.OID_NOV_PERMISO));
    novedadpermisocip.setMotivo(MotivosNovCIP.findByOidProxy(db.getInteger(DBNovedadPermisoCIP.OID_MOTIVO),getSesion()));
    novedadpermisocip.setFecha(db.getDate(DBNovedadPermisoCIP.FECHA));
    novedadpermisocip.setLegajo(Legajo.findByOidProxy(db.getInteger(DBNovedadPermisoCIP.OID_LEGAJO),getSesion()));
    novedadpermisocip.setHora_desde(db.getString(DBNovedadPermisoCIP.HORA_DESDE));
    novedadpermisocip.setHora_hasta(db.getString(DBNovedadPermisoCIP.HORA_HASTA));
    novedadpermisocip.setHora_desde_en_min(db.getInteger(DBNovedadPermisoCIP.HORA_DESDE_EN_MIN));
    novedadpermisocip.setHora_hasta_en_min(db.getInteger(DBNovedadPermisoCIP.HORA_HASTA_EN_MIN));
    novedadpermisocip.setGrupo_puerta(GrupoPuerta.findByOidProxy(db.getInteger(DBNovedadPermisoCIP.OID_GRUPO_PUERTA),getSesion()));
    novedadpermisocip.setObservacion(db.getString(DBNovedadPermisoCIP.OBSERVACION));
    novedadpermisocip.setActivo(db.getBoolean(DBNovedadPermisoCIP.ACTIVO));
    novedadpermisocip.setFec_usu_asig_perm(db.getDate(DBNovedadPermisoCIP.FEC_USU_ASIG_PERM));
    novedadpermisocip.setUsu_asig_permiso(Usuario.findByOidProxy(db.getInteger(DBNovedadPermisoCIP.OID_USU_ASIG_PERM),getSesion()));
    novedadpermisocip.setHor_usu_asig_perm(db.getString(DBNovedadPermisoCIP.HOR_USU_ASIG_PERM));
    novedadpermisocip.setPermisoIngreso(db.getString(DBNovedadPermisoCIP.PERMISO_INGRESO));
    novedadpermisocip.setPermisoEgreso(db.getString(DBNovedadPermisoCIP.PERMISO_EGRESO));
    novedadpermisocip.setEsNovedadExterna(db.getBoolean(DBNovedadPermisoCIP.ES_NOV_EXT));
    novedadpermisocip.setIdentifNovExt(db.getString(DBNovedadPermisoCIP.IDENTIF_NOV_EXT));
    novedadpermisocip.setPesoNovedad(db.getInteger(DBNovedadPermisoCIP.PESO_NOVEDAD));
  }
}
