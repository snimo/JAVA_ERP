package com.srn.erp.ctasAPagar.op;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ComproProvDetCtaImpu;
import com.srn.erp.ctasAPagar.bm.ComproProvInfRecOC;
import com.srn.erp.ctasAPagar.bm.ComproProvTotImpu;
import com.srn.erp.ctasAPagar.bm.ComproProvVtoFijo;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.ctasAPagar.bm.ComproProveedorDet;
import com.srn.erp.ctasAPagar.bm.ComproProveedorImpu;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveComproProv extends Operation {

  ComproProveedorBase comproProveedor = null;

  public SaveComproProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	CalculadorMoney calcTotMonLoc = new CalculadorMoney(new Money(0));
	HashTableDatos listaCotiz = null;
	if (mapaDatos.containsKey("TCotizaciones"))
		listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));  
    IDataSet dataseComproProv = mapaDatos.getDataSet("TComproProv");
    dataseComproProv.first();
    while (!dataseComproProv.EOF()) {

      Integer oidTC                = dataseComproProv.getInteger("oid_tc");
      java.util.Date fecEmision    = dataseComproProv.getDate("fec_emision");
      java.util.Date fecImputacion = dataseComproProv.getDate("fec_imputac");
      Integer oidMoneda            = dataseComproProv.getInteger("oid_moneda");
      if (oidMoneda == null)
    	  throw new ExceptionValidation(null,"Debe ingresar la moneda");
      String comentario            = dataseComproProv.getString("comentario");
      Boolean convertir            = new Boolean(true);
      ValorCotizacion cotizacion   = dataseComproProv.getCotizacion("cotizacion");
      Integer oid                  = dataseComproProv.getInteger("oid_cco");
      Integer oidProveedor         = dataseComproProv.getInteger("oid_proveedor");
      Money totMonedaOri           = dataseComproProv.getMoney("importe");

      java.util.Date fecBase       = dataseComproProv.getDate("fec_base");
      Integer oidCondPago          = dataseComproProv.getInteger("oid_cond_pago_prov");
      String letra                 = dataseComproProv.getString("letra");
      Integer nroLugEmi            = dataseComproProv.getInteger("lug_emi");
      
      if (nroLugEmi == null)
      	throw new ExceptionValidation(null,"Debe ingresar el Lugar de Emisión del comprobante");
      	
      Integer oidLugarEmi          = dataseComproProv.getInteger("oid_lug_emi");
      LugarEmision lugarEmision    = LugarEmision.findByOid(oidLugarEmi,getSesion());
      Integer nroExt               = dataseComproProv.getInteger("nro_ext");
      Integer oidTipoCtaCteProv    = dataseComproProv.getInteger("oid_tipo_cta_prov");
      String tipoFactura           = dataseComproProv.getString("tipo_factura");
      
      if (tipoFactura == null)
      	throw new ExceptionValidation(null,"Debe ingresar el Tipo de Factura");
      
      Money netoGravado            = this.getTotNetoGravado(mapaDatos.getDataSet("TTotalesComproProv"));
      Money netoNoGravado          = this.getTotNetoNoGravado(mapaDatos.getDataSet("TTotalesComproProv"));
      
      SectorCompra sectorCompra    = SectorCompra.findByOid(dataseComproProv.getInteger("oid_sector_compra"),getSesion());
      ValorCotizacion valorCotiz   = dataseComproProv.getCotizacion("cotizacion");
 
      if (oidMoneda.intValue() == Moneda.getMonedaCursoLegal(getSesion()).getOID())
    	  cotizacion = new ValorCotizacion(new Double(1));      
      
      TipoComprobante tc = TipoComprobante.findByOidProxy(oidTC,getSesion());
      
      if (tc == null)
      	throw new ExceptionValidation(null,"Debe ingresar el Tipo de Comprobante");
      
      comproProveedor = ComproProveedorBase.findByComproProv(tc.getIdentificacion(),
      		oid,
      		getSesion());
      
      if (dataseComproProv.getBoolean("activo").booleanValue()==false) {
      	comproProveedor.supportRefresh();
      	comproProveedor.delete();
        addTransaccion(comproProveedor);
        dataseComproProv.next();
        continue;
      }
      
      comproProveedor.setTipoFactura(tipoFactura);
      comproProveedor.addCotizacionesMonedas(listaCotiz);
      comproProveedor.setContabiliza(true);
      comproProveedor.setTipoCompro(TipoComprobante.findByOidProxy(oidTC,getSesion()));
      comproProveedor.setLetra(letra);
      comproProveedor.setNrolugemision(nroLugEmi);
      comproProveedor.setLugarEmision(lugarEmision);
      comproProveedor.setNroext(nroExt);
      comproProveedor.setEmision(fecEmision);
      comproProveedor.setFecImputacion(fecImputacion);
      comproProveedor.setImputac(fecImputacion);
      
      
      comproProveedor.setComentario(comentario);
      comproProveedor.setNoContaOtrasMonedas(new Boolean(false));
      comproProveedor.setMoneda(Moneda.findByOidProxy(oidMoneda,getSesion()));
      comproProveedor.setCotizacion(cotizacion);
      comproProveedor.setTipoCambio(ComproConta.getTipoCambioContable(getSesion()));
      comproProveedor.setProveedor(Proveedor.findByOid(oidProveedor,getSesion()));
      comproProveedor.setSectorCompra(sectorCompra);
      comproProveedor.setCotizacion(valorCotiz);
      
      if ((totMonedaOri==null))
    	throw new ExceptionValidation(null,"Debe ingresar el total del Comprobante");
      
      comproProveedor.setTotMonedaOri(totMonedaOri);
      comproProveedor.setNetoGravadoMonOri(netoGravado);
      comproProveedor.setNetoGravadoMonLoc(Cotizacion.getImporteMonedaLocal(cotizacion,netoGravado));
      comproProveedor.setNetoNoGravadoMonOri(netoNoGravado);
      comproProveedor.setNetoNoGravadoMonLoc(Cotizacion.getImporteMonedaLocal(cotizacion,netoNoGravado));
            
      calcTotMonLoc.sumar(comproProveedor.getNetoGravadoMonLoc());
      calcTotMonLoc.sumar(comproProveedor.getNetoNoGravadoMonLoc());
      
      comproProveedor.setFecbase(fecBase);
      comproProveedor.setCondPagoCC(CondicionCompra.findByOid(oidCondPago,getSesion()));
      comproProveedor.setDescCondPagoCC(dataseComproProv.getMoney("descuento"));
      comproProveedor.setTipoCtaCteProv(TipoCtaCteProv.findByOid(oidTipoCtaCteProv,getSesion()));
      comproProveedor.setMaxMontoAutOri(new Money(0));
      comproProveedor.setAutorizada(new Boolean(false));
      comproProveedor.setActivo(dataseComproProv.getBoolean("activo"));
      comproProveedor.setValorCotizExt1(comproProveedor.getCotizMonExt1());
      comproProveedor.setValorCotizExt2(comproProveedor.getCotizMonExt2());
      
      if (!comproProveedor.isActivo()) {
    	  comproProveedor.delete();
    	  this.addTransaccion(comproProveedor);
    	  return;
      }

      // Cargar los Vtos Fijos
      IDataSet datasetDetVtoFijos = dataseComproProv.getDataSet("TVtosFijos");
      datasetDetVtoFijos.first();
      while (!datasetDetVtoFijos.EOF()) {
        ComproProvVtoFijo vtoFijo = comproProveedor.addComproProvVtoFijo();
        vtoFijo.setComprobante(comproProveedor);
        vtoFijo.setFecha(datasetDetVtoFijos.getDate("fecha"));
        vtoFijo.setPorcentaje(datasetDetVtoFijos.getDouble("porc"));
        vtoFijo.setActivo(datasetDetVtoFijos.getBoolean("activo"));
        datasetDetVtoFijos.next();
      }

      // Cargar los conceptos del Comprobante
      IDataSet datasetDetComproProv = dataseComproProv.getDataSet("TConceptosCompro");
      int secu = 0;
      datasetDetComproProv.first();
      while (!datasetDetComproProv.EOF()) {
        ComproProveedorDet comproProvDet = comproProveedor.addDetalle();
        comproProvDet.setComprobante(comproProveedor);
        comproProvDet.setSecu(new Integer(++secu));
        comproProvDet.setConcFactProv(ConcFactProv.findByOidProxy(
              datasetDetComproProv.getInteger("oid_conc_fact_prov"),
              getSesion()));

        if (datasetDetComproProv.getMoney("importe")==null) {
          datasetDetComproProv.next();
          continue;
        }

        comproProvDet.setImpoMonedaOri(datasetDetComproProv.getMoney("importe"));
        CalculadorMoney calcImpoMonLocal = new CalculadorMoney(datasetDetComproProv.getMoney("importe"));
        calcImpoMonLocal.multiplicarPor(cotizacion);
        comproProvDet.setImpoMonedaLoc(calcImpoMonLocal.getResultMoney());


        // Grabar los Impuestos correspondientes
        addConceptoImpuesto(comproProvDet,
                                datasetDetComproProv.getInteger("oid_conc_imp_iva"));
        addConceptoImpuesto(comproProvDet,
                                datasetDetComproProv.getInteger("oid_conc_imp_perc_iva"));
        addConceptoImpuesto(comproProvDet,
                                datasetDetComproProv.getInteger("oid_conc_imp_perc_ib"));
        addConceptoImpuesto(comproProvDet,
                                datasetDetComproProv.getInteger("oid_conc_imp_internos"));
        addConceptoImpuesto(comproProvDet,
                                datasetDetComproProv.getInteger("oid_conc_imp_ret_iva"));
        addConceptoImpuesto(comproProvDet,
                                datasetDetComproProv.getInteger("oid_conc_imp_ret_gan"));
        addConceptoImpuesto(comproProvDet,
                                datasetDetComproProv.getInteger("oid_conc_imp_ret_ib"));

        // Recorrer las cuentas imputables de cada concepto
        IDataSet dataSetCtasImputablesConc = datasetDetComproProv.getDataSet("TImputacionesConcCompro");
        dataSetCtasImputablesConc.first();
        while (!dataSetCtasImputablesConc.EOF()) {
          ComproProvDetCtaImpu comproProvDetCtaImpu =
            comproProvDet.addCuentaImputable();
          comproProvDetCtaImpu.setCuentaimputable(
               CuentaImputable.findByOidProxy(
                    dataSetCtasImputablesConc.getInteger("oid_ai"),
                    getSesion()));
          comproProvDetCtaImpu.setComproprovdet(comproProvDet);
          comproProvDetCtaImpu.setImporte(dataSetCtasImputablesConc.getDouble("importe"));
          comproProvDetCtaImpu.setComentario(dataSetCtasImputablesConc.getString("comentario"));
          comproProvDetCtaImpu.setActivo(new Boolean(true));
          dataSetCtasImputablesConc.next();
        }

        datasetDetComproProv.next();  
      }
      
      // Grabar los articulos facturados
      IDataSet dataSetInfRecOC = dataseComproProv.getDataSet("TComproProvOC");
      dataSetInfRecOC.first();
      while (!dataSetInfRecOC.EOF()) {
    	  ComproProvInfRecOC comproProvInfRecOC = comproProveedor.addComproProvInfRecOC();
    	  comproProvInfRecOC.setProducto(Producto.findByOidProxy(dataSetInfRecOC.getInteger("oid_producto"),getSesion()));
    	  comproProvInfRecOC.setOrdenDeCompraDet(OrdenDeCompraDet.findByOidProxy(dataSetInfRecOC.getInteger("oid_oc_det"),getSesion())); 
    	 //comproProvInfRecOC.setInforme_rec_det(InformeRecepcionDet.findByOidProxy(dataSetInfRecOC.getInteger("oid_inf_rec_det"),getSesion()));
    	  comproProvInfRecOC.setCant_facturada(dataSetInfRecOC.getDouble("cantidad"));
    	  comproProvInfRecOC.setPrecio_factura(dataSetInfRecOC.getDouble("precio"));
    	  comproProvInfRecOC.setPrecio_oc(dataSetInfRecOC.getDouble("precio_oc"));
    	  comproProvInfRecOC.setMoneda_oc(Moneda.findByOidProxy(dataSetInfRecOC.getInteger("oid_mon_oc"),getSesion()));
    	  comproProvInfRecOC.setImpo_det_factura(dataSetInfRecOC.getDouble("importe"));
    	  comproProvInfRecOC.setInforme_rec_det(InformeRecepcionDet.findByOidProxy(dataSetInfRecOC.getInteger("oid_inf_rec_det"),getSesion()));
    	  comproProvInfRecOC.setActivo(new Boolean(true));
    	  dataSetInfRecOC.next();
      }

      // Grabar totales por Impuesos
   /*   IDataSet dataSetTotImpu = dataseComproProv.getDataSet("TImpuestosComproProv");
      dataSetTotImpu.first();
      while (!dataSetTotImpu.EOF()) {
        ComproProvTotImpu comproProvTotImpu =
            comproProveedor.addComproProvTotImpu();
        comproProvTotImpu.setComprobante(comproProveedor);
        comproProvTotImpu.setConceptoImpuesto(
               ConceptoImpuesto.findByOidProxy(dataSetTotImpu.getInteger("oid_conc_impu"),
                                         getSesion()));
        comproProvTotImpu.setImporteMonedaOri(dataSetTotImpu.getMoney("importe"));
        comproProvTotImpu.setImporteMonedaLocal(
                 Cotizacion.getImporteMonedaLocal(comproProveedor.getCotizacion(),
                                                  dataSetTotImpu.getMoney("importe")));
        calcTotMonLoc.sumar(comproProvTotImpu.getImporteMonedaLocal());
        dataSetTotImpu.next();
      }*/
      
      IDataSet dataSetTotImpu = mapaDatos.getDataSet("TTotalesComproProv");
      dataSetTotImpu.first();
      while (!dataSetTotImpu.EOF()) {
      	
      	if (dataSetTotImpu.getBoolean("es_neto_gravado").booleanValue()) {
      		dataSetTotImpu.next();
      		continue;
      	}
      	
      	if (dataSetTotImpu.getBoolean("es_neto_no_gravado").booleanValue()) {
      		dataSetTotImpu.next();
      		continue;
      	}
      	
        ComproProvTotImpu comproProvTotImpu =
            comproProveedor.addComproProvTotImpu();
        comproProvTotImpu.setComprobante(comproProveedor);
        comproProvTotImpu.setConceptoImpuesto(
               ConceptoImpuesto.findByOidProxy(dataSetTotImpu.getInteger("oid_conc_imp"),
                                         getSesion()));
        comproProvTotImpu.setImporteMonedaOri(dataSetTotImpu.getMoney("importe"));
        comproProvTotImpu.setImporteMonedaLocal(
                 Cotizacion.getImporteMonedaLocal(comproProveedor.getCotizacion(),
                                                  dataSetTotImpu.getMoney("importe")));
        calcTotMonLoc.sumar(comproProvTotImpu.getImporteMonedaLocal());
        dataSetTotImpu.next();
      }
      
      
      comproProveedor.setTotMonedaLoc(calcTotMonLoc.getResultMoney());


      addTransaccion(comproProveedor);
      dataseComproProv.next();
    }

  }

  private void addConceptoImpuesto(ComproProveedorDet comproProvDet,
                                       Integer oidConceptoImpuesto)
      throws BaseException {
      if ((oidConceptoImpuesto != null) && (oidConceptoImpuesto.intValue()!=0)) {
        ComproProveedorImpu comproProvImpu = comproProvDet.addComproProvImpu();
        comproProvImpu.setComproProveedorDet(comproProvDet);
        comproProvImpu.setConceptoImpuesto(ConceptoImpuesto.findByOidProxy(
            oidConceptoImpuesto,
            getSesion()));
        comproProvImpu.setActivo(new Boolean(true));


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
  
  private Money getTotNetoGravado(IDataSet dsTotConc) throws BaseException {
    CalculadorMoney calcTotNetoGrav = new CalculadorMoney(new Money(0));
  	dsTotConc.first();
  	while (!dsTotConc.EOF()) {
  		if (dsTotConc.getBoolean("es_neto_gravado").booleanValue()) 
  			calcTotNetoGrav.sumar(dsTotConc.getMoney("importe"));  		
  		dsTotConc.next();
  	}
  	return calcTotNetoGrav.getResultMoney();
  }
  
  private Money getTotNetoNoGravado(IDataSet dsTotConc) throws BaseException {
    CalculadorMoney calcTotNetoNoGrav = new CalculadorMoney(new Money(0));
  	dsTotConc.first();
  	while (!dsTotConc.EOF()) {
  		if (dsTotConc.getBoolean("es_neto_no_gravado").booleanValue()) 
  			calcTotNetoNoGrav.sumar(dsTotConc.getMoney("importe"));  		
  		dsTotConc.next();
  	}

  	return calcTotNetoNoGrav.getResultMoney();
  }


}
