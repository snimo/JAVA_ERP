package com.srn.erp.stock.bm;

import com.srn.erp.stock.da.DBSaldoStockUbiEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SaldoStockUbiEstado extends ObjetoLogico {

  public SaldoStockUbiEstado() {
  }

  public static String NICKNAME = "st.SaldoStockUbiEstado";

  private Deposito deposito;
  private UbicacionDeposito ubicacion_deposito;
  private UnidadMedida unidad_medida;
  private Producto producto;
  private EstadoStock estado_stock;
  private Double saldo;
  private Double movimiento;

  public void setMovimiento(Double aMovimiento) throws BaseException {
    this.movimiento = aMovimiento;
  }

  public Double getMovimiento() throws BaseException {
    return this.movimiento;
  }

  public Deposito getDeposito() throws BaseException {
    supportRefresh();
    return deposito;
  }

  public void setDeposito(Deposito aDeposito) {
    this.deposito =  aDeposito;
  }

  public UbicacionDeposito getUbicacion_deposito() throws BaseException {
    supportRefresh();
    return ubicacion_deposito;
  }

  public void setUbicacion_deposito(UbicacionDeposito aUbicacion_deposito) {
    this.ubicacion_deposito =  aUbicacion_deposito;
  }

  public UnidadMedida getUnidad_medida() throws BaseException {
    supportRefresh();
    return unidad_medida;
  }

  public void setUnidad_medida(UnidadMedida aUnidad_medida) {
    this.unidad_medida =  aUnidad_medida;
  }

  public Producto getProducto() throws BaseException {
    supportRefresh();
    return producto;
  }

  public void setProducto(Producto aProducto) {
    this.producto =  aProducto;
  }

  public EstadoStock getEstado_stock() throws BaseException {
    supportRefresh();
    return estado_stock;
  }

  public void setEstado_stock(EstadoStock aEstado_stock) {
    this.estado_stock =  aEstado_stock;
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

 public static SaldoStockUbiEstado findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (SaldoStockUbiEstado) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static SaldoStockUbiEstado findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (SaldoStockUbiEstado) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(deposito, "Debe ingresar el Depósito");
    Validar.noNulo(ubicacion_deposito, "Debe ingresar la Ubicación del Depósito");
    Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
    Validar.noNulo(producto, "Debe ingresar el Producto");
    Validar.noNulo(estado_stock, "Debe ingresar el Estdo de Stock");
    Validar.noNulo(saldo, "Debe ingresar el Saldo");
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

  public static SaldoStockUbiEstado getSaldoStockUbiEstado(Producto producto,
                                                           Deposito deposito,
                                                           UbicacionDeposito ubiDepo,
                                                           EstadoStock estStock,
                                                           ISesion aSesion)
                                                           throws BaseException {
    return DBSaldoStockUbiEstado.getSaldoStockUbiEstado(producto,deposito,ubiDepo,estStock,aSesion);
  }


}
