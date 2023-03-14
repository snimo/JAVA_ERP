package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBGenerarValorCompoCriImpu;
import com.srn.erp.general.bm.DefinicionAtributoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GenerarValorCompoCriImpu extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public GenerarValorCompoCriImpu() {
	}

	public static String NICKNAME = "cg.GenerarValorCompoCriImpu";

	private ValoresAtriCriterioImpu valoresAtriCriterioImputacion;

	private DefinicionAtributoEntidad atributo_entidad;

	private Componente componente;

	public ValoresAtriCriterioImpu getValoresatricriterioimputacion()
			throws BaseException {
		supportRefresh();
		return valoresAtriCriterioImputacion;
	}

	public void setValoresatricriterioimputacion(
			ValoresAtriCriterioImpu aValoresatricriterioimputacion) {
		this.valoresAtriCriterioImputacion = aValoresatricriterioimputacion;
	}

	public DefinicionAtributoEntidad getAtributo_entidad() throws BaseException {
		supportRefresh();
		return atributo_entidad;
	}

	public void setAtributo_entidad(DefinicionAtributoEntidad aAtributo_entidad) {
		this.atributo_entidad = aAtributo_entidad;
	}

	public Componente getComponente() throws BaseException {
		supportRefresh();
		return componente;
	}

	public void setComponente(Componente aComponente) {
		this.componente = aComponente;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static GenerarValorCompoCriImpu findByOid(Integer oid,
			ISesion aSesion) throws BaseException {
		return (GenerarValorCompoCriImpu) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GenerarValorCompoCriImpu findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (GenerarValorCompoCriImpu) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(valoresAtriCriterioImputacion,
				"Debe ingresar el criterio");
		Validar.noNulo(atributo_entidad, "Debe ingresar el Atributo Entidad");
		Validar.noNulo(componente, "Debe ingresar el componente Contable");
	}

	public static List getGenerarValoresCompo(
			ValoresAtriCriterioImpu valAtriCriImpu, ISesion aSesion)
			throws BaseException {
		return DBGenerarValorCompoCriImpu.getGenerarValoresCompo(
				valAtriCriImpu, aSesion);
	}

}
