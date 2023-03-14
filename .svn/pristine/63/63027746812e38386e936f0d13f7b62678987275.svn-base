package com.srn.erp.contabilidad.bm;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

import com.srn.erp.contabilidad.da.DBMayorDia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class MayorDia extends ObjetoLogico {

	public MayorDia() {
	}

	public static String NICKNAME = "cg.MayorDia";

	private Diario diario;
	private CuentaImputable cuentaImputable;
	private Date imputac;
	private Integer signo;
	private Integer cantidad;
	private Money impoLocHist;
	private Money impoLocAju;
	private Money impoMonExt1;
	private Money impoMonExt2;
	private MayorPeri mayorPeri;

	public Diario getDiario() throws BaseException {
		supportRefresh();
		return diario;
	}

	public void setDiario(Diario aDiario) {
		this.diario = aDiario;
	}

	public CuentaImputable getCuentaimputable() throws BaseException {
		supportRefresh();
		return cuentaImputable;
	}

	public void setCuentaimputable(CuentaImputable aCuentaimputable) {
		this.cuentaImputable = aCuentaimputable;
	}

	public Date getImputac() throws BaseException {
		supportRefresh();
		return imputac;
	}

	public void setImputac(Date aImputac) {
		this.imputac = aImputac;
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

	public MayorPeri getMayorPeri() throws BaseException {
		supportRefresh();
		return mayorPeri;
	}

	public void setMayorPeri(MayorPeri aMayorperi) {
		this.mayorPeri = aMayorperi;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static MayorDia findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MayorDia) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MayorDia findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MayorDia) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static MayorDia findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MayorDia) getObjectByCodigo(NICKNAME, codigo, aSesion);
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

	public static MayorDia getByDiarioImputableFechaSigno(Diario diario, CuentaImputable cuentaImputable, java.util.Date fecha,
			Integer signo, ISesion aSesion) throws BaseException {

		return DBMayorDia.getByDiarioImputableFechaSigno(diario, cuentaImputable, fecha, signo, aSesion);
	}

	public static MayorDia getNewMayorDia(ISesion aSesion) throws BaseException {
		return (MayorDia) MayorDia.getNew(MayorDia.NICKNAME, aSesion);
	}

	public static List getImputacionesByCuentasValoresCompo(java.util.Date fecDesde, java.util.Date fecHasta, List listaCuentas,
			HashTableDatos listaValoresCompo, ISesion aSesion) throws BaseException {
		return DBMayorDia.getImputacionesByCuentasValoresCompo(fecDesde, fecHasta, listaCuentas, listaValoresCompo, aSesion);
	}

	public static List getImputacionesByDriverSubReparto(java.util.Date fecDesde, java.util.Date fecHasta, DriverSubreparto driver,
			ISesion aSesion) throws BaseException {
		return DBMayorDia.getImputacionesByDriverSubReparto(fecDesde, fecHasta, driver, aSesion);
	}

	public static void borrarTodo(ISesion aSesion) throws BaseException {

		DBMayorDia.borrarTodo(aSesion);

	}

}
