package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.ListaBlanca;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.da.DBListaBlanca;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryListaBlanca extends FactoryObjetoLogico { 

  public FactoryListaBlanca() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ListaBlanca listablanca = (ListaBlanca) objLog;
    listablanca.setOID(db.getInteger(DBListaBlanca.OID_LB));
    listablanca.setPuerta(Puerta.findByOidProxy(db.getInteger(DBListaBlanca.OID_PUERTA),getSesion()));
    listablanca.setLegajo(Legajo.findByOidProxy(db.getInteger(DBListaBlanca.OID_LEGAJO),getSesion()));
    listablanca.setNro_a_validar(db.getInteger(DBListaBlanca.NRO_A_VALIDAR));
    listablanca.setNro_orden(db.getInteger(DBListaBlanca.NRO_ORDEN));
    listablanca.setTipo(db.getString(DBListaBlanca.TIPO));
    listablanca.setActivo(db.getBoolean(DBListaBlanca.ACTIVO));

  }
}
