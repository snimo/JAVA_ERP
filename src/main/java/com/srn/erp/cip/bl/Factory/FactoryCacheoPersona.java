package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CacheoPersona;
import com.srn.erp.cip.bm.PersonalSeguridad;
import com.srn.erp.cip.bm.ResultadoCacheo;
import com.srn.erp.cip.da.DBCacheoPersona;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCacheoPersona extends FactoryObjetoLogico { 

  public FactoryCacheoPersona() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CacheoPersona cacheopersona = (CacheoPersona) objLog;
    cacheopersona.setOID(db.getInteger(DBCacheoPersona.OID_CACHEO_PERS));
    cacheopersona.setLegajo(Legajo.findByOidProxy(db.getInteger(DBCacheoPersona.OID_LEGAJO),getSesion()));
    cacheopersona.setFecha(db.getDate(DBCacheoPersona.FECHA));
    cacheopersona.setHora(db.getString(DBCacheoPersona.HORA));
    cacheopersona.setObservacion(db.getString(DBCacheoPersona.OBSERVACION));
    cacheopersona.setActivo(db.getBoolean(DBCacheoPersona.ACTIVO));
    cacheopersona.setPersonalSeguridad(PersonalSeguridad.findByOidProxy(db.getInteger(DBCacheoPersona.OID_PERS_SEGU),getSesion()));
    cacheopersona.setResultadoCacheo(ResultadoCacheo.findByOidProxy(db.getInteger(DBCacheoPersona.OID_EST_RES_CACHEO),getSesion()));
  }
}
