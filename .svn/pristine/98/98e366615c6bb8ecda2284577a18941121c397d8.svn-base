package com.srn.erp.Ausentismo.bm;

import java.util.List;

import com.srn.erp.Ausentismo.da.DBGrupoRRHHDetalle;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class GrupoRRHHDetalle extends ObjetoLogico {

	public GrupoRRHHDetalle() {
	}

	public static String NICKNAME = "admRRHH.GrupoDet";

	private Integer oid_grupo;
	private String cod_ext_1;
	private String cod_ext_2;
	private String descripcion;
	private Boolean activo;

	public Integer getOid_grupo() throws BaseException {
		supportRefresh();
		return oid_grupo;
	}

	public void setOid_grupo(Integer aOid_grupo) {
		this.oid_grupo = aOid_grupo;
	}

	public String getCod_ext_1() throws BaseException {
		supportRefresh();
		return cod_ext_1;
	}

	public void setCod_ext_1(String aCod_ext_tramo) {
		this.cod_ext_1 = aCod_ext_tramo;
	}
	
	public String getCod_ext_2() throws BaseException {
		supportRefresh();
		return cod_ext_2;
	}

	public void setCod_ext_2(String aCod_ext_tramo) {
		this.cod_ext_2 = aCod_ext_tramo;
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

	public static GrupoRRHHDetalle findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoRRHHDetalle) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoRRHHDetalle findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoRRHHDetalle) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	@SuppressWarnings("rawtypes")
	public static List<GrupoRRHHDetalle> getSelectByOidGrupo(ISesion aSesion, Integer oid_grupo) throws BaseException {
		return DBGrupoRRHHDetalle.getSelectByOidGrupo(aSesion, oid_grupo);
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
