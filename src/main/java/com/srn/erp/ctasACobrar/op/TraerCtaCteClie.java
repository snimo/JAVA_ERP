package com.srn.erp.ctasACobrar.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.bm.ConsultaCtaCteClie;
import com.srn.erp.ctasACobrar.bm.TranClie;
import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
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

public class TraerCtaCteClie extends Operation {

  public TraerCtaCteClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    TipoCtaCteClie tipoCuenta     = null;
    Sujeto         sujeto         = null;
    java.util.Date fecha          = null;

    if (mapaDatos.containsKey("oid_tipo_cta_clie")) {
      Integer oidTipoCtaClie = mapaDatos.getInteger("oid_tipo_cta_clie");
      tipoCuenta     = TipoCtaCteClie.findByOidProxy(oidTipoCtaClie,getSesion());
    }

    sujeto = (Sujeto) Sujeto.findByOid(mapaDatos.getInteger("oid_cliente"),getSesion());

    if (!mapaDatos.containsKey("fecha")) {
      fecha = Fecha.getFechaActual();
    }
    else {
      fecha = mapaDatos.getDate("fecha");
      if (fecha == null)
        throw new ExceptionValidation(null,"Debe ingresar una Fecha");
    }

    IDataSet datasetCtaCteClie = getDataSetCtaCteClie();
    List listVtosCtaCte = ConsultaCtaCteClie.getVtosCtaCteBySujeto(sujeto,
                                                                   fecha,
                                                                   tipoCuenta,
                                                                   null,
                                                                   getSesion());
    Iterator iterVtosCtaCte = listVtosCtaCte.iterator();
    while (iterVtosCtaCte.hasNext()) {

      // Hacer un corte de control por Comprobante y Fecha de Vencimiento
      ConsultaCtaCteClie consultaCtaCteClie = (ConsultaCtaCteClie)iterVtosCtaCte.next();

      cargarRegistroDataSetCtaCteClie(datasetCtaCteClie,
    		  consultaCtaCteClie.getOrden(),
    		  consultaCtaCteClie.getOIDInteger(),
    		  consultaCtaCteClie.getTc_ext(),
    		  consultaCtaCteClie.getLetra(),
    		  consultaCtaCteClie.getLugEmi(),
    		  consultaCtaCteClie.getNroExt(),
    		  consultaCtaCteClie.getFecEmision(),
    		  consultaCtaCteClie.getFecImputac(),
    		  consultaCtaCteClie.getTranClie(),
    		  consultaCtaCteClie.getTranClieVto(),
    		  consultaCtaCteClie.getVto(),
    		  consultaCtaCteClie.getImpoCuota(),
    		  consultaCtaCteClie.getSaldoCuota(),
    		  consultaCtaCteClie.getTipoCtaCteClie(),
    		  consultaCtaCteClie.getDescTipoCtaCteClie(),
    		  consultaCtaCteClie.getSujeto(),
    		  consultaCtaCteClie.getRsSujeto(),
    		  consultaCtaCteClie.getTotMonOri(),
    		  consultaCtaCteClie.getSaldoMonOri(),
    		  consultaCtaCteClie.getMoneda(),
    		  consultaCtaCteClie.getDescMoneda(),
    		  consultaCtaCteClie.getComprobante(),
    		  consultaCtaCteClie.getCodigo(),
    		  consultaCtaCteClie.getCotizMonOri(),
    		  consultaCtaCteClie.getCotizMonExt1(),
    		  consultaCtaCteClie.getCotizMonExt2(),
    		  consultaCtaCteClie.getCotizMonOriCon(),
    		  consultaCtaCteClie.getCotizMonExt1Con(),
    		  consultaCtaCteClie.getCotizMonExt2Con());
    }

    IDataSet dsTipoCons = getDataSetTipoConsulta();
    cargarRegistroTipoConsulta(dsTipoCons,fecha);

    writeCliente(datasetCtaCteClie);
    writeCliente(dsTipoCons);
  }

  private IDataSet getDataSetCtaCteClie() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConsCtaCteClie");
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
    dataset.fieldDef(new Field("desc_tipo_cta_cte_cli",Field.STRING,50));
    dataset.fieldDef(new Field("oid_sujeto",Field.INTEGER, 0));
    dataset.fieldDef(new Field("rs_sujeto",Field.STRING,50));
    dataset.fieldDef(new Field("tot_mon_ori",Field.CURRENCY,0));
    dataset.fieldDef(new Field("saldo_mon_ori",Field.CURRENCY,0));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER,0));
    dataset.fieldDef(new Field("moneda",Field.STRING,30));
    dataset.fieldDef(new Field("oid_cco",Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante",Field.STRING,30));
    dataset.fieldDef(new Field("cotiz_mon_ori",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext1",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext2",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ori_co",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext1_co",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext2_co",Field.CURRENCY,0));
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
                                               ValorCotizacion cotizMonExt2Con
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
    dataset.fieldValue("oid_tran_clie",tranClie.getOID());
    dataset.fieldValue("oid_tran_vto",tranClieVto.getOID());
    dataset.fieldValue("vto",Fecha.getddmmyyyy(vtoCuota));
    dataset.fieldValue("impo_cuota",impoCuota.doubleValue()*-1);
    dataset.fieldValue("saldo_cuota",saldoCuota.doubleValue()*-1);
    dataset.fieldValue("oid_tipo_cta_clie",tipoCtaCteClie.getOID());
    dataset.fieldValue("desc_tipo_cta_cte_cli",descTipoCtaCteClie);
    dataset.fieldValue("oid_sujeto",sujeto.getOID());
    dataset.fieldValue("rs_sujeto",rsSujeto);
    dataset.fieldValue("tot_mon_ori",totMonedaOri.doubleValue()*-1);
    dataset.fieldValue("saldo_mon_ori",saldoMonedaOri.doubleValue()*-1);
    dataset.fieldValue("oid_moneda",moneda.getOIDInteger());
    dataset.fieldValue("moneda",descMoneda);
    dataset.fieldValue("oid_cco",comproCab.getOIDInteger());
    dataset.fieldValue("comprobante",comprobante);
    dataset.fieldValue("cotiz_mon_ori",cotizMonLocal.doubleValue());
    dataset.fieldValue("cotiz_mon_ext1",cotizMonExt1.doubleValue());
    dataset.fieldValue("cotiz_mon_ext2",cotizMonExt2.doubleValue());
    dataset.fieldValue("cotiz_mon_ori_co",cotizMonLocalCon.doubleValue());
    dataset.fieldValue("cotiz_mon_ext1_co",cotizMonExt1Con.doubleValue());
    dataset.fieldValue("cotiz_mon_ext2_co",cotizMonExt2Con.doubleValue());

  }




}
