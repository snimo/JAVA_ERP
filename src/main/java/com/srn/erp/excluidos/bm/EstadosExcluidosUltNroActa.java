package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBEstadosExcluidosUltNroActa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class EstadosExcluidosUltNroActa extends ObjetoLogico {

	public EstadosExcluidosUltNroActa() {
	}

	public static String NICKNAME = "exc.EstadosExcluidosUltNroActa";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private String descripcion;
	private Integer ult_nro;

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Integer getUlt_nro() throws BaseException {
		supportRefresh();
		return ult_nro;
	}

	public void setUlt_nro(Integer aUlt_nro) {
		this.ult_nro = aUlt_nro;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static EstadosExcluidosUltNroActa findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadosExcluidosUltNroActa) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstadosExcluidosUltNroActa findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadosExcluidosUltNroActa) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public static List getAllUltNrosEstados(ISesion aSesion) throws BaseException {
		return DBEstadosExcluidosUltNroActa.getAllUltNrosEstados(aSesion);
	}

}
