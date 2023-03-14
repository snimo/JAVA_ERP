package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.Biometrico;
import com.srn.erp.cip.da.DBBiometrico;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryBiometrico extends FactoryObjetoLogico { 

  public FactoryBiometrico() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Biometrico biometrico = (Biometrico) objLog;
    biometrico.setOID(db.getInteger(DBBiometrico.ID_BIOMETRICO));
    biometrico.setCodigo(db.getString(DBBiometrico.CODIGO));
    biometrico.setDescripcion(db.getString(DBBiometrico.DESCRIPCION));
    biometrico.setIp(db.getString(DBBiometrico.IP));
    biometrico.setPuerto(db.getInteger(DBBiometrico.PUERTO));
    biometrico.setTipo_biometrico(db.getString(DBBiometrico.TIPO_BIOMETRICO));
    biometrico.setNro_biometrico(db.getInteger(DBBiometrico.NRO_BIOMETRICO));
    biometrico.setActivo(db.getBoolean(DBBiometrico.ACTIVO));

  }
}
