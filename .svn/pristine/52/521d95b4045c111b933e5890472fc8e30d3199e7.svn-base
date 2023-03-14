package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.pagos.bm.AnuladorRendFFComproProv;
import com.srn.erp.pagos.bm.AnuladorRendFFValores;
import com.srn.erp.pagos.bm.RendicionFondoFijoCompro;
import com.srn.erp.pagos.bm.RendicionFondoFijoMedioPago;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AnulacionDevolucionCab extends ComproCab {

	private ComproCab comprobante;

	private List detalles = new ArrayList();
	private boolean readDetalle = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnulacionDevolucionCab() {
	}

	public static String NICKNAME = "ve.AnulacionDevolucionCab";

	private DevolucionVtasCab devolucion_cab;

	public DevolucionVtasCab getDevolucion_cab() throws BaseException {
		supportRefresh();
		return devolucion_cab;
	}

	public void setDevolucion_cab(DevolucionVtasCab aDevolucion_cab) {
		this.devolucion_cab = aDevolucion_cab;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnulacionDevolucionCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnulacionDevolucionCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnulacionDevolucionCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AnulacionDevolucionCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static AnulacionDevolucionCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AnulacionDevolucionCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(devolucion_cab, "Debe ingresar la Devolución Ventas ");
		beforeSaveComprobante(this);
		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
		}

	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return getImputac();
	}

	public void afterSave() throws BaseException {

		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			AnulacionDevolucionDet anuladorDevolucionDet = (AnulacionDevolucionDet) iterDetalles.next();
			anuladorDevolucionDet.save();
			anuladorDevolucionDet = null;
		}
		
		iterDetalles = null;
		afterSaveComprobante(this);
		anularComprobante(this);

	}

	public void addDetalle(AnulacionDevolucionDet anulacionRequisicionDet) throws BaseException {
		this.detalles.add(anulacionRequisicionDet);
		anulacionRequisicionDet.setAnulador_devolucion_cab(this);
	}
	
	public void generarComproAnulacion() throws BaseException {
		
		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getDevolucion_cab().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
												+ this.getDevolucion_cab().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("Anulación Devolución " + this.getDevolucion_cab().getCodigo());
		setActivo(new Boolean(true));
		
		Iterator iterDetallesDev = 
			this.getDevolucion_cab().getDetallesDev().iterator();
		while (iterDetallesDev.hasNext()) {
			DevolucionVtasDet devVtasDet = (DevolucionVtasDet) iterDetallesDev.next();
			devVtasDet.validarTenenciaAplicacionesStk();
			
			AnulacionDevolucionDet anulacionDevDet =
				(AnulacionDevolucionDet) AnulacionDevolucionDet.getNew(AnulacionDevolucionDet.NICKNAME, this.getSesion());
			anulacionDevDet.setAnulador_devolucion_cab(this);
			anulacionDevDet.setDevolucion_det(devVtasDet);
			
			
			
			this.addDetalle(anulacionDevDet);
			
		}

	}
	

}
