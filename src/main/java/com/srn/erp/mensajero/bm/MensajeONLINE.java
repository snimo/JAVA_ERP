package com.srn.erp.mensajero.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import framework.request.bl.Utils.BaseException;

public class MensajeONLINE {
	
	private int tipoMensaje = 0;
	private String mensaje = null;
	private boolean todos = false;
	private String idImagen = "";
	private int idSonido = 0;
	private boolean eliminar = false; 
	public long inicioEnMilisecod = 0;
	private String pathSonido;
	private String pathImagen;
	private int imagenAlto;
	private int imagenAncho;
	private String formulario;
	private Integer oidObjNeg;
	private String externalCall;
	
	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}
	
	public String getExternalCall() {
		return this.externalCall;
	}

	public void setExternalCall(String aExternalCall) {
		this.externalCall = aExternalCall;
	}	

	public Integer getOidObjNeg() {
		return oidObjNeg;
	}

	public void setOidObjNeg(Integer oidObjNeg) {
		this.oidObjNeg = oidObjNeg;
	}

	public String getPathSonido() {
		return pathSonido;
	}

	public int getImagenAlto() {
		return imagenAlto;
	}

	public void setImagenAlto(int imagenAlto) {
		this.imagenAlto = imagenAlto;
	}

	public int getImagenAncho() {
		return imagenAncho;
	}

	public void setImagenAncho(int imagenAncho) {
		this.imagenAncho = imagenAncho;
	}

	public void setPathSonido(String pathSonido) {
		this.pathSonido = pathSonido;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	private List usuarios = new ArrayList();
	private List maquinas = new ArrayList();
	private List nodoProcesado = new ArrayList();
	
	public static final int TM_ONLINE = 1; // 
	
	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public  static MensajeONLINE getNewMensajeONLINE(
			int aTipoMensaje , 
			String mensaje , 
			List usuarios  , 
			List maquinas , 
			boolean aTodos , 
			String idImagen , 
			String pathImagen,
			int alto,
			int ancho,
			int idSonido,
			String pathSonido,
			String formulario,
			Integer oidObjNeg,
			String externalCall) throws BaseException  {
		
		MensajeONLINE mensajeOL = new MensajeONLINE();
		mensajeOL.tipoMensaje = aTipoMensaje;
		mensajeOL.mensaje = mensaje;
		mensajeOL.todos = aTodos;
		mensajeOL.idImagen = idImagen;
		mensajeOL.idSonido = idSonido;
		java.util.Date fecha = new Date();
		mensajeOL.inicioEnMilisecod = (new Date()).getTime();
		mensajeOL.setPathSonido(pathSonido);
		mensajeOL.setPathImagen(pathImagen);
		mensajeOL.setImagenAlto(alto);
		mensajeOL.setImagenAncho(ancho);
		mensajeOL.setFormulario(formulario);
		mensajeOL.setOidObjNeg(oidObjNeg);
		mensajeOL.setExternalCall(externalCall);
		
		mensajeOL.cargarUsuarios(usuarios);
		mensajeOL.cargarMaquinas(maquinas);
				
		return mensajeOL;
		
	}
	
	public long getAntiguedadEnSeg() {
		double seg = ((new Date()).getTime() - inicioEnMilisecod)/1000;
		return Math.round(seg);
	}
	
	private void cargarUsuarios(List usuarios) throws BaseException {
		if (usuarios == null) return;
		Iterator iterUsuarios = 
			usuarios.iterator();
		while (iterUsuarios.hasNext()) {
			String usuario = (String) iterUsuarios.next();
			this.usuarios.add(usuario);
		}
	}
	
	private void cargarMaquinas(List maquinas) throws BaseException {
		if (maquinas == null) return;
		Iterator iterMaquinas = 
			maquinas.iterator();
		while (iterMaquinas.hasNext()) {
			String maquina = (String) iterMaquinas.next();
			this.maquinas.add(maquina);
		}
	}
	
	
	public void addUsuario(String aUsuario) {
		this.usuarios.add(aUsuario.toUpperCase());
	}
	
	public void addMaquina(String aMaquina) {
		this.maquinas.add(aMaquina.toUpperCase());
	}
	
	public String getMensaje() {
		return this.mensaje;
	}
	
	public boolean hasUsuario(String usuario) {
		if (usuarios.contains(usuario))
			return true;
		else
			return false;
	}
	
	public boolean hasMaquina(String maquina) {
		if (maquinas.contains(maquina))
			return true;
		else
			return false;
	}
	
	public synchronized void addNodoProcesado(String aNodoProcesado) {
		this.nodoProcesado.add(aNodoProcesado);
	}
	
	public boolean isNodoProcesado(String aNodo) {
		return nodoProcesado.contains(aNodo);
	}
	
	public Integer getIdSonido() {
		return this.idSonido;
	}
	
	public String getIdImagen() {
		return this.idImagen;
	}
	
	
}
