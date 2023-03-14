package com.srn.erp.ventas.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class Cobrador extends ObjetoLogico {

  public Cobrador() {
  }

  public static String NICKNAME = "ve.Cobrador";

  private String codigo;
  private String apellido;
  private String nombre;
  private Boolean activo;
  
	public String getNombreyApellido() throws BaseException {
		return this.getNombre()+" "+this.getApellido();
	}
  

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }

  public String getApellido() throws BaseException {
    supportRefresh();
    return apellido;
  }

  public void setApellido(String aApellido) {
    this.apellido =  aApellido;
  }

  public String getNombre() throws BaseException {
    supportRefresh();
    return nombre;
  }

  public void setNombre(String aNombre) {
    this.nombre =  aNombre;
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

 public static Cobrador findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Cobrador) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static Cobrador findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Cobrador) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static Cobrador findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Cobrador) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
 }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() throws BaseException {
    supportRefresh();
    return getApellido()+", "+getNombre();
  }

}
