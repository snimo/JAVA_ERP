package com.srn.erp.stock.bm;

import com.srn.erp.general.bm.ComproCab;

import framework.request.bl.Utils.BaseException;

public class RenglonMovStock {

  private ComproCab comproCab;
  private Deposito deposito;
  private UbicacionDeposito ubicacionDeposito;
  private EstadoStock estadoStock;
  private Partida partida;
  private Serie serie;
  private Producto producto;
  private java.util.Date fecha;
  private Double cantidad;
  private Integer signo;
  private UnidadMedida unidadMedida;
  private Boolean afectaStockFisico;
  private java.util.Date fechaArrivo;
  private Double cantRecibida;
  private Boolean pendArrivo;
  private Boolean activo;
  private Integer oidCCODet;
  private ComproCab comproCabDestino;
  private Integer oidCCODetDestino;

  public Integer getOidCCODet() {
	return oidCCODet;
}

public void setOidCCODet(Integer oidCCODet) {
	this.oidCCODet = oidCCODet;
	if (this.getOidCCODetDestino()==null)
		this.setOidCCODetDestino(oidCCODet);
}

public ComproCab getComproCabDestino() {
	return comproCabDestino;
}

public void setComproCabDestino(ComproCab comproCabDestino) {
	this.comproCabDestino = comproCabDestino;
}

public Integer getOidCCODetDestino() {
	return oidCCODetDestino;
}

public void setOidCCODetDestino(Integer oidCCODetDestino) {
	this.oidCCODetDestino = oidCCODetDestino;
}

public RenglonMovStock() throws BaseException {
  }

  public void setComproCab(ComproCab aComproCab) throws BaseException {
    this.comproCab = aComproCab;
    if (this.getComproCabDestino()==null)
    	this.setComproCabDestino(aComproCab);
  }

  public ComproCab getComproCab() throws BaseException {
    return comproCab;
  }

  public void setDeposito(Deposito aDeposito) throws BaseException {
    this.deposito = aDeposito;
  }

  public Deposito getDeposito() throws BaseException {
    return deposito;
  }

  public void setUbicacionDeposito(UbicacionDeposito aUbicacionDeposito) throws BaseException {
    this.ubicacionDeposito = aUbicacionDeposito;
  }

  public UbicacionDeposito getUbicacionDeposito() throws BaseException {
    return this.ubicacionDeposito;
  }

  public void setEstadoStock(EstadoStock aEstadoStock) throws BaseException {
      this.estadoStock = aEstadoStock;
  }

  public EstadoStock getEstadoStock() throws BaseException {
    return this.estadoStock;
  }

  public void setPartida(Partida aPartida) throws BaseException {
    this.partida = aPartida;
  }

  public Partida getPartida() throws BaseException {
    return partida;
  }

  public void setSerie(Serie aSerie) throws BaseException {
    this.serie = aSerie;
  }

  public Serie getSerie() throws BaseException {
    return this.serie;
  }

  public void setProducto(Producto aProducto) throws BaseException {
    this.producto = aProducto;
  }

  public Producto getProducto() throws BaseException {
    return producto;
  }

  public void setFecha(java.util.Date aFecha) throws BaseException {
    this.fecha = aFecha;
  }

  public java.util.Date getFecha() throws BaseException {
    return fecha;
  }

  public void setCantidad(Double aCantidad) throws BaseException {
    this.cantidad = new Double(Math.abs(aCantidad.doubleValue()));
  }

  public Double getCantidad() throws BaseException {
    return cantidad;
  }

  public void setSigno(Integer aSigno) throws BaseException {
    this.signo = aSigno;
  }

  public Integer getSigno() throws BaseException {
    return signo;
  }

  public void setUnidadMedida(UnidadMedida aUnidadMedida) throws BaseException {
    this.unidadMedida = aUnidadMedida;
  }

  public UnidadMedida getUnidadMedida() throws BaseException {
    return unidadMedida;
  }

  public void setAfectaStockFisico(Boolean aAfectaStockFisico) throws BaseException {
    this.afectaStockFisico = aAfectaStockFisico;
  }

  public Boolean isAfectaStockFisico() throws BaseException {
    return this.afectaStockFisico;
  }

  public void setFechaArrivo(java.util.Date aFechaArrivo) throws BaseException {
    this.fechaArrivo = aFechaArrivo;
  }

  public java.util.Date getFechaArrivo() throws BaseException {
    return this.fechaArrivo;
  }

  public void setCantRecibifa(Double cantRecibida) throws BaseException {
    this.cantRecibida = cantRecibida;
  }

  public Double getCantRecibida() throws BaseException {
    return this.cantRecibida;
  }

  public void setPendArrivo(Boolean aPendArrivo) throws BaseException {
    this.pendArrivo = aPendArrivo;
  }

  public Boolean getPendArrivo() throws BaseException {
    return pendArrivo;
  }

  public void setActivo(Boolean aActivo) throws BaseException {
    this.activo = aActivo;
  }

  public Boolean isActivo() throws BaseException {
    return activo;
  }

}
