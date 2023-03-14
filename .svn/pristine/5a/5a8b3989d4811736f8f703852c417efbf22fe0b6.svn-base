package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.CicloPresupuestal;
import com.srn.erp.presupuesto.bm.TipoCiclo;
import com.srn.erp.presupuesto.da.DBCicloPresupuestal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCicloPresupuestal extends FactoryObjetoLogico { 

  public FactoryCicloPresupuestal() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CicloPresupuestal ciclopresupuestal = (CicloPresupuestal) objLog;
    ciclopresupuestal.setOID(db.getInteger(DBCicloPresupuestal.OID_CICLO));
    ciclopresupuestal.setCodigo(db.getString(DBCicloPresupuestal.CODIGO));
    ciclopresupuestal.setDescripcion(db.getString(DBCicloPresupuestal.DESCRIPCION));
    ciclopresupuestal.setObservacion(db.getString(DBCicloPresupuestal.OBSERVACION));
    ciclopresupuestal.setNro_orden_visual(db.getInteger(DBCicloPresupuestal.NRO_ORDEN_VISUAL));
    ciclopresupuestal.setActivo(db.getBoolean(DBCicloPresupuestal.ACTIVO));
    ciclopresupuestal.setTipo_ciclo(TipoCiclo.findByOidProxy(db.getInteger(DBCicloPresupuestal.OID_TIPO_CICLO),getSesion()));
    ciclopresupuestal.setFechaInicioPlanif(db.getDate(DBCicloPresupuestal.FECHA_INICIO_PLANIF));

  }
}
