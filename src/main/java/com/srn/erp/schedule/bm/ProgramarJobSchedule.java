package com.srn.erp.schedule.bm;

import java.util.List;

import com.srn.erp.schedule.da.DBProgramarJobSchedule;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ProgramarJobSchedule extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ProgramarJobSchedule() {
	}

	public static String NICKNAME = "sc.ProgramarJobSchedule";

	private Integer orden;
	private JobSchedule job;
	private TriggerSchedule trigger;
	private Boolean activo;

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public JobSchedule getJob() throws BaseException {
		supportRefresh();
		return job;
	}

	public void setJob(JobSchedule aJob) {
		this.job = aJob;
	}

	public TriggerSchedule getTrigger() throws BaseException {
		supportRefresh();
		return trigger;
	}

	public void setTrigger(TriggerSchedule aTrigger) {
		this.trigger = aTrigger;
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

	public static ProgramarJobSchedule findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ProgramarJobSchedule) getObjectByOid(NICKNAME, oid, aSesion);
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

	public static ProgramarJobSchedule findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ProgramarJobSchedule) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(orden, "Debe ingresar el Orden");
		Validar.noNulo(job, "Debe ingresar el Job");
		Validar.noNulo(trigger, "Debe ingresar el Trigger");
	}

	public static List getProgramacionActivo(ISesion aSesion) throws BaseException {
		return DBProgramarJobSchedule.getProgramacionActivo(aSesion);
	}

}
