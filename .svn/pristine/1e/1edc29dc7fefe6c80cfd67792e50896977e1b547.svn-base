package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class AlgoritmoCacheo extends ObjetoLogico {

	public static final String CON_FILTRO_LEGAJO = "SI";
	public static final String SIN_FILTRO_LEGAJO = "NO";

	public static final String CON_FILTRO_ESTADO = "SI";
	public static final String SIN_FILTRO_ESTADO = "NO";

	public static final String TIPO_PLANIF_TODOS = "TODOS";
	public static final String TIPO_PLANIF = "PLANIF";

	private List probabilidadesCacheo = new ArrayList();
	private boolean readProbabilidadesCacheo = true;

	private List clasifCacheo = new ArrayList();
	private boolean readClasifCacheo = true;

	private List estadosCacheo = new ArrayList();
	private boolean readEstadosCacheo = true;

	private List fechasExclusiones = new ArrayList();
	private boolean readFechasExclusiones = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		this.supportRefresh();
		return this.codigo;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		this.supportRefresh();
		return this.descripcion;
	}

	public AlgoritmoCacheo() {
	}

	public static String NICKNAME = "cip.AlgoritmoCacheo";

	private String filtro_legajo;
	private String tipo_planif;
	private Double porc_ent;
	private Boolean activo;
	private Double prob_cach_ent;
	private Double porc_sal;
	private Double prob_cach_sal;
	private String filtro_estados;
	private String codigo;
	private String descripcion;
	private boolean lunes;
	private boolean martes;
	private boolean miercoles;
	private boolean jueves;
	private boolean viernes;
	private boolean sabado;
	private boolean domingo;

	public String getFiltro_legajo() throws BaseException {
		supportRefresh();
		return filtro_legajo;
	}

	public void setFiltro_legajo(String aFiltro_legajo) {
		this.filtro_legajo = aFiltro_legajo;
	}

	public boolean isLunes() throws BaseException {
		supportRefresh();
		return this.lunes;
	}

	public void setLunes(boolean aLunes) {
		this.lunes = aLunes;
	}

	public boolean isMartes() throws BaseException {
		supportRefresh();
		return this.martes;
	}

	public void setMartes(boolean aMartes) {
		this.martes = aMartes;
	}

	public boolean isMiercoles() throws BaseException {
		supportRefresh();
		return this.miercoles;
	}

	public void setMiercoles(boolean aMiercoles) {
		this.miercoles = aMiercoles;
	}

	public boolean isJueves() throws BaseException {
		supportRefresh();
		return this.jueves;
	}

	public void setJueves(boolean aJueves) {
		this.jueves = aJueves;
	}

	public boolean isViernes() throws BaseException {
		supportRefresh();
		return this.viernes;
	}

	public void setViernes(boolean aViernes) {
		this.viernes = aViernes;
	}

	public boolean isSabado() throws BaseException {
		supportRefresh();
		return this.sabado;
	}

	public void setSabado(boolean aSabado) {
		this.sabado = aSabado;
	}

	public boolean isDomingo() throws BaseException {
		supportRefresh();
		return this.domingo;
	}

	public void setDomingo(boolean aDomingo) {
		this.domingo = aDomingo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getFiltro_estados() throws BaseException {
		supportRefresh();
		return filtro_estados;
	}

	public void setFiltro_estados(String aFiltro_estado) {
		this.filtro_estados = aFiltro_estado;
	}

	public String getTipo_planif() throws BaseException {
		supportRefresh();
		return tipo_planif;
	}

	public void setTipo_planif(String aTipo_planif) {
		this.tipo_planif = aTipo_planif;
	}

	public Double getPorc_ent() throws BaseException {
		supportRefresh();
		return porc_ent;
	}

	public void setPorc_ent(Double aPorc_ent) {
		this.porc_ent = aPorc_ent;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Double getProb_cach_ent() throws BaseException {
		supportRefresh();
		return prob_cach_ent;
	}

	public void setProb_cach_ent(Double aProb_cach_ent) {
		this.prob_cach_ent = aProb_cach_ent;
	}

	public Double getPorc_sal() throws BaseException {
		supportRefresh();
		return porc_sal;
	}

	public void setPorc_sal(Double aPorc_sal) {
		this.porc_sal = aPorc_sal;
	}

	public Double getProb_cach_sal() throws BaseException {
		supportRefresh();
		return prob_cach_sal;
	}

	public void setProb_cach_sal(Double aProb_cach_sal) {
		this.prob_cach_sal = aProb_cach_sal;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AlgoritmoCacheo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AlgoritmoCacheo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AlgoritmoCacheo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AlgoritmoCacheo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static AlgoritmoCacheo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AlgoritmoCacheo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(filtro_legajo, "Debe ingresar el Filtro del Legajo");
		Validar.noNulo(tipo_planif, "Debe ingresar el Tipo de Planificación");
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public List getProbabilidadesCacheos() throws BaseException {
		if (this.readProbabilidadesCacheo) {
			List listaProbCacheos = ProbabilidadCacheo.getProbabilidadesCacheos(this, getSesion());
			this.probabilidadesCacheo.addAll(listaProbCacheos);
			this.readProbabilidadesCacheo = false;
		}
		return probabilidadesCacheo;
	}

	public List getEstadosCacheos() throws BaseException {
		if (this.readEstadosCacheo) {
			List listaEstadosCacheo = AlgoCacheoEstado.getAlgoCacheoEstados(this, getSesion());
			this.estadosCacheo.addAll(listaEstadosCacheo);
			this.readEstadosCacheo = false;
		}
		return estadosCacheo;
	}

	public List getFechasExclusiones() throws BaseException {
		if (this.readFechasExclusiones) {
			List listaFechasExclusiones = FechaExclusionCacheo.getFechasExclusionCacheo(this, getSesion());
			this.fechasExclusiones.addAll(listaFechasExclusiones);
			this.readFechasExclusiones = false;
		}
		return fechasExclusiones;
	}

	public List getClasifCacheos() throws BaseException {
		if (this.readClasifCacheo) {
			List listaClasifCacheos = AlgoCacheoClasif.getAlgoCacheoClasif(this, getSesion());
			this.clasifCacheo.addAll(listaClasifCacheos);
			this.readClasifCacheo = false;
		}
		return clasifCacheo;
	}

	public void addProbabilidadCacheo(ProbabilidadCacheo probabilidadCacheo) throws BaseException {
		probabilidadCacheo.setAlgoritmo_cacheo(this);
		this.probabilidadesCacheo.add(probabilidadCacheo);
	}

	public void addFechaExclusion(FechaExclusionCacheo aFechaExclusionCacheo) throws BaseException {
		aFechaExclusionCacheo.setAlgoritmo(this);
		this.fechasExclusiones.add(aFechaExclusionCacheo);
	}

	public void addClasifCacheo(AlgoCacheoClasif algoCacheoClasif) throws BaseException {
		algoCacheoClasif.setAlgoritmo_cacheo(this);
		this.clasifCacheo.add(algoCacheoClasif);
	}

	public void addEstadoCacheo(AlgoCacheoEstado algoCacheoEstado) throws BaseException {
		algoCacheoEstado.setAlgoritmo_cacheo(this);
		this.estadosCacheo.add(algoCacheoEstado);
	}

	public void afterSave() throws BaseException {

		Iterator iterProbCacheo = this.probabilidadesCacheo.iterator();
		while (iterProbCacheo.hasNext()) {
			ProbabilidadCacheo probCacheo = (ProbabilidadCacheo) iterProbCacheo.next();
			probCacheo.save();
			probCacheo = null;
		}
		iterProbCacheo = null;

		Iterator iterClasifCacheo = this.clasifCacheo.iterator();
		while (iterClasifCacheo.hasNext()) {
			AlgoCacheoClasif algoritmoClasifCacheo = (AlgoCacheoClasif) iterClasifCacheo.next();
			algoritmoClasifCacheo.save();
			algoritmoClasifCacheo = null;
		}
		iterClasifCacheo = null;

		Iterator iterEstadosCacheo = this.estadosCacheo.iterator();
		while (iterEstadosCacheo.hasNext()) {
			AlgoCacheoEstado algoCacheoEstado = (AlgoCacheoEstado) iterEstadosCacheo.next();
			algoCacheoEstado.save();
			algoCacheoEstado = null;
		}
		iterEstadosCacheo = null;

		Iterator iterFechasExclusiones = this.fechasExclusiones.iterator();
		while (iterFechasExclusiones.hasNext()) {
			FechaExclusionCacheo fechaExclusionCacheo = (FechaExclusionCacheo) iterFechasExclusiones.next();
			fechaExclusionCacheo.save();
			fechaExclusionCacheo = null;
		}
		iterFechasExclusiones = null;

	}

	public static AlgoritmoCacheo getAlgoritmoCacheo(ISesion aSesion) throws BaseException {
		Integer oidAlgoCacheo = ValorParametro.findByCodigoParametro("ALGORITMO_CACHEO", aSesion).getOidObjNeg();
		AlgoritmoCacheo algoCacheo = AlgoritmoCacheo.findByOid(oidAlgoCacheo, aSesion);
		return algoCacheo;
	}

	public void planificar(java.util.Date fecDesde, java.util.Date fecHasta, String tipo) throws BaseException {

		// Grabar la cabecera del proceso de planificación
		ProcPlanifCacheo procPlanifCacheo = (ProcPlanifCacheo) ProcPlanifCacheo.getNew(ProcPlanifCacheo.NICKNAME, this.getSesion());
		procPlanifCacheo.setFec_proceso(UtilCIP.getFechaHoraActual(this.getSesion()));
		procPlanifCacheo.setTipo(tipo);
		procPlanifCacheo.setUsuario(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()));
		procPlanifCacheo.setFec_desde(fecDesde);
		procPlanifCacheo.setFec_hasta(fecHasta);
		procPlanifCacheo.setActivo(true);
		procPlanifCacheo.save();

		java.util.Date fecPlanif = fecDesde;
		fecHasta = Fecha.getFechaDiaPosterior(fecHasta);
		while (fecPlanif.before(fecHasta)) {
			if (tipo.equals("PLANIF"))
				planificar(procPlanifCacheo, fecPlanif);
			else if (tipo.equals("ANU"))
				anularPlanificacion(procPlanifCacheo, fecPlanif);
			fecPlanif = Fecha.getFechaDiaPosterior(fecPlanif);
		}
	}

	private boolean planificar(ProcPlanifCacheo procPlanifCacheo, java.util.Date fecha) throws BaseException {

		// Verificar si ya se planifico para la fecha
		FechaPlanifCacheo fechaPlanifCacheo = FechaPlanifCacheo.getFechaPlanifCacheo(Fecha.getFechaTruncada(fecha), this.getSesion());
		if (fechaPlanifCacheo != null)
			anularPlanificacion(procPlanifCacheo, fecha);

		// Verificar si se debe planificar cacheo para la fecha indicada
		if (isDiaHabParaCacheo(fecha) == false)
			return false;

		if (this.getTipo_planif().equals(TIPO_PLANIF)) {
			return planificarPorRotas(procPlanifCacheo, fecha);
		}

		return true;
	}

	private boolean planificarPorRotas(ProcPlanifCacheo procPlanifCacheo, java.util.Date fecha) throws BaseException {

		
		List listaClasif = Legajo.getClasificadoresEntidadActivos(this.getSesion());
		
		// Agregar la fecha de Planificacion
		FechaPlanifCacheo fechaPlanifCacheo = (FechaPlanifCacheo) FechaPlanifCacheo.getNew(FechaPlanifCacheo.NICKNAME, this.getSesion());
		fechaPlanifCacheo.setFecha(fecha);
		fechaPlanifCacheo.setProceso(procPlanifCacheo);
		fechaPlanifCacheo.setActivo(true);
		fechaPlanifCacheo.save();

		// Fecha Exclusion
		FechaExclusionCacheo fechaExclusion = FechaExclusionCacheo.getFechaExclusionCacheo(this, Fecha.getFechaTruncada(fecha), this
				.getSesion());
		if (fechaExclusion != null)
			return false;

		// Obtener Informacion a nivel Rota

		HashTableDatos planifLegCacheoEnt = new HashTableDatos();
		HashTableDatos planifLegCacheoSal = new HashTableDatos();

		HashTableDatos cantTotLegCacheoPorRotasEnt = new HashTableDatos();
		HashTableDatos cantTotLegCacheoPorRotasSal = new HashTableDatos();
		HashTableDatos probCacheosEntrada = new HashTableDatos();
		HashTableDatos probCacheosSalida = new HashTableDatos();
		HashTableDatos cantMaxCacheosPorRota = new HashTableDatos();

		Iterator iterRotas = Rota.getAllRotas(this.getSesion()).iterator();
		while (iterRotas.hasNext()) {
			Rota rota = (Rota) iterRotas.next();

			int cantLegPorRotaFec = LegajoRotaFecha.getCantLegPorFecha(rota, fecha, this.getSesion());
			ProbabilidadCacheo probCacheo = this.getProbabilidadCacheo(rota);
			if ((probCacheo != null) && (cantLegPorRotaFec != 0)) {

				// Calcular cantidad de Legajos a la entrada
				CalculadorMoney calcCachEnt = new CalculadorMoney(new Money(0));
				calcCachEnt.sumar(new Money(probCacheo.getPorc_ent()));
				calcCachEnt.dividirPor(new Money(100));
				calcCachEnt.multiplicarPor(new Money(cantLegPorRotaFec));
				long cantEnt = new Double(Math.ceil(calcCachEnt.getResult())).intValue();

				// Calcular cantidad de Legajos a la salida
				CalculadorMoney calcCachSal = new CalculadorMoney(new Money(0));
				calcCachSal.sumar(new Money(probCacheo.getPorc_sal()));
				calcCachSal.dividirPor(new Money(100));
				calcCachSal.multiplicarPor(new Money(cantLegPorRotaFec));
				long cantSal = new Double(Math.ceil(calcCachSal.getResult())).intValue();

				cantTotLegCacheoPorRotasEnt.put(rota.getOIDInteger(), new Double(cantEnt));
				cantTotLegCacheoPorRotasSal.put(rota.getOIDInteger(), new Double(cantSal));
				probCacheosEntrada.put(rota.getOIDInteger(), probCacheo.getProb_cacheo_ent());
				probCacheosSalida.put(rota.getOIDInteger(), probCacheo.getProb_cacheo_sal());

			} else {
				cantTotLegCacheoPorRotasEnt.put(rota.getOIDInteger(), new Double(0));
				cantTotLegCacheoPorRotasSal.put(rota.getOIDInteger(), new Double(0));
				probCacheosEntrada.put(rota.getOIDInteger(), new Double(0));
				probCacheosSalida.put(rota.getOIDInteger(), new Double(0));
			}

			cantMaxCacheosPorRota.put(rota.getOIDInteger(), new Double(ContadorCacheoLeg.getMaximoCacheosLegPorRota(fecha, rota, this
					.getSesion())));
		}

		// Obtener las cantidades de Cacheos por Legajo
		HashTableDatos cacheosPorLeg = new HashTableDatos();
		Iterator iterCacheosLeg = ContadorCacheoLeg.getAllCacheosLeg(this.getSesion()).iterator();
		while (iterCacheosLeg.hasNext()) {
			ContadorCacheoLeg contadorCacheoLeg = (ContadorCacheoLeg) iterCacheosLeg.next();
			cacheosPorLeg.put(contadorCacheoLeg.getLegajo().getOIDInteger(), contadorCacheoLeg);
		}

		// Filtrar por Legajo
		boolean conFiltroLeg = this.getFiltro_legajo().equals(AlgoritmoCacheo.CON_FILTRO_LEGAJO);
		boolean filtroPorEstados = this.getFiltro_estados().equals(AlgoritmoCacheo.CON_FILTRO_ESTADO);

		List listaClasifAInc = this.getAlgoCacheoClasifIncluidos();
		List listaClasifAExc = this.getAlgoCacheoClasifExcluidos();
		List listaEstadosAlgoCacheo = this.getEstadosAlgoCacheo();

		// Recorrido por Fechas
		HashTableDatos legPorRota = new HashTableDatos();
		Iterator iterLegRotFec = LegajoRotaFecha.getLegajosFechaRotas(fecha, this.getSesion()).iterator();
		while (iterLegRotFec.hasNext()) {
			LegajoRotaFecha legRotFec = (LegajoRotaFecha) iterLegRotFec.next();
			
			boolean tomtarOtroLegajo = false;
			
			if (!legRotFec.getLegajo().isCircuitoCacheo()) {
				
				if ((legRotFec.getLegajo().getEstadoCIP()==null) || 
				   ((legRotFec.getLegajo().getEstadoCIP()!=null) && 
			        (legRotFec.getLegajo().getEstadoCIP().isSusceptibleCacheo()==false) )) {
					
					tomtarOtroLegajo = true;
					
					// Buscar haber si hay algun clasificador que lo habilite
					Iterator iterClasifLeg = listaClasif.iterator();
					while (iterClasifLeg.hasNext()) {
						ClasificadorEntidad clasifEnti = (ClasificadorEntidad) iterClasifLeg.next();
						ValorClasificadorEntidad valorClasifEnt = legRotFec.getLegajo().getValorClasifEnt(clasifEnti);
						if (valorClasifEnt!=null) {
							AccesoValClasif accesoValClasif = AccesoValClasif.getAccesoValClasif(valorClasifEnt, this.getSesion());
							if (accesoValClasif!=null) {
								if (accesoValClasif.isCacheo()) {
									tomtarOtroLegajo = false;
								}
							}
						}
					}
					
				}
			}
			
			//** Toma otro legajo porque no es susceptible de ir a cacheo porque no tienen ninguna marca **/
			
			if (tomtarOtroLegajo) continue;
			

			// Buscar todos los incluidos (Si hay alguno incluirlo)
			if (conFiltroLeg && (listaClasifAInc.size() > 0)) {
				boolean cumplioCondicion = false;
				Iterator iterClasifAInc = listaClasifAInc.iterator();
				while (iterClasifAInc.hasNext()) {
					AlgoCacheoClasif algoCacheoClasif = (AlgoCacheoClasif) iterClasifAInc.next();
					if (legRotFec.getLegajo().isProxy())
						legRotFec.getLegajo().supportRefresh();
					ValorClasificadorEntidad valClasifEnt = legRotFec.getLegajo().getValorClasifEnt(algoCacheoClasif.getClasificador());
					if ((valClasifEnt != null) && (valClasifEnt.getOID() == algoCacheoClasif.getValor_clasif().getOID())) {
						cumplioCondicion = true;
						break;
					}
				}
				if (!cumplioCondicion)
					continue;
			}

			// Buscar todos los excluidos (Si hay alguno excluirlo)
			if (conFiltroLeg && (listaClasifAExc.size() > 0)) {
				boolean cumplioCondicion = true;
				Iterator iterClasifAExc = listaClasifAExc.iterator();
				while (iterClasifAExc.hasNext()) {
					AlgoCacheoClasif algoCacheoClasif = (AlgoCacheoClasif) iterClasifAExc.next();
					if (legRotFec.getLegajo().isProxy())
						legRotFec.getLegajo().supportRefresh();
					ValorClasificadorEntidad valClasifEnt = legRotFec.getLegajo().getValorClasifEnt(algoCacheoClasif.getClasificador());
					if ((valClasifEnt != null) && (valClasifEnt.getOID() == algoCacheoClasif.getValor_clasif().getOID())) {
						cumplioCondicion = false;
						break;
					}
				}
				if (!cumplioCondicion)
					continue;
			}

			// Todos los estados
			if ((filtroPorEstados) && (listaEstadosAlgoCacheo.size() > 0)) {
				boolean cumplioCondicion = false;
				Iterator iterEstadosCacheo = listaEstadosAlgoCacheo.iterator();
				while (iterEstadosCacheo.hasNext()) {
					AlgoCacheoEstado algoCacheoEstado = (AlgoCacheoEstado) iterEstadosCacheo.next();
					if (legRotFec.getLegajo().getEstadoCIP().getOID() == algoCacheoEstado.getEstado().getOID()) {
						cumplioCondicion = true;
						break;
					}
				}
				if (!cumplioCondicion)
					continue;
			}

			List listaLegajos = (List) legPorRota.get(legRotFec.getRota().getOIDInteger());
			if (listaLegajos == null) {
				listaLegajos = new ArrayList();
				legPorRota.put(legRotFec.getRota().getOIDInteger(), listaLegajos);
			}

			// Segun la probabilidad de ocurrencia que tenga que lo cargue de 1
			// a 10 veces
			Double maxCantCachRot = (Double) cantMaxCacheosPorRota.get(legRotFec.getRota().getOIDInteger());
			if ((maxCantCachRot == null) || (maxCantCachRot.intValue() == 0))
				maxCantCachRot = 1.0;

			ContadorCacheoLeg contCacheoLeg = (ContadorCacheoLeg) cacheosPorLeg.get(legRotFec.getLegajo().getOIDInteger());
			Double maxCantCecheoLeg = 1.0;
			if ((contCacheoLeg != null) && (contCacheoLeg.getCantidad().intValue() > 0))
				maxCantCecheoLeg = new Double(contCacheoLeg.getCantidad());

			int probCacheoLeg = (int) ((1.0 - (maxCantCecheoLeg / maxCantCachRot)) * 10.0);
			for (int j = 1; j <= probCacheoLeg; ++j)
				listaLegajos.add(legRotFec.getLegajo());
			listaLegajos.add(legRotFec.getLegajo());

		}

		// Recorrer las rotas por cada una segun probabilidad de ocurrencia
		// determinar si realizar algoritmo
		iterRotas = Rota.getAllRotas(this.getSesion()).iterator();
		while (iterRotas.hasNext()) {
			Rota rota = (Rota) iterRotas.next();

			// Determinar probabilidad de cacheo a la entrada
			Double probEntCacheo = (Double) probCacheosEntrada.get(rota.getOIDInteger());
			if (probEntCacheo == null)
				probEntCacheo = new Double(0.0);

			if (isProbabilidadOK(probEntCacheo)) {
				// Determinar cantidad de Legajos a chequear
				Double cantLegACachear = ((Double) cantTotLegCacheoPorRotasEnt.get(rota.getOIDInteger()));
				if (cantLegACachear == null)
					cantLegACachear = new Double(0);
				// Obtener la Lista de Legajos para esa rota
				List listaLegajos = (List) legPorRota.get(rota.getOIDInteger());
				if (listaLegajos != null) {
					for (int k = 1; k <= (int) cantLegACachear.doubleValue(); ++k) {
						boolean intentarDeNuevo = true;
						int cantIntentos = 0;
						while (intentarDeNuevo) {
							++cantIntentos;
							int nroAleatorio = getNroAleatorioDe0aX(listaLegajos.size());
							Legajo legajo = (Legajo) listaLegajos.get(nroAleatorio);
							if (planifLegCacheoEnt.get(legajo.getOIDInteger()) == null) {
								planifLegCacheoEnt.put(legajo.getOIDInteger(), legajo);
								intentarDeNuevo = false;
							} else {
								if (cantIntentos > 500)
									intentarDeNuevo = false;
							}
						}
						// Salir del ciclo While intentar de nuevo
					}
				}

			}

			// Determinar probabilidad de cacheo a la salida
			Double probSalCacheo = (Double) probCacheosSalida.get(rota.getOIDInteger());
			if (probSalCacheo == null)
				probSalCacheo = new Double(0.0);

			if (isProbabilidadOK(probSalCacheo)) {
				// Determinar cantidad de Legajos a chequear
				Double cantLegACachear = ((Double) cantTotLegCacheoPorRotasSal.get(rota.getOIDInteger()));
				if (cantLegACachear == null)
					cantLegACachear = new Double(0);
				// Obtener la Lista de Legajos para esa rota
				List listaLegajos = (List) legPorRota.get(rota.getOIDInteger());
				if (listaLegajos != null) {
					for (int k = 1; k <= (int) cantLegACachear.doubleValue(); ++k) {
						boolean intentarDeNuevo = true;
						int cantIntentos = 0;
						while (intentarDeNuevo) {
							++cantIntentos;
							int nroAleatorio = getNroAleatorioDe0aX(listaLegajos.size());
							Legajo legajo = (Legajo) listaLegajos.get(nroAleatorio);
							if (planifLegCacheoSal.get(legajo.getOIDInteger()) == null) {
								planifLegCacheoSal.put(legajo.getOIDInteger(), legajo);
								intentarDeNuevo = false;
							} else {
								if (cantIntentos > 500)
									intentarDeNuevo = false;
							}
						}
						// Salir del ciclo While intentar de nuevo
					}
				}

			}

		}

		// Grabar los cacheos planificados de entrada y salida
		PlanifDiaCacheo planifDiaCacheo = PlanifDiaCacheo.getPlanifDiaCacheo(this.getSesion());
		if (planifDiaCacheo == null)
			return false;

		GrupoPuerta grupoPuertaEntrada = GrupoPuerta.getGrupoPuertaEntAlgoCacheo(this.getSesion());
		GrupoPuerta grupoPuertaSalida = GrupoPuerta.getGrupoPuertaSalAlgoCacheo(this.getSesion());

		if (grupoPuertaEntrada != null) {
			Iterator iterLegPlanifCachEnt = planifLegCacheoEnt.values().iterator();
			while (iterLegPlanifCachEnt.hasNext()) {
				Legajo legajo = (Legajo) iterLegPlanifCachEnt.next();
				Cacheo cacheo = (Cacheo) Cacheo.getNew(Cacheo.NICKNAME, this.getSesion());
				cacheo.setLegajo(legajo);
				cacheo.setFec_planif_cacheo(fecha);
				cacheo.setFec_cacheo(null);
				cacheo.setRealizado(false);
				cacheo.setActivo(true);
				cacheo.setUsuario_cacheo(null);
				cacheo.setHora_cacheo(null);
				cacheo.setFec_levantado(null);
				cacheo.setLevantado(false);
				cacheo.setNo_realizado(true);
				cacheo.setObs_cacheo(null);
				cacheo.setHora_levantado(null);
				cacheo.setEnt_o_sal("E");
				cacheo.setEst_res_cacheo(null);
				cacheo.setUsuario_levanto(null);
				cacheo.setCacheoPersona(null);
				cacheo.setGrupoPuerta(grupoPuertaEntrada);
				cacheo.setIntentoDePase(false);
				cacheo.setFechaPlanifacheo(fechaPlanifCacheo);
				cacheo.save();
			}
		}

		if (grupoPuertaSalida != null) {
			Iterator iterLegPlanifCachSal = planifLegCacheoSal.values().iterator();
			while (iterLegPlanifCachSal.hasNext()) {
				Legajo legajo = (Legajo) iterLegPlanifCachSal.next();
				Cacheo cacheo = (Cacheo) Cacheo.getNew(Cacheo.NICKNAME, this.getSesion());
				cacheo.setLegajo(legajo);
				cacheo.setFec_planif_cacheo(fecha);
				cacheo.setFec_cacheo(null);
				cacheo.setRealizado(false);
				cacheo.setActivo(true);
				cacheo.setUsuario_cacheo(null);
				cacheo.setHora_cacheo(null);
				cacheo.setFec_levantado(null);
				cacheo.setLevantado(false);
				cacheo.setNo_realizado(true);
				cacheo.setObs_cacheo(null);
				cacheo.setHora_levantado(null);
				cacheo.setEnt_o_sal("S");
				cacheo.setEst_res_cacheo(null);
				cacheo.setUsuario_levanto(null);
				cacheo.setCacheoPersona(null);
				cacheo.setGrupoPuerta(grupoPuertaSalida);
				cacheo.setIntentoDePase(false);
				cacheo.setFechaPlanifacheo(fechaPlanifCacheo);
				cacheo.save();
			}
		}

		return true;
	}

	private void anularPlanificacion(ProcPlanifCacheo procPlanifCacheo, java.util.Date fecha) throws BaseException {
		FechaPlanifCacheo fecPlanifCacheo = FechaPlanifCacheo.getFechaPlanifCacheo(fecha, this.getSesion());
		if (fecPlanifCacheo == null)
			return;
		fecPlanifCacheo.setActivo(false);
		fecPlanifCacheo.save();

		Iterator iterCacheos = Cacheo.getCacheos(fecha, fecha, this.getSesion()).iterator();
		while (iterCacheos.hasNext()) {
			Cacheo cacheo = (Cacheo) iterCacheos.next();
			if ((cacheo.isActivo()) && (!cacheo.isRealizado())) {
				cacheo.setActivo(false);
				cacheo.save();
			}
		}

	}

	private int getNroAleatorioDe0aX(int X) throws BaseException {
		double nroAleatorio = Math.random();
		int nroAleaEntero = (int) Math.floor(nroAleatorio * X);
		return nroAleaEntero;
	}

	private boolean isProbabilidadOK(double probabilidad) throws BaseException {
		// Obtener un mail de 1 a 1000
		int rango = (int) Math.ceil(10000.0 * (probabilidad / 100.0));
		int nroAlea1000 = (int) Math.ceil(Math.random() * 10000.0);
		int ptoDerecho = nroAlea1000 + rango;
		int ptoIzquierdo = nroAlea1000;
		if (ptoDerecho > 10000) {
			ptoIzquierdo = nroAlea1000 - (ptoDerecho - 10000) + 1;
			ptoDerecho = 10000;
		}
		if (probabilidad == 0) {
			ptoIzquierdo = 0;
			ptoDerecho = 0;
		}
		int nroSelNro = (int) Math.ceil(Math.random() * 10000.0);
		if ((nroSelNro >= ptoIzquierdo) && (nroSelNro <= ptoDerecho))
			return true;
		else
			return false;
	}

	private boolean isDiaHabParaCacheo(java.util.Date fecha) throws BaseException {
		if (Fecha.getDiaSemana(fecha) == 1)
			return this.isDomingo();
		else if (Fecha.getDiaSemana(fecha) == 2)
			return this.isLunes();
		else if (Fecha.getDiaSemana(fecha) == 3)
			return this.isMartes();
		else if (Fecha.getDiaSemana(fecha) == 4)
			return this.isMiercoles();
		else if (Fecha.getDiaSemana(fecha) == 5)
			return this.isJueves();
		else if (Fecha.getDiaSemana(fecha) == 6)
			return this.isViernes();
		else if (Fecha.getDiaSemana(fecha) == 7)
			return this.isSabado();
		return false;
	}

	public List getAlgoCacheoClasifIncluidos() throws BaseException {
		return AlgoCacheoClasif.getAlgoCacheoClasifIncluidos(this, this.getSesion());
	}

	public List getAlgoCacheoClasifExcluidos() throws BaseException {
		return AlgoCacheoClasif.getAlgoCacheoClasifExcluidos(this, this.getSesion());
	}

	public List getEstadosAlgoCacheo() throws BaseException {
		return AlgoCacheoEstado.getAlgoCacheoEstados(this, this.getSesion());
	}

	public ProbabilidadCacheo getProbabilidadCacheo(Rota rota) throws BaseException {
		return ProbabilidadCacheo.getProbabilidadCacheo(this, rota, this.getSesion());
	}

	public FechaExclusionCacheo getFechaExclusionCacheo(java.util.Date fecha) throws BaseException {
		return FechaExclusionCacheo.getFechaExclusionCacheo(this, fecha, this.getSesion());
	}

}
