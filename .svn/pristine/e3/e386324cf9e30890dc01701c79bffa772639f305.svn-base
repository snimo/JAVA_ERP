package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.bm.PorcLibRetGan;
import com.srn.erp.pagos.da.DBPorcLibRetGan;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPorcLibRetGan extends FactoryObjetoLogico {

  public FactoryPorcLibRetGan() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PorcLibRetGan porclibretgan = (PorcLibRetGan) objLog;
    porclibretgan.setOID(db.getInteger(DBPorcLibRetGan.OID_LIB_RET_GAN));
    porclibretgan.setSujetoimpositivo(SujetoImpositivo.findByOidProxy(db.getInteger(DBPorcLibRetGan.OID_SUJ_IMP),getSesion()));
    porclibretgan.setFechadesde(db.getDate(DBPorcLibRetGan.FEC_DESDE));
    porclibretgan.setFechahasta(db.getDate(DBPorcLibRetGan.FEC_HASTA));
    porclibretgan.setPorcentaje(db.getMoney(DBPorcLibRetGan.PORC));
    porclibretgan.setActivo(db.getBoolean(DBPorcLibRetGan.ACTIVO));
    porclibretgan.setDecreto(db.getString(DBPorcLibRetGan.DECRETO));
  }
}
