package com.srn.erp.payroll.bm;

import java.util.List;

import com.srn.erp.payroll.da.DBPayTipoAusencias;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class PayTipoAusencias extends ObjetoLogico {

	public PayTipoAusencias() {
	}

	public static String NICKNAME = "admRRHH.payTipoAusencias";

	private Integer CODIGO;
	private Integer COTAB;
	private String DESCRIP;

	public Integer getCodigoActual() throws BaseException {
		supportRefresh();
		return CODIGO;
	}

	public void setCodigo(Integer aCodigo) {
		this.CODIGO = aCodigo;
	}

	public Integer getCotab() throws BaseException {
		supportRefresh();
		return COTAB;
	}

	public void setCotab(Integer aCotab) {
		this.COTAB = aCotab;
	}

	public String getDescrip() throws BaseException {
		supportRefresh();
		return DESCRIP;
	}

	public void setDescrip(String aDescrip) {
		this.DESCRIP = aDescrip;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PayTipoAusencias findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (PayTipoAusencias) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PayTipoAusencias findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (PayTipoAusencias) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public static List<PayTipoAusencias> findAll(ISesion aSesion) throws BaseException {
		return (List<PayTipoAusencias>) DBPayTipoAusencias.findAll(aSesion);
	}
	
	public void beforeSave() throws BaseException {
	}

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

	
	
}
