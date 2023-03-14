package com.srn.erp.stock.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.da.DBCostoProductoGral;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class CostoProductoGral extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CostoProductoGral() {
	}

	public static String NICKNAME = "st.CostoProductoGral";

	private ValorClasificadorEntidad val_clasif_ent;
	private ClasificadorEntidad clasificador;
	private java.util.Date fec_ult_costo;
	private Moneda moneda;
	private Money cantidad;
	private UnidadMedida um;
	private Money costo;
	private Boolean activo;
	private java.util.Date fecVigencia;
	
	public static String COMO_OBT_COSTO_LPP = "LP_VIG_PROV";
	public static String COMO_OBT_COSTO_COSTOS_HIST = "COSTOS_HIST";

	public java.util.Date getFecVigencia() {
		return fecVigencia;
	}

	public void setFecVigencia(java.util.Date fecVigencia) {
		this.fecVigencia = fecVigencia;
	}

	public ValorClasificadorEntidad getVal_clasif_ent() throws BaseException {
		supportRefresh();
		return val_clasif_ent;
	}

	public void setVal_clasif_ent(ValorClasificadorEntidad aVal_clasif_ent) {
		this.val_clasif_ent = aVal_clasif_ent;
	}

	public ClasificadorEntidad getClasificador() throws BaseException {
		supportRefresh();
		return clasificador;
	}

	public void setClasificador(ClasificadorEntidad aClasificador) {
		this.clasificador = aClasificador;
	}

	public java.util.Date getFec_ult_costo() throws BaseException {
		supportRefresh();
		return fec_ult_costo;
	}

	public void setFec_ult_costo(java.util.Date aFec_ult_costo) {
		this.fec_ult_costo = aFec_ult_costo;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Money getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Money aCantidad) {
		this.cantidad = aCantidad;
	}

	public UnidadMedida getUm() throws BaseException {
		supportRefresh();
		return um;
	}

	public void setUm(UnidadMedida aUm) {
		this.um = aUm;
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

	public static CostoProductoGral findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CostoProductoGral) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CostoProductoGral findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CostoProductoGral) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CostoProductoGral findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (CostoProductoGral) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(val_clasif_ent,
				"Debe ingresar el Valor del Clasificador");
		Validar.noNulo(clasificador, "Debe ingresar el clasificador");
		Validar.noNulo(fec_ult_costo, "Debe ingresar la Fecha Ultimo Costo");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(cantidad, "Debe ingresar la Cantidad");
		Validar.noNulo(um, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(costo, "Debe ingresar el Costo");
	}

	public static List getCostosProductosGral(ClasificadorEntidad clasificador,
			ValorClasificadorEntidad valClasifEnt, ISesion aSesion)
			throws BaseException {
		return DBCostoProductoGral.getCostosProductosGral(clasificador,
				valClasifEnt, aSesion);
	}

	public static HashTableDatos getConsultaMasivaProductos(
			java.util.Date fecha, Integer oidProducto, String descProducto,
			String descAbreviada, String codigoProducto,
			TipoProducto tipoProducto, boolean isComprable, boolean isVendible,
			boolean isStockeable, boolean isProdPropia, boolean isImportado,
			HashTableDatos listaValoresClasif, ISesion aSesion)
			throws BaseException {

		return DBCostoProductoGral.getConsultaMasivaProductos(fecha,
				oidProducto, descProducto, descAbreviada, codigoProducto,
				tipoProducto, isComprable, isVendible, isStockeable,
				isProdPropia, isImportado, listaValoresClasif, aSesion);

	}

	public static Money getCostoConvAUMVta(ExtensionProdGen producto,
			Money costo, Money cantCosto, UnidadMedida umCosto, Money cantPV,
			UnidadMedida umVenta, ISesion aSesion) throws BaseException {

		// Obtener el Factor de Conversion
		Money cantEnUV = producto.getConvertirUM(null, cantCosto.doubleValue(),
				umCosto, umVenta);

		// Calculador costo de Venta
		CalculadorMoney calcCostoVta = new CalculadorMoney(cantPV);
		calcCostoVta.multiplicarPor(costo);
		calcCostoVta.dividirPor(cantEnUV);

		return calcCostoVta.getResultMoney();
	}

	public static CostoProductoGral getCostoProductoByFecha(
			java.util.Date fecha, ValorClasifEntProdGen producto,
			ISesion aSesion) throws BaseException {

		return DBCostoProductoGral.getCostoProductoByFecha(fecha, producto,
				aSesion);
	}

	public static Money getCostoConvAUMVta(Producto producto, Money costo,
			Money cantCosto, UnidadMedida umCosto, Money cantPV,
			UnidadMedida umVenta, ISesion aSesion) throws BaseException {

		// Obtener el Factor de Conversion
		Money cantEnUV = producto.getConvertirUM(null, cantCosto.doubleValue(),
				umCosto, umVenta);

		// Calculador costo de Venta
		CalculadorMoney calcCostoVta = new CalculadorMoney(cantPV);
		calcCostoVta.multiplicarPor(costo);
		calcCostoVta.dividirPor(cantEnUV);

		return calcCostoVta.getResultMoney();
	}

	@Override
	public void afterSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveDelete();
		
		/*
		ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getVal_clasif_ent().getOIDInteger(), this.getSesion());

		if (valClasifEntProdGral != null) {

			Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
			while (iterProductos.hasNext()) {
				Producto producto = (Producto) iterProductos.next();
				CostoProducto costoProducto = producto.getCostoProductoAFecha(this.getFec_ult_costo());
				if (costoProducto != null) {
					costoProducto.delete();
					costoProducto.save();
				}
			}
				
		}*/
		
		
	}

	public void afterSave() throws BaseException {

		super.afterSave();

		/* Comenta esto de abajo porque no le veo sentido */
		
		/*
		ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getVal_clasif_ent().getOIDInteger(), this.getSesion());

		if (valClasifEntProdGral != null) {

			Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
			while (iterProductos.hasNext()) {
				Producto producto = (Producto) iterProductos.next();
				
				CostoProducto costoProducto = producto.getCostoProductoAFecha(this.getFec_ult_costo());
				if (costoProducto == null)
					costoProducto = (CostoProducto) CostoProducto.getNew(CostoProducto.NICKNAME, this.getSesion());
				costoProducto.setProducto(producto);
				costoProducto.setFec_ult_costo(this.getFec_ult_costo());
				costoProducto.setMoneda(this.getMoneda());
				if (this.getCantidad()!=null)
					costoProducto.setCantidad(this.getCantidad().doubleValue());
				else
					costoProducto.setCantidad(null);
				costoProducto.setUnidad_medida(this.getUm());
				costoProducto.setCosto(this.getCosto());
				costoProducto.setActivo(this.isActivo());
				if (!costoProducto.isActivo().booleanValue())
					costoProducto.delete();
				
				costoProducto.save();
			}

		}*/

	}
	
	public static CostoProductoGral getCostoProductoVigenteAFecha(
			  java.util.Date fecha,
			  ValorClasificadorEntidad producto,
	          ISesion aSesion)
	          throws BaseException {
		  
		  return DBCostoProductoGral.getCostoProductoVigenteAFecha(fecha,producto,aSesion);
	}
	
	public Money getCostoUnidario() throws BaseException {
		if ((this.getCantidad()==null) || (this.getCantidad().doubleValue()==0))
			return null;
		if (this.getCosto()==null)
			return null;
		CalculadorMoney calcCostoUni = new CalculadorMoney(this.getCosto());
		calcCostoUni.dividirPor(this.getCantidad());
		return calcCostoUni.getResultMoney();
	}
	
	public static HashTableDatos getListaComoObtenerCostos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(COMO_OBT_COSTO_LPP, "Lista de Precios Vigente Proveedor");
		condiciones.put(COMO_OBT_COSTO_COSTOS_HIST, "Históricos de Costos");
		return condiciones;
	}
	

}
