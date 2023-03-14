package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.AplicacionRetiroProveedor;
import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.bm.MotivoRechazoCC;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.PedMercDepoDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.da.DBRemitoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class RemitoDet extends ObjetoLogico {

	public void afterSaveNew() throws BaseException {
		// Aplicar las cantidades despachadas del Pedido
		super.afterSaveNew();
		if (getPedidoDet() != null)
			aplicarCantDespContraDetPed();

		// ESTA APLICACIO DE ABAJO NO SE SI QUEDO EN DESUSO
		// Aplicar las cantidades devueltas del Informe de control de calidad
		if (this.getRemito_cab().getTipoRemito().equals(RemitoCab.TIPO_RTO_DEV_PROV))
			aplicarCantDevueltas();

		if (this.getRemito_cab().getComportamientoRto().equals(RemitoCab.DESPACHO_DEV_PROVEEDOR)) 
			if (this.getOCDetPorDevolucion() != null)
				this.getOCDetPorDevolucion().devolucion(this.getCant_desp(), this.getUnidad_desp());
			
		if (this.getRemito_cab().getComportamientoRto().equals(RemitoCab.DESPACHO_PED_PARA_DEPO)) 
			if (this.getPedidoDepositoDet() != null)
					this.getPedidoDepositoDet().aplicarCantidadesEnviadas(this);
		

	}

	private void aplicarCantDespContraDetPed() throws BaseException {
		AplicDespachoPedido aplicDespPed = (AplicDespachoPedido) AplicDespachoPedido.getNew(AplicDespachoPedido.NICKNAME, getSesion());
		aplicDespPed.setPedido_detalle(this.getPedidoDet());
		aplicDespPed.setCant_desp(this.getCant_desp());
		aplicDespPed.setComportamiento_compro(this.getRemito_cab().getTipoCompro().getIdentificacion());
		aplicDespPed.setComprobante_entrega(this.getRemito_cab());
		aplicDespPed.setOid_detalle_compro(this.getOIDInteger());
		aplicDespPed.setActivo(new Boolean(true));
		aplicDespPed.save();
	}

	public RemitoDet() {
	}

	public static String NICKNAME = "ve.RemitoDet";

	private Integer oid;

	private RemitoCab remito_cab;

	private Producto producto;

	private Double cant_desp;

	private Double cant_fact;

	private Double cant_nc;

	private Double cant_devuelta;

	private Boolean pend_fact;

	private UnidadMedida unidad_desp;

	private String comentario;

	private Boolean activo;

	private PedMercDepoDet pedidoMercDepoDet;

	private MotivoRechazoCC motivoDevolucion;

	private CompoStkTalonarioRto compoStkTalonarioRto;

	private PedidoDet pedidoDet;

	private List detallesPartidasSeries = new ArrayList();

	private boolean readDetallesPartidasSeries = true;

	private List detallesMovStock = new ArrayList();

	private boolean readDetallesMovStock = true;

	private InformeControlCalidadDet infCCDet = null;
	
	private Double cantRecep;
	
	private Boolean pendRecep;

	private OrdenDeCompraDet ocDetPorDevolucion;

	public Double getCantRecep() throws BaseException {
		supportRefresh();
		return this.cantRecep;
	}

	public void setCantRecep(Double aCantRecep) throws BaseException {
		this.cantRecep = aCantRecep;
	}
	
	public Boolean isPendRecep() throws BaseException {
		supportRefresh();
		return this.pendRecep;
	}

	public void setPendRecep(Boolean aPendRecep) throws BaseException {
		this.pendRecep = aPendRecep;
	}
	
	public PedidoDet getPedidoDet() throws BaseException {
		supportRefresh();
		return pedidoDet;
	}

	public void setPedidoDepositoDet(PedMercDepoDet aPedidoDepositoDet) throws BaseException {
		this.pedidoMercDepoDet = aPedidoDepositoDet;
	}

	public PedMercDepoDet getPedidoDepositoDet() throws BaseException {
		supportRefresh();
		return this.pedidoMercDepoDet;
	}

	public void setPedidoDet(PedidoDet aPedidoDet) throws BaseException {
		this.pedidoDet = aPedidoDet;
	}

	public Double getCantDevuelta() throws BaseException {
		supportRefresh();
		return this.cant_devuelta;
	}

	public void setCantDevuelta(Double aCantDevuelta) throws BaseException {
		this.cant_devuelta = aCantDevuelta;
	}

	public InformeControlCalidadDet getInfCCDet() throws BaseException {
		supportRefresh();
		return this.infCCDet;
	}

	public void setOCDetPorDevolucion(OrdenDeCompraDet aOCDetPorDev) throws BaseException {
		this.ocDetPorDevolucion = aOCDetPorDev;
	}

	public OrdenDeCompraDet getOCDetPorDevolucion() throws BaseException {
		supportRefresh();
		return this.ocDetPorDevolucion;
	}

	public void setMotivoDevolucion(MotivoRechazoCC aMotivoDevolucion) throws BaseException {
		this.motivoDevolucion = aMotivoDevolucion;
	}

	public MotivoRechazoCC getMotivoDevolucion() throws BaseException {
		supportRefresh();
		return this.motivoDevolucion;
	}

	public void setInformeControlCalidadDet(InformeControlCalidadDet aInfCCDet) throws BaseException {
		this.infCCDet = aInfCCDet;
	}

	public CompoStkTalonarioRto getCompoStkTalonarioRto() throws BaseException {
		supportRefresh();
		return compoStkTalonarioRto;
	}

	public void setCompoStkTalonarioRto(CompoStkTalonarioRto aCompoStkTalonarioRto) throws BaseException {
		this.compoStkTalonarioRto = aCompoStkTalonarioRto;
	}

	public Integer getOid() throws BaseException {
		supportRefresh();
		return oid;
	}

	public void setOid(Integer aOid) {
		this.oid = aOid;
	}

	public RemitoCab getRemito_cab() throws BaseException {
		supportRefresh();
		return remito_cab;
	}

	public void setRemito_cab(RemitoCab aRemito_cab) {
		this.remito_cab = aRemito_cab;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public Double getCant_desp() throws BaseException {
		supportRefresh();
		return cant_desp;
	}

	public void setCant_desp(Double aCant_desp) {
		this.cant_desp = aCant_desp;
	}

	public Double getCant_fact() throws BaseException {
		supportRefresh();
		return cant_fact;
	}

	public Double getCant_NC() throws BaseException {
		supportRefresh();
		return cant_nc;
	}

	public Double getCantPendFact() throws BaseException {
		if (this.isPend_fact().booleanValue() == false)
			return new Double(0);
		if (this.isActivo().booleanValue() == false)
			return new Double(0);
		CalculadorMoney calcPendFact = new CalculadorMoney(new Money(this.getCant_desp().doubleValue()));
		calcPendFact.restar(new Money(this.getCant_fact().doubleValue()));
		if (calcPendFact.getResultMoney().doubleValue() <= 0)
			return new Double(0);
		else
			return new Double(calcPendFact.getResultMoney().doubleValue());
	}
	
	public Double getCantPendRecep() throws BaseException {
		if (this.isPendRecep().booleanValue() == false)
			return new Double(0);
		if (this.isActivo().booleanValue() == false)
			return new Double(0);
		CalculadorMoney calcPendDesp = new CalculadorMoney(new Money(this.getCant_desp()));
		calcPendDesp.restar(new Money(this.getCantRecep().doubleValue()));
		if (calcPendDesp.getResultMoney().doubleValue() <= 0)
			return new Double(0);
		else
			return new Double(calcPendDesp.getResultMoney().doubleValue());
	}
	

	public void setCant_fact(Double aCant_fact) {
		this.cant_fact = aCant_fact;
	}

	public void setCant_NC(Double aCant_NC) {
		this.cant_nc = aCant_NC;
	}

	public Boolean isPend_fact() throws BaseException {
		supportRefresh();
		return pend_fact;
	}

	public boolean isPendienteFacturar() throws BaseException {
		if (this.isPend_fact().booleanValue() && this.isActivo().booleanValue())
			return true;
		else
			return false;
	}

	public void setPend_fact(Boolean aPend_fact) {
		this.pend_fact = aPend_fact;
	}

	public UnidadMedida getUnidad_desp() throws BaseException {
		supportRefresh();
		return unidad_desp;
	}

	public void setUnidad_desp(UnidadMedida aUnidad_desp) {
		this.unidad_desp = aUnidad_desp;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
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

	public static RemitoDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RemitoDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RemitoDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RemitoDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static RemitoDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RemitoDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		Validar.noNulo(remito_cab, "Debe ingresar la Cabecera del Remito");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(cant_desp, "Debe ingresar la cantidad despachada");
		Validar.noNulo(cant_fact, "Debe ingresar la cantidad facturada");
		Validar.noNulo(pend_fact, "Debe indicar si esta pendiente");
		Validar.noNulo(unidad_desp, "Debe Ingresar la Unidad de Medida");

		if (this.getRemito_cab().getComportamientoRto().equals(RemitoCab.DESPACHO_DEV_PROVEEDOR))
			Validar.noNulo(this.motivoDevolucion, "Debe ingresar el Motivo de Devolución");

		// Marcar si se factura todo el remito que no esta pendiente de facturar
		// despacho
		if ((this.isPend_fact().booleanValue() == true) && (this.isActivo().booleanValue()))
			if (this.getCant_fact().doubleValue() >= this.getCant_desp().doubleValue())
				this.setPend_fact(new Boolean(false));

	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() throws BaseException {
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

	public static List getDetalles(RemitoCab aRemitoCab, ISesion aSesion) throws BaseException {
		return DBRemitoDet.getDetalles(aRemitoCab, aSesion);
	}

	public void onNew() throws BaseException {
		setCant_fact(new Double(0));
		setPend_fact(new Boolean(true));
	}

	public List getDetallesPartidasSeries() throws BaseException {
		if (readDetallesPartidasSeries) {
			List listaDetPartSerie = RemitoDetPartidaSerie.getRemitoDetPartidasSeries(this, getSesion());
			detallesPartidasSeries.addAll(listaDetPartSerie);
			readDetallesPartidasSeries = false;
		}
		return detallesPartidasSeries;
	}

	public List getDetallesMovStock() throws BaseException {
		if (readDetallesMovStock) {
			List listaDetMovStock = RemitoDetMovStock.getDetallesMovStock(this, getSesion());
			detallesMovStock.addAll(listaDetMovStock);
			readDetallesMovStock = false;
		}
		return detallesMovStock;
	}

	public void addDetalleMovStock(RemitoDetMovStock rtoDetMovStock) throws BaseException {
		rtoDetMovStock.setRemito_detalle(this);
		detallesMovStock.add(rtoDetMovStock);
	}

	public void addDetallePartidaSerie(RemitoDetPartidaSerie detPartSerie) throws BaseException {
		detPartSerie.setRemito_detalle(this);
		detallesPartidasSeries.add(detPartSerie);
	}

	public void afterSave() throws BaseException {

		Iterator iterDetPartSerie = detallesPartidasSeries.iterator();
		while (iterDetPartSerie.hasNext()) {
			RemitoDetPartidaSerie rtoDetPartSerie = (RemitoDetPartidaSerie) iterDetPartSerie.next();
			rtoDetPartSerie.save();
			rtoDetPartSerie = null;
		}
		iterDetPartSerie = null;

		Iterator iterDetMovStock = detallesMovStock.iterator();
		while (iterDetMovStock.hasNext()) {
			RemitoDetMovStock rtoDetMovStock = (RemitoDetMovStock) iterDetMovStock.next();
			rtoDetMovStock.save();
			rtoDetMovStock = null;
		}
		iterDetMovStock = null;

		// Si se trata de una Devolucion a Proveedor actualizar el Inf. de
		// control de calidad

		// Refrescar al Grabar
		detallesMovStock.clear();
		readDetallesMovStock = true;

		detallesPartidasSeries.clear();
		readDetallesPartidasSeries = true;

	}

	public void aplicarCantDevueltas() throws BaseException {
		if (this.getInfCCDet() == null)
			return;
		AplicacionRetiroProveedor aplicRetProv = (AplicacionRetiroProveedor) AplicacionRetiroProveedor.getNew(
				AplicacionRetiroProveedor.NICKNAME, getSesion());
		aplicRetProv.setControl_calidad_det(this.getInfCCDet());
		aplicRetProv.setRemito_det(this);
		aplicRetProv.setCant_um_stk(this.getCant_desp());
		aplicRetProv.setOid_um_stk(this.getUnidad_desp());

		// Llevarlo a la Unidad de Compra
		Money cantConv = producto.getConvertirUM(this.getRemito_cab().getProveedor(), this.getCant_desp(), this.getUnidad_desp(), this
				.getInfCCDet().getInforme_recepcion_det().getUnidadMedidaCompra());
		aplicRetProv.setCant_um_cpra(cantConv.doubleValue());
		aplicRetProv.setOid_um_cpra(this.getInfCCDet().getInforme_recepcion_det().getUnidadMedidaCompra());
		aplicRetProv.save();
	}

	private void marcarRemitoSiSeFacturo() throws BaseException {

		// Si no existen items pendiente de despacho marcar el pedido como
		// despachado
		if (!this.getRemito_cab().existeAlgunItemPendFact()) {
			this.getRemito_cab().marcaRemitoComoNoPendFact();
		}

	}

	public void afterSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveDelete();
		marcarRemitoSiSeFacturo();
	}

	public void afterSaveModified() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveModified();
		marcarRemitoSiSeFacturo();
	}

	public void afterSaveRehabilitar() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveRehabilitar();
		marcarRemitoSiSeFacturo();
	}

	protected void beforeSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveNew();
		setCantRecep(new Double(0));

		if ((this.isPend_fact().booleanValue()) && (this.getRemito_cab().getComportamientoRto().equals(RemitoCab.DESPACHO_SIN_FACTURACION)))
			this.setPend_fact(new Boolean(false));
		
		if ((this.getRemito_cab().getComportamientoRto().equals(RemitoCab.DESPACHO_PED_PARA_DEPO)))
			this.setPendRecep(new Boolean(true));

	}

	public static List getDetallesPendFact(RemitoCab remitoCab, ISesion aSesion) throws BaseException {
		return DBRemitoDet.getDetallesPendFact(remitoCab, aSesion);
	}

	
	public static List getDetallesPendRecep(
			RemitoCab remitoCab, 
			Deposito deposito,
			Producto producto,
			java.util.Date fecEmiDesde,
			java.util.Date fecEmiHasta,
			Integer nroExtDesde,
			Integer nroExtHasta,
			ISesion aSesion) throws BaseException {
		return DBRemitoDet.getDetallesPendRecep(remitoCab, 
                deposito,
                producto,
                fecEmiDesde,
                fecEmiHasta,
                nroExtDesde,
                nroExtHasta,
                aSesion);
	}
	
	
	public PrecioEnLP getPrecioListaSinIVAParaFact(java.util.Date fecha) throws BaseException {

		PrecioEnLP precioEnLP = new PrecioEnLP();
		if (this.getPedidoDet() != null) {
			precioEnLP.setCantidad(new Money(1));
			precioEnLP.setMoneda(this.getPedidoDet().getPedido().getMoneda());
			precioEnLP.setPrecio(this.getPedidoDet().getPrecio_lista());
			precioEnLP.setUm(this.getPedidoDet().getUni_med_ori());
			return precioEnLP;
		} else {
			ListaPrecios lp = this.getRemito_cab().getLPAUsarParaFact(fecha);
			if (lp == null)
				return null;
			precioEnLP = this.getProducto().getPrecioListaSinIVA(lp, this.getUnidad_desp(), fecha);
			return precioEnLP;
		}
	}

	public PrecioEnLP getPrecioATomarParaFact(java.util.Date fecha) throws BaseException {

		PrecioEnLP precioEnLP = new PrecioEnLP();
		if (this.getPedidoDet() != null) {
			precioEnLP.setCantidad(new Money(1)); // Se asume que el precio del
			// pedido es Unitario
			precioEnLP.setMoneda(this.getPedidoDet().getPedido().getMoneda());
			precioEnLP.setPrecio(this.getPedidoDet().getPrecio());
			precioEnLP.setUm(this.getPedidoDet().getUni_med_ori());
			return precioEnLP;
		} else {

			ListaPrecios lp = this.getRemito_cab().getLPAUsarParaFact(fecha);
			if (lp == null)
				return null;

			PrecioEnLP precioFactura = this.getProducto().getPrecioFactura(lp, this.getRemito_cab().getSujeto(), fecha);

			precioEnLP.setCantidad(new Money(1));
			precioEnLP.setMoneda(precioFactura.getMoneda());
			precioEnLP.setPrecio(precioFactura.getPrecio());
			precioEnLP.setUm(precioFactura.getUm());
			return precioEnLP;

		}

	}

	public static void aplicarCantidadDevuelta(RemitoDet remitoDet, Double cantDevuelta, ISesion aSesion) throws BaseException {

		DBRemitoDet.aplicarCantidadDevuelta(remitoDet, cantDevuelta, aSesion);

	}

	public void actuCantidadesDevueltas(Double cantDevuelta) throws BaseException {

		DBRemitoDet.aplicarCantidadDevuelta(this, cantDevuelta, this.getSesion());

	}

	public Double getCantPermitidaDevolucion() throws BaseException {
		CalculadorMoney cantPermitidaDev = new CalculadorMoney(new Money(this.getCant_desp()));
		if (this.getCantDevuelta() != null)
			cantPermitidaDev.restar(new Money(this.getCantDevuelta()));
		return cantPermitidaDev.getResult();
	}
	
	public static void aplicarCantidadRecepcionada(RemitoDet remitoDet, Double cantRecepcionada, Boolean pendRecep, ISesion aSesion) throws BaseException {
		DBRemitoDet.aplicarCantidadRecepcionada(remitoDet,cantRecepcionada,pendRecep,aSesion);
	}
	

}
