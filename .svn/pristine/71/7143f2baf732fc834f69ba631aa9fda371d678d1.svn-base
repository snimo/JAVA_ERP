package com.srn.erp.tesoreria.op;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.pagos.bm.TipoValorFormaPago;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MovCajaDiaTipoCompro;
import com.srn.erp.tesoreria.bm.MovimientoCaja;
import com.srn.erp.tesoreria.bm.SaldoEfectivo;
import com.srn.erp.tesoreria.bm.SaldoTipoValor;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresEnCaja extends Operation {

  private int secu = 0;
  
  public TraerValoresEnCaja() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  Caja caja = Caja.findByOid(mapaDatos.getInteger("oid_caja"),getSesion());
	  String tipoConsulta = mapaDatos.getString("tipo_consulta");
	  if (tipoConsulta.equals("CAJA"))   
		  traerValoresEnCaja(caja,mapaDatos);
	  else {
		  java.util.Date fechaDesde = mapaDatos.getDate("fecha_desde");
		  java.util.Date fechaHasta = mapaDatos.getDate("fecha_hasta");
		  
		  if (tipoConsulta.equals("RESUMIDA")) 
			  traerConsResumida(caja,fechaDesde,fechaHasta);
		  else
		  if (tipoConsulta.equals("DET_POR_TIPO_COMPRO")) 
			  traerConsPorTipoCompro(caja,fechaDesde,fechaHasta);
		  else
		  if (tipoConsulta.equals("DET_POR_TIPO_COMPRO_RESU")) 
			  traerConsPorTipoComproResumido(caja,fechaDesde,fechaHasta);
		  else
		  if (tipoConsulta.equals("DET_POR_COMPRO")) { 
			  TipoValor tipoValor = null;
			  TipoComprobante tc = null;
			  if (mapaDatos.containsKey("oid_tipo_valor")) {
				  if (mapaDatos.getInteger("oid_tipo_valor").intValue()>0)
					  tipoValor = TipoValor.findByOidProxy(mapaDatos.getInteger("oid_tipo_valor"), this.getSesion());
			  }
			  if (mapaDatos.containsKey("oid_tc")) {
				  if (mapaDatos.getInteger("oid_tc").intValue()>0)
					  tc = TipoComprobante.findByOidProxy(mapaDatos.getInteger("oid_tc"), this.getSesion());
			  }
			  
			  traerConsPorDetalleComprobante(caja,fechaDesde,fechaHasta,tipoValor,tc);
		  }
		  
		  
	  }
		  
  }

  private IDataSet getDataSetValoresEnCaja() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValoresEnCaja");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_valor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_valor",Field.STRING, 50));
    dataset.fieldDef(new Field("oid_valor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_tipo_valor",Field.STRING, 50));
    dataset.fieldDef(new Field("nro_tarjeta",Field.STRING, 50));
    dataset.fieldDef(new Field("nro",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_entidad",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_entidad",Field.STRING, 50));
    dataset.fieldDef(new Field("razon_social",Field.STRING, 50));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_moneda",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_moneda",Field.STRING, 100));
    dataset.fieldDef(new Field("fec_emision",Field.DATE, 0));
    dataset.fieldDef(new Field("fec_vto",Field.DATE, 0));
    dataset.fieldDef(new Field("importe",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cupon",Field.INTEGER, 0));
    dataset.fieldDef(new Field("lote",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cuotas",Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante",Field.STRING, 100));
    dataset.fieldDef(new Field("fecha",Field.DATE, 0));
    dataset.fieldDef(new Field("nro_certificado",Field.STRING, 50));
    dataset.fieldDef(new Field("provincia",Field.STRING, 100));
    dataset.fieldDef(new Field("codigo_autorizacion",Field.STRING, 50));
    dataset.fieldDef(new Field("cuit",Field.STRING, 20));
    dataset.fieldDef(new Field("nro_valor",Field.STRING, 50));
    dataset.fieldDef(new Field("oid_cco",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_caja",Field.INTEGER, 0));
    
    
    
    return dataset;
  }
  
  private IDataSet getDataSetConsTipoCompro() {
	IDataSet dataset = new TDataSet();
	dataset.create("TConsCajaTipoCompro");
	dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
	dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
	dataset.fieldDef(new Field("fecha", Field.DATE, 0));
	dataset.fieldDef(new Field("oid_tc",Field.INTEGER, 0));
	dataset.fieldDef(new Field("desc_tc",Field.STRING, 100));
	dataset.fieldDef(new Field("importe",Field.CURRENCY, 0));
	return dataset;
  }
  
  private void cargarRegistroConsTipoCompro(IDataSet dataset,
    Integer secu,
    Integer orden,
    Integer oidMoneda,
    Integer oidTipoValor,
    Date fecha,
    Integer oidTC,
    String descTC,
    Money importe) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("secu", secu);
	  dataset.fieldValue("orden", orden);
	  dataset.fieldValue("oid_moneda", oidMoneda);
	  dataset.fieldValue("oid_tipo_valor", oidTipoValor);
	  dataset.fieldValue("fecha", fecha);
	  dataset.fieldValue("oid_tc", oidTC);
	  dataset.fieldValue("desc_tc", descTC);
	  dataset.fieldValue("importe", importe);

  }
  
  private IDataSet getDataSetConsTipoComproResumida() {
	IDataSet dataset = new TDataSet();
	dataset.create("TConsCajaTipoComproResumida");
	dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
	dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_tc",Field.INTEGER, 0));
	dataset.fieldDef(new Field("desc_tc",Field.STRING, 100));
	dataset.fieldDef(new Field("importe",Field.CURRENCY, 0));
	return dataset;
  }
	  
  private void cargarRegistroConsTipoComproResumida(IDataSet dataset,
	Integer secu,
	Integer orden,
	Integer oidMoneda,
	Integer oidTipoValor,
	Integer oidTC,
	String descTC,
	Money importe) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("secu", secu);
	  dataset.fieldValue("orden", orden);
	  dataset.fieldValue("oid_moneda", oidMoneda);
	  dataset.fieldValue("oid_tipo_valor", oidTipoValor);
	  dataset.fieldValue("oid_tc", oidTC);
	  dataset.fieldValue("desc_tc", descTC);
	  dataset.fieldValue("importe", importe);

  }
  
  
  
  private IDataSet getDataSetConsResumida() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TConsultaResumidaCaja");
	    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
	    dataset.fieldDef(new Field("saldo_inicial", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("entradas", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("salidas", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("saldo_final", Field.CURRENCY, 0));
	    return dataset;
  }  
  
  private void cargarRegistroResumida(IDataSet dataset,
		  							  Integer secu,
		  							  Integer oidMoneda,
		  							  Integer oidTipoValor,
		  							  java.util.Date fecha,
		  							  Money saldoInicial,
		  							  Money entradas,
		  							  Money salidas,
		  							  Money saldoFinal) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("secu", secu);
	  dataset.fieldValue("oid_moneda", oidMoneda);
	  dataset.fieldValue("oid_tipo_valor", oidTipoValor);
	  dataset.fieldValue("fecha", fecha);
	  dataset.fieldValue("saldo_inicial", saldoInicial);
	  dataset.fieldValue("entradas", entradas);
	  dataset.fieldValue("salidas", salidas);
	  dataset.fieldValue("saldo_final", saldoFinal);	  
	    	  
  }

  private void cargarRegistroValoresEnCaja(IDataSet dataset,
                         Integer secu,
                         Integer orden,
                         Integer oidTipoValor,
                         String codTipoValor,
                         Integer oidValor,
                         String descTipoValor,
                         String nroTarjeta,
                         Integer nro,
                         String codigoEntidad,
                         String descEntidad,
                         String razonSocial,
                         Integer oidMoneda,
                         String codMoneda,
                         String descMoneda,
                         java.util.Date fecEmision,
                         java.util.Date fecVto,
                         Money importe,
                         Integer cupon,
                         Integer lote,
                         Integer cuotas,
                         String comprobante,
                         Date fecha,
                         String nroCertificado,
                         String provincia,
                         String codigoAutorizacion,
                         String cuit,
                         String nroValor,
                         Integer oidCCO,
                         Integer oidCaja) throws BaseException { 
    dataset.append();
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("orden", orden);
    dataset.fieldValue("oid_tipo_valor",oidTipoValor);
    dataset.fieldValue("cod_tipo_valor",codTipoValor);
    dataset.fieldValue("oid_valor",oidValor);
    dataset.fieldValue("desc_tipo_valor",descTipoValor);
    if (nroTarjeta!=null)
    	dataset.fieldValue("nro_tarjeta",nroTarjeta);
    else
    	dataset.fieldValue("nro_tarjeta","");
    if (nro!=null)
    	dataset.fieldValue("nro",nro);
    else
    	dataset.fieldValue("nro",new Integer(0));
    
    dataset.fieldValue("cod_entidad",codigoEntidad);
    
    if (descEntidad!=null)
    	dataset.fieldValue("desc_entidad",descEntidad);
    else
    	dataset.fieldValue("desc_entidad","");
    if (razonSocial!=null)
    	dataset.fieldValue("razon_social",razonSocial);
    else
    	dataset.fieldValue("razon_social","");
    dataset.fieldValue("oid_moneda",oidMoneda);
    dataset.fieldValue("cod_moneda",codMoneda);
    dataset.fieldValue("desc_moneda",descMoneda);
    if (fecEmision!=null)
    	dataset.fieldValue("fec_emision",fecEmision);
    else
    	dataset.fieldValue("fec_emision",Fecha.FECHA_NULA());
    if (fecVto!=null)
    	dataset.fieldValue("fec_vto",fecVto);
    else
    	dataset.fieldValue("fec_vto",Fecha.FECHA_NULA());
    if (importe!=null)
    	dataset.fieldValue("importe",importe);
    else
    	dataset.fieldValue("importe",new Integer(0));
    if (cupon!=null)
    	dataset.fieldValue("cupon",cupon);
    else
    	dataset.fieldValue("cupon",new Integer(0));
    if (lote!=null)
    	dataset.fieldValue("lote",lote);
    else
    	dataset.fieldValue("lote",new Integer(0));
    if (cuotas!=null)
    	dataset.fieldValue("cuotas",cuotas);
    else
    	dataset.fieldValue("cuotas",new Integer(0));
    dataset.fieldValue("comprobante", comprobante);
    if (fecha!=null)
    	dataset.fieldValue("fecha",fecha);
    else
    	dataset.fieldValue("fecha",Fecha.FECHA_NULA());
    dataset.fieldValue("nro_certificado", nroCertificado);
    dataset.fieldValue("provincia", provincia);
    dataset.fieldValue("codigo_autorizacion", codigoAutorizacion);
    dataset.fieldValue("cuit", cuit);
    dataset.fieldValue("nro_valor", nroValor);
    dataset.fieldValue("oid_cco",oidCCO);
    dataset.fieldValue("oid_caja",oidCaja);
    
  }
  
  private void traerConsPorDetalleComprobante(
  		Caja caja,
  		Date fechaDesde,
  		Date fechaHasta,
  		TipoValor aTipoValor,
  		TipoComprobante tc) 
  throws BaseException {
	  IDataSet ds = getDataSetValoresEnCaja();
	  Iterator iterTiposValores = TipoValor.getAllTiposValores(getSesion()).iterator();
	  while (iterTiposValores.hasNext()) {
		TipoValor tipoValor = (TipoValor) iterTiposValores.next();
		
		if (aTipoValor!=null) 
			if (aTipoValor.getOID() != tipoValor.getOID()) continue;
		
		Iterator iterMovCaja = MovimientoCaja.getMovCajaFecDesdeHasta(caja,tipoValor,fechaDesde,fechaHasta,getSesion()).iterator();
		
		// Cargar el saldo Inicial y Final
		// Saldo Inicial 
		SaldoTipoValor saldoTipoValorFecDesde = SaldoTipoValor.getSaldoTipoValor(caja,fechaDesde,tipoValor,getSesion());
		SaldoTipoValor saldoTipoValorFecHasta = SaldoTipoValor.getSaldoTipoValor(caja,fechaHasta,tipoValor,getSesion());
		
		Money saldoInicial = new Money(0);
		if (saldoTipoValorFecDesde!=null)
			saldoInicial = saldoTipoValorFecDesde.getSaldo_inicial();
		
		Money saldoFinal = new Money(0);
		if (saldoTipoValorFecHasta!=null)
			saldoFinal = saldoTipoValorFecHasta.getSaldo_final();
		
		if (tc==null)
			cargarRegistroValoresEnCaja(ds,
				new Integer(++secu),
				new Integer(0),
				tipoValor.getOIDInteger(),
				tipoValor.getCodigo(),
				new Integer(0),
				tipoValor.getDescripcion(),
				"",
				new Integer("0"),
				"",
				"",
				"",
				tipoValor.getMoneda().getOIDInteger(),
				tipoValor.getMoneda().getCodigo(),
				tipoValor.getMoneda().getDescripcion(),
				null,null,
				saldoInicial,null,null,null,
				"Saldo Inicial",
				fechaDesde,
				"",
				"",
				"",
				"",
				"",
				new Integer(0),
				caja.getOIDInteger());
		
		while (iterMovCaja.hasNext()) {
			MovimientoCaja movimientoCaja = (MovimientoCaja) iterMovCaja.next();
			Integer oidValor = new Integer(0);
			String nroTarjeta = new String("");
			Integer nro = new Integer(0);
			String razonSocial = new String();
			java.util.Date fecEmision = null;
			java.util.Date fecVto = null;
			Integer cupon = new Integer(0);
			Integer lote = new Integer(0);
			Integer cuotas = new Integer(0);
			String codEntidad = "";
			String descEntidad = "";
			String nroCertificado = "";
			String provincia = "";
			String codigoAutorizacion = "";
			String cuit = "";
			String nroValorGeneral = "";
			
			if (movimientoCaja.getValor()!=null) {
				
				oidValor = movimientoCaja.getValor().getOIDInteger();
				nroTarjeta = movimientoCaja.getValor().getNro_tarjeta();
				nro = movimientoCaja.getValor().getNro_valor();
				fecEmision = movimientoCaja.getValor().getFechaemision();
				fecVto = movimientoCaja.getValor().getFechavto();
				cupon = movimientoCaja.getValor().getCupon();
				lote = movimientoCaja.getValor().getLote();
				cuit = movimientoCaja.getValor().getCUIT();
				cuotas = movimientoCaja.getValor().getCuotas();
				nroCertificado = movimientoCaja.getValor().getNroCertificado();
				codigoAutorizacion = movimientoCaja.getValor().getCodigoAutorizacion();
				nroValorGeneral = movimientoCaja.getValor().getNroValorGenerico();
				
				if (movimientoCaja.getValor().getDescEntidad()!=null) {
					descEntidad = movimientoCaja.getValor().getDescEntidad();
					codEntidad = movimientoCaja.getValor().getCodEntidad();
				}
				
				if (movimientoCaja.getValor().getSujeto()!=null)
					razonSocial = movimientoCaja.getValor().getSujeto().getRazon_social();
				
				if (movimientoCaja.getValor().getTipovalor().isChequeCliente() || movimientoCaja.getValor().getTipovalor().isChequeTercero()) {
					descEntidad = movimientoCaja.getValor().getBanco().getDescripcion();
				  nro = movimientoCaja.getValor().getNrocheque();
				}
				
				if (movimientoCaja.getValor().getProvincia()!=null)
					provincia = movimientoCaja.getValor().getProvincia().getDescripcion();
				
			}
			
			double importe = movimientoCaja.getImporte().doubleValue() * movimientoCaja.getSigno().intValue(); 
			
			
			if ((tc!=null) && (movimientoCaja.getComprobante().getTipoCompro().getOID() != tc.getOID()))
				continue;
			
			
			Integer oidCaja = null;
			if ((movimientoCaja.getValor()!=null) && (movimientoCaja.getValor().getCaja()!=null))
				oidCaja = movimientoCaja.getValor().getCaja().getOIDInteger(); 
			
			cargarRegistroValoresEnCaja(ds,
					new Integer(++secu),
					new Integer(1),
					tipoValor.getOIDInteger(),
					tipoValor.getCodigo(),
					oidValor,
					movimientoCaja.getTipovalor().getDescripcion(),
					nroTarjeta,
					nro,
					codEntidad,
					descEntidad,					
					razonSocial,
					tipoValor.getMoneda().getOIDInteger(),
					tipoValor.getMoneda().getCodigo(),
					tipoValor.getMoneda().getDescripcion(),
					fecEmision,fecVto,
					new Money(importe),cupon,lote,cuotas,
					movimientoCaja.getComprobante().getCodigo(),
					movimientoCaja.getFechacaja(),
					nroCertificado,
					provincia,
					codigoAutorizacion,
					cuit,
					nroValorGeneral,
					movimientoCaja.getComprobante().getOIDInteger(),
					oidCaja
					);
					
					
					
		}
		
		
		if (tc==null)
			cargarRegistroValoresEnCaja(ds,
				new Integer(++secu),
				new Integer(0),
				tipoValor.getOIDInteger(),
				tipoValor.getCodigo(),
				new Integer(0),
				tipoValor.getDescripcion(),
				"",
				new Integer("0"),
				"",
				"",
				"",
				tipoValor.getMoneda().getOIDInteger(),
				tipoValor.getMoneda().getCodigo(),
				tipoValor.getMoneda().getDescripcion(),
				null,null,
				saldoFinal,null,null,null,
				"Saldo Final",
				fechaHasta,"","","","","", new Integer(0),0);
		
		
		
	  }
	  writeCliente(ds);
  }
  
  private void traerConsPorTipoCompro(Caja caja,Date fechaDesde,Date fechaHasta) throws BaseException {
	  IDataSet dsConsTipoCompro = getDataSetConsTipoCompro();
	  Date fecha = fechaDesde;
	  while (!fecha.after(fechaHasta)) { 
		 enviarMovDiaPorTipoCompro(dsConsTipoCompro,caja,fecha,fechaDesde,fechaHasta);
	  	 fecha = Fecha.getFechaMasDias(fecha,1);
	  }
	  
	  // Cargar Saldos Iniciales y Finales por TC
	  enviarSaldosInicialesFinalesPorTC(dsConsTipoCompro,caja,fechaDesde,fechaHasta);
			  
	  writeCliente(dsConsTipoCompro);
  }
  
  private void traerConsPorTipoComproResumido(Caja caja,Date fechaDesde,Date fechaHasta) throws BaseException {
	  IDataSet dsConsTipoCompro = getDataSetConsTipoComproResumida();
	  
	  // Caragr Movimientos Resumidos por TC
	  enviarMovResumidosPorTC(dsConsTipoCompro,caja,fechaDesde,fechaHasta);
	  
	  writeCliente(dsConsTipoCompro);
  }
  
  private void enviarMovResumidosPorTC(IDataSet dsConsTipoCompro,Caja caja,Date fechaDesde,Date fechaHasta) throws BaseException {
	  Iterator iterTiposValores = TipoValor.getAllTiposValores(getSesion()).iterator();
	  while (iterTiposValores.hasNext()) {
		TipoValor tipoValor = (TipoValor) iterTiposValores.next();
		
		// Saldo Inicial 
		SaldoTipoValor saldoTipoValorFecDesde = SaldoTipoValor.getSaldoTipoValor(caja,fechaDesde,tipoValor,getSesion());
		Money saldoInicial = new Money(0);
		if (saldoTipoValorFecDesde!=null)
			saldoInicial = saldoTipoValorFecDesde.getSaldo_inicial();
		
		cargarRegistroConsTipoComproResumida(dsConsTipoCompro,
                new Integer(++secu),
                new Integer(0),
                tipoValor.getMoneda().getOIDInteger(),
                tipoValor.getOIDInteger(),
                new Integer(0),
                "Saldo Inicial",
                saldoInicial);
		
		// Saldo Final		
		SaldoTipoValor saldoTipoValorFecHasta = SaldoTipoValor.getSaldoTipoValor(caja,fechaHasta,tipoValor,getSesion());
		Money saldoFinal = new Money(0);
		if (saldoTipoValorFecHasta!=null)
			saldoFinal = saldoTipoValorFecHasta.getSaldo_final();
				
		cargarRegistroConsTipoComproResumida(dsConsTipoCompro,
                new Integer(++secu),
                new Integer(2),
                tipoValor.getMoneda().getOIDInteger(),
                tipoValor.getOIDInteger(),
                new Integer(2),
                "Saldo Final",
                saldoFinal);
		
		// Movimientos Resumidos por TC
		Iterator iterMovResuTipoCompo = 
			MovCajaDiaTipoCompro.getMovDiaTiposComproEntreFechas(caja,tipoValor,fechaDesde,fechaHasta,getSesion()).iterator();
		while (iterMovResuTipoCompo.hasNext()) {
			MovCajaDiaTipoCompro movCajaDiaTipoCompro = (MovCajaDiaTipoCompro) iterMovResuTipoCompo.next();
			cargarRegistroConsTipoComproResumida(dsConsTipoCompro,
	                new Integer(++secu),
	                new Integer(1),
	                tipoValor.getMoneda().getOIDInteger(),
	                tipoValor.getOIDInteger(),
	                movCajaDiaTipoCompro.getTipo_comprobante().getOIDInteger(),
	                movCajaDiaTipoCompro.getTipo_comprobante().getDescripcion(),
	                movCajaDiaTipoCompro.getImporte());
			
		}
		
		
	  }
	  
  }
  
  
  private void traerConsResumida(Caja caja,Date fechaDesde,Date fechaHasta) throws BaseException {
	  IDataSet dsResumida = getDataSetConsResumida();
	  Date fecha = fechaDesde;
	  while (!fecha.after(fechaHasta)) { 
		 enviarSaldosResumidosAFecha(dsResumida,caja,fecha);
	  	 fecha = Fecha.getFechaMasDias(fecha,1);
	  }
	  writeCliente(dsResumida);
  }
  
  private void enviarSaldosInicialesFinalesPorTC(IDataSet dsMovDiaPorTipoCompro,
		  										 Caja caja,
		  										 Date fechaDesde,Date fechaHasta) throws BaseException {
	  Iterator iterTiposValores = TipoValor.getAllTiposValores(getSesion()).iterator();
	  while (iterTiposValores.hasNext()) {
		TipoValor tipoValor = (TipoValor) iterTiposValores.next();
		
		// Saldo Inicial 
		SaldoTipoValor saldoTipoValorFecDesde = SaldoTipoValor.getSaldoTipoValor(caja,fechaDesde,tipoValor,getSesion());
		Money saldoInicial = new Money(0);
		if (saldoTipoValorFecDesde!=null)
			saldoInicial = saldoTipoValorFecDesde.getSaldo_inicial();
		
		cargarRegistroConsTipoCompro(dsMovDiaPorTipoCompro,
                new Integer(++secu),
                new Integer(0),
                tipoValor.getMoneda().getOIDInteger(),
                tipoValor.getOIDInteger(),
                fechaDesde,
                new Integer(0),
                "Saldo Inicial",
                saldoInicial);
		
		// Saldo Final		
		SaldoTipoValor saldoTipoValorFecHasta = SaldoTipoValor.getSaldoTipoValor(caja,fechaHasta,tipoValor,getSesion());
		Money saldoFinal = new Money(0);
		if (saldoTipoValorFecHasta!=null)
			saldoFinal = saldoTipoValorFecHasta.getSaldo_final();
				
		cargarRegistroConsTipoCompro(dsMovDiaPorTipoCompro,
                new Integer(++secu),
                new Integer(2),
                tipoValor.getMoneda().getOIDInteger(),
                tipoValor.getOIDInteger(),
                fechaHasta,
                new Integer(2),
                "Saldo Final",
                saldoFinal);
	  }
	  
  }
		  
  private void enviarMovDiaPorTipoCompro(IDataSet dsMovDiaPorTipoCompro,
		  								 Caja caja,
		  								 Date fecha,
		  								 Date fechaDesde,
		  								 Date fechaHasta) throws BaseException {
	  Iterator iterTiposValores = TipoValor.getAllTiposValores(getSesion()).iterator();
	  while (iterTiposValores.hasNext()) {
		TipoValor tipoValor = (TipoValor) iterTiposValores.next();
		
		Iterator iterMovDiaPorTC = MovCajaDiaTipoCompro.getMovDiaTiposComprobantes(caja,tipoValor,fecha,getSesion()).iterator();
		while (iterMovDiaPorTC.hasNext()) {
			MovCajaDiaTipoCompro movDia = (MovCajaDiaTipoCompro) iterMovDiaPorTC.next();
			cargarRegistroConsTipoCompro(dsMovDiaPorTipoCompro,
					                     new Integer(++secu),
					                     new Integer(1),
					                     tipoValor.getMoneda().getOIDInteger(),
					                     tipoValor.getOIDInteger(),
					                     fecha,
					                     movDia.getTipo_comprobante().getOIDInteger(),
					                     movDia.getTipo_comprobante().getDescripcion(),
					                     movDia.getImporte());
		}
	  }
		
  }
  
  private void enviarSaldosResumidosAFecha(IDataSet dsResumida,Caja caja,Date fecha) throws BaseException {
	  Iterator iterTiposValores = TipoValor.getAllTiposValores(getSesion()).iterator();
	  while (iterTiposValores.hasNext()) {
		TipoValor tipoValor = (TipoValor) iterTiposValores.next();
		SaldoTipoValor saldoTipoValor = SaldoTipoValor.getSaldoTipoValor(caja,fecha,tipoValor,getSesion());
		if (saldoTipoValor!=null) {
			cargarRegistroResumida(dsResumida,
								   new Integer(++secu),tipoValor.getMoneda().getOIDInteger(),
								   tipoValor.getOIDInteger(),fecha,
					               saldoTipoValor.getSaldo_inicial(),
					               saldoTipoValor.getEntradas(),
					               saldoTipoValor.getSalidas(),
					               saldoTipoValor.getSaldo_final());
		} else {
			cargarRegistroResumida(dsResumida,
					   new Integer(++secu),tipoValor.getMoneda().getOIDInteger(),
					   tipoValor.getOIDInteger(),fecha,
		               new Money(0),
		               new Money(0),
		               new Money(0),
		               new Money(0));
			
		}
		  
	  }
  }
  
  private void traerValoresEnCaja(Caja caja,MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = getDataSetValoresEnCaja();
	  int secu = 0;
	  
	  
	  TipoValor tipoValor = null;
	  if (mapaDatos.containsKey("oid_tipo_valor")) 
		  tipoValor = TipoValor.findByOidProxy(mapaDatos.getInteger("oid_tipo_valor"), this.getSesion());
	  // Obtener los tipos de Valores segun forma de Pago
	  List tiposValores = null;
	  if (mapaDatos.containsKey("oid_forma_pago")) {
		  tiposValores = new ArrayList();
		  FormaPago formaPago = FormaPago.findByOid(mapaDatos.getInteger("oid_forma_pago"), this.getSesion());
		  Iterator iterTiposValores =
			  formaPago.getTiposValores().iterator();
		  while (iterTiposValores.hasNext()) {
			  TipoValorFormaPago tipoValorFormaPago = 
				  (TipoValorFormaPago) iterTiposValores.next();
			  tiposValores.add(tipoValorFormaPago.getTipovalor());
		  }
	  }
	  
	  // Traer el efectivo
	  Iterator iterSaldoEfectivo = SaldoEfectivo.getSaldosEfectivo(caja,getSesion()).iterator();
	  while (iterSaldoEfectivo.hasNext()) {
		  SaldoEfectivo saldoEfectivo = (SaldoEfectivo) iterSaldoEfectivo.next();
		  
		  boolean okEfectivo = true;
		  if (tiposValores!=null) {
			  okEfectivo = false;
			  Iterator iterTipoValores =
				  tiposValores.iterator();
			  while (iterTipoValores.hasNext()) {
				  TipoValor tv = (TipoValor) iterTipoValores.next();
				  if (tv.getOID() == saldoEfectivo.getTipo_valor().getOID() ) {
					  okEfectivo = true;
					  break;
				  }
			  }
		  } 
		  
		  if (okEfectivo == false) continue;
		  
		  if ((tipoValor!=null) && (saldoEfectivo.getTipo_valor().getOID()!=tipoValor.getOID())) continue;
		  
		  cargarRegistroValoresEnCaja(ds,new Integer(++secu),new Integer(1),
				                      saldoEfectivo.getTipo_valor().getOIDInteger(),
				                      saldoEfectivo.getTipo_valor().getCodigo(),
				                      new Integer(0),
				                      saldoEfectivo.getTipo_valor().getDescripcion(),
				                      new String(""),
				                      new Integer(0),saldoEfectivo.getCaja().getCodigo(),
				                      saldoEfectivo.getTipo_valor().getDescripcion(),
				                      new String(""),
				                      saldoEfectivo.getMoneda().getOIDInteger(),
				                      saldoEfectivo.getMoneda().getCodigo(),
				                      saldoEfectivo.getMoneda().getDescripcion(),
				                      null,null,saldoEfectivo.getSaldo(), 
				                      new Integer(0),new Integer(0), new Integer(0),"",null,"","","","","", new Integer(0),saldoEfectivo.getCaja().getOIDInteger());
	  }
	  
	  
	  Iterator iterValores = Valor.getValoresEnCaja(caja,null,tipoValor,tiposValores,this.getSesion()).iterator();
	  while (iterValores.hasNext()) {
	  	Valor valor = (Valor) iterValores.next();
	  	String provincia = "";
	  	if (valor.getProvincia()!=null)
	  		provincia = valor.getProvincia().getDescripcion();
	  	
	  	String razonSocial = "";
	  	if (valor.getSujeto()!=null)
	  		razonSocial = valor.getSujeto().getRazon_social();
	  	
	  	
	  	Integer oidCaja = 0; 
	  	if (valor.getCaja()!=null)
	  		oidCaja = valor.getCaja().getOIDInteger(); 
	  	
		  cargarRegistroValoresEnCaja(ds,new Integer(++secu),new Integer(1),
          valor.getTipovalor().getOIDInteger(),
          valor.getTipovalor().getCodigo(),
          valor.getOIDInteger(),
          valor.getTipovalor().getDescripcion(),
          valor.getNro_tarjeta(),
          valor.getNroValorGenericoNumerico(),
          valor.getCodEntidad(),
          valor.getDescEntidad(),
          razonSocial,
          valor.getTipovalor().getMoneda().getOIDInteger(),
          valor.getTipovalor().getMoneda().getCodigo(),
          valor.getTipovalor().getMoneda().getDescripcion(),
          valor.getFechaemision(),valor.getFechavto(),valor.getSaldo(),
          valor.getCupon(), valor.getLote(), valor.getCuotas() , 
          "", null, valor.getNroCertificado(),provincia,valor.getCodigoAutorizacion(),
          valor.getCUIT(),valor.getNroValorGenerico(),
          new Integer(0),oidCaja);		  
	  	
	  }
		  
	  writeCliente(ds);
  }
  
}
