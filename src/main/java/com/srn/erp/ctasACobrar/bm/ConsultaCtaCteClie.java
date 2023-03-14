package com.srn.erp.ctasACobrar.bm;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasACobrar.da.DBConsultaCtaCteClie;
import com.srn.erp.ctasAPagar.da.DBConsultaCtaCteProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ConsultaCtaCteClie extends ObjetoLogico implements Comparable {

	public static String NICKNAME = "cac.ConsultaCtaCteClie";

	private Integer orden;
	private ComproCab comprobante;
	private String tc_ext;
	private String letra;
	private Integer lugEmi;
	private Integer nroExt;
	private java.util.Date fecEmision;
	private java.util.Date fecImputac;
	private TranClie tranClie;
	private TranClieVto tranClieVto;
	private java.util.Date vto;
	private Money impoCuota;
	private Money saldoCuota;
	private TipoCtaCteClie tipoCtaCteClie;
	private String descTipoCtaCteClie;
	private Sujeto sujeto;
	private String rsSujeto;
	private Money totMonOri;
	private Money saldoMonOri;
	private String descMoneda;
	private Moneda moneda;
	private ValorCotizacion cotizMonOri;
	private ValorCotizacion cotizMonExt1;
	private ValorCotizacion cotizMonExt2;
	private ValorCotizacion cotizMonOriCon;
	private ValorCotizacion cotizMonExt1Con;
	private ValorCotizacion cotizMonExt2Con;
	private java.util.Date fechaConfCobranza;
	
	public java.util.Date getFechaCF() throws BaseException {
		if (this.getFechaConfCobranza()!=null)
			return this.getFechaConfCobranza();
		else
			return this.getVto();
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}
	
	public java.util.Date getFechaConfCobranza() throws BaseException {
		supportRefresh();
		return this.fechaConfCobranza;
	}
	
	public void setFechaConfCobranza(java.util.Date aFecConfCobranza) throws BaseException {
		this.fechaConfCobranza = aFecConfCobranza;
	}

	public void setOrden(Integer aOrden) throws BaseException {
		this.orden = aOrden;
	}

	public Money getImpoCuota() {
		return impoCuota;
	}

	public Money getTotMonOri() throws BaseException {
		supportRefresh();
		return totMonOri;
	}

	public String getDescTipoCtaCteClie() throws BaseException {
		supportRefresh();
		return descTipoCtaCteClie;
	}

	public String getLetra() throws BaseException {
		supportRefresh();
		return letra;
	}

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public String getRsSujeto() throws BaseException {
		supportRefresh();
		return rsSujeto;
	}

	public Integer getNroExt() throws BaseException {
		supportRefresh();
		return nroExt;
	}

	public TipoCtaCteClie getTipoCtaCteClie() throws BaseException {
		supportRefresh();
		return tipoCtaCteClie;
	}

	public String getTc_ext() throws BaseException {
		supportRefresh();
		return tc_ext;
	}

	public Integer getLugEmi() throws BaseException {
		supportRefresh();
		return lugEmi;
	}

	public String getNICKNAME() {
		return NICKNAME;
	}

	public Date getFecEmision() throws BaseException {
		supportRefresh();
		return fecEmision;
	}

	public Date getFecImputac() throws BaseException {
		supportRefresh();
		return fecImputac;
	}

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public TranClie getTranClie() throws BaseException {
		supportRefresh();
		return tranClie;
	}

	public Money getSaldoMonOri() throws BaseException {
		supportRefresh();
		return saldoMonOri;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public String getDescMoneda() throws BaseException {
		supportRefresh();
		return descMoneda;
	}

	public Money getSaldoCuota() throws BaseException {
		supportRefresh();
		return saldoCuota;
	}

	public Date getVto() throws BaseException {
		supportRefresh();
		return vto;
	}

	public TranClieVto getTranClieVto() throws BaseException {
		supportRefresh();
		return tranClieVto;
	}

	public ValorCotizacion getCotizMonExt2() throws BaseException {
		supportRefresh();
		return cotizMonExt2;
	}

	public ValorCotizacion getCotizMonOriCon() throws BaseException {
		supportRefresh();
		return cotizMonOriCon;
	}

	public ValorCotizacion getCotizMonExt1Con() throws BaseException {
		supportRefresh();
		return cotizMonExt1Con;
	}

	public ValorCotizacion getCotizMonOri() throws BaseException {
		supportRefresh();
		return cotizMonOri;
	}

	public ValorCotizacion getCotizMonExt2Con() throws BaseException {
		supportRefresh();
		return cotizMonExt2Con;
	}

	public ValorCotizacion getCotizMonExt1() throws BaseException {
		supportRefresh();
		return cotizMonExt1;
	}

	public void setImpoCuota(Money impoCuota) throws BaseException {
		this.impoCuota = impoCuota;
	}

	public void setTotMonOri(Money totMonOri) throws BaseException {
		this.totMonOri = totMonOri;
	}

	public void setDescTipoCtaCteClie(String descTipoCtaCteClie) throws BaseException {
		this.descTipoCtaCteClie = descTipoCtaCteClie;
	}

	public void setLetra(String letra) throws BaseException {
		this.letra = letra;
	}

	public void setSujeto(Sujeto sujeto) throws BaseException {
		this.sujeto = sujeto;
	}

	public void setRsSujeto(String rsSujeto) {
		this.rsSujeto = rsSujeto;
	}

	public void setNroExt(Integer nroExt) {
		this.nroExt = nroExt;
	}

	public void setTipoCtaCteClie(TipoCtaCteClie tipoCtaCteClie) {
		this.tipoCtaCteClie = tipoCtaCteClie;
	}

	public void setTc_ext(String tc_ext) {
		this.tc_ext = tc_ext;
	}

	public void setLugEmi(Integer lugEmi) {
		this.lugEmi = lugEmi;
	}

	public void setNICKNAME(String NICKNAME) {
		this.NICKNAME = NICKNAME;
	}

	public void setFecEmision(Date fecEmision) {
		this.fecEmision = fecEmision;
	}

	public void setFecImputac(Date fecImputac) {
		this.fecImputac = fecImputac;
	}

	public void setComprobante(ComproCab comprobante) {
		this.comprobante = comprobante;
	}

	public void setTranClie(TranClie tranClie) {
		this.tranClie = tranClie;
	}

	public void setSaldoMonOri(Money saldoMonOri) {
		this.saldoMonOri = saldoMonOri;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public void setDescMoneda(String descMoneda) {
		this.descMoneda = descMoneda;
	}

	public void setSaldoCuota(Money saldoCuota) {
		this.saldoCuota = saldoCuota;
	}

	public void setVto(Date vto) {
		this.vto = vto;
	}

	public void setTranClieVto(TranClieVto tranClieVto) {
		this.tranClieVto = tranClieVto;
	}

	public void setCotizMonExt2(ValorCotizacion cotizMonExt2) {
		this.cotizMonExt2 = cotizMonExt2;
	}

	public void setCotizMonOriCon(ValorCotizacion cotizMonLocCon) {
		this.cotizMonOriCon = cotizMonLocCon;
	}

	public void setCotizMonExt1Con(ValorCotizacion cotizMonExt1Con) {
		this.cotizMonExt1Con = cotizMonExt1Con;
	}

	public void setCotizMonOri(ValorCotizacion cotizMonOri) {
		this.cotizMonOri = cotizMonOri;
	}

	public void setCotizMonExt2Con(ValorCotizacion cotizMonExt2Con) {
		this.cotizMonExt2Con = cotizMonExt2Con;
	}

	public void setCotizMonExt1(ValorCotizacion cotizMonExt1) {
		this.cotizMonExt1 = cotizMonExt1;
	}

	public ConsultaCtaCteClie() {
	}

	/**
	 * getNickName
	 * 
	 * @return String
	 */
	public String getNickName() {
		return "";
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
	public String getDescripcion() throws BaseException {
		return this.getSujeto().getRazon_social()+" "+this.getComprobante().getCodigo();
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() throws BaseException {
		return ComproCab.getFormatoCompro(getTc_ext(), getLetra(), getLugEmi(), getNroExt());
	}

	public static List getVtosCtaCteByProveedor(Proveedor proveedor, java.util.Date fecha, TipoCtaCteProv tipoCta, Moneda moneda,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Proveedor.NICKNAME, proveedor);
		condiciones.put("fecha", fecha);
		if (tipoCta != null)
			condiciones.put(TipoCtaCteProv.NICKNAME, tipoCta);
		if (moneda != null)
			condiciones.put(Moneda.NICKNAME, moneda);
		return DBConsultaCtaCteProv.getVtosCtaCteByProveedor(condiciones, aSesion);
	}

	public static List getVtosCtaCteByProveedorSoloFacyND(Proveedor proveedor, java.util.Date fecha, TipoCtaCteProv tipoCta, Moneda moneda,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Proveedor.NICKNAME, proveedor);
		condiciones.put("fecha", fecha);
		if (tipoCta != null)
			condiciones.put(TipoCtaCteProv.NICKNAME, tipoCta);
		if (moneda != null)
			condiciones.put(Moneda.NICKNAME, moneda);
		return DBConsultaCtaCteProv.getVtosCtaCteByProveedorSoloFactyND(condiciones, aSesion);
	}

	public static List getVtosCtaCteBySujetoImputacDesdeHasta(Sujeto sujeto, java.util.Date fechaDesde, java.util.Date fechaHasta,
			ISesion aSesion) throws BaseException {

		return DBConsultaCtaCteClie.getVtosCtaCteBySujetoImputacDesdeHasta(sujeto, fechaDesde, fechaHasta, aSesion);
	}

	public static List getVtosCtaCteBySujeto(Sujeto sujeto, java.util.Date fecha, TipoCtaCteClie tipoCta, Moneda moneda, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (sujeto != null)
			condiciones.put(Sujeto.NICKNAME, sujeto);
		condiciones.put("fecha", fecha);
		if (tipoCta != null)
			condiciones.put(TipoCtaCteClie.NICKNAME, tipoCta);
		if (moneda != null)
			condiciones.put(Moneda.NICKNAME, moneda);
		return DBConsultaCtaCteClie.getVtosCtaCteBySujeto(condiciones, aSesion);
	}
	
	public static List getVtosCtaCteByComprobante(ComproCab compro, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ComproCab.NICKNAME, compro);
		return DBConsultaCtaCteClie.getVtosCtaCteByComprobante(condiciones, aSesion);
	}
	
	public static HashTableDatos getCtasCtesAplicadasConDeuda(HashTableDatos aCotizaciones,ISesion aSesion) throws BaseException {
		
		HashTableDatos cotizaciones = aCotizaciones;
		
		HashTableDatos clientesConDeuda = new HashTableDatos();
		
		// Separa las Transaccion en Positivas y Negativas
		List listVtosCtaCte = ConsultaCtaCteClie.getVtosCtaCteBySujeto(
				null,
                Fecha.getFechaActual(),
                null,
                null,
                aSesion);
		
		Iterator iterVtos = 
			listVtosCtaCte.iterator();
		while (iterVtos.hasNext()) {
			ConsultaCtaCteClie cons = (ConsultaCtaCteClie) iterVtos.next();
			
			AuxCtaCteClie1 auxCtaCteClie = (AuxCtaCteClie1) 	
				clientesConDeuda.get(cons.getSujeto().getOIDInteger());
			if (auxCtaCteClie == null) {
				auxCtaCteClie = new AuxCtaCteClie1();
				clientesConDeuda.put(cons.getSujeto().getOIDInteger(), auxCtaCteClie);
			}
			if (cons.getSaldoCuota().doubleValue()>0)
				auxCtaCteClie.addTransaccionPositiva(cons);
			else
				auxCtaCteClie.addTransaccionNegativa(cons);
				
		}
		
		// Ordenar las Listas por Fecha de Vencimiento
		Iterator iterClientesConDeuda = 
			clientesConDeuda.values().iterator();
		while (iterClientesConDeuda.hasNext()) {
			AuxCtaCteClie1 auxCtaCteClie1 = (AuxCtaCteClie1)iterClientesConDeuda.next();
			Collections.sort(auxCtaCteClie1.getListaTransacNeg());
			Collections.sort(auxCtaCteClie1.getListaTransacPos());
			
			// Recorrer los Negativos en Forma Ordenada
			for (int i = 0;i<auxCtaCteClie1.getListaTransacNeg().size();++i) {
				ConsultaCtaCteClie consTranNeg = (ConsultaCtaCteClie) auxCtaCteClie1.getListaTransacNeg().get(i);
				
				// Agotar el Saldo Negativo sobre los Positivos
				
				CalculadorMoney impoAAplicar = new CalculadorMoney(consTranNeg.getSaldoCuota());
				impoAAplicar.multiplicarPor(new Money(-1));
				for (int j = 0;j<auxCtaCteClie1.getListaTransacPos().size();++j) {
					ConsultaCtaCteClie consTranPos = (ConsultaCtaCteClie) auxCtaCteClie1.getListaTransacPos().get(j);
					
					if (consTranPos.getSaldoCuota().doubleValue()==0) continue;
					
					// Pasar el Importe a Aplicar a la Moneda de la Transaccion Positiva
					Money impoAplicMonTran = Cotizacion.getImporteEnMoneda(
							cotizaciones, 
							impoAAplicar.getResultMoney(), 
							consTranNeg.getMoneda(),
							consTranPos.getMoneda());
					
					if (impoAplicMonTran.doubleValue() <= 0) break;
					if (impoAplicMonTran.doubleValue()<=consTranPos.getSaldoCuota().doubleValue()) {
						// El importe a aplicar en menor que el saldo
						CalculadorMoney calcSaldo = new CalculadorMoney(consTranPos.getSaldoCuota());
						calcSaldo.restar(impoAplicMonTran);
						consTranPos.setSaldoCuota(calcSaldo.getResultMoney());
						impoAAplicar.restar(impoAAplicar.getResultMoney());
					} else {
						
						Money impoAplicMonTranNeg= Cotizacion.getImporteEnMoneda(
								cotizaciones, 
								consTranPos.getSaldoCuota(), 
								consTranPos.getMoneda(),
								consTranNeg.getMoneda());
						
						impoAAplicar.restar(impoAplicMonTranNeg);
						consTranPos.setSaldoCuota(new Money(0));
					}
					
				}
				
				
				
			}
			
			
		}
		
		return clientesConDeuda;
	}
	
	public int compareTo(Object arg0)  {

		try {
			return this.getVto().compareTo(((ConsultaCtaCteClie)arg0).getVto());
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			return 0;
		}

	}
	
	

}
