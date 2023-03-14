package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBAplicFacturadoRemito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AplicFacturadoRemito extends ObjetoLogico {

	public AplicFacturadoRemito() {
	}

	public static String	NICKNAME	= "ve.AplicFacturadoRemito";

	private RemitoDet			remito_det;

	private Double				cant_fact;

	private String				compo_compro;

	private FacturaCab		factura;

	private FacturaDet		factura_det;

	private Boolean				activo;

	public RemitoDet getRemito_det() throws BaseException {
		supportRefresh();
		return remito_det;
	}

	public void setRemito_det(RemitoDet aRemito_det) {
		this.remito_det = aRemito_det;
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

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
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

	public static AplicFacturadoRemito findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AplicFacturadoRemito) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AplicFacturadoRemito findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AplicFacturadoRemito) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(remito_det, "Debe ingresar el Detalle del Remito");
		Validar.noNulo(compo_compro, "Debe ingresar el comportamiento");
		Validar.noNulo(factura, "Debe ingresar la Factura");
		Validar.noNulo(factura_det, "Debe ingresar la Factura Detalle");
	}
	
	private void aplicarCantFactContraDetPed() throws BaseException {
		AplicFacturadoPedido aplicFactPed = 
			(AplicFacturadoPedido) AplicFacturadoPedido.getNew(AplicFacturadoPedido.NICKNAME,getSesion());
		aplicFactPed.setPedido_det(this.getRemito_det().getPedidoDet());
		aplicFactPed.setCant_fact(this.getCant_fact());
		aplicFactPed.setCompo_compro(this.getFactura().getTipoCompro().getIdentificacion());
		aplicFactPed.setFactura(this.getFactura());
		aplicFactPed.setFactura_det(this.getFactura_det());
		aplicFactPed.setActivo(new Boolean(true));
		aplicFactPed.save();
	}
	

	public void afterSaveNew() throws BaseException {
		super.afterSaveNew();

		if ((this.getRemito_det().getPedidoDet()!=null) &&
				(this.getRemito_det().getPedidoDet().getProducto().getOID() == this.getRemito_det().getProducto().getOID()) &&
				(this.getRemito_det().getPedidoDet().isAnulado().booleanValue()==false) &&
				(this.getRemito_det().getPedidoDet().getPedido().isActivo().booleanValue()==true))
				aplicarCantFactContraDetPed();
		
		// Aplicar lo facturado contra el Detalle de los Remitos
		CalculadorMoney acumCantFact = new CalculadorMoney(new Money(this.getCant_fact().doubleValue()));
		acumCantFact.sumar(new Money(this.getRemito_det().getCant_fact().doubleValue()));
		this.getRemito_det().setCant_fact(new Double(acumCantFact.getResultDecimal().doubleValue()));
		this.getRemito_det().save();
		
	}
	
  public static List getAplicRemitosFact(FacturaCab factura,
      ISesion aSesion) throws BaseException {
  	return DBAplicFacturadoRemito.getAplicRemitosFact(factura,aSesion);
  }
	

}
