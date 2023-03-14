package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.Transporte;
import com.srn.erp.ventas.da.DBCotizacionCab;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class CotizacionCab extends ComproCab {

	public CotizacionCab() {
	}

	public static String						NICKNAME				= "ve.PresuCab";

	public static String						MERCADO_INTERNO	= "I";

	public static String						MERCADO_EXTERNO	= "E";

	private CotizacionCabAnulacion	comprobanteAnulacion;

	private ComproCab								comprobante;

	private ContactoSujeto					contactoSujeto;

	private Sujeto									sujeto;

	private Moneda									moneda;

	private ValorCotizacion					cotizacion;
	
	private ValorCotizacion 				cotizMonFact;
	
	private String 									comporCotizFact;

	private String									mercado;

	private Double									porc_bonif_cli;

	private Double									porc_reca_cli;

	private Boolean									bonif_cli_cascada;

	private Boolean									reca_cli_cascada;

	private ListaPrecios						lista_precios;

	private CondicionPago						condicionPago;

	private Vendedor								vendedor;

	private UnidadEdilicia					domicilio_entrega;

	private Double									porc_bonif_cp;

	private Double									porc_reca_cp;

	private Boolean									bonif_cp_cascada;

	private Boolean									reca_cp_cascada;

	private Boolean									observado;

	private String									comentario;

	private Boolean									pendEnt;

	private Boolean									pendFact;

	private Transporte							transporte;

	private Moneda									monedaFact;

	private Boolean									pendDesp;

	private FormaEntrega						formaEntrega;

	private String									ordenDeCompra;

	private Money										bruto;

	private Porcentaje							porc_dto;

	private Money										descuento;

	private Porcentaje							porc_recar;

	private Money										recargo;

	private Money										neto;

	private Money										iva;
	
	private Money										iva2;

	private Money										perc_iva;

	private Money										imp_internos;

	private Money										perc_ib;

	private Money										total;

	private Money										impre_bruto;

	private Money										impre_porc_bonif;

	private Money										impre_porc_recar;

	private Money										impre_bonif;

	private Money										impre_recar;

	private Money										impre_neto;

	private Money										impre_iva;
	
	private Money										impre_iva2;

	private Money										impre_perc_iva;

	private Money										impre_perc_ib;

	private Money										impre_imp_int;

	private Money										impre_total;

	private Money										brutoMonLoc;

	private Porcentaje							porcDtoMonLoc;

	private Money										dtoMonLoc;

	private Porcentaje							porcRecarMonloc;

	private Money										recargoMonLoc;

	private Money										netoMonedaLoc;

	private Money										ivaMonLoc;
	
	private Money										iva2MonLoc;

	private Money										percIVAMonLoc;

	private Money										impuInternosMonLoc;

	private Money										percIBMonLoc;

	private Money										totalMonLoc;

	private ConceptoImpuesto				concIVA;
	
	private ConceptoImpuesto				concIVA2;

	private ConceptoImpuesto				concPercIVA;

	private ConceptoImpuesto				concPercIB;

	private ConceptoImpuesto				concImpInt;

	private Money										netoGravado;

	private Money										netoNoGravado;

	private Money										netoGravadoMonLoc;

	private Money										netoNoGravadoMonLoc;

	private java.util.Date					fecValidez;

	private List										detalles				= new ArrayList();
	private boolean									readDetalle			= true;
	
	private List										observacionesCodificadas = new ArrayList();
	private	boolean										readObsCodif = true;
	
	private EstadoPresupuestoCliente estadoPresupuesto;
	
	private MotivoEstadoPresuCliente motivoEstado;
	

	public void setEstadoPresupuesto(EstadoPresupuestoCliente aEstadoPresupuestoCliente) throws BaseException {
		this.estadoPresupuesto = aEstadoPresupuestoCliente;
	}

	public EstadoPresupuestoCliente getEstadoPresupuestoCliente() throws BaseException {
		supportRefresh();
		return this.estadoPresupuesto;
	}
	
	public void setMotivoEstadoPresuCliente(MotivoEstadoPresuCliente aMotivoEstadoPresuCliente) throws BaseException {
		this.motivoEstado = aMotivoEstadoPresuCliente;
	}

	public MotivoEstadoPresuCliente getMotivoEstadoPresuCliente() throws BaseException {
		supportRefresh();
		return this.motivoEstado;
	}
	
	public void setMonedaFact(Moneda aMonedaFact) throws BaseException {
		this.monedaFact = aMonedaFact;
	}

	public Moneda getMonedaFact() throws BaseException {
		supportRefresh();
		return monedaFact;
	}

	public java.util.Date getFecValidez() throws BaseException {
		supportRefresh();
		return this.fecValidez;
	}

	public void setFecValidez(java.util.Date aFecValidez) throws BaseException {
		this.fecValidez = aFecValidez;
	}

	public void setOrdenDeCompra(String aOrdenDeCompra) throws BaseException {
		this.ordenDeCompra = aOrdenDeCompra;
	}

	public String getOrdenDeCompra() throws BaseException {
		supportRefresh();
		return this.ordenDeCompra;
	}

	public void setContactoSujeto(ContactoSujeto aContactoSujeto) throws BaseException {
		this.contactoSujeto = aContactoSujeto;
	}

	public ContactoSujeto getContactoSujeto() throws BaseException {
		supportRefresh();
		return this.contactoSujeto;
	}
	
	public void setCotizMonFact(ValorCotizacion aCotizMonFact) throws BaseException {
		this.cotizMonFact = aCotizMonFact;
	}

	public ValorCotizacion getCotizMonFact() throws BaseException {
		supportRefresh();
		return this.cotizMonFact;
	}
	
	public void setComporCotizFact(String aComporCotizFact) throws BaseException {
		this.comporCotizFact = aComporCotizFact;
	}

	public String getComporCotizFact() throws BaseException {
		supportRefresh();
		return this.comporCotizFact;
	}

	public void setFormaEntrega(FormaEntrega aFormaEntrega) throws BaseException {
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

	public void setCotizacion(ValorCotizacion aCotizacion) {
		this.cotizacion = aCotizacion;
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
	
	public String getComentarioMasObsCodif(Idioma idioma) throws BaseException {
		StringBuffer comentario  = new StringBuffer("");
		if (this.getComentario()!=null)
			comentario.append(this.getComentario());
		
		Iterator iterObsCodif = 
			this.getObservacionesCodificadas().iterator();
		while (iterObsCodif.hasNext()) {
			ObsCodifPresuCab obs = (ObsCodifPresuCab) iterObsCodif.next();
			if (!obs.isActivo()) continue;
			//comentario.append(Util.ENTER());
			comentario.append(obs.getObs_codificada().getDescripcion(idioma));
		}
		return comentario.toString();
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static CotizacionCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CotizacionCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CotizacionCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CotizacionCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}

		beforeSaveComprobante(this);

		validarDatos();

	}

	private void validarDatos() throws BaseException {

		Validar.noNulo(this.sujeto, "Debe ingresar el cliente");
		Validar.noNulo(this.lista_precios, "Debe ingresr la lista de precios");
		Validar.noNulo(this.condicionPago, "Debe ingresar la Condición de Pago");

		Validar.noNulo(this.vendedor, "Debe ingresar el Vendedor");
		Validar.noNulo(this.moneda, "Debe ingresar la Moneda del Presupuesto");
		Validar.noNulo(this.cotizacion, "Debe ingresar la Cotización de la moneda");
		Validar.noNulo(this.cotizMonFact, "Debe ingresar la Cotización de la moneda de facturación");
		Validar.noNulo(this.monedaFact, "Debe ingresar la moneda de Facturación");
		Validar.noNulo(this.getEmision(), "Debe ingresar la Fecha de Emisión");
		Validar.noNulo(this.getTalonario(), "Debe ingresar el Talonario");
		Validar.noNulo(this.getFecValidez(), "Debe ingresar la Fecha de Validez");
		
		if (this.getTotal().doubleValue()<0)
			 throw new ExceptionValidation(null,"El total del comprobante no puede ser negativo");
		 		

	}

	public void afterSave() throws BaseException {
		
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			CotizacionDet cotizacionDet = (CotizacionDet) iterDetalles.next();
			cotizacionDet.save();
			cotizacionDet = null;
		}
		iterDetalles = null;
		
		Iterator iterObservacionesCodificadas = this.observacionesCodificadas.iterator();
		while (iterObservacionesCodificadas.hasNext()) {
			ObsCodifPresuCab obsCodifPresuCab = (ObsCodifPresuCab)iterObservacionesCodificadas.next();
			obsCodifPresuCab.save();
			obsCodifPresuCab = null;
		}
		iterObservacionesCodificadas = null;
		

		afterSaveComprobante(this);
		
	}

	public void afterSaveModified() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveModified();
		
		// Verificar si se cambia la version de impresion
		this.getComprobanteImpreso().siEstaCongeladoGenerarNuevaVersion();

		
	}
	
	
	public void addDetalle(CotizacionDet cotizacionDet) throws BaseException {
		this.detalles.add(cotizacionDet);
		cotizacionDet.setCotizacion(this);
	}
	
	public void addObservacionCodificada(ObsCodifPresuCab aObsCodif) throws BaseException {
		this.observacionesCodificadas.add(aObsCodif);
		aObsCodif.setPresupuesto(this);
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

	public CotizacionDet addDetalle() throws BaseException {
		CotizacionDet cotizacionDet = (CotizacionDet) CotizacionDet.getNew(CotizacionDet.NICKNAME, getSesion());
		cotizacionDet.setCotizacion(this);
		detalles.add(cotizacionDet);
		return cotizacionDet;
	}

	public List getDetalles() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(CotizacionDet.getDetallesByCotizacion(this, getSesion()));
			readDetalle = false;
			return detalles;
		}
		else
			return detalles;
	}
	
	public List getDetallesActivos() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(CotizacionDet.getDetallesByCotizacionActivos(this, getSesion()));
			readDetalle = false;
			return detalles;
		}
		else
			return detalles;
	}
	
	
	public List getObservacionesCodificadas() throws BaseException {
		if (this.readObsCodif == true) {
			observacionesCodificadas.addAll(ObsCodifPresuCab.getObsCodifPresuCab(this, getSesion()));
			readObsCodif = false;
			return observacionesCodificadas;
		}
		else
			return observacionesCodificadas;
	}
	

	public static List getCotizaciones(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde,
			java.util.Date fecHasta, Sujeto sujeto, Producto producto,Vendedor vendedor,EstadoPresupuestoCliente estado,MotivoEstadoPresuCliente motivo,ISesion aSesion) throws BaseException {
		return DBCotizacionCab.getCotizaciones(nroExtDesde, nroExtHasta, fecDesde, fecHasta, sujeto, producto , vendedor, estado, motivo,aSesion);
	}

	public static CotizacionCab getCotizacionBy_TC_Letra_LE_NroExt(TipoComprobante tipoComprobante, String letra,
			Integer nroLugEmi, Integer nroExt, ISesion aSesion) throws BaseException {
		return DBCotizacionCab.getCotizacionTC_Letra_LE_NroExt(tipoComprobante, letra, nroLugEmi, nroExt, aSesion);
	}

	public static boolean isOcultaBonif1EnPedido(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("OCULTAR_BONIF_1_ING_PEDIDO", aSesion).getBoolean();
	}

	public static boolean isOcultaBonif2EnPedido(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("OCULTAR_BONIF_2_ING_PEDIDO", aSesion).getBoolean();
	}

	public static boolean isOcultaBonif3EnPedido(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("OCULTAR_BONIF_3_ING_PEDIDO", aSesion).getBoolean();
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

	public void setPorcDtoMonLoc(Porcentaje aPorcDtoMonLoc) throws BaseException {
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

	public void setPorcRecarMonLoc(Porcentaje aPorcRecarMonLoc) throws BaseException {
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
	
	public void setIva2MonLoc(Money aIVA2MonLoc) throws BaseException {
		this.iva2MonLoc = aIVA2MonLoc;
	}

	public Money getIVA2MonLoc() throws BaseException {
		this.supportRefresh();
		return this.iva2MonLoc;
	}
	

	public void setPercIVAMonLoc(Money aPercIVAMonLoc) throws BaseException {
		this.percIVAMonLoc = aPercIVAMonLoc;
	}

	public Money getPercIVAMonLoc() throws BaseException {
		this.supportRefresh();
		return this.percIVAMonLoc;
	}

	public void setImpuInternosMonLoc(Money aImpuIntMonLoc) throws BaseException {
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

	public void setConcImpIVA(ConceptoImpuesto aConcImpIVA) throws BaseException {
		this.concIVA = aConcImpIVA;
	}

	public ConceptoImpuesto getConcImpuIVA() throws BaseException {
		this.supportRefresh();
		return this.concIVA;
	}
	
	public void setConcImpIVA2(ConceptoImpuesto aConcImpIVA2) throws BaseException {
		this.concIVA2 = aConcImpIVA2;
	}

	public ConceptoImpuesto getConcImpuIVA2() throws BaseException {
		this.supportRefresh();
		return this.concIVA2;
	}
	

	public void setConcImpPercIVA(ConceptoImpuesto aConcImpPercIVA) throws BaseException {
		this.concPercIVA = aConcImpPercIVA;
	}

	public ConceptoImpuesto getConcImpuPercIVA() throws BaseException {
		this.supportRefresh();
		return this.concPercIVA;
	}

	public void setConcImpPercIB(ConceptoImpuesto aConcImpPercIB) throws BaseException {
		this.concPercIB = aConcImpPercIB;
	}

	public ConceptoImpuesto getConcImpuPercIB() throws BaseException {
		this.supportRefresh();
		return this.concPercIB;
	}

	public void setConcImpInt(ConceptoImpuesto aConcImpInt) throws BaseException {
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

	public void setNetoGravadoMonLoc(Money aNetoGravadoMonLoc) throws BaseException {
		this.netoGravadoMonLoc = aNetoGravadoMonLoc;
	}

	public Money getNetoGravadoMonLoc() throws BaseException {
		this.supportRefresh();
		return this.netoGravadoMonLoc;
	}

	public void setNetoNoGravadoMonLoc(Money aNetoNoGravadoMonLoc) throws BaseException {
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

	public void anular() throws BaseException {

		// Anular los Detalles
		Iterator iterDetalles = getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			CotizacionDet cotizacionDet = (CotizacionDet) iterDetalles.next();
			cotizacionDet.delete();
			cotizacionDet.save();
		}

		comprobanteAnulacion = (CotizacionCabAnulacion) CotizacionCabAnulacion.getNew(CotizacionCabAnulacion.NICKNAME,
				getSesion());
		comprobanteAnulacion.setCotizacion_cab(this);
		comprobanteAnulacion.generarComproAnulacion();
		comprobanteAnulacion.save();

	}
	
	public static String getCarpetaRTMPresupuestos(ISesion aSesion)
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"CARPETA_REPO_RTM_PRESUPUESTOS", aSesion).getValorCadena();
	}
	

}
