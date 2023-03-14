package com.srn.erp.stock.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoDeposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStkProdPorEstado;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSaldosStockEstadosDepositos extends Operation {
 
	IDataSet dsSaldosEstadosStock  = null;
	Producto producto = null;
	
	public TraerSaldosStockEstadosDepositos() {
		
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		dsSaldosEstadosStock = getDataSetEstadosStock();
		tomarParametros(mapaDatos);
		traerSaldosDepositos();
		writeCliente(dsSaldosEstadosStock);
	}
	
	private void tomarParametros(MapDatos mapaDatos) throws BaseException {
		Integer oidProducto = mapaDatos.getInteger("oid_producto");
		producto = Producto.findByOid(oidProducto,getSesion());
	}
	
	private void traerSaldosDepositos() throws BaseException {
		Iterator iterDepositos = Deposito.getDepositos(getSesion()).iterator();		
		while (iterDepositos.hasNext()) {
			Deposito deposito = (Deposito) iterDepositos.next();	
			traerSaldosEstadosDeposito(deposito);
		}
		
	}
	
	private void traerSaldosEstadosDeposito(Deposito deposito) throws BaseException {
		List saldosPorEstado = SaldoStkProdPorEstado.getSaldosPorEstados(producto,deposito,getSesion());
		Iterator iterSaldosPorEstado = saldosPorEstado.iterator();
		while (iterSaldosPorEstado.hasNext()) {
			SaldoStkProdPorEstado saldoEstado = (SaldoStkProdPorEstado) iterSaldosPorEstado.next();
			cargarRegistroEstadoStock(dsSaldosEstadosStock,saldoEstado);
		}
	}

	private IDataSet getDataSetEstadosStock() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSaldosEstadosStock");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_estado_stock", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_estado_stock", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarRegistroEstadoStock(IDataSet dataset,
			SaldoStkProdPorEstado saldoStkProdPorEstado) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", saldoStkProdPorEstado.getOIDInteger());
		dataset.fieldValue("oid_deposito", saldoStkProdPorEstado.getDeposito()
				.getOIDInteger());
		dataset.fieldValue("oid_producto", saldoStkProdPorEstado.getProducto()
				.getOIDInteger());
		dataset.fieldValue("oid_estado_stock", saldoStkProdPorEstado
				.getEstado_stock().getOIDInteger());
		
		EstadoDeposito estadoDeposito = 
			saldoStkProdPorEstado.getDeposito().getEstadoDeposito(saldoStkProdPorEstado.getEstado_stock());
		
		if (estadoDeposito == null)
			throw new ExceptionValidation(null,"Falta definir el Agrupado para el estado "+
					                                saldoStkProdPorEstado.getEstado_stock().getDescripcion()+" y el Depósito  "+
					                                saldoStkProdPorEstado.getDeposito().getDescripcion());
					                                
		dataset.fieldValue("oid_grupo_estado_stock", estadoDeposito.getAgrupadorEstadoStock().getOIDInteger());
		dataset.fieldValue("cantidad", saldoStkProdPorEstado.getSaldo());
	}

}
