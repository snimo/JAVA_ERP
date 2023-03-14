package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.da.DBAplicacionIngDevStock;
import com.srn.erp.ventas.da.DBIngStockDevVtasDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class IngStockDevVtasDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public IngStockDevVtasDet() {
	}

	public static String NICKNAME = "ve.IngStockDevVtasDet";

	private IngresoDevolucionStockCab ingresoDevolucionStockCab;
	private DevolucionVtasDet devolucion_det;
	private Double cantidad;
	private UnidadMedida unidad_medida;
	private TipoConfMovStkTalonario movimiento_stock;

	public IngresoDevolucionStockCab getIngresodevolucionstockcab() throws BaseException {
		supportRefresh();
		return ingresoDevolucionStockCab;
	}

	public void setIngresodevolucionstockcab(IngresoDevolucionStockCab aIngresodevolucionstockcab) {
		this.ingresoDevolucionStockCab = aIngresodevolucionstockcab;
	}

	public DevolucionVtasDet getDevolucion_det() throws BaseException {
		supportRefresh();
		return devolucion_det;
	}

	public void setDevolucion_det(DevolucionVtasDet aDevolucion_det) {
		this.devolucion_det = aDevolucion_det;
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

	public TipoConfMovStkTalonario getMovimiento_stock() throws BaseException {
		supportRefresh();
		return movimiento_stock;
	}

	public void setMovimiento_stock(TipoConfMovStkTalonario aMovimiento_stock) {
		this.movimiento_stock = aMovimiento_stock;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static IngStockDevVtasDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (IngStockDevVtasDet) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static IngStockDevVtasDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (IngStockDevVtasDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static IngStockDevVtasDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (IngStockDevVtasDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(ingresoDevolucionStockCab, "Debe ingresar la Devolución");
		Validar.noNulo(devolucion_det, "Debe ingresar la Devolución Ventas ");
		Validar.noNulo(cantidad, "Debe ingresar la Cantidad");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(movimiento_stock, "Debe ingresar el Tipo de Configuración");
	}

	public static List getIngresoDevolucionesDet(IngresoDevolucionStockCab ingresoDevolucion, ISesion aSesion) throws BaseException {
		return DBIngStockDevVtasDet.getIngresoDevolucionesDet(ingresoDevolucion, aSesion);
	}
	
	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		// Grabar la aplicacion
		AplicacionIngDevStock aplicacionIngDevStock =
			(AplicacionIngDevStock) AplicacionIngDevStock.getNew(AplicacionIngDevStock.NICKNAME, this.getSesion());
		aplicacionIngDevStock.setDevolucion_stk_det(this);
		aplicacionIngDevStock.setDevolucion_vtas_det(this.getDevolucion_det());
		aplicacionIngDevStock.setCantidad(this.getCantidad());
		aplicacionIngDevStock.setActivo(new Boolean(true));
		aplicacionIngDevStock.save();
		
	}
	
	public List getAplicacionesByIngStockDet() throws BaseException {
		return AplicacionIngDevStock.getAplicacionesByIngStockDet(this, this.getSesion());
	}
	

	

}
