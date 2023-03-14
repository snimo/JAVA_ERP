package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBInformeRecepcionDet;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.AplicInfRecRto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorDecimal;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class InformeRecepcionDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		supportRefresh();
		return getInforme_recepcion().getCodigo() + "/"
				+ getNro_item().toString();
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return getInforme_recepcion().getCodigo() + "/"
				+ getNro_item().toString();
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public InformeRecepcionDet() {
	}

	public static String NICKNAME = "cp.InformeRecepcionDet";

	private InformeRecepcion informe_recepcion;

	private Integer nro_item;

	private Producto producto;

	private Double cant_recibida;

	private UnidadMedida unidad_medida_recibido;

	private Double cant_rec_en_uc;

	private Double cant_rec_en_us;

	private Boolean controlar_calidad;

	private Boolean pendiente_cc;

	private Double cant_ok_us;

	private Double cant_mal_us;

	private Double cant_ok_uc;

	private Double cant_mal_uc;

	private String comentario;

	private Money precio_ori;

	private Moneda moneda_origen;

	private Money precio_mon_ori;

	private Money precio_mon_local;

	private Money precio_mon_ext1;

	private Money precio_mon_ext2;

	private Money valoriz_mon_ori;

	private Money valoriz_mon_local;

	private Money valoriz_mon_ext1;

	private Money valoriz_mon_ext2;

	private ValorCotizacion valorCotizMonOri = null;

	private ValorCotizacion valorCotizMonExt1 = null;

	private ValorCotizacion valorCotizMonExt2 = null;

	private Boolean anulado;

	private UnidadMedida unidadMedidaStock;

	private UnidadMedida unidadMedidaCompra;

	private OrdenDeCompraDet ordenDeCompraDet;
	
	private Double cantFactUS;
	
	private Double cantFactUC;
	
	private Boolean pendFacturar;
	
	private RemitoDet remitoDet;
	
	public void setCantFactUS(Double aCantFactUS)
	  throws BaseException {
		this.cantFactUS = aCantFactUS;
	}

	public Double getCantFactUS() throws BaseException {
		supportRefresh();
		return this.cantFactUS;
	}
	
	public void setRemitoDet(RemitoDet aRemitoDet)
	  throws BaseException {
		this.remitoDet = aRemitoDet;
	}

	public RemitoDet getRemitoDet() throws BaseException {
		supportRefresh();
		return this.remitoDet;
	}
	
	
	public void setCantFactUC(Double aCantFactUC)
	  throws BaseException {
		this.cantFactUC = aCantFactUC;
	}

	public Double getCantFactUC() throws BaseException {
		supportRefresh();
		return this.cantFactUC;
	}
	
	public Double getCantPendFactUC() throws BaseException {
		if (isPendFacturar().booleanValue()==false)
			return new Double(0);
		else {
			
			CalculadorMoney calc = new CalculadorMoney(new NumeroBase(getCant_rec_en_uc()));
			calc.restar(new NumeroBase(getCantFactUC()));
			return new Double(calc.getResultMoney().doubleValue());
		}
	}
	
	public void setPendFact(Boolean aPendFact)
	  throws BaseException {
		this.pendFacturar = aPendFact;
	}
	
	public Boolean isPendFacturar() throws BaseException {
		supportRefresh();
		return this.pendFacturar;
	}

	public void setOrdenDeCompraDet(OrdenDeCompraDet ordenDeCompraDet)
			throws BaseException {
		this.ordenDeCompraDet = ordenDeCompraDet;
	}

	public OrdenDeCompraDet getOrdenDeCompraDet() throws BaseException {
		supportRefresh();
		return this.ordenDeCompraDet;
	}

	public void setUnidadMedidaStock(UnidadMedida aUnidadMedida)
			throws BaseException {
		this.unidadMedidaStock = aUnidadMedida;
	}

	public UnidadMedida getUnidadMedidaStock() throws BaseException {
		supportRefresh();
		return this.unidadMedidaStock;
	}

	public void setUnidadMedidaCompra(UnidadMedida aUnidadMedida)
			throws BaseException {
		this.unidadMedidaCompra = aUnidadMedida;
	}

	public UnidadMedida getUnidadMedidaCompra() throws BaseException {
		supportRefresh();
		return this.unidadMedidaCompra;
	}

	public InformeRecepcion getInforme_recepcion() throws BaseException {
		supportRefresh();
		return informe_recepcion;
	}

	public void setInforme_recepcion(InformeRecepcion aInforme_recepcion) {
		this.informe_recepcion = aInforme_recepcion;
	}

	public Integer getNro_item() throws BaseException {
		supportRefresh();
		return nro_item;
	}

	public void setNro_item(Integer aNro_item) {
		this.nro_item = aNro_item;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public Double getCant_recibida() throws BaseException {
		supportRefresh();
		return cant_recibida;
	}

	public void setCant_recibida(Double aCant_recibida) {
		this.cant_recibida = aCant_recibida;
	}

	public UnidadMedida getUnidad_medida_recibido() throws BaseException {
		supportRefresh();
		return unidad_medida_recibido;
	}

	public void setUnidad_medida_recibido(UnidadMedida aUnidad_medida_recibido) {
		this.unidad_medida_recibido = aUnidad_medida_recibido;
	}

	public Double getCant_rec_en_uc() throws BaseException {
		supportRefresh();
		return cant_rec_en_uc;
	}

	public void setCant_rec_en_uc(Double aCant_rec_en_uc) {
		this.cant_rec_en_uc = aCant_rec_en_uc;
	}

	public Double getCant_rec_en_us() throws BaseException {
		supportRefresh();
		return cant_rec_en_us;
	}

	public void setCant_rec_en_us(Double aCant_rec_en_us) {
		this.cant_rec_en_us = aCant_rec_en_us;
	}

	public Boolean isControlar_calidad() throws BaseException {
		supportRefresh();
		return controlar_calidad;
	}

	public void setControlar_calidad(Boolean aControlar_calidad) {
		this.controlar_calidad = aControlar_calidad;
	}

	public Boolean isPendiente_cc() throws BaseException {
		supportRefresh();
		return pendiente_cc;
	}

	public void setPendiente_cc(Boolean aPendiente_cc) {
		this.pendiente_cc = aPendiente_cc;
	}

	public Double getCant_ok_us() throws BaseException {
		supportRefresh();
		return cant_ok_us;
	}

	public void setCant_ok_us(Double aCant_ok_us) {
		this.cant_ok_us = aCant_ok_us;
	}

	public Double getCant_mal_us() throws BaseException {
		supportRefresh();
		return cant_mal_us;
	}

	public void setCant_mal_us(Double aCant_mal_us) {
		this.cant_mal_us = aCant_mal_us;
	}

	public Double getCant_ok_uc() throws BaseException {
		supportRefresh();
		return cant_ok_uc;
	}

	public void setCant_ok_uc(Double aCant_ok_uc) {
		this.cant_ok_uc = aCant_ok_uc;
	}

	public Double getCant_mal_uc() throws BaseException {
		supportRefresh();
		return cant_mal_uc;
	}

	public void setCant_mal_uc(Double aCant_mal_uc) {
		this.cant_mal_uc = aCant_mal_uc;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public Money getPrecio_ori() throws BaseException {
		supportRefresh();
		return precio_ori;
	}

	public void setPrecio_ori(Money aPrecio_ori) {
		this.precio_ori = aPrecio_ori;
	}

	public Moneda getMoneda_origen() throws BaseException {
		supportRefresh();
		return moneda_origen;
	}

	public void setMoneda_origen(Moneda aMoneda_origen) {
		this.moneda_origen = aMoneda_origen;
	}

	public Money getPrecio_mon_local() throws BaseException {
		supportRefresh();
		return precio_mon_local;
	}

	public void setPrecio_mon_local(Money aPrecio_mon_local) {
		this.precio_mon_local = aPrecio_mon_local;
	}

	public Money getPrecio_mon_ext1() throws BaseException {
		supportRefresh();
		return precio_mon_ext1;
	}

	public void setPrecio_mon_ext1(Money aPrecio_mon_ext1) {
		this.precio_mon_ext1 = aPrecio_mon_ext1;
	}

	public Money getPrecio_mon_ext2() throws BaseException {
		supportRefresh();
		return precio_mon_ext2;
	}

	public void setPrecio_mon_ext2(Money aPrecio_mon_ext2) {
		this.precio_mon_ext2 = aPrecio_mon_ext2;
	}

	public Money getValoriz_mon_ori() throws BaseException {
		supportRefresh();
		return valoriz_mon_ori;
	}

	public void setValoriz_mon_ori(Money aValoriz_mon_ori) {
		this.valoriz_mon_ori = aValoriz_mon_ori;
	}

	public Money getValoriz_mon_local() throws BaseException {
		supportRefresh();
		return valoriz_mon_local;
	}

	public void setValoriz_mon_local(Money aValoriz_mon_local) {
		this.valoriz_mon_local = aValoriz_mon_local;
	}

	public Money getValoriz_mon_ext1() throws BaseException {
		supportRefresh();
		return valoriz_mon_ext1;
	}

	public void setValoriz_mon_ext1(Money aValoriz_mon_ext1) {
		this.valoriz_mon_ext1 = aValoriz_mon_ext1;
	}

	public Money getValoriz_mon_ext2() throws BaseException {
		supportRefresh();
		return valoriz_mon_ext2;
	}

	public void setValoriz_mon_ext2(Money aValoriz_mon_ext2) {
		this.valoriz_mon_ext2 = aValoriz_mon_ext2;
	}

	public Boolean isAnulado() throws BaseException {
		supportRefresh();
		return anulado;
	}

	public void setAnulado(Boolean aAnulado) {
		this.anulado = aAnulado;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static InformeRecepcionDet findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (InformeRecepcionDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static InformeRecepcionDet findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (InformeRecepcionDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static InformeRecepcionDet findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (InformeRecepcionDet) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(informe_recepcion,
				"Debe ingresar el Informe de Recepción");
		Validar.noNulo(nro_item, "Debe ingresar el Nro. de Item");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(cant_recibida, "Debe ingresar la cantidad Recibida");
		Validar.noNulo(unidad_medida_recibido,
				"Debe ingresar la Unidad de Medida");
		
		if (this.getInforme_recepcion().getTipo().equals(InformeRecepcion.TIPO_RTO_PROVEEDOR))
			if (this.getInforme_recepcion().getProveedor().isPermitirRecepProdSinOC().booleanValue()==false)
			Validar.noNulo(ordenDeCompraDet,
				"El item del producto "+
				  producto.getCodigo()+" - "+
				  producto.getDescripcion()+" no se encuentra referenciado a una Orden de Compra");
		if (getCant_rec_en_uc().doubleValue() == 0)
			throw new ExceptionValidation(null,
					"Debe ingresar las cantidades recibidas en Unidades de Compra");
		if (getProducto().isStockeable().booleanValue())
			if (getCant_rec_en_us().doubleValue() == 0)
				throw new ExceptionValidation(null,
						"Debe ingresar las cantidades recibidas en Unidades de Stock");

		if (isNew()) {
			setRecepcionItem();
		}
	}

	private void itemAControlCalidad() {
		this.setControlar_calidad(new Boolean(true));
		this.setPendiente_cc(new Boolean(true));
	}

	private void noControlarCalidadDelItem() {
		this.setControlar_calidad(new Boolean(false));
		this.setPendiente_cc(new Boolean(false));
	}

	private void setRecepcionItem() throws BaseException {

		// Marcar el Item como para controlar su calidad
		if (getProducto().isSistema_calidad().booleanValue())
			itemAControlCalidad();
		else
			noControlarCalidadDelItem();

		// Valorizar la Recepcion
		if (this.getOrdenDeCompraDet() != null) {
			setMoneda_origen(this.getOrdenDeCompraDet().getOrden_de_compra().getMoneda());
			setPrecio_ori(new Money(this.getOrdenDeCompraDet().getPrecio_neto_bonif().doubleValue()));

			// Grabar el Precio en las cuatro monedas y la Valorizacion
			// correspondiente
			setValorizarRecepcion(getMoneda_origen(), getPrecio_ori());
		}
	}

	private void setValorizarRecepcion(Moneda moneda, Money precio)
			throws BaseException {

		// Obtener precios en las diferentes monedas
		ImportesContables importesPrecios = getInforme_recepcion()
				.getImporteContable(moneda, precio);
		setPrecio_mon_local(importesPrecios.getImpoMonLoc());
		setPrecio_mon_ext1(importesPrecios.getImpoMonExt1());
		setPrecio_mon_ext2(importesPrecios.getImpoMonExt2());

		// Valorizacion de la mercaderia en Moneda Origen
		CalculadorMoney calcValorizMonOri = new CalculadorMoney(getPrecio_ori());
		calcValorizMonOri.multiplicarPor(new NumeroBase(getCant_rec_en_uc()));
		setValoriz_mon_ori(calcValorizMonOri.getResultMoney());

		// Valorizacion de la mercaderia en Moneda Local
		CalculadorMoney calcValorizMonLoc = new CalculadorMoney(
				getPrecio_mon_local());
		calcValorizMonLoc.multiplicarPor(new NumeroBase(getCant_rec_en_uc()));
		setValoriz_mon_local(calcValorizMonLoc.getResultMoney());

		// Valorizacion de la mercaderia en Moneda Extranjera 1
		CalculadorMoney calcValorizMonExt1 = new CalculadorMoney(
				getPrecio_mon_ext1());
		calcValorizMonExt1.multiplicarPor(new NumeroBase(getCant_rec_en_uc()));
		setValoriz_mon_ext1(calcValorizMonExt1.getResultMoney());

		// Valorizacion de la mercaderia en Moneda Extranjera 2
		CalculadorMoney calcValorizMonExt2 = new CalculadorMoney(
				getPrecio_mon_ext2());
		calcValorizMonExt2.multiplicarPor(new NumeroBase(getCant_rec_en_uc()));
		setValoriz_mon_ext2(calcValorizMonExt2.getResultMoney());

		Moneda monedaOC = getOrdenDeCompraDet().getOrden_de_compra().getMoneda();

		setValorCotizMonOri(getInforme_recepcion()
				.getCotizacionMoneda(monedaOC));
		setValorCotizMonExt1(importesPrecios.getValorCotizMonExt1());
		setValorCotizMonExt2(importesPrecios.getValorCotizMonExt2());

	}

	public static List getDetallesInfRec(InformeRecepcion informeRecepcion,
			ISesion aSesion) throws BaseException {
		return DBInformeRecepcionDet.getDetallesInfRec(informeRecepcion,
				aSesion);
	}

	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();
		setCant_mal_uc(new Double(0));
		setCant_mal_us(new Double(0));
		setCant_ok_uc(new Double(0));
		setCant_ok_us(new Double(0));
		setCantFactUC(new Double(0));
		setCantFactUS(new Double(0));
		setAnulado(new Boolean(false));
		setPendFact(new Boolean(false));

	}

	public static List getDetallesInfRec(HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {
		return DBInformeRecepcionDet.getDetallesInfRec(condiciones, aSesion);
	}

	public Double getCantPendCCEnUS() throws BaseException {
		if ((isAnulado().booleanValue() == false)
				&& (isPendiente_cc().booleanValue())) {
			CalculadorDecimal calcPendCC = new CalculadorDecimal(
					new NumeroBase(getCant_rec_en_us().doubleValue()));
			calcPendCC.restar(new NumeroBase(getCant_ok_us()));
			calcPendCC.restar(new NumeroBase(getCant_mal_us()));
			return new Double(calcPendCC.getResult());
		} else
			return new Double(0);
	}

	public ValorCotizacion getValorCotizMonOri() throws BaseException {
		supportRefresh();
		return this.valorCotizMonOri;
	}

	public ValorCotizacion getValorCotizMonExt1() throws BaseException {
		supportRefresh();
		return this.valorCotizMonExt1;
	}

	public ValorCotizacion getValorCotizMonExt2() throws BaseException {
		supportRefresh();
		return this.valorCotizMonExt2;
	}

	public void setValorCotizMonOri(ValorCotizacion aValorCotiz)
			throws BaseException {
		this.valorCotizMonOri = aValorCotiz;
	}

	public void setValorCotizMonExt1(ValorCotizacion aValorCotiz)
			throws BaseException {
		this.valorCotizMonExt1 = aValorCotiz;
	}

	public void setValorCotizMonExt2(ValorCotizacion aValorCotiz)
			throws BaseException {
		this.valorCotizMonExt2 = aValorCotiz;
	}

	public Double getCantPendCCEnUC() throws BaseException {
		if ((isAnulado().booleanValue() == false)
				&& (isPendiente_cc().booleanValue())) {
			CalculadorDecimal calcPendCC = new CalculadorDecimal(
					new NumeroBase(getCant_rec_en_uc().doubleValue()));
			calcPendCC.restar(new NumeroBase(getCant_ok_uc()));
			calcPendCC.restar(new NumeroBase(getCant_mal_uc()));
			return new Double(calcPendCC.getResult());
		} else
			return new Double(0);
	}

	public static List getDetallesInfRecPendCC(HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {
		return DBInformeRecepcionDet.getDetallesInfRecPendCC(condiciones,
				aSesion);
	}

	public void afterSave() throws BaseException {
	}

	public void afterSaveNew() throws BaseException {

		// Marcar en los detalles de entregas de las Ordenes de Compras las
		// cantidades recepcionadas
		if (this.getOrdenDeCompraDet() != null) {
			getOrdenDeCompraDet().setRecepcionPorInfRecEnUS(getCant_rec_en_us());
			getOrdenDeCompraDet().setRecepcionPorInfRecEnUC(getCant_rec_en_uc());
			getOrdenDeCompraDet().marcarSiNoEstaPendienteDeRecep();
			getOrdenDeCompraDet().save();
		}
		
		// Si corresponde a un remito interna y esta referencia a un detalle remito entonces actualizar
		// las cantidades recepcionadas
		
		if (this.getInforme_recepcion().getTipo().equals(InformeRecepcion.TIPO_RTO_INT_DEPO)) {
			if (this.getRemitoDet()!=null) {
				
				AplicInfRecRto aplicInfRecRto = (AplicInfRecRto)
					AplicInfRecRto.getNew(AplicInfRecRto.NICKNAME, this.getSesion());
				aplicInfRecRto.setRemito_det(this.getRemitoDet());
				aplicInfRecRto.setInf_rec_det(this);
				aplicInfRecRto.setCantidad(this.getCant_rec_en_us());
				aplicInfRecRto.setUm(this.getUnidadMedidaStock());
				aplicInfRecRto.setActivo(true);
				aplicInfRecRto.save();
				
			}
		}

	}

	public void anular() throws BaseException {

		// Dismininuir las cantidades recepcionadas en los detalles de entregas
		// de las Ordenes de compra
		if (getOrdenDeCompraDet() != null) {
			getOrdenDeCompraDet().setRecepcionPorInfRecEnUS(
					new Double(getCant_rec_en_us().doubleValue() * -1));
			getOrdenDeCompraDet().setRecepcionPorInfRecEnUC(
					new Double(getCant_rec_en_uc().doubleValue() * -1));
			getOrdenDeCompraDet().marcarSiNoEstaPendienteDeRecep();
			getOrdenDeCompraDet().save();
		}

	}
	
	public void setCantControladaOKInfCCEnUC(Double aCantidad) throws BaseException {
	  supportRefresh();
	  CalculadorMoney calcCantOK = new CalculadorMoney(new NumeroBase(getCant_ok_uc()));
	  calcCantOK.sumar(new NumeroBase(aCantidad));
	  setCant_ok_uc(new Double(calcCantOK.getResultMoney().doubleValue()));
	}
	
	public void setCantControladaOKInfCCEnUS(Double aCantidad) throws BaseException {
	  supportRefresh();
	  CalculadorMoney calcCantOK = new CalculadorMoney(new NumeroBase(getCant_ok_us()));
	  calcCantOK.sumar(new NumeroBase(aCantidad));
	  setCant_ok_us(new Double(calcCantOK.getResultMoney().doubleValue()));
	}	
	
	public void setCantControladaMalInfCCEnUC(Double aCantidad) throws BaseException {
	  supportRefresh();
	  CalculadorMoney calcCantMal = new CalculadorMoney(new NumeroBase(getCant_mal_uc()));
	  calcCantMal.sumar(new NumeroBase(aCantidad));
	  setCant_mal_uc(new Double(calcCantMal.getResultMoney().doubleValue()));
	}
		
	public void setCantControladaMalInfCCEnUS(Double aCantidad) throws BaseException {
	  supportRefresh();
	  CalculadorMoney calcCantMal = new CalculadorMoney(new NumeroBase(getCant_mal_us()));
	  calcCantMal.sumar(new NumeroBase(aCantidad));
	  setCant_mal_us(new Double(calcCantMal.getResultMoney().doubleValue()));
	}	
	
	public boolean analizarSiEstaPendCC() throws BaseException {
		if (isControlar_calidad().booleanValue()==false) return false;
		CalculadorMoney totalRevisado = new CalculadorMoney(new NumeroBase(getCant_ok_us()));
		totalRevisado.sumar(new NumeroBase(getCant_mal_us()));
		if (totalRevisado.getResultMoney().doubleValue()<getCant_rec_en_us().doubleValue())
			return true;
		else
			return false;
	}
	
	public void determinarMarcaPendCC() throws BaseException {
		if (analizarSiEstaPendCC())
			setPendiente_cc(new Boolean(true));
		else
			setPendiente_cc(new Boolean(false));
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
		if (getCant_rec_en_us().doubleValue()<=getCantFactUS().doubleValue())
			setPendFact(new Boolean(false));
		
	}
	
}
