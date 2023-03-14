package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.da.DBVisita;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.sueldos.da.DBLegajo;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Visita extends ObjetoLogico {

	private Hashtable listaOidValClasif = new Hashtable();

	private List documentacion = new ArrayList();
	private boolean readDocumentacion = true;
	
	private List tarjetas = new ArrayList();
	private boolean readTarjetas = true;
	
	private List rotas = new ArrayList();
	private boolean readRotas = true;
	
	private List motEntInter = new ArrayList();
	private boolean readMotEntInter = true;
	
	public static final int PRIO_MOT_HAB_VIS = 100;
	public static final String HAB_PERMI = "HAB_PERM";
	

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getApeyNom();
	}

	public Visita() {
	}

	private String mensNoPuedeIngresar;
	
	public String getMensNoPuedeIngresar() {
		return mensNoPuedeIngresar;
	}

	public void setMensNoPuedeIngresar(String mensNoPuedeIngresar) {
		this.mensNoPuedeIngresar = mensNoPuedeIngresar;
	}

	public static String NICKNAME = "cip.Visita";

	private String ape_y_nom;
	private Boolean activo;
	private java.util.Date fecIngreso;
	private java.util.Date fecRetiro;
	private TipoDocumento tipoDocumento;
	private String nroDocumento;
	private GrupoPuerta grupoPuertaIngreso;
	private GrupoPuerta grupoPuertaEgreso;
	private EmpresaCIP empresa;
	private ZonaCIP zonaActual;
	private Legajo visitaA;
	private Legajo autoriza;
	private java.util.Date fecHorUltMov;
	private String sentido;
	private boolean controlAntiPassBack;
	private boolean ignorarProxAntiPassBack;
	private PermisoSemanalCIP permisoSemanal;
	private GrupoVisita grupoVisita;
	private boolean aplicVigencia;
	private java.util.Date fecVigDesde;
	private java.util.Date fecVigHasta;
	private CategAccesoCIP categAcceso;
	private MotivoVisita motivo;
	private boolean libAccesoAlPredio; 

	public TipoDocumento getTipoDocumento() throws BaseException {
		supportRefresh();
		return this.tipoDocumento;
	}
	
	public boolean isLibAccesoAlPredio() throws BaseException {
		supportRefresh();
		return this.libAccesoAlPredio;
	}
	
	
	public MotivoVisita getMotivoVisita() throws BaseException {
		supportRefresh();
		return this.motivo;
	}
	
	
	public CategAccesoCIP getCategoriaAcceso() throws BaseException {
		supportRefresh();
		return this.categAcceso;
	}
	
	
	public java.util.Date getFecVigenciaDesde() throws BaseException {
		supportRefresh();
		return this.fecVigDesde;
	}
	
	public java.util.Date getFecVigenciaHasta() throws BaseException {
		supportRefresh();
		return this.fecVigHasta;
	}
	
	public boolean isAplicVigencia() throws BaseException {
		supportRefresh();
		return this.aplicVigencia;
	}
	
	
	public GrupoVisita getGrupoVisita() throws BaseException {
		supportRefresh();
		return this.grupoVisita;
	}
	
	
	public PermisoSemanalCIP getPermisoSemanal() throws BaseException {
		supportRefresh();
		return this.permisoSemanal;
	}
	
	
	public boolean isIgnorarProxAntiPassBack() throws BaseException {
		supportRefresh();
		return this.ignorarProxAntiPassBack;
	}
	
	
	public boolean isControlAntiPassBack() throws BaseException {
		supportRefresh();
		return this.controlAntiPassBack;
	}
	
	
	public String getSentido() throws BaseException {
		supportRefresh();
		return this.sentido;
	}
	
	
	public java.util.Date getFecHorUltMov() throws BaseException {
		supportRefresh();
		return this.fecHorUltMov;
	}

	
	public Legajo getVisitaA() throws BaseException {
		supportRefresh();
		return this.visitaA;
	}
	

	public void setVisitaA(Legajo aVisitaA) {
		this.visitaA = aVisitaA;
	}
	
	public void setLibAccesoAlPredio(boolean aLibAccesoAlPredio) {
		this.libAccesoAlPredio = aLibAccesoAlPredio;
	}
	
	
	public void setMotivoVisita(MotivoVisita aMotivoVisita) {
		this.motivo = aMotivoVisita;
	}
	
	
	public void setCategAcceso(CategAccesoCIP aCategAccesoCIP) {
		this.categAcceso = aCategAccesoCIP;
	}
	
	
	public void setAplicVigencia(boolean aAplicVigencia) {
		this.aplicVigencia = aAplicVigencia;
	}
	
	public void setFecVigenciaDesde(java.util.Date aFecVigenciaDesde) {
		this.fecVigDesde = aFecVigenciaDesde;
	}
	
	public void setFecVigenciaHasta(java.util.Date aFecVigenciaHasta) {
		this.fecVigHasta = aFecVigenciaHasta;
	}
	
	
	public void setGrupoVisita(GrupoVisita aGrupoVisita) {
		this.grupoVisita = aGrupoVisita;
	}
	
	
	public void setPermisoSemanal(PermisoSemanalCIP aPermisoSemanal) {
		this.permisoSemanal = aPermisoSemanal;
	}
	
	
	public void setIgnorarProxAntiPassBack(boolean aIgnorarProxAntiPassBack) {
		this.ignorarProxAntiPassBack = aIgnorarProxAntiPassBack;
	}
	
	
	public void setControlAntiPassBack(boolean aControlAntiPassBack) {
		this.controlAntiPassBack = aControlAntiPassBack;
	}
	
	
	public void setSentido(String aSentido) {
		this.sentido = aSentido;
	}
	
	
	public void setFecHorUltMov(java.util.Date aFecHorUltMov) {
		this.fecHorUltMov = aFecHorUltMov;
	}
	
	
	public Legajo getAutoriza() throws BaseException {
		supportRefresh();
		return this.autoriza;
	}
	

	public void setAutoriza(Legajo aAutoriza) {
		this.autoriza = aAutoriza;
	}
	
	public ZonaCIP getZonaActual() throws BaseException {
		supportRefresh();
		return this.zonaActual;
	}
	

	public void setTipoDocumento(TipoDocumento aTipoDocumento) {
		this.tipoDocumento = aTipoDocumento;
	}
	
	public void setZonaActual(ZonaCIP aZonaCIP) {
		this.zonaActual = aZonaCIP;
	}
	

	public EmpresaCIP getEmpresaCIP() throws BaseException {
		supportRefresh();
		return this.empresa;
	}

	public void setEmpresaCIP(EmpresaCIP aEmpresaCIP) {
		this.empresa = aEmpresaCIP;
	}

	public GrupoPuerta getGrupoPuertaIngreso() throws BaseException {
		supportRefresh();
		return this.grupoPuertaIngreso;
	}

	public void setGrupoPuertaIngreso(GrupoPuerta aGrupoPuertaIngreso) {
		this.grupoPuertaIngreso = aGrupoPuertaIngreso;
	}

	public GrupoPuerta getGrupoPuertaEgreso() throws BaseException {
		supportRefresh();
		return this.grupoPuertaEgreso;
	}

	public void setGrupoPuertaEgreso(GrupoPuerta aGrupoPuertaEgreso) {
		this.grupoPuertaEgreso = aGrupoPuertaEgreso;
	}

	public String getNroDocumento() throws BaseException {
		supportRefresh();
		return this.nroDocumento;
	}

	public void setNroDocumento(String aNroDocumento) {
		this.nroDocumento = aNroDocumento;
	}

	public java.util.Date getFecIngreso() throws BaseException {
		supportRefresh();
		return this.fecIngreso;
	}

	public void setFecIngreso(java.util.Date aFecIngreso) {
		this.fecIngreso = aFecIngreso;
	}

	public java.util.Date getFecRetiro() throws BaseException {
		supportRefresh();
		return this.fecRetiro;
	}

	public void setFecRetiro(java.util.Date aFecRetiro) {
		this.fecRetiro = aFecRetiro;
	}

	public String getApeyNom() throws BaseException {
		supportRefresh();
		return ape_y_nom;
	}

	public void setApeyNom(String aApeyNom) {
		this.ape_y_nom = aApeyNom;
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

	public static Visita findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Visita) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Visita findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Visita) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Visita findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Visita) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(ape_y_nom, "Debe ingresar el Apellido");
		
		if (this.aplicVigencia) {
			Validar.noNulo(this.fecVigDesde, "Debe ingresar la fecha Vigencia desde");
			Validar.noNulo(this.fecVigHasta, "Debe ingresar la fecha Vigencia hasta");
		}
		
	}

	public ValorClasificadorEntidad getValorClasifEnt(ClasificadorEntidad clasifEnt) throws BaseException {
		ValorClasificadorEntidad valClasifEnt = null;
		Integer oidValClasifEnt = (Integer) listaOidValClasif.get(clasifEnt.getNroClasif());
		if (oidValClasifEnt != null)
			valClasifEnt = ValorClasificadorEntidad.findByOid(oidValClasifEnt, getSesion());
		return valClasifEnt;
	}

	public List getClasifEntidadesActivas() throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidadActivos(Visita.NICKNAME, true, getSesion());
	}

	public static List getClasificadoresEntidadActivos(ISesion aSesion) throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidad(Visita.NICKNAME, true, aSesion);
	}

	public Integer getOidValorClasif(Integer nroClasif) throws BaseException {
		supportRefresh();
		if (listaOidValClasif.get(nroClasif) != null)
			return (Integer) listaOidValClasif.get(nroClasif);
		else
			return new Integer(0);
	}

	public void addOidValorClasif(Integer nroClasif, Integer aValor) {
		if (aValor == null)
			listaOidValClasif.put(nroClasif, new Integer(0));
		else
			listaOidValClasif.put(nroClasif, aValor);
	}

	public static List getLegajosByCondiciones(List listaLegajos, List valoresClasificadores, ISesion aSesion) throws BaseException {
		return DBLegajo.getLegajosByCondiciones(listaLegajos, valoresClasificadores, aSesion);
	}

	public List getDocumentacion() throws BaseException {
		if (this.readDocumentacion) {
			List listaDocumentacion = DocumentacionVisitaCIP.getDocumentacion(this, getSesion());
			this.documentacion.addAll(listaDocumentacion);
			this.readDocumentacion = false;
		}
		return documentacion;
	}

	public void addDocumentacion(DocumentacionVisitaCIP aDocumentacionVisitaCIP) throws BaseException {
		aDocumentacionVisitaCIP.setVistat(this);
		this.documentacion.add(aDocumentacionVisitaCIP);
	}
	
	public void addTarjetaCIP(TarjetaCIP aTarjetaCIP) throws BaseException {
		aTarjetaCIP.setVisita(this);
		this.tarjetas.add(aTarjetaCIP);
	}
	
	public void addRota(RotaVisita aRotaVisita) throws BaseException {
		aRotaVisita.setVisita(this);
		this.rotas.add(aRotaVisita);
	}
	
	public void addMotEntInter(MotEntIntVis aMotEntIntVis) throws BaseException {
		aMotEntIntVis.setVisita(this);
		this.motEntInter.add(aMotEntIntVis);
	}
	

	public void afterSave() throws BaseException {
		
		Iterator iterDocumentacionVisitaCIP = documentacion.iterator();
		while (iterDocumentacionVisitaCIP.hasNext()) {
			DocumentacionVisitaCIP docuVisitaCIP = (DocumentacionVisitaCIP) iterDocumentacionVisitaCIP.next();
			docuVisitaCIP.save();
			docuVisitaCIP = null;
		}
		iterDocumentacionVisitaCIP = null;
		
		Iterator iterTarjetasCIP = tarjetas.iterator();
		while (iterTarjetasCIP.hasNext()) {
			TarjetaCIP tarjeta = (TarjetaCIP) iterTarjetasCIP.next();
			tarjeta.save();
			tarjeta = null;
		}
		iterTarjetasCIP = null;
		
		Iterator iterRotas = rotas.iterator();
		while (iterRotas.hasNext()) {
			RotaVisita rotaVisita = (RotaVisita) iterRotas.next();
			rotaVisita.save();
			rotaVisita = null;
		}
		iterRotas = null;
		
		Iterator iterMotEntInter = this.motEntInter.iterator();
		while (iterMotEntInter.hasNext()) {
			MotEntIntVis motEntIntVis = (MotEntIntVis) iterMotEntInter.next();
			motEntIntVis.save();
			motEntIntVis = null;
		}
		iterMotEntInter = null;
		
		
	}
	
	public static String getPathFotosVisita(ISesion aSesion)
	throws BaseException {
		ValorParametro valorPathImagenesProd = ValorParametro
		.findByCodigoParametro("PATH_FOTOS_VISITA", aSesion);
		return valorPathImagenesProd.getValorCadena();
	}
	
	public static Visita getVisita(
			  TipoDocumento tipo,
			  String nroDocu,
	          ISesion aSesion)
	          throws BaseException {
		  if (tipo==null) return null;
		  if (nroDocu==null) return null;
		  return DBVisita.getVisita(tipo,nroDocu,aSesion);
	}
	
	
	public static List getVisitasPorNroDocu(
			  String nroDocumento,
	          ISesion aSesion) throws BaseException {
		  return DBVisita.getVisitasPorNroDocu(nroDocumento,aSesion);
	}
	
	public TarjetaCIP getTarjetaAsignada() throws BaseException {
		return TarjetaCIP.getTarjetaCIP(this, this.getSesion());
	}
	
	public boolean isTieneTarjetaAsignada() throws BaseException {
		TarjetaCIP tarjeta = TarjetaCIP.getTarjetaCIP(this, this.getSesion());
		if (tarjeta!=null)
			return true;
		else
			return false;
	}
	
	public static int getToleranciaMinEntVisita(ISesion aSesion) throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro("TOL_MIN_ENT_VISITA", aSesion).getValorEntero();
		} catch (Exception e) {
			return 60;
		}
	}
	
	public GrupoPuerta getGrupoPuertas(String computerName) throws BaseException {
		if (computerName==null) 
			return Visita.getGrupoPuertaDefault(this.getSesion());
		
		MaqPuertasVisita maqPuertasVisita =
			MaqPuertasVisita.findByCodigo(computerName.toUpperCase(), this.getSesion());
		
		if (maqPuertasVisita == null)
			return Visita.getGrupoPuertaDefault(this.getSesion());
		else {
			if (maqPuertasVisita.getGrupoPuerta()!=null)
				return maqPuertasVisita.getGrupoPuerta();
			else
				return Visita.getGrupoPuertaDefault(this.getSesion());
		}
	}
	
	public static GrupoPuerta getGrupoPuertaDefault(ISesion aSesion)
	throws BaseException {
		Integer oid = ValorParametro.findByCodigoParametro(
				"GRU_PUE_DEF_VIS", aSesion).getOidObjNeg();
		GrupoPuerta grupoPuerta = GrupoPuerta.findByOid(oid, aSesion);
		return grupoPuerta;
	}
	
	public List getPermisosHabIngVisita(
			  java.util.Date fecha) throws BaseException {
		    return PermisoVisita.getPermisosVisitaEntradas(this,Visita.HAB_PERMI,fecha,this.getSesion());
	}
	
	public List getPermisosHabIngVisitaPriAlta(
			  java.util.Date fecha) throws BaseException {
		    return PermisoVisita.getPermisosVisitaEntradasPriAlta(this,Visita.HAB_PERMI,fecha,this.getSesion());
	}
	
	public List getPermisosHabIngVisitaPriBaja(
			  java.util.Date fecha) throws BaseException {
		    return PermisoVisita.getPermisosVisitaEntradasPriBaja(this,Visita.HAB_PERMI,fecha,this.getSesion());
	}
	
	public List getPermisosHabEgrVisita(
			  java.util.Date fecha) throws BaseException {
		    return PermisoVisita.getPermisosVisitaSalidas(this,Visita.HAB_PERMI,fecha,this.getSesion());
	}
	
	
	public boolean puedeEgresarConTarj(String nroTarjeta, 
			Puerta puerta, 
			java.util.Date aFecHorActual) throws BaseException {
		
		// Verificar si puede ingresar por la fecha actual
		java.util.Date fecha = Fecha.getFechaTruncada(aFecHorActual);
		
		// Determinar estado de la Tarjeta
		TarjetaCIP tarjetaCIP = TarjetaCIP.getTarjetaCIP(nroTarjeta, this.getSesion());
		
		// Verificar que exista la tarjeta
		if (tarjetaCIP == null) {
			setMensNoPuedeIngresar("Tarjeta inexistente.");
			return false;
		}
		
		// Verificar que la tarjeta no se encuentre dehabilitada
		if (tarjetaCIP.isTarjetaDesHabilitada() || (tarjetaCIP.isActivo()==false)) {
			setMensNoPuedeIngresar("Tarjeta deshabilitada.");
			return false;
		}
		
		// Verificar que la tarjeta este Vigente
		if (!tarjetaCIP.isVigentaAFecHora(aFecHorActual)) {
			setMensNoPuedeIngresar("Tarjeta NO vigente");
			return false;
		} else if (!isVigentaAFecHora(aFecHorActual)) {
			setMensNoPuedeIngresar("Visita caduco vigencia");
			return false;
		} else if ((this.getGrupoVisita()!=null) && (this.getGrupoVisita().isActivo()) && (!this.getGrupoVisita().isVigentaAFecHora(aFecHorActual))) {
			setMensNoPuedeIngresar("Grupo Visita caduco vigencia");
			return false;
		}
			
		// Verificar que la tarjeta sea para visita
		if (!tarjetaCIP.isParaVisita()) {
			setMensNoPuedeIngresar("Tarjeta No habilitada Visitas");
			return false;
		}
		
		// Determinar si se pudo determinar la puerta
		if (puerta == null) {
			setMensNoPuedeIngresar("Puerta DESCONOCIDA");
			return false;
		}
		
		// Verificar si la puerta se encuentra restringida para visita
		if ((puerta.isRestringirEntVisita())) {
			setMensNoPuedeIngresar("Puerta NO habilitada Visita");
			return false;
		}
		
		// Verificar que la visita se encuentre activa
		if (this.isActivo()==false) {
			setMensNoPuedeIngresar("Visita dada de BAJA");
			return false;
		}
		
		if (puerta.isLibSalidaVisita()) {
			return true;
		}
		
		
		// Verificar que tenga acceso a una de las puertas
		if (puerta.isEgresoDelPredio()) {
			boolean puertaHabilitada = false;
			GrupoPuertaDet grupoPuertaDet   = null;
			if (this.getGrupoPuertaEgreso()!=null)
				grupoPuertaDet 	= this.getGrupoPuertaEgreso().getGrupoPuertaDet(puerta);
			if (grupoPuertaDet!=null) 
				puertaHabilitada = true;
			else {
				if (tarjetaCIP.getGrupoPueEgrVisita()!=null)
					grupoPuertaDet = tarjetaCIP.getGrupoPueEgrVisita().getGrupoPuertaDet(puerta);
				if (grupoPuertaDet!=null) 
					puertaHabilitada = true;
				else {
					if ((this.getGrupoVisita()!=null) && (this.getGrupoVisita().isActivo()) && (this.getGrupoVisita().getGrupoPuertaEgreso()!=null)) {
						grupoPuertaDet = this.getGrupoVisita().getGrupoPuertaEgreso().getGrupoPuertaDet(puerta);
						if (grupoPuertaDet!=null) 
							puertaHabilitada = true;
					}
				}
			}
			
			if (!puertaHabilitada) {
				setMensNoPuedeIngresar("Puerta NO habilitada");
				return false;
			}
		}
		
		// Verificar antipassback
		if (tarjetaCIP.isControlarAntiPassBack() || 
			this.isControlAntiPassBack() || 
			((this.getGrupoVisita()!=null) && (this.getGrupoVisita().isActivo()) && (this.getGrupoVisita().isAntipassback()))) {
			if ((this.isIgnorarProxAntiPassBack()==false) && 
				(ActLAntiPassBack.isActivado(this.getSesion())) && 
				(this.getSentido()!=null) && 
				(puerta.isControlAntiPassBackSal()) &&
				(this.getSentido().equals(MovimientoCIP.MOV_SAL_CIP))) {
				setMensNoPuedeIngresar("Salida ya registrada");
				return false;
			}			
		}		
		
		// Verificar los siguientes permisos
		Iterator iterPermisosVis = getPermisosHabEgrVisita(aFecHorActual).iterator();
		while (iterPermisosVis.hasNext()) {
			PermisoVisita permiso = (PermisoVisita) iterPermisosVis.next();
			if (permiso.getGrupo_puerta().getGrupoPuertaDet(puerta)==null) 
				continue;
			else 
				return true;
		}
		
		// Verificar si se trata de un acceso interno
		if (!puerta.isEgresoDelPredio())  {
			
			if ((tarjetaCIP.getCategAccesoVisita()!=null) && 
			    (tarjetaCIP.getCategAccesoVisita().isTieneAccesoDeSalidaAPuerta(puerta)))
				return true;
			else if ((this.getCategoriaAcceso()!=null) && (this.getCategoriaAcceso().isTieneAccesoDeSalidaAPuerta(puerta)))
					return true;
			else if ((this.getGrupoVisita()!=null) && (this.getGrupoVisita().getCategoriaAcceso()!=null) 
					  && (this.getGrupoVisita().getCategoriaAcceso().isTieneAccesoDeSalidaAPuerta(puerta)))
				return true;			
		}
		
		
		// Ver si tiene acceso por Planificacion por Fecha 

		if (puerta.isEgresoDelPredio()) {
			
			RotaVisita rotaVisita = this.getBuscarRotaFecha(fecha);
			if ((rotaVisita!=null) && (rotaVisita.getRota().isSegunHorario())) {
				if (rotaVisita.getRota().isPuedeEgresarSegunHorario(fecha,aFecHorActual , 0 , 0)) 
					return true;
			}
			
			rotaVisita = this.getBuscarRotaFechaDelGrupo(fecha);
			if ((rotaVisita!=null) && (rotaVisita.getRota().isSegunHorario())) {
				if (rotaVisita.getRota().isPuedeEgresarSegunHorario(fecha,aFecHorActual , 0 , 0)) 
					return true;
			}
			
			// Verificar si puede ingresar por la rota del dia anterior
			java.util.Date fecDiaAnt = Fecha.getFechaDiaAnterior(fecha);
			RotaVisita rotaVisitaDiaAnt = this.getBuscarRotaFecha(fecDiaAnt);
			if ((rotaVisitaDiaAnt!=null) && (rotaVisitaDiaAnt.getRota().isSegunHorario())) {
					if (rotaVisitaDiaAnt.getRota().isPuedeEgresarSegunHorario(fecDiaAnt,aFecHorActual , 0 , 0)) 
						return true;				
			}
			
			rotaVisitaDiaAnt = this.getBuscarRotaFechaDelGrupo(fecDiaAnt);
			if ((rotaVisitaDiaAnt!=null) && (rotaVisitaDiaAnt.getRota().isSegunHorario())) {
					if (rotaVisitaDiaAnt.getRota().isPuedeEgresarSegunHorario(fecDiaAnt,aFecHorActual, 0 , 0)) 
						return true;				
			}
			
				
			// Verificar si puede ingresar por la rota del dia posterior
			java.util.Date fecDiaPost = Fecha.getFechaDiaPosterior(fecha);
			
			RotaVisita rotaVisitaDiaPost = this.getBuscarRotaFecha(fecDiaPost);
			if ((rotaVisitaDiaPost!=null) && (rotaVisitaDiaPost.getRota().isSegunHorario())) {
					if (rotaVisitaDiaPost.getRota().isPuedeEgresarSegunHorario(fecDiaPost,aFecHorActual,0,0)) 
						return true;					
			}
			
			rotaVisitaDiaPost = this.getBuscarRotaFechaDelGrupo(fecDiaPost);
			if ((rotaVisitaDiaPost!=null) && (rotaVisitaDiaPost.getRota().isSegunHorario())) {
					if (rotaVisitaDiaPost.getRota().isPuedeEgresarSegunHorario(fecDiaPost,aFecHorActual,0,0)) 
						return true;					
			}				
			
			
			
			if (rotaVisita != null) {
				
				if (rotaVisita.getRota().isPermiteEgreso()) 
					return true;
				else if (rotaVisita.getRota().isEgresoDenegado()) {
						setMensNoPuedeIngresar("Egreso denegado");
						return false;
					 } else if (rotaVisita.getRota().isEgresoSegunHorario()) {
						 		// Si llego hasta aca es porque no tiene acceso
								setMensNoPuedeIngresar(rotaVisita.getRota().getLeyendaNoEgresa());
								return false;
					  		}
			}
			
			
		}
		
		// ************************************//
		// *** Planificacion de la Semana *** //
		// ************************************//

		if (puerta.isEgresoDelPredio()) {

			if (this.getPermisoSemanal() != null) {

				int dia = Fecha.getDiaSemana(fecha);
				java.util.Date fecDiaAnt = Fecha.getFechaDiaAnterior(fecha);
				java.util.Date fecDiaPos = Fecha.getFechaDiaPosterior(fecha);
				int diaAnterior = dia - 1;
				if (diaAnterior==0) diaAnterior = 7;
				int diaPosterior = dia + 1;
				if (diaPosterior==8) diaPosterior = 1; 
				
				String tipoPermiso = "";
				tipoPermiso = this.getPermisoSemanal().getTipoPermisoSemanalSal(dia);
				if ((tipoPermiso!=null) && (tipoPermiso.equals(TiposEntradasRotas.SEGUN_HORARIO))) {
					if (this.getPermisoSemanal().isPuedeEgresar(dia, fecha , aFecHorActual , 0 , 0)) 
						return true;
				}
				
				String tipoPermisoAnt = this.getPermisoSemanal().getTipoPermisoSemanalSal(diaAnterior);
				if ((tipoPermisoAnt!=null) && (tipoPermisoAnt.equals(TiposEntradasRotas.SEGUN_HORARIO))) {
					if (this.getPermisoSemanal().isPuedeEgresar(diaAnterior, fecDiaAnt , aFecHorActual,0,0)) 
						return true;
				}
				
				String tipoPermisoPos = this.getPermisoSemanal().getTipoPermisoSemanalSal(diaPosterior);
				if ((tipoPermisoPos!=null) && (tipoPermisoPos.equals(TiposEntradasRotas.SEGUN_HORARIO))) {
					if (this.getPermisoSemanal().isPuedeEgresar(diaPosterior, fecDiaPos , aFecHorActual,0,0)) 
						return true;
				}				
				
				
				if (tipoPermiso.equals(TiposEntradasRotas.PERMITIDO)) 
					return true;
				else if (tipoPermiso.equals(TiposEntradasRotas.DENEGADO)) {
					setMensNoPuedeIngresar(this.getPermisoSemanal().getLeyendaNoEgresa(dia));
					return false;
				} else if (tipoPermiso.equals(TiposEntradasRotas.SEGUN_HORARIO)) {
						setMensNoPuedeIngresar(getPermisoSemanal().getLeyendaNoEgresa(dia));
						return false;
				}

			}
			
		}
		
		
		setMensNoPuedeIngresar("Visita pase NO autorizado");
		return false;
		
	}
	
	
	public boolean puedeIngresarConTarj(String nroTarjeta, 
										Puerta puerta, 
										java.util.Date aFecHorActual) throws BaseException {
		
		// Verificar si puede ingresar por la fecha actual
		java.util.Date fecha = Fecha.getFechaTruncada(aFecHorActual);
		
		// Determinar estado de la Tarjeta
		TarjetaCIP tarjetaCIP = TarjetaCIP.getTarjetaCIP(nroTarjeta, this.getSesion());
		
		// Verificar que exista la tarjeta
		if (tarjetaCIP == null) {
			setMensNoPuedeIngresar("Tarjeta inexistente.");
			return false;
		}
		
		// Verificar que la tarjeta no se encuentre dehabilitada
		if (tarjetaCIP.isTarjetaDesHabilitada() || (tarjetaCIP.isActivo()==false)) {
			setMensNoPuedeIngresar("Tarjeta deshabilitada.");
			return false;
		}
		
		// Verificar que la tarjeta este Vigente
		if (!tarjetaCIP.isVigentaAFecHora(aFecHorActual)) {
			setMensNoPuedeIngresar("Tarjeta NO vigente");
			return false;
		} else if (!isVigentaAFecHora(aFecHorActual)) {
			setMensNoPuedeIngresar("Visita caduco vigencia");
			return false;
		} else if ((this.getGrupoVisita()!=null) && (this.getGrupoVisita().isActivo()) && (!this.getGrupoVisita().isVigentaAFecHora(aFecHorActual))) {
			setMensNoPuedeIngresar("Grupo Visita caduco vigencia");
			return false;
		}
			
		// Verificar que la tarjeta sea para visita
		if (!tarjetaCIP.isParaVisita()) {
			setMensNoPuedeIngresar("Tarjeta No habilitada Visitas");
			return false;
		}
		
		// Determinar si se pudo determinar la puerta
		if (puerta == null) {
			setMensNoPuedeIngresar("Puerta DESCONOCIDA");
			return false;
		}
		
		// Verificar si la puerta se encuentra restringida para visita
		if ((puerta.isRestringirEntVisita())) {
			setMensNoPuedeIngresar("Puerta NO habilitada Visita");
			return false;
		}
		
		// Verificar que la visita se encuentre activa
		if (this.isActivo()==false) {
			setMensNoPuedeIngresar("Visita dada de BAJA");
			return false;
		}
				
		// Verificar que tenga acceso a una de las puertas
		if (puerta.isIngresoAlPredio()) {
			boolean puertaHabilitada = false;
			GrupoPuertaDet grupoPuertaDet   = null;
			if (this.getGrupoPuertaIngreso()!=null)
				grupoPuertaDet 	= this.getGrupoPuertaIngreso().getGrupoPuertaDet(puerta);
			if (grupoPuertaDet!=null) 
				puertaHabilitada = true;
			else {
				if (tarjetaCIP.getGrupoPueAccVisita()!=null)
					grupoPuertaDet = tarjetaCIP.getGrupoPueAccVisita().getGrupoPuertaDet(puerta);
				if (grupoPuertaDet!=null) 
					puertaHabilitada = true;
				else {
					if ((this.getGrupoVisita()!=null) && (this.getGrupoVisita().isActivo()) && (this.getGrupoVisita().getGrupoPuertaIngreso()!=null)) {
						grupoPuertaDet = this.getGrupoVisita().getGrupoPuertaIngreso().getGrupoPuertaDet(puerta);
						if (grupoPuertaDet!=null) 
							puertaHabilitada = true;
					}
				}
			}
			
			if (!puertaHabilitada) {
				setMensNoPuedeIngresar("Puerta NO habilitada");
				return false;
			}
		}
		
		// Si la puerta esta liberar puede pasar cualquier visita
		if (puerta.isLibEntradaVisita()) {
			return true;
		}
		
		//*********************************************/
		// ** Verificar si tiene liberada la entrada **/
		//*********************************************/
		
		if ((puerta!=null) && 
			(puerta.isIngresoAlPredio() && 
			(this.isLibAccesoAlPredio()))) 
			return true;
		
		// Verificar los siguientes permisos

		Iterator iterPermisosVis = getPermisosHabIngVisitaPriAlta(aFecHorActual).iterator();
		while (iterPermisosVis.hasNext()) {
			PermisoVisita permiso = (PermisoVisita) iterPermisosVis.next();
			if (permiso.getGrupo_puerta().getGrupoPuertaDet(puerta)==null) 
				continue;
			else 
				return true;
		}
		
		// Verificar antipassback
		if (tarjetaCIP.isControlarAntiPassBack() || 
			this.isControlAntiPassBack() || 
			((this.getGrupoVisita()!=null) && (this.getGrupoVisita().isActivo()) && (this.getGrupoVisita().isAntipassback()))) {
			if ((this.isIgnorarProxAntiPassBack()==false) && 
				(ActLAntiPassBack.isActivado(this.getSesion())) && 
				(this.getSentido()!=null) && 
				(puerta.isControlAntiPassBackEnt()) &&
				(this.getSentido().equals(MovimientoCIP.MOV_ENT_CIP))) {
				setMensNoPuedeIngresar("Entrada ya registrada");
				return false;
			}			
		}		
		
		
		// Verifivar que no deba documentacion
		boolean noIngresaPorFaltaDeDocu = false;
		if (this.getMotivoVisita()!=null) {
			StringBuffer docuFaltante = new StringBuffer("");
			Iterator iterDocuRequerida = this.getMotivoVisita().getDocumentacion().iterator();
			while (iterDocuRequerida.hasNext()) {
				MotivoVisitaDoc motivoVisitaDoc = (MotivoVisitaDoc)iterDocuRequerida.next();
				DocumentacionVisitaCIP docuVisitaCIP = this.getTieneDocumentacion(fecha, motivoVisitaDoc.getTipo_docu());
				if (docuVisitaCIP == null) {
					noIngresaPorFaltaDeDocu = true;
					docuFaltante.append(motivoVisitaDoc.getTipo_docu().getDescripcion()+ " ");
				}
			}
			if (noIngresaPorFaltaDeDocu) {
				setMensNoPuedeIngresar("Falta Presentar Documentacion:"+docuFaltante.toString());
				return false;
			}
		}
		
		// Verificar los siguientes permisos

		iterPermisosVis = getPermisosHabIngVisitaPriBaja(aFecHorActual).iterator();
		while (iterPermisosVis.hasNext()) {
			PermisoVisita permiso = (PermisoVisita) iterPermisosVis.next();
			if (permiso.getGrupo_puerta().getGrupoPuertaDet(puerta)==null) 
				continue;
			else 
				return true;
		}

		
		// Verificar si se trata de un acceso interno
		if (puerta.isIngresoInterno())  {
			
			if ((tarjetaCIP.getCategAccesoVisita()!=null) && 
			    (tarjetaCIP.getCategAccesoVisita().isTieneAccesoDeEntradaAPuerta(puerta)))
				return true;
			else if ((this.getCategoriaAcceso()!=null) && (this.getCategoriaAcceso().isTieneAccesoDeEntradaAPuerta(puerta)))
					return true;
			else if ((this.getGrupoVisita()!=null) && (this.getGrupoVisita().getCategoriaAcceso()!=null) 
					  && (this.getGrupoVisita().getCategoriaAcceso().isTieneAccesoDeEntradaAPuerta(puerta)))
				return true;			
		}
		
		// Ver si tiene acceso por Planificacion por Fecha 

		if (puerta.isIngresoAlPredio()) {
			
			RotaVisita rotaVisita = this.getBuscarRotaFecha(fecha);
			if ((rotaVisita!=null) && (rotaVisita.getRota().isSegunHorario())) {
				if (rotaVisita.getRota().isPuedeIngresarSegunHorario(fecha,aFecHorActual , 0 , 0)) 
					return true;
				if (puedeIngresarEntIntermedias(aFecHorActual,this,rotaVisita)) 
					return true;
			}
			
			rotaVisita = this.getBuscarRotaFechaDelGrupo(fecha);
			if ((rotaVisita!=null) && (rotaVisita.getRota().isSegunHorario())) {
				if (rotaVisita.getRota().isPuedeIngresarSegunHorario(fecha,aFecHorActual , 0 , 0)) 
					return true;
				if (puedeIngresarEntIntermedias(aFecHorActual,this,rotaVisita)) 
					return true;
			}
			
			// Verificar si puede ingresar por la rota del dia anterior
			java.util.Date fecDiaAnt = Fecha.getFechaDiaAnterior(fecha);
			RotaVisita rotaVisitaDiaAnt = this.getBuscarRotaFecha(fecDiaAnt);
			if ((rotaVisitaDiaAnt!=null) && (rotaVisitaDiaAnt.getRota().isSegunHorario())) {
					if (rotaVisitaDiaAnt.getRota().isPuedeIngresarSegunHorario(fecDiaAnt,aFecHorActual , 0 , 0)) 
						return true;				
					if (puedeIngresarEntIntermedias(aFecHorActual,this,rotaVisitaDiaAnt)) 
						return true;
			}
			
			rotaVisitaDiaAnt = this.getBuscarRotaFechaDelGrupo(fecDiaAnt);
			if ((rotaVisitaDiaAnt!=null) && (rotaVisitaDiaAnt.getRota().isSegunHorario())) {
					if (rotaVisitaDiaAnt.getRota().isPuedeIngresarSegunHorario(fecDiaAnt,aFecHorActual, 0 , 0)) 
						return true;				
					if (puedeIngresarEntIntermedias(aFecHorActual,this,rotaVisitaDiaAnt)) 
						return true;
			}
			
				
			// Verificar si puede ingresar por la rota del dia posterior
			java.util.Date fecDiaPost = Fecha.getFechaDiaPosterior(fecha);
			
			RotaVisita rotaVisitaDiaPost = this.getBuscarRotaFecha(fecDiaPost);
			if ((rotaVisitaDiaPost!=null) && (rotaVisitaDiaPost.getRota().isSegunHorario())) {
					if (rotaVisitaDiaPost.getRota().isPuedeIngresarSegunHorario(fecDiaPost,aFecHorActual,0,0)) 
						return true;					
					if (puedeIngresarEntIntermedias(aFecHorActual,this,rotaVisitaDiaPost)) 
						return true;					
			}
			
			rotaVisitaDiaPost = this.getBuscarRotaFechaDelGrupo(fecDiaPost);
			if ((rotaVisitaDiaPost!=null) && (rotaVisitaDiaPost.getRota().isSegunHorario())) {
					if (rotaVisitaDiaPost.getRota().isPuedeIngresarSegunHorario(fecDiaPost,aFecHorActual,0,0)) 
						return true;					
					if (puedeIngresarEntIntermedias(aFecHorActual,this,rotaVisitaDiaPost)) 
						return true;					
			}				
			
			
			
			if (rotaVisita != null) {
				
				if (rotaVisita.getRota().isPermiteIngreso()) 
					return true;
				else if (rotaVisita.getRota().isIngresoDenegado()) {
						setMensNoPuedeIngresar("Ingreso denegado");
						return false;
					 } else if (rotaVisita.getRota().isSegunHorario()) {
						 		// Si llego hasta aca es porque no tiene acceso
								setMensNoPuedeIngresar(rotaVisita.getRota().getLeyendaNoIngresa());
								return false;
					  		}
			}
			
			
		}
		
		// ************************************//
		// *** Planificacion de la Semana *** //
		// ************************************//

		if (puerta.isIngresoAlPredio()) {

			if (this.getPermisoSemanal() != null) {

				int dia = Fecha.getDiaSemana(fecha);
				java.util.Date fecDiaAnt = Fecha.getFechaDiaAnterior(fecha);
				java.util.Date fecDiaPos = Fecha.getFechaDiaPosterior(fecha);
				int diaAnterior = dia - 1;
				if (diaAnterior==0) diaAnterior = 7;
				int diaPosterior = dia + 1;
				if (diaPosterior==8) diaPosterior = 1; 
				
				String tipoPermiso = "";
				tipoPermiso = this.getPermisoSemanal().getTipoPermisoSemanalEnt(dia);
				if ((tipoPermiso!=null) && (tipoPermiso.equals(TiposEntradasRotas.SEGUN_HORARIO))) {
					if (this.getPermisoSemanal().isPuedeIngresar(dia, fecha , aFecHorActual , 0 , 0)) 
						return true;
					if (puedeIngresarEntIntermedias(aFecHorActual,this.getPermisoSemanal(),fecha)) 
							return true;
				}
				
				String tipoPermisoAnt = this.getPermisoSemanal().getTipoPermisoSemanalEnt(diaAnterior);
				if ((tipoPermisoAnt!=null) && (tipoPermisoAnt.equals(TiposEntradasRotas.SEGUN_HORARIO))) {
					if (this.getPermisoSemanal().isPuedeIngresar(diaAnterior, fecDiaAnt , aFecHorActual,0,0)) 
						return true;
					if (puedeIngresarEntIntermedias(aFecHorActual,this.getPermisoSemanal(),fecDiaAnt)) 
						return true;
				}
				
				String tipoPermisoPos = this.getPermisoSemanal().getTipoPermisoSemanalEnt(diaPosterior);
				if ((tipoPermisoPos!=null) && (tipoPermisoPos.equals(TiposEntradasRotas.SEGUN_HORARIO))) {
					if (this.getPermisoSemanal().isPuedeIngresar(diaPosterior, fecDiaPos , aFecHorActual,0,0)) 
						return true;
					if (puedeIngresarEntIntermedias(aFecHorActual,this.getPermisoSemanal(),fecDiaPos)) 
						return true;
				}				
				
				
				if (tipoPermiso.equals(TiposEntradasRotas.PERMITIDO)) 
					return true;
				else if (tipoPermiso.equals(TiposEntradasRotas.DENEGADO)) {
					setMensNoPuedeIngresar(this.getPermisoSemanal().getLeyendaNoIngresa(dia));
					return false;
				} else if (tipoPermiso.equals(TiposEntradasRotas.SEGUN_HORARIO)) {
						setMensNoPuedeIngresar(getPermisoSemanal().getLeyendaNoIngresa(dia));
						return false;
				}

			}
			
		}
		
		
		setMensNoPuedeIngresar("Visita pase NO autorizado");
		return false;
		
	}
	
	private boolean puedeIngresarEntIntermedias(
			java.util.Date fecHorActual,
			PermisoSemanalCIP permisoSemanal,
			java.util.Date fecha) throws BaseException {
		
			String diaSemana = MotEntInterPlanifS.getDiaSemana(Fecha.getDiaSemana(fecha));
		
			Iterator iterMotEntInterPlanifS = 
				MotEntInterPlanifS.getMotEntInterPlanifS(permisoSemanal, diaSemana, this.getSesion()).iterator();
			while (iterMotEntInterPlanifS.hasNext()) {
				MotEntInterPlanifS motEntInterPlanifS = (MotEntInterPlanifS) iterMotEntInterPlanifS.next();
					
				int HorasDesde   = UtilCIP.getParteHoraEnHoras(motEntInterPlanifS.getHorario_desde());
				int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(motEntInterPlanifS.getHorario_desde());
				int cantMinutosHorDesde = UtilCIP.getHoraEnMin(motEntInterPlanifS.getHorario_desde());
					
				Calendar calFecHorDesde = GregorianCalendar.getInstance(); 
				calFecHorDesde.setTime(fecha); // set cal to date
				calFecHorDesde.add(Calendar.HOUR, HorasDesde);
				calFecHorDesde.add(Calendar.MINUTE, MinutosDesde);
				java.util.Date fecHorDesde = calFecHorDesde.getTime();
					
				int HorasHasta   = UtilCIP.getParteHoraEnHoras(motEntInterPlanifS.getHorario_hasta());
				int MinutosHasta = UtilCIP.getParteMinutosEnMinutos(motEntInterPlanifS.getHorario_hasta());
				int cantMinutosHorHasta = UtilCIP.getHoraEnMin(motEntInterPlanifS.getHorario_hasta());
					
				Calendar calFecHorHasta = GregorianCalendar.getInstance(); 
				if (cantMinutosHorHasta<cantMinutosHorDesde)
					calFecHorHasta.setTime(Fecha.getFechaDiaPosterior(fecha)); 
				else
					calFecHorHasta.setTime(fecha); // set cal to date
				calFecHorHasta.add(Calendar.HOUR, HorasHasta);
				calFecHorHasta.add(Calendar.MINUTE, MinutosHasta);
				java.util.Date fecHorHasta = calFecHorHasta.getTime();
					
				if ((!fecHorActual.before(fecHorDesde)) && (!fecHorActual.after((fecHorHasta)))) {
					if (motEntInterPlanifS.getAsignacion().equals(MotivoEntradasInterRota.ASIG_FIJA))
						return true;
					else {
						// Segun tenga el motivo asignado
						MotEntIntVis motEntIntVis =
							MotEntIntVis.getMotEntIntVis(this, motEntInterPlanifS.getMotivo(), this.getSesion());
						if (motEntIntVis!=null)
							return true;
						else {
							if (this.getGrupoVisita()!=null) {
								motEntIntVis =
									MotEntIntVis.getMotEntIntVis(this.getGrupoVisita(), motEntInterPlanifS.getMotivo(), this.getSesion());
								if (motEntIntVis!=null)
									return true;
							}
						}
						
					}
				}
			}
			return false;
		
	}
	
	
	public List getRotasVisita(java.util.Date fecha) throws BaseException {
		  return RotaVisita.getRotasVisita(this,fecha,this.getSesion());
	}
	
	public boolean isVigentaAFecHora(java.util.Date aFecHor) throws BaseException {
		if (this.isAplicVigencia()==false) return true;  
		if ((this.getFecVigenciaDesde()==null) || (this.getFecVigenciaHasta()==null)) return true;
		java.util.Date fecHorActual = Fecha.getFechaTruncada(aFecHor);
		if (Fecha.isFechaEntre(fecHorActual, Fecha.getFechaTruncada(this.getFecVigenciaDesde()), Fecha.getFechaTruncada(this.getFecVigenciaHasta()))) return true;
		return false;
	}
	
	public RotaVisita getBuscarRotaFecha(java.util.Date fecha) throws BaseException {
		return RotaVisita.getBuscarRotaVisita(this,fecha,this.getSesion());
	}
	
	public RotaVisita getBuscarRotaFechaDelGrupo(java.util.Date fecha) throws BaseException {
		if (this.getGrupoVisita()==null) return null;
		return RotaVisita.getBuscarRotaVisita(this.getGrupoVisita(),fecha,this.getSesion());
	}
	
	private boolean puedeIngresarEntIntermedias(
			java.util.Date fecHorActual,
			Visita visita,
			RotaVisita rotaVisita) throws BaseException {
		
			if (rotaVisita!=null) {
				
				int HorasDesde   = UtilCIP.getParteHoraEnHoras(rotaVisita.getRota().getHorario_desde());
				int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(rotaVisita.getRota().getHorario_desde());
				int cantMinutosHorDesde = UtilCIP.getHoraEnMin(rotaVisita.getRota().getHorario_desde());
				
				Calendar calFecHorDesde = GregorianCalendar.getInstance(); 
				calFecHorDesde.setTime(rotaVisita.getFecha()); // set cal to date
				calFecHorDesde.add(Calendar.HOUR, HorasDesde);
				calFecHorDesde.add(Calendar.MINUTE, MinutosDesde);
				java.util.Date fecHorDesde = calFecHorDesde.getTime();
				
				int HorasHasta   = UtilCIP.getParteHoraEnHoras(rotaVisita.getRota().getHorario_hasta());
				int MinutosHasta = UtilCIP.getParteMinutosEnMinutos(rotaVisita.getRota().getHorario_hasta());
				int cantMinutosHorHasta = UtilCIP.getHoraEnMin(rotaVisita.getRota().getHorario_hasta());
				
				Calendar calFecHorHasta = GregorianCalendar.getInstance(); 
				if (cantMinutosHorHasta<cantMinutosHorDesde)
					calFecHorHasta.setTime(Fecha.getFechaDiaPosterior(rotaVisita.getFecha())); 
				else
					calFecHorHasta.setTime(rotaVisita.getFecha()); // set cal to date
				calFecHorHasta.add(Calendar.HOUR, HorasHasta);
				calFecHorHasta.add(Calendar.MINUTE, MinutosHasta);
				java.util.Date fecHorHasta = calFecHorHasta.getTime();
			
				if ((!fecHorActual.before(fecHorDesde)) && (!fecHorActual.after((fecHorHasta)))) {
					
					Iterator iterMotInterRotasAsigFij = getMotEntInterSegunVisita(rotaVisita.getRota()).iterator();
					while (iterMotInterRotasAsigFij.hasNext()) {
						MotivoEntradasInterRota motivoEntradasInterRota = (MotivoEntradasInterRota) iterMotInterRotasAsigFij.next();
						
						int HorasDesdeMot          = UtilCIP.getParteHoraEnHoras(motivoEntradasInterRota.getHorario_desde());
						int MinutosDesdeMot        = UtilCIP.getParteMinutosEnMinutos(motivoEntradasInterRota.getHorario_desde());
						int cantMinutosHorDesdeMot = UtilCIP.getHoraEnMin(motivoEntradasInterRota.getHorario_desde());
						
						Calendar calFecHorDesdeMot = GregorianCalendar.getInstance();
						calFecHorDesdeMot.setTime(rotaVisita.getFecha()); 
						calFecHorDesdeMot.add(Calendar.HOUR, HorasDesdeMot);
						calFecHorDesdeMot.add(Calendar.MINUTE, MinutosDesdeMot);
						java.util.Date fecHorDesdeMot = calFecHorDesdeMot.getTime();
						
						int HorasHastaMot          = UtilCIP.getParteHoraEnHoras(motivoEntradasInterRota.getHorario_hasta());
						int MinutosHastaMot        = UtilCIP.getParteMinutosEnMinutos(motivoEntradasInterRota.getHorario_hasta());
						int cantMinutosHorHastaMot = UtilCIP.getHoraEnMin(motivoEntradasInterRota.getHorario_hasta());
						
						Calendar calFecHorHastaMot = GregorianCalendar.getInstance(); 
						if (cantMinutosHorHastaMot<cantMinutosHorDesdeMot)
							calFecHorHastaMot.setTime(Fecha.getFechaDiaPosterior(rotaVisita.getFecha())); 
						else
							calFecHorHastaMot.setTime(rotaVisita.getFecha()); // set cal to date
						calFecHorHastaMot.add(Calendar.HOUR, HorasHastaMot);
						calFecHorHastaMot.add(Calendar.MINUTE, MinutosHastaMot);
						java.util.Date fecHorHastaMot = calFecHorHastaMot.getTime();					
						if ((!fecHorActual.before(fecHorDesdeMot)) && (!fecHorActual.after((fecHorHastaMot)))) {
							return true;
						}	
					
					}
					
				}
			}
		
		return false;
		
	}
	
	
    public List getMotEntInterSegunVisita(Rota rota) throws BaseException {
  	  return MotivoEntradasInterRota.getMotEntInterSegunVisita(rota,this,this.getSesion());
  }
    
    public String getFecHorUltEntSalPredio() throws BaseException {
    	StringBuffer cond = new StringBuffer("");
    	if (this.getFecHorUltMov()!=null)
    		cond.append(Fecha.getFormatoFecHoraMin(this.getFecHorUltMov())+" ");
    	if (this.getSentido()!=null) {
    		if (this.getSentido().equals("E"))
    			cond.append("Entrada");
    		else
    			cond.append("Salida");
    	}
    	return cond.toString();
    }
    
    public boolean isEnElExterior() throws BaseException {
    	if (this.getZonaActual() == null) return true;
    	if ((this.getZonaActual()!=null) && (this.getZonaActual().esExterna()))
    		return true;
    	else
    		return false;
    }
    
    public DocumentacionVisitaCIP getTieneDocumentacion(
			  java.util.Date fecha,
			  TipoDocumentacionCIP tipoDocu)
	          throws BaseException {
		  return DocumentacionVisitaCIP.getDocumentacion(fecha,this,tipoDocu,this.getSesion());
	}
    
    public static List getVisitasEnPredio(
            ISesion aSesion) throws BaseException {
  	  return DBVisita.getVisitasEnPredio(aSesion);
    }
    
    public List getNovedades(java.util.Date aFecHorActual) throws BaseException {
    	
    	ArrayList novedades = new ArrayList();
    	
    	// Obtener las Novedades
		Iterator iterPermisosVis = getPermisosHabIngVisita(aFecHorActual).iterator();
		while (iterPermisosVis.hasNext()) {
			PermisoVisita permiso = (PermisoVisita) iterPermisosVis.next();
			
			
			if (permiso.getSentido().equals(PermisoVisita.SENTIDO_E)) {
				String horaDesde = Fecha.getFormatoHoraMin(permiso.getFec_hor_desde());
				String horaHasta = Fecha.getFormatoHoraMin(permiso.getFec_hor_hasta());
				if (permiso.getPermiso().equals(Visita.HAB_PERMI)) {
					String novedad = "Puede ingresar en el Horario de "+horaDesde+" a "+horaHasta;
					novedades.add(novedad);
				}
			}
			
		}
    	
    	return novedades;
    }
    
	

}
