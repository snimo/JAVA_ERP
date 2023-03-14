package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBComproCierreEjercicio;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComproCierreEjercicio extends ComproCab implements IContabilizable {

	public static final String CIERRE_RESUL = "RESUL";
	public static final String CIERRE_PATRI = "PATRI";

	private AnuladorComproCierreEjercicio anuladorComproCierreEjercicio = null;

	private ComproCab comprobante;
	private String cierreDe;

	RenglonesAsiento renglones = new RenglonesAsiento();

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	public String getCierreDe() throws BaseException {
		this.supportRefresh();
		return this.cierreDe;
	}

	public void setCierreDe(String aCierreDe) {
		this.cierreDe = aCierreDe;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public java.util.Date getImputacion() throws BaseException {
		return this.getImputac();
	}

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public ComproCierreEjercicio() {
	}

	public void addRenglonCierre(CuentaImputable cuenta, Integer signo,
			Money impoMonLocHist, Money impoMonLocAju, Money impoMonExt1,
			Money impoMonExt2, Moneda monedaOri, Money importeOri,
			ValorCotizacion cotizMonOri, ValorCotizacion monExt1,
			ValorCotizacion monExt2) throws BaseException {

		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(cuenta);
		renglon.setD_H(signo);
		renglon.setMonedaOri(monedaOri);
		renglon.setImporteOri(importeOri);
		renglon.setCotizOri(cotizMonOri);
		renglon.setCotizMonExt1(monExt1);
		renglon.setCotizMonExt2(monExt2);
		renglon.setComentario("");

		renglon.setImpoLocHist(impoMonLocHist);
		renglon.setImpoLocAju(impoMonLocAju);
		renglon.setImpoMonExt1(impoMonExt1);
		renglon.setImpoMonExt2(impoMonExt2);

	}

	public static String NICKNAME = "cg.ComproCierreEjercicio";

	private Ejercicio ejercicio;

	public Ejercicio getEjercicio() throws BaseException {
		supportRefresh();
		return ejercicio;
	}

	public void setEjercicio(Ejercicio aEjercicio) {
		this.ejercicio = aEjercicio;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproCierreEjercicio findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproCierreEjercicio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproCierreEjercicio findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (ComproCierreEjercicio) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public static ComproCierreEjercicio findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (ComproCierreEjercicio) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {

			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));

		}

		beforeSaveComprobante(this);

		Validar.noNulo(ejercicio, "Debe ingresar el Ejercicio");
		Validar.noNulo(this.getImputac(),
				"Debe ingresar la Fecha de Imputación");

	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		return this.renglones;
	}

	public static Talonario getTalonatioAsientoCierreEjercicio(ISesion aSesion)
			throws BaseException {
		return Talonario.getTalonatioAsientoCierreEjercicio(aSesion);
	}

	public static CuentaImputable getCuentaResultadoEjericioAsientoDeCierre(
			ISesion aSesion) throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro(
				"CTA_RESULT_EJER_CIERRE_EJER", aSesion);
		CuentaImputable cuentaImputable = CuentaImputable.findByOid(
				valorParametro.getOidObjNeg(), aSesion);
		return cuentaImputable;
	}

	public static List getComprobantesCierreEjercicio(Ejercicio ejercicio,
			ISesion aSesion) throws BaseException {

		return DBComproCierreEjercicio.getComprobantesCierreEjercicio(
				ejercicio, aSesion);

	}

	public static String getDescTipoCierre(String codigo) throws BaseException {

		if (codigo.equals(CIERRE_PATRI))
			return "Cierre Cuentas Patrimoniales";
		else if (codigo.equals(CIERRE_RESUL))
			return "Cierre Cuentas de Resultado";
		else
			return "";

	}

	public void anular() throws BaseException {

		anuladorComproCierreEjercicio = (AnuladorComproCierreEjercicio) AnuladorComproCierreEjercicio
				.getNew(AnuladorComproCierreEjercicio.NICKNAME, getSesion());
		anuladorComproCierreEjercicio.setComproCierreEjercicio(this);
		anuladorComproCierreEjercicio.generarComproAnulacion();
		anuladorComproCierreEjercicio.save();

	}

	public static ComproCierreEjercicio getComproCierrePatrimonial(Ejercicio ejercicio, ISesion aSesion) throws BaseException {
		return DBComproCierreEjercicio.getComproCierrePatrimonial(ejercicio,aSesion);
	}
	
	public boolean isCierreCtasResultado() throws BaseException {
		if (this.getCierreDe().equals(CIERRE_RESUL))
			return true;
		else
			return false;
	}

}
