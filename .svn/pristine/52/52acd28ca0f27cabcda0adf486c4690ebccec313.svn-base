package com.srn.erp.contabilidad.bm;

import java.sql.PreparedStatement;

import com.srn.erp.contabilidad.da.DBMayorPeri;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class MayorPeri extends ObjetoLogico {

	public MayorPeri() {
	}

	public static String NICKNAME = "cg.MayorPeri";

	private CuentaImputable cuentaImputable;
	private Periodo periodo;
	private Integer signo;
	private Integer cantidad;
	private Money impoLocHist;
	private Money impoLocAju;
	private Money impoMonExt1;
	private Money impoMonExt2;

	public CuentaImputable getCuentaImputable() throws BaseException {
		supportRefresh();
		return cuentaImputable;
	}

	public void setCuentaImputable(CuentaImputable aCuentaImputable) throws BaseException {
		this.cuentaImputable = aCuentaImputable;
	}

	public Periodo getPeriodo() throws BaseException {
		supportRefresh();
		return periodo;
	}

	public void setPeriodo(Periodo aPeriodo) {
		this.periodo = aPeriodo;
	}

	public Integer getSigno() throws BaseException {
		supportRefresh();
		return signo;
	}

	public void setSigno(Integer aSigno) {
		this.signo = aSigno;
	}

	public Integer getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Integer aCantidad) {
		this.cantidad = aCantidad;
	}

	public Money getImpoLocHist() throws BaseException {
		supportRefresh();
		return impoLocHist;
	}

	public void setImpoLocHist(Money aImpolochist) {
		this.impoLocHist = aImpolochist;
	}

	public Money getImpoLocAju() throws BaseException {
		supportRefresh();
		return impoLocAju;
	}

	public void setImpoLocAju(Money aImpolocaju) {
		this.impoLocAju = aImpolocaju;
	}

	public Money getImpoMonExt1() throws BaseException {
		supportRefresh();
		return impoMonExt1;
	}

	public void setImpoMonExt1(Money aImpomonext1) {
		this.impoMonExt1 = aImpomonext1;
	}

	public Money getImpoMonExt2() throws BaseException {
		supportRefresh();
		return impoMonExt2;
	}

	public void setImpoMonExt2(Money aImpomonext2) {
		this.impoMonExt2 = aImpomonext2;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static MayorPeri findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MayorPeri) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MayorPeri findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MayorPeri) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static MayorPeri findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MayorPeri) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	public Boolean isActivo() {
		return null;
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	public static MayorPeri getByImputablePeriSigno(CuentaImputable cuentaImputable, Periodo periodo, Integer signo, ISesion aSesion)
			throws BaseException {

		return DBMayorPeri.getByImputablePeriSigno(cuentaImputable, periodo, signo, aSesion);
	}

	public static MayorPeri getNewMayorPeri(ISesion aSesion) throws BaseException {
		return (MayorPeri) MayorPeri.getNew(MayorPeri.NICKNAME, aSesion);
	}

	public static void borrarTodo(ISesion aSesion) throws BaseException {

		DBMayorPeri.borrarTodo(aSesion);
	}

}
