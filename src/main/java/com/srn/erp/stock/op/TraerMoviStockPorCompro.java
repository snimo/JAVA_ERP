package com.srn.erp.stock.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.EstadoDeposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockMovimiento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMoviStockPorCompro extends Operation {

	private static final String	MOV_STOCK	= "Movimientos";

	private int									secu			= 0;

	public TraerMoviStockPorCompro() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Talonario talonario = Talonario.findByOidProxy(mapaDatos.getInteger("oid_talonario"), getSesion());
		Integer nroExt = mapaDatos.getInteger("nro_ext");

		ComproCab comproCab = ComproCab.getComproCab(talonario, nroExt, getSesion());
		if (comproCab == null)
			throw new ExceptionValidation(null, "Nro. de Comprobante Inexistente");

		IDataSet dsDatosFiltro = getDataDatosFiltro();
		IDataSet dsConsMovStock = getDataSetConsMovStock();
		IDataSet dsEstadosDep = getDataSetEstadoStock();

		cargarRegistroDatosFiltro(dsDatosFiltro, comproCab);
		traerMovimietosStock(dsConsMovStock, comproCab);
		traerEstadosDeposito(dsEstadosDep,comproCab);

		writeCliente(dsDatosFiltro);
		writeCliente(dsConsMovStock);
		writeCliente(dsEstadosDep);
	}

	private void traerMovimietosStock(IDataSet ds, ComproCab comproCab) throws BaseException {
		Iterator iterMovimientos = StockMovimiento.getMovByComprobante(comproCab, getSesion()).iterator();
		while (iterMovimientos.hasNext()) {
			StockMovimiento stockMovimiento = (StockMovimiento) iterMovimientos.next();
			cargarRegistroStock(ds, new Integer(++secu), stockMovimiento.getEstado_stock().getOIDInteger(), new Double(
					stockMovimiento.getCantidad().doubleValue() * stockMovimiento.getSigno().doubleValue()), MOV_STOCK,
					stockMovimiento.getComprobante().getOIDInteger(), stockMovimiento.getComprobante().getCodigo(),
					stockMovimiento.getFecha(), stockMovimiento.getDeposito().getDescripcion(), stockMovimiento.getProducto());
		}
	}

	private IDataSet getDataSetConsMovStock() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsMovStock");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("stock", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tipo_mov", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_co", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha", Field.DATE, 10));
		dataset.fieldDef(new Field("deposito", Field.STRING, 50));
		dataset.fieldDef(new Field("producto", Field.STRING, 255));
		return dataset;
	}

	private IDataSet getDataDatosFiltro() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDatosFiltro");
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		return dataset;
	}

	private void cargarRegistroDatosFiltro(IDataSet dataset, ComproCab comproCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("comprobante", comproCab.getCodigo());
		dataset.fieldValue("fecha", comproCab.getEmision());
	}

	private void cargarRegistroStock(IDataSet dataset, Integer secu, Integer oidEstadoStock, Double stock,
			String tipoMov, Integer oidComprobante, String codCompro, Date fecha, String deposito, Producto producto)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("oid_estado", oidEstadoStock);
		dataset.fieldValue("stock", stock);
		dataset.fieldValue("tipo_mov", tipoMov);
		dataset.fieldValue("oid_co", oidComprobante);
		dataset.fieldValue("codigo_comprobante", codCompro);
		dataset.fieldValue("fecha", fecha);
		dataset.fieldValue("deposito", deposito);
		dataset.fieldValue("producto", producto.getCodigo() + " - " + producto.getDescripcion());
	}

	private IDataSet getDataSetEstadoStock() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadosDeposito");
		dataset.fieldDef(new Field("oid_estado_depo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_estado_stock", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_estado_stock", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_estado_stock", Field.STRING, 100));
		dataset.fieldDef(new Field("allow_saldo_neg", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_agrup_estado", Field.INTEGER, 0));

		return dataset;
	}

	private void cargarEstadoStock(IDataSet dataset, EstadoDeposito estadoDeposito) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_estado_depo", estadoDeposito.getOIDInteger());
		dataset.fieldValue("oid_deposito", estadoDeposito.getDeposito().getOIDInteger());
		dataset.fieldValue("oid_estado_stock", estadoDeposito.getEstado_stock().getOIDInteger());
		dataset.fieldValue("cod_estado_stock", estadoDeposito.getEstado_stock().getCodigo());
		dataset.fieldValue("desc_estado_stock", estadoDeposito.getEstado_stock().getDescripcion());
		dataset.fieldValue("allow_saldo_neg", estadoDeposito.isAllow_saldo_neg());
		dataset.fieldValue("activo", new Boolean(true));
		dataset.fieldValue("oid_agrup_estado", estadoDeposito.getAgrupadorEstadoStock().getOIDInteger());
	}
	
	private void traerEstadosDeposito(IDataSet dsEstadosDep,ComproCab comproCab) throws BaseException {
		HashTableDatos depositos = new HashTableDatos();
		Iterator iterMovimientos = StockMovimiento.getMovByComprobante(comproCab, getSesion()).iterator();
		while (iterMovimientos.hasNext()) {
			StockMovimiento stockMovimiento = (StockMovimiento) iterMovimientos.next();
			Integer oidDeposito = (Integer)depositos.get(stockMovimiento.getDeposito().getOIDInteger());
			if (oidDeposito == null) {
				depositos.put(stockMovimiento.getDeposito().getOIDInteger(),stockMovimiento.getDeposito().getOIDInteger());
		    Iterator iterEstadosDeposito = stockMovimiento.getDeposito().getEstadosDeposito().iterator();
		    while (iterEstadosDeposito.hasNext()) {
		      EstadoDeposito estadoDeposito = (EstadoDeposito) iterEstadosDeposito.next();
		      cargarEstadoStock(dsEstadosDep,estadoDeposito);
		    }
			}
		}
		
	}

}
