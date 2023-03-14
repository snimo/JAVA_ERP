package com.srn.erp.pagos.bm;

import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class DtoComproEnOP extends ObjetoLogico {

  public DtoComproEnOP() {
  }

  public static String NICKNAME = "pag.DtoComproEnOP";

  private ComproCab comproProv;
  private Money dtoMonOri;
  private Money dtoMonLoc;
  private java.util.Date fecha;
  private ComproCab comproOP;
  private Boolean activo;

  public ComproCab getComproprov() throws BaseException {
    supportRefresh();
    return comproProv;
  }

  public void setComproprov(ComproCab aComproprov) {
    this.comproProv =  aComproprov;
  }

  public Money getDtomonori() throws BaseException {
    supportRefresh();
    return dtoMonOri;
  }

  public void setDtomonori(Money aDtomonori) {
    this.dtoMonOri =  aDtomonori;
  }

  public Money getDtomonloc() throws BaseException {
    supportRefresh();
    return dtoMonLoc;
  }

  public void setDtomonloc(Money aDtomonloc) {
    this.dtoMonLoc =  aDtomonloc;
  }

  public java.util.Date getFecha() throws BaseException {
    supportRefresh();
    return fecha;
  }

  public void setFecha(java.util.Date aFecha) {
    this.fecha =  aFecha;
  }

  public ComproCab getComproop() throws BaseException {
    supportRefresh();
    return comproOP;
  }

  public void setComproop(ComproCab aComproop) {
    this.comproOP =  aComproop;
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

 public static DtoComproEnOP findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (DtoComproEnOP) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static DtoComproEnOP findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (DtoComproEnOP) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
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

}
