package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.UbiDepoHabTalonario;
import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMovStkTal extends Operation {

	public TraerMovStkTal() {
	}

	IDataSet dsMovStkTalonario = getDataSetMovStkTalonario();

	IDataSet dsUbicacionesDepo = getDataSetUbicacionDeposito();

	public void execute(MapDatos mapaDatos) throws BaseException {

		procesarConsulta(mapaDatos);

	}

	private void procesarConsulta(MapDatos mapaDatos) throws BaseException {
		Integer oidMovStkTal = mapaDatos.getInteger("oid_mov_stk_tal");
		cargarMovStkTal(oidMovStkTal);
		writeCliente(dsMovStkTalonario);
		writeCliente(dsUbicacionesDepo);
	}

	private void cargarMovStkTal(Integer oidMovStkTal) throws BaseException {
		MovStockTalonarioDeposito movStkTalDepo = MovStockTalonarioDeposito
				.findByOid(oidMovStkTal, getSesion());
		cargarMovStockTalonario(dsMovStkTalonario,movStkTalDepo);
		cargarUbiHabDepoTal(dsUbicacionesDepo,movStkTalDepo);
	}
	
	private void cargarUbiHabDepoTal(IDataSet dsUbiDepoHabTal,
			MovStockTalonarioDeposito movStockHabTal) throws BaseException {
		Iterator iterUbicaciones = movStockHabTal.getDeposito()
				.getUbicaciones().iterator();
		while (iterUbicaciones.hasNext()) {
			UbicacionDeposito ubicacionDeposito = (UbicacionDeposito) iterUbicaciones
					.next();
			cargarUbicacionDeposito(dsUbiDepoHabTal, movStockHabTal,
					ubicacionDeposito);
		}
	}

	private void cargarMovStockTalonario(IDataSet dataset,
			MovStockTalonarioDeposito movStockTalDepo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_mov_stk_tal", movStockTalDepo.getOIDInteger());
		dataset.fieldValue("oid_tipo_conf_mov",movStockTalDepo.getTipo_conf_mov().getOIDInteger());
		dataset.fieldValue("secu", movStockTalDepo.getSecu());
		dataset.fieldValue("oid_deposito", movStockTalDepo.getDeposito()
				.getOIDInteger());
		dataset.fieldValue("cod_deposito", movStockTalDepo.getDeposito()
				.getCodigo());
		dataset.fieldValue("desc_deposito", movStockTalDepo.getDeposito()
				.getDescripcion());
		dataset.fieldValue("oid_estado_stock", movStockTalDepo
				.getEstado_stock().getOIDInteger());
		dataset.fieldValue("desc_estado_stock",  movStockTalDepo.getEstado_stock().getDescripcion());
		dataset.fieldValue("tipo_movimiento", movStockTalDepo
				.getTipo_movimiento());
		dataset.fieldValue("activo", movStockTalDepo.isActivo());
		dataset.fieldValue("afecta_stk_fisico", movStockTalDepo
				.isAfectaStockFisico());
	}

	private void cargarUbicacionDeposito(IDataSet dataset,
			MovStockTalonarioDeposito movStockHabTal,
			UbicacionDeposito ubicacionDeposito) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_ubi_depo", ubicacionDeposito.getOIDInteger());
		dataset.fieldValue("codigo", ubicacionDeposito.getCodigo());
		dataset.fieldValue("oid", ubicacionDeposito.getOid());
		dataset.fieldValue("descripcion", ubicacionDeposito.getDescripcion()+" ("+ubicacionDeposito.getCodigo()+")");
		if (ubicacionDeposito.getDeposito() != null) {
			dataset.fieldValue("oid_deposito", ubicacionDeposito.getDeposito()
					.getOIDInteger());
		}	
		else {
			dataset.fieldValue("oid_deposito", 0);
		}	
		dataset.fieldValue("oid_padre", ubicacionDeposito.getOid_padre());
		dataset.fieldValue("solo_sku_habi", ubicacionDeposito
						.isSolo_sku_habi());
		if (ubicacionDeposito.getSujeto() != null) {
			dataset.fieldValue("oid_sujeto", ubicacionDeposito.getSujeto()
					.getOIDInteger());
			dataset.fieldValue("codigo_sujeto", ubicacionDeposito.getSujeto()
					.getCodigo());
			dataset.fieldValue("rz_sujeto", ubicacionDeposito.getSujeto()
					.getRazon_social());
		} else {
			dataset.fieldValue("oid_sujeto", 0);
			dataset.fieldValue("codigo_sujeto", "");
			dataset.fieldValue("rz_sujeto", "");
		}
		if (ubicacionDeposito.getTransporte() != null) {
			dataset.fieldValue("oid_transporte", ubicacionDeposito
					.getTransporte().getOIDInteger());
			dataset.fieldValue("cod_transporte", ubicacionDeposito
					.getTransporte().getCodigo());
			dataset.fieldValue("desc_transporte", ubicacionDeposito
					.getTransporte().getDescripcion());
		} else {
			dataset.fieldValue("oid_transporte", 0);
			dataset.fieldValue("cod_transporte", "");
			dataset.fieldValue("desc_transporte", "");
		}
		if (ubicacionDeposito.getDeposito_destino() != null) {
			dataset.fieldValue("oid_depo_dest", ubicacionDeposito
					.getDeposito_destino().getOIDInteger());
			dataset.fieldValue("codigo_depo_dest", ubicacionDeposito
					.getDeposito_destino().getCodigo());
			dataset.fieldValue("desc_depo_dest", ubicacionDeposito
					.getDeposito_destino().getDescripcion());
		} else {
			dataset.fieldValue("oid_depo_dest", 0);
			dataset.fieldValue("codigo_depo_dest", "");
			dataset.fieldValue("desc_depo_dest", "");
		}
		dataset.fieldValue("allow_almacenar", ubicacionDeposito
				.isAllow_almacenar());
		dataset.fieldValue("tipo", ubicacionDeposito.getTipo());
		dataset.fieldValue("secu", ubicacionDeposito.getSecu());
		dataset.fieldValue("ocultar_registro", new Integer(0));
		if (ubicacionDeposito.isSolo_sku_habi().booleanValue() == true)
			dataset.fieldValue("valor_sku_hab", 1);
		else
			dataset.fieldValue("valor_sku_hab", 0);
		// Buscar configuraciones Guardadas
		UbiDepoHabTalonario ubiDepoHabTalonario = UbiDepoHabTalonario
				.getUbiDepoHabTalonario(movStockHabTal, ubicacionDeposito,
						getSesion());
		if (ubiDepoHabTalonario != null) {
			dataset.fieldValue("oid_ubi_depo_tal", ubiDepoHabTalonario
					.getOIDInteger());
			dataset.fieldValue("oid_mov_stk_tal", movStockHabTal
					.getOIDInteger());
			dataset
					.fieldValue("habilitado", ubiDepoHabTalonario
							.isHabilitado());
			dataset.fieldValue("incluye_hijos", ubiDepoHabTalonario
					.isIncluye_hijos());
			dataset.fieldValue("usar_por_defecto", ubiDepoHabTalonario
					.isUsar_por_defecto());
			dataset.fieldValue("activo", ubiDepoHabTalonario.isActivo());
		} else {
			dataset.fieldValue("oid_ubi_depo_tal", new Integer(-1));
			dataset.fieldValue("oid_mov_stk_tal", movStockHabTal
					.getOIDInteger());
			dataset.fieldValue("habilitado", new Boolean(false));
			dataset.fieldValue("incluye_hijos", new Boolean(false));
			dataset.fieldValue("usar_por_defecto", new Boolean(false));
			dataset.fieldValue("activo", new Boolean(true));
		}
	}

	private IDataSet getDataSetUbicacionDeposito() {
		IDataSet dataset = new TDataSet();
		dataset.create("TUbicacionDeposito");
		dataset.fieldDef(new Field("oid_ubi_depo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));		
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_padre", Field.INTEGER, 0));
		dataset.fieldDef(new Field("solo_sku_habi", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_transporte", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_transporte", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_transporte", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_depo_dest", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_depo_dest", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_depo_dest", Field.STRING, 100));
		dataset.fieldDef(new Field("allow_almacenar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 20));
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ocultar_registro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("valor_sku_hab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ubi_depo_tal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mov_stk_tal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("incluye_hijos", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetMovStkTalonario() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMovStkTalonario");
		dataset.fieldDef(new Field("oid_mov_stk_tal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_deposito", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_deposito", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_estado_stock", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_estado_stock", Field.STRING, 20));		
		dataset.fieldDef(new Field("tipo_movimiento", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("afecta_stk_fisico", Field.BOOLEAN, 0));
		return dataset;
	}

	

}
