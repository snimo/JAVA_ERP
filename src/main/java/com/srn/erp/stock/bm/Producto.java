package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.AcuerdoLPDetalle;
import com.srn.erp.compras.bm.OCTomarPreciosDe;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.contabilidad.bm.AtributoEnGrupo;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadFijo;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoHabilitadoEntidad;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.FactorConversion;
import com.srn.erp.general.bm.IEntidadClasificable;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Precio;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TasaIVA;
import com.srn.erp.stock.da.DBCostoProducto;
import com.srn.erp.stock.da.DBProducto;
import com.srn.erp.ventas.bm.CalculadorItemVenta;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.ConfProdPorLP;
import com.srn.erp.ventas.bm.EsquemaBonificacionVigSuj;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosDet;
import com.srn.erp.ventas.bm.PrecioEnLP;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorCotizacion;
import framework.applicarionServer.bm.Varios.CalculadorDecimal;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Decimal;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Producto extends ObjetoLogico implements IEntidadClasificable  {

	public Producto() {
	}

	public static String NICKNAME = "st.Producto";

	private String codigo;

	private String descripcion;

	private String desc_abrev;

	private Boolean comprable;

	private Boolean vendible;

	private Boolean stockeable;

	private Boolean prod_propia;

	private Boolean importado;

	private Boolean modifPrecioFactura;

	private String sinonimo;

	private Boolean seguimientoStock;

	private String codigo_barra;

	private UnidadMedida um_vta;

	private UnidadMedida um_stk;

	private UnidadMedida um_stk_alt;

	private UnidadMedida um_cpra;

	private UnidadMedida um_prod;

	private Money tolerancia_recep;

	private Money porc_cump_oc;

	private Boolean sistema_calidad;

	private Cuenta cuenta_cpra;

	private Boolean modif_ai_cpra;

	private Boolean activo;

	private TipoProducto tipoProducto;

	private Integer lt_entrega;

	private ConcFactProv concFactProv;

	private Boolean llevaPartida;

	private Boolean llevaSerie;

	private Integer nro;

	private CuentaImputable cuentaVta;

	private AtributosProducto atributosProducto;

	private Collection listaAtributos = null;

	private List costosProducto = new ArrayList();

	private boolean readCostosProducto = true;

	private List productosProveedor = new ArrayList();

	private boolean readProductosProveedor = true;

	private List confProdPorLP = new ArrayList();

	private boolean readConfProdPorLP = true;

	private List conceptosImpuestos = new ArrayList();

	private boolean readConceptosImpuestos = true;

	private List conversionesUM = new ArrayList();

	private boolean readConversionesUM = true;

	private Hashtable listaOidValClasif = new Hashtable();

	private Integer cantDecPrecioVta;

	private Integer leadTimeVta;

	private String descSearch;

	private boolean precioNoDefLP;

	private boolean habilitadaNotaDebitoInterna;

	private boolean habilitadaNotaCreditoInterna;

	private boolean calcPercIBBsAs;

	private boolean calcPercIBCapFed;

	private boolean calcPercIVA;

	private boolean seUsaParaSaldoPendFactSenia;

	private boolean esSeniaFactura;
	
	private boolean noRealizarValClasif;
	
	private String tomarPrecioOC1;
	
	private String tomarPrecioOC2;
	
	private String tomarPrecioOC3;
	
	private String tomarPrecioOC4;
	
	private String formaCalcCosto;
	
	private Proveedor proveedorCosto;

	private List seguimientosStock = new ArrayList();
	private boolean readSeguimientoStock = true;

	public void setDescSearc(String aDescSearch) throws BaseException {
		this.descSearch = aDescSearch;
	}

	public String getDescSearch() throws BaseException {
		this.supportRefresh();
		return this.descSearch;
	}
	
	public void setProveedorCosto(Proveedor aProveedor) throws BaseException {
		this.proveedorCosto = aProveedor;
	}

	public Proveedor getProveedorCosto() throws BaseException {
		this.supportRefresh();
		return this.proveedorCosto;
	}
	
	
	public void setFormaCalcCosto(String aFormaCalcCosto) throws BaseException {
		this.formaCalcCosto = aFormaCalcCosto;
	}

	public String getFormaCalcCosto() throws BaseException {
		this.supportRefresh();
		return this.formaCalcCosto;
	}
	
	
	public void setTomarPrecioOC1(String aTomarPrecioOC1) throws BaseException {
		this.tomarPrecioOC1 = aTomarPrecioOC1;
	}

	public String getTomarPrecioOC1() throws BaseException {
		this.supportRefresh();
		return this.tomarPrecioOC1;
	}
	
	public void setTomarPrecioOC2(String aTomarPrecioOC2) throws BaseException {
		this.tomarPrecioOC2 = aTomarPrecioOC2;
	}

	public String getTomarPrecioOC2() throws BaseException {
		this.supportRefresh();
		return this.tomarPrecioOC2;
	}
	
	public void setTomarPrecioOC3(String aTomarPrecioOC3) throws BaseException {
		this.tomarPrecioOC3 = aTomarPrecioOC3;
	}

	public String getTomarPrecioOC3() throws BaseException {
		this.supportRefresh();
		return this.tomarPrecioOC3;
	}
	
	public void setTomarPrecioOC4(String aTomarPrecioOC4) throws BaseException {
		this.tomarPrecioOC4 = aTomarPrecioOC4;
	}

	public String getTomarPrecioOC4() throws BaseException {
		this.supportRefresh();
		return this.tomarPrecioOC4;
	}
	
	public void setIsSeniaFactura(Boolean aIsSeniaFactura) throws BaseException {
		this.esSeniaFactura = aIsSeniaFactura;
	}

	public Boolean isSeniaFactura() throws BaseException {
		this.supportRefresh();
		return this.esSeniaFactura;
	}

	public Boolean isModifPrecioFactura() throws BaseException {
		this.supportRefresh();
		return this.modifPrecioFactura;
	}

	public void setModifPrecioFactura(Boolean aModifPrecioFactura)
			throws BaseException {
		this.modifPrecioFactura = aModifPrecioFactura;
	}

	public Boolean isSeUsaParaSaldoPendFactSenia() throws BaseException {
		this.supportRefresh();
		return this.seUsaParaSaldoPendFactSenia;
	}

	public void setUsaParaSaldoPendFactSenia(Boolean aUsaParaSaldoPendFactSenia)
			throws BaseException {
		this.seUsaParaSaldoPendFactSenia = aUsaParaSaldoPendFactSenia;
	}

	public void setCalcPercIBBsAs(boolean aCalcPercIBBsAs) throws BaseException {
		this.calcPercIBBsAs = aCalcPercIBBsAs;
	}

	public boolean isCalcPercIBBsAs() throws BaseException {
		this.supportRefresh();
		return this.calcPercIBBsAs;
	}

	public void setCalcPercIVA(boolean aCalcPercIVA) throws BaseException {
		this.calcPercIVA = aCalcPercIVA;
	}

	public boolean isCalcPercIVA() throws BaseException {
		this.supportRefresh();
		return this.calcPercIVA;
	}

	public void setCalcPercIBCapFed(boolean aCalcPercIBCapFed)
			throws BaseException {
		this.calcPercIBCapFed = aCalcPercIBCapFed;
	}

	public boolean isCalcPercIBCapFed() throws BaseException {
		this.supportRefresh();
		return this.calcPercIBCapFed;
	}

	public void setSeguimientoStock(Boolean aSeguimientoStock)
			throws BaseException {
		this.seguimientoStock = aSeguimientoStock;
	}

	public Boolean isSeguimientoStock() throws BaseException {
		this.supportRefresh();
		return this.seguimientoStock;
	}

	public void setPrecioNoDefLP(boolean aPrecioNoDefLP) throws BaseException {
		this.precioNoDefLP = aPrecioNoDefLP;
	}

	public boolean isPrecioNoDefLP() throws BaseException {
		this.supportRefresh();
		return this.precioNoDefLP;
	}

	public void setHabilitadaNotaDebitoInterna(boolean aHabNDInt)
			throws BaseException {
		this.habilitadaNotaDebitoInterna = aHabNDInt;
	}

	public boolean isHabilitadaNotaDebitoInterna() throws BaseException {
		this.supportRefresh();
		return this.habilitadaNotaDebitoInterna;
	}

	public void setHabilitadaNotaCreditoInterna(boolean aHabNDInt)
			throws BaseException {
		this.habilitadaNotaCreditoInterna = aHabNDInt;
	}

	public boolean isHabilitadaNotaCreditoInterna() throws BaseException {
		this.supportRefresh();
		return this.habilitadaNotaCreditoInterna;
	}

	public void addOidValorClasif(Integer nroClasif, Integer aValor) {
		if (aValor == null)
			listaOidValClasif.put(nroClasif, new Integer(0));
		else
			listaOidValClasif.put(nroClasif, aValor);
	}

	public Integer getOidValorClasif(Integer nroClasif) throws BaseException {
		supportRefresh();
		return (Integer) listaOidValClasif.get(nroClasif);
	}

	public IValorClasificadorEntidad getValorClasifEnt(
			ClasificadorEntidad clasifEnt) throws BaseException {
		if (clasifEnt == null)
			return null;
		
		
		if (clasifEnt.getNickname().equals(ExtensionProdGen.NICKNAME)) {
			supportRefresh();
			if (this.getValorClasifProdGen()==null) return null;
			return this.getValorClasifProdGen().getValorClasifEnt(clasifEnt);
		}
		
		if (!clasifEnt.getNickname().equals(Producto.NICKNAME))
			throw new ExceptionValidation(null,"El clasificador "+clasifEnt.getDescripcion()+" no corresponde al producto.");

		
		supportRefresh();
		ValorClasificadorEntidad valClasifEnt = null;
		Integer oidValClasifEnt = (Integer) listaOidValClasif.get(clasifEnt
				.getNroClasif());
		if (oidValClasifEnt != null)
			valClasifEnt = ValorClasificadorEntidad.findByOid(oidValClasifEnt,
					getSesion());
		return valClasifEnt;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setConcFactProv(ConcFactProv aConcFactProv)
			throws BaseException {
		this.concFactProv = aConcFactProv;
	}

	public Integer getNro() throws BaseException {
		supportRefresh();
		return nro;
	}

	public void setCantDecPrecioVta(Integer aCantDecPrecioVta)
			throws BaseException {
		this.cantDecPrecioVta = aCantDecPrecioVta;
	}

	public Integer getCantDecPrecioVta() throws BaseException {
		supportRefresh();
		return this.cantDecPrecioVta;
	}

	public void setNro(Integer aNro) throws BaseException {
		this.nro = aNro;
	}

	public CuentaImputable getCuentaVenta() throws BaseException {
		supportRefresh();
		return this.cuentaVta;
	}

	public AtributosProducto getValoresAtributos() throws BaseException {
		supportRefresh();
		if (this.atributosProducto != null)
			return this.atributosProducto;
		this.atributosProducto = AtributosProducto.getAtributosProducto(this,
				this.getSesion());
		if (this.atributosProducto == null) {
			this.atributosProducto = (AtributosProducto) AtributosProducto
					.getNew(AtributosProducto.NICKNAME, this.getSesion());
			this.atributosProducto.setProducto(this);
		}
		return this.atributosProducto;
	}

	public void setCuentaVenta(CuentaImputable aCuentaVenta)
			throws BaseException {
		this.cuentaVta = aCuentaVenta;
	}

	public ConcFactProv getConcFactProv() throws BaseException {
		supportRefresh();
		return concFactProv;
	}

	public ConcFactProv getConcFactProvCorrespondiente() throws BaseException {

		ConcFactProv concFactProv = getConcFactProv();
		if (concFactProv != null)
			return concFactProv;

		ValorClasifEntProdGen valorClasifEntProdGen = getValorClasifProdGen();

		if (valorClasifEntProdGen != null)
			if (valorClasifEntProdGen.getExtensionProdGen() != null)
				if (valorClasifEntProdGen.getExtensionProdGen()
						.getConc_fact_prov() != null)
					return valorClasifEntProdGen.getExtensionProdGen()
							.getConc_fact_prov();

		return ConcFactProv.getConcFactProvDefProd(this.getSesion());
	}

	public ValorClasifEntProdGen getValorClasifProdGen() throws BaseException {

		ClasificadorEntidad clasif = getClasifProductoGeneral(this.getSesion());
		if (clasif == null)
			return null;

		IValorClasificadorEntidad valor = this.getValorClasifEnt(clasif);
		if (valor == null)
			return null;

		ValorClasifEntProdGen valorClasifEntProdGen = ValorClasifEntProdGen
				.findByOidProxy(valor.getOID(), this.getSesion());

		return valorClasifEntProdGen;

	}

	public void setLeadTimeVta(Integer aLeadTimeVta) throws BaseException {
		this.leadTimeVta = aLeadTimeVta;
	}

	public void setLlevaPartida(Boolean aLlevaPartida) throws BaseException {
		this.llevaPartida = aLlevaPartida;
	}

	public Boolean isLlevaPartida() throws BaseException {
		supportRefresh();
		return llevaPartida;
	}

	public void setLlevaSerie(Boolean aLlevaSerie) throws BaseException {
		this.llevaSerie = aLlevaSerie;
	}

	public Boolean isLlevaSerie() throws BaseException {
		supportRefresh();
		return llevaSerie;
	}

	public void setCodigo(String aCodigo) {
		if (aCodigo != null)
			this.codigo = aCodigo.toUpperCase();
		else
			this.codigo = null;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public Integer getLeadTimeVta() throws BaseException {
		supportRefresh();
		return this.leadTimeVta;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
		if (descripcion != null)
			this.descSearch = descripcion.toUpperCase();
		else
			this.descSearch = null;
	}

	public String getDesc_abrev() throws BaseException {
		supportRefresh();
		return desc_abrev;
	}

	public void setDesc_abrev(String aDesc_abrev) {
		this.desc_abrev = aDesc_abrev;
	}

	public Boolean isComprable() throws BaseException {
		supportRefresh();
		return comprable;
	}

	public void setComprable(Boolean aComprable) {
		this.comprable = aComprable;
	}

	public Boolean isVendible() throws BaseException {
		supportRefresh();
		return vendible;
	}

	public void setVendible(Boolean aVendible) {
		this.vendible = aVendible;
	}

	public Boolean isStockeable() throws BaseException {
		supportRefresh();
		if (stockeable != null)
			return stockeable;
		else
			return new Boolean(false);
	}

	public void setStockeable(Boolean aStockeable) {
		this.stockeable = aStockeable;
	}

	public Boolean isProd_propia() throws BaseException {
		supportRefresh();
		return prod_propia;
	}

	public void setProd_propia(Boolean aProd_propia) {
		this.prod_propia = aProd_propia;
	}

	public Boolean isImportado() throws BaseException {
		supportRefresh();
		return importado;
	}

	public void setImportado(Boolean aImportado) {
		this.importado = aImportado;
	}

	public String getSinonimo() throws BaseException {
		supportRefresh();
		return sinonimo;
	}

	public void setSinonimo(String aSinonimo) {
		this.sinonimo = aSinonimo;
	}

	public String getCodigo_barra() throws BaseException {
		supportRefresh();
		return codigo_barra;
	}

	public void setCodigo_barra(String aCodigo_barra) {
		this.codigo_barra = aCodigo_barra;
	}

	public UnidadMedida getUm_vta() throws BaseException {
		supportRefresh();
		return um_vta;
	}

	public void setUm_vta(UnidadMedida aUm_vta) {
		this.um_vta = aUm_vta;
	}

	public UnidadMedida getUm_stk() throws BaseException {
		supportRefresh();
		return um_stk;
	}

	public void setUm_stk(UnidadMedida aUm_stk) {
		this.um_stk = aUm_stk;
	}

	public UnidadMedida getUm_stk_alt() throws BaseException {
		supportRefresh();
		return um_stk_alt;
	}

	public void setUm_stk_alt(UnidadMedida aUm_stk_alt) {
		this.um_stk_alt = aUm_stk_alt;
	}

	public UnidadMedida getUm_cpra() throws BaseException {
		supportRefresh();
		return um_cpra;
	}

	public void setUm_cpra(UnidadMedida aUm_cpra) {
		this.um_cpra = aUm_cpra;
	}

	public UnidadMedida getUm_prod() throws BaseException {
		supportRefresh();
		return um_prod;
	}

	public void setUm_prod(UnidadMedida aUm_prod) {
		this.um_prod = aUm_prod;
	}

	public Money getTolerancia_recep() throws BaseException {
		supportRefresh();
		return tolerancia_recep;
	}

	public void setTolerancia_recep(Money aTolerancia_recep) {
		this.tolerancia_recep = aTolerancia_recep;
	}

	public Money getPorc_cump_oc() throws BaseException {
		supportRefresh();
		return porc_cump_oc;
	}

	public void setPorc_cump_oc(Money aPorc_cump_oc) {
		this.porc_cump_oc = aPorc_cump_oc;
	}

	public Boolean isSistema_calidad() throws BaseException {
		supportRefresh();
		if (sistema_calidad == null)
			return new Boolean(false);
		else
			return sistema_calidad;
	}

	public void setSistema_calidad(Boolean aSistema_calidad) {
		this.sistema_calidad = aSistema_calidad;
	}

	public Cuenta getCuenta_cpra() throws BaseException {
		supportRefresh();
		return cuenta_cpra;
	}

	public void setCuenta_cpra(Cuenta aCuenta_cpra) {
		this.cuenta_cpra = aCuenta_cpra;
	}

	public Boolean isModif_ai_cpra() throws BaseException {
		supportRefresh();
		return modif_ai_cpra;
	}

	public void setModif_ai_cpra(Boolean aModif_ai_cpra) {
		this.modif_ai_cpra = aModif_ai_cpra;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public TipoProducto getTipoproducto() throws BaseException {
		supportRefresh();
		return tipoProducto;
	}

	public void setTipoproducto(TipoProducto aTipoproducto) {
		this.tipoProducto = aTipoproducto;
	}

	public Integer getLt_entrega() throws BaseException {
		supportRefresh();
		return lt_entrega;
	}

	public void setLt_entrega(Integer aLt_entrega) {
		this.lt_entrega = aLt_entrega;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static Producto findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Producto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Producto findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Producto) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Producto findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {

		// Buscar por codigo
		Producto producto = (Producto) getObjectByCodigo(NICKNAME, codigo,
				aSesion);

		// Si no lo encontro buscar por codigo de barra
		if (producto == null)
			producto = Producto.getProductoByCodigoBarra(codigo, aSesion);

		// Si no lo encuentra buscar por sinonimo
		if (producto == null)
			producto = Producto.getProductoBySinonimo(codigo, aSesion);

		return producto;
	}

	public static Producto buscarProducto(String codigo, ISesion aSesion)
			throws BaseException {
		if (isCodigoNumerico(aSesion))
			validarCodigoNumerico(codigo);
		return (Producto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public List getProductosProveedor() throws BaseException {
		if (readProductosProveedor) {
			List listaProductosProveedor = ProductoProveedor
					.getProductosProveedor(this, getSesion());
			productosProveedor.addAll(listaProductosProveedor);
			readProductosProveedor = false;
		}
		return productosProveedor;
	}

	public List getCostosProducto() throws BaseException {
		if (readCostosProducto) {
			List listaCostosProducto = CostoProducto.getCostosProducto(this,
					getSesion());
			costosProducto.addAll(listaCostosProducto);
			this.readCostosProducto = false;
		}
		return costosProducto;
	}

	public List getConversionesUM() throws BaseException {
		if (readConversionesUM) {
			List listaConversionesUM = ConversionUMProducto
					.getConversionesUMProducto(this, getSesion());
			conversionesUM.addAll(listaConversionesUM);
			readConversionesUM = false;
		}
		return conversionesUM;
	}

	public List getConceptosImpuestos() throws BaseException {
		if (readConceptosImpuestos) {
			List listaConceptosImpuestos = ConceptoImpuestoProducto
					.getConceptosImpuestosProducto(this, getSesion());
			conceptosImpuestos.addAll(listaConceptosImpuestos);
			readConceptosImpuestos = false;
		}
		return conceptosImpuestos;
	}

	public void addConversionUM(ConversionUMProducto aConversionUMProducto)
			throws BaseException {
		aConversionUMProducto.setProducto(this);
		conversionesUM.add(aConversionUMProducto);
	}

	public void addProductoProveedor(ProductoProveedor aProductoProveedor)
			throws BaseException {
		aProductoProveedor.setProducto(this);
		productosProveedor.add(aProductoProveedor);
	}

	public void addConfProdPorLP(ConfProdPorLP aConfProdPorLP)
			throws BaseException {
		aConfProdPorLP.setProducto(this);
		confProdPorLP.add(aConfProdPorLP);
	}

	public void addCostoProducto(CostoProducto aCostoProducto)
			throws BaseException {
		aCostoProducto.setProducto(this);
		costosProducto.add(aCostoProducto);
	}

	public void addConceptoImpuesto(
			ConceptoImpuestoProducto aConceptoImpuestoProducto)
			throws BaseException {
		aConceptoImpuestoProducto.setProducto(this);
		conceptosImpuestos.add(aConceptoImpuestoProducto);
	}

	public ConceptoImpuestoProducto getFirstConceptoImpuestoProducto()
			throws BaseException {
		if (conceptosImpuestos.size() > 0)
			return (ConceptoImpuestoProducto) conceptosImpuestos.get(0);
		else
			return null;
	}

	public void afterSave() throws BaseException {

		Iterator iterProductosProveedor = productosProveedor.iterator();
		while (iterProductosProveedor.hasNext()) {
			ProductoProveedor productoProveedor = (ProductoProveedor) iterProductosProveedor
					.next();
			productoProveedor.save();
			productoProveedor = null;
		}
		iterProductosProveedor = null;

		Iterator iterConfProdPorLP = this.confProdPorLP.iterator();
		while (iterConfProdPorLP.hasNext()) {
			ConfProdPorLP condProdPorLP = (ConfProdPorLP) iterConfProdPorLP
					.next();
			condProdPorLP.save();
			condProdPorLP = null;
		}
		iterConfProdPorLP = null;

		Iterator iterConceptosImpuestos = conceptosImpuestos.iterator();
		while (iterConceptosImpuestos.hasNext()) {
			ConceptoImpuestoProducto conceptoImpuestoProducto = (ConceptoImpuestoProducto) iterConceptosImpuestos
					.next();

			// Si ya existe un conceto IVA para el producto y esa fecha entonces
			// reemplazarlo
			if (conceptoImpuestoProducto.getConcepto_impuesto().getImpuesto()
					.isIVA()) {
				ConceptoImpuestoProducto concImpuIVA = ConceptoImpuestoProducto
						.getConcImpuProdIVA(conceptoImpuestoProducto
								.getProducto(), conceptoImpuestoProducto
								.getFecha_vigencia(), this.getSesion());
				if (concImpuIVA != null) {
					concImpuIVA.setConcepto_impuesto(conceptoImpuestoProducto
							.getConcepto_impuesto());
					concImpuIVA.save();
					continue;
				}
			}

			conceptoImpuestoProducto.save();
			conceptoImpuestoProducto = null;
		}
		iterConceptosImpuestos = null;

		Iterator iterConversionesUM = conversionesUM.iterator();
		while (iterConversionesUM.hasNext()) {
			ConversionUMProducto convUMProd = (ConversionUMProducto) iterConversionesUM
					.next();
			convUMProd.save();
			convUMProd = null;
		}
		iterConversionesUM = null;

		Iterator iterCostosProducto = costosProducto.iterator();
		while (iterCostosProducto.hasNext()) {
			CostoProducto costoProducto = (CostoProducto) iterCostosProducto
					.next();
			costoProducto.save();
			costoProducto = null;
		}
		iterCostosProducto = null;

		// Grabar Atributos del Producto
		this.getValoresAtributos().save();

		Iterator iterSeguimientoStock = seguimientosStock.iterator();
		while (iterSeguimientoStock.hasNext()) {
			SeguimientoStock seguimientoStock = (SeguimientoStock) iterSeguimientoStock
					.next();
			seguimientoStock.save();
			seguimientoStock = null;
		}
		iterSeguimientoStock = null;

	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(desc_abrev, "Debe ingresar la Descripción Abreviada");
		Validar.noNulo(comprable, "Debe indicar si es comprable");
		Validar.noNulo(vendible, "Debe indicar si es vendible");
		Validar.noNulo(stockeable, "Debe indicar si lleva stock");
		Validar.noNulo(prod_propia, "Debe indicar si se produce");
		Validar.noNulo(importado, "Debe indicar si es importado");
		Validar.noNulo(tipoProducto, "Debe ingresar el Tipo de Producto");

		Producto.validarComposicionCodigo(codigo, getSesion());
		if (isVendible().booleanValue())
			Validar
					.noNulo(um_vta,
							"Debe ingresar la Unidad de Medida de Venta");

		if (isStockeable().booleanValue())
			Validar
					.noNulo(um_stk,
							"Debe ingresar la Unidad de Medida de Stock");

		if (isComprable().booleanValue())
			Validar.noNulo(um_cpra,
					"Debe ingresar la Unidad de Medida de Compra");

		if (isProd_propia().booleanValue())
			Validar.noNulo(um_prod,
					"Debe ingresar la Unidad de Medida de Producción");

		if (isNew() && (isActivo().booleanValue() == false))
			Validar.mensajeValidacion("El Producto debe estar en modo activo");

		// Validar que el Código sea Unico
		Producto producto = Producto.getProductoByCodigoyDistintoOid(
				this.codigo, this.getOIDInteger(), this.getSesion());
		if (producto != null)
			throw new ExceptionValidation(null, "Código de producto Duplicado:"
					+ producto.getCodigo());
		
		if (!noRealizarValidacionClasif()) {
			Iterator iterClasifAct = this.getClasificadoresEntidadActivos().iterator();
			while (iterClasifAct.hasNext()) {
				ClasificadorEntidad clasif = (ClasificadorEntidad) iterClasifAct.next();
				if (clasif.isObligatorio()) {
					if (this.getValorClasifEnt(clasif)==null)
						throw new ExceptionValidation(null,"Debe ingresar el valor del clasificador "+clasif.getDescripcion()+" del producto "+this.getCodigo()+" - "+this.getDescripcion());
				}
			}
		}

	}

	public static List getHelpProductos(HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {

		return DBProducto.getHelpProductos(condiciones, aSesion);
	}
	
	public static List getHelpProductosALL(HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {

		return DBProducto.getHelpProductosAll(condiciones, aSesion);
	}


	public ListaPreciosDet getListaPreciosDet(ListaPrecios listaPrecios)
			throws BaseException {
		return listaPrecios.getListaPreciosDet(this);
	}

	public PrecioEnLP getPrecioLista(ListaPrecios listaPrecios, UnidadMedida um)
			throws BaseException {
		return listaPrecios.getPrecioLista(this);
	}

	public PrecioEnLP getPrecioListaSinIVA(ListaPrecios listaPrecios,
			UnidadMedida um, java.util.Date fecha) throws BaseException {
		return listaPrecios.getPrecioListaSinIVA(this, fecha);
	}

	public PrecioEnLP getPrecioListaConIVA(ListaPrecios listaPrecios,
			UnidadMedida um, java.util.Date fecha) throws BaseException {
		return listaPrecios.getPrecioListaConIVA(this, fecha);
	}

	public PrecioEnLP getPrecioFactura(ListaPrecios listaPrecios,
			Sujeto sujeto, java.util.Date fecha) throws BaseException {
		return CalculadorItemVenta.getPrecioAMostrar(listaPrecios, this,
				sujeto, fecha);

	}

	public Decimal convertir(Decimal cantidad, UnidadMedida uniMedOri,
			UnidadMedida uniMedDest) throws BaseException {
		ConversionUMProducto concUMProducto = ConversionUMProducto
				.getByProductoUMOriUMDest(this, uniMedOri, uniMedDest,
						getSesion());
		if (concUMProducto != null) {
			CalculadorCotizacion calcConv = new CalculadorCotizacion(
					new NumeroBase(cantidad.doubleValue()));
			calcConv.multiplicarPor(new NumeroBase(concUMProducto
					.getFact_conv()));
			return new Decimal(calcConv.getResult());
		} else {
			FactorConversion factConv = FactorConversion.getFactConv(uniMedOri,
					uniMedDest, getSesion());
			if (factConv != null) {
				CalculadorCotizacion calcConv = new CalculadorCotizacion(
						new NumeroBase(cantidad.doubleValue()));
				calcConv.multiplicarPor(new NumeroBase(factConv.getFactor()));
				return new Decimal(calcConv.getResult());
			} else
				return null;
		}
	}

	public SaldoStockProducto getSaldoStock(Deposito deposito)
			throws BaseException {
		return SaldoStockProducto.getSaldoStockProducto(this, deposito,
				getSesion());
	}

	protected void onNew() throws BaseException {
		for (int i = 1; i <= 20; ++i)
			addOidValorClasif(new Integer(i), new Integer(0));
	}

	public List getClasificadoresEntidad() throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidad(Producto.NICKNAME,
				true, getSesion());
	}
	
	
	public List getClasificadoresEntidadActivos() throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidadActivos(Producto.NICKNAME,
				true, getSesion());
	}
	

	public static List getClasificadoresEntidad(ISesion aSesion)
			throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidad(Producto.NICKNAME,
				true, aSesion);
	}
	
	public static List getClasificadoresEntidadActivos(ISesion aSesion)
	throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidadActivos(Producto.NICKNAME,
		true, aSesion);
	}	

	public ConceptoImpuesto getConcImpuIVA(java.util.Date aFechaVigencia)
			throws BaseException {
		ConceptoImpuestoProducto concImpuProd = ConceptoImpuestoProducto
				.getConcImpuProdIVA(this, aFechaVigencia, getSesion());
		if (concImpuProd != null) {
			return concImpuProd.getConcepto_impuesto();
		} else {
			// Concepto de Impuesto
			if (this.getValorClasifProdGen()==null)
				return null;
			else {
				concImpuProd = this.getValorClasifProdGen().getConcImpuIVAProdVigAFecha(aFechaVigencia);
				if (concImpuProd!=null)
					return concImpuProd.getConcepto_impuesto();
				else
					return null;
			}
		}
	}

	public ConceptoImpuestoProducto getConcImpuIVAProducto(
			java.util.Date aFechaVigencia) throws BaseException {
		ConceptoImpuestoProducto concImpuProd = ConceptoImpuestoProducto
				.getConcImpuProdIVA(this, aFechaVigencia, getSesion());
		if (concImpuProd == null)
			return null;
		else
			return concImpuProd;
	}

	public ConceptoImpuesto getConcImpuPercIVA(java.util.Date aFechaVigencia)
			throws BaseException {
		ConceptoImpuestoProducto concImpuProd = ConceptoImpuestoProducto
				.getConcImpuProdPercIVA(this, aFechaVigencia, getSesion());
		if (concImpuProd != null)
			return concImpuProd.getConcepto_impuesto();
		else {
			if (this.getValorClasifProdGen()==null)
				return null;
			else {
				concImpuProd = this.getValorClasifProdGen().getConcImpuIVAProdVigAFecha(aFechaVigencia);
				if (concImpuProd!=null)
					return concImpuProd.getConcepto_impuesto();
				else
					return null;
			}
		}
	}

	public ConceptoImpuesto getConcImpuInterno(java.util.Date aFechaVigencia)
			throws BaseException {
		ConceptoImpuestoProducto concImpuProd = ConceptoImpuestoProducto
				.getConcImpuProdImpInt(this, aFechaVigencia, getSesion());
		if (concImpuProd != null)
			return concImpuProd.getConcepto_impuesto();
		else {
			if (this.getValorClasifProdGen()==null)
				return null;
			else {
				concImpuProd = this.getValorClasifProdGen().getConcImpuProdImpInt(aFechaVigencia);
				if (concImpuProd!=null)
					return concImpuProd.getConcepto_impuesto();
				else
					return null;
			}
		}
			
	}

	public ConceptoImpuesto getConcImpuPercIB(java.util.Date aFechaVigencia)
			throws BaseException {
		ConceptoImpuestoProducto concImpuProd = ConceptoImpuestoProducto
				.getConcImpuProdPercIB(this, aFechaVigencia, getSesion());
		if (concImpuProd != null)
			return concImpuProd.getConcepto_impuesto();
		else {
			concImpuProd = this.getValorClasifProdGen().getConcImpuProdPercIB(aFechaVigencia);
			if (this.getValorClasifProdGen()==null)
				return null;
			else {
				if (concImpuProd!=null)
					return concImpuProd.getConcepto_impuesto();
				else
					return null;
			}
		}
		
	}

	public static String getPathImagenesProducto(ISesion aSesion)
			throws BaseException {
		ValorParametro valorPathImagenesProd = ValorParametro
				.findByCodigoParametro("PATH_IMAGENES_PRODUCTOS", aSesion);
		return valorPathImagenesProd.getValorCadena();
	}

	public static Producto getProductoSaldoPendPagoPorSenia(ISesion aSesion)
			throws BaseException {
		Integer oidProducto = ValorParametro.findByCodigoParametro(
				"COD_PROD_SALDO_PEND_SENIA", aSesion).getOidObjNeg();
		Producto producto = Producto.findByOid(oidProducto, aSesion);
		return producto;
	}

	public static Producto getProductoSeniaFactura(ISesion aSesion)
			throws BaseException {
		Integer oidProducto = ValorParametro.findByCodigoParametro(
				"COD_PROD_SENIA_FACT", aSesion).getOidObjNeg();
		Producto producto = Producto.findByOid(oidProducto, aSesion);
		return producto;
	}

	public static Producto getProductoSaldoPendPagoPorSeniaDiscIVA(
			ISesion aSesion) throws BaseException {
		Integer oidProducto = ValorParametro.findByCodigoParametro(
				"COD_PROD_SALDO_PEND_SENIA_MI", aSesion).getOidObjNeg();
		Producto producto = Producto.findByOid(oidProducto, aSesion);
		return producto;
	}

	public static boolean isCodigoNumerico(ISesion aSesion)
			throws BaseException {
		ValorParametro valorIsCodigoNumerico = ValorParametro
				.findByCodigoParametro("COD_SKU_NUMERICO", aSesion);
		return valorIsCodigoNumerico.getBoolean();
	}

	private static void validarCodigoNumerico(String codigo)
			throws BaseException {
		try {
			Integer nro = new Integer(codigo);
		} catch (Exception e) {
			throw new ExceptionValidation(null,
					"El código de Producto debe ser numérico");
		}
	}

	public static void validarComposicionCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		if (isCodigoNumerico(aSesion))
			validarCodigoNumerico(codigo);
	}

	public boolean esCodigoNumerico() throws BaseException {
		return isCodigoNumerico(getSesion());
	}

	public Money getConvertirUM(Proveedor proveedor, Double cantidad,
			UnidadMedida uniMedOri, UnidadMedida uniMedDest)
			throws BaseException {
		Double factorConv = getFactConv(proveedor, uniMedOri, uniMedDest);
		if (factorConv == null)
			throw new ExceptionValidation(null,
					"No existe factor de conversión entre "
							+ uniMedOri.getDescripcion() + " y "
							+ uniMedDest.getDescripcion());
		CalculadorMoney calcUMDestino = new CalculadorMoney(new NumeroBase(
				factorConv));
		calcUMDestino.multiplicarPor(new NumeroBase(cantidad));
		return calcUMDestino.getResultMoney();
	}

	public ProductoProveedor getProductoProveedor(Proveedor proveedor)
			throws BaseException {
		List listaProdProv = getProductosProveedor(proveedor);
		if (listaProdProv.size() != 0)
			return (ProductoProveedor) listaProdProv.get(0);
		else
			return null;
	}

	private Double getFactConv(Proveedor proveedor, UnidadMedida uniMedOri,
			UnidadMedida uniMedDest) throws BaseException {

		if (uniMedOri == null)
			throw new ExceptionValidation(null,
					"No se especifico la unidad de medidad Origen");
		if (uniMedDest == null)
			throw new ExceptionValidation(null,
					"No se especifico la unidad de medida Destino");
		if (uniMedOri.getOID() == uniMedDest.getOID())
			return new Double(1);

		if (proveedor != null) {

			List listaProdProv = getProductosProveedor(proveedor);

			// Buscar en las Relaciones Directas del Proveedor
			Iterator iterProdProv = listaProdProv.iterator();
			while (iterProdProv.hasNext()) {
				ProductoProveedor prodProv = (ProductoProveedor) (iterProdProv
						.next());
				if (prodProv.getUmcpra().getOID() == uniMedOri.getOID()) {
					Iterator iterFactConvProv = prodProv
							.getFactoresConversionProv().iterator();
					while (iterFactConvProv.hasNext()) {
						FactorConversionProveedor factConvProv = (FactorConversionProveedor) iterFactConvProv
								.next();
						if (factConvProv.getUnidad_medida().getOID() == uniMedDest
								.getOID())
							return factConvProv.getFactor_conversion();
					}
				}
			}

			// Buscar en la Relacion Inversa del Proveedor
			Iterator iterFactConvProv = FactorConversionProveedor
					.getFactoresConversion(uniMedOri, this, proveedor,
							getSesion()).iterator();
			while (iterFactConvProv.hasNext()) {
				FactorConversionProveedor factConvProv = (FactorConversionProveedor) iterFactConvProv
						.next();
				if (factConvProv.getProducto_proveedor().getUmcpra().getOID() == uniMedDest
						.getOID()) {
					CalculadorDecimal calc = new CalculadorDecimal(
							new NumeroBase(1));
					calc.dividirPor(new NumeroBase(factConvProv
							.getFactor_conversion()));
					return new Double(calc.getResult());
				}

			}

		}

		// Buscar en las equivalencias en el producto
		Double factConv = getFactorConversionUMProducto(uniMedOri, uniMedDest);
		if (factConv != null)
			return factConv;

		// Buscar las Equivalencias en el Factor General
		factConv = getFactorConvGral(uniMedOri, uniMedDest, getSesion());
		if (factConv != null)
			return factConv;

		return null;
	}

	public List getProductosProveedor(Proveedor proveedor) throws BaseException {
		return ProductoProveedor.getProductosProveedor(this, proveedor,
				getSesion());
	}

	private Double getFactorConversionUMProducto(UnidadMedida uniMedOri,
			UnidadMedida uniMedDest) throws BaseException {
		ConversionUMProducto convUMProducto = ConversionUMProducto
				.getByProductoUMOriUMDest(this, uniMedOri, uniMedDest,
						getSesion());
		if (convUMProducto != null)
			return convUMProducto.getFact_conv();
		convUMProducto = ConversionUMProducto.getByProductoUMOriUMDest(this,
				uniMedDest, uniMedOri, getSesion());
		if (convUMProducto != null) {
			CalculadorDecimal calc = new CalculadorDecimal(new NumeroBase(1));
			calc.dividirPor(new NumeroBase(convUMProducto.getFact_conv()));
			return new Double(calc.getResult());
		}
		return null;
	}

	public static Double getFactorConvGral(UnidadMedida uniMedOri,
			UnidadMedida uniMedDest, ISesion aSesion) throws BaseException {
		return FactorConversion.getFactorConvGral(uniMedOri, uniMedDest,
				aSesion);
	}

	public Precio getPrecioUltimaOC(Proveedor proveedor) throws BaseException {
		Precio precio = null;
		List listaDetOC = OrdenDeCompraDet.getDetallesByProductoProveedor(this,
				proveedor, getSesion());
		Iterator iterDetalles = listaDetOC.iterator();
		while (iterDetalles.hasNext()) {
			OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterDetalles.next();
			precio = new Precio();
			precio.setMoneda(ocDet.getMoneda());
			precio.setImporte(new Money(ocDet.getPrecio().doubleValue()));
			precio.setPorcDto1(new Porcentaje(ocDet.getDto1().doubleValue()));
			precio.setPorcDto2(new Porcentaje(ocDet.getDto2().doubleValue()));
			precio.setPorcDto3(new Porcentaje(ocDet.getDto3().doubleValue()));
			precio.setEnCascada(ocDet.isEnCascada().booleanValue());
			precio.setUm(ocDet.getUnidad_compra());
			precio.setCantidad(new Money(1));
			precio.setFecVigencia(ocDet.getOrden_de_compra().getEmision());
			
			
			precio.setFuente("O.C. "
					+ ocDet.getOrden_de_compra().getNroExt()
					+ " fecha "
					+ Fecha
							.getddmmyyyy(ocDet.getOrden_de_compra()
									.getEmision()));

			return precio;
		}
		return precio;
	}

	public List getGruposAtributosVariables() throws BaseException {
		return GrupoAtributoEntidadVar.getGruposAtriEntVar(Producto.NICKNAME,
				this.getSesion());
	}

	public Collection getAtributos() throws BaseException {

		if (this.listaAtributos != null)
			return this.listaAtributos;

		// Obtener los atributos fijos
		Hashtable listaAtributos = new Hashtable();
		Iterator iterGrupoAtriEntFijo = GrupoAtributoEntidadFijo
				.getGruposAtriFijosByNickName(Producto.NICKNAME,
						this.getSesion()).iterator();
		while (iterGrupoAtriEntFijo.hasNext()) {
			GrupoAtributoEntidadFijo grupoAtriEntFijo = (GrupoAtributoEntidadFijo) iterGrupoAtriEntFijo
					.next();
			Iterator iterAtributosEnGrupo = grupoAtriEntFijo
					.getGrupo_atributo().getAtributosEnGrupo().iterator();
			while (iterAtributosEnGrupo.hasNext()) {
				AtributoEnGrupo atriEnGrupo = (AtributoEnGrupo) iterAtributosEnGrupo
						.next();
				if (listaAtributos.get(atriEnGrupo.getAtributo()
						.getOIDInteger()) == null)
					listaAtributos.put(atriEnGrupo.getAtributo()
							.getOIDInteger(), atriEnGrupo.getAtributo());
			}
		}

		// Obtener los atributo variables
		Iterator iterGruposAtriEntVar = GrupoAtributoEntidadVar
				.getGruposAtriEntVar(Producto.NICKNAME, this.getSesion())
				.iterator();
		while (iterGruposAtriEntVar.hasNext()) {
			GrupoAtributoEntidadVar grupoatributoentidadvar = (GrupoAtributoEntidadVar) iterGruposAtriEntVar
					.next();
			Iterator grupoAtriEntVar = grupoatributoentidadvar
					.getGruposAtributosHabilitados().iterator();
			while (grupoAtriEntVar.hasNext()) {
				GrupoHabilitadoEntidad grupoHabEnt = (GrupoHabilitadoEntidad) grupoAtriEntVar
						.next();
				Iterator iterAtriEnGrupo = grupoHabEnt.getGrupo_atributo()
						.getAtributosEnGrupo().iterator();
				while (iterAtriEnGrupo.hasNext()) {
					AtributoEnGrupo atriEnGrupo = (AtributoEnGrupo) iterAtriEnGrupo
							.next();
					if (listaAtributos.get(atriEnGrupo.getAtributo()
							.getOIDInteger()) == null)
						listaAtributos.put(atriEnGrupo.getAtributo()
								.getOIDInteger(), atriEnGrupo.getAtributo());
				}
			}

		}

		this.listaAtributos = listaAtributos.values();

		return this.listaAtributos;
	}


	public Precio getPrecioAcuerdoComercial(Proveedor proveedor,
			java.util.Date fecha) throws BaseException {
		Precio precio = null;
		AcuerdoLP acuerdoActivo = null;
		Iterator iterListasPrecios = AcuerdoLP.getAcuerdosLP(proveedor,
				"ACUERDO", fecha, getSesion()).iterator();
		while (iterListasPrecios.hasNext()) {
			AcuerdoLP acuerdoLP = (AcuerdoLP) iterListasPrecios.next();
			if (acuerdoLP.isActivo().booleanValue()) {
				acuerdoActivo = acuerdoLP;
				break;
			}
		}

		if (acuerdoActivo == null)
			return null;

		AcuerdoLPDetalle acuerdoDetalle = acuerdoActivo.getAcuerdosLPDetalle(
				this, getSesion());

		if (acuerdoDetalle != null) {
			precio = new Precio();
			precio.setMoneda(acuerdoDetalle.getMoneda());
			precio.setImporte(acuerdoDetalle.getPrecio());
			precio.setPorcDto1(new Porcentaje(0));
			precio.setPorcDto2(new Porcentaje(0));
			precio.setPorcDto3(new Porcentaje(0));
			precio.setEnCascada(false);
			precio.setFuente(acuerdoDetalle.getAcuerdo_lp().getDescripcion());
		}

		return precio;

	}

	public Money getCalcularIVA(java.util.Date fecha, Money precio)
			throws BaseException {
		ConceptoImpuesto concImpIVA = this.getConcImpuIVA(fecha);
		Money impuestoIVA = null;
		if (concImpIVA != null)
			impuestoIVA = concImpIVA.getCalcImpuesto(fecha, precio);
		else
			impuestoIVA = new Money(0);
		return impuestoIVA;
	}

	public Money getMontoIVADePrecioIVAInluido(java.util.Date fecha,
			Money precioIVAIncludo) throws BaseException {
		ConceptoImpuesto concImpIVA = this.getConcImpuIVA(fecha);
		if (concImpIVA != null)
			return concImpIVA.getMontoIVADePrecioIVAIncluido(fecha,
					precioIVAIncludo);
		else
			return new Money(0);

	}

	public Money getMontoImpuIntDePrecioIVAInluido(java.util.Date fecha,
			Money precioIVAIncludo) throws BaseException {
		ConceptoImpuesto concImpInt = this.getConcImpuInterno(fecha);
		if (concImpInt != null)
			return concImpInt.getMontoImpIntDePrecioIVAIncluido(fecha,
					precioIVAIncludo);
		else
			return new Money(0);

	}

	public Money getPrecioSinIVA(java.util.Date fecha, Money precioConIVA)
			throws BaseException {
		ConceptoImpuesto concImpIVA = this.getConcImpuIVA(fecha);
		if (concImpIVA != null) {
			Money precio = concImpIVA.getPrecioSinIVA(fecha, precioConIVA);
			if (precio == null)
				return null;
			else
				return new Money(precio.doubleValue(2));
		} else
			return new Money(0);

	}

	public Money getPrecioConsumidorFinal(java.util.Date fecha,
			Money precioSinImpuestos) throws BaseException {

		CalculadorMoney precioConsFinal = new CalculadorMoney(
				precioSinImpuestos);

		Money montoIVA = this.getCalcularIVA(fecha, precioSinImpuestos);
		Money montoImpuInt = this.getCalcImpuInterno(fecha, precioSinImpuestos);

		precioConsFinal.sumar(montoImpuInt);
		precioConsFinal.sumar(montoIVA);

		return precioConsFinal.getResultMoney();
	}

	public Money getCalcImpuInterno(Date fecha, Money precio)
			throws BaseException {
		ConceptoImpuesto concImpInterno = this.getConcImpuInterno(fecha);
		Money impuestoInterno = null;
		if (concImpInterno != null)
			impuestoInterno = concImpInterno.getCalcImpuesto(fecha, precio);
		else
			impuestoInterno = new Money(0);
		return impuestoInterno;
	}

	public static Producto getProductoBySinonimo(String sinonimo,
			ISesion aSesion) throws BaseException {
		return DBProducto.getProductoBySinonimo(sinonimo, aSesion);
	}

	public static Producto getProductoByCodigoBarra(String codigoBarra,
			ISesion aSesion) throws BaseException {
		return DBProducto.getProductoByCodigoBarra(codigoBarra, aSesion);
	}

	public static TipoProducto getTipoProductoDefault(ISesion aSesion)
			throws BaseException {
		return TipoProducto.getTipoProductoDefault(aSesion);
	}

	public static boolean isSugerirProdComprable(ISesion aSesion)
			throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"ES_COMPRABLE_DEF_ABM_PROD", aSesion).getBoolean();
	}

	public static boolean isSugerirProdVendible(ISesion aSesion)
			throws BaseException {
		return ValorParametro.findByCodigoParametro("ES_VENDIBLE_DEF_ABM_PROD",
				aSesion).getBoolean();
	}

	public static boolean isSugerirProdStockeable(ISesion aSesion)
			throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"ES_STOCKEABLE_DEF_ABM_PROD", aSesion).getBoolean();
	}

	public static List getConsultaMasivaProductos(Integer oidProducto,
			String descProducto, String descAbreviada, String codigoProducto,
			TipoProducto tipoProducto, boolean isComprable, boolean isVendible,
			boolean isStockeable, boolean isProdPropia, boolean isImportado,
			HashTableDatos valoresClasificadores, ISesion aSesion)
			throws BaseException {

		return DBProducto.getConsultaMasivaProductos(oidProducto, descProducto,
				descAbreviada, codigoProducto, tipoProducto, isComprable,
				isVendible, isStockeable, isProdPropia, isImportado,
				valoresClasificadores, aSesion);

	}

	public IValorClasificadorEntidad getValClasifProd1ParaContaVta()
			throws BaseException {
		return this.getValorClasifEnt(ClasificadorEntidad
				.getClasifProd1ParaContaVta(this.getSesion()));
	}

	public static Producto getProductoByCodigoyDistintoOid(String codigo,
			Integer oid, ISesion aSesion) throws BaseException {
		if (oid == null)
			return null;
		else
			return DBProducto.getProductoByCodigoyDistintoOid(codigo, oid,
					aSesion);
	}

	public Porcentaje getPorcDtoProducto(Sujeto sujeto, CondicionPago condPago,
			Date fecha) throws BaseException {

		EsquemaBonificacionVigSuj esqBonifVigSuj = sujeto
				.getEsquemaBonifVigSuj(fecha);
		if (esqBonifVigSuj == null)
			return new Porcentaje(0);
		if (esqBonifVigSuj.getEsquema_bonificacion() == null)
			return new Porcentaje(0);
		Porcentaje porc = esqBonifVigSuj.getEsquema_bonificacion()
				.getPorcBonif(this, fecha);
		if (porc == null)
			return new Porcentaje(0);
		else
			return porc;
	}

	public TasaIVA getTasaIVA(Sujeto sujeto, java.util.Date fecha)
			throws BaseException {
		// La idea de pasarle el sujeto es para tener en cuenta el porcentaje de
		// liberacion de IVA
		ConceptoImpuesto concImpuestoIVA = this.getConcImpuIVA(fecha);
		if (concImpuestoIVA != null)
			return concImpuestoIVA.getTasaVigenteIVA(fecha, this.getSesion());
		else {
			return null;
		}
		
	}
	
	private Precio getPrecioEntreOCyLP(Proveedor proveedor,java.util.Date fecha) throws BaseException {
		
		Precio precioLP = this.getValorClasifProdGen().getPrecioLP(proveedor, fecha , TipoAcuerdo.LISTA_PRECIOS);
		Precio precioOC = this.getPrecioUltimaOC(proveedor);
		
		if ((precioLP!=null) && (precioOC!=null)) {
			if (precioLP.getFecVigencia().before(precioOC.getFecVigencia())) 
				return precioOC;
			else
				return precioLP;
		} else
			if (precioLP!=null)
				return precioLP;
			else
				if (precioOC!=null)
					return precioOC;
		
		return null;
		
	}

	public Precio getPrecioCompra(Proveedor proveedor, java.util.Date fecha)
			throws BaseException {

		for (int i = 1; i <= 4; ++i) {
			String tomarPrecioDe = null; 
			if (i == 1)
				tomarPrecioDe = this.getTomarPrecioOC1();
			else if (i == 2)
				tomarPrecioDe = this.getTomarPrecioOC2();
			else if (i == 3)
				tomarPrecioDe = this.getTomarPrecioOC3();
			else if (i == 4)
				tomarPrecioDe = this.getTomarPrecioOC4();
			
			Precio precio = null;

			if (tomarPrecioDe != null) {

				if (tomarPrecioDe.equals(OCTomarPreciosDe.ULTOC))
					precio = this.getPrecioUltimaOC(proveedor);
				
				else if (tomarPrecioDe.equals(OCTomarPreciosDe.LISTA)) {
					if (this.getValorClasifProdGen()!=null)
						precio = this.getValorClasifProdGen().getPrecioLP(proveedor, fecha , TipoAcuerdo.LISTA_PRECIOS);
				}
				else if (tomarPrecioDe.equals(OCTomarPreciosDe.ACUERDO)) {
					if (this.getValorClasifProdGen()!=null)
						precio = this.getValorClasifProdGen().getPrecioLP(proveedor,fecha , TipoAcuerdo.ACUERDO);
				}
				else if (tomarPrecioDe.equals(OCTomarPreciosDe.LP_OC)) {
					if (this.getValorClasifProdGen()!=null)
						precio = getPrecioEntreOCyLP(proveedor,fecha);
				}
				
				if (precio != null)
					return precio;
				
			}
			
			
			
			
		}
			
			
		
		
		for (int i = 0; i <= 5; ++i) {
			String tomarPrecioDe = null;

			if (proveedor!=null) {
				if (i == 0)
					tomarPrecioDe = proveedor.getTomarPrecioOC();
				else if (i == 1)
					tomarPrecioDe = proveedor.getTomarPrecioOC1();
				else if (i == 2)
					tomarPrecioDe = proveedor.getTomarPrecioOC2();
				else if (i == 3)
					tomarPrecioDe = proveedor.getTomarPrecioOC3();
				else if (i == 4)
					tomarPrecioDe = proveedor.getTomarPrecioOC4();
				else if (i == 5)
					tomarPrecioDe = proveedor.getTomarPrecioOC5();
			}

			Precio precio = null;

			if (tomarPrecioDe != null) {

				if (tomarPrecioDe.equals(OCTomarPreciosDe.ULTOC))
					precio = this.getPrecioUltimaOC(proveedor);
				else if (tomarPrecioDe.equals(OCTomarPreciosDe.LISTA)) {
					if (this.getValorClasifProdGen()!=null)
						precio = this.getValorClasifProdGen().getPrecioLP(proveedor, fecha , TipoAcuerdo.LISTA_PRECIOS);
				}
				else if (tomarPrecioDe.equals(OCTomarPreciosDe.ACUERDO)) {
					if (this.getValorClasifProdGen()!=null)
						precio = this.getValorClasifProdGen().getPrecioLP(proveedor, fecha , TipoAcuerdo.ACUERDO);
				}
				else if (tomarPrecioDe.equals(OCTomarPreciosDe.LP_OC)) {
					if (this.getValorClasifProdGen()!=null)
						precio = getPrecioEntreOCyLP(proveedor,fecha);
				}
				

				if (precio != null)
					return precio;

			}

		}

		return null;
	}

	public static ClasificadorEntidad getClasifProductoGeneral(ISesion aSesion)
			throws BaseException {
		Integer oidClasifEntidad = ValorParametro.findByCodigoParametro(
				"CLASIF_ART_PROD_GENERAL", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEntidad = ClasificadorEntidad.findByOid(
				oidClasifEntidad, aSesion);
		return clasifEntidad;
	}

	public SaldoStkProdPorEstado getSaldoStkProdPorEstado(Deposito deposito,
			EstadoStock estadoStock) throws BaseException {
		return SaldoStkProdPorEstado.getSaldoStkProdPorEstado(this, deposito,
				estadoStock, this.getSesion());
	}

	public List getSeguimientosStock() throws BaseException {
		if (this.readSeguimientoStock) {
			List listaSeguimiento = SeguimientoStock.getSeguimientosStock(this,
					getSesion());
			this.seguimientosStock.addAll(listaSeguimiento);
			this.readSeguimientoStock = false;
		}
		return this.seguimientosStock;
	}

	public void addSeguimientoStock(SeguimientoStock aSeguimientoStock)
			throws BaseException {
		aSeguimientoStock.setProducto(this);
		this.seguimientosStock.add(aSeguimientoStock);
	}

	public ConfProdPorLP getConfProdPorLP(ListaPrecios listaPrecios)
			throws BaseException {
		return ConfProdPorLP
				.getConfProdLP(this, listaPrecios, this.getSesion());
	}

	public CostoProducto getCostoProductoVigAFecha(java.util.Date fechaDesde,
			ISesion aSesion) throws BaseException {
		return DBCostoProducto.getCostoProductoVigAFecha(fechaDesde, this,
				aSesion);
	}

	public Money getCostoConvAUMVta(Money costo, Money cantCosto,
			UnidadMedida umCosto, Money cantPV, UnidadMedida umVenta)
			throws BaseException {

		return CostoProducto.getCostoConvAUMVta(this, costo, cantCosto,
				umCosto, cantPV, umVenta, this.getSesion());

	}

	public CostoProducto getCostoProductoAFecha(java.util.Date fecha)
			throws BaseException {
		return CostoProducto.getCostoProductoByFecha(fecha, this, this
				.getSesion());
	}
	
	public static List getProductosByValorClasificador(ValorClasificadorEntidad valor, ISesion aSesion) throws BaseException {
		return DBProducto.getProductosByValorClasificador(valor,aSesion);
	}
	
	public ConceptoImpuestoProducto getConceptoImpuestoProducto(java.util.Date fecha,ConceptoImpuesto concImpu) throws BaseException {
		return ConceptoImpuestoProducto.getConcImpuProd(this,fecha,concImpu,this.getSesion());
	}
	
	public ConversionUMProducto getFactConvUMOriUMDest(UnidadMedida umOri,UnidadMedida umDest) throws BaseException {
		return ConversionUMProducto.getByProductoUMOriUMDest(this,umOri,umDest,this.getSesion());
	}
	
	public void setNoRealizarValClasif(boolean noRealizarValidacion) throws BaseException {
		this.noRealizarValClasif = noRealizarValidacion;
	}
	
	public boolean noRealizarValidacionClasif() throws BaseException {
		this.supportRefresh();
		return this.noRealizarValClasif;
	}
  	
	public static String getFormaDefaultCalcCosto(ISesion aSesion)
	throws BaseException {
		String valor = null;
		
		try {
		
		valor =
			ValorParametro.findByCodigoParametro(
				"DEF_FORM_CALC_COSTO_PROD", aSesion).getValorCadena();
		} catch(Exception e) {
			
		}
		return valor;
	}
	
	public static Proveedor getProveedorDefaultCalcCosto(ISesion aSesion)
	throws BaseException {
		Proveedor valor = null;
		
		try {
		
		Integer oidProv =
			ValorParametro.findByCodigoParametro(
				"DEF_PROV_CALC_COSTO_PROD", aSesion).getOidObjNeg();
		
		valor = Proveedor.findByOidProxy(oidProv, aSesion);
		
		} catch(Exception e) {
			
		}
		return valor;
	}
	
	public static String getFormaDefaultTomarPrecioOCOpcion(Integer nroOpcion,ISesion aSesion )
	throws BaseException {
		String valor = null;
		
		try {
		
		valor =
			ValorParametro.findByCodigoParametro(
				"DEF_TOMAR_PREC_OC_"+nroOpcion+"_ALTA_PROD", aSesion).getValorCadena();
		} catch(Exception e) {
			
		}
		return valor;
	}
	
	public List getSaldosPorEstados(AgrupadorDeposito agrupadorDeposito, EstadoStock estadoStock) throws BaseException {
		return SaldoStkProdPorEstado.getSaldosPorEstados(this,agrupadorDeposito,estadoStock,this.getSesion());
	}
	
	public List getDetallesOCPendRecep() throws BaseException {
		return OrdenDeCompraDet.getDetallesOCPendRecep(this,this.getSesion());
	}	
	
	public List getRequisicionesPendCompra() throws BaseException {
		return RequisicionDet.getRequisicionesPendCompra(this, this.getSesion());
	}
	
	public ProductoProveedor getProveedorMenorPrioridad()
	throws BaseException {
		return ProductoProveedor.getProveedorMenorPrioridad(this,this.getSesion());
	}
	
	
	
	
	

}
