package com.srn.erp.bancos.op;

import java.util.Iterator;

import com.srn.erp.bancos.bm.BoletaDeposito;
import com.srn.erp.bancos.bm.BoletaDepositoDet;
import com.srn.erp.bancos.bm.GastoBoletaDeposito;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerBoletaDeposito extends Operation {

  public TraerBoletaDeposito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	Integer oid = mapaDatos.getInteger("oid");
		BoletaDeposito boleta = BoletaDeposito.findByOid(oid, getSesion());
		
		IDataSet dsBoleta = this.getDSBoleta();
		IDataSet dsBoletaVal = this.getDSBoletaValores();
		IDataSet dsboletaGastos = this.getDSBoletaGastos();
		IDataSet dsTalonarios = this.getDataSetTalonarios();
		
		cargarTalonario(dsTalonarios,boleta.getTalonario());
		cargarRegBoleta(dsBoleta,boleta);
		
		Iterator iterBolDepDet = 
			boleta.getDetallesBolDep().iterator();
		while (iterBolDepDet.hasNext()) {
			BoletaDepositoDet bolDepDet = (BoletaDepositoDet) iterBolDepDet.next();
			cargarRegistrovalores(dsBoletaVal,bolDepDet);
		}
		
		Iterator iterGastosBolDep = 
			boleta.getGastosBoletaDepoito().iterator();
		while (iterGastosBolDep.hasNext()) {
			GastoBoletaDeposito gastoBoletaDeposito = (GastoBoletaDeposito) iterGastosBolDep.next();
			cargarRegistroGastos(dsboletaGastos,gastoBoletaDeposito);
		}
		
		writeCliente(dsTalonarios);
		writeCliente(dsBoleta);
		writeCliente(dsBoletaVal);
		writeCliente(dsboletaGastos);
  }
  
  private void cargarRegistroGastos(IDataSet ds,GastoBoletaDeposito gastoBoleta) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid_gasto_bd", gastoBoleta.getOIDInteger());
  	ds.fieldValue("oid_boleta_dep", gastoBoleta.getBoleta_deposito().getOIDInteger());
  	ds.fieldValue("debe", gastoBoleta.getDebe());
  	ds.fieldValue("haber", gastoBoleta.getHaber());
  	ds.fieldValue("comentario", gastoBoleta.getComentario());
  	ds.fieldValue("codigo_ana_imp", gastoBoleta.getCuenta_imputable().getCodigoCuentaMasCodigosValCompo());
  	ds.fieldValue("oid_ai", gastoBoleta.getCuenta_imputable().getOIDInteger());
  	ds.fieldValue("desc_ana_imp", gastoBoleta.getCuenta_imputable().getDescCuentaMasDescValCompo());
  	ds.fieldValue("secu",gastoBoleta.getOIDInteger());
  }
  
  
  private IDataSet getDSBoletaGastos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TGastoBoletaDeposito");
    dataset.fieldDef(new Field("oid_gasto_bd", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_boleta_dep", Field.INTEGER, 0));
    dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    dataset.fieldDef(new Field("codigo_ana_imp", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_ana_imp", Field.STRING, 255));
    dataset.fieldDef(new Field("secu",Field.INTEGER, 0));
    return dataset;
  }
  
  
  private IDataSet getDSBoletaValores() {
    IDataSet dataset = new TDataSet();
    dataset.create("TBoletaDepositoValores");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 50));
    dataset.fieldDef(new Field("nro", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_entidad", Field.STRING, 255));
    dataset.fieldDef(new Field("razon_social", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_moneda", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_moneda", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_vto", Field.DATE, 0));
    dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cupon", Field.INTEGER, 0));
    dataset.fieldDef(new Field("lote", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cuotas", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("nro_certificado", Field.STRING, 50));
    dataset.fieldDef(new Field("provincia", Field.STRING, 50));
    dataset.fieldDef(new Field("codigo_autorizacion", Field.STRING, 50));
    dataset.fieldDef(new Field("cuit", Field.STRING, 20));
    dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("importe_mon_cta", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_caja",Field.INTEGER, 0));
    return dataset;
  }
  
  private void cargarRegistrovalores(IDataSet ds,BoletaDepositoDet bolDepDet) throws BaseException {
  	ds.append();
  	ds.fieldValue("secu", bolDepDet.getOIDInteger());
  	ds.fieldValue("orden", bolDepDet.getOIDInteger());
  	ds.fieldValue("oid_tipo_valor", bolDepDet.getTipo_valor().getOIDInteger());
  	if (bolDepDet.getValor()!=null)
  		ds.fieldValue("oid_valor", bolDepDet.getValor().getOIDInteger());
  	else
  		ds.fieldValue("oid_valor", new Integer(0));
  	ds.fieldValue("desc_tipo_valor", bolDepDet.getTipo_valor().getDescripcion());
  	if (bolDepDet.getValor()!=null) {
  		ds.fieldValue("nro_tarjeta", bolDepDet.getValor().getNro_tarjeta());
  		ds.fieldValue("nro", bolDepDet.getValor().getNro_valor());
  		ds.fieldValue("desc_entidad", bolDepDet.getValor().getDescEntidad());
  		if (bolDepDet.getValor().getSujeto()!=null)
  			ds.fieldValue("razon_social", bolDepDet.getValor().getSujeto().getRazon_social());
  		else
  			ds.fieldValue("razon_social", "");
  	} else {
  		ds.fieldValue("nro_tarjeta", "");
  		ds.fieldValue("nro", "");
  		ds.fieldValue("desc_entidad", "");
  		ds.fieldValue("razon_social", "");
  	}
  	ds.fieldValue("oid_moneda", bolDepDet.getTipo_valor().getMoneda().getOIDInteger());
  	ds.fieldValue("cod_moneda", bolDepDet.getTipo_valor().getMoneda().getCodigo());
  	ds.fieldValue("desc_moneda", bolDepDet.getTipo_valor().getMoneda().getDescripcion());
  	
  	if (bolDepDet.getValor()!=null) {
  		ds.fieldValue("fec_emision", bolDepDet.getValor().getFechaemision());
  		ds.fieldValue("fec_vto", bolDepDet.getValor().getFechavto());
  	} else {
  		ds.fieldValue("fec_emision", Fecha.FECHA_NULA());
  		ds.fieldValue("fec_vto", Fecha.FECHA_NULA());
  	}
  	ds.fieldValue("importe", bolDepDet.getImpoMonValor());
  	if (bolDepDet.getValor()!=null) {
  		ds.fieldValue("cupon", bolDepDet.getValor().getCupon());
  		ds.fieldValue("lote", bolDepDet.getValor().getLote());
  		ds.fieldValue("cuotas", bolDepDet.getValor().getCuotas());
  		ds.fieldValue("comprobante", "");
  		ds.fieldValue("fecha", bolDepDet.getValor().getFechaemision());
  		ds.fieldValue("nro_certificado", bolDepDet.getValor().getNroCertificado());
  		if (bolDepDet.getValor().getProvincia()!=null)
  				ds.fieldValue("provincia", bolDepDet.getValor().getProvincia().getDescripcion());
  		else
  			  ds.fieldValue("provincia", "");
  		ds.fieldValue("codigo_autorizacion", bolDepDet.getValor().getCodigoAutorizacion());
  		ds.fieldValue("cuit", bolDepDet.getValor().getCUIT());
  	} else {
  		ds.fieldValue("cupon", "");
  		ds.fieldValue("lote", "");
  		ds.fieldValue("cuotas", "");
  		ds.fieldValue("comprobante", "");
  		ds.fieldValue("fecha", "");
  		ds.fieldValue("nro_certificado", "");
  		ds.fieldValue("provincia", "");
  		ds.fieldValue("codigo_autorizacion", "");
  		ds.fieldValue("cuit", "");
  	}
  	ds.fieldValue("cotizacion", bolDepDet.getCotizacion());
  	ds.fieldValue("importe_mon_cta", bolDepDet.getImporte());
  	ds.fieldValue("oid_caja",bolDepDet.getCaja().getOIDInteger());
  	
  }
  

  private IDataSet getDSBoleta() {
    IDataSet dataset = new TDataSet();
    dataset.create("TBoletaDeposito");
    dataset.fieldDef(new Field("oid_boleta_dep", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_deposito", Field.DATE, 0));
    dataset.fieldDef(new Field("clearing", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cta_bancaria", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cta_bancaria", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_cta_bancaria", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tc", Field.STRING, 50));
    dataset.fieldDef(new Field("letra", Field.STRING, 1));
    dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("cod_moneda", Field.STRING, 10));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("monto_deposito", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("gastos", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("neto_deposito", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_caja", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_caja", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_moneda", Field.STRING, 100));
    return dataset;
  }
  
  private void cargarRegBoleta(IDataSet ds,BoletaDeposito boleta) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid_boleta_dep", boleta.getOIDInteger());
  	ds.fieldValue("fec_deposito", boleta.getEmision());
  	ds.fieldValue("clearing", boleta.getClearing());
  	ds.fieldValue("oid_cta_bancaria", boleta.getCuenta_bancaria().getOIDInteger());
  	ds.fieldValue("cod_cta_bancaria", boleta.getCuenta_bancaria().getCodigo());
  	ds.fieldValue("desc_cta_bancaria", boleta.getCuenta_bancaria().getDescripcion());
  	ds.fieldValue("oid_moneda", boleta.getMoneda().getOIDInteger());
  	ds.fieldValue("cotizacion", boleta.getCotizacion());
  	ds.fieldValue("oid_tc", boleta.getTipoCompro().getOIDInteger());
  	ds.fieldValue("cod_tc", boleta.getTipoCompro().getCodigo());
  	ds.fieldValue("letra", boleta.getLetra());
  	ds.fieldValue("oid_lug_emi", boleta.getLugarEmision().getOIDInteger());
  	ds.fieldValue("lug_emi", boleta.getLugarEmision().getLugemi());
  	ds.fieldValue("nro_ext", boleta.getNroExt());
  	ds.fieldValue("oid_talonario", boleta.getTalonario().getOIDInteger());
  	ds.fieldValue("fec_emision", boleta.getEmision());
  	ds.fieldValue("cod_moneda", boleta.getMoneda().getCodigo());
  	ds.fieldValue("comentario", boleta.getComentario());
  	ds.fieldValue("activo", boleta.isActivo());
  	ds.fieldValue("monto_deposito", boleta.getMontoDeposito());
  	ds.fieldValue("gastos", boleta.getGastos());
  	ds.fieldValue("neto_deposito", boleta.getNetoDeposito());
  	if (boleta.getCaja()!=null) {
  	  ds.fieldValue("oid_caja", boleta.getCaja().getOIDInteger());
  	  ds.fieldValue("cod_caja", boleta.getCaja().getCodigo());
  	  ds.fieldValue("desc_caja", boleta.getCaja().getDescripcion());
  	} else {
  	  ds.fieldValue("oid_caja", new Integer(0));
  	  ds.fieldValue("cod_caja", "");
  	  ds.fieldValue("desc_caja", "");
  	}
  	ds.fieldValue("desc_moneda", boleta.getMoneda().getDescripcion());
  	
  }
  
  private IDataSet getDataSetTalonarios() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TTalonarios");
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }
  
  private void cargarTalonario(IDataSet ds,Talonario talonario) throws BaseException {
  	ds.append();  	
  	ds.fieldValue("oid_talonario", talonario.getOIDInteger());
  	ds.fieldValue("codigo", talonario.getCodigo());
  	ds.fieldValue("descripcion", talonario.getDescripcion());
  }
  
}
