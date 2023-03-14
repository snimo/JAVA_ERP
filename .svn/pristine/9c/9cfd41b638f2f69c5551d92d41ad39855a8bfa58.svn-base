package com.srn.erp.bancos.bl.Factory;

import com.srn.erp.bancos.bm.ConciliacionCab;
import com.srn.erp.bancos.bm.ConciliacionDet;
import com.srn.erp.bancos.da.DBConciliacionDet;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.tesoreria.bm.MovimientoCtaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConciliacionDet extends FactoryObjetoLogico { 

  public FactoryConciliacionDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConciliacionDet conciliaciondet = (ConciliacionDet) objLog;
    conciliaciondet.setOID(db.getInteger(DBConciliacionDet.OID_CONC_BCO_DET));
    conciliaciondet.setConciliacion_cab(ConciliacionCab.findByOidProxy(db.getInteger(DBConciliacionDet.OID_CONCI_BCO),getSesion()));
    conciliaciondet.setMovimiento_cuenta(MovimientoCtaBancaria.findByOidProxy(db.getInteger(DBConciliacionDet.OID_MOV_CTA_BCO),getSesion()));
    conciliaciondet.setConciliado(db.getBoolean(DBConciliacionDet.CONCILIADO));
    conciliaciondet.setFecha(db.getDate(DBConciliacionDet.FECHA));
    conciliaciondet.setA_conciliar(db.getDouble(DBConciliacionDet.A_CONCILIAR));
    conciliaciondet.setTipo_mov(db.getString(DBConciliacionDet.TIPO_MOV));
    conciliaciondet.setCuenta_contable(CuentaImputable.findByOidProxy(db.getInteger(DBConciliacionDet.OID_AI),getSesion()));
    conciliaciondet.setNro_valor(db.getInteger(DBConciliacionDet.NRO_VALOR));
    conciliaciondet.setNuevo_mov(db.getBoolean(DBConciliacionDet.NUEVO_MOV));
    conciliaciondet.setExtracto(db.getDouble(DBConciliacionDet.EXTRACTO));
    conciliaciondet.setObservacion(db.getString(DBConciliacionDet.OBSERVACION));

  }
}
