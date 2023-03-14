package com.srn.erp.contabilidad.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.request.bl.Utils.*;
import framework.applicarionServer.bl.Sesion.ISesion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;

public class Subdiario extends ObjetoLogico {

	public Subdiario() {
	}

	public static String NICKNAME = "cg.Subdiario";

	private String codigo;
	private String descripcion;
	private Boolean activo;

	private List subdiariosDet = new ArrayList();
	private boolean readSubdiariosDet = true;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

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

	public static Subdiario findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Subdiario) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Subdiario findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Subdiario) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Subdiario findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Subdiario) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
	}

	public List getSubdiariosDet() throws BaseException {
		if (this.readSubdiariosDet) {
			List listaSubdiariosDet = SubdiarioDet.getSubDiariosDet(this, getSesion());
			this.subdiariosDet.addAll(listaSubdiariosDet);
			readSubdiariosDet = false;
		}
		return this.subdiariosDet;
	}

	public void addSubdiarioDet(SubdiarioDet aSubdiarioDet) throws BaseException {
		aSubdiarioDet.setSubdiario(this);
		this.subdiariosDet.add(aSubdiarioDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterSubDiariosDet = this.subdiariosDet.iterator();
		while (iterSubDiariosDet.hasNext()) {
			SubdiarioDet subDiarioDet = (SubdiarioDet) iterSubDiariosDet.next();
			subDiarioDet.save();
			subDiarioDet = null;
		}
		iterSubDiariosDet = null;
	}
	
	public Estructura getEstructura() throws BaseException {
		Estructura estrucLeida = null;
		Iterator iterSubdiarioDet = 
			this.getSubdiariosDet().iterator();
		while (iterSubdiarioDet.hasNext()) {
			SubdiarioDet subdiarioDet = (SubdiarioDet) iterSubdiarioDet.next();
			if (!subdiarioDet.isActivo()) continue;
			if (subdiarioDet.getCuenta().getEstructura()==null)
				return null;
			if ((subdiarioDet.getCuenta().getEstructura()!=null) && 
				(estrucLeida!=null) && 
				(subdiarioDet.getCuenta().getEstructura().getOID()!=estrucLeida.getOID()))
				return null;
			if (subdiarioDet.getCuenta().getEstructura()!=null)
				estrucLeida = subdiarioDet.getCuenta().getEstructura();
		}
		return estrucLeida;
	}

}
