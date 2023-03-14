package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBEquivMotEntIntermedias;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EquivMotEntIntermedias extends ObjetoLogico {

	public EquivMotEntIntermedias() {
	}

	public static String NICKNAME = "cip.EquivMotEntIntermedias";

	private String codigo;
	private MotivoEntIntermedias motivo;
	private Boolean activo;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public MotivoEntIntermedias getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotivoEntIntermedias aMotivo) {
		this.motivo = aMotivo;
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

	public static EquivMotEntIntermedias findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EquivMotEntIntermedias) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EquivMotEntIntermedias findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EquivMotEntIntermedias) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(motivo, "Debe Ingresar el Motivo");
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getEquivMotEntIntermedias(MotivoEntIntermedias motivo, ISesion aSesion) throws BaseException {
		return DBEquivMotEntIntermedias.getEquivMotEntIntermedias(motivo, aSesion);
	}

}
