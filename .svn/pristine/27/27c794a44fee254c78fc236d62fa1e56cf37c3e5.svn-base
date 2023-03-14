package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;
import com.srn.erp.tesoreria.bm.LiquidacionTarCab;
import com.srn.erp.tesoreria.bm.LiquidacionTarjetaDet;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLiquidacionTarCab extends Operation {

	
	public TraerLiquidacionTarCab() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		LiquidacionTarCab liquidaciontarcab = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			liquidaciontarcab = LiquidacionTarCab.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			liquidaciontarcab = LiquidacionTarCab.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetLiquidacionTarCab = getDataSetLiquidacionTarCab();
		IDataSet dsTalonarios = this.getDataSetTalonarios();
		IDataSet dsTipoValores = getTiposTarjetas();
		IDataSet dsEntidades = this.getDSEntidades();
		IDataSet dsConcLiq = getDataSetConcLiqTar();
		IDataSet dsLiquiDet = getDataSetDetalleLiq();
		IDataSet dsCajas = getDataSetCajas();

		if (liquidaciontarcab != null) {
			cargarRegistroLiquidacionTarCab(datasetLiquidacionTarCab, liquidaciontarcab);
		}

		cargarRegistroTalonario(dsTalonarios, liquidaciontarcab.getTalonario());
		cargarRegistroTipoTarjetas(dsTipoValores, liquidaciontarcab.getTipo_valor());

		if (liquidaciontarcab.getTarjeta_credito() != null)
			cargarRegistroEntidad(dsEntidades, liquidaciontarcab.getTarjeta_credito().getOIDInteger(), liquidaciontarcab
					.getTarjeta_credito().getCodigo(), liquidaciontarcab.getTarjeta_credito().getDescripcion());
		else if (liquidaciontarcab.getBanco() != null)
			cargarRegistroEntidad(dsEntidades, liquidaciontarcab.getBanco().getOIDInteger(), liquidaciontarcab.getBanco().getCodigo(),
					liquidaciontarcab.getBanco().getDescripcion());
		cargarRegistroConcLiq(dsConcLiq, liquidaciontarcab.getConcepto_liq_tar());

		Iterator iterLiquiDet = (Iterator) liquidaciontarcab.getDetallesLiquidacion().iterator();
		while (iterLiquiDet.hasNext()) {
			LiquidacionTarjetaDet liqTarDet = (LiquidacionTarjetaDet) iterLiquiDet.next();
			cargarRegLiqDet(dsLiquiDet, liqTarDet);
		}
		
		if (liquidaciontarcab.getCaja()!=null)
			cargarRegistroCaja(dsCajas,liquidaciontarcab.getCaja());

		writeCliente(datasetLiquidacionTarCab);
		writeCliente(dsTalonarios);
		writeCliente(dsTipoValores);
		writeCliente(dsEntidades);
		writeCliente(dsConcLiq);
		writeCliente(dsLiquiDet);
		writeCliente(dsCajas);

	}

	private IDataSet getDSEntidades() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEntidades");
		dataset.fieldDef(new Field("oid_entidad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_entidad", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_entidad", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroEntidad(IDataSet ds, Integer oid, String codigo, String descripcion) throws BaseException {
		ds.append();
		ds.fieldValue("oid_entidad", oid);
		ds.fieldValue("cod_entidad", codigo);
		ds.fieldValue("desc_entidad", descripcion);
	}

	private IDataSet getTiposTarjetas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposTarjetas");
		dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tipo_valor", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroTipoTarjetas(IDataSet ds, TipoValor tipoValor) throws BaseException {
		ds.append();
		ds.fieldValue("oid_tipo_valor", tipoValor.getOIDInteger());
		ds.fieldValue("cod_tipo_valor", tipoValor.getCodigo());
		ds.fieldValue("desc_tipo_valor", tipoValor.getDescripcion());
	}

	private IDataSet getDataSetLiquidacionTarCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLiquidacionCab");
		dataset.fieldDef(new Field("oid_liqui_tar", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("compo_tipo_valor", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_tar_credito", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_banco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_hasta", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_vto", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_liq_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("imputacion", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_entidad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		dataset.fieldDef(new Field("compor_tc", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_caja_liq", Field.INTEGER, 0));

		return dataset;
	}

	private void cargarRegistroLiquidacionTarCab(IDataSet dataset, LiquidacionTarCab liquidacionTarCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_liqui_tar", liquidacionTarCab.getOIDInteger());
		dataset.fieldValue("oid_tipo_valor", liquidacionTarCab.getTipo_valor().getOIDInteger());
		dataset.fieldValue("compo_tipo_valor", liquidacionTarCab.getTipo_valor().getCompo());
		if (liquidacionTarCab.getTarjeta_credito() != null)
			dataset.fieldValue("oid_tar_credito", liquidacionTarCab.getTarjeta_credito().getOIDInteger());
		else
			dataset.fieldValue("oid_tar_credito", "");
		if (liquidacionTarCab.getBanco() != null)
			dataset.fieldValue("oid_banco", liquidacionTarCab.getBanco().getOIDInteger());
		else
			dataset.fieldValue("oid_banco", "");
		dataset.fieldValue("fec_desde", liquidacionTarCab.getFec_desde());
		dataset.fieldValue("fec_hasta", liquidacionTarCab.getFec_hasta());
		dataset.fieldValue("fec_vto", liquidacionTarCab.getFec_vto());
		dataset.fieldValue("oid_moneda", liquidacionTarCab.getMoneda().getOIDInteger());
		dataset.fieldValue("cotizacion", liquidacionTarCab.getCotizacion());
		dataset.fieldValue("importe", liquidacionTarCab.getImporte());
		dataset.fieldValue("oid_conc_liq_tc", liquidacionTarCab.getConcepto_liq_tar().getOIDInteger());
		dataset.fieldValue("oid_talonario", liquidacionTarCab.getTalonario().getOIDInteger());
		dataset.fieldValue("nro_ext", liquidacionTarCab.getNroExt());
		dataset.fieldValue("fecha", liquidacionTarCab.getEmision());
		dataset.fieldValue("imputacion", liquidacionTarCab.getImputacion());
		if (liquidacionTarCab.getTarjeta_credito() != null)
			dataset.fieldValue("oid_entidad", liquidacionTarCab.getTarjeta_credito().getOIDInteger());
		else if (liquidacionTarCab.getBanco() != null)
			dataset.fieldValue("oid_entidad", liquidacionTarCab.getBanco().getOIDInteger());
		else
			dataset.fieldValue("oid_entidad", "");
		dataset.fieldValue("comentario", liquidacionTarCab.getComentario());
		dataset.fieldValue("compor_tc", liquidacionTarCab.getTipoCompro().getIdentificacion());
		if (liquidacionTarCab.getCaja() != null)
			dataset.fieldValue("oid_caja_liq", liquidacionTarCab.getCaja().getOIDInteger());
		else
			dataset.fieldValue("oid_caja_liq", "");

	}

	private void cargarRegistroTalonario(IDataSet ds, Talonario talonario) throws BaseException {
		ds.append();
		ds.fieldValue("oid_talonario", talonario.getOIDInteger());
		ds.fieldValue("codigo", talonario.getCodigo());
		ds.fieldValue("descripcion", talonario.getDescripcion());
		ds.fieldValue("activo", talonario.isActivo());

	}

	private IDataSet getDataSetTalonarios() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTalonarios");
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroConcLiq(IDataSet ds, ConceptoLiqTarjeta concepto) throws BaseException {
		ds.append();
		ds.fieldValue("oid_concepto", concepto.getOIDInteger());
		ds.fieldValue("cod_concepto", concepto.getCodigo());
		ds.fieldValue("desc_concepto", concepto.getDescripcion());
	}
	
	private void cargarRegistroCaja(IDataSet ds, Caja aCaja) throws BaseException {
		ds.append();
		ds.fieldValue("oid_caja", aCaja.getOIDInteger());
		ds.fieldValue("cod_caja", aCaja.getCodigo());
		ds.fieldValue("desc_caja", aCaja.getDescripcion());
	}
	

	private IDataSet getDataSetConcLiqTar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConcLiqTar");
		dataset.fieldDef(new Field("oid_concepto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_concepto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_concepto", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetCajas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCajasOperativasLiq");
		dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_caja", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_caja", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetDetalleLiq() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresALiquidar");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_liquidar_tar", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_vto", Field.DATE, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nro_lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cupon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cuotas", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_autoriz", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_cuota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("importe_liquidado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("moneda", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("saldo", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarRegLiqDet(IDataSet dsLiqTarDet, LiquidacionTarjetaDet liquiTarDet) throws BaseException {
		dsLiqTarDet.append();
		dsLiqTarDet.fieldValue("sel", true);
		dsLiqTarDet.fieldValue("oid_det", liquiTarDet.getOIDInteger());
		dsLiqTarDet.fieldValue("oid_liquidar_tar", liquiTarDet.getLiquidacion_tar().getOIDInteger());
		dsLiqTarDet.fieldValue("nro_tarjeta", liquiTarDet.getValor().getNro_tarjeta());
		dsLiqTarDet.fieldValue("fec_emision", liquiTarDet.getValor().getFechaemision());
		dsLiqTarDet.fieldValue("fec_vto", liquiTarDet.getValor().getFechavto());
		dsLiqTarDet.fieldValue("importe", liquiTarDet.getValor().getImporte());
		dsLiqTarDet.fieldValue("nro_lote", liquiTarDet.getValor().getLote());
		dsLiqTarDet.fieldValue("cupon", liquiTarDet.getValor().getCupon());
		dsLiqTarDet.fieldValue("cuotas", liquiTarDet.getValor().getCuotas());
		dsLiqTarDet.fieldValue("cod_autoriz", liquiTarDet.getValor().getCodigoAutorizacion());
		dsLiqTarDet.fieldValue("nro_cuota", liquiTarDet.getNroCuota());
		dsLiqTarDet.fieldValue("importe_liquidado", liquiTarDet.getImporte_liquidado());
		dsLiqTarDet.fieldValue("moneda", liquiTarDet.getValor().getTipovalor().getMoneda().getCodigo());
		dsLiqTarDet.fieldValue("oid_moneda", liquiTarDet.getValor().getTipovalor().getMoneda().getOIDInteger());
		dsLiqTarDet.fieldValue("saldo", liquiTarDet.getValor().getSaldo());
	}

}
