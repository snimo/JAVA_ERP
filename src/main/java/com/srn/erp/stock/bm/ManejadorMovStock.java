package com.srn.erp.stock.bm;

import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class ManejadorMovStock implements IStockeable {

	ComproCab comproCab;
	ISesion sesion;
	
	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this.comproCab;
	}
	
	public ComproCab getComproCab() throws BaseException {
		return this.comproCab;
	}
	
	public void setComproCab(ComproCab aComproCab) throws BaseException {
		this.comproCab = aComproCab;
	}
	

	public RenglonesStock getRenglonesStock() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setSesion(ISesion aSesion) throws BaseException {
		this.sesion = aSesion;
	}
	
	public ISesion getSesion() throws BaseException {
		return this.sesion;
	}

}
