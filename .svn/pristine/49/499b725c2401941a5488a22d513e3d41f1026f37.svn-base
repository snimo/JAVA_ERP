package com.srn.erp.conciTarjeta.bm;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public abstract class ImpArchCobTar {
	
	protected ISesion session;
	protected String archivo;
	protected CabTarConciEnt cabTarConciEnt;
	protected int cantRegImp = 0;
	
	protected void incrementarCantRegImp() {
		++cantRegImp;
	}
	
	public int getCantRegImp() {
		return cantRegImp; 
	}
	
	public void setCabTarConciEnt(CabTarConciEnt aCabTarConciEnt) throws BaseException {
		cabTarConciEnt = aCabTarConciEnt;
	}
	
	public CabTarConciEnt getTarConciEnt() throws BaseException {
		return cabTarConciEnt;
	}
	
	public void setSession(ISesion session) {
		this.session = session;
	}
	
	public ISesion getSession() {
		return session;
	}
	
	public void setArchivo(String aArchivo) {
		this.archivo = aArchivo;
	}
	
	public abstract void importar() throws BaseException ;
	
	public static ImpArchCobTar getImpArchCobTar(String tipo) {
		if (tipo.equals(TipoArchivoConciliacion.TA_VISA))
			return new ImpArchVISACobTar();
		else if (tipo.equals(TipoArchivoConciliacion.TA_MASTER))
				return new ImpArchMASTCobTar();
			else if (tipo.equals(TipoArchivoConciliacion.TA_AME))
				return new ImpArchAMECobTar();
			else 
				return null;
	}
	
	
	

}
