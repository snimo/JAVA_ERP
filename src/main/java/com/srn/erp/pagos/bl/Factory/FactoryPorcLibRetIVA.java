package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.bm.PorcLibRetIVA;
import com.srn.erp.pagos.da.DBPorcLibRetIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPorcLibRetIVA extends FactoryObjetoLogico {

  public FactoryPorcLibRetIVA() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PorcLibRetIVA porclibretiva = (PorcLibRetIVA) objLog;
    porclibretiva.setOID(db.getInteger(DBPorcLibRetIVA.OID_LIB_RET_IVA));
    porclibretiva.setSujetoimpositivo(SujetoImpositivo.findByOidProxy(db.getInteger(DBPorcLibRetIVA.OID_SUJ_IMP),getSesion()));
    porclibretiva.setFechadesde(db.getDate(DBPorcLibRetIVA.FEC_DESDE));
    porclibretiva.setFechahasta(db.getDate(DBPorcLibRetIVA.FEC_HASTA));
    porclibretiva.setPorcentaje(db.getMoney(DBPorcLibRetIVA.PORC));
    porclibretiva.setDecreto(db.getString(DBPorcLibRetIVA.DECRETO));
    porclibretiva.setActivo(db.getBoolean(DBPorcLibRetIVA.ACTIVO));
  }
}
