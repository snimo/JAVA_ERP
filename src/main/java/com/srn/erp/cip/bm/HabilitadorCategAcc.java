package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBHabilitadorCategAcc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class HabilitadorCategAcc extends ObjetoLogico {

	public HabilitadorCategAcc() {
	}

	public static String NICKNAME = "cip.HabilitadorCategAcc";

	private PerfilFuncional perfil_funcional;
	private CategAccesoCIP categoria_acceso;
	private Boolean activo;

	public PerfilFuncional getPerfil_funcional() throws BaseException {
		supportRefresh();
		return perfil_funcional;
	}

	public void setPerfil_funcional(PerfilFuncional aPerfil_funcional) {
		this.perfil_funcional = aPerfil_funcional;
	}

	public CategAccesoCIP getCategoria_acceso() throws BaseException {
		supportRefresh();
		return categoria_acceso;
	}

	public void setCategoria_acceso(CategAccesoCIP aCategoria_acceso) {
		this.categoria_acceso = aCategoria_acceso;
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

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static HabilitadorCategAcc findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (HabilitadorCategAcc) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static HabilitadorCategAcc findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (HabilitadorCategAcc) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(perfil_funcional, "Debe ingresar el Perfil Funcional");
		Validar.noNulo(categoria_acceso, "Debe ingresar la Categoría");
	}

	public static List getHabilitadoresCategAccesoInt(CategAccesoCIP categoria,
			ISesion aSesion) throws BaseException {
		return DBHabilitadorCategAcc.getHabilitadoresCategAccesoInt(categoria,
				aSesion);
	}

	public static HabilitadorCategAcc getHabilitadorCategAcc(
			CategAccesoCIP categoria, 
			PerfilFuncional perfil, 
			ISesion aSesion)
			throws BaseException {
		return DBHabilitadorCategAcc.getHabilitadorCategAcc(categoria, perfil,aSesion);
	}

}
