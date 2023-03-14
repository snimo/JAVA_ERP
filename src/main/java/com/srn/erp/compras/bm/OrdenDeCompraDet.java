package com.srn.erp.compras.bm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBAplicRequiDet;
import com.srn.erp.compras.da.DBOrdenDeCompraDet;
import com.srn.erp.ctasAPagar.bm.ComproProvInfRecOC;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class OrdenDeCompraDet extends ObjetoLogico {

	private List		entregas												= new ArrayList();

	private List		listaRequiDetParaAplic					= new ArrayList();

	private List		aplicacionesDetRequisicion			= new ArrayList();

	private boolean	readAplicacionesDetRequisicion	= true;

	private boolean	readEntregas										= true;
	
	private PedidoDet pedidoDet;
	
	private PedidoCab pedidoCab;
	
	private RequisicionDet requisicionDet;
	
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return new Boolean(!this.isAnulado().booleanValue());
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		this.supportRefresh();
		StringBuffer desc = new StringBuffer();
		desc.append("OC "+this.getOrden_de_compra().getNroExt().toString());
		desc.append(" Ped."+ this.getCant_comprada_uc().doubleValue());
		desc.append(" Rec."+ this.getCantRecepUC().doubleValue());
		desc.append(" Pend. "+ this.getCantPendRecepUC());
		desc.append(" Req. "+Fecha.getddmmyyyy(this.getFecRequerida()));
		return desc.toString();
	}

	public OrdenDeCompraDet() {
	}

	public static String			NICKNAME	= "cp.OrdenDeCompraDet";

	private OrdenDeCompraCab	orden_de_compra;

	private Integer						nro_item;

	private UnidadMedida			unidad_compra;

	private Producto					producto;

	private String						desc_adic_sku;

	private UnidadMedida			um_stock;

	private Double						cant_comprada_uc;

	private Double						cant_comprada_us;

	private Moneda						moneda;

	private String						fuente_precio_sug;

	private Double						precio_sugerido;

	private Boolean						anulado;

	private Double						precio_neto_bonif;

	private Double						precio;

	private String						comentario;

	private Double						total;

	private Double						dto1;

	private Double						dto2;

	private Double						dto3;

	private Boolean						enCascada;
	
	private Double						cantFactUC;
	
	private Double						cantFactUS;
	
	private Boolean						pendFact;
	
	private Double cantDevueltaUC;
	
	private Double cantDevueltaUS;
	
	private Porcentaje porcRecar;
	
	private String tipoRecarDto;
	
	private Porcentaje porcDtoRecar;
	
	private Date fecRequerida;
	
	private Double cantRecepUC;
	
	private Double cantRecepUS;
	
	private Boolean pendRecepcion;
	
	
	
	public java.util.Date getFecRequerida() throws BaseException {
		supportRefresh();
		return this.fecRequerida;
	}

	public void setFecRequerida(java.util.Date aFecRequerida) {
		this.fecRequerida = aFecRequerida;
	}
	
	public Double getCantDevueltaUC() throws BaseException {
		supportRefresh();
		return this.cantDevueltaUC;
	}

	public void setCantDevueltaUC(Double aCantDevueltaUC) {
		this.cantDevueltaUC = aCantDevueltaUC;
	}
	
	public Double getCantDevueltaUS() throws BaseException {
		supportRefresh();
		return this.cantDevueltaUS;
	}

	public void setCantDevueltaUS(Double aCantDevueltaUS) {
		this.cantDevueltaUS = aCantDevueltaUS;
	}
	
	

	public PedidoDet getPedidoDet() throws BaseException {
		supportRefresh();
		return this.pedidoDet;
	}
	
	public void setRequisicionDet(RequisicionDet aRequisicionDet) {
		this.requisicionDet = aRequisicionDet;
	}

	public RequisicionDet getRequisicionDet() throws BaseException {
		supportRefresh();
		return this.requisicionDet;
	}
	

	public void setPedidoDet(PedidoDet aPedidoDet) {
		this.pedidoDet = aPedidoDet;
	}
	
	public Boolean isPendFact() throws BaseException {
		supportRefresh();
		return this.pendFact;
	}

	public void setPendFact(Boolean aPendFact) {
		this.pendFact = aPendFact;
	}
	
	public Double getCantPendFactUC() throws BaseException {
		if (this.isPendFact().booleanValue() == false)
			return new Double(0);
		
		CalculadorMoney calcPendFact = new CalculadorMoney(new NumeroBase(0));
		if (this.getCant_comprada_uc()!=null)
			calcPendFact.sumar(new Money(this.getCant_comprada_uc()));
		if (this.getCantFactUC()!=null)
			calcPendFact.restar(new Money(this.getCantFactUC()));
		return calcPendFact.getResultMoney().doubleValue();
	}
	
	
	public Double getCantFactUC() throws BaseException {
		supportRefresh();
		return this.cantFactUC;
	}

	public void setCantFactUC(Double aCantFactUC) {
		this.cantFactUC = aCantFactUC;
	}
	
	public Double getCantFactUS() throws BaseException {
		supportRefresh();
		return this.cantFactUS;
	}

	public void setCantFactUS(Double aCantFactUS) {
		this.cantFactUS = aCantFactUS;
	}
	
	public PedidoCab getPedidoCab() throws BaseException {
		supportRefresh();
		return this.pedidoCab;
	}

	public void setPedidoCab(PedidoCab aPedidoCab) {
		this.pedidoCab = aPedidoCab;
	}
	

	public Double getCantRecepUS() throws BaseException {
		supportRefresh();
		return this.cantRecepUS;
	}

	public void setCantRecepUS(Double aCantRecepUS) {
		this.cantRecepUS = aCantRecepUS;
	}
	
	public Double getCantRecepUC() throws BaseException {
		supportRefresh();
		return this.cantRecepUC;
	}

	public void setCantRecepUC(Double aCantRecepUC) {
		this.cantRecepUC = aCantRecepUC;
	}
	
	public Boolean isPendienteRecepcion() throws BaseException {
		supportRefresh();
		return this.pendRecepcion;
	}
	
	public void setPendienteRecepcion(Boolean aPendRecep) throws BaseException {
		this.pendRecepcion = aPendRecep;
	}
	
	
	
	public String getTipoRecarDto() throws BaseException {
		supportRefresh();
		return this.tipoRecarDto;
	}

	public void setPorcDtoRecar(Porcentaje aPorcDtoRecar) {
		this.porcDtoRecar = aPorcDtoRecar;
	}
	
	public Porcentaje getPorcDtoRecar() throws BaseException {
		supportRefresh();
		return this.porcDtoRecar;
	}

	public void setTipoRecarDto(String aTipoRecarDto) {
		this.tipoRecarDto = aTipoRecarDto;
	}
	
	
	
	public OrdenDeCompraCab getOrden_de_compra() throws BaseException {
		supportRefresh();
		return orden_de_compra;
	}

	public void setOrden_de_compra(OrdenDeCompraCab aOrden_de_compra) {
		this.orden_de_compra = aOrden_de_compra;
	}
	
	public Porcentaje getPorcRecar() throws BaseException {
		supportRefresh();
		return this.porcRecar;
	}

	public void setPorcRecar(Porcentaje aPorcRecar) {
		this.porcRecar = aPorcRecar;
	}
	

	public Double getDto1() throws BaseException {
		supportRefresh();
		return dto1;
	}

	public void setDto1(Double aDto1) {
		this.dto1 = aDto1;
	}

	public Double getDto2() throws BaseException {
		supportRefresh();
		return dto2;
	}

	public void setDto2(Double aDto2) {
		this.dto2 = aDto2;
	}

	public Double getDto3() throws BaseException {
		supportRefresh();
		return dto3;
	}

	public void setDto3(Double aDto3) {
		this.dto3 = aDto3;
	}

	public Integer getNro_item() throws BaseException {
		supportRefresh();
		return nro_item;
	}

	public void setNro_item(Integer aNro_item) {
		this.nro_item = aNro_item;
	}

	public Boolean isEnCascada() throws BaseException {
		supportRefresh();
		return enCascada;
	}

	public void setEnCascada(Boolean aEnCascada) {
		this.enCascada = aEnCascada;
	}

	public UnidadMedida getUnidad_compra() throws BaseException {
		supportRefresh();
		return unidad_compra;
	}

	public void setUnidad_compra(UnidadMedida aUnidad_compra) {
		this.unidad_compra = aUnidad_compra;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public String getDesc_adic_sku() throws BaseException {
		supportRefresh();
		return desc_adic_sku;
	}

	public void setDesc_adic_sku(String aDesc_adic_sku) {
		this.desc_adic_sku = aDesc_adic_sku;
	}

	public UnidadMedida getUm_stock() throws BaseException {
		supportRefresh();
		return um_stock;
	}

	public void setUm_stock(UnidadMedida aUm_stock) {
		this.um_stock = aUm_stock;
	}

	public Double getCant_comprada_uc() throws BaseException {
		supportRefresh();
		return cant_comprada_uc;
	}

	public void setCant_comprada_uc(Double aCant_comprada_uc) {
		this.cant_comprada_uc = aCant_comprada_uc;
	}

	public Double getCant_comprada_us() throws BaseException {
		supportRefresh();
		return cant_comprada_us;
	}

	public void setCant_comprada_us(Double aCant_comprada_us) {
		this.cant_comprada_us = aCant_comprada_us;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public String getFuente_precio_sug() throws BaseException {
		supportRefresh();
		return fuente_precio_sug;
	}

	public void setFuente_precio_sug(String aFuente_precio_sug) {
		this.fuente_precio_sug = aFuente_precio_sug;
	}

	public Double getPrecio_sugerido() throws BaseException {
		supportRefresh();
		return precio_sugerido;
	}

	public void setPrecio_sugerido(Double aPrecio_sugerido) {
		this.precio_sugerido = aPrecio_sugerido;
	}

	public Boolean isAnulado() throws BaseException {
		supportRefresh();
		return anulado;
	}

	public void setAnulado(Boolean aAnulado) {
		this.anulado = aAnulado;
	}

	public Double getPrecio_neto_bonif() throws BaseException {
		supportRefresh();
		return precio_neto_bonif;
	}

	public void setPrecio_neto_bonif(Double aPrecio_neto_bonif) {
		this.precio_neto_bonif = aPrecio_neto_bonif;
	}

	public Double getPrecio() throws BaseException {
		supportRefresh();
		return precio;
	}

	public void setPrecio(Double aPrecio) {
		this.precio = aPrecio;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public Double getTotal() throws BaseException {
		supportRefresh();
		return total;
	}

	public void setTotal(Double aTotal) {
		this.total = aTotal;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static OrdenDeCompraDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (OrdenDeCompraDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static OrdenDeCompraDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (OrdenDeCompraDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static OrdenDeCompraDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (OrdenDeCompraDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(orden_de_compra, "Debe ingresar la Orden de Compra");
		Validar.noNulo(nro_item, "Debe ingresar el Nro. de Item");
		Validar.noNulo(unidad_compra, "Debe ingresar la Unidad de Medida de Compra");
		Validar.noNulo(producto, "Debe ingresar el producto");
		Validar.noNulo(um_stock, "Debe ingresar la Unidad de Medida de Stock");
		Validar.noNulo(cant_comprada_uc, "Debe ingresar la cantidad en Unidades de Compra");
		Validar.noNulo(cant_comprada_us, "Debe ingresar la cantidad en Unidades de Stock");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(anulado, "Debe ingresar si el campo esta o no anulado");
		Validar.noNulo(precio_neto_bonif, "Debe ingresar el Precio Neto de Bonificación");
		Validar.noNulo(precio, "Debe ingresar el Precio");
		Validar.noNulo(total, "Debe ingresar el Total");
		Validar.noNulo(this.fecRequerida, "Debe ingresar la Fecha requerida del Producto");
	}

	public static List getDetallesOC(OrdenDeCompraCab ordenDeCompraCab, ISesion aSesion) throws BaseException {
		return DBOrdenDeCompraDet.getDetallesOC(ordenDeCompraCab, aSesion);
	}

	public void afterSave() throws BaseException {

		Iterator iterAplicDetRequi = aplicacionesDetRequisicion.iterator();
		while (iterAplicDetRequi.hasNext()) {
			AplicRequiDet aplicRequiDet = (AplicRequiDet) iterAplicDetRequi.next();
			aplicRequiDet.save();
			aplicRequiDet = null;
		}
		iterAplicDetRequi = null;

	}

	public static List getDetallesByProductoProveedor(Producto producto, Proveedor proveedor, ISesion aSesion)
			throws BaseException {
		return DBOrdenDeCompraDet.getDetallesByProductoProveedor(producto, proveedor, aSesion);
	}

	public void afterSaveNew() throws BaseException {

		// Marcar la Orden de Compra de Entrega

	}

	public void addRequiDetParaAplicar(RequisicionDet requiDet) throws BaseException {
		listaRequiDetParaAplic.add(requiDet);
	}

	public void generarAplicParaRequi() throws BaseException {

		Double cantCompradaEnUC = getCant_comprada_uc();
		CalculadorMoney calcAgotarCantComprada = new CalculadorMoney(new NumeroBase(cantCompradaEnUC));

		if (cantCompradaEnUC.doubleValue() == 0)
			return;

		Iterator iterRequiDet = listaRequiDetParaAplic.iterator();
		while (iterRequiDet.hasNext()) {
			RequisicionDet requiDet = (RequisicionDet) iterRequiDet.next();

			// Convertir la cantidad comprada a cantidades en Unidades de la
			// Requisicion
			Proveedor proveedor = getOrden_de_compra().getProveedor();
			Money cantCompradaEnUniRequi = getProducto().getConvertirUM(proveedor,
					new Double(calcAgotarCantComprada.getResult()), getUnidad_compra(), requiDet.getUnidad_medida_req());

			// Agotar la cantidad compradas en el Detalle de la requisicion
			if (requiDet.getCant_solicitada().doubleValue() > cantCompradaEnUniRequi.doubleValue()) {
				AplicRequiDet aplicRequiDet = (AplicRequiDet) AplicRequiDet.getNew(AplicRequiDet.NICKNAME, getSesion());
				aplicRequiDet.setActivo(new Boolean(true));
				aplicRequiDet.setRequisicion_det(requiDet);
				aplicRequiDet.setDetalle_oc(this);
				aplicRequiDet.setCant_comprada(cantCompradaEnUniRequi.doubleValue());
				addAplicacionDetRequisicion(aplicRequiDet);

				// Convertir las cantidades aplicadas en Unidades de Requisicion a Unidades de Compras
				// y agogar sobre la cantidad comprada en la Orden de Compra
				Money cantAplicEnUC = getProducto().getConvertirUM(proveedor, cantCompradaEnUniRequi.doubleValue(),
						requiDet.getUnidad_medida_req(), getUnidad_compra());
				calcAgotarCantComprada.restar(new NumeroBase(cantAplicEnUC.doubleValue()));
			}
			else {
				AplicRequiDet aplicRequiDet = (AplicRequiDet) AplicRequiDet.getNew(AplicRequiDet.NICKNAME, getSesion());
				aplicRequiDet.setActivo(new Boolean(true));
				aplicRequiDet.setRequisicion_det(requiDet);
				aplicRequiDet.setDetalle_oc(this);
				aplicRequiDet.setCant_comprada(requiDet.getCant_solicitada());
				addAplicacionDetRequisicion(aplicRequiDet);

				// Convertir las cantidades aplicadas en Unidades de Requisicion a Unidades de Compras
				// y agogar sobre la cantidad comprada en la Orden de Compra
				Money cantAplicEnUC = getProducto().getConvertirUM(proveedor, requiDet.getCant_solicitada(),
						requiDet.getUnidad_medida_req(), getUnidad_compra());
				calcAgotarCantComprada.restar(new NumeroBase(cantAplicEnUC.doubleValue()));

			}

			if (calcAgotarCantComprada.getResult() == 0)
				break;

		}
	}

	public List getAplicacionesDetRequisiciones() throws BaseException {
		if (readAplicacionesDetRequisicion) {
			List listaAplicaciones = AplicRequiDet.getAplicRequiDet(this, getSesion());
			aplicacionesDetRequisicion.addAll(listaAplicaciones);
			readAplicacionesDetRequisicion = false;
		}
		return aplicacionesDetRequisicion;
	}

	public void addAplicacionDetRequisicion(AplicRequiDet aAplicRequiDet) throws BaseException {
		aAplicRequiDet.setDetalle_oc(this);
		aplicacionesDetRequisicion.add(aAplicRequiDet);
	}

	public void anular() throws BaseException {

		// Anular las aplicaciones de las Requisiciones
		Iterator iterAplicRequi = getAplicRequiDet().iterator();
		while (iterAplicRequi.hasNext()) {
			AplicRequiDet aplicRequiDet = (AplicRequiDet) iterAplicRequi.next();
			aplicRequiDet.delete();
			aplicRequiDet.save();
		}
	}

	public List getAplicRequiDet() throws BaseException {
		return DBAplicRequiDet.getAplicOCDet(this, getSesion());
	}

	public static List getDetallesOC(OrdenDeCompraCab ordenDeCompraCab, LugarEntrega lugarEntrega, ISesion aSesion)
			throws BaseException {
		return DBOrdenDeCompraDet.getDetallesOC(ordenDeCompraCab, lugarEntrega, aSesion);
	}

	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();
		
		// Inicializar el detalle indicando que se encuentra pendiente de recepcion
		this.setCantRecepUC(new Double(0));
		this.setCantRecepUS(new Double(0));
		this.setPendienteRecepcion(new Boolean(true));
		
	}
	
	public Double getCantPendRecepUC() throws BaseException {
		
		if (this.isAnulado().booleanValue()==true)
			return new Double(0);
		
		if (this.isPendienteRecepcion().booleanValue()==false)
			return new Double(0);
					
		CalculadorMoney calcCantPend = new CalculadorMoney(new Money(this.getCant_comprada_uc().doubleValue()));
		calcCantPend.restar(new Money(this.getCantRecepUC().doubleValue()));
		return new Double(calcCantPend.getResult());
		
	}
	
	public Double getCantPendRecepUS() throws BaseException {
		
		if (this.isAnulado().booleanValue()==true)
			return new Double(0);
		
		if (this.isPendienteRecepcion().booleanValue()==false)
			return new Double(0);
					
		CalculadorMoney calcCantPend = new CalculadorMoney(new Money(this.getCant_comprada_us().doubleValue()));
		calcCantPend.restar(new Money(this.getCantRecepUS().doubleValue()));
		return new Double(calcCantPend.getResult());
		
	}
	
	public static List getDetallesOCPendRecep(OrdenDeCompraCab oc,
				ISesion aSesion) throws BaseException {
		return DBOrdenDeCompraDet.getDetallesOCPendRecep(oc,aSesion);
	}
	
	public static List getDetallesOCPendRecep(PedidoDet pedidoDet,
			ISesion aSesion) throws BaseException {
		return DBOrdenDeCompraDet.getDetallesOCPendRecep(pedidoDet,aSesion);
	}	
	
	public void setRecepcionPorInfRecEnUS(Double cantRecepEnUS)
	throws BaseException {
		supportRefresh();
		CalculadorMoney calcCantRecepUS = new CalculadorMoney(new NumeroBase(this.getCantRecepUS()));
		calcCantRecepUS.sumar(new NumeroBase(cantRecepEnUS));
		this.setCantRecepUS(new Double(calcCantRecepUS.getResultMoney().doubleValue()));
  }
	
	public void setRecepcionPorInfRecEnUC(Double cantRecepEnUC)
	throws BaseException {
		supportRefresh();
		CalculadorMoney calcCantRecepUC = new CalculadorMoney(new NumeroBase(this.getCantRecepUC()));
		calcCantRecepUC.sumar(new NumeroBase(cantRecepEnUC));
    this.setCantRecepUC(new Double(calcCantRecepUC.getResultMoney().doubleValue()));
  }
	
	public boolean analizarSiEstaPendRecepcion() throws BaseException {
		
		if (!this.getOrden_de_compra().isActivo())
			return false;
		
		if (this.isAnulado())
			return false;
		
		if (this.getCant_comprada_uc().doubleValue() > this.getCantRecepUC().doubleValue())
			return true;
		else
			return false;
	}
	
	
	public void marcarSiNoEstaPendienteDeRecep() throws BaseException {
		if (analizarSiEstaPendRecepcion())
			this.setPendienteRecepcion(new Boolean(true));
		else
			this.setPendienteRecepcion(new Boolean(false));
	}
	
	public static List getDetallesByCondiciones(HashTableDatos condiciones,
      ISesion aSesion) throws BaseException {
		return DBOrdenDeCompraDet.getDetallesByCondiciones(condiciones,aSesion);
		
	}
	

	public void aplicarCantFacturadas(Double aCantFactUC,Double aCantFactUS) throws BaseException {
		
		// Aplicar la cantidad Facturada en Unidades de Compra
		Double cantFactUC = new Double(0);
		if (getCantFactUC()!=null)
			cantFactUC = getCantFactUC();
		CalculadorMoney calcCanfFactUC = new CalculadorMoney(new NumeroBase(cantFactUC));
		calcCanfFactUC.sumar(new NumeroBase(aCantFactUC));		
		setCantFactUC(new Double(calcCanfFactUC.getResultMoney().doubleValue()));
		
		// Aplicar la cantidad Facturada en Unidades de Stock
		Double cantFactUS = new Double(0);
		if (getCantFactUS()!=null)
			cantFactUS = getCantFactUS();
		CalculadorMoney calcCanfFactUS = new CalculadorMoney(new NumeroBase(cantFactUS));
		calcCanfFactUS.sumar(new NumeroBase(aCantFactUS));
		setCantFactUS(new Double(calcCanfFactUS.getResultMoney().doubleValue()));
		
		// Verificar si el item se encuentra pendiente de recepcion
		if (this.getCant_comprada_uc().doubleValue()<=getCantFactUS().doubleValue()) 
			setPendFact(new Boolean(false));
		else
			setPendFact(new Boolean(true));
		
	}
	
	public static List getDetallesByProvProdGralMasCercaAFecha(
			java.util.Date fecha,
			Proveedor proveedor,
			ValorClasificadorEntidad valorClasif,
            ISesion aSesion) throws BaseException {
		
		return DBOrdenDeCompraDet.getDetallesByProvProdGralMasCercaAFecha(
				fecha,
				proveedor,
				valorClasif,
				aSesion);

	}
	
	public static List getDetallesOCPendRecep(Producto producto,
			ISesion aSesion) throws BaseException {
		return DBOrdenDeCompraDet.getDetallesOCPendRecep(producto,aSesion);
	}
	
	public static int getMaxNroRenglon(ISesion sesion,OrdenDeCompraCab oc)
	throws BaseException {
		
		return DBOrdenDeCompraDet.getMaxNroRenglon(sesion,oc);
		
	}
	
	public static void actuCantDevueltas(ISesion aSesion, OrdenDeCompraDet ocDet, Double cantDevUS , Double cantDevUC) throws BaseException {
		DBOrdenDeCompraDet.actuCantDevueltas(aSesion, ocDet, cantDevUS, cantDevUC);
	}
	
	public static void actuMarcarCompPendRecep(ISesion aSesion, OrdenDeCompraDet ocDet, boolean pendRecep) throws BaseException {
		DBOrdenDeCompraDet.actuMarcarCompPendRecep(aSesion, ocDet, pendRecep);
	}
	
	public static void actuCantRecepcionadas(ISesion aSesion, OrdenDeCompraDet ocDet , Double cantRecUS , Double cantRecUC) throws BaseException {
		DBOrdenDeCompraDet.actuCantRecepcionadas(aSesion, ocDet, cantRecUS , cantRecUC);
	}
	
	public void devolucion(Double cantDevolucion , UnidadMedida um) throws BaseException {
		
		
		Double cantDevUC = new Double(0);
		Double cantDevUS = new Double(0);
		
		if (cantDevolucion!=null) {
			// Convertir a Unidades de Stock y a Unidades de Compra
			cantDevUS = 
				this.getProducto().getConvertirUM(this.getOrden_de_compra().getProveedor(), cantDevolucion, um , this.getProducto().getUm_stk()).doubleValue();
			
			cantDevUC = 
				this.getProducto().getConvertirUM(this.getOrden_de_compra().getProveedor(), cantDevolucion, um , this.getProducto().getUm_cpra()).doubleValue();						
			
		}

		OrdenDeCompraDet ocDet = OrdenDeCompraDet.findByOid(this.getOIDInteger(), this.getSesion());
		
		// Actualizar las cantidades devueltas
		CalculadorMoney acumDevEnUC = new CalculadorMoney(new Money(0));
		if (ocDet.getCantDevueltaUC()!=null)
			acumDevEnUC.sumar(new Money(ocDet.getCantDevueltaUC().doubleValue()));
		if (cantDevUC!=null)
			acumDevEnUC.sumar(new Money(cantDevUC));
		
		CalculadorMoney acumDevEnUS = new CalculadorMoney(new Money(0));
		if (ocDet.getCantDevueltaUS()!=null)
			acumDevEnUS.sumar(new Money(ocDet.getCantDevueltaUS().doubleValue()));
		if (cantDevUS!=null)
			acumDevEnUS.sumar(new Money(cantDevUS));
		
		Double cantDevueltasEnUS = new Double(0);
		Double cantDevueltasEnUC = new Double(0);
		
		if (acumDevEnUS.getResult()>0)
			cantDevueltasEnUS = acumDevEnUS.getResult();
		
		if (acumDevEnUC.getResult()>0)
			cantDevueltasEnUC = acumDevEnUC.getResult();
			
		
		actuCantDevueltas(this.getSesion(), ocDet , cantDevueltasEnUS , cantDevueltasEnUC);
		
		// Calcular las cantidades Recepcionadas
		Double cantRecepEnUS = new Double(0);
		Double cantRecepEnUC = new Double(0);
		
		CalculadorMoney calcCantRecepUS = new CalculadorMoney(new Money(0));
		if (ocDet.getCantRecepUS()!=null)
			calcCantRecepUS.sumar(new Money(ocDet.getCantRecepUS().doubleValue()));
		calcCantRecepUS.restar(new Money(cantDevUS));
		if (calcCantRecepUS.getResult()>0)
			cantRecepEnUS = calcCantRecepUS.getResult(); 
		
		CalculadorMoney calcCantRecepUC = new CalculadorMoney(new Money(0));
		if (ocDet.getCantRecepUC()!=null)
			calcCantRecepUC.sumar(new Money(ocDet.getCantRecepUC().doubleValue()));
		calcCantRecepUC.restar(new Money(cantDevUC));
		if (calcCantRecepUC.getResult()>0)
			cantRecepEnUC = calcCantRecepUC.getResult();		
		
		actuCantRecepcionadas(this.getSesion(), ocDet, cantRecepEnUS, cantRecepEnUC);
		
		// Analisis si esta o no pendiente de recepcion
		OrdenDeCompraDet ocDetParaAnalisisPendRec =
			OrdenDeCompraDet.findByOid(this.getOIDInteger(), this.getSesion());
		boolean pendRecep = ocDetParaAnalisisPendRec.analizarSiEstaPendRecepcion();
		actuMarcarCompPendRecep(this.getSesion(), ocDetParaAnalisisPendRec, pendRecep);
		
	}
	
	public List getComproProvInfRecOC() throws BaseException {
		return ComproProvInfRecOC.getComproProvProductoOCDetActivo(this, this.getSesion());
	}
	
	public static double getCantProdOCPendRecep(Producto producto, ISesion aSesion) throws BaseException {

		return DBOrdenDeCompraDet.getCantProdOCPendRecep(producto, aSesion);
			
	}	


}
