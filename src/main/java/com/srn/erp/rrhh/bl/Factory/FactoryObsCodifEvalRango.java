package com.srn.erp.rrhh.bl.Factory;


import com.srn.erp.rrhh.bm.ObsCodifEvalRH;
import com.srn.erp.rrhh.bm.ObsCodifEvalRango;
import com.srn.erp.rrhh.bm.RangoPtajeObsCodif;
import com.srn.erp.rrhh.da.DBObsCodifEvalRango;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryObsCodifEvalRango extends FactoryObjetoLogico { 

  public FactoryObsCodifEvalRango() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ObsCodifEvalRango obscodifevalrango = (ObsCodifEvalRango) objLog;
    obscodifevalrango.setOID(db.getInteger(DBObsCodifEvalRango.OID_MOD_OBS_DET));
    obscodifevalrango.setOrden(db.getInteger(DBObsCodifEvalRango.ORDEN));
    obscodifevalrango.setOid_obs_codif(ObsCodifEvalRH.findByOidProxy(db.getInteger(DBObsCodifEvalRango.OID_OBS_CODIF),getSesion()));
    obscodifevalrango.setMod_obs_codif(RangoPtajeObsCodif.findByOidProxy(db.getInteger(DBObsCodifEvalRango.OID_MOD_OBS_CODIF),getSesion()));
    obscodifevalrango.setDescripcion(db.getString(DBObsCodifEvalRango.DESCRIPCION));
    obscodifevalrango.setActivo(db.getBoolean(DBObsCodifEvalRango.ACTIVO));

  }
}
