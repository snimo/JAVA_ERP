package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBLogImpDatosCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class LogImpDatosCIP extends ObjetoLogico {

	public static final String TIPO_IMP_HIP = "HIPO";
	
	public LogImpDatosCIP() {
	}

	public static String NICKNAME = "cip.LogImpDatosCIP";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private String tipo_imp;
	private java.util.Date fecha;
	private String hora;
	private Boolean se_ejecuto;
	private Boolean hubo_error;
	private String mot_no_ejecuto;
	private String observacion;
	private String desc_error;
	private Boolean activo;

	public String getTipo_imp() throws BaseException {
		supportRefresh();
		return tipo_imp;
	}

	public void setTipo_imp(String aTipo_imp) {
		this.tipo_imp = aTipo_imp;
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

	public Boolean isSe_ejecuto() throws BaseException {
		supportRefresh();
		return se_ejecuto;
	}

	public void setSe_ejecuto(Boolean aSe_ejecuto) {
		this.se_ejecuto = aSe_ejecuto;
	}

	public Boolean isHubo_error() throws BaseException {
		supportRefresh();
		return hubo_error;
	}

	public void setHubo_error(Boolean aHubo_error) {
		this.hubo_error = aHubo_error;
	}

	public String getMot_no_ejecuto() throws BaseException {
		supportRefresh();
		return mot_no_ejecuto;
	}

	public void setMot_no_ejecuto(String aMot_no_ejecuto) {
		this.mot_no_ejecuto = aMot_no_ejecuto;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public String getDesc_error() throws BaseException {
		supportRefresh();
		return desc_error;
	}

	public void setDesc_error(String aDesc_error) {
		this.desc_error = aDesc_error;
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

	public static LogImpDatosCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (LogImpDatosCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static LogImpDatosCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (LogImpDatosCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tipo_imp, "Debe el tipo de Importación");
		Validar.noNulo(fecha, "Debe ingresar la fecha");
	}
	
	public static void borrarLogsAntiguos(
			java.util.Date fecha,
		    ISesion aSesion)
		  throws BaseException {
			 DBLogImpDatosCIP.borrarLogsAntiguos(fecha,aSesion);
	}
	
	  public static void insLogs(
			  String tipoImportacion,
			  boolean seEjecuto,boolean huboError,
			  String motivoNoEjecuto,String observacion,String descError , ISesion aSesion) throws BaseException {

		  DBLogImpDatosCIP.insLogs(tipoImportacion, seEjecuto, huboError, motivoNoEjecuto, observacion, descError, aSesion);
		  
	  }
	  
		public static List getAll(ISesion aSesion) throws BaseException {
			  return DBLogImpDatosCIP.getAll(aSesion);
		}
	  
	
	

}
