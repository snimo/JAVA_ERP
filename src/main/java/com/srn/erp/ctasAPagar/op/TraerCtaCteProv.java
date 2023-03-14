package com.srn.erp.ctasAPagar.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ConsultaCtaCteProv;
import com.srn.erp.ctasAPagar.bm.TranProv;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

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

public class TraerCtaCteProv extends Operation {

  public TraerCtaCteProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    TipoCtaCteProv tipoCuenta     = null;
    Proveedor      proveedor      = null;
    java.util.Date fecha          = null;

    if (mapaDatos.containsKey("oid_tipo_cta_prov")) {
      Integer oidTipoCtaProv = mapaDatos.getInteger("oid_tipo_cta_prov");
      tipoCuenta     = TipoCtaCteProv.findByOidProxy(oidTipoCtaProv,getSesion());
    }

    if (mapaDatos.containsKey("oid_proveedor")) 
      proveedor = (Proveedor) Proveedor.findByOid(mapaDatos.getInteger("oid_proveedor"),getSesion());
    

    if (!mapaDatos.containsKey("fecha")) {
      fecha = Fecha.getFechaActual();
    }
    else {
      fecha = mapaDatos.getDate("fecha");
      if (fecha == null)
        throw new ExceptionValidation(null,"Debe ingresar una Fecha");
    }

    IDataSet datasetCtaCteProv = getDataSetCtaCteProv();
    List listVtosCtaCte = ConsultaCtaCteProv.getVtosCtaCteByProveedor(proveedor,
                                                                      fecha,
                                                                      tipoCuenta,
                                                                      null,
                                                                      getSesion());
    Iterator iterVtosCtaCte = listVtosCtaCte.iterator();
    while (iterVtosCtaCte.hasNext()) {

      // Hacer un corte de control por Comprobante y Fecha de Vencimiento
      ConsultaCtaCteProv consultaCtaCteProv = (ConsultaCtaCteProv)iterVtosCtaCte.next();

      cargarRegistroDataSetCtaCteProv(datasetCtaCteProv,
                                      consultaCtaCteProv.getOrden(),
                                      consultaCtaCteProv.getOIDInteger(),
                                      consultaCtaCteProv.getTc_ext(),
                                      consultaCtaCteProv.getLetra(),
                                      consultaCtaCteProv.getLugEmi(),
                                      consultaCtaCteProv.getNroExt(),
                                      consultaCtaCteProv.getFecEmision(),
                                      consultaCtaCteProv.getTranProv(),
                                      consultaCtaCteProv.getTranProvVto(),
                                      consultaCtaCteProv.getVto(),
                                      consultaCtaCteProv.getImpoCuota(),
                                      consultaCtaCteProv.getSaldoCuota(),
                                      consultaCtaCteProv.getTipoCtaCteProv(),
                                      consultaCtaCteProv.getDescTipoCtaCteProv(),
                                      consultaCtaCteProv.getProveedor(),
                                      consultaCtaCteProv.getRsProveedor(),
                                      consultaCtaCteProv.getTotMonOri(),
                                      consultaCtaCteProv.getSaldoMonOri(),
                                      consultaCtaCteProv.getMoneda(),
                                      consultaCtaCteProv.getDescMoneda(),
                                      consultaCtaCteProv.getComprobante(),
                                      consultaCtaCteProv.getCodigo(),
                                      consultaCtaCteProv.getCotizMonOri(),
                                      consultaCtaCteProv.getCotizMonExt1(),
                                      consultaCtaCteProv.getCotizMonExt2(),
                                      consultaCtaCteProv.getCotizMonOriCon(),
                                      consultaCtaCteProv.getCotizMonExt1Con(),
                                      consultaCtaCteProv.getCotizMonExt2Con()
                                      );
    }

    IDataSet dsTipoCons = getDataSetTipoConsulta();
    cargarRegistroTipoConsulta(dsTipoCons,fecha);

    writeCliente(datasetCtaCteProv);
    writeCliente(dsTipoCons);
  }

  private IDataSet getDataSetCtaCteProv() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConsultaCtaCteProv");
    dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid",Field.INTEGER, 0));
    dataset.fieldDef(new Field("tc_ext",Field.STRING, 10));
    dataset.fieldDef(new Field("letra",Field.STRING, 1));
    dataset.fieldDef(new Field("lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision",Field.STRING,10));
    dataset.fieldDef(new Field("oid_tran_prov",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tran_vto",Field.INTEGER, 0));
    dataset.fieldDef(new Field("vto",Field.STRING,10));
    dataset.fieldDef(new Field("impo_cuota",Field.CURRENCY,0));
    dataset.fieldDef(new Field("saldo_cuota",Field.CURRENCY,0));
    dataset.fieldDef(new Field("oid_tipo_cta_prov",Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_cta_prov",Field.STRING,50));
    dataset.fieldDef(new Field("oid_proveedor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("rs_proveedor",Field.STRING,50));
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
    dataset.create("TTipoConsCtaCteProv");
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


  private void cargarRegistroDataSetCtaCteProv(IDataSet dataset,
                                               Integer orden,
                                               Integer oid,
                                               String tcExt,
                                               String letra,
                                               Integer lugEmi,
                                               Integer nroExt,
                                               java.util.Date fecEmision,
                                               TranProv tranProv,
                                               TranProvVto tranProvVto,
                                               java.util.Date vtoCuota,
                                               Money impoCuota,
                                               Money saldoCuota,
                                               TipoCtaCteProv tipoCtaCteProv,
                                               String descTipoCtaCteProv,
                                               Proveedor proveedor,
                                               String rsProveedor,
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
    dataset.fieldValue("oid_tran_prov",tranProv.getOID());
    dataset.fieldValue("oid_tran_vto",tranProvVto.getOID());
    dataset.fieldValue("vto",Fecha.getddmmyyyy(vtoCuota));
    dataset.fieldValue("impo_cuota",impoCuota.doubleValue()*-1);
    dataset.fieldValue("saldo_cuota",saldoCuota.doubleValue()*-1);
    dataset.fieldValue("oid_tipo_cta_prov",tipoCtaCteProv.getOID());
    dataset.fieldValue("tipo_cta_prov",descTipoCtaCteProv);
    dataset.fieldValue("oid_proveedor",proveedor.getOID());
    dataset.fieldValue("rs_proveedor",rsProveedor);
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
