package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluSectores;
import com.srn.erp.reclutamiento.da.DBRecluSectores;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluSectores extends FactoryObjetoLogico { 

  public FactoryRecluSectores() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluSectores reclusectores = (RecluSectores) objLog;
    reclusectores.setOID(db.getInteger(DBRecluSectores.OID_SECTOR));
    reclusectores.setCodigo(db.getString(DBRecluSectores.CODIGO));
    reclusectores.setDescripcion(db.getString(DBRecluSectores.DESCRIPCION));
    reclusectores.setActivo(db.getBoolean(DBRecluSectores.ACTIVO));

  }
}
