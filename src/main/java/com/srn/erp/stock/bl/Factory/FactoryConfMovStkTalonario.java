package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.da.DBConfMovStkTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfMovStkTalonario extends FactoryObjetoLogico {

  public FactoryConfMovStkTalonario() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfMovStkTalonario confmovstktalonario = (ConfMovStkTalonario) objLog;
    confmovstktalonario.setOID(db.getInteger(DBConfMovStkTalonario.OID_CONF_MOV_STK));
    confmovstktalonario.setTalonario(Talonario.findByOidProxy(db.getInteger(DBConfMovStkTalonario.OID_TALONARIO),getSesion()));
    confmovstktalonario.setActivo(db.getBoolean(DBConfMovStkTalonario.ACTIVO));

  }
}
