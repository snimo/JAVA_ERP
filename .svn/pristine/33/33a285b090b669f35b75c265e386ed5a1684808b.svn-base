package com.srn.erp.ctasAPagar.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ConsultaMovCtaCteProv {

	private HashTableDatos listaMovimienos = new HashTableDatos();

	private HashTableDatos listaTotPorMoneda = new HashTableDatos();

	private int secu = 0;

	private TotMovPorMoneda totMovPorMoneda = new TotMovPorMoneda();

	public class SaldosPorMoneda {

		private Moneda moneda;

		private Money saldoInicial;

		private Money movimientos;

		public void setMoneda(Moneda aMoneda) throws BaseException {
			this.moneda = aMoneda;
		}

		public Moneda getMoneda() throws BaseException {
			return moneda;
		}

		public void setSaldoInicial(Money aSaldoInicial) throws BaseException {
			this.saldoInicial = aSaldoInicial;
		}

		public Money getSaldoInicial() throws BaseException {
			return this.saldoInicial;
		}

		public Money getSaldoFinal() throws BaseException {
			CalculadorMoney calcSaldoFinal = new CalculadorMoney(
					getSaldoInicial());
			calcSaldoFinal.sumar(getMovimientos());
			return calcSaldoFinal.getResultMoney();
		}

		public void setMovimientos(Money aMovimientos) throws BaseException {
			this.movimientos = aMovimientos;
		}

		public Money getMovimientos() throws BaseException {
			return this.movimientos;
		}

	}

	public class ConsMovCtaCte {
		public Integer secu;

		public Integer orden = null;

		public Integer oid_cco_tran_vto = null;

		public String codigo_cco_tran_vto = null;

		public Integer oid_cco_aplic = null;

		public String codigo_cco_aplic = null;

		public Integer oid_cco_aplic_aux = null;

		public String codigo_cco_aplic_aux = null;

		public java.util.Date imputacion = null;

		public java.util.Date emision = null;

		public Money importe = null;
		
		public Boolean allowDesaplicar = null;

		public Money saldo = null;

		public Integer oidTipoCtaCte = null;

		public Integer oidMoneda = null;
		
		public java.util.Date vto;
		
		public Integer oidCCO;
	}

	public class TotMovPorMoneda {

		private HashTableDatos listaTotPorMonedas = new HashTableDatos();

		public void addMoneda(Integer oidMoneda, Money importe) {
			Money totMov = (Money) listaTotPorMonedas.get(oidMoneda);
			if (totMov == null)
				totMov = new Money(0);
			else
				listaTotPorMonedas.remove(oidMoneda);

			// Calcular el Nuevo total
			CalculadorMoney nuevoTotMov = new CalculadorMoney(totMov);
			nuevoTotMov.sumar(importe);
			listaTotPorMonedas.put(oidMoneda, nuevoTotMov.getResultMoney());
		}

		public HashTableDatos getTotMovPorMonedas() throws BaseException {
			return listaTotPorMonedas;
		}

	}

	ISesion sesion = null;

	Proveedor proveedor = null;

	java.util.Date fechaDesde;

	java.util.Date fechaHasta;

	public java.util.Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(java.util.Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public java.util.Date getFechaHasta() {
		return fechaHasta;
	}
	
	public void setFechaHasta(java.util.Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public ConsultaMovCtaCteProv(ISesion aSesion) {
		this.sesion = aSesion;
	}

	public void ejecutarConsulta() throws BaseException {
		traerVtosEntreFechas();
		realizarAplicaciones();
		obtenerSaldosIniciales();
		obtenerMovimientos();
	}

	private void obtenerSaldosIniciales() throws BaseException {

		Iterator iterSaldosIniciales = SaldoCtaCteProv.getSaldosIniciales(
				proveedor, fechaDesde, sesion).iterator();
		while (iterSaldosIniciales.hasNext()) {
			SaldoCtaCteProv saldoCtaCteProv = (SaldoCtaCteProv) iterSaldosIniciales
					.next();
			addSaldoInicial(saldoCtaCteProv.getMoneda(), saldoCtaCteProv
					.getSaldo());
		}

	}
	
	public List getSaldosResumenes() throws BaseException {
		List resumen = new ArrayList();
		resumen.addAll(listaTotPorMoneda.values());
		return resumen;
	}

	private void addSaldoInicial(Moneda moneda, Money saldo)
			throws BaseException {
		SaldosPorMoneda saldosPorMoneda = (SaldosPorMoneda) listaTotPorMoneda
				.get(moneda.getOIDInteger());
		if (saldosPorMoneda == null) {
			saldosPorMoneda = new SaldosPorMoneda();
			saldosPorMoneda.setMoneda(moneda);
			saldosPorMoneda.setSaldoInicial(saldo);
			saldosPorMoneda.setMovimientos(new Money(0));
			listaTotPorMoneda.put(moneda.getOIDInteger(), saldosPorMoneda);
		} else {
			CalculadorMoney acumSaldoIncial = new CalculadorMoney(
					saldosPorMoneda.getSaldoInicial());
			acumSaldoIncial.sumar(saldo);
			saldosPorMoneda.setSaldoInicial(acumSaldoIncial.getResultMoney());
		}
	}

	private void addMovimiento(Moneda moneda, Money movimiento)
			throws BaseException {
		SaldosPorMoneda saldosPorMoneda = (SaldosPorMoneda) listaTotPorMoneda
				.get(moneda.getOIDInteger());
		if (saldosPorMoneda == null) {
			saldosPorMoneda = new SaldosPorMoneda();
			saldosPorMoneda.setMoneda(moneda);
			saldosPorMoneda.setSaldoInicial(new Money(0));
			saldosPorMoneda.setMovimientos(movimiento);
			listaTotPorMoneda.put(moneda.getOIDInteger(), saldosPorMoneda);
		} else {
			CalculadorMoney acumTotMov = new CalculadorMoney(saldosPorMoneda
					.getMovimientos());
			acumTotMov.sumar(movimiento);
			saldosPorMoneda.setMovimientos(acumTotMov.getResultMoney());
		}
	}

	private void obtenerMovimientos() throws BaseException {
		HashTableDatos totMovimientos = totMovPorMoneda.getTotMovPorMonedas();
		Iterator iterOidMonedas = totMovimientos.keySet().iterator();
		while (iterOidMonedas.hasNext()) {
			Integer oidMoneda = (Integer) iterOidMonedas.next();
			Money total = (Money) totMovimientos.get(oidMoneda);
			Moneda moneda = Moneda.findByOidProxy(oidMoneda, sesion);
			addMovimiento(moneda, total);
		}
	}

	private void traerVtosEntreFechas() throws BaseException {
		Iterator iterVtos = ConsultaCtaCteProv
				.getVtosCtaCteByProveedorImputacDesdeHasta(proveedor,
						fechaDesde, fechaHasta, sesion).iterator();
		while (iterVtos.hasNext()) {
			ConsultaCtaCteProv consCtaCteProv = (ConsultaCtaCteProv) iterVtos
					.next();
			++secu;
			ConsMovCtaCte consMov = new ConsMovCtaCte();
			consMov.secu = new Integer(secu);
			consMov.orden = new Integer(1);
			consMov.oid_cco_tran_vto = consCtaCteProv.getTranProvVto()
					.getOIDInteger();
			consMov.codigo_cco_tran_vto = consCtaCteProv.getCodigo();
			consMov.imputacion = consCtaCteProv.getFecImputac();
			consMov.emision = consCtaCteProv.getFecEmision();
			consMov.importe = consCtaCteProv.getImpoCuota();
			consMov.saldo = consCtaCteProv.getImpoCuota();
			consMov.oidMoneda = consCtaCteProv.getMoneda().getOIDInteger();
			consMov.oidCCO = consCtaCteProv.getComprobante().getOIDInteger();
			consMov.vto = consCtaCteProv.getVto();
			consMov.oidTipoCtaCte = consCtaCteProv.getTipoCtaCteProv()
					.getOIDInteger();
			totMovPorMoneda.addMoneda(consMov.oidMoneda, consMov.importe);
			listaMovimienos.put(
					consCtaCteProv.getTranProvVto().getOIDInteger(), consMov);
		}
	}

	private void realizarAplicaciones() throws BaseException {
		Iterator iterAplic = ConsultaAplicCtaCteProv.getConsAplic(proveedor,
				null, fechaDesde, fechaHasta, sesion).iterator();
		while (iterAplic.hasNext()) {
			ConsultaAplicCtaCteProv consAplic = (ConsultaAplicCtaCteProv) iterAplic
					.next();
			++secu;
			ConsMovCtaCte consMov = new ConsMovCtaCte();
			consMov.secu = new Integer(secu);
			consMov.orden = new Integer(2);
			consMov.oid_cco_tran_vto = consAplic.getTran_vto().getOIDInteger();
			consMov.imputacion = consAplic.getImputac();
			consMov.emision = consAplic.getEmision();
			consMov.oid_cco_aplic = consAplic.getOid_cco_apl();
			consMov.codigo_cco_aplic = consAplic.getCodigoAplicacion();
			consMov.oid_cco_aplic_aux = consAplic.getOid_cco_apl_aux();
			consMov.codigo_cco_aplic_aux = consAplic.getCodigoAplicacionAux();
			consMov.importe = new Money(consAplic.getImporte().doubleValue());
			consMov.saldo = new Money(0);
			consMov.vto = null;
			consMov.allowDesaplicar = consAplic.isAllowDesaplicar();
			consMov.oidTipoCtaCte = consAplic.getTipo_cta_prov()
					.getOIDInteger();
			consMov.oidMoneda = consAplic.getMoneda().getOIDInteger();
			consMov.oidCCO = consAplic.getOid_cco_apl();
			totMovPorMoneda.addMoneda(consMov.oidMoneda, consMov.importe);
			listaMovimienos.put(new Integer(secu * -1), consMov);

			aplicarATransaccion(consAplic);
		}
	}

	private void aplicarATransaccion(ConsultaAplicCtaCteProv consAplic)
			throws BaseException {
		Integer oidTranVto = consAplic.getTran_vto().getOIDInteger();
		ConsMovCtaCte consMov = (ConsMovCtaCte) listaMovimienos.get(oidTranVto);
		if (consMov != null) {
			CalculadorMoney saldo = new CalculadorMoney(consMov.saldo);
			saldo.sumar(new Money(consAplic.getImporte().doubleValue()));
			consMov.saldo = saldo.getResultMoney();
		}
	}
	
	public List getMovimientos() throws BaseException {
		List lista = new ArrayList();
		lista.addAll(listaMovimienos.values());
		return lista;
	}

}