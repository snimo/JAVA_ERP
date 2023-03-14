package com.srn.erp.bancos.bm;

import java.util.List;

import com.srn.erp.bancos.da.DBBoletaDepositoDet;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class BoletaDepositoDet extends ObjetoLogico {

	public BoletaDepositoDet() {
	}

	public static String		NICKNAME									= "ba.BoletaDepositoDet";

	public static final int	SELECT_BY_BOLETA_DEPOSITO	= 100;

	private BoletaDeposito	boleta_deposito;

	private TipoValor				tipo_valor;

	private Valor						valor;

	private Money						importe;

	private Caja						caja;
	
	private ValorCotizacion cotizacion;
	
	private Money impoMonValor;

	public BoletaDeposito getBoleta_deposito() throws BaseException {
		supportRefresh();
		return boleta_deposito;
	}

	public void setBoleta_deposito(BoletaDeposito aBoleta_deposito) {
		this.boleta_deposito = aBoleta_deposito;
	}
	
	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(ValorCotizacion aValorCotizacion) {
		this.cotizacion = aValorCotizacion;
	}
	
	
	public Money getImpoMonValor() throws BaseException {
		supportRefresh();
		return this.impoMonValor;
	}

	public void setImpoMonValor(Money aImpoMonVlor) {
		this.impoMonValor = aImpoMonVlor;
	}
	

	public TipoValor getTipo_valor() throws BaseException {
		supportRefresh();
		return tipo_valor;
	}

	public void setTipo_valor(TipoValor aTipo_valor) {
		this.tipo_valor = aTipo_valor;
	}

	public Valor getValor() throws BaseException {
		supportRefresh();
		return valor;
	}

	public void setValor(Valor aValor) {
		this.valor = aValor;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
	}

	public String getNickName() {
		return NICKNAME;
	}
	
	public static BoletaDepositoDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (BoletaDepositoDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static BoletaDepositoDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (BoletaDepositoDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(boleta_deposito, "Debe ingresar el Boleta de Depósito");
		Validar.noNulo(tipo_valor, "Debe ingresar el Tipo de Valor");
		Validar.noNulo(importe, "Debe ingresar el Importe");
		Validar.noNulo(caja, "Debe ingresar la Caja");
		Validar.noNulo(cotizacion, "Debe ingresar la cotización");
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getDetallesBolDep(BoletaDeposito boletaDeposito, ISesion aSesion) throws BaseException {
		return DBBoletaDepositoDet.getDetallesBolDep(boletaDeposito, aSesion);
	}

}
