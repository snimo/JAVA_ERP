package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBContactoProveedor;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ContactoProveedor extends ObjetoLogico {

  public ContactoProveedor() {
  }

  public static String NICKNAME = "cp.ContactoProveedor";

  private String apellido;
  private String nombre;
  private String telefonos;
  private String fax;
  private String direccion;
  private String localidad;
  private String codigoPostal;
  private Provincia provincia;
  private Pais pais;
  private String mail;
  private Boolean envioOC;
  private Boolean envioPedCotiz;
  private Proveedor proveedor;
  private String sector;
  private String cargo;
  private Boolean activo;

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

  public void setActivo(Boolean aActivo) {
  this.activo =  aActivo;
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

  public String getCodigopostal() throws BaseException {
    supportRefresh();
    return codigoPostal;
  }

  public void setCodigopostal(String aCodigopostal) {
    this.codigoPostal =  aCodigopostal;
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

  public String getMail() throws BaseException {
    supportRefresh();
    return mail;
  }

  public void setMail(String aMail) {
    this.mail =  aMail;
  }

  public Boolean isEnviooc() throws BaseException {
    supportRefresh();
    return envioOC;
  }

  public void setEnviooc(Boolean aEnviooc) {
    this.envioOC =  aEnviooc;
  }

  public Boolean isEnviopedcotiz() throws BaseException {
    supportRefresh();
    return envioPedCotiz;
  }

  public void setEnviopedcotiz(Boolean aEnviopedcotiz) {
    this.envioPedCotiz =  aEnviopedcotiz;
  }

  public Proveedor getProveedor() throws BaseException {
    supportRefresh();
    return proveedor;
  }

  public void setProveedor(Proveedor aProveedor) {
    this.proveedor =  aProveedor;
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

  public String getNickName() {
    return NICKNAME;
  }

 public static ContactoProveedor findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ContactoProveedor) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ContactoProveedor findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ContactoProveedor) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(apellido, "Debe ingresar el Apellido");
    Validar.noNulo(nombre, "Debe ingresar el Nombre");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El contacto debe ingresarse en modo activo");

 }

  /**
   * isActivo
   *
   * @return Boolean
   */
  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  public static List getContactosByProveedor(Proveedor proveedor,
                                             ISesion aSesion) throws BaseException {
    return DBContactoProveedor.getContactosByProveedor(proveedor,aSesion);
  }


}
