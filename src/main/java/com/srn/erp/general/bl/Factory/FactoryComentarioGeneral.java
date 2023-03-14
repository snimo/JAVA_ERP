package com.srn.erp.general.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.general.bm.ComentarioGeneral;
import com.srn.erp.general.da.DBComentarioGeneral;

public class FactoryComentarioGeneral extends FactoryObjetoLogico { 

  public FactoryComentarioGeneral() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComentarioGeneral comentariogeneral = (ComentarioGeneral) objLog;
    comentariogeneral.setOID(db.getInteger(DBComentarioGeneral.OID_COMEN_GRAL));
    comentariogeneral.setOidObjeto(db.getInteger(DBComentarioGeneral.OID_OBJETO));
    comentariogeneral.setClave(db.getString(DBComentarioGeneral.CLAVE));
    comentariogeneral.setSecu(db.getInteger(DBComentarioGeneral.SECU));
    comentariogeneral.setComentario(db.getString(DBComentarioGeneral.COMENTARIO));

  }
}
