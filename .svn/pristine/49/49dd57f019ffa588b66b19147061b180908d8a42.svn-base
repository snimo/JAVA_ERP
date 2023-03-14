package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBAplicacionIngDevRto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AplicacionIngDevRto extends ObjetoLogico {

	@Override
	public void anular() throws BaseException {
		// TODO Auto-generated method stub
		super.anular();
		
		// Volver a dejar las cantidad devueltas del remito como corresponde
		if (this.getDevolucion_det().getRemito_det() != null) {
			Money cantDevueltas = new Money(0);
			if (this.getRemito_det().getCantDevuelta()!=null)
				cantDevueltas = new Money(this.getRemito_det().getCantDevuelta()); 
			CalculadorMoney calcTotalDevoluciones = new CalculadorMoney(cantDevueltas);
			if (this.getCantidad() != null)
				calcTotalDevoluciones.restar(new Money(this.getCantidad()));
			this.getRemito_det().actuCantidadesDevueltas(calcTotalDevoluciones.getResult());
		}
		
		// Registrar a nivel pedido las cantidades devueltas
		if (this.getRemito_det().getPedidoDet()!=null) {

			CalculadorMoney calcCantDesp = new CalculadorMoney(this.getRemito_det().getPedidoDet().getCant_um_ori_desp());
			calcCantDesp.sumar(new Money(this.getCantidad()));
			Double nuevaCantEnt = calcCantDesp.getResult(); 
			
			// Determinar el detalle del pedido si esta pendiente de entrega
			boolean pendDesp = true;
			
			if (this.getRemito_det().getPedidoDet().isPendDesp())
				pendDesp = true;
			else {
				if (nuevaCantEnt >= 
					this.getRemito_det().getPedidoDet().getCant_um_ori().doubleValue())
					pendDesp = false;
				else
					pendDesp = true;
			}
								
			this.getRemito_det().getPedidoDet().actualizarCantidadesDespachadas(nuevaCantEnt, pendDesp);
		}
		
		
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AplicacionIngDevRto() {
	}

	public static String NICKNAME = "ve.AplicacionIngDevRto";

	private RemitoDet remito_det;
	private DevolucionVtasDet devolucion_det;
	private Double cantidad;
	private Boolean activo;

	public RemitoDet getRemito_det() throws BaseException {
		supportRefresh();
		return remito_det;
	}

	public void setRemito_det(RemitoDet aRemito_det) {
		this.remito_det = aRemito_det;
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

	public static AplicacionIngDevRto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AplicacionIngDevRto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AplicacionIngDevRto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AplicacionIngDevRto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(remito_det, "Debe ingresar el Detalle del Remito");
		Validar.noNulo(devolucion_det, "Debe ingresar el Detalle de la Devolución");
		Validar.noNulo(cantidad, "Debe ingresar la Cantidad Devuelta");
	}

	@Override
	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		if (this.getDevolucion_det().getRemito_det() != null) {
			CalculadorMoney calcTotalDevoluciones = new CalculadorMoney(new Money(this.getCantidad()));
			if (this.getRemito_det().getCantDevuelta() != null)
				calcTotalDevoluciones.sumar(new Money(this.getRemito_det().getCantDevuelta().doubleValue()));
			this.getRemito_det().actuCantidadesDevueltas(calcTotalDevoluciones.getResult());
		}
		
		// Registrar a nivel pedido las cantidades devueltas
		if (this.getRemito_det().getPedidoDet()!=null) {

			CalculadorMoney calcCantDesp = new CalculadorMoney(this.getRemito_det().getPedidoDet().getCant_um_ori_desp());
			calcCantDesp.restar(new Money(this.getCantidad()));
			Double nuevaCantEnt = calcCantDesp.getResult(); 
			
			// Determinar el detalle del pedido si esta pendiente de entrega
			boolean pendDesp = true;
			
			if (this.getRemito_det().getPedidoDet().isPendDesp())
				pendDesp = true;
			else {
				if (nuevaCantEnt >= 
					this.getRemito_det().getPedidoDet().getCant_um_ori().doubleValue())
					pendDesp = false;
				else
					pendDesp = true;
			}
								
			this.getRemito_det().getPedidoDet().actualizarCantidadesDespachadas(nuevaCantEnt, pendDesp);
		}
		
		
	}

	public static List getAplicacionesActivasIngDevDet(
			DevolucionVtasDet devolucionVtasDet, 
			ISesion aSesion) throws BaseException {
		return DBAplicacionIngDevRto.getAplicacionesActivasIngDevDet(devolucionVtasDet, aSesion);
	}

}
