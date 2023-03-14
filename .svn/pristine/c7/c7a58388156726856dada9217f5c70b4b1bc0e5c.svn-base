package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.implementacion.bm.TablaGeneral;
import com.srn.erp.ventas.bm.ObservadorReservasPedidoDet;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorDecimal;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Decimal;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class GrabarStock {

	private ISesion sesion;
	
	private List listaObserSaldoProdEstadoItem = new ArrayList();

	private IStockeable stockeable;

	public static final int CANT_DECIMALES_STOCK = 2;

	public GrabarStock(ISesion aSesion) {
		this.sesion = aSesion;
		listaObserSaldoProdEstadoItem.add(new ObservadorReservasPedidoDet());
	}

	public ISesion getSesion() throws BaseException {
		return sesion;
	}

	public void setStockeable(IStockeable aStockeable) throws BaseException {
		this.stockeable = aStockeable;
	}

	public IStockeable getStockeable() throws BaseException {
		return stockeable;
	}

	public void save() throws BaseException {
		StockCabecera stockCab = grabarCabeceraStock(getStockeable());
		boolean graboAlunMovStock = grabarMovimientos(getStockeable());
		if (graboAlunMovStock)
			stockCab.save();
	}

	private StockCabecera grabarCabeceraStock(IStockeable aStockeable)
			throws BaseException {
		StockCabecera stockCab = (StockCabecera) StockCabecera.getNew(
				StockCabecera.NICKNAME, getSesion());
		stockCab.setComprobante(aStockeable.getComprobante());
		return stockCab; 

	}

	private boolean grabarMovimientos(IStockeable aStockeable)
			throws BaseException {
		boolean graboAlgunMovStock = false;
		Iterator iterRenglonesMovStk = aStockeable.getRenglonesStock()
				.getListaRenglones().iterator();
		while (iterRenglonesMovStk.hasNext()) {
			RenglonMovStock renglonMovStock = (RenglonMovStock) iterRenglonesMovStk
					.next();
			if (grabarRenglonMovStock(renglonMovStock))
				graboAlgunMovStock = true;
		}
		return graboAlgunMovStock;
	}
	

	private boolean grabarRenglonMovStock(RenglonMovStock renglonMovStk)
			throws BaseException {
		
		if (renglonMovStk.getProducto().isStockeable().booleanValue()==false) return false;
		
		StockMovimiento stockMovimiento = (StockMovimiento) StockMovimiento
				.getNew(StockMovimiento.NICKNAME, getSesion());
		stockMovimiento.setComprobante(renglonMovStk.getComproCab());
		stockMovimiento.setDeposito(renglonMovStk.getDeposito());
		stockMovimiento.setUbicacion_deposito(renglonMovStk
				.getUbicacionDeposito());
		stockMovimiento.setEstado_stock(renglonMovStk.getEstadoStock());
		stockMovimiento.setProducto(renglonMovStk.getProducto());
		stockMovimiento.setFecha(renglonMovStk.getFecha());
		stockMovimiento.setSigno(renglonMovStk.getSigno());
		stockMovimiento.setCantidad(renglonMovStk.getCantidad());
		stockMovimiento.setUnidad_medida(renglonMovStk.getUnidadMedida());
		stockMovimiento.setAfecta_stk_fisico(renglonMovStk
				.isAfectaStockFisico());
		stockMovimiento.setPartida(renglonMovStk.getPartida());
		stockMovimiento.setSerie(renglonMovStk.getSerie());
		stockMovimiento.setActivo(renglonMovStk.isActivo());
		stockMovimiento.setOidComproDet(renglonMovStk.getOidCCODet());
		stockMovimiento.setComprobanteDestino(renglonMovStk.getComproCabDestino());
		stockMovimiento.setOidComproDestinoDet(renglonMovStk.getOidCCODetDestino());
		stockMovimiento.save();
		
		// AGREGAR QUE ACTUALICE LAS TABLAS DE SALDOS DE ESTADOS
		
		actuSaldoProducto(stockMovimiento);
		
		return true;
		
		
	}

	public void actuSaldoProducto(StockMovimiento stockMovimiento)
			throws BaseException {
		actuSaldoProductoDepoEstadoItem(stockMovimiento);
		actuSaldoProductoDeposito(stockMovimiento);
		actuSaldoProductoDepositoEstado(stockMovimiento);
		actuSaldoProductoDepositoUbi(stockMovimiento);
		actuSaldoProductoDepositoUbiEstado(stockMovimiento);
		actuMovStockDia(stockMovimiento);
		actuMovStockEstadoDia(stockMovimiento);
		actuMovStockPeri(stockMovimiento);
		if ((stockMovimiento.getPartida() != null)
				|| (stockMovimiento.getSerie() != null))
			actuMovStockPeriPartidaSerie(stockMovimiento);
	}
	
	private void actuSaldoProductoDepoEstadoItem(StockMovimiento stockMovimiento) throws BaseException {
		
		if ((stockMovimiento.getComprobanteDestino() == null) ||
		   (stockMovimiento.getOidComproDestinoDet() == null))
		   return;
		
		SaldoStockPorItemDepoEst saldo =
			SaldoStockPorItemDepoEst.getSaldoStockPorItemDepoEst(
					stockMovimiento.getDeposito(), 
					stockMovimiento.getProducto(), 
					stockMovimiento.getEstado_stock(), 
					stockMovimiento.getComprobanteDestino(), 
					stockMovimiento.getOidComproDestinoDet(), this.getSesion());
		
		if (saldo == null)
			nuevoSaldoProdDepoEstadoItem(stockMovimiento);
		else
			actuSaldoProdDepoEstadoItem(saldo,stockMovimiento);
		
		// Llamar a los observadores
		Iterator iterObs = 
			this.listaObserSaldoProdEstadoItem.iterator();
		while (iterObs.hasNext()) {
			IObservadorSaldoProdDepoEstadoItem observador = 
				(IObservadorSaldoProdDepoEstadoItem) iterObs.next();
			observador.ejecutar(stockMovimiento, this.getSesion());
		}
		
	}
	
	private void actuSaldoProdDepoEstadoItem(SaldoStockPorItemDepoEst saldo,
											 StockMovimiento stockMovimiento) throws BaseException {
	
		CalculadorMoney nuevoSaldo = new CalculadorMoney(saldo.getSaldo());		
		CalculadorMoney mov = new CalculadorMoney(new Money(stockMovimiento.getCantidad()));
		mov.multiplicarPor(new Money(stockMovimiento.getSigno()));
		nuevoSaldo.restar(mov.getResultMoney());
		saldo.setSaldo(nuevoSaldo.getResultMoney());
		if (nuevoSaldo.getResultMoney().doubleValue() == 0)
			saldo.setTiene_saldo(new Boolean(false));
		else
			saldo.setTiene_saldo(new Boolean(true));
		saldo.save();
	}
	
	private void nuevoSaldoProdDepoEstadoItem(StockMovimiento stockMovimiento) throws BaseException {
		SaldoStockPorItemDepoEst saldo = 
			(SaldoStockPorItemDepoEst)SaldoStockPorItemDepoEst.getNew(
					SaldoStockPorItemDepoEst.NICKNAME, 
					this.getSesion());
		saldo.setDeposito(stockMovimiento.getDeposito());
		saldo.setProducto(stockMovimiento.getProducto());
		saldo.setUnidad_medida(stockMovimiento.getUnidad_medida());
		saldo.setEstado_stock(stockMovimiento.getEstado_stock());
		saldo.setComprobante(stockMovimiento.getComprobanteDestino());
		saldo.setOid_cco_det(stockMovimiento.getOidComproDestinoDet());
		CalculadorMoney calcSaldo = new CalculadorMoney(new Money(stockMovimiento.getCantidad().doubleValue()));
		calcSaldo.multiplicarPor(new Money(stockMovimiento.getSigno()));
		Money saldoMov = calcSaldo.getResultMoney();
		saldo.setSaldo(saldoMov);
		if (saldoMov.doubleValue()==0)
			saldo.setTiene_saldo(new Boolean(false));
		else
			saldo.setTiene_saldo(new Boolean(true));
		saldo.save();
		
	}

	private void actuMovStockPeri(StockMovimiento stockMovimiento)
			throws BaseException {
		PeriodoStockReal pediodoStockReal = PeriodoStockReal
				.getPeriodoStockReal(stockMovimiento.getFecha(), getSesion());
		if (pediodoStockReal == null)
			throw new ExceptionValidation(null,
					"No se pudo obtener un período de Stock para la fecha "
							+ Fecha.getddmmyyyy(stockMovimiento.getFecha()));
		StockPeriodo stockPeriodo = StockPeriodo.getStockPeriodo(
				stockMovimiento.getProducto(), stockMovimiento.getDeposito(),
				pediodoStockReal, getSesion());
		if (stockPeriodo == null)
			nuevoMoviPeriProducto(stockMovimiento, pediodoStockReal);
		else
			actuSaldoMoviPeriProducto(stockMovimiento, stockPeriodo);
	}

	private void actuMovStockDia(StockMovimiento stockMovimiento)
			throws BaseException {

		StockDia stockDia = StockDia.getStockDia(stockMovimiento.getProducto(),
				stockMovimiento.getDeposito(), stockMovimiento.getFecha(),
				getSesion());
		if (stockDia == null)
			nuevoMoviStockDia(stockMovimiento);
		else
			actuSaldoStockDia(stockMovimiento, stockDia);
	}

	private void actuMovStockEstadoDia(StockMovimiento stockMovimiento)
			throws BaseException {

		StockEstadoDia stockEstadoDia = StockEstadoDia.getStockEstadoDia(
				stockMovimiento.getProducto(), stockMovimiento.getDeposito(),
				stockMovimiento.getEstado_stock(), stockMovimiento.getFecha(),
				getSesion());
		if (stockEstadoDia == null)
			nuevoMoviStockEstadoDia(stockMovimiento);
		else
			actuSaldoStockEstadoDia(stockMovimiento, stockEstadoDia);
	}

	private void nuevoMoviStockDia(StockMovimiento stockMovimiento)
			throws BaseException {
		StockDia stockDia = (StockDia) StockDia.getNew(StockDia.NICKNAME,
				getSesion());
		stockDia.setDeposito(stockMovimiento.getDeposito());
		stockDia.setProducto(stockMovimiento.getProducto());
		stockDia.setFecha(stockMovimiento.getFecha());
		stockDia.setUni_med(stockMovimiento.getUnidad_medida());
		CalculadorDecimal calcSaldo = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		if (stockMovimiento.getSigno().intValue() == 1) {
			stockDia.setEntradas(new Double(calcSaldo
					.getResult(CANT_DECIMALES_STOCK)));
			stockDia.setSalidas(new Double(0));
		} else {
			stockDia.setSalidas(new Double(calcSaldo
					.getResult(CANT_DECIMALES_STOCK)));
			stockDia.setEntradas(new Double(0));
		}
		stockDia.save();
	}

	private void nuevoMoviStockEstadoDia(StockMovimiento stockMovimiento)
			throws BaseException {
		StockEstadoDia stockEstadoDia = (StockEstadoDia) StockEstadoDia.getNew(StockEstadoDia.NICKNAME,
				getSesion());
		stockEstadoDia.setDeposito(stockMovimiento.getDeposito());
		stockEstadoDia.setProducto(stockMovimiento.getProducto());
		stockEstadoDia.setFecha(stockMovimiento.getFecha());
		stockEstadoDia.setEstado_stock(stockMovimiento.getEstado_stock());
		stockEstadoDia.setUnidad_medida(stockMovimiento.getUnidad_medida());
		CalculadorDecimal calcSaldo = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		if (stockMovimiento.getSigno().intValue() == 1) {
			stockEstadoDia.setEntradas(new Double(calcSaldo
					.getResult(CANT_DECIMALES_STOCK)));
			stockEstadoDia.setSalidas(new Double(0));
		} else {
			stockEstadoDia.setSalidas(new Double(calcSaldo
					.getResult(CANT_DECIMALES_STOCK)));
			stockEstadoDia.setEntradas(new Double(0));
		}
		stockEstadoDia.save();
	}

	private void actuMovStockPeriPartidaSerie(StockMovimiento stockMovimiento)
			throws BaseException {
		SaldoStockPartidaSerie saldoStockPartidaSerie = SaldoStockPartidaSerie
				.getSaldoStockPartidaSerie(stockMovimiento.getDeposito(),
						stockMovimiento.getProducto(), stockMovimiento
								.getUbicacion_deposito(), stockMovimiento
								.getEstado_stock(), stockMovimiento
								.getPartida(), stockMovimiento.getSerie(),
						getSesion());
		if (saldoStockPartidaSerie == null)
			nuevoSaldoStockPartidaSerie(stockMovimiento);
		else
			actuSaldoStockPartidaSerie(stockMovimiento, saldoStockPartidaSerie);
	}

	private void actuSaldoProductoDepositoUbi(StockMovimiento stockMovimiento)
			throws BaseException {
		// Actualizar el Saldo del Producto
		SaldoStockUbi saldoStockUbi = SaldoStockUbi.getSaldoStockUbi(
				stockMovimiento.getProducto(), stockMovimiento.getDeposito(),
				stockMovimiento.getUbicacion_deposito(), getSesion());
		if (saldoStockUbi == null)
			nuevoSaldoProductoUbi(stockMovimiento);
		else
			actuSaldoProductoUbi(stockMovimiento, saldoStockUbi);

	}

	private void actuSaldoProductoDepositoUbiEstado(
			StockMovimiento stockMovimiento) throws BaseException {
		// Actualizar el Saldo del Producto
		SaldoStockUbiEstado saldoStockUbiEst = SaldoStockUbiEstado
				.getSaldoStockUbiEstado(stockMovimiento.getProducto(),
						stockMovimiento.getDeposito(), stockMovimiento
								.getUbicacion_deposito(), stockMovimiento
								.getEstado_stock(), getSesion());
		if (saldoStockUbiEst == null)
			nuevoSaldoProductoUbiEstado(stockMovimiento);
		else
			actuSaldoProductoUbiEstado(stockMovimiento, saldoStockUbiEst);
	}

	private void actuSaldoProductoDeposito(StockMovimiento stockMovimiento)
			throws BaseException {
		// Actualizar el Saldo del Producto
		SaldoStockProducto saldoStockProducto = SaldoStockProducto
				.getSaldoStockProducto(stockMovimiento.getProducto(),
						stockMovimiento.getDeposito(), getSesion());
		if (saldoStockProducto == null)
			nuevoSaldoProducto(stockMovimiento);
		else
			actuSaldoProducto(stockMovimiento, saldoStockProducto);
	}

	private void actuSaldoProductoDepositoEstado(StockMovimiento stockMovimiento)
			throws BaseException {
		// Actualizar el Saldo del Producto por Estado
		SaldoStkProdPorEstado saldoStkProdPorEst = SaldoStkProdPorEstado
				.getSaldoStkProdPorEstado(stockMovimiento.getProducto(),
						stockMovimiento.getDeposito(), stockMovimiento
								.getEstado_stock(), getSesion());
		if (saldoStkProdPorEst == null)
			nuevoSaldoProductoEstado(stockMovimiento);
		else
			actuSaldoProductoEstado(stockMovimiento, saldoStkProdPorEst);
	}

	private void actuSaldoMoviPeriProducto(StockMovimiento stockMovimiento,
			StockPeriodo stockPeriodo) throws BaseException {
		if (stockMovimiento.getSigno().intValue() == 1) {
			stockPeriodo.setMovEntrada(stockMovimiento.getCantidad());
			stockPeriodo.setMovSalida(new Double(0.0));
			stockPeriodo.save();
		} else {
			stockPeriodo.setMovSalida(stockMovimiento.getCantidad());
			stockPeriodo.setMovEntrada(new Double(0.0));
			stockPeriodo.save();
		}
	}

	private void actuSaldoStockDia(StockMovimiento stockMovimiento,
			StockDia stockDia) throws BaseException {
		if (stockMovimiento.getSigno().intValue() == 1) {
			
			stockDia.setEntradas(stockMovimiento.getCantidad());
			stockDia.setSalidas(new Double(0.0));
			stockDia.save();
		} else {
			stockDia.setSalidas(stockMovimiento.getCantidad());
			stockDia.setEntradas(new Double(0.0));
			stockDia.save();
		}
	}
	
	private void actuSaldoStockEstadoDia(StockMovimiento stockMovimiento,
			StockEstadoDia stockEstadoDia) throws BaseException {
		if (stockMovimiento.getSigno().intValue() == 1) {
			stockEstadoDia.setEntradas(stockMovimiento.getCantidad());
			stockEstadoDia.setSalidas(new Double(0.0));
			stockEstadoDia.save();
		} else {
			stockEstadoDia.setSalidas(stockMovimiento.getCantidad());
			stockEstadoDia.setEntradas(new Double(0.0));
			stockEstadoDia.save();
		}
	}	

	private void actuSaldoProductoUbiEstado(StockMovimiento stockMovimiento,
			SaldoStockUbiEstado saldoStkUbiEstado) throws BaseException {
		CalculadorDecimal calcCant = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		calcCant.multiplicarPor(new Decimal(stockMovimiento.getSigno()
				.intValue()));
		saldoStkUbiEstado.setMovimiento(new Double(calcCant
				.getResult(GrabarStock.CANT_DECIMALES_STOCK)));
		saldoStkUbiEstado.save();
	}

	private void actuSaldoStockPartidaSerie(StockMovimiento stockMovimiento,
			SaldoStockPartidaSerie saldoStockPartidaSerie) throws BaseException {
		CalculadorDecimal calcCant = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		calcCant.multiplicarPor(new Decimal(stockMovimiento.getSigno()
				.intValue()));
		saldoStockPartidaSerie.setMovimiento(new Double(calcCant
				.getResult(GrabarStock.CANT_DECIMALES_STOCK)));
		saldoStockPartidaSerie.save();

		// Actualizar el Falg del Saldo
		SaldoStockPartidaSerie saldostkPartidaSerie = SaldoStockPartidaSerie
				.findByOid(saldoStockPartidaSerie.getOIDInteger(), getSesion());
		saldostkPartidaSerie.setMovimiento(new Double(0));
		if (saldostkPartidaSerie.getSaldo().doubleValue() == 0)
			saldostkPartidaSerie.setSaldo_cero(new Boolean(true));
		else
			saldostkPartidaSerie.setSaldo_cero(new Boolean(false));
		saldostkPartidaSerie.save();
	}

	private void actuSaldoProductoUbi(StockMovimiento stockMovimiento,
			SaldoStockUbi saldoStkUbi) throws BaseException {
		CalculadorDecimal calcCant = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		calcCant.multiplicarPor(new Decimal(stockMovimiento.getSigno()
				.intValue()));
		saldoStkUbi.setMovimiento(new Double(calcCant
				.getResult(GrabarStock.CANT_DECIMALES_STOCK)));
		saldoStkUbi.save();
	}

	private void actuSaldoProducto(StockMovimiento stockMovimiento,
			SaldoStockProducto saldoStockProducto) throws BaseException {
		CalculadorDecimal calcCant = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		calcCant.multiplicarPor(new Decimal(stockMovimiento.getSigno()
				.intValue()));
		saldoStockProducto.setMovimiento(new Double(calcCant
				.getResult(GrabarStock.CANT_DECIMALES_STOCK)));
		saldoStockProducto.save();
	}

	private void actuSaldoProductoEstado(StockMovimiento stockMovimiento,
			SaldoStkProdPorEstado saldoStockProductoEstado)
			throws BaseException {
		CalculadorDecimal calcCant = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		calcCant.multiplicarPor(new Decimal(stockMovimiento.getSigno()
				.intValue()));
		saldoStockProductoEstado.setMovimiento(new Double(calcCant
				.getResult(GrabarStock.CANT_DECIMALES_STOCK)));
		saldoStockProductoEstado.save();
	}

	private void nuevoMoviPeriProducto(StockMovimiento stockMovimiento,
			PeriodoStockReal periodoStockReal) throws BaseException {
		StockPeriodo stockPeriodo = (StockPeriodo) StockPeriodo.getNew(
				StockPeriodo.NICKNAME, getSesion());
		stockPeriodo.setPeri_stock_real(periodoStockReal);
		stockPeriodo.setDeposito(stockMovimiento.getDeposito());
		stockPeriodo.setProducto(stockMovimiento.getProducto());
		stockPeriodo.setUnidad_medida(stockMovimiento.getUnidad_medida());
		if (stockMovimiento.getSigno().intValue() == 1) {
			stockPeriodo.setEntradas(stockMovimiento.getCantidad());
			stockPeriodo.setSalidas(new Double(0.0));
		} else {
			stockPeriodo.setSalidas(stockMovimiento.getCantidad());
			stockPeriodo.setEntradas(new Double(0.0));
		}
		stockPeriodo.save();
	}

	private void nuevoSaldoStockPartidaSerie(StockMovimiento stockMovimiento)
			throws BaseException {
		SaldoStockPartidaSerie saldoStockPartidaSerie = (SaldoStockPartidaSerie) SaldoStockPartidaSerie
				.getNew(SaldoStockPartidaSerie.NICKNAME, getSesion());
		saldoStockPartidaSerie.setDeposito(stockMovimiento.getDeposito());
		saldoStockPartidaSerie.setProducto(stockMovimiento.getProducto());
		saldoStockPartidaSerie.setUbicacion_deposito(stockMovimiento
				.getUbicacion_deposito());
		saldoStockPartidaSerie.setEstado_stock(stockMovimiento
				.getEstado_stock());
		saldoStockPartidaSerie.setPartida(stockMovimiento.getPartida());
		saldoStockPartidaSerie.setSerie(stockMovimiento.getSerie());
		saldoStockPartidaSerie.setUnidad_medida(stockMovimiento
				.getUnidad_medida());
		CalculadorDecimal calcSaldo = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		calcSaldo.multiplicarPor(new Decimal(stockMovimiento.getSigno()
				.intValue()));
		saldoStockPartidaSerie.setSaldo(new Double(calcSaldo
				.getResult(CANT_DECIMALES_STOCK)));
		if (calcSaldo.getResult(CANT_DECIMALES_STOCK) == 0)
			saldoStockPartidaSerie.setSaldo_cero(new Boolean(true));
		else
			saldoStockPartidaSerie.setSaldo_cero(new Boolean(false));
		saldoStockPartidaSerie.save();
	}

	private void nuevoSaldoProducto(StockMovimiento stockMovimiento)
			throws BaseException {
		SaldoStockProducto saldoStockProducto = (SaldoStockProducto) SaldoStockProducto
				.getNew(SaldoStockProducto.NICKNAME, getSesion());
		saldoStockProducto.setDeposito(stockMovimiento.getDeposito());
		saldoStockProducto.setProducto(stockMovimiento.getProducto());
		saldoStockProducto.setUnidad_medida(stockMovimiento.getUnidad_medida());
		CalculadorDecimal calcSaldo = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		calcSaldo.multiplicarPor(new Decimal(stockMovimiento.getSigno()
				.intValue()));
		saldoStockProducto.setSaldo(new Double(calcSaldo
				.getResult(CANT_DECIMALES_STOCK)));
		saldoStockProducto.save();
	}

	private void nuevoSaldoProductoEstado(StockMovimiento stockMovimiento)
			throws BaseException {
		SaldoStkProdPorEstado saldoStkProdPorEstado = (SaldoStkProdPorEstado) SaldoStkProdPorEstado
				.getNew(SaldoStkProdPorEstado.NICKNAME, getSesion());
		saldoStkProdPorEstado.setDeposito(stockMovimiento.getDeposito());
		saldoStkProdPorEstado.setProducto(stockMovimiento.getProducto());
		saldoStkProdPorEstado.setUnidad_medida(stockMovimiento
				.getUnidad_medida());
		saldoStkProdPorEstado
				.setEstado_stock(stockMovimiento.getEstado_stock());
		CalculadorDecimal calcSaldo = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		calcSaldo.multiplicarPor(new Decimal(stockMovimiento.getSigno()
				.intValue()));
		saldoStkProdPorEstado.setSaldo(new Double(calcSaldo
				.getResult(CANT_DECIMALES_STOCK)));
		saldoStkProdPorEstado.save();
	}

	private void nuevoSaldoProductoUbiEstado(StockMovimiento stockMovimiento)
			throws BaseException {
		SaldoStockUbiEstado saldoStkUbiEst = (SaldoStockUbiEstado) SaldoStockUbiEstado
				.getNew(SaldoStockUbiEstado.NICKNAME, getSesion());
		saldoStkUbiEst.setDeposito(stockMovimiento.getDeposito());
		saldoStkUbiEst.setProducto(stockMovimiento.getProducto());
		saldoStkUbiEst.setUnidad_medida(stockMovimiento.getUnidad_medida());
		saldoStkUbiEst.setUbicacion_deposito(stockMovimiento
				.getUbicacion_deposito());
		saldoStkUbiEst.setEstado_stock(stockMovimiento.getEstado_stock());
		CalculadorDecimal calcSaldo = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		calcSaldo.multiplicarPor(new Decimal(stockMovimiento.getSigno()
				.intValue()));
		saldoStkUbiEst.setSaldo(new Double(calcSaldo
				.getResult(CANT_DECIMALES_STOCK)));
		saldoStkUbiEst.save();
	}

	private void nuevoSaldoProductoUbi(StockMovimiento stockMovimiento)
			throws BaseException {
		SaldoStockUbi saldoStkUbi = (SaldoStockUbi) SaldoStockUbi.getNew(
				SaldoStockUbi.NICKNAME, getSesion());
		saldoStkUbi.setDeposito(stockMovimiento.getDeposito());
		saldoStkUbi.setProducto(stockMovimiento.getProducto());
		saldoStkUbi.setUnidad_medida(stockMovimiento.getUnidad_medida());
		saldoStkUbi.setUbicacion_deposito(stockMovimiento
				.getUbicacion_deposito());
		CalculadorDecimal calcSaldo = new CalculadorDecimal(new Decimal(
				stockMovimiento.getCantidad().toString()));
		calcSaldo.multiplicarPor(new Decimal(stockMovimiento.getSigno()
				.intValue()));
		saldoStkUbi.setSaldo(new Double(calcSaldo
				.getResult(CANT_DECIMALES_STOCK)));
		saldoStkUbi.save();
	}
	
	public static void borrarTablasStockParaReconsEnBaseAMovi(ISesion aSesion) throws BaseException {
		TablaGeneral.borrarTabla("skStockSaldoProd", aSesion);
		TablaGeneral.borrarTabla("skStockSaldoEstado", aSesion);
		TablaGeneral.borrarTabla("skStockSaldoUbiEst", aSesion);
		TablaGeneral.borrarTabla("skStockSaldoUbi", aSesion);
		TablaGeneral.borrarTabla("skStockSalPartSer", aSesion);
		TablaGeneral.borrarTabla("skStockSalEstItem", aSesion);
		TablaGeneral.borrarTabla("skStockEstadoDia", aSesion);
		TablaGeneral.borrarTabla("skStockDia", aSesion);
		TablaGeneral.borrarTabla("skStockPeri", aSesion);
	}

}
