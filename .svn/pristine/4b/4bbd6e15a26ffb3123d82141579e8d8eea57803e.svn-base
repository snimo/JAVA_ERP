package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBPerfExcluidoPerfFunc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PerfExcluidoPerfFunc extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PerfExcluidoPerfFunc() {
	}

	public static String NICKNAME = "exc.PerfExcluidoPerfFunc";

	private PerfilFuncional perfilFuncional;
	private SeguPerfilExcluido seguridadPerfil;
	private Boolean activo;

	public PerfilFuncional getPerfilfuncional() throws BaseException {
		supportRefresh();
		return perfilFuncional;
	}

	public void setPerfilfuncional(PerfilFuncional aPerfilfuncional) {
		this.perfilFuncional = aPerfilfuncional;
	}

	public SeguPerfilExcluido getSeguridadperfil() throws BaseException {
		supportRefresh();
		return seguridadPerfil;
	}

	public void setSeguridadperfil(SeguPerfilExcluido aSeguridadperfil) {
		this.seguridadPerfil = aSeguridadperfil;
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

	public static PerfExcluidoPerfFunc findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PerfExcluidoPerfFunc) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PerfExcluidoPerfFunc findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PerfExcluidoPerfFunc) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(perfilFuncional, "Debe ingresar el Perfil Funcional");
		Validar.noNulo(seguridadPerfil, "Debe ingresar el Perfil");
	}
	
	public static List getPerfExcluidosPerfFuncional(PerfilFuncional perfil,
	          ISesion aSesion) throws BaseException {
		  return DBPerfExcluidoPerfFunc.getPerfExcluidosPerfFuncional(perfil,aSesion);
	}
	
	public static List getAllActivos(ISesion aSesion) throws BaseException {
		  return DBPerfExcluidoPerfFunc.getAllActivos(aSesion);
	}	

}
