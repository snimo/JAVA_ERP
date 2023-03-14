package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.bm.Diario;
import com.srn.erp.contabilidad.da.DBComproConta;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproConta extends FactoryObjetoLogico {

  public FactoryComproConta() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproConta comproConta = (ComproConta) objLog;
    comproConta.setOID(db.getInteger(DBComproConta.OID_CCO));
    comproConta.setImputac(db.getDate(DBComproConta.IMPUTAC));
    comproConta.setCierre(db.getBoolean(DBComproConta.CIERRE));
    comproConta.setPeriodo(Periodo.findByOidProxy(db.getInteger(DBComproConta.OID_PERI),getSesion()));
    comproConta.setDiario(Diario.findByOidProxy(db.getInteger(DBComproConta.OID_DIARIO),getSesion()));
    comproConta.setAnulado(db.getBoolean(DBComproConta.ANULADO));
    comproConta.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBComproConta.OID_CCO),getSesion()));
  }
}
