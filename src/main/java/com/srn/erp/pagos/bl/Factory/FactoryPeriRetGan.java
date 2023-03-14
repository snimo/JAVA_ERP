package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.PeriRetGan;
import com.srn.erp.pagos.da.DBPeriRetGan;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPeriRetGan extends FactoryObjetoLogico {

  public FactoryPeriRetGan() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PeriRetGan periretgan = (PeriRetGan) objLog;
    periretgan.setOID(db.getInteger(DBPeriRetGan.OID_PERI_RET_GAN));
    periretgan.setFecdesde(db.getDate(DBPeriRetGan.FEC_DESDE));
    periretgan.setFechasta(db.getDate(DBPeriRetGan.FEC_HASTA));
    periretgan.setDescripcion(db.getString(DBPeriRetGan.DESCRIPCION));
    periretgan.setCodinterno(db.getString(DBPeriRetGan.CODIGO_INTERNO));
    periretgan.setActivo(db.getBoolean(DBPeriRetGan.ACTIVO));

  }
}
