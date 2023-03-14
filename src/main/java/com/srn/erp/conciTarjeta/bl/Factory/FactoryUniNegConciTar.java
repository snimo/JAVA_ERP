package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.UniNegConciTar;
import com.srn.erp.conciTarjeta.da.DBUniNegConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryUniNegConciTar extends FactoryObjetoLogico { 

  public FactoryUniNegConciTar() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UniNegConciTar uninegconcitar = (UniNegConciTar) objLog;
    uninegconcitar.setOID(db.getInteger(DBUniNegConciTar.OID_UNI_NEG));
    uninegconcitar.setDescripcion(db.getString(DBUniNegConciTar.DESCRIPCION));
    uninegconcitar.setEmpresa(EmpresaConciTar.findByOidProxy(db.getInteger(DBUniNegConciTar.OID_EMPRESA),getSesion()));
    uninegconcitar.setActivo(db.getBoolean(DBUniNegConciTar.ACTIVO));
    uninegconcitar.setCtaTarjetaACobrar(db.getString(DBUniNegConciTar.ACOB_CTA_TARJ));
    uninegconcitar.setCtaTarjetaACobrarC1(db.getString(DBUniNegConciTar.ACOB_CTA_TARJ_C1));
    uninegconcitar.setCtaTarjetaACobrarC2(db.getString(DBUniNegConciTar.ACOB_CTA_TARJ_C2));    
  }
}
