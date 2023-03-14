package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.PeriodoPresupuestario;
import com.srn.erp.presupuesto.bm.TipoPeriodo;
import com.srn.erp.presupuesto.da.DBPeriodoPresupuestario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPeriodoPresupuestario extends FactoryObjetoLogico { 

  public FactoryPeriodoPresupuestario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PeriodoPresupuestario periodopresupuestario = (PeriodoPresupuestario) objLog;
    periodopresupuestario.setOID(db.getInteger(DBPeriodoPresupuestario.OID_PERI));
    periodopresupuestario.setCodigo(db.getString(DBPeriodoPresupuestario.CODIGO));
    periodopresupuestario.setDescripcion(db.getString(DBPeriodoPresupuestario.DESCRIPCION));
    periodopresupuestario.setActivo(db.getBoolean(DBPeriodoPresupuestario.ACTIVO));
    periodopresupuestario.setTipo_periodo(TipoPeriodo.findByOidProxy(db.getInteger(DBPeriodoPresupuestario.OID_TIPO_PERI),getSesion()));
    periodopresupuestario.setFec_desde(db.getDate(DBPeriodoPresupuestario.FEC_DESDE));
    periodopresupuestario.setFec_hasta(db.getDate(DBPeriodoPresupuestario.FEC_HASTA));

  }
}
