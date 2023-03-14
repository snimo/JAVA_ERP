package com.srn.erp.contabilidad.op;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;

import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.contabilidad.bm.ImporteDebeHaber;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLibroDiario extends Operation {

  private boolean esMonedaLocal = false;
  private boolean esMonedaExt1 = false;
  private boolean esMonedaExt2 = false;
  private HashTableDatos cacheCuentas = new HashTableDatos();

  int secu = 1;
	  
	
  public TraerLibroDiario() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	  Ejercicio ejercicio = Ejercicio.findByOid(mapaDatos.getInteger("oid_ejercicio"), this.getSesion());
	  Moneda moneda = Moneda.findByOid(mapaDatos.getInteger("oid_moneda"), this.getSesion());
	  java.util.Date fecDesde = ejercicio.getFechadesde();
	  java.util.Date fecHasta = ejercicio.getFechahasta();
	  
	  if (moneda.isMonedaCursoLegal())
		  esMonedaLocal = true;
	  else if (moneda.isMonedaExt1())
		  		esMonedaExt1 = true;
	  else if (moneda.isMonedaExt2())
		  		esMonedaExt2 = true;
	  
	  if (mapaDatos.containsKey("fec_desde"))
		  fecDesde = mapaDatos.getDate("fec_desde");
	  
	  if (mapaDatos.containsKey("fec_hasta"))
		  fecHasta = mapaDatos.getDate("fec_hasta");
	  
	  IDataSet ds = this.getDataSetLibroDiario();
	  IDataSet dsTitulo = getDataSetTituloLibroDiario();
	  
	  cargarTitulo(dsTitulo," Libro Diario del "+Fecha.getddmmyyyy(fecDesde)+" al "+Fecha.getddmmyyyy(fecHasta));
	  
	  int ultNroAsiento = -1;
	  HashTableDatos asientoResumen = new HashTableDatos();
	  
	  Iterator iterComproContaDet = 
		  ComproContaDet.getImpuFecDesdeHastaOrderByNroAsi(fecDesde,fecHasta,this.getSesion()).iterator();
	  while (iterComproContaDet.hasNext()) {
		  ComproContaDet comproContaDet = (ComproContaDet) iterComproContaDet.next();
		  
		  int nroAsiento = 0;
		  if (comproContaDet.getNroAsiento() != null)
			  nroAsiento = comproContaDet.getNroAsiento().intValue();
		  
		  if (nroAsiento!=ultNroAsiento) {
			  
			  if (asientoResumen.size()>0) 
				  enviarDetallesAsiento(ds,asientoResumen);
			  
			  // Enviar la Cabecera del Asiento
			  
			  asientoResumen = null;
			  asientoResumen = new HashTableDatos();
			  ultNroAsiento = nroAsiento;
			  cargarRegistroLibroDiario(true,ds, new Integer(++secu), "", "", null, null);
			  cargarRegistroLibroDiario(true,ds, new Integer(++secu), "", "", null, null);
			  cargarRegistroLibroDiario(true,ds, new Integer(++secu), "CUENTA", "          --- NRO. ASIENTO "+nroAsiento+"    FECHA "+Fecha.getddmmyyyy(comproContaDet.getComprobante().getImputac())+" ---", "DEBE", "    HABER");
			  StringBuffer concepto = new StringBuffer("");
	          concepto.append("          ");
			  if ((comproContaDet.getComprobante().getComprobante().getTipoCompro().getDescTituAsiLibroDiario()!=null) &&
			  (comproContaDet.getComprobante().getComprobante().getTipoCompro().getDescTituAsiLibroDiario().length()>0))
				  concepto.append(comproContaDet.getComprobante().getComprobante().getTipoCompro().getDescTituAsiLibroDiario());
			  else
				  concepto.append(comproContaDet.getComprobante().getComprobante().getTipoCompro().getDescripcion());
			  if (ejercicio.getUltimaPresentacionLibroDiario()!=null) 
				  if (ejercicio.getUltimaPresentacionLibroDiario().equals(Ejercicio.LD_DIA_COMPRO))
					  concepto.append(" "+comproContaDet.getComprobante().getComprobante().getCodigo());
			  
			  cargarRegistroLibroDiario(true,ds, new Integer(++secu), "", concepto.toString(), null, null);
			  
			  concepto = null;
			  
 		  }
		  
		  acumularComproContaDetPorCuenta(comproContaDet,asientoResumen);
		  
		  comproContaDet = null;
	  }
	  
	  if (asientoResumen.size()>0) 
		  enviarDetallesAsiento(ds,asientoResumen);
	  
	  writeCliente(ds);
	  writeCliente(dsTitulo);
	  
    
  }
  
  private void enviarDetallesAsiento(IDataSet ds,HashTableDatos asientoResumen) throws BaseException {

	  NumberFormat formatter = new DecimalFormat("###,###,###,###,##0.00");
	  Iterator iterCtas = 
		  asientoResumen.keySet().iterator();
	  
	  while (iterCtas.hasNext()) {
		  
		  Integer oidCuenta = (Integer) iterCtas.next();
		  Cuenta cuenta     = getCuenta(oidCuenta);
		  
		  ImporteDebeHaber impoDebeHaber = (ImporteDebeHaber) asientoResumen.get(oidCuenta);
		  
		  String debe = null;
		  String haber = null;
		  
		  if (esMonedaLocal) {
			  if (impoDebeHaber.getDebe().getImpoMonLoc().doubleValue()>0) {
				  debe = formatter.format(impoDebeHaber.getDebe().getImpoMonLoc().doubleValue());
				  cargarRegistroLibroDiario(false,ds, new Integer(++secu), cuenta.getCodigo(), cuenta.getDescripcion(), debe, haber);
			  }
		  }
		  else if (esMonedaExt1) {
			  if (impoDebeHaber.getDebe().getImpoMonExt1().doubleValue()>0) {
				  debe = formatter.format(impoDebeHaber.getDebe().getImpoMonExt1().doubleValue());
				  cargarRegistroLibroDiario(false,ds, new Integer(++secu), cuenta.getCodigo(), cuenta.getDescripcion(), debe, haber);
			  }
		  }
		  else if (esMonedaExt2) {
			  if (impoDebeHaber.getDebe().getImpoMonExt2().doubleValue()>0) {
				  debe = formatter.format(impoDebeHaber.getDebe().getImpoMonExt2().doubleValue());
				  cargarRegistroLibroDiario(false,ds, new Integer(++secu), cuenta.getCodigo(), cuenta.getDescripcion(), debe, haber);
			  }
		  }
			  
		  cuenta = null;
		  impoDebeHaber = null;
		  
	  }
	  
	  iterCtas = null;
	  
	  iterCtas = 
		  asientoResumen.keySet().iterator();
	  
	  while (iterCtas.hasNext()) {
		  
		  Integer oidCuenta = (Integer) iterCtas.next();
		  Cuenta cuenta     = getCuenta(oidCuenta);
		  
		  ImporteDebeHaber impoDebeHaber = (ImporteDebeHaber) asientoResumen.get(oidCuenta);
		  
		  String debe = null;
		  String haber = null;
		  
		  if (esMonedaLocal) {
			  if (impoDebeHaber.getHaber().getImpoMonLoc().doubleValue()>0) {
				  haber = formatter.format(impoDebeHaber.getHaber().getImpoMonLoc().doubleValue());
				  cargarRegistroLibroDiario(false,ds, new Integer(++secu), cuenta.getCodigo(), cuenta.getDescripcion(), debe, haber);
			  }
		  }
		  else if (esMonedaExt1) {
			  if (impoDebeHaber.getHaber().getImpoMonExt1().doubleValue()>0) {
				  haber = formatter.format(impoDebeHaber.getHaber().getImpoMonExt1().doubleValue());
				  cargarRegistroLibroDiario(false,ds, new Integer(++secu), cuenta.getCodigo(), cuenta.getDescripcion(), debe, haber);
			  }
		  }
		  else if (esMonedaExt2) {
			  if (impoDebeHaber.getHaber().getImpoMonExt2().doubleValue()>0) {
				  haber = formatter.format(impoDebeHaber.getHaber().getImpoMonExt2().doubleValue());
				  cargarRegistroLibroDiario(false,ds, new Integer(++secu), cuenta.getCodigo(), cuenta.getDescripcion(), debe, haber);
			  }
		  }
		  
		  cuenta = null;
		  impoDebeHaber = null;
		  
	  }
	  
	  iterCtas = null;
	  formatter = null;
	  
  }
  

  private IDataSet getDataSetLibroDiario() {
    IDataSet dataset = new TDataSet();
    dataset.create("TLibroDiario");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cuenta", Field.STRING, 100));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
    dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
    return dataset;
  }
  
  private IDataSet getDataSetTituloLibroDiario() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TTituloDiario");
	    dataset.fieldDef(new Field("titulo", Field.STRING, 255));
	    return dataset;
  }
  
  private void cargarTitulo(IDataSet dataset,
          String titulo)
          throws BaseException {
	 dataset.append();
	 dataset.fieldValue("titulo", titulo);
	 
  }

  
  
  private void cargarRegistroLibroDiario(boolean esTitu,
		                                 IDataSet dataset,
                                         Integer secu,
                                         String cuenta,
                                         String descripcion,
                                         String debe,
                                         String haber)
                                         throws BaseException {
	  
    dataset.append();
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("cuenta", cuenta);
    dataset.fieldValue("descripcion", descripcion);
    if (debe!=null)
    	dataset.fieldValue("debe", debe);
    else
    	dataset.fieldValue("debe", "");
    if (haber!=null)
    	dataset.fieldValue("haber", haber);
    else
    	dataset.fieldValue("haber", "");
    
  }
  
  private void acumularComproContaDetPorCuenta(ComproContaDet comproContaDet , HashTableDatos acumPorCuenta) throws BaseException {     
		
		ImporteDebeHaber importeDebeHaber =
			(ImporteDebeHaber) acumPorCuenta.get(comproContaDet.getCuentaImputable().getCuenta().getOIDInteger());
		
		if (importeDebeHaber == null) {
			importeDebeHaber = new ImporteDebeHaber();
			ImportesContables impoContaDebe = new ImportesContables(new Money(0), new Money(0), new Money(0), new Money(0)); 
			ImportesContables impoContaHaber = new ImportesContables(new Money(0), new Money(0), new Money(0), new Money(0));
			importeDebeHaber.setDebe(impoContaDebe);
			importeDebeHaber.setHaber(impoContaHaber);
			acumPorCuenta.put(comproContaDet.getCuentaImputable().getCuenta().getOIDInteger(), importeDebeHaber);
		}
		
		ImportesContables importesContables = new ImportesContables(
				comproContaDet.getImpoLocHist(),
				comproContaDet.getImpoLocAju(),
				comproContaDet.getImpoMonExt1(),
				comproContaDet.getImpoMonExt2()); 
		
		if (comproContaDet.getSigno().intValue() == RenglonAsiento.DEBE) 
			importeDebeHaber.acumularDebe(importesContables);
		else
			importeDebeHaber.acumularHaber(importesContables);
			
		
	}
  
    private Cuenta getCuenta(Integer oidCuenta) throws BaseException {
    	Cuenta cuenta = (Cuenta) cacheCuentas.get(oidCuenta);
    	if (cuenta==null) {
    		cuenta = Cuenta.findByOid(oidCuenta, this.getSesion());
    		cacheCuentas.put(oidCuenta, cuenta);
    	}
    	return cuenta;
    }
  


}
