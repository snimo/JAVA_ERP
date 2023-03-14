package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.impuestos.bm.Impuesto;
import com.srn.erp.impuestos.da.DBImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryImpuesto extends FactoryObjetoLogico {

  public FactoryImpuesto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Impuesto impuesto = (Impuesto) objLog;
    impuesto.setOID(db.getInteger(DBImpuesto.OID_IMPUESTO));
    impuesto.setCodigo(db.getString(DBImpuesto.CODIGO));
    impuesto.setDescripcion(db.getString(DBImpuesto.DESCRIPCION));
    impuesto.setCompo(db.getString(DBImpuesto.COMPO));
    impuesto.setActivo(db.getBoolean(DBImpuesto.ACTIVO));
    impuesto.setVentas(db.getBoolean(DBImpuesto.VENTAS));
    impuesto.setCompras(db.getBoolean(DBImpuesto.COMPRAS));
  }
}
