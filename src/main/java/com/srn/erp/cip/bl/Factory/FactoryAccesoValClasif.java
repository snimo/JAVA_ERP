package com.srn.erp.cip.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cip.bm.AccesoValClasif;
import com.srn.erp.cip.da.DBAccesoValClasif;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

public class FactoryAccesoValClasif extends FactoryObjetoLogico { 

  public FactoryAccesoValClasif() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AccesoValClasif accesovalclasif = (AccesoValClasif) objLog;
    accesovalclasif.setOID(db.getInteger(DBAccesoValClasif.OID_VAL_ACCESO));
    accesovalclasif.setTipo_ingreso(db.getString(DBAccesoValClasif.TIPO_INGRESO));
    accesovalclasif.setLey_no_ingreso(db.getString(DBAccesoValClasif.LEY_NO_INGRESO));
    accesovalclasif.setMin_ent_antes(db.getInteger(DBAccesoValClasif.MIN_ENT_ANTES));
    accesovalclasif.setMin_ent_despues(db.getInteger(DBAccesoValClasif.MIN_ENT_DESPUES));
    accesovalclasif.setTipo_egreso(db.getString(DBAccesoValClasif.TIPO_EGRESO));
    accesovalclasif.setLey_no_egreso(db.getString(DBAccesoValClasif.LEY_NO_EGRESO));
    accesovalclasif.setAntipassback(db.getBoolean(DBAccesoValClasif.ANTIPASSBACK));
    accesovalclasif.setCacheo(db.getBoolean(DBAccesoValClasif.CACHEO));
    accesovalclasif.setActivo(db.getBoolean(DBAccesoValClasif.ACTIVO));
    accesovalclasif.setValorClasificador(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBAccesoValClasif.OID_VAL_CLASIF), this.getSesion()));
  }
}
