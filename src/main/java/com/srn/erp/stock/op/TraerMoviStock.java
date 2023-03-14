package com.srn.erp.stock.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoDeposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockEstadoDia;
import com.srn.erp.stock.bm.StockMovimiento;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMoviStock extends Operation {

	private static final String SALDO_INICIAL = "Saldo inicial";
	private static final String MOV_STOCK = "Movimientos";
	
	private int secu = 0;

	public TraerMoviStock() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Producto producto = Producto.findByOidProxy(mapaDatos
				.getInteger("oid_producto"), getSesion());
		Deposito deposito = Deposito.findByOidProxy(mapaDatos
				.getInteger("oid_deposito"), getSesion());
		java.util.Date fechaDesde = mapaDatos.getDate("fec_desde");
		java.util.Date fechaHasta = mapaDatos.getDate("fec_hasta");

		IDataSet dsDatosFiltro = getDataDatosFiltro();
		IDataSet dsConsMovStock = getDataSetEstadoStock();

		cargarRegistroDatosFiltro(dsDatosFiltro,deposito,producto,fechaDesde,fechaHasta);
		traerSaldosInicialesPorEstados(dsConsMovStock, producto, deposito,
				fechaDesde);
		traerMovimietosStock(dsConsMovStock,producto,deposito,fechaDesde,fechaHasta);
		
		writeCliente(dsDatosFiltro);
		writeCliente(dsConsMovStock);
	}

	private void traerSaldosInicialesPorEstados(IDataSet ds, Producto producto,
			Deposito deposito, Date fecha) throws BaseException {
		Iterator iterSaldosIniciales = StockEstadoDia
				.getSaldosInicialesPorEstados(deposito, producto, fecha,
						getSesion()).iterator();
		
		cargarRegistroStock(ds, new Integer(++secu), ((EstadoDeposito)deposito.getEstadosDeposito().get(0)).getOIDInteger(),
				new Double(0), SALDO_INICIAL, new Integer(0), "", fecha, "" , "");		
		while (iterSaldosIniciales.hasNext()) {
			StockEstadoDia stockEstadoDia = (StockEstadoDia) iterSaldosIniciales
					.next();
			cargarRegistroStock(ds, new Integer(++secu), stockEstadoDia
					.getEstado_stock().getOIDInteger(), stockEstadoDia
					.getDifEntSal(), SALDO_INICIAL, new Integer(0), "", fecha, "" , "");			
		}

	}
	
	private void traerMovimietosStock(IDataSet ds,
								Producto producto,
								Deposito deposito, 
								Date fechaDesde,
								Date fechaHasta) throws BaseException {
		Iterator iterMovimientos = StockMovimiento.getMoviByDepoProduFechaDesdeHasta(deposito,
																					 producto,
																					 fechaDesde,
																					 fechaHasta,
																					 getSesion()).iterator();
		while (iterMovimientos.hasNext()) {
			StockMovimiento stockMovimiento = (StockMovimiento) iterMovimientos.next();
			cargarRegistroStock(ds, 
							   new Integer(++secu), 
							   stockMovimiento.getEstado_stock().getOIDInteger(), 
							   new Double(stockMovimiento.getCantidad().doubleValue()*stockMovimiento.getSigno().doubleValue()),
							   MOV_STOCK, 
							   stockMovimiento.getComprobante().getOIDInteger(),
							   stockMovimiento.getComprobante().getCodigo(),
							   stockMovimiento.getFecha(),
							   Fecha.getddmmyyyy(stockMovimiento.getFecha())+"     "+stockMovimiento.getComprobante().getCodigo(),
							   stockMovimiento.getComprobante().getComentario());
							   
			
			
		}
	}
	

	private IDataSet getDataSetEstadoStock() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsMovStock");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("stock", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tipo_mov", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_co", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha", Field.DATE, 10));
		dataset.fieldDef(new Field("fecha_y_cod_compro", Field.STRING, 50));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		return dataset;
	}

	private IDataSet getDataDatosFiltro() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDatosFiltro");
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_depo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_depo", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_depo", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_hasta", Field.DATE, 0));
		return dataset;
	}
	
	private void cargarRegistroDatosFiltro(IDataSet dataset, 
										  Deposito deposito,
										  Producto producto,
										  Date fecDesde,
										  Date fecHasta) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("cod_producto", producto.getCodigo());
		dataset.fieldValue("desc_producto", producto.getDescripcion());
		dataset.fieldValue("oid_depo", deposito.getOIDInteger());
		dataset.fieldValue("cod_depo", deposito.getCodigo());
		dataset.fieldValue("desc_depo", deposito.getDescripcion());
		dataset.fieldValue("fec_desde", fecDesde);
		dataset.fieldValue("fec_hasta", fecHasta);		
	}	

	private void cargarRegistroStock(IDataSet dataset, Integer secu,
			Integer oidEstadoStock, Double stock, String tipoMov,
			Integer oidComprobante, String codCompro, Date fecha,
			String fecha_y_compro,
			String comentario) {
		dataset.append();
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("oid_estado", oidEstadoStock);
		dataset.fieldValue("stock", stock);
		dataset.fieldValue("tipo_mov", tipoMov);
		dataset.fieldValue("oid_co", oidComprobante);
		dataset.fieldValue("codigo_comprobante", codCompro);
		dataset.fieldValue("fecha", fecha);
		dataset.fieldValue("fecha_y_cod_compro", fecha_y_compro);
		if ((comentario!=null) && (comentario.length()>0))
			dataset.fieldValue("comentario", comentario);
		else
			dataset.fieldValue("comentario", "...");
	}

}
