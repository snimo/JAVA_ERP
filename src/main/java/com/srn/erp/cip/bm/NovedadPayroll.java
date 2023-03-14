package com.srn.erp.cip.bm;

import com.srn.erp.cip.da.DBNovedadPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class NovedadPayroll extends ObjetoLogico {

	public NovedadPayroll() {
	}

	public static String NICKNAME = "cip.NovedadPayroll";

	private Integer nmonovedad;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer nmoordenpr;
	private java.util.Date nmofecha;
	private String nmolegajo;
	private Boolean activo;
	private String nmocex;
	private Integer novTipo;
	private Integer novMotivo;
	private String identifNovExt;

	public Integer getNmonovedad() throws BaseException {
		supportRefresh();
		return nmonovedad;
	}
	
	public String getIdentifNovExt() throws BaseException {
		supportRefresh();
		return this.identifNovExt;
	}
	
	public void setIdentifNovExt(String aIdentifNovExt) {
		this.identifNovExt = aIdentifNovExt;
	}
	
	
	public String getNmoCex() throws BaseException {
		supportRefresh();
		return this.nmocex;
	}
	

	public void setNmonovedad(Integer aNmonovedad) {
		this.nmonovedad = aNmonovedad;
	}
	
	public void setNmoCex(String aNmoCex) {
		this.nmocex = aNmoCex;
	}
	

	public Integer getNmoordenpr() throws BaseException {
		supportRefresh();
		return nmoordenpr;
	}

	public void setNmoordenpr(Integer aNmoordenpr) {
		this.nmoordenpr = aNmoordenpr;
	}
	
	public Integer getNovTipo() throws BaseException {
		supportRefresh();
		return this.novTipo;
	}

	public void setNovTipo(Integer aNovTipo) {
		this.novTipo = aNovTipo;
	}
	
	public Integer getNovMotivo() throws BaseException {
		supportRefresh();
		return this.novMotivo;
	}

	public void setNovMotivo(Integer aNovMotivo) {
		this.novMotivo = aNovMotivo;
	}
	
	

	public java.util.Date getNmofecha() throws BaseException {
		supportRefresh();
		return nmofecha;
	}

	public void setNmofecha(java.util.Date aNmofecha) {
		this.nmofecha = aNmofecha;
	}

	public String getNmolegajo() throws BaseException {
		supportRefresh();
		return nmolegajo;
	}

	public void setNmolegajo(String aNmolegajo) {
		this.nmolegajo = aNmolegajo;
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

	public static NovedadPayroll findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (NovedadPayroll) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static NovedadPayroll findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (NovedadPayroll) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public static void truncarTablaNovedades(ISesion aSesion)
	  throws BaseException {
		 DBNovedadPayroll.truncarTablaNovedades(aSesion);
	}

}
