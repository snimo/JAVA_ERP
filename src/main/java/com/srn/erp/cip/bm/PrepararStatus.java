package com.srn.erp.cip.bm;

import com.srn.erp.cip.da.DBPrepararStatus;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class PrepararStatus extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrepararStatus() {
	}

	public static String NICKNAME = "cip.PrepararStatus";

	private Puerta puerta;
	private java.util.Date fecha_ultstatus;
	private String hora_ultstatus;
	private Boolean activo;

	public Puerta getPuerta() throws BaseException {
		supportRefresh();
		return puerta;
	}

	public void setPuerta(Puerta aPuerta) {
		this.puerta = aPuerta;
	}

	public java.util.Date getFecha_ultStatus() throws BaseException {
		supportRefresh();
		return fecha_ultstatus;
	}

	public void setFecha_ultstatus(java.util.Date aFecha_ultStatus) {
		this.fecha_ultstatus = aFecha_ultStatus;
	}

	public String getHora_ultStatus() throws BaseException {
		supportRefresh();
		return hora_ultstatus;
	}

	public void setHora_ultStatus(String aHora_ultStatus) {
		this.hora_ultstatus = aHora_ultStatus;
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

	public static PrepararStatus findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PrepararStatus) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PrepararStatus findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PrepararStatus) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(puerta, "Debe ingresar la Puerta");
	}
	
	public static PrepararStatus getPuertaByIdentif(String identif, ISesion aSesion) throws BaseException {
		return DBPrepararStatus.getPuertaByIdentif(identif,aSesion);
	}
	
	
}
