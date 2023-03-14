package com.srn.erp.rrhh.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.CantSancionesPorTitu;
import com.srn.erp.rrhh.bm.CategPosibleLeg;
import com.srn.erp.rrhh.bm.CronogramaDesa;
import com.srn.erp.rrhh.bm.DetConsPlanDesa;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.MesCronoDesa;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.rrhh.bm.MotivosNoAprob;
import com.srn.erp.rrhh.bm.ObsLegajo;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.RemplazoAcumLeg;
import com.srn.erp.rrhh.bm.TipoObsLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPropuRecateg extends Operation {

	public TraerPropuRecateg() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsFiltros = this.getDataSetFiltros();
		IDataSet dsAccion = this.getDataSetAccion();
		IDataSet dsConsulta = this.getDataSetPropuRecateg();
		IDataSet dsCantCol = getColCantNov();

		java.util.Date fecActual = UtilCIP.getTruncDate(UtilCIP.getFechaHoraActual(this.getSesion()));
		TipoObsLeg tipoObsLegIRL = TipoObsLeg.getTipoObsRelLab(this.getSesion());

		CronogramaDesa cronogramaDesa = null;
		Integer anio = null;
		String mes = null;
		List listaAcciones = new ArrayList();
		HashTableDatos horasAcumRem = null;

		IDataSet dsInput = mapaDatos.getDataSet("TInput");
		dsInput.first();
		while (!dsInput.EOF()) {

			cronogramaDesa = CronogramaDesa.findByOidProxy(dsInput.getInteger("oid_cronograma"), this.getSesion());

			if (cronogramaDesa == null)
				throw new ExceptionValidation(null, "Debe seleccionar un Cronograma");

			mes = dsInput.getString("mes");
			anio = dsInput.getInteger("anio");

			if (cronogramaDesa == null)
				throw new ExceptionValidation(null, "Debe seleccionar un Mes");

			cargarRegistroAccionesDesa(dsFiltros, cronogramaDesa, getDescMes(mes) + "-" + anio, "", mes, anio);

			dsInput.next();
		}

		// Obtener el Periodo
		java.util.Date fecHastaPeriAEval = getFecHastaPeriEval(anio, mes);
		int mesFinEval = MesCronoDesa.getNroMes(mes) - 1;
		int anioFinEval = anio;

		if (mesFinEval == 0) {
			mesFinEval = 12;
			anioFinEval = anioFinEval - 1;
		}
		String mes2Dig = mesFinEval + "";
		if (mes2Dig.length() == 1)
			mes2Dig = "0" + mes2Dig;
		String periodo = anioFinEval + "." + mes2Dig;
		horasAcumRem = getRempHorasAcum(periodo);

		IDataSet dsAcciones = mapaDatos.getDataSet("TAccionesCronograma");
		dsAcciones.first();
		while (!dsAcciones.EOF()) {

			if (dsAcciones.getBoolean("seleccionar")) {
				AccCronoDesa accCronoDesa = AccCronoDesa.findByOid(dsAcciones.getInteger("oid_accion"), this.getSesion());
				listaAcciones.add(accCronoDesa);
				cargarRegistroAccion(dsAccion, accCronoDesa.getAccion());
			}

			dsAcciones.next();
		}

		CantSancionesPorTitu cantSancionesPorTitu = new CantSancionesPorTitu();

		if ((cronogramaDesa != null) && (mes != null)) {
			Iterator detCons = DetConsPlanDesa.getListaDetConsPlanDesa(cronogramaDesa, mes, listaAcciones, this.getSesion()).iterator();
			while (detCons.hasNext()) {
				DetConsPlanDesa detConsPlanDesa = (DetConsPlanDesa) detCons.next();

				
				
				// if (detConsPlanDesa.getEstadoDesarrollo() != null) {
				// if (detConsPlanDesa.getEstadoDesarrollo().isNo_promocionar()
				// == true)
				// continue;
				// }

				Integer cantJuegosA = null;
				Integer cantJuegosB = null;

				if (detConsPlanDesa.getGradoLegajo() != null) {
					cantJuegosA = detConsPlanDesa.getGradoLegajo().getCantJuegosA();
					cantJuegosB = detConsPlanDesa.getGradoLegajo().getCantJuegosB();
				}

				ValorClasificadorEntidad categPosible = null;
				Legajo legajo = Legajo.findByOidProxy(detConsPlanDesa.getOidLegajo(), this.getSesion());
				CategPosibleLeg categPosibleLeg = legajo.getCategoriaPosible(fecActual);

				java.util.Date fecUltRecateg = legajo.getFecUltRecateg();
				java.util.Date fecUltRecategDia1 = legajo.getFecUltRecategDia1();

				if ((categPosibleLeg != null) && (categPosibleLeg.getCateg_posible() != null))
					categPosible = categPosibleLeg.getCateg_posible();

				if (categPosible == null) {

					// Buscar la Categoria en la Jerarquia
					if (detConsPlanDesa.getPosibleCategoria() != null)
						categPosible = detConsPlanDesa.getPosibleCategoria();

					// Buscar la categoria en la Accion
					if (categPosible == null) {
						AccCronoDesa accCronoDesa = AccCronoDesa.findByOidProxy(detConsPlanDesa.getOidAccion(), this.getSesion());
						categPosible = accCronoDesa.getCategoriaPosible();
					}

				}

				AccCronoDesa accion = AccCronoDesa.findByOidProxy(detConsPlanDesa.getOidAccion(), this.getSesion());
				RankearCab rankeador = legajo.getRankeador(accion, anio, mes);

				java.util.Date fecDesdeEval = null;
				if (rankeador != null) {
					int ultMeses = rankeador.getEval_ult_meses();
					fecDesdeEval = Legajo.getFecDesdeEval(ultMeses, fecHastaPeriAEval);
				}
				
				java.util.Date fecDesdeEvalPot = null;
				int ultMeses = detConsPlanDesa.getUltMesesEvalPot().intValue();
				fecDesdeEvalPot = Legajo.getFecDesdeEval(ultMeses, fecHastaPeriAEval);

				java.util.Date fecDesdeIRL = null;
				int ultMesesIRL = detConsPlanDesa.getUltMesesIRL().intValue();
				fecDesdeIRL = Legajo.getFecDesdeEval(ultMesesIRL, fecHastaPeriAEval);

				MotivosNoAprob motivosNoAprob = new MotivosNoAprob();

				EvaluacionLegajoCab evalDesemp = legajo.getUltimaEvalLegCab(fecDesdeEval, fecHastaPeriAEval, ModeloEvalCab.TIPO_DESEN);// EvaluacionLegajoCab.getUltimaEvaluacionLegajoCab(legajo,
																																		// this.getSesion());
				EvaluacionLegajoCab evalPoten = legajo.getUltimaEvalLegCab(fecDesdeEvalPot, fecHastaPeriAEval, ModeloEvalCab.TIPO_POTEN);// EvaluacionLegajoCab.getUltimaEvaluacionLegajoCab(legajo,
																																			// this.getSesion());

				// Marca si corresponde que la Evaluacion de Potencial esta
				// Pendiente
				if ((detConsPlanDesa.isPendEvalSinPot() != null) && (detConsPlanDesa.isPendEvalSinPot().booleanValue())) {
					if (evalPoten == null)
						motivosNoAprob.addMotivoPendiente("Falta Evaluación de potencial. (P)", motivosNoAprob.getKEY_MOT_Falta_Eval_Potencial());
				}
				
				
				//detConsPlanDesa.getMesesHoriCarrera()
				int antSectorMeses = legajo.getAntiEnMesesSector(detConsPlanDesa.getValClasifEmp(), detConsPlanDesa.getValClasifSec(), fecHastaPeriAEval); 

				// **************************************** //
				// *** No tiene evaluacion de desempeño *** //
				// **************************************** //
				if ((detConsPlanDesa.isPendEvalSiFaltaEvalDesemp() != null) && (detConsPlanDesa.isPendEvalSiFaltaEvalDesemp().booleanValue())) {
					if (evalDesemp == null)
						motivosNoAprob.addMotivoPendiente("Falta evaluación de desempeño. (P)", motivosNoAprob.getKEY_MOT_Clasif_Gral_Min());
				}

				ObsLegajo obsLegajo = legajo.getUltObsLegajo(tipoObsLegIRL, fecDesdeIRL, fecHastaPeriAEval);

				if ((detConsPlanDesa.isPendEvalSinIRL() != null) && (detConsPlanDesa.isPendEvalSinIRL().booleanValue())) {
					if (obsLegajo == null)
						motivosNoAprob.addMotivoPendiente("Falta Informe de Relaciones Laborales. (P)", motivosNoAprob.getKEY_MOT_Falta_Inf_RelLab());
				}

				cantSancionesPorTitu.initCantidades();

				int ranking = legajo.getRankingDesarrollo(
						null, 
						cantSancionesPorTitu, 
						motivosNoAprob, 
						AccCronoDesa.findByOidProxy(detConsPlanDesa.getOidAccion(), this.getSesion()), 
						anio, 
						mes,
						detConsPlanDesa.isPendEvalSiFaltaEvalDesemp(), 
						detConsPlanDesa.isPendEvalSiFaltaJuego(),
						detConsPlanDesa.getMesesHoriCarrera(),
						antSectorMeses);

				Integer horasAcumRemplazo = null;
				RemplazoAcumLeg objHorasRemp = (RemplazoAcumLeg) horasAcumRem.get(detConsPlanDesa.getLegajo());
				if (objHorasRemp != null)
					horasAcumRemplazo = objHorasRemp.getHoras_acum();

				// int difMesesHC = Fecha.getAntiguedadEnMeses(
				// legajo.getFecAntParaDesa(),
				// Fecha.getFechaDiaPosterior(legajo.getFecHastaPeriEval(anio,
				// mes)));

				// difMesesHC = difMesesHC -
				// detConsPlanDesa.getMesesHoriCarrera();
				// difMesesHC = difMesesHC * -1;

				String claseSindicato = "";
				if (legajo.getClaseSindicato()!=null)
					claseSindicato = legajo.getClaseSindicato().getDescripcion(); 

				cargarRegPropuRecateg(dsConsulta, legajo, fecHastaPeriAEval, detConsPlanDesa.getOidCronograma(), detConsPlanDesa.getCronograma(), detConsPlanDesa.getOidAccion(), detConsPlanDesa
						.getAccion(), detConsPlanDesa.getOidLegajo(), detConsPlanDesa.getLegajo(), detConsPlanDesa.getApellido(), detConsPlanDesa.getNombre(), detConsPlanDesa.getFecIngreso(), Fecha
						.getLabelAntiguedad(legajo.getFecAntParaDesa(), Fecha.getFechaDiaPosterior(legajo.getFecHastaPeriEval(anio, mes))), detConsPlanDesa.getValClasifEmp(), detConsPlanDesa
						.getValClasifSec(), detConsPlanDesa.getValClasifPue(), cantJuegosA, cantJuegosB, categPosible, fecUltRecateg, Fecha.getLabelAntiguedad(fecUltRecategDia1, Fecha
						.getFechaDiaPosterior(legajo.getFecHastaPeriEval(anio, mes))), evalDesemp, evalPoten, ranking, motivosNoAprob.aprobado(), motivosNoAprob.getMotivos(), cantSancionesPorTitu,
						horasAcumRemplazo, detConsPlanDesa.getCantMinJuegosA(), detConsPlanDesa.getAntiguedadHorCarrera(), detConsPlanDesa.getMesesHoriCarrera(), obsLegajo, motivosNoAprob
								.isPendCargaEvalDesempenio(), motivosNoAprob.isPendCargaEvalPotencia(), motivosNoAprob.isPendCargaCantJuegosA(), motivosNoAprob.isPendCargaInfRelLab(),claseSindicato);

			}
		}

		cargarRegCantColCant(dsCantCol, cantSancionesPorTitu);

		writeCliente(dsFiltros);
		writeCliente(dsAccion);
		writeCliente(dsConsulta);
		writeCliente(dsCantCol);
	}

	private int getDifMesesHC() throws BaseException {
		return 0;
	}

	private void cargarRegCantColCant(IDataSet ds, CantSancionesPorTitu cantSancionesPorTitu) throws BaseException {
		ds.append();
		ds.fieldValue("nro_col_1", cantSancionesPorTitu.getCantidad(0));
		ds.fieldValue("nro_col_2", cantSancionesPorTitu.getCantidad(1));
		ds.fieldValue("nro_col_3", cantSancionesPorTitu.getCantidad(2));
		ds.fieldValue("nro_col_4", cantSancionesPorTitu.getCantidad(3));
		ds.fieldValue("nro_col_5", cantSancionesPorTitu.getCantidad(4));
		ds.fieldValue("nro_col_6", cantSancionesPorTitu.getCantidad(5));
		ds.fieldValue("nro_col_7", cantSancionesPorTitu.getCantidad(6));
		ds.fieldValue("nro_col_8", cantSancionesPorTitu.getCantidad(7));
		ds.fieldValue("nro_col_9", cantSancionesPorTitu.getCantidad(8));
		ds.fieldValue("nro_col_10", cantSancionesPorTitu.getCantidad(9));
		;
		ds.fieldValue("titulo_1", cantSancionesPorTitu.getTitulo(0));
		ds.fieldValue("titulo_2", cantSancionesPorTitu.getTitulo(1));
		ds.fieldValue("titulo_3", cantSancionesPorTitu.getTitulo(2));
		ds.fieldValue("titulo_4", cantSancionesPorTitu.getTitulo(3));
		ds.fieldValue("titulo_5", cantSancionesPorTitu.getTitulo(4));
		ds.fieldValue("titulo_6", cantSancionesPorTitu.getTitulo(5));
		ds.fieldValue("titulo_7", cantSancionesPorTitu.getTitulo(6));
		ds.fieldValue("titulo_8", cantSancionesPorTitu.getTitulo(7));
		ds.fieldValue("titulo_9", cantSancionesPorTitu.getTitulo(8));
		ds.fieldValue("titulo_10", cantSancionesPorTitu.getTitulo(9));
	}

	private String getDescMes(String mes) throws BaseException {
		if (mes == null)
			return "";
		if (mes.equals(MesCronoDesa.ENERO))
			return "Enero";
		else if (mes.equals(MesCronoDesa.FEBRERO))
			return "Febrero";
		else if (mes.equals(MesCronoDesa.MARZO))
			return "Marzo";
		else if (mes.equals(MesCronoDesa.ABRIL))
			return "Abril";
		else if (mes.equals(MesCronoDesa.MAYO))
			return "Mayo";
		else if (mes.equals(MesCronoDesa.JUNIO))
			return "Junio";
		else if (mes.equals(MesCronoDesa.JULIO))
			return "Julio";
		else if (mes.equals(MesCronoDesa.AGOSTO))
			return "Agosto";
		else if (mes.equals(MesCronoDesa.SEPTIEMBRE))
			return "Septiembre";
		else if (mes.equals(MesCronoDesa.OCTUBRE))
			return "Octubre";
		else if (mes.equals(MesCronoDesa.NOVIEMBRE))
			return "Noviembre";
		else if (mes.equals(MesCronoDesa.DICIEMBRE))
			return "Diciembre";
		else
			return "";

	}

	private IDataSet getColCantNov() {
		IDataSet dataset = new TDataSet();
		dataset.create("TColNov");
		dataset.fieldDef(new Field("nro_col_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_col_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_col_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_col_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_col_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_col_6", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_col_7", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_col_8", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_col_9", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_col_10", Field.INTEGER, 0));
		dataset.fieldDef(new Field("titulo_1", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_2", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_3", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_4", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_5", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_6", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_7", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_8", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_9", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo_10", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetPropuRecateg() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsultaDesarrollo");
		dataset.fieldDef(new Field("oid_cronograma", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_cronograma", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_accion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_accion", Field.STRING, 5000));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("apellido", Field.STRING, 100));
		dataset.fieldDef(new Field("nombre", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_ingreso", Field.DATE, 0));
		dataset.fieldDef(new Field("ant_ingreso", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_val_clasif_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_val_clasif_emp", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_val_clasif_sec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_val_clasif_sec", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_val_clasif_pue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_val_clasif_pue", Field.STRING, 100));
		dataset.fieldDef(new Field("cant_juegos_a", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_juegos_b", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_categ_posible", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_categ_posible", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_ant_puesto", Field.DATE, 0));
		dataset.fieldDef(new Field("ant_puesto", Field.STRING, 50));
		dataset.fieldDef(new Field("evaluacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("desc_evaluacion", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_eval_desemp", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_eval_desemp", Field.INTEGER, 0));

		dataset.fieldDef(new Field("evaluacion_pot", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("desc_evaluacion_pot", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_eval_pot", Field.DATE, 0));
		dataset.fieldDef(new Field("puesto_eval_pot", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_eval_poten", Field.INTEGER, 0));

		dataset.fieldDef(new Field("ranking", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("aprobado", Field.STRING, 4));
		dataset.fieldDef(new Field("mot_no_aprob", Field.STRING, 1000));
		dataset.fieldDef(new Field("cant_nov_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_nov_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_nov_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_nov_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_nov_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_nov_6", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_nov_7", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_nov_8", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_nov_9", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_nov_10", Field.INTEGER, 0));
		dataset.fieldDef(new Field("horas_acum", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_min_juegos_a", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tiempo_hor_carrera", Field.STRING, 50));
		dataset.fieldDef(new Field("dif_meses_hc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("antiguedad_sector", Field.STRING, 50));
		dataset.fieldDef(new Field("ant_sec_meses", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_irl", Field.DATE, 0));
		dataset.fieldDef(new Field("result_irl", Field.STRING, 20));
		dataset.fieldDef(new Field("obs_irl", Field.MEMO, 0));
		dataset.fieldDef(new Field("pend_realizar_eval_des", Field.STRING, 2));
		dataset.fieldDef(new Field("pend_realizar_eval_pot", Field.STRING, 2));
		dataset.fieldDef(new Field("pend_realizar_irl", Field.STRING, 2));
		dataset.fieldDef(new Field("pend_realizar_carga_ja", Field.STRING, 2));
		dataset.fieldDef(new Field("clase_sindicato", Field.STRING, 100));
		
		return dataset;
	}

	private void cargarRegPropuRecateg(IDataSet ds, Legajo oLegajo, java.util.Date fecHastaPeriAEval, Integer oidCronograma, String descCronograma, Integer oidAccion, String descAccion,
			Integer oidLegajo, String legajo, String apellido, String nombre, java.util.Date fecIngreso, String antIngreso, ValorClasificadorEntidad valClasifEmp,
			ValorClasificadorEntidad valClasifSec, ValorClasificadorEntidad valClasifPue, Integer cantJuegosA, Integer cantJuegosB, ValorClasificadorEntidad categPosible, java.util.Date fecAntPuesto,
			String antPuesto, EvaluacionLegajoCab evalDesemp, EvaluacionLegajoCab evalPoten, int ranking, String aprobado, String motNoAprob, CantSancionesPorTitu cantSancionesPorTitu,
			Integer horasAcum, Integer cantMinJuegosA, String tiempoHorizCarrera, int cantMesesHorCarrera, ObsLegajo obsLegajo, Boolean isPendCargaEvalDesemp, Boolean isPendCargaEvalPoten,
			Boolean isPendCargaJuegosA, Boolean isPendCargaIRL,String claseSindicato) throws BaseException {

		ds.append();
		ds.fieldValue("oid_cronograma", oidCronograma);
		ds.fieldValue("desc_cronograma", descCronograma);
		ds.fieldValue("oid_accion", oidAccion);
		ds.fieldValue("desc_accion", descAccion);
		ds.fieldValue("oid_legajo", oidLegajo);
		ds.fieldValue("legajo", legajo);
		ds.fieldValue("apellido", apellido);
		ds.fieldValue("nombre", nombre);
		ds.fieldValue("fec_ingreso", fecIngreso);
		ds.fieldValue("ant_ingreso", antIngreso);
		if (valClasifEmp != null) {
			ds.fieldValue("oid_val_clasif_emp", valClasifEmp.getOIDInteger());
			ds.fieldValue("desc_val_clasif_emp", valClasifEmp.getDescripcion());
		} else {
			ds.fieldValue("oid_val_clasif_emp", "");
			ds.fieldValue("desc_val_clasif_emp", "");
		}
		if (valClasifSec != null) {
			ds.fieldValue("oid_val_clasif_sec", valClasifSec.getOIDInteger());
			ds.fieldValue("desc_val_clasif_sec", valClasifSec.getDescripcion());
		} else {
			ds.fieldValue("oid_val_clasif_sec", "");
			ds.fieldValue("desc_val_clasif_sec", "");
		}
		if (valClasifPue != null) {
			ds.fieldValue("oid_val_clasif_pue", valClasifPue.getOIDInteger());
			ds.fieldValue("desc_val_clasif_pue", valClasifPue.getDescripcion());
		} else {
			ds.fieldValue("oid_val_clasif_pue", "");
			ds.fieldValue("desc_val_clasif_pue", "");
		}

		if ((cantJuegosA != null) && (cantJuegosA.intValue() != 0))
			ds.fieldValue("cant_juegos_a", cantJuegosA);
		else
			ds.fieldValue("cant_juegos_a", "");
		if ((cantJuegosB != null) && (cantJuegosB.intValue() != 0))
			ds.fieldValue("cant_juegos_b", cantJuegosB);
		else
			ds.fieldValue("cant_juegos_b", "");

		if (categPosible != null) {
			ds.fieldValue("oid_categ_posible", categPosible.getOIDInteger());
			ds.fieldValue("desc_categ_posible", categPosible.getDescripcion());
		} else {
			ds.fieldValue("oid_categ_posible", "");
			ds.fieldValue("desc_categ_posible", "");
		}

		ds.fieldValue("fec_ant_puesto", fecAntPuesto);
		ds.fieldValue("ant_puesto", antPuesto);

		if (evalDesemp != null) {
			ds.fieldValue("evaluacion", evalDesemp.getPuntajeEntero());
			ds.fieldValue("desc_evaluacion", evalDesemp.getCodigo());
			ds.fieldValue("fec_eval_desemp", evalDesemp.getFec_eval());
			ds.fieldValue("oid_eval_desemp", evalDesemp.getOIDInteger());
		} else {
			ds.fieldValue("evaluacion", "");
			ds.fieldValue("desc_evaluacion", "");
			ds.fieldValue("fec_eval_desemp", "");
			ds.fieldValue("oid_eval_desemp", "");
		}

		if (evalPoten != null) {
			ds.fieldValue("evaluacion_pot", evalPoten.getPuntajeEntero());
			ds.fieldValue("desc_evaluacion_pot", evalPoten.getCodigo());
			ds.fieldValue("fec_eval_pot", evalPoten.getFec_eval());
			if (evalPoten.getValClasifPuestoFuturo() != null)
				ds.fieldValue("puesto_eval_pot", evalPoten.getValClasifPuestoFuturo().getDescripcion());
			else
				ds.fieldValue("puesto_eval_pot", "");
			ds.fieldValue("oid_eval_poten", evalPoten.getOIDInteger());
		} else {
			ds.fieldValue("evaluacion_pot", "");
			ds.fieldValue("desc_evaluacion_pot", "");
			ds.fieldValue("fec_eval_pot", "");
			ds.fieldValue("puesto_eval_pot", "");
			ds.fieldValue("oid_eval_poten", "");
		}

		ds.fieldValue("ranking", ranking);
		ds.fieldValue("aprobado", aprobado);
		ds.fieldValue("mot_no_aprob", motNoAprob);

		ds.fieldValue("cant_nov_1", cantSancionesPorTitu.getCantidad(0));
		ds.fieldValue("cant_nov_2", cantSancionesPorTitu.getCantidad(1));
		ds.fieldValue("cant_nov_3", cantSancionesPorTitu.getCantidad(2));
		ds.fieldValue("cant_nov_4", cantSancionesPorTitu.getCantidad(3));
		ds.fieldValue("cant_nov_5", cantSancionesPorTitu.getCantidad(4));
		ds.fieldValue("cant_nov_6", cantSancionesPorTitu.getCantidad(5));
		ds.fieldValue("cant_nov_7", cantSancionesPorTitu.getCantidad(6));
		ds.fieldValue("cant_nov_8", cantSancionesPorTitu.getCantidad(7));
		ds.fieldValue("cant_nov_9", cantSancionesPorTitu.getCantidad(8));
		ds.fieldValue("cant_nov_10", cantSancionesPorTitu.getCantidad(9));

		ds.fieldValue("horas_acum", horasAcum);
		ds.fieldValue("cant_min_juegos_a", cantMinJuegosA);

		ds.fieldValue("tiempo_hor_carrera", tiempoHorizCarrera);

		int antSectorMeses = oLegajo.getAntiEnMesesSector(valClasifEmp, valClasifSec, fecHastaPeriAEval);

		ds.fieldValue("dif_meses_hc", cantMesesHorCarrera - antSectorMeses);

		ds.fieldValue("antiguedad_sector", Fecha.getLabelAntiguedad(antSectorMeses));
		ds.fieldValue("ant_sec_meses", antSectorMeses);

		if (obsLegajo != null) {
			ds.fieldValue("fec_irl", obsLegajo.getFecha());
			ds.fieldValue("result_irl", obsLegajo.getPosNegNeu());
			ds.fieldValue("obs_irl", obsLegajo.getObservacion());
		} else {
			ds.fieldValue("fec_irl", "");
			ds.fieldValue("result_irl", "");
			ds.fieldValue("obs_irl", "");
		}

		if ((isPendCargaEvalDesemp != null) && (isPendCargaEvalDesemp.booleanValue()))
			ds.fieldValue("pend_realizar_eval_des", "Si");
		else
			ds.fieldValue("pend_realizar_eval_des", "");

		if ((isPendCargaEvalPoten != null) && (isPendCargaEvalPoten.booleanValue()))
			ds.fieldValue("pend_realizar_eval_pot", "Si");
		else
			ds.fieldValue("pend_realizar_eval_pot", "");

		if ((isPendCargaIRL != null) && (isPendCargaIRL.booleanValue()))
			ds.fieldValue("pend_realizar_irl", "Si");
		else
			ds.fieldValue("pend_realizar_irl", "");

		if ((isPendCargaJuegosA != null) && (isPendCargaJuegosA.booleanValue()))
			ds.fieldValue("pend_realizar_carga_ja", "Si");
		else
			ds.fieldValue("pend_realizar_carga_ja", "");
		
		ds.fieldValue("clase_sindicato", claseSindicato);
		
	}

	private IDataSet getDataSetFiltros() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFiltros");
		dataset.fieldDef(new Field("oid_cronograma", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_cronograma", Field.INTEGER, 0));
		dataset.fieldDef(new Field("mes", Field.STRING, 50));
		dataset.fieldDef(new Field("acciones", Field.STRING, 5000));
		dataset.fieldDef(new Field("codigo_mes", Field.STRING, 10));
		dataset.fieldDef(new Field("anio", Field.INTEGER, 0));
		return dataset;
	}

	private IDataSet getDataSetAccion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAcciones");
		dataset.fieldDef(new Field("accion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroAccion(IDataSet dataset, String accion) throws BaseException {
		dataset.append();
		dataset.fieldValue("accion", accion);
	}

	private void cargarRegistroAccionesDesa(IDataSet dataset, CronogramaDesa cronograma, String mes, String acciones, String codigoMes, Integer anio) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cronograma", cronograma.getOIDInteger());
		dataset.fieldValue("desc_cronograma", cronograma.getDescripcion());
		dataset.fieldValue("mes", mes);
		dataset.fieldValue("acciones", acciones);
		dataset.fieldValue("codigo_mes", codigoMes);
		dataset.fieldValue("anio", anio);
	}

	private HashTableDatos getRempHorasAcum(String periodo) throws BaseException {
		HashTableDatos horasAcum = new HashTableDatos();
		Iterator iterRemAcumLeg = RemplazoAcumLeg.getRemplazosAcumLeg(periodo, this.getSesion()).iterator();
		while (iterRemAcumLeg.hasNext()) {
			RemplazoAcumLeg remplazoAcumLeg = (RemplazoAcumLeg) iterRemAcumLeg.next();
			horasAcum.put(remplazoAcumLeg.getLegajo().getNro_legajo(), remplazoAcumLeg);
		}
		return horasAcum;
	}

	public java.util.Date getFecHastaPeriEval(int anio, String mes) throws BaseException {

		if (mes == null)
			return null;

		// Obtener el Nro del Mes
		int nroMes = MesCronoDesa.getNroMes(mes);
		if (!((nroMes >= 1) && (nroMes <= 12)))
			return null;

		// Obtener el Mes Anterior
		int mesAnterior = nroMes - 1;
		if (mesAnterior == 0) {
			mesAnterior = 12;
			--anio;
		}

		// Obtener la fecha hasta del periodo a Evaluar
		int ultDiaMesAnt = Fecha.getUltimoDiaMesFechaDada(Fecha.getFecha(1, mesAnterior, anio));
		java.util.Date fecHastaPeriAEval = Fecha.getFecha(ultDiaMesAnt, mesAnterior, anio);

		return fecHastaPeriAEval;

	}

}
