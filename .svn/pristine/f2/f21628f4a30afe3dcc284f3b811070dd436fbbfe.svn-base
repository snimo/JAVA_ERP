package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.ventas.bm.ObsCodifVtas;
import com.srn.erp.ventas.bm.ObsCodifVtasSucursal;
import com.srn.erp.ventas.da.DBObsCodifVtasSucursal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryObsCodifVtasSucursal extends FactoryObjetoLogico { 

  public FactoryObsCodifVtasSucursal() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ObsCodifVtasSucursal obscodifvtassucursal = (ObsCodifVtasSucursal) objLog;
    obscodifvtassucursal.setOID(db.getInteger(DBObsCodifVtasSucursal.OID_OBS_COD_UO));
    obscodifvtassucursal.setCodigo_observacion(ObsCodifVtas.findByOidProxy(db.getInteger(DBObsCodifVtasSucursal.OID_OBS_COD),getSesion()));
    obscodifvtassucursal.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBObsCodifVtasSucursal.OID_SUCURSAL),getSesion()));
    obscodifvtassucursal.setActivo(db.getBoolean(DBObsCodifVtasSucursal.ACTIVO));

  }
}
