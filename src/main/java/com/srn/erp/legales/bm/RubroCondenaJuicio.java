package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBRubroCondenaJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RubroCondenaJuicio extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RubroCondenaJuicio() {
	}

	public static String NICKNAME = "leg.RubroCondenaJuicio";

	private RubroCondena rubro_condena;
	private Juicio juicio;
	private Boolean activo;

	public RubroCondena getRubro_condena() throws BaseException {
		supportRefresh();
		return rubro_condena;
	}

	public void setRubro_condena(RubroCondena aRubro_condena) {
		this.rubro_condena = aRubro_condena;
	}

	public Juicio getJuicio() throws BaseException {
		supportRefresh();
		return juicio;
	}

	public void setJuicio(Juicio aJuicio) {
		this.juicio = aJuicio;
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

	public static RubroCondenaJuicio findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RubroCondenaJuicio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RubroCondenaJuicio findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RubroCondenaJuicio) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(rubro_condena, "Debe ingresar el Rubro Condena");
		Validar.noNulo(juicio, "Debe ingresar el Juicio");
	}
	
	public static List getRubrosCondenaJuicio(Juicio juicio,
              ISesion aSesion) throws BaseException {
		  return DBRubroCondenaJuicio.getRubrosCondenaJuicio(juicio,aSesion);
	}	

}
