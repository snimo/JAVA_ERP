package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.tesoreria.da.DBGrupoCajasDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class GrupoCajasDet extends ObjetoLogico {

	public GrupoCajasDet() {
	}

	public static String NICKNAME = "te.GrupoCajasDet";

	private GrupoCajas grupo_caja;
	private Caja caja;
	private Integer orden;
	private Boolean activo;

	public GrupoCajas getGrupo_caja() throws BaseException {
		supportRefresh();
		return grupo_caja;
	}

	public void setGrupo_caja(GrupoCajas aGrupo_caja) {
		this.grupo_caja = aGrupo_caja;
	}

	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
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

	public static GrupoCajasDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoCajasDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoCajasDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoCajasDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(grupo_caja, "Debe ingresar el Grupo");
		Validar.noNulo(caja, "Debe ingresar la Caja");
		Validar.noNulo(orden, "Debe ingresar el Orden");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getGruposCajasDetByCaja(GrupoCajas grupo, ISesion aSesion) throws BaseException {
		return DBGrupoCajasDet.getGruposCajasDetByCaja(grupo, aSesion);
	}
	
	public static GrupoCajasDet getGrupoCajasDet(GrupoCajas grupoCajas,Caja caja,
	          ISesion aSesion)
	          throws BaseException {
		  return DBGrupoCajasDet.getGrupoCajasDet(grupoCajas,caja,aSesion);
	}
	  	

}
