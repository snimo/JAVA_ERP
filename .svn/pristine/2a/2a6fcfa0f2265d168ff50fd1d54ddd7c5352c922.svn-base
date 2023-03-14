package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBConversionUMProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConversionUMProducto extends ObjetoLogico {

  public ConversionUMProducto() {
  }

  public static String NICKNAME = "st.ConversionUMProducto";

  private Producto producto;
  private UnidadMedida unidad_Medida_Origen;
  private UnidadMedida unidad_Medida_Dest;
  private Double fact_conv;

  public Producto getProducto() throws BaseException {
    supportRefresh();
    return producto;
  }

  public void setProducto(Producto aProducto) {
    this.producto =  aProducto;
  }

  public UnidadMedida getUnidad_medida_origen() throws BaseException {
    supportRefresh();
    return unidad_Medida_Origen;
  }

  public void setUnidad_medida_origen(UnidadMedida aUnidad_medida_origen) {
    this.unidad_Medida_Origen =  aUnidad_medida_origen;
  }

  public UnidadMedida getUnidad_medida_dest() throws BaseException {
    supportRefresh();
    return unidad_Medida_Dest;
  }

  public void setUnidad_medida_dest(UnidadMedida aUnidad_medida_dest) {
    this.unidad_Medida_Dest =  aUnidad_medida_dest;
  }

  public Double getFact_conv() throws BaseException {
    supportRefresh();
    return fact_conv;
  }

  public void setFact_conv(Double aFact_conv) {
    this.fact_conv =  aFact_conv;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static ConversionUMProducto findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ConversionUMProducto) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ConversionUMProducto findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ConversionUMProducto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
   Validar.noNulo(producto,"Debe ingresar el producto");
   Validar.noNulo(unidad_Medida_Origen,"Debe ingresar la Unidad de Medida de Origen");
   Validar.noNulo(unidad_Medida_Dest,"Debe ingresar la Unidad de Medida de Destino");
   Validar.noNulo(fact_conv,"Debe ingresar el Factor de conversión");
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

  public static List getConversionesUMProducto(Producto aProducto,ISesion aSesion) throws BaseException {
    return DBConversionUMProducto.getConversionesUM(aProducto,aSesion);
  }

  public static ConversionUMProducto getByProductoUMOriUMDest(Producto producto,
                                                       UnidadMedida unidadMedidaOri,
                                                       UnidadMedida unidadMedidaDest,
                                                       ISesion aSesion) throws BaseException {
    return DBConversionUMProducto.getByProductoUMOriUMDest(producto,
                                                           unidadMedidaOri,
                                                           unidadMedidaDest,
                                                           aSesion);

  }
  
  public static ConversionUMProducto getConversionUMProducto(UnidadMedida unidadMedidaOri,
          UnidadMedida unidadMedidaDes, 	
          ISesion aSesion)
  			throws BaseException {
	return  DBConversionUMProducto.getConversionUMProducto(unidadMedidaOri,unidadMedidaDes,aSesion);
  }  



}
