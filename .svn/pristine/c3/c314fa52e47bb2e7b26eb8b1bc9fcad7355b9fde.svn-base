package com.srn.erp.bancos.bm;

import java.util.Date;

import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class ComproConciliacionBcoDia extends ComproCab implements
		IContabilizable {

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getCodigo();
	}
	
	RenglonesAsiento renglonesAsiento;

	private ComproCab comprobante;

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		// TODO Auto-generated method stub
		return renglonesAsiento;
	}
	
	public void setRenglonesAsiento(RenglonesAsiento aRenglonesAsiento) throws BaseException {
		this.renglonesAsiento = aRenglonesAsiento;
	}

	public ComproConciliacionBcoDia() {
	}

	public static String NICKNAME = "ba.ComproConciliacionBcoDia";

	public void beforeSave() throws BaseException {

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}

		beforeSaveComprobante(this);

	}

	public void afterSave() throws BaseException {

		afterSaveComprobante(this);
	}

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getImputac();
	}
	
	public static ComproConciliacionBcoDia findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ComproConciliacionBcoDia) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public static ComproConciliacionBcoDia findByOidCompro(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproConciliacionBcoDia) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static ComproConciliacionBcoDia findByOidComproProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproConciliacionBcoDia) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	
	public static Talonario getTalonarioAsientoConciliacion(ISesion aSesion) throws BaseException {
	   return Talonario.getTalonatioAsientoConciliacionBanco(aSesion);
	}
	

}
