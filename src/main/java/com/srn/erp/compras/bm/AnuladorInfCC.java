package com.srn.erp.compras.bm;

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

public class AnuladorInfCC extends ComproCab implements IContabilizable,
		IStockeable {

	private List detalles = new ArrayList();

	private boolean readDetalle = true;

	private ComproCab comprobante;

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorInfCC() {
	}

	public static String NICKNAME = "cp.AnuladorInfCC";

	private InformeControlCalidad control_calidad;

	public InformeControlCalidad getControl_calidad() throws BaseException {
		supportRefresh();
		return control_calidad;
	}

	public void setControl_calidad(InformeControlCalidad aControl_calidad) {
		this.control_calidad = aControl_calidad;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorInfCC findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorInfCC) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorInfCC findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorInfCC) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		beforeSaveComprobante(this);
		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
		}

	}

	public void afterSave() throws BaseException {

		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			AnuladorInfCCDet anuladorInfCCDet = (AnuladorInfCCDet) iterDetalles
					.next();
			anuladorInfCCDet.save();
			anuladorInfCCDet = null;
		}
		iterDetalles = null;

		afterSaveComprobante(this);

		anularComprobante(getControl_calidad());

	}

	public void addDetalle(AnuladorInfCCDet anuladorInfCCDet)
			throws BaseException {
		this.detalles.add(anuladorInfCCDet);
		anuladorInfCCDet.setAnulador_inf_cc(this);
	}

	public List getDetalles() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(AnuladorInfCCDet
					.getDetalles(this, getSesion()));
			readDetalle = false;
		}
		return detalles;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}
	
	public void generarComproAnulacion() throws BaseException {
		
        // Set datos del comrobante
        setContabiliza(true);
        Talonario talonarioAnulacion = getControl_calidad().getTalonario().getTalonarioAnulacion();
        if (talonarioAnulacion==null)
        	throw new ExceptionValidation(null,"No existe talonario de anulación para el talonario "+
        			getControl_calidad().getTalonario().getDescripcion());        
        setTalonario(talonarioAnulacion);
        setTipoCompro(talonarioAnulacion.getTipo_comprobante());
        setLetra(talonarioAnulacion.getLetra());
        setLugarEmision(talonarioAnulacion.getLugar_emision());
        setNroext(new Integer(0));
        setEmision(Fecha.getFechaActual());
        setImputac(Fecha.getFechaActual());
        setComentario("");
        
		Iterator iterDetInfCC = getControl_calidad().getDetallesInfCC().iterator();
		while (iterDetInfCC.hasNext()) {
			InformeControlCalidadDet infCCDet = (InformeControlCalidadDet) iterDetInfCC.next();
			if (infCCDet.isAnulado().booleanValue()) continue;
			AnuladorInfCCDet anuladorInfCCDet = (AnuladorInfCCDet) AnuladorInfCCDet.getNew(AnuladorInfCCDet.NICKNAME,getSesion());
			anuladorInfCCDet.setAnulador_inf_cc(this);
			anuladorInfCCDet.setDetalle_inf_cc(infCCDet);
			addDetalle(anuladorInfCCDet);
		}        
                
        
	}

	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();
		setActivo(new Boolean(true));
		setEstado(ComproCab.ESTADO_ALTA);
	}

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return getImputac();
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		// La anulacion la realiza automaticamente el comprobante padre
		return null;
	}
	
	public RenglonesStock getRenglonesStock() throws BaseException {
	  return getControl_calidad().getStockCabecera().getRenglonesStockInvertidos(this);
	}	
	

}
