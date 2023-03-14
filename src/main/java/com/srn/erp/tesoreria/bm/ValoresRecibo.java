package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.tesoreria.da.DBValoresRecibo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ValoresRecibo extends ObjetoLogico {

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
		if (this.getValor() != null)
			return this.getValor().getDescripcion();
		return "";
	}

	public ValoresRecibo() {
	}

	public static String		NICKNAME	= "te.ValoresRecibo";

	private Recibo					recibo;

	private TipoValor				tipo_valor;

	private Valor						valor;

	private Money						impo_mon_ori;

	private Money						impo_mon_loc;

	private ValorCotizacion	cotizacion;

	private Money						impo_mon_rec;

	public Recibo getRecibo() throws BaseException {
		supportRefresh();
		return recibo;
	}

	public void setRecibo(Recibo aRecibo) {
		this.recibo = aRecibo;
	}

	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(ValorCotizacion aValorCotizacion) {
		this.cotizacion = aValorCotizacion;
	}

	public Money getImpoMonRec() throws BaseException {
		supportRefresh();
		return impo_mon_rec;
	}

	public void setImpoMonRec(Money aImpoMonRec) {
		this.impo_mon_rec = aImpoMonRec;
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

	public Money getImpo_mon_ori() throws BaseException {
		supportRefresh();
		return impo_mon_ori;
	}

	public void setImpo_mon_ori(Money aImpo_mon_ori) {
		this.impo_mon_ori = aImpo_mon_ori;
	}

	public Money getImpo_mon_loc() throws BaseException {
		supportRefresh();
		return impo_mon_loc;
	}

	public void setImpo_mon_loc(Money aImpo_mon_loc) {
		this.impo_mon_loc = aImpo_mon_loc;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ValoresRecibo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ValoresRecibo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ValoresRecibo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ValoresRecibo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ValoresRecibo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ValoresRecibo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(recibo, "Debe ingresar un Recibo");
		Validar.noNulo(tipo_valor, "Debe ingresar un Tipo de Valor");
	}

	public static List getValoresEnRecibo(Recibo recibo, ISesion aSesion) throws BaseException {
		return DBValoresRecibo.getValoresEnRecibo(recibo, aSesion);
	}

}
