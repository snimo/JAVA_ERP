package com.srn.erp.cashflow.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cashflow.bm.CajaSaldoIniCF;
import com.srn.erp.cashflow.bm.CajasHabDeudaFinanCF;
import com.srn.erp.cashflow.bm.CashFlow;
import com.srn.erp.cashflow.bm.CtaBcoSaldoIniCF;
import com.srn.erp.cashflow.bm.CtaSaldoIniCf;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.bm.GrupoConceptoCF;
import com.srn.erp.cashflow.bm.RangoFechasCF;
import com.srn.erp.cashflow.bm.TipoValorSICajaCF;
import com.srn.erp.cashflow.bm.VistaCashFlow;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.ctasACobrar.bm.AuxCtaCteClie1;
import com.srn.erp.ctasACobrar.bm.ConsultaCtaCteClie;
import com.srn.erp.ctasAPagar.bm.ConsultaCtaCteProv;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.tesoreria.bm.SaldoCuentaBanco;
import com.srn.erp.tesoreria.bm.SaldoEfectivo;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerVistaCF extends Operation {

	public static final String SALDO_INICIAL = "1-Saldo Caja";
	public static final String CUENTA_BANCARIA = "Cuenta Bancaria";
	public static final String EFECTIVO = "Efectivo";
	public static final String CUENTA_CONTABLE = "Cuenta Contable";
	public static final String INGRESOS = "2-Ingresos";
	public static final String EGRESOS = "3-Egresos";
	public static final String CTA_CTE_CLI = "Cta. Cte. Cliente";
	public static final String CTA_CTE_PROV = "Cta. Cte. Proveedores";
	public static final String DEU_FIN_CLI = "Deuda Financiera Cliente";
	public static final String VAL_EMITIDOS = "Valores Emitidos";
	public static final String SALDO_PERI_ANT = "0-Saldo Período Anterior";
	
	public static final String SI_PERI = "0-Saldo Inicial";
	public static final String PERI = "1-Período";
	public static final String SF_PERI = "2-Saldo Final";
	
	public static final String FUENTE_CONC_PLANIF = "CONC_PLANIF";
	public static final String FUENTE_CTA_BCO = "CTA_BANCO";
	public static final String FUENTE_VALOR = "VALOR";
	public static final String FUENTE_CTA_CONTABLE = "CTA_CONTA";
	public static final String FUENTE_CTA_CTE_CLI = "CTA_CTE_CLI";
	public static final String FUENTE_DEU_FIN_CLI = "DEU_FIN_CLI";
	public static final String FUENTE_CTA_CTE_PROV = "CTA_CTE_PRO";
	public static final String FUENTE_DEU_FIN_PRO = "DEU_FIN_PRO";
	public static final String FUENTE_SAL_ANT = "SAL_ANT";
	
	HashTableDatos fechasCF = new HashTableDatos();
	HashTableDatos acumPorFecha = new HashTableDatos();
	List rangosPeriodos = new ArrayList();
	Integer diasADesplazarFactVencCF = null;
	Integer diasADesplazarConcPlanifVencCF = null;
	Integer diasADesplazarDeudaFinanVencClie = null;
	Integer maxDiasVencDeudaFinanClieCF = null;
	Integer diasADesplazarFactProvVencCF = null;
	private int id = 1;

	public TraerVistaCF() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		java.util.Date fecDesde = mapaDatos.getDate("fec_desde");
		java.util.Date fecHasta = Fecha.getFechaDiaPosterior(mapaDatos.getDate("fec_hasta"));
		EscenarioCashFlow escenario = EscenarioCashFlow.findByOidProxy(mapaDatos.getInteger("oid_escenario"), this.getSesion());
		String vista = mapaDatos.getString("vista");
		Integer dias = mapaDatos.getInteger("dias");
		diasADesplazarFactVencCF = ValorParametro.findByCodigoParametro(
				"CANT_DIAS_A_DESP_FACT_VENC_CF", this.getSesion()).getValorEntero();
		diasADesplazarConcPlanifVencCF = ValorParametro.findByCodigoParametro(
				"CANT_DIAS_A_DESP_CP_VENC_CF", this.getSesion()).getValorEntero();
		diasADesplazarDeudaFinanVencClie = ValorParametro.findByCodigoParametro(
				"CANT_DIAS_A_DESP_CHE_CLI_VENC_CF", this.getSesion()).getValorEntero();
		maxDiasVencDeudaFinanClieCF = ValorParametro.findByCodigoParametro(
				"CONS_DF_CF_CON_VENC_MENOR_A", this.getSesion()).getValorEntero();
		diasADesplazarFactProvVencCF = ValorParametro.findByCodigoParametro(
				"CANT_DIAS_A_DESP_FP_VENC_CF", this.getSesion()).getValorEntero();
		
		


		enviarVistaCF(fecDesde, fecHasta, escenario, vista , dias);

	}

	private void enviarVistaCF(java.util.Date fecDesde, java.util.Date fecHasta, EscenarioCashFlow escenario, String vista , Integer dias)
			throws BaseException {

		cachFlowDiario(fecDesde, fecHasta, escenario,vista,dias);

	}

	private void cachFlowDiario(java.util.Date fecDesde, java.util.Date fecHasta, EscenarioCashFlow escenario,String vista,Integer dias) throws BaseException {

		IDataSet ds = this.getDataSetVistaCF();
		IDataSet dsPeriodos = this.getDataSetPeriodos();

		TipoCambio tipoCambio = CashFlow.getTipoCambio(this.getSesion());
		HashTableDatos cotizaciones = Cotizacion.getListaCotizacionesPorOidMoneda(Fecha.getFechaActual(), tipoCambio, this.getSesion());

		// Saldo Periodo Anterior
		
		// Traer Saldo Inicial Bancos
		Iterator iterCtasBcos = escenario.getSaldoInicialCtasBancarias().iterator();
		while (iterCtasBcos.hasNext()) {
			CtaBcoSaldoIniCF ctaBcoSaldoIni = (CtaBcoSaldoIniCF) iterCtasBcos.next();
			SaldoCuentaBanco saldoCuentaBanco = ctaBcoSaldoIni.getCuenta_bancaria().getSaldo();
			Money impoMonCF = Cotizacion.getImporteEnMoneda(
					cotizaciones, 
					saldoCuentaBanco.getSaldo(), 
					saldoCuentaBanco.getMoneda(),
					escenario.getMoneda());
			cargarRegistroConcepto(ds,
					escenario.getMoneda(),
					null,
					SALDO_INICIAL, 
					CUENTA_BANCARIA, 
					ctaBcoSaldoIni.getCuenta_bancaria().getDescripcion(),
					null,
					impoMonCF,
					SI_PERI,
					"",
					FUENTE_CTA_BCO,
					saldoCuentaBanco.getOIDInteger()
					);
			acumPorFecha(impoMonCF, "SI");
			
		}

		// Traer Saldo Inicial Cajas
		Iterator iterCajas = escenario.getSaldoInicialCajas().iterator();
		while (iterCajas.hasNext()) {
			CajaSaldoIniCF cajaSaldoIniCF = (CajaSaldoIniCF) iterCajas.next();
			if (!cajaSaldoIniCF.isActivo())
				continue;
			Iterator iterTiposValores = cajaSaldoIniCF.getTiposValores().iterator();
			while (iterTiposValores.hasNext()) {
				TipoValorSICajaCF tipoValorSICaja = (TipoValorSICajaCF) iterTiposValores.next();
				if (!tipoValorSICaja.isActivo())
					continue;
				if (tipoValorSICaja.getTipo_valor().isEfectivo()) {
					SaldoEfectivo saldoEfectivo = cajaSaldoIniCF.getCaja().getSaldoEfectivo(tipoValorSICaja.getTipo_valor());
					if (saldoEfectivo == null)
						continue;
					Money impoMonCF = Cotizacion.getImporteEnMoneda(
							cotizaciones, 
							saldoEfectivo.getSaldo(), 
							saldoEfectivo.getTipo_valor().getMoneda(), escenario.getMoneda());
					cargarRegistroConcepto(
							ds, 
							escenario.getMoneda(),
							null,
							SALDO_INICIAL, 
							EFECTIVO, 
							saldoEfectivo.getTipo_valor().getDescripcion(),
							null,
							impoMonCF,
							SI_PERI,
							"",
							FUENTE_VALOR,
							new Integer(0));
					acumPorFecha(impoMonCF, "SI");
				}

			}

		}

		// Traer cuentas
		Iterator iterCtasContables = escenario.getSaldoInicialCtasContables().iterator();
		while (iterCtasContables.hasNext()) {
			CtaSaldoIniCf ctaSaldoIniCF = (CtaSaldoIniCf) iterCtasContables.next();
			if (!ctaSaldoIniCF.isActivo())
				continue;
			ImportesContables saldoCuenta = ctaSaldoIniCF.getCuenta().getSaldoFinal(Fecha.getFechaActual(), null);
			Money impoMonCF = Cotizacion.getImporteEnMoneda(cotizaciones, saldoCuenta.getImpoMonLoc(), Moneda.getMonedaCursoLegal(this
					.getSesion()), escenario.getMoneda());
			cargarRegistroConcepto(ds,
					escenario.getMoneda(),
					null,
					SALDO_INICIAL, 
					CUENTA_CONTABLE, 
					ctaSaldoIniCF.getCuenta().getDescripcion(),
					null,
					impoMonCF,
					SI_PERI,
					"",
					FUENTE_CTA_CONTABLE,
					new Integer(0));
			acumPorFecha(impoMonCF, "SI");

		}
		
		java.util.Date fechaRangoDesde = fecDesde;
		if (vista.equals("RANGO")) {
		
			
			if (dias.intValue() <= 0) throw new ExceptionValidation(null,"Debe ingresar la cantidad de días");
			
			while (fechaRangoDesde.before(fecHasta)) {
				
				java.util.Date fechaRangoHasta = Fecha.getFechaMasDias(fechaRangoDesde, dias.intValue()-1);
				if (!(fechaRangoHasta.before(fecHasta)))
					fechaRangoHasta = Fecha.getFechaDiaAnterior(fecHasta);
				RangoFechasCF rangoFechas = new RangoFechasCF();
				rangoFechas.setFecDesde(fechaRangoDesde);
				rangoFechas.setFecHasta(fechaRangoHasta);
				rangosPeriodos.add(rangoFechas);
				
				fechaRangoDesde = Fecha.getFechaDiaPosterior(fechaRangoHasta);
			}
			
			
		}

		// Traer Conceptos Planificados
		Iterator iterConcPlanif = VistaCashFlow.getConceptosPlanificados(escenario, this.getSesion()).iterator();
		while (iterConcPlanif.hasNext()) {
			VistaCashFlow vistaConcCF = (VistaCashFlow) iterConcPlanif.next();
			cargarRegistroConceptoPlanif(ds , cotizaciones , vistaConcCF , escenario , fecDesde , fecHasta , PERI , vista , FUENTE_CONC_PLANIF , vistaConcCF.getOIDInteger());

		}
		
		// Traer consulta en cuenta corrienta clientes
		HashTableDatos ctaCteClientes = 
			ConsultaCtaCteClie.getCtasCtesAplicadasConDeuda(cotizaciones, this.getSesion());
		Iterator iterClientes = 
			ctaCteClientes.keySet().iterator();
		while (iterClientes.hasNext()) {
			
			Integer oidCliente = (Integer) iterClientes.next();
			AuxCtaCteClie1 auxCtaCteClie1 = (AuxCtaCteClie1) ctaCteClientes.get(oidCliente);
			
			Iterator iterTransacPos =
				auxCtaCteClie1.getListaTransacPos().iterator();
			while (iterTransacPos.hasNext()) {
				ConsultaCtaCteClie consultaCtaCte = (ConsultaCtaCteClie) iterTransacPos.next();
				if (consultaCtaCte.getSaldoCuota().doubleValue() == 0) continue;
				
				Money impoMonCF = Cotizacion.getImporteEnMoneda(
						cotizaciones, 
						consultaCtaCte.getSaldoCuota(), 
						consultaCtaCte.getMoneda(),
						escenario.getMoneda());
				
				String tipo = null;
				String periodo = "";
				java.util.Date fecVtoFact = null;
				
				// Si esta vencido , reacomodar la fecha de Vencimiento segun dias del Parametro
				if (consultaCtaCte.getFechaCF().before(fecDesde)) {
					java.util.Date fecNuevaVenc = Fecha.getFechaMasDias(fecDesde, diasADesplazarFactVencCF.intValue()-1);
					consultaCtaCte.setFechaConfCobranza(fecNuevaVenc);
				}
				
				if (consultaCtaCte.getFechaCF().before(fecDesde)) 
					tipo = SI_PERI;
				else
				if (consultaCtaCte.getFechaCF().after(Fecha.getFechaDiaAnterior((fecHasta)))) 
					tipo = SF_PERI;
				else {
					tipo = PERI;
					periodo = getPeriodo(consultaCtaCte.getFechaCF());
					fecVtoFact = consultaCtaCte.getFechaCF();
				}

				
				cargarRegistroConcepto(ds,
						escenario.getMoneda(),
						null,
						INGRESOS, 
						CTA_CTE_CLI, 
						consultaCtaCte.getDescripcion(),
						fecVtoFact,
						impoMonCF,
						tipo,
						periodo,
						FUENTE_CTA_CTE_CLI,
						consultaCtaCte.getOIDInteger()
						);
				
				if (tipo.equals(SI_PERI))
					acumPorFecha(impoMonCF, "SI");
				else
				if (tipo.equals(SF_PERI))
					acumPorFecha(impoMonCF, "SF");
				else if (vista.equals("RANGO")) 
					acumPorFecha(impoMonCF, getPeriodo(fecVtoFact));
				else
					acumPorFecha(impoMonCF, Fecha.getddmmyyyy(fecVtoFact));
				
			}
			
		}
		
		// Traer la Deuda Financiera de Clientes
	    List listValoresEnCartera = 
	    	Valor.getValoresEnCaja(null, 
	    						   null, 
	    						   TipoValor.getTiposValoresDeudaFinanciera(this.getSesion()),
	    						   this.getSesion());

	    
	    HashTableDatos listaCajasDF = getCajasHabDeudaFinan(escenario);
	    
	    java.util.Date limiteFecDF = Fecha.getFechaMasDias(fecDesde, maxDiasVencDeudaFinanClieCF.intValue()*-1);
	    limiteFecDF = Fecha.getFechaDiaAnterior(limiteFecDF);
		Iterator iterValFinan = listValoresEnCartera.iterator();
	    while (iterValFinan.hasNext()) {

	    	Valor valor = (Valor)iterValFinan.next();
	    	
	    	if (!valor.getFechaCF().after(limiteFecDF)) continue;
	    	
	    	if (listaCajasDF.get(valor.getCaja().getOIDInteger())==null) continue;
	    	
	    	Money impoMonCF = Cotizacion.getImporteEnMoneda(
					cotizaciones, 
					valor.getImporte(), 
					valor.getTipovalor().getMoneda(),
					escenario.getMoneda());	    	
			String tipo = null;
			String periodo = "";
			java.util.Date fecVtoValor = null;

			// Si esta vencido , reacomodar la fecha de Vencimiento segun dias del Parametro
			if (valor.getFechaCF().before(fecDesde)) {
				java.util.Date fecNuevaVenc = Fecha.getFechaMasDias(fecDesde, diasADesplazarDeudaFinanVencClie.intValue()-1);
				valor.setFechavto(fecNuevaVenc);
			}
			
			if (valor.getFechaCF().before(fecDesde)) 
				tipo = SI_PERI;
			else
			if (valor.getFechaCF().after(Fecha.getFechaDiaAnterior((fecHasta)))) 
				tipo = SF_PERI;
			else {
				tipo = PERI;
				periodo = getPeriodo(valor.getFechaCF());
				fecVtoValor = valor.getFechaCF();
			}
	    	
			cargarRegistroConcepto(ds,
					escenario.getMoneda(),
					null,
					INGRESOS, 
					DEU_FIN_CLI, 
					valor.getDescripcion(),
					fecVtoValor,
					impoMonCF,
					tipo,
					periodo,
					FUENTE_DEU_FIN_CLI,
					valor.getOIDInteger()
					);
			
			if (tipo.equals(SI_PERI))
				acumPorFecha(impoMonCF, "SI");
			else
			if (tipo.equals(SF_PERI))
				acumPorFecha(impoMonCF, "SF");
			else if (vista.equals("RANGO")) 
				acumPorFecha(impoMonCF, getPeriodo(fecVtoValor));
			else
				acumPorFecha(impoMonCF, Fecha.getddmmyyyy(fecVtoValor));
	    						      
	    }

	    
	    // Traer la Cuenta Corriente de Proveedores
		HashTableDatos ctaCteProveedores = 
			ConsultaCtaCteProv.getCtasCtesAplicadasConDeuda(cotizaciones, this.getSesion());
		Iterator iterProveedores = 
			ctaCteProveedores.keySet().iterator();
		while (iterProveedores.hasNext()) {
			
			Integer oidProveedor = (Integer) iterProveedores.next();
			AuxCtaCteClie1 auxCtaCteProv1 = (AuxCtaCteClie1) ctaCteProveedores.get(oidProveedor);
			
			Iterator iterTransacNeg =
				auxCtaCteProv1.getListaTransacPos().iterator();
			while (iterTransacNeg.hasNext()) {
				ConsultaCtaCteProv consultaCtaCte = (ConsultaCtaCteProv) iterTransacNeg.next();
				if (consultaCtaCte.getSaldoCuota().doubleValue() == 0) continue;
				
				Money impoMonCF = Cotizacion.getImporteEnMoneda(
						cotizaciones, 
						new Money(consultaCtaCte.getSaldoCuota().doubleValue()*-1), 
						consultaCtaCte.getMoneda(),
						escenario.getMoneda());
				
				String tipo = null;
				String periodo = "";
				java.util.Date fecVtoFact = null;
				
				// Si esta vencido , reacomodar la fecha de Vencimiento segun dias del Parametro
				if (consultaCtaCte.getFechaCF().before(fecDesde)) {
					java.util.Date fecNuevaVenc = Fecha.getFechaMasDias(fecDesde, diasADesplazarFactProvVencCF.intValue()-1);
					consultaCtaCte.setVto(fecNuevaVenc);
				}
				
				if (consultaCtaCte.getFechaCF().before(fecDesde)) 
					tipo = SI_PERI;
				else
				if (consultaCtaCte.getFechaCF().after(Fecha.getFechaDiaAnterior((fecHasta)))) 
					tipo = SF_PERI;
				else {
					tipo = PERI;
					periodo = getPeriodo(consultaCtaCte.getFechaCF());
					fecVtoFact = consultaCtaCte.getFechaCF();
				}

				
				cargarRegistroConcepto(ds,
						escenario.getMoneda(),
						null,
						EGRESOS, 
						CTA_CTE_PROV, 
						consultaCtaCte.getDescripcion(),
						fecVtoFact,
						impoMonCF,
						tipo,
						periodo,
						FUENTE_CTA_CTE_PROV,
						consultaCtaCte.getOIDInteger()
						);
				
				if (tipo.equals(SI_PERI))
					acumPorFecha(impoMonCF, "SI");
				else
				if (tipo.equals(SF_PERI))
					acumPorFecha(impoMonCF, "SF");
				else if (vista.equals("RANGO")) 
					acumPorFecha(impoMonCF, getPeriodo(fecVtoFact));
				else
					acumPorFecha(impoMonCF, Fecha.getddmmyyyy(fecVtoFact));
				
			}
			
		}
		
		// Traer la Deuda Financiera de Proveedores
	    List listValoresEmitidos = 
	    	Valor.getValoresDeudaFinanProv(fecDesde,null,null,this.getSesion());

		Iterator iterValoresEmitidos = listValoresEmitidos.iterator();
	    while (iterValoresEmitidos.hasNext()) {

	    	Valor valor = (Valor)iterValoresEmitidos.next();
	    	
	    	Money impoMonCF = Cotizacion.getImporteEnMoneda(
					cotizaciones, 
					new Money(valor.getImporte().doubleValue()*-1), 
					valor.getTipovalor().getMoneda(),
					escenario.getMoneda());
	    	
			String tipo = null;
			String periodo = "";
			java.util.Date fecVtoValor = null;

			if (valor.getFechaCF().before(fecDesde)) 
				tipo = SI_PERI;
			else
			if (valor.getFechaCF().after(Fecha.getFechaDiaAnterior((fecHasta)))) 
				tipo = SF_PERI;
			else {
				tipo = PERI;
				periodo = getPeriodo(valor.getFechaCF());
				fecVtoValor = valor.getFechaCF();
			}
	    	
			cargarRegistroConcepto(ds,
					escenario.getMoneda(),
					null,
					EGRESOS, 
					VAL_EMITIDOS, 
					valor.getDescripcion(),
					fecVtoValor,
					impoMonCF,
					tipo,
					periodo,
					FUENTE_DEU_FIN_PRO,
					valor.getOIDInteger());
			
			if (tipo.equals(SI_PERI))
				acumPorFecha(impoMonCF, "SI");
			else
			if (tipo.equals(SF_PERI))
				acumPorFecha(impoMonCF, "SF");
			else if (vista.equals("RANGO")) 
				acumPorFecha(impoMonCF, getPeriodo(fecVtoValor));
			else
				acumPorFecha(impoMonCF, Fecha.getddmmyyyy(fecVtoValor));
	    						      
	    }
		
	    
	    
		
		// Traer Saldos Anterior periodos
		traerSaldoAnteriorDiario(ds,escenario,fecDesde,fecHasta,vista);

		writeCliente(ds);
		writeCliente(dsPeriodos);

	}
	
	private void traerSaldoAnteriorDiario(
			IDataSet dataset , 
			EscenarioCashFlow escenario,
			java.util.Date fecDesde , 
			java.util.Date fecHasta,
			String vista) throws BaseException {

		if (vista.equals("DIA"))
			enviarSaldoAnteriorDiario(escenario,dataset,fecDesde,fecHasta,vista);
		else
			enviarSaldoAnteriorRango(dataset,escenario,fecDesde,fecHasta,vista);
	}
	
	private void enviarSaldoAnteriorDiario(
			EscenarioCashFlow escenario,
			IDataSet dataset , 
			java.util.Date fecDesde , 
			java.util.Date fecHasta,
			String vista) throws BaseException {

		CalculadorMoney calcSaldoInicial = (CalculadorMoney)acumPorFecha.get("SI");
		if (calcSaldoInicial == null)
			calcSaldoInicial = new CalculadorMoney(new Money(0));

		java.util.Date fecHastaMas1 = Fecha.getFechaDiaPosterior(fecHasta);
		java.util.Date fecCorriente = fecDesde;
		while (fecCorriente.before(fecHastaMas1)) {
			String fechaString = Fecha.getddmmyyyy(fecCorriente);
			CalculadorMoney totFecha = (CalculadorMoney) acumPorFecha.get(fechaString);
			if (totFecha == null)
				totFecha = new CalculadorMoney(new Money(0));
			
			
			String tipo = null;
			
			if (fecCorriente.before(fecDesde)) {
				tipo = SI_PERI;
			} else
			if (fecCorriente.after(Fecha.getFechaDiaAnterior((fecHasta)))) {
				tipo = SF_PERI;
			}
			else {
				tipo = PERI;
			}

			// La ultima fecha correspondiente al saldo final Mostrar Null
			java.util.Date mostrarFecha = null;
			if (!fecCorriente.equals(fecHasta))
				mostrarFecha = fecCorriente; 
			
			cargarRegistroConcepto(dataset,
					escenario.getMoneda(),
					null,
					SALDO_PERI_ANT, 
					"", 
					"",
					mostrarFecha,
					calcSaldoInicial.getResultMoney(),
					tipo,
					getPeriodo(mostrarFecha),
					FUENTE_SAL_ANT,
					new Integer(0));

			
			calcSaldoInicial.sumar(totFecha.getResultMoney());
			
			fecCorriente = Fecha.getFechaDiaPosterior(fecCorriente);
		}
		
	}
	
	private void enviarSaldoAnteriorRango(
			IDataSet dataset , 
			EscenarioCashFlow escenario,
			java.util.Date fecDesde , 
			java.util.Date fecHasta,
			String vista) throws BaseException {

		CalculadorMoney calcSaldoInicial = (CalculadorMoney)acumPorFecha.get("SI");
		if (calcSaldoInicial == null)
			calcSaldoInicial = new CalculadorMoney(new Money(0));

		Iterator iterPeriodos = 
			rangosPeriodos.iterator();
		while (iterPeriodos.hasNext()) {
			RangoFechasCF rango = (RangoFechasCF) iterPeriodos.next();
			
			
			CalculadorMoney totFecha = (CalculadorMoney) acumPorFecha.get(rango.getDescripcion());
			if (totFecha == null)
				totFecha = new CalculadorMoney(new Money(0));
			
			cargarRegistroConcepto(dataset,
					escenario.getMoneda(),
					null,
					SALDO_PERI_ANT, 
					"", 
					"",
					null,
					calcSaldoInicial.getResultMoney(),
					PERI,
					rango.getDescripcion(),
					FUENTE_SAL_ANT,
					new Integer(0));
			
			calcSaldoInicial.sumar(totFecha.getResultMoney());
			
		}
		
		cargarRegistroConcepto(dataset,
				escenario.getMoneda(),
				null,
				SALDO_PERI_ANT, 
				"", 
				"",
				fecHasta,
				calcSaldoInicial.getResultMoney(),
				SF_PERI,
				"",
				FUENTE_SAL_ANT,
				new Integer(0));		
		
		
	}

	private void cargarRegistroConceptoPlanif(
			IDataSet dataset, 
			HashTableDatos cotizaciones,
			VistaCashFlow vistaCF,
			EscenarioCashFlow escenario,
			java.util.Date fecDesde,
			java.util.Date fecHasta,
			String saldoIniPeriFinal,
			String vista,
			String fuente,
			Integer oidFuente) throws BaseException {
		
		dataset.append();
		
		if (vistaCF.getGrupo_concepto().isIngreso())
			dataset.fieldValue("grupo", INGRESOS);
		else if (vistaCF.getGrupo_concepto().isEgreso())
				dataset.fieldValue("grupo", EGRESOS);
		else if (vistaCF.getGrupo_concepto().isSaldoInicial())
					dataset.fieldValue("grupo", SALDO_INICIAL);
		else dataset.fieldValue("grupo", "");
		dataset.fieldValue("subgrupo", vistaCF.getGrupo_concepto().getDescripcion());
		if (vistaCF.getConcepto_cf()!=null)
			dataset.fieldValue("concepto", vistaCF.getConcepto_cf().getDescripcion());
		else if (vistaCF.getDescripcion()!=null)
			dataset.fieldValue("concepto", vistaCF.getDescripcion());
		else
			dataset.fieldValue("concepto", "");
		
		
		java.util.Date fechaAConsiderar = null;
		String tipo = "";

		Money impoMonCF = Cotizacion.getImporteEnMoneda(
				cotizaciones, new Money(vistaCF.getImporte()),
				vistaCF.getMoneda(),
				escenario.getMoneda());
		
		// Si el concepto esta vencido reajustar la fecha segun parametro
		if (vistaCF.getFecha().before(fecDesde)) {
			java.util.Date fecNuevaVenc = Fecha.getFechaMasDias(fecDesde, diasADesplazarConcPlanifVencCF.intValue()-1);
			vistaCF.setFecha(fecNuevaVenc);
		}
		
		if (vistaCF.getFecha().before(fecDesde)) {
			fechaAConsiderar = null;
			tipo = SI_PERI;
			acumPorFecha(impoMonCF, "SI");
		} else
		if (vistaCF.getFecha().after(Fecha.getFechaDiaAnterior((fecHasta)))) {
			fechaAConsiderar = null;
			tipo = SF_PERI;
			acumPorFecha(impoMonCF, Fecha.getddmmyyyy(fechaAConsiderar));
		}
		else {
			fechaAConsiderar = vistaCF.getFecha();
			tipo = PERI;
			if (vista.equals("RANGO")) 
				acumPorFecha(impoMonCF, getPeriodo(fechaAConsiderar));
			else
				acumPorFecha(impoMonCF, Fecha.getddmmyyyy(fechaAConsiderar));
		}
		
		dataset.fieldValue("fecha",fechaAConsiderar);
		dataset.fieldValue("importe", impoMonCF);
		dataset.fieldValue("tipo_si_per_sf",tipo);
		dataset.fieldValue("rango",getPeriodo(fechaAConsiderar));
		dataset.fieldValue("tipo_concepto", "PER"); // Permanente
		dataset.fieldValue("oid_grupo_conc", vistaCF.getGrupo_concepto().getOIDInteger());
		dataset.fieldValue("oid_moneda", escenario.getMoneda().getOIDInteger());
		dataset.fieldValue("id", ++id);
		dataset.fieldValue("fuente", fuente);
		dataset.fieldValue("oid_fuente", oidFuente);
		dataset.fieldValue("fec_ori", fechaAConsiderar);
		dataset.fieldValue("importe_ori", impoMonCF);
		
		
		
		
	}

	private IDataSet getDataSetPeriodos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPeriodosCF");
		dataset.fieldDef(new Field("nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroPeriodo(IDataSet dataset, Integer nro, String descripcion) throws BaseException {

		dataset.append();
		dataset.fieldValue("nro", nro);
		dataset.fieldValue("descripcion", descripcion);

	}

	private IDataSet getDataSetVistaCF() {
		IDataSet dataset = new TDataSet();
		dataset.create("TVistaCF");
		dataset.fieldDef(new Field("grupo", Field.STRING, 100));
		dataset.fieldDef(new Field("subgrupo", Field.STRING, 100));
		dataset.fieldDef(new Field("concepto", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("importe", Field.DATE, 0));
		dataset.fieldDef(new Field("tipo_si_per_sf", Field.STRING, 20)); 
		dataset.fieldDef(new Field("rango", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_concepto", Field.STRING, 10));
		dataset.fieldDef(new Field("oid_grupo_conc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("id", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fuente", Field.STRING, 10));
		dataset.fieldDef(new Field("oid_fuente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_ori", Field.DATE, 0));
		dataset.fieldDef(new Field("importe_ori", Field.CURRENCY, 0));
		
		return dataset;
	}

	private void cargarRegistroConcepto(
			IDataSet dataset, 
			Moneda moneda,
			GrupoConceptoCF grupoConc,
			String grupo, 
			String subgrupo, 
			String concepto, 
			java.util.Date fecha,
			Money importe,
			String saldoIniPeriFinal,
			String rango,
			String fuente,
			Integer oidFuente) throws BaseException {

		dataset.append();
		dataset.fieldValue("grupo", grupo);
		dataset.fieldValue("subgrupo", subgrupo);
		dataset.fieldValue("concepto", concepto);
		dataset.fieldValue("fecha", fecha);
		dataset.fieldValue("importe", importe);
		dataset.fieldValue("tipo_si_per_sf", saldoIniPeriFinal);
		dataset.fieldValue("rango", rango);
		dataset.fieldValue("tipo_concepto", "PER"); // Permanente
		if (grupoConc!=null)
			dataset.fieldValue("oid_grupo_conc", grupoConc.getOIDInteger());
		else
			dataset.fieldValue("oid_grupo_conc", 0);
		dataset.fieldValue("oid_moneda", moneda.getOIDInteger());
		dataset.fieldValue("id", ++id);
		dataset.fieldValue("fuente", fuente);
		dataset.fieldValue("oid_fuente", oidFuente);
		dataset.fieldValue("fec_ori", fecha);
		dataset.fieldValue("importe_ori", importe);
		
		
	}
	
	private void acumPorFecha(Money importe, String fecha) throws BaseException {
		CalculadorMoney calcTotPeri = (CalculadorMoney)acumPorFecha.get(fecha);
		if (calcTotPeri == null) {
			calcTotPeri = new CalculadorMoney(importe);
			acumPorFecha.put(fecha, calcTotPeri);
		} else {
			calcTotPeri.sumar(importe);
		}
	}
	
	private String getPeriodo(java.util.Date fecha) throws BaseException {
		if (fecha == null)
			return "";
		Iterator iterPeriodos = 
			rangosPeriodos.iterator();
		while (iterPeriodos.hasNext()) {
			RangoFechasCF rango = (RangoFechasCF) iterPeriodos.next();
			if ((fecha.after(Fecha.getFechaDiaAnterior(rango.getFecDesde()))) && (fecha.before(Fecha.getFechaDiaPosterior(rango.getFecHasta())))) 
				return rango.getDescripcion();			
		}
		return "";
	}
	
	private HashTableDatos getCajasHabDeudaFinan(EscenarioCashFlow escenario) throws BaseException {
		HashTableDatos listaCajasHab = new HashTableDatos();
		Iterator iterCajasHabDeudaFinan = 
			CajasHabDeudaFinanCF.getCajasHabDeudaFinanActivas(escenario, this.getSesion()).iterator();
		while (iterCajasHabDeudaFinan.hasNext()) {
			CajasHabDeudaFinanCF cajasHabDeudaFinan = (CajasHabDeudaFinanCF) iterCajasHabDeudaFinan.next();
			listaCajasHab.put(cajasHabDeudaFinan.getCaja().getOIDInteger(),cajasHabDeudaFinan);
		}
		return listaCajasHab;
	}

}
