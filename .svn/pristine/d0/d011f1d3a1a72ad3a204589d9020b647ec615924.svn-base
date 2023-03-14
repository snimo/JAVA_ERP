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

public class AnuladorRequisicionCab extends ComproCab {
		

	private List detalles = new ArrayList();

	private boolean readDetalle = true;

	private ComproCab comprobante;

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorRequisicionCab() {
	}

	public static String NICKNAME = "cp.AnuladorRequisicionCab";

	private RequisicionCab requisicionCab;

	public RequisicionCab getRequisicionCab() throws BaseException {
		supportRefresh();
		return this.requisicionCab;
	}

	public void setRequisicionCab(RequisicionCab aRequisicionCab) {
		this.requisicionCab = aRequisicionCab;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorRequisicionCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorRequisicionCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorRequisicionCab findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorRequisicionCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
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
			AnuladorRequisicionDet anuladorRequisicionDet = (AnuladorRequisicionDet) iterDetalles.next();
			anuladorRequisicionDet.save();
			anuladorRequisicionDet = null;
		}
		iterDetalles = null;

		afterSaveComprobante(this);

		anularComprobante(getRequisicionCab());

	}

	public void addDetalle(AnuladorRequisicionDet anuladorRequisicionDet)
			throws BaseException {
		this.detalles.add(anuladorRequisicionDet);
		anuladorRequisicionDet.setAnulador_req_cab(this);
	}

	public List getDetalles() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(AnuladorRequisicionDet.getDetalles(this, getSesion()));
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
        Talonario talonarioAnulacion = getRequisicionCab().getTalonario().getTalonarioAnulacion();
        if (talonarioAnulacion==null)
        	throw new ExceptionValidation(null,"No existe talonario de anulación para el talonario "+
        			getRequisicionCab().getTalonario().getDescripcion());        
        setTalonario(talonarioAnulacion);
        setTipoCompro(talonarioAnulacion.getTipo_comprobante());
        setLetra(talonarioAnulacion.getLetra());
        setLugarEmision(talonarioAnulacion.getLugar_emision());
        setNroext(new Integer(0));
        setEmision(Fecha.getFechaActual());
        setImputac(Fecha.getFechaActual());
        setComentario("");
        
		Iterator iterRequisicionDet = this.getRequisicionCab().getRequisicionesDet().iterator();
		while (iterRequisicionDet.hasNext()) {
			RequisicionDet requisicionDet = (RequisicionDet) iterRequisicionDet.next();
			if (requisicionDet.isAnulada().booleanValue()) continue;
			AnuladorRequisicionDet anuladorRequisicionDet = (AnuladorRequisicionDet) 
			   AnuladorRequisicionDet.getNew(AnuladorRequisicionDet.NICKNAME,getSesion());
			anuladorRequisicionDet.setAnulador_req_cab(this);
			anuladorRequisicionDet.setRequisicion_det(requisicionDet);
			addDetalle(anuladorRequisicionDet);
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


}
