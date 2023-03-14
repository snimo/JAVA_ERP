package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.impuestos.bm.ColumnaLibroIVA;
import com.srn.erp.impuestos.da.DBColumnaLibroIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryColumnaLibroIVA extends FactoryObjetoLogico {

  public FactoryColumnaLibroIVA() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ColumnaLibroIVA columnalibroiva = (ColumnaLibroIVA) objLog;
    columnalibroiva.setOID(db.getInteger(DBColumnaLibroIVA.OID_COL_LIBRO_IVA));
    columnalibroiva.setCodigo(db.getString(DBColumnaLibroIVA.CODIGO));
    columnalibroiva.setDescripcion(db.getString(DBColumnaLibroIVA.DESCRIPCION));
    columnalibroiva.setColumna(db.getInteger(DBColumnaLibroIVA.COLUMNA));
    columnalibroiva.setActivo(db.getBoolean(DBColumnaLibroIVA.ACTIVO));
    columnalibroiva.setUsarIVACompras(db.getBoolean(DBColumnaLibroIVA.USAR_IVA_CPRAS));
    columnalibroiva.setUsarIVAVentas(db.getBoolean(DBColumnaLibroIVA.USAR_IVA_VTAS));
  }
}
