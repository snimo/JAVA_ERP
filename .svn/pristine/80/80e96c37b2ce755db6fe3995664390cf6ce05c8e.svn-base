package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.ctasAPagar.bm.ComproAnticipoProveedor;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.pagos.da.DBComproOrdenPagoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComproOrdenPagoDet extends ObjetoLogico {

	protected void beforeSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveNew();

		if (this.getTranprovvto() != null) {
			this.setValorCotizOriCon(tranProvVto.getTranprov()
					.getCotizmonedaoricon());
			this.setValorCotizExt1Con(tranProvVto.getTranprov()
					.getCotizmonedaext1con());
			this.setValorCotizExt2Con(tranProvVto.getTranprov()
					.getCotizmonedaext2con());
		} else if (this.getComproAntProv() != null) {
			this.setValorCotizOriCon(this.getComproAntProv().getCotizacion());
			this.setValorCotizExt1Con(this.getComproAntProv()
					.getValorCotizExt1());
			this.setValorCotizExt2Con(this.getComproAntProv()
					.getValorCotizExt2());
		}

	}

	public ComproOrdenPagoDet() {
	}

	public static String NICKNAME = "pag.ComproOrdenPagoDet";

	private ComproCab comprobante;
	private Moneda moneda;
	private Money impoFactMonOri;
	private Money dtoMonOri;
	private Money netoPagoMonOri;
	private Money impoFactMonPago;
	private Money dtoMonPago;
	private TranProvVto tranProvVto;
	private Money impoAutorizMonOri;
	private Money netoPagoMonPago;
	private Money impoMaxAutorizOri;
	private Money impoAutorizMonPago;
	private Money impoMaxAutorizPago;
	private ValorCotizacion valorCotizOriCon;
	private ValorCotizacion valorCotizExt1Con;
	private ValorCotizacion valorCotizExt2Con;
	private ValorCotizacion valorCotizOriHoy;
	private ValorCotizacion valorCotizExt1Hoy;
	private ValorCotizacion valorCotizExt2Hoy;
	private Money impoMaxAutoLoc;
	private Money impoAutoMonLoc;
	private Money impoFactMonLoc;
	private Money dtoMonLoc;
	private Money netoPagoMonLoc;
	private ComproAnticipoProveedor comproAntProv;
	private ConceptoOPVarias conceptoOPVarias;
	private String comentario;
	private ValorCotizacion valorCotizacion;

	private Money importeCuota;
	private Money saldoCuota;
	private Money autorizado;
	private Money pagar;

	public void setImporteCuota(Money aImporteCuota) {
		this.importeCuota = aImporteCuota;
	}

	public Money getImporteCuota() throws BaseException {
		supportRefresh();
		return this.importeCuota;
	}

	public void setSaldoCuota(Money aSaldoCuota) {
		this.saldoCuota = aSaldoCuota;
	}

	public Money getSaldoCuota() throws BaseException {
		supportRefresh();
		return this.saldoCuota;
	}

	public void setAutorizado(Money aAutorizado) {
		this.autorizado = aAutorizado;
	}

	public Money getAutorizado() throws BaseException {
		supportRefresh();
		return this.autorizado;
	}

	public void setPagar(Money aPagar) {
		this.pagar = aPagar;
	}

	public Money getPagar() throws BaseException {
		supportRefresh();
		return this.pagar;
	}

	public void setCotizacion(ValorCotizacion aValorCotizacion) {
		this.valorCotizacion = aValorCotizacion;
	}

	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return this.valorCotizacion;
	}

	public ComproOrdenPagoCab getComproOrdenDePago() throws BaseException {
		return (ComproOrdenPagoCab) this.getComprobante();
	}

	public Money getImpoMaxAutoLoc() throws BaseException {
		supportRefresh();
		return impoMaxAutoLoc;
	}

	public void setImpoMaxAutoLoc(Money aImpoMaxAutoLoc) {
		this.impoMaxAutoLoc = aImpoMaxAutoLoc;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return this.comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public ConceptoOPVarias getConceptoOPVarias() throws BaseException {
		supportRefresh();
		return this.conceptoOPVarias;
	}

	public void setConceptoOPVarias(ConceptoOPVarias aConceptoOPVarias) {
		this.conceptoOPVarias = aConceptoOPVarias;
	}

	public ComproAnticipoProveedor getComproAntProv() throws BaseException {
		supportRefresh();
		return this.comproAntProv;
	}

	public ComproCab getComprobantePagado() throws BaseException {
		if (this.getTranprovvto() != null)
			return this.getTranprovvto().getTranprov().getComprobante();
		else
			return this.getComproAntProv();
	}

	public void setComproAntProv(ComproAnticipoProveedor aComproAnticipoProv) {
		this.comproAntProv = aComproAnticipoProv;
	}

	public Money getImpoAutoMonLoc() throws BaseException {
		supportRefresh();
		return impoAutoMonLoc;
	}

	public void setImpoAutoMonLoc(Money aImpoAutoMonLoc) {
		this.impoAutoMonLoc = aImpoAutoMonLoc;
	}

	public Money getImpoFactMonloc() throws BaseException {
		supportRefresh();
		return impoFactMonLoc;
	}

	public void setImpoFactMonLoc(Money aImpoFactMonLoc) {
		this.impoFactMonLoc = aImpoFactMonLoc;
	}

	public Money getDtoMonloc() throws BaseException {
		supportRefresh();
		return dtoMonLoc;
	}

	public void setDtoMonLoc(Money aDtoMonLoc) throws BaseException {
		this.dtoMonLoc = aDtoMonLoc;
	}

	public Money getNetoPagoMonLoc() throws BaseException {
		supportRefresh();
		return netoPagoMonLoc;
	}

	public void setNetoPagoMonLoc(Money aPagoMonedaLoc) {
		this.netoPagoMonLoc = aPagoMonedaLoc;
	}

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public ValorCotizacion getValorCotizExt2Con() throws BaseException {
		supportRefresh();
		return valorCotizExt2Con;
	}

	public ValorCotizacion getValorCotizExt2Hoy() throws BaseException {
		supportRefresh();
		return valorCotizExt2Hoy;
	}

	public ValorCotizacion getValorCotizExt1Hoy() throws BaseException {
		supportRefresh();
		return valorCotizExt1Hoy;
	}

	public ValorCotizacion getValorCotizOriCon() throws BaseException {
		supportRefresh();
		return valorCotizOriCon;
	}

	public ValorCotizacion getValorCotizOriHoy() throws BaseException {
		supportRefresh();
		return valorCotizOriHoy;
	}

	public ValorCotizacion getValorCotizExt1Con() throws BaseException {
		supportRefresh();
		return valorCotizExt1Con;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public void setValorCotizExt2Con(ValorCotizacion valorCotizExt2Con) {
		this.valorCotizExt2Con = valorCotizExt2Con;
	}

	public void setValorCotizExt2Hoy(ValorCotizacion valorCotizExt2Hoy) {
		this.valorCotizExt2Hoy = valorCotizExt2Hoy;
	}

	public void setValorCotizExt1Hoy(ValorCotizacion valorCotizExt1Hoy) {
		this.valorCotizExt1Hoy = valorCotizExt1Hoy;
	}

	public void setValorCotizOriCon(ValorCotizacion valorCotizOriCon) {
		this.valorCotizOriCon = valorCotizOriCon;
	}

	public void setValorCotizOriHoy(ValorCotizacion valorCotizOriHoy) {
		this.valorCotizOriHoy = valorCotizOriHoy;
	}

	public void setValorCotizExt1Con(ValorCotizacion valorCotizExt1Con) {
		this.valorCotizExt1Con = valorCotizExt1Con;
	}

	public Money getImpofactmonori() throws BaseException {
		supportRefresh();
		return impoFactMonOri;
	}

	public void setImpofactmonori(Money aImpofactmonori) {
		this.impoFactMonOri = aImpofactmonori;
	}

	public Money getDtomonori() throws BaseException {
		supportRefresh();
		return dtoMonOri;
	}

	public Money getTotAplicMonOri() throws BaseException {
		CalculadorMoney totAplic = new CalculadorMoney(getNetopagomonori());
		totAplic.sumar(getDtomonori());
		return totAplic.getResultMoney();
	}

	public Money getTotAplicMonPago() throws BaseException {
		CalculadorMoney totAplic = new CalculadorMoney(getNetopagomonpago());
		totAplic.sumar(getDtomonpago());
		return totAplic.getResultMoney();
	}

	public void setDtomonori(Money aDtomonori) {
		this.dtoMonOri = aDtomonori;
	}

	public Money getNetopagomonori() throws BaseException {
		supportRefresh();
		return netoPagoMonOri;
	}

	public void setNetopagomonori(Money aNetopagomonori) {
		this.netoPagoMonOri = aNetopagomonori;
	}

	public Money getDtoMonHist() throws BaseException {
		supportRefresh();
		if (getMoneda().getOID() == Moneda.getMonedaCursoLegal(getSesion())
				.getOID())
			return getDtomonori();
		else {
			CalculadorMoney calcDtoMonHist = new CalculadorMoney(getDtomonori());
			calcDtoMonHist.multiplicarPor(getValorCotizOriHoy());
			return calcDtoMonHist.getResultMoney();
		}
	}

	public Money getDtoMonAju() throws BaseException {
		return getDtoMonHist();
	}

	public Money getNetoPagoMonHist() throws BaseException {
		supportRefresh();
		if (getMoneda().getOID() == Moneda.getMonedaCursoLegal(getSesion())
				.getOID())
			return getNetopagomonori();
		else {
			CalculadorMoney calcImpoMonHist = new CalculadorMoney(
					getNetopagomonori());
			calcImpoMonHist.multiplicarPor(getValorCotizOriHoy());
			return calcImpoMonHist.getResultMoney();
		}
	}

	public Money getNetoPagoMonAju() throws BaseException {
		return getNetoPagoMonHist();
	}

	public Money getNetoPagoMonExt1() throws BaseException {
		if (getMoneda().getOID() == Moneda.getMonedaExt1(getSesion()).getOID())
			return getNetopagomonori();
		else {
			CalculadorMoney calcMonedaExt1 = new CalculadorMoney(
					getNetopagomonori());
			calcMonedaExt1.multiplicarPor(getValorCotizOriHoy());
			calcMonedaExt1.dividirPor(getValorCotizExt1Hoy());
			return calcMonedaExt1.getResultMoney();
		}
	}

	public Money getDtoMonExt1() throws BaseException {
		if (getMoneda().getOID() == Moneda.getMonedaExt1(getSesion()).getOID())
			return getDtomonori();
		else {
			CalculadorMoney calcDtoMonedaExt1 = new CalculadorMoney(
					getDtomonori());
			calcDtoMonedaExt1.multiplicarPor(getValorCotizOriHoy());
			calcDtoMonedaExt1.dividirPor(getValorCotizExt1Hoy());
			return calcDtoMonedaExt1.getResultMoney();
		}
	}

	public Money getDtoMonExt2() throws BaseException {
		if (getMoneda().getOID() == Moneda.getMonedaExt2(getSesion()).getOID())
			return getDtomonori();
		else {
			CalculadorMoney calcDtoMonedaExt2 = new CalculadorMoney(
					getDtomonori());
			calcDtoMonedaExt2.multiplicarPor(getValorCotizOriHoy());
			calcDtoMonedaExt2.dividirPor(getValorCotizExt1Hoy());
			return calcDtoMonedaExt2.getResultMoney();
		}
	}

	public Money getNetoPagoMonExt2() throws BaseException {
		if (getMoneda().getOID() == Moneda.getMonedaExt2(getSesion()).getOID())
			return getNetopagomonori();
		else {
			CalculadorMoney calcMonedaExt2 = new CalculadorMoney(
					getNetopagomonori());
			calcMonedaExt2.multiplicarPor(getValorCotizOriHoy());
			calcMonedaExt2.dividirPor(getValorCotizExt2Hoy());
			return calcMonedaExt2.getResultMoney();
		}
	}

	public Money getImpofactmonpago() throws BaseException {
		supportRefresh();
		return impoFactMonPago;
	}

	public void setImpofactmonpago(Money aImpofactmonpago) {
		this.impoFactMonPago = aImpofactmonpago;
	}

	public Money getDtomonpago() throws BaseException {
		supportRefresh();
		return dtoMonPago;
	}

	public void setDtomonpago(Money aDtomonpago) {
		this.dtoMonPago = aDtomonpago;
	}

	public TranProvVto getTranprovvto() throws BaseException {
		supportRefresh();
		return tranProvVto;
	}

	public void setTranprovvto(TranProvVto aTranprovvto) {
		this.tranProvVto = aTranprovvto;
	}

	public Money getImpoautorizmonori() throws BaseException {
		supportRefresh();
		return impoAutorizMonOri;
	}

	public void setImpoautorizmonori(Money aImpoautorizmonori) {
		this.impoAutorizMonOri = aImpoautorizmonori;
	}

	public Money getNetopagomonpago() throws BaseException {
		supportRefresh();
		return netoPagoMonPago;
	}

	public void setNetopagomonpago(Money aNetopagomonpago) {
		this.netoPagoMonPago = aNetopagomonpago;
	}

	public Money getImpomaxautorizori() throws BaseException {
		supportRefresh();
		return impoMaxAutorizOri;
	}

	public void setImpomaxautorizori(Money aImpomaxautorizori) {
		this.impoMaxAutorizOri = aImpomaxautorizori;
	}

	public Money getImpoautorizmonpago() throws BaseException {
		supportRefresh();
		return impoAutorizMonPago;
	}

	public void setImpoautorizmonpago(Money aImpoautorizmonpago) {
		this.impoAutorizMonPago = aImpoautorizmonpago;
	}

	public Money getImpomaxautorizpago() throws BaseException {
		supportRefresh();
		return impoMaxAutorizPago;
	}

	public void setImpomaxautorizpago(Money aImpomaxautorizpago) {
		this.impoMaxAutorizPago = aImpomaxautorizpago;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproOrdenPagoDet findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproOrdenPagoDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproOrdenPagoDet findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (ComproOrdenPagoDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		Validar.noNulo(comprobante, "Debe ingresar el comprobante");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");

		if (this.getComproOrdenDePago().getTipoCompro().esOrdenDePago()) {
			Validar.noNulo(impoFactMonOri,
					"Debe Ingresar el Importe en Moneda Origen");
			Validar.noNulo(dtoMonOri,
					"Debe ingresar el descuento en Moneda Origen");
			Validar.noNulo(impoFactMonPago,
					"Debe ingresar el importe en Moneda Pago");
			Validar.noNulo(dtoMonPago,
					"Debe ingresar el Descuento en Moneda Pago");
			Validar.noNulo(impoAutorizMonOri,
					"Debe ingresar el Máximo Autorizado en Moneda Ori.");
			Validar.noNulo(impoMaxAutorizOri,
					"Debe ingresar el Importe Max. Autoriz. en Mon. Ori");
			Validar.noNulo(impoAutorizMonPago,
					"Debe ingresar el Importe Autoriz. en Moneda Pago");
			Validar.noNulo(impoMaxAutorizPago,
					"Debe ingresar el Importe Máx. Autoriz. Pago");
			Validar
					.noNulo(impoMaxAutoLoc,
							"Debe ingresar el importe Máximo Autorizado en Moneda Local");
			Validar.noNulo(impoAutoMonLoc,
					"Debe ingresar el importe autorizado en Moneda Local");
			Validar.noNulo(impoFactMonLoc,
					"Debe ingresar el importe en moneda local");
			Validar.noNulo(dtoMonLoc,
					"Debe ingresar el descuento en moneda local");
		}

		Validar.noNulo(netoPagoMonOri,
				"Debe ingresar el Neto a Pagar en Moneda Origen");
		Validar.noNulo(netoPagoMonPago,
				"Debe ingresar el neto a Pagar en Moneda Pago");
		Validar.noNulo(netoPagoMonLoc,
				"Debe ingresar el neto Pagado en moneda local");
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
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	public void afterSave() throws BaseException {
		if (this.getComproOrdenDePago().getTipoCompro().esOrdenDePago())
			grabarDescuentos();
	}

	private void grabarDescuentos() throws BaseException {
		DtoComproEnOP dtoComproEnOP = (DtoComproEnOP) DtoComproEnOP.getNew(
				DtoComproEnOP.NICKNAME, getSesion());
		dtoComproEnOP.setComproop(getComprobante());
		dtoComproEnOP.setComproprov(this.getComprobantePagado());
		dtoComproEnOP.setDtomonloc(getDtoMonloc());
		dtoComproEnOP.setDtomonori(getDtomonori());
		dtoComproEnOP.setFecha(getComprobante().getEmision());
		dtoComproEnOP.setActivo(new Boolean(true));
		dtoComproEnOP.save();
	}

	public static List getOrdPagoDet(ComproCab comproCab, ISesion aSesion)
			throws BaseException {
		return DBComproOrdenPagoDet.getOrdPagoDet(comproCab, aSesion);
	}

	public boolean isAnticipo() throws BaseException {
		if (IdentificacionTipoComprobante.esAnticipoProveedor(this
				.getComprobantePagado().getTipoCompro().getIdentificacion()))
			return true;
		else
			return false;
	}

}
