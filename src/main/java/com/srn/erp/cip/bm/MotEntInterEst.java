package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBMotEntInterEst;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotEntInterEst extends ObjetoLogico {

	public MotEntInterEst() {
	}

	public static String NICKNAME = "cip.MotEntInterEst";

	private MotivoEntIntermedias motivo;
	private EstadoCIP estado;
	private Boolean activo;

	public MotivoEntIntermedias getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMotivo(MotivoEntIntermedias aMotivo) {
		this.motivo = aMotivo;
	}

	public EstadoCIP getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(EstadoCIP aEstado) {
		this.estado = aEstado;
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

	public static MotEntInterEst findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (MotEntInterEst) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotEntInterEst findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (MotEntInterEst) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(motivo, "Debe ingresar los Motivos Intermedios");
		Validar.noNulo(estado, "Debe ingresar el Estado");
	}

	public static MotEntInterEst getMotEntInterEstado(
			MotivoEntIntermedias motivo, EstadoCIP estado, ISesion aSesion)
			throws BaseException {
		return DBMotEntInterEst.getMotEntInterEstado(motivo, estado, aSesion);
	}

	public static List getMotEntInterEst(EstadoCIP estado, ISesion aSesion)
			throws BaseException {
		return DBMotEntInterEst.getMotEntInterEst(estado, aSesion);
	}

}
