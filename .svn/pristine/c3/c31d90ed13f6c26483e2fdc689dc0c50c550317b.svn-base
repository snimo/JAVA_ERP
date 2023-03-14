package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Idioma;
import com.srn.erp.ventas.bm.ObsCodifVtas;
import com.srn.erp.ventas.bm.ObsCodifVtasIdioma;
import com.srn.erp.ventas.da.DBObsCodifVtasIdioma;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryObsCodifVtasIdioma extends FactoryObjetoLogico { 

  public FactoryObsCodifVtasIdioma() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ObsCodifVtasIdioma obscodifvtasidioma = (ObsCodifVtasIdioma) objLog;
   obscodifvtasidioma.setOID(db.getInteger(DBObsCodifVtasIdioma.OID_OBS_IDIOMA));
    obscodifvtasidioma.setCodigo_observacion(ObsCodifVtas.findByOidProxy(db.getInteger(DBObsCodifVtasIdioma.OID_OBS_COD),getSesion()));
    obscodifvtasidioma.setDescripcion(db.getString(DBObsCodifVtasIdioma.DESCRIPCION));
    obscodifvtasidioma.setIdioma(Idioma.findByOidProxy(db.getInteger(DBObsCodifVtasIdioma.OID_IDIOMA),getSesion()));
    obscodifvtasidioma.setActivo(db.getBoolean(DBObsCodifVtasIdioma.ACTIVO));

  }
}
