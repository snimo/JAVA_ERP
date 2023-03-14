package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBPedMercDepoDet;
import com.srn.erp.ventas.bm.AplicPedDepoRto;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PedMercDepoDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PedMercDepoDet() {
	}

	public static String NICKNAME = "st.PedMercDepoDet";

	private PedMercDep pedido_mercaderia;
	private Producto producto;
	private UnidadMedida unidad_medida;
	private Double cantidad;
	private String observacion;
	private java.util.Date fec_necesidad;
	private PedidoCab pedido;
	private PedidoDet pedido_det;
	private Boolean activo;
	private Double cantEnviada;
	private Boolean pendEnvio;
	private Double cantRecep;
	private Boolean pendRecep;

	public Double getCantEnviada() throws BaseException {
		supportRefresh();
		return this.cantEnviada;
	}

	public void setCantEnviada(Double aCantEnviada) {
		this.cantEnviada = aCantEnviada;
	}

	public Boolean isPendEnvio() throws BaseException {
		supportRefresh();
		return this.pendEnvio;
	}

	public void setPendEnvio(Boolean aPendEnvio) {
		this.pendEnvio = aPendEnvio;
	}

	public Boolean isPendRecep() throws BaseException {
		supportRefresh();
		return this.pendRecep;
	}

	public void setPendRecep(Boolean aPendRecep) {
		this.pendRecep = aPendRecep;
	}

	public Double getCantRecepcionada() throws BaseException {
		supportRefresh();
		return this.cantRecep;
	}

	public void setCantRecepcionada(Double aCantRecepcionada) {
		this.cantRecep = aCantRecepcionada;
	}

	public PedMercDep getPedido_mercaderia() throws BaseException {
		supportRefresh();
		return pedido_mercaderia;
	}

	public void setPedido_mercaderia(PedMercDep aPedido_mercaderia) {
		this.pedido_mercaderia = aPedido_mercaderia;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public Double getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public Double getCantPendEnvio() throws BaseException {
		if (this.isPendEnvio() == false)
			return new Double(0);
		else {
			CalculadorMoney calcCantPendEnvio = new CalculadorMoney(new Money(this.getCantidad()));
			calcCantPendEnvio.restar(new Money(this.getCantEnviada()));
			return calcCantPendEnvio.getResult();
		}
	}

	public void setCantidad(Double aCantidad) {
		this.cantidad = aCantidad;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public java.util.Date getFec_necesidad() throws BaseException {
		supportRefresh();
		return fec_necesidad;
	}

	public void setFec_necesidad(java.util.Date aFec_necesidad) {
		this.fec_necesidad = aFec_necesidad;
	}

	public PedidoCab getPedido() throws BaseException {
		supportRefresh();
		return pedido;
	}

	public void setPedido(PedidoCab aPedido) {
		this.pedido = aPedido;
	}

	public PedidoDet getPedido_det() throws BaseException {
		supportRefresh();
		return pedido_det;
	}

	public void setPedido_det(PedidoDet aPedido_det) {
		this.pedido_det = aPedido_det;
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

	public static PedMercDepoDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PedMercDepoDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PedMercDepoDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (PedMercDepoDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	
	
	public static PedMercDepoDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PedMercDepoDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(pedido_mercaderia, "Debe ingresar el Pedido de Mercadería");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(cantidad, "Debe ingresar la cantidad");
		Validar.noNulo(fec_necesidad, "Debe ingresar la Fecha");
	}

	public static List getDetalles(PedMercDep pedidoMercDepo, ISesion aSesion) throws BaseException {
		return DBPedMercDepoDet.getDetalles(pedidoMercDepo, aSesion);
	}
	
	public static List getDetallesPendientesDeEnvio(
			Integer nroExtDesde, 
			Integer nroExtHasta, 
			java.util.Date fecDesde,
			java.util.Date fecHasta, 
			java.util.Date fecReqDesde, 
			java.util.Date fecReqHasta, 
			PedidoCab pedido, 
			Deposito deposito,
			SolicitarAPedMerc solicitarA,
			Producto producto,ISesion aSesion) throws BaseException {
		return DBPedMercDepoDet.getDetallesPendientesDeEnvio(nroExtDesde,nroExtHasta,fecDesde,fecHasta,fecReqDesde,fecReqHasta,pedido,deposito,solicitarA,producto,aSesion);
	}
	
	public void aplicarCantidadesEnviadas(RemitoDet remitoDet) throws BaseException {
		AplicPedDepoRto aplicPedRto = (AplicPedDepoRto) AplicPedDepoRto.getNew(AplicPedDepoRto.NICKNAME, this.getSesion());
		aplicPedRto.setPedido_merc_det(this);
		aplicPedRto.setRemito_det(remitoDet);
		aplicPedRto.setCant_enviada(remitoDet.getCant_desp());
		aplicPedRto.setUm(remitoDet.getUnidad_desp());
		aplicPedRto.setActivo(new Boolean(true));
		aplicPedRto.save();
	}
	
	  public static void actuCantidadEnviada(
			  PedMercDepoDet pedDepoDet,
			  Double cantidad,
			  boolean pendEnvio,
	          ISesion aSesion)
	          throws BaseException {
		  DBPedMercDepoDet.actuCantidadEnviada(pedDepoDet,cantidad,pendEnvio,aSesion);
	  }
	  
	  public void actuCantidadEnviada(
			  Double cantidad,
			  boolean pendEnvio)
	          throws BaseException {
		  DBPedMercDepoDet.actuCantidadEnviada(this,cantidad,pendEnvio,this.getSesion());
	  }
	  
	
	

}
