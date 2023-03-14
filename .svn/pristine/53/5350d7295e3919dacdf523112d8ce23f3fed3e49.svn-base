package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.legales.da.DBAbogado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Abogado extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Abogado() {
	}

	public static String NICKNAME = "leg.Abogado";

	private String apellido;
	private String nombre;
	private String telefonos;
	private String mail;
	private String direccion;
	private String estudio;
	private Boolean activo;
	private String cuit;

	public String getApeyNom() throws BaseException {
		String nomCompleto = "";
		if (this.getApellido() != null)
			nomCompleto = this.getApellido() + " ";
		if (this.getNombre() != null)
			nomCompleto = nomCompleto + this.getNombre();
		return nomCompleto;
	}

	public String getApellido() throws BaseException {
		supportRefresh();
		return apellido;
	}

	public void setApellido(String aApellido) {
		this.apellido = aApellido;
	}

	public String getCUIT() throws BaseException {
		supportRefresh();
		return cuit;
	}

	public void setCUIT(String aCUIT) {
		this.cuit = aCUIT;
	}

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public String getTelefonos() throws BaseException {
		supportRefresh();
		return telefonos;
	}

	public void setTelefonos(String aTelefonos) {
		this.telefonos = aTelefonos;
	}

	public String getMail() throws BaseException {
		supportRefresh();
		return mail;
	}

	public void setMail(String aMail) {
		this.mail = aMail;
	}

	public String getDireccion() throws BaseException {
		supportRefresh();
		return direccion;
	}

	public void setDireccion(String aDireccion) {
		this.direccion = aDireccion;
	}

	public String getEstudio() throws BaseException {
		supportRefresh();
		return estudio;
	}

	public void setEstudio(String aEstudio) {
		this.estudio = aEstudio;
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

	public static Abogado findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Abogado) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Abogado findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Abogado) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Abogado findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Abogado) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		Validar.noNulo(apellido, "Debe ingresar el Apellido");

	}

	public static List getAll(ISesion aSesion) throws BaseException {
		return DBAbogado.getAll(aSesion);
	}

}
