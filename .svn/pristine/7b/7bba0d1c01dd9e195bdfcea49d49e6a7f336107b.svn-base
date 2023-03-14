package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.da.DBFacturaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class FacturaDet extends ObjetoLogico {

	public FacturaDet() {
	}

	public static String			NICKNAME	= "ve.FacturaDet";

	private FacturaCab				comproCab;

	private Producto					producto;

	private Double						cantidad;

	private UnidadMedida			unidad_medida;

	private Money							precio_lista;

	private Money							precio_ingresado;

	private Money							precio_sugerido;

	private Porcentaje				porc_bonif_1;

	private Porcentaje				porc_bonif_2;

	private Porcentaje				porc_bonif_3;

	private Money							precio_bonificado;

	private Money							importe;

	private String						comentario;

	private Money							dto_recar;

	private Boolean						anulado;

	private Money							impre_precio;

	private Money							impre_bonif;

	private Money							impre_recar;

	private Money							impre_precio_bonif;

	private Money							impre_importe;

	private ConceptoImpuesto	concImpuIVA;

	private ConceptoImpuesto	concImpuPercIVA;

	private ConceptoImpuesto	concImpuInt;

	private ConceptoImpuesto	concImpuPercIB;

	private Money							netoGravado;

	private Money							netoNoGravado;
	
	private PedidoCab pedidoCab;
	
	private PedidoDet pedidoDet;
	
	private RemitoCab remitoCab;
	
	private RemitoDet remitoDet;
	
	private FacturaCab comproFactAplic;
	
	private FacturaDet comproFactDetAplic;
	
	private Money iva;
	
	private Porcentaje tasaIVA;

	public ConceptoImpuesto getConcImpuIVA() throws BaseException {
		supportRefresh();
		return this.concImpuIVA;
	}

	public void setConcImpuIVA(ConceptoImpuesto aConceptoImpuesto) {
		this.concImpuIVA = aConceptoImpuesto;
	}
	
	public Money getIVA() throws BaseException {
		supportRefresh();
		return this.iva;
	}

	public void setIVA(Money aIVA) {
		this.iva = aIVA;
	}
	
	public Porcentaje getTasaIVA() throws BaseException {
		supportRefresh();
		return this.tasaIVA;
	}

	public void setTasaIVA(Porcentaje aTasaIVA) {
		this.tasaIVA = aTasaIVA;
	}
	
	public PedidoCab getPedidoCab() throws BaseException {
		supportRefresh();
		return this.pedidoCab;
	}

	
	public FacturaCab getFacturaAplicada() throws BaseException {
		supportRefresh();
		return this.comproFactAplic;
	}

	public void setFacturaAplicada(FacturaCab aFacturaCab) throws BaseException {
		this.comproFactAplic = aFacturaCab;
	}
	
	public FacturaDet getFacturaDetAplicada() throws BaseException {
		supportRefresh();
		return this.comproFactDetAplic;
	}

	public void setFacturaDetAplicada(FacturaDet aFacturaDet) throws BaseException {
		this.comproFactDetAplic = aFacturaDet;
	}
	
	public void setPedidoCab(PedidoCab aPedidoCab) {
		this.pedidoCab = aPedidoCab;
	}
	
	public PedidoDet getPedidoDet() throws BaseException {
		supportRefresh();
		return this.pedidoDet;
	}

	public void setPedidoDet(PedidoDet aPedidoDet) throws BaseException {
		this.pedidoDet = aPedidoDet;
		if (this.pedidoDet!=null)
			this.setPedidoCab(this.pedidoDet.getPedido());
		else
			this.setPedidoCab(null);
	}
	
	public RemitoCab getRemitoCab() throws BaseException {
		supportRefresh();
		return this.remitoCab;
	}

	public void setRemitoDet(RemitoDet aRemitoDet) throws BaseException {
		this.remitoDet = aRemitoDet;
		if (this.remitoDet!=null)
			this.setRemitoCab(this.remitoDet.getRemito_cab());
		else
			this.setRemitoCab(null);
	}
	
	public RemitoDet getRemitoDet() throws BaseException {
		supportRefresh();
		return this.remitoDet;
	}

	public void setRemitoCab(RemitoCab aRemitoCab) {
		this.remitoCab = aRemitoCab;
	}
	

	public ConceptoImpuesto getConcImpuPercIVA() throws BaseException {
		supportRefresh();
		return this.concImpuPercIVA;
	}

	public void setConcImpuPercIVA(ConceptoImpuesto aConceptoImpuesto) {
		this.concImpuPercIVA = aConceptoImpuesto;
	}

	public ConceptoImpuesto getConcImpuInt() throws BaseException {
		supportRefresh();
		return this.concImpuInt;
	}

	public void setConcImpuInt(ConceptoImpuesto aConceptoImpuesto) {
		this.concImpuInt = aConceptoImpuesto;
	}

	public ConceptoImpuesto getConcImpuPercIB() throws BaseException {
		supportRefresh();
		return this.concImpuPercIB;
	}

	public void setConcImpuPercIB(ConceptoImpuesto aConceptoImpuesto) {
		this.concImpuPercIB = aConceptoImpuesto;
	}

	public FacturaCab getComprocab() throws BaseException {
		supportRefresh();
		return comproCab;
	}

	public Sucursal getSucursal() throws BaseException {
		return this.getComprocab().getSucursal();
	}

	public void setComprocab(FacturaCab aComprocab) {
		this.comproCab = aComprocab;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public Double getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Double aCantidad) {
		this.cantidad = aCantidad;
	}

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public Money getPrecio_lista() throws BaseException {
		supportRefresh();
		return precio_lista;
	}

	public void setPrecio_lista(Money aPrecio_lista) {
		this.precio_lista = aPrecio_lista;
	}
	
	public Sujeto getSujeto() throws BaseException {
		return this.getComprocab().getSujeto();
	}
	
	public Money getCalcImportePrecioListaSinIVA() throws BaseException {
		
		PrecioEnLP precioFactura = producto.getPrecioFactura(
				this.getComprocab().getLista_precios(),
				this.getComprocab().getSujeto(),
				this.getComprocab().getEmision());
		
		if (precioFactura == null)
			return null;
		
		CalculadorMoney calcPrecioPorCant = new CalculadorMoney(precioFactura.getPrecio());
		calcPrecioPorCant.multiplicarPor(new Money(this.getCantidad().doubleValue()));
		
		if (this.getComprocab().getSujeto().getSujeto_impositivo().getCategiva().isDiscriminaIVA().booleanValue()) 
			return new Money(calcPrecioPorCant.getResult(2));
		else {
			// Discriminar el IVA
			Money precioSinIVA =
				producto.getPrecioSinIVA(this.getComprocab().getEmision(),calcPrecioPorCant.getResultMoney());
			return new Money(precioSinIVA.doubleValue(2));
		}
			
	}
	
	public Money getNetoGravadoMasNetoNoGravado() throws BaseException {
		CalculadorMoney total = new CalculadorMoney(new Money(0));
		if (this.getNetoGravado()!=null)
			total.sumar(this.getNetoGravado());
		if (this.getNetoNoGravado()!=null)
			total.sumar(this.getNetoNoGravado());
		return total.getResultMoney();
	}

	public Money getPrecio_ingresado() throws BaseException {
		supportRefresh();
		return precio_ingresado;
	}

	public void setPrecio_ingresado(Money aPrecio_ingresado) {
		this.precio_ingresado = aPrecio_ingresado;
	}

	public Money getPrecio_sugerido() throws BaseException {
		supportRefresh();
		return precio_sugerido;
	}

	public void setPrecio_sugerido(Money aPrecio_sugerido) {
		this.precio_sugerido = aPrecio_sugerido;
	}

	public Porcentaje getPorc_bonif_1() throws BaseException {
		supportRefresh();
		return porc_bonif_1;
	}

	public void setPorc_bonif_1(Porcentaje aPorc_bonif_1) {
		this.porc_bonif_1 = aPorc_bonif_1;
	}

	public Porcentaje getPorc_bonif_2() throws BaseException {
		supportRefresh();
		return porc_bonif_2;
	}

	public void setPorc_bonif_2(Porcentaje aPorc_bonif_2) {
		this.porc_bonif_2 = aPorc_bonif_2;
	}

	public Porcentaje getPorc_bonif_3() throws BaseException {
		supportRefresh();
		return porc_bonif_3;
	}

	public void setPorc_bonif_3(Porcentaje aPorc_bonif_3) {
		this.porc_bonif_3 = aPorc_bonif_3;
	}

	public Money getPrecio_bonificado() throws BaseException {
		supportRefresh();
		return precio_bonificado;
	}

	public void setPrecio_bonificado(Money aPrecio_bonificado) {
		this.precio_bonificado = aPrecio_bonificado;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		if (aComentario!=null) {
			if (aComentario.length()>=255)
				this.comentario =  aComentario.substring(0,254);
			else
				this.comentario =  aComentario;
		}
		else
			this.comentario = aComentario;
	}

	public Money getDto_recar() throws BaseException {
		supportRefresh();
		return dto_recar;
	}

	public void setDto_recar(Money aDto_recar) {
		this.dto_recar = aDto_recar;
	}

	public Boolean isAnulado() throws BaseException {
		supportRefresh();
		return anulado;
	}

	public void setAnulado(Boolean aAnulado) {
		this.anulado = aAnulado;
	}

	public Money getImpre_precio() throws BaseException {
		supportRefresh();
		return impre_precio;
	}

	public void setImpre_precio(Money aImpre_precio) {
		this.impre_precio = aImpre_precio;
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

	public void setNetoGravado(Money aNetoGravado) {
		this.netoGravado = aNetoGravado;
	}

	public Money getNetoGravado() throws BaseException {
		supportRefresh();
		return this.netoGravado;
	}

	public void setNetoNoGravado(Money aNetoNoGravado) {
		this.netoNoGravado = aNetoNoGravado;
	}

	public Money getNetoNoGravado() throws BaseException {
		supportRefresh();
		return this.netoNoGravado;
	}

	public void setImpre_recar(Money aImpre_recar) {
		this.impre_recar = aImpre_recar;
	}

	public Money getImpre_precio_bonif() throws BaseException {
		supportRefresh();
		return impre_precio_bonif;
	}

	public void setImpre_precio_bonif(Money aImpre_precio_bonif) {
		this.impre_precio_bonif = aImpre_precio_bonif;
	}

	public Money getImpre_importe() throws BaseException {
		supportRefresh();
		return impre_importe;
	}

	public void setImpre_importe(Money aImpre_importe) {
		this.impre_importe = aImpre_importe;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static FacturaDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (FacturaDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static FacturaDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (FacturaDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static FacturaDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (FacturaDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(comproCab, "Debe ingresar la Factura");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(cantidad, "Debe ingresar la cantidad");
		Validar.noNulo(this.precio_ingresado, "Debe ingresar el precio");
		Validar.noNulo(this.precio_bonificado, "Debe ingresar el precio");
		Validar.noNulo(this.importe, "Debe ingresar el importe");

	}

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
		return this.getProducto().getCodigo()+" - "+getProducto().getDescripcion();
	}
	
	public static List getItemsFactura(FacturaCab facturaCab, ISesion aSesion) throws BaseException {
		return DBFacturaDet.getItemsFactura(facturaCab, aSesion);
	}

	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();
		this.setAnulado(new Boolean(false));
	}
	
	
	private void aplicarCantFactContraDetRem() throws BaseException {
		AplicFacturadoRemito aplicFactRem = 
			(AplicFacturadoRemito) AplicFacturadoRemito.getNew(AplicFacturadoRemito.NICKNAME,getSesion());
		aplicFactRem.setRemito_det(this.getRemitoDet());
		aplicFactRem.setCant_fact(this.getCantidad());
		aplicFactRem.setCompo_compro(this.getComprocab().getTipoCompro().getIdentificacion());
		aplicFactRem.setFactura(this.getComprocab());
		aplicFactRem.setFactura_det(this);
		aplicFactRem.setActivo(new Boolean(true));
		aplicFactRem.save();
	}
	
	private void aplicarCantFactContraDetPedido() throws BaseException {
		AplicFacturadoPedido aplicFactPed = 
			(AplicFacturadoPedido) AplicFacturadoPedido.getNew(AplicFacturadoPedido.NICKNAME,getSesion());
		aplicFactPed.setPedido_det(getPedidoDet());
		aplicFactPed.setCant_fact(this.getCantidad());
		aplicFactPed.setCompo_compro(this.getComprocab().getTipoCompro().getIdentificacion());
		aplicFactPed.setFactura(this.getComprocab());
		aplicFactPed.setFactura_det(this);
		aplicFactPed.setActivo(new Boolean(true));
		aplicFactPed.save();
		
	}
	
	
	public void afterSaveNew() throws BaseException {
		
		// Aplicar las canidades facturadas con el remito
		if ((getRemitoDet() != null) && 
				(getRemitoDet().getProducto().getOID() == this.getProducto().getOID()) &&
				(getRemitoDet().isActivo().booleanValue()==true) &&
				(getRemitoDet().getRemito_cab().isActivo().booleanValue()==true))
				aplicarCantFactContraDetRem();
		else if ((this.getPedidoDet()!=null) && (this.getPedidoDet().getProducto().getOID() == this.getProducto().getOID()))
		 	      aplicarCantFactContraDetPedido();
			
	}
	
	public IValorClasificadorEntidad getValClasif1ParaContabilizarVta() throws BaseException {
		IValorClasificadorEntidad valClasifEnt =
			producto.getValClasifProd1ParaContaVta();
		if (valClasifEnt == null) {
			ClasificadorEntidad clasifEnt = ClasificadorEntidad.getClasifProd1ParaContaVta(this.getSesion());
			throw new ExceptionValidation(null,"Falta Cargar el valor del clasificador "+
					clasifEnt.getDescripcion()+" para el producto "+this.getProducto().getDescripcion()+" - "+
					this.getProducto().getCodigo());
		}
		return valClasifEnt;
	}
	
	

}
