package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoBajaTarjeta extends ObjetoLogico {

	public MotivoBajaTarjeta() {
	}

	public static String NICKNAME = "cip.MotivoBajaTarjeta";

	private String codigo;
	private String descripcion;
	private Boolean activo;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
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

	public static MotivoBajaTarjeta findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoBajaTarjeta) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static MotivoBajaTarjeta findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoBajaTarjeta) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static MotivoBajaTarjeta findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MotivoBajaTarjeta) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
	}

	public static MotivoBajaTarjeta getMotivoPerdioTarjeta(ISesion aSesion)
	throws BaseException {
		Integer oidMotivo = ValorParametro.findByCodigoParametro(
				"MOTPERDIOTARJ", aSesion).getOidObjNeg();
		MotivoBajaTarjeta motivo = MotivoBajaTarjeta.findByOid(oidMotivo, aSesion);
		return motivo;
	}
	
	
}
