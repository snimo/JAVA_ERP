package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.UbiDepoHabTalonario;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.stock.da.DBUbiDepoHabTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryUbiDepoHabTalonario extends FactoryObjetoLogico {

  public FactoryUbiDepoHabTalonario() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UbiDepoHabTalonario ubidepohabtalonario = (UbiDepoHabTalonario) objLog;
    ubidepohabtalonario.setOID(db.getInteger(DBUbiDepoHabTalonario.OID_UBI_DEPO_TAL));
    ubidepohabtalonario.setMov_stk_tal(MovStockTalonarioDeposito.findByOidProxy(db.getInteger(DBUbiDepoHabTalonario.OID_MOV_STK_TAL),getSesion()));
    ubidepohabtalonario.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(db.getInteger(DBUbiDepoHabTalonario.OID_UBI_DEPO),getSesion()));
    ubidepohabtalonario.setHabilitado(db.getBoolean(DBUbiDepoHabTalonario.HABILITADO));
    ubidepohabtalonario.setIncluye_hijos(db.getBoolean(DBUbiDepoHabTalonario.INCLUYE_HIJOS));
    ubidepohabtalonario.setUsar_por_defecto(db.getBoolean(DBUbiDepoHabTalonario.USAR_POR_DEFECTO));
    ubidepohabtalonario.setActivo(db.getBoolean(DBUbiDepoHabTalonario.ACTIVO));

  }
}
