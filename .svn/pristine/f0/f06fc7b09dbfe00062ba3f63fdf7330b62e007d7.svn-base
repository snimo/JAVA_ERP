package com.srn.erp.conciTarjeta.bm;

import java.util.List;

import com.srn.erp.conciTarjeta.da.DBUniNegConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UniNegConciTar extends ObjetoLogico {

	public UniNegConciTar() {
	}

	public static String NICKNAME = "ctar.UniNegConciTar";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private String descripcion;
	private EmpresaConciTar empresa;
	private Boolean activo;
	private String cuentaTarjACobrar;
	private String cuentaTarjACobrarC1;
	private String cuentaTarjACobrarC2;	

	public String getCtaTarjetaACobrar() throws BaseException {
		supportRefresh();
		return this.cuentaTarjACobrar;
	}	
	
	public String getCtaTarjetaACobrarC1() throws BaseException {
		supportRefresh();
		return this.cuentaTarjACobrarC1;
	}	
	
	public String getCtaTarjetaACobrarC2() throws BaseException {
		supportRefresh();
		return this.cuentaTarjACobrarC2;
	}
	
	public void setCtaTarjetaACobrarC1(String aCtaTarjetaACobrarC1) {
		this.cuentaTarjACobrarC1 = aCtaTarjetaACobrarC1;
	}	
	
	public void setCtaTarjetaACobrarC2(String aCtaTarjetaACobrarC2) {
		this.cuentaTarjACobrarC2 = aCtaTarjetaACobrarC2;
	}	
	
	public void setCtaTarjetaACobrar(String aCtaTarjetaACobrar) {
		this.cuentaTarjACobrar = aCtaTarjetaACobrar;
	}	
	
	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public EmpresaConciTar getEmpresa() throws BaseException {
		supportRefresh();
		return empresa;
	}

	public void setEmpresa(EmpresaConciTar aEmpresa) {
		this.empresa = aEmpresa;
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

	public static UniNegConciTar findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (UniNegConciTar) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static UniNegConciTar findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (UniNegConciTar) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static UniNegConciTar findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (UniNegConciTar) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(empresa, "Debe ingresar la Empresa");
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBUniNegConciTar.getAllActivos(aSesion);
	}

}
