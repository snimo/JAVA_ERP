package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBComproContaDet;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ComproContaDet extends ObjetoLogico {

	public ComproContaDet() {
	}

	public static String NICKNAME = "cg.ComproContaDet";

	private ComproConta comprobante;
	private Integer secu;
	private Integer signo;
	private CuentaImputable cuentaImputable;
	private Moneda moneda;
	private Integer cantidad;
	private Money importeOriginal;
	private String comentario;
	private MayorDia mayorDia;
	private MayorPeri mayorPeri;
	private Money impoLocHist;
	private Money impoLocAju;
	private Money impo_mon_ext_1;
	private Money impo_mon_ext_2;
	private ValorCotizacion cotiz_mon_ori;
	private ValorCotizacion cotiz_mon_ext_1;
	private ValorCotizacion cotiz_mon_ext_2;
	private Integer nroAsiento;

	public ComproConta getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public static ComproContaDet getNewDetalle(ISesion aSesion) throws BaseException {
		return (ComproContaDet) ComproContaDet.getNew(ComproContaDet.NICKNAME, aSesion);
	}

	public Integer getNroAsiento() throws BaseException {
		supportRefresh();
		return this.nroAsiento;
	}

	public void setComprobante(ComproConta aComprobante) {
		this.comprobante = aComprobante;
	}

	public void setNroAsiento(Integer aNroAsiento) {
		this.nroAsiento = aNroAsiento;
	}

	public Integer getSecu() throws BaseException {
		supportRefresh();
		return secu;
	}

	public void setSecu(Integer aSecu) {
		this.secu = aSecu;
	}

	public ValorCotizacion getCotizMonOri() throws BaseException {
		supportRefresh();
		return cotiz_mon_ori;
	}

	public void setCotizMonOri(ValorCotizacion aValorCotizacion) {
		this.cotiz_mon_ori = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt1() throws BaseException {
		supportRefresh();
		return cotiz_mon_ext_1;
	}

	public void setCotizMonExt1(ValorCotizacion aValorCotizacion) {
		this.cotiz_mon_ext_1 = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt2() throws BaseException {
		supportRefresh();
		return cotiz_mon_ext_2;
	}

	public void setCotizMonExt2(ValorCotizacion aValorCotizacion) {
		this.cotiz_mon_ext_2 = aValorCotizacion;
	}

	public Integer getSigno() throws BaseException {
		supportRefresh();
		return signo;
	}

	public Integer getSingoInvertido() throws BaseException {
		return new Integer(getSigno().intValue() * -1);
	}

	public void setSigno(Integer aSigno) {
		this.signo = aSigno;
	}

	public CuentaImputable getCuentaImputable() throws BaseException {
		supportRefresh();
		return cuentaImputable;
	}

	public void setCuentaImputable(CuentaImputable aCuentaimputable) {
		this.cuentaImputable = aCuentaimputable;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Integer getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Integer aCantidad) {
		this.cantidad = aCantidad;
	}

	public Money getImporteOriginal() throws BaseException {
		supportRefresh();
		return importeOriginal;
	}

	public void setImporteOriginal(Money aImporteoriginal) {
		this.importeOriginal = aImporteoriginal;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public MayorDia getMayorDia() throws BaseException {
		supportRefresh();
		return mayorDia;
	}

	public void setMayorDia(MayorDia aMayordia) {
		this.mayorDia = aMayordia;
	}

	public MayorPeri getMayorPeri() throws BaseException {
		supportRefresh();
		return mayorPeri;
	}

	public void setMayorPeri(MayorPeri aMayorperi) {
		this.mayorPeri = aMayorperi;
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
		return impo_mon_ext_1;
	}

	public void setImpoMonExt1(Money aImpo_mon_ext_1) {
		this.impo_mon_ext_1 = aImpo_mon_ext_1;
	}

	public Money getImpoMonExt2() throws BaseException {
		supportRefresh();
		return impo_mon_ext_2;
	}

	public void setImpoMonExt2(Money aImpo_mon_ext_2) {
		this.impo_mon_ext_2 = aImpo_mon_ext_2;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproContaDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproContaDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproContaDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproContaDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ComproContaDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ComproContaDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	private void grabarMayorPeri() throws BaseException {

		mayorPeri = MayorPeri.getByImputablePeriSigno(getCuentaImputable(), getComprobante().getPeriodo(), getSigno(), getSesion());
		if (mayorPeri == null) {
			mayorPeri = MayorPeri.getNewMayorPeri(getSesion());
			mayorPeri.setCuentaImputable(getCuentaImputable());
			mayorPeri.setPeriodo(getComprobante().getPeriodo());
			mayorPeri.setSigno(getSigno());
			mayorPeri.setCantidad(getCantidad());
			mayorPeri.setImpoLocAju(getImpoLocAju());
			mayorPeri.setImpoLocHist(getImpoLocHist());
			mayorPeri.setImpoMonExt1(getImpoMonExt1());
			mayorPeri.setImpoMonExt2(getImpoMonExt2());
			mayorPeri.save();
		} else {
			mayorPeri.setCantidad(getCantidad());
			mayorPeri.setImpoLocAju(getImpoLocAju());
			mayorPeri.setImpoLocHist(getImpoLocHist());
			mayorPeri.setImpoMonExt1(getImpoMonExt1());
			mayorPeri.setImpoMonExt2(getImpoMonExt2());
			mayorPeri.save();
		}

	}

	public void grabarMayorDia() throws BaseException {
		mayorDia = MayorDia.getByDiarioImputableFechaSigno(comprobante.getDiario(), getCuentaImputable(), comprobante.getImputac(),
				getSigno(), getSesion());
		if (mayorDia == null) {
			mayorDia = MayorDia.getNewMayorDia(getSesion());
			mayorDia.setImputac(comprobante.getImputac());
			mayorDia.setDiario(comprobante.getDiario());
			mayorDia.setCuentaimputable(getCuentaImputable());
			mayorDia.setSigno(getSigno());
			mayorDia.setMayorPeri(mayorPeri);
			mayorDia.setCantidad(getCantidad());
			mayorDia.setImpoLocAju(getImpoLocAju());
			mayorDia.setImpoLocHist(getImpoLocHist());
			mayorDia.setImpoMonExt1(getImpoMonExt1());
			mayorDia.setImpoMonExt2(getImpoMonExt2());
			mayorDia.save();
		} else {
			mayorDia.setCantidad(getCantidad());
			mayorDia.setImpoLocAju(getImpoLocAju());
			mayorDia.setImpoLocHist(getImpoLocHist());
			mayorDia.setImpoMonExt1(getImpoMonExt1());
			mayorDia.setImpoMonExt2(getImpoMonExt2());
			mayorDia.save();
		}

	}

	@Override
	protected void beforeSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveNew();

		grabarMayorPeri();
		grabarMayorDia();

	}

	public void recostruirMayores() throws BaseException {

		grabarMayorPeri();
		grabarMayorDia();

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

	public static List getDetallesByComproConta(ComproConta comproConta, ISesion aSesion) throws BaseException {
		return DBComproContaDet.getDetallesByComproConta(comproConta, aSesion);
	}

	public static List getDetallesByComproConta(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBComproContaDet.getDetallesByComproConta(condiciones, aSesion);
	}

	public static List getImputacionesByCuentasValoresCompo(java.util.Date fecDesde, java.util.Date fecHasta, List listaCuentas,
			HashTableDatos listaValoresCompo, ISesion aSesion) throws BaseException {
		return DBComproContaDet.getImputacionesByCuentasValoresCompo(fecDesde, fecHasta, listaCuentas, listaValoresCompo, aSesion);
	}

	public static List getDetallesByEjercicio(Ejercicio ejercicio, boolean patrimonial, boolean resultado, ISesion aSesion)
			throws BaseException {

		return DBComproContaDet.getDetallesByEjercicio(ejercicio, patrimonial, resultado, aSesion);
	}

	public static List getImpuEjercicioOrderFecOIDCCO(Ejercicio ejercicio, ISesion aSesion) throws BaseException {
		return DBComproContaDet.getImpuEjercicioOrderFecOIDCCO(ejercicio, aSesion);
	}

	public static List getImpuFecDesdeHastaOrderByNroAsi(java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion)
			throws BaseException {

		return DBComproContaDet.getImpuFecDesdeHastaOrderByNroAsi(fecDesde, fecHasta, aSesion);

	}

	@Override
	public void beforeSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveDelete();

		int nuevoSigno = this.getSigno().intValue() * -1;
		this.setSigno(nuevoSigno);

		grabarMayorPeri();
		grabarMayorDia();

	}

	public static List getAllComproContaDet(ISesion aSesion) throws BaseException {

		return DBComproContaDet.getAllComproContaDet(aSesion);
	}

	public static List getAllComproContaDetHastaOID(ISesion aSesion, Integer OID) throws BaseException {
		return DBComproContaDet.getAllComproContaDetHastaOID(aSesion, OID);
	}

}
