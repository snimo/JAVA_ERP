package com.srn.erp.cashflow.bm;

import java.util.List;

import com.srn.erp.cashflow.da.DBConfProgConcCF;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.presupuesto.bm.Escenario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfProgConcCF extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ConfProgConcCF() {
	}

	public static String NICKNAME = "cf.ConfProgConcCF";

	private ConceptoCashFlow concepto;
	private Integer nro_mes;
	private Integer dia;
	private Double monto;
	private Moneda moneda;
	private Boolean activo;

	public ConceptoCashFlow getConcepto() throws BaseException {
		supportRefresh();
		return concepto;
	}

	public void setConcepto(ConceptoCashFlow aConcepto) {
		this.concepto = aConcepto;
	}

	public Integer getNro_mes() throws BaseException {
		supportRefresh();
		return nro_mes;
	}

	public void setNro_mes(Integer aNro_mes) {
		this.nro_mes = aNro_mes;
	}

	public Integer getDia() throws BaseException {
		supportRefresh();
		return dia;
	}

	public void setDia(Integer aDia) {
		this.dia = aDia;
	}

	public Double getMonto() throws BaseException {
		supportRefresh();
		return monto;
	}

	public void setMonto(Double aMonto) {
		this.monto = aMonto;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
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

	public static ConfProgConcCF findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ConfProgConcCF) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConfProgConcCF findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ConfProgConcCF) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(concepto, "Debe ingresar el Concepto CashFlow");
		Validar.noNulo(nro_mes, "Debe ingresar el Mes");
		Validar.noNulo(dia, "Debe ingresar el día");
		Validar.noNulo(monto, "Debe ingresar el Moneto");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
	}

	public static List getConfProgConcCF(ConceptoCashFlow concepto, ISesion aSesion) throws BaseException {
		return DBConfProgConcCF.getConfProgConcCF(concepto, aSesion);
	}

	public static List getConfProgConcCF(Integer nroMes, Integer diaDesde, Integer diaHasta, ISesion aSesion) throws BaseException {
		return DBConfProgConcCF.getConfProgConcCF(nroMes, diaDesde, diaHasta, aSesion);
	}

	public static List getConfProgConcCF(
			Integer nroMes, 
			Integer nroDia, 
			EscenarioCashFlow escenario,
			ISesion aSesion) throws BaseException {
		return DBConfProgConcCF.getConfProgConcCF(nroMes, nroDia, escenario, aSesion);
	}

}
