package com.srn.erp.cubo.bl.Factory;

import com.srn.erp.cubo.bm.FactTableCubo;
import com.srn.erp.cubo.da.DBFactTableCubo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;
import framework.xlook.bm.Select;

public class FactoryFactTableCubo extends FactoryObjetoLogico { 

  public FactoryFactTableCubo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FactTableCubo facttablecubo = (FactTableCubo) objLog;
    facttablecubo.setOID(db.getInteger(DBFactTableCubo.OID_FACT_TABLE));
    facttablecubo.setCodigo(db.getString(DBFactTableCubo.CODIGO));
    facttablecubo.setDescripcion(db.getString(DBFactTableCubo.DESCRIPCION));
    facttablecubo.setSelect(Select.findByOidProxy(db.getInteger(DBFactTableCubo.OID_SELECT),getSesion()));
    facttablecubo.setTipo_fact_table(db.getString(DBFactTableCubo.TIPO_FACT_TABLE));
    facttablecubo.setNombre_oper(db.getString(DBFactTableCubo.NOMBRE_OPER));
    facttablecubo.setActivo(db.getBoolean(DBFactTableCubo.ACTIVO));
  }
}
