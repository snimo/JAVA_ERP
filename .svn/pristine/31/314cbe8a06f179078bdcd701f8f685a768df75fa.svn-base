package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ComproProvVtoFijo;
import com.srn.erp.ctasAPagar.da.DBComproProvVtoFijo;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproProvVtoFijo extends FactoryObjetoLogico {

  public FactoryComproProvVtoFijo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproProvVtoFijo comproprovvtofijo = (ComproProvVtoFijo) objLog;
    comproprovvtofijo.setOID(db.getInteger(DBComproProvVtoFijo.
                                           OID_CCO_VTOF_FIJO));
    comproprovvtofijo.setComprobante(ComproCab.findByOidProxyCompro(db.
        getInteger(DBComproProvVtoFijo.OID_CCO), getSesion()));
    comproprovvtofijo.setFecha(db.getDate(DBComproProvVtoFijo.FECHA));
    comproprovvtofijo.setPorcentaje(db.getDouble(DBComproProvVtoFijo.PORC));
    comproprovvtofijo.setActivo(db.getBoolean(DBComproProvVtoFijo.ACTIVO));
  }

}
