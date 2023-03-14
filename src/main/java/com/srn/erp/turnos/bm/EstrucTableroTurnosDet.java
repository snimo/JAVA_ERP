package com.srn.erp.turnos.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.request.bl.Utils.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;

import java.util.List;

import com.srn.erp.turnos.da.DBEstrucTableroTurnosDet;

public class EstrucTableroTurnosDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EstrucTableroTurnosDet() {
	}

	public static String NICKNAME = "tu.EstrucTableroTurnosDet";

	private EstrucTableroTurnosCab estruc_tab_cab;
	private ParteTablero parte_tablero;
	private Boolean activo;
	private Integer secu;
	

	public EstrucTableroTurnosCab getEstruc_tab_cab() throws BaseException {
		supportRefresh();
		return estruc_tab_cab;
	}

	public void setEstruc_tab_cab(EstrucTableroTurnosCab aEstruc_tab_cab) {
		this.estruc_tab_cab = aEstruc_tab_cab;
	}

	public Integer getSecu() throws BaseException {
		supportRefresh();
		return this.secu;
	}

	public void setSecu(Integer aSecu) {
		this.secu = aSecu;
	}

	public ParteTablero getParte_tablero() throws BaseException {
		supportRefresh();
		return parte_tablero;
	}

	public void setParte_tablero(ParteTablero aParte_tablero) {
		this.parte_tablero = aParte_tablero;
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

	public static EstrucTableroTurnosDet findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (EstrucTableroTurnosDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstrucTableroTurnosDet findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (EstrucTableroTurnosDet) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(estruc_tab_cab, "Debe ingresar la Estructura");
		Validar.noNulo(parte_tablero, "Debe ingresar el Tablero");
		Validar.noNulo(secu, "Debe ingresar el Orden");
	}

	public static List getDetalles(EstrucTableroTurnosCab estrucTab,
			ISesion aSesion) throws BaseException {
		return DBEstrucTableroTurnosDet.getDetalles(estrucTab, aSesion);
	}

}
