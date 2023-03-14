package com.srn.erp.turnos.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class TurnoGrupoEntidad extends ObjetoLogico {
	
	public static final String TIPO_TENIS = "TENIS";
	public static final String TIPO_PADDLE = "PADDLE";
	public static final String TIPO_FUTBOL = "FUTBOL";
	public static final String TIPO_HOCKEY = "HOCKEY";
	public static final String TIPO_BOLEYBALL = "BOLEYBALL";
	public static final String TIPO_BOCHAS = "BOCHAS";
	public static final String TIPO_OTROS = "OTROS";
	
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		this.supportRefresh();
		return this.cod_grupo;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		this.supportRefresh();
		return this.desc_grupo;
	}

	public TurnoGrupoEntidad() {
	}

	public static String NICKNAME = "tu.TurnoGrupoEntidad";

	private String cod_grupo;
	private String desc_grupo;
	private String comportamiento;
	private Boolean activo;

	public String getCod_grupo() throws BaseException {
		supportRefresh();
		return cod_grupo;
	}

	public void setCod_grupo(String aCod_grupo) {
		this.cod_grupo = aCod_grupo;
	}

	public String getDesc_grupo() throws BaseException {
		supportRefresh();
		return desc_grupo;
	}

	public void setDesc_grupo(String aDesc_grupo) {
		this.desc_grupo = aDesc_grupo;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
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

	public static TurnoGrupoEntidad findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (TurnoGrupoEntidad) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static TurnoGrupoEntidad findByOidProxy(Integer oid, ISesion aSesion)
	throws BaseException {
		return (TurnoGrupoEntidad) getObjectByOid(NICKNAME, oid, aSesion);
	}	

	public static TurnoGrupoEntidad findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (TurnoGrupoEntidad) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(this.cod_grupo, "Debe ingresar el Código");
		Validar.noNulo(this.desc_grupo, "Debe ingresar la Descripción");
		Validar.noNulo(this.comportamiento, "Debe ingresar el Tipo");
	}
	
	public static HashTableDatos getTipos() throws BaseException {
		HashTableDatos tipos = new HashTableDatos();
		tipos.put(TIPO_TENIS,"TENIS");
		tipos.put(TIPO_PADDLE,"PADDLE");
		tipos.put(TIPO_FUTBOL,"FUTBOL");
		tipos.put(TIPO_HOCKEY,"HOCKEY");
		tipos.put(TIPO_BOLEYBALL,"BOLEYBALL");
		tipos.put(TIPO_BOCHAS,"BOCHAS");
		tipos.put(TIPO_OTROS,"OTROS");
		return tipos;
	}
	
	public static String getDescripcion(String codigo) throws BaseException {
		HashTableDatos tipos = getTipos();
		return (String)tipos.get(codigo);
	}

}
