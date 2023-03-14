package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.EsquemaBonificacion;
import com.srn.erp.ventas.bm.EsquemaBonificacionVigSuj;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.da.DBEsquemaBonificacionVigSuj;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsquemaBonificacionVigSuj extends FactoryObjetoLogico { 

  public FactoryEsquemaBonificacionVigSuj() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EsquemaBonificacionVigSuj esquemabonificacionvigsuj = (EsquemaBonificacionVigSuj) objLog;
    esquemabonificacionvigsuj.setOID(db.getInteger(DBEsquemaBonificacionVigSuj.OID_ESQ_BON_SUJ));
    esquemabonificacionvigsuj.setEsquema_bonificacion(EsquemaBonificacion.findByOidProxy(db.getInteger(DBEsquemaBonificacionVigSuj.OID_ESQ_BONIF),getSesion()));
    esquemabonificacionvigsuj.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBEsquemaBonificacionVigSuj.OID_SUJETO),getSesion()));
    esquemabonificacionvigsuj.setFec_vig_desde(db.getDate(DBEsquemaBonificacionVigSuj.FEC_VIG_DESDE));
    esquemabonificacionvigsuj.setFec_vig_hasta(db.getDate(DBEsquemaBonificacionVigSuj.FEC_VIG_HASTA));
    esquemabonificacionvigsuj.setActivo(db.getBoolean(DBEsquemaBonificacionVigSuj.ACTIVO));

  }
}
