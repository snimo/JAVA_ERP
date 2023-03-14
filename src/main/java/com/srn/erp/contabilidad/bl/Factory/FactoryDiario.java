package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Diario;
import com.srn.erp.contabilidad.da.DBDiario;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDiario extends FactoryObjetoLogico {

  public FactoryDiario() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Diario diario = (Diario) objLog;
    diario.setOID(db.getInteger(DBDiario.OID_DIARIO));
    diario.setTipocomprobante(
      TipoComprobante.findByOidProxy(db.getInteger(DBDiario.OID_TC),getSesion()));
    diario.setImputac(db.getDate(DBDiario.IMPUTAC));
    diario.setCierre(db.getBoolean(DBDiario.CIERRE));
    diario.setComentario(db.getString(DBDiario.COMENTARIO));
  }
}
