package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.bm.PorcLibRetIB;
import com.srn.erp.pagos.da.DBPorcLibRetIB;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPorcLibRetIB extends FactoryObjetoLogico {

  public FactoryPorcLibRetIB() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PorcLibRetIB porclibretib = (PorcLibRetIB) objLog;
    porclibretib.setOID(db.getInteger(DBPorcLibRetIB.OID_LIB_RET_IB));
    porclibretib.setSujetoimpositivo(SujetoImpositivo.findByOidProxy(db.getInteger(DBPorcLibRetIB.OID_SUJ_IMP),getSesion()));
    porclibretib.setFechadesde(db.getDate(DBPorcLibRetIB.FEC_DESDE));
    porclibretib.setFechahasta(db.getDate(DBPorcLibRetIB.FEC_HASTA));
    porclibretib.setPorcentaje(db.getMoney(DBPorcLibRetIB.PORC));
    porclibretib.setActivo(db.getBoolean(DBPorcLibRetIB.ACTIVO));
    porclibretib.setDecreto(db.getString(DBPorcLibRetIB.DECRETO));

  }
}
