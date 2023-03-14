package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.ConfigTalonarioDevVtas;
import com.srn.erp.ventas.bm.OperHabiTalonarioDevVtas;
import com.srn.erp.ventas.da.DBOperHabiTalonarioDevVtas;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryOperHabiTalonarioDevVtas extends FactoryObjetoLogico { 

  public FactoryOperHabiTalonarioDevVtas() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    OperHabiTalonarioDevVtas operhabitalonariodevvtas = (OperHabiTalonarioDevVtas) objLog;
    operhabitalonariodevvtas.setOID(db.getInteger(DBOperHabiTalonarioDevVtas.OID_OPER_TAL_DEV));
    operhabitalonariodevvtas.setConf_tal_dev(ConfigTalonarioDevVtas.findByOidProxy(db.getInteger(DBOperHabiTalonarioDevVtas.OID_CONF_TAL_DEV),getSesion()));
    operhabitalonariodevvtas.setTipo_devolucion(db.getString(DBOperHabiTalonarioDevVtas.TIPO_DEV));
    operhabitalonariodevvtas.setUsar_por_defecto(db.getBoolean(DBOperHabiTalonarioDevVtas.USAR_POR_DEFECTO));

  }
}
