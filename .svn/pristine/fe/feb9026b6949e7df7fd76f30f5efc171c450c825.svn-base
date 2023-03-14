package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.da.DBSistemaValuacion;
import com.srn.erp.general.bm.Indice;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySistemaValuacion extends FactoryObjetoLogico { 

  public FactorySistemaValuacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SistemaValuacion sistemavaluacion = (SistemaValuacion) objLog;
    sistemavaluacion.setOID(db.getInteger(DBSistemaValuacion.OID_SIST_VAL));
    sistemavaluacion.setCodigo(db.getString(DBSistemaValuacion.CODIGO));
    sistemavaluacion.setDescripcion(db.getString(DBSistemaValuacion.DESCRIPCION));
    sistemavaluacion.setTipo_amort(db.getString(DBSistemaValuacion.TIPO_AMORT));
    sistemavaluacion.setContable(db.getBoolean(DBSistemaValuacion.CONTABLE));
    sistemavaluacion.setAju_inf(db.getBoolean(DBSistemaValuacion.AJU_INF));
    sistemavaluacion.setMoneda(Moneda.findByOidProxy(db.getInteger(DBSistemaValuacion.OID_MONEDA),getSesion()));
    sistemavaluacion.setIndice(Indice.findByOidProxy(db.getInteger(DBSistemaValuacion.OID_INDICE),getSesion()));
    sistemavaluacion.setActivo(db.getBoolean(DBSistemaValuacion.ACTIVO));

  }
}
