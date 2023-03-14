package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.ComplexionExcluido;
import com.srn.erp.excluidos.da.DBComplexionExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComplexionExcluido extends FactoryObjetoLogico { 

  public FactoryComplexionExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComplexionExcluido complexionexcluido = (ComplexionExcluido) objLog;
    complexionexcluido.setOID(db.getInteger(DBComplexionExcluido.OID_COMPLEXION));
    complexionexcluido.setCodigo(db.getString(DBComplexionExcluido.CODIGO));
    complexionexcluido.setDescripcion(db.getString(DBComplexionExcluido.DESCRIPCION));
    complexionexcluido.setActivo(db.getBoolean(DBComplexionExcluido.ACTIVO));

  }
}
