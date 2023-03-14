package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBFiltroValLegCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class FiltroValLegCab extends ObjetoLogico {

	public FiltroValLegCab() {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "rh.FiltroValLegCab";

	private FiltroLegCab filtro_cab;
	private Integer oid_valor;
	private String tipo;
	private Boolean activo;

	public FiltroLegCab getFiltro_cab() throws BaseException {
		supportRefresh();
		return filtro_cab;
	}

	public void setFiltro_cab(FiltroLegCab aFiltro_cab) {
		this.filtro_cab = aFiltro_cab;
	}

	public Integer getOid_valor() throws BaseException {
		supportRefresh();
		return oid_valor;
	}

	public void setOid_valor(Integer aOid_valor) {
		this.oid_valor = aOid_valor;
	}

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
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

	public static FiltroValLegCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (FiltroValLegCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static FiltroValLegCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (FiltroValLegCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(filtro_cab, "Debe ingresar el Filtro");
		Validar.noNulo(oid_valor, "Debe ingresar el Valor");
		Validar.noNulo(tipo, "Debe ingresar el Tipo");
	}
	
	public static List getFiltroValLegCab(
			  FiltroLegCab filtro,
			  String tipo,
            ISesion aSesion) throws BaseException {
		
		return DBFiltroValLegCab.getFiltroValLegCab(filtro,tipo,aSesion);
		
	}	
	
	public static FiltroValLegCab getFiltroValLegCab(
			  FiltroLegCab filtroLegCab,
			  String tipo,
			  Integer oidValor,
	          ISesion aSesion)
	          throws BaseException {
		
		return DBFiltroValLegCab.getFiltroValLegCab(filtroLegCab,tipo,oidValor,aSesion);
	}
	
	public static List getFiltroValLegCab(
			  FiltroLegCab filtro,
          ISesion aSesion) throws BaseException {
		
		return DBFiltroValLegCab.getFiltroValLegCab(filtro,aSesion);
             
	}	

}
