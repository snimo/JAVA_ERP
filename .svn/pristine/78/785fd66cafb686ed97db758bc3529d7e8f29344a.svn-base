package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.ObsGeneralesExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.da.DBObsGeneralesExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryObsGeneralesExcluido extends FactoryObjetoLogico { 

  public FactoryObsGeneralesExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ObsGeneralesExcluido obsgeneralesexcluido = (ObsGeneralesExcluido) objLog;
    obsgeneralesexcluido.setOID(db.getInteger(DBObsGeneralesExcluido.OID_OBS_GRALES));
    obsgeneralesexcluido.setIndividuo(IndividuoExcluido.findByOidProxy(db.getInteger(DBObsGeneralesExcluido.OID_INDIVIDUO),getSesion()));
    obsgeneralesexcluido.setFecha(db.getDate(DBObsGeneralesExcluido.FECHA));
    obsgeneralesexcluido.setObservacion(db.getString(DBObsGeneralesExcluido.OBSERVACION));
    obsgeneralesexcluido.setActivo(db.getBoolean(DBObsGeneralesExcluido.ACTIVO));
    obsgeneralesexcluido.setPredioExcluido(PredioExcluido.findByOidProxy(db.getInteger(DBObsGeneralesExcluido.OID_PREDIO),getSesion()));

  }
}
