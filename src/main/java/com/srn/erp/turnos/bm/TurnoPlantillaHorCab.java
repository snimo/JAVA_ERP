package com.srn.erp.turnos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TurnoPlantillaHorCab extends ObjetoLogico {

	private List horariosDet = new ArrayList();
	private boolean readHorariosDet = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public TurnoPlantillaHorCab() {
	}

	public static String NICKNAME = "tu.TurnoPlantillaHorCab";

	private String descripcion;
	private Boolean activo;

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
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

	public static TurnoPlantillaHorCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (TurnoPlantillaHorCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TurnoPlantillaHorCab findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (TurnoPlantillaHorCab) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public static TurnoPlantillaHorCab findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (TurnoPlantillaHorCab) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	public List getHorariosDet() throws BaseException {
		if (this.readHorariosDet) {
		   List listaHorarios = TurnoPlantillaHorDet.getPlantillasHorDet(this,getSesion());
		   this.horariosDet.addAll(listaHorarios);
		   readHorariosDet = false;
		}
		return this.horariosDet;
	}

	public void addPlantillaHorDet(TurnoPlantillaHorDet plantillaHorDet) throws BaseException {
		plantillaHorDet.setPlantilla_horario(this);
		this.horariosDet.add(plantillaHorDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterPlantHorDet = this.horariosDet.iterator();
		while (iterPlantHorDet.hasNext()) {
		  TurnoPlantillaHorDet turnoPlantillaHorDet = (TurnoPlantillaHorDet) iterPlantHorDet.next();
		  turnoPlantillaHorDet.save();
		  turnoPlantillaHorDet = null;
		}
		iterPlantHorDet = null;
	}
	
	public List getHorariosFormateados() throws BaseException {
		List horariosFormateados = new ArrayList();
		StringBuffer horario = null;
		Iterator iterHorariosDet = this.getHorariosDet().iterator();
		while (iterHorariosDet.hasNext()) {
			TurnoPlantillaHorDet turnoPlantillaHorDet = (TurnoPlantillaHorDet) iterHorariosDet.next();
			
			if (horario == null) {
				horario = new StringBuffer("");
				horario.append(turnoPlantillaHorDet.getHorario());
				horario.append(" ");
				horario.append("a");
				horario.append(" ");
			} else {
				horario.append(turnoPlantillaHorDet.getHorario());
				horariosFormateados.add(horario.toString());
				horario = null;
				
				horario = new StringBuffer("");
				horario.append(turnoPlantillaHorDet.getHorario());
				horario.append(" ");
				horario.append("a");
				horario.append(" ");
				
				
			}
			
			turnoPlantillaHorDet.getHorario();
		}
		return horariosFormateados;
	}
	

}
