package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.ComproBienUsoDet;
import com.srn.erp.bienUso.bm.MovimientoBienUso;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.SubBien;
import com.srn.erp.bienUso.da.DBMovimientoBienUso;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMovimientoBienUso extends FactoryObjetoLogico { 

  public FactoryMovimientoBienUso() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MovimientoBienUso movimientobienuso = (MovimientoBienUso) objLog;
    movimientobienuso.setOID(db.getInteger(DBMovimientoBienUso.OID_MOVIN_BIEN));
    movimientobienuso.setSub_bien(SubBien.findByOidProxy(db.getInteger(DBMovimientoBienUso.OID_BIEN_ALTA),getSesion()));
    movimientobienuso.setFec_imputac(db.getDate(DBMovimientoBienUso.FEC_IMPUTAC));
    movimientobienuso.setTipo_mov(db.getString(DBMovimientoBienUso.TIPO_MOV));
    movimientobienuso.setPeriodo(Periodo.findByOidProxy(db.getInteger(DBMovimientoBienUso.OID_PERI),getSesion()));
    movimientobienuso.setCompro_conta_det(ComproContaDet.findByOidProxy(db.getInteger(DBMovimientoBienUso.OID_DCO),getSesion()));
    movimientobienuso.setSistemaValuacion(SistemaValuacion.findByOidProxy(db.getInteger(DBMovimientoBienUso.OID_SIST_VAL),getSesion()));
    movimientobienuso.setMesesAmortizados(db.getInteger(DBMovimientoBienUso.MESES_AMORT));
    movimientobienuso.setTasaAmortizacion(db.getMoney(DBMovimientoBienUso.TASA_AMORT));
    movimientobienuso.setImporte(db.getMoney(DBMovimientoBienUso.IMPORTE));
    movimientobienuso.setComproBienUsoDet(ComproBienUsoDet.findByOidProxy(db.getInteger(DBMovimientoBienUso.OID_CCO_DET_BU),getSesion()));
    movimientobienuso.setSigno(db.getInteger(DBMovimientoBienUso.SIGNO));
  }
}
