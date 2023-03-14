package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.FacturaElectronicaCab;
import com.srn.erp.ventas.da.DBFacturaElectronicaCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFacturaElectronicaCab extends FactoryObjetoLogico { 

  public FactoryFacturaElectronicaCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FacturaElectronicaCab facturaelectronicacab = (FacturaElectronicaCab) objLog;
    facturaelectronicacab.setOID(db.getInteger(DBFacturaElectronicaCab.OID_CCO_FACT));
    facturaelectronicacab.setHomologada_fe(db.getBoolean(DBFacturaElectronicaCab.HOMOLOGADA_FE));
    facturaelectronicacab.setFechora_homologada_fe(db.getDate(DBFacturaElectronicaCab.FECHORA_HOMOLOGADA_FE));
    facturaelectronicacab.setUsu_homologada_fe(db.getString(DBFacturaElectronicaCab.USU_HOMOLOGADA_FE));
    facturaelectronicacab.setCae_fe(db.getString(DBFacturaElectronicaCab.CAE_FE));
    facturaelectronicacab.setFec_vto_cae_fe(db.getDate(DBFacturaElectronicaCab.FEC_VTO_CAE_FE));

  }
}
