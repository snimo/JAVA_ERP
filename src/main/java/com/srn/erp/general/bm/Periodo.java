package com.srn.erp.general.bm;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Periodo extends ObjetoLogico {

	public static String UNIDAD_DIA = "UNI_DIA";
	public static String UNIDAD_MES = "UNI_MES";

	public Periodo() {
	}

	public static String NICKNAME = "ge.Periodo";

	private String codigo;

	private String descripcion;

	private Date fechaDesde;

	private Date fechaHasta;

	private String tipo;

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

	public Date getFechadesde() throws BaseException {
		supportRefresh();
		return fechaDesde;
	}

	public void setFechadesde(Date aFechadesde) {
		this.fechaDesde = aFechadesde;
	}

	public Date getFechahasta() throws BaseException {
		supportRefresh();
		return fechaHasta;
	}

	public void setFechahasta(Date aFechahasta) {
		this.fechaHasta = aFechahasta;
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

	public static Periodo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Periodo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Periodo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Periodo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Periodo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Periodo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar un código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(fechaDesde, "Debe ingresar la Fecha Desde");
		Validar.noNulo(fechaHasta, "Debe Ingresar la Fecha Hasta");
		Validar.noNulo(tipo, "Debe ingresar el Tipo de Período");

		if (isNew() && (isActivo().booleanValue() == false))
			Validar.mensajeValidacion("El período debe estar en modo activo");

	}

	public static Periodo getPeriodoByFechaDelEjercicio(java.util.Date fecha, ISesion aSesion) throws BaseException {
		return DBPeriodo.getPeriodoByFechaDelEjercicio(fecha, aSesion);
	}

	public boolean isPosterior(Periodo aPeriodo) throws BaseException {
		long fechaDesde = getFechadesde().getTime();
		long fechaDesdePeriodo = aPeriodo.getFechadesde().getTime();
		return (fechaDesde > fechaDesdePeriodo);
	}

	public int getMesesEntre(Periodo aPeriodo) throws BaseException {
		// Devuelve la cantidad de Periodo entre dos Periodos
		Calendar inicio = Calendar.getInstance();
		Calendar fin = Calendar.getInstance();

		if (this.getFechadesde().after(aPeriodo.getFechadesde())) {
			inicio.setTime(this.getFechadesde());
			fin.setTime(aPeriodo.getFechadesde());
		} else {
			inicio.setTime(aPeriodo.getFechadesde());
			fin.setTime(this.getFechadesde());
		}
		int mesNeg = fin.get(Calendar.MONTH) + 1;
		int anioNeg = fin.get(Calendar.YEAR);

		int mesPos = inicio.get(Calendar.MONTH) + 1;
		int anioPos = inicio.get(Calendar.YEAR);

		int meses = (anioPos - anioNeg) * 12;
		return (meses - mesNeg + mesPos);
	}

	public Periodo getPrimerPeriodoEjercicio() throws BaseException {
		Ejercicio ejercicio = Ejercicio.getEjercicio(this, getSesion());
		return ejercicio.getPrimerPeriodo();
	}

	public static Periodo getPeriodoMensual(java.util.Date fechaDesde, ISesion aSesion) throws BaseException {
		return DBPeriodo.getPeriodoMensual(fechaDesde, aSesion);
	}

	public Periodo getSiguienPeriMensual() throws BaseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.getFechadesde());
		calendar.add(Calendar.MONTH, 1);
		Periodo proxPeriMensual = Periodo.getPeriodoMensual(calendar.getTime(), getSesion());
		return proxPeriMensual;
	}

	public Periodo getPeriMensualAnterior() throws BaseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.getFechadesde());
		calendar.add(Calendar.MONTH, -1);
		Periodo proxPeriMensual = Periodo.getPeriodoMensual(calendar.getTime(), getSesion());
		return proxPeriMensual;
	}

	public static Periodo getPeriodoMensualByFecha(java.util.Date fecha, ISesion aSesion) throws BaseException {
		return DBPeriodo.getPeriodoMensualByFecha(fecha, aSesion);
	}
	
	public static List getPeriodosEntreFechas(
			  java.util.Date fecDesde,
			  java.util.Date fecHasta,
	          ISesion aSesion) throws BaseException {
		  return DBPeriodo.getPeriodosEntreFechas(fecDesde,fecHasta,aSesion);
	}	

}
