package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.SolicitarAPedMerc;
import com.srn.erp.stock.da.DBSolicitarAPedMerc;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySolicitarAPedMerc extends FactoryObjetoLogico { 

  public FactorySolicitarAPedMerc() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SolicitarAPedMerc solicitarapedmerc = (SolicitarAPedMerc) objLog;
    solicitarapedmerc.setOID(db.getInteger(DBSolicitarAPedMerc.OID_SOL_PED_MERC));
    solicitarapedmerc.setCodigo(db.getString(DBSolicitarAPedMerc.CODIGO));
    solicitarapedmerc.setDescripcion(db.getString(DBSolicitarAPedMerc.DESCRIPCION));
    solicitarapedmerc.setActivo(db.getBoolean(DBSolicitarAPedMerc.ACTIVO));

  }
}
