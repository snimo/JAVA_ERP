package com.srn.erp.general.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.general.bm.DirectorioBaseServidor;
import com.srn.erp.general.da.DBDirectorioBaseServidor;

public class FactoryDirectorioBaseServidor extends FactoryObjetoLogico { 

  public FactoryDirectorioBaseServidor() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DirectorioBaseServidor directoriobaseservidor = (DirectorioBaseServidor) objLog;
    directoriobaseservidor.setOID(db.getInteger(DBDirectorioBaseServidor.OID_DIR_BASE));
    directoriobaseservidor.setCodigo(db.getString(DBDirectorioBaseServidor.CODIGO));
    directoriobaseservidor.setDescripcion(db.getString(DBDirectorioBaseServidor.DESCRIPCION));
    directoriobaseservidor.setActivo(db.getBoolean(DBDirectorioBaseServidor.ACTIVO));

  }
}
