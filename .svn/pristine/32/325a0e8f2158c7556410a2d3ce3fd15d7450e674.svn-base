package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBRemplazoAcumLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RemplazoAcumLeg extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RemplazoAcumLeg() {
	}

	public static String NICKNAME = "rh.RemplazoAcumLeg";

	private Legajo legajo;
	private String periodo;
	private Integer horas_acum;
	private String observacion;
	private Boolean activo;

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public String getPeriodo() throws BaseException {
		supportRefresh();
		return periodo;
	}

	public void setPeriodo(String aPeriodo) {
		this.periodo = aPeriodo;
	}

	public Integer getHoras_acum() throws BaseException {
		supportRefresh();
		return horas_acum;
	}

	public void setHoras_acum(Integer aHoras_acum) {
		this.horas_acum = aHoras_acum;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
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

	public static RemplazoAcumLeg findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RemplazoAcumLeg) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RemplazoAcumLeg findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RemplazoAcumLeg) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "su.Legajo");
		Validar.noNulo(periodo, "Debe ingresar el Período");
		Validar.noNulo(horas_acum, "Debe ingresar las Horas");
	}

	public static int eliminarRemplazosPeriodo(String periodo, ISesion aSesion) throws BaseException {
		return DBRemplazoAcumLeg.eliminarRemplazosPeriodo(periodo, aSesion);
	}

	public static RemplazoAcumLeg getRemplazoAcumLeg(Legajo legajo, String periodo, ISesion aSesion) throws BaseException {
		return DBRemplazoAcumLeg.getRemplazoAcumLeg(legajo, periodo, aSesion);
	}
	
	public static List getRemplazosAcumLeg(
			 String periodo,
          	 ISesion aSesion) throws BaseException {
		return DBRemplazoAcumLeg.getRemplazosAcumLeg(periodo,aSesion);
	}
	
	public static List getRemplazosAcumEnPeriodos(List periodos, ISesion aSesion) throws BaseException {
		return DBRemplazoAcumLeg.getRemplazosAcumEnPeriodos(periodos,aSesion);
	}	

}
