package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.BonifRecarSujeto;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.da.DBBonifRecarSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryBonifRecarSujeto extends FactoryObjetoLogico {

  public FactoryBonifRecarSujeto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    BonifRecarSujeto bonifrecarsujeto = (BonifRecarSujeto) objLog;
    bonifrecarsujeto.setOID(db.getInteger(DBBonifRecarSujeto.OID_BONIF_RECAR));
    bonifrecarsujeto.setFec_vig_desde(db.getDate(DBBonifRecarSujeto.FEC_VIG_DESDE));
    bonifrecarsujeto.setFec_vig_hasta(db.getDate(DBBonifRecarSujeto.FEC_VIG_HASTA));
    bonifrecarsujeto.setBonif1(db.getDecimal(DBBonifRecarSujeto.BONIF1));
    bonifrecarsujeto.setBonif2(db.getDecimal(DBBonifRecarSujeto.BONIF2));
    bonifrecarsujeto.setBonif3(db.getDecimal(DBBonifRecarSujeto.BONIF3));
    bonifrecarsujeto.setBonif4(db.getDecimal(DBBonifRecarSujeto.BONIF4));
    bonifrecarsujeto.setBonif5(db.getDecimal(DBBonifRecarSujeto.BONIF5));
    bonifrecarsujeto.setEn_cascada_bonif(db.getBoolean(DBBonifRecarSujeto.EN_CASCADA_BONIF));
    bonifrecarsujeto.setReca1(db.getDecimal(DBBonifRecarSujeto.RECA1));
    bonifrecarsujeto.setReca2(db.getDecimal(DBBonifRecarSujeto.RECA2));
    bonifrecarsujeto.setReca3(db.getDecimal(DBBonifRecarSujeto.RECA3));
    bonifrecarsujeto.setReca4(db.getDecimal(DBBonifRecarSujeto.RECA4));
    bonifrecarsujeto.setReca5(db.getDecimal(DBBonifRecarSujeto.RECA5));
    bonifrecarsujeto.setEn_cascada_reca(db.getBoolean(DBBonifRecarSujeto.EN_CASCADA_RECA));
    bonifrecarsujeto.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBBonifRecarSujeto.OID_SUJETO),getSesion()));

  }
}
