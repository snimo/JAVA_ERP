package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBProdHabUbiDepo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ProdHabUbiDepo extends ObjetoLogico {

	public ProdHabUbiDepo() {
	}

	public static String NICKNAME = "st.ProdHabUbiDepo";

	private UbicacionDeposito ubicacion_deposito;

	private Producto producto;

	public UbicacionDeposito getUbicacion_deposito() throws BaseException {
		supportRefresh();
		return ubicacion_deposito;
	}

	public void setUbicacion_deposito(UbicacionDeposito aUbicacion_deposito) {
		this.ubicacion_deposito = aUbicacion_deposito;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ProdHabUbiDepo findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ProdHabUbiDepo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ProdHabUbiDepo findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (ProdHabUbiDepo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(ubicacion_deposito,
				"Debe ingresar la Ubicación del Depósito");
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

	public static List getProductosHabilitados(
			UbicacionDeposito ubicacionDeposito, ISesion aSesion)
			throws BaseException {
		return DBProdHabUbiDepo.getProductosHabilitados(ubicacionDeposito,
				aSesion);
	}

	public static ProdHabUbiDepo getProdHab(
			UbicacionDeposito ubicacionDeposito, 
			Producto producto,
			ISesion aSesion) throws BaseException {		
		return DBProdHabUbiDepo.getProdHab(ubicacionDeposito,producto,aSesion);
		
	}

}
