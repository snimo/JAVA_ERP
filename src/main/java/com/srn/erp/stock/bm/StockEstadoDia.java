package com.srn.erp.stock.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.stock.da.DBStockEstadoDia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorDecimal;
import framework.applicarionServer.bm.Varios.Decimal;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class StockEstadoDia extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public StockEstadoDia() {
	}

	public static String NICKNAME = "st.StockEstadoDia";

	private java.util.Date fecha;

	private Deposito deposito;

	private Producto producto;

	private EstadoStock estado_stock;

	private UnidadMedida unidad_medida;

	private Double entradas;

	private Double salidas;

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public Deposito getDeposito() throws BaseException {
		supportRefresh();
		return deposito;
	}

	public void setDeposito(Deposito aDeposito) {
		this.deposito = aDeposito;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public EstadoStock getEstado_stock() throws BaseException {
		supportRefresh();
		return estado_stock;
	}

	public void setEstado_stock(EstadoStock aEstado_stock) {
		this.estado_stock = aEstado_stock;
	}

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public Double getEntradas() throws BaseException {
		supportRefresh();
		return entradas;
	}

	public void setEntradas(Double aEntradas) {
		this.entradas = aEntradas;
	}

	public Double getSalidas() throws BaseException {
		supportRefresh();
		return salidas;
	}

	public void setSalidas(Double aSalidas) {
		this.salidas = aSalidas;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static StockEstadoDia findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (StockEstadoDia) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static StockEstadoDia findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (StockEstadoDia) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(fecha, "Debe ingresar la fecha");
		Validar.noNulo(deposito, "Debe ingresar el Deposito");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(estado_stock, "Debe ingresar el Estado de Stock");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
	}

	public static StockEstadoDia getStockEstadoDia(Producto producto,
			Deposito deposito, EstadoStock estadoStock, Date fecha,
			ISesion aSesion) throws BaseException {
		return DBStockEstadoDia.getStockEstadoDia(producto, deposito,
				estadoStock, fecha, aSesion);
	}

	public static List getSaldosInicialesPorEstados(Deposito deposito,
			Producto producto, Date fecha, ISesion aSesion)
			throws BaseException {
		return DBStockEstadoDia.getSaldosInicialesPorEstados(deposito,
				producto, fecha, aSesion);
	}
	
	public Double getDifEntSal() throws BaseException {
		CalculadorDecimal calcSaldo = new CalculadorDecimal(new NumeroBase(getEntradas()));
		calcSaldo.restar(new Decimal(getSalidas().doubleValue()));
		return new Double(calcSaldo.getResult());
	}

}
