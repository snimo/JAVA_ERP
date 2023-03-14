package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBPerfilGrupoPuerta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PerfilGrupoPuerta extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PerfilGrupoPuerta() {
	}

	public static String NICKNAME = "cip.PerfilGrupoPuerta";

	private GrupoPuerta grupo_puerta;
	private PerfilFuncional perfil_funcional;
	private Boolean hab_ing;
	private Boolean hab_egr;
	private Boolean hab_ambos;
	private Boolean den_ing;
	private Boolean den_egr;
	private Boolean den_ambos;
	private Boolean activo;

	public GrupoPuerta getGrupo_puerta() throws BaseException {
		supportRefresh();
		return grupo_puerta;
	}

	public void setGrupo_puerta(GrupoPuerta aGrupo_puerta) {
		this.grupo_puerta = aGrupo_puerta;
	}

	public PerfilFuncional getPerfil_funcional() throws BaseException {
		supportRefresh();
		return perfil_funcional;
	}

	public void setPerfil_funcional(PerfilFuncional aPerfil_funcional) {
		this.perfil_funcional = aPerfil_funcional;
	}

	public Boolean isHab_ing() throws BaseException {
		supportRefresh();
		return hab_ing;
	}

	public void setHab_ing(Boolean aHab_ing) {
		this.hab_ing = aHab_ing;
	}

	public Boolean isHab_egr() throws BaseException {
		supportRefresh();
		return hab_egr;
	}

	public void setHab_egr(Boolean aHab_egr) {
		this.hab_egr = aHab_egr;
	}

	public Boolean isHab_ambos() throws BaseException {
		supportRefresh();
		return hab_ambos;
	}

	public void setHab_ambos(Boolean aHab_ambos) {
		this.hab_ambos = aHab_ambos;
	}

	public Boolean isDen_ing() throws BaseException {
		supportRefresh();
		return den_ing;
	}

	public void setDen_ing(Boolean aDen_ing) {
		this.den_ing = aDen_ing;
	}

	public Boolean isDen_egr() throws BaseException {
		supportRefresh();
		return den_egr;
	}

	public void setDen_egr(Boolean aDen_egr) {
		this.den_egr = aDen_egr;
	}

	public Boolean isDen_ambos() throws BaseException {
		supportRefresh();
		return den_ambos;
	}

	public void setDen_ambos(Boolean aDen_ambos) {
		this.den_ambos = aDen_ambos;
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

	public static PerfilGrupoPuerta findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PerfilGrupoPuerta) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PerfilGrupoPuerta findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PerfilGrupoPuerta) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(grupo_puerta, "Debe ingresar el Grupo de Puertas");
		Validar.noNulo(perfil_funcional, "Debe ingresar el Perfil Funcional");
	}
	
	public static List getPerfilGrupoPuerta(
			  GrupoPuerta grupoPuerta,
              ISesion aSesion) throws BaseException {
		return DBPerfilGrupoPuerta.getPerfilGrupoPuerta(grupoPuerta,aSesion);
	}	

}
