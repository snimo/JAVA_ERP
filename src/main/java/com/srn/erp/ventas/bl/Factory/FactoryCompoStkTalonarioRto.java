package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioRto;
import com.srn.erp.ventas.bm.OperHabiTalonarioRto;
import com.srn.erp.ventas.da.DBCompoStkTalonarioRto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCompoStkTalonarioRto extends FactoryObjetoLogico {

  public FactoryCompoStkTalonarioRto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CompoStkTalonarioRto compostktalonariorto = (CompoStkTalonarioRto) objLog;
    compostktalonariorto.setOID(db.getInteger(DBCompoStkTalonarioRto.OID_COMPO_STK_RTO));
    compostktalonariorto.setOper_tal_rto(OperHabiTalonarioRto.findByOidProxy(db.getInteger(DBCompoStkTalonarioRto.OID_OPER_TAL_RTO),getSesion()));
    compostktalonariorto.setTipo_conf_mov(TipoConfMovStkTalonario.findByOidProxy(db.getInteger(DBCompoStkTalonarioRto.OID_TIPO_CONF_MOV),getSesion()));
    compostktalonariorto.setUsarPorDefecto(db.getBoolean(DBCompoStkTalonarioRto.USAR_POR_DEFECTO));
  }
}
