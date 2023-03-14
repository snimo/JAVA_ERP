package com.srn.erp.schedule.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TriggerSchedule extends ObjetoLogico {

	public TriggerSchedule() {
	}

	public static String NICKNAME = "sc.TriggerSchedule";

	private String codigo;
	private String descripcion;
	private String tipo;
	private Boolean activo;
	private Integer hora;
	private Integer minutos;
	private Integer segundos;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}
	
	public Integer getSegundos() throws BaseException {
		supportRefresh();
		if (segundos!=null)
			return segundos;
		else
			return 0;
	}
	

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public void setSegundos(Integer aSegundos) {
		this.segundos = aSegundos;
	}
	

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Integer getHora() throws BaseException {
		supportRefresh();
		return hora;
	}

	public void setHora(Integer aHora) {
		this.hora = aHora;
	}

	public Integer getMinutos() throws BaseException {
		supportRefresh();
		return minutos;
	}

	public void setMinutos(Integer aMinutos) {
		this.minutos = aMinutos;
	}

	@Override
	public void afterSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveDelete();
		AdministradorSchedule.programarJobs(this.getSesion().getServicios(),this.getSesion());
	}

	@Override
	public void afterSaveModified() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveModified();
		AdministradorSchedule.programarJobs(this.getSesion().getServicios(),this.getSesion());
	}

	@Override
	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		AdministradorSchedule.programarJobs(this.getSesion().getServicios(),this.getSesion());
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TriggerSchedule findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TriggerSchedule) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TriggerSchedule findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TriggerSchedule) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TriggerSchedule findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TriggerSchedule) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(tipo, "Debe ingresar el Tipo");

	}

	
}
