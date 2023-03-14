package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBJuicioRubroCondena;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class JuicioRubroCondena extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public JuicioRubroCondena() {
	}

	public static String NICKNAME = "leg.JuicioRubroCondena";

	private Juicio juicio;
	private RubroCondena rubro_condena;
	private Boolean activo;

	public Juicio getJuicio() throws BaseException {
		supportRefresh();
		return juicio;
	}

	public void setJuicio(Juicio aJuicio) {
		this.juicio = aJuicio;
	}

	public RubroCondena getRubro_condena() throws BaseException {
		supportRefresh();
		return rubro_condena;
	}

	public void setRubro_condena(RubroCondena aRubro_condena) {
		this.rubro_condena = aRubro_condena;
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

	public static JuicioRubroCondena findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (JuicioRubroCondena) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static JuicioRubroCondena findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (JuicioRubroCondena) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(juicio, "Debe ingresar el Juicio");
		Validar.noNulo(rubro_condena, "Debe ingresar el Rubro Condena");
	}

	public static List getJuiciosRubroCondena(Juicio juicio, ISesion aSesion) throws BaseException {
		return DBJuicioRubroCondena.getJuiciosRubroCondena(juicio, aSesion);
	}

}
