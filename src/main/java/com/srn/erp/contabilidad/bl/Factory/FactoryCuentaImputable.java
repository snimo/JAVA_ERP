package com.srn.erp.contabilidad.bl.Factory;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.EstructuraCompo;
import com.srn.erp.contabilidad.da.DBCuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCuentaImputable extends FactoryObjetoLogico {

  public FactoryCuentaImputable() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {

    CuentaImputable cuentaimputable = (CuentaImputable) objLog;
    cuentaimputable.setOID(db.getInteger(DBCuentaImputable.OID_AI));
    Cuenta cuenta = Cuenta.findByOid(db.getInteger(DBCuentaImputable.OID_ANA_CON),getSesion());
    cuentaimputable.setCuenta(cuenta);
    cuentaimputable.setActivo(db.getBoolean(DBCuentaImputable.ACTIVO));

    // Agregar los componentes de la cuenta
    if (cuenta.getEstructura()!=null) {
      Iterator iterEstCompo =
          cuenta.getEstructura().getEstrucComponenentes().iterator();
      while (iterEstCompo.hasNext()) {
        EstructuraCompo estrucCompo =
            (EstructuraCompo) iterEstCompo.next();
        if (!estrucCompo.isActivo().booleanValue())
        	continue;
        IObjetoLogico objetoLogico =
            estrucCompo.getComponente().getValorCompo(db.getInteger(estrucCompo.getComponente().getCampoFisicoAnaImp()));
        cuentaimputable.addValorCompo(estrucCompo.getComponente(),objetoLogico);
      }
    }
  }

}
