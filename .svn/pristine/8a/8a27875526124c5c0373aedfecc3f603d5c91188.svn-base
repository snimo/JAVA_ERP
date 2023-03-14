package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.da.DBVendedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Vendedor extends ObjetoLogico {

  public Vendedor() {
  }

  public static String NICKNAME = "ve.Vendedor";

  private String codigo;
  private String apellido;
  private String nombre;
  private Boolean activo;
  private String telefono;
  private String mail;

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }
  
  public String getTelefono() throws BaseException {
    supportRefresh();
    return telefono;
  }

  public void setTelefono(String aTelefono) {
    this.telefono =  aTelefono;
  }
  
  public String getMail() throws BaseException {
    supportRefresh();
    return mail;
  }

  public void setMail(String aMail) {
    this.mail =  aMail;
  }
  
  

  public String getApellido() throws BaseException {
    supportRefresh();
    if (apellido == null)
    	return "";
    else
      return apellido;
  }

  public void setApellido(String aApellido) {
    this.apellido =  aApellido;
  }

  public String getNombre() throws BaseException {
    supportRefresh();
    if (nombre  == null)
    	return "";
    else
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

 public static Vendedor findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Vendedor) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static Vendedor findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Vendedor) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static Vendedor findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Vendedor) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(apellido, "Debe ingresar el Apellido");
    Validar.noNulo(nombre, "Debe ingresar el Nombre");
 }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() throws BaseException {
    return getApellido()+", "+getNombre();
  }
  
  public String getNombreyApellido() throws BaseException {
  	return this.getNombre()+" "+this.getApellido();
  }
  
  public static List getAllVendedores(ISesion aSesion)
  throws BaseException {
  	return DBVendedor.getAllVendedores(aSesion);
  }
  
  public static Vendedor getVendedorDefVtaMostrador(ISesion aSesion) throws BaseException {
    Integer oidVendedor =
        ValorParametro.findByCodigoParametro("VEND_DEF_VTA_MOSTRADOR",aSesion).getOidObjNeg();
    Vendedor vendedor = Vendedor.findByOid(oidVendedor,aSesion);
    return vendedor;
  }
  
  public static Vendedor getVendedorDefParaFacturarRto(ISesion aSesion) throws BaseException {
    Integer oidVendedor =
        ValorParametro.findByCodigoParametro("VEND_DEF_FACT_RTO",aSesion).getOidObjNeg();
    Vendedor vendedor = Vendedor.findByOid(oidVendedor,aSesion);
    return vendedor;
  }
  
  
  
  
  

}
