package com.srn.erp.conciTarjeta.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.da.DBCabModeloLiq;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CabModeloLiq extends ObjetoLogico {

	public CabModeloLiq() {
	}

	public static String NICKNAME = "ctar.CabModeloLiq";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private String comenAsiento;

	private List cuentas = new ArrayList();
	private boolean readCuentas = true;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}
	
	public String getComenAsiento() throws BaseException {
		supportRefresh();
		return this.comenAsiento;
	}	

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public void setComenAsiento(String aComenAsiento) {
		this.comenAsiento = aComenAsiento;
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

	public static CabModeloLiq findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CabModeloLiq) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CabModeloLiq findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CabModeloLiq) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CabModeloLiq findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CabModeloLiq) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public List getRenglonesCuentas() throws BaseException {
		if (this.readCuentas) {
			List listaRenCuentas = DetModeloLiq.getDetallesModLiq(this, getSesion());
			cuentas.addAll(listaRenCuentas);
			this.readCuentas = false;
		}
		return cuentas;
	}

	public void addRenglonCuenta(DetModeloLiq aDetModeloLiq) throws BaseException {
		aDetModeloLiq.setModelo(this);
		cuentas.add(aDetModeloLiq);

	}

	public void afterSave() throws BaseException {
		Iterator iterRenglonesCtas = cuentas.iterator();
		while (iterRenglonesCtas.hasNext()) {
			DetModeloLiq detModeloLiq = (DetModeloLiq) iterRenglonesCtas.next();
			detModeloLiq.save();
			detModeloLiq = null;
		}
		iterRenglonesCtas = null;
	}

	public static List getCabModLiq(EmpresaConciTar empresa, ISesion aSesion) throws BaseException {
		return DBCabModeloLiq.getCabModLiq(empresa, aSesion);
	}
	

}
