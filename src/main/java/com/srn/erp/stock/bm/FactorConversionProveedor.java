package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.stock.da.DBFactorConversionProveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FactorConversionProveedor extends ObjetoLogico {

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public FactorConversionProveedor() {
	}

	public static String NICKNAME = "st.FactorConversionProveedor";

	private UnidadMedida unidad_medida;

	private ProductoProveedor producto_proveedor;

	private Double factor_conversion;

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public ProductoProveedor getProducto_proveedor() throws BaseException {
		supportRefresh();
		return producto_proveedor;
	}

	public void setProducto_proveedor(ProductoProveedor aProducto_proveedor) {
		this.producto_proveedor = aProducto_proveedor;
	}

	public Double getFactor_conversion() throws BaseException {
		supportRefresh();
		return factor_conversion;
	}

	public void setFactor_conversion(Double aFactor_conversion) {
		this.factor_conversion = aFactor_conversion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static FactorConversionProveedor findByOid(Integer oid,
			ISesion aSesion) throws BaseException {
		return (FactorConversionProveedor) getObjectByOid(NICKNAME, oid,
				aSesion);
	}

	public static FactorConversionProveedor findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (FactorConversionProveedor) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(producto_proveedor,
				"Debe ingresar el Producto Proveedor");
	}

	public static List getFactoresConversion(
			ProductoProveedor productoProveedor, ISesion aSesion)
			throws BaseException {
		return DBFactorConversionProveedor.getFactoresConversion(
				productoProveedor, aSesion);
	}
	
	public static List getFactoresConversion(
			UnidadMedida unidadMedida, ISesion aSesion)
			throws BaseException {
		return DBFactorConversionProveedor.getFactoresConversion(unidadMedida,aSesion);
	}	
	
	public static List getFactoresConversion(
			UnidadMedida unidadMedida,
			Producto producto,
			Proveedor proveedor,
			ISesion aSesion)
			throws BaseException {
		return DBFactorConversionProveedor.getFactoresConversion(unidadMedida,producto,proveedor,aSesion);
	}	
	

}
