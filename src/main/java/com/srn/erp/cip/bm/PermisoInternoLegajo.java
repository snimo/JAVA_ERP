package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBPermisoInternoLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PermisoInternoLegajo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PermisoInternoLegajo() {
	}

	public static String NICKNAME = "cip.PermisoInternoLegajo";

	private ReglasPermisosInt regla_permiso;
	private Legajo legajo;
	private Boolean activo;

	public ReglasPermisosInt getRegla_permiso() throws BaseException {
		supportRefresh();
		return regla_permiso;
	}

	public void setRegla_permiso(ReglasPermisosInt aRegla_permiso) {
		this.regla_permiso = aRegla_permiso;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
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

	public static PermisoInternoLegajo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PermisoInternoLegajo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PermisoInternoLegajo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PermisoInternoLegajo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(regla_permiso, "Debe ingresar la Regla");
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
	}
	
	public static List getPermisosInternosLegajos(
			  ReglasPermisosInt reglasPermisosInt,
	          ISesion aSesion) throws BaseException {
		  return DBPermisoInternoLegajo.getPermisosInternosLegajos(reglasPermisosInt, aSesion);
	  } 	

}
