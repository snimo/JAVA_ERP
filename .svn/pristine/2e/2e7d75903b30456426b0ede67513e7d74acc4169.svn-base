package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.da.DBTipoCambio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoCambio extends FactoryObjetoLogico {

  public FactoryTipoCambio() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoCambio tipocambio = (TipoCambio) objLog;
  tipocambio.setOID(db.getInteger(DBTipoCambio.OID_TIPO_CAMBIO));
    tipocambio.setCodigo(db.getString(DBTipoCambio.CODIGO));
    tipocambio.setDescripcion(db.getString(DBTipoCambio.DESCRIPCION));
    tipocambio.setActivo(db.getBoolean(DBTipoCambio.ACTIVO));

  }
}
