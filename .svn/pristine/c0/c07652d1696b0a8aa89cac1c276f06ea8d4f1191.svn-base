package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.PeriRetIB;
import com.srn.erp.pagos.da.DBPeriRetIB;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPeriRetIB extends FactoryObjetoLogico {

  public FactoryPeriRetIB() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PeriRetIB periretib = (PeriRetIB) objLog;
    periretib.setOID(db.getInteger(DBPeriRetIB.OID_PERI_RET_IB));
    periretib.setFecdesde(db.getDate(DBPeriRetIB.FEC_DESDE));
    periretib.setFechasta(db.getDate(DBPeriRetIB.FEC_HASTA));
    periretib.setDescripcion(db.getString(DBPeriRetIB.DESCRIPCION));
    periretib.setCodinterno(db.getString(DBPeriRetIB.CODIGO_INTERNO));
    periretib.setActivo(db.getBoolean(DBPeriRetIB.ACTIVO));
  }
}
