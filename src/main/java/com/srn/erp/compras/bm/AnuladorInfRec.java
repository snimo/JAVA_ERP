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

public class AnuladorInfRec extends ComproCab implements IContabilizable  , IStockeable {

	private List detalles = new ArrayList();
	private boolean readDetalle = true;

	private ComproCab comprobante;

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorInfRec() {
	}

	public static String NICKNAME = "cp.AnuladorInfRec";

	private InformeRecepcion informe_recepcion;

	public InformeRecepcion getInforme_recepcion() throws BaseException {
		supportRefresh();
		return informe_recepcion;
	}

	public void setInforme_recepcion(InformeRecepcion aInforme_recepcion) {
		this.informe_recepcion = aInforme_recepcion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorInfRec findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorInfRec) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorInfRec findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorInfRec) getObjectByOidProxy(NICKNAME, oid, aSesion);
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

	public void afterSave() throws BaseException {
		
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			AnuladorInfRecDet anuladorInfRecDet = (AnuladorInfRecDet) iterDetalles
					.next();
			anuladorInfRecDet.save();
			anuladorInfRecDet = null;
		}
		iterDetalles = null;

		afterSaveComprobante(this);
		
		anularComprobante(getInforme_recepcion());
		
		
	}

	public void addDetalle(AnuladorInfRecDet anuladorInfRecDet)
			throws BaseException {
		this.detalles.add(anuladorInfRecDet);
		anuladorInfRecDet.setAnulador_inf_rec(this);
	}

	public List getDetalles() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(AnuladorInfRecDet
					.getDetAnuInfRec(this, getSesion()));
			readDetalle = false;
		}
		return detalles;
	}
	
	public void generarComproAnulacion() throws BaseException {
		
        // Set datos del comrobante
        setContabiliza(true);
        Talonario talonarioAnulacion = getInforme_recepcion().getTalonario().getTalonarioAnulacion();
        if (talonarioAnulacion==null)
        	throw new ExceptionValidation(null,"No existe talonario de anulación para el talonario "+
        										getInforme_recepcion().getTalonario().getDescripcion());        
        setTalonario(talonarioAnulacion);
        setTipoCompro(talonarioAnulacion.getTipo_comprobante());
        setLetra(talonarioAnulacion.getLetra());
        setLugarEmision(talonarioAnulacion.getLugar_emision());
        setNroext(new Integer(0));
        setEmision(Fecha.getFechaActual());
        setImputac(Fecha.getFechaActual());
        
        String comentario = "Por anulación de "+this.getInforme_recepcion().getCodigo();
        setComentario(comentario);
        
		Iterator iterDetInfRec = getInforme_recepcion().getDetallesInfRec().iterator();
		while (iterDetInfRec.hasNext()) {
			InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterDetInfRec.next();
			if (infRecDet.isAnulado().booleanValue()) continue;
			AnuladorInfRecDet anuladorInfRecDet = (AnuladorInfRecDet) AnuladorInfRecDet.getNew(AnuladorInfRecDet.NICKNAME,getSesion());
			anuladorInfRecDet.setAnulador_inf_rec(this);
			anuladorInfRecDet.setInf_rec_det(infRecDet);
			addDetalle(anuladorInfRecDet);
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
		// TODO Auto-generated method stub
		//return getInforme_recepcion().getComproConta().getRenglonesAsientoInvertidos();
		return null;
	}
	
	public RenglonesStock getRenglonesStock() throws BaseException {
	  return getInforme_recepcion().getStockCabecera().getRenglonesStockInvertidos(this);
	}	
	
	

}
