package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.AnuladorAsientoCab;
import com.srn.erp.contabilidad.da.DBAnuladorAsientoCab;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorAsientoCab extends FactoryObjetoLogico {

  public FactoryAnuladorAsientoCab() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorAsientoCab anuladorAsientoCab = (AnuladorAsientoCab) objLog;
    anuladorAsientoCab.setOID(db.getInteger(DBAnuladorAsientoCab.OID_CCO));
    anuladorAsientoCab.setComprobanteAnulado(ComproCab.findByOidCompro(db.getInteger(DBAnuladorAsientoCab.OID_CCO_ANULADO),getSesion()));
    anuladorAsientoCab.setFecImputacion(db.getDate(DBAnuladorAsientoCab.FEC_IMPUTAC));
    anuladorAsientoCab.setFecReal(db.getDate(DBAnuladorAsientoCab.FEC_REAL));
    anuladorAsientoCab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBAnuladorAsientoCab.OID_USU),getSesion()));
    anuladorAsientoCab.setComentario(db.getString(DBAnuladorAsientoCab.COMENTARIO));
  }
}
