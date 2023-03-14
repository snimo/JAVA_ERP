package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.HistoricoPuesto;
import com.srn.erp.rrhh.da.DBHistoricoPuesto;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryHistoricoPuesto extends FactoryObjetoLogico { 

  public FactoryHistoricoPuesto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    HistoricoPuesto historicopuesto = (HistoricoPuesto) objLog;
    historicopuesto.setOID(db.getInteger(DBHistoricoPuesto.OID_HIST_PUESTO));
    historicopuesto.setVal_clasif_pue(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBHistoricoPuesto.OID_VAL_CLASIF_PUE),getSesion()));
    historicopuesto.setFec_desde(db.getDate(DBHistoricoPuesto.FEC_DESDE));
    historicopuesto.setLegajo(Legajo.findByOidProxy(db.getInteger(DBHistoricoPuesto.OID_LEGAJO),getSesion()));
    historicopuesto.setActivo(db.getBoolean(DBHistoricoPuesto.ACTIVO));
    historicopuesto.setVal_clasif_emp(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBHistoricoPuesto.OID_VAL_CLASIF_EMP),getSesion()));
    historicopuesto.setVal_clasif_sec(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBHistoricoPuesto.OID_VAL_CLASIF_SEC),getSesion()));    
  }
}
