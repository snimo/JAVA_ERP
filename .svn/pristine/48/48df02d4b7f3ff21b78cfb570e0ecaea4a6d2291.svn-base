package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.da.DBCotizacionDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Decimal;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CotizacionDet extends ObjetoLogico {

	public CotizacionDet() {
	}

	public static String			NICKNAME	= "ve.PresuDet";

	private CotizacionCab					cotizacion;

	private Producto					producto;

	private UnidadMedida			uni_med_ori;

	private Decimal						cant_um_ori;

	private Decimal						cant_um_ori_res;

	private Decimal						cant_um_ori_sep;

	private Decimal						cant_um_ori_desp;

	private Decimal						cant_um_ori_ent;

	private Decimal						cant_um_ori_fact;

	private Money							precio;

	private Money							precio_bonif;

	private Money							precio_lista;

	private Money							precio_sugerido;

	private Moneda						moneda;

	private Boolean						anulado;

	private Decimal						bonif1;

	private Decimal						bonif2;

	private Decimal						bonif3;

	private Decimal						bonif4;

	private Decimal						bonif5;

	private Decimal						bonif6;

	private Decimal						bonif7;

	private Decimal						bonif8;

	private Decimal						bonif9;

	private java.util.Date		fecEntrega;

	private String						comentario;

	private Boolean						pendEnt;

	private Boolean						pendDesp;
	
	private Boolean						pendFact;

	private Integer						nroRenglon;

	private Money							importe;

	private Money							dto_recar;

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
	
	private Integer 					diasEntrega;

	public void setPendEnt(Boolean aPendEnt) {
		this.pendEnt = aPendEnt;
	}

	public Boolean isPendEnt() throws BaseException {
		supportRefresh();
		return pendEnt;
	}

	public void setPendDesp(Boolean aPendDesp) {
		this.pendDesp = aPendDesp;
	}

	public Boolean isPendDesp() throws BaseException {
		supportRefresh();
		return pendDesp;
	}
	
	public void setPendFact(Boolean aPendFact) {
		this.pendFact = aPendFact;
	}

	public Boolean isPendFact() throws BaseException {
		supportRefresh();
		return pendFact;
	}
	

	public void setFecEntrega(java.util.Date aFecha) throws BaseException {
		this.fecEntrega = aFecha;
	}

	public java.util.Date getFechaEntrega() throws BaseException {
		supportRefresh();
		return fecEntrega;
	}
	
	public void setDiasEntrega(Integer aDiasEntrega) throws BaseException {
		this.diasEntrega = aDiasEntrega;
	}

	public Integer getDiasEntrega() throws BaseException {
		supportRefresh();
		return this.diasEntrega;
	}
	

	public void setNroRenglon(Integer aNroRenglon) throws BaseException {
		this.nroRenglon = aNroRenglon;
	}

	public Integer getNroRenglon() throws BaseException {
		supportRefresh();
		return nroRenglon;
	}

	public void setComentario(String aComentario) throws BaseException {
		this.comentario = aComentario;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public CotizacionCab getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(CotizacionCab aCotizacion) {
		this.cotizacion = aCotizacion;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public UnidadMedida getUni_med_ori() throws BaseException {
		supportRefresh();
		return uni_med_ori;
	}

	public void setUni_med_ori(UnidadMedida aUni_med_ori) {
		this.uni_med_ori = aUni_med_ori;
	}

	public Decimal getCant_um_ori() throws BaseException {
		supportRefresh();
		return cant_um_ori;
	}

	public void setCant_um_ori(Decimal aCant_um_ori) {
		this.cant_um_ori = aCant_um_ori;
	}

	public Decimal getCant_um_ori_res() throws BaseException {
		supportRefresh();
		return cant_um_ori_res;
	}

	public void setCant_um_ori_res(Decimal aCant_um_ori_res) {
		this.cant_um_ori_res = aCant_um_ori_res;
	}

	public Decimal getCant_um_ori_sep() throws BaseException {
		supportRefresh();
		return cant_um_ori_sep;
	}

	public void setCant_um_ori_sep(Decimal aCant_um_ori_sep) {
		this.cant_um_ori_sep = aCant_um_ori_sep;
	}

	public Decimal getCant_um_ori_desp() throws BaseException {
		supportRefresh();
		return cant_um_ori_desp;
	}

	public void setCant_um_ori_desp(Decimal aCant_um_ori_desp) {
		this.cant_um_ori_desp = aCant_um_ori_desp;
	}

	public Decimal getCant_um_ori_ent() throws BaseException {
		supportRefresh();
		return cant_um_ori_ent;
	}

	public void setCant_um_ori_ent(Decimal aCant_um_ori_ent) {
		this.cant_um_ori_ent = aCant_um_ori_ent;
	}

	public Decimal getCant_um_ori_fact() throws BaseException {
		supportRefresh();
		return cant_um_ori_fact;
	}

	public void setCant_um_ori_fact(Decimal aCant_um_ori_fact) {
		this.cant_um_ori_fact = aCant_um_ori_fact;
	}

	public Money getPrecio() throws BaseException {
		supportRefresh();
		return precio;
	}

	public void setPrecio(Money aPrecio) {
		this.precio = aPrecio;
	}

	public Money getPrecio_bonif() throws BaseException {
		supportRefresh();
		return precio_bonif;
	}

	public void setPrecio_bonif(Money aPrecio_bonif) {
		this.precio_bonif = aPrecio_bonif;
	}

	public Money getPrecio_lista() throws BaseException {
		supportRefresh();
		return precio_lista;
	}

	public void setPrecio_lista(Money aPrecio_lista) {
		this.precio_lista = aPrecio_lista;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Boolean isAnulado() throws BaseException {
		supportRefresh();
		return anulado;
	}

	public void setAnulado(Boolean aAnulado) {
		this.anulado = aAnulado;
	}

	public Decimal getBonif1() throws BaseException {
		supportRefresh();
		return bonif1;
	}

	public void setBonif1(Decimal aBonif1) {
		this.bonif1 = aBonif1;
	}

	public Decimal getBonif2() throws BaseException {
		supportRefresh();
		return bonif2;
	}

	public void setBonif2(Decimal aBonif2) {
		this.bonif2 = aBonif2;
	}

	public Decimal getBonif3() throws BaseException {
		supportRefresh();
		return bonif3;
	}

	public void setBonif3(Decimal aBonif3) {
		this.bonif3 = aBonif3;
	}

	public Decimal getBonif4() throws BaseException {
		supportRefresh();
		return bonif4;
	}

	public void setBonif4(Decimal aBonif4) {
		this.bonif4 = aBonif4;
	}

	public Decimal getBonif5() throws BaseException {
		supportRefresh();
		return bonif5;
	}

	public void setBonif5(Decimal aBonif5) {
		this.bonif5 = aBonif5;
	}

	public Decimal getBonif6() throws BaseException {
		supportRefresh();
		return bonif6;
	}

	public void setBonif6(Decimal aBonif6) {
		this.bonif6 = aBonif6;
	}

	public Decimal getBonif7() throws BaseException {
		supportRefresh();
		return bonif7;
	}

	public void setBonif7(Decimal aBonif7) {
		this.bonif7 = aBonif7;
	}

	public Decimal getBonif8() throws BaseException {
		supportRefresh();
		return bonif8;
	}

	public void setBonif8(Decimal aBonif8) {
		this.bonif8 = aBonif8;
	}

	public Decimal getBonif9() throws BaseException {
		supportRefresh();
		return bonif9;
	}

	public void setBonif9(Decimal aBonif9) {
		this.bonif9 = aBonif9;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static CotizacionDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CotizacionDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CotizacionDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CotizacionDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CotizacionDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CotizacionDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		Validar.noNulo(cotizacion, "Debe ingresar el Presupuesto");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(uni_med_ori, "Debe Ingresar la Unidad de Medida Origen");
		Validar.noNulo(cant_um_ori, "Debe ingresar la cantidad en U.M. Orígen");
		Validar.noNulo(cant_um_ori_res, "Debe ingresar la cantidad en U.M.O.R.");
		Validar.noNulo(cant_um_ori_sep, "Debe ingresar la cantidad en U.M.O.S.");
		Validar.noNulo(cant_um_ori_desp, "Debe ingresar la cantidad en U.M.O.D.");
		Validar.noNulo(cant_um_ori_ent, "Debe ingresar la cantidad en U.M.O.E.");
		Validar.noNulo(cant_um_ori_fact, "Debe ingresar la cantidad en U.M.O.F.");
		Validar.noNulo(precio, "Debe ingresar el Precio");
		Validar.noNulo(precio_bonif, "Debe ingresar el Precio Bonificado");
		Validar.noNulo(precio_lista, "Debe ingresar el Precio de Lista");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(anulado, "Debe ingresar si esta o no anulado");
		Validar.noNulo(diasEntrega, "Debe ingresar los días de Entrega");
		
	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	public Boolean isActivo() {
		return null;
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	public static List getDetallesByCotizacion(CotizacionCab cotizacion, ISesion aSesion) throws BaseException {
		return DBCotizacionDet.getDetallesByCotizacion(cotizacion, aSesion);
	}
	
	public static List getDetallesByCotizacionActivos(CotizacionCab cotizacion, ISesion aSesion) throws BaseException {
		return DBCotizacionDet.getDetallesByCotizacionActivos(cotizacion, aSesion);
	}
	

	public void onNew() throws BaseException {
		setPendEnt(new Boolean(false));
		setPendDesp(new Boolean(false));
		setPendFact(new Boolean(false));
		setCant_um_ori(new Decimal(0));
		setCant_um_ori_res(new Decimal(0));
		setCant_um_ori_sep(new Decimal(0));
		setCant_um_ori_desp(new Decimal(0));
		setCant_um_ori_ent(new Decimal(0));
		setCant_um_ori_fact(new Decimal(0));
	}

	public void afterSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveDelete();
	}

	public void afterSaveModified() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveModified();
		
		// Verificar si se cambia la version de impresion
		this.getCotizacion().getComprobanteImpreso().siEstaCongeladoGenerarNuevaVersion();

		
	}

	public void afterSaveRehabilitar() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveRehabilitar();
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public Money getDto_recar() throws BaseException {
		supportRefresh();
		return dto_recar;
	}

	public void setDto_recar(Money aDto_recar) {
		this.dto_recar = aDto_recar;
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

	public ConceptoImpuesto getConcImpuIVA() throws BaseException {
		supportRefresh();
		return this.concImpuIVA;
	}

	public void setConcImpuIVA(ConceptoImpuesto aConceptoImpuesto) {
		this.concImpuIVA = aConceptoImpuesto;
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

}
