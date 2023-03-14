package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.da.DBCotizacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCotizacion extends FactoryObjetoLogico {

  public FactoryCotizacion() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Cotizacion cotizacion = (Cotizacion) objLog;
    cotizacion.setOID(db.getInteger(DBCotizacion.OID_COTIZACION));
    cotizacion.setFechavig(db.getDate(DBCotizacion.FECHA_VIG));
    cotizacion.setTipocambio(TipoCambio.findByOidProxy(db.getInteger(DBCotizacion.OID_TIPO_CAMBIO),getSesion()));
    cotizacion.setCotizacion(db.getCotizacion(DBCotizacion.COTIZACION));
    cotizacion.setMoneda(Moneda.findByOidProxy(db.getInteger(DBCotizacion.OID_MONEDA),getSesion()));
    cotizacion.setActivo(db.getBoolean(DBCotizacion.ACTIVO));

  }
}
