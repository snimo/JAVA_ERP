package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBAplicacionIngDevStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AplicacionIngDevStock extends ObjetoLogico {

	@Override
	public void anular() throws BaseException {
		// TODO Auto-generated method stub
		super.anular();
		
		// Ingresar las cantidades en Stock
		CalculadorMoney calcPendIngStk = new CalculadorMoney(new Money(this.getDevolucion_vtas_det().getCantPendIngStock()));
		if (this.getCantidad() != null)
			calcPendIngStk.sumar(new Money(this.getCantidad()));
		boolean pendIngStk = false;
		if (calcPendIngStk.getResult() <= 0)
			pendIngStk = false;
		else
			pendIngStk = true;

		CalculadorMoney calcCantIngStk = new CalculadorMoney(new Money(this.getDevolucion_vtas_det().getCantIngStk()));
		calcCantIngStk.restar(new Money(this.getCantidad()));

		this.getDevolucion_vtas_det().aplicarCantIngStk(calcCantIngStk.getResult(), pendIngStk);
		
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AplicacionIngDevStock() {
	}

	public static String NICKNAME = "ve.AplicacionIngDevStock";

	private DevolucionVtasDet devolucion_vtas_det;
	private IngStockDevVtasDet devolucion_stk_det;
	private Double cantidad;
	private Boolean activo;

	public DevolucionVtasDet getDevolucion_vtas_det() throws BaseException {
		supportRefresh();
		return devolucion_vtas_det;
	}

	public void setDevolucion_vtas_det(DevolucionVtasDet aDevolucion_vtas_det) {
		this.devolucion_vtas_det = aDevolucion_vtas_det;
	}

	public IngStockDevVtasDet getDevolucion_stk_det() throws BaseException {
		supportRefresh();
		return devolucion_stk_det;
	}

	public void setDevolucion_stk_det(IngStockDevVtasDet aDevolucion_stk_det) {
		this.devolucion_stk_det = aDevolucion_stk_det;
	}

	public Double getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Double aCantidad) {
		this.cantidad = aCantidad;
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

	public static AplicacionIngDevStock findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AplicacionIngDevStock) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AplicacionIngDevStock findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AplicacionIngDevStock) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(devolucion_vtas_det, "Debe ingresar la Devolución");
		Validar.noNulo(devolucion_stk_det, "Debe ingresar el Stock");
		Validar.noNulo(cantidad, "Debe ingresar la Cantidad");
	}

	public void afterSaveNew() throws BaseException {

		// TODO Auto-generated method stub
		super.afterSaveNew();

		// Ingresar las cantidades en Stock
		CalculadorMoney calcPendIngStk = new CalculadorMoney(new Money(this.getDevolucion_vtas_det().getCantPendIngStock()));
		if (this.getCantidad() != null)
			calcPendIngStk.restar(new Money(this.getCantidad()));
		boolean pendIngStk = false;
		if (calcPendIngStk.getResult() <= 0)
			pendIngStk = false;
		else
			pendIngStk = true;

		CalculadorMoney calcCantIngStk = new CalculadorMoney(new Money(this.getDevolucion_vtas_det().getCantIngStk()));
		calcCantIngStk.sumar(new Money(this.getCantidad()));

		this.getDevolucion_vtas_det().aplicarCantIngStk(calcCantIngStk.getResult(), pendIngStk);

	}

	public static List getAplicacionByDevVtasDetActivas(DevolucionVtasDet devolucionVtasDet, ISesion aSesion) throws BaseException {
		return DBAplicacionIngDevStock.getAplicacionByDevVtasDetActivas(devolucionVtasDet, aSesion);
	}

	public static List getAplicacionesByIngStockDet(IngStockDevVtasDet ingStockDet, ISesion aSesion) throws BaseException {
		return DBAplicacionIngDevStock.getAplicacionesByIngStockDet(ingStockDet, aSesion);
	}

}
