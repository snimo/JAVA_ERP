package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.ventas.da.DBCotizacionTotal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CotizacionTotal extends ObjetoLogico {

	public CotizacionTotal() {
	}

	public static String			NICKNAME	= "ve.CotizacionTotal";

	private CotizacionCab			cotizacionCab;

	private ConceptoImpuesto	conceptoImpuesto;

	private Integer						secu;

	private String						comportamiento;

	private String						concepto;

	private Money							importe;

	public CotizacionCab getCotizacioncab() throws BaseException {
		supportRefresh();
		return cotizacionCab;
	}

	public void setCotizacioncab(CotizacionCab aCotizacioncab) {
		this.cotizacionCab = aCotizacioncab;
	}

	public ConceptoImpuesto getConceptoimpuesto() throws BaseException {
		supportRefresh();
		return conceptoImpuesto;
	}

	public void setConceptoimpuesto(ConceptoImpuesto aConceptoimpuesto) {
		this.conceptoImpuesto = aConceptoimpuesto;
	}

	public Integer getSecu() throws BaseException {
		supportRefresh();
		return secu;
	}

	public void setSecu(Integer aSecu) {
		this.secu = aSecu;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}

	public String getConcepto() throws BaseException {
		supportRefresh();
		return concepto;
	}

	public void setConcepto(String aConcepto) {
		this.concepto = aConcepto;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static CotizacionTotal findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CotizacionTotal) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CotizacionTotal findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CotizacionTotal) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(cotizacionCab, "Debe ingresar la Cotización ");
		Validar.noNulo(secu, "Debe ingresar el orden");
		Validar.noNulo(comportamiento, "Debe ingresar el comportamiento");
		Validar.noNulo(concepto, "Debe ingresar el concepto");
		Validar.noNulo(importe, "Debe ingresar el importe");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getDetallesByCotizacion(CotizacionCab cotizacion, ISesion aSesion) throws BaseException {
		return DBCotizacionTotal.getDetallesByCotizacion(cotizacion, aSesion);
	}

}
