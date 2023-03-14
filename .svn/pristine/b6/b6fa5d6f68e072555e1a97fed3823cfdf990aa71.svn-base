package com.srn.erp.stock.bm;


import com.srn.erp.stock.da.DBSaldoStockProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SaldoStockProducto extends ObjetoLogico {

  public SaldoStockProducto() {
  }

  public static String NICKNAME = "st.SaldoStockProducto";

  private Producto producto;
  private UnidadMedida unidad_medida;
  private Deposito deposito;
  private Double saldo;
  private Double movimiento;


  public void setMovimiento(Double amovimiento) throws BaseException {
    this.movimiento = amovimiento;
  }

  public Double getMovimiento() throws BaseException {
    return movimiento;
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

 public static SaldoStockProducto findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (SaldoStockProducto) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static SaldoStockProducto findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (SaldoStockProducto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(producto, "Debe ingresar el Producto");
    Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
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

  public static SaldoStockProducto getSaldoStockProducto(Producto producto,
                                                         Deposito deposito,
                                                         ISesion aSesion)
                                                         throws BaseException {
    return DBSaldoStockProducto.getSaldoStockProducto(producto,deposito,aSesion);
  }


}
