package com.srn.erp.ventas.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.TipoProducto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.da.DBListaPreciosDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ListaPreciosDet extends ObjetoLogico {

  public ListaPreciosDet() {
  }

  public static String NICKNAME = "ve.ListaPreciosDet";

  private ListaPrecios lista_precio;
  private Producto producto;
  private UnidadMedida unidad_medida;
  private Double cantidad;
  private Moneda moneda;
  private Money precio;
  private Boolean activo;
  private Date fecUltAct;

  public ListaPrecios getLista_precio() throws BaseException {
    supportRefresh();
    return lista_precio;
  }

  public void setLista_precio(ListaPrecios aLista_precio) {
    this.lista_precio =  aLista_precio;
  }
  
  public Date getFecUltAct() throws BaseException {
	supportRefresh();
	return this.fecUltAct;
  }

  public void setFecUltAct(Date aFecUltAct) {
	this.fecUltAct =  aFecUltAct;
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

  public Double getCantidad() throws BaseException {
    supportRefresh();
    return cantidad;
  }

  public void setCantidad(Double aCantidad) {
    this.cantidad =  aCantidad;
  }

  public Moneda getMoneda() throws BaseException {
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) {
    this.moneda =  aMoneda;
  }

  public Money getPrecio() throws BaseException {
    supportRefresh();
    return precio;
  }

  public Money getPrecio(ValorCotizacion monedaOri,
                         ValorCotizacion monedaDest) throws BaseException {
    return Cotizacion.convertir(getPrecio(),monedaOri,monedaDest);
  }

  public void setPrecio(Money aPrecio) {
    this.precio =  aPrecio;
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

 public static ListaPreciosDet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ListaPreciosDet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ListaPreciosDet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ListaPreciosDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(lista_precio, "Debe ingresar la Lista de Precios");
    Validar.noNulo(producto, "Debe ingresar el Producto");
    Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
    Validar.noNulo(cantidad, "Debe ingresar la Cantidad");
    Validar.noNulo(moneda, "Debe ingresar la Moneda");
    Validar.noNulo(precio, "Debe ingresar el Precio");
 }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  public static ListaPreciosDet getListaPrecioDetByListaProducto(ListaPrecios listaPrecio,
                                                                 Producto producto,
                                                                 UnidadMedida unidadMedida,
                                                                 ISesion aSesion)
                                                      throws BaseException {

    return DBListaPreciosDet.getListaPrecioDetByListaProducto(listaPrecio,producto,unidadMedida,aSesion);
  }
  
  public static List getDetallesListaPrecios(ListaPrecios listaPrecios,
			 ISesion aSesion) throws BaseException {
  	return DBListaPreciosDet.getDetallesListaPrecios(listaPrecios,aSesion);
  }
  
  public static List getConsultaMasivaProductos(
		    ListaPrecios lp,
		    Integer oidProducto,
	  		String descProducto,
	  		String descAbreviada,
	  		String codigoProducto,
	  		TipoProducto tipoProducto,  		
	  		boolean isComprable,
	  		boolean isVendible,
	  		boolean isStockeable,
	  		boolean isProdPropia,
	  		boolean isImportado,
	  		HashTableDatos listaValoresClasif,
	        ISesion aSesion) throws BaseException {
	  	
	  	return DBListaPreciosDet.getConsultaMasivaProductos(
	  			lp,
	  			oidProducto,
	  			descProducto,
	  			descAbreviada,
	  			codigoProducto,
	  			tipoProducto,
	  			isComprable,
	  			isVendible,
	  			isStockeable,
	  			isProdPropia,
	  			isImportado,
	  			listaValoresClasif,
	  			aSesion);
	  }
		






}
