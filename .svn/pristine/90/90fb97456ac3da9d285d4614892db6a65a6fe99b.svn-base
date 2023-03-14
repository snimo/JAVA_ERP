package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.CotizacionCabAnulacion;
import com.srn.erp.ventas.bm.CotizacionDet;
import com.srn.erp.ventas.bm.CotizacionDetAnulacion;
import com.srn.erp.ventas.da.DBCotizacionDetAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCotizacionDetAnulacion extends FactoryObjetoLogico {

	public FactoryCotizacionDetAnulacion() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		CotizacionDetAnulacion cotizaciondetanulacion = (CotizacionDetAnulacion) objLog;
		cotizaciondetanulacion.setOID(db.getInteger(DBCotizacionDetAnulacion.OID_COT_DET_ANU));
		cotizaciondetanulacion.setCotizacion_cab_anu(CotizacionCabAnulacion.findByOidProxy(db
				.getInteger(DBCotizacionDetAnulacion.OID_COT_CAB_ANU), getSesion()));
		cotizaciondetanulacion.setCotizacion_det(CotizacionDet.findByOidProxy(db.getInteger(DBCotizacionDetAnulacion.OID_COTIZACION_DET),
				getSesion()));

	}
}
