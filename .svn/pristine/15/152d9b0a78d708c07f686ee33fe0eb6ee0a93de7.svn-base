package com.srn.erp.ventas.bm;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MedioPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AnuladorCobVtaMos extends ObjetoLogico {

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

	public AnuladorCobVtaMos() {
	}

	public static String NICKNAME = "ve.AnuladorCobVtaMos";

	private CobranzaVtaMostrador cobranza_vta_mos;
	private AnuladorFactCab anulador_factura_cab;

	public CobranzaVtaMostrador getCobranza_vta_mos() throws BaseException {
		supportRefresh();
		return cobranza_vta_mos;
	}

	public void setCobranza_vta_mos(CobranzaVtaMostrador aCobranza_vta_mos) {
		this.cobranza_vta_mos = aCobranza_vta_mos;
	}

	public AnuladorFactCab getAnuladorFactura_cab() throws BaseException {
		supportRefresh();
		return anulador_factura_cab;
	}

	public void setAnuladorFactura_cab(AnuladorFactCab aAnuladorFactura_cab) {
		this.anulador_factura_cab = aAnuladorFactura_cab;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorCobVtaMos findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorCobVtaMos) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorCobVtaMos findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (AnuladorCobVtaMos) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(cobranza_vta_mos,
				"Debe ingresar la Cobranza Venta Mostrador");
	}

	public void afterSave() throws BaseException {

		super.afterSave();

		// Por la anulacion del Valor el mismo debe salir de la caja
		Caja caja = this.getAnuladorFactura_cab().getFactura_cab().getCaja();

		// Si el valor es efectivo
		MedioPago medioPago = new MedioPago();
		medioPago.setSesion(getSesion());
		medioPago.setComprobante(this.getAnuladorFactura_cab());
		medioPago.setIngresoEgreso(MedioPago.EGRESO);
		medioPago.setValor(this.getCobranza_vta_mos().getValor());
		medioPago.setTipoValor(this.getCobranza_vta_mos().getTipo_valor());
		medioPago.setCaja(caja);
		medioPago.setDevolucion(true);
		medioPago.setImporteMonedaValor(this.getCobranza_vta_mos().getImpo_mon_tv());
		medioPago.setCotizMonedaValor(this.getCobranza_vta_mos().getCotizacion());

		medioPago.save();

	}

}
