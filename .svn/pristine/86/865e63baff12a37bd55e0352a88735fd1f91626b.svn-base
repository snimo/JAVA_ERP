package com.srn.erp.ctasAPagar.bm;

import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.da.DBAplProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;

public class AplProv extends ObjetoLogico {

  public AplProv() {
  }

  public static String NICKNAME = "cap.AplProv";

  private ComproCab comprobanteApl;
  private TipoCtaCteProv tipoCtaProv;
  private Proveedor proveedor;
  private Moneda moneda;
  private Money importe;
  private java.util.Date fecImputac;
  private java.util.Date emision;
  private Integer diasBase;
  private Integer diasVto;
  private ComproCab comprobanteOri;
  private TranProvVto tranProvVto;
  private TranProvVto tranProvVtoOri;
  private ValorCotizacion cotizMonOri;
  private ValorCotizacion cotizMonExt1;
  private ValorCotizacion cotizMonExt2;


  public ValorCotizacion getCotizMonOri() throws BaseException {
    return this.cotizMonOri;
  }

  public void setCotizMonOri(ValorCotizacion aCotizMonOri) throws BaseException {
    this.cotizMonOri = aCotizMonOri;
  }

  public ValorCotizacion getCotizMonExt1() throws BaseException {
    return this.cotizMonExt1;
  }

  public void setCotizMonExt1(ValorCotizacion aCotizMonExt1) throws BaseException {
    this.cotizMonExt1 = aCotizMonExt1;
  }

  public ValorCotizacion getCotizMonExt2() throws BaseException {
    return this.cotizMonExt2;
  }

  public void setCotizMonExt2(ValorCotizacion aCotizMonExt2) throws BaseException {
    this.cotizMonExt2 = aCotizMonExt2;
  }


  public ComproCab getComprobanteapl() throws BaseException {
    supportRefresh();
    return comprobanteApl;
  }

  public void setComprobanteapl(ComproCab aComprobanteapl) {
    this.comprobanteApl =  aComprobanteapl;
  }

  public TipoCtaCteProv getTipoctaprov() throws BaseException {
    supportRefresh();
    return tipoCtaProv;
  }

  public void setTipoctaprov(TipoCtaCteProv aTipoctaprov) {
    this.tipoCtaProv =  aTipoctaprov;
  }

  public Proveedor getProveedor() throws BaseException {
    supportRefresh();
    return proveedor;
  }

  public void setProveedor(Proveedor aProveedor) {
    this.proveedor =  aProveedor;
  }

  public Moneda getMoneda() throws BaseException {
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) {
    this.moneda =  aMoneda;
  }

  public Money getImporte() throws BaseException {
    supportRefresh();
    return importe;
  }

  public void setImporte(Money aImporte) {
    this.importe =  aImporte;
  }

  public java.util.Date getFecimputac() throws BaseException {
    supportRefresh();
    return fecImputac;
  }

  public void setFecimputac(java.util.Date aFecimputac) {
    this.fecImputac =  aFecimputac;
  }

  public java.util.Date getEmision() throws BaseException {
    supportRefresh();
    return emision;
  }

  public void setEmision(java.util.Date aEmision) {
    this.emision =  aEmision;
  }


  public Integer getDiasbase() throws BaseException {
    supportRefresh();
    return diasBase;
  }

  public void setDiasbase(Integer aDiasbase) {
    this.diasBase =  aDiasbase;
  }

  public Integer getDiasvto() throws BaseException {
    supportRefresh();
    return diasVto;
  }

  public void setDiasvto(Integer aDiasvto) {
    this.diasVto =  aDiasvto;
  }

  public ComproCab getComprobanteori() throws BaseException {
    supportRefresh();
    return comprobanteOri;
  }

  public void setComprobanteori(ComproCab aComprobanteori) {
    this.comprobanteOri =  aComprobanteori;
  }

  public TranProvVto getTranprovvto() throws BaseException {
    supportRefresh();
    return tranProvVto;
  }

  public TranProvVto getTranprovvtoOri() throws BaseException {
    supportRefresh();
    return tranProvVtoOri;
  }


  public void setTranprovvto(TranProvVto aTranprovvto) {
    this.tranProvVto =  aTranprovvto;
  }

  public void setTranprovvtoOri(TranProvVto aTranprovvtoOri) {
    this.tranProvVtoOri =  aTranprovvtoOri;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static AplProv findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (AplProv) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static AplProv findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (AplProv) getObjectByCodigo(NICKNAME,codigo,aSesion);
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
  
  public static List getAplicacionesProveedor(AplicacionComproProv aplicComproProv,
          ISesion aSesion) throws BaseException {
	  return DBAplProv.getAplicacionesProveedor(aplicComproProv,aSesion);             
  }
  
  public static List getAplicacionesActivasCompro(ComproCab aComproCab,
          ISesion aSesion) throws BaseException {
	  return DBAplProv.getAplicacionesActivasCompro(aComproCab,aSesion);
  }
  
  public static List getAplicacionesActivasDelCompro(ComproCab aComproCab,
          ISesion aSesion) throws BaseException {
	  return DBAplProv.getAplicacionesActivasDelCompro(aComproCab,aSesion);
  }
  

}
