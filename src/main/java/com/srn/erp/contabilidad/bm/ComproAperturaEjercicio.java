package com.srn.erp.contabilidad.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBComproAperturaEjercicio;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComproAperturaEjercicio extends ComproCab implements IContabilizable {

	private AnuladorComproAperturaEjercicio anuladorComproAperturaEjercicio = null;

	private ComproCab comprobante;

	RenglonesAsiento renglones = new RenglonesAsiento();

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
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

	public ComproAperturaEjercicio() {
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

	public static String NICKNAME = "cg.ComproAperturaEjercicio";

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

	public static ComproAperturaEjercicio findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproAperturaEjercicio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproAperturaEjercicio findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (ComproAperturaEjercicio) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public static ComproAperturaEjercicio findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (ComproAperturaEjercicio) getObjectByCodigo(NICKNAME, codigo,
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

	public static Talonario getTalonatioAsientoAperturaEjercicio(ISesion aSesion)
			throws BaseException {
		return Talonario.getTalonatioAsientoAperturaEjercicio(aSesion);
	}

	public static List getComprobantesAperturaEjercicio(Ejercicio ejercicio,
			ISesion aSesion) throws BaseException {

		return DBComproAperturaEjercicio.getComprobantesAperturaEjercicio(
				ejercicio, aSesion);

	}
	
	public static boolean isTieneEjercicioComproAperturaActivo(Ejercicio ejercicio,ISesion aSesion) throws BaseException {
		Iterator iterComproAper = 
			getComprobantesAperturaEjercicio(ejercicio,aSesion).iterator();
		while (iterComproAper.hasNext()) {
			ComproAperturaEjercicio comproAperturaEjercicio = (ComproAperturaEjercicio) iterComproAper.next();
			if (comproAperturaEjercicio.isActivo())
				return true;
		}
		return false;
	}


	public void anular() throws BaseException {

		anuladorComproAperturaEjercicio = (AnuladorComproAperturaEjercicio) AnuladorComproAperturaEjercicio
				.getNew(AnuladorComproAperturaEjercicio.NICKNAME, getSesion());
		anuladorComproAperturaEjercicio.setComproAperturaEjercicio(this);
		anuladorComproAperturaEjercicio.generarComproAnulacion();
		anuladorComproAperturaEjercicio.save();

	}


}
