package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.VehiAsigExcluido;
import com.srn.erp.excluidos.bm.VehiculoExcluido;
import com.srn.erp.excluidos.da.DBVehiAsigExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryVehiAsigExcluido extends FactoryObjetoLogico { 

  public FactoryVehiAsigExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    VehiAsigExcluido vehiasigexcluido = (VehiAsigExcluido) objLog;
    vehiasigexcluido.setOID(db.getInteger(DBVehiAsigExcluido.OID_VEHI_INDI));
    vehiasigexcluido.setIndividuo(IndividuoExcluido.findByOidProxy(db.getInteger(DBVehiAsigExcluido.OID_INDIVIDUO),getSesion()));
    vehiasigexcluido.setVehiculo(VehiculoExcluido.findByOidProxy(db.getInteger(DBVehiAsigExcluido.OID_VEHICULO),getSesion()));
    vehiasigexcluido.setActivo(db.getBoolean(DBVehiAsigExcluido.ACTIVO));
    vehiasigexcluido.setPredio(PredioExcluido.findByOidProxy(db.getInteger(DBVehiAsigExcluido.OID_PREDIO),getSesion()));
  }
}
