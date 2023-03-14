package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.tesoreria.da.DBValoresReciboAnulado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ValoresReciboAnulado extends ObjetoLogico {

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

	public ValoresReciboAnulado() {
	}

	public static String NICKNAME = "te.ValoresReciboAnulado";

	private AnuladorRecibo anulador_recibo;
	private ValoresRecibo valor_recibo;

	public AnuladorRecibo getAnulador_recibo() throws BaseException {
		supportRefresh();
		return anulador_recibo;
	}

	public void setAnulador_recibo(AnuladorRecibo aAnulador_recibo) {
		this.anulador_recibo = aAnulador_recibo;
	}

	public ValoresRecibo getValor_recibo() throws BaseException {
		supportRefresh();
		return valor_recibo;
	}

	public void setValor_recibo(ValoresRecibo aValor_recibo) {
		this.valor_recibo = aValor_recibo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ValoresReciboAnulado findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ValoresReciboAnulado) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ValoresReciboAnulado findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ValoresReciboAnulado) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(anulador_recibo, "Debe ingresar el Anulador Recibo");
		Validar.noNulo(valor_recibo, "Debe ingresar el Valor del Recibo");
	}

	public static List getValoresReciboAnulados(AnuladorRecibo anuladorRecibo, ISesion aSesion) throws BaseException {
		return DBValoresReciboAnulado.getValoresReciboAnulados(anuladorRecibo, aSesion);
	}

	public void afterSave() throws BaseException {

		super.afterSave();

		// Por la anulacion del Valor el mismo debe salir de la caja
		Caja caja = null;
		if (this.getValor_recibo().getTipo_valor().isEfectivo())
			caja = this.getAnulador_recibo().getRecibo().getCaja();
		else
			caja = this.getValor_recibo().getValor().getCaja();

		// Si el valor es efectivo
		MedioPago medioPago = new MedioPago();
		medioPago.setSesion(getSesion());
		medioPago.setComprobante(this.getAnulador_recibo());
		medioPago.setIngresoEgreso(MedioPago.EGRESO);
		medioPago.setValor(this.getValor_recibo().getValor());
		medioPago.setTipoValor(this.getValor_recibo().getTipo_valor());
		medioPago.setCaja(caja);
		medioPago.setDevolucion(true);
		medioPago.setImporteMonedaValor(this.getValor_recibo().getImpo_mon_ori());
		medioPago.setCotizMonedaValor(this.getValor_recibo().getCotizacion());
		medioPago.setIsAnulacionRecibo(true);

		medioPago.save();

	}

}
