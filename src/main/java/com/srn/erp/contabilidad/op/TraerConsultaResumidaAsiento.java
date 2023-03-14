package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsultaResumidaAsiento extends Operation {

	
	private HashTableDatos renglones = new HashTableDatos();
	
	class ResumenRenglonAsi {
		  Integer oidCuenta;
		  String codCuenta;
		  String descCuenta;
		  Money debeLocal = new Money(0);
		  Money haberLocal = new Money(0);
		  Money debeLocalAju = new Money(0);
		  Money haberLocalAju = new Money(0);		  
		  Money debeMoneExt1 = new Money(0);
		  Money haberMoneExt1 = new Money(0);		  
		  Money debeMoneExt2 = new Money(0);
		  Money haberMoneExt2= new Money(0);
		  
		  public void add(Money aDebeLocal,
				     Money aHaberLocal,
				     Money aDebeAju,
				     Money aHaberAju,
				     Money aDebeExt1,
				     Money aHaberExt1,
				     Money aDebeExt2,
				     Money aHaberExt2) throws BaseException {
			  
			  CalculadorMoney calcDebeLocal = new CalculadorMoney(debeLocal);
			  calcDebeLocal.sumar(aDebeLocal);
			  debeLocal = calcDebeLocal.getResultMoney();
			  
			  CalculadorMoney calcHaberLocal = new CalculadorMoney(haberLocal);
			  calcHaberLocal.sumar(aHaberLocal);
			  haberLocal = calcHaberLocal.getResultMoney();
			  
			  CalculadorMoney calcDebeLocalAju = new CalculadorMoney(debeLocalAju);
			  calcDebeLocalAju.sumar(aDebeAju);
			  debeLocalAju = calcDebeLocalAju.getResultMoney();
			  
			  CalculadorMoney calcHaberLocalAju = new CalculadorMoney(haberLocalAju);
			  calcHaberLocalAju.sumar(aHaberAju);
			  haberLocalAju = calcHaberLocalAju.getResultMoney();
			  
			  CalculadorMoney calcDebeExt1 = new CalculadorMoney(debeMoneExt1);
			  calcDebeExt1.sumar(aDebeExt1);
			  debeMoneExt1 = calcDebeExt1.getResultMoney();
			  
			  CalculadorMoney calcHaberExt1 = new CalculadorMoney(haberMoneExt1);
			  calcHaberExt1.sumar(aHaberExt1);
			  haberMoneExt1 = calcHaberExt1.getResultMoney();
			  
			  CalculadorMoney calcDebeExt2 = new CalculadorMoney(debeMoneExt2);
			  calcDebeExt2.sumar(aDebeExt2);
			  debeMoneExt2 = calcDebeExt2.getResultMoney();
			  
			  CalculadorMoney calcHaberExt2 = new CalculadorMoney(haberMoneExt2);
			  calcHaberExt2.sumar(aHaberExt2);
			  haberMoneExt2 = calcHaberExt2.getResultMoney();
			  
		  }
	}	
	
  public TraerConsultaResumidaAsiento() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Integer oidCCO = 0;
    if (mapaDatos.containsKey("oid"))
    	oidCCO = mapaDatos.getInteger("oid");
    else
    	oidCCO = mapaDatos.getInteger(DBComproCab.OID_CCO);
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
      ResumenRenglonAsi renglon =
    	  getRenglon(comproContaDet.getCuentaImputable().getCuenta());
      
      
      Money impoDebe = new Money(0);
      Money impoHaber = new Money(0);
      Money impoDebeAju = new Money(0);
      Money impoHaberAju = new Money(0);
      Money impoDebeMonExt1 = new Money(0);
      Money impoHaberMonExt1 = new Money(0);
      Money impoDebeMonExt2 = new Money(0);
      Money impoHaberMonExt2 = new Money(0);      
      
      if (comproContaDet.getSigno().intValue()==1) {
          impoDebe = comproContaDet.getImpoLocHist();
          impoDebeAju = comproContaDet.getImpoLocAju();
          impoDebeMonExt1 = comproContaDet.getImpoMonExt1();
          impoDebeMonExt2 = comproContaDet.getImpoMonExt2();
      } else {
    	  impoHaber = comproContaDet.getImpoLocHist();
          impoHaberAju = comproContaDet.getImpoLocAju();      
          impoHaberMonExt1 = comproContaDet.getImpoMonExt1();
          impoHaberMonExt2 = comproContaDet.getImpoMonExt2();
      }
      
      renglon.add(impoDebe, impoHaber, impoDebeAju, impoHaberAju, impoDebeMonExt1, impoHaberMonExt1, impoDebeMonExt2, impoHaberMonExt2);
      
    }
    
    int secu = 0;
    Iterator iterRenglones = 
    	renglones.values().iterator();
    while (iterRenglones.hasNext()) {
    	ResumenRenglonAsi resuDet = (ResumenRenglonAsi) iterRenglones.next();
    	cargarRegistroComproContaDet(dataSetComproContaDet, 
    			++secu, comproConta.getOIDInteger(), 
    			secu, 
    			resuDet.oidCuenta, 
    			resuDet.codCuenta, 
    			resuDet.descCuenta, 
    			resuDet.debeLocal,
    			resuDet.haberLocal,
    			resuDet.debeLocalAju,
    			resuDet.haberLocalAju,
    			resuDet.debeMoneExt1,
    			resuDet.haberMoneExt1,
    			resuDet.debeMoneExt2,
    			resuDet.haberMoneExt2,
    			"");
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

  private ResumenRenglonAsi getRenglon(Cuenta cuenta) throws BaseException {
	  ResumenRenglonAsi resuRenglon =
		  (ResumenRenglonAsi)renglones.get(cuenta.getOIDInteger());
	  if (resuRenglon == null) {
		  resuRenglon = new ResumenRenglonAsi();
		  resuRenglon.oidCuenta = cuenta.getOIDInteger();
		  resuRenglon.descCuenta = cuenta.getDescripcion();
		  resuRenglon.codCuenta = cuenta.getCodigo();
		  renglones.put(cuenta.getOIDInteger(), resuRenglon);
	  }
	  return resuRenglon;
  }
  
}
