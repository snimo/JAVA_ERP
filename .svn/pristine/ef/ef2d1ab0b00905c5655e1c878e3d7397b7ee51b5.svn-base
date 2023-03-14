package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBAvisoCIPGUsuario;
import com.srn.erp.mensajero.bm.GrupoUsuMens;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class AvisoCIPGUsuario extends ObjetoLogico {

	public AvisoCIPGUsuario() {
	}

	public static String NICKNAME = "cip.AvisoCIPGUsuario";

	private GrupoUsuMens grupo_usuario;
	private Integer oid_obj_neg;
	private String circuito;

	public GrupoUsuMens getGrupo_usuario() throws BaseException {
		supportRefresh();
		return grupo_usuario;
	}

	public void setGrupo_usuario(GrupoUsuMens aGrupo_usuario) {
		this.grupo_usuario = aGrupo_usuario;
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

	public static AvisoCIPGUsuario findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AvisoCIPGUsuario) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AvisoCIPGUsuario findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AvisoCIPGUsuario) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(grupo_usuario, "Debe ingresar el Grupo de Mensajes");
		Validar.noNulo(oid_obj_neg, "Debe ingresar el ID");
		Validar.noNulo(circuito, "Debe Ingresar el Circuito");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getAvisos(Integer oidObjNeg, String circuito, ISesion aSesion) throws BaseException {
		return DBAvisoCIPGUsuario.getAvisos(oidObjNeg, circuito, aSesion);
	}

}
