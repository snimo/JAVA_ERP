package com.srn.erp.ventas.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.da.DBDevolucionVtasDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class DevolucionVtasDet extends ObjetoLogico {

	public DevolucionVtasDet() {
	}

	public static String NICKNAME = "ve.DevolucionVtasDet";

	private DevolucionVtasCab devolucion_cab;
	private Producto producto;
	private String observaciones;
	private Boolean pend_emitir_nc;
	private Boolean modif_precio;
	private Double cantidad_devuelta;
	private UnidadMedida unidad_medida;
	private PedidoDet pedido_det;
	private RemitoDet remito_det;
	private FacturaDet factura_det;
	private Boolean activo;
	private MotivoDevolucionCliente motivo_devolucion;
	private Double cantIngStk;
	private boolean pendIngStk;

	public DevolucionVtasCab getDevolucion_cab() throws BaseException {
		supportRefresh();
		return devolucion_cab;
	}

	public void setDevolucion_cab(DevolucionVtasCab aDevolucion_cab) {
		this.devolucion_cab = aDevolucion_cab;
	}

	public boolean isPendIngStk() throws BaseException {
		supportRefresh();
		return this.pendIngStk;
	}

	public void setPendIngStk(boolean aPendIngStk) {
		this.pendIngStk = aPendIngStk;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setCantIngStk(Double aCantIngStk) {
		this.cantIngStk = aCantIngStk;
	}

	public Double getCantIngStk() throws BaseException {
		supportRefresh();
		return this.cantIngStk;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}
	
	public Double getCantPendIngStock() throws BaseException {
		if (this.isPendIngStk()==false)
			return new Double(0);
		if (!this.isActivo())
			return new Double(0);
		CalculadorMoney calcCantPendIngStk = new CalculadorMoney(new Money(this.getCantidad_devuelta()));
		if (this.getCantIngStk()!=null)
			calcCantPendIngStk.restar(new Money(this.getCantIngStk()));
		return calcCantPendIngStk.getResultMoney().doubleValue();
	}

	public String getObservaciones() throws BaseException {
		supportRefresh();
		return observaciones;
	}

	public void setObservaciones(String aObservaciones) {
		this.observaciones = aObservaciones;
	}

	public Boolean isPend_emitir_nc() throws BaseException {
		supportRefresh();
		return pend_emitir_nc;
	}

	public void setPend_emitir_nc(Boolean aPend_emitir_nc) {
		this.pend_emitir_nc = aPend_emitir_nc;
	}

	public Boolean isModif_precio() throws BaseException {
		supportRefresh();
		return modif_precio;
	}

	public void setModif_precio(Boolean aModif_precio) {
		this.modif_precio = aModif_precio;
	}

	public Double getCantidad_devuelta() throws BaseException {
		supportRefresh();
		return cantidad_devuelta;
	}

	public void setCantidad_devuelta(Double aCantidad_devuelta) {
		this.cantidad_devuelta = aCantidad_devuelta;
	}

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public PedidoDet getPedido_det() throws BaseException {
		supportRefresh();
		return pedido_det;
	}

	public void setPedido_det(PedidoDet aPedido_det) {
		this.pedido_det = aPedido_det;
	}

	public RemitoDet getRemito_det() throws BaseException {
		supportRefresh();
		return remito_det;
	}

	public void setRemito_det(RemitoDet aRemito_det) {
		this.remito_det = aRemito_det;
	}

	public FacturaDet getFactura_det() throws BaseException {
		supportRefresh();
		return factura_det;
	}

	public void setFactura_det(FacturaDet aFactura_det) {
		this.factura_det = aFactura_det;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public MotivoDevolucionCliente getMotivo_devolucion() throws BaseException {
		supportRefresh();
		return motivo_devolucion;
	}

	public void setMotivo_devolucion(MotivoDevolucionCliente aMotivo_devolucion) {
		this.motivo_devolucion = aMotivo_devolucion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static DevolucionVtasDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (DevolucionVtasDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DevolucionVtasDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (DevolucionVtasDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static DevolucionVtasDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (DevolucionVtasDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(devolucion_cab, "Debe ingresar la Devolución");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(cantidad_devuelta, "Debe ingresar la cantidad devuelta");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(motivo_devolucion, "Debe ingresar el Motivo de Devolución");

		if (this.getCantidad_devuelta() <= 0)
			throw new ExceptionValidation(null, "La cantidad devuelta debe ser mayor a cero");
	}

	@Override
	protected void beforeSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveNew();

		double cantIngStk = 0;
		if (this.getCantIngStk() != null)
			cantIngStk = this.getCantIngStk().doubleValue();
		if (this.getCantidad_devuelta().doubleValue() > cantIngStk)
			setPendIngStk(true);

	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getDevolucionesVtasDet(DevolucionVtasCab devolucion, ISesion aSesion) throws BaseException {
		return DBDevolucionVtasDet.getDevolucionesVtasDet(devolucion, aSesion);
	}

	public static List getPendIngStock(Talonario talonario, Sujeto sujeto, FacturaCab factura, RemitoCab remito, PedidoCab pedido,
			Integer nroExt, java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion) throws BaseException {
		return DBDevolucionVtasDet.getPendIngStock(talonario, sujeto, factura, remito, pedido, nroExt, fecDesde, fecHasta, aSesion);

	}
	
	public String getTitulo() throws BaseException {
			return getDevolucion_cab().getSujeto().getRazon_social()+
  			" - "+
  			"Fecha:"+Fecha.getddmmyyyy(getDevolucion_cab().getEmision())+
  			" - Comprobante "+getDevolucion_cab().getCodigo();
	}
	
	  public static void AplicarCantIngStk(
			  DevolucionVtasDet devVtasDet,
			  Double cantIngStk,
			  boolean pendIngStk,
			  ISesion aSesion) throws BaseException {
		  
		  DBDevolucionVtasDet.AplicarCantIngStk(devVtasDet,cantIngStk,pendIngStk,aSesion);
		  
	  }
	  
	  public void aplicarCantIngStk(
			  Double cantIngStk,
			  boolean pendIngStk) throws BaseException {
		  
		  DevolucionVtasDet.AplicarCantIngStk(this,cantIngStk,pendIngStk,this.getSesion());
		  
	  }
	  
		public void afterSaveNew() throws BaseException {
			// TODO Auto-generated method stub
			super.afterSaveNew();
			
			// Grabar la aplicacion, registrando que hay cantidades devueltas sobre el remito
			if (this.getRemito_det()!=null) {
				AplicacionIngDevRto aplicIngDevRto = (AplicacionIngDevRto) AplicacionIngDevRto.getNew(AplicacionIngDevRto.NICKNAME, this.getSesion());
				aplicIngDevRto.setRemito_det(this.getRemito_det());
				aplicIngDevRto.setDevolucion_det(this);
				aplicIngDevRto.setCantidad(this.getCantidad_devuelta());
				aplicIngDevRto.setActivo(new Boolean(true));
				aplicIngDevRto.save();
			}
			
		}
		
		public void validarTenenciaAplicacionesStk() throws BaseException {
			StringBuffer comprobantesStock = new StringBuffer("");
			Iterator iterAplicStock = 
				AplicacionIngDevStock.getAplicacionByDevVtasDetActivas(this,this.getSesion()).iterator();
			while (iterAplicStock.hasNext()) {
				AplicacionIngDevStock aplicIngDevStk = (AplicacionIngDevStock) iterAplicStock.next();
				comprobantesStock.append(" "+aplicIngDevStk.getDevolucion_stk_det().getIngresodevolucionstockcab().getCodigo());
			}
			
			if (comprobantesStock.length()>0)
				throw new ExceptionValidation(null,"El comprobante no puede anularse debido a que tiene asociado "+Util.ENTER()+
						"los siguiente comprobantes:"+comprobantesStock.toString()+" de ingreso de stock."+
						Util.ENTER()+"Anule primero estos comprobantes.");
	
		}
	  
	  
	

}
