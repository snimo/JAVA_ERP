package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.Cacheo;
import com.srn.erp.cip.bm.CacheoPersona;
import com.srn.erp.cip.bm.FechaPlanifCacheo;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.ResultadoCacheo;
import com.srn.erp.cip.da.DBCacheo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryCacheo extends FactoryObjetoLogico { 

  public FactoryCacheo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Cacheo cacheo = (Cacheo) objLog;
    cacheo.setOID(db.getInteger(DBCacheo.OID_CACHEO));
    cacheo.setLegajo(Legajo.findByOidProxy(db.getInteger(DBCacheo.OID_LEGAJO),getSesion()));
    cacheo.setFec_planif_cacheo(db.getDate(DBCacheo.FEC_PLANIF_CACHEO));
    cacheo.setFec_cacheo(db.getDate(DBCacheo.FEC_CACHEO));
    cacheo.setRealizado(db.getBoolean(DBCacheo.REALIZADO));
    cacheo.setActivo(db.getBoolean(DBCacheo.ACTIVO));
    cacheo.setUsuario_cacheo(Usuario.findByOidProxy(db.getInteger(DBCacheo.OID_USU_CACHEO),getSesion()));
    cacheo.setHora_cacheo(db.getString(DBCacheo.HORA_CACHEO));
    cacheo.setFec_levantado(db.getDate(DBCacheo.FEC_LEVANTADO));
    cacheo.setLevantado(db.getBoolean(DBCacheo.LEVANTADO));
    cacheo.setNo_realizado(db.getBoolean(DBCacheo.NO_REALIZADO));
    cacheo.setObs_cacheo(db.getString(DBCacheo.OBS_CACHEO));
    cacheo.setHora_levantado(db.getString(DBCacheo.HORA_LEVANTADO));
    cacheo.setEnt_o_sal(db.getString(DBCacheo.ENT_O_SAL));
    cacheo.setEst_res_cacheo(ResultadoCacheo.findByOidProxy(db.getInteger(DBCacheo.OID_EST_RES_CACHEO),getSesion()));
    cacheo.setUsuario_levanto(Usuario.findByOidProxy(db.getInteger(DBCacheo.OID_USU_LEVANTADO),getSesion()));
    cacheo.setCacheoPersona(CacheoPersona.findByOidProxy(db.getInteger(DBCacheo.OID_CACHEO_PERS),getSesion()));
    cacheo.setGrupoPuerta(GrupoPuerta.findByOidProxy(db.getInteger(DBCacheo.OID_GRUPO_PUERTA),getSesion()));
    cacheo.setIntentoDePase(db.getBoolean(DBCacheo.INTENTO_DE_PASE));
    cacheo.setFechaPlanifacheo(FechaPlanifCacheo.findByOidProxy(db.getInteger(DBCacheo.OID_FEC_PLANIF),getSesion()));
  }
}
