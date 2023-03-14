package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.AlturaExcluido;
import com.srn.erp.excluidos.da.DBAlturaExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAlturaExcluido extends FactoryObjetoLogico { 

  public FactoryAlturaExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AlturaExcluido alturaexcluido = (AlturaExcluido) objLog;
    alturaexcluido.setOID(db.getInteger(DBAlturaExcluido.OID_ALTURA));
    alturaexcluido.setCodigo(db.getString(DBAlturaExcluido.CODIGO));
    alturaexcluido.setDescripcion(db.getString(DBAlturaExcluido.DESCRIPCION));
    alturaexcluido.setActivo(db.getBoolean(DBAlturaExcluido.ACTIVO));

  }
}
