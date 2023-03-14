package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBGrupoHabilitadoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoHabilitadoEntidad extends ObjetoLogico {

	public GrupoHabilitadoEntidad() {
	}

	public static String						NICKNAME	= "cg.GrupoHabilitadoEntidad";

	private GrupoAtributoEntidadVar	grupo_atributo_entidad_var;

	private GrupoDeAtributos				grupo_atributo;

	private Boolean									activo;

	public GrupoAtributoEntidadVar getGrupo_atributo_entidad_var() throws BaseException {
		supportRefresh();
		return grupo_atributo_entidad_var;
	}

	public void setGrupo_atributo_entidad_var(GrupoAtributoEntidadVar aGrupo_atributo_entidad_var) {
		this.grupo_atributo_entidad_var = aGrupo_atributo_entidad_var;
	}

	public GrupoDeAtributos getGrupo_atributo() throws BaseException {
		supportRefresh();
		return grupo_atributo;
	}

	public void setGrupo_atributo(GrupoDeAtributos aGrupo_atributo) {
		this.grupo_atributo = aGrupo_atributo;
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

	public static GrupoHabilitadoEntidad findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoHabilitadoEntidad) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoHabilitadoEntidad findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoHabilitadoEntidad) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(grupo_atributo_entidad_var, "Debe ingresar el Grupo de Atributo Variable");
		Validar.noNulo(grupo_atributo, "Debe ingresar un grupo de Atributos");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getGruposHabilitadosVarEntidad(GrupoAtributoEntidadVar grupoAtributoEntidadVar, ISesion aSesion)
			throws BaseException {
		return DBGrupoHabilitadoEntidad.getGruposHabilitadosEnt(grupoAtributoEntidadVar, aSesion);
	}

}
