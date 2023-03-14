package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.LiquidacionTarCab;
import com.srn.erp.tesoreria.bm.LiquidacionTarjetaValor;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.tesoreria.da.DBLiquidacionTarjetaValor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;

public class FactoryLiquidacionTarjetaValor extends FactoryObjetoLogico { 

  public FactoryLiquidacionTarjetaValor() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LiquidacionTarjetaValor liquidaciontarjetavalor = (LiquidacionTarjetaValor) objLog;
    liquidaciontarjetavalor.setOID(db.getInteger(DBLiquidacionTarjetaValor.OID_LIQ_TAR_VAL));
    liquidaciontarjetavalor.setLiquidacion_tarjeta(LiquidacionTarCab.findByOidProxy(db.getInteger(DBLiquidacionTarjetaValor.OID_LIQUI_TAR),getSesion()));
    liquidaciontarjetavalor.setValor(Valor.findByOidProxy(db.getInteger(DBLiquidacionTarjetaValor.OID_VALOR),getSesion()));
    liquidaciontarjetavalor.setImporte(db.getMoney(DBLiquidacionTarjetaValor.IMPORTE));
    liquidaciontarjetavalor.setImporte_mon_loc(db.getMoney(DBLiquidacionTarjetaValor.IMPORTE_MON_LOC));
    liquidaciontarjetavalor.setCotizacion(db.getCotizacion(DBLiquidacionTarjetaValor.COTIZACION));
    liquidaciontarjetavalor.setNro(db.getInteger(DBLiquidacionTarjetaValor.NRO));
    liquidaciontarjetavalor.setTarjeta(TarjetaCredito.findByOidProxy(db.getInteger(DBLiquidacionTarjetaValor.OID_TARJETA),getSesion()));
    liquidaciontarjetavalor.setCuenta(Cuenta.findByOidProxy(db.getInteger(DBLiquidacionTarjetaValor.OID_ANA_CON),getSesion()));
    liquidaciontarjetavalor.setBanco(Banco.findByOidProxy(db.getInteger(DBLiquidacionTarjetaValor.OID_BANCO),getSesion()));
    liquidaciontarjetavalor.setActivo(db.getBoolean(DBLiquidacionTarjetaValor.ACTIVO));

  }
}
