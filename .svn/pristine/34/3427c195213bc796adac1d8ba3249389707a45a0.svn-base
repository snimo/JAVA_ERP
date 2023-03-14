package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.EvalFirma;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.FirmaModeloEvaluacion;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.rrhh.bm.ModeloEvalCompe;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDatosLegEvalRH extends Operation {

	public TraerDatosLegEvalRH() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsDatosLegajo = this.getDataSetDatosLeg();
		IDataSet dsCompetencias = getDataSetCompetencias();
		IDataSet dsFirmas = getDataSetFirmas();

		Legajo legajo = Legajo.findByOid(mapaDatos.getInteger("oid_legajo"), this.getSesion());
		ModeloEvalCab modeloEvalCab = ModeloEvalCab.findByOid(mapaDatos.getInteger("oid_mod_eval_cab"), this.getSesion());
		Integer oidEvalCab = mapaDatos.getInteger("oid_eval_cab");

		cargarRegistroDatosLegajo(dsDatosLegajo, dsCompetencias, dsFirmas, legajo, modeloEvalCab, oidEvalCab);

		writeCliente(dsDatosLegajo);
		writeCliente(dsCompetencias);
		writeCliente(dsFirmas);

	}

	private IDataSet getDataSetDatosLeg() {

		IDataSet dataset = new TDataSet();
		dataset.create("TDatosLegajo");

		dataset.fieldDef(new Field("oid_clasif_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_valor_empresa", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_valor_empresa", Field.STRING, 100));

		dataset.fieldDef(new Field("oid_clasif_sector", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor_sector", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_valor_sector", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_valor_sector", Field.STRING, 100));

		dataset.fieldDef(new Field("oid_clasif_puesto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor_puesto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_valor_puesto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_valor_puesto", Field.STRING, 100));

		dataset.fieldDef(new Field("oid_clasif_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_valor_estado", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_valor_estado", Field.STRING, 100));

		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));

		dataset.fieldDef(new Field("oid_cond_modelo", Field.INTEGER, 0));

		return dataset;
	}

	private void cargarRegistroDatosLegajo(IDataSet dataset, IDataSet dsCompetencias, IDataSet dsFirmas, Legajo legajo, ModeloEvalCab modeloEvalCab, Integer oidEvalCab) throws BaseException {
		dataset.append();

		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());

		ValorClasificadorEntidad valorClasifEmp = legajo.getValorClasifEnt(clasifEmpresa);
		ValorClasificadorEntidad valorClasifSec = legajo.getValorClasifEnt(clasifSector);
		ValorClasificadorEntidad valorClasifPue = legajo.getValorClasifEnt(clasifPuesto);
		ValorClasificadorEntidad valorClasifEst = legajo.getValorClasifEnt(clasifEstado);

		dataset.fieldValue("oid_clasif_empresa", clasifEmpresa.getOIDInteger());
		if (valorClasifEmp != null) {
			dataset.fieldValue("oid_valor_empresa", valorClasifEmp.getOID());
			dataset.fieldValue("cod_valor_empresa", valorClasifEmp.getCodigo());
			dataset.fieldValue("desc_valor_empresa", valorClasifEmp.getDescripcion());
		} else {
			dataset.fieldValue("oid_valor_empresa", "");
			dataset.fieldValue("cod_valor_empresa", "");
			dataset.fieldValue("desc_valor_empresa", "");
		}

		dataset.fieldValue("oid_clasif_sector", clasifSector.getOIDInteger());
		if (valorClasifSec != null) {
			dataset.fieldValue("oid_valor_sector", valorClasifSec.getOIDInteger());
			dataset.fieldValue("cod_valor_sector", valorClasifSec.getCodigo());
			dataset.fieldValue("desc_valor_sector", valorClasifSec.getDescripcion());
		} else {
			dataset.fieldValue("oid_valor_sector", "");
			dataset.fieldValue("cod_valor_sector", "");
			dataset.fieldValue("desc_valor_sector", "");
		}

		dataset.fieldValue("oid_clasif_puesto", clasifPuesto.getOIDInteger());
		if (valorClasifPue != null) {
			dataset.fieldValue("oid_valor_puesto", valorClasifPue.getOIDInteger());
			dataset.fieldValue("cod_valor_puesto", valorClasifPue.getCodigo());
			dataset.fieldValue("desc_valor_puesto", valorClasifPue.getDescripcion());
		} else {
			dataset.fieldValue("oid_valor_puesto", "");
			dataset.fieldValue("cod_valor_puesto", "");
			dataset.fieldValue("desc_valor_puesto", "");
		}

		dataset.fieldValue("oid_clasif_estado", clasifEstado.getOIDInteger());
		if (valorClasifEst != null) {
			dataset.fieldValue("oid_valor_estado", valorClasifEst.getOIDInteger());
			dataset.fieldValue("cod_valor_estado", valorClasifEst.getCodigo());
			dataset.fieldValue("desc_valor_estado", valorClasifEst.getDescripcion());
		} else {
			dataset.fieldValue("oid_valor_estado", "");
			dataset.fieldValue("cod_valor_estado", "");
			dataset.fieldValue("desc_valor_estado", "");
		}

		dataset.fieldValue("oid_legajo", legajo.getOIDInteger());
		dataset.fieldValue("cod_legajo", legajo.getNro_legajo());
		dataset.fieldValue("ape_y_nom", legajo.getApellidoyNombre());

		CondModEvalCab condModEvalCab = modeloEvalCab.getCondModeloSegunLeg(legajo);
		if (condModEvalCab != null)
			dataset.fieldValue("oid_cond_modelo", condModEvalCab.getOIDInteger());
		else
			dataset.fieldValue("oid_cond_modelo", "");

		// Competencias
		if (condModEvalCab != null) {

			Iterator iterCompetencias = condModEvalCab.getCompetenciasCondicion().iterator();
			while (iterCompetencias.hasNext()) {
				ModeloEvalCompe modeloEvalCompe = (ModeloEvalCompe) iterCompetencias.next();
				cargarCompetencia(dsCompetencias, modeloEvalCompe.getOID(), modeloEvalCompe.getOrden(), oidEvalCab, modeloEvalCompe.getCompetencia(), modeloEvalCompe);
			}

			int secu = -100000;
			// Recorrer los firmantes de la condicion del modelo
			Iterator iterFirmasModelo = condModEvalCab.getFirmas().iterator();
			while (iterFirmasModelo.hasNext()) {
				FirmaModeloEvaluacion firmaModeloEvaluacion = (FirmaModeloEvaluacion) iterFirmasModelo.next();
				--secu;

				dsFirmas.append();
				dsFirmas.fieldValue("oid_firma_eval", secu);
				dsFirmas.fieldValue("oid_eval_cab", oidEvalCab);
				dsFirmas.fieldValue("nro_firma", 999);
				if (firmaModeloEvaluacion.getLegajo_firma() != null) {
					dsFirmas.fieldValue("oid_legajo_firma", firmaModeloEvaluacion.getLegajo_firma().getOIDInteger());
					dsFirmas.fieldValue("cod_legajo_firma", firmaModeloEvaluacion.getLegajo_firma().getNro_legajo());
					dsFirmas.fieldValue("desc_legajo_firma", firmaModeloEvaluacion.getLegajo_firma().getApellidoyNombre());
				} else {
					dsFirmas.fieldValue("oid_legajo_firma", "");
					dsFirmas.fieldValue("cod_legajo_firma", "");
					dsFirmas.fieldValue("desc_legajo_firma", "");
				}
				dsFirmas.fieldValue("firmo", false);
				dsFirmas.fieldValue("fec_firma", "");
				dsFirmas.fieldValue("activo", true);
				ValorClasificadorEntidad valClasifEnt = null;
				if (firmaModeloEvaluacion.getLegajo_firma() != null) {
					valClasifEnt = firmaModeloEvaluacion.getLegajo_firma().getValorClasifEnt(clasifPuesto);
					if (valClasifEnt != null)
						dsFirmas.fieldValue("puesto", valClasifEnt.getDescripcion());
					else
						dsFirmas.fieldValue("puesto", "");

				} else {
					dsFirmas.fieldValue("puesto", firmaModeloEvaluacion.getTitulo());
				}

			}

		}

	}

	private IDataSet getDataSetCompetencias() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCompetenciasEval");
		dataset.fieldDef(new Field("oid_compe_eval", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_eval_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_competencia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_competencia", Field.STRING, 200));
		dataset.fieldDef(new Field("grado", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarCompetencia(IDataSet dsCompetencias, int secu, int orden, int oidEvalCab, Competencia competencia, ModeloEvalCompe modeloEvalCompe) throws BaseException {

		dsCompetencias.append();
		dsCompetencias.fieldValue("oid_compe_eval", secu);
		dsCompetencias.fieldValue("orden", orden);
		dsCompetencias.fieldValue("oid_eval_cab", oidEvalCab);
		dsCompetencias.fieldValue("oid_competencia", competencia.getOIDInteger());
		dsCompetencias.fieldValue("desc_competencia", modeloEvalCompe.getTitulo_compe());
		dsCompetencias.fieldValue("grado", "");

	}

	private IDataSet getDataSetFirmas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFirmasTemp");
		dataset.fieldDef(new Field("oid_firma_eval", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_eval_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_firma", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo_firma", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_legajo_firma", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_legajo_firma", Field.STRING, 100));
		dataset.fieldDef(new Field("firmo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_firma", Field.DATE, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("puesto", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistrosFirmas(IDataSet dsFirmas, EvaluacionLegajoCab evaluacionLegajoCab) throws BaseException {

		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());

		HashTableDatos legajos = new HashTableDatos();

		Iterator iterFirmas = evaluacionLegajoCab.getFirmas().iterator();
		while (iterFirmas.hasNext()) {
			EvalFirma evalFirma = (EvalFirma) iterFirmas.next();

			dsFirmas.append();
			dsFirmas.fieldValue("oid_firma_eval", evalFirma.getOIDInteger());
			dsFirmas.fieldValue("oid_eval_cab", evaluacionLegajoCab.getOIDInteger());
			dsFirmas.fieldValue("nro_firma", evalFirma.getNro_firma());
			if (evalFirma.getLegajo_firma() != null) {
				dsFirmas.fieldValue("oid_legajo_firma", evalFirma.getLegajo_firma().getOIDInteger());
				dsFirmas.fieldValue("cod_legajo_firma", evalFirma.getLegajo_firma().getNro_legajo());
				dsFirmas.fieldValue("desc_legajo_firma", evalFirma.getLegajo_firma().getApellidoyNombre());
				legajos.put(evalFirma.getLegajo_firma().getOIDInteger(), "");
			} else {
				dsFirmas.fieldValue("oid_legajo_firma", "");
				dsFirmas.fieldValue("cod_legajo_firma", "");
				dsFirmas.fieldValue("desc_legajo_firma", "");
			}
			dsFirmas.fieldValue("firmo", evalFirma.isFirmo());
			dsFirmas.fieldValue("fec_firma", evalFirma.getFec_firma());
			dsFirmas.fieldValue("activo", evalFirma.isActivo());
			ValorClasificadorEntidad valClasifEnt = null;
			if (evalFirma.getLegajo_firma() != null)
				valClasifEnt = evalFirma.getLegajo_firma().getValorClasifEnt(clasifPuesto);
			if (valClasifEnt != null)
				dsFirmas.fieldValue("puesto", valClasifEnt.getDescripcion());
			else
				dsFirmas.fieldValue("puesto", "");

		}

		int secu = -100000;
		// Recorrer los firmantes de la condicion del modelo
		Iterator iterFirmasModelo = evaluacionLegajoCab.getCondModEvalCab().getFirmas().iterator();
		while (iterFirmasModelo.hasNext()) {
			--secu;
			FirmaModeloEvaluacion firmaModeloEvaluacion = (FirmaModeloEvaluacion) iterFirmasModelo.next();
			if (!legajos.containsKey(firmaModeloEvaluacion.getLegajo_firma().getOIDInteger())) {
				dsFirmas.append();
				dsFirmas.fieldValue("oid_firma_eval", secu);
				dsFirmas.fieldValue("oid_eval_cab", evaluacionLegajoCab.getOIDInteger());
				dsFirmas.fieldValue("nro_firma", 999);
				if (firmaModeloEvaluacion.getLegajo_firma() != null) {
					dsFirmas.fieldValue("oid_legajo_firma", firmaModeloEvaluacion.getLegajo_firma().getOIDInteger());
					dsFirmas.fieldValue("cod_legajo_firma", firmaModeloEvaluacion.getLegajo_firma().getNro_legajo());
					dsFirmas.fieldValue("desc_legajo_firma", firmaModeloEvaluacion.getLegajo_firma().getApellidoyNombre());
				} else {
					dsFirmas.fieldValue("oid_legajo_firma", "");
					dsFirmas.fieldValue("cod_legajo_firma", "");
					dsFirmas.fieldValue("desc_legajo_firma", "");
				}
				dsFirmas.fieldValue("firmo", false);
				dsFirmas.fieldValue("fec_firma", "");
				dsFirmas.fieldValue("activo", true);
				ValorClasificadorEntidad valClasifEnt = null;
				if (firmaModeloEvaluacion.getLegajo_firma() != null) {
					valClasifEnt = firmaModeloEvaluacion.getLegajo_firma().getValorClasifEnt(clasifPuesto);
					if (valClasifEnt != null)
						dsFirmas.fieldValue("puesto", valClasifEnt.getDescripcion());
					else
						dsFirmas.fieldValue("puesto", "");

				} else {
					dsFirmas.fieldValue("puesto", firmaModeloEvaluacion.getTitulo());
				}

			}

		}

	}

}
