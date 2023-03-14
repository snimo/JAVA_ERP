package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.ObsCodifPresuCab;
import com.srn.erp.ventas.bm.ObsCodifVtas;
import com.srn.erp.ventas.da.DBObsCodifPresuCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryObsCodifPresuCab extends FactoryObjetoLogico { 

  public FactoryObsCodifPresuCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ObsCodifPresuCab obscodifpresucab = (ObsCodifPresuCab) objLog;
    obscodifpresucab.setOID(db.getInteger(DBObsCodifPresuCab.OID_OBS_CODIF));
    obscodifpresucab.setPresupuesto(CotizacionCab.findByOidProxy(db.getInteger(DBObsCodifPresuCab.OID_CCO_PRESU),getSesion()));
    obscodifpresucab.setOrden(db.getInteger(DBObsCodifPresuCab.ORDEN));
    obscodifpresucab.setObs_codificada(ObsCodifVtas.findByOidProxy(db.getInteger(DBObsCodifPresuCab.OID_OBS_COD),getSesion()));
    obscodifpresucab.setActivo(db.getBoolean(DBObsCodifPresuCab.ACTIVO));

  }
}
