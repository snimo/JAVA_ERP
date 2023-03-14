package com.srn.erp.tesoreria.op;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.FacturasRecibo;
import com.srn.erp.tesoreria.bm.MedioPago;
import com.srn.erp.tesoreria.bm.MotivoIngresoVarios;
import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.Ticket;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.ventas.bm.Cobrador;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecibo extends Operation {

	Recibo	recibo	= null;
	HashTableDatos listaCotiz = null;

	public SaveRecibo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		if (mapaDatos.containsKey("TCotizaciones"))
			listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));
		
		IDataSet dsRecibo = mapaDatos.getDataSet("TRecibo");
		procesarRecibo(dsRecibo,mapaDatos);
	}

	private void procesarRecibo(IDataSet dsRecibo,MapDatos mapaDatos) throws BaseException {
		dsRecibo.first();
		while (!dsRecibo.EOF()) {
			recibo = Recibo.findByOid(dsRecibo.getInteger("oid_cco_recibo"), getSesion());
			
			// Analizar si se trata de una Anulación del Recibo
			if ((recibo.isNew()==false) && 
					(recibo.isActivo().booleanValue()) && 
					(dsRecibo.getBoolean("activo").booleanValue()==false)) {
				recibo.delete();
				this.addTransaccion(recibo);
				return;
			}
			
			procesarCabRecibo(recibo,dsRecibo);
			procesarMediosPago(dsRecibo,mapaDatos);
			procesarFactCobradas(dsRecibo);
			procesarMotivosIngVar(dsRecibo,recibo);
						
			addTransaccion(recibo);
			dsRecibo.next();
		}

	}

	protected void afterSave() throws BaseException {

		InformarComprobante infoCompro = 
			new InformarComprobante(recibo.getOIDInteger(), 
					                    recibo.getDescripcion());

		writeCliente(infoCompro.getDataSetInfoCompro());

	}
	
	
	
	private void procesarCabRecibo(Recibo aRecibo,IDataSet dsRecibo) throws BaseException {
		recibo.addCotizacionesMonedas(listaCotiz);
		recibo.setContabiliza(Recibo.isContabilizaRecibo(this.getSesion()));
		recibo.setTalonario(Talonario.findByOidProxy(dsRecibo.getInteger("oid_talonario"), getSesion()));
		recibo.setTipoCompro(TipoComprobante.findByOidProxy(dsRecibo.getInteger("oid_tc"), getSesion()));
		recibo.setLetra(dsRecibo.getString("letra"));
		LugarEmision lugEmi = LugarEmision.findByOidProxy(dsRecibo.getInteger("oid_lug_emi"), getSesion());
		recibo.setLugarEmision(lugEmi);
		recibo.setNrolugemision(lugEmi.getLugemi());
		recibo.setEmision(dsRecibo.getDate("fec_emision"));
		recibo.setNroext(dsRecibo.getInteger("nro_ext"));
		recibo.setImputac(dsRecibo.getDate("fec_imputacion"));
		recibo.setComentario(dsRecibo.getString("comentario"));
		recibo.setMoneda(Moneda.findByOidProxy(dsRecibo.getInteger("oid_moneda"), getSesion()));
		recibo.setCotizacion(dsRecibo.getCotizacion("cotizacion"));
		recibo.setMotivoComprobante(MotivoComprobante.findByOidProxy(dsRecibo.getInteger("oid_motivo_recibo"),
				getSesion()));
		recibo.setSujeto(Sujeto.findByOidProxy(dsRecibo.getInteger("oid_sujeto"), getSesion()));
		recibo.setTipoOper(dsRecibo.getString("tipo_oper"));
		recibo.setImputac(dsRecibo.getDate("fec_imputacion"));
		recibo.setCaja(Caja.findByOidProxy(dsRecibo.getInteger("oid_caja"), getSesion()));
		recibo.setCobrador(Cobrador.findByOidProxy(dsRecibo.getInteger("oid_cobrador"), getSesion()));
		recibo.setNro_rec_ori(dsRecibo.getString("recibo_provisorio"));
		recibo.setTot_mon_ori(dsRecibo.getMoney("tot_mon_ori"));
		recibo.setEnConcepto(dsRecibo.getString("en_concepto"));
		if (dsRecibo.getBoolean("pago_a_cuenta").booleanValue()) {
			recibo.setIsPagoACuenta(new Boolean(true));
			recibo.setPagoACuenta(dsRecibo.getMoney("impo_pago_a_cuenta"));
		}	
		
	}
	
	public void procesarMediosPago(IDataSet dsRecibo,MapDatos mapaDatos) throws BaseException {
		
  	// Tratar los Medios de pago
  	IDataSet dsValores = mapaDatos.getDataSet("TValores");
  	dsValores.first();
  	while (!dsValores.EOF()) {
  	     MedioPago medioPago = recibo.addMedioPago();
           medioPago.setIngresoEgreso(MedioPago.INGRESO);
           medioPago.setSujeto(recibo.getSujeto());
           medioPago.setOidOPMedioPago(dsValores.getInteger("secu"));
           medioPago.setFechaContable(recibo.getImputac());
           TipoValor tipoValor = TipoValor.findByOid(dsValores.getInteger("oid_tipo_valor"),getSesion());           
           medioPago.setTipoValor(tipoValor);
           if (!tipoValor.isEfectivo()) // 
          	 medioPago.setOidEntidad(dsValores.getInteger("oid_entidad"));
           medioPago.setNro_cheque(dsValores.getInteger("nro"));
           medioPago.setFecEmision(dsValores.getDate("fec_emision"));
           medioPago.setNroCertificado(dsValores.getString("nro_certificado"));
           medioPago.setProvincia(Provincia.findByOid(dsValores.getInteger("oid_provincia"),getSesion()));
           medioPago.setFecVencimiento(dsValores.getDate("fec_vto"));
           medioPago.setImporteMonedaPago(dsValores.getMoney("impo_mon_fact"));
           medioPago.setImporteMonedaValor(dsValores.getMoney("importe"));
           medioPago.setLote(dsValores.getInteger("lote"));
           medioPago.setCupon(dsValores.getInteger("cupon"));
           medioPago.setCuotas(dsValores.getInteger("cuotas"));
           medioPago.setNroTarjeta(dsValores.getString("nro_tarjeta"));
           medioPago.setCotizMonedaValor(dsValores.getCotizacion("cotizacion"));
           medioPago.setTarjetaCredito(TarjetaCredito.findByOidProxy(dsValores.getInteger("oid_tarjeta_credito"),getSesion()));
           medioPago.setTicket(Ticket.findByOidProxy(dsValores.getInteger("oid_ticket"),getSesion()));
           medioPago.setCaja(recibo.getCaja());
           if ((dsValores.getString("cuit_cuil")!=null) && (dsValores.getString("cuit_cuil").length()>0))
          	 medioPago.setCUIT(dsValores.getString("cuit_cuil"));
           else if ((recibo.getSujeto()!=null) && (recibo.getSujeto().getSujeto_impositivo()!=null))
          	 		medioPago.setCUIT(recibo.getSujeto().getSujeto_impositivo().getCuit());
           medioPago.setImportesContables(
         		  recibo.getImportesContables(dsValores.getMoney("importe"),
         				  						  					medioPago.getTipoValor().getMoneda(),
         				  						  					recibo.getEmision()));    		
  		dsValores.next();
  	}
  	  	
	}
	
	public void procesarFactCobradas(IDataSet dsRecibo) throws BaseException {
  	IDataSet dsFactCobradas = dsRecibo.getDataSet("TFacturasCobradas");
  	dsFactCobradas.first();
  	while (!dsFactCobradas.EOF()) {
  		FacturasRecibo facturaEnRecibo = (FacturasRecibo) FacturasRecibo.getNew(FacturasRecibo.NICKNAME,getSesion());
  		facturaEnRecibo.setRecibo(recibo);
  		
  		TranClieVto tranVtoClie = TranClieVto.findByOid(dsFactCobradas.getInteger("oid_tran_vto"),getSesion()); 
  		facturaEnRecibo.setTranClieVto(tranVtoClie);
  		facturaEnRecibo.setImpo_mon_ori(dsFactCobradas.getMoney("impo_mon_ori"));
  		facturaEnRecibo.setImpo_mon_loc(dsFactCobradas.getMoney("impo_mon_loc"));
  		facturaEnRecibo.setSaldo_mon_ori(dsFactCobradas.getMoney("saldo_mon_ori"));
  		facturaEnRecibo.setSaldo_mon_loc(dsFactCobradas.getMoney("saldo_mon_loc"));
  		facturaEnRecibo.setImpo_dto_mon_ori(dsFactCobradas.getMoney("impo_dto_mon_ori"));
  		facturaEnRecibo.setImpo_dto_mon_loc(dsFactCobradas.getMoney("impo_dto_mon_loc"));
  		facturaEnRecibo.setImpo_cob_mon_ori(dsFactCobradas.getMoney("impo_cob_mon_ori"));
  		facturaEnRecibo.setImpo_cob_mon_loc(dsFactCobradas.getMoney("impo_cob_mon_loc"));
  		facturaEnRecibo.setCotizacion(dsFactCobradas.getCotizacion("cotizacion"));
  		facturaEnRecibo.setImpoCobMonRec(dsFactCobradas.getMoney("impo_cob_mon_rec"));
  		recibo.addFacturaRecibo(facturaEnRecibo);
  		dsFactCobradas.next();
  	}     
	}
	
	public void procesarMotivosIngVar(IDataSet dsRecibo,Recibo recibo) throws BaseException {
		IDataSet dsMotivosIngresos = dsRecibo.getDataSet("TMotivosIngresos");
		dsMotivosIngresos.first();
		while (!dsMotivosIngresos.EOF()) {
			MotivoIngresoVarios motivoIngresosVarios = MotivoIngresoVarios.findByOid(dsMotivosIngresos.getInteger("oid_mot_ing_rec"),getSesion());
			motivoIngresosVarios.setRecibo(recibo);
			motivoIngresosVarios.setCuenta_imputable(CuentaImputable.findByOidProxy(dsMotivosIngresos.getInteger("oid_ai"),getSesion()));
			motivoIngresosVarios.setDebe(dsMotivosIngresos.getMoney("debe"));
			motivoIngresosVarios.setHaber(dsMotivosIngresos.getMoney("haber"));
			motivoIngresosVarios.setComentario(dsMotivosIngresos.getString("comentario"));
			recibo.addMotivoIngVarios(motivoIngresosVarios);
			dsMotivosIngresos.next();
		}
		
	}
	
	
  private HashTableDatos cargarCotizaciones(IDataSet dsCotizaciones) throws BaseException {
	  HashTableDatos listaCotizaciones = new HashTableDatos();
	  dsCotizaciones.first();
	  while (!dsCotizaciones.EOF()) {
		  Moneda moneda              = Moneda.findByOidProxy(dsCotizaciones.getInteger("oid_moneda"),getSesion());
		  ValorCotizacion valorCotiz = dsCotizaciones.getCotizacion("cotizacion");
		  listaCotizaciones.put(moneda,valorCotiz);
		  dsCotizaciones.next();
	  }
	  return listaCotizaciones;
  }
	

}
