package com.srn.erp.stock.bm;

import com.srn.erp.stock.da.DBStockPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class StockPeriodo extends ObjetoLogico {

  public StockPeriodo() {
  }

  public static String NICKNAME = "st.StockPeriodo";

  private PeriodoStockReal peri_stock_real;
  private Deposito deposito;
  private UnidadMedida unidad_medida;
  private Producto producto;
  private Double entradas;
  private Double salidas;
  private Double movEntrada;
  private Double movSalida;

  public void setMovEntrada(Double aMovEntrada) throws BaseException {
    this.movEntrada = aMovEntrada;
  }

  public Double getMovEntrada() throws BaseException {
    return movEntrada;
  }

  public void setMovSalida(Double aMovSalida) throws BaseException {
    this.movSalida = aMovSalida;
  }

  public Double getMovSalida() throws BaseException {
    return movSalida;
  }

  public PeriodoStockReal getPeri_stock_real() throws BaseException {
    supportRefresh();
    return peri_stock_real;
  }

  public void setPeri_stock_real(PeriodoStockReal aPeri_stock_real) {
    this.peri_stock_real =  aPeri_stock_real;
  }

  public Deposito getDeposito() throws BaseException {
    supportRefresh();
    return deposito;
  }

  public void setDeposito(Deposito aDeposito) {
    this.deposito =  aDeposito;
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

  public Double getEntradas() throws BaseException {
    supportRefresh();
    return entradas;
  }

  public void setEntradas(Double aEntradas) {
    this.entradas =  aEntradas;
  }

  public Double getSalidas() throws BaseException {
    supportRefresh();
    return salidas;
  }

  public void setSalidas(Double aSalidas) {
    this.salidas =  aSalidas;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static StockPeriodo findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (StockPeriodo) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static StockPeriodo findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (StockPeriodo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(peri_stock_real, "Debe ingresar el Período");
    Validar.noNulo(deposito, "Debe ingresar el Depósito");
    Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
    Validar.noNulo(producto, "Debe ingresar el Producto");
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

  public static StockPeriodo getStockPeriodo(Producto producto,
                                             Deposito deposito,
                                             PeriodoStockReal periodoStockReal,
                                             ISesion aSesion)
                                             throws BaseException {
    return DBStockPeriodo.getStockPeriodo(producto,deposito,periodoStockReal,aSesion);
  }


}
