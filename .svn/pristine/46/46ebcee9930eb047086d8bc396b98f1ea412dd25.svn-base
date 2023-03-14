package com.srn.erp.stock.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.da.DBStockMovimiento;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class StockMovimiento extends ObjetoLogico {

	public StockMovimiento() {
	}

	public static String NICKNAME = "st.StockMovimiento";

	private ComproCab comprobante;

	private Deposito deposito;

	private UbicacionDeposito ubicacion_deposito;

	private EstadoStock estado_stock;

	private Producto producto;

	private java.util.Date fecha;

	private Integer signo;

	private Double cantidad;

	private UnidadMedida unidad_medida;

	private Boolean afecta_stk_fisico;

	private Partida partida;

	private Serie serie;

	private java.util.Date fecha_arrivo;

	private Double cant_recibida;

	private Boolean pend_arrivo;

	private Boolean activo;
	
	private Integer oidComproDet;
	
	private ComproCab comprobanteDestino;
	
	private Integer oidComproDetDestino;

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}
	
	public Integer getOidComproDet() throws BaseException {
		supportRefresh();
		return this.oidComproDet;
	}

	public void setOidComproDet(Integer aOidComproDet) {
		this.oidComproDet = aOidComproDet;
	}
	
	public ComproCab getComprobanteDestino() throws BaseException {
		supportRefresh();
		return this.comprobanteDestino;
	}

	public void setComprobanteDestino(ComproCab aComprobanteDestino) {
		this.comprobanteDestino = aComprobanteDestino;
	}
	
	public Integer getOidComproDestinoDet() throws BaseException {
		supportRefresh();
		return this.oidComproDetDestino;
	}

	public void setOidComproDestinoDet(Integer aOidComproDestinoDet) {
		this.oidComproDetDestino = aOidComproDestinoDet;
	}
	

	public UbicacionDeposito getUbicacion_deposito() throws BaseException {
		supportRefresh();
		return ubicacion_deposito;
	}

	public void setUbicacion_deposito(UbicacionDeposito aUbicacion_deposito) {
		this.ubicacion_deposito = aUbicacion_deposito;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public Integer getSigno() throws BaseException {
		supportRefresh();
		return signo;
	}

	public void setSigno(Integer aSigno) {
		this.signo = aSigno;
	}

	public Double getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Double aCantidad) {
		this.cantidad = aCantidad;
	}

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public Boolean isAfecta_stk_fisico() throws BaseException {
		supportRefresh();
		return afecta_stk_fisico;
	}

	public void setAfecta_stk_fisico(Boolean aAfecta_stk_fisico) {
		this.afecta_stk_fisico = aAfecta_stk_fisico;
	}

	public Partida getPartida() throws BaseException {
		supportRefresh();
		return partida;
	}

	public void setPartida(Partida aPartida) {
		this.partida = aPartida;
	}

	public Serie getSerie() throws BaseException {
		supportRefresh();
		return serie;
	}

	public void setSerie(Serie aSerie) {
		this.serie = aSerie;
	}

	public java.util.Date getFecha_arrivo() throws BaseException {
		supportRefresh();
		return fecha_arrivo;
	}

	public void setFecha_arrivo(java.util.Date aFecha_arrivo) {
		this.fecha_arrivo = aFecha_arrivo;
	}

	public Double getCant_recibida() throws BaseException {
		supportRefresh();
		return cant_recibida;
	}

	public void setCant_recibida(Double aCant_recibida) {
		this.cant_recibida = aCant_recibida;
	}

	public Deposito getDeposito() throws BaseException {
		supportRefresh();
		return deposito;
	}

	public void setDeposito(Deposito aDeposito) {
		this.deposito = aDeposito;
	}

	public EstadoStock getEstado_stock() throws BaseException {
		supportRefresh();
		return estado_stock;
	}

	public void setEstado_stock(EstadoStock aEstado_stock) {
		this.estado_stock = aEstado_stock;
	}

	public Boolean isPend_arrivo() throws BaseException {
		supportRefresh();
		return pend_arrivo;
	}

	public void setPend_arrivo(Boolean aPend_arrivo) {
		this.pend_arrivo = aPend_arrivo;
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

	public static StockMovimiento findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (StockMovimiento) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static StockMovimiento findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (StockMovimiento) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(ubicacion_deposito,
				"Debe ingresar la Ubicación del Depósito");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
		Validar.noNulo(signo, "Debe ingresar el signo");
		Validar.noNulo(cantidad, "Debe ingresar la cantidad");
		Validar.noNulo(comprobante, "Debe Ingresar el comprobante");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(afecta_stk_fisico,
				"Debe indicar si afecta o no al Stock Fisico");
		Validar.noNulo(deposito, "Debe ingresar el Depósito");
		Validar.noNulo(estado_stock, "Debe ingresar el Estado de Stock");
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	public static List getMoviByDepoProduFechaDesdeHasta(Deposito deposito,
													Producto producto, 
													Date aFechaDesde, 
													Date aFechaHasta,
													ISesion aSesion)
			throws BaseException {
		return DBStockMovimiento.getMovByDepoProduFecDesdeFecHasta(deposito,
																   producto, 
																   aFechaDesde, 
																   aFechaHasta, 
																   aSesion);
	}
	
	public static List getMovByComprobante(ComproCab comproCab,ISesion aSesion) throws BaseException {
		return DBStockMovimiento.getMovByComprobante(comproCab,aSesion);
	}
	
	public static List getAllMovimientosStock(ISesion aSesion) throws BaseException {
		return DBStockMovimiento.getAllMovimientosStock(aSesion);
	}
	
	public static List getMovByDepoProdEstadoComproDestino(ISesion aSesion,
			Producto producto,
			Deposito deposito,
			EstadoStock estado,
			Integer oidComproDestino,
			Integer oidComproDestinoDet
			) throws BaseException {
		return DBStockMovimiento.getMovByDepoProdEstadoComproDestino(
				aSesion,
				producto,
				deposito,
				estado,
				oidComproDestino,
				oidComproDestinoDet);
	}
	
	public static List getMovByProdEstadoComproDestino(ISesion aSesion,
			Producto producto,
			EstadoStock estado,
			Integer oidComproDestino,
			Integer oidComproDestinoDet
			) throws BaseException {
		return DBStockMovimiento.getMovByProdEstadoComproDestino(aSesion,producto,estado,oidComproDestino,oidComproDestinoDet);
	}
	
	public static List getMovimientosIngresoFisico(ISesion aSesion,
			java.util.Date fecDesde,
			java.util.Date fecHasta
			) throws BaseException {
		return DBStockMovimiento.getMovimientosIngresoFisico(aSesion,fecDesde,fecHasta);
	}	
	
	
	
	

}
