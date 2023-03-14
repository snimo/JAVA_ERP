package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.CondMinRankeador;
import com.srn.erp.rrhh.bm.CondMinSancion;
import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.RankearNovedad;
import com.srn.erp.rrhh.bm.SancionRankear;
import com.srn.erp.rrhh.bm.SancionesRRHH;
import com.srn.erp.rrhh.bm.TipoNovedad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRankearCab extends Operation {

	public SaveRankearCab() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TRankearCab");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			RankearCab rankearcab = RankearCab.findByOid(dataset.getInteger("oid_rankear"), getSesion());
			rankearcab.setOID(dataset.getInteger("oid_rankear"));
			rankearcab.setCodigo(dataset.getString("codigo"));
			rankearcab.setDescripcion(dataset.getString("descripcion"));
			rankearcab.setActivo(dataset.getBoolean("activo"));
			rankearcab.setRank_por_ant_emp(dataset.getBoolean("rank_por_ant_emp"));
			rankearcab.setPtos_ant_emp(dataset.getMoney("ptos_ant_emp"));
			rankearcab.setUnitiempoantemp(dataset.getString("ut_ant_emp"));
			rankearcab.setPond_ant_emp(dataset.getMoney("pond_ant_emp"));
			rankearcab.setRank_por_ant_pue(dataset.getBoolean("rank_por_ant_pue"));
			rankearcab.setPtos_ant_pue(dataset.getMoney("ptos_ant_pue"));
			rankearcab.setUt_ant_pue(dataset.getString("ut_ant_pue"));
			rankearcab.setPond_ant_pue(dataset.getMoney("pond_ant_pue"));
			rankearcab.setRank_por_novedad(dataset.getBoolean("rank_por_novedad"));
			rankearcab.setRank_por_eval(dataset.getBoolean("rank_por_eval"));
			rankearcab.setEval_ult_meses(dataset.getInteger("eval_ult_meses"));
			rankearcab.setEval_calif_punto(dataset.getMoney("eval_calif_punto"));
			rankearcab.setEval_ponderacion(dataset.getMoney("eval_ponderacion"));
			rankearcab.setCm_ant_req_emp(dataset.getBoolean("cm_ant_req_emp"));
			rankearcab.setCm_cant_req_emp(dataset.getInteger("cm_cant_req_emp"));
			rankearcab.setCm_ut_req_emp(dataset.getString("cm_ut_req_emp"));
			rankearcab.setCm_ant_req_pue(dataset.getBoolean("cm_ant_req_pue"));
			rankearcab.setCm_cant_req_pue(dataset.getInteger("cm_cant_req_pue"));
			rankearcab.setCm_ut_req_pue(dataset.getString("cm_ut_req_pue"));
			rankearcab.setCm_aplicar_eval(dataset.getBoolean("cm_aplicar_eval"));
			rankearcab.setCm_puntaje_eval(dataset.getMoney("cm_puntaje_eval"));
			rankearcab.setCm_aplic_nov_1(dataset.getBoolean("cm_aplic_nov_1"));
			rankearcab.setCm_dias_nov_1(dataset.getInteger("cm_dias_nov_1"));
			rankearcab.setCm_ult_mes_nov_1(dataset.getInteger("cm_ult_mes_nov_1"));
			rankearcab.setCm_motivos_1(dataset.getString("cm_motivos_1"));
			rankearcab.setCm_aplic_nov_2(dataset.getBoolean("cm_aplic_nov_2"));
			rankearcab.setCm_dias_nov_2(dataset.getInteger("cm_dias_nov_2"));
			rankearcab.setCm_ult_mes_nov_2(dataset.getInteger("cm_ult_mes_nov_2"));
			rankearcab.setCm_motivos_2(dataset.getString("cm_motivos_2"));
			rankearcab.setCm_aplic_nov_3(dataset.getBoolean("cm_aplic_nov_3"));
			rankearcab.setCm_dias_nov_3(dataset.getInteger("cm_dias_nov_3"));
			rankearcab.setCm_ult_mes_nov_3(dataset.getInteger("cm_ult_mes_nov_3"));
			rankearcab.setCm_motivos_3(dataset.getString("cm_motivos_3"));
			rankearcab.setCm_aplic_nov_4(dataset.getBoolean("cm_aplic_nov_4"));
			rankearcab.setCm_dias_nov_4(dataset.getInteger("cm_dias_nov_4"));
			rankearcab.setCm_ult_mes_nov_4(dataset.getInteger("cm_ult_mes_nov_4"));
			rankearcab.setCm_motivos_4(dataset.getString("cm_motivos_4"));
			rankearcab.setCm_aplic_nov_5(dataset.getBoolean("cm_aplic_nov_5"));
			rankearcab.setCm_dias_nov_5(dataset.getInteger("cm_dias_nov_5"));
			rankearcab.setCm_ult_mes_nov_5(dataset.getInteger("cm_ult_mes_nov_5"));
			rankearcab.setCm_motivos_5(dataset.getString("cm_motivos_5"));
			rankearcab.setRankearPorSancion(dataset.getBoolean("rank_por_sancion"));
			rankearcab.setControlarEstadoDesa(dataset.getBoolean("control_esta_desa"));
			rankearcab.setAplicHoriCarrera(dataset.getBoolean("cm_aplic_hor_car"));
			

			rankearcab.setCm_aplic_nov_6(dataset.getBoolean("cm_aplic_nov_6"));
			rankearcab.setCm_dias_nov_6(dataset.getInteger("cm_dias_nov_6"));
			rankearcab.setCm_ult_mes_nov_6(dataset.getInteger("cm_ult_mes_nov_6"));
			rankearcab.setCm_motivos_6(dataset.getString("cm_motivos_6"));

			rankearcab.setCm_aplic_nov_7(dataset.getBoolean("cm_aplic_nov_7"));
			rankearcab.setCm_dias_nov_7(dataset.getInteger("cm_dias_nov_7"));
			rankearcab.setCm_ult_mes_nov_7(dataset.getInteger("cm_ult_mes_nov_7"));
			rankearcab.setCm_motivos_7(dataset.getString("cm_motivos_7"));

			rankearcab.setCm_aplic_nov_8(dataset.getBoolean("cm_aplic_nov_8"));
			rankearcab.setCm_dias_nov_8(dataset.getInteger("cm_dias_nov_8"));
			rankearcab.setCm_ult_mes_nov_8(dataset.getInteger("cm_ult_mes_nov_8"));
			rankearcab.setCm_motivos_8(dataset.getString("cm_motivos_8"));

			rankearcab.setCm_aplic_nov_9(dataset.getBoolean("cm_aplic_nov_9"));
			rankearcab.setCm_dias_nov_9(dataset.getInteger("cm_dias_nov_9"));
			rankearcab.setCm_ult_mes_nov_9(dataset.getInteger("cm_ult_mes_nov_9"));
			rankearcab.setCm_motivos_9(dataset.getString("cm_motivos_9"));

			rankearcab.setCm_aplic_nov_10(dataset.getBoolean("cm_aplic_nov_10"));
			rankearcab.setCm_dias_nov_10(dataset.getInteger("cm_dias_nov_10"));
			rankearcab.setCm_ult_mes_nov_10(dataset.getInteger("cm_ult_mes_nov_10"));
			rankearcab.setCm_motivos_10(dataset.getString("cm_motivos_10"));
			
			rankearcab.setAplicCaligGral(dataset.getBoolean("cm_calif_gral"));
			rankearcab.setPtosMinCalifGral(dataset.getMoney("cm_ptos_min_calif"));
			rankearcab.setAplicCMJuegosA(dataset.getBoolean("cm_aplic_juegos_a"));
			
			
			rankearcab.setDesapruebaSiSancRestanMas(dataset.getBoolean("des_sanc_rest_mas"));
			rankearcab.setDesapruebaSiNoveRestanMas(dataset.getBoolean("des_nov_rest_mas"));
			rankearcab.setPtosMaxDesapruebaSanc(dataset.getMoney("ptos_max_rest_sanc"));
			rankearcab.setPtosMaxDesapruebaNov(dataset.getMoney("ptos_max_rest_nov"));

			IDataSet dsSanciones = dataset.getDataSet("TSancionRank");
			dsSanciones.first();
			while (!dsSanciones.EOF()) {
				SancionesRRHH sancion = SancionesRRHH.findByOidProxy(dsSanciones.getInteger("oid_mot_sancion"), this.getSesion());
				SancionRankear sancionRankear = SancionRankear.getSancionRankear(rankearcab, sancion, this.getSesion());

				if (sancionRankear == null) {
					sancionRankear = (SancionRankear) SancionRankear.getNew(SancionRankear.NICKNAME, this.getSesion());
				}

				sancionRankear.setActivo(true);
				sancionRankear.setAplicar(dsSanciones.getBoolean("aplicar"));
				sancionRankear.setSuma_o_resta(dsSanciones.getString("suma_o_resta"));
				sancionRankear.setCalif_en_puntos(dsSanciones.getMoney("calif_en_puntos"));
				sancionRankear.setOid_rankear(rankearcab);
				sancionRankear.setAnalizar_ult_meses(dsSanciones.getInteger("analizar_ult_meses"));
				sancionRankear.setPonderacion(dsSanciones.getMoney("ponderacion"));
				sancionRankear.setMotivo_sancion(sancion);

				rankearcab.addRankSancion(sancionRankear);

				dsSanciones.next();
			}

			IDataSet dsTiposNov = dataset.getDataSet("TRankearNovedad");
			dsTiposNov.first();
			while (!dsTiposNov.EOF()) {

				TipoNovedad tipoNov = TipoNovedad.findByOidProxy(dsTiposNov.getInteger("oid_tipo_nov"), this.getSesion());
				MotivoTipoNov motivo = MotivoTipoNov.findByOidProxy(dsTiposNov.getInteger("oid_motivo"), this.getSesion());

				RankearNovedad rankearNovedad = RankearNovedad.getRankearNovedad(rankearcab, tipoNov, motivo, this.getSesion());

				if (rankearNovedad == null) {
					rankearNovedad = (RankearNovedad) RankearNovedad.getNew(RankearNovedad.NICKNAME, this.getSesion());
				}

				rankearNovedad.setRankear(rankearcab);
				rankearNovedad.setTipo_novedad(TipoNovedad.findByOidProxy(dsTiposNov.getInteger("oid_tipo_nov"), this.getSesion()));
				rankearNovedad.setActivo(true);
				rankearNovedad.setMotivo(MotivoTipoNov.findByOidProxy(dsTiposNov.getInteger("oid_motivo"), this.getSesion()));
				rankearNovedad.setAplicar(dsTiposNov.getBoolean("aplicar"));
				rankearNovedad.setSuma_o_resta(dsTiposNov.getString("suma_o_resta"));
				rankearNovedad.setCalif_en_puntos(dsTiposNov.getMoney("calif_en_puntos"));
				rankearNovedad.setAnalizar_ult_meses(dsTiposNov.getInteger("analizar_ult_meses"));
				rankearNovedad.setPonderacion(dsTiposNov.getMoney("ponderacion"));
				rankearcab.addRankNovedad(rankearNovedad);
				dsTiposNov.next();
			}

			IDataSet dsSan1 = dataset.getDataSet("TCondMinSanc6");
			dsSan1.first();
			while (!dsSan1.EOF()) {
				SancionesRRHH sancion = SancionesRRHH.findByOidProxy(dsSan1.getInteger("oid_mot_sancion"), this.getSesion());
				CondMinSancion condMinSan = CondMinSancion.getCondMinSancion(6, rankearcab, sancion, this.getSesion());
				if (condMinSan == null)
					condMinSan = (CondMinSancion) CondMinSancion.getNew(CondMinSancion.NICKNAME, this.getSesion());
				condMinSan.setNro_novedad(6);
				condMinSan.setRankear(rankearcab);
				condMinSan.setOid_mot_sancion(sancion);
				condMinSan.setActivo(dsSan1.getBoolean("activo"));
				rankearcab.addCondMinSancion(condMinSan);
				dsSan1.next();
			}
			
			IDataSet dsSan2 = dataset.getDataSet("TCondMinSanc7");
			dsSan2.first();
			while (!dsSan2.EOF()) {
				SancionesRRHH sancion = SancionesRRHH.findByOidProxy(dsSan2.getInteger("oid_mot_sancion"), this.getSesion());
				CondMinSancion condMinSan = CondMinSancion.getCondMinSancion(7, rankearcab, sancion, this.getSesion());
				if (condMinSan == null)
					condMinSan = (CondMinSancion) CondMinSancion.getNew(CondMinSancion.NICKNAME, this.getSesion());
				condMinSan.setNro_novedad(7);
				condMinSan.setRankear(rankearcab);
				condMinSan.setOid_mot_sancion(sancion);
				condMinSan.setActivo(dsSan2.getBoolean("activo"));
				rankearcab.addCondMinSancion(condMinSan);
				dsSan2.next();
			}
			
			IDataSet dsSan3 = dataset.getDataSet("TCondMinSanc8");
			dsSan3.first();
			while (!dsSan3.EOF()) {
				SancionesRRHH sancion = SancionesRRHH.findByOidProxy(dsSan3.getInteger("oid_mot_sancion"), this.getSesion());
				CondMinSancion condMinSan = CondMinSancion.getCondMinSancion(8, rankearcab, sancion, this.getSesion());
				if (condMinSan == null)
					condMinSan = (CondMinSancion) CondMinSancion.getNew(CondMinSancion.NICKNAME, this.getSesion());
				condMinSan.setNro_novedad(8);
				condMinSan.setRankear(rankearcab);
				condMinSan.setOid_mot_sancion(sancion);
				condMinSan.setActivo(dsSan3.getBoolean("activo"));
				rankearcab.addCondMinSancion(condMinSan);
				dsSan3.next();
			}
			
			IDataSet dsSan4 = dataset.getDataSet("TCondMinSanc9");
			dsSan4.first();
			while (!dsSan4.EOF()) {
				SancionesRRHH sancion = SancionesRRHH.findByOidProxy(dsSan4.getInteger("oid_mot_sancion"), this.getSesion());
				CondMinSancion condMinSan = CondMinSancion.getCondMinSancion(9, rankearcab, sancion, this.getSesion());
				if (condMinSan == null)
					condMinSan = (CondMinSancion) CondMinSancion.getNew(CondMinSancion.NICKNAME, this.getSesion());
				condMinSan.setNro_novedad(9);
				condMinSan.setRankear(rankearcab);
				condMinSan.setOid_mot_sancion(sancion);
				condMinSan.setActivo(dsSan4.getBoolean("activo"));
				rankearcab.addCondMinSancion(condMinSan);
				dsSan4.next();
			}
			
			IDataSet dsSan5 = dataset.getDataSet("TCondMinSanc10");
			dsSan5.first();
			while (!dsSan5.EOF()) {
				SancionesRRHH sancion = SancionesRRHH.findByOidProxy(dsSan5.getInteger("oid_mot_sancion"), this.getSesion());
				CondMinSancion condMinSan = CondMinSancion.getCondMinSancion(10, rankearcab, sancion, this.getSesion());
				if (condMinSan == null)
					condMinSan = (CondMinSancion) CondMinSancion.getNew(CondMinSancion.NICKNAME, this.getSesion());
				condMinSan.setNro_novedad(10);
				condMinSan.setRankear(rankearcab);
				condMinSan.setOid_mot_sancion(sancion);
				condMinSan.setActivo(dsSan5.getBoolean("activo"));
				rankearcab.addCondMinSancion(condMinSan);
				dsSan5.next();
			}			
			
			
			

			IDataSet dsNov1 = dataset.getDataSet("TCondMinRank1");
			dsNov1.first();
			while (!dsNov1.EOF()) {
				TipoNovedad tipoNovedad = TipoNovedad.findByOidProxy(dsNov1.getInteger("oid_tipo_nov"), this.getSesion());
				MotivoTipoNov motivo = MotivoTipoNov.findByOidProxy(dsNov1.getInteger("oid_motivo"), this.getSesion());
				CondMinRankeador condMinRank = CondMinRankeador.getCondMinRankeador(1, rankearcab, tipoNovedad, motivo, this.getSesion());
				if (condMinRank != null) {
					condMinRank.setActivo(dsNov1.getBoolean("activo"));
					rankearcab.addCondMinRankeador(condMinRank);
				} else {
					CondMinRankeador condMinRankeador = (CondMinRankeador) CondMinRankeador.getNew(CondMinRankeador.NICKNAME, this.getSesion());
					condMinRankeador.setNro_novedad(1);
					condMinRankeador.setRankear(rankearcab);
					condMinRankeador.setTipo_novedad(tipoNovedad);
					condMinRankeador.setMotivo(motivo);
					condMinRankeador.setActivo(dsNov1.getBoolean("activo"));
					rankearcab.addCondMinRankeador(condMinRankeador);
				}

				dsNov1.next();
			}

			IDataSet dsNov2 = dataset.getDataSet("TCondMinRank2");
			dsNov2.first();
			while (!dsNov2.EOF()) {
				TipoNovedad tipoNovedad = TipoNovedad.findByOidProxy(dsNov2.getInteger("oid_tipo_nov"), this.getSesion());
				MotivoTipoNov motivo = MotivoTipoNov.findByOidProxy(dsNov2.getInteger("oid_motivo"), this.getSesion());
				CondMinRankeador condMinRank = CondMinRankeador.getCondMinRankeador(2, rankearcab, tipoNovedad, motivo, this.getSesion());
				if (condMinRank != null) {
					condMinRank.setActivo(dsNov2.getBoolean("activo"));
					rankearcab.addCondMinRankeador(condMinRank);
				} else {
					CondMinRankeador condMinRankeador = (CondMinRankeador) CondMinRankeador.getNew(CondMinRankeador.NICKNAME, this.getSesion());
					condMinRankeador.setNro_novedad(2);
					condMinRankeador.setRankear(rankearcab);
					condMinRankeador.setTipo_novedad(tipoNovedad);
					condMinRankeador.setMotivo(motivo);
					condMinRankeador.setActivo(dsNov2.getBoolean("activo"));
					rankearcab.addCondMinRankeador(condMinRankeador);
				}

				dsNov2.next();
			}

			IDataSet dsNov3 = dataset.getDataSet("TCondMinRank3");
			dsNov3.first();
			while (!dsNov3.EOF()) {
				TipoNovedad tipoNovedad = TipoNovedad.findByOidProxy(dsNov3.getInteger("oid_tipo_nov"), this.getSesion());
				MotivoTipoNov motivo = MotivoTipoNov.findByOidProxy(dsNov3.getInteger("oid_motivo"), this.getSesion());
				CondMinRankeador condMinRank = CondMinRankeador.getCondMinRankeador(3, rankearcab, tipoNovedad, motivo, this.getSesion());
				if (condMinRank != null) {
					condMinRank.setActivo(dsNov3.getBoolean("activo"));
					rankearcab.addCondMinRankeador(condMinRank);
				} else {
					CondMinRankeador condMinRankeador = (CondMinRankeador) CondMinRankeador.getNew(CondMinRankeador.NICKNAME, this.getSesion());
					condMinRankeador.setNro_novedad(3);
					condMinRankeador.setRankear(rankearcab);
					condMinRankeador.setTipo_novedad(tipoNovedad);
					condMinRankeador.setMotivo(motivo);
					condMinRankeador.setActivo(dsNov3.getBoolean("activo"));
					rankearcab.addCondMinRankeador(condMinRankeador);
				}

				dsNov3.next();
			}

			IDataSet dsNov4 = dataset.getDataSet("TCondMinRank4");
			dsNov4.first();
			while (!dsNov4.EOF()) {
				TipoNovedad tipoNovedad = TipoNovedad.findByOidProxy(dsNov4.getInteger("oid_tipo_nov"), this.getSesion());
				MotivoTipoNov motivo = MotivoTipoNov.findByOidProxy(dsNov4.getInteger("oid_motivo"), this.getSesion());
				CondMinRankeador condMinRank = CondMinRankeador.getCondMinRankeador(4, rankearcab, tipoNovedad, motivo, this.getSesion());
				if (condMinRank != null) {
					condMinRank.setActivo(dsNov4.getBoolean("activo"));
					rankearcab.addCondMinRankeador(condMinRank);
				} else {
					CondMinRankeador condMinRankeador = (CondMinRankeador) CondMinRankeador.getNew(CondMinRankeador.NICKNAME, this.getSesion());
					condMinRankeador.setNro_novedad(4);
					condMinRankeador.setRankear(rankearcab);
					condMinRankeador.setTipo_novedad(tipoNovedad);
					condMinRankeador.setMotivo(motivo);
					condMinRankeador.setActivo(dsNov4.getBoolean("activo"));
					rankearcab.addCondMinRankeador(condMinRankeador);
				}

				dsNov4.next();
			}

			IDataSet dsNov5 = dataset.getDataSet("TCondMinRank5");
			dsNov5.first();
			while (!dsNov5.EOF()) {
				TipoNovedad tipoNovedad = TipoNovedad.findByOidProxy(dsNov5.getInteger("oid_tipo_nov"), this.getSesion());
				MotivoTipoNov motivo = MotivoTipoNov.findByOidProxy(dsNov5.getInteger("oid_motivo"), this.getSesion());
				CondMinRankeador condMinRank = CondMinRankeador.getCondMinRankeador(5, rankearcab, tipoNovedad, motivo, this.getSesion());
				if (condMinRank != null) {
					condMinRank.setActivo(dsNov5.getBoolean("activo"));
					rankearcab.addCondMinRankeador(condMinRank);
				} else {
					CondMinRankeador condMinRankeador = (CondMinRankeador) CondMinRankeador.getNew(CondMinRankeador.NICKNAME, this.getSesion());
					condMinRankeador.setNro_novedad(5);
					condMinRankeador.setRankear(rankearcab);
					condMinRankeador.setTipo_novedad(tipoNovedad);
					condMinRankeador.setMotivo(motivo);
					condMinRankeador.setActivo(dsNov5.getBoolean("activo"));
					rankearcab.addCondMinRankeador(condMinRankeador);
				}

				dsNov5.next();
			}

			addTransaccion(rankearcab);
			dataset.next();
		}
	}

}
