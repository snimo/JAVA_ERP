package com.srn.erp.stock.bm;

import com.srn.erp.stock.da.DBSaldoStockPartidaSerie;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SaldoStockPartidaSerie extends ObjetoLogico {

  public SaldoStockPartidaSerie() {
  }

  public static String NICKNAME = "st.SaldoStockPartidaSerie";

  private Partida partida;
  private Producto producto;
  private UnidadMedida unidad_medida;
  private Boolean saldo_cero;
  private Serie serie;
  private UbicacionDeposito ubicacion_deposito;
  private EstadoStock estado_stock;
  private Deposito deposito;
  private Double saldo;
  private Double movimiento;

  public void setMovimiento(Double aMovimiento) throws BaseException {
    this.movimiento = aMovimiento;
  }

  public Double getMovimiento() throws BaseException {
    return movimiento;
  }

  public Partida getPartida() throws BaseException {
    supportRefresh();
    return partida;
  }

  public void setPartida(Partida aPartida) {
    this.partida =  aPartida;
  }

  public Producto getProducto() throws BaseException {
    supportRefresh();
    return producto;
  }

  public void setProducto(Producto aProducto) {
    this.producto =  aProducto;
  }

  public UnidadMedida getUnidad_medida() throws BaseException {
    supportRefresh();
    return unidad_medida;
  }

  public void setUnidad_medida(UnidadMedida aUnidad_medida) {
    this.unidad_medida =  aUnidad_medida;
  }

  public Boolean isSaldo_cero() throws BaseException {
    supportRefresh();
    return saldo_cero;
  }

  public void setSaldo_cero(Boolean aSaldo_cero) {
    this.saldo_cero =  aSaldo_cero;
  }

  public Serie getSerie() throws BaseException {
    supportRefresh();
    return serie;
  }

  public void setSerie(Serie aSerie) {
    this.serie =  aSerie;
  }

  public UbicacionDeposito getUbicacion_deposito() throws BaseException {
    supportRefresh();
    return ubicacion_deposito;
  }

  public void setUbicacion_deposito(UbicacionDeposito aUbicacion_deposito) {
    this.ubicacion_deposito =  aUbicacion_deposito;
  }

  public EstadoStock getEstado_stock() throws BaseException {
    supportRefresh();
    return estado_stock;
  }

  public void setEstado_stock(EstadoStock aEstado_stock) {
    this.estado_stock =  aEstado_stock;
  }

  public Deposito getDeposito() throws BaseException {
    supportRefresh();
    return deposito;
  }

  public void setDeposito(Deposito aDeposito) {
    this.deposito =  aDeposito;
  }

  public Double getSaldo() throws BaseException {
    supportRefresh();
    return saldo;
  }

  public void setSaldo(Double aSaldo) {
    this.saldo =  aSaldo;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static SaldoStockPartidaSerie findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (SaldoStockPartidaSerie) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static SaldoStockPartidaSerie findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (SaldoStockPartidaSerie) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(producto, "Debe ingresar el Producto");
    Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
    Validar.noNulo(saldo_cero, "Debe ingresar si el saldo es cero");
    Validar.noNulo(ubicacion_deposito, "Debe ingresar la Ubicación del Depósito");
    Validar.noNulo(estado_stock, "Debe ingresar el Estado de Stock");
    Validar.noNulo(deposito, "Debe ingresar el Depósito");
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

  public static SaldoStockPartidaSerie getSaldoStockPartidaSerie(Deposito deposito,
                                                                 Producto producto,
                                                                 UbicacionDeposito ubiDepo,
                                                                 EstadoStock estadoStock,
                                                                 Partida partida,
                                                                 Serie serie,
                                                                 ISesion aSesion)
                                                      throws BaseException {
    return DBSaldoStockPartidaSerie.getSaldoStockPartidaSerie(deposito,producto,
                                                       ubiDepo,estadoStock,
                                                       partida,serie,
                                                       aSesion);
  }


}
