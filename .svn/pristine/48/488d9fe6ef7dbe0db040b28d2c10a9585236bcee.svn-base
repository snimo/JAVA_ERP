package com.srn.erp.tesoreria.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.tesoreria.da.DBTransferenciaValores;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TransferenciaValores extends ComproCab implements IContabilizable {

	private AnuladorTransferenciaValores	anuladorTransferencia			= null;

	private List													efectivoTransferencia			= new ArrayList();

	private boolean												readEfectivoTransferencia	= true;

	private List													valoresTransferencia			= new ArrayList();

	private boolean												readValoresTransferencia	= true;

	private ComproCab											comprobante;

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public java.util.Date getImputacion() throws BaseException {
		return this.getImputac();
	}

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public TransferenciaValores() {
	}

	public static String	NICKNAME	= "te.TransferenciaValores";

	private Caja					cajaOrigen;

	private Caja					cajaDestino;

	public void setCajaOrigen(Caja aCajaOrigen) throws BaseException {
		this.cajaOrigen = aCajaOrigen;
	}

	public Caja getCajaOrigen() throws BaseException {
		return this.cajaOrigen;
	}

	public void setCajaDestino(Caja aCajaDestino) throws BaseException {
		this.cajaDestino = aCajaDestino;
	}

	public Caja getCajaDestino() throws BaseException {
		return this.cajaDestino;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TransferenciaValores findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TransferenciaValores) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TransferenciaValores findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TransferenciaValores) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}

		beforeSaveComprobante(this);

		Validar.noNulo(cajaOrigen, "Debe Ingresar la Caja Origen");
		Validar.noNulo(cajaDestino, "Debe ingresar la Caja Destino");

	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {

		RenglonesAsiento renglones = new RenglonesAsiento();
		getRenglonEfectivo(renglones);
		getRenglonValor(renglones);
		return renglones;
	}

	private void getRenglonEfectivo(RenglonesAsiento renglones) throws BaseException {

		Iterator iterTransEfe = this.efectivoTransferencia.iterator();
		while (iterTransEfe.hasNext()) {
			TransferenciaEfectivo transEfe = (TransferenciaEfectivo) iterTransEfe.next();

			if ((transEfe.getTransferido() == null) || (transEfe.getTransferido().doubleValue() == 0))
				continue;

			ImportesContables importesValores = this.getImportesContables(transEfe.getTransferido(), transEfe.getTipo_valor()
					.getMoneda(), this.getImputac());

			// Salida por la caja Origen

			RenglonAsiento renglonOrigen = renglones.addRenglonAsiento();
			renglonOrigen.setCuentaImputable(transEfe.getTipo_valor().getCuentaImputable());
			renglonOrigen.setD_H(RenglonAsiento.HABER);
			renglonOrigen.setMonedaOri(transEfe.getTipo_valor().getMoneda());
			renglonOrigen.setImporteOri(transEfe.getTransferido());
			renglonOrigen.setCotizOri(this.getCotizacionMoneda(transEfe.getTipo_valor().getMoneda()));
			renglonOrigen.setComentario("");
			renglonOrigen.setCotizMonExt1(importesValores.getValorCotizMonExt1());
			renglonOrigen.setCotizMonExt2(importesValores.getValorCotizMonExt2());

			renglonOrigen.setImpoLocHist(importesValores.getImpoMonLoc());
			renglonOrigen.setImpoLocAju(importesValores.getImpoMonLocAju());
			renglonOrigen.setImpoMonExt1(importesValores.getImpoMonExt1());
			renglonOrigen.setImpoMonExt2(importesValores.getImpoMonExt2());

			// Entrada por la caja Destino

			RenglonAsiento renglonDestino = renglones.addRenglonAsiento();
			renglonDestino.setCuentaImputable(transEfe.getTipo_valor().getCuentaImputable());
			renglonDestino.setD_H(RenglonAsiento.DEBE);
			renglonDestino.setMonedaOri(transEfe.getTipo_valor().getMoneda());
			renglonDestino.setImporteOri(transEfe.getTransferido());
			renglonDestino.setCotizOri(this.getCotizacionMoneda(transEfe.getTipo_valor().getMoneda()));
			renglonDestino.setComentario("");
			renglonDestino.setCotizMonExt1(importesValores.getValorCotizMonExt1());
			renglonDestino.setCotizMonExt2(importesValores.getValorCotizMonExt2());

			renglonDestino.setImpoLocHist(importesValores.getImpoMonLoc());
			renglonDestino.setImpoLocAju(importesValores.getImpoMonLocAju());
			renglonDestino.setImpoMonExt1(importesValores.getImpoMonExt1());
			renglonDestino.setImpoMonExt2(importesValores.getImpoMonExt2());

		}

	}

	private void getRenglonValor(RenglonesAsiento renglones) throws BaseException {

		Iterator iterTransVal = this.valoresTransferencia.iterator();
		while (iterTransVal.hasNext()) {
			TransferenciaValor transVal = (TransferenciaValor) iterTransVal.next();

			ImportesContables importesValores = this.getImportesContables(transVal.getTransferido(), transVal.getValor()
					.getTipovalor().getMoneda(), this.getImputac());

			// Salida por la caja Origen

			RenglonAsiento renglonOrigen = renglones.addRenglonAsiento();
			
			renglonOrigen.setCuentaImputable(transVal.getValor().getCuentaImputable());
			renglonOrigen.setD_H(RenglonAsiento.HABER);
			renglonOrigen.setMonedaOri(transVal.getValor().getTipovalor().getMoneda());
			renglonOrigen.setImporteOri(transVal.getImporte());
			renglonOrigen.setCotizOri(this.getCotizacionMoneda(transVal.getValor().getTipovalor().getMoneda()));
			renglonOrigen.setComentario("");
			renglonOrigen.setCotizMonExt1(importesValores.getValorCotizMonExt1());
			renglonOrigen.setCotizMonExt2(importesValores.getValorCotizMonExt2());

			renglonOrigen.setImpoLocHist(importesValores.getImpoMonLoc());
			renglonOrigen.setImpoLocAju(importesValores.getImpoMonLocAju());
			renglonOrigen.setImpoMonExt1(importesValores.getImpoMonExt1());
			renglonOrigen.setImpoMonExt2(importesValores.getImpoMonExt2());

			// Entrada por la caja Destino

			RenglonAsiento renglonDestino = renglones.addRenglonAsiento();
			renglonDestino.setCuentaImputable(transVal.getValor().getCuentaImputable());
			renglonDestino.setD_H(RenglonAsiento.DEBE);
			renglonDestino.setMonedaOri(transVal.getValor().getTipovalor().getMoneda());
			renglonDestino.setImporteOri(transVal.getImporte());
			renglonDestino.setCotizOri(this.getCotizacionMoneda(transVal.getValor().getTipovalor().getMoneda()));
			renglonDestino.setComentario("");
			renglonDestino.setCotizMonExt1(importesValores.getValorCotizMonExt1());
			renglonDestino.setCotizMonExt2(importesValores.getValorCotizMonExt2());

			renglonDestino.setImpoLocHist(importesValores.getImpoMonLoc());
			renglonDestino.setImpoLocAju(importesValores.getImpoMonLocAju());
			renglonDestino.setImpoMonExt1(importesValores.getImpoMonExt1());
			renglonDestino.setImpoMonExt2(importesValores.getImpoMonExt2());

		}

	}

	public void addTransferenciaEfectivo(TransferenciaEfectivo aTransferenciaEfectivo) throws BaseException {
		aTransferenciaEfectivo.setTransferencia_valores(this);
		efectivoTransferencia.add(aTransferenciaEfectivo);
	}

	public void addTransferenciaValor(TransferenciaValor aTransferenciaValor) throws BaseException {
		aTransferenciaValor.setTransferencia_valores(this);
		valoresTransferencia.add(aTransferenciaValor);
	}

	public void afterSave() throws BaseException {
		grabarTransferenciasEfectivo();
		grabarTransferenciasValores();
		afterSaveComprobante(this);
	}

	public List getTransferenciasEfectivo() throws BaseException {
		if (this.readEfectivoTransferencia == true) {
			this.efectivoTransferencia.addAll(TransferenciaEfectivo.getTransferenciasEfectivo(this, getSesion()));
			this.readEfectivoTransferencia = false;
			return this.efectivoTransferencia;
		}
		else
			return this.efectivoTransferencia;
	}

	public List getTransferenciasValores() throws BaseException {
		if (this.readValoresTransferencia == true) {
			this.valoresTransferencia.addAll(TransferenciaValor.getTransferenciasValor(this, getSesion()));
			this.readValoresTransferencia = false;
			return this.valoresTransferencia;
		}
		else
			return this.valoresTransferencia;
	}

	private void grabarTransferenciasEfectivo() throws BaseException {

		Iterator iterTransferenciasEfectivo = this.efectivoTransferencia.iterator();
		while (iterTransferenciasEfectivo.hasNext()) {
			TransferenciaEfectivo transEfe = (TransferenciaEfectivo) iterTransferenciasEfectivo.next();
			transEfe.save();
			transEfe = null;
		}

	}

	private void grabarTransferenciasValores() throws BaseException {

		Iterator iterTransferenciasValores = this.valoresTransferencia.iterator();
		while (iterTransferenciasValores.hasNext()) {
			TransferenciaValor transVal = (TransferenciaValor) iterTransferenciasValores.next();
			transVal.save();
			transVal = null;
		}

	}

	public void anular() throws BaseException {

		/*
		 * anuladorRecibo = (AnuladorRecibo) AnuladorRecibo.getNew(AnuladorRecibo.NICKNAME, getSesion());
		 * anuladorRecibo.setRecibo(this); anuladorRecibo.generarComproAnulacion(); anuladorRecibo.save();
		 */

	}

	public static List getHelpTransferencias(Integer nroExtDesde, Integer nroExtHasta, Date fechaDesde, Date fechaHasta,
			ISesion aSesion) throws BaseException {

		return DBTransferenciaValores.getHelpTransferencias(nroExtDesde, nroExtHasta, fechaDesde, fechaHasta, aSesion);
	}

}
