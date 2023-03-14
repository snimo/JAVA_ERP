package com.srn.erp.turnos.bm;

import java.util.List;

import com.srn.erp.turnos.da.DBTableroHorarioTurnos;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class TableroHorarioTurnos extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public TableroHorarioTurnos() {
	}

	public static String NICKNAME = "tu.TableroHorarioTurnos";

	private TableroTurnos tablero;
	private String horario;
	private TableroEntidadTurnos entidad_tablero;
	private Integer horaDesdeEnMinutos;
	private Integer horaHastaEnMinutos;

	public TableroTurnos getTablero() throws BaseException {
		supportRefresh();
		return tablero;
	}

	public void setTablero(TableroTurnos aTablero) {
		this.tablero = aTablero;
	}

	public Integer getHoraDesdeEnMinutos() throws BaseException {
		supportRefresh();
		return this.horaDesdeEnMinutos;
	}

	public void setHoraDesdeEnMinutos(Integer aHoraDesdeEnMinutos) {
		this.horaDesdeEnMinutos = aHoraDesdeEnMinutos;
	}

	public Integer getHoraHastaEnMinutos() throws BaseException {
		supportRefresh();
		return this.horaHastaEnMinutos;
	}

	public void setHoraHastaEnMinutos(Integer aHoraHastaEnMinutos) {
		this.horaHastaEnMinutos = aHoraHastaEnMinutos;
	}

	public String getHorario() throws BaseException {
		supportRefresh();
		return horario;
	}

	public void setHorario(String aHorario) {
		this.horario = aHorario;

		if ((aHorario == null) || (aHorario.length() == 0)) {
			this.setHoraDesdeEnMinutos(new Integer(0));
			this.setHoraHastaEnMinutos(new Integer(0));
		} else {
			ManejadorHorario manejadorHorario = new ManejadorHorario();
			manejadorHorario.setHorario(aHorario);
			this.setHoraDesdeEnMinutos(manejadorHorario.getHoraDesdeEnMinutos());
			this.setHoraHastaEnMinutos(manejadorHorario.getHoraHastaEnMinutos());
		}

	}

	public TableroEntidadTurnos getEntidad_tablero() throws BaseException {
		supportRefresh();
		return entidad_tablero;
	}

	public void setEntidad_tablero(TableroEntidadTurnos aEntidad_tablero) {
		this.entidad_tablero = aEntidad_tablero;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TableroHorarioTurnos findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TableroHorarioTurnos) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TableroHorarioTurnos findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TableroHorarioTurnos) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TableroHorarioTurnos findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TableroHorarioTurnos) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tablero, "Debe ingresar el Tablero de Turnos");
		Validar.noNulo(horario, "Debe ingresar el Horario");
		Validar.noNulo(entidad_tablero, "Debe ingresar la Entidad");
	}

	public static List getHorarios(TableroTurnos tablero, TableroEntidadTurnos tableroEntidad, ISesion aSesion) throws BaseException {
		return DBTableroHorarioTurnos.getHorarios(tablero, tableroEntidad, aSesion);
	}

	public static TableroHorarioTurnos getHorario(TableroTurnos tablero, TableroEntidadTurnos entidadTurno, String horario, ISesion aSesion)
			throws BaseException {
		return DBTableroHorarioTurnos.getHorario(tablero, entidadTurno, horario, aSesion);
	}

	public static List getHorariosLibres(TableroTurnos tablero, TableroEntidadTurnos tableroEntidad, ISesion aSesion) throws BaseException {
		return DBTableroHorarioTurnos.getHorariosLibres(tablero, tableroEntidad, aSesion);
	}

	public int getDuracionTurnoEnMinutos() throws BaseException {
		return this.getHoraHastaEnMinutos().intValue() - this.getHoraDesdeEnMinutos().intValue();
	}

	public static List getHorariosActivos(TableroTurnos tablero, TableroEntidadTurnos tableroEntidad, ISesion aSesion) throws BaseException {
		return DBTableroHorarioTurnos.getHorariosActivos(tablero, tableroEntidad, aSesion);
	}

	public static TableroHorarioTurnos getProximoHorario(TableroTurnos tablero, TableroEntidadTurnos entidadTurno, Integer horaDesdeEnMin,
			ISesion aSesion) throws BaseException {
		return DBTableroHorarioTurnos.getProximoHorario(tablero, entidadTurno, horaDesdeEnMin, aSesion);
	}
	
	public TableroHorarioTurnos getProximoHorario() throws BaseException {
		return DBTableroHorarioTurnos.getProximoHorario(this.getTablero(), this.getEntidad_tablero(), this.getHoraHastaEnMinutos(), this.getSesion());
	}
	
	public String getHoraDesde() throws BaseException {
		return this.getHorario().substring(0, 5);
	}
	
	public String getHoraHasta() throws BaseException {
		return this.getHorario().substring(8, 13);
	}
	
	
	
	

}
