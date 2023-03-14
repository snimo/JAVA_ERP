package com.srn.erp.Ausentismo.bm;

import java.util.List;

import com.srn.erp.Ausentismo.da.DBGrupoRRHHGeneralCodigo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class GrupoRRHHGeneralCodigo extends ObjetoLogico {

	public GrupoRRHHGeneralCodigo() {
	}

	public static String NICKNAME = "admRRHH.grupoRRHHGeneralCodigo";

	private GrupoRRHHGeneralDesc grupoGeneralDesc;
	private String tipoTabla;
	private String codigoExternoElemento;
	private Boolean activo;

	public GrupoRRHHGeneralDesc getGrupogeneraldesc() throws BaseException {
		supportRefresh();
		return grupoGeneralDesc;
	}

	public void setGrupogeneraldesc(GrupoRRHHGeneralDesc aGrupogeneraldesc) {
		this.grupoGeneralDesc = aGrupogeneraldesc;
	}

	public String getTipotabla() throws BaseException {
		supportRefresh();
		return tipoTabla;
	}

	public void setTipotabla(String aTipotabla) {
		this.tipoTabla = aTipotabla;
	}

	public String getCodigoexternoelemento() throws BaseException {
		supportRefresh();
		return codigoExternoElemento;
	}

	public void setCodigoexternoelemento(String aCodigoexternoelemento) {
		this.codigoExternoElemento = aCodigoexternoelemento;
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

	public static GrupoRRHHGeneralCodigo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoRRHHGeneralCodigo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoRRHHGeneralCodigo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoRRHHGeneralCodigo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}
	
	public static List<GrupoRRHHGeneralCodigo> findByOidGrupoGral(GrupoRRHHGeneralDesc grupo, ISesion aSesion) throws BaseException {
		return (List<GrupoRRHHGeneralCodigo>) DBGrupoRRHHGeneralCodigo.getByOidGruGralDesc(aSesion, grupo);
	}

	public void beforeSave() throws BaseException {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
