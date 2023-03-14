package com.srn.erp.ctasACobrar.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.bm.ConsultaCtaCteClie;
import com.srn.erp.ctasACobrar.bm.TranClie;
import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerVistaCtaCteClie extends Operation {
	
  List primerasCuotas = new ArrayList();
  
  public TraerVistaCtaCteClie() {
  }
  
  private String getClaveCuota(ComproCab compro, 
		                       TranClie tranClie) throws BaseException {
	  return compro.getOIDInteger().toString()+"_"+tranClie.getOIDInteger();
  }
  
  private boolean existeClave(String clave) throws BaseException {
	  return primerasCuotas.contains(clave);
  }
  
  public void agregarClave(String clave) throws BaseException {
	  primerasCuotas.add(clave);
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    TipoCtaCteClie tipoCuenta     = null;
    Sujeto         sujeto         = null;
    java.util.Date fecha          = null;
    boolean incluirDeudaFinan     = false;

    if (mapaDatos.containsKey("oid_tipo_cta_clie")) {
      Integer oidTipoCtaClie = mapaDatos.getInteger("oid_tipo_cta_clie");
      tipoCuenta     = TipoCtaCteClie.findByOidProxy(oidTipoCtaClie,getSesion());
    }

    if (mapaDatos.containsKey("oid_cliente"))
    	sujeto = (Sujeto) Sujeto.findByOid(mapaDatos.getInteger("oid_cliente"),getSesion());
    
    if (mapaDatos.containsKey("incluir_deuda_finan"))
    	incluirDeudaFinan = mapaDatos.getBoolean("incluir_deuda_finan");
    

    if (!mapaDatos.containsKey("fecha")) {
      fecha = Fecha.getFechaActual();
    }
    else {
      fecha = mapaDatos.getDate("fecha");
      if (fecha == null)
        throw new ExceptionValidation(null,"Debe ingresar una Fecha");
    }
    
    java.util.Date fechaEmisionHasta = null;
    java.util.Date fecVto = Valor.getFechaDeudaFinan(this.getSesion());
    
    if (fecha!=null)
    	if (!fecha.equals(Fecha.getFechaActual())) {
    		fechaEmisionHasta = fecha;
    		fecVto = fecha;
    	}
    
    		
   // 	throw new ExceptionValidation(null,"Solamente se debe permitir el ingreso de la fecha actual");
    	

    IDataSet datasetCtaCteClie = getDataSetCtaCteClie();
    List listVtosCtaCte = ConsultaCtaCteClie.getVtosCtaCteBySujeto(sujeto,
                                                                   fecha,
                                                                   tipoCuenta,
                                                                   null,
                                                                   getSesion());
    
    // Devolver al Deuda Financiera
    if (incluirDeudaFinan) {
    	
    	Iterator iterValDeudaFinan = 
    		Valor.getValoresDeudaFinanClie(fecVto, sujeto, null, null, fechaEmisionHasta,this.getSesion()).iterator();
    	while (iterValDeudaFinan.hasNext()) {
    		Valor valor = (Valor) iterValDeudaFinan.next();
    		
    		String rsSujeto = "";
    		if (valor.getSujeto()!=null)
    			rsSujeto = valor.getSujeto().getRazon_social();
    		
    	      cargarRegistroDataSetCtaCteClie(datasetCtaCteClie,
    	    		  1,
    	    		  1,
    	    		  "",
    	    		  "",
    	    		  new Integer(0),
    	    		  new Integer(0),
    	    		  valor.getFechaemision(),
    	    		  valor.getFechavto(),
    	    		  null,
    	    		  null,
    	    		  valor.getFechavto(),
    	    		  valor.getImporte(),
    	    		  valor.getImporte(),
    	    		  null,
    	    		  valor.getTipovalor().getDescripcion(),
    	    		  valor.getSujeto(),
    	    		  rsSujeto,
    	    		  valor.getImporte(),
    	    		  valor.getImporte(),
    	    		  valor.getTipovalor().getMoneda(),
    	    		  valor.getTipovalor().getMoneda().getDescripcion(),
    	    		  null,
    	    		  valor.getDescripcion(),
    	    		  valor.getCotizacion(),
    	    		  null,
    	    		  null,
    	    		  null,
    	    		  null,
    	    		  null,
    	    		  new Integer(1)
    	    		  );
    		
    		
    	}
    	
    }
    
    
    // Devolver la Cuenta Corrienye
    Iterator iterVtosCtaCte = listVtosCtaCte.iterator();
    while (iterVtosCtaCte.hasNext()) {

      // Hacer un corte de control por Comprobante y Fecha de Vencimiento
      ConsultaCtaCteClie consultaCtaCteClie = (ConsultaCtaCteClie)iterVtosCtaCte.next();

      String clave = getClaveCuota(consultaCtaCteClie.getComprobante(),consultaCtaCteClie.getTranClie());
      
      String comprobante = consultaCtaCteClie.getComprobante().getCodigo();
      java.util.Date fechaEmisionCompro = consultaCtaCteClie.getComprobante().getEmision();
      java.util.Date fechaImputacCompro = consultaCtaCteClie.getComprobante().getImputac();
      Money importe = consultaCtaCteClie.getTotMonOri();
      Money saldo = consultaCtaCteClie.getSaldoMonOri();
      int primeraCuota = 0;
      
      if (this.existeClave(clave)) {
          //comprobante = "";
          //fechaEmisionCompro = null;
          //fechaImputacCompro = null;
          importe = null;
          saldo = null;
          primeraCuota = 1;
      } else agregarClave(clave);
      
      
      cargarRegistroDataSetCtaCteClie(datasetCtaCteClie,
    		  consultaCtaCteClie.getOrden(),
    		  consultaCtaCteClie.getOIDInteger(),
    		  consultaCtaCteClie.getTc_ext(),
    		  consultaCtaCteClie.getLetra(),
    		  consultaCtaCteClie.getLugEmi(),
    		  consultaCtaCteClie.getNroExt(),
    		  fechaEmisionCompro,
    		  fechaImputacCompro,
    		  consultaCtaCteClie.getTranClie(),
    		  consultaCtaCteClie.getTranClieVto(),
    		  consultaCtaCteClie.getVto(),
    		  consultaCtaCteClie.getImpoCuota(),
    		  consultaCtaCteClie.getSaldoCuota(),
    		  consultaCtaCteClie.getTipoCtaCteClie(),
    		  consultaCtaCteClie.getDescTipoCtaCteClie(),
    		  consultaCtaCteClie.getSujeto(),
    		  consultaCtaCteClie.getRsSujeto(),
    		  importe,
    		  saldo,
    		  consultaCtaCteClie.getMoneda(),
    		  consultaCtaCteClie.getDescMoneda(),
    		  consultaCtaCteClie.getComprobante(),
    		  comprobante,
    		  consultaCtaCteClie.getCotizMonOri(),
    		  consultaCtaCteClie.getCotizMonExt1(),
    		  consultaCtaCteClie.getCotizMonExt2(),
    		  consultaCtaCteClie.getCotizMonOriCon(),
    		  consultaCtaCteClie.getCotizMonExt1Con(),
    		  consultaCtaCteClie.getCotizMonExt2Con(),
    		  primeraCuota
    		  );
    }

    IDataSet dsTipoCons = getDataSetTipoConsulta();
    cargarRegistroTipoConsulta(dsTipoCons,fecha);

    writeCliente(datasetCtaCteClie);
    writeCliente(dsTipoCons);
  }

  private IDataSet getDataSetCtaCteClie() {
    IDataSet dataset = new TDataSet();
    dataset.create("TVistaCtaCteClie");
    dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid",Field.INTEGER, 0));
    dataset.fieldDef(new Field("tc_ext",Field.STRING, 10));
    dataset.fieldDef(new Field("letra",Field.STRING, 1));
    dataset.fieldDef(new Field("lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision",Field.DATE,0));
    dataset.fieldDef(new Field("fec_imputacion",Field.DATE,0));
    dataset.fieldDef(new Field("oid_tran_clie",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tran_vto",Field.INTEGER, 0));
    dataset.fieldDef(new Field("vto",Field.STRING,10));
    dataset.fieldDef(new Field("impo_cuota",Field.CURRENCY,0));
    dataset.fieldDef(new Field("saldo_cuota",Field.CURRENCY,0));
    dataset.fieldDef(new Field("oid_tipo_cta_clie",Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_cta_clie",Field.STRING,50));
    dataset.fieldDef(new Field("oid_cliente",Field.INTEGER, 0));
    dataset.fieldDef(new Field("rs_cliente",Field.STRING,50));
    dataset.fieldDef(new Field("tot_mon_ori",Field.CURRENCY,0));
    dataset.fieldDef(new Field("saldo_mon_ori",Field.CURRENCY,0));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER,0));
    dataset.fieldDef(new Field("moneda",Field.STRING,30));
    dataset.fieldDef(new Field("oid_cco",Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante",Field.STRING,50));
    dataset.fieldDef(new Field("cotiz_mon_ori",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext1",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext2",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ori_co",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext1_co",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext2_co",Field.CURRENCY,0));
    dataset.fieldDef(new Field("primer_cuota",Field.INTEGER,0));
    return dataset;
  }

  private IDataSet getDataSetTipoConsulta() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoConsCtaCteClie");
    dataset.fieldDef(new Field("trae_aplicaciones",Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipoConsulta(IDataSet dataSet, java.util.Date fecha) throws BaseException {
    dataSet.append();
    if (fecha.equals(Fecha.getFechaActual()))
      dataSet.fieldValue("trae_aplicaciones",new Boolean(false));
    else
      dataSet.fieldValue("trae_aplicaciones",new Boolean(true));
  }


  private void cargarRegistroDataSetCtaCteClie(IDataSet dataset,
                                               Integer orden,
                                               Integer oid,
                                               String tcExt,
                                               String letra,
                                               Integer lugEmi,
                                               Integer nroExt,
                                               java.util.Date fecEmision,
                                               java.util.Date fecImputacion,
                                               TranClie tranClie,
                                               TranClieVto tranClieVto,
                                               java.util.Date vtoCuota,
                                               Money impoCuota,
                                               Money saldoCuota,
                                               TipoCtaCteClie tipoCtaCteClie,
                                               String descTipoCtaCteClie,
                                               Sujeto sujeto,
                                               String rsSujeto,
                                               Money totMonedaOri,
                                               Money saldoMonedaOri,
                                               Moneda moneda,
                                               String descMoneda,
                                               ComproCab comproCab,
                                               String comprobante,
                                               ValorCotizacion cotizMonLocal,
                                               ValorCotizacion cotizMonExt1,
                                               ValorCotizacion cotizMonExt2,
                                               ValorCotizacion cotizMonLocalCon,
                                               ValorCotizacion cotizMonExt1Con,
                                               ValorCotizacion cotizMonExt2Con,
                                               Integer nroCuota
                                               )
                                             throws BaseException {

    dataset.append();
    dataset.fieldValue("orden",orden);
    dataset.fieldValue("oid",oid);
    dataset.fieldValue("tc_ext",tcExt);
    dataset.fieldValue("letra",letra);
    dataset.fieldValue("lug_emi",lugEmi);
    dataset.fieldValue("nro_ext",nroExt);
    if (fecEmision == null)
        dataset.fieldValue("fec_emision","");
    else
        dataset.fieldValue("fec_emision",Fecha.getddmmyyyy(fecEmision));
    if (fecImputacion == null)
        dataset.fieldValue("fec_imputacion","");
    else
        dataset.fieldValue("fec_imputacion",Fecha.getddmmyyyy(fecImputacion));
    if (tranClie!=null)
    	dataset.fieldValue("oid_tran_clie",tranClie.getOID());
    else
    	dataset.fieldValue("oid_tran_clie","");
    if (tranClieVto!=null)
    	dataset.fieldValue("oid_tran_vto",tranClieVto.getOID());
    else
    	dataset.fieldValue("oid_tran_vto","");
    dataset.fieldValue("vto",Fecha.getddmmyyyy(vtoCuota));
    dataset.fieldValue("impo_cuota",impoCuota.doubleValue());
    dataset.fieldValue("saldo_cuota",saldoCuota.doubleValue());
    if (tipoCtaCteClie!=null)
    	dataset.fieldValue("oid_tipo_cta_clie",tipoCtaCteClie.getOID());
    else
    	dataset.fieldValue("oid_tipo_cta_clie","");
    dataset.fieldValue("tipo_cta_clie",descTipoCtaCteClie);
    if (sujeto!=null)
    	dataset.fieldValue("oid_cliente",sujeto.getOID());
    else
    	dataset.fieldValue("oid_cliente","");
    dataset.fieldValue("rs_cliente",rsSujeto);
    
    if (totMonedaOri!=null)
    	dataset.fieldValue("tot_mon_ori",totMonedaOri.doubleValue());
    else {
    	Money sinImporte = null; 
    	dataset.fieldValue("tot_mon_ori",sinImporte);
    }
    
    if (saldoMonedaOri!=null)
    	dataset.fieldValue("saldo_mon_ori",saldoMonedaOri.doubleValue());
    else {
    	Money sinImporte = null; 
    	dataset.fieldValue("saldo_mon_ori",sinImporte);
    }
    
    dataset.fieldValue("oid_moneda",moneda.getOIDInteger());
    dataset.fieldValue("moneda",descMoneda);
    if (comproCab!=null)
    	dataset.fieldValue("oid_cco",comproCab.getOIDInteger());
    else
    	dataset.fieldValue("oid_cco","");
    dataset.fieldValue("comprobante",comprobante);
    if (cotizMonLocal!=null)
    	dataset.fieldValue("cotiz_mon_ori",cotizMonLocal.doubleValue());
    else
    	dataset.fieldValue("cotiz_mon_ori","");
    if (cotizMonExt1!=null)
    	dataset.fieldValue("cotiz_mon_ext1",cotizMonExt1.doubleValue());
    else
    	dataset.fieldValue("cotiz_mon_ext1","");
    if (cotizMonExt2!=null)
    	dataset.fieldValue("cotiz_mon_ext2",cotizMonExt2.doubleValue());
    else
    	dataset.fieldValue("cotiz_mon_ext2","");
    if (cotizMonLocalCon!=null)
    	dataset.fieldValue("cotiz_mon_ori_co",cotizMonLocalCon.doubleValue());
    else
    	dataset.fieldValue("cotiz_mon_ori_co","");
    if (cotizMonExt1Con!=null)
    	dataset.fieldValue("cotiz_mon_ext1_co",cotizMonExt1Con.doubleValue());
    else
    	dataset.fieldValue("cotiz_mon_ext1_co","");
    if (cotizMonExt2Con!=null)
    	dataset.fieldValue("cotiz_mon_ext2_co",cotizMonExt2Con.doubleValue());
    else
    	dataset.fieldValue("cotiz_mon_ext2_co","");
    dataset.fieldValue("primer_cuota", nroCuota);

  }




}
