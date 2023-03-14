package com.srn.erp.legales.bl.Factory;


import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.legales.bm.ConcPagoSeclo;
import com.srn.erp.legales.da.DBConcPagoSeclo;

public class FactoryConcPagoSeclo extends FactoryObjetoLogico { 

  public FactoryConcPagoSeclo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConcPagoSeclo concpagoseclo = (ConcPagoSeclo) objLog;
    concpagoseclo.setOID(db.getInteger(DBConcPagoSeclo.OID_CONC_PAGO_SECLO));
    concpagoseclo.setDescripcion(db.getString(DBConcPagoSeclo.DESCRIPCION));
    concpagoseclo.setActivo(db.getBoolean(DBConcPagoSeclo.ACTIVO));
  }
}
