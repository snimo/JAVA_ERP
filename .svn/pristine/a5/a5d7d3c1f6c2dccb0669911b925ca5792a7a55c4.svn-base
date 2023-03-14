package com.srn.erp.bancos.bm;

import java.util.List;

import com.srn.erp.bancos.da.DBGastoBoletaDeposito;
import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GastoBoletaDeposito extends ObjetoLogico {

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

	public GastoBoletaDeposito() {
	}

	public static String		NICKNAME	= "ba.GastoBoletaDeposito";

	private BoletaDeposito	boleta_deposito;

	private CuentaImputable	cuenta_imputable;

	private Money						debe;

	private Money						haber;

	private String					comentario;

	public BoletaDeposito getBoleta_deposito() throws BaseException {
		supportRefresh();
		return boleta_deposito;
	}

	public void setBoleta_deposito(BoletaDeposito aBoleta_deposito) {
		this.boleta_deposito = aBoleta_deposito;
	}

	public CuentaImputable getCuenta_imputable() throws BaseException {
		supportRefresh();
		return cuenta_imputable;
	}

	public void setCuenta_imputable(CuentaImputable aCuenta_imputable) {
		this.cuenta_imputable = aCuenta_imputable;
	}

	public Money getDebe() throws BaseException {
		supportRefresh();
		return debe;
	}

	public void setDebe(Money aDebe) {
		this.debe = aDebe;
	}

	public Money getHaber() throws BaseException {
		supportRefresh();
		return haber;
	}

	public void setHaber(Money aHaber) {
		this.haber = aHaber;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static GastoBoletaDeposito findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GastoBoletaDeposito) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GastoBoletaDeposito findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GastoBoletaDeposito) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(boleta_deposito, "Debe ingresar la Boleta de Depósito");
		Validar.noNulo(cuenta_imputable, "Debe ingresar la cuenta");
	}
	
  public static List getGastosByBoletaDeposito(BoletaDeposito boletaDeposito,
      ISesion aSesion) throws BaseException {
  	return DBGastoBoletaDeposito.getGastosByBoletaDeposito(boletaDeposito,aSesion);
  }
	

}
