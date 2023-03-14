package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.PeriRetIVA;
import com.srn.erp.pagos.da.DBPeriRetIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPeriRetIVA extends FactoryObjetoLogico {

  public FactoryPeriRetIVA() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PeriRetIVA periretiva = (PeriRetIVA) objLog;
    periretiva.setOID(db.getInteger(DBPeriRetIVA.OID_PERI_RET_IVA));
    periretiva.setFecdesde(db.getDate(DBPeriRetIVA.FEC_DESDE));
    periretiva.setFechasta(db.getDate(DBPeriRetIVA.FEC_HASTA));
    periretiva.setDescripcion(db.getString(DBPeriRetIVA.DESCRIPCION));
    periretiva.setCodinterno(db.getString(DBPeriRetIVA.CODIGO_INTERNO));
    periretiva.setActivo(db.getBoolean(DBPeriRetIVA.ACTIVO));

  }
}
