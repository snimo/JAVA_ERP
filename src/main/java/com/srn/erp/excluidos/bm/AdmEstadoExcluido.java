package com.srn.erp.excluidos.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class AdmEstadoExcluido extends ObjetoLogico {

	private boolean actuNroSinc = false;
	
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setActuNroSinc(boolean aValor) {
		this.actuNroSinc = aValor;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AdmEstadoExcluido() {
	}

	public static String NICKNAME = "exc.AdmEstadoExcluido";

	private EstadoExcluido estado;
	private EstadoExcluido estado_anterior;
	private java.util.Date fec_estado;
	private java.util.Date fec_estado_ant;
	private NovedadExcluido novedad;

	public EstadoExcluido getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(EstadoExcluido aEstado) {
		this.estado = aEstado;
	}

	public EstadoExcluido getEstado_anterior() throws BaseException {
		supportRefresh();
		return estado_anterior;
	}

	public void setEstado_anterior(EstadoExcluido aEstado_anterior) {
		this.estado_anterior = aEstado_anterior;
	}

	public java.util.Date getFec_estado() throws BaseException {
		supportRefresh();
		return fec_estado;
	}

	public void setFec_estado(java.util.Date aFec_estado) {
		this.fec_estado = aFec_estado;
	}

	public java.util.Date getFec_estado_ant() throws BaseException {
		supportRefresh();
		return fec_estado_ant;
	}

	public void setFec_estado_ant(java.util.Date aFec_estado_ant) {
		this.fec_estado_ant = aFec_estado_ant;
	}

	public NovedadExcluido getNovedad() throws BaseException {
		supportRefresh();
		return novedad;
	}

	public void setNovedad(NovedadExcluido aNovedad) {
		this.novedad = aNovedad;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AdmEstadoExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AdmEstadoExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static AdmEstadoExcluido findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AdmEstadoExcluido) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static AdmEstadoExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AdmEstadoExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public void afterSave() throws BaseException {

		if (this.actuNroSinc)
			IndividuoExcluido.actuNroLoteSinc(this.getOIDInteger(), this.getSesion().getNewOIDByKey(IndividuoExcluido.LOTE_EXP_EXC), this.getSesion());
		
	}

}
