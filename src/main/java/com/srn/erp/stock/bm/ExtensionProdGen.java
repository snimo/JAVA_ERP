package com.srn.erp.stock.bm;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.PrecioCompraPorClasifArt;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.da.DBExtensionProdGen;
import com.srn.erp.ventas.bm.ConfProdGralPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.da.DBConfProdGralPorLP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorDecimal;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ExtensionProdGen extends ObjetoLogico {

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ExtensionProdGen() {
	}

	public static String NICKNAME = "st.ExtensionProdGen";

	private ValorClasificadorEntidad valor_clasif_ent;
	private ClasificadorEntidad clasificador;
	private ConcFactProv conc_fact_prov;

	private UnidadMedida umVta;
	private UnidadMedida umCompra;
	private Integer ltEntrega;
	private Boolean precioNoDefEnLP;
	private Boolean modifPrecioFact;
	private Integer cantDecPrecio;
	private TipoProducto tipoProducto;
	private boolean comprable;
	private boolean vendible;
	private boolean stockeable;
	private boolean prodPropia;
	private boolean importado;
	private UnidadMedida umProd;
	private UnidadMedida umStockPpal;
	private UnidadMedida umStockAlt;
	private boolean llevaSerie;
	private boolean llevaPartida;
	private boolean seguiStock;
	private boolean esSaldoFactSenia;
	private boolean esSenia;
	private CuentaImputable cuentaImputableVentas;
	private boolean habNDInt;
	private boolean habNCInt;
	private boolean suscPercIBCapFed;
	private boolean suscPercIBBsAs;
	private boolean suscPercIVA;
	private boolean sistemaCalidad;
	private Double porcCumpOC;
	private Cuenta cuentaCompras;
	private Double porcToleRecep;
	private Integer ltEntregaProv;
	private String tomarPrecioOC1;
	private String tomarPrecioOC2;
	private String tomarPrecioOC3;
	private String tomarPrecioOC4;
	private String formaCalcCosto;
	private Proveedor proveedorCosto;
	private String comoObtenerCosto;
	

	private Hashtable listaOidValClasif = new Hashtable();
	
	public Double getPorcCumpOC() throws BaseException {
		supportRefresh();
		return this.porcCumpOC;
	}

	public void setPorcCumpOC(Double aPorcCumpOC) {
		this.porcCumpOC = aPorcCumpOC;
	}
	
	public void setComoObtenerCosto(String aComoObtenerCosto) {
		this.comoObtenerCosto = aComoObtenerCosto;
	}
	
	public String getFormaCalcCosto() throws BaseException {
		supportRefresh();
		return this.formaCalcCosto;
	}
	
	public String getComoObtenerCosto() throws BaseException {
		supportRefresh();
		return this.comoObtenerCosto;
	}
	
	public void setFormaCalcCosto(String aFormaCalcCosto) {
		this.formaCalcCosto = aFormaCalcCosto;
	}
	
	public Proveedor getProveedorCosto() throws BaseException {
		supportRefresh();
		return this.proveedorCosto;
	}

	public void setProveedorCosto(Proveedor aProveedorCosto) {
		this.proveedorCosto = aProveedorCosto;
	}
	
	
	
	public Cuenta getCuentaCompras() throws BaseException {
		supportRefresh();
		return this.cuentaCompras;
	}
	
	public void setTomarPrecioOC1(String aTomarPrecioOC1) {
		this.tomarPrecioOC1 = aTomarPrecioOC1;
	}
	
	public String getTomarPrecioOC1() throws BaseException {
		supportRefresh();
		return this.tomarPrecioOC1;
	}
	
	public void setTomarPrecioOC2(String aTomarPrecioOC2) {
		this.tomarPrecioOC2 = aTomarPrecioOC2;
	}
	
	public String getTomarPrecioOC2() throws BaseException {
		supportRefresh();
		return this.tomarPrecioOC2;
	}
	
	public void setTomarPrecioOC3(String aTomarPrecioOC3) {
		this.tomarPrecioOC3 = aTomarPrecioOC3;
	}
	
	public String getTomarPrecioOC3() throws BaseException {
		supportRefresh();
		return this.tomarPrecioOC3;
	}
	
	public void setTomarPrecioOC4(String aTomarPrecioOC4) {
		this.tomarPrecioOC4 = aTomarPrecioOC4;
	}
	
	public String getTomarPrecioOC4() throws BaseException {
		supportRefresh();
		return this.tomarPrecioOC4;
	}	
	
	public void setCuentaCompras(Cuenta aCuentaCompra) {
		this.cuentaCompras = aCuentaCompra;
	}
	
	public Double getPorcTolRecep() throws BaseException {
		supportRefresh();
		return this.porcToleRecep;
	}

	public void setPorcTolRecep(Double aPorcTolRecep) {
		this.porcToleRecep = aPorcTolRecep;
	}
	
	public Integer getLTEntregaProv() throws BaseException {
		supportRefresh();
		return this.ltEntregaProv;
	}

	public void setLTProveedor(Integer aLTProveedor) {
		this.ltEntregaProv = aLTProveedor;
	}
	
	public Boolean isPrecioNoDefEnLP() throws BaseException {
		supportRefresh();
		return this.precioNoDefEnLP;
	}

	public void setPrecioNoDefEnLP(Boolean aPrecioNoDefEnLP) {
		this.precioNoDefEnLP = aPrecioNoDefEnLP;
	}
	
	public Boolean isSistemaCalidad() throws BaseException {
		supportRefresh();
		return this.sistemaCalidad;
	}

	public void setSistemaCalidad(Boolean aSistemaCalidad) {
		this.sistemaCalidad = aSistemaCalidad;
	}
	
	
	public Boolean isSuscPercIBBsAs() throws BaseException {
		supportRefresh();
		return this.suscPercIBBsAs;
	}

	public void setSuscPercIBBsAs(Boolean aSuscPercIBBsAs) {
		this.suscPercIBBsAs = aSuscPercIBBsAs;
	}
	
	public Boolean isSuscPercIBCapFed() throws BaseException {
		supportRefresh();
		return this.suscPercIBCapFed;
	}

	public void setSuscPercIBCapFed(Boolean aSuscPercIBCapFed) {
		this.suscPercIBCapFed = aSuscPercIBCapFed;
	}
	
	public Boolean isSuscPercIVA() throws BaseException {
		supportRefresh();
		return this.suscPercIVA;
	}

	public void setSuscPercIVA(Boolean aSuscPercIBIVA) {
		this.suscPercIVA = aSuscPercIBIVA;
	}
	
	
	public Boolean isHabNDInt() throws BaseException {
		supportRefresh();
		return this.habNDInt;
	}

	public void setHabNDInt(Boolean aHabNDInt) {
		this.habNDInt = aHabNDInt;
	}
	
	public Boolean isHabNCInt() throws BaseException {
		supportRefresh();
		return this.habNCInt;
	}

	public void setHabNCInt(Boolean aHabNCInt) {
		this.habNCInt = aHabNCInt;
	}
	
	
	
	public CuentaImputable getCuentaImputableVentas() throws BaseException {
		supportRefresh();
		return this.cuentaImputableVentas;
	}

	public void setCuentaImputableVentas(CuentaImputable aCuentaImputableVentas) {
		this.cuentaImputableVentas = aCuentaImputableVentas;
	}
	
	
	public Boolean isSaldoFacturaSenia() throws BaseException {
		supportRefresh();
		return this.esSaldoFactSenia;
	}

	public void setSaldoFacturaSenia(Boolean aSaldoFacturaSenia) {
		this.esSaldoFactSenia = aSaldoFacturaSenia;
	}	
	
	public Boolean isSenia() throws BaseException {
		supportRefresh();
		return this.esSenia;
	}

	public void setEsSenia(Boolean aEsSenia) {
		this.esSenia = aEsSenia;
	}	
	
	public UnidadMedida getUMProd() throws BaseException {
		supportRefresh();
		return this.umProd;
	}
	
	public void setUMStockPpal(UnidadMedida aUMStockPpal) {
		this.umStockPpal = aUMStockPpal;
	}
	
	public UnidadMedida getUMStockPpal() throws BaseException {
		supportRefresh();
		return this.umStockPpal;
	}
	
	public void setUMStockAlt(UnidadMedida aUMStockAlt) {
		this.umStockAlt = aUMStockAlt;
	}
	
	public UnidadMedida getUMStockAlt() throws BaseException {
		supportRefresh();
		return this.umStockAlt;
	}
	
	

	public void setUMProd(UnidadMedida aUnidadMedida) {
		this.umProd = aUnidadMedida;
	}
	
	
	public Boolean isComprable() throws BaseException {
		supportRefresh();
		return this.comprable;
	}

	public void setComprable(Boolean aComprable) {
		this.comprable = aComprable;
	}
	
	public Boolean isLlevaSerie() throws BaseException {
		supportRefresh();
		return this.llevaSerie;
	}

	public void setLlevaSerie(Boolean aLlevaSerie) {
		this.llevaSerie = aLlevaSerie;
	}
	
	public Boolean isLlevaPartida() throws BaseException {
		supportRefresh();
		return this.llevaPartida;
	}

	public void setLlevaPartida(Boolean aLlevaPartida) {
		this.llevaPartida = aLlevaPartida;
	}
	
	public Boolean isSeguiStock() throws BaseException {
		supportRefresh();
		return this.seguiStock;
	}

	public void setSeguiStock(Boolean aSeguiStock) {
		this.seguiStock = aSeguiStock;
	}	
	
	public Boolean isVendible() throws BaseException {
		supportRefresh();
		return this.vendible;
	}

	public void setVendible(Boolean aVendible) {
		this.vendible = aVendible;
	}
	
	public Boolean isStockeable() throws BaseException {
		supportRefresh();
		return this.stockeable;
	}

	public void setStockeable(Boolean aStockeable) {
		this.stockeable = aStockeable;
	}
	
	public Boolean isProdPropia() throws BaseException {
		supportRefresh();
		return this.prodPropia;
	}

	public void setProdPropia(Boolean aProdPropia) {
		this.prodPropia = aProdPropia;
	}
	
	public Boolean isImportado() throws BaseException {
		supportRefresh();
		return this.importado;
	}

	public void setImportado(Boolean aImportado) {
		this.importado = aImportado;
	}
	
	
	
	
	

	public Boolean isModifPrecioFact() throws BaseException {
		supportRefresh();
		return this.modifPrecioFact;
	}

	public void setModifPrecioFact(Boolean aModifPrecioFact) {
		this.modifPrecioFact = aModifPrecioFact;
	}

	public UnidadMedida getUMVta() throws BaseException {
		supportRefresh();
		return this.umVta;
	}

	public void setUMVta(UnidadMedida aUMVta) {
		this.umVta = aUMVta;
	}
	
	public TipoProducto getTipoProducto() throws BaseException {
		supportRefresh();
		return this.tipoProducto;
	}

	public void setTipoProducto(TipoProducto aTipoProducto) {
		this.tipoProducto = aTipoProducto;
	}
	
	
	public UnidadMedida getUMCompra() throws BaseException {
		supportRefresh();
		return this.umCompra;
	}

	public void setUMCompra(UnidadMedida aUMCompra) {
		this.umCompra = aUMCompra;
	}	

	public Integer getCantDecPrecio() throws BaseException {
		supportRefresh();
		return this.cantDecPrecio;
	}

	public void setCantDecPrecio(Integer aCantDecPrecio) {
		this.cantDecPrecio = aCantDecPrecio;
	}

	public Integer getLTEntrega() throws BaseException {
		supportRefresh();
		return this.ltEntrega;
	}

	public void setLTEntrega(Integer aLTEntrega) {
		this.ltEntrega = aLTEntrega;
	}

	public ValorClasificadorEntidad getValor_clasif_ent() throws BaseException {
		supportRefresh();
		return valor_clasif_ent;
	}
	
	public ValorClasifEntProdGen getValorClasifProdGral() throws BaseException {
		supportRefresh();
		return ValorClasifEntProdGen.findByOidProxy(this.getValor_clasif_ent().getOIDInteger(), this.getSesion());
	}
	

	public void setValor_clasif_ent(ValorClasificadorEntidad aValor_clasif_ent) {
		this.valor_clasif_ent = aValor_clasif_ent;
	}

	public ClasificadorEntidad getClasificador() throws BaseException {
		supportRefresh();
		return clasificador;
	}

	public void setClasificador(ClasificadorEntidad aClasificador) {
		this.clasificador = aClasificador;
	}

	public ConcFactProv getConc_fact_prov() throws BaseException {
		supportRefresh();
		return conc_fact_prov;
	}

	public void setConc_fact_prov(ConcFactProv aConc_fact_prov) {
		this.conc_fact_prov = aConc_fact_prov;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ExtensionProdGen findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ExtensionProdGen) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ExtensionProdGen findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ExtensionProdGen) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ExtensionProdGen findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (ExtensionProdGen) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(valor_clasif_ent, "Valor clasificador Entidad");
		Validar.noNulo(clasificador, "Debe ingresar el clasificador");
		
		Iterator iterClasifAct =
			this.getClasificadoresEntidadActivos(this.getSesion()).iterator();
		while (iterClasifAct.hasNext()) {
			ClasificadorEntidad clasif = (ClasificadorEntidad) iterClasifAct.next();
			if (clasif.isObligatorio()) {
				if (this.getValorClasifEnt(clasif)==null)
					throw new ExceptionValidation(null,"Debe ingresar el valor del clasificador "+clasif.getDescripcion());
			}
		}
		
	}

	public static ExtensionProdGen getExtensionProdGral(
			ValorClasificadorEntidad valClasifEnt, ISesion aSesion)
			throws BaseException {
		return DBExtensionProdGen.getExtensionGral(valClasifEnt, aSesion);
	}

	public static String getPathImagenesProducto(ISesion aSesion)
			throws BaseException {
		ValorParametro valorPathImagenesProd = ValorParametro
				.findByCodigoParametro("PATH_IMAGENES_PROD_GRAL", aSesion);
		return valorPathImagenesProd.getValorCadena();
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
		if (clasifEnt == null) return null;
		supportRefresh();
		ValorClasificadorEntidad valClasifEnt = null;
		Integer oidValClasifEnt = (Integer) listaOidValClasif.get(clasifEnt
				.getNroClasif());
		if (oidValClasifEnt != null)
			valClasifEnt = ValorClasificadorEntidad.findByOid(oidValClasifEnt,
					getSesion());
		return valClasifEnt;
	}
	
	public static List getClasificadoresEntidad(ISesion aSesion) throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidad(ExtensionProdGen.NICKNAME,
				true, aSesion);
	}
	
	public static List getClasificadoresEntidadActivos(ISesion aSesion) throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidadActivos(ExtensionProdGen.NICKNAME,
				true, aSesion);
	}	
	
	
	protected void onNew() throws BaseException {
		for (int i = 1; i <= 20; ++i)
			addOidValorClasif(new Integer(i), new Integer(0));
	}
	
	public static List getConsultaMasivaProductos(Integer oidProducto,
			String descProducto, String descAbreviada, String codigoProducto,
			TipoProducto tipoProducto, boolean isComprable, boolean isVendible,
			boolean isStockeable, boolean isProdPropia, boolean isImportado,
			HashTableDatos valoresClasificadores, ISesion aSesion)
			throws BaseException {

		return DBExtensionProdGen.getConsultaMasivaProductos(oidProducto, descProducto,
				descAbreviada, codigoProducto, tipoProducto, isComprable,
				isVendible, isStockeable, isProdPropia, isImportado,
				valoresClasificadores, aSesion);

	}
	
	public Money getCostoConvAUMVta(Money costo, Money cantCosto,
			UnidadMedida umCosto, Money cantPV, UnidadMedida umVenta)
			throws BaseException {

		return CostoProductoGral.getCostoConvAUMVta(this, costo, cantCosto,
				umCosto, cantPV, umVenta, this.getSesion());

	}
	
	public CostoProductoGral getCosto(java.util.Date fecha) throws BaseException {
		//Verificar el metodo de calculo del Producto
		CostoProductoGral costo = null;
		if (this.getComoObtenerCosto()==null)
			return null;
		if (this.getComoObtenerCosto().equals(CostoProductoGral.COMO_OBT_COSTO_LPP)) {
			costo = getCostoAcuerdoLPProveedores(fecha);
		} else if (this.getComoObtenerCosto().equals(CostoProductoGral.COMO_OBT_COSTO_COSTOS_HIST)) {
			costo = 
				CostoProductoGral.getCostoProductoVigenteAFecha(fecha, this.getValorClasifProdGral(), this.getSesion());
		}
		return costo;
	}
	
	private CostoProductoGral getCostoAcuerdoLPProveedor(java.util.Date fecha) throws BaseException {

		if (this.getProveedorCosto() == null)
			return null;
		
		PrecioCompraPorClasifArt precioCompra = 
			PrecioCompraPorClasifArt.getPrecioCompraVigAFecha(this.getValor_clasif_ent(),this.getProveedorCosto(),fecha,TipoAcuerdo.ACUERDO,this.getSesion());
		
		if (precioCompra!=null) {
			CostoProductoGral costoProdGral = 
				(CostoProductoGral)CostoProductoGral.getNew(CostoProductoGral.NICKNAME, this.getSesion());
			costoProdGral.setVal_clasif_ent(precioCompra.getValor_clasif_art());
			costoProdGral.setClasificador(precioCompra.getClasificador());
			costoProdGral.setFec_ult_costo(precioCompra.getFechaVigencia());
			costoProdGral.setFecVigencia(precioCompra.getFechaVigencia());
			costoProdGral.setMoneda(precioCompra.getMoneda());
			costoProdGral.setCantidad(precioCompra.getCantidad());
			costoProdGral.setUm(precioCompra.getUnidad_medida());
			costoProdGral.setCosto(precioCompra.getPrecio());
			costoProdGral.setActivo(new Boolean(true));		
			return costoProdGral; 
		}
		
		precioCompra = 
			PrecioCompraPorClasifArt.getPrecioCompraVigAFecha(this.getValor_clasif_ent(),this.getProveedorCosto(),fecha,TipoAcuerdo.LISTA_PRECIOS,this.getSesion());
		
		if (precioCompra!=null) {
			CostoProductoGral costoProdGral = 
				(CostoProductoGral)CostoProductoGral.getNew(CostoProductoGral.NICKNAME, this.getSesion());
			costoProdGral.setVal_clasif_ent(precioCompra.getValor_clasif_art());
			costoProdGral.setClasificador(precioCompra.getClasificador());
			costoProdGral.setFec_ult_costo(precioCompra.getFechaVigencia());
			costoProdGral.setFecVigencia(precioCompra.getFechaVigencia());
			costoProdGral.setMoneda(precioCompra.getMoneda());
			costoProdGral.setCantidad(precioCompra.getCantidad());
			costoProdGral.setUm(precioCompra.getUnidad_medida());
			costoProdGral.setCosto(precioCompra.getPrecio());
			costoProdGral.setActivo(new Boolean(true));		
			return costoProdGral; 
		}
		
		return null;
	}
	
	private CostoProductoGral getCostoAcuerdoLPProveedores(java.util.Date fecha) throws BaseException {

		if (this.getProveedorCosto() == null)
			return null;
		
		PrecioCompraPorClasifArt precioCompra = 
			PrecioCompraPorClasifArt.getPrecioCompraVigAFecha(this.getValor_clasif_ent(),null,fecha,null,this.getSesion());
		
		if (precioCompra!=null) {
			CostoProductoGral costoProdGral = 
				(CostoProductoGral)CostoProductoGral.getNew(CostoProductoGral.NICKNAME, this.getSesion());
			costoProdGral.setVal_clasif_ent(precioCompra.getValor_clasif_art());
			costoProdGral.setClasificador(precioCompra.getClasificador());
			costoProdGral.setFec_ult_costo(precioCompra.getFechaVigencia());
			costoProdGral.setFecVigencia(precioCompra.getFechaVigencia());
			costoProdGral.setMoneda(precioCompra.getMoneda());
			costoProdGral.setCantidad(precioCompra.getCantidad());
			costoProdGral.setUm(precioCompra.getUnidad_medida());
			costoProdGral.setCosto(precioCompra.getPrecio());
			costoProdGral.setActivo(new Boolean(true));		
			return costoProdGral; 
		}
		
		return null;
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

		// Buscar en las equivalencias en el producto
		Double factConv = getFactorConversionUMProducto(uniMedOri, uniMedDest);
		if (factConv != null)
			return factConv;

		// Buscar las Equivalencias en el Factor General
		factConv = Producto.getFactorConvGral(uniMedOri, uniMedDest, getSesion());
		if (factConv != null)
			return factConv;

		return null;
	}
	
	private Double getFactorConversionUMProducto(UnidadMedida uniMedOri,
			UnidadMedida uniMedDest) throws BaseException {
		
		FactConvProdGral convUMProducto = FactConvProdGral.getFactorConv(this.getValor_clasif_ent(), uniMedOri, uniMedDest,getSesion());
		if (convUMProducto != null)
			return convUMProducto.getFact_conv().doubleValue(2);
		convUMProducto = FactConvProdGral.getFactorConv(this.getValor_clasif_ent(),
				uniMedDest, uniMedOri, getSesion());
		if (convUMProducto != null) {
			CalculadorDecimal calc = new CalculadorDecimal(new NumeroBase(1));
			calc.dividirPor(convUMProducto.getFact_conv());
			return new Double(calc.getResult());
		}
		return null;
	}
	
	public ConfProdGralPorLP getConfProdLP(ListaPrecios listaPrecios)
		throws BaseException {
		return DBConfProdGralPorLP.getConfProdPorLP(this.getValor_clasif_ent(),listaPrecios,this.getSesion());
 }
	
	public void afterSave() throws BaseException {

		super.afterSave();
		
		ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getValor_clasif_ent().getOIDInteger(), this.getSesion());
		
		if (valClasifEntProdGral!=null) {
			Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
			while (iterProductos.hasNext()) {
				Producto producto = (Producto) iterProductos.next();
				asignarAProducto(producto);
				producto.setNoRealizarValClasif(true);
				producto.save();
				
			}
		}
		
		
		
	}
	
	public void asignarAProducto(Producto producto) throws BaseException {
		
		producto.setComprable(this.isComprable());
		producto.setVendible(this.isVendible());
		producto.setStockeable(this.isStockeable());
		producto.setProd_propia(this.isProdPropia());
		producto.setImportado(this.isImportado());
		producto.setTipoproducto(this.getTipoProducto());
		producto.setUm_prod(this.getUMProd());
		producto.setUm_stk(this.getUMStockPpal());
		producto.setUm_stk_alt(this.getUMStockAlt());
		producto.setLlevaPartida(this.isLlevaPartida());
		producto.setLlevaSerie(this.isLlevaSerie());
		producto.setSeguimientoStock(this.isSeguiStock());
		producto.setUm_cpra(this.getUMCompra());
		
		producto.setUm_vta(this.getUMVta());
		producto.setLeadTimeVta(this.getLTEntrega());
		producto.setPrecioNoDefLP(this.isPrecioNoDefEnLP());
		producto.setModifPrecioFactura(this.isModifPrecioFact());
		producto.setIsSeniaFactura(this.isSenia());
		producto.setUsaParaSaldoPendFactSenia(this.isSaldoFacturaSenia());
		producto.setCuentaVenta(this.getCuentaImputableVentas());
		producto.setCantDecPrecioVta(this.getCantDecPrecio());
		producto.setHabilitadaNotaCreditoInterna(this.isHabNCInt());
		producto.setHabilitadaNotaDebitoInterna(this.isHabNDInt());
		producto.setCalcPercIBBsAs(this.isSuscPercIBBsAs());
		producto.setCalcPercIBCapFed(this.isSuscPercIBCapFed());
		producto.setCalcPercIVA(this.isSuscPercIVA());
		producto.setTomarPrecioOC1(this.getTomarPrecioOC1());
		producto.setTomarPrecioOC2(this.getTomarPrecioOC2());
		producto.setTomarPrecioOC3(this.getTomarPrecioOC3());
		producto.setTomarPrecioOC4(this.getTomarPrecioOC4());
		
		producto.setFormaCalcCosto(this.getFormaCalcCosto());
		producto.setProveedorCosto(this.getProveedorCosto());
		
		producto.setConcFactProv(this.getConc_fact_prov());
		producto.setSistema_calidad(this.isSistemaCalidad());
		
		if (this.getPorcCumpOC()!=null)
			producto.setPorc_cump_oc(new Money(this.getPorcCumpOC().doubleValue()));
		else
			producto.setPorc_cump_oc(null);
		producto.setCuenta_cpra(this.getCuentaCompras());
		if (this.getPorcTolRecep()!=null)
			producto.setTolerancia_recep(new Money(this.getPorcTolRecep().doubleValue()));
		else
			producto.setTolerancia_recep(null);
		producto.setLt_entrega(this.getLTEntregaProv());
		
		
	}
	
	

	
	
	
	
	
	

}
