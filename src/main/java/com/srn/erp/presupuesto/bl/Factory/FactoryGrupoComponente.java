package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.GrupoComponente;
import com.srn.erp.presupuesto.da.DBGrupoComponente;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoComponente extends FactoryObjetoLogico { 

  public FactoryGrupoComponente() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoComponente grupocomponente = (GrupoComponente) objLog;
    grupocomponente.setOID(db.getInteger(DBGrupoComponente.OID_GRUPO_COMPO));
    grupocomponente.setCodigo(db.getString(DBGrupoComponente.CODIGO));
    grupocomponente.setDescripcion(db.getString(DBGrupoComponente.DESCRIPCION));
    grupocomponente.setActivo(db.getBoolean(DBGrupoComponente.ACTIVO));

  }
}
