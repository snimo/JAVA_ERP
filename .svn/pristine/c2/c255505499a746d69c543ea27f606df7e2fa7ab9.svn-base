package com.srn.erp.rrhh.bm;

import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoObsLeg extends ObjetoLogico {

	public TipoObsLeg() {
	}

	public static String NICKNAME = "rh.TipoObsLeg";

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

	public static TipoObsLeg findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoObsLeg) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static TipoObsLeg findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoObsLeg) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static TipoObsLeg findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoObsLeg) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	public static TipoObsLeg getTipoObsRelLab(ISesion aSesion)
	throws BaseException {
			Integer oid= ValorParametro.findByCodigoParametro(
						"TIPO_OBS_LEG_REL_LAB", aSesion).getOidObjNeg();
			TipoObsLeg tipoObs = TipoObsLeg.findByOid(oid, aSesion);
			return tipoObs;
	}	

}
