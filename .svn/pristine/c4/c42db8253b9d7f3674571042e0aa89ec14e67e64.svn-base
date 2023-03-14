package com.srn.erp.pagos.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctasAPagar.bm.ComproProvDetCtaImpu;
import com.srn.erp.ctasAPagar.bm.ComproProvTotImpu;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.ctasAPagar.bm.ComproProveedorDet;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.RendicionFFImpuestos;
import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.pagos.bm.RendicionFondoFijoCompro;
import com.srn.erp.pagos.bm.RendicionFondoFijoComproImpu;
import com.srn.erp.pagos.bm.RendicionFondoFijoImpu;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MedioPago;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRendicionFondoFijo extends Operation {

	private IDataSet dsCotizaciones = null;
	private RendicionFondoFijo rendicionFondoFijo = null; 
	
  public SaveRendicionFondoFijo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
  	if (mapaDatos.containsKey("TCotizaciones")) 	
  		dsCotizaciones = mapaDatos.getDataSet("TCotizaciones");
    IDataSet dataset = mapaDatos.getDataSet("TRendicionCab");
    saveRendicionFondoFijo(dataset,dsCotizaciones);
  }

  private void saveRendicionFondoFijo(IDataSet dataset,IDataSet dsCotizaciones) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
    	rendicionFondoFijo = RendicionFondoFijo.findByOid(dataset.getInteger("oid_rendicion_cab"),getSesion());
    	
    	
    	// Ver si se trata de una anulacion
			if ((rendicionFondoFijo.isNew()==false) && 
					(rendicionFondoFijo.isActivo().booleanValue()) && 
					(dataset.getBoolean("activo").booleanValue()==false)) {
				rendicionFondoFijo.delete();
				this.addTransaccion(rendicionFondoFijo);
				dataset.next();
				continue;
			}    	
    	
    	rendicionFondoFijo.cargarCotizaciones(dsCotizaciones);
    	rendicionFondoFijo.setContabiliza(RendicionFondoFijo.contabilizarComprobante(getSesion()));
    	
    	Talonario talonario = Talonario.findByOid(dataset.getInteger("oid_talonario"),getSesion());
    	
    	rendicionFondoFijo.setTalonario(talonario);
    	rendicionFondoFijo.setTipoCompro(talonario.getTipo_comprobante());
    	rendicionFondoFijo.setLetra(talonario.getLetra());
    	rendicionFondoFijo.setLugarEmision(talonario.getLugar_emision());
    	rendicionFondoFijo.setEmision(dataset.getDate("fecha"));
    	rendicionFondoFijo.setImputac(dataset.getDate("fecha"));
    	rendicionFondoFijo.setComentario(dataset.getString("comentario"));
    	rendicionFondoFijo.setCotizacion(dataset.getCotizacion("cotizacion"));
    	rendicionFondoFijo.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
    	rendicionFondoFijo.setActivo(new Boolean(true));
    	
    	armarComproProveedor(dataset,
    			                 rendicionFondoFijo,
    			                 dsCotizaciones,
    			                 Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()),
    			                 dataset.getCotizacion("cotizacion")
    			                 );
    	armarImputacionesRendFF(dataset,rendicionFondoFijo);
    	armarMediosPago(dataset,rendicionFondoFijo);
    	
        addTransaccion(rendicionFondoFijo);
        dataset.next();
    }
  }
  
  private void armarMediosPago(IDataSet dsRendFF,
          RendicionFondoFijo rendFF) throws BaseException { 
	  
      // Recorrer los Medios de Pago
      IDataSet dsMediosPago = dsRendFF.getDataSet("TMediosPago");
      dsMediosPago.first();
      while (!dsMediosPago.EOF()) {
        MedioPago medioPago = rendFF.addMedioPago();
        
        medioPago.setIngresoEgreso(MedioPago.EGRESO);
        medioPago.setOidOPMedioPago(dsMediosPago.getInteger("oid_rend_med_pago"));
        medioPago.setFechaContable(rendFF.getEmision());
        medioPago.setTipoValor(TipoValor.findByOid(dsMediosPago.getInteger("oid_tipo_valor"),getSesion()));
        medioPago.setImporteMonedaPago(dsMediosPago.getMoney("impo_mon_pago"));
        medioPago.setImporteMonedaValor(dsMediosPago.getMoney("impo_mon_valor"));
        medioPago.setCotizMonedaValor(dsMediosPago.getCotizacion("cotizacion"));
        medioPago.setCaja(Caja.findByOid(dsMediosPago.getInteger("oid_caja"),getSesion()));
        medioPago.setImportesContables(
        		rendFF.getImportesContables(dsMediosPago.getMoney("impo_mon_valor"),
                                     		medioPago.getTipoValor().getMoneda(),
                                     		rendFF.getEmision()));
        dsMediosPago.next();
      }
	  
  }
  
  private void armarImputacionesRendFF(IDataSet dsRendFF,
          RendicionFondoFijo rendFF) throws BaseException {
	  IDataSet dsImputaciones = dsRendFF.getDataSet("TRenfFFImputaciones");
	  dsImputaciones.first();
	  while (!dsImputaciones.EOF()) {
		  RendicionFondoFijoImpu renfFFImputacion = rendFF.addRendFFImputacion();
		  renfFFImputacion.setCuenta_imputable(CuentaImputable.findByOidProxy(dsImputaciones.getInteger("oid_ai"),getSesion()));
		  renfFFImputacion.setImporte_debe(dsImputaciones.getDouble("importe_debe"));
		  renfFFImputacion.setImporte_haber(dsImputaciones.getDouble("importe_haber"));
		  renfFFImputacion.setComentario(dsImputaciones.getString("comentario"));
		  dsImputaciones.next();
	  }
  }
  
  private void armarComproProveedor(IDataSet dsRendFF,
		                            RendicionFondoFijo rendFF,
		                            IDataSet dsCotizaciones,
		                            Moneda moneda,
		                            ValorCotizacion cotizacion) throws BaseException {
	  IDataSet dsRendFFComproProv = dsRendFF.getDataSet("TRendicionComproProv");
	  dsRendFFComproProv.first();
	  while (!dsRendFFComproProv.EOF()) {
		  RendicionFondoFijoCompro renfFFCompro = rendFF.addDetComproProvFF();
		  
		  renfFFCompro.setNetoGravado(dsRendFFComproProv.getMoney("neto_gravado"));
		  renfFFCompro.setNetoNoGravado(dsRendFFComproProv.getMoney("neto_no_gravado"));
		  renfFFCompro.setIVA(dsRendFFComproProv.getMoney("iva"));
		  renfFFCompro.setPercIVA(dsRendFFComproProv.getMoney("perc_iva"));

		  renfFFCompro.setPercIB(dsRendFFComproProv.getMoney("perc_ib"));
		  renfFFCompro.setOtrosImp(dsRendFFComproProv.getMoney("otros_imp"));
		  renfFFCompro.setTotal(dsRendFFComproProv.getMoney("total"));
		  renfFFCompro.setMoneda(Moneda.findByOidProxy(dsRendFFComproProv.getInteger("oid_moneda"),this.getSesion()));
		  renfFFCompro.setConcFactProv(ConcFactProv.findByOidProxy(dsRendFFComproProv.getInteger("oid_conc_fact_prov"),this.getSesion()));
		  renfFFCompro.setConcImpuIVA(ConceptoImpuesto.findByOidProxy(dsRendFFComproProv.getInteger("oid_conc_impu_iva"),this.getSesion()));
		  renfFFCompro.setConcImpuPercIVA(ConceptoImpuesto.findByOidProxy(dsRendFFComproProv.getInteger("oid_conc_impu_perc_iva"),this.getSesion()));
		  renfFFCompro.setConcImpuPercIB(ConceptoImpuesto.findByOidProxy(dsRendFFComproProv.getInteger("oid_conc_impu_perc_ib"),this.getSesion()));
		  
		  
		  
		  renfFFCompro.setComprobante_proveedor(getComproProv(
		  		dsRendFFComproProv,
		  		dsCotizaciones,
		  		moneda,
		  		cotizacion
		  		));
		  
		  IDataSet dsImputacionesFactProv = dsRendFFComproProv.getDataSet("TRendicionComproProvImpu");
		  dsImputacionesFactProv.first();
		  while (!dsImputacionesFactProv.EOF()) {
			  RendicionFondoFijoComproImpu rendFFComproImpu = 
				  RendicionFondoFijoComproImpu.findByOid(dsImputacionesFactProv.getInteger("oid_cco_compro_impu"),getSesion());
			  rendFFComproImpu.setCuenta_imputable(CuentaImputable.findByOidProxy(dsImputacionesFactProv.getInteger("oid_ai"),getSesion()));
			  rendFFComproImpu.setImporte(dsImputacionesFactProv.getDouble("importe"));
			  rendFFComproImpu.setComentario(dsImputacionesFactProv.getString("comentario"));
			  renfFFCompro.addImputacionRendFF(rendFFComproImpu);
			  dsImputacionesFactProv.next();
		  }
		  
		  
		  Iterator iterDetTotImpu = 
			  renfFFCompro.getComprobante_proveedor().getDetallesTotImpuestos().iterator();
		  while (iterDetTotImpu.hasNext()) {
			  ComproProvTotImpu comproProvTotImpu = (ComproProvTotImpu) iterDetTotImpu.next();
			  
			  RendicionFFImpuestos rendicionFFImpuestos = (RendicionFFImpuestos) RendicionFFImpuestos.getNew(RendicionFFImpuestos.NICKNAME, this.getSesion()); 
			  rendicionFFImpuestos.setRend_ff_det(renfFFCompro);
			  rendicionFFImpuestos.setConcepto_impuesto(comproProvTotImpu.getConceptoImpuesto());
			  rendicionFFImpuestos.setImporte(comproProvTotImpu.getImporteMonedaOri());
			  rendicionFFImpuestos.setComportamiento(comproProvTotImpu.getConceptoImpuesto().getImpuesto().getCompo());
			  renfFFCompro.addImpuestoRendFF(rendicionFFImpuestos);
			  
		  }
		  		  
		  dsRendFFComproProv.next();
	  }
	  
	  
  }
  
  
  private  ComproProveedorBase getComproProv(IDataSet dsComproProvfFF , 
  		                                     IDataSet dsCotizaciones,
  		                                     Moneda moneda,
  		                                     ValorCotizacion valorCotizacion) throws BaseException {
	  
      ComproProveedorBase comproProveedor = ComproProveedor.findByOid(dsComproProvfFF.getInteger("oid_cco_prov"),getSesion());
      comproProveedor.cargarCotizaciones(dsCotizaciones);
      comproProveedor.setContabiliza(false);
      comproProveedor.setTipoCompro(TipoComprobante.findByOidProxy(dsComproProvfFF.getInteger("oid_tc"),getSesion()));
      comproProveedor.setLetra(dsComproProvfFF.getString("letra"));
      comproProveedor.setLugarEmision(null);
      comproProveedor.setNrolugemision(dsComproProvfFF.getInteger("lug_emi"));
      comproProveedor.setNroext(dsComproProvfFF.getInteger("nro_ext"));
      comproProveedor.setEmision(dsComproProvfFF.getDate("fec_emision"));
      comproProveedor.setFecImputacion(dsComproProvfFF.getDate("fec_emision"));
      comproProveedor.setComentario("");
      comproProveedor.setNoContaOtrasMonedas(new Boolean(false));
      comproProveedor.setMoneda(moneda);
      comproProveedor.setCotizacion(valorCotizacion);
      comproProveedor.setTipoCambio(ComproConta.getTipoCambioContable(getSesion()));
      comproProveedor.setProveedor(Proveedor.findByOid(dsComproProvfFF.getInteger("oid_prov"),getSesion()));
      comproProveedor.setTotMonedaOri(dsComproProvfFF.getMoney("total"));
      comproProveedor.setNetoGravadoMonOri(dsComproProvfFF.getMoney("neto_gravado"));
      comproProveedor.setNetoGravadoMonLoc(comproProveedor.getImporteEnMonLoc(dsComproProvfFF.getMoney("neto_gravado"),moneda));
      comproProveedor.setNetoNoGravadoMonOri(dsComproProvfFF.getMoney("neto_no_gravado"));
      comproProveedor.setNetoNoGravadoMonLoc(comproProveedor.getImporteEnMonLoc(dsComproProvfFF.getMoney("neto_no_gravado"),moneda));
      comproProveedor.setFecbase(Fecha.getFechaActual());
      comproProveedor.setCondPagoCC(RendicionFondoFijo.getCondPagoDefaultFF(getSesion()));
      comproProveedor.setDescCondPagoCC(new Money(0));
      comproProveedor.setTipoCtaCteProv(RendicionFondoFijo.getTipoCtaCteProv(getSesion()));
      comproProveedor.setMaxMontoAutOri(new Money(0));
      comproProveedor.setAutorizada(new Boolean(true));
      comproProveedor.setActivo(new Boolean(true));
      comproProveedor.setPagoContado(true);
      comproProveedor.setTotMonedaLoc(comproProveedor.getImporteEnMonLoc(dsComproProvfFF.getMoney("total"),moneda));
      
      // Agregar un detalle concepto
      ConcFactProv concFactProv = ConcFactProv.findByOid(dsComproProvfFF.getInteger("oid_conc_fact_prov") ,getSesion());
      ComproProveedorDet comproProvDet = comproProveedor.addDetalle();
      comproProvDet.setComprobante(comproProveedor);
      comproProvDet.setSecu(new Integer(1));
      comproProvDet.setConcFactProv(concFactProv);
      CalculadorMoney totalNeto = null;
      if (comproProveedor.getNetoGravadoMonOri()!=null)
      	totalNeto = new CalculadorMoney(comproProveedor.getNetoGravadoMonOri());
      else
      	totalNeto = new CalculadorMoney(new Money(0));
      if (comproProveedor.getNetoNoGravadoMonOri()!=null)
    	  totalNeto.sumar(comproProveedor.getNetoNoGravadoMonOri());      
      comproProvDet.setImpoMonedaOri(totalNeto.getResultMoney());
      comproProvDet.setImpoMonedaLoc(Cotizacion.getImporteMonedaLocal(valorCotizacion,comproProvDet.getImpoMonedaOri()));
      
      // Guardar Impuestos
     
      if (dsComproProvfFF.getMoney("iva").doubleValue()>0) {
    	  ConceptoImpuesto conceptoImpuestoIVA = ConceptoImpuesto.findByOidProxy(dsComproProvfFF.getInteger("oid_conc_impu_iva"),this.getSesion());
    	  if (conceptoImpuestoIVA == null)
    		  throw new ExceptionValidation(null,"Debe ingresar el concepto del impuesto IVA");
          ComproProvTotImpu comproProvTotImpu = comproProveedor.addComproProvTotImpu();
          comproProvTotImpu.setComprobante(comproProveedor);
          comproProvTotImpu.setConceptoImpuesto(conceptoImpuestoIVA);
          comproProvTotImpu.setImporteMonedaOri(dsComproProvfFF.getMoney("iva"));
          comproProvTotImpu.setImporteMonedaLocal(comproProveedor.getImporteEnMonLoc(dsComproProvfFF.getMoney("iva"),comproProveedor.getMoneda()));
      }
      
      if (dsComproProvfFF.getMoney("perc_iva").doubleValue()>0) {
    	  ConceptoImpuesto conceptoImpuestoPercIVA = ConceptoImpuesto.findByOidProxy(dsComproProvfFF.getInteger("oid_conc_impu_perc_iva"),this.getSesion());
    	  if (conceptoImpuestoPercIVA == null)
    		  throw new ExceptionValidation(null,"Debe ingresar el concepto del impuesto Percepción IVA");
          ComproProvTotImpu comproProvTotImpu = comproProveedor.addComproProvTotImpu();
          comproProvTotImpu.setComprobante(comproProveedor);
          comproProvTotImpu.setConceptoImpuesto(conceptoImpuestoPercIVA);
          comproProvTotImpu.setImporteMonedaOri(dsComproProvfFF.getMoney("perc_iva"));
          comproProvTotImpu.setImporteMonedaLocal(comproProveedor.getImporteEnMonLoc(dsComproProvfFF.getMoney("perc_iva"),comproProveedor.getMoneda()));
      }
      
      if (dsComproProvfFF.getMoney("perc_ib").doubleValue()>0) {
    	  ConceptoImpuesto conceptoImpuestoPercIVA = ConceptoImpuesto.findByOidProxy(dsComproProvfFF.getInteger("oid_conc_impu_perc_ib"),this.getSesion());
    	  if (conceptoImpuestoPercIVA == null)
    		  throw new ExceptionValidation(null,"Debe ingresar el concepto del impuesto Percepción I.B.");
          ComproProvTotImpu comproProvTotImpu = comproProveedor.addComproProvTotImpu();
          comproProvTotImpu.setComprobante(comproProveedor);
          comproProvTotImpu.setConceptoImpuesto(conceptoImpuestoPercIVA);
          comproProvTotImpu.setImporteMonedaOri(dsComproProvfFF.getMoney("perc_ib"));
          comproProvTotImpu.setImporteMonedaLocal(comproProveedor.getImporteEnMonLoc(dsComproProvfFF.getMoney("perc_ib"),comproProveedor.getMoneda()));
      }
      
      // Cargar las imputaciones del concepto
      IDataSet dataSetCtasImputablesConc = dsComproProvfFF.getDataSet("TRendicionComproProvImpu");
      dataSetCtasImputablesConc.first();
      while (!dataSetCtasImputablesConc.EOF()) {
        ComproProvDetCtaImpu comproProvDetCtaImpu =
          comproProvDet.addCuentaImputable();
        comproProvDetCtaImpu.setCuentaimputable(
             CuentaImputable.findByOidProxy(
                  dataSetCtasImputablesConc.getInteger("oid_ai"),
                  getSesion()));
        comproProvDetCtaImpu.setImporte(dataSetCtasImputablesConc.getDouble("importe"));
        comproProvDetCtaImpu.setActivo(new Boolean(true));
        dataSetCtasImputablesConc.next();
      }
                
      comproProveedor.save();
	  
	  return comproProveedor;
  }
    
	protected void afterSave() throws BaseException {

		if (rendicionFondoFijo!=null) {
			InformarComprobante infoCompro = 
				new InformarComprobante(rendicionFondoFijo.getOIDInteger(), 
						rendicionFondoFijo.getDescripcion());
			writeCliente(infoCompro.getDataSetInfoCompro());
		}

	}
  
  
  
  

}
