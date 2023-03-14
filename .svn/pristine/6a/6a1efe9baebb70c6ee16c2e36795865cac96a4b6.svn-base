package com.srn.erp.cashflow.bl.Factory;

import com.srn.erp.cashflow.bm.CajaSaldoIniCF;
import com.srn.erp.cashflow.bm.TipoValorSICajaCF;
import com.srn.erp.cashflow.da.DBTipoValorSICajaCF;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoValorSICajaCF extends FactoryObjetoLogico { 

  public FactoryTipoValorSICajaCF() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoValorSICajaCF tipovalorsicajacf = (TipoValorSICajaCF) objLog;
    tipovalorsicajacf.setOID(db.getInteger(DBTipoValorSICajaCF.OID_TV_SAL_INI));
    tipovalorsicajacf.setSaldo_inicial_caja(CajaSaldoIniCF.findByOidProxy(db.getInteger(DBTipoValorSICajaCF.OID_SAL_INI_CAJA),getSesion()));
    tipovalorsicajacf.setTipo_valor(TipoValor.findByOidProxy(db.getInteger(DBTipoValorSICajaCF.OID_TIPO_VALOR),getSesion()));
    tipovalorsicajacf.setActivo(db.getBoolean(DBTipoValorSICajaCF.ACTIVO));
    

  }
}
