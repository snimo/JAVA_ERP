package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CategAccValClasif;
import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.da.DBCategAccValClasif;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCategAccValClasif extends FactoryObjetoLogico { 

  public FactoryCategAccValClasif() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CategAccValClasif categaccvalclasif = (CategAccValClasif) objLog;
    categaccvalclasif.setOID(db.getInteger(DBCategAccValClasif.OID_CATEG_ACC_VCLA));
    categaccvalclasif.setCategoria(CategAccesoCIP.findByOidProxy(db.getInteger(DBCategAccValClasif.OID_CATEG_ACCESO),getSesion()));
    categaccvalclasif.setActivo(db.getBoolean(DBCategAccValClasif.ACTIVO));
    categaccvalclasif.setVal_clasif_ent(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBCategAccValClasif.OID_VAL_CLASIF_ENT),getSesion()));

  }
}
