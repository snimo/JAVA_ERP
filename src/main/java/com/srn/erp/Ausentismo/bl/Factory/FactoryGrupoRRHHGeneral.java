package com.srn.erp.Ausentismo.bl.Factory;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneral;
import com.srn.erp.Ausentismo.da.DBGrupoRRHHGeneral;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoRRHHGeneral extends FactoryObjetoLogico { 

  public FactoryGrupoRRHHGeneral() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoRRHHGeneral gruporrhhgeneral = (GrupoRRHHGeneral) objLog;
   gruporrhhgeneral.setOID(db.getInteger(DBGrupoRRHHGeneral.OID_GRUPO_GRAL));
    gruporrhhgeneral.setTipo(db.getString(DBGrupoRRHHGeneral.TIPO));
    gruporrhhgeneral.setNombre(db.getString(DBGrupoRRHHGeneral.NOMBRE));
    gruporrhhgeneral.setActivo(db.getBoolean(DBGrupoRRHHGeneral.ACTIVO));

  }
}
