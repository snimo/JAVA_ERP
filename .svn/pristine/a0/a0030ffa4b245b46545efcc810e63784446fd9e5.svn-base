package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.EstadoCivil;
import com.srn.erp.ventas.da.DBEstadoCivil;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoCivil extends FactoryObjetoLogico {

  public FactoryEstadoCivil() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoCivil estadocivil = (EstadoCivil) objLog;
    estadocivil.setOID(db.getInteger(DBEstadoCivil.OID_ESTADO_CIVIL));
    estadocivil.setCodigo(db.getString(DBEstadoCivil.CODIGO));
    estadocivil.setDescripcion(db.getString(DBEstadoCivil.DESCRIPCION));
    estadocivil.setActivo(db.getBoolean(DBEstadoCivil.ACTIVO));
  }
}
