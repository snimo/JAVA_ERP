package com.srn.erp.tesoreria.bm;

import java.util.Date;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class CertificadoRetencionIB extends ValorBase {

	public static String		ENTRADA	= "ENTRADA";

	public static String		SALIDA	= "SALIDA";

	private ISesion					sesion;

	private TipoValor				tipoValor;

	private Valor						valorCertificado;

	private Date						fechaEmision;

	private Date						fechaContable;

	private Money						importe;

	private String					tipoOper;

	private ComproCab				comprobante;

	private Money						importeHist;

	private Money						importeAju;

	private Money						importeExt1;

	private Money						importeExt2;

	private ValorCotizacion	cotizMonOri;

	private ValorCotizacion	cotizMonExt1;

	private ValorCotizacion	cotizMonExt2;

	private ValorCotizacion	cotizMonOriCon;

	private ValorCotizacion	cotizMonExt1Con;

	private ValorCotizacion	cotizMonExt2Con;

	private String					nroCertificado;

	private Caja						caja;

	private Sujeto					sujeto;

	private Provincia				provincia;

	public Caja getCaja() throws BaseException {
		return caja;
	}

	public void setCaja(Caja aCaja) throws BaseException {
		this.caja = aCaja;
	}

	public String getNroCertificado() throws BaseException {
		return this.nroCertificado;
	}

	public void setNroCertificado(String aNroCertificado) throws BaseException {
		this.nroCertificado = aNroCertificado;
	}
	
	public Provincia getProvincia() throws BaseException {
		return this.provincia;
	}

	public void setProvincia(Provincia aProvincia) throws BaseException {
		this.provincia = aProvincia;
	}
	

	public Valor getValorCertificado() throws BaseException {
		return this.valorCertificado;
	}

	public void setValorCertificado(Valor aValorCertificado) throws BaseException {
		this.valorCertificado = aValorCertificado;
	}

	public Sujeto getSujeto() throws BaseException {
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) throws BaseException {
		this.sujeto = aSujeto;
	}

	public String getTipoOper() throws BaseException {
		return this.tipoOper;
	}

	public ValorCotizacion getCotizMonOri() throws BaseException {
		return cotizMonOri;
	}

	public void setCotizMonOri(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonOri = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt1() throws BaseException {
		return cotizMonExt1;
	}

	public void setCotizMonExt1(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt1 = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt2() throws BaseException {
		return cotizMonExt2;
	}

	public void setCotizMonExt2(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt2 = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonOriCon() throws BaseException {
		return cotizMonOriCon;
	}

	public void setCotizMonOriCon(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonOriCon = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt1Con() throws BaseException {
		return cotizMonExt1Con;
	}

	public void setCotizMonExt1Con(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt1Con = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt2Con() throws BaseException {
		return cotizMonExt2Con;
	}

	public void setCotizMonExt2Con(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt2Con = aValorCotizacion;
	}

	public void setComprobante(ComproCab aComproCAB) {
		this.comprobante = aComproCAB;
	}

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public void setTipoOper(String aTipoOper) {
		this.tipoOper = aTipoOper;
	}

	public Money getImporte() {
		return importe;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaContable(Date aFechaContable) {
		this.fechaContable = aFechaContable;
	}

	public void setImporte(Money importe) {
		this.importe = importe;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public void setSesion(ISesion sesion) {
		this.sesion = sesion;
	}

	public void setTipoValor(TipoValor tipoValor) {
		this.tipoValor = tipoValor;
	}

	public void setImporteAju(Money importeAju) {
		this.importeAju = importeAju;
	}

	public void setImporteExt1(Money importeExt1) {
		this.importeExt1 = importeExt1;
	}

	public void setImporteHist(Money importeHist) {
		this.importeHist = importeHist;
	}

	public void setImporteExt2(Money importeExt2) {
		this.importeExt2 = importeExt2;
	}

	public Date getFechaContable() {
		return fechaContable;
	}

	public ISesion getSesion() {
		return sesion;
	}

	public TipoValor getTipoValor() {
		return tipoValor;
	}

	public Money getImporteAju() {
		return importeAju;
	}

	public Money getImporteExt1() {
		return importeExt1;
	}

	public Money getImporteHist() {
		return importeHist;
	}

	public Money getImporteExt2() {
		return importeExt2;
	}

	public CertificadoRetencionIB() {
	}

	public void beforeSave() throws BaseException {
		validarDatosChequePropio();
	}

	public void validarDatosChequePropio() throws BaseException {

		if ((this.getNroCertificado() == null) || (this.getNroCertificado().trim().equals("")))
			throw new ExceptionValidation(null, "Debe ingresar el Nro. de Certificado");
		if (getTipoValor() == null)
			throw new ExceptionValidation(null, "Debe ingresar el tipo de Valor");
		if (getFechaEmision() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión");
		if (getImporte() == null)
			throw new ExceptionValidation(null, "Debe ingresar el Importe");
		if (this.getProvincia() == null)
			throw new ExceptionValidation(null, "Debe ingresar la provincia");
		
	}

	public void save() throws BaseException {
		
		if (this.getTipoOper().equals(ENTRADA)) {
			beforeSave();
			valorCertificado = (Valor) Valor.getNew(Valor.NICKNAME, getSesion());
			valorCertificado.setTipovalor(getTipoValor());
			valorCertificado.setCaja(this.getCaja());
			valorCertificado.setFechaemision(getFechaEmision());
			valorCertificado.setAnulado(new Boolean(false));
			valorCertificado.setEndosado(new Boolean(false));
			valorCertificado.setDepositado(new Boolean(false));
			valorCertificado.setRechazado(new Boolean(false));
			valorCertificado.setCobrado(new Boolean(false));
			valorCertificado.setRecibido(new Boolean(false));
			valorCertificado.setSujeto(this.getSujeto());
			valorCertificado.setImporte(getImporte());
			valorCertificado.setSaldo(getImporte());
			if (this.getTipoValor().isSeguimientoCaja())
				valorCertificado.setEstaencaja(new Boolean(true));
			else
				valorCertificado.setEstaencaja(new Boolean(false));
			valorCertificado.setUsuario(getSesion().getLogin().getUsuario());
			valorCertificado.setCotizacion(getCotizMonOri());
			valorCertificado.setNroCertificado(this.getNroCertificado());
			valorCertificado.setProvincia(this.getProvincia());
			valorCertificado.save();
		}  else {
			if (this.depositar())
				depositarCertificado();
			else if (this.isDevolucion())
				devolverCertificado();
			else if (this.isLiquidando())
				liquidarCertificado();
			
    	
    }
		
		afterSave();
	}
	
	private void devolverCertificado() throws BaseException {
		// Marcar el cheque como depositado
		this.getValorCertificado().supportRefresh();
		this.getValorCertificado().setDevuelto(true);
		this.getValorCertificado().setEstaencaja(new Boolean(false));
		this.getValorCertificado().save();
	}
  
	private void depositarCertificado() throws BaseException {
		// Marcar el cheque como depositado
		this.getValorCertificado().supportRefresh();
		this.getValorCertificado().setDepositado(new Boolean(true));
		this.getValorCertificado().setEstaencaja(new Boolean(false));
		this.getValorCertificado().save();
	}
	

	public void afterSave() throws BaseException {
		if ((this.getTipoValor()!=null) && (this.getTipoValor().isSeguimientoCaja()!=null) && (this.getTipoValor().isSeguimientoCaja().booleanValue() == false))
			return;
		
		if ((this.getValorCertificado()!=null) && (this.getValorCertificado().getTipovalor()!=null) && (this.getValorCertificado().getTipovalor().isSeguimientoCaja()!=null) && (this.getValorCertificado().getTipovalor().isSeguimientoCaja().booleanValue()==false))
			return;
		
		movimientoArqueo();
	}

	private void movimientoArqueo() throws BaseException {
		MovimientoCaja movCaja = (MovimientoCaja) MovimientoCaja.getNew(MovimientoCaja.NICKNAME, getSesion());
		movCaja.setCaja(getCaja());
		movCaja.setComprobante(getComprobante());
		movCaja.setFechacaja(getCaja().getFechaCaja());
		movCaja.setValor(this.getValorCertificado());
		if (getTipoOper().equals(ENTRADA)) {
			movCaja.setSigno(new Integer(1));
			movCaja.setEntrada(getImporte());
			movCaja.setSalida(new Money(0));
		}
		else {
			movCaja.setSigno(new Integer(-1));
			movCaja.setEntrada(new Money(0));
			movCaja.setSalida(getImporte());
		}
		movCaja.setImporte(getImporte());
		movCaja.setSujeto(getSujeto());
		movCaja.setMoneda(getTipoValor().getMoneda());
		movCaja.setTipovalor(getTipoValor());
		movCaja.setCompotipovalor(getTipoValor().getCompo());
		movCaja.setCotizacion(getCotizMonOri());
		movCaja.setFechaReal(Fecha.getFechaActual());
		movCaja.setHora(Fecha.getHoraActual());
		movCaja.setUsuario(sesion.getLogin().getUsuario());
		movCaja.setActivo(new Boolean(true));
		movCaja.save();

	}
	
	private void liquidarCertificado() throws BaseException {
		// Marcar el cheque como depositado
		this.getValorCertificado().supportRefresh();
		this.getValorCertificado().setLiquidado(new Boolean(true));
		this.getValorCertificado().setEstaencaja(new Boolean(false));
		this.getValorCertificado().save();
	}
	

}
