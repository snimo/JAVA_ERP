package com.srn.erp.stock.bm;

import com.srn.erp.stock.da.DBSaldoStockUbi;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SaldoStockUbi extends ObjetoLogico {

  public SaldoStockUbi() {
  }

  public static String NICKNAME = "st.SaldoStockUbi";

  private Deposito deposito;
  private UbicacionDeposito ubicacion_deposito;
  private UnidadMedida unidad_medida;
  private Producto producto;
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

 public static SaldoStockUbi findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (SaldoStockUbi) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static SaldoStockUbi findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (SaldoStockUbi) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(deposito, "Debe ingresar el Depósito");
    Validar.noNulo(ubicacion_deposito, "Debe ingresar la Ubicación del Depósito");
    Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
    Validar.noNulo(producto, "Debe ingresar el Producto");
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

  public static SaldoStockUbi getSaldoStockUbi(Producto producto,
                                               Deposito deposito,
                                               UbicacionDeposito ubicacionDeposito,
                                               ISesion aSesion) throws BaseException {
    return DBSaldoStockUbi.getSaldoStockUbi(producto,deposito,ubicacionDeposito,aSesion);
  }


}
