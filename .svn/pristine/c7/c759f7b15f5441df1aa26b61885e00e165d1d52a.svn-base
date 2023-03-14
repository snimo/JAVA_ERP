package com.srn.erp.mensajero.bm;

import java.util.List;

import com.srn.erp.mensajero.da.DBGrupoMaquinaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoMaquinaDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public GrupoMaquinaDet() {
	}

	public static String NICKNAME = "ge.GrupoMaquinaDet";

	private GrupoMaquina grupo_maquina;
	private Maquina maquina;
	private Boolean activo;

	public GrupoMaquina getGrupo_maquina() throws BaseException {
		supportRefresh();
		return grupo_maquina;
	}

	public void setGrupo_maquina(GrupoMaquina aGrupo_maquina) {
		this.grupo_maquina = aGrupo_maquina;
	}

	public Maquina getMaquina() throws BaseException {
		supportRefresh();
		return maquina;
	}

	public void setMaquina(Maquina aMaquina) {
		this.maquina = aMaquina;
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

	public static GrupoMaquinaDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoMaquinaDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoMaquinaDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoMaquinaDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(grupo_maquina, "Debe ingresar el Grupo");
		Validar.noNulo(maquina, "Debe ingresar la Máquina");
	}

	public static List getMaquinasDetalle(GrupoMaquina grupoMaquina, ISesion aSesion) throws BaseException {
		return DBGrupoMaquinaDet.getMaquinasDetalle(grupoMaquina, aSesion);
	}

}
