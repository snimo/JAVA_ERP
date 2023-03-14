package com.srn.erp.ventas.bm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.CuentasParametrizadas;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.bm.AplicClieVto;
import com.srn.erp.ctasACobrar.bm.GrabarCtaCteClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.CotizacionesConta;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.ILibroIVA;
import com.srn.erp.impuestos.bm.ListadoIVA;
import com.srn.erp.impuestos.bm.ListadoIVACab;
import com.srn.erp.impuestos.bm.ListadoIVAConcImpu;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.impuestos.bm.TasaPercIB;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.RenglonMovStock;
import com.srn.erp.stock.bm.RenglonesStock;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MedioPago;
import com.srn.erp.ventas.da.DBFacturaCab;
import com.srn.erp.ventas.da.DBFacturaCabImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class FacturaCab extends ComproCab implements IContabilizable, ILibroIVA, IStockeable {

	private AnuladorFactCab anuladorFactCab = null;

	public static final int SIGNO_FACTURA = 1;

	public static final int SIGNO_NOTA_DEBITO = 1;

	private List detallesFactura = new ArrayList();

	private boolean readDetallesFactura = true;

	private ComproCab comprobante;

	private List cobranzaMostrador = new ArrayList();

	private boolean readCobranzaMostrador = true;

	private List mediosPago = new ArrayList();

	private CotizacionesConta cotizacionesConta = null;

	private List detallesFacturaImpuestos = new ArrayList();

	private boolean readImpuestosFact = true;

	private String oc;

	private String factura;

	private ComproCab facturaSenia;

	private Proyecto proyecto;
	
	private String tipoImpresion; 

	public java.util.Date getImputacion() throws BaseException {
		return this.getImputac();
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public FacturaCab() {
	}

	public static String NICKNAME = "ve.FacturaCab";

	private Sujeto sujeto;

	private String tipo_oper;

	private boolean cargaFactComoAnulada;
	
	private String tipo_cliente;

	private Caja caja;

	private java.util.Date fec_caja;

	private Double porc_bonif_cli;

	private Double porc_recar_cli;

	private Talonario talonario;

	private ListaPrecios lista_precios;

	private Provincia provincia;

	private Moneda moneda;

	private ValorCotizacion cotizacion;

	private Vendedor vendedor;

	private CondicionPago cond_pago;

	private CompoStkTalonarioFactClie compo_stk_fact;

	private TipoConfMovStkTalonario tipoConfMovStk;

	private Double porc_bonif_cp;

	private Double porc_recar_cp;

	private java.util.Date fec_base;

	private SujetoImpositivo sujeto_impositivo;

	private Integer signo;

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

	private Money iva2MonLoc;

	private Money percIVAMonLoc;

	private Money impuInternosMonLoc;

	private Money percIBMonLoc;

	private Money totalMonLoc;

	private ConceptoImpuesto concIVA;

	private ConceptoImpuesto concIVA2;

	private ConceptoImpuesto concPercIVA;

	private ConceptoImpuesto concPercIB;

	private ConceptoImpuesto concImpInt;

	private Money netoGravado;

	private Money netoNoGravado;

	private Money netoGravadoMonLoc;

	private Money netoNoGravadoMonLoc;

	private TipoCtaCteClie tipoCtaCteClie;

	private Money percIBBsAs;

	private Money percIBCapFed;

	private Money imprePercIBBsAs;

	private Money imprePercIBCapFed;

	private Money percIBBsAsMonLoc;

	private Money percIBCapFedMonLoc;
	
	private Boolean homologadaFE;
	private Date 	fecHorHomologadaFE;
	private String 	usuHomologadoFE;
	private String 	caeFE;
	private Date 	fecVtoCaeFE;
	
	public Boolean isHomologadaFE() throws BaseException {
		this.supportRefresh();
		return this.homologadaFE;
	}
	
	public void setHomologadaFE(Boolean aHomologadaFE) throws BaseException {
		this.homologadaFE = aHomologadaFE;
	}
	
	public Date getFecHorHomologadaFE() throws BaseException {
		this.supportRefresh();
		return this.fecHorHomologadaFE;
	}
	
	public void setFecHorHomologadaFE(Date aFecHorHomologadaFE) throws BaseException {
		this.fecHorHomologadaFE = aFecHorHomologadaFE;
	}
	
	
	public String getUsuHomologadaFE() throws BaseException {
		this.supportRefresh();
		return this.usuHomologadoFE;
	}
	
	public void setUsuHomologadaFE(String aUsuHomologadoFE) throws BaseException {
		this.usuHomologadoFE = aUsuHomologadoFE;
	}
	
	public String getCaeFE() throws BaseException {
		this.supportRefresh();
		return this.caeFE;
	}
	
	public void setCaeFE(String aCaeFE) throws BaseException {
		this.caeFE = aCaeFE;
	}


	public Date getFecVtoCaeFE() throws BaseException {
		this.supportRefresh();
		return this.fecVtoCaeFE;
	}
	
	public void setFecVtoCaeFE(Date aFecVtoCaeFE) throws BaseException {
		this.fecVtoCaeFE = aFecVtoCaeFE;
	}
	


	
	public Money getPercIBBsAsMonLoc() throws BaseException {
		return this.percIBBsAsMonLoc;
	}

	public void setPercIBBsAsMonLoc(Money aPercIBBsAsMonLoc) throws BaseException {
		this.percIBBsAsMonLoc = aPercIBBsAsMonLoc;
	}

	public Money getPercIBCapFedMonLoc() throws BaseException {
		return this.percIBCapFedMonLoc;
	}

	public void setPercIBCapFedMonLoc(Money aPercIBCapFedMonLoc) throws BaseException {
		this.percIBCapFedMonLoc = aPercIBCapFedMonLoc;
	}
	
	public void setCargaFactComoAnulada(Boolean aCargaFactComoAnulada) throws BaseException {
		this.cargaFactComoAnulada = aCargaFactComoAnulada;
	}
	
	public boolean isCargaFactComoAnulada() {
		return this.cargaFactComoAnulada;
	}
	

	public Money getImprePercIBCapFed() throws BaseException {
		return this.imprePercIBCapFed;
	}

	public void setProyecto(Proyecto aProyecto) throws BaseException {
		this.proyecto = aProyecto;
	}

	public Proyecto getProyecto() throws BaseException {
		return this.proyecto;
	}

	public void setImprePercIBCapFed(Money aImprePercIBCapFed) throws BaseException {
		this.imprePercIBCapFed = aImprePercIBCapFed;
	}

	public Money getImprePercIBBsAs() throws BaseException {
		return this.imprePercIBBsAs;
	}

	public void setImprePercIBBsAs(Money aImprePercIBBsAs) throws BaseException {
		this.imprePercIBBsAs = aImprePercIBBsAs;
	}

	public Money getPercIBBsAs() throws BaseException {
		return this.percIBBsAs;
	}

	public void setPercIBBsAs(Money aPercIBBsAs) throws BaseException {
		this.percIBBsAs = aPercIBBsAs;
	}

	public Money getPercIBCapFed() throws BaseException {
		return this.percIBCapFed;
	}

	public void setPercIBCapFed(Money aPercIBCapFed) throws BaseException {
		this.percIBCapFed = aPercIBCapFed;
	}

	public TipoCtaCteClie getTipoCtaCteClie() throws BaseException {
		return this.tipoCtaCteClie;
	}

	public void setTipoCtaCteClie(TipoCtaCteClie aTipoCtaCteClie) throws BaseException {
		this.tipoCtaCteClie = aTipoCtaCteClie;
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

	public TipoConfMovStkTalonario getTipoConfMovStkTalonario() throws BaseException {
		this.supportRefresh();
		return this.tipoConfMovStk;
	}

	public void setTipoConfMovStkTalonario(TipoConfMovStkTalonario aTipoConfMovStk) throws BaseException {
		this.tipoConfMovStk = aTipoConfMovStk;
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
	
	public String getTipoImpresion() throws BaseException {
		this.supportRefresh();
		return this.tipoImpresion;
	}
	

	public void setConcImpPercIVA(ConceptoImpuesto aConcImpPercIVA) throws BaseException {
		this.concPercIVA = aConcImpPercIVA;
	}
	
	public void setTipoImpresion(String aTipoImpresion) throws BaseException {
		this.tipoImpresion = aTipoImpresion;
	}
	

	public ComproCab getFacturaSenia() throws BaseException {
		this.supportRefresh();
		return this.facturaSenia;
	}

	public void setFacturaSenia(ComproCab aFacturaSenia) throws BaseException {
		this.facturaSenia = aFacturaSenia;
	}

	public ConceptoImpuesto getConcImpuPercIVA() throws BaseException {
		this.supportRefresh();
		return this.concPercIVA;
	}

	public void setConcImpPercIB(ConceptoImpuesto aConcImpPercIB) throws BaseException {
		this.concPercIB = aConcImpPercIB;
	}

	public String getOC() throws BaseException {
		this.supportRefresh();
		return this.oc;
	}

	public void setOC(String aOC) throws BaseException {
		this.oc = aOC;
	}

	public String getFactura() throws BaseException {
		this.supportRefresh();
		return this.factura;
	}

	public void setFactura(String aFactura) throws BaseException {
		this.factura = aFactura;
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

	public void setPercIVAMonLoc(Money aPercIVAMonLoc) throws BaseException {
		this.percIVAMonLoc = aPercIVAMonLoc;
	}

	public Money getIVA2MonLoc() throws BaseException {
		this.supportRefresh();
		return this.iva2MonLoc;
	}

	public void setIVA2MonLoc(Money aIVA2MonLoc) throws BaseException {
		this.iva2MonLoc = aIVA2MonLoc;
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

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public Sucursal getSucursal() throws BaseException {
		return super.getSucursal();
	}

	public void setSujeto(Sujeto aSujeto) {
		this.sujeto = aSujeto;
	}

	public String getTipo_oper() throws BaseException {
		supportRefresh();
		return tipo_oper;
	}

	public void setTipo_oper(String aTipo_oper) throws BaseException {
		this.tipo_oper = aTipo_oper;

		if (this.tipo_oper != null) {
			if ((TipoOperFacturacion.FACT_MOST.equals(this.tipo_oper)) || (TipoOperFacturacion.NC_MOST.equals(this.tipo_oper))) {
				if (this.isNew())
					this.setActuStock(true);
			}

		}

	}

	public String getTipo_cliente() throws BaseException {
		supportRefresh();
		return tipo_cliente;
	}

	public void setTipo_cliente(String aTipo_cliente) {
		this.tipo_cliente = aTipo_cliente;
	}

	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
	}

	public java.util.Date getFec_caja() throws BaseException {
		supportRefresh();
		return fec_caja;
	}

	public void setFec_caja(java.util.Date aFec_caja) {
		this.fec_caja = aFec_caja;
	}

	public Double getPorc_bonif_cli() throws BaseException {
		supportRefresh();
		return porc_bonif_cli;
	}

	public void setPorc_bonif_cli(Double aPorc_bonif_cli) {
		this.porc_bonif_cli = aPorc_bonif_cli;
	}

	public Double getPorc_recar_cli() throws BaseException {
		supportRefresh();
		return porc_recar_cli;
	}

	public void setPorc_recar_cli(Double aPorc_recar_cli) {
		this.porc_recar_cli = aPorc_recar_cli;
	}

	public Talonario getTalonario() throws BaseException {
		supportRefresh();
		return talonario;
	}

	public void setTalonario(Talonario aTalonario) {
		this.talonario = aTalonario;
	}

	public ListaPrecios getLista_precios() throws BaseException {
		supportRefresh();
		return lista_precios;
	}

	public void setLista_precios(ListaPrecios aLista_precios) {
		this.lista_precios = aLista_precios;
	}

	public Provincia getProvincia() throws BaseException {
		supportRefresh();
		return provincia;
	}

	public void setProvincia(Provincia aProvincia) {
		this.provincia = aProvincia;
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

	public Vendedor getVendedor() throws BaseException {
		supportRefresh();
		return vendedor;
	}

	public void setVendedor(Vendedor aVendedor) {
		this.vendedor = aVendedor;
	}

	public CondicionPago getCond_pago() throws BaseException {
		supportRefresh();
		return cond_pago;
	}

	public void setCond_pago(CondicionPago aCond_pago) {
		this.cond_pago = aCond_pago;
	}

	public CompoStkTalonarioFactClie getCompo_stk_fact() throws BaseException {
		supportRefresh();
		return compo_stk_fact;
	}

	public void setCompo_stk_fact(CompoStkTalonarioFactClie aCompo_stk_fact) {
		this.compo_stk_fact = aCompo_stk_fact;
	}

	public Double getPorc_bonif_cp() throws BaseException {
		supportRefresh();
		return porc_bonif_cp;
	}

	public void setPorc_bonif_cp(Double aPorc_bonif_cp) {
		this.porc_bonif_cp = aPorc_bonif_cp;
	}

	public Double getPorc_recar_cp() throws BaseException {
		supportRefresh();
		return porc_recar_cp;
	}

	public void setPorc_recar_cp(Double aPorc_recar_cp) {
		this.porc_recar_cp = aPorc_recar_cp;
	}

	public java.util.Date getFec_base() throws BaseException {
		supportRefresh();
		return fec_base;
	}

	public void setFec_base(java.util.Date aFec_base) {
		this.fec_base = aFec_base;
	}

	public SujetoImpositivo getSujeto_impositivo() throws BaseException {
		supportRefresh();
		return sujeto_impositivo;
	}

	public void setSujeto_impositivo(SujetoImpositivo aSujeto_impositivo) {
		this.sujeto_impositivo = aSujeto_impositivo;
	}

	public Integer getSigno() throws BaseException {
		supportRefresh();
		return signo;
	}

	public void setSigno(Integer aSigno) {
		this.signo = aSigno;
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

	public String getNickName() {
		return NICKNAME;
	}

	public static FacturaCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (FacturaCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static FacturaCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (FacturaCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {

			this.setComprobante(this);
			
			if (this.isCargaFactComoAnulada()==true) {
				this.setEstado(ComproCab.ESTADO_ANULADO);
				this.setActivo(new Boolean(false));
			} else {
				this.setEstado(ComproCab.ESTADO_ALTA);
				this.setActivo(new Boolean(true));
			}

			// Validar si se puede facturar en CtaCte
			Validar.noNulo(cond_pago, "Debe ingresar la Cond. de Pago");

			if (this.getCond_pago().isCtaCte() && (this.getSujeto().isHabilitarLimiteCredito().booleanValue() == false))
				throw new ExceptionValidation(null, "El cliente no se encuentra habilitado para operar en Cuenta Corriente");

			if (this.getCond_pago().isContado())
				Validar.noNulo(this.caja, "Debe ingresar la caja");

			
			if (((this.getTotal().doubleValue() <= 0)) && (isCargaFactComoAnulada()==false))
				throw new ExceptionValidation(null, "El total del comprobante debe ser mayor a cero");

		}

		beforeSaveComprobante(this);

		Validar.noNulo(sujeto, "Debe ingresar la Persona");
		Validar.noNulo(tipo_oper, "Debe ingresar el tTipo de Operación");
		Validar.noNulo(talonario, "Debe ingresar el Talonario");
		Validar.noNulo(provincia, "Debe ingresar la Provincia");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(cotizacion, "Debe ingresar la Cotización");
		Validar.noNulo(vendedor, "Debe ingresar el Vendedor");
		Validar.noNulo(fec_base, "Debe ingresar la fecha Base");
		Validar.noNulo(sujeto_impositivo, "Debe ingresar el Sujeto Impositivo");
		Validar.noNulo(signo, "Debe ingresar el signo");
		if (this.isCargaFactComoAnulada()==false)
			Validar.noNulo(tipoConfMovStk, "Debe ingresar el Despacho");
		Validar.noNulo(this.lista_precios, "Debe ingresar la Lista de Precios");

		// Grabar los Importes en Pesos
		if (this.isNew()) {
			validarDetalles();
			grabarImportesEnMonLocal();
		}

	}

	private void validarDetalles() throws BaseException {
		if ((this.detallesFactura.isEmpty()) && (this.isCargaFactComoAnulada()==false))
			throw new ExceptionValidation(null, "Debe ingresar algún item del comprobante");
	}

	private void grabarImportesEnMonLocal() throws BaseException {

		Money brutoMonLoc = this.getImporteEnMonLoc(this.getBruto(), this.getMoneda());
		Money porcDto = this.getImporteEnMonLoc(new Money(this.getPorc_dto().doubleValue()), this.getMoneda());
		Money descuento = this.getImporteEnMonLoc(this.getDescuento(), this.getMoneda());
		Money porcRecar = this.getImporteEnMonLoc(new Money(this.getPorc_recar().doubleValue()), this.getMoneda());
		Money recargo = this.getImporteEnMonLoc(this.getRecargo(), this.getMoneda());
		Money netoGravado = this.getImporteEnMonLoc(this.getNetoGravado(), this.getMoneda());
		Money netoNoGravado = this.getImporteEnMonLoc(this.getNetoNoGravado(), this.getMoneda());

		CalculadorMoney calcNeto = new CalculadorMoney(new Money(0));
		calcNeto.sumar(netoGravado);
		calcNeto.sumar(netoNoGravado);

		Money neto = calcNeto.getResultMoney();
		Money iva = this.getImporteEnMonLoc(this.getIva(), this.getMoneda());
		Money iva2 = this.getImporteEnMonLoc(this.getIva2(), this.getMoneda());
		Money percIBBsAs = this.getImporteEnMonLoc(this.getPercIBBsAs(), this.getMoneda());
		Money percIVA = this.getImporteEnMonLoc(this.getPerc_iva(), this.getMoneda());
		Money percIB = this.getImporteEnMonLoc(this.getPerc_ib(), this.getMoneda());
		Money impInt = this.getImporteEnMonLoc(this.getImp_internos(), this.getMoneda());

		CalculadorMoney calcTotal = new CalculadorMoney(new Money(0));
		calcTotal.sumar(neto);
		calcTotal.sumar(iva);
		calcTotal.sumar(iva2);
		calcTotal.sumar(percIVA);
		calcTotal.sumar(percIB);
		calcTotal.sumar(percIBBsAs);
		calcTotal.sumar(impInt);
		Money total = calcTotal.getResultMoney();

		this.setBrutoMonLoc(brutoMonLoc);
		this.setPorcDtoMonLoc(new Porcentaje(porcDto.doubleValue()));
		this.setDtoMonLoc(descuento);
		this.setPorcRecarMonLoc(new Porcentaje(porcRecar.doubleValue()));
		this.setRecargoMonLoc(recargo);
		this.setNetoMonedaLocal(neto);
		this.setNetoGravadoMonLoc(netoGravado);
		this.setNetoNoGravadoMonLoc(netoNoGravado);
		this.setIvaMonLoc(iva);
		this.setIVA2MonLoc(iva2);

		this.setPercIVAMonLoc(percIVA);
		this.setPercIBBsAsMonLoc(percIBBsAs);
		this.setPercIBMonLoc(percIB);
		this.setImpuInternosMonLoc(impInt);
		this.setTotalMonLoc(total);

		// Grabar los Impuestos correspondientes
		if ((this.getIva2() != null) && (getIva2().doubleValue() != 0)) {
			// Agregar el impuesto IVA
			FacturaCabImpu factCabImpu = (FacturaCabImpu) FacturaCabImpu.getNew(FacturaCabImpu.NICKNAME, getSesion());
			factCabImpu.setFacturacab(this);
			factCabImpu.setConcepto_impuesto(this.getConcImpuIVA2());
			factCabImpu.setImporte_mon_local(this.getIVA2MonLoc());
			factCabImpu.setImporte_mon_ori(this.getIva2());
			detallesFacturaImpuestos.add(factCabImpu);
		}

		// Grabar los Impuestos correspondientes
		if ((this.getIva() != null) && (getIva().doubleValue() != 0)) {
			// Agregar el impuesto IVA
			FacturaCabImpu factCabImpu = (FacturaCabImpu) FacturaCabImpu.getNew(FacturaCabImpu.NICKNAME, getSesion());
			factCabImpu.setFacturacab(this);
			factCabImpu.setConcepto_impuesto(this.getConcImpuIVA());
			factCabImpu.setImporte_mon_local(this.getIVAMonLoc());
			factCabImpu.setImporte_mon_ori(this.getIva());
			detallesFacturaImpuestos.add(factCabImpu);
		}

		if ((this.getPerc_iva() != null) && (getPerc_iva().doubleValue() != 0)) {
			// Agregar el impuesto Perc IVA
			FacturaCabImpu factCabImpu = (FacturaCabImpu) FacturaCabImpu.getNew(FacturaCabImpu.NICKNAME, getSesion());
			factCabImpu.setFacturacab(this);
			factCabImpu.setConcepto_impuesto(this.getConcImpuPercIVA());
			factCabImpu.setImporte_mon_local(this.getPercIVAMonLoc());
			factCabImpu.setImporte_mon_ori(this.getPerc_iva());
			detallesFacturaImpuestos.add(factCabImpu);
		}
		if ((this.getPercIBBsAs() != null) && (getPercIBBsAs().doubleValue() != 0)) {
			// Agregar el impuesto Perc IB
			FacturaCabImpu factCabImpu = (FacturaCabImpu) FacturaCabImpu.getNew(FacturaCabImpu.NICKNAME, getSesion());
			factCabImpu.setFacturacab(this);
			factCabImpu.setConcepto_impuesto(ConceptoImpuesto.getPercIBBsAs(this.getSesion()));
			factCabImpu.setImporte_mon_local(this.getPercIBBsAsMonLoc());
			factCabImpu.setImporte_mon_ori(this.getPercIBBsAs());
			detallesFacturaImpuestos.add(factCabImpu);
		}
		if ((this.getPercIBCapFed() != null) && (getPercIBCapFed().doubleValue() != 0)) {
			// Agregar el impuesto Perc IB
			FacturaCabImpu factCabImpu = (FacturaCabImpu) FacturaCabImpu.getNew(FacturaCabImpu.NICKNAME, getSesion());
			factCabImpu.setFacturacab(this);
			factCabImpu.setConcepto_impuesto(ConceptoImpuesto.getPercIBCapFed(this.getSesion()));
			factCabImpu.setImporte_mon_local(this.getPercIBCapFedMonLoc());
			factCabImpu.setImporte_mon_ori(this.getPercIBCapFed());
			detallesFacturaImpuestos.add(factCabImpu);
		}
		if ((this.getPerc_ib() != null) && (getPerc_ib().doubleValue() != 0)) {
			// Agregar el impuesto Perc IB
			FacturaCabImpu factCabImpu = (FacturaCabImpu) FacturaCabImpu.getNew(FacturaCabImpu.NICKNAME, getSesion());
			factCabImpu.setFacturacab(this);
			factCabImpu.setConcepto_impuesto(this.getConcImpuPercIB());
			factCabImpu.setImporte_mon_local(this.getPercIBMonLoc());
			factCabImpu.setImporte_mon_ori(this.getPerc_ib());
			detallesFacturaImpuestos.add(factCabImpu);
		}
		if ((this.getImp_internos() != null) && (getImp_internos().doubleValue() != 0)) {
			// Agregar el impuesto Perc IB
			FacturaCabImpu factCabImpu = (FacturaCabImpu) FacturaCabImpu.getNew(FacturaCabImpu.NICKNAME, getSesion());
			factCabImpu.setFacturacab(this);
			factCabImpu.setConcepto_impuesto(this.getConcImpInt());
			factCabImpu.setImporte_mon_local(this.getImpuIntMonLoc());
			factCabImpu.setImporte_mon_ori(this.getImp_internos());
			detallesFacturaImpuestos.add(factCabImpu);
		}

	}

	public List getItemsFactura() throws BaseException {
		if (readDetallesFactura) {
			List listaItemsFactura = FacturaDet.getItemsFactura(this, getSesion());
			detallesFactura.addAll(listaItemsFactura);
			readDetallesFactura = false;
		}
		return detallesFactura;
	}

	public List getImpuestos() throws BaseException {
		if (readImpuestosFact) {
			List listaImpuestos = FacturaCab.getFacturaCabImpu(this, getSesion());
			detallesFacturaImpuestos.addAll(listaImpuestos);
			readImpuestosFact = false;
		}
		return detallesFacturaImpuestos;
	}

	public List getCobranzasMostrador() throws BaseException {
		if (readCobranzaMostrador) {
			List listaCobrazas = CobranzaVtaMostrador.getCobranzasVtaMos(this, getSesion());
			cobranzaMostrador.addAll(listaCobrazas);
			readCobranzaMostrador = false;
		}
		return cobranzaMostrador;
	}

	public void addDetalleFactura(FacturaDet facturaDet) throws BaseException {
		facturaDet.setComprocab(this);
		detallesFactura.add(facturaDet);
	}

	public void addImpuesto(FacturaCabImpu facturaCabImpu) throws BaseException {
		facturaCabImpu.setFacturacab(this);
		detallesFacturaImpuestos.add(facturaCabImpu);
	}

	public void addCobranzaVtaMostrador(CobranzaVtaMostrador aCobranzaVtaMostrador) throws BaseException {
		aCobranzaVtaMostrador.setFacturaCab(this);
		this.cobranzaMostrador.add(aCobranzaVtaMostrador);
	}

	public void afterSave() throws BaseException {

		Iterator iterDetallesFactura = detallesFactura.iterator();
		while (iterDetallesFactura.hasNext()) {
			FacturaDet facturaDet = (FacturaDet) iterDetallesFactura.next();
			facturaDet.save();
			facturaDet = null;
		}
		iterDetallesFactura = null;

		// Grabar los Impuestos de la Factura
		Iterator iterImpuFact = detallesFacturaImpuestos.iterator();
		while (iterImpuFact.hasNext()) {
			FacturaCabImpu factCabImpu = (FacturaCabImpu) iterImpuFact.next();
			factCabImpu.save();
			factCabImpu = null;
		}

		// Cobranza mostrador
		grabarMediosPago();

		// Iterator iterCobranzaVtaMostrador =
		// this.cobranzaMostrador.iterator();
		// while (iterCobranzaVtaMostrador.hasNext()) {
		// CobranzaVtaMostrador cobVtaMos = (CobranzaVtaMostrador)
		// iterCobranzaVtaMostrador.next();
		// cobVtaMos.save();
		// cobVtaMos = null;
		// }
		

		if (this.getCond_pago().isCtaCte())
			grabarCtaCteClie();

		afterSaveComprobante(this);

		// Si el comprobante sale por impresora fiscal
		// actualizar en el talonario el Nro. de comprobante

		if ((this.getTalonario().isUsaImpresoraFiscal()) && (this.isCargaFactComoAnulada()==false)) {
			// Actualizar el Talonatio
			this.getTalonario().setNro_actual(this.getNroExt());
			this.getTalonario().save();
		}

	}

	public FacturaDet addDetalle() throws BaseException {
		FacturaDet factDet = (FacturaDet) FacturaDet.getNew(FacturaDet.NICKNAME, getSesion());
		addDetalleFactura(factDet);
		return factDet;
	}

	public static List getFacturaCabImpu(FacturaCab facturaCab, ISesion aSesion) throws BaseException {
		return DBFacturaCabImpu.getFacturaCabImpu(facturaCab, aSesion);
	}

	public ListadoIVACab getLibroIVACab() throws BaseException {

		// Las Notas de Debito y Credito Internas no deben grabar el Libro de
		// IVA
		// Despues deben tener el mismo compotamiento que una factura nomal

		if (this.getTipoCompro().esNotaDebitoInternaCliente() || this.getTipoCompro().esNotaCreditoInternaCliente())
			return null;

		ListadoIVACab libroIVA = (ListadoIVACab) ListadoIVACab.getNew(ListadoIVACab.NICKNAME, getSesion());
		libroIVA.setComprobante(this);
		libroIVA.setRazon_social(this.getSujeto_impositivo().getRazon());
		if (this.getSujeto_impositivo() == null)
			throw new ExceptionValidation(null, "No se encuentra configurado un sujeto impositivo para el cliente "
					+ this.getSujeto().getCodigo() + " - " + this.getSujeto().getRazon_social());
		libroIVA.setCategoria_iva(this.getSujeto_impositivo().getCategiva());
		libroIVA.setSujetoImpositivo(this.getSujeto_impositivo());
		libroIVA.setCuit(this.getSujeto_impositivo().getCuit());
		libroIVA.setTipo_listado(ListadoIVA.LIBRO_IVA_VENTAS);
		libroIVA.setNeto_gravado(new Money(this.getNetoGravado().doubleValue() * getSignoLibroIVA()));
		libroIVA.setNeto_no_gravado(new Money(this.getNetoNoGravado().doubleValue() * getSignoLibroIVA()));
		libroIVA.setTotal(new Money(this.getTotal().doubleValue() * getSignoLibroIVA()));

		// Verificar si esta gravado con IVA
		if (this.getConcImpuIVA() != null)
			if ((this.getIVAMonLoc() != null) && (this.getIVAMonLoc().doubleValue() != 0)) {
				ListadoIVAConcImpu listadoIVAConcImpu = (ListadoIVAConcImpu) ListadoIVAConcImpu.getNew(ListadoIVAConcImpu.NICKNAME,
						getSesion());
				listadoIVAConcImpu.setConcepto_impuesto(this.getConcImpuIVA());
				listadoIVAConcImpu.setImporte(new Money(this.getIVAMonLoc().doubleValue() * getSignoLibroIVA()));
				libroIVA.addLibroIVAConcImpu(listadoIVAConcImpu);
			}

		// Verificar si esta gravado con IVA
		if (this.getConcImpuIVA2() != null)
			if ((this.getIVA2MonLoc() != null) && (this.getIVA2MonLoc().doubleValue() != 0)) {
				ListadoIVAConcImpu listadoIVAConcImpu = (ListadoIVAConcImpu) ListadoIVAConcImpu.getNew(ListadoIVAConcImpu.NICKNAME,
						getSesion());
				listadoIVAConcImpu.setConcepto_impuesto(this.getConcImpuIVA2());
				listadoIVAConcImpu.setImporte(new Money(this.getIVA2MonLoc().doubleValue() * getSignoLibroIVA()));
				libroIVA.addLibroIVAConcImpu(listadoIVAConcImpu);
			}

		// Verificar si esta gravado con percepcion de IVA
		if (this.getConcImpuPercIVA() != null)
			if ((this.getPercIVAMonLoc() != null) && (this.getPercIVAMonLoc().doubleValue() != 0)) {
				ListadoIVAConcImpu listadoIVAConcImpu = (ListadoIVAConcImpu) ListadoIVAConcImpu.getNew(ListadoIVAConcImpu.NICKNAME,
						getSesion());
				listadoIVAConcImpu.setConcepto_impuesto(this.getConcImpuPercIVA());
				listadoIVAConcImpu.setImporte(new Money(this.getPercIVAMonLoc().doubleValue() * getSignoLibroIVA()));
				libroIVA.addLibroIVAConcImpu(listadoIVAConcImpu);
			}

		// Grabar las percepcion de Ingresos Brutos Bs As
		if ((this.getPercIBBsAsMonLoc() != null) && (this.getPercIBBsAsMonLoc().doubleValue() > 0)) {
			ListadoIVAConcImpu listadoIVAConcImpu = (ListadoIVAConcImpu) ListadoIVAConcImpu
					.getNew(ListadoIVAConcImpu.NICKNAME, getSesion());
			listadoIVAConcImpu.setConcepto_impuesto(ConceptoImpuesto.getPercIBBsAs(this.getSesion()));
			listadoIVAConcImpu.setImporte(new Money(this.getPercIBBsAsMonLoc().doubleValue() * getSignoLibroIVA()));
			libroIVA.addLibroIVAConcImpu(listadoIVAConcImpu);
		}

		if ((this.getPercIBCapFedMonLoc() != null) && (this.getPercIBCapFedMonLoc().doubleValue() > 0)) {
			ListadoIVAConcImpu listadoIVAConcImpu = (ListadoIVAConcImpu) ListadoIVAConcImpu
					.getNew(ListadoIVAConcImpu.NICKNAME, getSesion());
			listadoIVAConcImpu.setConcepto_impuesto(ConceptoImpuesto.getPercIBCapFed(this.getSesion()));
			listadoIVAConcImpu.setImporte(new Money(this.getPercIBCapFedMonLoc().doubleValue() * getSignoLibroIVA()));
			libroIVA.addLibroIVAConcImpu(listadoIVAConcImpu);
		}

		// Verificar si tiene Percepcion de Ingresos Brutos
		/*
		 * if (this.getConcImpuPercIB() != null) if ((this.getPercIBMonLoc() !=
		 * null) && (this.getPercIBMonLoc().doubleValue() != 0)) {
		 * ListadoIVAConcImpu listadoIVAConcImpu = (ListadoIVAConcImpu)
		 * ListadoIVAConcImpu.getNew( ListadoIVAConcImpu.NICKNAME, getSesion());
		 * listadoIVAConcImpu.setConcepto_impuesto(this.getConcImpuPercIB());
		 * listadoIVAConcImpu.setImporte(new
		 * Money(this.getPercIBMonLoc().doubleValue() getSignoLibroIVA()));
		 * libroIVA.addLibroIVAConcImpu(listadoIVAConcImpu); }
		 */

		// Verificar si tiene Impuestos Internos
		if (this.getConcImpInt() != null)
			if ((this.getImpuIntMonLoc() != null) && (this.getImpuIntMonLoc().doubleValue() != 0)) {
				ListadoIVAConcImpu listadoIVAConcImpu = (ListadoIVAConcImpu) ListadoIVAConcImpu.getNew(ListadoIVAConcImpu.NICKNAME,
						getSesion());
				listadoIVAConcImpu.setConcepto_impuesto(this.getConcImpInt());
				listadoIVAConcImpu.setImporte(new Money(this.getImpuIntMonLoc().doubleValue() * getSignoLibroIVA()));
				libroIVA.addLibroIVAConcImpu(listadoIVAConcImpu);
			}

		return libroIVA;
	}

	public int getSignoLibroIVA() throws BaseException {
		if (isFacturaNotaDebito())
			return 1;
		else
			return -1;
	}

	private void grabarMediosPago() throws BaseException {
		Iterator iterMediosPagos = mediosPago.iterator();
		while (iterMediosPagos.hasNext()) {
			MedioPago medioPago = (MedioPago) iterMediosPagos.next();
			medioPago.save();
		}
	}

	public MedioPago addMedioPago() throws BaseException {
		MedioPago medioPago = new MedioPago();
		medioPago.setSesion(getSesion());
		medioPago.setComprobante(this);

		if (isFacturaNotaDebito())
			medioPago.setIngresoEgreso(MedioPago.INGRESO);
		else {
			medioPago.setIngresoEgreso(MedioPago.EGRESO);
			medioPago.setDevolucion(true);
		}

		mediosPago.add(medioPago);
		return medioPago;
	}

	private void grabarCtaCteClie() throws BaseException {
		// Grabar la Cuenta Corriente del Proveedor
		getCotizacionesConta().init();
		getCotizacionesConta().addCotizaciones(listaCotizaciones);
		getCotizacionesConta().addCotizacion(getMoneda(), getCotizacion());
		getCotizacionesConta().setFecha(getEmision());
		GrabarCtaCteClie ctaCteClie = new GrabarCtaCteClie(getSesion());
		if (this.isFacturaNotaDebito())
			ctaCteClie.setSigno(new Integer(1));
		else
			ctaCteClie.setSigno(new Integer(-1));
		ctaCteClie.setComprobante(this);
		ctaCteClie.setTipoCtaCteClie(this.getTipoCtaCteClie());
		ctaCteClie.setSujeto(getSujeto());
		ctaCteClie.setMoneda(getMoneda());
		ctaCteClie.setImporte(this.getTotal());
		ctaCteClie.setImputac(this.getImputac());
		ctaCteClie.setEmision(getEmision());
		ctaCteClie.setBase(this.getFec_base());
		ctaCteClie.setCotizMonOri(this.getCotizacion());
		ctaCteClie.setCotizMonExt1(getCotizacionesConta().getCotizMonedaExt1());
		ctaCteClie.setCotizMonExt2(getCotizacionesConta().getCotizMonedaExt2());
		ctaCteClie.setCotizMonOriCon(this.getCotizacion());
		ctaCteClie.setCotizMonExt1Con(getCotizacionesConta().getCotizMonedaExt1());
		ctaCteClie.setCotizMonExt2Con(getCotizacionesConta().getCotizMonedaExt2());
		// Condiciones de Pago
		ctaCteClie.setCondVenta(this.getCond_pago().getCondicion_vta());
		ctaCteClie.save();

	}

	private CotizacionesConta getCotizacionesConta() throws BaseException {
		if (cotizacionesConta == null)
			cotizacionesConta = new CotizacionesConta(getSesion());
		return cotizacionesConta;
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		return contabilizarFactura();
	}

	private RenglonesAsiento contabilizarFactura() throws BaseException {
		RenglonesAsiento renglones = new RenglonesAsiento();
		if (this.getCond_pago().isCtaCte())
			getRenglonDeudoresPorVentas(renglones);
		else
			getRenglonValores(renglones);
		getRenglonesVentas(renglones);
		getRenglonIVA(renglones);
		getRenglonIVA2(renglones);
		getRenglonPercIVA(renglones);
		getRenglonImpInternos(renglones);
		// getRenglonPercIB(renglones);
		getRenglonPercIBBsAs(renglones);
		getRenglonesBonificacionRecargo(renglones);
		return renglones;
	}

	protected void getRenglonValores(RenglonesAsiento renglones) throws BaseException {
		Iterator iterMediosPago = mediosPago.iterator();
		while (iterMediosPago.hasNext()) {
			MedioPago medioPago = (MedioPago) iterMediosPago.next();

			RenglonAsiento renglon = renglones.addRenglonAsiento();
			if (medioPago.getTipoValor().getCuentaImputable()!=null)
				renglon.setCuentaImputable(medioPago.getTipoValor().getCuentaImputable());
			else if (medioPago.getValorGrabado()!=null)
					renglon.setCuentaImputable(medioPago.getValorGrabado().getCuentaImputable());
			
			if (this.isFacturaNotaDebito())
				renglon.setD_H(RenglonAsiento.DEBE);
			else
				renglon.setD_H(RenglonAsiento.HABER);
			renglon.setMonedaOri(medioPago.getTipoValor().getMoneda());
			renglon.setImporteOri(medioPago.getImporteMonedaValor());
			renglon.setCotizOri(medioPago.getCotizMonedaValor());
			renglon.setComentario("");

			addCotizacionMoneda(medioPago.getTipoValor().getMoneda(), medioPago.getCotizMonedaValor());
			ImportesContables importesValor = this.getImportesContables(medioPago.getImporteMonedaValor(), medioPago.getTipoValor()
					.getMoneda(), this.getImputac());

			renglon.setCotizMonExt1(importesValor.getValorCotizMonExt1());
			renglon.setCotizMonExt2(importesValor.getValorCotizMonExt2());

			renglon.setImpoLocHist(importesValor.getImpoMonLoc());
			renglon.setImpoLocAju(importesValor.getImpoMonLocAju());
			renglon.setImpoMonExt1(importesValor.getImpoMonExt1());
			renglon.setImpoMonExt2(importesValor.getImpoMonExt2());
		}
	}

	public boolean isFacturaNotaDebito() throws BaseException {
		if ((this.getTipo_oper().equals(TipoOperFacturacion.FACT_MOST) || (this.getTipo_oper().equals(TipoOperFacturacion.FACT_SS))
				|| (this.getTipo_oper().equals(TipoOperFacturacion.NOTA_DEBITO)) || (this.getTipo_oper().equals(TipoOperFacturacion.FACT_REM)) || (this.getTipo_oper().equals(TipoOperFacturacion.FACT_PED))
				|| (this.getTipo_oper().equals(TipoOperFacturacion.ND_INTERNA)) || (this.getTipo_oper()
				.equals(TipoOperFacturacion.FACT_ANT))))
			return true;
		else if ((this.getTipo_oper().equals(TipoOperFacturacion.NC_MOST) || (this.getTipo_oper().equals(TipoOperFacturacion.NC_INTERNA))))
			return false;
		else
			return false;
	}

	protected void getRenglonDeudoresPorVentas(RenglonesAsiento renglones) throws BaseException {

		// Deudores por Ventas
		if (this.getTotal().doubleValue() == 0)
			return;

		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(CuentasParametrizadas.getDeudoresPorVentas(getSesion()));

		if (isFacturaNotaDebito())
			renglon.setD_H(RenglonAsiento.DEBE);
		else
			renglon.setD_H(RenglonAsiento.HABER);
		renglon.setMonedaOri(getMoneda());
		renglon.setImporteOri(this.getTotal());
		renglon.setCotizOri(this.getCotizacion());
		renglon.setComentario("");

		ImportesContables importesDeudoresPorVentas = this.getImportesContables(this.getTotal(), this.getMoneda(), this.getImputac());

		renglon.setCotizMonExt1(importesDeudoresPorVentas.getValorCotizMonExt1());
		renglon.setCotizMonExt2(importesDeudoresPorVentas.getValorCotizMonExt2());

		renglon.setImpoLocHist(importesDeudoresPorVentas.getImpoMonLoc());
		renglon.setImpoLocAju(importesDeudoresPorVentas.getImpoMonLocAju());
		renglon.setImpoMonExt1(importesDeudoresPorVentas.getImpoMonExt1());
		renglon.setImpoMonExt2(importesDeudoresPorVentas.getImpoMonExt2());

	}

	protected void getRenglonesVentas(RenglonesAsiento renglones) throws BaseException {

		Iterator iterDetallesFacturas = this.detallesFactura.iterator();
		while (iterDetallesFacturas.hasNext()) {
			FacturaDet facturaDet = (FacturaDet) iterDetallesFacturas.next();

			CalculadorMoney calcImpoNeto = null;

			Money precioListaSinIVA = facturaDet.getCalcImportePrecioListaSinIVA();

			if ((precioListaSinIVA != null) && (precioListaSinIVA.doubleValue() != 0))
				calcImpoNeto = new CalculadorMoney(precioListaSinIVA);
			else
				calcImpoNeto = new CalculadorMoney(facturaDet.getNetoGravadoMasNetoNoGravado());

			if (calcImpoNeto.getResultMoney().doubleValue() == 0)
				continue;

			ImportesContables importesVenta = this.getImportesContables(calcImpoNeto.getResultMoney(), this.getMoneda(), this.getImputac());

			// Ventas
			RenglonAsiento renglon = renglones.addRenglonAsiento();
			renglon.setCuentaImputable(CuentasParametrizadas.getImputableVenta(facturaDet, getSesion()));
			if (this.isFacturaNotaDebito())
				renglon.setD_H(RenglonAsiento.HABER);
			else
				renglon.setD_H(RenglonAsiento.DEBE);
			renglon.setMonedaOri(getMoneda());
			renglon.setImporteOri(calcImpoNeto.getResultMoney());
			renglon.setCotizOri(this.getCotizacion());
			renglon.setComentario("");

			renglon.setCotizMonExt1(importesVenta.getValorCotizMonExt1());
			renglon.setCotizMonExt2(importesVenta.getValorCotizMonExt2());

			renglon.setImpoLocHist(importesVenta.getImpoMonLoc());
			renglon.setImpoLocAju(importesVenta.getImpoMonLocAju());
			renglon.setImpoMonExt1(importesVenta.getImpoMonExt1());
			renglon.setImpoMonExt2(importesVenta.getImpoMonExt2());

		}

	}

	protected void getRenglonIVA(RenglonesAsiento renglones) throws BaseException {

		if (getIva().doubleValue() == 0)
			return;

		RenglonAsiento renglon = renglones.addRenglonAsiento();

		if (this.getConcImpuIVA().getCuentaImputable() == null)
			throw new ExceptionValidation(null, "Falta configurar la cuenta contable para el concepto de impuesto "
					+ this.getConcImpuIVA().getDescripcion());

		renglon.setCuentaImputable(this.getConcImpuIVA().getCuentaImputable());
		if (this.isFacturaNotaDebito())
			renglon.setD_H(RenglonAsiento.HABER);
		else
			renglon.setD_H(RenglonAsiento.DEBE);
		renglon.setMonedaOri(getMoneda());
		renglon.setImporteOri(getIva());
		renglon.setCotizOri(this.getCotizacion());
		renglon.setComentario("");

		ImportesContables importesIVA = this.getImportesContables(getIva(), this.getMoneda(), this.getImputac());

		renglon.setCotizMonExt1(importesIVA.getValorCotizMonExt1());
		renglon.setCotizMonExt2(importesIVA.getValorCotizMonExt2());

		renglon.setImpoLocHist(importesIVA.getImpoMonLoc());
		renglon.setImpoLocAju(importesIVA.getImpoMonLocAju());
		renglon.setImpoMonExt1(importesIVA.getImpoMonExt1());
		renglon.setImpoMonExt2(importesIVA.getImpoMonExt2());
	}

	protected void getRenglonIVA2(RenglonesAsiento renglones) throws BaseException {

		if (getIva2().doubleValue() == 0)
			return;

		RenglonAsiento renglon = renglones.addRenglonAsiento();
		// renglon.setCuentaImputable(CuentasParametrizadas
		// .getIVADebito(getSesion()));
		if (this.getConcImpuIVA2().getCuentaImputable() == null)
			throw new ExceptionValidation(null, "Falta configurar la cuenta contable para el concepto de impuesto "
					+ this.getConcImpuIVA2().getDescripcion());
		renglon.setCuentaImputable(this.getConcImpuIVA2().getCuentaImputable());
		if (this.isFacturaNotaDebito())
			renglon.setD_H(RenglonAsiento.HABER);
		else
			renglon.setD_H(RenglonAsiento.DEBE);
		renglon.setMonedaOri(getMoneda());
		renglon.setImporteOri(getIva2());
		renglon.setCotizOri(this.getCotizacion());
		renglon.setComentario("");

		ImportesContables importesIVA = this.getImportesContables(getIva2(), this.getMoneda(), this.getImputac());

		renglon.setCotizMonExt1(importesIVA.getValorCotizMonExt1());
		renglon.setCotizMonExt2(importesIVA.getValorCotizMonExt2());

		renglon.setImpoLocHist(importesIVA.getImpoMonLoc());
		renglon.setImpoLocAju(importesIVA.getImpoMonLocAju());
		renglon.setImpoMonExt1(importesIVA.getImpoMonExt1());
		renglon.setImpoMonExt2(importesIVA.getImpoMonExt2());
	}

	protected void getRenglonPercIVA(RenglonesAsiento renglones) throws BaseException {

		if (getPerc_iva().doubleValue() == 0)
			return;

		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(CuentasParametrizadas.getPercIVACredito(getSesion()));
		if (this.isFacturaNotaDebito())
			renglon.setD_H(RenglonAsiento.HABER);
		else
			renglon.setD_H(RenglonAsiento.DEBE);
		renglon.setMonedaOri(getMoneda());
		renglon.setImporteOri(getPerc_iva());
		renglon.setCotizOri(this.getCotizacion());
		renglon.setComentario("");

		ImportesContables importesPercIVA = this.getImportesContables(getPerc_iva(), this.getMoneda(), this.getImputac());

		renglon.setCotizMonExt1(importesPercIVA.getValorCotizMonExt1());
		renglon.setCotizMonExt2(importesPercIVA.getValorCotizMonExt2());

		renglon.setImpoLocHist(importesPercIVA.getImpoMonLoc());
		renglon.setImpoLocAju(importesPercIVA.getImpoMonLocAju());
		renglon.setImpoMonExt1(importesPercIVA.getImpoMonExt1());
		renglon.setImpoMonExt2(importesPercIVA.getImpoMonExt2());

	}

	protected void getRenglonImpInternos(RenglonesAsiento renglones) throws BaseException {

		if (this.getImp_internos().doubleValue() == 0)
			return;

		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(CuentasParametrizadas.getImpIntVtas(getSesion()));
		if (this.isFacturaNotaDebito())
			renglon.setD_H(RenglonAsiento.HABER);
		else
			renglon.setD_H(RenglonAsiento.DEBE);
		renglon.setMonedaOri(getMoneda());
		renglon.setImporteOri(this.getImp_internos());
		renglon.setCotizOri(this.getCotizacion());
		renglon.setComentario("");

		ImportesContables importesImpIntVtas = this.getImportesContables(this.getImp_internos(), this.getMoneda(), this.getImputac());

		renglon.setCotizMonExt1(importesImpIntVtas.getValorCotizMonExt1());
		renglon.setCotizMonExt2(importesImpIntVtas.getValorCotizMonExt2());

		renglon.setImpoLocHist(importesImpIntVtas.getImpoMonLoc());
		renglon.setImpoLocAju(importesImpIntVtas.getImpoMonLocAju());
		renglon.setImpoMonExt1(importesImpIntVtas.getImpoMonExt1());
		renglon.setImpoMonExt2(importesImpIntVtas.getImpoMonExt2());

	}

	protected void getRenglonBonifExtraordinaria(FacturaDet facturaDet, Money bonifExtra, RenglonesAsiento renglones) throws BaseException {

		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(CuentasParametrizadas.getImputableBonificacionExtraordinaria(facturaDet, getSesion()));
		if (this.isFacturaNotaDebito())
			renglon.setD_H(RenglonAsiento.DEBE);
		else
			renglon.setD_H(RenglonAsiento.HABER);
		renglon.setMonedaOri(getMoneda());
		renglon.setImporteOri(bonifExtra);
		renglon.setCotizOri(this.getCotizacion());
		renglon.setComentario("");

		ImportesContables importesBonif = this.getImportesContables(bonifExtra, this.getMoneda(), this.getImputac());

		renglon.setCotizMonExt1(importesBonif.getValorCotizMonExt1());
		renglon.setCotizMonExt2(importesBonif.getValorCotizMonExt2());

		renglon.setImpoLocHist(importesBonif.getImpoMonLoc());
		renglon.setImpoLocAju(importesBonif.getImpoMonLocAju());
		renglon.setImpoMonExt1(importesBonif.getImpoMonExt1());
		renglon.setImpoMonExt2(importesBonif.getImpoMonExt2());

	}

	protected void getRenglonPercIB(RenglonesAsiento renglones) throws BaseException {

		if (this.getPerc_ib().doubleValue() == 0)
			return;

		ConceptoImpuesto concImpuPercIB = getTomarPrimerConcIB();
		if (concImpuPercIB == null)
			throw new ExceptionValidation(null, "No se pudo obtener el concepto de Perc. IB " + "para ningún producto de la factura");

		if (this.getProvincia() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Provincia para obtener la cuenta Imputable de Ingresos Brutos");

		if (this.getSujeto().getSujeto_impositivo() == null)
			throw new ExceptionValidation(null, "El cliente " + this.getSujeto().getRazon_social() + " no tiene carga un sujeto impositivo");

		if (this.getSujeto().getSujeto_impositivo().getCategib() == null)
			throw new ExceptionValidation(null, "El cliente no tiene cargado una categoría de IB");

		TasaPercIB tasaPercIB = TasaPercIB.getTasaVigentePercIB(getTomarPrimerConcIB(), this.getEmision(), this.getProvincia(), this
				.getSujeto().getSujeto_impositivo().getCategib(), getSesion());
		if (tasaPercIB == null)
			throw new ExceptionValidation(null, "No se pudo obtener la Cuenta Imputable de Perc. IB ");

		if (tasaPercIB.getCuentaImputable() == null)
			throw new ExceptionValidation(null, "No se encuentra cargada la Cuenta Imputable de Perc. IB");

		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(tasaPercIB.getCuentaImputable());
		if (this.isFacturaNotaDebito())
			renglon.setD_H(RenglonAsiento.HABER);
		else
			renglon.setD_H(RenglonAsiento.DEBE);
		renglon.setMonedaOri(getMoneda());
		renglon.setImporteOri(this.getPerc_ib());
		renglon.setCotizOri(this.getCotizacion());
		renglon.setComentario("");

		ImportesContables importesPercIB = this.getImportesContables(this.getPerc_ib(), this.getMoneda(), this.getImputac());

		renglon.setCotizMonExt1(importesPercIB.getValorCotizMonExt1());
		renglon.setCotizMonExt2(importesPercIB.getValorCotizMonExt2());

		renglon.setImpoLocHist(importesPercIB.getImpoMonLoc());
		renglon.setImpoLocAju(importesPercIB.getImpoMonLocAju());
		renglon.setImpoMonExt1(importesPercIB.getImpoMonExt1());
		renglon.setImpoMonExt2(importesPercIB.getImpoMonExt2());

	}

	protected void getRenglonPercIBBsAs(RenglonesAsiento renglones) throws BaseException {

		if (this.getPercIBBsAs() == null)
			return;

		if (this.getPercIBBsAs().doubleValue() == 0)
			return;

		ConceptoImpuesto concImpuPercIB = ConceptoImpuesto.getPercIBBsAs(this.getSesion());
		if (concImpuPercIB == null)
			throw new ExceptionValidation(null, "No se pudo obtener el concepto de Perc. IB de Bs. As.");

		if (concImpuPercIB.getCuentaImputable() == null)
			throw new ExceptionValidation(null, "No se pudo obtener la cuenta contable para el concepto " + concImpuPercIB.getDescripcion());

		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(concImpuPercIB.getCuentaImputable());
		if (this.isFacturaNotaDebito())
			renglon.setD_H(RenglonAsiento.HABER);
		else
			renglon.setD_H(RenglonAsiento.DEBE);
		renglon.setMonedaOri(getMoneda());
		renglon.setImporteOri(this.getPercIBBsAs());
		renglon.setCotizOri(this.getCotizacion());
		renglon.setComentario("");

		ImportesContables importesPercIB = this.getImportesContables(this.getPercIBBsAs(), this.getMoneda(), this.getImputac());

		renglon.setCotizMonExt1(importesPercIB.getValorCotizMonExt1());
		renglon.setCotizMonExt2(importesPercIB.getValorCotizMonExt2());

		renglon.setImpoLocHist(importesPercIB.getImpoMonLoc());
		renglon.setImpoLocAju(importesPercIB.getImpoMonLocAju());
		renglon.setImpoMonExt1(importesPercIB.getImpoMonExt1());
		renglon.setImpoMonExt2(importesPercIB.getImpoMonExt2());

	}

	protected void getRenglonesBonificacionRecargo(RenglonesAsiento renglones) throws BaseException {

		Iterator iterDetallesFacturas = this.detallesFactura.iterator();
		while (iterDetallesFacturas.hasNext()) {
			FacturaDet facturaDet = (FacturaDet) iterDetallesFacturas.next();

			Money precioListaSinIVA = facturaDet.getCalcImportePrecioListaSinIVA();

			if ((precioListaSinIVA == null) || (precioListaSinIVA.doubleValue() == 0))
				precioListaSinIVA = facturaDet.getNetoGravadoMasNetoNoGravado();

			// Al precio de lista sacarle la venta real
			CalculadorMoney calcBonifRecar = new CalculadorMoney(precioListaSinIVA);
			calcBonifRecar.restar(facturaDet.getNetoGravadoMasNetoNoGravado());

			int DEBE_HABER = 0;
			Money impoBonifRecar = new Money(0);

			if (calcBonifRecar.getResult() == 0)
				continue;
			else if (calcBonifRecar.getResult() > 0) {
				// Hubo una bonificacion
				if (this.isFacturaNotaDebito())
					DEBE_HABER = RenglonAsiento.DEBE;
				else
					DEBE_HABER = RenglonAsiento.HABER;
			} else {
				if (this.isFacturaNotaDebito())
					DEBE_HABER = RenglonAsiento.HABER;
				else
					DEBE_HABER = RenglonAsiento.DEBE;
				calcBonifRecar.multiplicarPor(new Money(-1));

			}

			impoBonifRecar = calcBonifRecar.getResultMoney();

			ImportesContables importes = this.getImportesContables(impoBonifRecar, this.getMoneda(), this.getImputac());

			RenglonAsiento renglon = renglones.addRenglonAsiento();
			if (DEBE_HABER == RenglonAsiento.DEBE)
				renglon.setCuentaImputable(CuentasParametrizadas.getImputableBonificacion(facturaDet, getSesion()));
			else
				renglon.setCuentaImputable(CuentasParametrizadas.getImputableRecargo(facturaDet, getSesion()));
			renglon.setD_H(DEBE_HABER);
			renglon.setMonedaOri(getMoneda());
			renglon.setImporteOri(impoBonifRecar);
			renglon.setCotizOri(this.getCotizacion());
			renglon.setComentario("");

			renglon.setCotizMonExt1(importes.getValorCotizMonExt1());
			renglon.setCotizMonExt2(importes.getValorCotizMonExt2());

			renglon.setImpoLocHist(importes.getImpoMonLoc());
			renglon.setImpoLocAju(importes.getImpoMonLocAju());
			renglon.setImpoMonExt1(importes.getImpoMonExt1());
			renglon.setImpoMonExt2(importes.getImpoMonExt2());

		}

	}

	public boolean getContabiliza() throws BaseException {
		if (this.isCargaFactComoAnulada()==true)
			return false;
		else {
			ValorParametro vpContabilizaFactura = ValorParametro.findByCodigoParametro("CONTABILIZA_FACT_VTAS", getSesion());
			return vpContabilizaFactura.getBoolean();
		}
	}

	private ConceptoImpuesto getTomarPrimerConcIB() throws BaseException {
		// Recorrer los productos
		Iterator iterDetFactura = detallesFactura.iterator();
		while (iterDetFactura.hasNext()) {
			FacturaDet facturaDet = (FacturaDet) iterDetFactura.next();
			ConceptoImpuesto concImpuPercIB = facturaDet.getProducto().getConcImpuPercIB(this.getEmision());
			if (concImpuPercIB != null)
				return concImpuPercIB;
		}
		return null;
	}

	public RenglonesStock getRenglonesStock() throws BaseException {

		RenglonesStock renglonesStock = new RenglonesStock();

		if (this.getTipoConfMovStkTalonario() == null)
			return renglonesStock;

		Iterator iterItemsFact = this.detallesFactura.iterator();
		while (iterItemsFact.hasNext()) {
			FacturaDet factDet = (FacturaDet) iterItemsFact.next();

			boolean hizoMovStock = false;

			Iterator iterMovStkTal = this.getTipoConfMovStkTalonario().getMoviStockTalonarios().iterator();
			while (iterMovStkTal.hasNext()) {
				MovStockTalonarioDeposito movStkTalDep = (MovStockTalonarioDeposito) iterMovStkTal.next();

				RenglonMovStock renglonMovStk = renglonesStock.addRenglonMovStock();
				renglonMovStk.setComproCab(this);
				renglonMovStk.setDeposito(movStkTalDep.getDeposito());
				if (movStkTalDep.getUbiDepoHabTalDefault() == null)
					throw new ExceptionValidation(null, "Falta Definir la ubicación Default para el Mov. de Stock "
							+ this.getTipoConfMovStkTalonario().getDescripcion());
				renglonMovStk.setUbicacionDeposito(movStkTalDep.getUbiDepoHabTalDefault().getUbicacion_deposito());
				renglonMovStk.setEstadoStock(movStkTalDep.getEstado_stock());
				renglonMovStk.setPartida(null);
				renglonMovStk.setSerie(null);
				renglonMovStk.setFecha(this.getEmision());

				if (factDet.getCantidad().doubleValue() < 0) {
					renglonMovStk.setCantidad(new Double(factDet.getCantidad().doubleValue() * -1));
					renglonMovStk.setSigno(new Integer(movStkTalDep.getSignoStock().intValue() * -1));
				} else {
					renglonMovStk.setCantidad(factDet.getCantidad());
					renglonMovStk.setSigno(movStkTalDep.getSignoStock());
				}

				renglonMovStk.setUnidadMedida(factDet.getUnidad_medida());
				renglonMovStk.setAfectaStockFisico(movStkTalDep.isAfectaStockFisico());
				renglonMovStk.setActivo(new Boolean(true));
				renglonMovStk.setProducto(factDet.getProducto());

				hizoMovStock = true;
				// Si es una Nota de Credito por Devolucion referida a un pedido
				// ,
				// Modificar las cantidades despachadas del pedido

			}

			if ((this.getTipoCompro().getIdentificacion().equals(IdentificacionTipoComprobante.COMPRO_NC_CLIENTE)) && (hizoMovStock)) {
				// Decrementar las cantidades despachas
				if ((factDet.getRemitoDet() != null) && (factDet.getRemitoDet().getPedidoDet() != null)) {

					// Decrementar las cantidades entregadas
					PedidoDet pedidoDet = PedidoDet.findByOid(factDet.getRemitoDet().getPedidoDet().getOIDInteger(), this.getSesion());
					CalculadorMoney acumCantDesp = new CalculadorMoney(new Money(pedidoDet.getCant_um_ori_desp().doubleValue()));
					acumCantDesp.restar(new Money(factDet.getCantidad()));
					pedidoDet.setCant_um_ori_desp(acumCantDesp.getResultDecimal());
					pedidoDet.save();

				}

			}

		}

		return renglonesStock;
	}

	public static List getFacturas(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde, java.util.Date fecHasta,
			Sujeto sujeto, Producto producto, ISesion aSesion) throws BaseException {
		return DBFacturaCab.getFacturas(nroExtDesde, nroExtHasta, fecDesde, fecHasta, sujeto, producto, aSesion);
	}

	public static List getFacturasyND(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde, java.util.Date fecHasta,
			Sujeto sujeto, ISesion aSesion) throws BaseException {
		return DBFacturaCab.getFacturasYND(nroExtDesde, nroExtHasta, fecDesde, fecHasta, sujeto, aSesion);
	}

	public static List getFacturasPorSeniaoAnt(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde, java.util.Date fecHasta,
			Sujeto sujeto, Producto producto, String oc, ISesion aSesion) throws BaseException {
		return DBFacturaCab.getFacturasPorSeniaOAnticipo(nroExtDesde, nroExtHasta, fecDesde, fecHasta, sujeto, producto, oc, aSesion);
	}

	public static boolean isPermitirFactVtaMosSinPrecio(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("ALLOW_FACT_PTO_VTA_PSP", aSesion).getBoolean();
	}

	public String getRemitosFacturados() throws BaseException {
		HashTableDatos listaRemitos = new HashTableDatos();
		String codigoRemito = "";
		Iterator iterAplicFactRem = AplicFacturadoRemito.getAplicRemitosFact(this, this.getSesion()).iterator();
		while (iterAplicFactRem.hasNext()) {
			AplicFacturadoRemito aplicFactRem = (AplicFacturadoRemito) iterAplicFactRem.next();
			codigoRemito = aplicFactRem.getRemito_det().getRemito_cab().getCodigo();
			if (listaRemitos.get(codigoRemito) == null)
				listaRemitos.put(codigoRemito, aplicFactRem.getRemito_det().getRemito_cab());
		}

		// Devolver los remitos
		StringBuffer remitos = new StringBuffer("");
		Iterator iterCodigosRemitos = listaRemitos.keySet().iterator();
		while (iterCodigosRemitos.hasNext()) {
			String codigo = (String) iterCodigosRemitos.next();
			if (remitos.length() != 0)
				remitos.append(" ");
			remitos.append(codigo);
		}

		return remitos.toString();
	}

	public PedidoCab getFirstPedido() throws BaseException {
		Iterator iterItemsFact = this.getItemsFactura().iterator();
		while (iterItemsFact.hasNext()) {
			FacturaDet facturaDet = (FacturaDet) iterItemsFact.next();
			if (facturaDet.getPedidoCab() != null)
				return facturaDet.getPedidoCab();
		}
		return null;
	}

	public static java.util.Date getFechaAUsarParaFacturar(ISesion aSesion) throws BaseException {
		Sucursal sucursal = Sucursal.findByOidProxy(aSesion.getLogin().getOidSucursal(), aSesion);
		FechaFacturacionSucursal fechaFactu = FechaFacturacionSucursal.getFechaFacturacion(sucursal, aSesion);
		if (fechaFactu == null)
			throw new ExceptionValidation(null, "No se pudo obtener la Fecha de Facturación");

		Date fechaFacturacion = fechaFactu.getFecha_actual();
		return fechaFacturacion;

	}

	public static Integer getTipoLinea1CabImpFact(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("TIPO_LINEA_1_CAB_IMP_FACT", aSesion).getValorEntero();
	}

	public static Integer getTipoLinea2CabImpFact(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("TIPO_LINEA_2_CAB_IMP_FACT", aSesion).getValorEntero();
	}

	public static Integer getTipoLinea3CabImpFact(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("TIPO_LINEA_3_CAB_IMP_FACT", aSesion).getValorEntero();
	}

	public static Integer getTipoLinea4CabImpFact(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("TIPO_LINEA_4_CAB_IMP_FACT", aSesion).getValorEntero();
	}

	public static Integer getTipoLinea5CabImpFact(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("TIPO_LINEA_5_CAB_IMP_FACT", aSesion).getValorEntero();
	}

	public static String getTxtLinea1CabImpFact(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("TXT_LINEA_1_CAB_IMP_FACT", aSesion).getValorCadena();
	}

	public static String getTxtLinea2CabImpFact(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("TXT_LINEA_2_CAB_IMP_FACT", aSesion).getValorCadena();
	}

	public static String getTxtLinea3CabImpFact(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("TXT_LINEA_3_CAB_IMP_FACT", aSesion).getValorCadena();
	}

	public static String getTxtLinea4CabImpFact(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("TXT_LINEA_4_CAB_IMP_FACT", aSesion).getValorCadena();
	}

	public static String getTxtLinea5CabImpFact(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("TXT_LINEA_5_CAB_IMP_FACT", aSesion).getValorCadena();
	}

	private static void addLinea(StringBuffer texto, PedidoCab pedido, String oc, Integer tipo) throws BaseException {
		if (tipo.intValue() == 1) { // Tratamiento Orden de compra
			if (oc != null)
				texto.append(oc);
		} else if (tipo.intValue() == 2) { // Tratamiento Orden de compra
		} else if (tipo.intValue() == 3) { // Tratamiento Pedido
			if (pedido != null)
				texto.append(pedido.getNroExt());
		}

	}

	public static String getLinea1CabImpFact(ISesion aSesion, PedidoCab pedido, String oc) throws BaseException {
		StringBuffer texto = new StringBuffer("");
		texto.append(getTxtLinea1CabImpFact(aSesion));
		Integer tipo = getTipoLinea1CabImpFact(aSesion);
		addLinea(texto, pedido, oc, tipo);
		return texto.toString().trim();
	}

	public static String getLinea2CabImpFact(ISesion aSesion, PedidoCab pedido, String oc) throws BaseException {
		StringBuffer texto = new StringBuffer("");
		texto.append(getTxtLinea2CabImpFact(aSesion));
		Integer tipo = getTipoLinea2CabImpFact(aSesion);
		addLinea(texto, pedido, oc, tipo);
		return texto.toString().trim();
	}

	public static String getLinea3CabImpFact(ISesion aSesion, PedidoCab pedido, String oc) throws BaseException {
		StringBuffer texto = new StringBuffer("");
		texto.append(getTxtLinea3CabImpFact(aSesion));
		Integer tipo = getTipoLinea3CabImpFact(aSesion);
		addLinea(texto, pedido, oc, tipo);
		return texto.toString().trim();
	}

	public static String getLinea4CabImpFact(ISesion aSesion, PedidoCab pedido, String oc) throws BaseException {
		StringBuffer texto = new StringBuffer("");
		texto.append(getTxtLinea4CabImpFact(aSesion));
		Integer tipo = getTipoLinea4CabImpFact(aSesion);
		addLinea(texto, pedido, oc, tipo);
		return texto.toString().trim();
	}

	public static String getLinea5CabImpFact(ISesion aSesion, PedidoCab pedido, String oc) throws BaseException {
		StringBuffer texto = new StringBuffer("");
		texto.append(getTxtLinea5CabImpFact(aSesion));
		Integer tipo = getTipoLinea5CabImpFact(aSesion);
		addLinea(texto, pedido, oc, tipo);
		return texto.toString().trim();
	}

	public static String getCarpetaRTMFacturas(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("CARPETA_REPO_RTM_FACTURAS", aSesion).getValorCadena();
	}

	public void anular() throws BaseException {

		anuladorFactCab = (AnuladorFactCab) AnuladorFactCab.getNew(AnuladorFactCab.NICKNAME, getSesion());
		anuladorFactCab.setFactura_cab(this);
		anuladorFactCab.generarComproAnulacion();
		anuladorFactCab.save();

	}

	public static FacturaCab buscarFacturaPor(TipoComprobante tc, String letra, LugarEmision lugEmi, Integer nroExt, boolean activo,
			ISesion aSesion) throws BaseException {

		// Traer el tipo de comprobante default
		if (tc == null)
			tc = FacturaCab.getTCFacturaDefBuscador(aSesion);

		if (letra == null)
			letra = FacturaCab.getLetraDefaultFactura(aSesion);

		if (lugEmi == null)
			lugEmi = FacturaCab.getLugarEmisionDefaultFactura(aSesion);

		if (nroExt == null)
			throw new ExceptionValidation(null, "Debe ingresar el Nro. del comprobante");

		return FacturaCab.getFacturaCab(tc, letra, lugEmi, nroExt, activo, aSesion);

	}

	public static FacturaCab buscarFacturaByCodigo(String codigo, boolean activa, ISesion sesion) throws BaseException {

		String formatoDesconocido = "Formato de código de comprobante Factura desconocido. Ejemplos Válidos: FAC-A-1-123 ; A-123 ; 1-123; FAC-123 ; A-1-123";

		TipoComprobante tc = null;
		String letra = null;
		LugarEmision lugEmi = null;
		Integer nroExt = null;

		FacturaCab factura = null;

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
						throw new ExceptionValidation(null, "Tipo de comprobante inexistente:" + listaCodigos[0]);
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
					throw new ExceptionValidation(null, "Código de tipo de comprobante inexistente:" + codTC);
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

		return FacturaCab.buscarFacturaPor(tc, letra, lugEmi, nroExt, activa, sesion);

	}

	public static TipoComprobante getTCFacturaDefBuscador(ISesion aSesion) throws BaseException {
		return TipoComprobante.getTCFacturaDefBuscador(aSesion);
	}

	public static String getLetraDefaultFactura(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("LETRA_COMPRO_DEF_FACT", aSesion).getValorCadena();
	}

	public static LugarEmision getLugarEmisionDefaultFactura(ISesion aSesion) throws BaseException {
		return LugarEmision.getLugarEmisionDefaultFactura(aSesion);
	}

	public static FacturaCab getFacturaCab(TipoComprobante tc, String letra, LugarEmision le, Integer nroExt, boolean activo,
			ISesion aSesion) throws BaseException {

		return DBFacturaCab.getFacturaCab(tc, letra, le, nroExt, activo, aSesion);
	}

	public List getAplicacionesActivasCompro() throws BaseException {
		return AplicClieVto.getAplicacionesActivasCompro(this, this.getSesion());
	}

	public List getAplicacionesActivasDelCompro() throws BaseException {
		return AplicClieVto.getAplicacionesActivasDelCompro(this, this.getSesion());
	}
	
	  public static void updateTipoImpresion(FacturaCab factura,
			  String tipoImpresion,
		      ISesion aSesion)
		  throws BaseException {
			 DBFacturaCab.updateTipoImpresion(factura,tipoImpresion,aSesion);
	  }

	

}
