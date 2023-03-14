package com.srn.erp.ventas.bm;

import java.util.Iterator;

import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.IObservadorSaldoProdDepoEstadoItem;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockMovimiento;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ObservadorReservasPedidoDet implements IObservadorSaldoProdDepoEstadoItem {
	
	
	private Money getSaldoEstado(
			Deposito deposito,
			Producto producto,
			EstadoStock estado,
			Integer oidComproDestino,
			Integer oidComproDestinoDet,
			ISesion aSesion) throws BaseException {
		
		Iterator iterMovPorEstado = 
			StockMovimiento.getMovByDepoProdEstadoComproDestino(
					aSesion, 
					producto, 
					deposito, 
					estado, 
					oidComproDestino, 
					oidComproDestinoDet).iterator();
		
		CalculadorMoney calcSaldoEstado = new CalculadorMoney(new Money(0));
		while (iterMovPorEstado.hasNext()) {
			StockMovimiento stockMovimiento = (StockMovimiento) iterMovPorEstado.next();
			
			CalculadorMoney calcMov = new CalculadorMoney(new Money(stockMovimiento.getCantidad()));
			calcMov.multiplicarPor(new Money(stockMovimiento.getSigno()));
			
			calcSaldoEstado.sumar(calcMov.getResultMoney());
			
		}
		return calcSaldoEstado.getResultMoney();
		
	}

	public void ejecutar(StockMovimiento stockMovimiento , ISesion sesion) throws BaseException {
		
		// Si el comprobante destino de la reserva no esta seteado no hacer nada
		if (stockMovimiento.getComprobanteDestino()==null)
			return;
		
		
		
		// Si no es un pedido no hacer nada
		if (stockMovimiento.getComprobanteDestino().getComportamiento()==null) return;
		if (!IdentificacionTipoComprobante.esPedidoCliente(stockMovimiento.getComprobanteDestino().getComportamiento()))
			return;
		
		// Si no es una reserva irse
		EstadoStock estadoStockReserva = EstadoStock.getEstadoStockReservado(sesion);
		
		if (stockMovimiento.getEstado_stock().getOID() != estadoStockReserva.getOID())
			return;
		
		// Si no se especifico item no hacer ninguna reserva automatica 
		if (stockMovimiento.getOidComproDestinoDet()==null)
			return;
				
		// Actualizar las reservas automaticamente
		ReservaPedidoDet reservaPedDet =
			ReservaPedidoDet.findByOid(stockMovimiento.getOidComproDestinoDet(), sesion);

		
		if (reservaPedDet == null) return;
		
		CalculadorMoney calcCantReserva = new CalculadorMoney(new Money(stockMovimiento.getCantidad()));
		calcCantReserva.multiplicarPor(new Money(stockMovimiento.getSigno()));
		calcCantReserva.sumar(reservaPedDet.getCant_um_ori_res());
		
		// Controles Reservas Pedido
		if (calcCantReserva.getResult()<0)
			throw new ExceptionValidation(null,"La cantidad reservada del item del Pedido "+stockMovimiento.getComprobanteDestino().getCodigo()+" no puede ser negativa");
		
		PedidoDet pedidoDet = (PedidoDet)
		  PedidoDet.findByOid(stockMovimiento.getOidComproDestinoDet(), sesion);
		
		if (pedidoDet.getCantPendEntUniOri().doubleValue()<calcCantReserva.getResult())
			throw new ExceptionValidation(null,"La cantidad reservada no puede superar a la cantidad pendiente de entrega para el item del pedido "+stockMovimiento.getComprobanteDestino().getCodigo());
		
		// Si esta desreservando verificar que exista saldo de reserva para ese item del Pedido
		if ((stockMovimiento.getEstado_stock().getOID() == estadoStockReserva.getOID()) 
				&& 
				(stockMovimiento.getSigno().intValue()==-1)) {
			
			// Si entro aca es porque esta desreservando
			
			Money saldo = getSaldoEstado(
					stockMovimiento.getDeposito(),
					stockMovimiento.getProducto(),
					stockMovimiento.getEstado_stock(),
					stockMovimiento.getComprobanteDestino().getOIDInteger(),
					stockMovimiento.getOidComproDestinoDet(),sesion);
					
			if (saldo.doubleValue()<0) {
				throw new ExceptionValidation(null,"No se puede desreserva "+
						stockMovimiento.getCantidad().toString()+" en el depósito "+Util.ENTER()+
						stockMovimiento.getDeposito().getDescripcion()+" porque el saldo de la reserva en el mismo es menor que la cantidad a desreservar "+
						" para el producto "+Util.ENTER()+
						stockMovimiento.getProducto().getCodigo()+"-"+
						stockMovimiento.getProducto().getDescripcion()+" "+Util.ENTER()+
						" del pedido "+
						stockMovimiento.getComprobanteDestino().getCodigo()+Util.ENTER()+
						"(Verifique en que depósitos se realizaron las reservas)"
						);
			}
					
			
		}
		
		reservaPedDet.setCant_um_ori_res(calcCantReserva.getResultDecimal());
		reservaPedDet.save();
		
		
		
	}

}
