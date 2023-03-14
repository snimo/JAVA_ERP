package com.srn.erp.Ausentismo.bl.Factory;

import com.srn.erp.Ausentismo.bm.GrupoRRHH;
import com.srn.erp.Ausentismo.da.DBGrupoRRHH;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoRRHH extends FactoryObjetoLogico { 

  public FactoryGrupoRRHH() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoRRHH grupo = (GrupoRRHH) objLog;
   grupo.setOID(db.getInteger(DBGrupoRRHH.OID_GRUPO));
    grupo.setTipo(db.getString(DBGrupoRRHH.TIPO));
    grupo.setNombre(db.getString(DBGrupoRRHH.NOMBRE));
    grupo.setActivo(db.getBoolean(DBGrupoRRHH.ACTIVO));

  }
}