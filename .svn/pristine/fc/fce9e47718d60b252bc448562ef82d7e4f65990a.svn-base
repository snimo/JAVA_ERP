package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.CabConciAutomatica;
import com.srn.erp.conciTarjeta.da.DBCabConciAutomatica;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryCabConciAutomatica extends FactoryObjetoLogico { 

  public FactoryCabConciAutomatica() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CabConciAutomatica cabconciautomatica = (CabConciAutomatica) objLog;
    cabconciautomatica.setOID(db.getInteger(DBCabConciAutomatica.OID_CAB_CONCI_AUT));
    cabconciautomatica.setUsuario(Usuario.findByOidProxy(db.getInteger(DBCabConciAutomatica.OID_USUARIO),getSesion()));
    cabconciautomatica.setFecha(db.getDate(DBCabConciAutomatica.FECHA));
    cabconciautomatica.setHora(db.getString(DBCabConciAutomatica.HORA));
    cabconciautomatica.setActivo(db.getBoolean(DBCabConciAutomatica.ACTIVO));

  }
}
