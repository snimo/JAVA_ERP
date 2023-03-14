package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBComproConta;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ComproConta extends ObjetoLogico {

	public ComproConta() {
	}

	public static String NICKNAME = "cg.ComproConta";

	public static int min_secu_debe = 1;

	public static int min_secu_haber = 15000;

	private ValorParametro maxDifBalanceo = null;

	private Date imputac;

	private Boolean cierre;

	private Periodo periodo;

	private Diario diario;

	private IContabilizable contabilizable;

	private Boolean anulado;

	private ComproCab comprobante;

	private List detalles = new ArrayList();

	private boolean readDetallesAsiento = true;
	
	
	

	public void setContabilizable(IContabilizable aContabilizable)
			throws BaseException {
		this.contabilizable = aContabilizable;
		setManualOID(aContabilizable.getComprobante().getOIDInteger());
		setImputac(aContabilizable.getImputacion());
		Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(aContabilizable
				.getImputacion(), getSesion());
		setPeriodo(periodo);
		setCierre(new Boolean(false));
	}

	private Integer getNextSecu(Integer debe_o_haber) throws BaseException {
		Integer nextSecu;
		if (debe_o_haber.intValue() == 1) {
			nextSecu = new Integer(min_secu_debe);
			++min_secu_debe;
		} else {
			nextSecu = new Integer(min_secu_haber);
			++min_secu_haber;
		}
		return nextSecu;
	}

	public double getMaxDifPermitidaBalanceo() throws BaseException {
		if (maxDifBalanceo == null)
			maxDifBalanceo = ValorParametro.findByCodigoParametro(
					"MAX_DIF_BALANCEO_ASIENTO_CONTA", getSesion());
		return maxDifBalanceo.getValorDecimal().doubleValue();
	}

	public IContabilizable getContabilizable() throws BaseException {
		return this.contabilizable;
	}

	public Date getImputac() throws BaseException {
		supportRefresh();
		return imputac;
	}

	public void setImputac(Date aImputac) {
		this.imputac = aImputac;
	}

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return this.comprobante;
	}

	public void setComprobante(ComproCab aComproCab) throws BaseException {
		this.comprobante = aComproCab;
	}

	public Boolean isCierre() throws BaseException {
		supportRefresh();
		return cierre;
	}

	public void setCierre(Boolean aCierre) {
		this.cierre = aCierre;
	}

	public Periodo getPeriodo() throws BaseException {
		supportRefresh();
		return periodo;
	}

	public void setPeriodo(Periodo aPeriodo) {
		this.periodo = aPeriodo;
	}

	public Diario getDiario() throws BaseException {
		supportRefresh();
		return diario;
	}

	public void setDiario(Diario aDiario) {
		this.diario = aDiario;
	}

	public Boolean isAnulado() throws BaseException {
		supportRefresh();
		return anulado;
	}

	public void setAnulado(Boolean anulado) throws BaseException {
		this.anulado = anulado;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproConta findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproConta) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproConta findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproConta) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		if (this.isNew()) {
			verificarBalanceo();
			beforeSaveComprobanteConta();
		}
	}

	private void verificarBalanceo() throws BaseException {

		String MENSAJE_BALANCEO = "No balancea el asiento en la moneda ";
		String DIFERENCIA = ". Diferencia ";

		if (detalles.size() == 0)
			throw new ExceptionValidation(null, "Asiento sin items");

		ComproContaDet maxConproContaDetDebe = null;
		ComproContaDet maxConproContaDetHaber = null;

		CalculadorMoney calcTotLocHist = new CalculadorMoney(
				new NumeroBase(0.0));
		CalculadorMoney calcTotLocAju = new CalculadorMoney(new NumeroBase(0.0));
		CalculadorMoney calcTotMonExt1 = new CalculadorMoney(
				new NumeroBase(0.0));
		CalculadorMoney calcTotMonExt2 = new CalculadorMoney(
				new NumeroBase(0.0));

		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			ComproContaDet comproContaDet = (ComproContaDet) iterDetalles
					.next();
			if (comproContaDet.getSigno().intValue() == 1) {
				calcTotLocHist.sumar(comproContaDet.getImpoLocHist());
				calcTotLocAju.sumar(comproContaDet.getImpoLocAju());
				calcTotMonExt1.sumar(comproContaDet.getImpoMonExt1());
				calcTotMonExt2.sumar(comproContaDet.getImpoMonExt2());
			} else {
				calcTotLocHist.restar(comproContaDet.getImpoLocHist());
				calcTotLocAju.restar(comproContaDet.getImpoLocAju());
				calcTotMonExt1.restar(comproContaDet.getImpoMonExt1());
				calcTotMonExt2.restar(comproContaDet.getImpoMonExt2());
			}

			// Determinar el Item de Mayor Valor para el debe y el Haber
			if (comproContaDet.getSigno().intValue() == 1) {
				if (maxConproContaDetDebe == null)
					maxConproContaDetDebe = comproContaDet;
				else if (maxConproContaDetDebe.getImpoLocHist().doubleValue() < comproContaDet
						.getImpoLocHist().doubleValue())
					maxConproContaDetDebe = comproContaDet;
			} else {
				if (maxConproContaDetHaber == null)
					maxConproContaDetHaber = comproContaDet;
				else if (maxConproContaDetHaber.getImpoLocHist().doubleValue() < comproContaDet
						.getImpoLocHist().doubleValue())
					maxConproContaDetHaber = comproContaDet;

			}

			comproContaDet = null;
		}

		double difImpoLocHist = calcTotLocHist.getResult();
		if (Math.abs(difImpoLocHist) > getMaxDifPermitidaBalanceo())
			throw new ExceptionValidation(null, MENSAJE_BALANCEO
					+ Moneda.getMonedaCursoLegal(getSesion()).getDescripcion()
					+ DIFERENCIA + new Double(difImpoLocHist));
		else if (difImpoLocHist > 0) {
			CalculadorMoney totReajLocHist = new CalculadorMoney(new Money(Math
					.abs(difImpoLocHist)));
			totReajLocHist.sumar(maxConproContaDetHaber.getImpoLocHist());
			maxConproContaDetHaber.setImpoLocHist(totReajLocHist
					.getResultMoney());
		} else if (difImpoLocHist < 0) {
			CalculadorMoney totReajLocHist = new CalculadorMoney(new Money(Math
					.abs(difImpoLocHist)));
			totReajLocHist.sumar(maxConproContaDetDebe.getImpoLocHist());
			maxConproContaDetDebe.setImpoLocHist(totReajLocHist
					.getResultMoney());
		}

		double difImpoLocAju = calcTotLocAju.getResult();
		if (Math.abs(difImpoLocAju) > getMaxDifPermitidaBalanceo())
			throw new ExceptionValidation(null, MENSAJE_BALANCEO
					+ Moneda.getMonedaCursoLegal(getSesion()).getDescripcion()
					+ " Ajustados" + DIFERENCIA + new Double(difImpoLocAju));
		else if (difImpoLocAju > 0) {
			CalculadorMoney totReajLocAju = new CalculadorMoney(new Money(Math
					.abs(difImpoLocAju)));
			totReajLocAju.sumar(maxConproContaDetHaber.getImpoLocAju());
			maxConproContaDetHaber
					.setImpoLocAju(totReajLocAju.getResultMoney());
		} else if (difImpoLocAju < 0) {
			CalculadorMoney totReajLocAju = new CalculadorMoney(new Money(Math
					.abs(difImpoLocAju)));
			totReajLocAju.sumar(maxConproContaDetDebe.getImpoLocAju());
			maxConproContaDetDebe.setImpoLocAju(totReajLocAju.getResultMoney());
		}

		double difImpoMonExt1 = calcTotMonExt1.getResult();
		if (Math.abs(difImpoMonExt1) > getMaxDifPermitidaBalanceo())
			throw new ExceptionValidation(null, MENSAJE_BALANCEO
					+ Moneda.getMonedaExt1(getSesion()).getDescripcion()
					+ DIFERENCIA + new Double(difImpoMonExt1));
		else if (difImpoMonExt1 > 0) {
			CalculadorMoney totReajMonExt1 = new CalculadorMoney(new Money(Math
					.abs(difImpoMonExt1)));
			totReajMonExt1.sumar(maxConproContaDetHaber.getImpoMonExt1());
			maxConproContaDetHaber.setImpoMonExt1(totReajMonExt1
					.getResultMoney());
		} else if (difImpoMonExt1 < 0) {
			CalculadorMoney totReajMonExt1 = new CalculadorMoney(new Money(Math
					.abs(difImpoMonExt1)));
			totReajMonExt1.sumar(maxConproContaDetDebe.getImpoMonExt1());
			maxConproContaDetDebe.setImpoMonExt1(totReajMonExt1
					.getResultMoney());
		}

		double difImpoMonExt2 = calcTotMonExt2.getResult();
		if (Math.abs(difImpoMonExt2) > getMaxDifPermitidaBalanceo())
			throw new ExceptionValidation(null, MENSAJE_BALANCEO
					+ Moneda.getMonedaExt2(getSesion()).getDescripcion()
					+ DIFERENCIA + new Double(difImpoMonExt2));
		else if (difImpoMonExt2 > 0) {
			CalculadorMoney totReajMonExt2 = new CalculadorMoney(new Money(Math
					.abs(difImpoMonExt2)));
			totReajMonExt2.sumar(maxConproContaDetHaber.getImpoMonExt2());
			maxConproContaDetHaber.setImpoMonExt2(totReajMonExt2
					.getResultMoney());
		} else if (difImpoMonExt2 < 0) {
			CalculadorMoney totReajMonExt2 = new CalculadorMoney(new Money(Math
					.abs(difImpoMonExt2)));
			totReajMonExt2.sumar(maxConproContaDetDebe.getImpoMonExt2());
			maxConproContaDetDebe.setImpoMonExt2(totReajMonExt2
					.getResultMoney());
		}

		iterDetalles = null;
	}

	public void afterSave() throws BaseException {
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			ComproContaDet comproContaDet = (ComproContaDet) iterDetalles
					.next();
			comproContaDet.setSecu(getNextSecu(comproContaDet.getSigno()));

			comproContaDet.save();
			comproContaDet = null;
		}
		iterDetalles = null;
	}

	private Diario getDiario(TipoComprobante tc, java.util.Date fecha)
			throws BaseException {
		Diario diario = Diario.getDiarioByFechayTC(fecha, tc, getSesion());
		return diario;
	}

	private Diario grabarDiario() throws BaseException {
		Diario diario = getDiario(getContabilizable().getComprobante()
				.getTipoCompro(), getImputac());
		if (diario == null) {
			diario = Diario.getNewDiario(getSesion());
			diario.setTipocomprobante(getContabilizable().getComprobante()
					.getTipoCompro());
			diario.setImputac(getImputac());
			diario.setCierre(new Boolean(false));
			diario.setComentario(getContabilizable().getComprobante()
					.getTipoCompro().getLeyenda().getDescripcion());
			diario.save();
		}
		return diario;
	}

	private void validacionesBasicas() throws BaseException {
		if (periodo == null)
			throw new ExceptionValidation(null, "Falta ingresar el Período contable");
	}

	public void beforeSaveComprobanteConta() throws BaseException {
		validacionesBasicas();
		Diario diario = grabarDiario();
		this.setDiario(diario);
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

	public static ComproConta getNewComprobante(ISesion aSesion)
			throws BaseException {
		return (ComproConta) ComproConta.getNew(ComproConta.NICKNAME, aSesion);
	}

	public ComproContaDet addDetalle() throws BaseException {
		ComproContaDet comproContaDet = ComproContaDet
				.getNewDetalle(getSesion());
		comproContaDet.setComprobante(this);
		detalles.add(comproContaDet);
		return comproContaDet;
	}

	public void addDetalle(ComproContaDet comproContaDet) throws BaseException {

		if ((comproContaDet.getCantidad().intValue() == 0)
				&& (comproContaDet.getImpoLocHist().doubleValue() == 0)
				&& (comproContaDet.getImpoLocAju().doubleValue() == 0)
				&& (comproContaDet.getImpoMonExt1().doubleValue() == 0)
				&& (comproContaDet.getImpoMonExt2().doubleValue() == 0))
			return;

		Iterator iterDet = detalles.iterator();
		boolean encontro = false;
		while (iterDet.hasNext()) {
			ComproContaDet comproContaDetExis = (ComproContaDet) iterDet.next();
			if ((comproContaDetExis.getCuentaImputable().getOID() == comproContaDet
					.getCuentaImputable().getOID())
					&& (comproContaDetExis.getSigno().intValue() == comproContaDet
							.getSigno().intValue())
					&& (comproContaDetExis.getComentario()
							.equals(comproContaDet.getComentario()))
					&& (comproContaDetExis.getMoneda().getOID() == comproContaDet
							.getMoneda().getOID())) {

				encontro = true;
				int cantidad = comproContaDetExis.getCantidad().intValue()
						+ comproContaDet.getCantidad().intValue();

				CalculadorMoney calcBase = new CalculadorMoney(new Money(0));
				calcBase.sumar(comproContaDetExis.getImporteOriginal());
				calcBase.sumar(comproContaDet.getImporteOriginal());
				comproContaDetExis
						.setImporteOriginal(calcBase.getResultMoney());

				calcBase.clear();
				calcBase.sumar(comproContaDetExis.getImpoLocHist());
				calcBase.sumar(comproContaDet.getImpoLocHist());
				comproContaDetExis.setImpoLocHist(calcBase.getResultMoney());

				calcBase.clear();
				calcBase.sumar(comproContaDetExis.getImpoLocAju());
				calcBase.sumar(comproContaDet.getImpoLocAju());
				comproContaDetExis.setImpoLocAju(calcBase.getResultMoney());

				calcBase.clear();
				calcBase.sumar(comproContaDetExis.getImpoMonExt1());
				calcBase.sumar(comproContaDet.getImpoMonExt1());
				comproContaDetExis.setImpoMonExt1(calcBase.getResultMoney());

				calcBase.clear();
				calcBase.sumar(comproContaDetExis.getImpoMonExt2());
				calcBase.sumar(comproContaDet.getImpoMonExt2());
				comproContaDetExis.setImpoMonExt2(calcBase.getResultMoney());

				break;
			}
		}

		// Si no lo encontro
		if (!encontro) {
			comproContaDet.setComprobante(this);
			detalles.add(comproContaDet);
		}

	}

	public static TipoCambio getTipoCambioContable(ISesion aSesion)
			throws BaseException {
		ValorParametro valorParamTipoCambio = ValorParametro
				.findByCodigoParametro("TIPO_CAMBIO_CONTABILIDAD", aSesion);
		return TipoCambio.findByOidProxy(valorParamTipoCambio.getOidObjNeg(),
				aSesion);
	}

	public List getDetallesAsiento() throws BaseException {
		if (readDetallesAsiento) {
			List listaDetalles = ComproContaDet.getDetallesByComproConta(this,
					getSesion());
			detalles.addAll(listaDetalles);
			readDetallesAsiento = false;
		}
		return detalles;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public void anular(ComproCab comprobanteAnulador) throws BaseException {

	}

	public static ComproConta getComproConta(ComproCab comproCab,
											 ISesion aSesion) throws BaseException {
		return DBComproConta.getComproConta(comproCab,aSesion);
	}
	
	public static boolean tieneAsiento(ComproCab comproCab,ISesion aSesion) throws BaseException {
		ComproConta comproConta = ComproConta.getComproConta(comproCab,aSesion);
		if (comproConta == null)
			return false;
		else
			return true;
	}
	
	public RenglonesAsiento getRenglonesAsientoInvertidos() throws BaseException {
		
		RenglonesAsiento renglones = new RenglonesAsiento();
		Iterator iterDetallesAsientos = getDetallesAsiento().iterator();
		while (iterDetallesAsientos.hasNext()) {
			ComproContaDet comproContaDet = (ComproContaDet) iterDetallesAsientos.next();
			RenglonAsiento renglonCompra = renglones.addRenglonAsiento();
			renglonCompra.setCuentaImputable(comproContaDet.getCuentaImputable());
			renglonCompra.setMonedaOri(comproContaDet.getMoneda());
			renglonCompra.setImporteOri(comproContaDet.getImporteOriginal());
			renglonCompra.setComentario(comproContaDet.getComentario());
			renglonCompra.setImpoLocHist(comproContaDet.getImpoLocHist());
			renglonCompra.setImpoLocAju(comproContaDet.getImpoLocAju());
			renglonCompra.setImpoMonExt1(comproContaDet.getImpoMonExt1());
			renglonCompra.setImpoMonExt2(comproContaDet.getImpoMonExt2());
			renglonCompra.setCotizOri(comproContaDet.getCotizMonOri());
			renglonCompra.setCotizMonExt1(comproContaDet.getCotizMonExt1());
			renglonCompra.setCotizMonExt2(comproContaDet.getCotizMonExt2());
			if (comproContaDet.getSigno().intValue()==1)
				renglonCompra.setD_H(RenglonAsiento.HABER);
			else
				renglonCompra.setD_H(RenglonAsiento.DEBE);
		}
				
		return renglones;
	  
	}
	
	public static ComproConta getAsientoCierrePatriminiales(Ejercicio ejercicio) throws BaseException {
		return null;
	}
	
	public static int recostruirMayores(ISesion aSesion,Integer oid) throws BaseException {
		
		int nro=1;
		int ultOIDProc = 0;
		Iterator iterAllComproContaDet =
			  ComproContaDet.getAllComproContaDetHastaOID(aSesion,oid).iterator();
		while (iterAllComproContaDet.hasNext()) {
			  ComproContaDet comproContaDet = (ComproContaDet) iterAllComproContaDet.next();
			  comproContaDet.recostruirMayores();
			  ultOIDProc = comproContaDet.getOIDInteger(); 
			  nro++;
			  if (nro>1000)
				  break;
		}
		
		return ultOIDProc;
	}
	
	public static void borrarMayor(ISesion aSesion) throws BaseException {
		MayorPeri.borrarTodo(aSesion);
		MayorDia.borrarTodo(aSesion);
	}
	

}
