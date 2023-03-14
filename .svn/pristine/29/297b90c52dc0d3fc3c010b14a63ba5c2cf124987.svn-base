package com.srn.erp.ventas.bm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.RenglonMovStock;
import com.srn.erp.stock.bm.RenglonesStock;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.da.DBFacturaCab;
import com.srn.erp.ventas.da.DBRemitoCab;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class RemitoCab extends ComproCab implements IStockeable {

	public RemitoCab() {
	}
	
	public static final String TIPO_RTO_DESP_CLI = "DESP_CLI";
	public static final String TIPO_RTO_DEV_PROV = "DEV_PROV";

	private RemitoCabAnulacion comprobanteAnulacion;
	
	public static final String			DESPACHO_PEDIDO_CLIENTE		= "DPC";

	public static final String			DESPACHO_SIN_FACTURACION	= "DSF";
	
	public static final String      DESPACHO_DIRECTO_CLIENTE  = "DDC";
	
	public static final String      DESPACHO_DEV_PROVEEDOR  = "DDP";
	
	public static final String      DESPACHO_PED_PARA_DEPO  = "DPD";
	

	private List										detalles									= new ArrayList();

	private boolean									readDetalle								= true;

	private List										detMovStockSugerido				= new ArrayList();

	private boolean									readMovStockSugerido			= true;

	public static String						NICKNAME									= "ve.RemitoCab";

	private ComproCab								comprobante;

	private String									comportamientoRto;

	private Sujeto									sujeto;

	private String									destinatario;

	private String									destino;

	private Deposito								depo_destivo;

	private UnidadEdilicia					uni_edi_dest;

	private UnidadOrganizativa			uni_org_dest;

	private Boolean									pend_fact;

	private String									calle_y_nro;

	private String									localidad;

	private String									codigo_postal;

	private Provincia								provincia;

	private Pais										pais;

	private CompoStkTalonarioRto		compoStockTalRto;

	private TipoConfMovStkTalonario	tipoConfMov;

	private Proveedor								proveedor;

	private String									tipoRemito;
	
	private String comentario;
	
	private String referencia1;
	
	private String referencia2;

	public void setTipoConfMovStk(TipoConfMovStkTalonario tipoConfMov) {
		this.tipoConfMov = tipoConfMov;
	}
	
	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}
	

	public TipoConfMovStkTalonario getTipoConfMov() throws BaseException {
		supportRefresh();
		return tipoConfMov;
	}
	
	public void setTipoRemito(String aTipoRemito) {
		this.tipoRemito = aTipoRemito;
	}

	public String getTipoRemito() throws BaseException {
		supportRefresh();
		return this.tipoRemito;
	}
	
	public String getComentario() throws BaseException {
		supportRefresh();
		return this.comentario;
	}
	
	

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return proveedor;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public CompoStkTalonarioRto getCompoStkTalRto() throws BaseException {
		supportRefresh();
		return compoStockTalRto;
	}

	public void setCompoStkTalRto(CompoStkTalonarioRto aCompoStkTalRto) throws BaseException {
		this.compoStockTalRto = aCompoStkTalRto;
	}

	public String getComportamientoRto() throws BaseException {
		supportRefresh();
		return comportamientoRto;
	}

	public void setComportamientoRto(String aComportamientoRto) {
		this.comportamientoRto = aComportamientoRto;
	}

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) {
		this.sujeto = aSujeto;
	}

	public String getDestinatario() throws BaseException {
		supportRefresh();
		return destinatario;
	}

	public void setDestinatario(String aDestinatario) {
		this.destinatario = aDestinatario;
	}

	public String getDestino() throws BaseException {
		supportRefresh();
		return destino;
	}

	public void setDestino(String aDestino) {
		this.destino = aDestino;
	}

	public Deposito getDepo_destino() throws BaseException {
		supportRefresh();
		return depo_destivo;
	}

	public void setDepo_destino(Deposito aDepo_destivo) {
		this.depo_destivo = aDepo_destivo;
	}

	public UnidadEdilicia getUni_edi_dest() throws BaseException {
		supportRefresh();
		return uni_edi_dest;
	}

	public void setUni_edi_dest(UnidadEdilicia aUni_edi_dest) {
		this.uni_edi_dest = aUni_edi_dest;
	}

	public UnidadOrganizativa getUni_org_dest() throws BaseException {
		supportRefresh();
		return uni_org_dest;
	}

	public void setUni_org_dest(UnidadOrganizativa aUni_org_dest) {
		this.uni_org_dest = aUni_org_dest;
	}

	public Boolean isPend_fact() throws BaseException {
		supportRefresh();
		return pend_fact;
	}

	public void setPend_fact(Boolean aPend_fact) {
		this.pend_fact = aPend_fact;
	}

	public String getCalle_y_nro() throws BaseException {
		supportRefresh();
		return calle_y_nro;
	}

	public void setCalle_y_nro(String aCalle_y_nro) {
		this.calle_y_nro = aCalle_y_nro;
	}

	public String getLocalidad() throws BaseException {
		supportRefresh();
		return localidad;
	}

	public void setLocalidad(String aLocalidad) {
		this.localidad = aLocalidad;
	}

	public String getCodigo_postal() throws BaseException {
		supportRefresh();
		return codigo_postal;
	}

	public void setCodigo_postal(String aCodigo_postal) {
		this.codigo_postal = aCodigo_postal;
	}

	public Provincia getProvincia() throws BaseException {
		supportRefresh();
		return provincia;
	}

	public void setProvincia(Provincia aProvincia) {
		this.provincia = aProvincia;
	}

	public Pais getPais() throws BaseException {
		supportRefresh();
		return pais;
	}

	public void setPais(Pais aPais) {
		this.pais = aPais;
	}
	
	public String getReferencia1() throws BaseException {
		supportRefresh();
		return this.referencia1;
	}

	public void setReferencia2(String aReferencia2) {
		this.referencia2 = aReferencia2;
	}

	
	public String getReferencia2() throws BaseException {
		supportRefresh();
		return this.referencia2;
	}

	public void setReferencia1(String aReferencia1) {
		this.referencia1 = aReferencia1;
	}
	
	

	public String getNickName() {
		return NICKNAME;
	}

	public static RemitoCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RemitoCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RemitoCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RemitoCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		
		Validar.noNulo(comportamientoRto, "Debe Ingresar el Tipo");
		Validar.noNulo(comportamientoRto, "Debe ingresar el Tipo de Remito");
		Validar.noNulo(provincia, "Debe ingresar la Provincia");
		if (comportamientoRto.equals(RemitoCab.DESPACHO_DEV_PROVEEDOR))
			Validar.noNulo(this.getProveedor(), "Debe ingresar un Proveedor");
		else if (comportamientoRto.equals(RemitoCab.DESPACHO_PED_PARA_DEPO))
			Validar.noNulo(this.getDepo_destino(), "Debe ingresar el Depósito Destino");
		else
			Validar.noNulo(this.getSujeto(), "Debe ingresar un Cliente");
		
		Validar.noNulo(this.getCalle_y_nro(),"Debe ingresar la dirección");
		
		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}
		beforeSaveComprobante(this);
		
		
	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() throws BaseException {
		return super.getDescripcion();
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public static Hashtable getTipos() throws BaseException {
		Hashtable tipos = new Hashtable();
		tipos.put(DESPACHO_PEDIDO_CLIENTE, "1-Pedido de Cliente");
		tipos.put(DESPACHO_SIN_FACTURACION, "2-Sin facturación");
		tipos.put(DESPACHO_DIRECTO_CLIENTE, "3-Directo a Cliente");
		tipos.put(DESPACHO_DEV_PROVEEDOR, "4-Devolución a Proveedor");
		tipos.put(DESPACHO_PED_PARA_DEPO,"5-Envío a Depósito");
		return tipos;
	}

	public static String getTipoRemito(String aTipo) throws BaseException {
		Hashtable tipos = getTipos();
		return (String) tipos.get(aTipo);
	}

	public static Hashtable getTiposDespSinFactu() throws BaseException {
		Hashtable tipos = new Hashtable();
		tipos.put(DESPACHO_SIN_FACTURACION, "Despacho Sin facturación");
		return tipos;
	}

	protected void grabarDetalles() throws BaseException {

		
		if (this.detalles.isEmpty()) 
			throw new ExceptionValidation(null,"Debe ingresar algún producto en el Remito");
		
		
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			RemitoDet remitoDet = (RemitoDet) iterDetalles.next();
			remitoDet.save();
			remitoDet = null;
		}
		iterDetalles = null;
	}

	public void afterSave() throws BaseException {

		grabarDetalles();

		Iterator iterRemitoCabMovStock = detMovStockSugerido.iterator();
		while (iterRemitoCabMovStock.hasNext()) {
			RemitoCabMovStock remitoCabMovStock = (RemitoCabMovStock) iterRemitoCabMovStock.next();
			remitoCabMovStock.save();
			remitoCabMovStock = null;
		}
		iterRemitoCabMovStock = null;

		afterSaveComprobante(this);
		
		// Si el comprobante sale por impresora fiscal
		// actualizar en el talonario el Nro. de comprobante
		
		if (this.getTalonario().isUsaImpresoraFiscal()) {
			// Actualizar el Talonatio
			this.getTalonario().setNro_actual(this.getNroExt());
			this.getTalonario().save();
		}
		

	}

	public void addDetalle(RemitoDet remitoDet) throws BaseException {
		this.detalles.add(remitoDet);
		remitoDet.setRemito_cab(this);
	}

	public void addDetMovStock(RemitoCabMovStock remitoCabMovStock) throws BaseException {
		remitoCabMovStock.setRemito_cabecera(this);
		detMovStockSugerido.add(remitoCabMovStock);
	}

	public RemitoDet addDetalle() throws BaseException {
		RemitoDet remitoDet = (RemitoDet) RemitoDet.getNew(RemitoDet.NICKNAME, getSesion());
		remitoDet.setRemito_cab(this);
		detalles.add(remitoDet);
		return remitoDet;
	}	
	
	public List getDetalles() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(RemitoDet.getDetalles(this, getSesion()));
			readDetalle = false;
			return detalles;
		}
		else
			return detalles;
	}

	public List getDetMovStockSugeridos() throws BaseException {
		if (readMovStockSugerido == true) {
			detMovStockSugerido.addAll(RemitoCabMovStock.getMovimientosStock(this, getSesion()));
			readMovStockSugerido = false;
			return detMovStockSugerido;
		}
		else
			return detMovStockSugerido;
	}

	public void onNew() throws BaseException {
		setPend_fact(new Boolean(true));
	}

	public ComproCab getComprobante() {
		return this;
	}

	/**
	 * Actualizar el Stock
	 */
	public RenglonesStock getRenglonesStock() throws BaseException {
		RenglonesStock renglonesStock = new RenglonesStock();
		Iterator iterDetRto = detalles.iterator();
		while (iterDetRto.hasNext()) {
			RemitoDet remitoDet = (RemitoDet) iterDetRto.next();
			if (remitoDet.getProducto().isStockeable().booleanValue())
				armarMovStock(renglonesStock, remitoDet);
		}
		return renglonesStock;
	}

	private void armarMovStock(RenglonesStock renglonresStock, RemitoDet remitoDet) throws BaseException {
		if (remitoDet.getProducto().isLlevaPartida().booleanValue()
				|| remitoDet.getProducto().isLlevaSerie().booleanValue())
			armarMovStockPartidaSerie(renglonresStock, remitoDet);
		else
			armarMovStockSinPartidaNiSerie(renglonresStock, remitoDet);
	}

	private void armarMovStockSinPartidaNiSerie(RenglonesStock renglonresStock, RemitoDet remitoDet) throws BaseException {
		if (remitoDet.getDetallesMovStock().isEmpty())
			armarMovStockSinPartNiSerieConMovCabecera(renglonresStock, remitoDet);
		else
			armarMovStockSinPartNiSerieConMovDetalle(renglonresStock, remitoDet);

	}

	private void armarMovStockSinPartNiSerieConMovDetalle(RenglonesStock renglonresStock, RemitoDet remitoDet)
			throws BaseException {
		if (remitoDet.getDetallesMovStock().isEmpty())
			throw new ExceptionValidation(null, "No se ingresaron movimientos de Stock para el producto "
					+ remitoDet.getProducto().getCodigo() + " - " + remitoDet.getProducto().getDescripcion());

		Iterator iterMovStock = remitoDet.getDetallesMovStock().iterator();
		while (iterMovStock.hasNext()) {
			RemitoDetMovStock rtoDetMovStk = (RemitoDetMovStock) iterMovStock.next();
			RenglonMovStock renglonMovStk = renglonresStock.addRenglonMovStock();
			renglonMovStk.setComproCab(this);
			renglonMovStk.setDeposito(rtoDetMovStk.getDeposito());
			renglonMovStk.setUbicacionDeposito(rtoDetMovStk.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(rtoDetMovStk.getEstado_stock());
			renglonMovStk.setPartida(null);
			renglonMovStk.setSerie(null);
			renglonMovStk.setProducto(remitoDet.getProducto());
			renglonMovStk.setFecha(getEmision());
			renglonMovStk.setCantidad(remitoDet.getCant_desp());
			renglonMovStk.setSigno(rtoDetMovStk.getSigno());
			renglonMovStk.setUnidadMedida(remitoDet.getUnidad_desp());
			renglonMovStk.setAfectaStockFisico(rtoDetMovStk.isAfectaStkFisico());
			renglonMovStk.setActivo(new Boolean(true));
		}

	}

	private void armarMovStockSinPartNiSerieConMovCabecera(RenglonesStock renglonresStock, RemitoDet remitoDet)
			throws BaseException {
		if (detMovStockSugerido.isEmpty())
			throw new ExceptionValidation(null, "No se han ingresado los movimientos de Stock para el siguiente artículo "
					+ remitoDet.getProducto().getCodigo() + " - " + remitoDet.getProducto().getDescripcion());
		// Validar carga datos Principales
		Iterator iterMovStockSug = detMovStockSugerido.iterator();
		while (iterMovStockSug.hasNext()) {
			RemitoCabMovStock rtoCabMovStk = (RemitoCabMovStock) iterMovStockSug.next();
			RenglonMovStock renglonMovStk = renglonresStock.addRenglonMovStock();
			renglonMovStk.setComproCab(this);
			renglonMovStk.setDeposito(rtoCabMovStk.getDeposito());
			renglonMovStk.setUbicacionDeposito(rtoCabMovStk.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(rtoCabMovStk.getEstado_stock());
			renglonMovStk.setPartida(null);
			renglonMovStk.setSerie(null);
			renglonMovStk.setProducto(remitoDet.getProducto());
			renglonMovStk.setFecha(getEmision());
			renglonMovStk.setCantidad(remitoDet.getCant_desp());
			renglonMovStk.setSigno(rtoCabMovStk.getSigno());
			renglonMovStk.setUnidadMedida(remitoDet.getUnidad_desp());
			renglonMovStk.setAfectaStockFisico(rtoCabMovStk.isAfectaStkFisico());
			renglonMovStk.setActivo(new Boolean(true));
		}

	}

	private void armarMovStockPartidaSerie(RenglonesStock renglonresStock, RemitoDet remitoDet) throws BaseException {
		Iterator iterPartidasSeries = remitoDet.getDetallesPartidasSeries().iterator();
		while (iterPartidasSeries.hasNext()) {
			RemitoDetPartidaSerie rtoDetPartSerie = (RemitoDetPartidaSerie) iterPartidasSeries.next();
			if (remitoDet.getDetallesMovStock().isEmpty())
				armarMovStockPartSerConMovCabecera(renglonresStock, remitoDet, rtoDetPartSerie);
			else
				armarMovStockPartSerConMovDetalle(renglonresStock, remitoDet, rtoDetPartSerie);
		}
	}

	private void armarMovStockPartSerConMovDetalle(RenglonesStock renglonresStock, RemitoDet remitoDet,
			RemitoDetPartidaSerie rtoDetPartSer) throws BaseException {
		if (remitoDet.getDetallesMovStock().isEmpty())
			throw new ExceptionValidation(null, "No se ingresaron movimientos de Stock para el producto "
					+ remitoDet.getProducto().getCodigo() + " - " + remitoDet.getProducto().getDescripcion());
		Iterator iterMovStock = remitoDet.getDetallesMovStock().iterator();
		while (iterMovStock.hasNext()) {
			RemitoDetMovStock rtoDetMovStk = (RemitoDetMovStock) iterMovStock.next();
			RenglonMovStock renglonMovStk = renglonresStock.addRenglonMovStock();
			renglonMovStk.setComproCab(this);
			renglonMovStk.setDeposito(rtoDetMovStk.getDeposito());
			renglonMovStk.setUbicacionDeposito(rtoDetMovStk.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(rtoDetMovStk.getEstado_stock());
			renglonMovStk.setPartida(rtoDetPartSer.getPartida());
			renglonMovStk.setSerie(rtoDetPartSer.getSerie());
			renglonMovStk.setProducto(remitoDet.getProducto());
			renglonMovStk.setFecha(getEmision());
			renglonMovStk.setCantidad(rtoDetPartSer.getCantidad());
			renglonMovStk.setSigno(rtoDetMovStk.getSigno());
			renglonMovStk.setUnidadMedida(remitoDet.getUnidad_desp());
			renglonMovStk.setAfectaStockFisico(rtoDetMovStk.isAfectaStkFisico());
			renglonMovStk.setActivo(new Boolean(true));
		}

	}

	private void armarMovStockPartSerConMovCabecera(RenglonesStock renglonresStock, RemitoDet remitoDet,
			RemitoDetPartidaSerie rtoDetPartSer) throws BaseException {
		if (detMovStockSugerido.isEmpty())
			throw new ExceptionValidation(null, "No se han ingresado los movimientos de Stock para el siguiente artículo "
					+ remitoDet.getProducto().getCodigo() + " - " + remitoDet.getProducto().getDescripcion());
		// Validar carga datos Principales
		Iterator iterMovStockSug = detMovStockSugerido.iterator();
		while (iterMovStockSug.hasNext()) {
			RemitoCabMovStock rtoCabMovStk = (RemitoCabMovStock) iterMovStockSug.next();
			RenglonMovStock renglonMovStk = renglonresStock.addRenglonMovStock();
			renglonMovStk.setComproCab(this);
			renglonMovStk.setDeposito(rtoCabMovStk.getDeposito());
			renglonMovStk.setUbicacionDeposito(rtoCabMovStk.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(rtoCabMovStk.getEstado_stock());
			renglonMovStk.setPartida(rtoDetPartSer.getPartida());
			renglonMovStk.setSerie(rtoDetPartSer.getSerie());
			renglonMovStk.setProducto(remitoDet.getProducto());
			renglonMovStk.setFecha(getEmision());
			renglonMovStk.setCantidad(rtoDetPartSer.getCantidad());
			renglonMovStk.setSigno(rtoCabMovStk.getSigno());
			renglonMovStk.setUnidadMedida(remitoDet.getUnidad_desp());
			renglonMovStk.setAfectaStockFisico(rtoCabMovStk.isAfectaStkFisico());
			renglonMovStk.setActivo(new Boolean(true));
		}
	}

	public static List getRemitosByCondiciones(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBRemitoCab.getRemitosByCondiciones(condiciones, aSesion);
	}
	
	public void anular() throws BaseException {

		// Anular los Detalles
		Iterator iterDetalles = getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			RemitoDet remitoDet = (RemitoDet) iterDetalles.next();
			remitoDet.delete();
			remitoDet.save();
		}

		comprobanteAnulacion = (RemitoCabAnulacion) RemitoCabAnulacion.getNew(RemitoCabAnulacion.NICKNAME, getSesion());
		comprobanteAnulacion.setRemito_cab(this);
		comprobanteAnulacion.generarComproAnulacion();
		comprobanteAnulacion.save();
	}
	
	public RemitoCabAnulacion getComprobanteAnulacion() throws BaseException {
		return comprobanteAnulacion;
	}
	
	public List getPedidos() throws BaseException {
		HashTableDatos listaPedidos = new HashTableDatos();
		Iterator iterDetPedidos = this.getDetalles().iterator();
		while (iterDetPedidos.hasNext()) {
			RemitoDet remitoDet = (RemitoDet) iterDetPedidos.next();
			if ((remitoDet.getPedidoDet()!=null)) { 
					PedidoCab pedido
					  = (PedidoCab) listaPedidos.get(remitoDet.getPedidoDet().getPedido().getOIDInteger());
					if (pedido == null)
						listaPedidos.put(remitoDet.getPedidoDet().getPedido().getOIDInteger(),
														 remitoDet.getPedidoDet().getPedido());
				
			}
			
		}
		return new ArrayList(listaPedidos.values());
	}
	
	public PedidoCab getFirstPedido() throws BaseException {
		List listaPedidos = this.getPedidos();
		if (listaPedidos.size()==0)
			return null;
		return (PedidoCab)listaPedidos.get(0);
	}
	
	public void marcaRemitoComoNoPendFact() throws BaseException {
				DBRemitoCab.marcaRemitoComoNoPendFact(this,this.getSesion());
	}
	
  public boolean existeAlgunItemPendFact() throws BaseException {
		// Si el pedido se encuentra pedientes de despacho y todos los items se encuentran despachados
		// entonces cambiar el estado del pedido como despachado
	  	int cantItems = DBRemitoCab.getQueryCantItemsPendFact(this,getSesion());
	  	if (cantItems == 0)
	  		return false;
	  	else
	  		return true;
  }
  
  public List getDetallesPendFact() throws BaseException {
	  return RemitoDet.getDetallesPendFact(this,this.getSesion());
  }
  
  public List getDetallesPendRecep() throws BaseException {
	  return RemitoDet.getDetallesPendRecep(this,null,null,null,null,null,null,this.getSesion());
  }
  
  
  public PedidoCab getFirsPedido() throws BaseException {
  	Iterator iterPedidos = this.getPedidos().iterator();
  	while (iterPedidos.hasNext()) {
  		PedidoCab pedido = (PedidoCab) iterPedidos.next();
  		return pedido;
  	}
  	return null;
  }
  
  public Moneda getMonedaFacturacion() throws BaseException {
  	
  	// Si tiene pedido devolver la moneda de Facturación del mismo
  	PedidoCab pedido = this.getFirsPedido();
  	if (pedido!=null)
  		return pedido.getMonedaFact();
  	
    // Verificar si el cliente tiene configurada una moneda para facturacion por defecto
  	if (this.getSujeto()!=null)
  		if (this.getSujeto().getMonedaFactura()!=null)
  			return this.getSujeto().getMonedaFactura(); 
  			
  	// De lo contrario se asume se factura en moneda default
  	return Moneda.getMonedaCursoLegal(this.getSesion());
  			
  			
  }
  
  public ListaPrecios getLPAUsarParaFact(java.util.Date aFecha) throws BaseException {
  	PedidoCab pedido = this.getFirsPedido();
		if (pedido!=null)
			return pedido.getLista_precios();
		
			// Tomar la primera lista de Precios habilitada
		List listasDePrecios = this.getSujeto().getListasPreciosVigentesMasHab(aFecha);
		Iterator iterListaPrecios = listasDePrecios.iterator();
		while (iterListaPrecios.hasNext()) 
				return (ListaPrecios) iterListaPrecios.next();
		
		return ListaPrecios.getListaPreciosDefaultFactRtos(this.getSesion());
		
  }
  
  public CondicionPago getCondPagoAUsarParaFact() throws BaseException {
  	PedidoCab pedido = this.getFirsPedido();
		if (pedido!=null)
			return pedido.getCondicionPago();
		if (this.getSujeto()!=null)
			if (this.getSujeto().getCondicionPago()!=null)
				return this.getSujeto().getCondicionPago();		
		return CondicionPago.getCondicionPagoDefaultFactRto(this.getSesion());
  }
  
  public Moneda getMonedaAUsarParaFact() throws BaseException {
  	PedidoCab pedido = this.getFirsPedido();
		if (pedido!=null)
			return pedido.getMonedaFact(); 
		if (this.getSujeto()!=null)
			if (this.getSujeto().getMonedaFactura()!=null)
				return this.getSujeto().getMonedaFactura();
		return Moneda.getMonedaCursoLegal(this.getSesion());
  }
  
  public Vendedor getVendedorAUsarParaFact() throws BaseException {
  	PedidoCab pedido = this.getFirsPedido();
		if (pedido!=null)
			return pedido.getVendedor();
		if (this.getSujeto()!=null)
			if (this.getSujeto().getVendedor_comercial()!=null)
				return this.getSujeto().getVendedor_comercial();
		return Vendedor.getVendedorDefParaFacturarRto(this.getSesion());
  }
  
  public Provincia getProvinciaAUsarParaFact() throws BaseException {
  	if (this.getProvincia()!=null)
  		return this.getProvincia();
  	else {
  		PedidoCab pedido = this.getFirsPedido();
  		if (pedido.getDomicilio_entrega()!=null)
  			if (pedido.getDomicilio_entrega().getProvincia()!=null)
  				return pedido.getDomicilio_entrega().getProvincia();
  	} 
  	return Provincia.getProvinciaDefaultFactRtoParaPercIB(this.getSesion());
  }
  
  public boolean isTomarLasCotizDelPedidoAlFact() throws BaseException {
  	PedidoCab pedido = this.getFirsPedido();
  	if (pedido == null) return false;
  	if (pedido.isRespetarCotizPedidoAlFacturar())
  		return true;
  	else
  		return false;
  }
  
	public static String getCarpetaRTMRemitos(ISesion aSesion)
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"CARPETA_REPO_RTM_REMITOS", aSesion).getValorCadena();
	}
	
	public static RemitoCab buscarRemitoByCodigo(String codigo,boolean activa,ISesion sesion) throws BaseException {
		
		
		String formatoDesconocido = 
			"Formato de código de comprobante Remito desconocido. Ejemplos Válidos: RTO-A-1-123 ; A-123 ; 1-123; FAC-123 ; A-1-123";
		
		TipoComprobante tc 		= null;
		String letra		 	= null;
		LugarEmision lugEmi 	= null;
		Integer nroExt 			= null;
		
		RemitoCab remito = null;
		
		if (codigo == null) return null;
		
		String[] listaCodigos = codigo.split("-");
		
		if (listaCodigos.length==0) return null;
		
		if (listaCodigos.length==1) {
			// Se asume que solo se ingreso el Nro Entero
			try	 {	
				nroExt = Integer.parseInt(listaCodigos[0]);
			} catch(Exception e) {
				throw new ExceptionValidation(null,
						formatoDesconocido); 
			}
		} else if (listaCodigos.length==2) {
			try {
				// Obtener el Lugar de Emision por el primer elemento
				Integer nrolugEmi = Integer.parseInt(listaCodigos[0]);
				NumberFormat formatLugEmi = new DecimalFormat("0000");
				String lugarDeEmision = formatLugEmi.format(nrolugEmi);
				lugEmi = LugarEmision.findByCodigo(lugarDeEmision, sesion); 
				
				// Obtener el Nro Externo por el segundo elemento
				try {
					nroExt = Integer.parseInt(listaCodigos[1]);
				} catch(Exception e) {
					throw new ExceptionValidation(null,formatoDesconocido);
				}
				
				
				
			} catch (Exception e) {
				// No es un entero, Entonces o el tipo de comprobante o una letra
				
				if (listaCodigos[0].length()==1)
					letra = listaCodigos[0];
				else {
					tc = TipoComprobante.findByCodigo(listaCodigos[0], sesion);
					if (tc== null)
						throw new ExceptionValidation(null,"Tipo de comprobante inexistente:"+listaCodigos[0]);
				}
				
				try {
					nroExt = Integer.parseInt(listaCodigos[1]);
				} catch(Exception e1) {
					throw new ExceptionValidation(null,formatoDesconocido);
				}
				
			}
			
			
			
		} else if (listaCodigos.length==3) {
			// Se asume que la primer es letra
			// Segunda lugar de emision
			// Tercera nro externo
			letra = listaCodigos[0];
			
			try {
				Integer nrolugEmi = Integer.parseInt(listaCodigos[1]);
				NumberFormat formatLugEmi = new DecimalFormat("0000");
				String lugarDeEmision = formatLugEmi.format(nrolugEmi);
				lugEmi = LugarEmision.findByCodigo(lugarDeEmision, sesion);
			}
			catch(Exception e) {
				throw new ExceptionValidation(null,formatoDesconocido);
			}
			
			try {
				nroExt = Integer.parseInt(listaCodigos[2]);
			} catch(Exception e1) {
				throw new ExceptionValidation(null,formatoDesconocido);
			}
			
		} else if (listaCodigos.length==4) {

			try {
				String codTC = listaCodigos[0];
				tc = TipoComprobante.findByCodigo(codTC, sesion);
				if (tc == null)
					throw new ExceptionValidation(null,"Código de tipo de comprobante inexistente:"+codTC);
			}
			catch(Exception e) {
				throw new ExceptionValidation(null,formatoDesconocido);
			}
				
			letra = listaCodigos[1];
			
			try {
				Integer nrolugEmi = Integer.parseInt(listaCodigos[2]);
				NumberFormat formatLugEmi = new DecimalFormat("0000");
				String lugarDeEmision = formatLugEmi.format(nrolugEmi);
				lugEmi = LugarEmision.findByCodigo(lugarDeEmision, sesion);
			}
			catch(Exception e) {
				throw new ExceptionValidation(null,formatoDesconocido);
			}
			
			try {
				nroExt = Integer.parseInt(listaCodigos[3]);
			} catch(Exception e1) {
				throw new ExceptionValidation(null,formatoDesconocido);
			}
			
		} else if (listaCodigos.length>4) {
			throw new ExceptionValidation(null,formatoDesconocido);
		}
			
		return RemitoCab.buscarRemitoPor(tc, letra, lugEmi, nroExt, activa, sesion);
		
	}
	
	public static RemitoCab buscarRemitoPor(
			TipoComprobante tc,
			String letra,
			LugarEmision lugEmi,
			Integer nroExt,
			boolean activo,
			ISesion aSesion) throws BaseException {
		

		// Traer el tipo de comprobante default
		if (tc == null) 
			tc = RemitoCab.getTCPedidoDefBuscador(aSesion);
		
		if (letra == null)
			letra = RemitoCab.getLetraDefaultRemito(aSesion);
		
		if (lugEmi == null)
			lugEmi = RemitoCab.getLugarEmisionDefaultRemito(aSesion);
		
		if (nroExt == null)
			throw new ExceptionValidation(null,"Debe ingresar el Nro. del comprobante");
		
		return RemitoCab.getRemitoCab(tc, letra, lugEmi , nroExt, activo, aSesion);
		
	}
	
	public static TipoComprobante getTCPedidoDefBuscador(ISesion aSesion) throws BaseException {
		return TipoComprobante.getTCRemitoDefBuscador(aSesion);
	}
	
	
	public static String getLetraDefaultRemito(ISesion aSesion)
		throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"LETRA_COMPRO_DEF_RTO", aSesion).getValorCadena();
	}
	
	public static LugarEmision getLugarEmisionDefaultRemito(ISesion aSesion) throws BaseException {
		return LugarEmision.getLugarEmisionDefaultRemito(aSesion);
	}
	
	public static RemitoCab getRemitoCab(
			TipoComprobante tc,
			String letra,
			LugarEmision le,
			Integer nroExt,
			boolean activo,
	        ISesion aSesion)
	        throws BaseException {
		
		  return DBRemitoCab.getRemitoCab(tc,letra,le,nroExt,activo,aSesion);
	}
	
	
	
	
  
  
}
