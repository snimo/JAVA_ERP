package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.DriverSubreparto;
import com.srn.erp.contabilidad.da.DBDriverSubreparto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDriverSubreparto extends FactoryObjetoLogico { 

  public FactoryDriverSubreparto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DriverSubreparto driversubreparto = (DriverSubreparto) objLog;
    driversubreparto.setOID(db.getInteger(DBDriverSubreparto.OID_DRIVER));
    driversubreparto.setCodigo(db.getString(DBDriverSubreparto.CODIGO));
    driversubreparto.setDescripcion(db.getString(DBDriverSubreparto.DESCRIPCION));
    driversubreparto.setTipo_valor(db.getString(DBDriverSubreparto.TIPO_VALOR));
    driversubreparto.setValor(db.getDouble(DBDriverSubreparto.VALOR));
    driversubreparto.setComponente(Componente.findByOidProxy(db.getInteger(DBDriverSubreparto.OID_COMPO),getSesion()));
    driversubreparto.setActivo(db.getBoolean(DBDriverSubreparto.ACTIVO));
    driversubreparto.setTipoSaldo(db.getString(DBDriverSubreparto.TIPO_SALDO));
  }
}
