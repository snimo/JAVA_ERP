package com.srn.erp.cip.bm;

import com.srn.erp.cip.da.DBLegFecRotPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class LegFecRotPayroll extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public LegFecRotPayroll() {
	}

	public static String NICKNAME = "cip.LegFecRotPayroll";

	private String etrlegajo;
	private java.util.Date etrfecha;
	private String etrtramo;
	private Boolean activo;

	public String getEtrlegajo() throws BaseException {
		supportRefresh();
		return etrlegajo;
	}

	public void setEtrlegajo(String aEtrlegajo) {
		this.etrlegajo = aEtrlegajo;
	}

	public java.util.Date getEtrfecha() throws BaseException {
		supportRefresh();
		return etrfecha;
	}

	public void setEtrfecha(java.util.Date aEtrfecha) {
		this.etrfecha = aEtrfecha;
	}

	public String getEtrtramo() throws BaseException {
		supportRefresh();
		return etrtramo;
	}

	public void setEtrtramo(String aEtrtramo) {
		this.etrtramo = aEtrtramo;
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

	public static LegFecRotPayroll findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (LegFecRotPayroll) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static LegFecRotPayroll findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (LegFecRotPayroll) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public static void truncarTablaLegRotFecPayroll(ISesion aSesion)
	  throws BaseException {
		 DBLegFecRotPayroll.truncarTablaLegRotFecPayroll(aSesion);
	}
	

}
