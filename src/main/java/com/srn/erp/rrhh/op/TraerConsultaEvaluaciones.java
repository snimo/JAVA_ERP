package com.srn.erp.rrhh.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.EvalCargaResul;
import com.srn.erp.rrhh.bm.EvalValClasifLeg;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsultaEvaluaciones extends Operation {

	List modelosEval = new ArrayList();
	HashTableDatos legConEval = new HashTableDatos();
	HashTableDatos allLegajos = new HashTableDatos();
	
	HashTableDatos consulta = new HashTableDatos();
	HashTableDatos valoresClasifLeg = new HashTableDatos();

	ClasificadorEntidad clasifEmpresa = null;
	ClasificadorEntidad clasifSector = null;
	ClasificadorEntidad clasifPuesto = null;
	ClasificadorEntidad clasifEstado = null;

	public TraerConsultaEvaluaciones() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsInput = mapaDatos.getDataSet("Tinput");
		IDataSet dsEvaluaciones = mapaDatos.getDataSet("TSelEvaluaciones");
		IDataSet dsLegajos = null;
		IDataSet dsEmpresas = null;
		IDataSet dsSector = null;
		IDataSet dsPuesto = null;
		IDataSet dsEstado = null;
		IDataSet dsColEval = null;

		if (mapaDatos.containsKey("consulta")) {
			dsLegajos = mapaDatos.getDataSet("TSelLegajos");
			dsEmpresas = mapaDatos.getDataSet("TSelEmpresas");
			dsSector = mapaDatos.getDataSet("TSelSector");
			dsPuesto = mapaDatos.getDataSet("TSelPuesto");
			dsEstado = mapaDatos.getDataSet("TSelEstado");
			dsColEval = mapaDatos.getDataSet("TColumnasEvaluaciones");
		}

		if (mapaDatos.containsKey("estructura"))
			traerEstructura(dsEvaluaciones, dsInput);
		else if (mapaDatos.containsKey("consulta"))
			traerDatos(dsInput, dsEvaluaciones, dsLegajos, dsEmpresas, dsSector, dsPuesto, dsEstado, dsColEval);

	}

	private void traerDatos(IDataSet dsInput, IDataSet dsEvaluaciones, IDataSet dsLegajos, IDataSet dsEmpresas, IDataSet dsSectores, IDataSet dsPuestos, IDataSet dsEstados, IDataSet dsColEval)
			throws BaseException {

		clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());

		java.util.Date fecDesde = null;
		java.util.Date fecHasta = null;
		boolean incluirLegSinEval = false;
		List modelos = new ArrayList();
		List legajos = new ArrayList();
		List empresas = new ArrayList();
		List sectores = new ArrayList();
		List puestos = new ArrayList();
		List estados = new ArrayList();

		dsInput.first();
		while (!dsInput.EOF()) {
			fecDesde = dsInput.getDate("fec_eval_desde");
			fecHasta = dsInput.getDate("fec_eval_hasta");
			incluirLegSinEval = dsInput.getBoolean("incluir_leg_sin_evaluar");
			dsInput.next();
		}

		dsEvaluaciones.first();
		while (!dsEvaluaciones.EOF()) {
			if (dsEvaluaciones.getBoolean("sel")) {
				ModeloEvalCab modelo = ModeloEvalCab.findByOidProxy(dsEvaluaciones.getInteger("oid_mod_eval"), this.getSesion());
				modelos.add(modelo);
			}
			dsEvaluaciones.next();
		}

		dsLegajos.first();
		while (!dsLegajos.EOF()) {
			if (dsLegajos.getBoolean("sel")) {
				Legajo legajo = Legajo.findByOidProxy(dsLegajos.getInteger("oid_legajo"), this.getSesion());
				legajos.add(legajo);
			}
			dsLegajos.next();
		}

		dsEmpresas.first();
		while (!dsEmpresas.EOF()) {
			if (dsEmpresas.getBoolean("sel")) {
				ValorClasificadorEntidad empresa = ValorClasificadorEntidad.findByOidProxy(dsEmpresas.getInteger("oid_empresa"), this.getSesion());
				empresas.add(empresa);
			}
			dsEmpresas.next();
		}

		dsSectores.first();
		while (!dsSectores.EOF()) {
			if (dsSectores.getBoolean("sel")) {
				ValorClasificadorEntidad sector = ValorClasificadorEntidad.findByOidProxy(dsSectores.getInteger("oid_sector"), this.getSesion());
				sectores.add(sector);
			}
			dsSectores.next();
		}

		dsPuestos.first();
		while (!dsPuestos.EOF()) {
			if (dsPuestos.getBoolean("sel")) {
				ValorClasificadorEntidad puesto = ValorClasificadorEntidad.findByOidProxy(dsPuestos.getInteger("oid_puesto"), this.getSesion());
				puestos.add(puesto);
			}
			dsPuestos.next();
		}

		dsEstados.first();
		while (!dsEstados.EOF()) {
			if (dsEstados.getBoolean("sel")) {
				ValorClasificadorEntidad estado = ValorClasificadorEntidad.findByOidProxy(dsEstados.getInteger("oid_estado"), this.getSesion());
				estados.add(estado);
			}
			dsEstados.next();
		}

		
		if (incluirLegSinEval) {
			Iterator iterLegEvalRRHH = Legajo.getLegajosEvalRRHH(legajos, empresas, sectores, puestos, estados, this.getSesion()).iterator();
			while (iterLegEvalRRHH.hasNext()) {
				Legajo legajo = (Legajo) iterLegEvalRRHH.next();
				allLegajos.put(legajo.getOIDInteger(), "");
			}
		}
		
		Iterator iterEvaIterator = EvaluacionLegajoCab.getConsulta(fecDesde, fecHasta, modelos, legajos, empresas, sectores, puestos, estados, this.getSesion()).iterator();
		while (iterEvaIterator.hasNext()) {
			EvaluacionLegajoCab evaluacionLegajoCab = (EvaluacionLegajoCab) iterEvaIterator.next();
			acumularEvaluaciones(evaluacionLegajoCab);
		}

		
		
		// Devolver los resutados de la consulra

		String[] colModelos = new String[dsColEval.getCount()];
		dsColEval.first();
		while (!dsColEval.EOF()) {
			colModelos[dsColEval.getInteger("orden") - 1] = dsColEval.getString("campo_puntaje");
			dsColEval.next();
		}

		Iterator iterClasifLeg = Legajo.getClasificadoresEntidadActivos(this.getSesion()).iterator();
		while (iterClasifLeg.hasNext()) {
			ClasificadorEntidad clasif = (ClasificadorEntidad) iterClasifLeg.next();
			Iterator iterValClasif = clasif.getValoresClasificador().iterator();
			while (iterValClasif.hasNext()) {
				ValorClasificadorEntidad valClasif = (ValorClasificadorEntidad) iterValClasif.next();
				valoresClasifLeg.put(valClasif.getOIDInteger(), valClasif);
			}
		}

		IDataSet dsResultConsulta = this.getDataSetConsultaEval(colModelos);
		cargarRegCons(dsResultConsulta, consulta, colModelos, valoresClasifLeg);
		if (incluirLegSinEval) 
			cargarRegCons(dsResultConsulta, consulta, colModelos, legConEval , allLegajos);
		
		writeCliente(dsResultConsulta);

	}

	private void acumularEvaluaciones(EvaluacionLegajoCab evaluacionLegajoCab) throws BaseException {
		String clave = armarClave(evaluacionLegajoCab);
		
		
		legConEval.put(evaluacionLegajoCab.getLegajo().getOIDInteger(), "");
		
		HashTableDatos puntosEval = (HashTableDatos) consulta.get(clave);
		if (puntosEval == null) {
			puntosEval = new HashTableDatos();
			consulta.put(clave, puntosEval);
		}
		puntosEval.put("pu_" + evaluacionLegajoCab.getModelo_eval_cab().getOIDInteger(), evaluacionLegajoCab);
	}

	private String armarClave(EvaluacionLegajoCab evaluacionLegajoCab) throws BaseException {

		String oidLegajo = evaluacionLegajoCab.getLegajo().getOIDInteger().toString();
		String oidEmpresa = "?";
		String oidSector = "?";
		String oidPuesto = "?";
		String oidEstado = "?";

		Iterator iterValClasif = evaluacionLegajoCab.getValoresClasificador().iterator();
		while (iterValClasif.hasNext()) {
			EvalValClasifLeg evalValClasifLeg = (EvalValClasifLeg) iterValClasif.next();
			if (evalValClasifLeg.getClasificador().getOID() == clasifEmpresa.getOID()) {
				oidEmpresa = evalValClasifLeg.getValor_clasificador().getOIDInteger().toString();
				evaluacionLegajoCab.setTempValClasifEmp(evalValClasifLeg.getValor_clasificador());
			} else if (evalValClasifLeg.getClasificador().getOID() == clasifSector.getOID()) {
				oidSector = evalValClasifLeg.getValor_clasificador().getOIDInteger().toString();
				evaluacionLegajoCab.setTempValClasifSec(evalValClasifLeg.getValor_clasificador());
			} else if (evalValClasifLeg.getClasificador().getOID() == clasifPuesto.getOID()) {
				oidPuesto = evalValClasifLeg.getValor_clasificador().getOIDInteger().toString();
				evaluacionLegajoCab.setTempValClasifPue(evalValClasifLeg.getValor_clasificador());
			} else if (evalValClasifLeg.getClasificador().getOID() == clasifEstado.getOID()) {
				oidEstado = evalValClasifLeg.getValor_clasificador().getOIDInteger().toString();
				evaluacionLegajoCab.setTempValClasifEst(evalValClasifLeg.getValor_clasificador());
			}
		}

		return oidLegajo + "_" + oidEmpresa + "_" + oidSector + "_" + oidPuesto + "_" + oidEstado;
	}

	private void traerEstructura(IDataSet dsEvaluaciones, IDataSet dsInput) throws BaseException {

		boolean traerGrados = false;
		boolean traerPorcGrados = false;
		String tipo = ""; 

		dsInput.first();
		while (!dsInput.EOF()) {
			traerGrados = dsInput.getBoolean("ver_grados");
			traerPorcGrados = dsInput.getBoolean("ver_porc_grados");
			tipo = dsInput.getString("tipo");
			dsInput.next();
		}

		int cantModelos = 0;
		dsEvaluaciones.first();
		while (!dsEvaluaciones.EOF()) {

			if (dsEvaluaciones.getBoolean("sel")) {
				++cantModelos;
				ModeloEvalCab modeloEvalCab = ModeloEvalCab.findByOidProxy(dsEvaluaciones.getInteger("oid_mod_eval"), this.getSesion());
				modelosEval.add(modeloEvalCab);
			}

			dsEvaluaciones.next();
		}

		if (cantModelos == 0) {
			modelosEval = ModeloEvalCab.getModelosActivosOrderByFecDesdeTipo(tipo,this.getSesion());
		}

		int secu = 1;
		IDataSet dsColumnasEvaluaciones = getDataSetColEvaluaciones();
		IDataSet dsBandasEvaluaciones = getDataSetBandasEvaluaciones();
		int ordenBandas = 1;

		Iterator iterModEval = modelosEval.iterator();
		while (iterModEval.hasNext()) {

			ModeloEvalCab modeloEvalCab = (ModeloEvalCab) iterModEval.next();
			cargarBandasEvaluaciones(dsBandasEvaluaciones, ordenBandas, modeloEvalCab, modeloEvalCab.getCodigo(), ordenBandas);

			cargarRegColEvaluacion(dsColumnasEvaluaciones, secu, modeloEvalCab, ordenBandas);
			++secu;

			if (traerGrados) {
				Iterator iterCompe = modeloEvalCab.getCompetencias().iterator();
				while (iterCompe.hasNext()) {
					Competencia competencia = (Competencia) iterCompe.next();
					cargarRegColEvaluacion(dsColumnasEvaluaciones, secu, "gc_" + modeloEvalCab.getOIDInteger() + "_" + competencia.getOIDInteger().toString(), "Gr." + competencia.getCodigo(),
							ordenBandas);
					++secu;
				}
			}

			if (traerPorcGrados) {
				Iterator iterCompe = modeloEvalCab.getCompetencias().iterator();
				while (iterCompe.hasNext()) {
					Competencia competencia = (Competencia) iterCompe.next();
					cargarRegColEvaluacion(dsColumnasEvaluaciones, secu, "pg_" + modeloEvalCab.getOIDInteger() + "_" + competencia.getOIDInteger().toString(), "%Gr." + competencia.getCodigo(),
							ordenBandas);
					++secu;
				}
			}

			++ordenBandas;

		}

		writeCliente(dsColumnasEvaluaciones);
		writeCliente(dsBandasEvaluaciones);

		// Devvolver columnas por los grados

	}

	private IDataSet getDataSetConsultaEval(String[] lista) {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsEvaluaciones");
		dataset.fieldDef(new Field("empresa", Field.STRING, 100));
		dataset.fieldDef(new Field("sector", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("puesto", Field.STRING, 100));
		dataset.fieldDef(new Field("estado", Field.STRING, 100));

		int i = 0;
		for (i = 0; i < lista.length; ++i) {
			dataset.fieldDef(new Field(lista[i], Field.DOUBLE, 0));
		}
		return dataset;
	}
	
	private void cargarRegCons(IDataSet ds, HashTableDatos consulta, String[] lista, HashTableDatos legConEval, HashTableDatos todosLeg) throws BaseException {
		
		int i=0;
		Iterator iterAllLegajos = todosLeg.keySet().iterator();
		while (iterAllLegajos.hasNext()) {
			Integer oidLegajo = (Integer) iterAllLegajos.next();
			if (legConEval.get(oidLegajo)==null) {
				
				Legajo legajo = Legajo.findByOid(oidLegajo, this.getSesion());
				
				ValorClasificadorEntidad valorClasifEmp = legajo.getValorClasifEnt(clasifEmpresa);
				ValorClasificadorEntidad valorClasifSec = legajo.getValorClasifEnt(clasifSector);
				ValorClasificadorEntidad valorClasifPue = legajo.getValorClasifEnt(clasifPuesto);
				ValorClasificadorEntidad valorClasifEst = legajo.getValorClasifEnt(clasifEstado);
				
				ds.append();
				if (valorClasifEmp!=null)
					ds.fieldValue("empresa", valorClasifEmp.getDescripcion());
				else
					ds.fieldValue("empresa", "");
				if (valorClasifSec!=null)
					ds.fieldValue("sector", valorClasifSec.getDescripcion());
				else
					ds.fieldValue("sector", "");
				ds.fieldValue("oid_legajo", legajo.getOIDInteger());
				ds.fieldValue("legajo", legajo.getNro_legajo());
				ds.fieldValue("ape_y_nom", legajo.getApellidoyNombre());
				if (valorClasifPue!=null)
					ds.fieldValue("puesto", valorClasifPue.getDescripcion());
				else
					ds.fieldValue("puesto", "");
				if (valorClasifEst!=null)
					ds.fieldValue("estado", valorClasifEst.getDescripcion());
				else
					ds.fieldValue("estado", "");
				for (i = 0; i < lista.length; ++i) 
						ds.fieldValue(lista[i].toString(), "");
				
			}
		}
		
		
		
	}

	private void cargarRegCons(IDataSet ds, HashTableDatos consulta, String[] lista, HashTableDatos valorClasifLeg) throws BaseException {

		Iterator iterCons = consulta.values().iterator();
		while (iterCons.hasNext()) {
			HashTableDatos puntajes = (HashTableDatos) iterCons.next();
			Legajo legajo = null;
			Double[] puntos = new Double[lista.length];
			String empresa = "";
			String sector = "";
			String puesto = "";
			String estado = "";
			EvaluacionLegajoCab evaluacionLegajoCab = null;
			int i = 0;
			for (i = 0; i < lista.length; ++i) {

				puntos[i] = 0.0;
				if (lista[i].startsWith("gc_") || lista[i].startsWith("pg_")) {

					int j = 0;
					StringTokenizer st = new StringTokenizer(lista[i], "_");
					while (st.hasMoreTokens()) {
						++j;
						String next = st.nextToken().toUpperCase();
						if (j == 2) {
							evaluacionLegajoCab = (EvaluacionLegajoCab) puntajes.get("pu_" + next);
						} else if (j == 3) {
							Competencia competencia = Competencia.findByOidProxy(new Integer(next), this.getSesion());
							if (evaluacionLegajoCab != null) {
								Iterator iterResulCompe = evaluacionLegajoCab.getResultadosCompe().iterator();
								while (iterResulCompe.hasNext()) {
									EvalCargaResul evalCargaResul = (EvalCargaResul) iterResulCompe.next();
									if (evalCargaResul.getCompetencia().getOID() == competencia.getOID()) {
										if (lista[i].startsWith("gc_")) {
											if (evalCargaResul.getNro_grado() != null)
												puntos[i] = new Double(evalCargaResul.getNro_grado().intValue());
											else
												puntos[i] = 0.0;
											break;
										} else if (lista[i].startsWith("pg_")) {
											if (evalCargaResul.getPorc_cumpli() != null)
												puntos[i] = new Double(evalCargaResul.getPorc_cumpli().doubleValue());
											else
												puntos[i] = 0.0;
											break;

										}
									}
								}
							} else
								puntos[i] = 0.0;
						}

					}

				} else if (lista[i].startsWith("pu_")) {

					evaluacionLegajoCab = (EvaluacionLegajoCab) puntajes.get(lista[i]);

					if ((legajo == null) && (evaluacionLegajoCab != null)) {
						legajo = evaluacionLegajoCab.getLegajo();

						if (evaluacionLegajoCab.getTempValClasifEmp() != null) {
							ValorClasificadorEntidad valEmp = (ValorClasificadorEntidad) valorClasifLeg.get(evaluacionLegajoCab.getTempValClasifEmp().getOIDInteger());
							if (valEmp != null)
								empresa = valEmp.getDescripcion();
						}

						if (evaluacionLegajoCab.getTempValClasifSec() != null) {
							ValorClasificadorEntidad valSec = (ValorClasificadorEntidad) valorClasifLeg.get(evaluacionLegajoCab.getTempValClasifSec().getOIDInteger());
							if (valSec != null)
								sector = valSec.getDescripcion();
						}

						if (evaluacionLegajoCab.getTempValClasifPue() != null) {
							ValorClasificadorEntidad valPue = (ValorClasificadorEntidad) valorClasifLeg.get(evaluacionLegajoCab.getTempValClasifPue().getOIDInteger());
							if (valPue != null)
								puesto = valPue.getDescripcion();
						}

						if (evaluacionLegajoCab.getTempValClasifEst() != null) {
							ValorClasificadorEntidad valEst = (ValorClasificadorEntidad) valorClasifLeg.get(evaluacionLegajoCab.getTempValClasifEst().getOIDInteger());
							if (valEst != null)
								estado = valEst.getDescripcion();
						}

					}
					if (evaluacionLegajoCab != null)
						puntos[i] = (double) evaluacionLegajoCab.getPuntajeEntero();
					else
						puntos[i] = 0.0;
				}
			}

			if (legajo == null)
				continue;

			ds.append();
			ds.fieldValue("empresa", empresa);
			ds.fieldValue("sector", sector);
			ds.fieldValue("oid_legajo", legajo.getOIDInteger());
			ds.fieldValue("legajo", legajo.getNro_legajo());
			ds.fieldValue("ape_y_nom", legajo.getApellidoyNombre());
			ds.fieldValue("puesto", puesto);
			ds.fieldValue("estado", estado);
			for (i = 0; i < lista.length; ++i) {
				if (puntos[i] == 0.0)
					ds.fieldValue(lista[i].toString(), "");
				else
					ds.fieldValue(lista[i].toString(), puntos[i]);
			}

		}

	}

	private IDataSet getDataSetColEvaluaciones() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TColumnasEvaluaciones");
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("campo_puntaje", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo", Field.STRING, 100));
		dataset.fieldDef(new Field("banda", Field.INTEGER, 0));
		return dataset;
	}

	private IDataSet getDataSetBandasEvaluaciones() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TBandasEvaluaciones");
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mod_eval_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("titulo", Field.STRING, 100));
		dataset.fieldDef(new Field("banda", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarBandasEvaluaciones(IDataSet ds, Integer orden, ModeloEvalCab modeloEvalCab, String titulo, Integer banda) throws BaseException {
		ds.append();
		ds.fieldValue("orden", orden);
		ds.fieldValue("oid_mod_eval_cab", modeloEvalCab.getOIDInteger());
		ds.fieldValue("titulo", titulo);
		ds.fieldValue("banda", banda);
	}

	private void cargarRegColEvaluacion(IDataSet ds, int secu, ModeloEvalCab aModeloEvalCab, Integer banda) throws BaseException {
		ds.append();
		ds.fieldValue("orden", secu);
		ds.fieldValue("campo_puntaje", "pu_" + aModeloEvalCab.getOIDInteger());
		ds.fieldValue("titulo", "Puntaje");
		ds.fieldValue("banda", banda);
	}

	private void cargarRegColEvaluacion(IDataSet ds, int secu, String campo, String titulo, Integer banda) throws BaseException {
		ds.append();
		ds.fieldValue("orden", secu);
		ds.fieldValue("campo_puntaje", campo);
		ds.fieldValue("titulo", titulo);
		ds.fieldValue("banda", banda);
	}

}
