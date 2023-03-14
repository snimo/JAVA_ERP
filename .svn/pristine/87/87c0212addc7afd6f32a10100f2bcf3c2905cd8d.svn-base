package com.srn.erp.pagos.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproAnticipoProveedor;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.pagos.bm.CalculadorRetencionGanancias;
import com.srn.erp.pagos.bm.CalculadorRetencionesOP;
import com.srn.erp.pagos.bm.CertificadoRetGanCab;
import com.srn.erp.pagos.bm.CertificadoRetGanDet;
import com.srn.erp.pagos.bm.RetCabGan;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMontoPagoOP extends Operation {

  public TraerMontoPagoOP() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {


    IDataSet dsCertRetCab = getDataSetCertificadoCAB();
    IDataSet dsCertRetDet = getDataSetCertificadoDET();

    CalculadorMoney totBruto      = new CalculadorMoney(new Money(0));
    CalculadorMoney totDescuento  = new CalculadorMoney(new Money(0));
    CalculadorMoney totNetoDto    = new CalculadorMoney(new Money(0));
    CalculadorMoney totNetoAPagar = new CalculadorMoney(new Money(0));
    CalculadorMoney totNetoAPagarSinAnticipos = new CalculadorMoney(new Money(0));

    CalculadorRetencionesOP calcRetOP = new CalculadorRetencionesOP();
    calcRetOP.setSesion(getSesion());
    calcRetOP.setCotizMonPago(mapaDatos.getCotizacion("cotizacion"));
    calcRetOP.setFecha(mapaDatos.getDate("fecha"));
    calcRetOP.setProveedor(Proveedor.findByOid(mapaDatos.getInteger("oid_proveedor"),getSesion()));

    IDataSet dsFactAPagar = mapaDatos.getDataSet("TFacturasAPagar");
    IDataSet dsMontoOP = getDataSetCalcMontoOP();
    dsFactAPagar.first();
    while (!dsFactAPagar.EOF()) {

      // Calcular total Bruto
      totBruto.sumar(dsFactAPagar.getMoney("descuento"));
      totBruto.sumar(dsFactAPagar.getMoney("a_pagar"));

      // Calcular el total del descuento
      totDescuento.sumar(dsFactAPagar.getMoney("descuento"));

      // Calcular Neto Descuento
      totNetoDto.sumar(dsFactAPagar.getMoney("a_pagar"));

      // Calcular las Retenciones de Impuestos
      TranProvVto tranProvVto =
          TranProvVto.findByOid(dsFactAPagar.getInteger("oid_tran_vto"),getSesion());
      
      ComproAnticipoProveedor comproAnticipoProv = (ComproAnticipoProveedor)
    		ComproAnticipoProveedor.findByOid(dsFactAPagar.getInteger("oid_cco_ant_prov"),getSesion());
    
      ComproCab comproCab = getComprobante(tranProvVto,comproAnticipoProv);
      
      calcRetOP.addPagoCuotaComprobante(tranProvVto,
      																	comproAnticipoProv,
                                        dsFactAPagar.getMoney("saldo_mon_pago"),
                                        dsFactAPagar.getMoney("descuento"),
                                        dsFactAPagar.getMoney("a_pagar"));

      // Calcular el Neto a Pagar
      totNetoAPagar.sumar(dsFactAPagar.getMoney("a_pagar"));
      
      if (!(IdentificacionTipoComprobante.esAnticipoProveedor(comproCab.getTipoCompro().getIdentificacion())))
      	totNetoAPagarSinAnticipos.sumar(dsFactAPagar.getMoney("a_pagar"));

      dsFactAPagar.next();
    }

    calcRetOP.setTotalPago(totNetoAPagar.getResultMoney());
    calcRetOP.calcularRetenciones();

    if (calcRetOP.tieneRetencionDeGanancias())
      enviarRetencionesGanancias(calcRetOP.getCalcRetGan(),dsCertRetCab,dsCertRetDet);

    totNetoAPagar.restar(calcRetOP.getRetIVAMonPago());
    totNetoAPagar.restar(calcRetOP.getRetGanMonPago());
    totNetoAPagar.restar(calcRetOP.getRetIBMonPago());

     
    
    cargarDataSetCalcMontoOP(
      dsMontoOP,
      totBruto.getResultMoney(),
      totDescuento.getResultMoney(),
      totNetoDto.getResultMoney(),
      calcRetOP.getRetIVAMonPago(),
      calcRetOP.getRetGanMonPago(),
      calcRetOP.getRetIBMonPago(),
      totNetoAPagar.getResultMoney(),
      totNetoAPagarSinAnticipos.getResultMoney());

    writeCliente(dsMontoOP);
    writeCliente(dsCertRetCab);
    writeCliente(dsCertRetDet);

  }
  
  private ComproCab getComprobante(TranProvVto tranProvVto,ComproAnticipoProveedor comproAntProv) throws BaseException {
  	if (tranProvVto!=null)
  		return tranProvVto.getTranprov().getComprobante();
  	else
  		return comproAntProv;
  }

  private void enviarRetencionesGanancias(CalculadorRetencionGanancias calcRetGan,
                                          IDataSet dsCertRetCab ,
                                          IDataSet dsCertRetDet)
      throws BaseException {
    CertificadoRetGanCab certRetGanCab = calcRetGan.getCertRetGanCab();
    cargarDataSetCertCAB(dsCertRetCab,
                         certRetGanCab.getOIDInteger(),
                         RetCabGan.NICKNAME,
                         certRetGanCab.getProveedor().getOIDInteger(),
                         certRetGanCab.getPeriretgan().getOIDInteger(),
                         certRetGanCab.getCatretgan().getOIDInteger(),
                         certRetGanCab.getPorclib(),
                         certRetGanCab.getDecreto());

    Iterator iterDetallesCertificados =
        calcRetGan.getDetallesCertificado().iterator();
    while (iterDetallesCertificados.hasNext()) {
      CertificadoRetGanDet certRetGanDet = (CertificadoRetGanDet) iterDetallesCertificados.next();
      cargarDataSetCertDET(dsCertRetDet,
                           certRetGanDet.getOIDInteger(),
                           certRetGanCab.getOIDInteger(),
                           certRetGanDet.getConceptoimpuesto().getOIDInteger(),
                           certRetGanDet.getMontonoimponible(),
                           certRetGanDet.getCertificado().getOIDInteger(),
                           certRetGanDet.getMontogravado(),
                           certRetGanDet.getPagoneto(),
                           certRetGanDet.getPorcentaje(),
                           certRetGanDet.getMontoretminima(),
                           certRetGanDet.getBasepararetener(),
                           certRetGanDet.getPagoacum(),
                           certRetGanDet.getRetacum(),
                           certRetGanDet.getImpuestoretenido(),
                           certRetGanDet.getMontofijo());
    }

  }

  private IDataSet getDataSetCalcMontoOP() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCalculoMontosOP");
    dataset.fieldDef(new Field("bruto", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("descuento", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("neto_descuento", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("ret_iva", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("ret_gan", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("ret_ib", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("ret_sus", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("a_pagar", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("a_pagar_sin_anticipos", Field.CURRENCY, 0));
    return dataset;
  }

  private IDataSet getDataSetCertificadoCAB() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCertificadoRetCab");
    dataset.fieldDef(new Field("oid_cert_ret_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_certificado", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_peri_ret_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ret_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("porc_lib", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("decreto", Field.STRING, 30));
    return dataset;
  }

  private void cargarDataSetCertCAB(IDataSet dataset,
                         Integer oidCertRetCab,
                         String  tipoCertificado,
                         Integer oidProveedor,
                         Integer oidPeriRetGan,
                         Integer oidCatRetGan,
                         Money   porcLib,
                         String  decreto) {
    dataset.append();
    dataset.fieldValue("oid_cert_ret_cab", oidCertRetCab);
    dataset.fieldValue("tipo_certificado", tipoCertificado);
    dataset.fieldValue("oid_proveedor",oidProveedor);
    dataset.fieldValue("oid_peri_ret_gan",oidPeriRetGan);
    dataset.fieldValue("oid_cat_ret_gan",oidCatRetGan);
    dataset.fieldValue("porc_lib",porcLib);
    dataset.fieldValue("decreto",decreto);
  }

  private IDataSet getDataSetCertificadoDET() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCertificadoRetDet");
    dataset.fieldDef(new Field("oid_cert_ret_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cert_ret_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu",Field.INTEGER, 0));
    dataset.fieldDef(new Field("monto_no_impo",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_cco_cert",Field.INTEGER, 0));
    dataset.fieldDef(new Field("monto_gravado",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("pago_neto",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc_ret",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_ret_min",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("base_para_retener",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("pago_acum",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("ret_acum",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("impuesto_retenido",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_fijo",Field.CURRENCY, 0));
    return dataset;
  }

  private void cargarDataSetCertDET(IDataSet dataset,
                         Integer oidCertRetDet,
                         Integer oidCertRetCab,
                         Integer oidConceptoImpuesto,
                         Money montoNoImponible,
                         Integer oidCCOCertificado,
                         Money montoGravado,
                         Money pagoNeto,
                         Money porcRet,
                         Money montoRetMin,
                         Money baseParaRetener,
                         Money pagoAcum,
                         Money retAcum,
                         Money impuestoRetenido,
                         Money montoFijo) {

    dataset.append();
    dataset.fieldValue("oid_cert_ret_det", oidCertRetDet);
    dataset.fieldValue("oid_cert_ret_cab", oidCertRetCab);
    dataset.fieldValue("oid_conc_impu",oidConceptoImpuesto);
    dataset.fieldValue("monto_no_impo",montoNoImponible);
    dataset.fieldValue("oid_cco_cert",oidCCOCertificado);
    dataset.fieldValue("monto_gravado",montoGravado);
    dataset.fieldValue("pago_neto",pagoNeto);
    dataset.fieldValue("porc_ret",porcRet);
    dataset.fieldValue("monto_ret_min",montoRetMin);
    dataset.fieldValue("base_para_retener",baseParaRetener);
    dataset.fieldValue("pago_acum",pagoAcum);
    dataset.fieldValue("ret_acum",retAcum);
    dataset.fieldValue("impuesto_retenido",impuestoRetenido);
    dataset.fieldValue("monto_fijo",montoFijo);
  }





  private void cargarDataSetCalcMontoOP(IDataSet dataset,
                         Money bruto,
                         Money descuento,
                         Money neto_descuento,
                         Money ret_iva,
                         Money ret_gan,
                         Money ret_ib,
                         Money aPagar,
                         Money aPagarSinAnticipos) {
    dataset.append();
    dataset.fieldValue("bruto", bruto);
    dataset.fieldValue("descuento", descuento);
    dataset.fieldValue("neto_descuento", neto_descuento);
    dataset.fieldValue("ret_iva", ret_iva);
    dataset.fieldValue("ret_gan", ret_gan);
    dataset.fieldValue("ret_ib", ret_ib);
    dataset.fieldValue("ret_sus", 0);
    dataset.fieldValue("a_pagar", aPagar);
    dataset.fieldValue("a_pagar_sin_anticipos", aPagarSinAnticipos);
  }



}
