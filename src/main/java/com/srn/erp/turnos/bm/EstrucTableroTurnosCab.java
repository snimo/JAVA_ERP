package com.srn.erp.turnos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstrucTableroTurnosCab extends ObjetoLogico {

	private List detalles = new ArrayList();
	private boolean readDetalles = true;
	private String comportamiento;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EstrucTableroTurnosCab() {
	}

	public static String NICKNAME = "tu.EstrucTableroTurnosCab";

	private String descripcion;
	private Boolean activo;

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
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

	public static EstrucTableroTurnosCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (EstrucTableroTurnosCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstrucTableroTurnosCab findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (EstrucTableroTurnosCab) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public static EstrucTableroTurnosCab findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (EstrucTableroTurnosCab) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(comportamiento, "Debe ingresar el Tipo");
	}

	public List getDetalles() throws BaseException {
		if (readDetalles) {
			List listaDetalles = EstrucTableroTurnosDet.getDetalles(this,
					getSesion());
			this.detalles.addAll(listaDetalles);
			readDetalles = false;
		}
		return detalles;
	}

	public void addDetalle(EstrucTableroTurnosDet aDetalle)
			throws BaseException {
		aDetalle.setEstruc_tab_cab(this);
		detalles.add(aDetalle);
	}

	public void afterSave() throws BaseException {
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			EstrucTableroTurnosDet estrucTabTurDet = (EstrucTableroTurnosDet) iterDetalles
					.next();
			estrucTabTurDet.save();
			estrucTabTurDet = null;
		}
		iterDetalles = null;
	}

}
