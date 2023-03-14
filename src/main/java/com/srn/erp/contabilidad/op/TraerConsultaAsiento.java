package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsultaAsiento extends Operation {

  public TraerConsultaAsiento() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Integer oidCCO = mapaDatos.getInteger(DBComproCab.OID_CCO);
    traerComprobanteAsiento(oidCCO);
  }


  public void traerComprobanteAsiento(Integer oidCCO) throws BaseException {

    IDataSet dataSetComproContaCab = getDataComproContaCab();
    IDataSet dataSetComproContaDet = getDataComproContaDet();
    IDataSet dataSetMonedasConta   = Moneda.enviarMonedasContables(getSesion());


    ComproConta comproConta = ComproConta.findByOid(oidCCO,getSesion());
    cargarRegistroComproContaCab(dataSetComproContaCab,
                                 comproConta.getOIDInteger(),
                                 comproConta.getComprobante().getCodigo(),
                                 comproConta.getComprobante().getEmision(),
                                 comproConta.getImputac(),
                                 new Integer(0),
                                 new Double(0.0),
                                 comproConta.getComprobante().getComentario(),
                                 comproConta.isAnulado());

    Iterator iterDetalleAsientos =
        comproConta.getDetallesAsiento().iterator();
    while (iterDetalleAsientos.hasNext()) {
      ComproContaDet comproContaDet =
          (ComproContaDet)iterDetalleAsientos.next();
      cargarRegistroComproContaDet(dataSetComproContaDet,
                                   comproContaDet.getOIDInteger(),
                                   comproConta.getOIDInteger(),
                                   comproContaDet.getSecu(),
                                   comproContaDet.getCuentaImputable().getOIDInteger(),
                                   comproContaDet.getCuentaImputable().getCodigoCuentaMasCodigosValCompo(),
                                   comproContaDet.getCuentaImputable().getDescCuentaMasDescValCompo(),
                                   (comproContaDet.getSigno().intValue()==1)?
                                     comproContaDet.getImpoLocHist():new Money(0.0),
                                   (comproContaDet.getSigno().intValue()==-1)?
                                     comproContaDet.getImpoLocHist():new Money(0.0),
                                   (comproContaDet.getSigno().intValue()==1)?
                                     comproContaDet.getImpoLocAju():new Money(0.0),
                                   (comproContaDet.getSigno().intValue()==-1)?
                                     comproContaDet.getImpoLocAju():new Money(0.0),
                                   (comproContaDet.getSigno().intValue()==1)?
                                     comproContaDet.getImpoMonExt1():new Money(0.0),
                                   (comproContaDet.getSigno().intValue()==-1)?
                                     comproContaDet.getImpoMonExt1():new Money(0.0),
                                   (comproContaDet.getSigno().intValue()==1)?
                                     comproContaDet.getImpoMonExt2():new Money(0.0),
                                   (comproContaDet.getSigno().intValue()==-1)?
                                     comproContaDet.getImpoMonExt2():new Money(0.0),
                                   comproContaDet.getComentario());
    }

    writeCliente(dataSetComproContaCab);
    writeCliente(dataSetComproContaDet);
    writeCliente(dataSetMonedasConta);

  }

  private IDataSet getDataComproContaCab() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAsientoCab");
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante",Field.STRING, 30));
    dataset.fieldDef(new Field("fec_emision",Field.STRING, 10));
    dataset.fieldDef(new Field("fec_imputacion",Field.STRING, 10));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cotizacion",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("comentario",Field.STRING, 255));
    dataset.fieldDef(new Field("anulado",Field.BOOLEAN,0));
    return dataset;
  }

  private void cargarRegistroComproContaCab(IDataSet dataset,
                                            Integer oidCCO,
                                            String comprobante,
                                            java.util.Date fecEmision,
                                            java.util.Date fecImputacion,
                                            Integer oidMoneda,
                                            Double cotizacion,
                                            String comentario,
                                            Boolean anulado) {
    dataset.append();
    dataset.fieldValue("oid_cco", oidCCO);
    dataset.fieldValue("comprobante",comprobante);
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(fecEmision));
    dataset.fieldValue("fec_imputacion", Fecha.getddmmyyyy(fecImputacion));
    dataset.fieldValue("oid_moneda", oidMoneda);
    dataset.fieldValue("cotizacion", cotizacion);
    if (comentario == null)
       dataset.fieldValue("comentario", "");
    else
       dataset.fieldValue("comentario", comentario);
    dataset.fieldValue("anulado", anulado);
  }


  private IDataSet getDataComproContaDet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAsientoDet");
    dataset.fieldDef(new Field("oid_dco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ana_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_ana_imp", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ana_imp", Field.STRING, 100));
    dataset.fieldDef(new Field("comentario", Field.STRING,255));
    dataset.fieldDef(new Field("debe_mon_loc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("haber_mon_loc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("debe_mon_aju", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("haber_mon_aju", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("debe_mon_ext_1", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("haber_mon_ext_1", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("debe_mon_ext_2", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("haber_mon_ext_2", Field.CURRENCY, 0));
    return dataset;
  }


  private void cargarRegistroComproContaDet(IDataSet dataset,
                         Integer oidDCO,
                         Integer oidCCO,
                         Integer secu,
                         Integer oidAnaImp,
                         String codigoAnaImp,
                         String descAnaImp,
                         Money debeMonLoc,
                         Money haberMonLoc,
                         Money debeMonAju,
                         Money haberMonAju,
                         Money debeMonExt1,
                         Money haberMonExt1,
                         Money debeMonExt2,
                         Money haberMonExt2,
                         String comentario) {
    dataset.append();
    dataset.fieldValue("oid_dco", oidDCO);
    dataset.fieldValue("oid_cco", oidCCO);
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("oid_ana_imp",oidAnaImp);
    dataset.fieldValue("codigo_ana_imp",codigoAnaImp);
    dataset.fieldValue("desc_ana_imp",descAnaImp);
    if (comentario == null)
      dataset.fieldValue("comentario","");
    else
      dataset.fieldValue("comentario",comentario);
    if (debeMonLoc.doubleValue()!=0)
    	dataset.fieldValue("debe_mon_loc", debeMonLoc.doubleValue());
    else
    	dataset.fieldValue("debe_mon_loc", "");
    if (haberMonLoc.doubleValue()!=0)
    	dataset.fieldValue("haber_mon_loc", haberMonLoc.doubleValue());
    else
    	dataset.fieldValue("haber_mon_loc", "");
    if (debeMonAju.doubleValue()!=0)
    	dataset.fieldValue("debe_mon_aju", debeMonAju.doubleValue());
    else
    	dataset.fieldValue("debe_mon_aju", "");
    if (haberMonAju.doubleValue()!=0)
    	dataset.fieldValue("haber_mon_aju", haberMonAju.doubleValue());
    else
    	dataset.fieldValue("haber_mon_aju", "");
    if (debeMonExt1.doubleValue()!=0)
    	dataset.fieldValue("debe_mon_ext_1", debeMonExt1.doubleValue());
    else
    	dataset.fieldValue("debe_mon_ext_1", "");
    if (haberMonExt1.doubleValue()!=0)
    	dataset.fieldValue("haber_mon_ext_1", haberMonExt1.doubleValue());
    else
    	dataset.fieldValue("haber_mon_ext_1", "");
    if (debeMonExt2.doubleValue()!=0)
    	dataset.fieldValue("debe_mon_ext_2", debeMonExt2.doubleValue());
    else
    	dataset.fieldValue("debe_mon_ext_2", "");
    if (haberMonExt2.doubleValue()!=0)
    	dataset.fieldValue("haber_mon_ext_2", haberMonExt2.doubleValue());
    else
    	dataset.fieldValue("haber_mon_ext_2", "");
  }

}
