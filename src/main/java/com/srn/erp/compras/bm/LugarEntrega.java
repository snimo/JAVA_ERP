package com.srn.erp.compras.bm;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class LugarEntrega extends ObjetoLogico { 

  public LugarEntrega() { 
  }

  public static String NICKNAME = "cp.LugarEntrega";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private String direccion;
  private String localidad;
  private Provincia provincia;
  private Pais pais;
  private String codigoPostal;
  private String telefonos;

  public String getCodigoPostal() throws BaseException {
  	supportRefresh();
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDireccion() throws BaseException {
		supportRefresh();
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() throws BaseException {
		supportRefresh();
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Pais getPais() throws BaseException {
		supportRefresh();
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Provincia getProvincia() throws BaseException {
		supportRefresh();
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getTelefonos() throws BaseException {
		supportRefresh();
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static LugarEntrega findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (LugarEntrega) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static LugarEntrega findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (LugarEntrega) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 
 public static LugarEntrega findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (LugarEntrega) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
 }

 
 private void addSeparador(StringBuffer cadena,String separador,String agregar) {
	 if (cadena.length()>0)
		 cadena.append(separador);
	 cadena.append(agregar);
 }

 
 public String getDireccionCompleta() throws BaseException {
	 
	 StringBuffer direccionCompleta = new StringBuffer("");
	 
	 if (this.getDireccion()!=null) 
		 addSeparador(direccionCompleta," ",this.getDireccion());
	 
	 if (this.getLocalidad()!=null) 
		 addSeparador(direccionCompleta,", ",this.getLocalidad());
	 
	 if (this.getProvincia()!=null) 
		 addSeparador(direccionCompleta,", ",this.getProvincia().getDescripcion());
	 
	 if (this.getPais()!=null) 
		 addSeparador(direccionCompleta,", ",this.getPais().getDescripcion());
	 
	 return direccionCompleta.toString();
	 
	 
 }
 

}
