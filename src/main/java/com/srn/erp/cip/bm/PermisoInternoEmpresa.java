package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBPermisoInternoEmpresa;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PermisoInternoEmpresa extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PermisoInternoEmpresa() {
	}

	public static String NICKNAME = "cip.PermisoInternoEmpresa";

	private ReglasPermisosInt regla_permiso;
	private ValorClasificadorEntidad val_clasif_empresa;
	private Boolean activo;

	public ReglasPermisosInt getRegla_permiso() throws BaseException {
		supportRefresh();
		return regla_permiso;
	}

	public void setRegla_permiso(ReglasPermisosInt aRegla_permiso) {
		this.regla_permiso = aRegla_permiso;
	}

	public ValorClasificadorEntidad getVal_clasif_empresa() throws BaseException {
		supportRefresh();
		return val_clasif_empresa;
	}

	public void setVal_clasif_empresa(ValorClasificadorEntidad aVal_clasif_empresa) {
		this.val_clasif_empresa = aVal_clasif_empresa;
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

	public static PermisoInternoEmpresa findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PermisoInternoEmpresa) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PermisoInternoEmpresa findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PermisoInternoEmpresa) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(regla_permiso, "Debe ingresar la Regla");
		Validar.noNulo(val_clasif_empresa, "Debe ingresar la Empresa");
	}

	public static PermisoInternoEmpresa getPermisoInternoEmpresa(ReglasPermisosInt reglaPermiso, ValorClasificadorEntidad valor, ISesion aSesion) throws BaseException {
		return DBPermisoInternoEmpresa.getPermisoInternoEmpresa(reglaPermiso, valor, aSesion);

	}
	
	public static List getPermisosIntEmpresa(ReglasPermisosInt regla,
            ISesion aSesion) throws BaseException {
		  return DBPermisoInternoEmpresa.getPermisosIntEmpresa(regla,aSesion);
	}	

}
