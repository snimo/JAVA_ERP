package com.srn.erp.ventas.op;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStkProdPorEstado;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.RenglonAnaCumpPed;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Decimal;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class AnalisisCumpliPedidos extends Operation {

	AgrupadorDeposito agrupadorDeposito = null;
	HashTableDatos saldoInicialProd = new HashTableDatos();
	EstadoStock estadoStockLibre = null;
	List renglonesAnalisisCumpPed = new ArrayList();
	int orden = 0;
	CalculadorMoney saldoAcum = new CalculadorMoney(new Money(0));

	public AnalisisCumpliPedidos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		
		IDataSet dsStock = this.getDataSetStockAFuturo();
		
		agrupadorDeposito = AgrupadorDeposito.findByOidProxy(mapaDatos.getInteger("oid_agrupador_deposito"), this.getSesion());

		estadoStockLibre = EstadoStock.getEstadoStockLibre(this.getSesion());
		
		Producto producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"), this.getSesion());

		Money saldoInicial = getSaldoIniProd(producto);
		
		cargarRegistroStockAFuturo(dsStock, 
				new Integer(++orden), 
				"Stock a hoy", 
				Fecha.getFechaActual(), 
				new Integer(0), 
				new Integer(0), 
				"", 
				"", 
				1,
				saldoInicial, 
				saldoInicial);
		
		List detallesPedidos = PedidoDet.getDetallesPendDesp(null, null, null,
				null, null, null, null, null, null, producto, this.getSesion());

		// Obtener los Pedidos pendientes de entrega
		Iterator iterDetalles = detallesPedidos.iterator();
		while (iterDetalles.hasNext()) {
			PedidoDet pedidoDet = (PedidoDet) iterDetalles.next();
			Decimal cantSinResNiSep = pedidoDet.getCantSinReserNiSepa();
			
			if (cantSinResNiSep.doubleValue() <= 0) {
				// Significa que el detalle del pedido esta cubierto con las
				// reservas y separaciones
				continue;
			}
			
			RenglonAnaCumpPed renglonCumpPedido = getArmarRenglonPedido(pedidoDet,new Money(cantSinResNiSep.doubleValue()));
			renglonesAnalisisCumpPed.add(renglonCumpPedido);
		}
		
		// Obtener las Orden de compras
		Iterator iterDetOC = 
			producto.getDetallesOCPendRecep().iterator();
		while (iterDetOC.hasNext()) {
			OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterDetOC.next();
			Money cantPendRec = new Money(ocDet.getCantPendRecepUS());
			RenglonAnaCumpPed renglonCumpPedido = getArmarRenglonOC(ocDet, cantPendRec);
			renglonesAnalisisCumpPed.add(renglonCumpPedido);
			
		}
		
		// Obtener las Requisiciones Pendientes de Compra
		Iterator iterRequi = 
			producto.getRequisicionesPendCompra().iterator();
		while (iterRequi.hasNext()) {
			RequisicionDet requiDet = (RequisicionDet) iterRequi.next();
			Money cantRequi = new Money(requiDet.getcantPendCompra());
			RenglonAnaCumpPed renglonCumpPedido = getArmarRenglonRequi(requiDet, cantRequi);
			renglonesAnalisisCumpPed.add(renglonCumpPedido);
			
		}
		
		
		
		// Ordenar los renglones por Fecha
		Collections.sort(renglonesAnalisisCumpPed);
		Iterator iterRenglones = 
			renglonesAnalisisCumpPed.iterator();
		while (iterRenglones.hasNext()) {
			RenglonAnaCumpPed renglon = (RenglonAnaCumpPed) iterRenglones.next();
			cargarRegistroStockAFuturo(
					dsStock, 
					orden, 
					renglon.getConcepto(), 
					renglon.getFecha(), 
					renglon.getNroRenglon(), 
					renglon.getComprobante().getOIDInteger(), 
					renglon.getComprobante().getCodigo(), 
					renglon.getReferencia(), 
					renglon.getSigno(),
					renglon.getCantidad(), 
					renglon.getSaldo());
		}
		
		writeCliente(dsStock);

	}

	private Money getSaldoIniProd(Producto producto) throws BaseException {
		CalculadorMoney calcSaldo = new CalculadorMoney(new Money(0));
		Iterator iterSaldosPorEstado = producto.getSaldosPorEstados(
				agrupadorDeposito, estadoStockLibre).iterator();
		while (iterSaldosPorEstado.hasNext()) {
			SaldoStkProdPorEstado saldo = (SaldoStkProdPorEstado) iterSaldosPorEstado
					.next();
			calcSaldo.sumar(new Money(saldo.getSaldo()));
		}
		return calcSaldo.getResultMoney();
	}

	private IDataSet getDataSetStockAFuturo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TStockAFuturo");
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("concepto", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("nro_item", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("referencia", Field.STRING, 100));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldo", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarRegistroStockAFuturo
		(IDataSet dataset,
		 Integer orden,
		 String concepto,
		 java.util.Date fecha,
		 Integer nroItem,
		 Integer oidCCO,
		 String comprobante,
		 String referencia,
		 int signo,
		 Money cantidad,
		 Money saldo) throws BaseException {
			
		dataset.append();
		dataset.fieldValue("orden", orden);
		dataset.fieldValue("concepto", concepto);
		dataset.fieldValue("fecha", fecha);
		dataset.fieldValue("nro_item", nroItem);
		dataset.fieldValue("oid_cco", oidCCO);
		dataset.fieldValue("comprobante", comprobante);
		dataset.fieldValue("referencia", referencia);
		
		CalculadorMoney calcCant = new CalculadorMoney(cantidad);
		calcCant.multiplicarPor(new Money(signo));
		
		dataset.fieldValue("cantidad", calcCant.getResultMoney());
		
		saldoAcum.sumar(calcCant.getResultMoney());
		
		dataset.fieldValue("saldo", saldoAcum.getResultMoney());
	}
	
	private RenglonAnaCumpPed getArmarRenglonPedido(PedidoDet pedidoDet,Money cantidad) throws BaseException {
		RenglonAnaCumpPed renglonAnaCumpPed = new RenglonAnaCumpPed();
		renglonAnaCumpPed.setNroRenglon(pedidoDet.getNroRenglon());
		renglonAnaCumpPed.setProducto(pedidoDet.getProducto());
		renglonAnaCumpPed.setConcepto("Pedido");
		renglonAnaCumpPed.setFecha(pedidoDet.getFechaEntrega());
		renglonAnaCumpPed.setComprobante(pedidoDet.getPedido());
		renglonAnaCumpPed.setReferencia("");
		renglonAnaCumpPed.setSigno(-1);
		renglonAnaCumpPed.setCantidad(cantidad);
		renglonAnaCumpPed.setSaldo(new Money(0));
		return  renglonAnaCumpPed;
	}
	
	private RenglonAnaCumpPed getArmarRenglonOC(OrdenDeCompraDet ocDet,Money cantidad) throws BaseException {
		RenglonAnaCumpPed renglonAnaCumpPed = new RenglonAnaCumpPed();
		renglonAnaCumpPed.setNroRenglon(ocDet.getNro_item());
		renglonAnaCumpPed.setProducto(ocDet.getProducto());
		renglonAnaCumpPed.setConcepto("Orden de Compra");
		renglonAnaCumpPed.setFecha(ocDet.getFecRequerida());
		renglonAnaCumpPed.setComprobante(ocDet.getOrden_de_compra());
		renglonAnaCumpPed.setReferencia("");
		renglonAnaCumpPed.setSigno(1);
		renglonAnaCumpPed.setCantidad(cantidad);
		renglonAnaCumpPed.setSaldo(new Money(0));
		return  renglonAnaCumpPed;
	}
	
	private RenglonAnaCumpPed getArmarRenglonRequi(RequisicionDet requiDet,Money cantidad) throws BaseException {
		RenglonAnaCumpPed renglonAnaCumpPed = new RenglonAnaCumpPed();
		renglonAnaCumpPed.setNroRenglon(requiDet.getRenglon());
		renglonAnaCumpPed.setProducto(requiDet.getProducto());
		renglonAnaCumpPed.setConcepto("Requisición");
		renglonAnaCumpPed.setFecha(requiDet.getFec_requerida());
		renglonAnaCumpPed.setComprobante(requiDet.getRequisicion());
		renglonAnaCumpPed.setReferencia("");
		renglonAnaCumpPed.setSigno(1);
		renglonAnaCumpPed.setCantidad(cantidad);
		renglonAnaCumpPed.setSaldo(new Money(0));
		return  renglonAnaCumpPed;
	}

}
