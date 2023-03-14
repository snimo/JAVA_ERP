package com.srn.erp.conciTarjeta.bm;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public abstract class ImpArchCierreLote {
	
	public static String TIPO_POS = "POSNET";
	public static String TIPO_VIS = "VISA";
	
	private String archivo;
	private ISesion sesion;
	private String nombreArchOriginal;
	private Integer oidEmpresa;
	private TerminalConciTar terminal;
	private Integer nroLote;
	private int cantRegImp = 0;
	
	public void incCantRegImp() {
		++cantRegImp;
	}
	
	public int getCantRegImp() {
		return this.cantRegImp;
	}
	
	public void setArchivo(String aArchivo) {
		this.archivo = aArchivo;
	}
	
	public void setTerminal(TerminalConciTar aTerminal) {
		this.terminal = aTerminal;
	}	
	
	public void setNroLote(Integer aNroLote) {
		this.nroLote = aNroLote;
	}
	
	public Integer getNroLote() {
		return this.nroLote;
	}	
	
	public void setOidEmpresa(Integer aOidEmpresa) {
		this.oidEmpresa = aOidEmpresa;
	}
	
	public TerminalConciTar getTerminal() {
		return this.terminal;
	}	
	
	public Integer getOidEmpresa() {
		return this.oidEmpresa;
	}
	
	public void setNombreArchivoOriginal(String aArchivo) {
		this.nombreArchOriginal = aArchivo;
	}	
	
		
	public void setSesion(ISesion aSession) {
		this.sesion = aSession;
	}
	
	public String getArchivo() {
		return this.archivo; 
	}
	
	public ISesion getSesion() {
		return this.sesion;
	}
	
	public void importar() throws BaseException {
		
		
		
	}
	
	private void validaciones() throws BaseException {
		
		if (terminal == null)
			throw new ExceptionValidation(null,"No se pudo determinal a que terminal corresponde el archivo.");
	    		
		EmpresaConciTar empresa =
			EmpresaConciTar.findByOidProxy(oidEmpresa, this.getSesion());
		
		if (empresa == null)
			throw new ExceptionValidation(null,"Debe seleccionar una empresa para poder operar.");	
		
		if (terminal.getUni_neg().getEmpresa().getOID()!=empresa.getOID())
			throw new ExceptionValidation(null,"El archivo seleccionado no corresponde a la empresa seleccionada.");
		
	}
	
	public static ImpArchCierreLote getNewImportador(String tipo) {
		if (tipo.equals(TIPO_POS))
			return new ImpArchCierreLotePOSNET();
		else
			return null;
	}
	
	public void comenzar() throws BaseException {
		String mensError = "";
		try {
			this.validaciones();
			this.importar();
		} catch (Exception e) {
			mensError = e.getMessage();
			try {this.getSesion().rollBackTransaction();} catch(Exception e1) {};
			grabarErrorArchivo(mensError);
			try {this.getSesion().commitTransaction();} catch(Exception e2) {};
			if (!mensError.equals(""))
				throw new ExceptionValidation(null,mensError);
		}
	}
	
	protected void grabarErrorArchivo(String error) throws BaseException {
		
	}
	
	public static String getUltCarpeta(String archivo) throws BaseException {
		int sep = archivo.lastIndexOf("\\");
		String path = archivo.substring(0, sep);
		int sep1 = path.lastIndexOf("\\");
		path = path.substring(sep1+1, path.length());
		return path;
	}
	
	public abstract Integer getOidArchLoteCab();
	
}
