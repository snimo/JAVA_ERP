package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;

public class AnuladorAsientoCab extends ComproCab implements IContabilizable {

  public AnuladorAsientoCab() {
  }

  public static String NICKNAME = "cg.AnuladorAsientoCab";

  private ComproCab comprobanteAnulado;
  private Date fecImputacion;
  private Date fecReal;
  private Usuario usuario;
  private String comentario;
  private ComproConta comproConta;

  private List detalles = new ArrayList();

  public ComproCab getComprobanteAnulado() throws BaseException {
    supportRefresh();
    return comprobanteAnulado;
  }

  public void setComprobanteAnulado(ComproCab aComprobanteAnulado) throws BaseException {
    this.comprobanteAnulado =  aComprobanteAnulado;
    comproConta = ComproConta.findByOid(aComprobanteAnulado.getOIDInteger(),getSesion());
  }

  public Date getFecImputacion() throws BaseException {
    supportRefresh();
    return fecImputacion;
  }

  public void setFecImputacion(Date aFecimputacion) {
    this.fecImputacion =  aFecimputacion;
  }

  public Date getFecReal() throws BaseException {
    supportRefresh();
    return fecReal;
  }

  public void setFecReal(Date aFecReal) {
    this.fecReal =  aFecReal;
  }


  public Usuario getUsuario() throws BaseException {
    supportRefresh();
    return usuario;
  }

  public void setUsuario(Usuario aUsuario) {
    this.usuario =  aUsuario;
  }

  public String getComentario() throws BaseException {
    supportRefresh();
    return comentario;
  }

  public void setComentario(String aComentario) {
    this.comentario =  aComentario;
  }

  public String getNickName() {
    return NICKNAME;
  }

  public static AnuladorAsientoCab getNewComprobante(ISesion aSesion)
      throws BaseException {
    AnuladorAsientoCab anuladorAsientoCab = null;
    anuladorAsientoCab = (AnuladorAsientoCab)AnuladorAsientoCab.getNew(NICKNAME,aSesion);
    return anuladorAsientoCab;
  }


 public static AnuladorAsientoCab findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (AnuladorAsientoCab) getObjectByOid(NICKNAME,oid,aSesion);
 }

 public static AnuladorAsientoCab findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
   return (AnuladorAsientoCab) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public void beforeSave() throws BaseException {
   beforeSaveComprobante(this);
   if (this.isNew())
     this.setEstado(ComproCab.ESTADO_ALTA);
 }

 public void afterSave() throws BaseException {
   Iterator iterDetalles = detalles.iterator();
   while (iterDetalles.hasNext()) {
     AnuladorAsientoDet anuladorAsientoDet = (AnuladorAsientoDet) iterDetalles.next();
     anuladorAsientoDet.save();
     anuladorAsientoDet = null;
   }
   iterDetalles = null;
   afterSaveComprobante(this);
   
   anularComprobante(this.getComprobanteAnulado());
   
   marcarComproContaComoAnulado();
 }

 public void marcarComproContaComoAnulado() throws BaseException {
   this.comproConta.setAnulado(new Boolean(true));
   this.comproConta.save();
 }

  /**
   * isActivo
   *
   * @return Boolean
   */
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

  public AnuladorAsientoDet addDetalle() throws BaseException {
    AnuladorAsientoDet anuladorAsiDet =
        (AnuladorAsientoDet)AnuladorAsientoDet.getNew(AnuladorAsientoDet.NICKNAME,getSesion());
    anuladorAsiDet.setComprobante(this);
    detalles.add(anuladorAsiDet);
    return anuladorAsiDet;
  }

  /**
   * getComprobante
   *
   * @return ComproCab
   */
  public ComproCab getComprobante() {
    return this;
  }

  /**
   * getImputacion
   *
   * @return Date
   */
  public Date getImputacion() throws BaseException {
    return getFecImputacion();
  }

  /**
   * getRenglonesAsiento
   *
   * @return RenglonesAsiento
   */
  public RenglonesAsiento getRenglonesAsiento() throws BaseException {
  	
		// La anulacion la realiza automaticamente el comprobante padre
		return null;
  	
  	
/*    RenglonesAsiento renglones = new RenglonesAsiento();
    Iterator iterDetalles = detalles.iterator();
    while (iterDetalles.hasNext()) {
      AnuladorAsientoDet anuladorAsientoDet = (AnuladorAsientoDet) iterDetalles.next();
      RenglonAsiento renglon = renglones.addRenglonAsiento();
      renglon.setCuentaImputable(anuladorAsientoDet.getCuentaimputable());
      if (anuladorAsientoDet.getSigno().intValue()==RenglonAsiento.DEBE)
        renglon.setD_H(RenglonAsiento.DEBE);
      else
        renglon.setD_H(RenglonAsiento.HABER);
      renglon.setMonedaOri(Moneda.getMonedaCursoLegal(getSesion()));
      renglon.setImporteOri(anuladorAsientoDet.getImpoLocHist());
      renglon.setCotizOri(new ValorCotizacion(1.0));
      renglon.setCotizMonExt1(importeContable.getValorCotizMonExt1());
      renglon.setCotizMonExt2(importeContable.getValorCotizMonExt2());
      renglon.setComentario(anuladorAsientoDet.getComentario());
      renglon.setImpoLocHist(anuladorAsientoDet.getImpoLocHist());
      renglon.setImpoLocAju(anuladorAsientoDet.getImpoLocAju());
      renglon.setImpoMonExt1(anuladorAsientoDet.getImpoMonExt1());
      renglon.setImpoMonExt2(anuladorAsientoDet.getImpoMonExt2());
    }
    return renglones;*/


  }

}
