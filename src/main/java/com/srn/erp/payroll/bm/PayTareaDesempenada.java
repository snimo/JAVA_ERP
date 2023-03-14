package com.srn.erp.payroll.bm;

import java.util.List;

import com.srn.erp.payroll.da.DBPayTareaDesempenada;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class PayTareaDesempenada extends ObjetoLogico {

	public PayTareaDesempenada() {
	}

	public static String NICKNAME = "admRRHH.payTareaDesempenada";

	private Integer codigo;
	private String descripcion;

	public Integer getCodigoActual() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(Integer aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PayTareaDesempenada findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PayTareaDesempenada) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PayTareaDesempenada findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PayTareaDesempenada) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public static List<PayTareaDesempenada> findAll(ISesion aSesion) throws BaseException {
		return (List<PayTareaDesempenada>) DBPayTareaDesempenada.findAll(aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
