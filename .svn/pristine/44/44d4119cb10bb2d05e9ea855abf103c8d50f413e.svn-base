package com.srn.erp.payroll.bm;

import java.util.List;

import com.srn.erp.payroll.da.DBPayPuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class PayPuesto extends ObjetoLogico {

	public PayPuesto() {
	}

	public static String NICKNAME = "admRRHH.payPuesto";

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

	public static PayPuesto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PayPuesto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PayPuesto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PayPuesto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public static List<PayPuesto> findAll(ISesion aSesion) throws BaseException {
		return (List<PayPuesto>) DBPayPuesto.findAll(aSesion);
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
