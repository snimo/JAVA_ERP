package com.srn.erp.turnos.bm;

import java.util.List;

import com.srn.erp.turnos.da.DBEntidadParteTableroTurnos;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EntidadParteTableroTurnos extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EntidadParteTableroTurnos() {
	}

	public static String NICKNAME = "tu.EntidadParteTableroTurnos";

	private EntidadTurno entidad_turno;
	private ParteTablero parte_tablero;
	private Integer orden;
	private Boolean activo;
	private Boolean cambHorAlPonerTurno;
	private Integer minutos1Suj;
	private Integer minutos2Suj;
	private Integer minutos3Suj;
	private Integer minutos4Suj;

	public EntidadTurno getEntidad_turno() throws BaseException {
		supportRefresh();
		return entidad_turno;
	}

	public void setEntidad_turno(EntidadTurno aEntidad_turno) {
		this.entidad_turno = aEntidad_turno;
	}

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
	
	
	public ParteTablero getParte_tablero() throws BaseException {
		supportRefresh();
		return parte_tablero;
	}

	public void setParte_tablero(ParteTablero aParte_tablero) {
		this.parte_tablero = aParte_tablero;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
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

	public static EntidadParteTableroTurnos findByOid(Integer oid,
			ISesion aSesion) throws BaseException {
		return (EntidadParteTableroTurnos) getObjectByOid(NICKNAME, oid,
				aSesion);
	}

	public static EntidadParteTableroTurnos findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (EntidadParteTableroTurnos) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public static EntidadParteTableroTurnos findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (EntidadParteTableroTurnos) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(entidad_turno, "Debe ingresar la entidad");
		Validar.noNulo(parte_tablero, "Debe ingresar el Tablero");
		Validar.noNulo(orden, "Debe ingresar el Orden");
	}

	public static List getEntidades(ParteTablero parteTablero, ISesion aSesion)
			throws BaseException {
		return DBEntidadParteTableroTurnos.getEntidades(parteTablero, aSesion);
	}

	public static EntidadParteTableroTurnos getEntidadParteTablero(
			ParteTablero parteTablero, EntidadTurno entidadTurno,
			ISesion aSesion) throws BaseException {
		return DBEntidadParteTableroTurnos.getEntidadParteTablero(parteTablero,
				entidadTurno, aSesion);
	}

}
