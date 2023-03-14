package com.srn.erp.cip.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cip.bm.MotivosNovCIP;
import com.srn.erp.cip.da.DBMotivosNovCIP;

public class FactoryMotivosNovCIP extends FactoryObjetoLogico { 

  public FactoryMotivosNovCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivosNovCIP motivosnovcip = (MotivosNovCIP) objLog;
    motivosnovcip.setOID(db.getInteger(DBMotivosNovCIP.OID_MOTIVO));
    motivosnovcip.setCodigo(db.getString(DBMotivosNovCIP.CODIGO));
    motivosnovcip.setDescripcion(db.getString(DBMotivosNovCIP.DESCRIPCION));
    motivosnovcip.setActivo(db.getBoolean(DBMotivosNovCIP.ACTIVO));
    motivosnovcip.setHabParaIngresos(db.getBoolean(DBMotivosNovCIP.HAB_PARA_INGRESOS));
    motivosnovcip.setHabParaEgresos(db.getBoolean(DBMotivosNovCIP.HAB_PARA_EGRESOS));
    motivosnovcip.setCompoExtIngreso(db.getString(DBMotivosNovCIP.COMPO_EXT_ING));
    motivosnovcip.setCompoExtEgreso(db.getString(DBMotivosNovCIP.COMPO_EXT_EGR));
    motivosnovcip.setMinEntAnt(db.getInteger(DBMotivosNovCIP.MIN_ENT_ANT));
    motivosnovcip.setMinEntDes(db.getInteger(DBMotivosNovCIP.MIN_ENT_DES));
    motivosnovcip.setAnulaRotaDelDia(db.getBoolean(DBMotivosNovCIP.ANULA_ROTA_DEL_DIA));
    
    motivosnovcip.setHoraDesdeIng(db.getString(DBMotivosNovCIP.HORA_DESDE_ING));
    motivosnovcip.setHoraHastaIng(db.getString(DBMotivosNovCIP.HORA_HASTA_ING));
    motivosnovcip.setHoraDesdeEgr(db.getString(DBMotivosNovCIP.HORA_DESDE_EGR));
    motivosnovcip.setHoraHastaEgr(db.getString(DBMotivosNovCIP.HORA_HASTA_EGR));
    
    motivosnovcip.setHoraDesdeIngMin(db.getInteger(DBMotivosNovCIP.HORA_DESDE_ING_MIN));
    motivosnovcip.setHoraHastaIngMin(db.getInteger(DBMotivosNovCIP.HORA_HASTA_ING_MIN));
    motivosnovcip.setHoraDesdeEgrMin(db.getInteger(DBMotivosNovCIP.HORA_DESDE_EGR_MIN));
    motivosnovcip.setHoraHastaEgrMin(db.getInteger(DBMotivosNovCIP.HORA_HASTA_EGR_MIN));
    
  }
}
