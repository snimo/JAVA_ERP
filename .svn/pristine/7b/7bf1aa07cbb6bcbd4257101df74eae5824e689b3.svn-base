package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MovimientoCaja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.tesoreria.da.DBMovimientoCaja;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryMovimientoCaja extends FactoryObjetoLogico {

  public FactoryMovimientoCaja() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MovimientoCaja movimientocaja = (MovimientoCaja) objLog;
    movimientocaja.setOID(db.getInteger(DBMovimientoCaja.OID_ARQUEO));
    movimientocaja.setCaja(Caja.findByOidProxy(db.getInteger(DBMovimientoCaja.OID_CAJA),getSesion()));
    movimientocaja.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBMovimientoCaja.OID_CCO),getSesion()));
    movimientocaja.setFechacaja(db.getDate(DBMovimientoCaja.FECHA_CAJA));
    movimientocaja.setValor(Valor.findByOidProxy(db.getInteger(DBMovimientoCaja.OID_VALOR),getSesion()));
    movimientocaja.setSigno(db.getInteger(DBMovimientoCaja.SIGNO));
    movimientocaja.setImporte(db.getMoney(DBMovimientoCaja.IMPORTE));
    movimientocaja.setMoneda(Moneda.findByOidProxy(db.getInteger(DBMovimientoCaja.OID_MONEDA),getSesion()));
    movimientocaja.setTipovalor(TipoValor.findByOidProxy(db.getInteger(DBMovimientoCaja.OID_TIPO_VALOR),getSesion()));
    movimientocaja.setCompotipovalor(db.getString(DBMovimientoCaja.COMPO_TIPO_VALOR));
    movimientocaja.setCotizacion(db.getValorCotizacion(DBMovimientoCaja.COTIZACION));
    movimientocaja.setEntrada(db.getMoney(DBMovimientoCaja.ENTRADA));
    movimientocaja.setSalida(db.getMoney(DBMovimientoCaja.SALIDA));
    movimientocaja.setActivo(db.getBoolean(DBMovimientoCaja.ACTIVO));
    movimientocaja.setFechaReal(db.getDate(DBMovimientoCaja.FECHA_REAL));
    movimientocaja.setHora(db.getString(DBMovimientoCaja.HORA_REAL));
    movimientocaja.setUsuario(Usuario.findByOidProxy(db.getInteger(DBMovimientoCaja.USUARIO),getSesion()));
    movimientocaja.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBMovimientoCaja.OID_SUJETO),getSesion()));
  }
}
