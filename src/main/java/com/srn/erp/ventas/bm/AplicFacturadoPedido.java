package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.ventas.da.DBAplicFacturadoPedido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AplicFacturadoPedido extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AplicFacturadoPedido() {
	}

	public static String NICKNAME = "ve.AplicFacturadoPedido";

	private PedidoDet pedido_det;
	private Double cant_fact;

	private String compo_compro;
	private FacturaCab factura;
	private FacturaDet factura_det;
	private Boolean activo;

	public PedidoDet getPedido_det() throws BaseException {
		supportRefresh();
		return pedido_det;
	}

	public void setPedido_det(PedidoDet aPedido_det) {
		this.pedido_det = aPedido_det;
	}

	public Double getCant_fact() throws BaseException {
		supportRefresh();
		return cant_fact;
	}

	public void setCant_fact(Double aCant_fact) {
		this.cant_fact = aCant_fact;
	}

	public String getCompo_compro() throws BaseException {
		supportRefresh();
		return compo_compro;
	}

	public void setCompo_compro(String aCompo_compro) {
		this.compo_compro = aCompo_compro;
	}

	public FacturaCab getFactura() throws BaseException {
		supportRefresh();
		return factura;
	}

	public void setFactura(FacturaCab aFactura) {
		this.factura = aFactura;
	}

	public FacturaDet getFactura_det() throws BaseException {
		supportRefresh();
		return factura_det;
	}

	public void setFactura_det(FacturaDet aFactura_det) {
		this.factura_det = aFactura_det;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AplicFacturadoPedido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AplicFacturadoPedido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AplicFacturadoPedido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AplicFacturadoPedido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(pedido_det, "Debe ingresar el Detalle del Pedido");
		Validar.noNulo(compo_compro, "Debe ingresar el comportamiento");
		Validar.noNulo(factura, "Debe ingresar la Factura");
		Validar.noNulo(factura_det, "Debe ingresar la Factura Detalle");
	}

	public void afterSaveNew() throws BaseException {
		super.afterSaveNew();

		// Aplicar lo facturado contra los detalles del pedido

		if (this.getCompo_compro().equals(IdentificacionTipoComprobante.COMPRO_NC_CLIENTE)) {
			CalculadorMoney acumCantFact = new CalculadorMoney(this.getPedido_det().getCant_um_ori_fact());
			acumCantFact.restar(new Money(this.getCant_fact().doubleValue()));
			this.getPedido_det().setCant_um_ori_fact(acumCantFact.getResultDecimal());

			// Verificar que la cantidad Facturada no supere la cantidad pedida
			if (acumCantFact.getResultDecimal().doubleValue() > getPedido_det().getCant_um_ori().doubleValue())
				throw new ExceptionValidation(null, "Las cantidad ya facturada más la cantidad actual facturada del producto " + getPedido_det().getProducto().getCodigo()
						+ "-" + getPedido_det().getProducto().getDescripcion() + " es "
						+ acumCantFact.getResultDecimal().doubleValue(2) + ", la cual supera a la cantidad del pedido que es "
						+ getPedido_det().getCant_um_ori().doubleValue(2) + Util.ENTER()
						+ "(Verifique que el pedido ya se encuentra facturado)");

			getPedido_det().save();
		} else {
			CalculadorMoney acumCantFact = new CalculadorMoney(new Money(this.getCant_fact().doubleValue()));
			acumCantFact.sumar(this.getPedido_det().getCant_um_ori_fact());
			this.getPedido_det().setCant_um_ori_fact(acumCantFact.getResultDecimal());

			// Verificar que la cantidad Facturada no supere la cantidad pedida
			if (acumCantFact.getResultDecimal().doubleValue() > getPedido_det().getCant_um_ori().doubleValue())
				throw new ExceptionValidation(null, "Las cantidad ya facturada más la cantidad actual facturada del producto " + getPedido_det().getProducto().getCodigo()
						+ "-" + getPedido_det().getProducto().getDescripcion() + " es "
						+ acumCantFact.getResultDecimal().doubleValue(2) + ", la cual supera a la cantidad del pedido que es "
						+ getPedido_det().getCant_um_ori().doubleValue(2) + Util.ENTER()
						+ "(Verifique que el pedido ya se encuentra facturado)");

			getPedido_det().save();
		}

	}

	public static List getAplicFacturadoPedido(FacturaCab facturaCab, FacturaDet facturaDet, ISesion aSesion) throws BaseException {
		return DBAplicFacturadoPedido.getAplicFacturadoPedido(facturaCab, facturaDet, aSesion);
	}

	@Override
	public void anular() throws BaseException {
		// TODO Auto-generated method stub
		super.anular();
		
		if (this.getCompo_compro().equals(IdentificacionTipoComprobante.COMPRO_NC_CLIENTE)) {
			CalculadorMoney acumCantFact = new CalculadorMoney(this.getPedido_det().getCant_um_ori_fact());
			acumCantFact.sumar(new Money(this.getCant_fact().doubleValue()));
			this.getPedido_det().setCant_um_ori_fact(acumCantFact.getResultDecimal());
			getPedido_det().save();
			
		} else {
			
			CalculadorMoney acumCantFact = new CalculadorMoney(this.getPedido_det().getCant_um_ori_fact());
			acumCantFact.restar(new Money(this.getCant_fact().doubleValue()));
			this.getPedido_det().setCant_um_ori_fact(acumCantFact.getResultDecimal());
			getPedido_det().save();
			
		}
		
		
		
	}
	
	  public static List getAplicFacturadoPedido(
			  PedidoDet pedidoDet,
	          ISesion aSesion) throws BaseException {
		  return DBAplicFacturadoPedido.getAplicFacturadoPedido(pedidoDet,aSesion);
	  }  
	

}
