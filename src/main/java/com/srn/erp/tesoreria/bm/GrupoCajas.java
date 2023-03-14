package com.srn.erp.tesoreria.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.tesoreria.da.DBGrupoCajasDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoCajas extends ObjetoLogico {

	public GrupoCajas() {
	}

	public static String NICKNAME = "te.GrupoCajas";

	private String codigo;
	private String descripcion;
	private Boolean activo;

	private List cajas = new ArrayList();
	private boolean readCajas = true;

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

	public static GrupoCajas findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoCajas) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoCajas findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoCajas) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static GrupoCajas findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoCajas) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public List getGrupoCajasDet() throws BaseException {
		if (this.readCajas) {
			List listaGrupoCajasDet = GrupoCajasDet.getGruposCajasDetByCaja(this, getSesion());
			cajas.addAll(listaGrupoCajasDet);
			this.readCajas = false;
		}
		return cajas;
	}

	public void addGrupoCajasDet(GrupoCajasDet aGrupoCajasDet) throws BaseException {
		aGrupoCajasDet.setGrupo_caja(this);
		cajas.add(aGrupoCajasDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterGrupoCajasDet = cajas.iterator();
		while (iterGrupoCajasDet.hasNext()) {
			GrupoCajasDet grupoCajasDet = (GrupoCajasDet) iterGrupoCajasDet.next();
			grupoCajasDet.save();
			grupoCajasDet = null;
		}
		iterGrupoCajasDet = null;
	}
	
	public GrupoCajasDet getGrupoCajasDet(Caja caja)
	          throws BaseException {
		  return GrupoCajasDet.getGrupoCajasDet(this,caja,this.getSesion());
	}
	

}
