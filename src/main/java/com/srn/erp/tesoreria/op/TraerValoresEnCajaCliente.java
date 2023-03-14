package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresEnCajaCliente extends Operation {

	public TraerValoresEnCajaCliente() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Caja caja = null;
		Sujeto sujeto = null;
		TipoValor tipoValor = null;
		
		
		if (mapaDatos.containsKey("oid_caja"))
			caja = Caja.findByOid(mapaDatos.getInteger("oid_caja"), getSesion());
		if (mapaDatos.containsKey("oid_sujeto"))
			sujeto = Sujeto.findByOid(mapaDatos.getInteger("oid_sujeto"), getSesion());
		if (mapaDatos.containsKey("oid_tipo_valor"))
			tipoValor = TipoValor.findByOid(mapaDatos.getInteger("oid_tipo_valor"), getSesion());

		enviarCabecera(caja, sujeto , tipoValor);
		traerValoresEnCaja(caja, sujeto , tipoValor);

	}

	private IDataSet getDataSetValoresEnCaja() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetValores");
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.MEMO, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("moneda", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tipo_valor", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_cheque", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_vto", Field.DATE, 0));
		
		return dataset;
	}
	
	private IDataSet getDataSetCabValores() throws BaseException {
	
		IDataSet dataset = new TDataSet();
		dataset.create("TCabValores");
		
		dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_caja", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_caja", Field.STRING, 100));

		dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_cliente", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_cliente", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tipo_valor", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 100));
		
		
		return dataset;
	}
	
	private void cargarRegistroCabecera(IDataSet dataset, Caja caja , Sujeto sujeto , TipoValor tipoValor) throws BaseException {
		dataset.append();
		if (caja!=null) {
		  dataset.fieldValue("oid_caja", caja.getOIDInteger());
		  dataset.fieldValue("cod_caja", caja.getCodigo());
		  dataset.fieldValue("desc_caja", caja.getDescripcion());
		} else {
		  dataset.fieldValue("oid_caja", new Integer(0));
		  dataset.fieldValue("cod_caja", "");
		  dataset.fieldValue("desc_caja", "");
		}
		if (sujeto!=null) {
		  dataset.fieldValue("oid_cliente", sujeto.getOIDInteger());
		  dataset.fieldValue("cod_cliente", sujeto.getCodigo());
		  dataset.fieldValue("rs_cliente", sujeto.getRazon_social());
		} else {
		  dataset.fieldValue("oid_cliente", new Integer(0));
		  dataset.fieldValue("cod_cliente", "");
		  dataset.fieldValue("rs_cliente", "");
		}
		if (tipoValor!=null) {
		  dataset.fieldValue("oid_tipo_valor", tipoValor.getOIDInteger());
		  dataset.fieldValue("cod_tipo_valor", tipoValor.getCodigo());
		  dataset.fieldValue("desc_tipo_valor", tipoValor.getDescripcion());
		} else {
		  dataset.fieldValue("oid_tipo_valor", new Integer(0));
		  dataset.fieldValue("cod_tipo_valor", "");
		  dataset.fieldValue("desc_tipo_valor", "");
		}
		
		
	}
	
	

	private void cargarRegistroValoresEnCaja(IDataSet dataset, Valor valor) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_valor", valor.getOIDInteger());
		dataset.fieldValue("descripcion", valor.getDescripcion());
		dataset.fieldValue("importe", valor.getImporte());
		dataset.fieldValue("oid_moneda", valor.getTipovalor().getMoneda().getOID());
		dataset.fieldValue("moneda", valor.getTipovalor().getMoneda().getSimbolo());
		dataset.fieldValue("oid_tipo_valor", valor.getTipovalor().getOIDInteger());
		dataset.fieldValue("cod_tipo_valor", valor.getTipovalor().getCodigo());
		dataset.fieldValue("desc_tipo_valor", valor.getTipovalor().getDescripcion());
		dataset.fieldValue("nro_cheque", valor.getNrocheque());
		dataset.fieldValue("fec_emision", valor.getFechaemision());
		dataset.fieldValue("fec_vto", valor.getFechavto());
		
	}

	private void traerValoresEnCaja(Caja caja, 
			                            Sujeto sujeto,
			                            TipoValor tipoValor) throws BaseException {
		IDataSet ds = getDataSetValoresEnCaja();
		
		Iterator iterValores = Valor.getValoresEnCaja(caja, sujeto , tipoValor ,null, this.getSesion()).iterator();
		while (iterValores.hasNext()) {
			Valor valor = (Valor) iterValores.next();
			cargarRegistroValoresEnCaja(ds, valor);
		}

		writeCliente(ds);
	}
	
	private void enviarCabecera(Caja caja, Sujeto sujeto , TipoValor tipoValor) throws BaseException {
		IDataSet ds = this.getDataSetCabValores();
		cargarRegistroCabecera(ds,caja,sujeto,tipoValor);
		writeCliente(ds);
	}
	
	
	

}
