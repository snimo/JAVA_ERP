package com.srn.erp.cip.bm;

import java.util.StringTokenizer;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public abstract class PINIEventoBase {

	private PINIAccess response = null;
	private String clavesYValores = null;
	private PINIEngine piniEngine = null;
	private ISesion session;

	public ISesion getSession() {
		return session;
	}

	public void setSession(ISesion session) {
		this.session = session;
	}

	public String getClavesyValores() {
		return this.clavesYValores;
	}

	public PINIEngine getPiniEngine() {
		return piniEngine;
	}

	public void setPiniEngine(PINIEngine piniEngine) {
		this.piniEngine = piniEngine;
	}

	public void setClavesyValores(String aClavesyValores) {
		this.clavesYValores = aClavesyValores;
	}

	public void setPINIAccessResp(PINIAccess aPINIAccess) {
		this.response = aPINIAccess;
	}

	public PINIAccess getPINIAccessResp() {
		return this.response;
	}

	public void run() throws BaseException {
		
			inicializar();
			analizarParams(clavesYValores);
			response.clear();
			internalRun(response);
	}

	public abstract void addParametro(String clave, String valor);
	
	public abstract void inicializar();

	public void analizarParams(String clavesYValores) {
		StringTokenizer descomponer = new StringTokenizer(clavesYValores, ";");
		while (descomponer.hasMoreTokens()) {
			String claveValor = descomponer.nextToken();
			StringTokenizer tokenClaveValor = new StringTokenizer(claveValor, "=");
			int i = 0;
			String clave = "", valor = "";
			while (tokenClaveValor.hasMoreTokens()) {
				String dato = tokenClaveValor.nextToken();
				if (i == 0) {
					clave = dato;
					++i;
				} else if (i == 1) {
					valor = dato;
					++i;
				}
			}
			addParametro(clave, valor);
		}
	}

	public abstract void internalRun(PINIAccess response) throws BaseException;

	private void devolverResponse() {

	}
	
	public void afterEnvioMensaje() {
	}
	

}
