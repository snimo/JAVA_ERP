package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.AsientoManual;
import com.srn.erp.contabilidad.bm.AsientoManualDet;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.da.DBAsientoManualDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAsientoManualDet extends FactoryObjetoLogico {

  public FactoryAsientoManualDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AsientoManualDet asientomanualdet = (AsientoManualDet) objLog;
    asientomanualdet.setOID(db.getInteger(DBAsientoManualDet.OID_DCO));
    asientomanualdet.setComprobante(AsientoManual.findByOidProxy(db.getInteger(DBAsientoManualDet.OID_CCO),getSesion()));
    asientomanualdet.setCuentaImputable(CuentaImputable.findByOidProxy(db.getInteger(DBAsientoManualDet.OID_AI),getSesion()));
    asientomanualdet.setSecu(db.getInteger(DBAsientoManualDet.SECU));
    asientomanualdet.setSigno(db.getInteger(DBAsientoManualDet.SIGNO));
    asientomanualdet.setImporte(db.getMoney(DBAsientoManualDet.IMPORTE));
    asientomanualdet.setComentario(db.getString(DBAsientoManualDet.COMENTARIO));

  }
}
