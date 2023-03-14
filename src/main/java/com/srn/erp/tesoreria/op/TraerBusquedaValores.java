package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerBusquedaValores extends Operation {

	
	private Caja caja = null;
	private java.util.Date fecEmiDesde = null;
	private java.util.Date fecEmiHasta = null;
	private java.util.Date fecVtoDesde = null;
	private java.util.Date fecVtoHasta = null;
	private TipoValor tipoValor = null;
	Sujeto sujeto = null;
	String cuit = null;
	Integer nroCheque = null;
	String nroTarjeta = null;
	Money importe = null;
	Banco banco = null;
	TarjetaCredito tarjeta = null;
	Integer nroLote = null;
	Integer nroCupon = null;
	String codAutorizacion = null;
	
	public TraerBusquedaValores() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = this.getDataSetValoresEnCaja();
		IDataSet dsMov = this.getDataSetMovArqueo();
		
		tomarParametros(mapaDatos);
		
		Iterator iterValores = 
			Valor.getBusquedaValores(
				caja, 
				fecEmiDesde, 
				fecEmiHasta, 
				fecVtoDesde, 
				fecVtoHasta, 
				tipoValor, sujeto, cuit, nroCheque, 
				nroTarjeta, 
				importe, 
				banco, tarjeta, nroLote, nroCupon, codAutorizacion, this.getSesion()).iterator();
		
		while (iterValores.hasNext()) {
			Valor valor = (Valor) iterValores.next();
			cargarRegistroValores(ds, valor);
		}
			
		
		writeCliente(ds);
		writeCliente(dsMov);
		
	}
	
	private void tomarParametros(MapDatos mapaDatos) throws BaseException {
		
		if (mapaDatos.containsKey("oid_caja"))
			caja = Caja.findByOidProxy(mapaDatos.getInteger("oid_caja"), this.getSesion());
		
		if (mapaDatos.containsKey("oid_tipo_valor"))
			tipoValor = TipoValor.findByOidProxy(mapaDatos.getInteger("oid_tipo_valor"), this.getSesion());
		
		if (mapaDatos.containsKey("fec_emi_desde"))
			fecEmiDesde = mapaDatos.getDate("fec_emi_desde");
		
		if (mapaDatos.containsKey("fec_emi_hasta"))
			fecEmiHasta = mapaDatos.getDate("fec_emi_hasta");
		
		if (mapaDatos.containsKey("fec_vto_desde"))
			fecVtoDesde = mapaDatos.getDate("fec_vto_desde");
		
		if (mapaDatos.containsKey("fec_vto_hasta"))
			fecVtoHasta = mapaDatos.getDate("fec_vto_hasta");
		
		if (mapaDatos.containsKey("oid_sujeto"))
			sujeto = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_sujeto"), this.getSesion());
		
		if (mapaDatos.containsKey("cuit"))
			cuit = mapaDatos.getString("cuit");
		
		if (mapaDatos.containsKey("nro_valor"))
			nroCheque = mapaDatos.getInteger("nro_valor");
		
		if (mapaDatos.containsKey("nro_tarjeta"))
			nroTarjeta = mapaDatos.getString("nro_tarjeta");
		
		if (mapaDatos.containsKey("importe"))
			importe = mapaDatos.getMoney("importe");
		
		if (mapaDatos.containsKey("oid_banco"))
			banco = Banco.findByOidProxy(mapaDatos.getInteger("oid_banco"), this.getSesion());
		
		if (mapaDatos.containsKey("oid_tar_credito"))
			tarjeta = TarjetaCredito.findByOidProxy(mapaDatos.getInteger("oid_tar_credito"), this.getSesion());
		
		if (mapaDatos.containsKey("nro_lote"))
			nroLote = mapaDatos.getInteger("nro_lote");
		
		if (mapaDatos.containsKey("cupon"))
			nroCupon = mapaDatos.getInteger("cupon");
		
		if (mapaDatos.containsKey("cod_autorizacion"))
			codAutorizacion = mapaDatos.getString("cod_autorizacion");
		
	}
	

	private IDataSet getDataSetValoresEnCaja() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValores");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tipo_valor", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 50));
		dataset.fieldDef(new Field("cod_entidad", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_entidad", Field.STRING, 50));
		dataset.fieldDef(new Field("razon_social", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_moneda", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_moneda", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_vto", Field.DATE, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cupon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cuotas", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_certificado", Field.STRING, 50));
		dataset.fieldDef(new Field("provincia", Field.STRING, 100));
		dataset.fieldDef(new Field("codigo_autorizacion", Field.STRING, 50));
		dataset.fieldDef(new Field("cuit", Field.STRING, 20));
		dataset.fieldDef(new Field("nro_valor", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistroValores(
			IDataSet dataset, 
			Valor valor) throws BaseException {
		dataset.append();
		dataset.fieldValue("secu", valor.getOIDInteger());
		dataset.fieldValue("orden", valor.getOIDInteger());
		dataset.fieldValue("oid_tipo_valor", valor.getTipovalor().getOIDInteger());
		dataset.fieldValue("cod_tipo_valor", valor.getTipovalor().getCodigo());
		dataset.fieldValue("oid_valor", valor.getOIDInteger());
		dataset.fieldValue("desc_tipo_valor", valor.getTipovalor().getDescripcion());
		dataset.fieldValue("nro_tarjeta", valor.getNro_tarjeta());
		dataset.fieldValue("cod_entidad", valor.getCodEntidad());
		dataset.fieldValue("desc_entidad", valor.getDescEntidad());
		if (valor.getSujeto()!=null)
			dataset.fieldValue("razon_social", valor.getSujeto().getRazon_social());
			else
			dataset.fieldValue("razon_social", "");
		dataset.fieldValue("oid_moneda", valor.getTipovalor().getMoneda().getOIDInteger());
		dataset.fieldValue("cod_moneda", valor.getTipovalor().getMoneda().getCodigo());
		dataset.fieldValue("desc_moneda", valor.getTipovalor().getMoneda().getDescripcion());
		dataset.fieldValue("fec_emision", valor.getFechaemision());
		dataset.fieldValue("fec_vto", valor.getFechavto());
		dataset.fieldValue("importe", valor.getImporte());
		dataset.fieldValue("cupon", valor.getCupon());
		dataset.fieldValue("lote", valor.getLote());
		dataset.fieldValue("cuotas", valor.getCuotas());
		dataset.fieldValue("nro_certificado", valor.getNroCertificado());
		if (valor.getProvincia()!=null)
			dataset.fieldValue("provincia", valor.getProvincia().getDescripcion());
		else
			dataset.fieldValue("provincia", "");
		dataset.fieldValue("codigo_autorizacion", valor.getCodigoAutorizacion());
		dataset.fieldValue("cuit", valor.getCUIT());
		dataset.fieldValue("nro_valor", valor.getNroValorGenerico());

	}
	
	private IDataSet getDataSetMovArqueo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMovArqueo");
		dataset.fieldDef(new Field("oid_mov_arqueo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_caja", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("movimiento", Field.STRING, 20));
		dataset.fieldDef(new Field("moneda", Field.STRING, 10));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_tipo_compro", Field.STRING, 50));
		return dataset;
	}
	
	
}
