package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.TipoObsLeg;
import com.srn.erp.rrhh.da.DBTipoObsLeg;

public class FactoryTipoObsLeg extends FactoryObjetoLogico { 

  public FactoryTipoObsLeg() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoObsLeg tipoobsleg = (TipoObsLeg) objLog;
    tipoobsleg.setOID(db.getInteger(DBTipoObsLeg.OID_TIPO_OBS_LEG));
    tipoobsleg.setCodigo(db.getString(DBTipoObsLeg.CODIGO));
    tipoobsleg.setDescripcion(db.getString(DBTipoObsLeg.DESCRIPCION));
    tipoobsleg.setActivo(db.getBoolean(DBTipoObsLeg.ACTIVO));

  }
}
