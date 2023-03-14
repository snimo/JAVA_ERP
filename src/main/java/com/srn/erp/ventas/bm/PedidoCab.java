package com.srn.erp.ventas.bm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.Transporte;
import com.srn.erp.ventas.da.DBPedidoCab;
import com.srn.erp.ventas.da.DBPedidoDet;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class PedidoCab extends ComproCab {

	public PedidoCab() {
	}

	public static String NICKNAME = "ve.PedidoCab";

	public static String MERCADO_INTERNO = "I";
	public static String MERCADO_EXTERNO = "E";

	// Comportamiento como tomar las cotizaciones al momento de facturar
	public static String RCDP = "RCDP"; // Respectar Cotizacion del Pedido
	public static String UCDF = "UCFF"; // Usar la cotizacion de la fecha de
	// facturacion

	private PedidoCabAnulacion comprobanteAnulacion;

	private ComproCab comprobante;
	private ContactoSujeto contactoSujeto;
	private Sujeto sujeto;
	private Moneda moneda;
	private ValorCotizacion cotizacion;
	private ValorCotizacion cotizMonFact;
	private String mercado;
	private Double porc_bonif_cli;
	private Double porc_reca_cli;
	private Boolean bonif_cli_cascada;
	private Boolean reca_cli_cascada;
	private ListaPrecios lista_precios;
	private CondicionPago condicionPago;
	private Vendedor vendedor;
	private UnidadEdilicia domicilio_entrega;
	private Double porc_bonif_cp;
	private Double porc_reca_cp;
	private Boolean bonif_cp_cascada;
	private Boolean reca_cp_cascada;
	private Boolean observado;
	private String comentario;
	private Boolean pendEnt;
	private Boolean pendFact;
	private Transporte transporte;
	private Moneda monedaFact;
	private Boolean pendDesp;
	private FormaEntrega formaEntrega;
	private String ordenDeCompra;
	private Money bruto;
	private Porcentaje porc_dto;
	private Money descuento;
	private Porcentaje porc_recar;
	private Money recargo;
	private Money neto;
	private Money iva;
	private Money iva2;
	private Money perc_iva;
	private Money imp_internos;
	private Money perc_ib;
	private Money total;
	private Money impre_bruto;
	private Money impre_porc_bonif;
	private Money impre_porc_recar;
	private Money impre_bonif;
	private Money impre_recar;
	private Money impre_neto;
	private Money impre_iva;
	private Money impre_iva2;
	private Money impre_perc_iva;
	private Money impre_perc_ib;
	private Money impre_imp_int;
	private Money impre_total;
	private Money brutoMonLoc;
	private Porcentaje porcDtoMonLoc;
	private Money dtoMonLoc;
	private Porcentaje porcRecarMonloc;
	private Money recargoMonLoc;
	private Money netoMonedaLoc;
	private Money ivaMonLoc;
	private Money ivaMonLoc2;
	private Money percIVAMonLoc;
	private Money impuInternosMonLoc;
	private Money percIBMonLoc;
	private Money totalMonLoc;
	private ConceptoImpuesto concIVA2;
	private ConceptoImpuesto concIVA;
	private ConceptoImpuesto concPercIVA;
	private ConceptoImpuesto concPercIB;
	private ConceptoImpuesto concImpInt;
	private Money netoGravado;
	private Money netoNoGravado;
	private Money netoGravadoMonLoc;
	private Money netoNoGravadoMonLoc;
	private String comporCotizFact;
	private Proyecto proyecto;
	private Boolean puedeAnularSinControl;

	private List detalles = new ArrayList();
	private boolean readDetalle = true;
	
	private List obsCodificadas = new ArrayList();
	private boolean readObsCodificadas = true;
	

	public void setMonedaFact(Moneda aMonedaFact) throws BaseException {
		this.monedaFact = aMonedaFact;
	}

	public Moneda getMonedaFact() throws BaseException {
		supportRefresh();
		return monedaFact;
	}
	
	public void setPuedeAnularSinControl(Boolean aPuedeAnularSinControl) throws BaseException {
		this.puedeAnularSinControl = aPuedeAnularSinControl;
	}

	public Boolean isPuedeAnularSinControl() throws BaseException {
		supportRefresh();
		return this.puedeAnularSinControl;
	}
	

	public void setComporCotizFact(String aComporCotizFact)
			throws BaseException {
		this.comporCotizFact = aComporCotizFact;
	}

	public Proyecto getProyecto() throws BaseException {
		supportRefresh();
		return proyecto;
	}

	public void setProyecto(Proyecto aProyecto) throws BaseException {
		this.proyecto = aProyecto;
	}

	public String getComporCotizFact() throws BaseException {
		supportRefresh();
		return this.comporCotizFact;
	}

	public void setOrdenDeCompra(String aOrdenDeCompra) throws BaseException {
		this.ordenDeCompra = aOrdenDeCompra;
	}

	public String getOrdenDeCompra() throws BaseException {
		supportRefresh();
		return this.ordenDeCompra;
	}

	public void setContactoSujeto(ContactoSujeto aContactoSujeto)
			throws BaseException {
		this.contactoSujeto = aContactoSujeto;
	}

	public ContactoSujeto getContactoSujeto() throws BaseException {
		supportRefresh();
		return this.contactoSujeto;
	}

	public void setFormaEntrega(FormaEntrega aFormaEntrega)
			throws BaseException {
		this.formaEntrega = aFormaEntrega;
	}

	public FormaEntrega getFormaEntrega() throws BaseException {
		supportRefresh();
		return formaEntrega;
	}

	public void setPendDesp(Boolean aPendDesp) throws BaseException {
		this.pendDesp = aPendDesp;
	}

	public Boolean isPendDesp() throws BaseException {
		supportRefresh();
		return this.pendDesp;
	}

	public void setTransporte(Transporte aTransporte) throws BaseException {
		this.transporte = aTransporte;
	}

	public Transporte getTransporte() throws BaseException {
		supportRefresh();
		return transporte;
	}

	public Boolean isPendEnt() throws BaseException {
		supportRefresh();
		return pendEnt;
	}

	public void setPendEnt(Boolean aPendEnt) throws BaseException {
		this.pendEnt = aPendEnt;
	}

	public Boolean isPendFact() throws BaseException {
		supportRefresh();
		return pendFact;
	}

	public void setPendFact(Boolean aPendFact) throws BaseException {
		this.pendFact = aPendFact;
	}

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) {
		this.sujeto = aSujeto;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public ValorCotizacion getCotizMonFact() throws BaseException {
		supportRefresh();
		return this.cotizMonFact;
	}

	public void setCotizacion(ValorCotizacion aCotizacion) {
		this.cotizacion = aCotizacion;
	}

	public void setCotizMonFact(ValorCotizacion aCotizacion) {
		this.cotizMonFact = aCotizacion;
	}

	public String getMercado() throws BaseException {
		supportRefresh();
		return mercado;
	}

	public void setMercado(String aMercado) {
		this.mercado = aMercado;
	}

	public Double getPorc_bonif_cli() throws BaseException {
		supportRefresh();
		return porc_bonif_cli;
	}

	public void setPorc_bonif_cli(Double aPorc_bonif_cli) {
		this.porc_bonif_cli = aPorc_bonif_cli;
	}

	public Double getPorc_reca_cli() throws BaseException {
		supportRefresh();
		return porc_reca_cli;
	}

	public void setPorc_reca_cli(Double aPorc_reca_cli) {
		this.porc_reca_cli = aPorc_reca_cli;
	}

	public Boolean isBonif_cli_cascada() throws BaseException {
		supportRefresh();
		return bonif_cli_cascada;
	}

	public void setBonif_cli_cascada(Boolean aBonif_cli_cascada) {
		this.bonif_cli_cascada = aBonif_cli_cascada;
	}

	public Boolean isReca_cli_cascada() throws BaseException {
		supportRefresh();
		return reca_cli_cascada;
	}

	public void setReca_cli_cascada(Boolean aReca_cli_cascada) {
		this.reca_cli_cascada = aReca_cli_cascada;
	}

	public ListaPrecios getLista_precios() throws BaseException {
		supportRefresh();
		return lista_precios;
	}

	public void setLista_precios(ListaPrecios aLista_precios) {
		this.lista_precios = aLista_precios;
	}

	public CondicionPago getCondicionPago() throws BaseException {
		supportRefresh();
		return this.condicionPago;
	}

	public void setCondicionPago(CondicionPago aCondicionPago) {
		this.condicionPago = aCondicionPago;
	}

	public Vendedor getVendedor() throws BaseException {
		supportRefresh();
		return vendedor;
	}

	public void setVendedor(Vendedor aVendedor) {
		this.vendedor = aVendedor;
	}

	public UnidadEdilicia getDomicilio_entrega() throws BaseException {
		supportRefresh();
		return domicilio_entrega;
	}

	public void setDomicilio_entrega(UnidadEdilicia aDomicilio_entrega) {
		this.domicilio_entrega = aDomicilio_entrega;
	}

	public Double getPorc_bonif_cp() throws BaseException {
		supportRefresh();
		return porc_bonif_cp;
	}

	public void setPorc_bonif_cp(Double aPorc_bonif_cp) {
		this.porc_bonif_cp = aPorc_bonif_cp;
	}

	public Double getPorc_reca_cp() throws BaseException {
		supportRefresh();
		return porc_reca_cp;
	}

	public void setPorc_reca_cp(Double aPorc_reca_cp) {
		this.porc_reca_cp = aPorc_reca_cp;
	}

	public Boolean isBonif_cp_cascada() throws BaseException {
		supportRefresh();
		return bonif_cp_cascada;
	}

	public void setBonif_cp_cascada(Boolean aBonif_cp_cascada) {
		this.bonif_cp_cascada = aBonif_cp_cascada;
	}

	public Boolean isReca_cp_cascada() throws BaseException {
		supportRefresh();
		return reca_cp_cascada;
	}

	public void setReca_cp_cascada(Boolean aReca_cp_cascada) {
		this.reca_cp_cascada = aReca_cp_cascada;
	}

	public Boolean isObservado() throws BaseException {
		supportRefresh();
		return observado;
	}

	public void setObservado(Boolean aObservado) {
		this.observado = aObservado;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PedidoCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (PedidoCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PedidoCab findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (PedidoCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
			this.setPuedeAnularSinControl(false);
		}

		beforeSaveComprobante(this);

		validarDatos();

	}

	private void validarDatos() throws BaseException {

		Validar.noNulo(this.sujeto, "Debe ingresar el cliente");
		Validar.noNulo(this.lista_precios, "Debe ingresr la lista de precios");
		Validar
				.noNulo(this.condicionPago,
						"Debe ingresar la Condición de Pago");

		Validar.noNulo(this.vendedor, "Debe ingresar el Vendedor");
		Validar.noNulo(this.moneda, "Debe ingresar la Moneda del Pedido");
		Validar.noNulo(this.monedaFact,
				"Debe ingresar la moneda de Facturación");
		Validar.noNulo(this.getEmision(), "Debe ingresar la Fecha de Emisión");
		Validar.noNulo(this.getTalonario(), "Debe ingresar el Talonario");
		Validar.noNulo(this.getCotizacion(), "Debe ingresar la cotización");
		Validar.noNulo(this.getCotizMonFact(),
				"Debe ingresar la cotización de la Moneda de Facturación");
		Validar.noNulo(this.getComporCotizFact(),
				"Debe indicar que tipo de Cotización usar al Facturar");

		if (moneda.isMonedaCursoLegal()
				&& (this.getCotizacion().doubleValue() != 1))
			throw new ExceptionValidation(null, "La cotización de la moneda "
					+ moneda.getDescripcion() + " debe ser igual a 1");

		if (monedaFact.isMonedaCursoLegal()
				&& (this.getCotizMonFact().doubleValue() != 1))
			throw new ExceptionValidation(null, "La cotización de la moneda "
					+ monedaFact.getDescripcion() + " debe ser igual a 1");

		if (moneda.isMonedaCursoLegal()
				&& (this.getCotizacion().doubleValue() <= 0))
			throw new ExceptionValidation(null, "La cotización de la moneda "
					+ moneda.getDescripcion() + " debe ser mayor a cero");

		if (monedaFact.isMonedaCursoLegal()
				&& (this.getCotizMonFact().doubleValue() != 1))
			throw new ExceptionValidation(null, "La cotización de la moneda "
					+ monedaFact.getDescripcion() + " debe ser igual a 1");

		if (monedaFact.isMonedaCursoLegal()
				&& (this.getCotizMonFact().doubleValue() <= 0))
			throw new ExceptionValidation(null, "La cotización de la moneda "
					+ monedaFact.getDescripcion() + " debe ser mayor a cero");

		if (this.getTotal().doubleValue() < 0)
			throw new ExceptionValidation(null,
					"El total del comprobante no puede ser negativo");

	}

	public void afterSave() throws BaseException {
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			PedidoDet pedidoDet = (PedidoDet) iterDetalles.next();
			pedidoDet.save();
			pedidoDet = null;
		}
		iterDetalles = null;
		
		Iterator iterObsCodificas = obsCodificadas.iterator();
		while (iterObsCodificas.hasNext()) {
			ObsCodifPedidoCab obsCodif = (ObsCodifPedidoCab) iterObsCodificas.next();
			obsCodif.save();
			obsCodif = null;
		}
		iterObsCodificas = null;
		

		afterSaveComprobante(this);
	}

	public void afterSaveModified() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveModified();

		// Verificar si se cambia la version de impresion
		this.getComprobanteImpreso().siEstaCongeladoGenerarNuevaVersion();

	}

	public void addDetalle(PedidoDet pedidoDet) throws BaseException {
		this.detalles.add(pedidoDet);
		pedidoDet.setPedido(this);
	}
	
	public void addObsCodificada(ObsCodifPedidoCab aObsCodif) throws BaseException {
		this.obsCodificadas.add(aObsCodif);
		aObsCodif.setPedido(this);
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

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public PedidoDet addDetalle() throws BaseException {
		PedidoDet pedidoDet = (PedidoDet) PedidoDet.getNew(PedidoDet.NICKNAME,
				getSesion());
		pedidoDet.setPedido(this);
		detalles.add(pedidoDet);
		return pedidoDet;
	}

	public List getDetalles() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(PedidoDet.getDetallesByPedido(this, getSesion()));
			readDetalle = false;
			return detalles;
		} else
			return detalles;
	}
	
	public List getDetallesActivos() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(PedidoDet.getDetallesByPedidoActivos(this, getSesion()));
			readDetalle = false;
			return detalles;
		} else
			return detalles;
	}
	
	
	public List getObservacionesCodif() throws BaseException {
		if (readObsCodificadas == true) {
			obsCodificadas.addAll(ObsCodifPedidoCab.getObsCodificasPedido(this, getSesion()));
			readObsCodificadas = false;
			return obsCodificadas;
		} else
			return obsCodificadas;
	}
	

	public static List getPedidos(Integer nroExtDesde, Integer nroExtHasta,
			java.util.Date fecDesde, java.util.Date fecHasta, Sujeto sujeto,
			Producto producto, Vendedor vendedor,ISesion aSesion) throws BaseException {
		return DBPedidoCab.getPedidos(nroExtDesde, nroExtHasta, fecDesde,
				fecHasta, sujeto, producto, vendedor,aSesion);
	}

	public void onNew() throws BaseException {
		setPendEnt(new Boolean(true));
		setPendDesp(new Boolean(true));
		setPendFact(new Boolean(true));
	}

	public static List getPedidosPendEnt(Integer nroDesde, Integer nroHasta,
			Sujeto sujeto, Vendedor vendedor, java.util.Date fecEntHasta,
			ISesion aSesion) throws BaseException {
		return DBPedidoCab.getPedidosPendEnt(nroDesde, nroHasta, sujeto,
				vendedor, fecEntHasta, aSesion);
	}

	public static List getPedidosPendDesp(Integer nroDesde, Integer nroHasta,
			Sujeto sujeto, Vendedor vendedor, java.util.Date fecEntHasta,
			Producto producto, ISesion aSesion) throws BaseException {
		return DBPedidoCab.getPedidosByCondiciones(nroDesde, nroHasta, sujeto,
				vendedor, fecEntHasta, producto, "PEND_DESP", aSesion);
	}

	public static List getPedidosByCondiciones(Integer nroDesde,
			Integer nroHasta, Sujeto sujeto, Vendedor vendedor,
			java.util.Date fecEntHasta, Producto producto, String tipo,
			ISesion aSesion) throws BaseException {
		return DBPedidoCab.getPedidosByCondiciones(nroDesde, nroHasta, sujeto,
				vendedor, fecEntHasta, producto, tipo, aSesion);
	}

	public static List getPedidos(Integer nroDesde, Integer nroHasta,
			Sujeto sujeto, Vendedor vendedor, java.util.Date fecEntHasta,
			Producto producto, ISesion aSesion) throws BaseException {
		return DBPedidoCab.getPedidos(nroDesde, nroHasta, sujeto, vendedor,
				fecEntHasta, producto, aSesion);
	}

	public List getDetallesPendEnt() throws BaseException {
		return PedidoDet.getDetallesPendDesp(this, getSesion());
	}

	public static PedidoCab getPedidoBy_TC_Letra_LE_NroExt(
			TipoComprobante tipoComprobante, String letra, Integer nroLugEmi,
			Integer nroExt, ISesion aSesion) throws BaseException {
		return DBPedidoCab.getPedidoTC_Letra_LE_NroExt(tipoComprobante, letra,
				nroLugEmi, nroExt, aSesion);
	}

	public static boolean isOcultaBonif1EnPedido(ISesion aSesion)
			throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"OCULTAR_BONIF_1_ING_PEDIDO", aSesion).getBoolean();
	}

	public static boolean isOcultaBonif2EnPedido(ISesion aSesion)
			throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"OCULTAR_BONIF_2_ING_PEDIDO", aSesion).getBoolean();
	}

	public static boolean isOcultaBonif3EnPedido(ISesion aSesion)
			throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"OCULTAR_BONIF_3_ING_PEDIDO", aSesion).getBoolean();
	}

	public boolean existeAlgunItemPendDesp() throws BaseException {
		// Si el pedido se encuentra pedientes de despacho y todos los items se
		// encuentran despachados
		// entonces cambiar el estado del pedido como despachado
		int cantItems = DBPedidoCab
				.getQueryCantItemsPendDesp(this, getSesion());
		if (cantItems == 0)
			return false;
		else
			return true;
	}

	public boolean existeAlgunItemPendFact() throws BaseException {
		// Si el pedido se encuentra pedientes de facturar y todos los items se
		// encuentran facturados
		// entonces cambiar el estado del pedido como facturado
		int cantItems = DBPedidoCab
				.getQueryCantItemsPendFact(this, getSesion());
		if (cantItems == 0)
			return false;
		else
			return true;
	}

	public void setBrutoMonLoc(Money aBrutoMonLoc) throws BaseException {
		this.brutoMonLoc = aBrutoMonLoc;
	}

	public Money getBrutoMonLoc() throws BaseException {
		this.supportRefresh();
		return this.brutoMonLoc;
	}

	public void setImprePorcBonif(Money aImprePorcBonif) throws BaseException {
		this.impre_porc_bonif = aImprePorcBonif;
	}

	public Money getImprePorcBonif() throws BaseException {
		this.supportRefresh();
		return this.impre_porc_bonif;
	}

	public void setImprePorcRecar(Money aImprePorcRecar) throws BaseException {
		this.impre_porc_recar = aImprePorcRecar;
	}

	public Money getImprePorcRecar() throws BaseException {
		this.supportRefresh();
		return this.impre_porc_recar;
	}

	public void setPorcDtoMonLoc(Porcentaje aPorcDtoMonLoc)
			throws BaseException {
		this.porcDtoMonLoc = aPorcDtoMonLoc;
	}

	public Porcentaje getPorcDtoMonLoc() throws BaseException {
		this.supportRefresh();
		return this.porcDtoMonLoc;
	}

	public void setDtoMonLoc(Money aDtoMonLoc) throws BaseException {
		this.dtoMonLoc = aDtoMonLoc;
	}

	public Money getDtoMonLoc() throws BaseException {
		this.supportRefresh();
		return this.dtoMonLoc;
	}

	public void setPorcRecarMonLoc(Porcentaje aPorcRecarMonLoc)
			throws BaseException {
		this.porcRecarMonloc = aPorcRecarMonLoc;
	}

	public Porcentaje getPorcRecarMonLoc() throws BaseException {
		this.supportRefresh();
		return this.porcRecarMonloc;
	}

	public void setRecargoMonLoc(Money aRecargoMonLoc) throws BaseException {
		this.recargoMonLoc = aRecargoMonLoc;
	}

	public Money getRecargoMonLoc() throws BaseException {
		this.supportRefresh();
		return this.recargoMonLoc;
	}

	public void setNetoMonedaLocal(Money aNetoMonedaLocal) throws BaseException {
		this.netoMonedaLoc = aNetoMonedaLocal;
	}

	public Money getNetoMonedaLocal() throws BaseException {
		this.supportRefresh();
		return this.netoMonedaLoc;
	}

	public void setIvaMonLoc(Money aIVAMonLoc) throws BaseException {
		this.ivaMonLoc = aIVAMonLoc;
	}

	public Money getIVAMonLoc() throws BaseException {
		this.supportRefresh();
		return this.ivaMonLoc;
	}

	public void setIvaMonLoc2(Money aIVAMonLoc2) throws BaseException {
		this.ivaMonLoc2 = aIVAMonLoc2;
	}

	public Money getIVAMonLoc2() throws BaseException {
		this.supportRefresh();
		return this.ivaMonLoc2;
	}

	public void setPercIVAMonLoc(Money aPercIVAMonLoc) throws BaseException {
		this.percIVAMonLoc = aPercIVAMonLoc;
	}

	public Money getPercIVAMonLoc() throws BaseException {
		this.supportRefresh();
		return this.percIVAMonLoc;
	}

	public void setImpuInternosMonLoc(Money aImpuIntMonLoc)
			throws BaseException {
		this.impuInternosMonLoc = aImpuIntMonLoc;
	}

	public Money getImpuIntMonLoc() throws BaseException {
		this.supportRefresh();
		return this.impuInternosMonLoc;
	}

	public void setPercIBMonLoc(Money aPercIBMonLoc) throws BaseException {
		this.percIBMonLoc = aPercIBMonLoc;
	}

	public Money getPercIBMonLoc() throws BaseException {
		this.supportRefresh();
		return this.percIBMonLoc;
	}

	public void setTotalMonLoc(Money aTotMonLoc) throws BaseException {
		this.totalMonLoc = aTotMonLoc;
	}

	public Money getTotMonLoc() throws BaseException {
		this.supportRefresh();
		return this.totalMonLoc;
	}

	public void setConcImpIVA(ConceptoImpuesto aConcImpIVA)
			throws BaseException {
		this.concIVA = aConcImpIVA;
	}

	public ConceptoImpuesto getConcImpuIVA() throws BaseException {
		this.supportRefresh();
		return this.concIVA;
	}

	public void setConcImpIVA2(ConceptoImpuesto aConcImpIVA2)
			throws BaseException {
		this.concIVA2 = aConcImpIVA2;
	}

	public ConceptoImpuesto getConcImpuIVA2() throws BaseException {
		this.supportRefresh();
		return this.concIVA2;
	}

	public void setConcImpPercIVA(ConceptoImpuesto aConcImpPercIVA)
			throws BaseException {
		this.concPercIVA = aConcImpPercIVA;
	}

	public ConceptoImpuesto getConcImpuPercIVA() throws BaseException {
		this.supportRefresh();
		return this.concPercIVA;
	}

	public void setConcImpPercIB(ConceptoImpuesto aConcImpPercIB)
			throws BaseException {
		this.concPercIB = aConcImpPercIB;
	}

	public ConceptoImpuesto getConcImpuPercIB() throws BaseException {
		this.supportRefresh();
		return this.concPercIB;
	}

	public void setConcImpInt(ConceptoImpuesto aConcImpInt)
			throws BaseException {
		this.concImpInt = aConcImpInt;
	}

	public ConceptoImpuesto getConcImpInt() throws BaseException {
		this.supportRefresh();
		return this.concImpInt;
	}

	public Money getImpre_bonif() throws BaseException {
		supportRefresh();
		return impre_bonif;
	}

	public void setImpre_bonif(Money aImpre_bonif) {
		this.impre_bonif = aImpre_bonif;
	}

	public Money getImpre_recar() throws BaseException {
		supportRefresh();
		return impre_recar;
	}

	public void setImpre_recar(Money aImpre_recar) {
		this.impre_recar = aImpre_recar;
	}

	public Money getImpre_neto() throws BaseException {
		supportRefresh();
		return impre_neto;
	}

	public void setImpre_neto(Money aImpre_neto) {
		this.impre_neto = aImpre_neto;
	}

	public Money getImpre_iva() throws BaseException {
		supportRefresh();
		return impre_iva;
	}

	public void setImpre_iva(Money aImpre_iva) {
		this.impre_iva = aImpre_iva;
	}

	public Money getImpre_iva2() throws BaseException {
		supportRefresh();
		return impre_iva2;
	}

	public void setImpre_iva2(Money aImpre_iva2) {
		this.impre_iva2 = aImpre_iva2;
	}

	public Money getImpre_perc_iva() throws BaseException {
		supportRefresh();
		return impre_perc_iva;
	}

	public void setImpre_perc_iva(Money aImpre_perc_iva) {
		this.impre_perc_iva = aImpre_perc_iva;
	}

	public Money getImpre_perc_ib() throws BaseException {
		supportRefresh();
		return impre_perc_ib;
	}

	public void setImpre_perc_ib(Money aImpre_perc_ib) {
		this.impre_perc_ib = aImpre_perc_ib;
	}

	public Money getImpre_imp_int() throws BaseException {
		supportRefresh();
		return impre_imp_int;
	}

	public void setImpre_imp_int(Money aImpre_imp_int) {
		this.impre_imp_int = aImpre_imp_int;
	}

	public Money getImpre_total() throws BaseException {
		supportRefresh();
		return impre_total;
	}

	public void setImpre_total(Money aImpre_total) {
		this.impre_total = aImpre_total;
	}

	public Money getBruto() throws BaseException {
		supportRefresh();
		return bruto;
	}

	public void setBruto(Money aBruto) {
		this.bruto = aBruto;
	}

	public Porcentaje getPorc_dto() throws BaseException {
		supportRefresh();
		return porc_dto;
	}

	public void setPorc_dto(Porcentaje aPorc_dto) {
		this.porc_dto = aPorc_dto;
	}

	public Money getDescuento() throws BaseException {
		supportRefresh();
		return descuento;
	}

	public void setDescuento(Money aDescuento) {
		this.descuento = aDescuento;
	}

	public Porcentaje getPorc_recar() throws BaseException {
		supportRefresh();
		return porc_recar;
	}

	public void setPorc_recar(Porcentaje aPorc_recar) {
		this.porc_recar = aPorc_recar;
	}

	public Money getRecargo() throws BaseException {
		supportRefresh();
		return recargo;
	}

	public void setRecargo(Money aRecargo) {
		this.recargo = aRecargo;
	}

	public Money getNeto() throws BaseException {
		supportRefresh();
		return neto;
	}

	public void setNeto(Money aNeto) {
		this.neto = aNeto;
	}

	public Money getIva() throws BaseException {
		supportRefresh();
		return iva;
	}

	public void setIva(Money aIva) {
		this.iva = aIva;
	}

	public Money getIva2() throws BaseException {
		supportRefresh();
		return iva2;
	}

	public void setIva2(Money aIva2) {
		this.iva2 = aIva2;
	}

	public Money getPerc_iva() throws BaseException {
		supportRefresh();
		return perc_iva;
	}

	public void setPerc_iva(Money aPerc_iva) {
		this.perc_iva = aPerc_iva;
	}

	public Money getImp_internos() throws BaseException {
		supportRefresh();
		return imp_internos;
	}

	public void setImp_internos(Money aImp_internos) {
		this.imp_internos = aImp_internos;
	}

	public Money getPerc_ib() throws BaseException {
		supportRefresh();
		return perc_ib;
	}

	public void setPerc_ib(Money aPerc_ib) {
		this.perc_ib = aPerc_ib;
	}

	public Money getTotal() throws BaseException {
		supportRefresh();
		return total;
	}

	public void setTotal(Money aTotal) {
		this.total = aTotal;
	}

	public Money getImpre_bruto() throws BaseException {
		supportRefresh();
		return impre_bruto;
	}

	public void setImpre_bruto(Money aImpre_bruto) {
		this.impre_bruto = aImpre_bruto;
	}

	public void setNetoGravado(Money aNetoGravado) throws BaseException {
		this.netoGravado = aNetoGravado;
	}

	public Money getNetoGravado() throws BaseException {
		this.supportRefresh();
		return this.netoGravado;
	}

	public void setNetoGravadoMonLoc(Money aNetoGravadoMonLoc)
			throws BaseException {
		this.netoGravadoMonLoc = aNetoGravadoMonLoc;
	}

	public Money getNetoGravadoMonLoc() throws BaseException {
		this.supportRefresh();
		return this.netoGravadoMonLoc;
	}

	public void setNetoNoGravadoMonLoc(Money aNetoNoGravadoMonLoc)
			throws BaseException {
		this.netoNoGravadoMonLoc = aNetoNoGravadoMonLoc;
	}

	public Money getNetoNoGravadoMonLoc() throws BaseException {
		this.supportRefresh();
		return this.netoNoGravadoMonLoc;
	}

	public void setNetoNoGravado(Money aNetoNoGravado) throws BaseException {
		this.netoNoGravado = aNetoNoGravado;
	}

	public Money getNetoNoGravado() throws BaseException {
		this.supportRefresh();
		return this.netoNoGravado;
	}

	public List getDetallesPendientesDeFacturar() throws BaseException {
		return PedidoDet.getDetallesPendFact(this, getSesion());
	}

	public void anular() throws BaseException {

		// Anular los Detalles
		Iterator iterDetalles = getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			PedidoDet pedidoDet = (PedidoDet) iterDetalles.next();
			if (pedidoDet.isAnulado()) continue;
			pedidoDet.delete();
			pedidoDet.save();
		}

		comprobanteAnulacion = (PedidoCabAnulacion) PedidoCabAnulacion.getNew(
				PedidoCabAnulacion.NICKNAME, getSesion());
		comprobanteAnulacion.setPedido_cab(this);
		comprobanteAnulacion.generarComproAnulacion();
		comprobanteAnulacion.save();

	}

	public void marcarPedidoComoNoPendDespacho() throws BaseException {
		DBPedidoCab.marcarPedidoComoNoPendDesp(this, this.getSesion());
	}

	public void marcarPedidoComoNoPendFacturacion() throws BaseException {
		DBPedidoCab.marcarPedidoComoNoPendFact(this, this.getSesion());
	}

	public boolean isRespetarCotizPedidoAlFacturar() throws BaseException {
		if (this.getComporCotizFact().equals(PedidoCab.RCDP))
			return true;
		else
			return false;
	}

	public boolean isUsarCotizDelDiaAlFacturar() throws BaseException {
		if (this.getComporCotizFact().equals(PedidoCab.UCDF))
			return true;
		else
			return false;
	}

	public static HashTableDatos getComportamientosCotizFact()
			throws BaseException {
		HashTableDatos comportamientos = new HashTableDatos();
		comportamientos.put(RCDP, "Fact. Cotiz. Pedido");
		comportamientos.put(UCDF, "Fact. Cotiz. Fecha Factura");
		return comportamientos;
	}

	public ValorCotizacion getCotizMonPedidoParaFact(
			HashTableDatos listaCotizActuales) throws BaseException {
		ValorCotizacion cotizOrigen = this.getCotizacion();
		if (this.isUsarCotizDelDiaAlFacturar()) {
			ValorCotizacion valorCotizacion = (ValorCotizacion) listaCotizActuales
					.get(this.getMoneda().getOIDInteger());
			if (valorCotizacion == null)
				throw new ExceptionValidation(null,
						"No se pudo encontrar cotización para la moneda "
								+ moneda.getDescripcion());
			cotizOrigen = valorCotizacion;
		} else if (this.isRespetarCotizPedidoAlFacturar())
			cotizOrigen = this.getCotizacion();
		return cotizOrigen;
	}

	public ValorCotizacion getCotizMonParaFact(HashTableDatos listaCotizActuales)
			throws BaseException {
		ValorCotizacion cotizOrigen = this.getCotizacion();
		if (this.isUsarCotizDelDiaAlFacturar()) {
			ValorCotizacion valorCotizacion = (ValorCotizacion) listaCotizActuales
					.get(this.getMonedaFact().getOIDInteger());
			if (valorCotizacion == null)
				throw new ExceptionValidation(null,
						"No se pudo encontrar cotización para la moneda "
								+ this.getMonedaFact().getDescripcion());
			cotizOrigen = valorCotizacion;
		} else if (this.isRespetarCotizPedidoAlFacturar())
			cotizOrigen = this.getCotizMonFact();
		return cotizOrigen;
	}

	public PedidoDet getPedidoDet(Integer nroRenglon) throws BaseException {
		return DBPedidoDet.getPedidoDet(this, nroRenglon, this.getSesion());
	}

	public static String getCarpetaRTMPedidos(ISesion aSesion)
			throws BaseException {
		return ValorParametro.findByCodigoParametro("CARPETA_REPO_RTM_PEDIDOS",
				aSesion).getValorCadena();
	}

	public static PedidoCab getPedidoCab(TipoComprobante tc, String letra,
			LugarEmision le, Integer nroExt, boolean activo, ISesion aSesion)
			throws BaseException {

		return DBPedidoCab.getPedidoCab(tc, letra, le, nroExt, activo, aSesion);
	}

	public static PedidoCab buscarPedidoByCodigo(String codigo, boolean activa,
			ISesion sesion) throws BaseException {

		String formatoDesconocido = "Formato de código de comprobante Pedido desconocido. Ejemplos Válidos: RTO-A-1-123 ; A-123 ; 1-123; FAC-123 ; A-1-123";

		TipoComprobante tc = null;
		String letra = null;
		LugarEmision lugEmi = null;
		Integer nroExt = null;

		RemitoCab remito = null;

		if (codigo == null)
			return null;

		String[] listaCodigos = codigo.split("-");

		if (listaCodigos.length == 0)
			return null;

		if (listaCodigos.length == 1) {
			// Se asume que solo se ingreso el Nro Entero
			try {
				nroExt = Integer.parseInt(listaCodigos[0]);
			} catch (Exception e) {
				throw new ExceptionValidation(null, formatoDesconocido);
			}
		} else if (listaCodigos.length == 2) {
			try {
				// Obtener el Lugar de Emision por el primer elemento
				Integer nrolugEmi = Integer.parseInt(listaCodigos[0]);
				NumberFormat formatLugEmi = new DecimalFormat("0000");
				String lugarDeEmision = formatLugEmi.format(nrolugEmi);
				lugEmi = LugarEmision.findByCodigo(lugarDeEmision, sesion);

				// Obtener el Nro Externo por el segundo elemento
				try {
					nroExt = Integer.parseInt(listaCodigos[1]);
				} catch (Exception e) {
					throw new ExceptionValidation(null, formatoDesconocido);
				}

			} catch (Exception e) {
				// No es un entero, Entonces o el tipo de comprobante o una
				// letra

				if (listaCodigos[0].length() == 1)
					letra = listaCodigos[0];
				else {
					tc = TipoComprobante.findByCodigo(listaCodigos[0], sesion);
					if (tc == null)
						throw new ExceptionValidation(null,
								"Tipo de comprobante inexistente:"
										+ listaCodigos[0]);
				}

				try {
					nroExt = Integer.parseInt(listaCodigos[1]);
				} catch (Exception e1) {
					throw new ExceptionValidation(null, formatoDesconocido);
				}

			}

		} else if (listaCodigos.length == 3) {
			// Se asume que la primer es letra
			// Segunda lugar de emision
			// Tercera nro externo
			letra = listaCodigos[0];

			try {
				Integer nrolugEmi = Integer.parseInt(listaCodigos[1]);
				NumberFormat formatLugEmi = new DecimalFormat("0000");
				String lugarDeEmision = formatLugEmi.format(nrolugEmi);
				lugEmi = LugarEmision.findByCodigo(lugarDeEmision, sesion);
			} catch (Exception e) {
				throw new ExceptionValidation(null, formatoDesconocido);
			}

			try {
				nroExt = Integer.parseInt(listaCodigos[2]);
			} catch (Exception e1) {
				throw new ExceptionValidation(null, formatoDesconocido);
			}

		} else if (listaCodigos.length == 4) {

			try {
				String codTC = listaCodigos[0];
				tc = TipoComprobante.findByCodigo(codTC, sesion);
				if (tc == null)
					throw new ExceptionValidation(null,
							"Código de tipo de comprobante inexistente:"
									+ codTC);
			} catch (Exception e) {
				throw new ExceptionValidation(null, formatoDesconocido);
			}

			letra = listaCodigos[1];

			try {
				Integer nrolugEmi = Integer.parseInt(listaCodigos[2]);
				NumberFormat formatLugEmi = new DecimalFormat("0000");
				String lugarDeEmision = formatLugEmi.format(nrolugEmi);
				lugEmi = LugarEmision.findByCodigo(lugarDeEmision, sesion);
			} catch (Exception e) {
				throw new ExceptionValidation(null, formatoDesconocido);
			}

			try {
				nroExt = Integer.parseInt(listaCodigos[3]);
			} catch (Exception e1) {
				throw new ExceptionValidation(null, formatoDesconocido);
			}

		} else if (listaCodigos.length > 4) {
			throw new ExceptionValidation(null, formatoDesconocido);
		}

		return PedidoCab.buscarPedidoPor(tc, letra, lugEmi, nroExt, activa,
				sesion);

	}

	public static PedidoCab buscarPedidoPor(TipoComprobante tc, String letra,
			LugarEmision lugEmi, Integer nroExt, boolean activo, ISesion aSesion)
			throws BaseException {

		// Traer el tipo de comprobante default
		if (tc == null)
			tc = PedidoCab.getTCPedidoDefBuscador(aSesion);

		if (letra == null)
			letra = PedidoCab.getLetraDefaultPedido(aSesion);

		if (lugEmi == null)
			lugEmi = PedidoCab.getLugarEmisionDefaultPedido(aSesion);

		if (nroExt == null)
			throw new ExceptionValidation(null,
					"Debe ingresar el Nro. del comprobante");

		return PedidoCab.getPedidoCab(tc, letra, lugEmi, nroExt, activo,
				aSesion);

	}

	public static TipoComprobante getTCPedidoDefBuscador(ISesion aSesion)
			throws BaseException {
		return TipoComprobante.getTCPedidoDefBuscador(aSesion);
	}

	public static String getLetraDefaultPedido(ISesion aSesion)
			throws BaseException {
		return ValorParametro.findByCodigoParametro("LETRA_COMPRO_DEF_PED",
				aSesion).getValorCadena();
	}

	public static LugarEmision getLugarEmisionDefaultPedido(ISesion aSesion)
			throws BaseException {
		return LugarEmision.getLugarEmisionDefaultPedido(aSesion);
	}
	
	public String getComentarioMasObsCodif(Idioma idioma) throws BaseException {
		StringBuffer comentario  = new StringBuffer("");
		if (this.getComentario()!=null)
			comentario.append(this.getComentario());
		
		Iterator iterObsCodif = 
			this.getObservacionesCodif().iterator();
		while (iterObsCodif.hasNext()) {
			ObsCodifPedidoCab obs = (ObsCodifPedidoCab) iterObsCodif.next();
			if (!obs.isActivo()) continue;
			//comentario.append(Util.ENTER());
			comentario.append(obs.getObs_codificada().getDescripcion(idioma));
		}
		return comentario.toString();
	}
	
	  public static void marcarPedidoPuedeAnularSinControl(PedidoCab pedidoCab,
		      ISesion aSesion)
		  throws BaseException {
		  	DBPedidoCab.marcarPedidoPuedeAnularSinControl(pedidoCab,aSesion);
	  }
	
	

}
