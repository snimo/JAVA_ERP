package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.ColorExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.VehiculoExcluido;
import com.srn.erp.excluidos.da.DBVehiculoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryVehiculoExcluido extends FactoryObjetoLogico { 

  public FactoryVehiculoExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    VehiculoExcluido vehiculoexcluido = (VehiculoExcluido) objLog;
    vehiculoexcluido.setOID(db.getInteger(DBVehiculoExcluido.OID_VEHICULO));
    vehiculoexcluido.setModelo(db.getString(DBVehiculoExcluido.MODELO));
    vehiculoexcluido.setDominio(db.getString(DBVehiculoExcluido.DOMINIO));
    vehiculoexcluido.setColor(ColorExcluido.findByOidProxy(db.getInteger(DBVehiculoExcluido.OID_COLOR),getSesion()));
    vehiculoexcluido.setActivo(db.getBoolean(DBVehiculoExcluido.ACTIVO));
    vehiculoexcluido.setMarca(db.getString(DBVehiculoExcluido.MARCA));
    vehiculoexcluido.setPredio(PredioExcluido.findByOidProxy(db.getInteger(DBVehiculoExcluido.OID_PREDIO),getSesion()));
    

  }
}
