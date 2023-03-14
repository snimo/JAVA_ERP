package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.da.DBStockCabecera;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class StockCabecera extends ObjetoLogico {

	private List movimientosStock = new ArrayList();

	private boolean readMovimientosStock = true;

	public StockCabecera() {
	}

	public static String NICKNAME = "st.StockCabecera";

	private ComproCab comprobante;

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static StockCabecera findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (StockCabecera) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static StockCabecera findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (StockCabecera) getObjectByCodigo(NICKNAME, codigo, aSesion);
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

	public void beforeSave() throws BaseException {
		Validar.noNulo(comprobante, "Debe ingresar un Comprobante");
	}

	public static StockCabecera getStockCabecera(ComproCab comproCab,
			ISesion aSesion) throws BaseException {
		return DBStockCabecera.getStockCabecera(comproCab, aSesion);
	}

	public static boolean tieneMovStock(ComproCab comproCab, ISesion aSesion)
			throws BaseException {
		StockCabecera stockCabecera = getStockCabecera(comproCab, aSesion);
		if (stockCabecera == null)
			return false;
		else
			return true;
	}

    public RenglonesStock getRenglonesStockInvertidos(ComproCab comproAnulador) throws BaseException {
		
		RenglonesStock renglonesStock = new RenglonesStock();
		
		Iterator iterMovStock = getMovimientosStock().iterator();
		while (iterMovStock.hasNext()) {
			StockMovimiento stockMovimiento = (StockMovimiento) iterMovStock.next();
			RenglonMovStock renglonMovStk = renglonesStock.addRenglonMovStock();
			renglonMovStk.setComproCab(comproAnulador);
			renglonMovStk.setDeposito(stockMovimiento.getDeposito());
			renglonMovStk.setUbicacionDeposito(stockMovimiento.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(stockMovimiento.getEstado_stock());
			renglonMovStk.setPartida(stockMovimiento.getPartida());
			renglonMovStk.setSerie(stockMovimiento.getSerie());
			renglonMovStk.setProducto(stockMovimiento.getProducto());
			renglonMovStk.setFecha(comproAnulador.getImputac());
			renglonMovStk.setCantidad(stockMovimiento.getCantidad());
			renglonMovStk.setUnidadMedida(stockMovimiento.getUnidad_medida());
			renglonMovStk.setAfectaStockFisico(stockMovimiento.isAfecta_stk_fisico());
			renglonMovStk.setActivo(stockMovimiento.isActivo());
			renglonMovStk.setOidCCODet(stockMovimiento.getOidComproDet());
			renglonMovStk.setComproCabDestino(stockMovimiento.getComprobanteDestino());
			renglonMovStk.setOidCCODetDestino(stockMovimiento.getOidComproDestinoDet());
			
			if (stockMovimiento.getSigno().intValue() == 1)
				renglonMovStk.setSigno(new Integer(-1));
			else
				renglonMovStk.setSigno(new Integer(1));
			
		}
		return renglonesStock;
	}	

   public List getMovimientosStock() throws BaseException {
		if (readMovimientosStock) {
			List listaMovStock = StockMovimiento.getMovByComprobante(
					getComprobante(), getSesion());
			movimientosStock.addAll(listaMovStock);
			readMovimientosStock = false;
		}
		return movimientosStock;
	}

}
