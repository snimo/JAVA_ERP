package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBRubroReclamoSeclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RubroReclamoSeclo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RubroReclamoSeclo() {
	}

	public static String NICKNAME = "leg.RubroReclamoSeclo";

	private RubroCondena rubro_condena;
	private Seclo seclo;
	private Boolean activo;

	public RubroCondena getRubro_condena() throws BaseException {
		supportRefresh();
		return rubro_condena;
	}

	public void setRubro_condena(RubroCondena aRubro_condena) {
		this.rubro_condena = aRubro_condena;
	}

	public Seclo getSeclo() throws BaseException {
		supportRefresh();
		return seclo;
	}

	public void setSeclo(Seclo aSeclo) {
		this.seclo = aSeclo;
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

	public static RubroReclamoSeclo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RubroReclamoSeclo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RubroReclamoSeclo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RubroReclamoSeclo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(rubro_condena, "Debe ingresar el Rubro Condena");
		Validar.noNulo(seclo, "Debe ingresar el SECLO");
	}
	
	public static List getRubrosReclaSeclos(Seclo aSeclo,
            ISesion aSesion) throws BaseException {
		  return DBRubroReclamoSeclo.getRubrosReclaSeclos(aSeclo,aSesion);
	}	

}
