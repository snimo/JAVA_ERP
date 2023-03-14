package com.srn.erp.ventas.bm;

import java.util.Iterator;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AnuladorFactCabDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorFactCabDet() {
	}

	public static String NICKNAME = "ve.AnuladorFactCabDet";

	private AnuladorFactCab anulador_factura_cab;
	private FacturaDet factura_det;

	public AnuladorFactCab getAnulador_factura_cab() throws BaseException {
		supportRefresh();
		return anulador_factura_cab;
	}

	public void setAnulador_factura_cab(AnuladorFactCab aAnulador_factura_cab) {
		this.anulador_factura_cab = aAnulador_factura_cab;
	}

	public FacturaDet getFactura_det() throws BaseException {
		supportRefresh();
		return factura_det;
	}

	public void setFactura_det(FacturaDet aFactura_det) {
		this.factura_det = aFactura_det;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorFactCabDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorFactCabDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorFactCabDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AnuladorFactCabDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(anulador_factura_cab, "Debe ingresar el Anulador de Factura");
		Validar.noNulo(factura_det, "Debe ingresar el Detalle de Factura");
	}
	
	@Override
	public void afterSaveNew() throws BaseException {

		super.afterSaveNew();

		// Verificar si el desalle de la factura tiene aplicaciones facturadas contra el detalle del pedido
		Iterator iterAplicFactPed =
			AplicFacturadoPedido.getAplicFacturadoPedido(
					this.getFactura_det().getComprocab(),
					this.getFactura_det(),
					this.getSesion()).iterator();
		
		while (iterAplicFactPed.hasNext()) {
			AplicFacturadoPedido aplicFactPed = (AplicFacturadoPedido) iterAplicFactPed.next();
			aplicFactPed.delete();
			aplicFactPed.save();
		}
		
	}


}
