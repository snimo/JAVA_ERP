package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBMotEntInterPlanifS;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotEntInterPlanifS extends ObjetoLogico {

	public MotEntInterPlanifS() {
	}

	public static final String LUNES = "LUN";
	public static final String MARTES = "MAR";
	public static final String MIERCOLES = "MIE";
	public static final String JUEVES = "JUE";
	public static final String VIERNES = "VIE";
	public static final String SABADO = "SAB";
	public static final String DOMINGO = "DOM";
	
	public static String getDiaSemana(int dia) {
		if (dia == 1)
			return DOMINGO;
		else
			if (dia == 2)
				return LUNES;
			else
				if (dia == 3)
					return MARTES;
				else
					if (dia == 4)
						return MIERCOLES;
					else
						if (dia == 5)
							return JUEVES;
						else
							if (dia == 6)
								return VIERNES;
							else
								if (dia == 7)
									return SABADO;
		return "";
			
	}

	public static String NICKNAME = "cip.MotEntInterPlanifS";

	private PermisoSemanalCIP permiso_semanal;
	private MotivoEntIntermedias motivo;
	private String dia;
	private Boolean activo;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private String horario_desde;
	private String horario_hasta;
	private String asignacion;

	public PermisoSemanalCIP getPermiso_semanal() throws BaseException {
		supportRefresh();
		return permiso_semanal;
	}

	public void setPermiso_semanal(PermisoSemanalCIP aPermiso_semanal) {
		this.permiso_semanal = aPermiso_semanal;
	}

	public MotivoEntIntermedias getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotivoEntIntermedias aMotivo) {
		this.motivo = aMotivo;
	}

	public String getDia() throws BaseException {
		supportRefresh();
		return dia;
	}

	public void setDia(String aDia) {
		this.dia = aDia;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getHorario_desde() throws BaseException {
		supportRefresh();
		return horario_desde;
	}

	public void setHorario_desde(String aHorario_desde) {
		this.horario_desde = aHorario_desde;
	}

	public String getHorario_hasta() throws BaseException {
		supportRefresh();
		return horario_hasta;
	}

	public void setHorario_hasta(String aHorario_hasta) {
		this.horario_hasta = aHorario_hasta;
	}

	public String getAsignacion() throws BaseException {
		supportRefresh();
		return asignacion;
	}

	public void setAsignacion(String aAsignacion) {
		this.asignacion = aAsignacion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static MotEntInterPlanifS findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (MotEntInterPlanifS) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotEntInterPlanifS findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (MotEntInterPlanifS) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(permiso_semanal, "Debe ingresar el Permiso Semanal");
		Validar.noNulo(motivo, "Debe ingresar las entradas intermedias");
		Validar.noNulo(dia, "Debe ingresar el día");
		Validar.noNulo(horario_desde, "Debe ingresar el horario desde");
		Validar.noNulo(horario_hasta, "Debe ingresar el horario hasta");
		Validar.noNulo(asignacion, "Debe ingresar el tipo de Permiso");
	}

	public static MotEntInterPlanifS getMotEntInterPlanifS(
			PermisoSemanalCIP permiso, MotivoEntIntermedias motivo,
			String diaSemana, ISesion aSesion) throws BaseException {
		return DBMotEntInterPlanifS.getMotEntInterPlanifS(permiso, motivo,
				diaSemana, aSesion);
	}

	public static List getMotEntInterPlanifS(PermisoSemanalCIP permiso,
			String diaSemana, ISesion aSesion) throws BaseException {
		return DBMotEntInterPlanifS.getMotEntInterPlanifS(permiso, diaSemana,
				aSesion);
	}

	public static List getMotEntInterPlanifS(PermisoSemanalCIP permiso,
			ISesion aSesion) throws BaseException {
		return DBMotEntInterPlanifS.getMotEntInterPlanifS(permiso, aSesion);
	}

}
