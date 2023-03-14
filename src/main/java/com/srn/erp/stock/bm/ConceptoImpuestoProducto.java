package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.da.DBConceptoImpuestoProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class ConceptoImpuestoProducto extends ObjetoLogico {

	public ConceptoImpuestoProducto() {
	}

	public static String			NICKNAME	= "st.ConceptoImpuestoProducto";

	private Producto					producto;

	private ConceptoImpuesto	concepto_impuesto;

	private java.util.Date		fecha_vigencia;
	
	private ValorClasificadorEntidad valClasifEnt;
	
	
	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}
	
	public ValorClasificadorEntidad getValClasifEnt() throws BaseException {
		supportRefresh();
		return this.valClasifEnt;
	}

	public void setValClasifEnt(ValorClasificadorEntidad aValClasifEnt) {
		this.valClasifEnt = aValClasifEnt;
	}
	

	public ConceptoImpuesto getConcepto_impuesto() throws BaseException {
		supportRefresh();
		return concepto_impuesto;
	}

	public void setConcepto_impuesto(ConceptoImpuesto aConcepto_impuesto) {
		this.concepto_impuesto = aConcepto_impuesto;
	}

	public java.util.Date getFecha_vigencia() throws BaseException {
		supportRefresh();
		return fecha_vigencia;
	}

	public void setFecha_vigencia(java.util.Date aFecha_vigencia) {
		this.fecha_vigencia = aFecha_vigencia;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ConceptoImpuestoProducto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ConceptoImpuestoProducto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConceptoImpuestoProducto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ConceptoImpuestoProducto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		if ((producto == null) && (valClasifEnt == null))
			throw new ExceptionValidation(null,"Debe ingresar el producto");
		Validar.noNulo(concepto_impuesto, "Debe ingresar el concepto de Impuesto");
		Validar.noNulo(fecha_vigencia, "Debe ingresar la fecha de Vigencia");
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

	public static List getConceptosImpuestosProducto(Producto producto, ISesion aSesion) throws BaseException {
		return DBConceptoImpuestoProducto.getConceptosImpuestosProducto(producto, aSesion);
	}

	public static ConceptoImpuestoProducto getConcImpuProdIVA(Producto producto, java.util.Date fecha, ISesion aSesion)
			throws BaseException {
		return DBConceptoImpuestoProducto.getConcImpuProdIVA(producto, fecha, aSesion);
	}

	public static ConceptoImpuestoProducto getConcImpuProdPercIVA(Producto producto, java.util.Date fecha, ISesion aSesion)
			throws BaseException {
		return DBConceptoImpuestoProducto.getConcImpuProdPercIVA(producto, fecha, aSesion);
	}

	public static ConceptoImpuestoProducto getConcImpuProdImpInt(Producto producto, java.util.Date fecha, ISesion aSesion)
			throws BaseException {
		return DBConceptoImpuestoProducto.getConcImpuProdImpInt(producto, fecha, aSesion);
	}

	public static ConceptoImpuestoProducto getConcImpuProdPercIB(Producto producto, java.util.Date fecha, ISesion aSesion)
			throws BaseException {
		return DBConceptoImpuestoProducto.getConcImpuProdPercIB(producto, fecha, aSesion);
	}
	
	public static List getConceptosImpuestos(ValorClasificadorEntidad valorClasifEnt, ISesion aSesion) throws BaseException {
		return DBConceptoImpuestoProducto.getConceptosImpuestos(valorClasifEnt,aSesion);
	}
	
	public static ConceptoImpuestoProducto getConcImpuProd(
			Producto producto, 
			java.util.Date fecha, 
			ConceptoImpuesto concImpu, ISesion aSesion)
		throws BaseException {
		return DBConceptoImpuestoProducto.getConcImpuProd(producto,fecha,concImpu,aSesion);
		
		
	}
	
	public void afterSave() throws BaseException {

		super.afterSave();
		
		/*Me parece que no corresponde por eso lo comento */
		
		/*
		if (getValClasifEnt()!=null) {
		
			ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getValClasifEnt().getOIDInteger(), this.getSesion());
		
			if (valClasifEntProdGral!=null) {
				Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
				while (iterProductos.hasNext()) {
					Producto producto = (Producto) iterProductos.next();
					
					ConceptoImpuestoProducto concImpuProd = producto.getConceptoImpuestoProducto(this.getFecha_vigencia(), this.getConcepto_impuesto());
					if (concImpuProd == null)
						concImpuProd = (ConceptoImpuestoProducto) ConceptoImpuestoProducto.getNew(ConceptoImpuestoProducto.NICKNAME, this.getSesion());
					concImpuProd.setConcepto_impuesto(this.getConcepto_impuesto());
					concImpuProd.setProducto(producto);
					concImpuProd.setValClasifEnt(null);
					concImpuProd.setFecha_vigencia(this.getFecha_vigencia());
					
					concImpuProd.save();
					
					
				}
			}
			
		}*/
		
	}

	@Override
	public void afterSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveDelete();
		
		/*
		
		if (getValClasifEnt()!=null) {
			
			ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getValClasifEnt().getOIDInteger(), this.getSesion());
		
			if (valClasifEntProdGral!=null) {
				Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
				while (iterProductos.hasNext()) {
					Producto producto = (Producto) iterProductos.next();
					
					ConceptoImpuestoProducto concImpuProd = producto.getConceptoImpuestoProducto(this.getFecha_vigencia(), this.getConcepto_impuesto());
					if (concImpuProd != null) {
						concImpuProd.delete();
						concImpuProd.save();
						
					}
					
				}
			}
			
		}*/
		
	}
	
	
	public static ConceptoImpuestoProducto getConcImpuProdGralPercIVA(
			ValorClasificadorEntidad valClasifEnt, 
			java.util.Date fecha, ISesion aSesion)
		throws BaseException {
				return DBConceptoImpuestoProducto.getConcImpuProdGralPercIVA(
							valClasifEnt,
							fecha,
							aSesion);
	}
	
	public static ConceptoImpuestoProducto getConcImpuProdGralImpInt(
			ValorClasificadorEntidad valClasifEnt, 
			java.util.Date fecha, ISesion aSesion)
		throws BaseException {
				return DBConceptoImpuestoProducto.getConcImpuProdGralImpInt(
							valClasifEnt,
							fecha,
							aSesion);
	}
	
	public static ConceptoImpuestoProducto getConcImpuProdGralPercIB(
			ValorClasificadorEntidad valClasifEnt, 
			java.util.Date fecha, ISesion aSesion)
		throws BaseException {
				return DBConceptoImpuestoProducto.getConcImpuProdGralPercIB(
							valClasifEnt,
							fecha,
							aSesion);
	}
	
	
	
	

	
	public static ConceptoImpuestoProducto getConcImpuProdGralIVA(
			ValorClasificadorEntidad valClasifEnt, 
			java.util.Date fecha, ISesion aSesion)
		throws BaseException {
				return DBConceptoImpuestoProducto.getConcImpuProdGralIVA(
							valClasifEnt,
							fecha,
							aSesion);
	}
	

}
