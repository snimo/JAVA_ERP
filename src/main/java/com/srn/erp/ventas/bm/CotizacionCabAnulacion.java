package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.RenglonesStock;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class CotizacionCabAnulacion extends ComproCab implements IContabilizable, IStockeable {

	public CotizacionCabAnulacion() {
	}

	private List					detalles		= new ArrayList();

	private boolean				readDetalle	= true;

	private ComproCab			comprobante;

	public static String	NICKNAME		= "ve.CotizacionCabAnulacion";

	private CotizacionCab			cotizacion_cab;

	public CotizacionCab getCotizacion_cab() throws BaseException {
		supportRefresh();
		return cotizacion_cab;
	}

	public void setCotizacion_cab(CotizacionCab aCotizacion_cab) {
		this.cotizacion_cab = aCotizacion_cab;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static CotizacionCabAnulacion findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CotizacionCabAnulacion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CotizacionCabAnulacion findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CotizacionCabAnulacion) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(cotizacion_cab, "Debe ingresar la Cotización");
		
			beforeSaveComprobante(this);
			if (this.isNew()) {
				this.setComprobante(this);
				this.setEstado(ComproCab.ESTADO_ALTA);
  		}
		
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		// TODO Auto-generated method stub
		// return getInforme_recepcion().getComproConta().getRenglonesAsientoInvertidos();
		return null;
	}

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return getImputac();
	}

	public RenglonesStock getRenglonesStock() throws BaseException {
		return this.getCotizacion_cab().getStockCabecera().getRenglonesStockInvertidos(this);
	}

	public void addDetalle(CotizacionDetAnulacion cotizacionDetAnulacion) throws BaseException {
		this.detalles.add(cotizacionDetAnulacion);
		cotizacionDetAnulacion.setCotizacion_cab_anu(this);
	}

	public List getDetalles() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(CotizacionDetAnulacion.getDetalles(this, getSesion()));
			readDetalle = false;
		}
		return detalles;
	}

	public void afterSave() throws BaseException {

		Iterator iterDetalles = this.detalles.iterator();
		while (iterDetalles.hasNext()) {
			CotizacionDetAnulacion cotizacionDetAnulacion = (CotizacionDetAnulacion) iterDetalles.next();
			cotizacionDetAnulacion.save();
			cotizacionDetAnulacion = null;
		}
		iterDetalles = null;

		afterSaveComprobante(this);

		anularComprobante(this.getCotizacion_cab());

	}

	public void generarComproAnulacion() throws BaseException {

		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getCotizacion_cab().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getCotizacion_cab().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("");
		setActivo(new Boolean(true));

		Iterator iterCotizacionDet = this.getCotizacion_cab().getDetalles().iterator();
		while (iterCotizacionDet.hasNext()) {
			CotizacionDet cotizacionDet = (CotizacionDet) iterCotizacionDet.next();
			if (cotizacionDet.isAnulado().booleanValue())
				continue;
			CotizacionDetAnulacion cotizacionDetAnulacion = (CotizacionDetAnulacion) CotizacionDetAnulacion.getNew(CotizacionDetAnulacion.NICKNAME,
					getSesion());
			cotizacionDetAnulacion.setCotizacion_cab_anu(this);
			cotizacionDetAnulacion.setCotizacion_det(cotizacionDet);
			addDetalle(cotizacionDetAnulacion);
		}

	}
	
	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}
	

}
