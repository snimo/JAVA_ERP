package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.Bien;
import com.srn.erp.bienUso.bm.BienImputacion;
import com.srn.erp.bienUso.da.DBBienImputacion;
import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryBienImputacion extends FactoryObjetoLogico { 

  public FactoryBienImputacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    BienImputacion bienimputacion = (BienImputacion) objLog;
    bienimputacion.setOID(db.getInteger(DBBienImputacion.OID_BIEN_IMPU));
    bienimputacion.setBien_uso(Bien.findByOidProxy(db.getInteger(DBBienImputacion.OID_BIEN_USO),getSesion()));
    bienimputacion.setVigencia_desde(db.getDate(DBBienImputacion.VIGENCIA_DESDE));
    bienimputacion.setCuenta_imputable(CuentaImputable.findByOidProxy(db.getInteger(DBBienImputacion.OID_AI),getSesion()));
    bienimputacion.setPorc(db.getDouble(DBBienImputacion.PORC));
    bienimputacion.setActivo(db.getBoolean(DBBienImputacion.ACTIVO));
  }
}
