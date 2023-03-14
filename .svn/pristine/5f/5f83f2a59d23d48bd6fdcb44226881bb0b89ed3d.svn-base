package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBPermisoInternoPuesto;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class PermisoInternoPuesto extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PermisoInternoPuesto() {
	}

	public static String NICKNAME = "cip.PermisoInternoPuesto";

	private ReglasPermisosInt regla_permiso;
	private ValorClasificadorEntidad val_clasif_puesto;
	private Boolean activo;

	public ReglasPermisosInt getRegla_permiso() throws BaseException {
		supportRefresh();
		return regla_permiso;
	}

	public void setRegla_permiso(ReglasPermisosInt aRegla_permiso) {
		this.regla_permiso = aRegla_permiso;
	}

	public ValorClasificadorEntidad getVal_clasif_puesto() throws BaseException {
		supportRefresh();
		return val_clasif_puesto;
	}

	public void setVal_clasif_puesto(ValorClasificadorEntidad aVal_clasif_puesto) {
		this.val_clasif_puesto = aVal_clasif_puesto;
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

	public static PermisoInternoPuesto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PermisoInternoPuesto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PermisoInternoPuesto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PermisoInternoPuesto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(regla_permiso, "Debe ingresar la Regla");
		Validar.noNulo(val_clasif_puesto, "Debe ingresar la Empresa");
	}
	
	public static List getPermisosIternosPuesto(
			  ReglasPermisosInt regla,
            ISesion aSesion) throws BaseException {
		return DBPermisoInternoPuesto.getPermisosIternosPuesto(regla,aSesion);
	}
	
	  public static PermisoInternoPuesto getPermisoInternoPuesto(
			  ReglasPermisosInt regla,
			  ValorClasificadorEntidad valor,
	          ISesion aSesion)
	          throws BaseException {
		  
		  return DBPermisoInternoPuesto.getPermisoInternoPuesto(regla,valor,aSesion);
	  }	

}
