package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.Subdiario;
import com.srn.erp.contabilidad.bm.SubdiarioDet;
import com.srn.erp.contabilidad.da.DBSubdiarioDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySubdiarioDet extends FactoryObjetoLogico { 

  public FactorySubdiarioDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SubdiarioDet subdiariodet = (SubdiarioDet) objLog;
    subdiariodet.setOID(db.getInteger(DBSubdiarioDet.OID_SUBDIARIO_DET));
    subdiariodet.setSubdiario(Subdiario.findByOidProxy(db.getInteger(DBSubdiarioDet.OID_SUBDIARIO),getSesion()));
    subdiariodet.setCuenta(Cuenta.findByOidProxy(db.getInteger(DBSubdiarioDet.OID_ANA_CON),getSesion()));
    subdiariodet.setActivo(db.getBoolean(DBSubdiarioDet.ACTIVO));

  }
}
