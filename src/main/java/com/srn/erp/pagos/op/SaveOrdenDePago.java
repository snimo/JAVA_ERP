package com.srn.erp.pagos.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctasAPagar.bm.ComproAnticipoProveedor;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CatRetGan;
import com.srn.erp.pagos.bm.CertificadoRetGanCab;
import com.srn.erp.pagos.bm.CertificadoRetGanDet;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.pagos.bm.ComproOrdenPagoDet;
import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.pagos.bm.ImputacionPagosVarios;
import com.srn.erp.pagos.bm.MotivoPago;
import com.srn.erp.pagos.bm.PeriRetGan;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MedioPago;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveOrdenDePago extends Operation {

  private ComproOrdenPagoCab comproordenpagocab = null;

  public SaveOrdenDePago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TOrdPagoCab");
    
    IDataSet dsCotizaciones = null;
    if (mapaDatos.containsKey("TCotizaciones"))
    	dsCotizaciones = mapaDatos.getDataSet("TCotizaciones");
    
    procesarRegistros(mapaDatos,dataset,dsCotizaciones);
  }

  private void procesarRegistros(MapDatos mapa,IDataSet dataset,IDataSet dsCotizaciones) throws BaseException {
	  
	Proveedor proveedor = null;  
	  
    dataset.first();
      while (!dataset.EOF()) {
        comproordenpagocab =
            ComproOrdenPagoCab.findByOid(dataset.getInteger("oid"),
                                         getSesion());
        
        if ((!comproordenpagocab.isNew()) && comproordenpagocab.isActivo() && (dataset.getBoolean("activo")==false)) {
        	comproordenpagocab.setActivo(false);
        	comproordenpagocab.delete();
        	this.addTransaccion(comproordenpagocab);
        	return;
        }
        
        comproordenpagocab.cargarCotizaciones(dsCotizaciones);
        comproordenpagocab.setContabiliza(ComproOrdenPagoCab.getContabilizarComprobante(getSesion()));
        comproordenpagocab.setTipoCompro(ComproOrdenPagoCab.getTipoComproOrdenPago(getSesion()));
        comproordenpagocab.setLetra(ComproCab.getLetraDefault(getSesion()));
        comproordenpagocab.setLugarEmision(ComproCab.getLugEmiDafault(getSesion()));
        comproordenpagocab.setComentario("");
        comproordenpagocab.setEmision(dataset.getDate("fecha"));
        comproordenpagocab.setImputac(dataset.getDate("fecha"));
        comproordenpagocab.setFecemision(dataset.getDate("fecha"));
        comproordenpagocab.setMotivopago(MotivoPago.findByOid(dataset.getInteger("oid_motivo_pago"),getSesion()));
        comproordenpagocab.setMoneda(Moneda.findByOid(dataset.getInteger("oid_moneda"),getSesion()));
        comproordenpagocab.setCotizacion(dataset.getDouble("cotizacion"));
        proveedor = Proveedor.findByOid(dataset.getInteger("oid_proveedor"),getSesion());
        comproordenpagocab.setProveedor(proveedor);
        comproordenpagocab.setActivo(dataset.getBoolean("activo"));
        comproordenpagocab.setRetGanMonPago(dataset.getMoney("ret_gan_mon_pago"));
        comproordenpagocab.setPagoACuenta(dataset.getMoney("pago_cta_mon_pago"));
        comproordenpagocab.setTalonario(Talonario.findByOid(dataset.getInteger("oid_talonario"),getSesion()));
        comproordenpagocab.setFormaPago(FormaPago.findByOid(dataset.getInteger("oid_forma_pago"),getSesion()));
        

        Moneda moneda = Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion());
        ValorCotizacion cotizacionMonOP = dataset.getCotizacion("cotizacion");
        comproordenpagocab.addCotizacionMoneda(moneda,cotizacionMonOP);
        
        
        IDataSet dsCalcTotOP = mapa.getDataSet("TCalculoMontosOP");
        dsCalcTotOP.first();
        while (!dsCalcTotOP.EOF()) {
        	comproordenpagocab.setBruto(dsCalcTotOP.getMoney("bruto"));
        	comproordenpagocab.setDescuento(dsCalcTotOP.getMoney("descuento"));
        	comproordenpagocab.setNeto(dsCalcTotOP.getMoney("neto_descuento"));
        	comproordenpagocab.setRetIVA(dsCalcTotOP.getMoney("ret_iva"));
        	comproordenpagocab.setRetGan(dsCalcTotOP.getMoney("ret_gan"));
        	comproordenpagocab.setRetIB(dsCalcTotOP.getMoney("ret_ib"));
        	comproordenpagocab.setRetSUS(dsCalcTotOP.getMoney("ret_sus"));
        	comproordenpagocab.setTotalPago(dsCalcTotOP.getMoney("a_pagar"));
        	dsCalcTotOP.next();
        }
        
        // Recorrer las Imputaciones de OP Varias
        IDataSet dsImpuOPVarias = dataset.getDataSet("TImputacionPagosVarios");
        dsImpuOPVarias.first();
        while (!dsImpuOPVarias.EOF()) {
        	ImputacionPagosVarios impuPagosVarios = ImputacionPagosVarios.findByOid(dsImpuOPVarias.getInteger("oid_impu_op_varias"), this.getSesion());
        	impuPagosVarios.setCuenta_imputable(CuentaImputable.findByOidProxy(dsImpuOPVarias.getInteger("oid_ana_imp"), this.getSesion()));
        	impuPagosVarios.setComprobante(comproordenpagocab);
        	impuPagosVarios.setDebe_mon_pago(dsImpuOPVarias.getMoney("debe_mon_pago"));
        	impuPagosVarios.setHaber_mon_pago(dsImpuOPVarias.getMoney("haber_mon_pago"));
        	if (impuPagosVarios.getDebe_mon_pago()!=null)
        		impuPagosVarios.setDebe_mon_loc(comproordenpagocab.getImporteEnMonLoc(impuPagosVarios.getDebe_mon_pago(),comproordenpagocab.getMoneda()));
        	if (impuPagosVarios.getHaber_mon_pago()!=null)
        	impuPagosVarios.setHaber_mon_loc(comproordenpagocab.getImporteEnMonLoc(impuPagosVarios.getHaber_mon_pago(),comproordenpagocab.getMoneda()));
        	impuPagosVarios.setComentario(dsImpuOPVarias.getString("comentario"));
        	impuPagosVarios.setActivo(dsImpuOPVarias.getBoolean("activo"));
        	comproordenpagocab.addImputacionOPVarias(impuPagosVarios);
        	dsImpuOPVarias.next();
        }
        
        

        // Recorrer los vencimientos Pagados
        IDataSet dsVtosPagados = dataset.getDataSet("TVtosPagados");
        dsVtosPagados.first();
        while (!dsVtosPagados.EOF()) {
          ComproOrdenPagoDet comproOrdenPagoDet =
              ComproOrdenPagoDet.findByOid(dsVtosPagados.getInteger("oid_compro_det_op"),
                                           getSesion());

          comproOrdenPagoDet.setComprobante(comproordenpagocab);
          TranProvVto tranProvVto =
                TranProvVto.findByOidProxy(dsVtosPagados.getInteger("oid_tran_vto"),getSesion());
          ComproAnticipoProveedor comproAnticipoProv = (ComproAnticipoProveedor)
          	ComproAnticipoProveedor.findByOid(dsVtosPagados.getInteger("oid_cco_ant_prov"),getSesion());
          
          comproOrdenPagoDet.setTranprovvto(tranProvVto);
          comproOrdenPagoDet.setComproAntProv(comproAnticipoProv);
          comproOrdenPagoDet.setMoneda(Moneda.findByOidProxy(dsVtosPagados.getInteger("oid_moneda"),getSesion()));
          comproOrdenPagoDet.setImpofactmonori(dsVtosPagados.getMoney("impo_fact_mon_ori"));
          comproOrdenPagoDet.setImpoautorizmonori(dsVtosPagados.getMoney("impo_auto_mon_ori"));
          comproOrdenPagoDet.setDtomonori(dsVtosPagados.getMoney("dto_mon_ori"));
          comproOrdenPagoDet.setImpomaxautorizori(dsVtosPagados.getMoney("impo_max_auto_ori"));
          comproOrdenPagoDet.setNetopagomonori(dsVtosPagados.getMoney("neto_pago_mon_ori"));
          comproOrdenPagoDet.setImpofactmonpago(dsVtosPagados.getMoney("impo_fact_mon_pago"));
          comproOrdenPagoDet.setImpoautorizmonpago(dsVtosPagados.getMoney("impo_auto_mon_pago"));
          comproOrdenPagoDet.setDtomonpago(dsVtosPagados.getMoney("dto_mon_pago"));
          comproOrdenPagoDet.setImpomaxautorizpago(dsVtosPagados.getMoney("impo_max_auto_pago"));
          comproOrdenPagoDet.setNetopagomonpago(dsVtosPagados.getMoney("neto_pago_mon_pago"));
          comproOrdenPagoDet.setCotizacion(dsVtosPagados.getCotizacion("cotizacion"));
          
          
          Moneda monedaVtoFact = Moneda.findByOidProxy(dsVtosPagados.getInteger("oid_moneda"),getSesion());
          comproOrdenPagoDet.setValorCotizOriHoy(comproordenpagocab.getCotizacionMoneda(monedaVtoFact));
          comproOrdenPagoDet.setValorCotizExt1Hoy(comproordenpagocab.getCotizMonExt1());
          comproOrdenPagoDet.setValorCotizExt2Hoy(comproordenpagocab.getCotizMonExt2());
          Moneda monedaVtos = Moneda.findByOidProxy(dsVtosPagados.getInteger("oid_moneda"),getSesion());
          comproOrdenPagoDet.setImpoMaxAutoLoc(comproordenpagocab.getImporteEnMonLoc(dsVtosPagados.getMoney("impo_max_auto_ori"),monedaVtos));
          comproOrdenPagoDet.setImpoAutoMonLoc(comproordenpagocab.getImporteEnMonLoc(dsVtosPagados.getMoney("impo_auto_mon_ori"),monedaVtos));
          comproOrdenPagoDet.setImpoFactMonLoc(comproordenpagocab.getImporteEnMonLoc(dsVtosPagados.getMoney("impo_fact_mon_ori"),monedaVtos));
          comproOrdenPagoDet.setDtoMonLoc(comproordenpagocab.getImporteEnMonLoc(dsVtosPagados.getMoney("dto_mon_ori"),monedaVtos));
          comproOrdenPagoDet.setNetoPagoMonLoc(comproordenpagocab.getImporteEnMonLoc(dsVtosPagados.getMoney("neto_pago_mon_ori"),monedaVtos));
          
          comproOrdenPagoDet.setImporteCuota(dsVtosPagados.getMoney("impo_cuota"));
          comproOrdenPagoDet.setSaldoCuota(dsVtosPagados.getMoney("saldo_cuota"));
          comproOrdenPagoDet.setAutorizado(dsVtosPagados.getMoney("autorizado"));
          comproOrdenPagoDet.setPagar(dsVtosPagados.getMoney("a_pagar"));
          
          comproordenpagocab.addOrdenPagoDet(comproOrdenPagoDet);

          dsVtosPagados.next();
        }

        // Recorrer los Medios de Pago
        IDataSet dsMediosPago = dataset.getDataSet("TMediosPago");
        dsMediosPago.first();
        while (!dsMediosPago.EOF()) {
          MedioPago medioPago = comproordenpagocab.addMedioPago();
          medioPago.setIngresoEgreso(MedioPago.EGRESO);
          medioPago.setOidOPMedioPago(dsMediosPago.getInteger("oid_op_medio_pago"));
          medioPago.setFechaContable(comproordenpagocab.getFecemision());
          medioPago.setTipoValor(TipoValor.findByOid(dsMediosPago.getInteger("oid_tipo_valor"),getSesion()));
          medioPago.setCaja(Caja.findByOid(dsMediosPago.getInteger("oid_caja"),getSesion()));
          medioPago.setOidEntidad(dsMediosPago.getInteger("oid_entidad"));
          
          if ((dsMediosPago.getString("nro_valor")!=null) && (dsMediosPago.getString("nro_valor").length()>0))
        	  medioPago.setNro_cheque(new Integer(dsMediosPago.getString("nro_valor").trim()));
          else
        	  medioPago.setNro_cheque(null);
          medioPago.setFecEmision(dsMediosPago.getDate("fec_emision"));
          medioPago.setFecVencimiento(dsMediosPago.getDate("fec_vto"));
          medioPago.setImporteMonedaPago(dsMediosPago.getMoney("impo_mon_pago"));
          medioPago.setImporteMonedaValor(dsMediosPago.getMoney("impo_mon_valor"));
          medioPago.setCotizMonedaValor(dsMediosPago.getCotizacion("cotizacion"));
          medioPago.setValor(Valor.findByOid(dsMediosPago.getInteger("oid_valor"),getSesion()));
          if (medioPago.getTipoValor().isChequePropio())
        	  medioPago.setProveedor(proveedor);
          if (medioPago.getTipoValor().isChequeCliente() || 
        	  medioPago.getTipoValor().isChequeTercero() || 
        	  medioPago.getTipoValor().isCuponTarjetaDebito() ||
        	  medioPago.getTipoValor().isTarjetaCredito()
        	  )
          	medioPago.setEndosar(true);
          
          if ((medioPago.getTipoValor().isCertificadoRetGan()) ||
             (medioPago.getTipoValor().isCertificadoRetIB()) ||
             (medioPago.getTipoValor().isCertificadoRetIVA()) ||
             (medioPago.getTipoValor().isCertificadoRetSUS()))
        	  medioPago.setEstaLiquidando(true);
          
          if (dsMediosPago.getMoney("impo_mon_valor") == null)
        	  throw new ExceptionValidation(null,"Debe ingresar el importe del Valor");
          
          medioPago.setImportesContables(
        		  comproordenpagocab.getImportesContables(dsMediosPago.getMoney("impo_mon_valor"),
        				  								  medioPago.getTipoValor().getMoneda(),
        				  								  comproordenpagocab.getFecemision()));
          dsMediosPago.next();
        }

        // Grabar los Certificados de Retencion
        IDataSet dsCertRetCab = dataset.getDataSet("TCertificadoRetCab");
        dsCertRetCab.first();
        while (!dsCertRetCab.EOF()) {
          CertificadoRetGanCab certRetGan =
              CertificadoRetGanCab.findByOid(dsCertRetCab.getInteger("oid_cert_ret_cab"),
                                             getSesion());
          certRetGan.setContabiliza(false);
          certRetGan.inicializar();
          certRetGan.setEmision(comproordenpagocab.getEmision());
          certRetGan.setCatretgan(CatRetGan.findByOid(dsCertRetCab.getInteger("oid_cat_ret_gan"),getSesion()));
          certRetGan.setOrdendepago(comproordenpagocab);
          certRetGan.setProveedor(Proveedor.findByOid(dsCertRetCab.getInteger("oid_proveedor"),getSesion()));
          certRetGan.setPeriretgan(PeriRetGan.findByOid(dsCertRetCab.getInteger("oid_peri_ret_gan"),getSesion()));
          certRetGan.setPorclib(dsCertRetCab.getMoney("porc_lib"));
          certRetGan.setDecreto(dsCertRetCab.getString("decreto"));
          comproordenpagocab.addCertificadoRetGan(certRetGan);

          IDataSet dsCertRetGanDet = dsCertRetCab.getDataSet("TCertificadoRetDet");
          dsCertRetGanDet.first();
          while (!dsCertRetGanDet.EOF()) {
            Integer oidCertRetDet = dsCertRetGanDet.getInteger("oid_cert_ret_det");
            CertificadoRetGanDet certRetGanDet = CertificadoRetGanDet.findByOid(oidCertRetDet,getSesion());
            certRetGanDet.setCertificado(certRetGan);
            certRetGanDet.setConceptoimpuesto(ConceptoImpuesto.findByOidProxy(dsCertRetGanDet.getInteger("oid_conc_impu"),getSesion()));
            certRetGanDet.setMontonoimponible(dsCertRetGanDet.getMoney("monto_no_impo"));
            certRetGanDet.setMontoretminima(dsCertRetGanDet.getMoney("monto_ret_min"));
            certRetGanDet.setMontogravado(dsCertRetGanDet.getMoney("monto_gravado"));
            certRetGanDet.setPorcentaje(dsCertRetGanDet.getMoney("porc_ret"));
            certRetGanDet.setMontofijo(dsCertRetGanDet.getMoney("monto_fijo"));
            certRetGanDet.setBasepararetener(dsCertRetGanDet.getMoney("base_para_retener"));
            certRetGanDet.setPagoacum(dsCertRetGanDet.getMoney("pago_acum"));
            certRetGanDet.setRetacum(dsCertRetGanDet.getMoney("ret_acum"));
            certRetGanDet.setPagoneto(dsCertRetGanDet.getMoney("pago_neto"));
            certRetGanDet.setImpuestoretenido(dsCertRetGanDet.getMoney("impuesto_retenido"));
            certRetGanDet.setRetencionesContables(
            		comproordenpagocab.getImportesContables(dsCertRetGanDet.getMoney("impuesto_retenido"),
                                            				comproordenpagocab.getMoneda(),
                                            				comproordenpagocab.getFecemision()));
            certRetGan.addDetalle(certRetGanDet);
            dsCertRetGanDet.next();
          }


          dsCertRetCab.next();
        }



        addTransaccion(comproordenpagocab);
        dataset.next();
    }
  }


  protected void afterSave() throws BaseException {

      InformarComprobante infoCompro = new InformarComprobante(
        comproordenpagocab.getOIDInteger(),
        comproordenpagocab.getDescripcion());

      writeCliente(infoCompro.getDataSetInfoCompro());

  }
  


}
