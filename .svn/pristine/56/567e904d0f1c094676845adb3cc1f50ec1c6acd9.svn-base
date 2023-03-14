package com.srn.erp.produccion.bl.Factory;

import com.srn.erp.produccion.bm.AlternativaFabricacion;
import com.srn.erp.produccion.bm.OperAlterFab;
import com.srn.erp.produccion.bm.OperacionProductiva;
import com.srn.erp.produccion.bm.ProcesoProductivo;
import com.srn.erp.produccion.bm.TipoEstacionTrabajo;
import com.srn.erp.produccion.bm.UMTiempoProduccion;
import com.srn.erp.produccion.da.DBOperAlterFab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryOperAlterFab extends FactoryObjetoLogico { 

  public FactoryOperAlterFab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    OperAlterFab operalterfab = (OperAlterFab) objLog;
    operalterfab.setOID(db.getInteger(DBOperAlterFab.OID_OPER_FABRI));
    operalterfab.setAlternativa_fabricacion(AlternativaFabricacion.findByOidProxy(db.getInteger(DBOperAlterFab.OID_ALTER_FABRI),getSesion()));
    operalterfab.setProceso(ProcesoProductivo.findByOidProxy(db.getInteger(DBOperAlterFab.OID_PROCESO),getSesion()));
    operalterfab.setOperacion(OperacionProductiva.findByOidProxy(db.getInteger(DBOperAlterFab.OID_OPERACION),getSesion()));
    operalterfab.setTipo_estacion(TipoEstacionTrabajo.findByOidProxy(db.getInteger(DBOperAlterFab.OID_TIPO_ESTACION),getSesion()));
    operalterfab.setTiempo_std(db.getDouble(DBOperAlterFab.TIEMPO_STD));
    operalterfab.setComportamiento(db.getString(DBOperAlterFab.COMPORTAMIENTO));
    operalterfab.setOid_rel(db.getString(DBOperAlterFab.OID_REL));
    operalterfab.setOid_rel_padre(db.getString(DBOperAlterFab.OID_REL_PADRE));
    operalterfab.setActivo(db.getBoolean(DBOperAlterFab.ACTIVO));
    operalterfab.setObservacion(db.getString(DBOperAlterFab.OBSERVACION));
    operalterfab.setUMTiempoProduccion(UMTiempoProduccion.findByOidProxy(db.getInteger(DBOperAlterFab.OID_UM_TIEMPO),getSesion()));

  }
}
