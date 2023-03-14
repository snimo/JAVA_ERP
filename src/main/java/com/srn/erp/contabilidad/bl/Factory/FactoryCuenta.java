package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.Estructura;
import com.srn.erp.contabilidad.da.DBCuenta;
import com.srn.erp.general.bm.Indice;
import com.srn.erp.general.bm.TipoCambio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCuenta extends FactoryObjetoLogico {

  public FactoryCuenta() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Cuenta cuenta = (Cuenta) objLog;
    cuenta.setOID(db.getInteger(DBCuenta.OID_ANA_CON));
    cuenta.setCodigo(db.getString(DBCuenta.CODIGO));
    cuenta.setDescripcion(db.getString(DBCuenta.DESCRIPCION));
    cuenta.setEspatrimonial(db.getBoolean(DBCuenta.ES_PATRIMONIAL));
    cuenta.setEsctainterna(db.getBoolean(DBCuenta.ES_CTA_INTERNA));
    cuenta.setEstructura(Estructura.findByOidProxy(db.getInteger(DBCuenta.OID_ESTRUC),getSesion()));
    cuenta.setTipocambio(TipoCambio.findByOidProxy(db.getInteger(DBCuenta.OID_TIPO_CAMBIO),getSesion()));
    cuenta.setIndice(Indice.findByOidProxy(db.getInteger(DBCuenta.OID_INDICE),getSesion()));
    cuenta.setActivo(db.getBoolean(DBCuenta.ACTIVO));
    cuenta.setEsImpuesto(db.getBoolean(DBCuenta.ES_IMPUESTO));
    cuenta.setSubsistema(db.getString(DBCuenta.SUBSISTEMA));
  }
}
