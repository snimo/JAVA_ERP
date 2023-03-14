package com.srn.erp.Ausentismo.bl.Factory;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneral;
import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralDesc;
import com.srn.erp.Ausentismo.da.DBGrupoRRHHGeneralDesc;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoRRHHGeneralDesc extends FactoryObjetoLogico { 

  public FactoryGrupoRRHHGeneralDesc() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoRRHHGeneralDesc gruporrhhgeneraldesc = (GrupoRRHHGeneralDesc) objLog;
    gruporrhhgeneraldesc.setOID(db.getInteger(DBGrupoRRHHGeneralDesc.OID_GRUPO_GRAL_DESC));
    gruporrhhgeneraldesc.setGrupogral(GrupoRRHHGeneral.findByOid(db.getInteger(DBGrupoRRHHGeneralDesc.OID_GRUPO_GRAL),getSesion()));
    gruporrhhgeneraldesc.setDescripcion(db.getString(DBGrupoRRHHGeneralDesc.DESCRIPCION));
    gruporrhhgeneraldesc.setActivo(db.getBoolean(DBGrupoRRHHGeneralDesc.ACTIVO));
  }
}