package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.LiquidacionTarCab;
import com.srn.erp.tesoreria.bm.LiquidacionTarjetaDet;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.tesoreria.da.DBLiquidacionTarjetaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLiquidacionTarjetaDet extends FactoryObjetoLogico { 

  public FactoryLiquidacionTarjetaDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LiquidacionTarjetaDet liquidaciontarjetadet = (LiquidacionTarjetaDet) objLog;
    liquidaciontarjetadet.setOID(db.getInteger(DBLiquidacionTarjetaDet.OID_LIQUI_DET));
    liquidaciontarjetadet.setLiquidacion_tar(LiquidacionTarCab.findByOidProxy(db.getInteger(DBLiquidacionTarjetaDet.OID_LIQUI_TAR),getSesion()));
    liquidaciontarjetadet.setValor(Valor.findByOidProxy(db.getInteger(DBLiquidacionTarjetaDet.OID_VALOR),getSesion()));
    liquidaciontarjetadet.setImporte_liquidado(db.getMoney(DBLiquidacionTarjetaDet.IMPO_LIQUIDADO));
    liquidaciontarjetadet.setActivo(db.getBoolean(DBLiquidacionTarjetaDet.ACTIVO));
    liquidaciontarjetadet.setNroCuota(db.getInteger(DBLiquidacionTarjetaDet.NRO_CUOTA));
  }
}
