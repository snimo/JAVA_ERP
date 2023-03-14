package com.srn.erp.cashflow.bm;

import java.util.List;

import com.srn.erp.cashflow.da.DBGrupoConceptoCF;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class GrupoConceptoCF extends ObjetoLogico {

	public static final String COMPO_INGRESOS = "ING_PLA";
	public static final String COMPO_EGRESO = "EGR_PLA";
	public static final String COMPO_SI = "SI_PLA";

	public GrupoConceptoCF() {
	}

	public static String NICKNAME = "cf.GrupoConceptoCF";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Integer orden;
	private String comporGrupo;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return this.orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public String getComporGrupo() throws BaseException {
		supportRefresh();
		return this.comporGrupo;
	}

	public void setComporGrupo(String aComporGrupo) {
		this.comporGrupo = aComporGrupo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
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

	public static GrupoConceptoCF findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoConceptoCF) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoConceptoCF findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoConceptoCF) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static GrupoConceptoCF findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoConceptoCF) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(orden, "Debe ingresar el Orden");
		Validar.noNulo(comporGrupo, "Debe ingresar el Comportamiento");
	}

	public static HashTableDatos getComportamientos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(COMPO_INGRESOS, "Ingresos");
		condiciones.put(COMPO_EGRESO, "Egresos");
		condiciones.put(COMPO_SI, "Saldo Inicial");
		return condiciones;
	}
	
	public boolean isIngreso() throws BaseException {
		if (this.getComporGrupo().equals(COMPO_INGRESOS))
			return true;
		else
			return false;
	}
	
	public boolean isEgreso() throws BaseException {
		if (this.getComporGrupo().equals(COMPO_EGRESO))
			return true;
		else
			return false;
	}
	
	public boolean isSaldoInicial() throws BaseException {
		if (this.getComporGrupo().equals(COMPO_SI))
			return true;
		else
			return false;
	}

	public static List getGruposConcepto(String comportamiento, ISesion aSesion) throws BaseException {
		return DBGrupoConceptoCF.getGruposConcepto(comportamiento, aSesion);
	}
	
	public String getDescripcionComportamiento() throws BaseException {
		return (String)GrupoConceptoCF.getComportamientos().get(this.getComporGrupo());
	}

}
