package com.srn.erp.sueldos.bm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.Cacheo;
import com.srn.erp.cip.bm.CategAccesoLegajo;
import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoPuertaDet;
import com.srn.erp.cip.bm.IdentificadoresDeLegajosCIP;
import com.srn.erp.cip.bm.LegajoRotaFecha;
import com.srn.erp.cip.bm.MotEntInterLeg;
import com.srn.erp.cip.bm.MotEntInterPlanifS;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.MotivoEntradasInterRota;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.bm.PlanifDiaCacheo;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.bm.TarjetaLegajo;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.cip.bm.ZonaCIP;
import com.srn.erp.cip.da.DBMotEntInterLeg;
import com.srn.erp.cip.da.DBTarjetaLegajo;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.bm.CartasDocRemLega;
import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.NegociacionLegales;
import com.srn.erp.legales.bm.Seclo;
import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.AgrupadorAntEmp;
import com.srn.erp.rrhh.bm.CantSancionesPorTitu;
import com.srn.erp.rrhh.bm.CategPosibleLeg;
import com.srn.erp.rrhh.bm.ClaseSindicato;
import com.srn.erp.rrhh.bm.EstadoDesarrollo;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.GradoLegajo;
import com.srn.erp.rrhh.bm.HistoricoPuesto;
import com.srn.erp.rrhh.bm.JerarquiaDesa;
import com.srn.erp.rrhh.bm.ListaDesgloseCalifGral;
import com.srn.erp.rrhh.bm.MesCronoDesa;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.rrhh.bm.MotivoEgresoEmp;
import com.srn.erp.rrhh.bm.MotivosNoAprob;
import com.srn.erp.rrhh.bm.NovedadLegajo;
import com.srn.erp.rrhh.bm.ObsLegajo;
import com.srn.erp.rrhh.bm.RankItemDesarrollo;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.RankearNovedad;
import com.srn.erp.rrhh.bm.SancionRankear;
import com.srn.erp.rrhh.bm.SancionesLegajo;
import com.srn.erp.rrhh.bm.ServicioMedicoRRHH;
import com.srn.erp.rrhh.bm.TareaDesempeneada;
import com.srn.erp.rrhh.bm.TipoObsLeg;
import com.srn.erp.rrhh.da.DBEvaluacionLegajoCab;
import com.srn.erp.rrhh.da.DBObsLegajo;
import com.srn.erp.rrhh.da.DBSancionesLegajo;
import com.srn.erp.rrhh.op.TraerLeyendasRepEval;
import com.srn.erp.sueldos.da.DBLegajo;
import com.srn.erp.ventas.bm.EstadoCivil;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Legajo extends ObjetoLogico {

	int orden = 0;

	private Hashtable listaOidValClasif = new Hashtable();

	private List tarjetasLegajo = new ArrayList();
	private boolean readTarjetasLegajo = true;

	private List motivosAccesosInter = new ArrayList();
	private boolean readMotivosAccesosInter = true;

	private List categAccesosInternos = new ArrayList();
	private boolean readCategAccesosInternos = true;

	private List planifDiaRota = new ArrayList();
	private boolean readPlanifDiaRota = true;

	private List listaClasifEnt = new ArrayList();
	private boolean readListaClasifEnt = true;

	private List listaHistPuestos = new ArrayList();
	private boolean readListaHistPuestos = true;

	private List listaSanciones = new ArrayList();
	private boolean readSanciones = true;

	private List pedidosMedicos = new ArrayList();
	private boolean readPedidosMed = true;

	private List atencionMedidas = new ArrayList();
	private boolean readAtencionMedicas = true;

	private List enfermedadFam = new ArrayList();
	private boolean readEnfermedadesFam = true;

	private List accidentesLaborales = new ArrayList();
	private boolean readAccidentesLaborales = true;

	private List cartasRemitidasLeg = new ArrayList();
	private boolean readCartasRemitidasLeg = true;

	private List novedades = new ArrayList();
	private boolean readNovedades = true;

	private List negociaciones = new ArrayList();
	private boolean readNegociaciones = true;

	private List seclos = new ArrayList();
	private boolean readSeclos = true;

	private List categPosibles = new ArrayList();
	private boolean readCategPosibles = true;

	private List juicios = new ArrayList();
	private boolean readJuicios = true;

	private List observaciones = new ArrayList();
	private boolean readObservaciones = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return this.getNro_legajo();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getApellido() + ", " + this.getNombre();
	}

	public String getApellidoyNombre() throws BaseException {
		if ((this.getApellido() != null) && (this.getNombre() != null))
			return this.getApellido() + " " + this.getNombre();
		else if (this.getApellido() != null)
			return this.getApellido();
		else if (this.getNombre() != null)
			return this.getNombre();
		else
			return "";
	}

	public Legajo() {
	}

	public static String NICKNAME = "su.Legajo";

	private String nro_legajo;
	private String apellido;
	private String nombre;
	private Boolean activo;
	private java.util.Date fecIngreso;
	private java.util.Date fecRetiro;
	private Integer idIdentificacion;
	private GrupoPuerta grupoPuertaIngreso;
	private GrupoPuerta grupoPuertaEgreso;
	private EstadoCIP estado;
	private PermisoSemanalCIP permisoSemanal;
	private Boolean activarAntiPassBack;
	private Date fecUltPaso;
	private String horaUtlPaso;
	private String sentidoPaso;
	private Boolean ignorarProxAntiPassBack;
	private Boolean circuitoCacheo;
	private ZonaCIP zonaActual;
	private boolean liberarIngAlPredio;
	private boolean prohibirAcceso;
	private String cuit;
	private String sexo;
	private EstadoCivil estadoCivil;
	private java.util.Date fecNacimiento;
	private TipoDocumento tipoDocumento;
	private String nroDocumento;
	private String telefono;
	private String telefonoCelular;
	private ClaseSindicato claseSindicato;
	private java.util.Date fecAntReco;
	private MotivoEgresoEmp motivoEgreso;
	private java.util.Date fecVencProteccion;
	private java.util.Date fecIngresoUTE;
	private String direccion;
	private GradoLegajo gradoLegajo;
	private EstadoDesarrollo estadoDesarrollo;
	private Boolean seguiLegales;
	private boolean SeguiCartasDocu;
	private TareaDesempeneada tareaDesempeneada;

	public String getDireccion() throws BaseException {
		supportRefresh();
		return this.direccion;
	}

	public Boolean isSeguiLegales() throws BaseException {
		supportRefresh();
		return this.seguiLegales;
	}

	public TareaDesempeneada getTareaDesempeneada() throws BaseException {
		supportRefresh();
		return this.tareaDesempeneada;
	}
	
	public void setTareaDempeneada(TareaDesempeneada aTareaDesempeneada) throws BaseException {
		this.tareaDesempeneada = aTareaDesempeneada;
	}	

	public Boolean isSeguiCartasDocu() throws BaseException {
		supportRefresh();
		return this.SeguiCartasDocu;
	}

	public void setSeguiLegales(Boolean aSeguiLegales) throws BaseException {
		this.seguiLegales = aSeguiLegales;
	}

	public void setSeguiCartasDocu(Boolean aSeguiCartasDocu) throws BaseException {
		this.SeguiCartasDocu = aSeguiCartasDocu;
	}

	public EstadoDesarrollo getEstadoDesarrollo() throws BaseException {
		supportRefresh();
		return this.estadoDesarrollo;
	}

	public GradoLegajo getGradoLegajo() throws BaseException {
		supportRefresh();
		return this.gradoLegajo;
	}

	public void setDireccion(String aDireccion) throws BaseException {
		this.direccion = aDireccion;
	}

	public void setEstadoDesarrollo(EstadoDesarrollo aEstadoDesarrollo) throws BaseException {
		this.estadoDesarrollo = aEstadoDesarrollo;
	}

	public void setGradoLegajo(GradoLegajo aGradoLegajo) throws BaseException {
		this.gradoLegajo = aGradoLegajo;
	}

	public java.util.Date getFecVencProteccion() throws BaseException {
		supportRefresh();
		return this.fecVencProteccion;
	}

	public void setFecVencProteccion(java.util.Date aFecVtoProteccion) throws BaseException {
		this.fecVencProteccion = aFecVtoProteccion;
	}

	public java.util.Date getIngresoUTE() throws BaseException {
		supportRefresh();
		return this.fecIngresoUTE;
	}

	public void setFecIngresoUTE(java.util.Date aFecIngresoUTE) throws BaseException {
		this.fecIngresoUTE = aFecIngresoUTE;
	}

	public MotivoEgresoEmp getMotivoEgresoEmp() throws BaseException {
		supportRefresh();
		return motivoEgreso;
	}

	public void setMotivoEgresoEmp(MotivoEgresoEmp aMotivoEgresoEmp) throws BaseException {
		this.motivoEgreso = aMotivoEgresoEmp;
	}

	public java.util.Date getFecAntReconocimiento() throws BaseException {
		supportRefresh();
		return fecAntReco;
	}

	public void setFecAntReconocimiento(java.util.Date aFecAntReconocimiento) throws BaseException {
		this.fecAntReco = aFecAntReconocimiento;
	}

	public ClaseSindicato getClaseSindicato() throws BaseException {
		supportRefresh();
		return claseSindicato;
	}

	public void setClaseSindicato(ClaseSindicato aClaseSindicato) throws BaseException {
		this.claseSindicato = aClaseSindicato;
	}

	public String getNroDocumento() throws BaseException {
		supportRefresh();
		return this.nroDocumento;
	}

	public void setNroDocumento(String aNroDocumento) throws BaseException {
		this.nroDocumento = aNroDocumento;
	}

	public String getTelefono() throws BaseException {
		supportRefresh();
		return this.telefono;
	}

	public void setTelefono(String aTelefono) throws BaseException {
		this.telefono = aTelefono;
	}

	public String getTelefonoCelular() throws BaseException {
		supportRefresh();
		return this.telefonoCelular;
	}

	public void setTelefonoCelular(String aTelefonoCelular) throws BaseException {
		this.telefonoCelular = aTelefonoCelular;
	}

	public EstadoCivil getEstadoCivil() throws BaseException {
		supportRefresh();
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil aEstadoCivil) throws BaseException {
		this.estadoCivil = aEstadoCivil;
	}

	public TipoDocumento getTipoDocumento() throws BaseException {
		supportRefresh();
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento aTipoDocumento) throws BaseException {
		this.tipoDocumento = aTipoDocumento;
	}

	public java.util.Date getFecNacimiento() throws BaseException {
		supportRefresh();
		return this.fecNacimiento;
	}

	public void setFecNacimiento(java.util.Date aFecNacimiento) throws BaseException {
		this.fecNacimiento = aFecNacimiento;
	}

	public String getCUIT() throws BaseException {
		supportRefresh();
		return cuit;
	}

	public void setCUIT(String aCUIT) throws BaseException {
		this.cuit = aCUIT;
	}

	public String getSEXO() throws BaseException {
		supportRefresh();
		return sexo;
	}

	public void setSexo(String aSexo) throws BaseException {
		this.sexo = aSexo;
	}

	public String getNro_legajo() throws BaseException {
		supportRefresh();
		return nro_legajo;
	}

	public boolean isLiberarIngAlPredio() throws BaseException {
		supportRefresh();
		return this.liberarIngAlPredio;
	}

	public boolean isProhibirAcceso() throws BaseException {
		supportRefresh();
		return this.prohibirAcceso;
	}

	public ZonaCIP getZonaActual() throws BaseException {
		supportRefresh();
		return this.zonaActual;
	}

	public void setNro_legajo(String aNro_legajo) {
		this.nro_legajo = aNro_legajo;
	}

	public void setProhibirAcceso(boolean aProhibirAcceso) {
		this.prohibirAcceso = aProhibirAcceso;
	}

	public void setLibIngAlPredio(boolean aLibIngAlPredio) {
		this.liberarIngAlPredio = aLibIngAlPredio;
	}

	public void setZonaActual(ZonaCIP aZonaActual) {
		this.zonaActual = aZonaActual;
	}

	public Boolean isIgnorarProxAntiPassBack() throws BaseException {
		supportRefresh();
		if (this.ignorarProxAntiPassBack == null)
			return false;
		else
			return this.ignorarProxAntiPassBack;
	}

	public void setIgnorarProxAntiPassBack(Boolean aIgnorarProxAntiPassBack) {
		this.ignorarProxAntiPassBack = aIgnorarProxAntiPassBack;
	}

	public Boolean isCircuitoCacheo() throws BaseException {
		supportRefresh();
		if (this.circuitoCacheo == null)
			return false;
		else
			return this.circuitoCacheo;
	}

	public void setCircuitoCacheo(Boolean aCircuitoCacheo) {
		this.circuitoCacheo = aCircuitoCacheo;
	}

	public Boolean isActivarAntiPassBack() throws BaseException {
		supportRefresh();
		return this.activarAntiPassBack;
	}

	public void setActivarAntiPassBack(Boolean aActivarAntiPassBack) {
		this.activarAntiPassBack = aActivarAntiPassBack;
	}

	public java.util.Date getFecUltPaso() throws BaseException {
		supportRefresh();
		return this.fecUltPaso;
	}

	public void setFecUltPaso(java.util.Date aFecUltPaso) {
		this.fecUltPaso = aFecUltPaso;
	}

	public String getHoraUltPaso() throws BaseException {
		supportRefresh();
		if (this.horaUtlPaso == null)
			return "00:00";
		else if ((this.horaUtlPaso.equals("") || (this.horaUtlPaso.equals("  :  "))))
			return "00:00";
		else
			return this.horaUtlPaso;
	}

	public void setHoraUltPaso(String aHoraUltPaso) {
		this.horaUtlPaso = aHoraUltPaso;
	}

	public String getSentidoPaso() throws BaseException {
		supportRefresh();
		return this.sentidoPaso;
	}

	public String getUltimoMovimiento() throws BaseException {
		supportRefresh();
		StringBuffer ultMov = new StringBuffer("");
		ultMov.append("Ult. Acceso Predio  ");
		if (this.getSentidoPaso() != null) {
			if (this.getSentidoPaso().equals("E"))
				ultMov.append("entrada ");
			else if (this.getSentidoPaso().equals("S"))
				ultMov.append("salida ");
		}
		if (this.getFecUltPaso() != null)
			ultMov.append(Fecha.getddmmyyyy(this.getFecUltPaso()) + " ");
		if (this.getHoraUltPaso() != null)
			ultMov.append(this.getHoraUltPaso());
		return ultMov.toString();
	}

	public void setSentidoPaso(String aSentidoPaso) {
		this.sentidoPaso = aSentidoPaso;
	}

	public PermisoSemanalCIP getPermisoSemanal() throws BaseException {
		supportRefresh();
		return this.permisoSemanal;
	}

	public void setPermisoSemanal(PermisoSemanalCIP aPermisoSemanal) {
		this.permisoSemanal = aPermisoSemanal;
	}

	public EstadoCIP getEstadoCIP() throws BaseException {
		supportRefresh();
		return this.estado;
	}

	public void setEstadoCIP(EstadoCIP aEstadoCIP) {
		this.estado = aEstadoCIP;
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

	public Integer getIDIdentificacion() throws BaseException {
		supportRefresh();
		return this.idIdentificacion;
	}

	public void setIDIdentificacion(Integer aIDIdentificacion) {
		this.idIdentificacion = aIDIdentificacion;
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

	public String getApellido() throws BaseException {
		supportRefresh();
		if (apellido == null)
			return "";
		else
			return apellido;
	}

	public void setApellido(String aApellido) {
		this.apellido = aApellido;
	}

	public String getNombre() throws BaseException {
		supportRefresh();
		if (nombre == null)
			return "";
		else
			return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
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

	public static Legajo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Legajo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Legajo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Legajo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Legajo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Legajo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(nro_legajo, "Debe ingresar el Nro. de Legajo");

		if ((apellido == null) && (nombre == null))
			throw new ExceptionValidation(null, "Debe ingresar el Nombre o el Apellido");

	}

	public ValorClasificadorEntidad getValorClasifEnt(ClasificadorEntidad clasifEnt) throws BaseException {
		ValorClasificadorEntidad valClasifEnt = null;
		Integer oidValClasifEnt = (Integer) listaOidValClasif.get(clasifEnt.getNroClasif());
		if (oidValClasifEnt != null)
			valClasifEnt = ValorClasificadorEntidad.findByOid(oidValClasifEnt, getSesion());
		return valClasifEnt;
	}

	public ValorClasificadorEntidad getValorClasifEntProxy(ClasificadorEntidad clasifEnt) throws BaseException {
		ValorClasificadorEntidad valClasifEnt = null;
		Integer oidValClasifEnt = (Integer) listaOidValClasif.get(clasifEnt.getNroClasif());
		if (oidValClasifEnt != null)
			valClasifEnt = ValorClasificadorEntidad.findByOidProxy(oidValClasifEnt, getSesion());
		return valClasifEnt;
	}

	public List getClasifEntidadesActivas() throws BaseException {
		if (readListaClasifEnt) {
			this.listaClasifEnt = ClasificadorEntidad.getClasificadoresEntidadActivos(Legajo.NICKNAME, true, getSesion());
			this.readListaClasifEnt = false;
		}
		return listaClasifEnt;
	}

	public List getHistoricoPuestos() throws BaseException {
		if (this.readListaHistPuestos) {
			this.listaHistPuestos = HistoricoPuesto.getHistoricoPuestos(this, getSesion());
			this.readListaHistPuestos = true;
		}
		return this.listaHistPuestos;
	}

	public List getSancionesLegajos() throws BaseException {
		if (this.readSanciones) {
			this.listaSanciones = SancionesLegajo.getSancionesLegajos(this, getSesion());
			this.readSanciones = true;
		}
		return this.listaSanciones;
	}

	public List getNovedades() throws BaseException {
		if (this.readNovedades) {
			this.novedades = NovedadLegajo.getNovedadesLegajo(this, getSesion());
			this.readNovedades = true;
		}
		return this.novedades;
	}

	public List getNegociaciones() throws BaseException {
		if (this.readNegociaciones) {
			this.negociaciones = NegociacionLegales.getNegociaciones(this, getSesion());
			this.readNegociaciones = true;
		}
		return this.negociaciones;
	}

	public List getPedidosMedicos() throws BaseException {
		if (this.readPedidosMed) {
			this.pedidosMedicos = ServicioMedicoRRHH.getServMedByLegajoPedMed(this, getSesion());
			this.readPedidosMed = true;
		}
		return this.pedidosMedicos;
	}

	public List getAtencionesMedicas() throws BaseException {
		if (this.readAtencionMedicas) {
			this.atencionMedidas = ServicioMedicoRRHH.getServMedByLegajoAteMed(this, getSesion());
			this.readAtencionMedicas = true;
		}
		return this.atencionMedidas;
	}

	public List getEnfermedadesFam() throws BaseException {
		if (this.readEnfermedadesFam) {
			this.enfermedadFam = ServicioMedicoRRHH.getServMedByLegajoEnfFam(this, getSesion());
			this.readEnfermedadesFam = true;
		}
		return this.enfermedadFam;
	}

	public List getAccidentesLaborales() throws BaseException {
		if (this.readAccidentesLaborales) {
			this.accidentesLaborales = ServicioMedicoRRHH.getServMedByLegajoAccLab(this, getSesion());
			this.readAccidentesLaborales = true;
		}
		return this.accidentesLaborales;
	}

	public List getCartasRemitidasLegales() throws BaseException {
		if (this.readCartasRemitidasLeg) {
			this.cartasRemitidasLeg = CartasDocRemLega.getCartasDocRemLega(this, getSesion());
			this.readCartasRemitidasLeg = true;
		}
		return this.cartasRemitidasLeg;
	}

	public List getSeclos() throws BaseException {
		if (this.readSeclos) {
			this.seclos = Seclo.getSeclosByLegajo(this, getSesion());
			this.readSeclos = true;
		}
		return this.seclos;
	}

	public List getCategPosibles() throws BaseException {
		if (this.readCategPosibles) {
			this.categPosibles = CategPosibleLeg.getCategPosibleLeg(this, getSesion());
			this.readCategPosibles = true;
		}
		return this.categPosibles;
	}

	public List getJuicios() throws BaseException {
		if (this.readJuicios) {
			this.juicios = Juicio.getJuicios(this, getSesion());
			this.readJuicios = true;
		}
		return this.juicios;
	}

	public List getObservaciones() throws BaseException {
		if (this.readObservaciones) {
			this.observaciones = ObsLegajo.getObsLegajo(this, getSesion());
			this.readObservaciones = true;
		}
		return this.observaciones;
	}

	public static List getClasificadoresEntidadActivos(ISesion aSesion) throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidad(Legajo.NICKNAME, true, aSesion);
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

	public List getTarjetasLegajo() throws BaseException {
		return DBTarjetaLegajo.getTarjetasLegajo(this, this.getSesion());
	}

	public List getTarjetasLegajoActivas() throws BaseException {
		if (this.readTarjetasLegajo) {
			List listaTarjetasLegajo = TarjetaLegajo.getTarjetasLegajo(this, getSesion());
			this.tarjetasLegajo.addAll(listaTarjetasLegajo);
			this.readTarjetasLegajo = false;
		}
		return tarjetasLegajo;
	}

	public List getMotivosAccesosIntermedios() throws BaseException {
		if (this.readMotivosAccesosInter) {
			List listaMotAccInter = MotEntInterLeg.getMotivosLegajo(this, getSesion());
			this.motivosAccesosInter.addAll(listaMotAccInter);
			this.readMotivosAccesosInter = false;
		}
		return motivosAccesosInter;
	}

	public List getCategAccesosInternos() throws BaseException {
		if (this.readCategAccesosInternos) {
			List listaCategAccesosInternos = CategAccesoLegajo.getCategAccesosLegajo(this, getSesion());
			this.categAccesosInternos.addAll(listaCategAccesosInternos);
			this.readCategAccesosInternos = false;
		}
		return categAccesosInternos;
	}

	public void addTarjetaLegajo(TarjetaLegajo aTarjetaLegajo) throws BaseException {
		aTarjetaLegajo.setLegajo(this);
		this.tarjetasLegajo.add(aTarjetaLegajo);
	}

	public void addObservaciones(ObsLegajo aObsLegajo) throws BaseException {
		aObsLegajo.setLegajo(this);
		this.observaciones.add(aObsLegajo);
	}

	public void addJuicio(Juicio aJuicio) throws BaseException {
		aJuicio.setLegajo(this);
		this.juicios.add(aJuicio);
	}

	public void addCategPosibleLeg(CategPosibleLeg aCategPosibleLeg) throws BaseException {
		aCategPosibleLeg.setLegajo(this);
		this.categPosibles.add(aCategPosibleLeg);
	}

	public void addNegociacion(NegociacionLegales aNegociacionLegales) throws BaseException {
		aNegociacionLegales.setLegajo(this);
		this.negociaciones.add(aNegociacionLegales);
	}

	public void addCartasDocRemLeg(CartasDocRemLega aCartasDocRemLega) throws BaseException {
		aCartasDocRemLega.setLegajo(this);
		this.cartasRemitidasLeg.add(aCartasDocRemLega);
	}

	public void addSeclo(Seclo aSeclo) throws BaseException {
		aSeclo.setLegajo(this);
		this.seclos.add(aSeclo);
	}

	public void addSancionLegajo(SancionesLegajo aSancionesLegajo) throws BaseException {
		aSancionesLegajo.setLegajo(this);
		this.listaSanciones.add(aSancionesLegajo);
	}

	public void addHistPuesto(HistoricoPuesto aHistoricoPuesto) throws BaseException {
		aHistoricoPuesto.setLegajo(this);
		this.listaHistPuestos.add(aHistoricoPuesto);
	}

	public void addCategoriaAccesoInterno(CategAccesoLegajo aCategAccesoLegajo) throws BaseException {
		aCategAccesoLegajo.setLegajo(this);
		this.categAccesosInternos.add(aCategAccesoLegajo);
	}

	public void addNovedadLegajo(NovedadLegajo aNovedadLegajo) throws BaseException {
		aNovedadLegajo.setOid_legajo(this);
		this.novedades.add(aNovedadLegajo);
	}

	public void addMotivoAccesoInter(MotEntInterLeg aMotEntInterLeg) throws BaseException {
		aMotEntInterLeg.setLegajo(this);
		this.motivosAccesosInter.add(aMotEntInterLeg);
	}

	public void addPedidoMedico(ServicioMedicoRRHH aServicioMedicoRRHH) throws BaseException {
		aServicioMedicoRRHH.setLegajo(this);
		this.pedidosMedicos.add(aServicioMedicoRRHH);
	}

	public void addAtencionMedica(ServicioMedicoRRHH aServicioMedicoRRHH) throws BaseException {
		aServicioMedicoRRHH.setLegajo(this);
		this.atencionMedidas.add(aServicioMedicoRRHH);
	}

	public void addAccidenteLaboral(ServicioMedicoRRHH aServicioMedicoRRHH) throws BaseException {
		aServicioMedicoRRHH.setLegajo(this);
		this.accidentesLaborales.add(aServicioMedicoRRHH);
	}

	public void addEnfermedadFamiliar(ServicioMedicoRRHH aServicioMedicoRRHH) throws BaseException {
		aServicioMedicoRRHH.setLegajo(this);
		this.enfermedadFam.add(aServicioMedicoRRHH);
	}

	public void addPlanifDiaRota(LegajoRotaFecha aLegajoRotaFecha) throws BaseException {
		aLegajoRotaFecha.setLegajo(this);
		this.planifDiaRota.add(aLegajoRotaFecha);
	}

	public void afterSave() throws BaseException {

		Iterator iterTarjetasLegajo = this.tarjetasLegajo.iterator();
		while (iterTarjetasLegajo.hasNext()) {
			TarjetaLegajo tarjetaLegajo = (TarjetaLegajo) iterTarjetasLegajo.next();
			tarjetaLegajo.save();
			tarjetaLegajo = null;
		}
		iterTarjetasLegajo = null;

		Iterator iterMotAccInter = this.motivosAccesosInter.iterator();
		while (iterMotAccInter.hasNext()) {
			MotEntInterLeg motEntInterLeg = (MotEntInterLeg) iterMotAccInter.next();
			motEntInterLeg.save();
			motEntInterLeg = null;
		}
		iterMotAccInter = null;

		Iterator iterCategAccInternos = this.categAccesosInternos.iterator();
		while (iterCategAccInternos.hasNext()) {
			CategAccesoLegajo categAccesoLegajo = (CategAccesoLegajo) iterCategAccInternos.next();
			categAccesoLegajo.save();
			categAccesoLegajo = null;
		}
		iterCategAccInternos = null;

		Iterator iterPlanifDiaRota = this.planifDiaRota.iterator();
		while (iterPlanifDiaRota.hasNext()) {
			LegajoRotaFecha legRotFec = (LegajoRotaFecha) iterPlanifDiaRota.next();
			legRotFec.save();
			legRotFec = null;
		}
		iterPlanifDiaRota = null;

		Iterator iterHistPuestos = this.listaHistPuestos.iterator();
		while (iterHistPuestos.hasNext()) {
			HistoricoPuesto historicoPuesto = (HistoricoPuesto) iterHistPuestos.next();
			historicoPuesto.save();
			historicoPuesto = null;
		}
		iterHistPuestos = null;

		Iterator iterSanciones = this.listaSanciones.iterator();
		while (iterSanciones.hasNext()) {
			SancionesLegajo sancionLegajo = (SancionesLegajo) iterSanciones.next();
			sancionLegajo.save();
			sancionLegajo = null;
		}
		iterSanciones = null;

		Iterator iterPedMed = this.pedidosMedicos.iterator();
		while (iterPedMed.hasNext()) {
			ServicioMedicoRRHH servMedRRHH = (ServicioMedicoRRHH) iterPedMed.next();
			servMedRRHH.save();
			servMedRRHH = null;
		}
		iterPedMed = null;

		Iterator iterAteMed = this.atencionMedidas.iterator();
		while (iterAteMed.hasNext()) {
			ServicioMedicoRRHH servMedRRHH = (ServicioMedicoRRHH) iterAteMed.next();
			servMedRRHH.save();
			servMedRRHH = null;
		}
		iterAteMed = null;

		Iterator iterEnfFam = this.enfermedadFam.iterator();
		while (iterEnfFam.hasNext()) {
			ServicioMedicoRRHH servMedRRHH = (ServicioMedicoRRHH) iterEnfFam.next();
			servMedRRHH.save();
			servMedRRHH = null;
		}
		iterEnfFam = null;

		Iterator iterAccLab = this.accidentesLaborales.iterator();
		while (iterAccLab.hasNext()) {
			ServicioMedicoRRHH servMedRRHH = (ServicioMedicoRRHH) iterAccLab.next();
			servMedRRHH.save();
			servMedRRHH = null;
		}
		iterEnfFam = null;

		Iterator iterDocuRemiLegales = this.cartasRemitidasLeg.iterator();
		while (iterDocuRemiLegales.hasNext()) {
			CartasDocRemLega cartasDocRemLega = (CartasDocRemLega) iterDocuRemiLegales.next();
			cartasDocRemLega.save();
			cartasDocRemLega = null;
		}
		iterDocuRemiLegales = null;

		Iterator iterSeclos = this.seclos.iterator();
		while (iterSeclos.hasNext()) {
			Seclo seclo = (Seclo) iterSeclos.next();
			seclo.save();
			seclo = null;
		}
		iterSeclos = null;

		Iterator iterNovedades = this.novedades.iterator();
		while (iterNovedades.hasNext()) {
			NovedadLegajo novedadLegajo = (NovedadLegajo) iterNovedades.next();
			novedadLegajo.save();
			novedadLegajo = null;
		}
		iterNovedades = null;

		Iterator iterNegociaciones = this.negociaciones.iterator();
		while (iterNegociaciones.hasNext()) {
			NegociacionLegales negociacionLegales = (NegociacionLegales) iterNegociaciones.next();
			negociacionLegales.save();
			negociacionLegales = null;
		}
		iterNegociaciones = null;

		Iterator iterCategPosibles = this.categPosibles.iterator();
		while (iterCategPosibles.hasNext()) {
			CategPosibleLeg categPosLeg = (CategPosibleLeg) iterCategPosibles.next();
			categPosLeg.save();
			categPosLeg = null;
		}
		iterCategPosibles = null;

		Iterator iterJuicios = this.juicios.iterator();
		while (iterJuicios.hasNext()) {
			Juicio juicio = (Juicio) iterJuicios.next();
			juicio.save();
			juicio = null;
		}
		iterJuicios = null;

		Iterator iterObservaciones = this.observaciones.iterator();
		while (iterObservaciones.hasNext()) {
			ObsLegajo obsLegajo = (ObsLegajo) iterObservaciones.next();
			obsLegajo.save();
			obsLegajo = null;
		}
		iterObservaciones = null;

	}

	public static List getLegajosByCondiciones(List listaLegajos, List valoresClasificadores, ISesion aSesion) throws BaseException {
		return DBLegajo.getLegajosByCondiciones(listaLegajos, valoresClasificadores, aSesion);
	}

	public static List getAllLegajos(ISesion aSesion) throws BaseException {
		return DBLegajo.getAllLegajos(aSesion);
	}

	public static String getPathImagenesLegajo(ISesion aSesion) throws BaseException {
		ValorParametro valorPathImagenesLeg = ValorParametro.findByCodigoParametro("PATH_IMAGENES_LEGAJO", aSesion);
		return valorPathImagenesLeg.getValorCadena();
	}

	public static String getExtensionImagenLegajo(ISesion aSesion) throws BaseException {
		try {
			ValorParametro valorPathImagenesLeg = ValorParametro.findByCodigoParametro("EXT_IMAGEN_LEG", aSesion);
			return valorPathImagenesLeg.getValorCadena();
		} catch (Exception e) {
			return "";
		}
	}

	public LegajoRotaFecha getLegajoRotaFecha(java.util.Date fecha) throws BaseException {
		return LegajoRotaFecha.getLegajoRotaFecha(this, fecha, this.getSesion());
	}

	public String getDescPuntoAcceso() throws BaseException {

		if ((this.getGrupoPuertaIngreso() != null) && (this.getGrupoPuertaEgreso() != null)) {

			if (this.getGrupoPuertaIngreso().getOID() == this.getGrupoPuertaEgreso().getOID())
				return this.getGrupoPuertaIngreso().getDescripcion();
			else
				return this.getGrupoPuertaIngreso().getDescripcion() + "-" + this.getGrupoPuertaEgreso().getDescripcion();

		} else {

			if ((this.getGrupoPuertaIngreso() != null) && (this.getGrupoPuertaEgreso() == null))
				return this.getGrupoPuertaIngreso().getDescripcion();
			else if ((this.getGrupoPuertaIngreso() == null) && (this.getGrupoPuertaEgreso() != null))
				return this.getGrupoPuertaEgreso().getDescripcion();
			else
				return "";

		}

	}

	public static Legajo getLegajoByIdentificacion(Integer identificacion, ISesion aSesion) throws BaseException {
		return DBLegajo.getLegajoByIdentificacion(identificacion, aSesion);
	}

	public static List getAllLegajosActivosConIdentif(ISesion aSesion) throws BaseException {
		return DBLegajo.getAllLegajosActivosConIdentif(aSesion);
	}

	public static Legajo getLegajoPaseAutoriz(ISesion aSesion) throws BaseException {
		Integer oidLegajo = ValorParametro.findByCodigoParametro("LEG_GEN_HAB_ES", aSesion).getOidObjNeg();
		Legajo legajo = Legajo.findByOid(oidLegajo, aSesion);
		return legajo;
	}

	public Integer getMediaEntrada(Puerta puerta) throws BaseException {
		try {
			if (puerta.getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.IDENTIF_LEGAJO))
				return this.getIDIdentificacion();
			else if (puerta.getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) {
				TarjetaLegajo tarjetaLegajo = getTarjetaLegajoOrden1();
				if (tarjetaLegajo != null)
					return new Integer(tarjetaLegajo.getNro_tarjeta());
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public Integer getMediaSalida(Puerta puerta) throws BaseException {
		try {
			if (puerta.getIdentifLegSal().equals(IdentificadoresDeLegajosCIP.IDENTIF_LEGAJO))
				return this.getIDIdentificacion();
			else if (puerta.getIdentifLegSal().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) {
				TarjetaLegajo tarjetaLegajo = getTarjetaLegajoOrden1();
				if (tarjetaLegajo != null)
					return new Integer(tarjetaLegajo.getNro_tarjeta());
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public TarjetaLegajo getTarjetaLegajoOrden1() throws BaseException {
		return DBTarjetaLegajo.getTarjetaLegajo(this, this.getSesion());
	}

	public boolean isParaCacheoEntrada(Puerta puerta, java.util.Date fecha, boolean marcarIntentoDePaso) throws BaseException {

		// Buscar si tiene un cacheo pendiente
		Cacheo cacheo = Cacheo.getCacheoPend(this.getOIDInteger(), fecha, "E", this.getSesion());

		if (cacheo == null)
			return false;

		// Obtener el dia de la semana
		int diaSemana = Fecha.getDiaSemana(fecha);

		// Obtener la planificacion de la semana
		PlanifDiaCacheo planifDiaCacheo = PlanifDiaCacheo.getPlanifDiaCacheo(this.getSesion());
		if (planifDiaCacheo == null)
			return false;

		GrupoPuerta grupoPuerta = null;
		if (diaSemana == 1)
			grupoPuerta = planifDiaCacheo.getDomingo_entrada();
		else if (diaSemana == 2)
			grupoPuerta = planifDiaCacheo.getLunes_entrada();
		else if (diaSemana == 3)
			grupoPuerta = planifDiaCacheo.getMartes_entrada();
		else if (diaSemana == 4)
			grupoPuerta = planifDiaCacheo.getMiercoles_entrada();
		else if (diaSemana == 5)
			grupoPuerta = planifDiaCacheo.getJueves_entrada();
		else if (diaSemana == 6)
			grupoPuerta = planifDiaCacheo.getViernes_entrada();
		else if (diaSemana == 7)
			grupoPuerta = planifDiaCacheo.getSabado_entrada();

		if (grupoPuerta == null)
			return false;

		GrupoPuertaDet grupoPuertaDet = grupoPuerta.getGrupoPuertaDet(puerta);

		if (grupoPuertaDet != null) {
			if (marcarIntentoDePaso)
				cacheo.marcarIntentoDePaso();
			return true;
		} else
			return false;
	}

	public boolean isParaCacheoSalida(Puerta puerta, java.util.Date fecha, boolean marcarIntentoDePaso) throws BaseException {

		// Buscar si tiene un cacheo pendiente
		Cacheo cacheo = Cacheo.getCacheoPend(this.getOIDInteger(), fecha, "S", this.getSesion());

		// Si no hay cacheo devolver false
		if (cacheo == null)
			return false;

		// Verifica que la puerta coincida con la habilitada para el cacheo
		GrupoPuertaDet grupoPuertaDet = cacheo.getGrupoPuerta().getGrupoPuertaDet(puerta);

		if (grupoPuertaDet == null)
			return false;

		// Obtener el dia de la semana
		int diaSemana = Fecha.getDiaSemana(fecha);

		// Obtener la planificacion de la semana
		PlanifDiaCacheo planifDiaCacheo = PlanifDiaCacheo.getPlanifDiaCacheo(this.getSesion());
		if (planifDiaCacheo == null)
			return false;

		GrupoPuerta grupoPuerta = null;
		if (diaSemana == 1)
			grupoPuerta = planifDiaCacheo.getDomingo_salida();
		else if (diaSemana == 2)
			grupoPuerta = planifDiaCacheo.getLunes_salida();
		else if (diaSemana == 3)
			grupoPuerta = planifDiaCacheo.getMartes_salida();
		else if (diaSemana == 4)
			grupoPuerta = planifDiaCacheo.getMiercoles_salida();
		else if (diaSemana == 5)
			grupoPuerta = planifDiaCacheo.getJueves_salida();
		else if (diaSemana == 6)
			grupoPuerta = planifDiaCacheo.getViermes_salida();
		else if (diaSemana == 7)
			grupoPuerta = planifDiaCacheo.getSabado_salida();

		if (grupoPuerta == null)
			return false;

		GrupoPuertaDet grupoPuertaCacheo = grupoPuerta.getGrupoPuertaDet(puerta);

		if (grupoPuertaCacheo != null) {
			if (marcarIntentoDePaso)
				cacheo.marcarIntentoDePaso();
			return true;
		} else
			return false;
	}

	public List getMotivosEntIntermediasLegajo() throws BaseException {
		return DBMotEntInterLeg.getMotivosLegajo(this, this.getSesion());
	}

	public List getMotEntInterSegunLegajo(Rota rota) throws BaseException {
		return MotivoEntradasInterRota.getMotEntInterSegunLegajo(rota, this, this.getSesion());
	}

	public List getLegajoRotaFechasMayoIgual(java.util.Date fecha) throws BaseException {
		return LegajoRotaFecha.getLegajoMayIgualFecha(fecha, this, this.getSesion());
	}

	public boolean isTieneMotivoEntIntermedia(MotivoEntIntermedias motivo) throws BaseException {
		MotivoEntIntermedias motivoEntIntermedias = (MotivoEntIntermedias) MotivoEntIntermedias.getMotivoEntIntermedia(this, motivo, this.getSesion());
		if (motivoEntIntermedias != null)
			return true;
		else
			return false;
	}

	public boolean puedeIngresarEntIntermedias(java.util.Date fecHorActual, PermisoSemanalCIP permisoSemanal, java.util.Date fecha) throws BaseException {

		String diaSemana = MotEntInterPlanifS.getDiaSemana(Fecha.getDia(fecha));

		Iterator iterMotEntInterPlanifS = MotEntInterPlanifS.getMotEntInterPlanifS(permisoSemanal, diaSemana, this.getSesion()).iterator();
		while (iterMotEntInterPlanifS.hasNext()) {
			MotEntInterPlanifS motEntInterPlanifS = (MotEntInterPlanifS) iterMotEntInterPlanifS.next();

			int HorasDesde = UtilCIP.getParteHoraEnHoras(motEntInterPlanifS.getHorario_desde());
			int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(motEntInterPlanifS.getHorario_desde());
			int cantMinutosHorDesde = UtilCIP.getHoraEnMin(motEntInterPlanifS.getHorario_desde());

			Calendar calFecHorDesde = GregorianCalendar.getInstance();
			calFecHorDesde.setTime(fecha); // set cal to date
			calFecHorDesde.add(Calendar.HOUR, HorasDesde);
			calFecHorDesde.add(Calendar.MINUTE, MinutosDesde);
			java.util.Date fecHorDesde = calFecHorDesde.getTime();

			int HorasHasta = UtilCIP.getParteHoraEnHoras(motEntInterPlanifS.getHorario_hasta());
			int MinutosHasta = UtilCIP.getParteMinutosEnMinutos(motEntInterPlanifS.getHorario_hasta());
			int cantMinutosHorHasta = UtilCIP.getHoraEnMin(motEntInterPlanifS.getHorario_hasta());

			Calendar calFecHorHasta = GregorianCalendar.getInstance();
			if (cantMinutosHorHasta < cantMinutosHorDesde)
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
					if (isTieneMotivoEntIntermedia(motEntInterPlanifS.getMotivo()))
						return true;
				}
			}
		}
		return false;

	}

	public String getFecHorUltEntSalPredio() throws BaseException {
		StringBuffer cond = new StringBuffer("");
		if (this.getFecUltPaso() != null)
			cond.append(Fecha.getddmmyyyy(this.getFecUltPaso()) + " " + this.getHoraUltPaso() + " ");
		if (this.getSentidoPaso() != null) {
			if (this.getSentidoPaso().equals("E"))
				cond.append("Entrada");
			else
				cond.append("Salida");
		}
		return cond.toString();
	}

	public static List getLegajosEnPredio(ISesion aSesion) throws BaseException {
		return DBLegajo.getLegajosEnPredio(aSesion);
	}

	public static List getLegajosEvalRRHH(List legajos, List empresas, List sectores, List puestos, List estados, ISesion aSesion) throws BaseException {
		return DBLegajo.getLegajosEvalRRHH(legajos, empresas, sectores, puestos, estados, aSesion);
	}

	public List getEvaluacionesByLegajo() throws BaseException {
		return DBEvaluacionLegajoCab.getEvaluacionesByLegajo(this, this.getSesion());
	}

	public CategPosibleLeg getCategoriaPosible(java.util.Date aFecha) throws BaseException {
		return CategPosibleLeg.getCategPosibleLeg(this, aFecha, this.getSesion());
	}

	public static java.util.Date getFecHastaPeriEval(int anio, String mes) throws BaseException {

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

	public RankearCab getRankeador(AccCronoDesa accion, int anio, String mes) throws BaseException {

		RankearCab rankear = null;

		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());

		if ((clasifEmpresa == null) || (clasifSector == null) || (clasifPuesto == null))
			return null;

		ValorClasificadorEntidad valorEmpresa = this.getValorClasifEnt(clasifEmpresa);
		ValorClasificadorEntidad valorSector = this.getValorClasifEnt(clasifSector);
		ValorClasificadorEntidad valorPuesto = this.getValorClasifEnt(clasifPuesto);

		java.util.Date fecHastaPeriAEval = getFecHastaPeriEval(anio, mes);

		// Obtener el rankeador si es que el legajo lo tiene asignado
		// directamente
		CategPosibleLeg categPosibleLeg = CategPosibleLeg.getCategPosibleLeg(this, fecHastaPeriAEval, this.getSesion());
		if (categPosibleLeg != null) {
			rankear = categPosibleLeg.getRankearCab();
		}

		if (rankear == null) {
			// Buscar por jerarquia
			if ((valorEmpresa != null) && (valorSector != null) && (valorPuesto != null)) {
				JerarquiaDesa jerarquiaDesa = JerarquiaDesa.getJerarquiaDesa(accion, valorEmpresa, valorSector, valorPuesto, this.getSesion());
				if (jerarquiaDesa != null)
					rankear = jerarquiaDesa.getRankearCab();
			}
		}

		if (rankear == null)
			rankear = accion.getRankear();

		return rankear;

	}

	public int getRankingDesarrollo(ListaDesgloseCalifGral listaDesgloseCalifGral, CantSancionesPorTitu cantSancionesPorTitu, MotivosNoAprob motivosNoAprob, AccCronoDesa accion, int anio, String mes,
			Boolean pendEvalSiFaltaDesemp, Boolean pendEvalSinJuegos, Integer mesesHoriCarrera, Integer antEnSector) throws BaseException {

		this.supportRefresh();

		// Obtener el Rankeador
		RankearCab rankearCab = null;

		// Obtener los clasificadores de Empresa / Sector y Puesto
		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());

		if ((clasifEmpresa == null) || (clasifSector == null) || (clasifPuesto == null))
			return 0;

		ValorClasificadorEntidad valorEmpresa = this.getValorClasifEnt(clasifEmpresa);
		ValorClasificadorEntidad valorSector = this.getValorClasifEnt(clasifSector);
		ValorClasificadorEntidad valorPuesto = this.getValorClasifEnt(clasifPuesto);

		ValorClasificadorEntidad valorCategPosible = null;

		java.util.Date fecHastaPeriAEval = getFecHastaPeriEval(anio, mes);

		// Obtener el rankeador si es que el legajo lo tiene asignado
		// directamente
		CategPosibleLeg categPosibleLeg = CategPosibleLeg.getCategPosibleLeg(this, fecHastaPeriAEval, this.getSesion());
		if (categPosibleLeg != null) {
			rankearCab = categPosibleLeg.getRankearCab();
			valorCategPosible = categPosibleLeg.getCateg_posible();
		}

		// Obtener la Jerarquia de desarrollo
		JerarquiaDesa jerarquiaDesa = null;
		if ((valorEmpresa != null) && (valorSector != null) && (valorPuesto != null))
			jerarquiaDesa = JerarquiaDesa.getJerarquiaDesa(accion, valorEmpresa, valorSector, valorPuesto, this.getSesion());
		if (jerarquiaDesa != null) {
			if (rankearCab == null)
				rankearCab = jerarquiaDesa.getRankearCab();
			if (valorCategPosible == null)
				valorCategPosible = jerarquiaDesa.getCategPosible();
		}

		if (rankearCab == null)
			rankearCab = accion.getRankear();

		if (rankearCab == null)
			return 0;

		CalculadorMoney totPuntos = new CalculadorMoney(new Money(0));

		// Comenzar a calcular el RANKING
		RankItemDesarrollo rankItemAntEmp = null;
		RankItemDesarrollo rankItemAntPue = null;
		RankItemDesarrollo rankItemEval = null;

		List listaItemsRank = new ArrayList();

		if ((rankearCab.isControlarEstadoDesa() != null) && (rankearCab.isControlarEstadoDesa())) {

			if ((this.getEstadoDesarrollo() != null) && (this.getEstadoDesarrollo().isNo_promocionar())) {

				motivosNoAprob.setNoAprobado(true);
				motivosNoAprob.addMotivoDesaprobacion("Legajo en estado no promocionable. (!)", motivosNoAprob.getKEY_MOT_Estado_No_Promocionable());

			}

		}

		if (rankearCab.isAplicHoriCarrera()) {

			Integer difEnMesesHC = new Integer(0);
			if ((mesesHoriCarrera != null) && (antEnSector != null)) {
				difEnMesesHC = mesesHoriCarrera - antEnSector;
				if (difEnMesesHC.intValue() > 0) {
					// motivosNoAprob.setNoAprobado(true);
					motivosNoAprob.addMotivoInformativo("No cumple el Horizonte de carrera faltan " + difEnMesesHC + " meses. (I)", motivosNoAprob.getKEY_MOT_No_Cumple_Hor_Carrera());
					// motivosNoAprob.addMotivoDesaprobacion("No cumple el Horizonte de carrera faltan "+difEnMesesHC+
					// " meses" ,
					// motivosNoAprob.getKEY_MOT_No_Cumple_Hor_Carrera());
				}
			}

		}

		if (rankearCab.isCm_ant_req_emp())
			analizarCondMinAntEmp(motivosNoAprob, rankearCab, fecHastaPeriAEval);

		if (rankearCab.isCm_aplic_nov_6()) {
			analizarCondMinSan(6, cantSancionesPorTitu, motivosNoAprob, rankearCab, fecHastaPeriAEval);
		}
		if (rankearCab.isCm_aplic_nov_7()) {
			analizarCondMinSan(7, cantSancionesPorTitu, motivosNoAprob, rankearCab, fecHastaPeriAEval);
		}

		if (rankearCab.isCm_aplic_nov_8()) {
			analizarCondMinSan(8, cantSancionesPorTitu, motivosNoAprob, rankearCab, fecHastaPeriAEval);
		}

		if (rankearCab.isCm_aplic_nov_9()) {
			analizarCondMinSan(9, cantSancionesPorTitu, motivosNoAprob, rankearCab, fecHastaPeriAEval);
		}

		if (rankearCab.isCm_aplic_nov_10()) {
			analizarCondMinSan(10, cantSancionesPorTitu, motivosNoAprob, rankearCab, fecHastaPeriAEval);
		}

		if (rankearCab.isCm_aplic_nov_1()) {
			analizarCondMinNov(1, cantSancionesPorTitu, motivosNoAprob, rankearCab, fecHastaPeriAEval);
		}

		if (rankearCab.isCm_aplic_nov_2()) {
			analizarCondMinNov(2, cantSancionesPorTitu, motivosNoAprob, rankearCab, fecHastaPeriAEval);
		}

		if (rankearCab.isCm_aplic_nov_3()) {
			analizarCondMinNov(3, cantSancionesPorTitu, motivosNoAprob, rankearCab, fecHastaPeriAEval);
		}

		if (rankearCab.isCm_aplic_nov_4()) {
			analizarCondMinNov(4, cantSancionesPorTitu, motivosNoAprob, rankearCab, fecHastaPeriAEval);
		}

		if (rankearCab.isCm_aplic_nov_5()) {
			analizarCondMinNov(5, cantSancionesPorTitu, motivosNoAprob, rankearCab, fecHastaPeriAEval);
		}

		if (rankearCab.isCm_ant_req_pue())
			analizarCondMinAntPue(jerarquiaDesa, motivosNoAprob, rankearCab, fecHastaPeriAEval);

		if (rankearCab.isCm_aplicar_eval())
			analizarPuntajeMinEval(jerarquiaDesa, motivosNoAprob, rankearCab, fecHastaPeriAEval);

		if (rankearCab.isAplicCMJuegosA()) {
			analizarCantJuegosA(jerarquiaDesa, motivosNoAprob, pendEvalSinJuegos);
		}

		if (rankearCab.isRank_por_ant_emp()) {
			rankItemAntEmp = getTotPuntosAntEmpresa(listaDesgloseCalifGral, motivosNoAprob, fecHastaPeriAEval, rankearCab);
			listaItemsRank.add(rankItemAntEmp);
		}

		if (rankearCab.isRank_por_ant_pue()) {
			rankItemAntPue = getTotPuntosAntPuesto(listaDesgloseCalifGral, motivosNoAprob, fecHastaPeriAEval, rankearCab);
			listaItemsRank.add(rankItemAntPue);
		}

		if (rankearCab.isRank_por_eval()) {
			rankItemEval = getTotPuntosEvaluacion(listaDesgloseCalifGral, motivosNoAprob, fecHastaPeriAEval, rankearCab, pendEvalSiFaltaDesemp);
			listaItemsRank.add(rankItemEval);
		}

		if (rankearCab.isRank_por_novedad()) {
			List listaItems = getTotPuntosNovedad(listaDesgloseCalifGral, motivosNoAprob, fecHastaPeriAEval, rankearCab);
			Iterator iterListaItems = listaItems.iterator();
			while (iterListaItems.hasNext()) {
				RankItemDesarrollo rankItemDesarrollo = (RankItemDesarrollo) iterListaItems.next();
				listaItemsRank.add(rankItemDesarrollo);
			}
		}

		if (rankearCab.isRankearPorSancion()) {
			List listaItems = getTotPuntosSanciones(listaDesgloseCalifGral, motivosNoAprob, fecHastaPeriAEval, rankearCab);
			Iterator iterListaItems = listaItems.iterator();
			while (iterListaItems.hasNext()) {
				RankItemDesarrollo rankItemDesarrollo = (RankItemDesarrollo) iterListaItems.next();
				listaItemsRank.add(rankItemDesarrollo);
			}
		}

		// Iterar por los items Rankeadores
		HashTableDatos controlDupliItems = new HashTableDatos();
		Iterator iterListaItemsRank = listaItemsRank.iterator();
		while (iterListaItemsRank.hasNext()) {
			RankItemDesarrollo rankItemDesarrollo = (RankItemDesarrollo) iterListaItemsRank.next();
			/*
			 * Double ponderacion = new
			 * Double(rankItemDesarrollo.getPonderacion().doubleValue(2)); if
			 * (!controlDupliItems.containsKey(ponderacion.toString())) {
			 * totPondDist.sumar(rankItemDesarrollo.getPonderacion());
			 * controlDupliItems.put(ponderacion.toString(), ""); }
			 */
			totPuntos.sumar(rankItemDesarrollo.getTotPuntXPond());
		}

		// Calcular el total del puntaje
		CalculadorMoney puntajePond = new CalculadorMoney(totPuntos.getResultMoney());
		puntajePond.dividirPor(new Money(100));

		// Redondear y pasarlo a entero
		if (puntajePond.getResult() >= 0)
			puntajePond.sumar(new Money(0.5));
		else
			puntajePond.restar(new Money(0.5));

		int califGeneral = (int) puntajePond.getResultMoney().doubleValue(2);

		if (rankearCab.isAplicClasifGral()) {

			Money califGralMin = rankearCab.getPtosMinCalifGral();

			if ((jerarquiaDesa != null) && (jerarquiaDesa.getPuntosMinCalifGen() != null) && (jerarquiaDesa.getPuntosMinCalifGen().doubleValue() != 0)) {

				califGralMin = jerarquiaDesa.getPuntosMinCalifGen();
			}

			if ((califGralMin != null) && (califGralMin.doubleValue() != 0) && (califGeneral < califGralMin.doubleValue())) {
				// motivosNoAprob.setNoAprobado(true);

				motivosNoAprob.addMotivoInformativo("No cumple la calificación general mínima de " + califGralMin.doubleValue() + " (I)", motivosNoAprob.getKEY_MOT_Clasif_Gral_Min());

				/*
				 * motivosNoAprob.addMotivoDesaprobacion(
				 * "No cumple la calificaciin general minima de " +
				 * califGralMin.doubleValue(),
				 * motivosNoAprob.getKEY_MOT_Clasif_Gral_Min());
				 */

			}

		}

		return califGeneral;

	}

	public java.util.Date getFecAntParaDesa() throws BaseException {

		java.util.Date fecMasAnt = null;
		fecMasAnt = this.getFecIngreso();
		if (fecMasAnt == null)
			fecMasAnt = this.getIngresoUTE();
		else {
			if (this.getIngresoUTE() != null) {
				if (this.getIngresoUTE().before(fecMasAnt))
					fecMasAnt = this.getIngresoUTE();
			}
		}
		if (fecMasAnt == null)
			fecMasAnt = this.getFecAntReconocimiento();

		return fecMasAnt;
	}

	public void analizarCondMinSan(Integer nroNovedad, CantSancionesPorTitu cantSancionesPorTitu, MotivosNoAprob motivosNoAprob, RankearCab rankearCab, java.util.Date fecHastaEval)
			throws BaseException {

		Integer ultMeses = new Integer(0);
		Integer cantMin = new Integer(0);
		String motivo = "";

		if (nroNovedad.intValue() == 6) {
			ultMeses = rankearCab.getCm_ult_mes_nov_6();
			cantMin = rankearCab.getCm_dias_nov_6();
			motivo = rankearCab.getCm_motivos_6();
		} else if (nroNovedad.intValue() == 7) {
			ultMeses = rankearCab.getCm_ult_mes_nov_7();
			cantMin = rankearCab.getCm_dias_nov_7();
			motivo = rankearCab.getCm_motivos_7();
		} else if (nroNovedad.intValue() == 8) {
			ultMeses = rankearCab.getCm_ult_mes_nov_8();
			cantMin = rankearCab.getCm_dias_nov_8();
			motivo = rankearCab.getCm_motivos_8();
		} else if (nroNovedad.intValue() == 9) {
			ultMeses = rankearCab.getCm_ult_mes_nov_9();
			cantMin = rankearCab.getCm_dias_nov_9();
			motivo = rankearCab.getCm_motivos_9();
		} else if (nroNovedad.intValue() == 10) {
			ultMeses = rankearCab.getCm_ult_mes_nov_10();
			cantMin = rankearCab.getCm_dias_nov_10();
			motivo = rankearCab.getCm_motivos_10();
		}

		if (ultMeses == null)
			ultMeses = new Integer(0);
		if (cantMin == null)
			cantMin = new Integer(0);
		if (motivo == null)
			motivo = "";

		java.util.Date fecDesdeNov = getFecDesdeEval(ultMeses, fecHastaEval);

		int cantSanciones = 0;
		Iterator iterSancionesLeg = SancionesLegajo.getSancionesLegajos(nroNovedad, rankearCab, this, fecDesdeNov, fecHastaEval, this.getSesion()).iterator();
		while (iterSancionesLeg.hasNext()) {
			SancionesLegajo sancionLegajo = (SancionesLegajo) iterSancionesLeg.next();
			cantSancionesPorTitu.add(motivo, sancionLegajo);
			++cantSanciones;
		}

		if (cantSanciones >= cantMin) {
			motivosNoAprob.setNoAprobado(true);
			int maxPermitido = cantMin - 1;
			if (maxPermitido <= 0)
				maxPermitido = 0;
			String leyenda = "";
			if (maxPermitido > 0)
				leyenda = ".Máximo permitido " + maxPermitido;
			else
				leyenda = "";
			motivosNoAprob.addMotivoDesaprobacion("El empleado tiene " + cantSanciones + " " + motivo + " (!)", motivosNoAprob.getKEY_MOT_Cant_Max_Sanciones());
			return;
		}

	}

	public void analizarCondMinNov(Integer nroNovedad, CantSancionesPorTitu cantSancionesPorTitu, MotivosNoAprob motivosNoAprob, RankearCab rankearCab, java.util.Date fecHastaEval)
			throws BaseException {

		Integer ultMeses = new Integer(0);
		Integer cantMin = new Integer(0);
		String motivo = "";

		if (nroNovedad.intValue() == 1) {
			ultMeses = rankearCab.getCm_ult_mes_nov_1();
			cantMin = rankearCab.getCm_dias_nov_1();
			motivo = rankearCab.getCm_motivos_1();
		} else if (nroNovedad.intValue() == 2) {
			ultMeses = rankearCab.getCm_ult_mes_nov_2();
			cantMin = rankearCab.getCm_dias_nov_2();
			motivo = rankearCab.getCm_motivos_2();
		} else if (nroNovedad.intValue() == 3) {
			ultMeses = rankearCab.getCm_ult_mes_nov_3();
			cantMin = rankearCab.getCm_dias_nov_3();
			motivo = rankearCab.getCm_motivos_3();
		} else if (nroNovedad.intValue() == 4) {
			ultMeses = rankearCab.getCm_ult_mes_nov_4();
			cantMin = rankearCab.getCm_dias_nov_4();
			motivo = rankearCab.getCm_motivos_4();
		} else if (nroNovedad.intValue() == 5) {
			ultMeses = rankearCab.getCm_ult_mes_nov_5();
			cantMin = rankearCab.getCm_dias_nov_5();
			motivo = rankearCab.getCm_motivos_5();
		}

		if (ultMeses == null)
			ultMeses = new Integer(0);
		if (cantMin == null)
			cantMin = new Integer(0);
		if (motivo == null)
			motivo = "";

		java.util.Date fecDesdeNov = getFecDesdeEval(ultMeses, fecHastaEval);

		int cantNovedades = 0;
		Iterator iterNovedades = NovedadLegajo.getNovedadesLegajo(this, rankearCab, fecDesdeNov, fecHastaEval, nroNovedad, this.getSesion()).iterator();
		while (iterNovedades.hasNext()) {
			NovedadLegajo novedadLegajo = (NovedadLegajo) iterNovedades.next();
			cantSancionesPorTitu.add(motivo, novedadLegajo);
			++cantNovedades;
		}

		if (cantNovedades >= cantMin) {
			motivosNoAprob.setNoAprobado(true);
			int maxPermitido = cantMin - 1;
			if (maxPermitido <= 0)
				maxPermitido = 0;
			String leyenda = "";
			if (maxPermitido > 0)
				leyenda = ".Máximo permitido " + maxPermitido;
			else
				leyenda = "";
			motivosNoAprob.addMotivoDesaprobacion("El empleado tiene " + cantNovedades + " " + motivo + "(!)", motivosNoAprob.getKEY_MOT_Cant_Max_Novedades());
			return;
		}

	}

	public void analizarCondMinAntEmp(MotivosNoAprob motivosNoAprob, RankearCab rankearCab, java.util.Date fecHastaEval) throws BaseException {

		if ((rankearCab.isCm_ant_req_emp() != null) && (rankearCab.isCm_ant_req_emp())) {

			java.util.Date fecMasAnt = getFecAntParaDesa();
			if (fecMasAnt == null)
				return;

			// Obtener la fecha hasta del periodo a evaluar

			java.util.Date diaPosterior = Fecha.getFechaDiaPosterior(fecHastaEval);

			int cantMeses = Fecha.getDifEnMeses(fecMasAnt, diaPosterior);

			int cantMinMesesAnt = 0;
			// Obtener antiguedad minima empresa
			if (rankearCab.getCm_ut_req_emp().equals("A")) {
				if (rankearCab.getCm_cant_req_emp() != null)
					cantMinMesesAnt = rankearCab.getCm_cant_req_emp() * 12;
			} else {
				if (rankearCab.getCm_cant_req_emp() != null)
					cantMinMesesAnt = rankearCab.getCm_cant_req_emp();
			}

			if (diaPosterior.before(fecMasAnt)) {
				motivosNoAprob.setNoAprobado(true);
				motivosNoAprob.addMotivoDesaprobacion("La antiguedad en la empresa no puede ser menor a " + cantMinMesesAnt + " meses. (!) ", motivosNoAprob.getKEY_MOT_Ant_Min_Empresa());
				return;
			}

			if (!(cantMeses >= cantMinMesesAnt)) {
				motivosNoAprob.setNoAprobado(true);
				motivosNoAprob.addMotivoDesaprobacion("La antiguedad en la empresa no puede ser menor a " + cantMinMesesAnt + " meses. (!)", motivosNoAprob.getKEY_MOT_Ant_Min_Empresa());
			}

		}
	}

	public void analizarCondMinAntPue(JerarquiaDesa jerarquiaDesa, MotivosNoAprob motivosNoAprob, RankearCab rankearCab, java.util.Date fecHastaEval) throws BaseException {

		if ((rankearCab.isCm_ant_req_pue() != null) && (rankearCab.isCm_ant_req_pue())) {

			java.util.Date fecMasAnt = getFecUltRecategDia1();
			if (fecMasAnt == null)
				return;

			// Obtener la fecha hasta del periodo a evaluar
			java.util.Date diaPosterior = Fecha.getFechaDiaPosterior(fecHastaEval);
			int cantMeses = Fecha.getDifEnMeses(fecMasAnt, diaPosterior);

			int cantMinMesesAnt = 0;
			// Obtener antiguedad minima empresa
			if (rankearCab.getCm_ut_req_pue().equals("A")) {
				if (rankearCab.getCm_cant_req_pue() != null)
					cantMinMesesAnt = rankearCab.getCm_cant_req_pue() * 12;
			} else {
				if (rankearCab.getCm_cant_req_pue() != null)
					cantMinMesesAnt = rankearCab.getCm_cant_req_pue();
			}

			if (jerarquiaDesa != null) {
				int cantAniosReqPuesto = 0;
				if (jerarquiaDesa.getCantAniosPuesto() != null)
					cantAniosReqPuesto = jerarquiaDesa.getCantAniosPuesto().intValue() * 12;
				int cantMesesReqPuesto = 0;
				if (jerarquiaDesa.getCantMesesPuesto() != null)
					cantMesesReqPuesto = jerarquiaDesa.getCantMesesPuesto().intValue();
				int mesesReqPorCateg = cantAniosReqPuesto + cantMesesReqPuesto;
				if (mesesReqPorCateg > cantMinMesesAnt)
					cantMinMesesAnt = mesesReqPorCateg;
			}

			if (diaPosterior.before(fecMasAnt)) {
				motivosNoAprob.setNoAprobado(true);
				motivosNoAprob.addMotivoDesaprobacion("La antiguedad en el puesto no puede ser menor a " + cantMinMesesAnt + " meses. (!)", motivosNoAprob.getKEY_MOT_Ant_Min_Puesto());
				return;
			}

			if (!(cantMeses >= cantMinMesesAnt)) {
				motivosNoAprob.setNoAprobado(true);
				motivosNoAprob.addMotivoDesaprobacion("La antiguedad en el puesto no puede ser menor a " + cantMinMesesAnt + " meses. (!)", motivosNoAprob.getKEY_MOT_Ant_Min_Puesto());
			}

		}
	}

	public java.util.Date getFechaIngaraCalcAnt() throws BaseException {
		java.util.Date fecMasAnt = null;
		fecMasAnt = this.getFecIngreso();
		if (fecMasAnt == null)
			fecMasAnt = this.getIngresoUTE();
		else {
			if (this.getIngresoUTE() != null) {
				if (this.getIngresoUTE().before(fecMasAnt))
					fecMasAnt = this.getIngresoUTE();
			}
		}
		if (fecMasAnt == null)
			fecMasAnt = this.getFecAntReconocimiento();
		return fecMasAnt;

	}

	private RankItemDesarrollo getTotPuntosAntEmpresa(ListaDesgloseCalifGral aListaDesgloseCalifGral, MotivosNoAprob motivosNoAprob, java.util.Date fecHastaEval, RankearCab rankearCab)
			throws BaseException {

		RankItemDesarrollo rankItemDesarrollo = new RankItemDesarrollo();
		rankItemDesarrollo.setPonderacion(new Money(0));
		rankItemDesarrollo.setPuntaje(new Money(0));
		rankItemDesarrollo.setLeyenda("Antiguedad en la empresa");

		// Verificar el contenido del Rankeador
		if (rankearCab == null)
			return rankItemDesarrollo;

		// Tomar la fecha mas antigua entra la fecha de Ingreso y la fecha UTE
		java.util.Date fecMasAnt = getFechaIngaraCalcAnt();
		if (fecMasAnt == null)
			return rankItemDesarrollo;

		// Obtener la fecha hasta del periodo a evaluar

		java.util.Date diaPosterior = Fecha.getFechaDiaPosterior(fecHastaEval);
		if (diaPosterior.before(fecMasAnt))
			return rankItemDesarrollo;

		int cantMeses = Fecha.getDifEnMeses(fecMasAnt, diaPosterior);

		String antiguedad = Fecha.getLabelAntiguedad(fecMasAnt, diaPosterior);

		// Obtener el Rankeador
		if (rankearCab.getUnitiempoantemp() == null)
			return rankItemDesarrollo;
		if (fecHastaEval == null)
			return rankItemDesarrollo;

		int cantPuntaje = 0;

		// Obtener el puntaje
		CalculadorMoney calcPuntaje = new CalculadorMoney(new Money(0));
		if (rankearCab.getUnitiempoantemp().equals("M")) {
			cantPuntaje = cantMeses;
			calcPuntaje.sumar(new Money(cantMeses));
			if (rankearCab.getPtos_ant_emp() != null)
				calcPuntaje.multiplicarPor(rankearCab.getPtos_ant_emp());
			else
				calcPuntaje.multiplicarPor(new Money(0));
		} else {
			int anio = (int) (cantMeses / 12);
			cantPuntaje = anio;
			calcPuntaje.sumar(new Money(anio));
			if (rankearCab.getPtos_ant_emp() != null)
				calcPuntaje.multiplicarPor(rankearCab.getPtos_ant_emp());
			else
				calcPuntaje.multiplicarPor(new Money(0));
		}

		// Multiplicar por la ponderaciin
		if (rankearCab.getPond_ant_emp() == null) {
			rankItemDesarrollo.setLeyenda("Antiguedad Empresa desde el " + Fecha.getddmmyyyy(fecMasAnt));
			return rankItemDesarrollo;
		}

		rankItemDesarrollo.setPuntaje(calcPuntaje.getResultMoney());
		rankItemDesarrollo.setPonderacion(rankearCab.getPond_ant_emp());
		rankItemDesarrollo.setLeyenda("Antiguedad Empresa desde el " + Fecha.getddmmyyyy(fecMasAnt));

		// Pasa desglosar la calificacion general
		if (aListaDesgloseCalifGral != null) {
			aListaDesgloseCalifGral.add("Antiguedad Empresa", fecMasAnt, "Fecha de Ingreso " + Fecha.getddmmyyyy(fecMasAnt) + ". Antiguedad " + antiguedad, rankearCab.getPtos_ant_emp(), new Money(
					cantPuntaje), rankearCab.getPond_ant_emp(), rankItemDesarrollo.getTotPuntXPondDiv100(), ++orden);
		}

		return rankItemDesarrollo;
	}

	private RankItemDesarrollo getTotPuntosAntPuesto(ListaDesgloseCalifGral aListaDesgloseCalifGral, MotivosNoAprob motivosNoAprob, java.util.Date fecHastaEval, RankearCab rankearCab)
			throws BaseException {

		RankItemDesarrollo rankItemDesarrollo = new RankItemDesarrollo();
		rankItemDesarrollo.setPonderacion(new Money(0));
		rankItemDesarrollo.setPuntaje(new Money(0));
		rankItemDesarrollo.setLeyenda("Antiguedad en el Puesto");

		// Verificar el contenido del Rankeador
		if (rankearCab == null)
			return rankItemDesarrollo;

		// Tomar la fecha mas antigua entra la fecha de Ingreso y la fecha UTE
		java.util.Date fecAntPue = getFecUltRecategDia1();
		if (fecAntPue == null)
			return rankItemDesarrollo;

		// Obtener la fecha hasta del periodo a evaluar
		java.util.Date diaPosterior = Fecha.getFechaDiaPosterior(fecHastaEval);
		if (diaPosterior.before(fecAntPue))
			return rankItemDesarrollo;
		int cantMeses = Fecha.getDifEnMeses(fecAntPue, diaPosterior);

		String antiguedad = Fecha.getLabelAntiguedad(fecAntPue, diaPosterior);

		// Obtener el Rankeador
		if (rankearCab.getUt_ant_pue() == null)
			return rankItemDesarrollo;
		if (fecHastaEval == null)
			return rankItemDesarrollo;

		// Obtener el puntaje
		int cantPuntaje = 0;
		CalculadorMoney calcPuntaje = new CalculadorMoney(new Money(0));
		if (rankearCab.getUt_ant_pue().equals("M")) {
			cantPuntaje = cantMeses;
			calcPuntaje.sumar(new Money(cantMeses));
			if (rankearCab.getPtos_ant_pue() != null) {
				calcPuntaje.multiplicarPor(rankearCab.getPtos_ant_pue());
			} else
				calcPuntaje.multiplicarPor(new Money(0));
		} else {
			int anio = (int) (cantMeses / 12);
			cantPuntaje = anio;
			calcPuntaje.sumar(new Money(anio));
			if (rankearCab.getPtos_ant_pue() != null)
				calcPuntaje.multiplicarPor(rankearCab.getPtos_ant_pue());
			else
				calcPuntaje.multiplicarPor(new Money(0));
		}

		// Multiplicar por la ponderaciin
		if (rankearCab.getPond_ant_pue() == null) {
			rankItemDesarrollo.setLeyenda("Antiguedad Puesto desde el " + Fecha.getddmmyyyy(fecAntPue));
			return rankItemDesarrollo;
		}

		rankItemDesarrollo.setPuntaje(calcPuntaje.getResultMoney());
		rankItemDesarrollo.setPonderacion(rankearCab.getPond_ant_pue());
		rankItemDesarrollo.setLeyenda("Antiguedad Puesto desde el " + Fecha.getddmmyyyy(fecAntPue));

		// Pasa desglosar la calificacion general
		if (aListaDesgloseCalifGral != null) {
			aListaDesgloseCalifGral.add("Antiguedad Puesto", fecAntPue, "Fecha último Puesto " + Fecha.getddmmyyyy(fecAntPue) + ". Antiguedad " + antiguedad, rankearCab.getPtos_ant_pue(), new Money(
					cantPuntaje), rankearCab.getPond_ant_pue(), rankItemDesarrollo.getTotPuntXPondDiv100(), ++orden);
		}

		return rankItemDesarrollo;
	}

	private List getTotPuntosSanciones(ListaDesgloseCalifGral aListaDesgloseCalifGral, MotivosNoAprob motivosNoAprob, java.util.Date fecHastaEval, RankearCab rankearCab) throws BaseException {

		List listaRankeadores = new ArrayList();
		HashTableDatos acumPorRankyPond = new HashTableDatos();
		
		CalculadorMoney totalizarPuntajes = new CalculadorMoney(new Money(0));

		// Verificar el contenido del Rankeador
		if (rankearCab == null)
			return listaRankeadores;

		// Traer las novedades para aplicar
		int maxUltMeses = 0;
		HashTableDatos listaDeSanciones = new HashTableDatos();
		List listaSancionesRank = SancionRankear.getSancionesRankear(rankearCab, this.getSesion());
		Iterator iterSancionesAplic = listaSancionesRank.iterator();
		while (iterSancionesAplic.hasNext()) {

			SancionRankear sancionRankear = (SancionRankear) iterSancionesAplic.next();
			if (!sancionRankear.isAplicar())
				continue;

			if ((sancionRankear.getAnalizar_ult_meses() != null) && (sancionRankear.getAnalizar_ult_meses().intValue() > maxUltMeses)) {
				maxUltMeses = sancionRankear.getAnalizar_ult_meses().intValue();

			}

			if (sancionRankear.getMotivo_sancion() == null)
				continue;

			String claveSancion = sancionRankear.getMotivo_sancion().getOIDInteger().toString();
			listaDeSanciones.put(claveSancion, sancionRankear);
		}

		// Obtener las Novedade de los ultimos meses: maxUltMeses;
		java.util.Date fecDesdeSancion = getFecDesdeEval(maxUltMeses, fecHastaEval);

		// Obtener todas las Sanciones desde el maximo

		Iterator iterSanLeg = SancionesLegajo.getSancionesLegajos(this, fecDesdeSancion, fecHastaEval, this.getSesion()).iterator();

		// Verificar que las Novedades pertenezcan a los tipo y motivos
		// habilitados ademas de peretener al periodo de analisis
		while (iterSanLeg.hasNext()) {

			SancionesLegajo sancionLegajo = (SancionesLegajo) iterSanLeg.next();
			String claveSancion = "";
			if (sancionLegajo.getMotivo_sancion() != null)
				claveSancion = sancionLegajo.getMotivo_sancion().getOIDInteger().toString();

			SancionRankear sancionRankear = (SancionRankear) listaDeSanciones.get(claveSancion);

			if (sancionRankear == null)
				continue;

			if (sancionRankear.getAnalizar_ult_meses() == null)
				continue;

			if (sancionLegajo.getFecha() == null)
				continue;

			java.util.Date fecDesdeItemSan = getFecDesdeEval(sancionRankear.getAnalizar_ult_meses(), fecHastaEval);
			if (!Fecha.isFechaEntre(Fecha.getFechaTruncada(sancionLegajo.getFecha()), Fecha.getFechaTruncada(fecDesdeItemSan), Fecha.getFechaTruncada(fecHastaEval)))
				continue;

			if ((sancionRankear.getCalif_en_puntos() == null) || (sancionRankear.getPonderacion() == null) || (sancionRankear.getSuma_o_resta() == null))
				continue;

			String claveRankyPond = sancionRankear.getPonderacion().toString();
			RankItemDesarrollo buscarItem = (RankItemDesarrollo) acumPorRankyPond.get(claveRankyPond);

			double puntos = 0;

			if (buscarItem == null) {
				RankItemDesarrollo rankItemDesarrollo = new RankItemDesarrollo();
				rankItemDesarrollo.setPonderacion(sancionRankear.getPonderacion());
				if (sancionRankear.getSuma_o_resta().equals("R")) {
					puntos = sancionRankear.getCalif_en_puntos().doubleValue() * -1;
					rankItemDesarrollo.setPuntaje(new Money(puntos));
					totalizarPuntajes.sumar(new Money(puntos));
					
				} else {
					rankItemDesarrollo.setPuntaje(sancionRankear.getCalif_en_puntos());
					puntos = sancionRankear.getCalif_en_puntos().doubleValue();
					totalizarPuntajes.sumar(new Money(puntos));
				}
				rankItemDesarrollo.setLeyenda("Sanciones");
				acumPorRankyPond.put(claveRankyPond, rankItemDesarrollo);
			} else {
				CalculadorMoney acumPuntaje = new CalculadorMoney(buscarItem.getPuntaje());
				if (sancionRankear.getSuma_o_resta().equals("R")) {
					puntos = sancionRankear.getCalif_en_puntos().doubleValue() * -1;
					acumPuntaje.restar(sancionRankear.getCalif_en_puntos());
					totalizarPuntajes.sumar(new Money(puntos));
				} else {
					puntos = sancionRankear.getCalif_en_puntos().doubleValue();
					acumPuntaje.sumar(sancionRankear.getCalif_en_puntos());
					totalizarPuntajes.sumar(new Money(puntos));
				}
				buscarItem.setPuntaje(acumPuntaje.getResultMoney());
				
				
			}

			if (aListaDesgloseCalifGral != null) {

				CalculadorMoney totPuntosPond = new CalculadorMoney(new Money(puntos));
				if (sancionRankear.getPonderacion() != null)
					totPuntosPond.multiplicarPor(sancionRankear.getPonderacion());
				else
					totPuntosPond.multiplicarPor(new Money(0));
				totPuntosPond.dividirPor(new Money(100));

				aListaDesgloseCalifGral.add("Sanciones", sancionLegajo.getFecha(), sancionLegajo.getDescripcion(), new Money(puntos), new Money(1), sancionRankear.getPonderacion(), totPuntosPond
						.getResultMoney(), ++orden);
			}

		}
		
		// Verificar si desaprueba evaluacion
		if ((rankearCab!=null) && (rankearCab.IsDesapruebaSiSancRestanMas()==true)) {
			if ((totalizarPuntajes.getResult()<0) && (rankearCab.getPtosMaxDesapruebaSanc()!=null) && (rankearCab.getPtosMaxDesapruebaSanc().doubleValue()!=0)) {
				if ((totalizarPuntajes.getResult()*-1)>rankearCab.getPtosMaxDesapruebaSanc().doubleValue()) {
					motivosNoAprob.setNoAprobado(true);
					motivosNoAprob.addMotivoDesaprobacion("Por sanciones resta "+totalizarPuntajes.getResult()*-1+" puntos que excede el máximo permitido de "+rankearCab.getPtosMaxDesapruebaSanc().doubleValue()+" (!)", motivosNoAprob.getKEY_MOT_Excede_Ptos_Max_Sanciones());
				}
				
				
			}
		}

		return new ArrayList(acumPorRankyPond.values());

	}

	private List getTotPuntosNovedad(ListaDesgloseCalifGral aListaDesgloseCalifGral, MotivosNoAprob motivosNoAprob, java.util.Date fecHastaEval, RankearCab rankearCab) throws BaseException {

		List listaRankeadores = new ArrayList();
		HashTableDatos acumPorRankyPond = new HashTableDatos();
		
		CalculadorMoney totalizarPuntajes = new CalculadorMoney(new Money(0));

		// Verificar el contenido del Rankeador
		if (rankearCab == null)
			return listaRankeadores;

		// Traer las novedades para aplicar
		int maxUltMeses = 0;
		HashTableDatos listaDeNovedades = new HashTableDatos();
		List listaNovRank = RankearNovedad.getRankearNovedadesAplic(rankearCab, this.getSesion());
		Iterator iterNovAplic = listaNovRank.iterator();
		while (iterNovAplic.hasNext()) {

			RankearNovedad rankearNovedad = (RankearNovedad) iterNovAplic.next();

			if (!rankearNovedad.isAplicar())
				continue;

			if ((rankearNovedad.getAnalizar_ult_meses() != null) && (rankearNovedad.getAnalizar_ult_meses().intValue() > maxUltMeses)) {
				maxUltMeses = rankearNovedad.getAnalizar_ult_meses().intValue();

			}

			if ((rankearNovedad.getTipo_novedad() == null) || (rankearNovedad.getMotivo() == null))
				continue;

			String claveNovedad = rankearNovedad.getTipo_novedad().getOIDInteger() + "_" + rankearNovedad.getMotivo().getOIDInteger();
			listaDeNovedades.put(claveNovedad, rankearNovedad);
		}

		// Obtener las Novedade de los ultimos meses: maxUltMeses;
		java.util.Date fecDesdeNov = getFecDesdeEval(maxUltMeses, fecHastaEval);

		// Obtener todas las Novedades desde el maximo
		Iterator iterNovLeg = NovedadLegajo.getNovedadesLegajo(this, fecDesdeNov, fecHastaEval, this.getSesion()).iterator();

		// Verificar que las Novedades pertenezcan a los tipo y motivos
		// habilitados ademas de peretener al periodo de analisis
		while (iterNovLeg.hasNext()) {

			NovedadLegajo novedadLegajo = (NovedadLegajo) iterNovLeg.next();
			String claveNovedad = novedadLegajo.getOid_tipo_novedad().getOIDInteger() + "_" + novedadLegajo.getMotivo_tipo_nov().getOIDInteger();

			RankearNovedad rankearNovedad = (RankearNovedad) listaDeNovedades.get(claveNovedad);

			if (rankearNovedad == null)
				continue;

			if (rankearNovedad.getAnalizar_ult_meses() == null)
				continue;

			if (novedadLegajo.getFecha() == null)
				continue;

			java.util.Date fecDesdeItemNov = getFecDesdeEval(rankearNovedad.getAnalizar_ult_meses(), fecHastaEval);
			if (!Fecha.isFechaEntre(Fecha.getFechaTruncada(novedadLegajo.getFecha()), Fecha.getFechaTruncada(fecDesdeItemNov), Fecha.getFechaTruncada((fecHastaEval))))
				continue;

			if ((rankearNovedad.getCalif_en_puntos() == null) || (rankearNovedad.getPonderacion() == null) || (rankearNovedad.getSuma_o_resta() == null))
				continue;

			String claveRankyPond = rankearNovedad.getPonderacion().toString();
			RankItemDesarrollo buscarItem = (RankItemDesarrollo) acumPorRankyPond.get(claveRankyPond);

			double puntos = 0;

			if (buscarItem == null) {
				RankItemDesarrollo rankItemDesarrollo = new RankItemDesarrollo();
				rankItemDesarrollo.setPonderacion(rankearNovedad.getPonderacion());
				if (rankearNovedad.getSuma_o_resta().equals("R")) {
					puntos = rankearNovedad.getCalif_en_puntos().doubleValue() * -1;
					rankItemDesarrollo.setPuntaje(new Money(puntos));
					totalizarPuntajes.sumar(new Money(puntos));
				} else {
					puntos = rankearNovedad.getCalif_en_puntos().doubleValue();
					rankItemDesarrollo.setPuntaje(new Money(puntos));
					totalizarPuntajes.sumar(new Money(puntos));
				}
				rankItemDesarrollo.setLeyenda("Novedades");
				acumPorRankyPond.put(claveRankyPond, rankItemDesarrollo);
			} else {
				CalculadorMoney acumPuntaje = new CalculadorMoney(buscarItem.getPuntaje());
				if (rankearNovedad.getSuma_o_resta().equals("R")) {
					puntos = rankearNovedad.getCalif_en_puntos().doubleValue() * -1;
					acumPuntaje.restar(rankearNovedad.getCalif_en_puntos());
					totalizarPuntajes.sumar(new Money(puntos));
				} else {
					puntos = rankearNovedad.getCalif_en_puntos().doubleValue();
					acumPuntaje.sumar(rankearNovedad.getCalif_en_puntos());
					totalizarPuntajes.sumar(new Money(puntos));
				}
				buscarItem.setPuntaje(acumPuntaje.getResultMoney());
			}

			if (aListaDesgloseCalifGral != null) {

				CalculadorMoney totPuntosPond = new CalculadorMoney(new Money(puntos));
				if (rankearNovedad.getPonderacion() != null)
					totPuntosPond.multiplicarPor(rankearNovedad.getPonderacion());
				else
					totPuntosPond.multiplicarPor(new Money(0));
				totPuntosPond.dividirPor(new Money(100));

				aListaDesgloseCalifGral.add("Novedades", novedadLegajo.getFecha(), novedadLegajo.getDescripcion(), new Money(puntos), new Money(1), rankearNovedad.getPonderacion(), totPuntosPond
						.getResultMoney(), ++orden);
			}

		}
		
		// Verificar si desaprueba evaluacion
		if ((rankearCab!=null) && (rankearCab.IsDesapruebaSiNoveRestanMas()==true)) {
			if ((totalizarPuntajes.getResult()<0) && (rankearCab.getPtosMaxDesapruebaNov()!=null) && (rankearCab.getPtosMaxDesapruebaNov().doubleValue()!=0)) {
				if ((totalizarPuntajes.getResult()*-1)>rankearCab.getPtosMaxDesapruebaNov().doubleValue()) {
					motivosNoAprob.setNoAprobado(true);
					motivosNoAprob.addMotivoDesaprobacion("Por novedades resta "+totalizarPuntajes.getResult()*-1+" puntos que excede el máximo permitido de "+rankearCab.getPtosMaxDesapruebaNov().doubleValue()+" (!)", motivosNoAprob.getKEY_MOT_Excede_Ptos_Max_Novedades());
				}
				
				
			}
		}


		return new ArrayList(acumPorRankyPond.values());

	}

	public static java.util.Date getFecDesdeEval(int ultMeses, java.util.Date fecHastaEval) throws BaseException {
		int dia = Fecha.getDia(fecHastaEval);
		int mes = Fecha.getMes(fecHastaEval);
		int anio = Fecha.getAnio(fecHastaEval);

		mes = mes - (ultMeses * 1);
		mes = mes + 1;
		if (mes < 1) {
			anio = anio - 1;
			mes = 12 + mes;
		}

		return Fecha.getFecha(1, mes, anio);

	}

	public void analizarCantJuegosA(JerarquiaDesa jerarquiaDesa, MotivosNoAprob motivosNoAprob, Boolean pendEvalSinJuegos) throws BaseException {

		if (jerarquiaDesa == null)
			return;

		Integer cantMinJuegosA = jerarquiaDesa.getCantMinJuegosA();
		if (cantMinJuegosA == null)
			return;
		if (cantMinJuegosA.intValue() == 0)
			return;

		if (jerarquiaDesa.getCantMinJuegosA() == null)
			return;
		if ((jerarquiaDesa.getCantMinJuegosA() != null) && (jerarquiaDesa.getCantMinJuegosA().intValue() == 0))
			return;

		if (this.getGradoLegajo() != null) {
			if (this.getGradoLegajo().getCantJuegosA() == null)
				motivosNoAprob.addMotivoPendiente("Falta cargar la cantidad de juegos A para " + this.getGradoLegajo().getCodigo() + ". (P)", motivosNoAprob.getKEY_MOT_Cant_Min_JuegosA());
		} else {
			motivosNoAprob.addMotivoPendiente("Falta cargar la cantidad de juegos A para el Legajo. (P)", motivosNoAprob.getKEY_MOT_Cant_Min_JuegosA());
		}

		Integer cantJuegoaA = null;
		if (this.getGradoLegajo() != null)
			cantJuegoaA = this.getGradoLegajo().getCantJuegosA();
		if (cantJuegoaA == null)
			cantJuegoaA = 0;

		if (cantJuegoaA < cantMinJuegosA) {
			motivosNoAprob.setNoAprobado(true);
			motivosNoAprob.addMotivoDesaprobacion("La cantidad requerida de Juegos A es " + cantMinJuegosA + " (!)", motivosNoAprob.getKEY_MOT_Cant_Min_JuegosA());
		}

	}

	public void analizarPuntajeMinEval(JerarquiaDesa jerarquiaDesa, MotivosNoAprob motivosNoAprob, RankearCab rankearCab, java.util.Date fecHastaEval) throws BaseException {
		// Verificar el contenido del Rankeador
		if (rankearCab == null)
			return;

		// Verificar la fecha hasta evaluacion
		if (fecHastaEval == null)
			return;

		// Obtener la Fecha desde de la Evaluacion
		if (rankearCab.getEval_ult_meses() == null)
			return;

		// Obtener la fecha desde evaluaciin
		int ultMeses = rankearCab.getEval_ult_meses();

		java.util.Date fecDesdeEval = getFecDesdeEval(ultMeses, fecHastaEval);

		// Evaluacion
		EvaluacionLegajoCab evaluacionLegajoCab = this.getUltimaEvalLegCab(fecDesdeEval, fecHastaEval, ModeloEvalCab.TIPO_DESEN);
		if (evaluacionLegajoCab == null)
			return;

		double puntajeMinimo = 0;
		if (rankearCab.getCm_puntaje_eval() != null)
			if (rankearCab.getCm_puntaje_eval().doubleValue() != 0)
				puntajeMinimo = rankearCab.getCm_puntaje_eval().doubleValue();

		if ((jerarquiaDesa.getPuntosMinEval() != null) && (jerarquiaDesa.getPuntosMinEval().doubleValue() != 0))
			puntajeMinimo = jerarquiaDesa.getPuntosMinEval().doubleValue();

		if ((evaluacionLegajoCab.getPuntaje() == null) && (puntajeMinimo != 0)) {
			motivosNoAprob.setNoAprobado(true);
			motivosNoAprob.addMotivoDesaprobacion("Evaluación " + evaluacionLegajoCab.getCodigo() + " sin puntaje. (!)", motivosNoAprob.getKEY_MOT_Punt_Min_Evaluacion());
			return;
		}

		if ((evaluacionLegajoCab.getPuntaje().doubleValue() < puntajeMinimo) && (puntajeMinimo != 0)) {
			motivosNoAprob.setNoAprobado(true);
			motivosNoAprob.addMotivoDesaprobacion("El puntaje mínimo de la evaluación debe ser " + puntajeMinimo + " (!)", motivosNoAprob.getKEY_MOT_Punt_Min_Evaluacion());
		}

	}

	private RankItemDesarrollo getTotPuntosEvaluacion(ListaDesgloseCalifGral aListaDesgloseCalifGral, MotivosNoAprob motivosNoAprob, java.util.Date fecHastaEval, RankearCab rankearCab,
			Boolean pendEvalSiFaltaEval) throws BaseException {

		RankItemDesarrollo rankItemDesarrollo = new RankItemDesarrollo();
		rankItemDesarrollo.setPonderacion(new Money(0));
		rankItemDesarrollo.setPuntaje(new Money(0));
		rankItemDesarrollo.setLeyenda("Ultima Evaluación");

		// Verificar el contenido del Rankeador
		if (rankearCab == null)
			return rankItemDesarrollo;

		// Verificar la fecha hasta evaluacion
		if (fecHastaEval == null)
			return rankItemDesarrollo;

		// Obtener la Fecha desde de la Evaluacion
		if (rankearCab.getEval_ult_meses() == null)
			return rankItemDesarrollo;

		// Obtener la fecha desde evaluaciin
		int ultMeses = rankearCab.getEval_ult_meses();

		java.util.Date fecDesdeEval = getFecDesdeEval(ultMeses, fecHastaEval);

		// Evaluacion
		EvaluacionLegajoCab evaluacionLegajoCab = this.getUltimaEvalLegCab(fecDesdeEval, fecHastaEval, ModeloEvalCab.TIPO_DESEN);
		if (evaluacionLegajoCab == null) {

			return rankItemDesarrollo;
		}

		// Obtener el puntaje
		CalculadorMoney calcPuntaje = new CalculadorMoney(new Money(0));
		if (evaluacionLegajoCab.getPuntaje() != null) {
			calcPuntaje.sumar(evaluacionLegajoCab.getPuntaje());
			if (rankearCab.getEval_calif_punto() != null)
				calcPuntaje.multiplicarPor(rankearCab.getEval_calif_punto());
			else
				calcPuntaje.multiplicarPor(new Money(0));
		}

		// Pasa desglosar la calificacion general

		rankItemDesarrollo.setPuntaje(calcPuntaje.getResultMoney());
		rankItemDesarrollo.setPonderacion(rankearCab.getEval_ponderacion());
		rankItemDesarrollo.setLeyenda("Ultima Evaluación " + evaluacionLegajoCab.getCodigo());

		if (aListaDesgloseCalifGral != null) {

			aListaDesgloseCalifGral.add("Ultima Evaluación " + evaluacionLegajoCab.getCodigo(), evaluacionLegajoCab.getFec_eval(), evaluacionLegajoCab.getCodigo() + " Del "
					+ Fecha.getddmmyyyy(evaluacionLegajoCab.getModelo_eval_cab().getFec_desde()) + " al " + Fecha.getddmmyyyy(evaluacionLegajoCab.getModelo_eval_cab().getFec_hasta()), rankearCab
					.getEval_calif_punto(), evaluacionLegajoCab.getPuntaje(), rankearCab.getEval_ponderacion(), rankItemDesarrollo.getTotPuntXPondDiv100(), ++orden);
		}

		return rankItemDesarrollo;
	}

	public EvaluacionLegajoCab getUltimaEvalLegCab(java.util.Date fecDesde, java.util.Date fecHasta, String tipo) throws BaseException {

		if ((fecDesde == null) || (fecHasta == null))
			return null;

		return EvaluacionLegajoCab.getUltimaEvalLegCab(fecDesde, fecHasta, tipo, this, this.getSesion());
	}

	public java.util.Date getFecUltRecateg() throws BaseException {

		this.supportRefresh();
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		ValorClasificadorEntidad valorPuesto = this.getValorClasifEnt(clasifPuesto);

		HistoricoPuesto histPuesto = null;
		if (valorPuesto != null)
			histPuesto = HistoricoPuesto.getHistoricoPuesto(this, valorPuesto, this.getSesion());
		java.util.Date fecUltRecateg = null;
		if (histPuesto != null)
			fecUltRecateg = histPuesto.getFec_desde();
		return fecUltRecateg;

	}

	public java.util.Date getFecUltRecategDia1() throws BaseException {

		this.supportRefresh();
		java.util.Date fecUltRecateg = getFecUltRecateg();
		if (fecUltRecateg == null)
			return null;
		Calendar ad = Calendar.getInstance();
		ad.setTime(fecUltRecateg);
		ad.set(Calendar.DATE, 1);
		return ad.getTime();

	}

	public int getAntiEnMesesSector(ValorClasificadorEntidad valorClasifEmp, ValorClasificadorEntidad valorClasifSec, java.util.Date aFechaHasta) throws BaseException {

		if (valorClasifSec == null)
			return 0;
		if (valorClasifSec == null)
			return 0;
		if (aFechaHasta == null)
			return 0;

		HashTableDatos listaCodAgrupEmp = new HashTableDatos();

		String codigoAgrupadorActual = "";
		if (valorClasifEmp == null)
			return 0;
		AgrupadorAntEmp agrupadorAntEmp = AgrupadorAntEmp.findByCodigo(valorClasifEmp.getOIDInteger().toString(), this.getSesion());

		// Obstener la empresa actual del empleado
		if (agrupadorAntEmp != null) {
			codigoAgrupadorActual = agrupadorAntEmp.getCod_ant_emp();
			listaCodAgrupEmp.put(agrupadorAntEmp.getValorClasifEmpresa().getOIDInteger(), codigoAgrupadorActual);
		}

		int acumAntSector = 0;

		int antEnMesesPuesto = 0;

		List listaHistPuestos = this.getHistoricoPuestos();
		Iterator iterHistPuestos = listaHistPuestos.iterator();

		int cantPuestos = listaHistPuestos.size();

		boolean primerPuesto = false;
		java.util.Date fecHasAntPuesto = aFechaHasta;
		int contarPuestos = 0;
		while (iterHistPuestos.hasNext()) {
			HistoricoPuesto historicoPuesto = (HistoricoPuesto) iterHistPuestos.next();
			++contarPuestos;

			if (contarPuestos == cantPuestos)
				primerPuesto = true;

			antEnMesesPuesto = 0;

			// Buscar el Cidigo de puesto Historico
			String codAgrupador = "";
			codAgrupador = (String) listaCodAgrupEmp.get(historicoPuesto.getVal_clasif_emp().getOIDInteger().toString());
			if (codAgrupador == null) {
				agrupadorAntEmp = AgrupadorAntEmp.findByCodigo(historicoPuesto.getVal_clasif_emp().getOIDInteger().toString(), this.getSesion());
				if (agrupadorAntEmp != null) {
					codAgrupador = agrupadorAntEmp.getCod_ant_emp();
					listaCodAgrupEmp.put(agrupadorAntEmp.getValorClasifEmpresa().getOIDInteger(), codAgrupador);
				}
			}

			int anioFecPuesto = Fecha.getAnio(historicoPuesto.getFec_desde());
			int mesFecPuesto = Fecha.getMes(historicoPuesto.getFec_desde());

			if ((codAgrupador!=null) && (codAgrupador.equals(codigoAgrupadorActual)) && (valorClasifSec.getOID() == historicoPuesto.getVal_clasif_sec().getOID())) {

				java.util.Date fecPrimeroDelMes = null;

				fecPrimeroDelMes = Fecha.getFecha(1, mesFecPuesto, anioFecPuesto);

				if (primerPuesto) {
					java.util.Date fecAntParaDesa = this.getFecAntParaDesa();
					if (fecAntParaDesa != null) {
						int anioFecAntParaDesa = Fecha.getAnio(fecAntParaDesa);
						int mesFecAntParaDesa = Fecha.getMes(fecAntParaDesa);
						if ((anioFecPuesto == anioFecAntParaDesa) && (mesFecPuesto == mesFecAntParaDesa)) {
							fecPrimeroDelMes = fecAntParaDesa;
						}
					}

				}

				antEnMesesPuesto = Fecha.getAntiguedadEnMeses(fecPrimeroDelMes, fecHasAntPuesto);
				if (antEnMesesPuesto < 0)
					antEnMesesPuesto = 0;
				acumAntSector = acumAntSector + antEnMesesPuesto;
			}

			// Validar el valor del Sector

			fecHasAntPuesto = historicoPuesto.getFec_desde();

			// En base a la fecha que asumio, otener la fecha ultimo dia del mes
			// anterior
			java.util.Date fecUltDiaFinMesAnterior = Fecha.getFecha(1, mesFecPuesto, anioFecPuesto);
			fecHasAntPuesto = Fecha.getFechaDiaAnterior(fecUltDiaFinMesAnterior);

			// historicoPuesto.getVal_clasif_sec()

		}

		listaCodAgrupEmp = null;

		return acumAntSector;
	}

	public ObsLegajo getUltObsLegajo(TipoObsLeg aTipoObsLeg, java.util.Date fecDesde, java.util.Date fecHasta) throws BaseException {
		return DBObsLegajo.getObsLegajo(this, aTipoObsLeg, fecDesde, fecHasta, this.getSesion());
	}

	public static List getLegajosEnSeguiLegales(ISesion aSesion) throws BaseException {
		return DBLegajo.getLegajosEnSeguiLegales(aSesion);
	}

	public String getMemoNegociacion() throws BaseException {
		
		StringBuffer texto = new StringBuffer("");
		Iterator iterNegociaciones = this.getNegociaciones().iterator();
		while (iterNegociaciones.hasNext()) {
			NegociacionLegales negociacionLegales = (NegociacionLegales) iterNegociaciones.next();

			
			
			int i=1;
			String monto = "";
			if (negociacionLegales.getMonto()!=null) {
				DecimalFormat myFormatter = new DecimalFormat("#,###.##");
				String monto1 = myFormatter.format(negociacionLegales.getMonto().doubleValue(2));
				monto = myFormatter.format(negociacionLegales.getMonto().doubleValue(2));
				for(i=1;i<=(15-monto1.length());++i) {
					monto = " "+monto;
				}
			}
			else {
				DecimalFormat myFormatter = new DecimalFormat("#,###.##");
				String monto1 = myFormatter.format(0);
				monto = "0";
				for(i=1;i<=(15-monto1.length());++i) {
					monto = " "+monto;
				}
			}

			if (texto.length()>0)
				texto.append(Util.ENTER());
				
			String fecha = "??/??/????";
			if (negociacionLegales.getFecha()!=null)
				fecha = Fecha.getddmmyyyy(negociacionLegales.getFecha());
			
			texto.append(fecha + "   Monto "+monto+"   "+negociacionLegales.getObservacion());
		}
		return texto.toString();
	}
	
	public List getNovedadesLegajoFecha(java.util.Date fecha) throws BaseException {
		return NovedadLegajo.getNovedadesLegajoFecha(this,fecha,this.getSesion());
	}
	
	public List getSancionesLegajosALaFecha(
			java.util.Date fecha) throws BaseException {
		return DBSancionesLegajo.getSancionesLegajosFecSuspDesdeYReintegro(this,fecha,this.getSesion());
	}
	
	public static List getLegConsPlanifRotasEntFechas(
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			Rota rota,
			FiltroLegCab filtro,
			String juegos,
			ISesion aSesion) throws BaseException {
		return  DBLegajo.getLegConsPlanifRotasEntFechas(fechaDesde,fechaHasta,rota,filtro,juegos,aSesion); 
	}
	

}
