package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBAvisoCIPMaquina;
import com.srn.erp.mensajero.bm.Maquina;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AvisoCIPMaquina extends ObjetoLogico {

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

	public AvisoCIPMaquina() {
	}

	public static String NICKNAME = "cip.AvisoCIPMaquina";

	private Maquina maquina;
	private Integer oid_obj_neg;
	private String circuito;

	public Maquina getMaquina() throws BaseException {
		supportRefresh();
		return maquina;
	}

	public void setMaquina(Maquina aMaquina) {
		this.maquina = aMaquina;
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

	public static AvisoCIPMaquina findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AvisoCIPMaquina) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AvisoCIPMaquina findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AvisoCIPMaquina) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(maquina, "Debe ingresar la Máquina");
		Validar.noNulo(oid_obj_neg, "Debe ingresar el ID");
	}

	public static List getAvisos(Integer oidObjNeg, String circuito, ISesion aSesion) throws BaseException {
		return DBAvisoCIPMaquina.getAvisos(oidObjNeg, circuito, aSesion);
	}

}
