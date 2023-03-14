package com.srn.erp.conciTarjeta.bm;

import java.util.List;

import com.srn.erp.conciTarjeta.da.DBArcImpErrorPOSNET;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ArcImpErrorPOSNET extends ObjetoLogico {
	
	public static final String TIPO_ARCH_POSNET = "POSNET";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArcImpErrorPOSNET() {
	}

	public static String NICKNAME = "ctar.ArcImpErrorPOSNET";

	private String tipo_arch;
	private java.util.Date fecha;
	private String hora;
	private String carpeta;
	private String nombre_archivo;
	private TerminalConciTar terminal;
	private EmpresaConciTar empresa;
	private String problema;
	private Boolean activo;

	public String getTipo_arch() throws BaseException {
		supportRefresh();
		return tipo_arch;
	}

	public void setTipo_arch(String aTipo_arch) {
		this.tipo_arch = aTipo_arch;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public String getHora() throws BaseException {
		supportRefresh();
		return hora;
	}

	public void setHora(String aHora) {
		this.hora = aHora;
	}

	public String getCarpeta() throws BaseException {
		supportRefresh();
		return carpeta;
	}

	public void setCarpeta(String aCarpeta) {
		this.carpeta = aCarpeta;
	}

	public String getNombre_archivo() throws BaseException {
		supportRefresh();
		return nombre_archivo;
	}

	public void setNombre_archivo(String aNombre_archivo) {
		this.nombre_archivo = aNombre_archivo;
	}

	public TerminalConciTar getTerminal() throws BaseException {
		supportRefresh();
		return terminal;
	}

	public void setTerminal(TerminalConciTar aTerminal) {
		this.terminal = aTerminal;
	}

	public EmpresaConciTar getEmpresa() throws BaseException {
		supportRefresh();
		return empresa;
	}

	public void setEmpresa(EmpresaConciTar aEmpresa) {
		this.empresa = aEmpresa;
	}

	public String getProblema() throws BaseException {
		supportRefresh();
		return problema;
	}

	public void setProblema(String aProblema) {
		this.problema = aProblema;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ArcImpErrorPOSNET findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ArcImpErrorPOSNET) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ArcImpErrorPOSNET findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ArcImpErrorPOSNET) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tipo_arch, "Debe ingresar el Tipo de Archivo");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
		Validar.noNulo(hora, "Debe ingresar la Hora");
		Validar.noNulo(carpeta, "Debe ingresar la carpeta");
		Validar.noNulo(nombre_archivo, "Debe ingresar el Nombre de Archivo");
		Validar.noNulo(terminal, "Debe ingresar la Terminal");
		Validar.noNulo(empresa, "Debe ingresar la Empresa");
	}
	
	  public static List getArchImpoConErrores(
			  java.util.Date fecDesde,
			  java.util.Date fecHasta,
			  EmpresaConciTar empresa,
			  String tipoArchivo,
	          ISesion aSesion) throws BaseException {
		  return DBArcImpErrorPOSNET.getArchImpoConErrores(fecDesde,fecHasta,empresa,tipoArchivo,aSesion);
	  }  
	

}
