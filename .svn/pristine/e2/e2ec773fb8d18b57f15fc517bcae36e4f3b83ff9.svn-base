package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.da.DBRendicionFFImpuestos;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RendicionFFImpuestos extends ObjetoLogico {

	public RendicionFFImpuestos() {
	}

	public static String							NICKNAME	= "pag.RendicionFFImpuestos";

	private RendicionFondoFijoCompro	rend_ff_det;

	private ConceptoImpuesto					concepto_impuesto;

	private Money											importe;

	private String										comportamiento;

	public RendicionFondoFijoCompro getRend_ff_det() throws BaseException {
		supportRefresh();
		return rend_ff_det;
	}

	public void setRend_ff_det(RendicionFondoFijoCompro aRend_ff_det) {
		this.rend_ff_det = aRend_ff_det;
	}

	public ConceptoImpuesto getConcepto_impuesto() throws BaseException {
		supportRefresh();
		return concepto_impuesto;
	}

	public void setConcepto_impuesto(ConceptoImpuesto aConcepto_impuesto) {
		this.concepto_impuesto = aConcepto_impuesto;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static RendicionFFImpuestos findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RendicionFFImpuestos) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RendicionFFImpuestos findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RendicionFFImpuestos) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(rend_ff_det, "Debe ingresar la Rendición Fondo Fijo");
		Validar.noNulo(concepto_impuesto, "Debe ingresar el Concepto Impuesto");
		Validar.noNulo(importe, "Debe ingresar el Importe");
		Validar.noNulo(comportamiento, "Debe ingresar el Comportamiento");
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
	
  public static List getConcImpuRendFF(RendicionFondoFijoCompro rendFFCompro,
      ISesion aSesion) throws BaseException {
   return DBRendicionFFImpuestos.getConcImpuRendFF(rendFFCompro,aSesion);
  }
	

}
