package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.AnuladorAsientoDet;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.da.DBAnuladorAsientoDet;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorAsientoDet extends FactoryObjetoLogico {

  public FactoryAnuladorAsientoDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorAsientoDet anuladorasientodet = (AnuladorAsientoDet) objLog;
    anuladorasientodet.setOID(db.getInteger(DBAnuladorAsientoDet.OID_DET_ANU_INGASI));
    anuladorasientodet.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBAnuladorAsientoDet.OID_CCO),getSesion()));
    anuladorasientodet.setSecu(db.getInteger(DBAnuladorAsientoDet.SECU));
    anuladorasientodet.setCuentaimputable(CuentaImputable.findByOidProxy(db.getInteger(DBAnuladorAsientoDet.OID_AI),getSesion()));
    anuladorasientodet.setSigno(db.getInteger(DBAnuladorAsientoDet.SIGNO));
    anuladorasientodet.setImpoLocAju(db.getMoney(DBAnuladorAsientoDet.IMPO_LOC_AJU));
    anuladorasientodet.setImpoLocHist(db.getMoney(DBAnuladorAsientoDet.IMPO_LOC_HIST));
    anuladorasientodet.setImpoMonExt1(db.getMoney(DBAnuladorAsientoDet.IMPOMONEXT1));
    anuladorasientodet.setImpoMonExt2(db.getMoney(DBAnuladorAsientoDet.IMPOMONEXT2));
    anuladorasientodet.setComentario(db.getString(DBAnuladorAsientoDet.COMENTARIO));
  }
}
