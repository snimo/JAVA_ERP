package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBPerfilFiltroLegajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PerfilFiltroLegajo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PerfilFiltroLegajo() {
	}

	public static String NICKNAME = "rh.PerfilFiltroLegajo";

	private FiltroLegCab filtro_legajo_cab;
	private PerfilFuncional perfil;
	private Boolean activo;

	public FiltroLegCab getFiltro_legajo_cab() throws BaseException {
		supportRefresh();
		return filtro_legajo_cab;
	}

	public void setFiltro_legajo_cab(FiltroLegCab aFiltro_legajo_cab) {
		this.filtro_legajo_cab = aFiltro_legajo_cab;
	}

	public PerfilFuncional getPerfil() throws BaseException {
		supportRefresh();
		return perfil;
	}

	public void setPerfil(PerfilFuncional aPerfil) {
		this.perfil = aPerfil;
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

	public static PerfilFiltroLegajo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PerfilFiltroLegajo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PerfilFiltroLegajo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PerfilFiltroLegajo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(filtro_legajo_cab, "Debe ingresar el Filtro");
		Validar.noNulo(perfil, "Debe ingresar el Perfil");
	}
	
	public static List getPerfilesFiltroLegajo(
			FiltroLegCab filtro,
            ISesion aSesion) throws BaseException {
		return DBPerfilFiltroLegajo.getPerfilesFiltroLegajo(filtro,aSesion);
	}
	
	public static List getPerfilesFiltroLegajoByUsu(
			  Usuario aUsuario,
          ISesion aSesion) throws BaseException {
		return DBPerfilFiltroLegajo.getPerfilesFiltroLegajoByUsu(aUsuario,aSesion);
	}		

}
