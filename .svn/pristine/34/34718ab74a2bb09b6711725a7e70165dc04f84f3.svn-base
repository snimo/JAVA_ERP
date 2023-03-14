package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBAvisoCIPUsuario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AvisoCIPUsuario extends ObjetoLogico {

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

	public AvisoCIPUsuario() {
	}

	public static String NICKNAME = "cip.AvisoCIPUsuario";

	private Usuario usuario;
	private Integer oid_obj_neg;
	private String circuito;

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
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

	public static AvisoCIPUsuario findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AvisoCIPUsuario) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AvisoCIPUsuario findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AvisoCIPUsuario) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(usuario, "Debe ingresar el Usuario");
		Validar.noNulo(oid_obj_neg, "Debe ingresar el ID");
		Validar.noNulo(circuito, "Debe Ingresar el Circuito");
	}

	public static List getAvisos(Integer oidObjNeg, String circuito, ISesion aSesion) throws BaseException {
		return DBAvisoCIPUsuario.getAvisos(oidObjNeg, circuito, aSesion);
	}

}
