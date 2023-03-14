package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.bm.RetPorcLib;
import com.srn.erp.pagos.da.DBRetPorcLib;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRetPorcLib extends FactoryObjetoLogico {

  public FactoryRetPorcLib() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RetPorcLib retporclib = (RetPorcLib) objLog;
    retporclib.setOID(db.getInteger(DBRetPorcLib.OID_RET_PORC_LIB));
    retporclib.setSujetoimpositivo(SujetoImpositivo.findByOidProxy(db.getInteger(DBRetPorcLib.OID_SUJ_IMP),getSesion()));
    retporclib.setCompoimpu(db.getString(DBRetPorcLib.COMPO_IMPU));
    retporclib.setDecreto(db.getString(DBRetPorcLib.DECRETO));
    retporclib.setFecvigdesde(db.getDate(DBRetPorcLib.FEC_VIG_DESDE));
    retporclib.setFecvighasta(db.getDate(DBRetPorcLib.FEC_VIG_HASTA));
    retporclib.setPorclib(db.getMoney(DBRetPorcLib.PORC_LIB));
    retporclib.setActivo(db.getBoolean(DBRetPorcLib.ACTIVO));
  }
}
