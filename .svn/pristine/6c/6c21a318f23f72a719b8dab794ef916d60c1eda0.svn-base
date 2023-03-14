package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluConceptoProceso;
import com.srn.erp.reclutamiento.bm.RecluProcDefEnBusq;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluTipoFormuProceso;
import com.srn.erp.reclutamiento.da.DBRecluProcDefEnBusq;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluProcDefEnBusq extends FactoryObjetoLogico { 

  public FactoryRecluProcDefEnBusq() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluProcDefEnBusq recluprocdefenbusq = (RecluProcDefEnBusq) objLog;
    recluprocdefenbusq.setOID(db.getInteger(DBRecluProcDefEnBusq.OID_PROC_DEF_BUSQ));
    recluprocdefenbusq.setBusqueda(RecluBusqueda.findByOidProxy(db.getInteger(DBRecluProcDefEnBusq.OID_BUSQUEDA_ACT),getSesion()));
    recluprocdefenbusq.setOrden(db.getInteger(DBRecluProcDefEnBusq.ORDEN));
    recluprocdefenbusq.setProceso(RecluProceso.findByOidProxy(db.getInteger(DBRecluProcDefEnBusq.OID_PROCESO),getSesion()));
    recluprocdefenbusq.setFecha_asigno(db.getDate(DBRecluProcDefEnBusq.FECHA_ASIGNO));
    recluprocdefenbusq.setActivo(db.getBoolean(DBRecluProcDefEnBusq.ACTIVO));
    recluprocdefenbusq.setConceptoProceso(RecluConceptoProceso.findByOid(db.getInteger(DBRecluProcDefEnBusq.OID_CONC_PROCESO), this.getSesion()));
    recluprocdefenbusq.setTipoFormulario(RecluTipoFormuProceso.findByOid(db.getInteger(DBRecluProcDefEnBusq.OID_TIPO_FORMULARIO), this.getSesion()));

  }
}
