package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.da.DBMoneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;

public class FactoryMoneda extends FactoryObjetoLogico {

  public FactoryMoneda() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Moneda moneda = (Moneda) objLog;
    moneda.setOID(db.getInteger(DBMoneda.OID_MONEDA));
    moneda.setCodigo(db.getString(DBMoneda.CODIGO));
    moneda.setDescripcion(db.getString(DBMoneda.DESCRIPCION));
    moneda.setBase(new ValorCotizacion(db.getDouble(DBMoneda.BASE)));
    moneda.setActivo(db.getBoolean(DBMoneda.ACTIVO));
    moneda.setSimbolo(db.getString(DBMoneda.SIMBOLO));
  }
}
