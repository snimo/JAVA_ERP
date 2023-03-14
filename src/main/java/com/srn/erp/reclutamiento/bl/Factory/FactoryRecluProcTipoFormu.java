package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluProcTipoFormu;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluTipoFormuProceso;
import com.srn.erp.reclutamiento.da.DBRecluProcTipoFormu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluProcTipoFormu extends FactoryObjetoLogico { 

  public FactoryRecluProcTipoFormu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluProcTipoFormu recluproctipoformu = (RecluProcTipoFormu) objLog;
    recluproctipoformu.setOID(db.getInteger(DBRecluProcTipoFormu.OID_PROC_TIPO_FORMU));
    recluproctipoformu.setTipo_formulario(RecluTipoFormuProceso.findByOidProxy(db.getInteger(DBRecluProcTipoFormu.OID_TIPO_FORMU),getSesion()));
    recluproctipoformu.setProceso(RecluProceso.findByOidProxy(db.getInteger(DBRecluProcTipoFormu.OID_PROCESO),getSesion()));
    recluproctipoformu.setActivo(db.getBoolean(DBRecluProcTipoFormu.ACTIVO));

  }
}
