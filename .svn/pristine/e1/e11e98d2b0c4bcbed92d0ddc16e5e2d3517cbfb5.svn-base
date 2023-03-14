package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.EtiquetaIdioma;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.ValorEtiquetaIdioma;
import com.srn.erp.general.da.DBValorEtiquetaIdioma;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValorEtiquetaIdioma extends FactoryObjetoLogico { 

  public FactoryValorEtiquetaIdioma() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ValorEtiquetaIdioma valoretiquetaidioma = (ValorEtiquetaIdioma) objLog;
    valoretiquetaidioma.setOID(db.getInteger(DBValorEtiquetaIdioma.OID_VAL_ETI_IDIOMA));
    valoretiquetaidioma.setEtiqueta_idioma(EtiquetaIdioma.findByOidProxy(db.getInteger(DBValorEtiquetaIdioma.OID_ETI_IDIOMA),getSesion()));
    valoretiquetaidioma.setDescripcion(db.getString(DBValorEtiquetaIdioma.DESCRIPCION));
    valoretiquetaidioma.setIdioma(Idioma.findByOidProxy(db.getInteger(DBValorEtiquetaIdioma.OID_IDIOMA),getSesion()));
    valoretiquetaidioma.setActivo(db.getBoolean(DBValorEtiquetaIdioma.ACTIVO));

  }
}
