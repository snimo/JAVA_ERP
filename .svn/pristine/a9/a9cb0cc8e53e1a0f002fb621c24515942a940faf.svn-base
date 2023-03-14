package com.srn.erp.ctasACobrar.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.ctasACobrar.bm.ConsultaCtaCteClie;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCaidaDeudaCliente extends Operation {

	public TraerCaidaDeudaCliente() {
	}
	
	java.util.Date fechaActua = null;

	private HashTableDatos sujetosEnCtaCte = new HashTableDatos();
	private HashTableDatos monedasCtaCte = new HashTableDatos();

	class CaidaDeuda {

		public CaidaDeuda(java.util.Date aFecha) {
			this.fechaActual = aFecha;
		}

		private java.util.Date fechaActual = null;

		CalculadorMoney vencidaCalcMasDe30 = new CalculadorMoney(new Money(0));
		CalculadorMoney vencidaCalcMasDe15 = new CalculadorMoney(new Money(0));
		CalculadorMoney vencidaCalcMasDe7 = new CalculadorMoney(new Money(0));
		CalculadorMoney vencidaCalcDe1a7 = new CalculadorMoney(new Money(0));
		CalculadorMoney totVencida = new CalculadorMoney(new Money(0));

		CalculadorMoney aVencerDe1a7 = new CalculadorMoney(new Money(0));
		CalculadorMoney aVencerMasDe7 = new CalculadorMoney(new Money(0));
		CalculadorMoney aVencerMasDe15 = new CalculadorMoney(new Money(0));
		CalculadorMoney aVencerMasDe30 = new CalculadorMoney(new Money(0));
		CalculadorMoney totAVencer = new CalculadorMoney(new Money(0));

		CalculadorMoney deudaFinanVencido = new CalculadorMoney(new Money(0));
		CalculadorMoney deudaFinanDe1a7 = new CalculadorMoney(new Money(0));
		CalculadorMoney deudaFinanMasDe7 = new CalculadorMoney(new Money(0));
		CalculadorMoney deudaFinanMasDe15 = new CalculadorMoney(new Money(0));
		CalculadorMoney deudaFinanMasDe30 = new CalculadorMoney(new Money(0));
		CalculadorMoney deudaFinan = new CalculadorMoney(new Money(0));
		CalculadorMoney deudaComercial = new CalculadorMoney(new Money(0));

		CalculadorMoney totAFavor = new CalculadorMoney(new Money(0));
		CalculadorMoney deudaTotal = new CalculadorMoney(new Money(0));
		Sujeto sujeto = null;

		Integer oidMoneda;

		private void acum(ConsultaCtaCteClie consultaCtaCteClie) throws BaseException {
			if (consultaCtaCteClie.getSaldoCuota().doubleValue() < 0)
				totAFavor.sumar(consultaCtaCteClie.getSaldoCuota());
			else {
				int diasVenc = Fecha.fechasDiferenciaEnDias(this.fechaActual, consultaCtaCteClie.getVto());
				acumEnColVenc(diasVenc, consultaCtaCteClie.getSaldoCuota());
			}

			deudaTotal.sumar(consultaCtaCteClie.getSaldoCuota());
			deudaComercial.sumar(consultaCtaCteClie.getSaldoCuota());

		}

		private void acumValorFinan(Valor valor) throws BaseException {

			int diasVenc = Fecha.fechasDiferenciaEnDias(this.fechaActual, valor.getFechavto());
			acumDeudaFinan(diasVenc, valor.getImporte());
			
			deudaTotal.sumar(valor.getImporte());
		}
		
		private void acumDeudaFinan(int dias, Money saldo) throws BaseException {
			
			if ((dias < 0))
				deudaFinanVencido.sumar(saldo);
			else if ((dias >= 0) && (dias <= 7))
				deudaFinanDe1a7.sumar(saldo);
			else if ((dias >= 8) && (dias <= 15))
				deudaFinanMasDe7.sumar(saldo);
			else if ((dias >= 16) && (dias <= 30))
				deudaFinanMasDe15.sumar(saldo);
			else if (dias > 30)
				deudaFinanMasDe30.sumar(saldo);

			deudaFinan.sumar(saldo);

		}
		

		private void acumEnColVenc(int dias, Money saldo) throws BaseException {
			if ((dias >= -7) && (dias < 0))
				vencidaCalcDe1a7.sumar(saldo);
			else if ((dias >= -15) && (dias <= -8))
				vencidaCalcMasDe7.sumar(saldo);
			else if ((dias >= -30) && (dias <= -16))
				vencidaCalcMasDe15.sumar(saldo);
			else if (dias <= -31)
				vencidaCalcMasDe30.sumar(saldo);
			else if ((dias >= 0) && (dias <= 7))
				aVencerDe1a7.sumar(saldo);
			else if ((dias >= 8) && (dias <= 15))
				aVencerMasDe7.sumar(saldo);
			else if ((dias >= 16) && (dias <= 30))
				aVencerMasDe15.sumar(saldo);
			else if (dias > 30)
				aVencerMasDe30.sumar(saldo);

			if (dias >= 0)
				totAVencer.sumar(saldo);
			else
				totVencida.sumar(saldo);

		}
		
		private void aplicarDeudaVencida(
				CalculadorMoney vencida,
				CalculadorMoney totAAPlicar) throws BaseException {
			
			if (vencida.getResult()<=totAAPlicar.getResult()) {
				totAFavor.sumar(vencida.getResultMoney());
				totVencida.restar(vencida.getResultMoney());
				totAAPlicar.restar(vencida.getResultMoney());
				vencida.restar(vencida.getResultMoney());
				
			} else {
				totAFavor.sumar(totAAPlicar.getResultMoney());
				totVencida.restar(totAAPlicar.getResultMoney());
				vencida.restar(totAAPlicar.getResultMoney());
				totAAPlicar.restar(totAAPlicar.getResultMoney());
			}
			
			
		}
		private void aplicarDeudaAVencer(
				CalculadorMoney aVencer,
				CalculadorMoney totAAPlicar) throws BaseException {
			
			if (aVencer.getResult()<=totAAPlicar.getResult()) {
				totAVencer.restar(aVencer.getResultMoney());
				totAFavor.sumar(aVencer.getResultMoney());
				totAAPlicar.restar(aVencer.getResultMoney());
				aVencer.restar(aVencer.getResultMoney());
			} else {
				totAVencer.restar(totAAPlicar.getResultMoney());
				totAFavor.sumar(totAAPlicar.getResultMoney());
				aVencer.restar(totAAPlicar.getResultMoney());
				totAAPlicar.restar(totAAPlicar.getResultMoney());
			}
			
			
		}
		
		
		private void aplicarRecibosyNC() throws BaseException {
			
			CalculadorMoney totAAPlicar = new CalculadorMoney(this.totAFavor.getResultMoney());
			totAAPlicar.multiplicarPor(new Money(-1));
			
			if (totAAPlicar.getResult() == 0) return;
				
			aplicarDeudaVencida(vencidaCalcMasDe30,totAAPlicar);
			if (totAAPlicar.getResult()==0) return;
			aplicarDeudaVencida(vencidaCalcMasDe15,totAAPlicar);
			if (totAAPlicar.getResult()==0) return;
			aplicarDeudaVencida(vencidaCalcMasDe7,totAAPlicar);
			if (totAAPlicar.getResult()==0) return;
			aplicarDeudaVencida(vencidaCalcDe1a7,totAAPlicar);
			if (totAAPlicar.getResult()==0) return;
			
			aplicarDeudaAVencer(aVencerDe1a7,totAAPlicar);
			if (totAAPlicar.getResult()==0) return;
			aplicarDeudaAVencer(aVencerMasDe7,totAAPlicar);
			if (totAAPlicar.getResult()==0) return;
			aplicarDeudaAVencer(aVencerMasDe15,totAAPlicar);
			if (totAAPlicar.getResult()==0) return;
			aplicarDeudaAVencer(aVencerMasDe30,totAAPlicar);
			if (totAAPlicar.getResult()==0) return;
				
			
			
		}

	}
	

	public void execute(MapDatos mapaDatos) throws BaseException {

		this.fechaActua = Fecha.getFechaActual();
		
		IDataSet ds = this.getDataSetCaidaDeuda();
		IDataSet dsMoneda = this.getDataSetMonedasDeuda();
		IDataSet dsLeyenda = getDataSetLeyenda();

		Sujeto sujeto = null;

		if (mapaDatos.containsKey("oid_cliente"))
			sujeto = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_cliente"), this.getSesion());

		List vtosCtaCte = ConsultaCtaCteClie.getVtosCtaCteBySujeto(sujeto, Fecha.getFechaActual(), null, null, getSesion());

		Iterator iterVtos = vtosCtaCte.iterator();
		while (iterVtos.hasNext()) {
			ConsultaCtaCteClie consultaCtaCteClie = (ConsultaCtaCteClie) iterVtos.next();
			acumSujeto(consultaCtaCteClie);
		}

		if (mapaDatos.containsKey("deuda_financiera"))
			enviarDeudaFinanciera(mapaDatos.containsKey("no_mostrar_val_venc"));

		enviarDatosCaidaDeuda(ds ,
				mapaDatos.containsKey("aplic_rec_nc"),
				mapaDatos.containsKey("mostrar_solo_clie_con_saldo"));
		enviarMonedas(dsMoneda);
		enviarLeyenda(dsLeyenda);

		writeCliente(ds);
		writeCliente(dsMoneda);
		writeCliente(dsLeyenda);

	}

	private void enviarDeudaFinanciera(boolean noMostrarValVenc) throws BaseException {

		List listValoresEnCartera = Valor.getValoresEnCaja(null, null, TipoValor.getTiposValoresDeudaFinanciera(this.getSesion()), this
				.getSesion());

		Iterator iterValFinan = listValoresEnCartera.iterator();
		while (iterValFinan.hasNext()) {

			// Hacer un corte de control por Comprobante y Fecha de Vencimiento
			Valor valor = (Valor) iterValFinan.next();
			if (noMostrarValVenc)
				if (valor.getFechavto().before(fechaActua))
					continue;
			
			guardarSujEnCtaCte(valor.getSujeto());
			
			HashTableDatos deudaSujetos = (HashTableDatos) monedasCtaCte.get(valor.getTipovalor().getMoneda().getOIDInteger());
			if (deudaSujetos == null) {
				deudaSujetos = new HashTableDatos();
				monedasCtaCte.put(valor.getTipovalor().getMoneda().getOIDInteger(), deudaSujetos);
			}
			
			CaidaDeuda caidaDeuda = (CaidaDeuda) deudaSujetos.get(valor.getSujeto().getOIDInteger());
			
			if (caidaDeuda == null) {
				caidaDeuda = new CaidaDeuda(Fecha.getFechaActual());
				caidaDeuda.sujeto = valor.getSujeto();
				caidaDeuda.oidMoneda = valor.getTipovalor().getMoneda().getOIDInteger();
				deudaSujetos.put(valor.getSujeto().getOIDInteger(), caidaDeuda);
			}

			caidaDeuda.acumValorFinan(valor);
			
		}

	}

	private void enviarLeyenda(IDataSet dsLeyenda) throws BaseException {

		cargarLeyendaMoneda(dsLeyenda, "Cantidad de Monedas(" + monedasCtaCte.size() + ")");

	}

	private void enviarMonedas(IDataSet dsMoneda) throws BaseException {
		Iterator iterOidMonedas = this.monedasCtaCte.keySet().iterator();
		while (iterOidMonedas.hasNext()) {
			Integer oidMoneda = (Integer) iterOidMonedas.next();
			Moneda moneda = Moneda.findByOid(oidMoneda, this.getSesion());
			cargarMoneda(dsMoneda, moneda);
		}

	}

	private void acumSujeto(ConsultaCtaCteClie consultaCtaCteClie) throws BaseException {

		guardarSujEnCtaCte(consultaCtaCteClie.getSujeto());

		HashTableDatos deudaSujetos = (HashTableDatos) monedasCtaCte.get(consultaCtaCteClie.getMoneda().getOIDInteger());
		if (deudaSujetos == null) {
			deudaSujetos = new HashTableDatos();
			monedasCtaCte.put(consultaCtaCteClie.getMoneda().getOIDInteger(), deudaSujetos);
		}

		CaidaDeuda caidaDeuda = (CaidaDeuda) deudaSujetos.get(consultaCtaCteClie.getSujeto().getOIDInteger());

		if (caidaDeuda == null) {
			caidaDeuda = new CaidaDeuda(Fecha.getFechaActual());
			caidaDeuda.sujeto = consultaCtaCteClie.getSujeto();
			caidaDeuda.oidMoneda = consultaCtaCteClie.getMoneda().getOIDInteger();
			deudaSujetos.put(consultaCtaCteClie.getSujeto().getOIDInteger(), caidaDeuda);
		}

		caidaDeuda.acum(consultaCtaCteClie);

	}

	private void enviarDatosCaidaDeuda(
			IDataSet ds  , 
			boolean aplicReciboyNC,
			boolean mostrarClientesConSaldo) throws BaseException {

		Iterator iterMonedas = this.monedasCtaCte.values().iterator();
		while (iterMonedas.hasNext()) {
			HashTableDatos deudaSujetos = (HashTableDatos) iterMonedas.next();

			Iterator iterDeudaSujetos = deudaSujetos.values().iterator();
			while (iterDeudaSujetos.hasNext()) {
				CaidaDeuda caidaDeuda = (CaidaDeuda) iterDeudaSujetos.next();
				if (aplicReciboyNC)
					caidaDeuda.aplicarRecibosyNC();
					
				if (mostrarClientesConSaldo)
					if (caidaDeuda.deudaTotal.getResult()==0) continue;
					
				cargarCaidaDeuda(ds, caidaDeuda);
			}

		}

	}

	private void guardarSujEnCtaCte(Sujeto aSujeto) throws BaseException {
		Sujeto sujeto = (Sujeto) sujetosEnCtaCte.get(aSujeto.getOIDInteger());
		if (sujeto == null)
			sujetosEnCtaCte.put(aSujeto.getOIDInteger(), aSujeto);
	}

	private IDataSet getDataSetCaidaDeuda() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCaidaDeudaClientes");
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_sujeto", Field.STRING, 255));
		dataset.fieldDef(new Field("a_favor_sin_aplic", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tot_deuda", Field.CURRENCY, 0));

		dataset.fieldDef(new Field("venc_mas_30", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("venc_mas_15", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("venc_mas_7", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("venc_1_a_7", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("venc_total", Field.CURRENCY, 0));

		dataset.fieldDef(new Field("a_venc_1_a_7", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("a_venc_mas_7", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("a_venc_mas_15", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("a_venc_mas_30", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("a_venc_total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		
		dataset.fieldDef(new Field("deuda_finan_vencido", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("deuda_finan_1_a_7", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("deuda_finan_mas_7", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("deuda_finan_mas_15", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("deuda_finan_mas_30", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("deuda_finan_total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("deuda_comercial", Field.CURRENCY, 0));
		

		return dataset;
	}

	private void cargarCaidaDeuda(IDataSet ds, CaidaDeuda caidaDeuda) throws BaseException {

		ds.append();
		ds.fieldValue("oid_sujeto", caidaDeuda.sujeto.getOIDInteger());
		ds.fieldValue("cod_sujeto", caidaDeuda.sujeto.getCodigo());
		ds.fieldValue("rs_sujeto", caidaDeuda.sujeto.getRazon_social());
		ds.fieldValue("a_favor_sin_aplic", caidaDeuda.totAFavor.getResultMoney());
		ds.fieldValue("tot_deuda", caidaDeuda.deudaTotal.getResultMoney());

		ds.fieldValue("venc_mas_30", caidaDeuda.vencidaCalcMasDe30.getResultMoney());
		ds.fieldValue("venc_mas_15", caidaDeuda.vencidaCalcMasDe15.getResultMoney());
		ds.fieldValue("venc_mas_7", caidaDeuda.vencidaCalcMasDe7.getResultMoney());
		ds.fieldValue("venc_1_a_7", caidaDeuda.vencidaCalcDe1a7.getResultMoney());
		ds.fieldValue("venc_total", caidaDeuda.totVencida.getResultMoney());

		ds.fieldValue("a_venc_1_a_7", caidaDeuda.aVencerDe1a7.getResultMoney());
		ds.fieldValue("a_venc_mas_7", caidaDeuda.aVencerMasDe7.getResultMoney());
		ds.fieldValue("a_venc_mas_15", caidaDeuda.aVencerMasDe15.getResultMoney());
		ds.fieldValue("a_venc_mas_30", caidaDeuda.aVencerMasDe30.getResultMoney());
		ds.fieldValue("a_venc_total", caidaDeuda.totAVencer.getResultMoney());
		ds.fieldValue("oid_moneda", caidaDeuda.oidMoneda);
		
		ds.fieldValue("deuda_finan_vencido", caidaDeuda.deudaFinanVencido.getResultMoney());
		ds.fieldValue("deuda_finan_1_a_7", caidaDeuda.deudaFinanDe1a7.getResultMoney());
		ds.fieldValue("deuda_finan_mas_7", caidaDeuda.deudaFinanMasDe7.getResultMoney());
		ds.fieldValue("deuda_finan_mas_15", caidaDeuda.deudaFinanMasDe15.getResultMoney());
		ds.fieldValue("deuda_finan_mas_30", caidaDeuda.deudaFinanMasDe30.getResultMoney());
		ds.fieldValue("deuda_finan_total", caidaDeuda.deudaFinan.getResultMoney());
		
		ds.fieldValue("deuda_comercial", caidaDeuda.deudaComercial.getResultMoney());

	}

	private IDataSet getDataSetMonedasDeuda() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMonedasDeuda");
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarMoneda(IDataSet dsMoneda, Moneda moneda) throws BaseException {
		dsMoneda.append();
		dsMoneda.fieldValue("oid_moneda", moneda.getOIDInteger());
		dsMoneda.fieldValue("codigo", moneda.getCodigo());
		dsMoneda.fieldValue("descripcion", moneda.getDescripcion());
	}

	private IDataSet getDataSetLeyenda() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLeyendaMonedas");
		dataset.fieldDef(new Field("leyenda", Field.STRING, 100));
		return dataset;
	}

	private void cargarLeyendaMoneda(IDataSet dsLeyenda, String leyenda) throws BaseException {
		dsLeyenda.append();
		dsLeyenda.fieldValue("leyenda", leyenda);
	}

}
