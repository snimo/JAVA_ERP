package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBAvisoCIPGMaquina;
import com.srn.erp.mensajero.bm.GrupoMaquina;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AvisoCIPGMaquina extends ObjetoLogico {

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AvisoCIPGMaquina() {
	}

	public static String NICKNAME = "cip.AvisoCIPGMaquina";

	private GrupoMaquina grupo_maquina;
	private Integer oid_obj_neg;
	private String circuito;

	public GrupoMaquina getGrupo_maquina() throws BaseException {
		supportRefresh();
		return grupo_maquina;
	}

	public void setGrupo_maquina(GrupoMaquina aGrupo_maquina) {
		this.grupo_maquina = aGrupo_maquina;
	}

	public Integer getOid_obj_neg() throws BaseException {
		supportRefresh();
		return oid_obj_neg;
	}

	public void setOid_obj_neg(Integer aOid_obj_neg) {
		this.oid_obj_neg = aOid_obj_neg;
	}

	public String getCircuito() throws BaseException {
		supportRefresh();
		return circuito;
	}

	public void setCircuito(String aCircuito) {
		this.circuito = aCircuito;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AvisoCIPGMaquina findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AvisoCIPGMaquina) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AvisoCIPGMaquina findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AvisoCIPGMaquina) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(grupo_maquina, "Debe ingresar el Grupo de Máquina");
		Validar.noNulo(oid_obj_neg, "Debe ingresar el ID");
		Validar.noNulo(circuito, "Debe Ingresar el Circuito");
	}

	public static List getAvisos(Integer oidObjNeg, String circuito, ISesion aSesion) throws BaseException {
		return DBAvisoCIPGMaquina.getAvisos(oidObjNeg, circuito, aSesion);
	}

}
