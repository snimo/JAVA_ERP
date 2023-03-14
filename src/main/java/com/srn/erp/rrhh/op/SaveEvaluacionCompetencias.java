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
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEvaluacionCompetencias extends Operation {

	public SaveEvaluacionCompetencias() {
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
			
			EvaluacionLegajoCab evaluacion = EvaluacionLegajoCab.findByOid(dsEvaluacionCAB.getInteger("oid_eval_cab"), this.getSesion());
			ModeloEvalCab modeloEvalCab = ModeloEvalCab.findByOidProxy(dsEvaluacionCAB.getInteger("oid_mod_eval_cab"), this.getSesion());
			evaluacion.setModelo_eval_cab(modeloEvalCab);
			evaluacion.setLegajo(Legajo.findByOidProxy(dsEvaluacionCAB.getInteger("oid_legajo"), this.getSesion()));
			evaluacion.setFec_eval(dsEvaluacionCAB.getDate("fec_eval"));
			evaluacion.setCondModEvalCab(CondModEvalCab.findByOidProxy(dsEvaluacionCAB.getInteger("oid_cond_mod_eval"), this.getSesion()));
			evaluacion.setComen_del_evaluado(dsEvaluacionCAB.getString("comen_del_evaluado"));
			evaluacion.setValClasifPueFut(ValorClasificadorEntidad.findByOidProxy(dsEvaluacionCAB.getInteger("oid_val_pue_fut"), this.getSesion()));
			
			//Actualizar los valores del Clasificador
			ValorClasificadorEntidad valorClasifEntidadEmp = ValorClasificadorEntidad.findByOidProxy(dsEvaluacionCAB.getInteger("oid_empresa"), this.getSesion()); 
			ValorClasificadorEntidad valorClasifEntidadSec = ValorClasificadorEntidad.findByOidProxy(dsEvaluacionCAB.getInteger("oid_sector"), this.getSesion());
			ValorClasificadorEntidad valorClasifEntidadPue = ValorClasificadorEntidad.findByOidProxy(dsEvaluacionCAB.getInteger("oid_puesto"), this.getSesion());
			ValorClasificadorEntidad valorClasifEntidadEst = ValorClasificadorEntidad.findByOidProxy(dsEvaluacionCAB.getInteger("oid_estado"), this.getSesion());
			
			EvalValClasifLeg evalValClasifLegEmp = evaluacion.getEvalValClasifLeg(clasifEmpresa);
			if (evalValClasifLegEmp!=null) {
				if (valorClasifEntidadEmp==null) 
					evalValClasifLegEmp.setActivo(false);
				else 
					evalValClasifLegEmp.setValor_clasificador(valorClasifEntidadEmp);
				evaluacion.addValorClasificador(evalValClasifLegEmp);
			} else {
				if (valorClasifEntidadEmp!=null) {
					EvalValClasifLeg newEvalValClasifLegEmp = (EvalValClasifLeg) EvalValClasifLeg.getNew(EvalValClasifLeg.NICKNAME, this.getSesion());
					newEvalValClasifLegEmp.setEvaluacion(evaluacion);
					newEvalValClasifLegEmp.setClasificador(clasifEmpresa);
					newEvalValClasifLegEmp.setValor_clasificador(valorClasifEntidadEmp);
					newEvalValClasifLegEmp.setActivo(true);
					evaluacion.addValorClasificador(newEvalValClasifLegEmp);
				}
			}
			
			
			EvalValClasifLeg evalValClasifLegSec = evaluacion.getEvalValClasifLeg(clasifSector);
			if (evalValClasifLegSec!=null) {
				if (valorClasifEntidadSec==null) 
					evalValClasifLegSec.setActivo(false);
				else 
					evalValClasifLegSec.setValor_clasificador(valorClasifEntidadSec);
				evaluacion.addValorClasificador(evalValClasifLegSec);
			} else {
				if (valorClasifEntidadSec!=null) {
					EvalValClasifLeg newEvalValClasifLegSec = (EvalValClasifLeg) EvalValClasifLeg.getNew(EvalValClasifLeg.NICKNAME, this.getSesion());
					newEvalValClasifLegSec.setEvaluacion(evaluacion);
					newEvalValClasifLegSec.setClasificador(clasifSector);
					newEvalValClasifLegSec.setValor_clasificador(valorClasifEntidadSec);
					newEvalValClasifLegSec.setActivo(true);
					evaluacion.addValorClasificador(newEvalValClasifLegSec);
				}
			}
			
			
			
			EvalValClasifLeg evalValClasifLegPue = evaluacion.getEvalValClasifLeg(clasifPuesto);
			if (evalValClasifLegPue!=null) {
				if (valorClasifEntidadPue==null) 
					evalValClasifLegPue.setActivo(false);
				else 
					evalValClasifLegPue.setValor_clasificador(valorClasifEntidadPue);
				evaluacion.addValorClasificador(evalValClasifLegPue);
			} else {
				if (valorClasifEntidadPue!=null) {
					EvalValClasifLeg newEvalValClasifLegPue = (EvalValClasifLeg) EvalValClasifLeg.getNew(EvalValClasifLeg.NICKNAME, this.getSesion());
					newEvalValClasifLegPue.setEvaluacion(evaluacion);
					newEvalValClasifLegPue.setClasificador(clasifPuesto);
					newEvalValClasifLegPue.setValor_clasificador(valorClasifEntidadPue);
					newEvalValClasifLegPue.setActivo(true);
					evaluacion.addValorClasificador(newEvalValClasifLegPue);
				}
			}
			
			EvalValClasifLeg evalValClasifLegEst = evaluacion.getEvalValClasifLeg(clasifEstado);
			if (evalValClasifLegEst!=null) {
				if (evalValClasifLegEst==null) 
					evalValClasifLegEst.setActivo(false);
				else 
					evalValClasifLegEst.setValor_clasificador(valorClasifEntidadEst);
				evaluacion.addValorClasificador(evalValClasifLegEst);
			} else {
				if (valorClasifEntidadEst!=null) {
					EvalValClasifLeg newEvalValClasifLegEst = (EvalValClasifLeg) EvalValClasifLeg.getNew(EvalValClasifLeg.NICKNAME, this.getSesion());
					newEvalValClasifLegEst.setEvaluacion(evaluacion);
					newEvalValClasifLegEst.setClasificador(clasifEstado);
					newEvalValClasifLegEst.setValor_clasificador(valorClasifEntidadEst);
					newEvalValClasifLegEst.setActivo(true);
					evaluacion.addValorClasificador(newEvalValClasifLegEst);
				}
			}
			
			
			
			if (evaluacion.isNew()) {
				evaluacion.setUsuario_alta(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOID(), this.getSesion()));
				evaluacion.setFec_alta_carga(UtilCIP.getFechaHoraActual(this.getSesion()));
				int nroMaxVersion = EvaluacionLegajoCab.getNroMaxVersion(evaluacion.getModelo_eval_cab(),evaluacion.getLegajo(),this.getSesion());
				evaluacion.setVersion_eval(nroMaxVersion+1);
				evaluacion.setVigente(true);
				evaluacion.setActuEnNoVigenteOtrasVersiones(true);
			}
			
			evaluacion.setActivo(dsEvaluacionCAB.getBoolean("activo"));
			
			
			IDataSet dsEvaluadores = dsEvaluacionCAB.getDataSet("TEvaluadores");
			dsEvaluadores.first();
			while (!dsEvaluadores.EOF()) {
				EvalEvaluador evalEvaluador = EvalEvaluador.findByOid(dsEvaluadores.getInteger("oid_eval_evaluador"), this.getSesion());
				evalEvaluador.setEvaluacion(evaluacion);
				evalEvaluador.setLegajo(Legajo.findByOidProxy(dsEvaluadores.getInteger("oid_legajo"), this.getSesion()));
				evalEvaluador.setFirmado(dsEvaluadores.getBoolean("firmado"));
				evalEvaluador.setFec_firmado(dsEvaluadores.getDate("fec_firmado"));
				evalEvaluador.setActivo(dsEvaluadores.getBoolean("activo"));
				
				evaluacion.addEvaluador(evalEvaluador);
				
				dsEvaluadores.next();
			}
			
			
			IDataSet dsFirmas = dsEvaluacionCAB.getDataSet("TFirmas");
			dsFirmas.first();
			while (!dsFirmas.EOF()) {
				EvalFirma evalFirma = EvalFirma.findByOid(dsFirmas.getInteger("oid_firma_eval"), this.getSesion());
				evalFirma.setEvaluacion(evaluacion);
				evalFirma.setNro_firma(dsFirmas.getInteger("nro_firma"));
				evalFirma.setLegajo_firma(Legajo.findByOidProxy(dsFirmas.getInteger("oid_legajo_firma"), this.getSesion()));
				evalFirma.setFirmo(dsFirmas.getBoolean("firmo"));
				evalFirma.setFec_firma(dsFirmas.getDate("fec_firma"));
				evalFirma.setActivo(dsFirmas.getBoolean("activo"));
				evalFirma.setTitulo(dsFirmas.getString("puesto"));
				evaluacion.addFirma(evalFirma);
				dsFirmas.next();
			}
			
			
			
			
			
			IDataSet dsObsGenRRHH = dsEvaluacionCAB.getDataSet("TObsGenRRHH");
			dsObsGenRRHH.first();
			while (!dsObsGenRRHH.EOF()) {
				EvalObsGen evalObsGen = EvalObsGen.findByOid(dsObsGenRRHH.getInteger("oid_obs_gen"), this.getSesion());
				
				if (evalObsGen.isNew()) {
					if ((dsObsGenRRHH.getString("observacion")==null) || (dsObsGenRRHH.getString("observacion").equals(""))) {
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
				
				evalObsGen.setEvaluacion(evaluacion);
				evalObsGen.setObservacion(dsObsGenRRHH.getString("observacion"));
				evalObsGen.setActivo(dsObsGenRRHH.getBoolean("activo"));
				evaluacion.addObsGenerales(evalObsGen);
				dsObsGenRRHH.next();
			}
			
			
			
			IDataSet dsAspectosDest = dsEvaluacionCAB.getDataSet("TAspectosDestacados");
			dsAspectosDest.first();
			while (!dsAspectosDest.EOF()) {
				EvalAspectos evalAspectos = EvalAspectos.findByOid(dsAspectosDest.getInteger("OID_EVAL_ASP"), this.getSesion());
				
				
				if (evalAspectos.isNew()) {
					if ((dsAspectosDest.getString("ASPECTO")==null) || (dsAspectosDest.getString("ASPECTO").equals(""))) {
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
				evalAspectos.setEvaluacion(evaluacion);
				evalAspectos.setTipo_aspecto(EvalAspectos.ASP_DES);
				evalAspectos.setAspecto(dsAspectosDest.getString("ASPECTO"));
				evalAspectos.setActivo(dsAspectosDest.getBoolean("ACTIVO"));
				evaluacion.addAspectos(evalAspectos);
				dsAspectosDest.next();
			}
			
			IDataSet dsAspectosMej = dsEvaluacionCAB.getDataSet("TAspectosAMejorar");
			dsAspectosMej.first();
			while (!dsAspectosMej.EOF()) {
				EvalAspectos evalAspectos = EvalAspectos.findByOid(dsAspectosMej.getInteger("OID_EVAL_ASP"), this.getSesion());
				
				if (evalAspectos.isNew()) {
					if ((dsAspectosMej.getString("ASPECTO")==null) || (dsAspectosMej.getString("ASPECTO").equals(""))) {
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
				evalAspectos.setEvaluacion(evaluacion);
				evalAspectos.setTipo_aspecto(EvalAspectos.ASP_MEJ);
				evalAspectos.setAspecto(dsAspectosMej.getString("ASPECTO"));
				evalAspectos.setActivo(dsAspectosMej.getBoolean("ACTIVO"));
				evaluacion.addAspectos(evalAspectos);
				dsAspectosMej.next();
			}
			
			
			
			
			IDataSet dsCompetencias = dsEvaluacionCAB.getDataSet("TCompetenciasEval");
			dsCompetencias.first();
			while (!dsCompetencias.EOF()) {
				Competencia competencia = Competencia.findByOidProxy(dsCompetencias.getInteger("oid_competencia"), this.getSesion());
				EvalCargaResul evalCargaResul = (EvalCargaResul) evaluacion.getEvalCargaResul(competencia);
				if (evalCargaResul == null) {
					evalCargaResul = (EvalCargaResul) EvalCargaResul.getNew(EvalCargaResul.NICKNAME, this.getSesion());
					evalCargaResul.setEvaluacion(evaluacion);
					evalCargaResul.setCompetencia(competencia);
					evalCargaResul.setActivo(true);
				}
				evalCargaResul.setNro_grado(dsCompetencias.getInteger("nro_grado"));
				evalCargaResul.setActivo(true);
				evaluacion.addResulCompe(evalCargaResul);
				dsCompetencias.next();
			}
			
			addTransaccion(evaluacion);
			
			dsEvaluacionCAB.next();
		}
		
	}

}
