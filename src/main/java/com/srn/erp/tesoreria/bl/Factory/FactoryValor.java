package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.Ticket;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.tesoreria.da.DBValor;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryValor extends FactoryObjetoLogico {

  public FactoryValor() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Valor valor = (Valor) objLog;
    valor.setOID(db.getInteger(DBValor.OID_VALOR));
    valor.setTipovalor(TipoValor.findByOidProxy(db.getInteger(DBValor.OID_TIPO_VALOR),getSesion()));
    valor.setTarjetacredito(TarjetaCredito.findByOidProxy(db.getInteger(DBValor.OID_TAR_CREDITO),getSesion()));
    valor.setTicket(Ticket.findByOidProxy(db.getInteger(DBValor.OID_TICKET),getSesion()));
    valor.setBanco(Banco.findByOidProxy(db.getInteger(DBValor.OID_BANCO),getSesion()));
    valor.setNrocheque(db.getInteger(DBValor.NRO_CHEQUE));
    valor.setFechaemision(db.getDate(DBValor.FEC_EMISION));
    valor.setFechavto(db.getDate(DBValor.FEC_VTO));
    valor.setAnulado(db.getBoolean(DBValor.ANULADO));
    valor.setEndosado(db.getBoolean(DBValor.ENDOSADO));
    valor.setCuentabancaria(CuentaBancaria.findByOidProxy(db.getInteger(DBValor.OID_CTA_BANCARIA),getSesion()));
    valor.setDepositado(db.getBoolean(DBValor.DEPOSITADO));
    valor.setRechazado(db.getBoolean(DBValor.RECHAZADO));
    valor.setCobrado(db.getBoolean(DBValor.COBRADO));
    valor.setTitular(db.getString(DBValor.TITULAR));
    valor.setRecibido(db.getBoolean(DBValor.RECIBIDO));
    valor.setCupon(db.getInteger(DBValor.CUPON));
    valor.setNro_tarjeta(db.getString(DBValor.NRO_TARJETA));
    valor.setNro_valor(db.getInteger(DBValor.NRO_VALOR));
    valor.setCaja(Caja.findByOidProxy(db.getInteger(DBValor.OID_CAJA),getSesion()));
    valor.setEstaencaja(db.getBoolean(DBValor.ES_CAJA));
    valor.setSaldo(db.getMoney(DBValor.SALDO));
    valor.setImporte(db.getMoney(DBValor.IMPORTE));
    valor.setUsuario(Usuario.findByOidProxy(db.getInteger(DBValor.OID_USUARIO),getSesion()));
    valor.setCotizacion(db.getValorCotizacion(DBValor.COTIZACION));
    valor.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBValor.OID_SUJETO),getSesion()));
    valor.setLote(db.getInteger(DBValor.LOTE));
    valor.setCuotas(db.getInteger(DBValor.CUOTAS));
    valor.setNroCertificado(db.getString(DBValor.NRO_CERTIFICADO));
    valor.setProvincia(Provincia.findByOidProxy(db.getInteger(DBValor.OID_PROVINCIA),getSesion()));
    valor.setCodigoAutorizacion(db.getString(DBValor.CODIGO_AUTORIZ));
    valor.setCUIT(db.getString(DBValor.CUIT));
    valor.setNuevaFecVto(db.getDate(DBValor.NUE_FEC_VTO));
    valor.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBValor.OID_PROVEEDOR),getSesion()));
    valor.setLiquidado(db.getBoolean(DBValor.LIQUIDADO));
}
}
