package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.EstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.EstructuraTipoCiclo;
import com.srn.erp.presupuesto.bm.TipoCiclo;
import com.srn.erp.presupuesto.da.DBEstructuraTipoCiclo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstructuraTipoCiclo extends FactoryObjetoLogico { 

  public FactoryEstructuraTipoCiclo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstructuraTipoCiclo estructuratipociclo = (EstructuraTipoCiclo) objLog;
    estructuratipociclo.setOID(db.getInteger(DBEstructuraTipoCiclo.OID_ESTRUC_TIPO));
    estructuratipociclo.setTipo_ciclo(TipoCiclo.findByOidProxy(db.getInteger(DBEstructuraTipoCiclo.OID_TIPO_CICLO),getSesion()));
    estructuratipociclo.setEstructura_planificacion(EstructuraPlanificacion.findByOidProxy(db.getInteger(DBEstructuraTipoCiclo.OID_ESTRUC_PLANIF),getSesion()));
    estructuratipociclo.setActivo(db.getBoolean(DBEstructuraTipoCiclo.ACTIVO));

  }
}
