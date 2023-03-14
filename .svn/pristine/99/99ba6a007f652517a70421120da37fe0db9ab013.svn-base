package com.srn.erp.cashflow.bm;

import java.util.List;

import com.srn.erp.cashflow.da.DBCajasHabDeudaFinanCF;
import com.srn.erp.tesoreria.bm.Caja;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CajasHabDeudaFinanCF extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CajasHabDeudaFinanCF() {
	}

	public static String NICKNAME = "cf.CajasHabDeudaFinanCF";

	private EscenarioCashFlow escenario_cf;
	private Caja caja;
	private Boolean activo;

	public EscenarioCashFlow getEscenario_cf() throws BaseException {
		supportRefresh();
		return escenario_cf;
	}

	public void setEscenario_cf(EscenarioCashFlow aEscenario_cf) {
		this.escenario_cf = aEscenario_cf;
	}

	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
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

	public static CajasHabDeudaFinanCF findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CajasHabDeudaFinanCF) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CajasHabDeudaFinanCF findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CajasHabDeudaFinanCF) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(escenario_cf, "Debe ingresar el Escenario");
		Validar.noNulo(caja, "Debe ingresar la Caja");
	}

	public static List getCajasHabDeudaFinan(EscenarioCashFlow escenario, ISesion aSesion) throws BaseException {
		return DBCajasHabDeudaFinanCF.getCajasHabDeudaFinan(escenario, aSesion);
	}
	
	public static List getCajasHabDeudaFinanActivas(EscenarioCashFlow escenario, ISesion aSesion) throws BaseException {
		return DBCajasHabDeudaFinanCF.getCajasHabDeudaFinanActivas(escenario, aSesion);
	}
	

}
