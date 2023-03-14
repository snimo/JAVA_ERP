package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.request.bl.Utils.*;
import framework.applicarionServer.bl.Sesion.ISesion;

import java.util.Date;
import java.util.List;

import com.srn.erp.cip.da.DBCIPLogPuerta;

public class CIPLogPuerta extends ObjetoLogico {

	public static final String DESCONECT = "Desconectada";
	public static final String CONECT = "Conectada";

	public static String NICKNAME = "cip.LogPuerta";

	private Puerta puerta;
	private Date fecHora;
	private String estado;
	private Boolean activo;

	public Puerta getPuerta() throws BaseException {
		supportRefresh();
		return puerta;
	}

	public void setPuerta(Puerta aPuerta) {
		this.puerta = aPuerta;
	}

	public Date getFechora() throws BaseException {
		supportRefresh();
		return fecHora;
	}

	public void setFechora(Date aFechora) {
		this.fecHora = aFechora;
	}

	public String getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(String aEstado) {
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

	@Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static CIPLogPuerta findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CIPLogPuerta) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CIPLogPuerta findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CIPLogPuerta) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(puerta, "El campo puerta es obligatorio");
		Validar.noNulo(fecHora, "El campo fecha es obligatorio");
		Validar.noNulo(estado, "El campo estado es obligatorio");
	}

	public static List<CIPLogPuerta> getRegistrosByPuertaFechaDesdeFechaHasta(Puerta puerta, Date fechaDesde, Date fechaHasta, ISesion sesion) throws BaseException {
		return DBCIPLogPuerta.getRegistrosByPuertaFechaDesdeFechaHasta(puerta, fechaDesde, fechaHasta, sesion);
	}

}