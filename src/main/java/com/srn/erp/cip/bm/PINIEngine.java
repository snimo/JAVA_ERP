package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class PINIEngine {

	
	private String pkt;
	private String seccion = "";
	private PINIAccess response = null;
	private HashTableDatos eventos = new HashTableDatos();
	private HashTableDatos claves = new HashTableDatos();
	private int puertoPlacaTeleComandos = 0;
	private ISesion session;
	private int idEquipo = -1;
		
	public ISesion getSession() {
		return session;
	}

	public void setSession(ISesion session) {
		this.session = session;
	}

	public PINIEngine() {
		initEventos();
	}
	
	public static final String STATUS_OK = "STATUS_OK";
	public static final String STATUS = "STATUS";
	public static final String HELLO = "HELLO";
	public static final String VALIDATE = "VALIDATE";
	public static final String SYNCRONIZATION = "SYNCRONIZATION";
	public static final String GETCONFIG = "GETCONFIG";
	public static final String GETCONFIGPOINT = "GETCONFIGPOINT";
	public static final String UPGRADELIST = "UPGRADELIST";
	public static final String GETLISTFIRST = "GETLISTFIRST";
	public static final String GETLISTNEXT = "GETLISTNEXT";
	public static final String TRANSACTION = "TRANSACTION";
	
	
	private void initEventos() {
		eventos.put(STATUS, new PINIEventoStatus());
		eventos.put(HELLO, new PINIEventoHELLO());
		eventos.put(STATUS_OK, new PINIEventoStatusOK());
		eventos.put(VALIDATE, new PINIEventoValidate());
		eventos.put(SYNCRONIZATION, new PINIEventoSincronizacion());
		eventos.put(GETCONFIGPOINT, new PINIEventoGetConfigPoint());
		eventos.put(GETCONFIG, new PINIEventoGetConfig());
		eventos.put(UPGRADELIST, new PINIUpgradeList());
		eventos.put(GETLISTFIRST, new PINIEventoGetListFirst());
		eventos.put(GETLISTNEXT, new PINIEventoGetListNext());
		eventos.put(TRANSACTION, new PINIEventoTransaction());
		
	}

	public void setPKT(String aPKT) {
		this.pkt = aPKT;
	}
	
	public Integer getPuertoPlacaTeleComandos() {
		return puertoPlacaTeleComandos;
	}

	public void setPuertoPlacaTeleComandos(Integer puertoPlacaTeleComandos) {
		this.puertoPlacaTeleComandos = puertoPlacaTeleComandos;
	}

	public void setPINIAccess(PINIAccess aResponse) {
		aResponse.clear();
		this.response = aResponse;
	}

	private void analizarSeccion() {
		if (pkt == null)
			seccion = "";
		try {
			seccion = pkt.substring(2, pkt.indexOf(']'));
		} catch(Exception e) {
			seccion = "";
		}
	}

	public String getSeccion() {
		return this.seccion;
	}

	public void run() throws BaseException {
		analizarSeccion();
		dispararEvento();
	}
	
	private void grabarLog(Integer idEquipo,java.util.Date fecha,String log) throws BaseException {
		LogMensajeCIP logMensCIP = 
			(LogMensajeCIP)LogMensajeCIP.getNew(LogMensajeCIP.NICKNAME, this.getSession());
		logMensCIP.setFec_hor(fecha);
		logMensCIP.setId_equipo(idEquipo);
		logMensCIP.setMensaje(log);
		logMensCIP.setActivo(true);
		logMensCIP.save();
	}
	
	private void dispararEvento() throws BaseException {
		
		if ((pkt!=null) && (ActLogsMens.isActivado(this.getSession())))
			grabarLog(this.idEquipo,UtilCIP.getFechaHoraActual(this.getSession()),pkt);			
		
		PINIEventoBase piniEvento = (PINIEventoBase) eventos.get(this.getSeccion());
		
		if (piniEvento == null){
//			System.out.println("mensaje no encontrado" + pkt + "\n");
			piniEvento = (PINIEventoBase) eventos.get(STATUS_OK);
		}
		
		piniEvento.setSession(this.getSession());
		piniEvento.setPiniEngine(this);
		piniEvento.setPINIAccessResp(this.response);
		piniEvento.setClavesyValores(getCadenaClaveValor());
		piniEvento.run();
		
		if ((pkt!=null) && (ActLogsMens.isActivado(this.getSession())))
			grabarLog(this.idEquipo,UtilCIP.getFechaHoraActual(this.getSession()),this.response.getPKT());			
		
		
		try {
			if (this.getSession()!=null)
				this.getSession().commitTransaction();
		} catch(Exception e) {
			if (this.getSession()!=null)
				this.getSession().rollBackTransaction();			
		}
			
	}
	
	private String getCadenaClaveValor() {
		String analizar = pkt.replace("["+seccion+"]", "");
		analizar = analizar.replaceFirst("<", "");
		analizar = analizar.replace(">", "");
		return analizar;
	}
	
	public void setIDEquipo(int aIDEquipos) throws BaseException {
		this.idEquipo = aIDEquipos;
	}
	
	public void afterEnvioMensaje() {
		PINIEventoBase piniEvento = (PINIEventoBase) eventos.get(this.getSeccion());
		if (piniEvento == null)
			piniEvento = (PINIEventoBase) eventos.get(STATUS_OK);
		piniEvento.afterEnvioMensaje();
		
	}

	
}
