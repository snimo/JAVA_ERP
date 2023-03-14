package com.srn.erp.Ausentismo.bm;

import java.util.List;

import com.srn.erp.Ausentismo.da.DBGrupoRRHH;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoRRHH extends ObjetoLogico {

	public GrupoRRHH() {
	}

	public static String NICKNAME = "admRRHH.Grupo";

	private String tipo;
	private String nombre;
	private Boolean activo;

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
	}

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
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

	public static GrupoRRHH findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoRRHH) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoRRHH findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoRRHH) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}
	
	public static List<GrupoRRHH> findByTipo(String tipo, ISesion aSesion) throws BaseException {
		return (List<GrupoRRHH>) DBGrupoRRHH.getSelectByTipo(aSesion, tipo);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(this.nombre, "Debe ingresar un Nombre");		
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
