package com.srn.erp.cashflow.bm;

import java.util.List;

import com.srn.erp.cashflow.da.DBTipoValorSICajaCF;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoValorSICajaCF extends ObjetoLogico {

	public TipoValorSICajaCF() {
	}

	public static String NICKNAME = "cf.TipoValorSICajaCF";

	private CajaSaldoIniCF saldo_inicial_caja;
	private TipoValor tipo_valor;
	private Boolean activo;

	public CajaSaldoIniCF getSaldo_inicial_caja() throws BaseException {
		supportRefresh();
		return saldo_inicial_caja;
	}

	public void setSaldo_inicial_caja(CajaSaldoIniCF aSaldo_inicial_caja) {
		this.saldo_inicial_caja = aSaldo_inicial_caja;
	}

	public TipoValor getTipo_valor() throws BaseException {
		supportRefresh();
		return tipo_valor;
	}

	public void setTipo_valor(TipoValor aTipo_valor) {
		this.tipo_valor = aTipo_valor;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TipoValorSICajaCF findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoValorSICajaCF) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TipoValorSICajaCF findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoValorSICajaCF) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(saldo_inicial_caja, "Debe ingresar el Saldo Inicial de Caja");
		Validar.noNulo(tipo_valor, "Debe ingresar el Tipo de Valor");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getTiposValoresSICaja(
			CajaSaldoIniCF cajaSaldoIniCF, 
			ISesion aSesion) throws BaseException {
		return DBTipoValorSICajaCF.getTiposValoresSICaja(cajaSaldoIniCF,aSesion); 
	}

}
