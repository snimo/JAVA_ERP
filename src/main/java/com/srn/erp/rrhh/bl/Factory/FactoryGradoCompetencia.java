package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.GradoCompetencia;
import com.srn.erp.rrhh.da.DBGradoCompetencia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGradoCompetencia extends FactoryObjetoLogico { 

  public FactoryGradoCompetencia() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GradoCompetencia gradocompetencia = (GradoCompetencia) objLog;
    gradocompetencia.setOID(db.getInteger(DBGradoCompetencia.OID_GRADO_COMPE));
    gradocompetencia.setCompetencia(Competencia.findByOidProxy(db.getInteger(DBGradoCompetencia.OID_COMPETENCIA),getSesion()));
    gradocompetencia.setNro_grado(db.getInteger(DBGradoCompetencia.NRO_GRADO));
    gradocompetencia.setDesc_grados(db.getString(DBGradoCompetencia.DESC_GRADOS));
    gradocompetencia.setPeso_tentativo(db.getDouble(DBGradoCompetencia.PESO_TENTATIVO));
    gradocompetencia.setActivo(db.getBoolean(DBGradoCompetencia.ACTIVO));

  }
}
