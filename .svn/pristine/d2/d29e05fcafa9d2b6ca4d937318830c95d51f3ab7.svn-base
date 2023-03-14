package com.srn.erp.ventas.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.ventas.da.DBAplicDespachoPedido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AplicDespachoPedido extends ObjetoLogico {

	public void afterSaveNew() throws BaseException {
		super.afterSaveNew();

		// Aplicar las entregas a los detalles del Pedido}
		CalculadorMoney acumCantDesp = new CalculadorMoney(new Money(getCant_desp().doubleValue()));
		acumCantDesp.sumar(getPedido_detalle().getCant_um_ori_desp());
		getPedido_detalle().setCant_um_ori_desp(acumCantDesp.getResultDecimal());
		getPedido_detalle().save();

	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AplicDespachoPedido() {
	}

	public static String	NICKNAME	= "ve.AplicDespachoPedido";

	private PedidoDet			pedido_detalle;

	private Double				cant_desp;

	private String				comportamiento_compro;

	private ComproCab			comprobante_entrega;

	private Integer				oid_detalle_compro;

	private Boolean				activo;

	public PedidoDet getPedido_detalle() throws BaseException {
		supportRefresh();
		return pedido_detalle;
	}

	public void setPedido_detalle(PedidoDet aPedido_detalle) {
		this.pedido_detalle = aPedido_detalle;
	}

	public Double getCant_desp() throws BaseException {
		supportRefresh();
		return cant_desp;
	}

	public void setCant_desp(Double aCant_desp) {
		this.cant_desp = aCant_desp;
	}

	public String getComportamiento_compro() throws BaseException {
		supportRefresh();
		return comportamiento_compro;
	}

	public void setComportamiento_compro(String aComportamiento_compro) {
		this.comportamiento_compro = aComportamiento_compro;
	}

	public ComproCab getComprobante_entrega() throws BaseException {
		supportRefresh();
		return comprobante_entrega;
	}

	public void setComprobante_entrega(ComproCab aComprobante_entrega) {
		this.comprobante_entrega = aComprobante_entrega;
	}

	public Integer getOid_detalle_compro() throws BaseException {
		supportRefresh();
		return oid_detalle_compro;
	}

	public void setOid_detalle_compro(Integer aOid_detalle_compro) {
		this.oid_detalle_compro = aOid_detalle_compro;
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

	public static AplicDespachoPedido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AplicDespachoPedido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AplicDespachoPedido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AplicDespachoPedido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(pedido_detalle, "Debe ingresar el detalle del comprobante");
		Validar.noNulo(cant_desp, "Debe ingresar la cantidad despachada");
		Validar.noNulo(comportamiento_compro, "Debe ingresar el comportamiento");
		Validar.noNulo(comprobante_entrega, "Debe ingresar el comportamiento de Entrega");
		Validar.noNulo(oid_detalle_compro, "Debe ingresar el Item Detalle de entrega");
	}

	public static List getAplicacionesPedido(ComproCab comproCab, Integer oidPedDet, ISesion aSesion)
			throws BaseException {

		return DBAplicDespachoPedido.getAplicacionesPedido(comproCab, oidPedDet, aSesion);

	}
	
	public static void anularAplicion(ComproCab comproCab,
			                              Integer oidDetalle,
			                              ISesion sesion) throws BaseException {
		
		boolean marcaPedCabComoPendDesp = false;
		
		Iterator iterAplicPedido = 
			AplicDespachoPedido.getAplicacionesPedido(comproCab,oidDetalle,sesion).iterator();
		
		while (iterAplicPedido.hasNext()) {
			
			AplicDespachoPedido aplicDespPed = (AplicDespachoPedido) iterAplicPedido.next();
			if (aplicDespPed.isActivo().booleanValue()==false) continue;
		
			CalculadorMoney calcNuevaCantDesp = new CalculadorMoney(new Money(aplicDespPed.getPedido_detalle().getCant_um_ori_desp().doubleValue()));
			calcNuevaCantDesp.restar(new Money(aplicDespPed.getCant_desp().doubleValue()));
			
			aplicDespPed.getPedido_detalle().setCant_um_ori_desp(calcNuevaCantDesp.getResultDecimal());
			
			if (aplicDespPed.getPedido_detalle().getCantPedidaMenosCantDesp().doubleValue()>0) {
				if (aplicDespPed.getPedido_detalle().isPendDesp().booleanValue()==false) {
					// Marca el detalle como pendiente de despacho
					aplicDespPed.getPedido_detalle().setPendDesp(new Boolean(true));
					
					// Marca el Pedido como pendiente de despacho
					marcaPedCabComoPendDesp = true;
				}
			}
			
			aplicDespPed.getPedido_detalle().save();
			
			// Grabar en el pedido las nuevas cantidades despachadas				
			if (marcaPedCabComoPendDesp = true) {
				if (aplicDespPed.getPedido_detalle().getPedido().isPendDesp().booleanValue()==false) {
  				   aplicDespPed.getPedido_detalle().getPedido().setPendDesp(new Boolean(true));
	  			   aplicDespPed.getPedido_detalle().getPedido().save();
				}
			}						
			
			// Marcar la Aplicacion como anulada
			aplicDespPed.delete();
			aplicDespPed.save(); 
			
			
		}
	}

}
