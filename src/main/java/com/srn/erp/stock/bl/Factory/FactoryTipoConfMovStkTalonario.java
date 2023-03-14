package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.da.DBTipoConfMovStkTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoConfMovStkTalonario extends FactoryObjetoLogico {

  public FactoryTipoConfMovStkTalonario() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoConfMovStkTalonario tipoconfmovstktalonario = (TipoConfMovStkTalonario) objLog;
    tipoconfmovstktalonario.setOID(db.getInteger(DBTipoConfMovStkTalonario.OID_TIPO_CONF_MOV));
    tipoconfmovstktalonario.setConf_mov_stk(ConfMovStkTalonario.findByOidProxy(db.getInteger(DBTipoConfMovStkTalonario.OID_CONF_MOV_STK),getSesion()));
    tipoconfmovstktalonario.setCodigo(db.getString(DBTipoConfMovStkTalonario.CODIGO));
    tipoconfmovstktalonario.setDescripcion(db.getString(DBTipoConfMovStkTalonario.DESCRIPCION));
    tipoconfmovstktalonario.setActivo(db.getBoolean(DBTipoConfMovStkTalonario.ACTIVO));
    tipoconfmovstktalonario.setTipoMovimiento(db.getString(DBTipoConfMovStkTalonario.TIPO_MOV));
  }
}
