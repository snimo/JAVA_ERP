package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.da.DBCostoProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class CostoProducto extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CostoProducto() {
	}

	public static String NICKNAME = "st.CostoProducto";

	private java.util.Date fec_ult_costo;
	private Producto producto;
	private Moneda moneda;
	private Double cantidad;
	private UnidadMedida unidad_medida;
	private Money costo;
	private Boolean activo;

	public java.util.Date getFec_ult_costo() throws BaseException {
		supportRefresh();
		return fec_ult_costo;
	}

	public void setFec_ult_costo(java.util.Date aFec_ult_costo) {
		this.fec_ult_costo = aFec_ult_costo;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Double getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Double aCantidad) {
		this.cantidad = aCantidad;
	}

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public Money getCosto() throws BaseException {
		supportRefresh();
		return costo;
	}

	public void setCosto(Money aCosto) {
		this.costo = aCosto;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static CostoProducto findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CostoProducto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CostoProducto findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (CostoProducto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(fec_ult_costo, "Debe ingresar la fecha");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(cantidad, "Debe ingresar la cantidad");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(costo, "Debe ingresar el Costo");
	}

	public static List getCostosProducto(Producto producto, ISesion aSesion)
			throws BaseException {
		return DBCostoProducto.getCostosProducto(producto, aSesion);
	}

	public static CostoProducto getCostoProductoVigAFecha(
			java.util.Date fechaDesde, Producto producto, ISesion aSesion)
			throws BaseException {
		return DBCostoProducto.getCostoProductoVigAFecha(fechaDesde, producto,
				aSesion);
	}

	public static HashTableDatos getConsultaMasivaProductos(java.util.Date fecha,Integer oidProducto,
			String descProducto, String descAbreviada, String codigoProducto,
			TipoProducto tipoProducto, boolean isComprable, boolean isVendible,
			boolean isStockeable, boolean isProdPropia, boolean isImportado,
			HashTableDatos listaValoresClasif, ISesion aSesion)
			throws BaseException {

		return DBCostoProducto.getConsultaMasivaProductos(fecha, oidProducto,descProducto,
				descAbreviada, codigoProducto, tipoProducto, isComprable,
				isVendible, isStockeable, isProdPropia, isImportado,
				listaValoresClasif, aSesion);

	}
	
	public static Money getCostoConvAUMVta(Producto producto,
			                        Money costo,
			                        Money cantCosto,
			                        UnidadMedida umCosto,
			                        Money cantPV,
			                        UnidadMedida umVenta,
			                        ISesion aSesion) throws BaseException {
		
		// Obtener el Factor de Conversion
		Money cantEnUV = producto.getConvertirUM(null,cantCosto.doubleValue(),umCosto, umVenta);
		
		// Calculador costo de Venta
		CalculadorMoney calcCostoVta = new CalculadorMoney(cantPV);
		calcCostoVta.multiplicarPor(costo);
		calcCostoVta.dividirPor(cantEnUV);
				
		return calcCostoVta.getResultMoney();
	}
	
	  public static CostoProducto getCostoProductoByFecha(
			  java.util.Date fecha,
			  Producto producto,
	          ISesion aSesion)
	          throws BaseException {
		  
		  return DBCostoProducto.getCostoProductoByFecha(fecha,producto,aSesion);
	  }
	

}
