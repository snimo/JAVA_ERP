package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBContadorCacheoLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ContadorCacheoLeg extends ObjetoLogico {

	public ContadorCacheoLeg() {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "cip.ContadorCacheoLeg";

	private Legajo legajo;
	private Integer cantidad;

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public Integer getCantidad() throws BaseException {
		supportRefresh();
		if (cantidad == null)
			return new Integer(0);
		else
			return cantidad;
	}

	public void setCantidad(Integer aCantidad) {
		this.cantidad = aCantidad;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ContadorCacheoLeg findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ContadorCacheoLeg) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ContadorCacheoLeg findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ContadorCacheoLeg) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(cantidad, "Debe ingresar la cantidad");
	}

	public static int getMaximoCacheosLeg(ISesion aSesion) throws BaseException {
		return DBContadorCacheoLeg.getMaximoCacheosLeg(aSesion);
	}

	public static List getAllCacheosLeg(ISesion aSesion) throws BaseException {
		return DBContadorCacheoLeg.getAllCacheosLeg(aSesion);
	}

	public static int getMaximoCacheosLegPorRota(java.util.Date fecha, Rota rota, ISesion aSesion) throws BaseException {

		return DBContadorCacheoLeg.getMaximoCacheosLegPorRota(fecha, rota, aSesion);

	}

	public static ContadorCacheoLeg getContadorCacheoLeg(Legajo legajo, ISesion aSesion) throws BaseException {
		return DBContadorCacheoLeg.getContadorCacheoLeg(legajo, aSesion);
	}
	
	public void acumular() throws BaseException {
		this.supportRefresh();
		if (this.cantidad == null)
			this.cantidad = new Integer(0);
		cantidad = cantidad.intValue()+1;
	}

}
