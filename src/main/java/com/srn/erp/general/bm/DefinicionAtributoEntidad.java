package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBDefinicionAtributoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DefinicionAtributoEntidad extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DefinicionAtributoEntidad() {
	}

	public static String NICKNAME = "ge.DefinicionAtributoEntidad";

	private String entidad;

	private String nombre_logico;

	private String signature;
	
	private Boolean activo;
	
	private String nombreNickname;

	
	public void setNombreNickName(String aNombreNickName) throws BaseException {
	   this.nombreNickname = aNombreNickName; 	
	}
	
	public String getNombeNickName() throws BaseException {
		supportRefresh();
		return nombreNickname;
	}
	
	
	public String getEntidad() throws BaseException {
		supportRefresh();
		return entidad;
	}

	public void setEntidad(String aEntidad) {
		this.entidad = aEntidad;
	}

	public String getNombre_logico() throws BaseException {
		supportRefresh();
		return nombre_logico;
	}

	public void setNombre_logico(String aNombre_logico) {
		this.nombre_logico = aNombre_logico;
	}

	public String getSignature() throws BaseException {
		supportRefresh();
		return signature;
	}

	public void setSignature(String aSignature) {
		this.signature = aSignature;
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

	public static DefinicionAtributoEntidad findByOid(Integer oid,
			ISesion aSesion) throws BaseException {
		return (DefinicionAtributoEntidad) getObjectByOid(NICKNAME, oid,
				aSesion);
	}

	public static DefinicionAtributoEntidad findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (DefinicionAtributoEntidad) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}
	
	
	public static DefinicionAtributoEntidad findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (DefinicionAtributoEntidad) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(entidad, "Debe ingresar la Entidad");
		Validar.noNulo(nombre_logico, "Debe ingresar el Nombre Logico");
		Validar.noNulo(signature, "Debe ingresar el Path del Atributo");		
		Validar.noNulo(nombreNickname,"Debe ingresar la Entidad del atributo");
	}

	public static List getAtributosByNickName(String nickName, ISesion aSesion)
			throws BaseException {
		return DBDefinicionAtributoEntidad.getAtributosByEntidad(nickName,
				aSesion);
	}

}
