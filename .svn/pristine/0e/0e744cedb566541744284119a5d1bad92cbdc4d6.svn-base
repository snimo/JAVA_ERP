package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBHistoricoPuesto;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class HistoricoPuesto extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public HistoricoPuesto() {
	}

	public static String NICKNAME = "rh.HistoricoPuesto";

	private ValorClasificadorEntidad val_clasif_pue;
	private ValorClasificadorEntidad val_clasif_sec;
	private ValorClasificadorEntidad val_clasif_emp;
	private java.util.Date fec_desde;
	private Legajo legajo;
	private Boolean activo;

	public ValorClasificadorEntidad getVal_clasif_pue() throws BaseException {
		supportRefresh();
		return val_clasif_pue;
	}

	public void setVal_clasif_pue(ValorClasificadorEntidad aVal_clasif_pue) {
		this.val_clasif_pue = aVal_clasif_pue;
	}
	
	public ValorClasificadorEntidad getVal_clasif_emp() throws BaseException {
		supportRefresh();
		return val_clasif_emp;
	}

	public void setVal_clasif_emp(ValorClasificadorEntidad aVal_clasif_emp) {
		this.val_clasif_emp = aVal_clasif_emp;
	}	
	
	public ValorClasificadorEntidad getVal_clasif_sec() throws BaseException {
		supportRefresh();
		return val_clasif_sec;
	}

	public void setVal_clasif_sec(ValorClasificadorEntidad aVal_clasif_sec) {
		this.val_clasif_sec = aVal_clasif_sec;
	}	

	public java.util.Date getFec_desde() throws BaseException {
		supportRefresh();
		return fec_desde;
	}

	public void setFec_desde(java.util.Date aFec_desde) {
		this.fec_desde = aFec_desde;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
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

	public static HistoricoPuesto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (HistoricoPuesto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static HistoricoPuesto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (HistoricoPuesto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(this.val_clasif_pue, "Debe ingresar el Puesto");
		Validar.noNulo(this.val_clasif_emp, "Debe ingresar la Empresa");
		Validar.noNulo(this.val_clasif_sec, "Debe ingresar el Sector");
	}

	public static List getHistoricoPuestos(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBHistoricoPuesto.getHistoricoPuestos(aLegajo, aSesion);
	}

	public static void truncarTablaPayHistPuesto(ISesion aSesion) throws BaseException {
		DBHistoricoPuesto.truncarTablaHistoricoPuesto(aSesion);
	}

	public static HistoricoPuesto getHistoricoPuesto(Legajo aLegajo, ValorClasificadorEntidad puesto, ISesion aSesion) throws BaseException {
		return DBHistoricoPuesto.getHistoricoPuesto(aLegajo, puesto, aSesion);
	}

	public static HistoricoPuesto getHistoricoPuesto(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBHistoricoPuesto.getHistoricoPuesto(aLegajo, aSesion);
	}

}
