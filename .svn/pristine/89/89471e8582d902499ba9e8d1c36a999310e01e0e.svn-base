package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioDevVtas;
import com.srn.erp.ventas.bm.OperHabiTalonarioDevVtas;
import com.srn.erp.ventas.da.DBCompoStkTalonarioDevVtas;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCompoStkTalonarioDevVtas extends FactoryObjetoLogico { 

  public FactoryCompoStkTalonarioDevVtas() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CompoStkTalonarioDevVtas compostktalonariodevvtas = (CompoStkTalonarioDevVtas) objLog;
    compostktalonariodevvtas.setOID(db.getInteger(DBCompoStkTalonarioDevVtas.OID_COMPO_STK_DEV));
    compostktalonariodevvtas.setOper_hab_tal_dev(OperHabiTalonarioDevVtas.findByOidProxy(db.getInteger(DBCompoStkTalonarioDevVtas.OID_OPER_TAL_DEV),getSesion()));
    compostktalonariodevvtas.setTipo_conf_mov(TipoConfMovStkTalonario.findByOidProxy(db.getInteger(DBCompoStkTalonarioDevVtas.OID_TIPO_CONF_MOV),getSesion()));
    compostktalonariodevvtas.setUsar_por_defecto(db.getBoolean(DBCompoStkTalonarioDevVtas.USAR_POR_DEFECTO));

  }
}
