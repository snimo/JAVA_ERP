package com.srn.erp.general.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.general.bm.EtiquetaIdioma;
import com.srn.erp.general.da.DBEtiquetaIdioma;

public class FactoryEtiquetaIdioma extends FactoryObjetoLogico { 

  public FactoryEtiquetaIdioma() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EtiquetaIdioma etiquetaidioma = (EtiquetaIdioma) objLog;
    etiquetaidioma.setOID(db.getInteger(DBEtiquetaIdioma.OID_ETI_IDIOMA));
    etiquetaidioma.setNickname(db.getString(DBEtiquetaIdioma.NICKNAME));
    etiquetaidioma.setEtiqueta(db.getString(DBEtiquetaIdioma.ETIQUETA));
    etiquetaidioma.setActivo(db.getBoolean(DBEtiquetaIdioma.ACTIVO));
    etiquetaidioma.setDescripcion(db.getString(DBEtiquetaIdioma.DESCRIPCION));

  }
}
