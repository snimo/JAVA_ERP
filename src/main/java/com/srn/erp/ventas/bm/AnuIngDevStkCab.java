package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.RenglonesStock;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class AnuIngDevStkCab extends ComproCab implements IStockeable {

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

	public AnuIngDevStkCab() {
	}

	public static String NICKNAME = "ve.AnuIngDevStkCab";

	private IngresoDevolucionStockCab ingreso_devolucion_stk_cab;

	public IngresoDevolucionStockCab getIngreso_devolucion_stk_cab() throws BaseException {
		supportRefresh();
		return ingreso_devolucion_stk_cab;
	}

	public void setIngreso_devolucion_stk_cab(IngresoDevolucionStockCab aIngreso_devolucion_stk_cab) {
		this.ingreso_devolucion_stk_cab = aIngreso_devolucion_stk_cab;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuIngDevStkCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuIngDevStkCab) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static AnuIngDevStkCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuIngDevStkCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static AnuIngDevStkCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AnuIngDevStkCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
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
	
	public RenglonesStock getRenglonesStock() throws BaseException {
		if (this.getIngreso_devolucion_stk_cab().getStockCabecera()==null)
			return null;
		else
			return this.getIngreso_devolucion_stk_cab().getStockCabecera().getRenglonesStockInvertidos(this);
	}
	
	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return getImputac();
	}

	public void afterSave() throws BaseException {

		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			AnuIngDevStkDet anuladorDevolucionDet = (AnuIngDevStkDet) iterDetalles.next();
			anuladorDevolucionDet.save();
			anuladorDevolucionDet = null;
		}
		
		iterDetalles = null;
		afterSaveComprobante(this);
		anularComprobante(this);

	}

	public void addDetalle(AnuIngDevStkDet anulacionDet) throws BaseException {
		this.detalles.add(anulacionDet);
		anulacionDet.setAnulacion_ing_dev_stk(this);
	}
	
	public void generarComproAnulacion() throws BaseException {
		
		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getIngreso_devolucion_stk_cab().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
												+ this.getIngreso_devolucion_stk_cab().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("Anulación Devolución " + this.getIngreso_devolucion_stk_cab().getCodigo());
		setActivo(new Boolean(true));
		setActuStock(true);
		
		Iterator iterDetallesDev = 
			this.getIngreso_devolucion_stk_cab().getDetallesDev().iterator();
		while (iterDetallesDev.hasNext()) {
			IngStockDevVtasDet ingDevVtasDet = (IngStockDevVtasDet) iterDetallesDev.next();
			
			AnuIngDevStkDet anulacionDevDet =
				(AnuIngDevStkDet) AnuIngDevStkDet.getNew(AnuIngDevStkDet.NICKNAME, this.getSesion());
			anulacionDevDet.setAnulacion_ing_dev_stk(this);
			anulacionDevDet.setIngreso_dev_stk_det(ingDevVtasDet);
			
			this.addDetalle(anulacionDevDet);
			
		}

	}

	
	
	

}
