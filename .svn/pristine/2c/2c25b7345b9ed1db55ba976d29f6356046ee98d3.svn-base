package com.srn.erp.ctasAPagar.bm;

import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.da.DBComproProvAAutorizar;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class ComproProvAAutorizar extends ObjetoLogico {

  public ComproProvAAutorizar() {
  }

  public static String NICKNAME = "cap.ComproProvAAutorizar";

  private ComproCab comprobante;
  private String tcExt;
  private String letra;
  private Integer lugEmi;
  private Integer nroExt;
  private TranProv tranProv;
  private TranProvVto tranProvVto;
  private Money importe;
  private Money saldo;
  private java.util.Date imputac;
  private java.util.Date emision;
  private java.util.Date vto;
  private Money importeCuota;
  private Money saldoCuota;
  private AutorizacionFactProv autorizFactProv;
  private Money porcAutoriz;
  private Money montoAutorizado;
  private Usuario usuario;
  private String apellido;
  private String nombre;
  private java.util.Date fecAutoriz;
  private String moneda;
  private String rsProveedor;
  private String codProveedor;
  private Integer estado;

  public String getRSProveedor() throws BaseException {
    supportRefresh();
    return rsProveedor;
  }

  public void setRSProveedor(String rsProveedor) {
    this.rsProveedor = rsProveedor;
  }
  
  public Integer getEstado() throws BaseException {
    supportRefresh();
    return this.estado;
  }

  public void setEstado(Integer aEstado) {
    this.estado = aEstado;
  }
  

  public String getCodigoProveedor() throws BaseException {
    supportRefresh();
    return codProveedor;
  }

  public void setCodigoProveedor(String codigoProveedor) {
    this.codProveedor = codigoProveedor;
  }

  public ComproCab getComprobante() throws BaseException {
    supportRefresh();
    return comprobante;
  }

  public void setComprobante(ComproCab aComprobante) {
    this.comprobante =  aComprobante;
  }

  public String getTcext() throws BaseException {
    supportRefresh();
    return tcExt;
  }

  public void setTcext(String aTcext) {
    this.tcExt =  aTcext;
  }

  public String getLetra() throws BaseException {
    supportRefresh();
    return letra;
  }

  public void setLetra(String aLetra) {
    this.letra =  aLetra;
  }

  public Integer getLugemi() throws BaseException {
    supportRefresh();
    return lugEmi;
  }

  public void setLugemi(Integer aLugemi) {
    this.lugEmi =  aLugemi;
  }

  public Integer getNroext() throws BaseException {
    supportRefresh();
    return nroExt;
  }

  public void setNroext(Integer aNroext) {
    this.nroExt =  aNroext;
  }

  public TranProv getTranprov() throws BaseException {
    supportRefresh();
    return tranProv;
  }

  public void setTranprov(TranProv aTranprov) {
    this.tranProv =  aTranprov;
  }

  public TranProvVto getTranprovVto() throws BaseException {
    supportRefresh();
    return tranProvVto;
  }

  public void setTranprovVto(TranProvVto aTranprovVto) {
    this.tranProvVto =  aTranprovVto;
  }

  public Money getImporte() throws BaseException {
    supportRefresh();
    return importe;
  }

  public void setImporte(Money aImporte) {
    this.importe =  aImporte;
  }

  public Money getSaldo() throws BaseException {
    supportRefresh();
    return saldo;
  }

  public void setSaldo(Money aSaldo) {
    this.saldo =  aSaldo;
  }

  public java.util.Date getImputac() throws BaseException {
    supportRefresh();
    return imputac;
  }

  public void setImputac(java.util.Date aImputac) {
    this.imputac =  aImputac;
  }

  public java.util.Date getEmision() throws BaseException {
    supportRefresh();
    return emision;
  }

  public void setEmision(java.util.Date aEmision) {
    this.emision =  aEmision;
  }

  public java.util.Date getVto() throws BaseException {
    supportRefresh();
    return vto;
  }

  public void setVto(java.util.Date aVto) {
    this.vto =  aVto;
  }

  public Money getImportecuota() throws BaseException {
    supportRefresh();
    return importeCuota;
  }

  public void setImportecuota(Money aImportecuota) {
    this.importeCuota =  aImportecuota;
  }

  public Money getSaldocuota() throws BaseException {
    supportRefresh();
    return saldoCuota;
  }

  public void setSaldocuota(Money aSaldocuota) {
    this.saldoCuota =  aSaldocuota;
  }

  public AutorizacionFactProv getAutorizfactprov() throws BaseException {
    supportRefresh();
    return autorizFactProv;
  }

  public void setAutorizfactprov(AutorizacionFactProv aAutorizfactprov) {
    this.autorizFactProv =  aAutorizfactprov;
  }

  public Money getPorcautoriz() throws BaseException {
    supportRefresh();
    return porcAutoriz;
  }

  public void setPorcautoriz(Money aPorcautoriz) {
    this.porcAutoriz =  aPorcautoriz;
  }

  public Money getMontoAutorizado() throws BaseException {
    supportRefresh();
    return montoAutorizado;
  }

  public void setMontoAutorizado(Money montoAutorizado) throws BaseException {
    this.montoAutorizado = montoAutorizado;
  }

  public Usuario getUsuario() throws BaseException {
    supportRefresh();
    return usuario;
  }

  public void setUsuario(Usuario aUsuario) {
    this.usuario =  aUsuario;
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

  public java.util.Date getFecautoriz() throws BaseException {
    supportRefresh();
    return fecAutoriz;
  }

  public void setFecautoriz(java.util.Date aFecautoriz) {
    this.fecAutoriz =  aFecautoriz;
  }

  public String getMoneda() throws BaseException {
    supportRefresh();
    return moneda;
  }

  public void setMoneda(String aMoneda) {
    this.moneda =  aMoneda;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static ComproProvAAutorizar findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ComproProvAAutorizar) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ComproProvAAutorizar findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ComproProvAAutorizar) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
 }

  /**
   * isActivo
   *
   * @return Boolean
   */
  public Boolean isActivo() {
    return null;
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  public static List getComproProvPendAutoriz(String tipoConsulta,
  																						java.util.Date fechaDesde,
  																						java.util.Date fechaHasta,
  																						Proveedor proveedor,
                                              TipoCtaCteProv tipoCtaCteProv,
                                              java.util.Date fecha,
                                              ISesion aSesion) throws BaseException {
    return DBComproProvAAutorizar.getComproProvPendAutoriz(tipoConsulta,
    		                                                   fechaDesde,
    		                                                   fechaHasta,
    																											 proveedor,
                                                           tipoCtaCteProv,
                                                           fecha,
                                                           aSesion);

  }




}
