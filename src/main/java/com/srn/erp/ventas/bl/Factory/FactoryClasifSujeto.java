package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.ClasifSujeto;
import com.srn.erp.ventas.da.DBClasifSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryClasifSujeto extends FactoryObjetoLogico {

  public FactoryClasifSujeto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ClasifSujeto clasifsujeto = (ClasifSujeto) objLog;
    clasifsujeto.setOID(db.getInteger(DBClasifSujeto.OID_CLASIF_SUJ));
    clasifsujeto.setCodigo(db.getString(DBClasifSujeto.CODIGO));
    clasifsujeto.setDescripcion(db.getString(DBClasifSujeto.DESCRIPCION));
    clasifsujeto.setActivo(db.getBoolean(DBClasifSujeto.ACTIVO));

  }
}
