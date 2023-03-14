package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.ComproContaConsulta;
import com.srn.erp.contabilidad.da.DBComproContaConsulta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproContaConsulta extends FactoryObjetoLogico {

  public FactoryComproContaConsulta() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproContaConsulta comprocontaconsulta = (ComproContaConsulta) objLog;
    comprocontaconsulta.setOID(db.getInteger(DBComproContaConsulta.OID_CCO));
    comprocontaconsulta.setEmision(db.getDate(DBComproContaConsulta.EMISION));
    comprocontaconsulta.setImputacion(db.getDate(DBComproContaConsulta.IMPUTAC));
    comprocontaconsulta.setComentario(db.getString(DBComproContaConsulta.COMENTARIO));
    comprocontaconsulta.setAnulado(db.getBoolean(DBComproContaConsulta.ANULADO));
    comprocontaconsulta.setTC(db.getString(DBComproContaConsulta.TC));
    comprocontaconsulta.setLetra(db.getString(DBComproContaConsulta.LETRA));
    comprocontaconsulta.setLugEmi(db.getInteger(DBComproContaConsulta.LUG_EMI));
    comprocontaconsulta.setNroExt(db.getInteger(DBComproContaConsulta.NRO_EXT));
  }
}
