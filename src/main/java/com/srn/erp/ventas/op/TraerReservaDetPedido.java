package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockMovimiento;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerReservaDetPedido extends Operation {

	public TraerReservaDetPedido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		PedidoDet pedidoDet = PedidoDet.findByOid(mapaDatos.getInteger("oid_ped_det"), this.getSesion());
		HashTableDatos reservasDeposito = new HashTableDatos();
		
		IDataSet dsCab = this.getDataSetCabCompro();
		IDataSet dsDet = this.getDataSetDetCompro();
		
		cargarRegistroCabCompro(
				dsCab, 
				pedidoDet.getPedido(), 
				pedidoDet.getNroRenglon(), 
				pedidoDet.getOIDInteger(), 
				pedidoDet.getProducto());
		
		EstadoStock estadoReservado = EstadoStock.getEstadoStockReservado(this.getSesion());
		
		Iterator iterMovStock =
			StockMovimiento.getMovByProdEstadoComproDestino(
				this.getSesion(),
				pedidoDet.getProducto(),
				estadoReservado,
				pedidoDet.getPedido().getOIDInteger(),
				pedidoDet.getOIDInteger()).iterator();
		
		while (iterMovStock.hasNext()) {
			StockMovimiento stockMovimiento = (StockMovimiento) iterMovStock.next();
			CalculadorMoney calcReservas = null;
			calcReservas = 
				(CalculadorMoney) reservasDeposito.get(stockMovimiento.getDeposito().getOIDInteger());
			if (calcReservas == null) {
				calcReservas = new CalculadorMoney(new Money(0));
				reservasDeposito.put(stockMovimiento.getDeposito().getOIDInteger(), calcReservas);
			}
			
			// Calcular Movimiento
			CalculadorMoney calcMov = new CalculadorMoney(new Money(stockMovimiento.getCantidad()));
			calcMov.multiplicarPor(new Money(stockMovimiento.getSigno()));
			
			calcReservas.sumar(calcMov.getResultMoney());
			
		}
		
		Iterator iterOidDepositos = 
			reservasDeposito.keySet().iterator();
		while (iterOidDepositos.hasNext()) {
			Integer oidDeposito = (Integer) iterOidDepositos.next();
			Deposito deposito = Deposito.findByOid(oidDeposito, this.getSesion());
			CalculadorMoney calcReservas = (CalculadorMoney) reservasDeposito.get(oidDeposito);
			if (calcReservas.getResultMoney().doubleValue()!=0)
				cargarRegistroDetCompro(dsDet, deposito, calcReservas.getResultMoney());
		}
		
		
		writeCliente(dsCab);
		writeCliente(dsDet);


	}

	private IDataSet getDataSetCabCompro() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCabCompro");
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_item", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto",Field.STRING, 255));
		return dataset;
	}
	
	private IDataSet getDataSetDetCompro() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetCompro");
		dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_deposito", Field.STRING, 100));
		dataset.fieldDef(new Field("cant_reservada", Field.CURRENCY, 0));
		return dataset;
	}
	


	private void cargarRegistroCabCompro(
			IDataSet dataset,
			ComproCab comproCab,
			Integer nroItem,
			Integer oidCCODet,
			Producto producto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cco", comproCab.getOIDInteger());
		dataset.fieldValue("codigo", comproCab.getCodigo());
		dataset.fieldValue("nro_item", nroItem);
		dataset.fieldValue("oid_cco_det", oidCCODet);
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("cod_producto", producto.getCodigo());
		dataset.fieldValue("desc_producto", producto.getDescripcion());
	}
	
	private void cargarRegistroDetCompro(
			IDataSet dataset,
			Deposito deposito,
			Money cantReservada) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_deposito", deposito.getOIDInteger());
		dataset.fieldValue("desc_deposito", deposito.getDescripcion());
		dataset.fieldValue("cant_reservada", cantReservada);
	}
	

}
