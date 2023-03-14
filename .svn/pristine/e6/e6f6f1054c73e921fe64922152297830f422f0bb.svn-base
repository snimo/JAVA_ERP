package com.srn.erp.bienUso.bm;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.bienUso.da.DBSistemaValuacion;
import com.srn.erp.general.bm.Indice;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SistemaValuacion extends ObjetoLogico {

	public static final String TIPO_ANUAL = "ANU";

	public static final String TIPO_MENSUAL = "MEN";

	public static final String TIPO_ANUAL_MENSUAL = "ANME";

	public SistemaValuacion() {
	}

	public static String NICKNAME = "bu.SistemaValuacion";

	private String codigo;

	private String descripcion;

	private String tipo_amort;

	private Boolean contable;

	private Boolean aju_inf;

	private Moneda moneda;

	private Indice indice;

	private Boolean activo;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getTipo_amort() throws BaseException {
		supportRefresh();
		return tipo_amort;
	}

	public void setTipo_amort(String aTipo_amort) {
		this.tipo_amort = aTipo_amort;
	}

	public Boolean isContable() throws BaseException {
		supportRefresh();
		return contable;
	}

	public void setContable(Boolean aContable) {
		this.contable = aContable;
	}

	public Boolean isAju_inf() throws BaseException {
		supportRefresh();
		return aju_inf;
	}

	public void setAju_inf(Boolean aAju_inf) {
		this.aju_inf = aAju_inf;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Indice getIndice() throws BaseException {
		supportRefresh();
		return indice;
	}

	public void setIndice(Indice aIndice) {
		this.indice = aIndice;
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

	public static SistemaValuacion findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (SistemaValuacion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SistemaValuacion findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (SistemaValuacion) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static SistemaValuacion findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (SistemaValuacion) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(tipo_amort, "Debe ingresar el Tipo");
		Validar.noNulo(contable, "Debe indicar si es contable");
		Validar.noNulo(aju_inf, "Dene indicar si ajusta por inflación");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
	}

	public static Hashtable getTiposAmortizaciones() throws BaseException {
		Hashtable tiposAmortizaciones = new Hashtable();
		tiposAmortizaciones.put(TIPO_ANUAL, "Anual");
		tiposAmortizaciones.put(TIPO_MENSUAL, "Mensual");
		tiposAmortizaciones.put(TIPO_ANUAL_MENSUAL, "Anual Mensualizado");
		return tiposAmortizaciones;
	}

	public static List getSistemasDeValuacion(ISesion aSesion)
			throws BaseException {
		return DBSistemaValuacion.getSistemasDeValuacion(aSesion);
	}

	public static List getSistemasDeValuacionActivos(ISesion aSesion)
			throws BaseException {
		return DBSistemaValuacion.getSistemasDeValuacionActivos(aSesion);
	}
	
	public boolean isAmortizaPeriodo(Periodo periodo) throws BaseException {
		if (getTipo_amort().equals(TIPO_MENSUAL))
			return true;
		else
			return false; 
	}

}
