package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.ComproBienUsoCab;
import com.srn.erp.bienUso.bm.ComproBienUsoDet;
import com.srn.erp.bienUso.da.DBComproBienUsoDet;
import com.srn.erp.contabilidad.bm.ComproContaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproBienUsoDet extends FactoryObjetoLogico { 

  public FactoryComproBienUsoDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproBienUsoDet comproBienUsoDet = (ComproBienUsoDet) objLog;
    comproBienUsoDet.setOID(db.getInteger(DBComproBienUsoDet.OID_CCO_DET_BU));
    comproBienUsoDet.setCompro_bien_uso_cab(ComproBienUsoCab.findByOidProxy(db.getInteger(DBComproBienUsoDet.OID_CCO_BU),getSesion()));
    comproBienUsoDet.setCompro_conta_det(ComproContaDet.findByOidProxy(db.getInteger(DBComproBienUsoDet.OID_DCO),getSesion()));
    comproBienUsoDet.setPorc(db.getDouble(DBComproBienUsoDet.PORC));
    comproBienUsoDet.setMeses_amort(db.getInteger(DBComproBienUsoDet.MESES_AMORT));
    comproBienUsoDet.setTasa_amort(db.getDouble(DBComproBienUsoDet.TASA_AMORT));
    comproBienUsoDet.setImporte(db.getDouble(DBComproBienUsoDet.IMPORTE));
  }
}
