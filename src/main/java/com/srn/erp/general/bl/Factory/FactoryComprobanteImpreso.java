package com.srn.erp.general.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.general.bm.ComprobanteImpreso;
import com.srn.erp.general.da.DBComprobanteImpreso;

public class FactoryComprobanteImpreso extends FactoryObjetoLogico { 

  public FactoryComprobanteImpreso() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComprobanteImpreso comprobanteimpreso = (ComprobanteImpreso) objLog;
    comprobanteimpreso.setOID(db.getInteger(DBComprobanteImpreso.OID_CCO));
    comprobanteimpreso.setImpre_generada(db.getBoolean(DBComprobanteImpreso.IMPRE_GENERADA));
    comprobanteimpreso.setImpre_fecha(db.getDate(DBComprobanteImpreso.IMPRE_FECHA));
    comprobanteimpreso.setImpre_hora(db.getString(DBComprobanteImpreso.IMPRE_HORA));
    comprobanteimpreso.setImpre_usu(db.getInteger(DBComprobanteImpreso.IMPRE_USU));
    comprobanteimpreso.setImpre_cant(db.getInteger(DBComprobanteImpreso.IMPRE_CANT));
    comprobanteimpreso.setPdf_generado(db.getBoolean(DBComprobanteImpreso.PDF_GENERADO));
    comprobanteimpreso.setPdf_fecha(db.getDate(DBComprobanteImpreso.PDF_FECHA));
    comprobanteimpreso.setPdf_hora(db.getString(DBComprobanteImpreso.PDF_HORA));
    comprobanteimpreso.setPdf_usu(db.getInteger(DBComprobanteImpreso.PDF_USU));
    comprobanteimpreso.setPdf_cant(db.getInteger(DBComprobanteImpreso.PDF_CANT));
    comprobanteimpreso.setVersion_externa(db.getInteger(DBComprobanteImpreso.VERSION_EXTERNA));
    comprobanteimpreso.setCongelarVersion(db.getBoolean(DBComprobanteImpreso.VERSION_CONGELADA));
    comprobanteimpreso.setVersion_fecha(db.getDate(DBComprobanteImpreso.VERSION_FECHA));
    comprobanteimpreso.setVersion_hora(db.getString(DBComprobanteImpreso.VERSION_HORA));
    comprobanteimpreso.setVersion_usu(db.getInteger(DBComprobanteImpreso.VERSION_USU));
    

  }
}
