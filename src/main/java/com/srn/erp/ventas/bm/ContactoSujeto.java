package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.ventas.da.DBContactoSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class ContactoSujeto extends ObjetoLogico {

  public ContactoSujeto() {
  }

  public static String NICKNAME = "ve.ContactoSujeto";

  private String descripcion;
  private Provincia provincia;
  private Pais pais;
  private String apellido;
  private String nombre;
  private String telefonos;
  private String fax;
  private String direccion;
  private String localidad;
  private String codigo_postal;
  private String mail;
  private String sector;
  private String cargo;
  private Sujeto sujeto;
  private Boolean activo;
  private Boolean reclamarPago;
  private Boolean pasarACobrar;

  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion =  aDescripcion;
  }
  
  public Boolean isReclamarPago() throws BaseException {
	supportRefresh();
	return this.reclamarPago;
  }

  public void setReclamarPago(Boolean aReclamarPago) {
	this.reclamarPago =  aReclamarPago;
  }
  
  public Boolean isPasarACobrar() throws BaseException {
	supportRefresh();
	return this.pasarACobrar;
  }

  public void setPasarACobrar(Boolean aPasarACobrar) {
	this.pasarACobrar =  aPasarACobrar;
  }

  public Provincia getProvincia() throws BaseException {
    supportRefresh();
    return provincia;
  }

  public void setProvincia(Provincia aProvincia) {
    this.provincia =  aProvincia;
  }

  public Pais getPais() throws BaseException {
    supportRefresh();
    return pais;
  }

  public void setPais(Pais aPais) {
    this.pais =  aPais;
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

  public String getTelefonos() throws BaseException {
    supportRefresh();
    return telefonos;
  }

  public void setTelefonos(String aTelefonos) {
    this.telefonos =  aTelefonos;
  }

  public String getFax() throws BaseException {
    supportRefresh();
    return fax;
  }

  public void setFax(String aFax) {
    this.fax =  aFax;
  }

  public String getDireccion() throws BaseException {
    supportRefresh();
    return direccion;
  }

  public void setDireccion(String aDireccion) {
    this.direccion =  aDireccion;
  }

  public String getLocalidad() throws BaseException {
    supportRefresh();
    return localidad;
  }

  public void setLocalidad(String aLocalidad) {
    this.localidad =  aLocalidad;
  }

  public String getCodigo_postal() throws BaseException {
    supportRefresh();
    return codigo_postal;
  }

  public void setCodigo_postal(String aCodigo_postal) {
    this.codigo_postal =  aCodigo_postal;
  }

  public String getMail() throws BaseException {
    supportRefresh();
    return mail;
  }

  public void setMail(String aMail) {
    this.mail =  aMail;
  }

  public String getSector() throws BaseException {
    supportRefresh();
    return sector;
  }

  public void setSector(String aSector) {
    this.sector =  aSector;
  }

  public String getCargo() throws BaseException {
    supportRefresh();
    return cargo;
  }

  public void setCargo(String aCargo) {
    this.cargo =  aCargo;
  }

  public Sujeto getSujeto() throws BaseException {
    supportRefresh();
    return sujeto;
  }

  public void setSujeto(Sujeto aSujeto) {
    this.sujeto =  aSujeto;
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

 public static ContactoSujeto findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ContactoSujeto) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static ContactoSujeto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
   return (ContactoSujeto) getObjectByOidProxy(NICKNAME,oid,aSesion);
  }
 

 public static ContactoSujeto findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ContactoSujeto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(apellido, "Debe Ingresar el Apellido del contacto");
    Validar.noNulo(nombre, "Debe Ingresar el Nombre del contacto");
 }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  public static List getContactos(Sujeto sujeto,
                                  ISesion aSesion) throws BaseException {
    return DBContactoSujeto.getContactos(sujeto,aSesion);
  }
  
  public String getNombreYApellido() throws BaseException {
  	StringBuffer nomyApe = new StringBuffer();
  	if (this.getNombre()!=null)
  		nomyApe.append(this.getNombre());
  	if (this.getApellido()!=null) {
  		if (nomyApe.length()>0)
  			nomyApe.append(" ");
  		nomyApe.append(this.getApellido());
  	}
  	return nomyApe.toString();
  }
  
  public static ContactoSujeto getContactoSujeto(Sujeto sujeto,
		  String descripcion,
          ISesion aSesion)
          throws BaseException {
	  return DBContactoSujeto.getContactoSujeto(sujeto,descripcion,aSesion);
  }


}
