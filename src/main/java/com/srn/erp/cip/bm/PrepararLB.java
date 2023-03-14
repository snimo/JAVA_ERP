package com.srn.erp.cip.bm;

import com.srn.erp.cip.da.DBPrepararLB;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PrepararLB extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrepararLB() {
	}

	public static String NICKNAME = "cip.PrepararLB";

	private Puerta puerta;
	private java.util.Date fecha_preparacion;
	private String hora_prep;
	private Boolean activo;

	public Puerta getPuerta() throws BaseException {
		supportRefresh();
		return puerta;
	}

	public void setPuerta(Puerta aPuerta) {
		this.puerta = aPuerta;
	}

	public java.util.Date getFecha_preparacion() throws BaseException {
		supportRefresh();
		return fecha_preparacion;
	}

	public void setFecha_preparacion(java.util.Date aFecha_preparacion) {
		this.fecha_preparacion = aFecha_preparacion;
	}

	public String getHora_prep() throws BaseException {
		supportRefresh();
		return hora_prep;
	}

	public void setHora_prep(String aHora_prep) {
		this.hora_prep = aHora_prep;
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

	public static PrepararLB findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PrepararLB) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PrepararLB findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PrepararLB) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(puerta, "Debe ingresar la Puerta");
	}
	
	public static PrepararLB getPrepararLB(Puerta puerta, ISesion aSesion) throws BaseException {
		return DBPrepararLB.getPrepararLB(puerta,aSesion);
	}
	


}
