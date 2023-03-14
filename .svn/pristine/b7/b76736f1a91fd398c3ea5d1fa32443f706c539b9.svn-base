package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.tesoreria.da.DBTransferenciaEfectivo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class TransferenciaEfectivo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public TransferenciaEfectivo() {
	}

	public static String					NICKNAME	= "te.TransferenciaEfectivo";

	private TransferenciaValores	transferencia_valores;

	private TipoValor							tipo_valor;

	private Money									saldo;

	private Money									transferido;

	public TransferenciaValores getTransferencia_valores() throws BaseException {
		supportRefresh();
		return transferencia_valores;
	}

	public void setTransferencia_valores(TransferenciaValores aTransferencia_valores) {
		this.transferencia_valores = aTransferencia_valores;
	}

	public TipoValor getTipo_valor() throws BaseException {
		supportRefresh();
		return tipo_valor;
	}

	public void setTipo_valor(TipoValor aTipo_valor) {
		this.tipo_valor = aTipo_valor;
	}

	public Money getSaldo() throws BaseException {
		supportRefresh();
		return saldo;
	}

	public void setSaldo(Money aSaldo) {
		this.saldo = aSaldo;
	}

	public Money getTransferido() throws BaseException {
		supportRefresh();
		return transferido;
	}

	public void setTransferido(Money aTransferido) {
		this.transferido = aTransferido;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TransferenciaEfectivo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TransferenciaEfectivo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TransferenciaEfectivo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TransferenciaEfectivo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TransferenciaEfectivo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TransferenciaEfectivo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(transferencia_valores, "Debe ingresar la Transferencia de Valores");
		Validar.noNulo(tipo_valor, "Debe ingresar el Tipo de Valor");
	}

	public static List getTransferenciasEfectivo(TransferenciaValores transferencia, ISesion aSesion)
			throws BaseException {
		return DBTransferenciaEfectivo.getTransferenciasEfectivo(transferencia, aSesion);
	}

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		saveTransferenciaEfectivo();
		
	}
	
	private void saveTransferenciaEfectivo() throws BaseException {
		salidaEfectivoCajaOrigen();
		entradaEfectivoCajaDestino();
	}
	
  public void salidaEfectivoCajaOrigen() throws BaseException {
    Efectivo efectivo = new Efectivo();
    efectivo.setSesion(getSesion());
    efectivo.setTipoValor(this.getTipo_valor());
    Caja caja = this.getTransferencia_valores().getCajaOrigen();
    efectivo.setCaja(caja);
    efectivo.setFechaCaja(caja.getFechaCaja());
    efectivo.setImporte(this.getTransferido());
    efectivo.setTipoOper(Efectivo.SALIDA);
    efectivo.setComprobante(this.getTransferencia_valores());
    efectivo.setCotizacion(this.getTransferencia_valores().getCotizacionMoneda(this.getTipo_valor().getMoneda()));
    efectivo.setActivo(new Boolean(true));
    efectivo.save();
  }
  
  public void entradaEfectivoCajaDestino() throws BaseException {
    Efectivo efectivo = new Efectivo();
    efectivo.setSesion(getSesion());
    efectivo.setTipoValor(this.getTipo_valor());
    Caja caja = this.getTransferencia_valores().getCajaDestino();
    efectivo.setCaja(caja);
    efectivo.setFechaCaja(caja.getFechaCaja());
    efectivo.setImporte(this.getTransferido());
    efectivo.setTipoOper(Efectivo.ENTRADA);
    efectivo.setComprobante(this.getTransferencia_valores());
    efectivo.setCotizacion(this.getTransferencia_valores().getCotizacionMoneda(this.getTipo_valor().getMoneda()));
    efectivo.setActivo(new Boolean(true));
    efectivo.save();
  }
  
	

}
