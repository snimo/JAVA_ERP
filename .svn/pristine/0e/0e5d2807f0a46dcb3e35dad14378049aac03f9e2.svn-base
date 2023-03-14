package com.srn.erp.rrhh.op;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.EvalAspectos;
import com.srn.erp.rrhh.bm.EvalCargaResul;
import com.srn.erp.rrhh.bm.EvalEvaluador;
import com.srn.erp.rrhh.bm.EvalFirma;
import com.srn.erp.rrhh.bm.EvalObsGen;
import com.srn.erp.rrhh.bm.EvalValClasifLeg;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEvaluacionDesempMasi extends Operation {

	public SaveEvaluacionDesempMasi() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());

		// Evaluacion de competencias
		IDataSet dsEvaluacionCAB = mapaDatos.getDataSet("TEvaluacionCAB");
		dsEvaluacionCAB.first();
		while (!dsEvaluacionCAB.EOF()) {

			ModeloEvalCab modeloEvalCab = ModeloEvalCab.findByOidProxy(dsEvaluacionCAB.getInteger("oid_mod_eval_cab"), this.getSesion());

			IDataSet dsEvaluacionesLeg = dsEvaluacionCAB.getDataSet("TEvaluacionesLegajos");
			dsEvaluacionesLeg.first();
			while (!dsEvaluacionesLeg.EOF()) {

				Legajo legajo = Legajo.findByOidProxy(dsEvaluacionesLeg.getInteger("oid_legajo"), this.getSesion());
				java.util.Date fecha = dsEvaluacionesLeg.getDate("fecha");

				// Crear una evaluacion por cada legajo
				EvaluacionLegajoCab evaluacionLegajoCab = EvaluacionLegajoCab.getEvalByModeloLegFecVig(modeloEvalCab, fecha, legajo, this.getSesion());
				if (evaluacionLegajoCab == null) {
					evaluacionLegajoCab = (EvaluacionLegajoCab) EvaluacionLegajoCab.getNew(EvaluacionLegajoCab.NICKNAME, this.getSesion());
					evaluacionLegajoCab.setOID(-1);
				}

				evaluacionLegajoCab.setActivo(true);

				evaluacionLegajoCab.setLegajo(legajo);
				evaluacionLegajoCab.setFec_eval(fecha);
				evaluacionLegajoCab.setModelo_eval_cab(modeloEvalCab);
				
				if (modeloEvalCab.getCondiciones().size()==0)
					throw new ExceptionValidation(null,"El modelo seleccionado no tiene condiciones.");
				
				evaluacionLegajoCab.setCondModEvalCab((CondModEvalCab) modeloEvalCab.getCondiciones().get(0));
				evaluacionLegajoCab.setComen_del_evaluado(dsEvaluacionCAB.getString("comen_del_evaluado"));

				if (evaluacionLegajoCab.isNew()) {
					evaluacionLegajoCab.setUsuario_alta(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOID(), this.getSesion()));
					evaluacionLegajoCab.setFec_alta_carga(UtilCIP.getFechaHoraActual(this.getSesion()));
					int nroMaxVersion = EvaluacionLegajoCab.getNroMaxVersion(evaluacionLegajoCab.getModelo_eval_cab(), evaluacionLegajoCab.getLegajo(), this.getSesion());
					evaluacionLegajoCab.setVersion_eval(nroMaxVersion + 1);
					evaluacionLegajoCab.setVigente(true);
					evaluacionLegajoCab.setActuEnNoVigenteOtrasVersiones(true);
				}

				legajo.supportRefresh();
				
				ValorClasificadorEntidad valorClasifEmp = legajo.getValorClasifEnt(clasifEmpresa);
				EvalValClasifLeg evalValClasifLegEmp = evaluacionLegajoCab.getEvalValClasifLeg(clasifEmpresa);
				if (evalValClasifLegEmp != null) {
					if (valorClasifEmp == null)
						evalValClasifLegEmp.setActivo(false);
					else
						evalValClasifLegEmp.setValor_clasificador(valorClasifEmp);
					evaluacionLegajoCab.addValorClasificador(evalValClasifLegEmp);
				} else {
					if (valorClasifEmp != null) {
						EvalValClasifLeg newEvalValClasifLegEmp = (EvalValClasifLeg) EvalValClasifLeg.getNew(EvalValClasifLeg.NICKNAME, this.getSesion());
						newEvalValClasifLegEmp.setEvaluacion(evaluacionLegajoCab);
						newEvalValClasifLegEmp.setClasificador(clasifEmpresa);
						newEvalValClasifLegEmp.setValor_clasificador(valorClasifEmp);
						newEvalValClasifLegEmp.setActivo(true);
						evaluacionLegajoCab.addValorClasificador(newEvalValClasifLegEmp);
					}
				}

				ValorClasificadorEntidad valorClasifEntidadSec = legajo.getValorClasifEnt(clasifSector);
				EvalValClasifLeg evalValClasifLegSec = evaluacionLegajoCab.getEvalValClasifLeg(clasifSector);
				if (evalValClasifLegSec != null) {
					if (valorClasifEntidadSec == null)
						evalValClasifLegSec.setActivo(false);
					else
						evalValClasifLegSec.setValor_clasificador(valorClasifEntidadSec);
					evaluacionLegajoCab.addValorClasificador(evalValClasifLegSec);
				} else {
					if (valorClasifEntidadSec != null) {
						EvalValClasifLeg newEvalValClasifLegSec = (EvalValClasifLeg) EvalValClasifLeg.getNew(EvalValClasifLeg.NICKNAME, this.getSesion());
						newEvalValClasifLegSec.setEvaluacion(evaluacionLegajoCab);
						newEvalValClasifLegSec.setClasificador(clasifSector);
						newEvalValClasifLegSec.setValor_clasificador(valorClasifEntidadSec);
						newEvalValClasifLegSec.setActivo(true);
						evaluacionLegajoCab.addValorClasificador(newEvalValClasifLegSec);
					}
				}

				ValorClasificadorEntidad valorClasifEntidadPue = legajo.getValorClasifEnt(clasifPuesto);
				EvalValClasifLeg evalValClasifLegPue = evaluacionLegajoCab.getEvalValClasifLeg(clasifPuesto);
				if (evalValClasifLegPue != null) {
					if (valorClasifEntidadPue == null)
						evalValClasifLegPue.setActivo(false);
					else
						evalValClasifLegPue.setValor_clasificador(valorClasifEntidadPue);
					evaluacionLegajoCab.addValorClasificador(evalValClasifLegPue);
				} else {
					if (valorClasifEntidadPue != null) {
						EvalValClasifLeg newEvalValClasifLegPue = (EvalValClasifLeg) EvalValClasifLeg.getNew(EvalValClasifLeg.NICKNAME, this.getSesion());
						newEvalValClasifLegPue.setEvaluacion(evaluacionLegajoCab);
						newEvalValClasifLegPue.setClasificador(clasifPuesto);
						newEvalValClasifLegPue.setValor_clasificador(valorClasifEntidadPue);
						newEvalValClasifLegPue.setActivo(true);
						evaluacionLegajoCab.addValorClasificador(newEvalValClasifLegPue);
					}
				}

				ValorClasificadorEntidad valorClasifEntidadEst = legajo.getValorClasifEnt(clasifEstado);
				EvalValClasifLeg evalValClasifLegEst = evaluacionLegajoCab.getEvalValClasifLeg(clasifEstado);
				if (evalValClasifLegEst != null) {
					if (evalValClasifLegEst == null)
						evalValClasifLegEst.setActivo(false);
					else
						evalValClasifLegEst.setValor_clasificador(valorClasifEntidadEst);
					evaluacionLegajoCab.addValorClasificador(evalValClasifLegEst);
				} else {
					if (valorClasifEntidadEst != null) {
						EvalValClasifLeg newEvalValClasifLegEst = (EvalValClasifLeg) EvalValClasifLeg.getNew(EvalValClasifLeg.NICKNAME, this.getSesion());
						newEvalValClasifLegEst.setEvaluacion(evaluacionLegajoCab);
						newEvalValClasifLegEst.setClasificador(clasifEstado);
						newEvalValClasifLegEst.setValor_clasificador(valorClasifEntidadEst);
						newEvalValClasifLegEst.setActivo(true);
						evaluacionLegajoCab.addValorClasificador(newEvalValClasifLegEst);
					}
				}

				IDataSet dsEvaluadores = dsEvaluacionCAB.getDataSet("TEvaluadores");
				dsEvaluadores.first();
				while (!dsEvaluadores.EOF()) {
					EvalEvaluador evalEvaluador = EvalEvaluador.findByOid(dsEvaluadores.getInteger("oid_eval_evaluador"), this.getSesion());
					evalEvaluador.setEvaluacion(evaluacionLegajoCab);
					evalEvaluador.setLegajo(Legajo.findByOidProxy(dsEvaluadores.getInteger("oid_legajo"), this.getSesion()));
					evalEvaluador.setFirmado(dsEvaluadores.getBoolean("firmado"));
					evalEvaluador.setFec_firmado(dsEvaluadores.getDate("fec_firmado"));
					evalEvaluador.setActivo(dsEvaluadores.getBoolean("activo"));

					evaluacionLegajoCab.addEvaluador(evalEvaluador);

					dsEvaluadores.next();
				}

				IDataSet dsFirmas = dsEvaluacionCAB.getDataSet("TFirmas");
				dsFirmas.first();
				while (!dsFirmas.EOF()) {
					EvalFirma evalFirma = EvalFirma.findByOid(dsFirmas.getInteger("oid_firma_eval"), this.getSesion());
					evalFirma.setEvaluacion(evaluacionLegajoCab);
					evalFirma.setNro_firma(dsFirmas.getInteger("nro_firma"));
					evalFirma.setLegajo_firma(Legajo.findByOidProxy(dsFirmas.getInteger("oid_legajo_firma"), this.getSesion()));
					evalFirma.setFirmo(dsFirmas.getBoolean("firmo"));
					evalFirma.setFec_firma(dsFirmas.getDate("fec_firma"));
					evalFirma.setActivo(dsFirmas.getBoolean("activo"));
					evalFirma.setTitulo(dsFirmas.getString("puesto"));
					evaluacionLegajoCab.addFirma(evalFirma);
					dsFirmas.next();
				}

				IDataSet dsObsGenRRHH = dsEvaluacionCAB.getDataSet("TObsGenRRHH");
				dsObsGenRRHH.first();
				while (!dsObsGenRRHH.EOF()) {
					EvalObsGen evalObsGen = EvalObsGen.findByOid(dsObsGenRRHH.getInteger("oid_obs_gen"), this.getSesion());

					if (evalObsGen.isNew()) {
						if ((dsObsGenRRHH.getString("observacion") == null) || (dsObsGenRRHH.getString("observacion").equals(""))) {
							dsObsGenRRHH.next();
							continue;
						}
					}

					if (evalObsGen.isNew()) {
						evalObsGen.setFec_alta(UtilCIP.getFechaHoraActual(this.getSesion()));
						evalObsGen.setUsuario_alta(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()));
					} else {
						evalObsGen.setFec_utl_modif(UtilCIP.getFechaHoraActual(this.getSesion()));
						evalObsGen.setUsuario_modif(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()));
					}

					evalObsGen.setEvaluacion(evaluacionLegajoCab);
					evalObsGen.setObservacion(dsObsGenRRHH.getString("observacion"));
					evalObsGen.setActivo(dsObsGenRRHH.getBoolean("activo"));
					evaluacionLegajoCab.addObsGenerales(evalObsGen);
					dsObsGenRRHH.next();
				}

				IDataSet dsAspectosDest = dsEvaluacionCAB.getDataSet("TAspectosDestacados");
				dsAspectosDest.first();
				while (!dsAspectosDest.EOF()) {
					EvalAspectos evalAspectos = EvalAspectos.findByOid(dsAspectosDest.getInteger("OID_EVAL_ASP"), this.getSesion());

					if (evalAspectos.isNew()) {
						if ((dsAspectosDest.getString("ASPECTO") == null) || (dsAspectosDest.getString("ASPECTO").equals(""))) {
							dsAspectosDest.next();
							continue;
						}
					}

					if (evalAspectos.isNew()) {
						evalAspectos.setFec_alta(UtilCIP.getFechaHoraActual(this.getSesion()));
						evalAspectos.setUsuario_alta(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()));
					} else {
						evalAspectos.setFec_modif(UtilCIP.getFechaHoraActual(this.getSesion()));
						evalAspectos.setUsuario_modif(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()));
					}
					evalAspectos.setEvaluacion(evaluacionLegajoCab);
					evalAspectos.setTipo_aspecto(EvalAspectos.ASP_DES);
					evalAspectos.setAspecto(dsAspectosDest.getString("ASPECTO"));
					evalAspectos.setActivo(dsAspectosDest.getBoolean("ACTIVO"));
					evaluacionLegajoCab.addAspectos(evalAspectos);
					dsAspectosDest.next();
				}

				IDataSet dsAspectosMej = dsEvaluacionCAB.getDataSet("TAspectosAMejorar");
				dsAspectosMej.first();
				while (!dsAspectosMej.EOF()) {
					EvalAspectos evalAspectos = EvalAspectos.findByOid(dsAspectosMej.getInteger("OID_EVAL_ASP"), this.getSesion());

					if (evalAspectos.isNew()) {
						if ((dsAspectosMej.getString("ASPECTO") == null) || (dsAspectosMej.getString("ASPECTO").equals(""))) {
							dsAspectosMej.next();
							continue;
						}
					}

					if (evalAspectos.isNew()) {
						evalAspectos.setFec_alta(UtilCIP.getFechaHoraActual(this.getSesion()));
						evalAspectos.setUsuario_alta(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()));
					} else {
						evalAspectos.setFec_modif(UtilCIP.getFechaHoraActual(this.getSesion()));
						evalAspectos.setUsuario_modif(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()));
					}
					evalAspectos.setEvaluacion(evaluacionLegajoCab);
					evalAspectos.setTipo_aspecto(EvalAspectos.ASP_MEJ);
					evalAspectos.setAspecto(dsAspectosMej.getString("ASPECTO"));
					evalAspectos.setActivo(dsAspectosMej.getBoolean("ACTIVO"));
					evaluacionLegajoCab.addAspectos(evalAspectos);
					dsAspectosMej.next();
				}

				// Verificar que tenga una sola competencia
				if (modeloEvalCab.getCompetencias().size() != 1)
					throw new ExceptionValidation(null, "El modelo a seleccionar debe tener una sola competencia.");
				
				Competencia competencia = (Competencia) modeloEvalCab.getCompetencias().get(0);
				EvalCargaResul evalCargaResul = (EvalCargaResul) evaluacionLegajoCab.getEvalCargaResul(competencia);
				if (evalCargaResul == null) {
					evalCargaResul = (EvalCargaResul) EvalCargaResul.getNew(EvalCargaResul.NICKNAME, this.getSesion());
					evalCargaResul.setEvaluacion(evaluacionLegajoCab);
					evalCargaResul.setCompetencia(competencia);
				}
				evalCargaResul.setActivo(true);
				evalCargaResul.setNro_grado(dsEvaluacionesLeg.getInteger("puntaje"));
				evaluacionLegajoCab.addResulCompe(evalCargaResul);

				addTransaccion(evaluacionLegajoCab);

				dsEvaluacionesLeg.next();
			}

			dsEvaluacionCAB.next();
		}


	}

}
