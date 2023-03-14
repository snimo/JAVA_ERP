package com.srn.erp.cashflow.bm;

import java.util.List;

import com.srn.erp.cashflow.da.DBCtaSaldoIniCf;
import com.srn.erp.contabilidad.bm.Cuenta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CtaSaldoIniCf extends ObjetoLogico {

	public CtaSaldoIniCf() {
	}

	public static String NICKNAME = "cf.CtaSaldoIniCf";

	private EscenarioCashFlow escenario;
	private Cuenta cuenta;
	private Boolean activo;

	public EscenarioCashFlow getEscenario() throws BaseException {
		supportRefresh();
		return escenario;
	}

	public void setEscenario(EscenarioCashFlow aEscenario) {
		this.escenario = aEscenario;
	}

	public Cuenta getCuenta() throws BaseException {
		supportRefresh();
		return cuenta;
	}

	public void setCuenta(Cuenta aCuenta) {
		this.cuenta = aCuenta;
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

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static CtaSaldoIniCf findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CtaSaldoIniCf) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CtaSaldoIniCf findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CtaSaldoIniCf) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(escenario, "Debe ingresar el Escenario");
		Validar.noNulo(cuenta, "Debe ingresar la Cuenta");
	}

	public static List getCtasContablesSICaja(EscenarioCashFlow escenario, ISesion aSesion) throws BaseException {
		return DBCtaSaldoIniCf.getCtasContablesSICaja(escenario, aSesion);
	}

}
