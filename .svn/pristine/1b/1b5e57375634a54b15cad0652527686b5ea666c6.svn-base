package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;

public class SemaforoImpAllHipo {

	private boolean importando = false;
	private static SemaforoImpAllHipo semaforo = null;
	
	public static synchronized SemaforoImpAllHipo getSemaforo() throws BaseException {
		if (SemaforoImpAllHipo.semaforo == null)
			SemaforoImpAllHipo.semaforo = new SemaforoImpAllHipo();
		return semaforo;
	}
	
	public synchronized boolean estaImportando() throws BaseException {
		return this.importando;
	}
	
	public synchronized void bloquear() throws BaseException {
		this.importando = true;
	}

	public synchronized void Desbloquear() throws BaseException {
		this.importando = false;
	}
	
}
