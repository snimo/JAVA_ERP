package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBEvaluacionLegajoCab;
import com.srn.erp.rrhh.da.DBModeloEvalCompe;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class EvaluacionLegajoCab extends ObjetoLogico {

	public boolean desHabilitarAfterNew = false;
	public boolean desHabilitarAfterModif = false;

	@Override
	public void afterSaveNew() throws BaseException {

		if (desHabilitarAfterNew)
			return;

		// TODO Auto-generated method stub
		super.afterSaveNew();

		if (this.isActuEnNoVigenteOtrasVersiones())
			EvaluacionLegajoCab.marcarOtrasEvalComoNoVigentes(this.getModelo_eval_cab(), this.getLegajo(), this, this.getSesion());

		EvaluacionLegajoCab.calcularPuntaje(this.getSesion(), this.getOIDInteger());
	}

	@Override
	public void afterSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveDelete();

		if (this.isVigente() == true) {
			// Buscar una evaluación Activa

			Iterator iterEvaluacionLegajoCab = EvaluacionLegajoCab.getEvaluacionesActivasModeloLeg(this.getModelo_eval_cab(), this.getLegajo(), this.getSesion()).iterator();
			while (iterEvaluacionLegajoCab.hasNext()) {
				EvaluacionLegajoCab evaluacionLegajoCab = (EvaluacionLegajoCab) iterEvaluacionLegajoCab.next();
				if (!evaluacionLegajoCab.isVigente()) {
					evaluacionLegajoCab.supportRefresh();
					evaluacionLegajoCab.setVigente(true);
					evaluacionLegajoCab.save();
					EvaluacionLegajoCab.marcarOtrasEvalComoNoVigentes(this.getModelo_eval_cab(), this.getLegajo(), evaluacionLegajoCab, this.getSesion());
					break;
				}
			}

		}

	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		StringBuffer armarCodigo = new StringBuffer("");
		if (this.getModelo_eval_cab() != null)
			armarCodigo.append(this.getModelo_eval_cab().getDesc_abreviada());

		if (this.getVersion_eval() != null)
			armarCodigo.append(" V." + this.getVersion_eval());

		return armarCodigo.toString();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afterSaveModified() throws BaseException {
		// TODO Auto-generated method stub

		if (desHabilitarAfterModif)
			return;

		super.afterSaveModified();

		EvaluacionLegajoCab.calcularPuntaje(this.getSesion(), this.getOIDInteger());

	}

	public EvaluacionLegajoCab() {
	}

	private List valoresClasificadores = new ArrayList();
	private boolean readValoresClasificadores = true;

	private List aspectos = new ArrayList();
	private boolean readAspectos = true;

	private List evaluadores = new ArrayList();
	private boolean readEvaluadores = true;

	private List obsGenerales = new ArrayList();
	private boolean readObsGenerales = true;

	private List firmas = new ArrayList();
	private boolean readFirmas = true;

	private List resultadosCompe = new ArrayList();
	private boolean readResultadosCompe = true;

	public static String NICKNAME = "rh.EvaluacionLegajoCab";

	private Integer version_eval;
	private ModeloEvalCab modelo_eval_cab;
	private Legajo legajo;
	private java.util.Date fec_eval;
	private java.util.Date fec_puntuacion;
	private Usuario usuario_alta;
	private java.util.Date fec_alta_carga;
	private Usuario usuario_modif;
	private java.util.Date fec_ult_modif;
	private Money puntaje;
	private Boolean firmado;
	private java.util.Date fec_firmado;
	private String comen_del_evaluado;
	private Boolean activo;
	private CondModEvalCab condModEvalCab;
	private boolean vigente;
	private boolean actuEnNoVigenteOtrasVersiones = false;
	private ValorClasificadorEntidad tempValClasifEmp;
	private ValorClasificadorEntidad tempValClasifSec;
	private ValorClasificadorEntidad tempValClasifPue;
	private ValorClasificadorEntidad tempValClasifEst;
	private ValorClasificadorEntidad valClasifPueFuturo; 

	public ValorClasificadorEntidad getTempValClasifEmp() {
		return tempValClasifEmp;
	}

	public void setTempValClasifEmp(ValorClasificadorEntidad tempValClasifEmp) {
		this.tempValClasifEmp = tempValClasifEmp;
	}

	public ValorClasificadorEntidad getTempValClasifSec() {
		return tempValClasifSec;
	}

	public void setTempValClasifSec(ValorClasificadorEntidad tempValClasifSec) {
		this.tempValClasifSec = tempValClasifSec;
	}

	public ValorClasificadorEntidad getTempValClasifPue() {
		return tempValClasifPue;
	}

	public void setTempValClasifPue(ValorClasificadorEntidad tempValClasifPue) {
		this.tempValClasifPue = tempValClasifPue;
	}

	public ValorClasificadorEntidad getTempValClasifEst() {
		return tempValClasifEst;
	}

	public void setTempValClasifEst(ValorClasificadorEntidad tempValClasifEst) {
		this.tempValClasifEst = tempValClasifEst;
	}

	public boolean isActuEnNoVigenteOtrasVersiones() {
		return actuEnNoVigenteOtrasVersiones;
	}

	public void setActuEnNoVigenteOtrasVersiones(boolean actuEnNoVigenteOtrasVersiones) {
		this.actuEnNoVigenteOtrasVersiones = actuEnNoVigenteOtrasVersiones;
	}

	public CondModEvalCab getCondModEvalCab() throws BaseException {
		supportRefresh();
		return condModEvalCab;
	}
	
	public ValorClasificadorEntidad getValClasifPuestoFuturo() throws BaseException {
		supportRefresh();
		return this.valClasifPueFuturo;
	}	

	public void setCondModEvalCab(CondModEvalCab aCondModEvalCab) {
		this.condModEvalCab = aCondModEvalCab;
	}
	
	public void setValClasifPueFut(ValorClasificadorEntidad aValClasifPueFut) {
		this.valClasifPueFuturo = aValClasifPueFut;
	}	

	public void setVigente(boolean aVigente) {
		this.vigente = aVigente;
	}

	public Integer getVersion_eval() throws BaseException {
		supportRefresh();
		return version_eval;
	}

	public boolean isVigente() throws BaseException {
		supportRefresh();
		return this.vigente;
	}

	public void setVersion_eval(Integer aVersion_eval) {
		this.version_eval = aVersion_eval;
	}

	public ModeloEvalCab getModelo_eval_cab() throws BaseException {
		supportRefresh();
		return modelo_eval_cab;
	}

	public void setModelo_eval_cab(ModeloEvalCab aModelo_eval_cab) {
		this.modelo_eval_cab = aModelo_eval_cab;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public java.util.Date getFec_eval() throws BaseException {
		supportRefresh();
		return fec_eval;
	}

	public void setFec_eval(java.util.Date aFec_eval) {
		this.fec_eval = aFec_eval;
	}

	public java.util.Date getFec_puntuacion() throws BaseException {
		supportRefresh();
		return fec_puntuacion;
	}

	public void setFec_puntuacion(java.util.Date aFec_puntuacion) {
		this.fec_puntuacion = aFec_puntuacion;
	}

	public Usuario getUsuario_alta() throws BaseException {
		supportRefresh();
		return usuario_alta;
	}

	public void setUsuario_alta(Usuario aUsuario_alta) {
		this.usuario_alta = aUsuario_alta;
	}

	public java.util.Date getFec_alta_carga() throws BaseException {
		supportRefresh();
		return fec_alta_carga;
	}

	public void setFec_alta_carga(java.util.Date aFec_alta_carga) {
		this.fec_alta_carga = aFec_alta_carga;
	}

	public Usuario getUsuario_modif() throws BaseException {
		supportRefresh();
		return usuario_modif;
	}

	public void setUsuario_modif(Usuario aUsuario_modif) {
		this.usuario_modif = aUsuario_modif;
	}

	public java.util.Date getFec_ult_modif() throws BaseException {
		supportRefresh();
		return fec_ult_modif;
	}

	public void setFec_ult_modif(java.util.Date aFec_ult_modif) {
		this.fec_ult_modif = aFec_ult_modif;
	}

	public Money getPuntaje() throws BaseException {
		supportRefresh();
		if (puntaje == null)
			return new Money(0);
		else
			return puntaje;
	}

	public int getPuntajeEntero() throws BaseException {

		Money puntajeEntero = new Money(0);
		if (this.getPuntaje() != null)
			puntajeEntero = this.getPuntaje();

		CalculadorMoney calc = new CalculadorMoney(puntajeEntero);
		calc.sumar(new Money(0.5));
		int sinDecimales = (int) calc.getResultMoney().doubleValue();

		return sinDecimales;

	}

	public void setPuntaje(Money aPuntaje) {
		this.puntaje = aPuntaje;
	}

	public Boolean isFirmado() throws BaseException {
		supportRefresh();
		return firmado;
	}

	public void setFirmado(Boolean aFirmado) {
		this.firmado = aFirmado;
	}

	public java.util.Date getFec_firmado() throws BaseException {
		supportRefresh();
		return fec_firmado;
	}

	public void setFec_firmado(java.util.Date aFec_firmado) {
		this.fec_firmado = aFec_firmado;
	}

	public String getComen_del_evaluado() throws BaseException {
		supportRefresh();
		return comen_del_evaluado;
	}

	public void setComen_del_evaluado(String aComen_del_evaluado) {
		this.comen_del_evaluado = aComen_del_evaluado;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static EvaluacionLegajoCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EvaluacionLegajoCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EvaluacionLegajoCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EvaluacionLegajoCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EvaluacionLegajoCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EvaluacionLegajoCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(version_eval, "Debe ingresar la Versión");
		Validar.noNulo(modelo_eval_cab, "Debe ingresar el Modelo");
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(fec_eval, "Debe ingresar la Fecha de Evaluación");
		Validar.noNulo(usuario_alta, "Debe ingresar el Usuario de Alta");
		Validar.noNulo(fec_alta_carga, "Debe ingresar la Fecha de Alta");
		Validar.noNulo(condModEvalCab, "No existe una condición que se cumpla para el Legajo en ese modelo de Evaluación");
	}

	public List getValoresClasificador() throws BaseException {
		if (this.readValoresClasificadores) {
			List listaValoresClasif = EvalValClasifLeg.getEvalValoresClasif(this, getSesion());
			valoresClasificadores.addAll(listaValoresClasif);
			this.readValoresClasificadores = false;
		}
		return valoresClasificadores;
	}

	public List getAspectos() throws BaseException {
		if (this.readAspectos) {
			List listaAspectos = EvalAspectos.getEvalAspectos(this, getSesion());
			aspectos.addAll(listaAspectos);
			this.readAspectos = false;
		}
		return aspectos;
	}

	public List getEvaluadores() throws BaseException {
		if (this.readEvaluadores) {
			List listaEvaluadores = EvalEvaluador.getEvalEvaluadores(this, getSesion());
			evaluadores.addAll(listaEvaluadores);
			this.readEvaluadores = false;
		}
		return evaluadores;
	}

	public List getObsGenerales() throws BaseException {
		if (this.readObsGenerales) {
			List listaObsGenerales = EvalObsGen.getEvalObsGen(this, getSesion());
			obsGenerales.addAll(listaObsGenerales);
			this.readObsGenerales = false;
		}
		return obsGenerales;
	}

	public List getFirmas() throws BaseException {
		if (this.readFirmas) {
			List listaFirmas = EvalFirma.getEvalFirmas(this, getSesion());
			firmas.addAll(listaFirmas);
			this.readFirmas = false;
		}
		return firmas;
	}

	public List getResultadosCompe() throws BaseException {
		if (this.readResultadosCompe) {
			List listaResultCompe = EvalCargaResul.getEvalCargaResul(this, getSesion());
			resultadosCompe.addAll(listaResultCompe);
			this.readResultadosCompe = false;
		}
		return resultadosCompe;
	}

	public void addValorClasificador(EvalValClasifLeg aEvalValClasifLeg) throws BaseException {
		aEvalValClasifLeg.setEvaluacion(this);
		valoresClasificadores.add(aEvalValClasifLeg);
	}

	public void addFirma(EvalFirma aEvalFirma) throws BaseException {
		aEvalFirma.setEvaluacion(this);
		firmas.add(aEvalFirma);
	}

	public void addEvaluador(EvalEvaluador aEvalEvaluador) throws BaseException {
		aEvalEvaluador.setEvaluacion(this);
		evaluadores.add(aEvalEvaluador);
	}

	public void addObsGenerales(EvalObsGen aEvalObsGen) throws BaseException {
		aEvalObsGen.setEvaluacion(this);
		obsGenerales.add(aEvalObsGen);
	}

	public void addAspectos(EvalAspectos aEvalAspectos) throws BaseException {
		aEvalAspectos.setEvaluacion(this);
		aspectos.add(aEvalAspectos);
	}

	public void addResulCompe(EvalCargaResul aEvalCargaResul) throws BaseException {
		aEvalCargaResul.setEvaluacion(this);
		resultadosCompe.add(aEvalCargaResul);
	}

	public void afterSave() throws BaseException {

		Iterator iterValoresClasif = valoresClasificadores.iterator();
		while (iterValoresClasif.hasNext()) {
			EvalValClasifLeg evalValClasifLeg = (EvalValClasifLeg) iterValoresClasif.next();
			evalValClasifLeg.save();
			evalValClasifLeg = null;
		}
		iterValoresClasif = null;

		Iterator iterAspectos = aspectos.iterator();
		while (iterAspectos.hasNext()) {
			EvalAspectos evalAspecto = (EvalAspectos) iterAspectos.next();
			evalAspecto.save();
			evalAspecto = null;
		}
		iterAspectos = null;

		Iterator iterEvaluadores = evaluadores.iterator();
		while (iterEvaluadores.hasNext()) {
			EvalEvaluador evaluador = (EvalEvaluador) iterEvaluadores.next();
			evaluador.save();
			evaluador = null;
		}
		iterEvaluadores = null;

		Iterator iterObsGenerales = obsGenerales.iterator();
		while (iterObsGenerales.hasNext()) {
			EvalObsGen evalObsGen = (EvalObsGen) iterObsGenerales.next();
			evalObsGen.save();
			evalObsGen = null;
		}
		iterObsGenerales = null;

		Iterator iterFirmas = firmas.iterator();
		while (iterFirmas.hasNext()) {
			EvalFirma firma = (EvalFirma) iterFirmas.next();
			firma.save();
			firma = null;
		}
		iterFirmas = null;

		Iterator iterResulCompe = resultadosCompe.iterator();
		while (iterResulCompe.hasNext()) {
			EvalCargaResul evalCargaResul = (EvalCargaResul) iterResulCompe.next();
			evalCargaResul.save();
			evalCargaResul = null;
		}
		iterResulCompe = null;

	}

	public static String getArchLogoRepEval(ISesion aSesion) throws BaseException {
		ValorParametro valorPathImagenesLeg = ValorParametro.findByCodigoParametro("ARCH_LOGO_REP_EVAL", aSesion);
		return valorPathImagenesLeg.getValorCadena();
	}

	public EvalCargaResul getEvalCargaResul(Competencia competencia) throws BaseException {
		return EvalCargaResul.getEvalCargaResul(this, competencia, this.getSesion());
	}

	public EvalValClasifLeg getEvalValClasifLeg(ClasificadorEntidad clasificador) throws BaseException {
		return EvalValClasifLeg.getEvalValClasifLeg(this, clasificador, this.getSesion());
	}

	public static void marcarOtrasEvalComoNoVigentes(ModeloEvalCab modelo, Legajo legajo, EvaluacionLegajoCab evaluacion, ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ModeloEvalCab.NICKNAME, modelo);
		condiciones.put(Legajo.NICKNAME, legajo);
		condiciones.put(EvaluacionLegajoCab.NICKNAME, evaluacion);

		ObjetoLogico.getObjects(EvaluacionLegajoCab.NICKNAME, DBEvaluacionLegajoCab.UPDATE_NO_VIGENTE, condiciones, null, aSesion);
	}

	public static List getConsulta(java.util.Date fecDesde, java.util.Date fecHasta, List modelo, List legajos, List empresas, List sectores, List puestos, List estados, ISesion aSesion)
			throws BaseException {
		return DBEvaluacionLegajoCab.getConsulta(fecDesde, fecHasta, modelo, legajos, empresas, sectores, puestos, estados, aSesion);
	}

	public static void calcularPuntaje(ISesion sesion, Integer oidEvalLegCab) throws BaseException {

		EvaluacionLegajoCab evalLegCab = EvaluacionLegajoCab.findByOid(oidEvalLegCab, sesion);

		CalculadorMoney totValoresCompe = new CalculadorMoney(new Money(0));
		HashTableDatos pesosCompetencias = new HashTableDatos();
		HashTableDatos pesosGrados = new HashTableDatos();

		Iterator iterCompeCond = evalLegCab.getCondModEvalCab().getCompetenciasCondicion().iterator();
		while (iterCompeCond.hasNext()) {
			// Acumuluar pesos de competencias
			ModeloEvalCompe modeloEvalCompe = (ModeloEvalCompe) iterCompeCond.next();
			if (modeloEvalCompe.getPeso_competencia() != null)
				totValoresCompe.sumar(modeloEvalCompe.getPeso_competencia());
			else
				totValoresCompe.sumar(new Money(0));
		}

		iterCompeCond = evalLegCab.getCondModEvalCab().getCompetenciasCondicion().iterator();
		while (iterCompeCond.hasNext()) {
			ModeloEvalCompe modeloEvalCompe = (ModeloEvalCompe) iterCompeCond.next();

			CalculadorMoney calcPesoCompe = new CalculadorMoney(new Money(0));
			if (modeloEvalCompe.getPeso_competencia() != null)
				calcPesoCompe.sumar(modeloEvalCompe.getPeso_competencia());
			if ((totValoresCompe.getResultMoney() != null) && (totValoresCompe.getResultMoney().doubleValue() != 0))
				calcPesoCompe.dividirPor(totValoresCompe.getResultMoney());
			else
				calcPesoCompe.multiplicarPor(new Money(0));
			calcPesoCompe.multiplicarPor(new Money(100));

			pesosCompetencias.put(modeloEvalCompe.getCompetencia().getOIDInteger(), calcPesoCompe.getResultMoney());

			Iterator iterGrados = modeloEvalCompe.getGrados().iterator();
			while (iterGrados.hasNext()) {
				ModeloEvalGrados modeloEvalGrados = (ModeloEvalGrados) iterGrados.next();
				CalculadorMoney calcPesosGrado = new CalculadorMoney(new Money(0));
				if (modeloEvalGrados.getPeso() != null)
					calcPesosGrado.sumar(modeloEvalGrados.getPeso());
				// Obtener el total de Grados por Compe
				calcPesosGrado.dividirPor(new Money(100));
				pesosGrados.put(modeloEvalCompe.getCompetencia().getOIDInteger() + "_" + modeloEvalGrados.getNro_grado(), calcPesosGrado.getResultMoney());
			}

		}

		CalculadorMoney totPuntajeEval = new CalculadorMoney(new Money(0));
		HashTableDatos puntajePorCompe = new HashTableDatos();
		HashTableDatos porcCumpGradoPorCompe = new HashTableDatos();

		iterCompeCond = evalLegCab.getCondModEvalCab().getCompetenciasCondicion().iterator();
		while (iterCompeCond.hasNext()) {
			ModeloEvalCompe modeloEvalCompe = (ModeloEvalCompe) iterCompeCond.next();
			EvalCargaResul evalCargaResul = evalLegCab.getEvalCargaResul(modeloEvalCompe.getCompetencia());

			// Calcular combinacio competencia grado
			Money pesoCompetencia = (Money) pesosCompetencias.get(modeloEvalCompe.getCompetencia().getOIDInteger());
			Money pesoGrado = new Money(0);
			if (evalCargaResul != null)
				pesoGrado = (Money) pesosGrados.get(modeloEvalCompe.getCompetencia().getOIDInteger() + "_" + evalCargaResul.getNro_grado());

			if (pesoCompetencia == null)
				pesoCompetencia = new Money(0);
			if (pesoGrado == null)
				pesoGrado = new Money(0);

			CalculadorMoney calcResultCompe = new CalculadorMoney(pesoCompetencia);
			calcResultCompe.multiplicarPor(pesoGrado);
			totPuntajeEval.sumar(calcResultCompe.getResultMoney());
			CalculadorMoney porcCumpGrado = new CalculadorMoney(new Money(0));
			if (pesoGrado != null)
				porcCumpGrado.sumar(pesoGrado);
			porcCumpGrado.multiplicarPor(new Money(100));

			puntajePorCompe.put(modeloEvalCompe.getCompetencia().getOIDInteger(), calcResultCompe.getResultMoney());
			porcCumpGradoPorCompe.put(modeloEvalCompe.getCompetencia().getOIDInteger(), porcCumpGrado.getResultMoney());

		}

		evalLegCab.setPuntaje(totPuntajeEval.getResultMoney());

		Iterator iterResulCompe = evalLegCab.getResultadosCompe().iterator();
		while (iterResulCompe.hasNext()) {
			EvalCargaResul evalCargaResul = (EvalCargaResul) iterResulCompe.next();
			Money puntPorCompe = (Money) puntajePorCompe.get(evalCargaResul.getCompetencia().getOIDInteger());
			Money porcGraPorCompe = (Money) porcCumpGradoPorCompe.get(evalCargaResul.getCompetencia().getOIDInteger());
			if (puntPorCompe != null)
				evalCargaResul.setPuntaje(puntPorCompe);
			else
				evalCargaResul.setPuntaje(new Money(0));
			if (porcGraPorCompe != null)
				evalCargaResul.setPorc_cumpli(porcGraPorCompe);
			else
				evalCargaResul.setPorc_cumpli(new Money(0));
		}

		evalLegCab.desHabilitarAfterNew = true;
		evalLegCab.desHabilitarAfterModif = true;

		try {
			evalLegCab.save();
		} finally {
			evalLegCab.desHabilitarAfterNew = false;
			evalLegCab.desHabilitarAfterModif = false;

		}

	}

	public static EvaluacionLegajoCab getEvaluacionLegajoCab(ModeloEvalCab modeloEvalCab, Legajo legajo, ISesion aSesion) throws BaseException {
		return DBEvaluacionLegajoCab.getEvaluacionLegajoCab(modeloEvalCab, legajo, aSesion);
	}

	public static List getOtrasVersiones(ModeloEvalCab modeloEvalCab, Legajo legajo, EvaluacionLegajoCab eEvaluacionLegajoCab, ISesion aSesion) throws BaseException {

		return DBEvaluacionLegajoCab.getOtrasVersiones(modeloEvalCab, legajo, eEvaluacionLegajoCab, aSesion);

	}

	public static int getNroMaxVersion(ModeloEvalCab aModeloEvalCab, Legajo legajo, ISesion aSesion) throws BaseException {

		return DBEvaluacionLegajoCab.getNroMaxVersion(aModeloEvalCab, legajo, aSesion);

	}

	public static List getEvaluacionesActivasModeloLeg(ModeloEvalCab modeloEvalCab, Legajo legajo, ISesion aSesion) throws BaseException {

		return DBEvaluacionLegajoCab.getEvaluacionesActivasModeloLeg(modeloEvalCab, legajo, aSesion);

	}

	public static List getEvaluacionesByModelo(ModeloEvalCab modeloEvalCab, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ModeloEvalCab.NICKNAME, modeloEvalCab);

		return DBEvaluacionLegajoCab.getEvaluacionesByModelo(modeloEvalCab, aSesion);
	}

	public ModeloEvalCompe getModeloEvalCompe(Competencia competencia) throws BaseException {
		return DBModeloEvalCompe.getModeloEvalCompe(this.getCondModEvalCab(), competencia, this.getSesion());
	}

	public static List getEvaluacionesByLegajo(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBEvaluacionLegajoCab.getEvaluacionesByLegajo(aLegajo, aSesion);
	}

	public static EvaluacionLegajoCab getUltimaEvaluacionLegajoCab(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBEvaluacionLegajoCab.getUltimaEvaluacionLegajoCab(aLegajo, aSesion);
	}

	public static EvaluacionLegajoCab getUltimaEvalLegCab(java.util.Date fecDesde, java.util.Date fecHasta, Legajo aLegajo, ISesion aSesion) throws BaseException {

		return DBEvaluacionLegajoCab.getUltimaEvalLegCab(fecDesde, fecHasta, aLegajo, aSesion);
	}
	
	public static EvaluacionLegajoCab getUltimaEvalLegCab(
			java.util.Date fecDesde,
			java.util.Date fecHasta,
			String tipo,
			Legajo aLegajo, ISesion aSesion) throws BaseException {
			return DBEvaluacionLegajoCab.getUltimaEvalLegCab(fecDesde,fecHasta,tipo,aLegajo,aSesion);
	}
	
	public static EvaluacionLegajoCab getEvalByModeloLegFecVig(
			ModeloEvalCab modelo,
			java.util.Date fecha,
			Legajo legajo,ISesion aSesion) throws BaseException {
		 return  DBEvaluacionLegajoCab.getEvalByModeloLegFecVig(modelo,fecha,legajo,aSesion);
		
		
	}	

}
