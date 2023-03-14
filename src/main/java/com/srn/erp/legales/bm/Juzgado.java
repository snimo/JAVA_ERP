package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBJuzgado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Juzgado extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return this.getNro();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return "Nro. "+this.getNro()+" "+this.getDireccion();
	}

	public Juzgado() {
	}

	public static String NICKNAME = "leg.Juzgado";

	private String nro;
	private String juzgado;
	private String direccion;
	private String observacion;
	private String telefono;
	private Boolean activo;

	public String getNro() throws BaseException {
		supportRefresh();
		return nro;
	}

	public void setNro(String aNro) {
		this.nro = aNro;
	}

	public String getJuzgado() throws BaseException {
		supportRefresh();
		return juzgado;
	}

	public void setJuzgado(String aJuzgado) {
		this.juzgado = aJuzgado;
	}

	public String getDireccion() throws BaseException {
		supportRefresh();
		if (direccion==null)
			return "";
		else
			return direccion;
	}

	public void setDireccion(String aDireccion) {
		this.direccion = aDireccion;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public String getTelefono() throws BaseException {
		supportRefresh();
		return telefono;
	}

	public void setTelefono(String aTelefono) {
		this.telefono = aTelefono;
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

	public static Juzgado findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Juzgado) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Juzgado findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Juzgado) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Juzgado findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Juzgado) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(nro, "Debe ingresar el Nro. de Juzgado");
		Validar.noNulo(juzgado, "Debe ingresar el Juzgado");
	}

	public static List getAllJuzgados(ISesion aSesion) throws BaseException {
		return DBJuzgado.getAllJuzgados(aSesion);
	}
	

}
