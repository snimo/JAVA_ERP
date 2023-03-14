package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.Impuesto;
import com.srn.erp.pagos.da.DBRendicionFondoFijoCompro;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RendicionFondoFijoCompro extends ObjetoLogico {

	private Money					netoGravado;

	private Money					netoNoGravado;

	private Money					iva;

	private Money					percIVA;

	private Money					percIB;

	private Money					otrosImp;

	private Money					total;

	private Moneda				moneda;

	private ConcFactProv	concFactProv;

	private List					detallesImpuestos			= new ArrayList();

	private boolean				readDetalleImpuestos	= true;
	
	private ConceptoImpuesto concImpuIVA;
	
	private ConceptoImpuesto concImpuPercIVA;
	
	private ConceptoImpuesto concImpuPercIB;
	

	public void setNetoGravado(Money aNetoGravado) throws BaseException {
		this.netoGravado = aNetoGravado;
	}

	public Money getNetoGravado() throws BaseException {
		this.supportRefresh();
		return this.netoGravado;
	}
	
	public void setConcImpuIVA(ConceptoImpuesto aConcImpuIVA) throws BaseException {
		this.concImpuIVA = aConcImpuIVA;
	}

	public ConceptoImpuesto getConcImpuIVA() throws BaseException {
		this.supportRefresh();
		return this.concImpuIVA;
	}
	
	public void setConcImpuPercIVA(ConceptoImpuesto aConcImpuPercIVA) throws BaseException {
		this.concImpuPercIVA = aConcImpuPercIVA;
	}

	public ConceptoImpuesto getConcImpuPercIVA() throws BaseException {
		this.supportRefresh();
		return this.concImpuPercIVA;
	}
	
	public void setConcImpuPercIB(ConceptoImpuesto aConcImpuPercIB) throws BaseException {
		this.concImpuPercIB = aConcImpuPercIB;
	}

	public ConceptoImpuesto getConcImpuPercIB() throws BaseException {
		this.supportRefresh();
		return this.concImpuPercIB;
	}
	
	public void setConcFactProv(ConcFactProv aConcFactProv) throws BaseException {
		this.concFactProv = aConcFactProv;
	}

	public ConcFactProv getConcFactProv() throws BaseException {
		this.supportRefresh();
		return this.concFactProv;
	}

	public void setIVA(Money aIVA) throws BaseException {
		this.iva = aIVA;
	}

	public Money getIVA() throws BaseException {
		this.supportRefresh();
		if (this.iva == null)
			return new Money(0);
		else
			return this.iva;
	}

	public void setPercIVA(Money aPercIVA) throws BaseException {
		this.percIVA = aPercIVA;
	}

	public Money getPercIVA() throws BaseException {
		this.supportRefresh();
		if (this.percIVA==null)
			return new Money(0);
		else
		  return this.percIVA;
	}

	public void setPercIB(Money aPercIB) throws BaseException {
		this.percIB = aPercIB;
	}

	public Money getPercIB() throws BaseException {
		this.supportRefresh();
		if (this.percIB == null)
			return new Money(0);
		else
			return this.percIB;
	}

	public void setOtrosImp(Money aOtrosImp) throws BaseException {
		this.otrosImp = aOtrosImp;
	}

	public Money getOtrosImp() throws BaseException {
		this.supportRefresh();
		if (this.otrosImp == null)
			return new Money(0);
		else
			return this.otrosImp;
	}

	public void setTotal(Money aTotal) throws BaseException {
		this.total = aTotal;
	}

	public Money getTotal() throws BaseException {
		this.supportRefresh();
		return this.total;
	}

	public void setMoneda(Moneda aMoneda) throws BaseException {
		this.moneda = aMoneda;
	}

	public Moneda getMoneda() throws BaseException {
		this.supportRefresh();
		return this.moneda;
	}

	public void setNetoNoGravado(Money aNetoNoGravado) throws BaseException {
		this.netoNoGravado = aNetoNoGravado;
	}

	public Money getNetoNoGravado() throws BaseException {
		this.supportRefresh();
		return this.netoNoGravado;
	}

	private List		imputacionesComproProv			= new ArrayList();

	private boolean	readImputacionesComproProv	= true;

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

	public RendicionFondoFijoCompro() {
	}

	public static String				NICKNAME	= "pag.RendicionFondoFijoCompro";

	private RendicionFondoFijo	rendicion_fondo;

	private ComproProveedorBase	comprobante_proveedorBase;

	public RendicionFondoFijo getRendicion_fondo() throws BaseException {
		supportRefresh();
		return rendicion_fondo;
	}

	public void setRendicion_fondo(RendicionFondoFijo aRendicion_fondo) {
		this.rendicion_fondo = aRendicion_fondo;
	}

	public ComproProveedorBase getComprobante_proveedor() throws BaseException {
		supportRefresh();
		return comprobante_proveedorBase;
	}

	public void setComprobante_proveedor(ComproProveedorBase aComprobante_proveedorBase) {
		this.comprobante_proveedorBase = aComprobante_proveedorBase;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static RendicionFondoFijoCompro findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RendicionFondoFijoCompro) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RendicionFondoFijoCompro findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RendicionFondoFijoCompro) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static RendicionFondoFijoCompro findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RendicionFondoFijoCompro) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(rendicion_fondo, "Debe ingresar un comprobante de Rendición");
		Validar.noNulo(comprobante_proveedorBase, "Debe ingresar el comprobante Proveedor");
	}

	public static List getComprobantesFF(RendicionFondoFijo rendicionFondoFijo, ISesion aSesion) throws BaseException {
		return DBRendicionFondoFijoCompro.getComprobantesFF(rendicionFondoFijo, aSesion);

	}

	public List getRendicionFondoFijoImputacionesCompro() throws BaseException {
		if (readImputacionesComproProv) {
			cargarListaFromBD(imputacionesComproProv, RendicionFondoFijoComproImpu.getImputacionesComproProv(this,
					getSesion()));
			readImputacionesComproProv = false;
		}
		return imputacionesComproProv;
	}
	
	public List getRendicionFondoFijoImpuestosCompro() throws BaseException {
		if (this.readDetalleImpuestos) {
			cargarListaFromBD(this.detallesImpuestos, RendicionFFImpuestos.getConcImpuRendFF(this,
					getSesion()));
			this.readDetalleImpuestos = false;
		}
		return this.detallesImpuestos;
	}
	

	public void addImputacionRendFF(RendicionFondoFijoComproImpu aRendFFComproImpu) throws BaseException {
		aRendFFComproImpu.setRendicion_det(this);
		imputacionesComproProv.add(aRendFFComproImpu);
	}
	
	public void addImpuestoRendFF(RendicionFFImpuestos aRendFFImpuestos) throws BaseException {
		aRendFFImpuestos.setRend_ff_det(this);
		this.detallesImpuestos.add(aRendFFImpuestos);
	}
	
	
	public void afterSave() throws BaseException {

		Iterator iterRendFFComproImputaciones = imputacionesComproProv.iterator();
		while (iterRendFFComproImputaciones.hasNext()) {
			RendicionFondoFijoComproImpu rendFFComproImpu = (RendicionFondoFijoComproImpu) iterRendFFComproImputaciones
					.next();
			rendFFComproImpu.save();
			rendFFComproImpu = null;
		}
		iterRendFFComproImputaciones = null;

		Iterator iterDetallesImpu = detallesImpuestos.iterator();
		while (iterDetallesImpu.hasNext()) {
			RendicionFFImpuestos rendFFImpuestos = (RendicionFFImpuestos) iterDetallesImpu.next();
			rendFFImpuestos.save();
			rendFFImpuestos = null;
		}
		iterDetallesImpu = null;

	}
	
	public Money getTotalImpuestosIVA() throws BaseException {
		CalculadorMoney totIVA = new CalculadorMoney(new NumeroBase(0));
		List listaDetallesImpuestos = null;
		
		if ((this.detallesImpuestos == null) || (this.detallesImpuestos.size()==0))
			listaDetallesImpuestos = getRendicionFondoFijoImpuestosCompro();
		else
			listaDetallesImpuestos = detallesImpuestos; 
		
		Iterator iterDetImpu = listaDetallesImpuestos.iterator();
		while (iterDetImpu.hasNext()) {
			RendicionFFImpuestos rendFFImpuesto = (RendicionFFImpuestos) iterDetImpu.next();
			if (rendFFImpuesto.getComportamiento().equals(Impuesto.CODIGO_IVA_C)) {
				totIVA.sumar(rendFFImpuesto.getImporte());
			}
		}
		return totIVA.getResultMoney();
	}
	
	public Money getTotalImpuestosPercIVA() throws BaseException {
		CalculadorMoney totIVA = new CalculadorMoney(new NumeroBase(0));
		List listaDetallesImpuestos = null;
		
		if ((this.detallesImpuestos == null) || (this.detallesImpuestos.size()==0))
			listaDetallesImpuestos = getRendicionFondoFijoImpuestosCompro();
		else
			listaDetallesImpuestos = detallesImpuestos; 
		
		Iterator iterDetImpu = listaDetallesImpuestos.iterator();
		while (iterDetImpu.hasNext()) {
			RendicionFFImpuestos rendFFImpuesto = (RendicionFFImpuestos) iterDetImpu.next();
			if (rendFFImpuesto.getComportamiento().equals(Impuesto.CODIGO_PERC_IVA_C)) {
				totIVA.sumar(rendFFImpuesto.getImporte());
			}
		}
		return totIVA.getResultMoney();
	}
	
	public Money getTotalImpuestosPercIB() throws BaseException {
		CalculadorMoney totIVA = new CalculadorMoney(new NumeroBase(0));
		List listaDetallesImpuestos = null;
		
		if ((this.detallesImpuestos == null) || (this.detallesImpuestos.size()==0))
			listaDetallesImpuestos = getRendicionFondoFijoImpuestosCompro();
		else
			listaDetallesImpuestos = detallesImpuestos; 
		
		Iterator iterDetImpu = listaDetallesImpuestos.iterator();
		while (iterDetImpu.hasNext()) {
			RendicionFFImpuestos rendFFImpuesto = (RendicionFFImpuestos) iterDetImpu.next();
			if ((rendFFImpuesto.getComportamiento().equals(Impuesto.CODIGO_PERC_IB_C))) {
				totIVA.sumar(rendFFImpuesto.getImporte());
			}
		}
		return totIVA.getResultMoney();
	}
	
	public Money getTotalImpuestosOtrosImpuestos() throws BaseException {
		CalculadorMoney totIVA = new CalculadorMoney(new NumeroBase(0));
		List listaDetallesImpuestos = null;
		
		if ((this.detallesImpuestos == null) || (this.detallesImpuestos.size()==0))
			listaDetallesImpuestos = getRendicionFondoFijoImpuestosCompro();
		else
			listaDetallesImpuestos = detallesImpuestos; 
		
		Iterator iterDetImpu = listaDetallesImpuestos.iterator();
		while (iterDetImpu.hasNext()) {
			RendicionFFImpuestos rendFFImpuesto = (RendicionFFImpuestos) iterDetImpu.next();
			if (rendFFImpuesto.getComportamiento().equals(Impuesto.CODIGO_IMP_INT_C)) {
				totIVA.sumar(rendFFImpuesto.getImporte());
			}
		}
		return totIVA.getResultMoney();
	}
	
	
	

}
