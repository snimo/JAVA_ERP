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

public class RemitoCabAnulacion extends ComproCab implements IContabilizable, IStockeable {

	public RemitoCabAnulacion() {
	}

	private List					detalles		= new ArrayList();

	private boolean				readDetalle	= true;

	private ComproCab			comprobante;

	public static String	NICKNAME		= "ve.RemitoCabAnulacion";

	private RemitoCab			remito_cab;

	public RemitoCab getRemito_cab() throws BaseException {
		supportRefresh();
		return remito_cab;
	}

	public void setRemito_cab(RemitoCab aRemito_cab) {
		this.remito_cab = aRemito_cab;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static RemitoCabAnulacion findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RemitoCabAnulacion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RemitoCabAnulacion findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RemitoCabAnulacion) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(remito_cab, "Debe ingresar el Remito");
		
			beforeSaveComprobante(this);
			if (this.isNew()) {
				this.setComprobante(this);
				this.setEstado(ComproCab.ESTADO_ALTA);
  		}
		
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return super.getDescripcion();
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
		return this.getRemito_cab().getStockCabecera().getRenglonesStockInvertidos(this);
	}

	public void addDetalle(RemitoDetAnulacion remitoDetAnulacion) throws BaseException {
		this.detalles.add(remitoDetAnulacion);
		remitoDetAnulacion.setRemito_cab_anu(this);
	}

	public List getDetalles() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(RemitoDetAnulacion.getDetalles(this, getSesion()));
			readDetalle = false;
		}
		return detalles;
	}

	public void afterSave() throws BaseException {

		Iterator iterDetalles = this.detalles.iterator();
		while (iterDetalles.hasNext()) {
			RemitoDetAnulacion remitoDetAnulacion = (RemitoDetAnulacion) iterDetalles.next();
			remitoDetAnulacion.save();
			remitoDetAnulacion = null;
		}
		iterDetalles = null;

		afterSaveComprobante(this);

		anularComprobante(this.getRemito_cab());

	}

	public void generarComproAnulacion() throws BaseException {

		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getRemito_cab().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getRemito_cab().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("");
		setActivo(new Boolean(true));

		Iterator iterRemitoDet = this.getRemito_cab().getDetalles().iterator();
		while (iterRemitoDet.hasNext()) {
			RemitoDet remitoDet = (RemitoDet) iterRemitoDet.next();
			if (!remitoDet.isActivo().booleanValue())
				continue;
			RemitoDetAnulacion remitoDetAnulacion = (RemitoDetAnulacion) RemitoDetAnulacion.getNew(RemitoDetAnulacion.NICKNAME,
					getSesion());
			remitoDetAnulacion.setRemito_cab_anu(this);
			remitoDetAnulacion.setRemito_det(remitoDet);
			addDetalle(remitoDetAnulacion);
		}

	}
	
	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}
	

}
