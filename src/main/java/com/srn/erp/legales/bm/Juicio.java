package com.srn.erp.legales.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.legales.da.DBJuicio;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Juicio extends ObjetoLogico {

	public Juicio() {
	}

	public static String NICKNAME = "leg.Juicio";

	private TipoReclamoLeg tipo_reclamo;
	private java.util.Date fec_rec_dem;
	private Juzgado juzgado;
	private String nro_expediente;
	private Money monto_reclamo;
	private String prob_resultado;
	private Money porc_prevision;
	private EstadoProcesal estado_procesal;
	private EstadoJuicio estado_juicio;
	private Boolean activo;
	private java.util.Date fec_pago;
	private String observaciones;
	private String primeraInstancia;
	private String segundaInstancia;
	private Periodo periodo_mensual;
	private Money prevision;
	private Abogado abogado;
	private Legajo legajo;
	private String cbu;
	private Money embargo;
	private Money estimado;
	private ResultadoJuicio resultadoJuicio;
	private String codigoInterno;
	private java.util.Date fecNovedad;
	private Money montoAcuerdo;
	private Money montoConciliador;
	private Money montoPerito;
	private Money montoTasaJusticia;
	private Money montoLetrado;
	private Money montoIntereses;
	private TipoPericia tipoPericia;
	private Fuero fuero;
	private CompaniaSeguro compSegCaucion;
	private String caratula;
	private Money porcIncapacidad; 
	private Money porcLetrado;
	private Money porcPerito;
	private Money porcTasaJust;

	private List docuEnviados = new ArrayList();
	private boolean readDocuEnviados = true;

	private List empresas = new ArrayList();
	private boolean readEmpresas = true;

	private List audiencias = new ArrayList();
	private boolean readAudiencias = true;

	private List pagosJuicios = new ArrayList();
	private boolean readPagosJuicios = true;

	private List rubrosCondenas = new ArrayList();
	private boolean readRubrosCondenas = true;
	
	private List rubrosReclamos = new ArrayList();
	private boolean readRubrosReclamos = true;
	
	private List calculoInteres = new ArrayList();
	private boolean readCalculoInteres = true;	
	
	
	public TipoReclamoLeg getTipo_reclamo() throws BaseException {
		supportRefresh();
		return tipo_reclamo;
	}

	public TipoPericia getTipoPericia() throws BaseException {
		supportRefresh();
		return this.tipoPericia;
	}
	
	public Money getPorcIncapacidad() throws BaseException {
		supportRefresh();
		return this.porcIncapacidad;
	}	
	
	public String getCaratula() throws BaseException {
		supportRefresh();
		return this.caratula;
	}	

	public java.util.Date getFecNovedad() throws BaseException {
		supportRefresh();
		return this.fecNovedad;
	}

	public ResultadoJuicio getResultadoJuicio() throws BaseException {
		supportRefresh();
		return this.resultadoJuicio;
	}
	
	public CompaniaSeguro getCompaniaSeguroCaucion() throws BaseException {
		supportRefresh();
		return this.compSegCaucion;
	}	

	public Money getEstimado() throws BaseException {
		supportRefresh();
		return this.estimado;
	}
	
	public String getPrimeraInstancia() throws BaseException {
		supportRefresh();
		return this.primeraInstancia;
	}	
	
	public String getSegundaInstancia() throws BaseException {
		supportRefresh();
		return this.segundaInstancia;
	}	
	
	public void setSegundaInstancia(String aSegundaInstancia) throws BaseException {
		this.segundaInstancia = aSegundaInstancia;
	}
	
	public void setPrimeraInstancia(String aPrimeraInstancia) throws BaseException {
		this.primeraInstancia = aPrimeraInstancia;
	}	
	
	public Money getPorcLetrado() throws BaseException {
		
		supportRefresh();
		
		CalculadorMoney calc = new CalculadorMoney(new Money(0));
		if (this.montoAcuerdo!=null)
			calc.sumar(montoAcuerdo);
		if (this.montoIntereses!=null)
			calc.sumar(montoIntereses);
		
		if ((this.montoLetrado==null) || (calc.getResult(2)==0.0))
			return new Money(0);
				
		CalculadorMoney calcPorc = new CalculadorMoney(this.montoLetrado);
		calcPorc.multiplicarPor(new Money(100.0));
		calcPorc.dividirPor(calc.getResultMoney());
		
		return calcPorc.getResultMoney();
	}	
	
	public Money getPorcPerito() throws BaseException {
		
		supportRefresh();
		
		CalculadorMoney calc = new CalculadorMoney(new Money(0));
		if (this.montoAcuerdo!=null)
			calc.sumar(montoAcuerdo);
		if (this.montoIntereses!=null)
			calc.sumar(montoIntereses);
		
		if ((this.montoPerito==null) || (calc.getResult(2)==0.0))
			return new Money(0);
				
		CalculadorMoney calcPorc = new CalculadorMoney(this.montoPerito);
		calcPorc.multiplicarPor(new Money(100.0));
		calcPorc.dividirPor(calc.getResultMoney());
		
		return calcPorc.getResultMoney();
	}	
	
	public Money getPorcTasaJusticia() throws BaseException {
		
		supportRefresh();
		
		CalculadorMoney calc = new CalculadorMoney(new Money(0));
		if (this.montoAcuerdo!=null)
			calc.sumar(montoAcuerdo);
		if (this.montoIntereses!=null)
			calc.sumar(montoIntereses);
		
		if ((this.montoTasaJusticia==null) || (calc.getResult(2)==0.0))
			return new Money(0);
				
		CalculadorMoney calcPorc = new CalculadorMoney(this.montoTasaJusticia);
		calcPorc.multiplicarPor(new Money(100.0));
		calcPorc.dividirPor(calc.getResultMoney());
		
		return calcPorc.getResultMoney();
	}	

	public Money getMontoAcuerdo() throws BaseException {
		this.supportRefresh();
		return montoAcuerdo;
	}

	public void setMontoAcuerdo(Money aMontoAcuerdo) throws BaseException {
		this.montoAcuerdo = aMontoAcuerdo;
	}
	
	public void setPorcLetrado(Money aPorcLetrado) throws BaseException {
		this.porcLetrado = aPorcLetrado;
	}	
	
	public void setPorcPerito(Money aPorcPerito) throws BaseException {
		this.porcPerito = aPorcPerito;
	}	
	
	public void setPorcTasaJusticia(Money aPorcTasaJusticia) throws BaseException {
		this.porcTasaJust = aPorcTasaJusticia;
	}	
	
	public void setPorcIncapacidad(Money aPorcIncapacidad) throws BaseException {
		this.porcIncapacidad = aPorcIncapacidad;
	}	
	
	public void setCaratula(String aCaratula) throws BaseException {
		this.caratula = aCaratula;
	}	
	
	public void setCompaniaSeguroCaucion(CompaniaSeguro aCompaniaSeguroCaucion) throws BaseException {
		this.compSegCaucion = aCompaniaSeguroCaucion;
	}	

	public void setTipoPericia(TipoPericia aTipoPericia) throws BaseException {
		this.tipoPericia = aTipoPericia;
	}

	public Money getMontoConciliador() throws BaseException {
		this.supportRefresh();
		return this.montoConciliador;
	}

	public void setMontoConciliado(Money aMontoConciliado) throws BaseException {
		this.montoConciliador = aMontoConciliado;
	}

	public Money getMontoPerito() throws BaseException {
		this.supportRefresh();
		return this.montoPerito;
	}

	public void setMontoPerito(Money aMontoPerito) throws BaseException {
		this.montoPerito = aMontoPerito;
	}

	public Money getMontoTasaJusticia() throws BaseException {
		this.supportRefresh();
		return montoTasaJusticia;
	}

	public Money getMontoLetrado() throws BaseException {
		this.supportRefresh();
		return this.montoLetrado;
	}
	
	public Money getMontoIntereses() throws BaseException {
		this.supportRefresh();
		return this.montoIntereses;
	}	

	public Fuero getFuero() throws BaseException {
		this.supportRefresh();
		return this.fuero;
	}

	public void setFuero(Fuero aFuero) throws BaseException {
		this.fuero = aFuero;
	}

	public void setMontoTasaJusticia(Money aTasaJusticia) throws BaseException {
		this.montoTasaJusticia = aTasaJusticia;
	}

	public void setMontoLetrado(Money aMontoLetrado) throws BaseException {
		this.montoLetrado = aMontoLetrado;
	}
	
	public void setMontoIntereses(Money aMontoIntereses) throws BaseException {
		this.montoIntereses = aMontoIntereses;
	}	

	public void setTipo_reclamo(TipoReclamoLeg aTipo_reclamo) {
		this.tipo_reclamo = aTipo_reclamo;
	}

	public void setFecNovedad(java.util.Date aFecNovedad) {
		this.fecNovedad = aFecNovedad;
	}

	public void setCodigoInterno(String aCodigoInterno) {
		this.codigoInterno = aCodigoInterno;
	}

	public void setResultadoJuicio(ResultadoJuicio aResultadoJuicio) {
		this.resultadoJuicio = aResultadoJuicio;
	}

	public void setEstimado(Money aEstimado) {
		this.estimado = aEstimado;
	}

	public String getCBU() throws BaseException {
		supportRefresh();
		return cbu;
	}

	public String getCodigoInterno() throws BaseException {
		supportRefresh();
		return this.codigoInterno;
	}

	public void setCBU(String aCBU) {
		this.cbu = aCBU;
	}

	public Money getEmbargo() throws BaseException {
		supportRefresh();
		return embargo;
	}

	public void setEmbargo(Money aEmbargo) {
		this.embargo = aEmbargo;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return this.legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public java.util.Date getFec_rec_dem() throws BaseException {
		supportRefresh();
		return fec_rec_dem;
	}

	public void setFec_rec_dem(java.util.Date aFec_rec_dem) {
		this.fec_rec_dem = aFec_rec_dem;
	}

	public Juzgado getJuzgado() throws BaseException {
		supportRefresh();
		return juzgado;
	}

	public void setJuzgado(Juzgado aJuzgado) {
		this.juzgado = aJuzgado;
	}

	public String getNro_expediente() throws BaseException {
		supportRefresh();
		return nro_expediente;
	}

	public void setNro_expediente(String aNro_te) {
		this.nro_expediente = aNro_te;
	}

	public Money getMonto_reclamo() throws BaseException {
		supportRefresh();
		return monto_reclamo;
	}

	public void setMonto_reclamo(Money aMonto_reclamo) {
		this.monto_reclamo = aMonto_reclamo;
	}

	public String getProb_resultado() throws BaseException {
		supportRefresh();
		return prob_resultado;
	}

	public void setProb_resultado(String aProb_resultado) {
		this.prob_resultado = aProb_resultado;
	}

	public Money getPorc_prevision() throws BaseException {
		supportRefresh();

		// Calcular el Porcentaje
		if (this.getMonto_reclamo() == null)
			return new Money(0);

		if (this.getMonto_reclamo().doubleValue() == 0)
			return new Money(0);

		if (this.getEstimado() == null)
			return new Money(0);

		if (this.getEstimado().doubleValue() == 0)
			return new Money(0);

		CalculadorMoney calc = new CalculadorMoney(this.getEstimado());
		calc.dividirPor(this.getMonto_reclamo());
		calc.multiplicarPor(new Money(100));

		return new Money(calc.getResult(2));
	}

	public void setPorc_prevision(Money aPorc_prevision) {
		this.porc_prevision = aPorc_prevision;
	}

	public EstadoProcesal getEstado_procesal() throws BaseException {
		supportRefresh();
		return estado_procesal;
	}

	public void setEstado_procesal(EstadoProcesal aEstado_procesal) {
		this.estado_procesal = aEstado_procesal;
	}

	public EstadoJuicio getEstado_juicio() throws BaseException {
		supportRefresh();
		return estado_juicio;
	}

	public void setEstado_juicio(EstadoJuicio aEstado_juicio) {
		this.estado_juicio = aEstado_juicio;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public java.util.Date getFec_pago() throws BaseException {
		supportRefresh();
		return fec_pago;
	}

	public void setFec_pago(java.util.Date aFec_pago) {
		this.fec_pago = aFec_pago;
	}

	public String getObservaciones() throws BaseException {
		supportRefresh();
		return observaciones;
	}

	public void setObservaciones(String aObservaciones) {
		this.observaciones = aObservaciones;
	}

	public Periodo getPeriodo_mensual() throws BaseException {
		supportRefresh();
		return periodo_mensual;
	}

	public void setPeriodo_mensual(Periodo aPeriodo_mensual) {
		this.periodo_mensual = aPeriodo_mensual;
	}

	public Money getPrevision() throws BaseException {
		supportRefresh();
		return prevision;
	}

	public void setPrevision(Money aPrevision) {
		this.prevision = aPrevision;
	}

	public Abogado getAbogado() throws BaseException {
		supportRefresh();
		return abogado;
	}

	public void setAbogado(Abogado aAbogado) {
		this.abogado = aAbogado;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static Juicio findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Juicio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Juicio findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Juicio) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Juicio findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Juicio) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(estado_juicio, "Debe ingresar el estado juicio");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getJuicios(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBJuicio.getJuicios(aLegajo, aSesion);
	}

	public List getDocuEnviados() throws BaseException {
		if (this.readDocuEnviados) {
			List listaDocuEnviados = DocuEnvJuicio.getDocuEnvJuicio(this, getSesion());
			this.docuEnviados.addAll(listaDocuEnviados);
			this.readDocuEnviados = false;
		}
		return this.docuEnviados;
	}

	public List getAudiencias() throws BaseException {
		if (this.readAudiencias) {
			List listaAudiencias = AudienciaJuicio.getAudienciasJuicio(this, getSesion());
			this.audiencias.addAll(listaAudiencias);
			this.readAudiencias = false;
		}
		return this.audiencias;
	}

	public List getPagosJuicios() throws BaseException {
		if (this.readPagosJuicios) {
			List listaPagosJuicios = PagoJuicio.getPagosJuicio(this, getSesion());
			this.pagosJuicios.addAll(listaPagosJuicios);
			this.readPagosJuicios = false;
		}
		return this.pagosJuicios;
	}

	public List getRubrosCondenas() throws BaseException {
		if (this.readRubrosCondenas) {
			List listaRubrosCondenas = JuicioRubroCondena.getJuiciosRubroCondena(this, getSesion());
			this.rubrosCondenas.addAll(listaRubrosCondenas);
			this.readRubrosCondenas = false;
		}
		return this.rubrosCondenas;
	}
	
	public List getRubrosReclamos() throws BaseException { //nuevo
		if (this.readRubrosReclamos) {
			List listaRubrosReclamos = RubroCondenaJuicio.getRubrosCondenaJuicio(this, getSesion());
			this.rubrosReclamos.addAll(listaRubrosReclamos);
			this.readRubrosReclamos = false;
		}
		return this.rubrosReclamos;
	}	
	
	
	public List getCalcInteres() throws BaseException { //nuevo
		if (this.readCalculoInteres) {
			List listaCalcInteres = JuicioCalcInt.getCalcInteres(this, getSesion());
			this.calculoInteres.addAll(listaCalcInteres);
			this.readCalculoInteres = false;
		}
		return this.calculoInteres;
	}	
	
	public String getLeyendaRubroReclamo() throws BaseException {
		StringBuffer leyenda = new StringBuffer("");
		
		Iterator iterRubroCondenaJuicio = RubroCondenaJuicio.getRubrosCondenaJuicio(this, getSesion()).iterator();
		while (iterRubroCondenaJuicio.hasNext()) {
			RubroCondenaJuicio rubroCondenaJuicio = (RubroCondenaJuicio) iterRubroCondenaJuicio.next();
			leyenda.append(rubroCondenaJuicio.getRubro_condena().getDescripcion()+Util.ENTER());
		}
		
		return leyenda.toString();
	}

	public List getEmpresas() throws BaseException {
		if (this.readEmpresas) {
			List listaEmpresas = JuicioEmpresa.getJuiciosEmpresa(this, getSesion());
			this.empresas.addAll(listaEmpresas);
			this.readEmpresas = false;
		}
		return this.empresas;
	}

	public void addDocuEnviados(DocuEnvJuicio aDocuEnvJuicio) throws BaseException {
		aDocuEnvJuicio.setJuicio(this);
		this.docuEnviados.add(aDocuEnvJuicio);
	}

	public void addAudiencia(AudienciaJuicio aAudienciaJuicio) throws BaseException {
		aAudienciaJuicio.setJuicio(this);
		this.audiencias.add(aAudienciaJuicio);
	}

	public void addPagoJuicio(PagoJuicio aPagoJuicio) throws BaseException {
		aPagoJuicio.setJuicio(this);
		this.pagosJuicios.add(aPagoJuicio);
	}

	public void addRubroCondena(JuicioRubroCondena aJuicioRubroCondena) throws BaseException {
		aJuicioRubroCondena.setJuicio(this);
		this.rubrosCondenas.add(aJuicioRubroCondena);
	}
	
	public void addRubroReclamo(RubroCondenaJuicio aRubroCondenaJuicio) throws BaseException {
		aRubroCondenaJuicio.setJuicio(this);
		this.rubrosReclamos.add(aRubroCondenaJuicio);
	}	
	
	public void addCalcInteres(JuicioCalcInt aJuicioCalcInt) throws BaseException {
		aJuicioCalcInt.setJuicio(this);
		this.calculoInteres.add(aJuicioCalcInt);
	}	

	public void addEmpresa(JuicioEmpresa aJucioEmpresa) throws BaseException {
		aJucioEmpresa.setJuicio(this);
		this.empresas.add(aJucioEmpresa);
	}

	public void afterSave() throws BaseException {

		Iterator iterDocuEnv = this.docuEnviados.iterator();
		while (iterDocuEnv.hasNext()) {
			DocuEnvJuicio docuEnvJuicio = (DocuEnvJuicio) iterDocuEnv.next();
			docuEnvJuicio.save();
			docuEnvJuicio = null;
		}
		iterDocuEnv = null;

		Iterator iterEmpresas = this.empresas.iterator();
		while (iterEmpresas.hasNext()) {
			JuicioEmpresa juicioEmpresa = (JuicioEmpresa) iterEmpresas.next();
			juicioEmpresa.save();
			juicioEmpresa = null;
		}
		iterEmpresas = null;

		Iterator iterAudiencias = this.audiencias.iterator();
		while (iterAudiencias.hasNext()) {
			AudienciaJuicio audienciaJuicio = (AudienciaJuicio) iterAudiencias.next();
			audienciaJuicio.save();
			audienciaJuicio = null;
		}
		iterAudiencias = null;

		Iterator iterPagosJuicios = this.pagosJuicios.iterator();
		while (iterPagosJuicios.hasNext()) {
			PagoJuicio pagoJuicio = (PagoJuicio) iterPagosJuicios.next();
			pagoJuicio.save();
			pagoJuicio = null;
		}
		iterPagosJuicios = null;

		Iterator iterJuiciosRubrosCondena = this.rubrosCondenas.iterator();
		while (iterJuiciosRubrosCondena.hasNext()) {
			JuicioRubroCondena juicioRubroCondena = (JuicioRubroCondena) iterJuiciosRubrosCondena.next();
			juicioRubroCondena.save();
			juicioRubroCondena = null;
		}
		iterJuiciosRubrosCondena = null;
		
		Iterator iterRubroCondenaJuicios = this.rubrosReclamos.iterator();
		while (iterRubroCondenaJuicios.hasNext()) {
			RubroCondenaJuicio rubroCondenaJuicio = (RubroCondenaJuicio) iterRubroCondenaJuicios.next();
			rubroCondenaJuicio.save();
			rubroCondenaJuicio = null;
		}
		iterRubroCondenaJuicios = null;		
		
		Iterator iterCalcInteres = this.calculoInteres.iterator();
		while (iterCalcInteres.hasNext()) {
			JuicioCalcInt juicioCalcInt = (JuicioCalcInt) iterCalcInteres.next();
			juicioCalcInt.save();
			juicioCalcInt = null;
		}
		iterCalcInteres = null;		
		
		

	}

	public static List getJuicios(java.util.Date fecDesde, java.util.Date fecHasta, Money montoDesde, Money montoHasta, String codigoInterno, Boolean soloConAudienPend, Boolean soloConPrevFinan,
			Boolean soloConEmbargos, List juzgados, List estadosProcesales, List resulProbJuicio, List tiposReclamos, List abogados, List resulJuicios, List estadoJuicios, List legajos,
			List empresas, List sectores, List puestos, List estados, List fueros, ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		if (fecDesde != null)
			condiciones.put("FEC_DESDE", fecDesde);
		if (fecHasta != null)
			condiciones.put("FEC_HASTA", fecHasta);
		if (montoDesde != null)
			condiciones.put("MONTO_DESDE", montoDesde);
		if (montoHasta != null)
			condiciones.put("MONTO_HASTA", montoHasta);
		if (codigoInterno != null)
			condiciones.put("CODIGO_INTERNO", codigoInterno);
		if (soloConAudienPend != null)
			condiciones.put("SOLO_CON_AUDI_PEND", soloConAudienPend);
		if (soloConEmbargos != null)
			condiciones.put("SOLO_CON_EMBARGOS", soloConEmbargos);

		if (soloConPrevFinan != null)
			condiciones.put("SOLO_CON_PREV_FINAN", soloConPrevFinan);

		condiciones.put("JUZGADOS", juzgados);
		condiciones.put("ESTADOS_PROCESALES", estadosProcesales);
		condiciones.put("RESUL_PROB_JUICIO", resulProbJuicio);
		condiciones.put("TIPOS_RECLAMOS", tiposReclamos);
		condiciones.put("ABOGADOS", abogados);
		condiciones.put("RESUL_JUICIOS", resulJuicios);
		condiciones.put("ESTADO_JUICIOS", estadoJuicios);
		condiciones.put("LEGAJOS", legajos);
		condiciones.put("EMPRESAS", empresas);
		condiciones.put("SECTORES", sectores);
		condiciones.put("PUESTOS", puestos);
		condiciones.put("ESTADOS", estados);
		condiciones.put("FUEROS", fueros);

		return DBJuicio.getJuicios(condiciones, aSesion);

	}

	public String getStringRequeridos() throws BaseException {
		StringBuffer listaReq = new StringBuffer("");
		Iterator iterReq = this.getEmpresas().iterator();
		while (iterReq.hasNext()) {
			JuicioEmpresa juicioEmpresa = (JuicioEmpresa) iterReq.next();
			listaReq.append(juicioEmpresa.getEmpresaJuicio().getDescripcion());
			listaReq.append(Util.ENTER());
		}
		return listaReq.toString();
	}

	public String getLeyendasAudiencias(java.util.Date fecActual) throws BaseException {

		boolean envioAudAnt = false;

		StringBuffer listaAud = new StringBuffer("");
		Iterator iterAudi = this.getAudiencias().iterator();
		while (iterAudi.hasNext()) {
			AudienciaJuicio audiencia = (AudienciaJuicio) iterAudi.next();

			if ((audiencia.getFecha() != null) && (audiencia.getFecha().before(fecActual))) {

				if (envioAudAnt == false)
					listaAud.append(Util.ENTER() + "Hubo audiencias anteriores ... ");
				envioAudAnt = true;
				continue;
			}

			listaAud.append(audiencia.getLeyendaAudiencia() + Util.ENTER());
		}
		return listaAud.toString();
	}

	public Money getTotalAPagar() throws BaseException {
		CalculadorMoney totalAPagar = new CalculadorMoney(new Money(0));

		if (this.getMontoAcuerdo() != null)
			totalAPagar.sumar(this.getMontoAcuerdo());
		
		if (this.getMontoIntereses() != null)
			totalAPagar.sumar(this.getMontoIntereses());		

		if (this.getMontoConciliador() != null)
			totalAPagar.sumar(this.getMontoConciliador());

		if (this.getMontoLetrado() != null)
			totalAPagar.sumar(this.getMontoLetrado());

		if (this.getMontoPerito() != null)
			totalAPagar.sumar(this.getMontoPerito());

		if (this.getMontoTasaJusticia() != null)
			totalAPagar.sumar(this.getMontoTasaJusticia());

		return totalAPagar.getResultMoney();
	}

	public Money getTotalPagado() throws BaseException {
		CalculadorMoney totalPagado = new CalculadorMoney(new Money(0));

		Iterator iterPagosJuicios = this.getPagosJuicios().iterator();
		while (iterPagosJuicios.hasNext()) {
			PagoJuicio pagoJuicio = (PagoJuicio) iterPagosJuicios.next();
			if (pagoJuicio.getPago_acuerdo() != null)
				totalPagado.sumar(pagoJuicio.getPago_acuerdo());
			if (pagoJuicio.getPago_horario() != null)
				totalPagado.sumar(pagoJuicio.getPago_horario());
			if (pagoJuicio.getPago_perito() != null)
				totalPagado.sumar(pagoJuicio.getPago_perito());
			if (pagoJuicio.getPagoLetrado() != null)
				totalPagado.sumar(pagoJuicio.getPagoLetrado());
			if (pagoJuicio.getPago_tasa_just() != null)
				totalPagado.sumar(pagoJuicio.getPago_tasa_just());
		}

		return totalPagado.getResultMoney();
	}

	public String getLeyendasDocEnviada() throws BaseException {
		StringBuffer listaDocEnv = new StringBuffer("");
		Iterator iterDocuEnv = this.getDocuEnviados().iterator();
		while (iterDocuEnv.hasNext()) {
			DocuEnvJuicio docEnvJuicio = (DocuEnvJuicio) iterDocuEnv.next();
			listaDocEnv.append(docEnvJuicio.getLeyendaDocuEnv() + Util.ENTER());
		}
		return listaDocEnv.toString();
	}

	public String getLeyendasPagosRealizados() throws BaseException {
		StringBuffer listaPagReal = new StringBuffer("");
		Iterator iterPagosRealiz = this.getPagosJuicios().iterator();
		while (iterPagosRealiz.hasNext()) {
			PagoJuicio pagoJuicio = (PagoJuicio) iterPagosRealiz.next();
			listaPagReal.append(pagoJuicio.getLeyendaPago() + Util.ENTER());
		}
		return listaPagReal.toString();
	}

	public String getLeyendasRubrosCondena() throws BaseException {
		StringBuffer listaRubCond = new StringBuffer("");
		Iterator iterRubrosCondena = this.getRubrosCondenas().iterator();
		while (iterRubrosCondena.hasNext()) {
			JuicioRubroCondena rubro = (JuicioRubroCondena) iterRubrosCondena.next();
			listaRubCond.append(rubro.getRubro_condena().getDescripcion() + Util.ENTER());
		}
		return listaRubCond.toString();
	}

	public static double getTotalEmbargoEmpleado(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBJuicio.getTotalEmbargoEmpleado(aLegajo, aSesion);
	}
	
}
