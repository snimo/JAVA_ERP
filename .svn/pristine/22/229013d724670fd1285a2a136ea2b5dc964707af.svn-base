package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.ReporteContaCompo;
import com.srn.erp.contabilidad.bm.ReporteContableDet;
import com.srn.erp.contabilidad.da.DBReporteContaCompo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryReporteContaCompo extends FactoryObjetoLogico {

  public FactoryReporteContaCompo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ReporteContaCompo reportecontacompo = (ReporteContaCompo) objLog;
    reportecontacompo.setOID(db.getInteger(DBReporteContaCompo.OID_REP_CON_COMPO));
    reportecontacompo.setReportecontadet(ReporteContableDet.findByOidProxy(db.getInteger(DBReporteContaCompo.OID_REP_CONTA_DET),getSesion()));
    Componente componente = Componente.findByOid(db.getInteger(DBReporteContaCompo.OID_CCO),getSesion());
    reportecontacompo.setComponente(componente);
    reportecontacompo.setValorcomponente(componente.getValorCompo(db.getInteger(DBReporteContaCompo.OID_VALOR_COMPO)));
  }
}
