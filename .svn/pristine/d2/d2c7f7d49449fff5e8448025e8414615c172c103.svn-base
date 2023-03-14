package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.CondMinRankeador;
import com.srn.erp.rrhh.bm.CondMinSancion;
import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.RankearNovedad;
import com.srn.erp.rrhh.bm.SancionRankear;
import com.srn.erp.rrhh.bm.SancionesRRHH;
import com.srn.erp.rrhh.bm.TipoNovedad;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRankearCab extends Operation {

	public TraerRankearCab() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		RankearCab rankearcab = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			rankearcab = RankearCab.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			rankearcab = RankearCab.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetRankearCab = getDataSetRankearCab();
		IDataSet datasetRankearNov = getDataSetNovRankear();
		IDataSet datasetRankearSan = getDataSetSanRankear();
		IDataSet datasetCondMinNov1 = getDataSetCondMinNov1();
		IDataSet datasetCondMinNov2 = getDataSetCondMinNov2();
		IDataSet datasetCondMinNov3 = getDataSetCondMinNov3();
		IDataSet datasetCondMinNov4 = getDataSetCondMinNov4();
		IDataSet datasetCondMinNov5 = getDataSetCondMinNov5();
		IDataSet datasetCondMinSan1 = getDataSetCondMinSan1();
		IDataSet datasetCondMinSan2 = getDataSetCondMinSan2();
		IDataSet datasetCondMinSan3 = getDataSetCondMinSan3();
		IDataSet datasetCondMinSan4 = getDataSetCondMinSan4();
		IDataSet datasetCondMinSan5 = getDataSetCondMinSan5();

		if (rankearcab != null) {

			cargarRegistroRankearCab(datasetRankearCab, rankearcab);
			cargarRegistroNovRank(datasetRankearNov, rankearcab);
			cargarRegistroSanciones(datasetRankearSan, rankearcab);
			cargarRegistroCondMinNov(datasetCondMinNov1, rankearcab, 1);
			cargarRegistroCondMinNov(datasetCondMinNov2, rankearcab, 2);
			cargarRegistroCondMinNov(datasetCondMinNov3, rankearcab, 3);
			cargarRegistroCondMinNov(datasetCondMinNov4, rankearcab, 4);
			cargarRegistroCondMinNov(datasetCondMinNov5, rankearcab, 5);
			cargarRegistroCondMinSan(datasetCondMinSan1, rankearcab, 6);
			cargarRegistroCondMinSan(datasetCondMinSan2, rankearcab, 7);
			cargarRegistroCondMinSan(datasetCondMinSan3, rankearcab, 8);
			cargarRegistroCondMinSan(datasetCondMinSan4, rankearcab, 9);
			cargarRegistroCondMinSan(datasetCondMinSan5, rankearcab, 10);

		}

		writeCliente(datasetRankearCab);
		writeCliente(datasetRankearNov);
		writeCliente(datasetRankearSan);
		writeCliente(datasetCondMinNov1);
		writeCliente(datasetCondMinNov2);
		writeCliente(datasetCondMinNov3);
		writeCliente(datasetCondMinNov4);
		writeCliente(datasetCondMinNov5);
		writeCliente(datasetCondMinSan1);
		writeCliente(datasetCondMinSan2);
		writeCliente(datasetCondMinSan3);
		writeCliente(datasetCondMinSan4);
		writeCliente(datasetCondMinSan5);

	}

	private void cargarRegistroCondMinNov(IDataSet datasetCondMinNov, RankearCab rankearcab, Integer nroNovedad) throws BaseException {
		int secu = -1;
		Iterator iterMotivos = MotivoTipoNov.getAllActivos(this.getSesion()).iterator();
		while (iterMotivos.hasNext()) {
			MotivoTipoNov motivoTipoNov = (MotivoTipoNov) iterMotivos.next();
			--secu;
			CondMinRankeador condMinRankeador = CondMinRankeador.getCondMinRankeador(nroNovedad, rankearcab, motivoTipoNov.getTipo_novedad(), motivoTipoNov, this.getSesion());
			if (condMinRankeador != null)
				cargarCondMinRank(datasetCondMinNov, condMinRankeador.getOIDInteger(), nroNovedad, rankearcab, motivoTipoNov.getTipo_novedad(), motivoTipoNov, condMinRankeador.isActivo());
			else
				cargarCondMinRank(datasetCondMinNov, secu, nroNovedad, rankearcab, motivoTipoNov.getTipo_novedad(), motivoTipoNov, false);
		}
	}

	private void cargarRegistroCondMinSan(IDataSet datasetCondMinSan, RankearCab rankearcab, Integer nroNovedad) throws BaseException {
		int secu = -1;
		Iterator iterSanciones = SancionesRRHH.getAllSanciones(this.getSesion()).iterator();
		while (iterSanciones.hasNext()) {
			SancionesRRHH sancion = (SancionesRRHH) iterSanciones.next();
			--secu;
			CondMinSancion condMinSancion = CondMinSancion.getCondMinSancion(nroNovedad, rankearcab, sancion, this.getSesion());
			if (condMinSancion != null)
				cargarCondMinSanc(datasetCondMinSan, secu , nroNovedad, rankearcab, sancion, condMinSancion.isActivo());
			else
				cargarCondMinSanc(datasetCondMinSan, secu , nroNovedad, rankearcab, sancion, false);
		}
	}

	private IDataSet getDataSetRankearCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRankearCab");
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("rank_por_ant_emp", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ptos_ant_emp", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ut_ant_emp", Field.STRING, 1));
		dataset.fieldDef(new Field("pond_ant_emp", Field.STRING, 0));
		dataset.fieldDef(new Field("rank_por_ant_pue", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ptos_ant_pue", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ut_ant_pue", Field.STRING, 1));
		dataset.fieldDef(new Field("pond_ant_pue", Field.STRING, 0));
		dataset.fieldDef(new Field("rank_por_novedad", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("rank_por_eval", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("eval_ult_meses", Field.INTEGER, 0));
		dataset.fieldDef(new Field("eval_calif_punto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("eval_ponderacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ant_req_emp", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_cant_req_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ut_req_emp", Field.STRING, 1));
		dataset.fieldDef(new Field("cm_ant_req_pue", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_cant_req_pue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ut_req_pue", Field.STRING, 1));
		dataset.fieldDef(new Field("cm_aplicar_eval", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_puntaje_eval", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_aplic_nov_1", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_dias_nov_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ult_mes_nov_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_motivos_1", Field.STRING, 100));
		dataset.fieldDef(new Field("cm_aplic_nov_2", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_dias_nov_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ult_mes_nov_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_motivos_2", Field.STRING, 100));
		dataset.fieldDef(new Field("cm_aplic_nov_3", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_dias_nov_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ult_mes_nov_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_motivos_3", Field.STRING, 100));
		dataset.fieldDef(new Field("cm_aplic_nov_4", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_dias_nov_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ult_mes_nov_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_motivos_4", Field.STRING, 100));
		dataset.fieldDef(new Field("cm_aplic_nov_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_dias_nov_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ult_mes_nov_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_motivos_5", Field.STRING, 100));
		dataset.fieldDef(new Field("rank_por_sancion", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("control_esta_desa", Field.BOOLEAN, 0));

		dataset.fieldDef(new Field("cm_aplic_nov_6", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_dias_nov_6", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ult_mes_nov_6", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_motivos_6", Field.STRING, 100));

		dataset.fieldDef(new Field("cm_aplic_nov_7", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_dias_nov_7", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ult_mes_nov_7", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_motivos_7", Field.STRING, 100));

		dataset.fieldDef(new Field("cm_aplic_nov_8", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_dias_nov_8", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ult_mes_nov_8", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_motivos_8", Field.STRING, 100));

		dataset.fieldDef(new Field("cm_aplic_nov_9", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_dias_nov_9", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ult_mes_nov_9", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_motivos_9", Field.STRING, 100));

		dataset.fieldDef(new Field("cm_aplic_nov_10", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_dias_nov_10", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_ult_mes_nov_10", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cm_motivos_10", Field.STRING, 100));
		
		dataset.fieldDef(new Field("cm_calif_gral", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cm_ptos_min_calif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cm_aplic_juegos_a", Field.BOOLEAN, 0));
		
		dataset.fieldDef(new Field("cm_aplic_hor_car", Field.BOOLEAN, 0));
		
		dataset.fieldDef(new Field("des_sanc_rest_mas",  Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("des_nov_rest_mas", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ptos_max_rest_sanc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("ptos_max_rest_nov" , Field.CURRENCY, 0));
		
		
		

		return dataset;
	}

	private void cargarRegistroRankearCab(IDataSet dataset, RankearCab rankear) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_rankear", rankear.getOIDInteger());
		dataset.fieldValue("codigo", rankear.getCodigo());
		dataset.fieldValue("descripcion", rankear.getDescripcion());
		dataset.fieldValue("activo", rankear.isActivo());
		dataset.fieldValue("rank_por_ant_emp", rankear.isRank_por_ant_emp());
		dataset.fieldValue("ptos_ant_emp", rankear.getPtos_ant_emp());
		dataset.fieldValue("ut_ant_emp", rankear.getUnitiempoantemp());
		dataset.fieldValue("pond_ant_emp", rankear.getPond_ant_emp());
		dataset.fieldValue("rank_por_ant_pue", rankear.isRank_por_ant_pue());
		dataset.fieldValue("ptos_ant_pue", rankear.getPtos_ant_pue());
		dataset.fieldValue("ut_ant_pue", rankear.getUt_ant_pue());
		dataset.fieldValue("pond_ant_pue", rankear.getPond_ant_pue());
		dataset.fieldValue("rank_por_novedad", rankear.isRank_por_novedad());
		dataset.fieldValue("rank_por_eval", rankear.isRank_por_eval());
		dataset.fieldValue("eval_ult_meses", rankear.getEval_ult_meses());
		dataset.fieldValue("eval_calif_punto", rankear.getEval_calif_punto());
		dataset.fieldValue("eval_ponderacion", rankear.getEval_ponderacion());
		dataset.fieldValue("cm_ant_req_emp", rankear.isCm_ant_req_emp());
		dataset.fieldValue("cm_cant_req_emp", rankear.getCm_cant_req_emp());
		dataset.fieldValue("cm_ut_req_emp", rankear.getCm_ut_req_emp());
		dataset.fieldValue("cm_ant_req_pue", rankear.isCm_ant_req_pue());
		dataset.fieldValue("cm_cant_req_pue", rankear.getCm_cant_req_pue());
		dataset.fieldValue("cm_ut_req_pue", rankear.getCm_ut_req_pue());
		dataset.fieldValue("cm_aplicar_eval", rankear.isCm_aplicar_eval());
		dataset.fieldValue("cm_puntaje_eval", rankear.getCm_puntaje_eval());
		dataset.fieldValue("cm_aplic_nov_1", rankear.isCm_aplic_nov_1());
		dataset.fieldValue("cm_dias_nov_1", rankear.getCm_dias_nov_1());
		dataset.fieldValue("cm_ult_mes_nov_1", rankear.getCm_ult_mes_nov_1());
		dataset.fieldValue("cm_motivos_1", rankear.getCm_motivos_1());
		dataset.fieldValue("cm_aplic_nov_2", rankear.isCm_aplic_nov_2());
		dataset.fieldValue("cm_dias_nov_2", rankear.getCm_dias_nov_2());
		dataset.fieldValue("cm_ult_mes_nov_2", rankear.getCm_ult_mes_nov_2());
		dataset.fieldValue("cm_motivos_2", rankear.getCm_motivos_2());
		dataset.fieldValue("cm_aplic_nov_3", rankear.isCm_aplic_nov_3());
		dataset.fieldValue("cm_dias_nov_3", rankear.getCm_dias_nov_3());
		dataset.fieldValue("cm_ult_mes_nov_3", rankear.getCm_ult_mes_nov_3());
		dataset.fieldValue("cm_motivos_3", rankear.getCm_motivos_3());
		dataset.fieldValue("cm_aplic_nov_4", rankear.isCm_aplic_nov_4());
		dataset.fieldValue("cm_dias_nov_4", rankear.getCm_dias_nov_4());
		dataset.fieldValue("cm_ult_mes_nov_4", rankear.getCm_ult_mes_nov_4());
		dataset.fieldValue("cm_motivos_4", rankear.getCm_motivos_4());
		dataset.fieldValue("cm_aplic_nov_5", rankear.isCm_aplic_nov_5());
		dataset.fieldValue("cm_dias_nov_5", rankear.getCm_dias_nov_5());
		dataset.fieldValue("cm_ult_mes_nov_5", rankear.getCm_ult_mes_nov_5());
		dataset.fieldValue("cm_motivos_5", rankear.getCm_motivos_5());
		dataset.fieldValue("rank_por_sancion", rankear.isRankearPorSancion());
		dataset.fieldValue("control_esta_desa", rankear.isControlarEstadoDesa());

		dataset.fieldValue("cm_aplic_nov_6", rankear.isCm_aplic_nov_6());
		dataset.fieldValue("cm_dias_nov_6", rankear.getCm_dias_nov_6());
		dataset.fieldValue("cm_ult_mes_nov_6", rankear.getCm_ult_mes_nov_6());
		dataset.fieldValue("cm_motivos_6", rankear.getCm_motivos_6());

		dataset.fieldValue("cm_aplic_nov_7", rankear.isCm_aplic_nov_7());
		dataset.fieldValue("cm_dias_nov_7", rankear.getCm_dias_nov_7());
		dataset.fieldValue("cm_ult_mes_nov_7", rankear.getCm_ult_mes_nov_7());
		dataset.fieldValue("cm_motivos_7", rankear.getCm_motivos_7());

		dataset.fieldValue("cm_aplic_nov_8", rankear.isCm_aplic_nov_8());
		dataset.fieldValue("cm_dias_nov_8", rankear.getCm_dias_nov_8());
		dataset.fieldValue("cm_ult_mes_nov_8", rankear.getCm_ult_mes_nov_8());
		dataset.fieldValue("cm_motivos_8", rankear.getCm_motivos_8());

		dataset.fieldValue("cm_aplic_nov_9", rankear.isCm_aplic_nov_9());
		dataset.fieldValue("cm_dias_nov_9", rankear.getCm_dias_nov_9());
		dataset.fieldValue("cm_ult_mes_nov_9", rankear.getCm_ult_mes_nov_9());
		dataset.fieldValue("cm_motivos_9", rankear.getCm_motivos_9());

		dataset.fieldValue("cm_aplic_nov_10", rankear.isCm_aplic_nov_10());
		dataset.fieldValue("cm_dias_nov_10", rankear.getCm_dias_nov_10());
		dataset.fieldValue("cm_ult_mes_nov_10", rankear.getCm_ult_mes_nov_10());
		dataset.fieldValue("cm_motivos_10", rankear.getCm_motivos_10());
		
		dataset.fieldValue("cm_calif_gral" , rankear.isAplicClasifGral());
		dataset.fieldValue("cm_ptos_min_calif" , rankear.getPtosMinCalifGral());
		dataset.fieldValue("cm_aplic_juegos_a" , rankear.isAplicCMJuegosA());
		dataset.fieldValue("cm_aplic_hor_car" , rankear.isAplicHoriCarrera());
		
		dataset.fieldValue("des_sanc_rest_mas",  rankear.IsDesapruebaSiSancRestanMas());
		dataset.fieldValue("des_nov_rest_mas", rankear.IsDesapruebaSiNoveRestanMas());
		dataset.fieldValue("ptos_max_rest_sanc", rankear.getPtosMaxDesapruebaSanc());
		dataset.fieldValue("ptos_max_rest_nov" , rankear.getPtosMaxDesapruebaNov());
				
		


	}

	private IDataSet getDataSetNovRankear() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRankearNovedad");
		dataset.fieldDef(new Field("oid_rankear_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("aplicar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("suma_o_resta", Field.STRING, 20));
		dataset.fieldDef(new Field("calif_en_puntos", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("analizar_ult_meses", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ponderacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("desc_tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_motivo", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetSanRankear() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSancionRank");
		dataset.fieldDef(new Field("oid_sancion_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("aplicar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("suma_o_resta", Field.STRING, 20));
		dataset.fieldDef(new Field("calif_en_puntos", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("analizar_ult_meses", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ponderacion", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarRegSancion(IDataSet ds, Integer oidSancionRank, Integer oidSancion, String descSancion, boolean activo, boolean aplicar, String sumaResta, Money califEnPuntos,
			RankearCab rankear, Integer ultMeses, Money ponderacion) throws BaseException {
		ds.append();
		ds.fieldValue("oid_sancion_rank", oidSancionRank);
		ds.fieldValue("oid_mot_sancion", oidSancion);
		ds.fieldValue("desc_mot_sancion", descSancion);
		ds.fieldValue("activo", activo);
		ds.fieldValue("aplicar", aplicar);
		ds.fieldValue("suma_o_resta", sumaResta);
		ds.fieldValue("calif_en_puntos", califEnPuntos);
		ds.fieldValue("oid_rankear", rankear.getOIDInteger());
		ds.fieldValue("analizar_ult_meses", ultMeses);
		ds.fieldValue("ponderacion", ponderacion);
	}

	private IDataSet getDataSetCondMinSan1() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinSanc6");
		dataset.fieldDef(new Field("oid_cond_min_sanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinSan2() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinSanc7");
		dataset.fieldDef(new Field("oid_cond_min_sanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinSan3() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinSanc8");
		dataset.fieldDef(new Field("oid_cond_min_sanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinSan4() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinSanc9");
		dataset.fieldDef(new Field("oid_cond_min_sanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinSan5() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinSanc10");
		dataset.fieldDef(new Field("oid_cond_min_sanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void cargarCondMinSanc(IDataSet ds, 
								   Integer oidCondMinSan, 
								   Integer nroNovedad, 
								   RankearCab rankearCab, 
								   SancionesRRHH sancion, 
								   boolean activo) throws BaseException {
		ds.append();
		ds.fieldValue("oid_cond_min_sanc", oidCondMinSan);
		ds.fieldValue("nro_novedad", nroNovedad);
		ds.fieldValue("oid_rankear", rankearCab.getOIDInteger());
		ds.fieldValue("oid_mot_sancion", sancion.getOIDInteger());
		ds.fieldValue("desc_mot_sancion", sancion.getDescripcion());
		ds.fieldValue("activo", activo);
	}
	

	private IDataSet getDataSetCondMinNov1() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinRank1");
		dataset.fieldDef(new Field("oid_cond_min_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarCondMinRank(IDataSet ds, Integer oidCondMinRank, Integer nroNovedad, RankearCab rankearCab, TipoNovedad tipoNov, MotivoTipoNov motivo, boolean activo) throws BaseException {
		ds.append();
		ds.fieldValue("oid_cond_min_rank", oidCondMinRank);
		ds.fieldValue("nro_novedad", nroNovedad);
		ds.fieldValue("oid_rankear", rankearCab.getOIDInteger());
		if (tipoNov != null) {
			ds.fieldValue("oid_tipo_nov", tipoNov.getOIDInteger());
			ds.fieldValue("tipo_nov", tipoNov.getDescripcion());
		} else {
			ds.fieldValue("oid_tipo_nov", "");
			ds.fieldValue("tipo_nov", "");
		}
		if (motivo != null) {
			ds.fieldValue("oid_motivo", motivo.getOIDInteger());
			ds.fieldValue("motivo", motivo.getDescripcion());
		} else {
			ds.fieldValue("oid_motivo", "");
			ds.fieldValue("motivo", "");
		}

		ds.fieldValue("activo", activo);
	}

	private IDataSet getDataSetCondMinNov2() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinRank2");
		dataset.fieldDef(new Field("oid_cond_min_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinNov3() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinRank3");
		dataset.fieldDef(new Field("oid_cond_min_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinNov4() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinRank4");
		dataset.fieldDef(new Field("oid_cond_min_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinNov5() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinRank5");
		dataset.fieldDef(new Field("oid_cond_min_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarNovRank(IDataSet dataset, RankearNovedad rankearNovedad) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_rankear_nov", rankearNovedad.getOIDInteger());
		dataset.fieldValue("oid_rankear", rankearNovedad.getRankear().getOIDInteger());
		if (rankearNovedad.getTipo_novedad() != null)
			dataset.fieldValue("oid_tipo_nov", rankearNovedad.getTipo_novedad().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_nov", "");
		dataset.fieldValue("activo", rankearNovedad.isActivo());
		if (rankearNovedad.getMotivo() != null)
			dataset.fieldValue("oid_motivo", rankearNovedad.getMotivo().getOIDInteger());
		else
			dataset.fieldValue("oid_motivo", "");
		dataset.fieldValue("aplicar", rankearNovedad.isAplicar());
		dataset.fieldValue("suma_o_resta", rankearNovedad.getSuma_o_resta());
		dataset.fieldValue("calif_en_puntos", rankearNovedad.getCalif_en_puntos());
		dataset.fieldValue("analizar_ult_meses", rankearNovedad.getAnalizar_ult_meses());
		dataset.fieldValue("ponderacion", rankearNovedad.getPonderacion());
		if (rankearNovedad.getTipo_novedad() != null)
			dataset.fieldValue("desc_tipo_nov", rankearNovedad.getTipo_novedad().getDescripcion());
		else
			dataset.fieldValue("desc_tipo_nov", "");
		if (rankearNovedad.getMotivo() != null)
			dataset.fieldValue("desc_motivo", rankearNovedad.getMotivo().getDescripcion());
		else
			dataset.fieldValue("desc_motivo", "");
	}

	private void cargarNovRank(IDataSet dataset, int secu, RankearCab rankearCab, MotivoTipoNov motivo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_rankear_nov", secu);
		dataset.fieldValue("oid_rankear", rankearCab.getOIDInteger());
		if (motivo.getTipo_novedad() != null)
			dataset.fieldValue("oid_tipo_nov", motivo.getTipo_novedad().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_nov", "");
		dataset.fieldValue("activo", true);
		if (motivo != null)
			dataset.fieldValue("oid_motivo", motivo.getOIDInteger());
		else
			dataset.fieldValue("oid_motivo", "");
		dataset.fieldValue("aplicar", false);
		dataset.fieldValue("suma_o_resta", "");
		dataset.fieldValue("calif_en_puntos", "");
		dataset.fieldValue("analizar_ult_meses", "");
		dataset.fieldValue("ponderacion", "");
		if (motivo.getTipo_novedad() != null)
			dataset.fieldValue("desc_tipo_nov", motivo.getTipo_novedad().getDescripcion());
		else
			dataset.fieldValue("desc_tipo_nov", "");
		dataset.fieldValue("desc_motivo", motivo.getDescripcion());

	}

	private void cargarRegistroSanciones(IDataSet datasetRankearSan, RankearCab rankearcab) throws BaseException {

		int secu = -1;
		Iterator iterSanciones = SancionesRRHH.getAllSanciones(this.getSesion()).iterator();
		while (iterSanciones.hasNext()) {
			--secu;
			SancionesRRHH sancion = (SancionesRRHH) iterSanciones.next();
			SancionRankear sancionRankear = SancionRankear.getSancionRankear(rankearcab, sancion, this.getSesion());

			boolean aplicar = false;
			String sumaResta = null;
			Money clasifPuntos = null;
			Integer ultMeses = null;
			Money ponderacion = null;

			if (sancionRankear != null) {
				aplicar = sancionRankear.isAplicar();
				sumaResta = sancionRankear.getSuma_o_resta();
				clasifPuntos = sancionRankear.getCalif_en_puntos();
				ultMeses = sancionRankear.getAnalizar_ult_meses();
				ponderacion = sancionRankear.getPonderacion();
			}

			cargarRegSancion(datasetRankearSan, secu, sancion.getOIDInteger(), sancion.getDescripcion(), true, aplicar, sumaResta, clasifPuntos, rankearcab, ultMeses, ponderacion);

		}

	}

	private void cargarRegistroNovRank(IDataSet datasetRankearNov, RankearCab rankearCab) throws BaseException {
		int secu = -1;
		Iterator iterMotTiposNov = MotivoTipoNov.getAllActivos(this.getSesion()).iterator();
		while (iterMotTiposNov.hasNext()) {
			MotivoTipoNov motivoTipoNov = (MotivoTipoNov) iterMotTiposNov.next();
			RankearNovedad rankearNovedad = RankearNovedad.getRankearNovedad(rankearCab, motivoTipoNov.getTipo_novedad(), motivoTipoNov, this.getSesion());

			if (rankearNovedad != null) {
				cargarNovRank(datasetRankearNov, rankearNovedad);
			} else {
				--secu;
				cargarNovRank(datasetRankearNov, secu, rankearCab, motivoTipoNov);
			}
		}
	}

}
