package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.FirmaModeloEvaluacion;
import com.srn.erp.rrhh.da.DBFirmaModeloEvaluacion;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFirmaModeloEvaluacion extends FactoryObjetoLogico { 

  public FactoryFirmaModeloEvaluacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FirmaModeloEvaluacion firmamodeloevaluacion = (FirmaModeloEvaluacion) objLog;
    firmamodeloevaluacion.setOID(db.getInteger(DBFirmaModeloEvaluacion.OID_MOV_EVAL_FIRM));
    firmamodeloevaluacion.setCondicion_modelo(CondModEvalCab.findByOidProxy(db.getInteger(DBFirmaModeloEvaluacion.OID_COND_MOD),getSesion()));
    firmamodeloevaluacion.setNro_firma(db.getInteger(DBFirmaModeloEvaluacion.NRO_FIRMA));
    firmamodeloevaluacion.setTitulo(db.getString(DBFirmaModeloEvaluacion.TITULO));
    firmamodeloevaluacion.setLegajo_firma(Legajo.findByOidProxy(db.getInteger(DBFirmaModeloEvaluacion.OID_LEGAJO_FIRMA),getSesion()));
    firmamodeloevaluacion.setActivo(db.getBoolean(DBFirmaModeloEvaluacion.ACTIVO));

  }
}
