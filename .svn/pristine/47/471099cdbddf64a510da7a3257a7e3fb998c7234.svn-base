package com.srn.erp.stock.bm;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class StockValorizado extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public StockValorizado() {
	}

	public static String NICKNAME = "sk.StockValorizado";

	private ComproCab compro_mov_stk;
	private java.util.Date fecha;
	private Producto producto;
	private Double cantidad;
	private UnidadMedida unidad_medida;
	private Integer signo;
	private Double costo_total;
	private Moneda moneda;
	private Double costo_unitario;
	private ComproCab compro_valorizador;
	private Boolean activo;
	private Deposito deposito;

	public ComproCab getCompro_mov_stk() throws BaseException {
		supportRefresh();
		return compro_mov_stk;
	}

	public void setCompro_mov_stk(ComproCab aCompro_mov_stk) {
		this.compro_mov_stk = aCompro_mov_stk;
	}

	public Deposito getDeposito() throws BaseException {
		supportRefresh();
		return this.deposito;
	}

	public void setDeposito(Deposito aDeposito) {
		this.deposito = aDeposito;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public Double getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Double aCantidad) {
		this.cantidad = aCantidad;
	}

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public Integer getSigno() throws BaseException {
		supportRefresh();
		return signo;
	}

	public void setSigno(Integer aSigno) {
		this.signo = aSigno;
	}

	public Double getCosto_total() throws BaseException {
		supportRefresh();
		return costo_total;
	}

	public void setCosto_total(Double aCosto_total) {
		this.costo_total = aCosto_total;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Double getCosto_unitario() throws BaseException {
		supportRefresh();
		return costo_unitario;
	}

	public void setCosto_unitario(Double aCosto_unitario) {
		this.costo_unitario = aCosto_unitario;
	}

	public ComproCab getCompro_valorizador() throws BaseException {
		supportRefresh();
		return compro_valorizador;
	}

	public void setCompro_valorizador(ComproCab aCompro_valorizador) {
		this.compro_valorizador = aCompro_valorizador;
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

	public static StockValorizado findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (StockValorizado) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static StockValorizado findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (StockValorizado) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static StockValorizado findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (StockValorizado) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(compro_mov_stk, "Debe ingresar el Movimiento de Stock");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(cantidad, "Debe ingresar la cantidad");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(signo, "Debe ingresar el signo");
		Validar.noNulo(costo_total, "Debe ingresar el Costo Total");
		Validar.noNulo(moneda, "Debe ingresar la moneda");
		Validar.noNulo(costo_unitario, "Debe ingresar el Costo Unitario");
	}

}
