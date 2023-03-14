package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.bancos.bm.ConciliacionCab;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.MovimientoCtaBancaria;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.tesoreria.da.DBMovimientoCtaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMovimientoCtaBancaria extends FactoryObjetoLogico {

  public FactoryMovimientoCtaBancaria() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MovimientoCtaBancaria movimientoctabancaria = (MovimientoCtaBancaria) objLog;
    movimientoctabancaria.setOID(db.getInteger(DBMovimientoCtaBancaria.OID_MOV_CTA_BCO));
    movimientoctabancaria.setCtabancaria(CuentaBancaria.findByOidProxy(db.getInteger(DBMovimientoCtaBancaria.OID_CTA_BANCARIA),getSesion()));
    movimientoctabancaria.setNrovalor(db.getInteger(DBMovimientoCtaBancaria.NRO_VALOR));
    movimientoctabancaria.setTipomov(db.getString(DBMovimientoCtaBancaria.TIPO_MOV));
    movimientoctabancaria.setFechaOperativa(db.getDate(DBMovimientoCtaBancaria.FECHA_OPER));
    movimientoctabancaria.setFechacontable(db.getDate(DBMovimientoCtaBancaria.FECHA_CONTABLE));
    movimientoctabancaria.setFechaemision(db.getDate(DBMovimientoCtaBancaria.FECHA_EMISION));
    movimientoctabancaria.setFechavto(db.getDate(DBMovimientoCtaBancaria.FECHA_VTO));
    movimientoctabancaria.setSigno(db.getInteger(DBMovimientoCtaBancaria.SIGNO));
    movimientoctabancaria.setImporte(db.getMoney(DBMovimientoCtaBancaria.IMPORTE));
    movimientoctabancaria.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBMovimientoCtaBancaria.OID_CCO),getSesion()));
    movimientoctabancaria.setActivo(db.getBoolean(DBMovimientoCtaBancaria.ACTIVO));
    movimientoctabancaria.setImportehist(db.getMoney(DBMovimientoCtaBancaria.IMPORTE_HIST));
    movimientoctabancaria.setImporteaju(db.getMoney(DBMovimientoCtaBancaria.IMPORTE_AJU));
    movimientoctabancaria.setImporteext1(db.getMoney(DBMovimientoCtaBancaria.IMPORTE_EXT1));
    movimientoctabancaria.setImporteext2(db.getMoney(DBMovimientoCtaBancaria.IMPORTE_EXT2));
    movimientoctabancaria.setCotizMonOri(db.getValorCotizacion(DBMovimientoCtaBancaria.COTIZ_MON_ORI));
    movimientoctabancaria.setCotizMonExt1(db.getValorCotizacion(DBMovimientoCtaBancaria.COTIZ_MON_EXT1));
    movimientoctabancaria.setCotizMonExt2(db.getValorCotizacion(DBMovimientoCtaBancaria.COTIZ_MON_EXT2));
    movimientoctabancaria.setCotizMonOriCon(db.getValorCotizacion(DBMovimientoCtaBancaria.COTIZ_MON_ORI_CON));
    movimientoctabancaria.setCotizMonExt1Con(db.getValorCotizacion(DBMovimientoCtaBancaria.COTIZ_MON_EXT1_CON));
    movimientoctabancaria.setCotizMonExt2Con(db.getValorCotizacion(DBMovimientoCtaBancaria.COTIZ_MON_EXT2_CON));
    movimientoctabancaria.setValor(Valor.findByOidProxy(db.getInteger(DBMovimientoCtaBancaria.OID_VALOR),getSesion()));
    movimientoctabancaria.setCuenta(CuentaImputable.findByOidProxy(db.getInteger(DBMovimientoCtaBancaria.OID_AI),getSesion()));
    movimientoctabancaria.setTipoValor(TipoValor.findByOidProxy(db.getInteger(DBMovimientoCtaBancaria.OID_TIPO_VALOR),getSesion()));
    movimientoctabancaria.setConciliado(db.getBoolean(DBMovimientoCtaBancaria.CONCILIADO));
    movimientoctabancaria.setConciliacionCab(ConciliacionCab.findByOidProxy(db.getInteger(DBMovimientoCtaBancaria.OID_CONCI_BCO),getSesion()));
    
  }
}
