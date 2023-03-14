package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.RemitoCabAnulacion;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.bm.RemitoDetAnulacion;
import com.srn.erp.ventas.da.DBRemitoDetAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRemitoDetAnulacion extends FactoryObjetoLogico { 

  public FactoryRemitoDetAnulacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RemitoDetAnulacion remitodetanulacion = (RemitoDetAnulacion) objLog;
   remitodetanulacion.setOID(db.getInteger(DBRemitoDetAnulacion.OID_RTO_DET_ANU));
    remitodetanulacion.setRemito_cab_anu(RemitoCabAnulacion.findByOidProxy(db
				.getInteger(DBRemitoDetAnulacion.OID_RTO_CAB_ANU), getSesion()));
		remitodetanulacion.setRemito_det(RemitoDet.findByOidProxy(db.getInteger(DBRemitoDetAnulacion.OID_REMITO_DET),
				getSesion()));

	}
}
