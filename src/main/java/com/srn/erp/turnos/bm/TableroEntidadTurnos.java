package com.srn.erp.turnos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.turnos.da.DBTableroEntidadTurnos;
import com.srn.erp.turnos.da.DBTableroHorarioTurnos;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TableroEntidadTurnos extends ObjetoLogico {

	private List horarios = new ArrayList();
	private boolean readHorarios = true;

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public TableroEntidadTurnos() {
	}

	public static String NICKNAME = "tu.TableroEntidadTurnos";

	private TableroTurnos tablero;
	private Integer secu;
	private EntidadTurno entidad_turno;
	private Boolean cambHorAlPonerTurno;
	private Integer minutos1Suj;
	private Integer minutos2Suj;
	private Integer minutos3Suj;
	private Integer minutos4Suj;

	public Boolean isCambiarHorarioAlPonerTurno() throws BaseException {
		supportRefresh();
		if (this.cambHorAlPonerTurno == null)
			return false;
		else
			return this.cambHorAlPonerTurno;
	}

	public void setCambiarHorarioAlPonerTurno(Boolean aCambiarHorAlPonerTurno) {
		this.cambHorAlPonerTurno = aCambiarHorAlPonerTurno;
	}

	public Integer getMinutosTur1Suj() throws BaseException {
		supportRefresh();
		if (this.minutos1Suj == null)
			return new Integer(0);
		else
			return this.minutos1Suj;
	}

	public void setMinutosTurno1Suj(Integer aMinutosTurnos1Sujeto) {
		this.minutos1Suj = aMinutosTurnos1Sujeto;
	}

	public Integer getMinutosTur2Suj() throws BaseException {
		supportRefresh();
		if (this.minutos2Suj == null)
			return new Integer(0);
		else
			return this.minutos2Suj;
	}

	public void setMinutosTurno2Suj(Integer aMinutosTurnos2Sujeto) {
		this.minutos2Suj = aMinutosTurnos2Sujeto;
	}
	
	public Integer getMinutosTur3Suj() throws BaseException {
		supportRefresh();
		if (this.minutos3Suj == null)
			return new Integer(0);
		else
			return this.minutos3Suj;
	}

	public void setMinutosTurno3Suj(Integer aMinutosTurnos3Sujeto) {
		this.minutos3Suj = aMinutosTurnos3Sujeto;
	}
	
	public Integer getMinutosTur4Suj() throws BaseException {
		supportRefresh();
		if (this.minutos4Suj == null)
			return new Integer(0);
		else
			return this.minutos4Suj;
	}

	public void setMinutosTurno4Suj(Integer aMinutosTurnos4Sujeto) {
		this.minutos4Suj = aMinutosTurnos4Sujeto;
	}
	
	

	public TableroTurnos getTablero() throws BaseException {
		supportRefresh();
		return tablero;
	}

	public void setTablero(TableroTurnos aTablero) {
		this.tablero = aTablero;
	}

	public Integer getSecu() throws BaseException {
		supportRefresh();
		return secu;
	}

	public void setSecu(Integer aSecu) {
		this.secu = aSecu;
	}

	public EntidadTurno getEntidad_turno() throws BaseException {
		supportRefresh();
		return entidad_turno;
	}

	public void setEntidad_turno(EntidadTurno aEntidad_turno) {
		this.entidad_turno = aEntidad_turno;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TableroEntidadTurnos findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (TableroEntidadTurnos) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TableroEntidadTurnos findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (TableroEntidadTurnos) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public static TableroEntidadTurnos findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (TableroEntidadTurnos) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tablero, "Debe ingresar el Tablero de Turnos");
		Validar.noNulo(entidad_turno, "Debe ingresar la Entidad");
	}

	public static List getEntidadesTablero(TableroTurnos tablero,
			ISesion aSesion) throws BaseException {
		return DBTableroEntidadTurnos.getEntidadesTablero(tablero, aSesion);
	}

	public static TableroEntidadTurnos getEntidadTablero(TableroTurnos tablero,
			EntidadTurno entidadTurno, ISesion aSesion) throws BaseException {
		return DBTableroEntidadTurnos.getEntidadTablero(tablero, entidadTurno,
				aSesion);
	}

	public List getHorarios() throws BaseException {
		if (readHorarios) {
			List listaHorarios = TableroHorarioTurnos.getHorarios(this
					.getTablero(), this, getSesion());
			horarios.addAll(listaHorarios);
			readHorarios = false;
		}
		return horarios;
	}

	public void addHorario(TableroHorarioTurnos horarioTablero)
			throws BaseException {
		horarioTablero.setTablero(this.getTablero());
		horarioTablero.setEntidad_tablero(this);
		horarios.add(horarioTablero);
	}

	public void afterSave() throws BaseException {
		Iterator iterHorarios = this.horarios.iterator();
		while (iterHorarios.hasNext()) {
			TableroHorarioTurnos tableroHorariosTurnos = (TableroHorarioTurnos) iterHorarios
					.next();
			tableroHorariosTurnos.save();
			tableroHorariosTurnos = null;
		}
		iterHorarios = null;
	}
	
	 public TableroHorarioTurnos getHorario(
			  String horario) throws BaseException {
		  return TableroHorarioTurnos.getHorario(this.getTablero(),this,horario,this.getSesion());
	 }
	

}
