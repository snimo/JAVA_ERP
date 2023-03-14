package com.srn.erp.tesoreria.op;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.SaldoEfectivo;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresADepositar extends Operation {
 
	
	HashTableDatos listaCotizaciones = null;
	List listaTipoValores = new ArrayList();
	Moneda monedaLocal = null;
	
  public TraerValoresADepositar() {
  }
  
  private boolean isExisteEnListaTiposValores(TipoValor aTipoValor) throws BaseException {
  	Iterator iterTiposValores = listaTipoValores.iterator();
  	while (iterTiposValores.hasNext()) {
  		TipoValor tipoValor = (TipoValor) iterTiposValores.next();
  		if (tipoValor.getOID() == aTipoValor.getOID())
  			return true;
  	}
  	return false;
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  Caja caja = Caja.findByOid(mapaDatos.getInteger("oid_caja"),getSesion());
	  listaCotizaciones = this.getCotizacionesPorTipoValor(mapaDatos);
		traerValoresEnCaja(caja);	  		  
  }
  
  public HashTableDatos getCotizacionesPorTipoValor(MapDatos mapaDatos) throws BaseException {
  	HashTableDatos listaCotizaciones = new HashTableDatos();
  	IDataSet ds = mapaDatos.getDataSet("TTiposValores");
  	ds.first();
  	while (!ds.EOF()) {
  		TipoValor tipoValor = TipoValor.findByOid(ds.getInteger("oid_tipo_valor"),this.getSesion());
  		if (ds.getBoolean("sel").booleanValue())
  			listaTipoValores.add(tipoValor);
  		ValorCotizacion cotizacion = ds.getCotizacion("cotizacion");
  		listaCotizaciones.put(tipoValor.getOIDInteger(),cotizacion);
  		ds.next();
  	}
  	return listaCotizaciones;
  }
  
  private ValorCotizacion getValorCotizacion(TipoValor tipoValor) throws BaseException {
  	ValorCotizacion valorCotiz = (ValorCotizacion)listaCotizaciones.get(tipoValor.getOIDInteger());
  	if (valorCotiz == null)
  		throw new ExceptionValidation(null,
  				"No se pudo obtener la cotización para la moneda "+tipoValor.getMoneda().getDescripcion());
  	return valorCotiz;
  }
  

  private IDataSet getDataSetValoresEnCaja() {
    IDataSet dataset = new TDataSet();
    dataset.create("TBoletaDepositoValores");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_valor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_valor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_tipo_valor",Field.STRING, 50));
    dataset.fieldDef(new Field("nro_tarjeta",Field.STRING, 50));
    dataset.fieldDef(new Field("nro",Field.INTEGER, 0));
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
    dataset.fieldDef(new Field("cotizacion",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("modif_importe",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_caja",Field.INTEGER, 0));
    dataset.fieldDef(new Field("modif_cotizacion",Field.BOOLEAN, 0));
    return dataset;
  }
  
  

  private void cargarRegistroValoresEnCaja(IDataSet dataset,
                         Integer secu,
                         Integer orden,
                         Integer oidTipoValor,
                         Integer oidValor,
                         String descTipoValor,
                         String nroTarjeta,
                         Integer nro,
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
                         ValorCotizacion cotizacion,
                         Boolean modifImporte,
                         Caja caja) throws BaseException { 
    dataset.append();
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("orden", orden);
    dataset.fieldValue("oid_tipo_valor",oidTipoValor);
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
    dataset.fieldValue("cotizacion", cotizacion);
    dataset.fieldValue("modif_importe", modifImporte);
    dataset.fieldValue("oid_caja", caja.getOIDInteger());
    
    if (this.getMonedaLocal().getOID() == oidMoneda.intValue())
    	 dataset.fieldValue("modif_cotizacion", new Boolean(false));
    else
    	 dataset.fieldValue("modif_cotizacion", new Boolean(true));
    
  }
  
  private void traerValoresEnCaja(Caja caja) throws BaseException {
	  IDataSet ds = getDataSetValoresEnCaja();
	  int secu = 0;
	  
    
	  // Traer el efectivo
	  Iterator iterSaldoEfectivo = SaldoEfectivo.getSaldosEfectivo(caja,getSesion()).iterator();
	  while (iterSaldoEfectivo.hasNext()) {
		  SaldoEfectivo saldoEfectivo = (SaldoEfectivo) iterSaldoEfectivo.next();
		  if (!isExisteEnListaTiposValores(saldoEfectivo.getTipo_valor())) continue;
		  
		  cargarRegistroValoresEnCaja(ds,new Integer(++secu),new Integer(1),
				                      saldoEfectivo.getTipo_valor().getOIDInteger(),
				                      new Integer(0),
				                      saldoEfectivo.getTipo_valor().getDescripcion(),
				                      new String(""),
				                      new Integer(0),"",
				                      new String(""),
				                      saldoEfectivo.getMoneda().getOIDInteger(),
				                      saldoEfectivo.getMoneda().getCodigo(),
				                      saldoEfectivo.getMoneda().getDescripcion(),
				                      null,
				                      null,
				                      saldoEfectivo.getSaldo(), 
				                      new Integer(0),
				                      new Integer(0), 
				                      new Integer(0),"",null,"","","","",
				                      this.getValorCotizacion(saldoEfectivo.getTipo_valor()),
				                      new Boolean(true),
				                      caja);
	  }
	  
	  
	  Iterator iterValores = Valor.getValoresEnCaja(caja,null,this.listaTipoValores,this.getSesion()).iterator();
	  while (iterValores.hasNext()) {
	  	Valor valor = (Valor) iterValores.next();
	  	String provincia = "";
	  	if (valor.getProvincia()!=null)
	  		provincia = valor.getProvincia().getDescripcion();
	  	
	  	String razonSocial = "";
	  	if (valor.getSujeto()!=null)
	  		razonSocial = valor.getSujeto().getRazon_social(); 
		  cargarRegistroValoresEnCaja(ds,new Integer(++secu),new Integer(1),
          valor.getTipovalor().getOIDInteger(),
          valor.getOIDInteger(),
          valor.getTipovalor().getDescripcion(),
          valor.getNro_tarjeta(),
          valor.getNrocheque(),valor.getDescEntidad(),
          razonSocial,
          valor.getTipovalor().getMoneda().getOIDInteger(),
          valor.getTipovalor().getMoneda().getCodigo(),
          valor.getTipovalor().getMoneda().getDescripcion(),
          valor.getFechaemision(),valor.getFechavto(),valor.getImporte(),
          valor.getCupon(), valor.getLote(), valor.getCuotas() , 
          "", null, valor.getNroCertificado(),provincia,valor.getCodigoAutorizacion(),
          valor.getCUIT(),
          this.getValorCotizacion(valor.getTipovalor()),
          new Boolean(false),
          caja);		  
	  	
	  }
		  
	  writeCliente(ds);
  }
  
  private Moneda getMonedaLocal() throws BaseException {
  	if (this.monedaLocal != null)
  		return monedaLocal;
  	
  	monedaLocal = Moneda.getMonedaCursoLegal(this.getSesion());
  	return monedaLocal; 
  		
  }
  
  
}
