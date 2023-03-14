package com.srn.erp.excluidos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.excluidos.da.DBImagenesExcluido;
import com.srn.erp.excluidos.da.DBIndividuoExcluido;
import com.srn.erp.general.bm.Nacionalidad;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class IndividuoExcluido extends ObjetoLogico {

	@Override
	public void afterSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveDelete();
		
		IndividuoExcluido.actuNroLoteSinc(this.getOIDInteger(), this.getSesion().getNewOIDByKey(IndividuoExcluido.LOTE_EXP_EXC), this.getSesion());
		
		
	}

	private List autos = new ArrayList();
	private boolean readAutos = true;
	
	private List archivosAdjuntos = new ArrayList();
	private boolean readArchivosAdjuntos = true;
	

	private List vehiculos = new ArrayList();
	private boolean readVehiculos = true;

	private List difImportes = new ArrayList();
	private boolean readDifImportes = true;

	private List referenciasArchivos = new ArrayList();
	private boolean readRefArchivos = true;

	private List imagenesIndividuo = new ArrayList();
	private boolean readImagenesIndividuo = true;

	private List observacionesGenerales = new ArrayList();
	private boolean readObsGenerales = true;

	private List relacionesExcluido = new ArrayList();
	private boolean readRelacionesExcluido = true;

	private List novedades = new ArrayList();
	private boolean readNovedades = true;

	public static final String COND_ACTIVA = "A";
	public static final String COND_PASIVA = "P";

	public static final String TI_EMPLEADO = "EMPLEADO";
	public static final String TI_EXTERNO = "EXTERNO";

	public static final String SEXO_M = "M";
	public static final String SEXO_F = "F";
	public static final String SEXO_T = "T";

	public static final String LOTE_EXP_EXC = "LOTE_EXP_EXC";
	public static final String CON_NOV_EN_CONSULTA = "CON_NOV_EN_CONSULTA";
	public static final String CON_NOV_FUERA_CONSULTA = "CON_NOV_FUERA_CONSULTA";
	
	
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public IndividuoExcluido() {
	}

	public static String NICKNAME = "exc.IndividuoExcluido";

	private String tipo;
	private String apellido;
	private String nombre;
	private TipoDocumento tipo_documento;
	private String nro_documento;
	private String apodo;
	private Nacionalidad nacionalidad;
	private String nro_legajo;
	private SectorLegajoExcluido sector;
	private CargoLegajoExcluido cargo;
	private String tipo_condicion;
	private String sexo;
	private RazaExcluido raza;
	private AlturaExcluido altura;
	private ComplexionExcluido complexion;
	private EdadExcluido edad;
	private ColorCabelloExcluido color;
	private TipoBarba tipo_barba;
	private TipoCabelloExcluido tipo_cabello;
	private TipoNariz tipo_nariz;
	private Boolean anteojos;
	private String marcas;
	private String rasgos;
	private EstadoExcluido estado;
	private EstadoExcluido estado_anterior;
	private java.util.Date fec_estado;
	private java.util.Date fec_estado_ant;
	private Legajo legajo;
	private Boolean activo;
	private NovedadExcluido novedad;
	private Boolean actuAutoEstInd;
	private String obsPrincipal;
	private CaracterExcluido caracter;
	private RasgoExcluido rasgo;
	private MarcaExcluido marca;
	private AnteojoExcluido anteojo;
	private java.util.Date fechaAlta;
	private Integer fotoPrincipal;
	private PeligrosidadExcluido peligrosidad;
	private PredioExcluido predio; 
	private PredioExcluido predioFoto1;
	private Integer nroVersionFoto1;
	private Integer nroVersionFoto2;
	private Integer nroVersionFoto3;
	
	
	public Boolean isActuAutoEstInd() throws BaseException {
		supportRefresh();
		return this.actuAutoEstInd;
	}
	
	public String getObsPrincipal() throws BaseException {
		supportRefresh();
		return this.obsPrincipal;
	}
	
	public PredioExcluido getPredioExcluido() throws BaseException {
		supportRefresh();
		return this.predio;
	}	
	
	public PredioExcluido getPredioFoto1() throws BaseException {
		supportRefresh();
		return this.predioFoto1;
	}
	
	public Integer getNroVersionFoto1() throws BaseException {
		supportRefresh();
		if (this.nroVersionFoto1!=null)
			return this.nroVersionFoto1;
		else
			return 0;
	}	
	
	public Integer getNroVersionFoto2() throws BaseException {
		supportRefresh();
		if (this.nroVersionFoto2!=null)
			return this.nroVersionFoto2;
		else
			return 0;
	}	
	
	public Integer getNroVersionFoto3() throws BaseException {
		supportRefresh();
		if (this.nroVersionFoto3!=null)
			return this.nroVersionFoto3;
		else
			return 0;
	}	
	
	public java.util.Date getFechaAlta() throws BaseException {
		supportRefresh();
		return this.fechaAlta;
	}
	
	public void setFechaAlta(java.util.Date aFechaAlta) throws BaseException {
		fechaAlta = aFechaAlta;
	}
	
	public void setNroVersionFoto1(Integer aNroVersionFoto1) throws BaseException {
		this.nroVersionFoto1 = aNroVersionFoto1;
	}
	
	public void setNroVersionFoto2(Integer aNroVersionFoto2) throws BaseException {
		this.nroVersionFoto2 = aNroVersionFoto2;
	}	
	
	public void setNroVersionFoto3(Integer aNroVersionFoto3) throws BaseException {
		this.nroVersionFoto3 = aNroVersionFoto3;
	}	
	
	
	public void setPredioExcluido(PredioExcluido aPredio) throws BaseException {
		this.predio = aPredio;
	}	
	
	public void setPredioFoto1(PredioExcluido aPredio) throws BaseException {
		this.predioFoto1 = aPredio;
	}	
	
	

	public void setActuAutoEstInd(Boolean aActuAutoEstInd) {
		this.actuAutoEstInd = aActuAutoEstInd;
	}
	
	public CaracterExcluido getCaracter() throws BaseException {
		supportRefresh();
		return this.caracter;
	}	

	public void setCaracter(CaracterExcluido aCaracter) {
		this.caracter = aCaracter;
	}
	
	public Integer getFotoPrincipal() throws BaseException {
		supportRefresh();
		return this.fotoPrincipal;
	}	

	public void setFotoPrincipal(Integer aFotoPrincipal) {
		this.fotoPrincipal = aFotoPrincipal;
	}	
	
	
	public void setObsPrincipal(String aObsPrincipal) {
		this.obsPrincipal = aObsPrincipal;
	}	
	
	
	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}
	
	public PeligrosidadExcluido getPeligrosidad() throws BaseException {
		supportRefresh();
		return this.peligrosidad;
	}	

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
	}
	
	public void setPeligrosidad(PeligrosidadExcluido aPeligrosidad) {
		this.peligrosidad = aPeligrosidad;
	}	
	
	public AnteojoExcluido getAnteojo() throws BaseException {
		supportRefresh();
		return this.anteojo;
	}

	public void setAnteojo(AnteojoExcluido aAnteojo) {
		this.anteojo = aAnteojo;
	}	
	
	public MarcaExcluido getMarca() throws BaseException {
		supportRefresh();
		return this.marca;
	}

	public void setMarca(MarcaExcluido aMarcaExcluido) {
		this.marca = aMarcaExcluido;
	}
	
	public RasgoExcluido getRasgo() throws BaseException {
		supportRefresh();
		return this.rasgo;
	}

	public void setRasgo(RasgoExcluido aRasgoExcluido) {
		this.rasgo = aRasgoExcluido;
	}	
	

	public NovedadExcluido getNovedadExcluido() throws BaseException {
		supportRefresh();
		return this.novedad;
	}

	public void setNovedadExcluido(NovedadExcluido aNovedadExcluido) {
		this.novedad = aNovedadExcluido;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return this.activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getApellido() throws BaseException {
		supportRefresh();
		return apellido;
	}

	public void setApellido(String aApellido) {
		this.apellido = aApellido;
	}

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public TipoDocumento getTipo_documento() throws BaseException {
		supportRefresh();
		return tipo_documento;
	}

	public void setTipo_documento(TipoDocumento aTipo_documento) {
		this.tipo_documento = aTipo_documento;
	}

	public String getNro_documento() throws BaseException {
		supportRefresh();
		return nro_documento;
	}

	public void setNro_documento(String aNro_documento) {
		this.nro_documento = aNro_documento;
	}

	public String getApodo() throws BaseException {
		supportRefresh();
		return apodo;
	}

	public void setApodo(String aApodo) {
		this.apodo = aApodo;
	}

	public Nacionalidad getNacionalidad() throws BaseException {
		supportRefresh();
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad aNacionalidad) {
		this.nacionalidad = aNacionalidad;
	}

	public String getNro_legajo() throws BaseException {
		supportRefresh();
		return nro_legajo;
	}

	public void setNro_legajo(String aNro_legajo) {
		this.nro_legajo = aNro_legajo;
	}

	public SectorLegajoExcluido getSector() throws BaseException {
		supportRefresh();
		return sector;
	}

	public void setSector(SectorLegajoExcluido aSector) {
		this.sector = aSector;
	}

	public CargoLegajoExcluido getCargo() throws BaseException {
		supportRefresh();
		return cargo;
	}

	public void setCargo(CargoLegajoExcluido aCargo) {
		this.cargo = aCargo;
	}

	public String getTipo_condicion() throws BaseException {
		supportRefresh();
		return tipo_condicion;
	}

	public void setTipo_condicion(String aTipo_condicion) {
		this.tipo_condicion = aTipo_condicion;
	}

	public String getSexo() throws BaseException {
		supportRefresh();
		return sexo;
	}

	public void setSexo(String aSexo) {
		this.sexo = aSexo;
	}

	public RazaExcluido getRaza() throws BaseException {
		supportRefresh();
		return raza;
	}

	public void setRaza(RazaExcluido aRaza) {
		this.raza = aRaza;
	}

	public AlturaExcluido getAltura() throws BaseException {
		supportRefresh();
		return altura;
	}

	public void setAltura(AlturaExcluido aAltura) {
		this.altura = aAltura;
	}

	public ComplexionExcluido getComplexion() throws BaseException {
		supportRefresh();
		return complexion;
	}

	public void setComplexion(ComplexionExcluido aComplexion) {
		this.complexion = aComplexion;
	}

	public EdadExcluido getEdad() throws BaseException {
		supportRefresh();
		return edad;
	}

	public void setEdad(EdadExcluido aEdad) {
		this.edad = aEdad;
	}

	public ColorCabelloExcluido getColor() throws BaseException {
		supportRefresh();
		return color;
	}

	public void setColor(ColorCabelloExcluido aColor) {
		this.color = aColor;
	}

	public TipoBarba getTipo_barba() throws BaseException {
		supportRefresh();
		return tipo_barba;
	}

	public void setTipo_barba(TipoBarba aTipo_barba) {
		this.tipo_barba = aTipo_barba;
	}

	public TipoCabelloExcluido getTipo_cabello() throws BaseException {
		supportRefresh();
		return tipo_cabello;
	}

	public void setTipo_cabello(TipoCabelloExcluido aTipo_cabello) {
		this.tipo_cabello = aTipo_cabello;
	}

	public TipoNariz getTipo_nariz() throws BaseException {
		supportRefresh();
		return tipo_nariz;
	}

	public void setTipo_nariz(TipoNariz aTipo_nariz) {
		this.tipo_nariz = aTipo_nariz;
	}

	public Boolean isAnteojos() throws BaseException {
		supportRefresh();
		return anteojos;
	}

	public void setAnteojos(Boolean aAnteojos) {
		this.anteojos = aAnteojos;
	}

	public String getMarcas() throws BaseException {
		supportRefresh();
		return marcas;
	}

	public void setMarcas(String aMarcas) {
		this.marcas = aMarcas;
	}

	public String getRasgos() throws BaseException {
		supportRefresh();
		return rasgos;
	}

	public void setRasgos(String aRasgos) {
		this.rasgos = aRasgos;
	}

	public EstadoExcluido getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(EstadoExcluido aEstado) {
		this.estado = aEstado;
	}

	public EstadoExcluido getEstado_anterior() throws BaseException {
		supportRefresh();
		return estado_anterior;
	}

	public void setEstado_anterior(EstadoExcluido aEstado_anterior) {
		this.estado_anterior = aEstado_anterior;
	}

	public java.util.Date getFec_estado() throws BaseException {
		supportRefresh();
		return fec_estado;
	}

	public void setFec_estado(java.util.Date aFec_estado) {
		this.fec_estado = aFec_estado;
	}

	public java.util.Date getFec_estado_ant() throws BaseException {
		supportRefresh();
		return fec_estado_ant;
	}

	public void setFec_estado_ant(java.util.Date aFec_estado_ant) {
		this.fec_estado_ant = aFec_estado_ant;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static IndividuoExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (IndividuoExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static IndividuoExcluido findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (IndividuoExcluido) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static IndividuoExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (IndividuoExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		
		Validar.noNulo(tipo, "Debe ingresar el Tipo");
		Validar.noNulo(predio, "Debe ingresar el Predio donde se da de Alta el Cliente");
		Validar.noNulo(predioFoto1, "Debe ingresar el Predio de la Primera Foto");
		
		if (this.isNew()) {
			Validar.noNulo(this.sexo, "Debe ingresar el Sexo");
			Validar.noNulo(this.raza, "Debe ingresar la Raza");
			Validar.noNulo(this.edad, "Debe ingresar la Edad");			
			Validar.noNulo(this.peligrosidad, "Debe ingresar la Peligrosidad");
		}
		
		
		
		if (this.getNro_documento()!=null) {
			if (this.getNro_documento().contains(",") || this.getNro_documento().contains(";") || this.getNro_documento().contains("-") || this.getNro_documento().contains("."))
				throw new ExceptionValidation(null,"El Nro. de documento no debe contener ninguno de los siguientes caracteres ; : - . ");
		}
			
	}

	public List getVehiculos() throws BaseException {
		if (this.readVehiculos) {
			List listaVehiculos = VehiAsigExcluido.getVehiAsigExcluido(this, this.getSesion());
			vehiculos.addAll(listaVehiculos);
			this.readVehiculos = false;
		}
		return vehiculos;
	}

	public List getDifImportes() throws BaseException {
		if (this.readDifImportes) {
			List listaDifImportes = DifImporteExcluido.getDifImportesExcluidos(this, this.getSesion());
			difImportes.addAll(listaDifImportes);
			this.readDifImportes = false;
		}
		return difImportes;
	}

	public List getReferenciasArchivos() throws BaseException {
		if (this.readRefArchivos) {
			List listaRefArch = ReferenciaArchivoExcluido.getReferenciasArchivos(this, this.getSesion());
			referenciasArchivos.addAll(listaRefArch);
			this.readRefArchivos = false;
		}
		return referenciasArchivos;
	}

	public List getReferenciaArchivoExcluidos() throws BaseException {
		if (this.readVehiculos) {
			List listaRefArch = ReferenciaArchivoExcluido.getReferenciasArchivos(this, this.getSesion());
			referenciasArchivos.addAll(listaRefArch);
			this.readRefArchivos = false;
		}
		return referenciasArchivos;
	}

	public List getObservacionesGenerales() throws BaseException {
		if (this.readObsGenerales) {
			List listaObsGenerales = ObsGeneralesExcluido.getObsGenerales(this, this.getSesion());
			this.observacionesGenerales.addAll(listaObsGenerales);
			this.readObsGenerales = false;
		}
		return observacionesGenerales;
	}

	public List getRelacionesEcluidos() throws BaseException {
		if (this.readRelacionesExcluido) {
			List listaRelaciones = RelacionExcluido.getRelacionesExcluidos(this, this.getSesion());
			this.relacionesExcluido.addAll(listaRelaciones);
			this.readRelacionesExcluido = false;
		}
		return relacionesExcluido;
	}

	public List getNovedades() throws BaseException {
		if (this.readNovedades) {
			cargarListaFromBD(novedades, NovedadExcluido.getNovedadesExcluido(this, this.getSesion()));
			//List listaNovedades = NovedadExcluido.getNovedadesExcluido(this, this.getSesion());
			//this.novedades.addAll(listaNovedades);
			this.readNovedades = false;
		}
		return this.novedades;
	}

	public List getImagenesIndividuo() throws BaseException {
		if (this.readImagenesIndividuo) {
			List listaImaInd = ImagenesExcluido.getImagenesExcluido(this, this.getSesion());
			imagenesIndividuo.addAll(listaImaInd);
			this.readImagenesIndividuo = false;
		}
		return imagenesIndividuo;
	}
	
	public List getArchivosAdjuntos() throws BaseException {
		if (this.readArchivosAdjuntos) {
			List listaArchAdj = ArchAdjExc.getArchAdjInd(this.getSesion(),this);
			archivosAdjuntos.addAll(listaArchAdj);
			this.readArchivosAdjuntos = false;
		}
		return archivosAdjuntos;
	}
	

	public void addVehiculo(VehiAsigExcluido aVehiAsigExcluido) throws BaseException {
		aVehiAsigExcluido.setIndividuo(this);
		vehiculos.add(aVehiAsigExcluido);
	}

	public void addDifImporte(DifImporteExcluido aDifImporte) throws BaseException {
		aDifImporte.setIndividuo(this);
		difImportes.add(aDifImporte);
	}

	public void addRelacion(RelacionExcluido aRelExc) throws BaseException {
		aRelExc.setIndividuo(this);
		relacionesExcluido.add(aRelExc);
	}

	public void addNovedad(NovedadExcluido aNovedadExcluido) throws BaseException {
		aNovedadExcluido.setIndividuoExcluido(this);
		novedades.add(aNovedadExcluido);
	}

	public void addObservacionGeneral(ObsGeneralesExcluido aObsGenExc) throws BaseException {
		aObsGenExc.setIndividuo(this);
		this.observacionesGenerales.add(aObsGenExc);
	}

	public void addImagenIndividuo(ImagenesExcluido aImagenExcluido) throws BaseException {
		aImagenExcluido.setIndividuo(this);
		imagenesIndividuo.add(aImagenExcluido);
	}

	public void addReferenciaArchivo(ReferenciaArchivoExcluido aRefArchExcluido) throws BaseException {
		aRefArchExcluido.setIndividuo(this);
		referenciasArchivos.add(aRefArchExcluido);
	}
	
	public void addArchivoAdjunto(ArchAdjExc aArchAdjExc) throws BaseException {
		aArchAdjExc.setIndividuo(this);
		archivosAdjuntos.add(aArchAdjExc);
	}
	

	public void addAuto(VehiculoExcluido aAuto) throws BaseException {
		this.autos.add(aAuto);
	}

	public void afterSave() throws BaseException {

		Iterator iterAutos = autos.iterator();
		while (iterAutos.hasNext()) {
			VehiculoExcluido vehiculoExcluido = (VehiculoExcluido) iterAutos.next();
			vehiculoExcluido.save();
			vehiculoExcluido = null;
		}
		iterAutos = null;

		Iterator iterVehiculos = vehiculos.iterator();
		while (iterVehiculos.hasNext()) {
			VehiAsigExcluido vehiculoAsigExcluido = (VehiAsigExcluido) iterVehiculos.next();
			vehiculoAsigExcluido.save();
			vehiculoAsigExcluido = null;
		}
		iterVehiculos = null;

		Iterator iterRefArchivos = referenciasArchivos.iterator();
		while (iterRefArchivos.hasNext()) {
			ReferenciaArchivoExcluido refArchExc = (ReferenciaArchivoExcluido) iterRefArchivos.next();
			refArchExc.save();
			refArchExc = null;
		}
		iterRefArchivos = null;

		Iterator iterImagenesInd = imagenesIndividuo.iterator();
		while (iterImagenesInd.hasNext()) {
			ImagenesExcluido imaInd = (ImagenesExcluido) iterImagenesInd.next();
			imaInd.save();
			imaInd = null;
		}
		iterImagenesInd = null;

		Iterator iterObsGen = this.observacionesGenerales.iterator();
		while (iterObsGen.hasNext()) {
			ObsGeneralesExcluido obsGenExc = (ObsGeneralesExcluido) iterObsGen.next();
			obsGenExc.save();
			obsGenExc = null;
		}
		iterObsGen = null;

		Iterator iterRelExc = this.relacionesExcluido.iterator();
		while (iterRelExc.hasNext()) {
			RelacionExcluido relacion = (RelacionExcluido) iterRelExc.next();
			relacion.save();
			relacion = null;
		}
		iterRelExc = null;

		Iterator iterDifImporte = this.difImportes.iterator();
		while (iterDifImporte.hasNext()) {
			DifImporteExcluido difImporte = (DifImporteExcluido) iterDifImporte.next();
			difImporte.save();
			difImporte = null;
		}
		iterDifImporte = null;

		Iterator iterNovedades = this.novedades.iterator();
		while (iterNovedades.hasNext()) {
			NovedadExcluido novedad = (NovedadExcluido) iterNovedades.next();
			novedad.save();
			novedad = null;
		}
		iterNovedades = null;
		
		Iterator iterArchAdj = this.archivosAdjuntos.iterator();
		while (iterArchAdj.hasNext()) {
			ArchAdjExc archAdj = (ArchAdjExc) iterArchAdj.next();
			archAdj.save();
			archAdj = null;
		}
		iterArchAdj = null;
		
		
		ManagerEstadoExcluido managerEstadoExc =
			  new ManagerEstadoExcluido();
		managerEstadoExc.setSesion(this.getSesion());
		managerEstadoExc.setIndividuo(this);
		managerEstadoExc.determinarEstado();
		AdmEstadoExcluido admEstadoExcluido = managerEstadoExc.getAdmEstadoExcluido();
		if (admEstadoExcluido!=null)
			admEstadoExcluido.save();
		
		IndividuoExcluido.actuNroLoteSinc(this.getOIDInteger(), this.getSesion().getNewOIDByKey(IndividuoExcluido.LOTE_EXP_EXC), this.getSesion());

	}

	@Override
	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();
		this.setFec_estado(Fecha.getFechaActual());
	}

	public static HashTableDatos getTiposEmpleados() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(IndividuoExcluido.TI_EMPLEADO, "Empleado");
		condiciones.put(IndividuoExcluido.TI_EXTERNO, "Externo");
		return condiciones;
	}

	public static HashTableDatos getSexoIndividuos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(IndividuoExcluido.SEXO_M, "Masculino");
		condiciones.put(IndividuoExcluido.SEXO_F, "Femenino");
		condiciones.put(IndividuoExcluido.SEXO_T, "Travesti");		
		return condiciones;
	}
	
	public static String getDescSexo(String sexo) throws BaseException {
		if (sexo==null)
			return "";
		else if (sexo.equals(IndividuoExcluido.SEXO_M))
			return "Masculino";
		else if (sexo.equals(IndividuoExcluido.SEXO_F))
			return "Femenino";
		else if (sexo.equals(IndividuoExcluido.SEXO_T))
			return "Travesti";
		else
			return "";
	}

	public static String getPathImagenPrincipalIndividuo(ISesion aSesion) throws BaseException {
		ValorParametro valorPathImagenesProd = ValorParametro.findByCodigoParametro("CARPETA_FOTO_EXCLUIDO", aSesion);
		return valorPathImagenesProd.getValorCadena();
	}

	public static String getFiltroEstadoExcluido(ISesion aSesion) throws BaseException {
		ValorParametro valorFiltro = null;
		try {
			valorFiltro = ValorParametro.findByCodigoParametro("FILTRO_EST_EXC", aSesion);
		} catch(Exception e) {
			return "";
		}
		if (valorFiltro ==null)
			return "";
		else if (valorFiltro.getValorCadena()==null)
				return "";
					else return valorFiltro.getValorCadena();
	}
	
	
	
	public ImagenesExcluido getImagenExcluido(Integer orden) throws BaseException {
		return DBImagenesExcluido.getImagenExcluido(this.getSesion(), this, orden);
	}

	public static HashTableDatos getCondicionesLegajo() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(COND_ACTIVA, "ACTIVO");
		condiciones.put(COND_PASIVA, "PASIVO");
		return condiciones;
	}

	public String getApeyNom() throws BaseException {
		StringBuffer nombre = new StringBuffer("");
		if (this.getApellido() != null)
			nombre.append(this.getApellido());
		if (nombre.length() != 0)
			nombre.append(" ");
		if (this.getNombre() != null)
			nombre.append(this.getNombre());
		return nombre.toString();
	}
	
	public String getNroPrincipal1() throws BaseException {
		if (this.getNovedadExcluido()!=null) {
			
			StringBuffer cond = new StringBuffer("");
			if (this.getNovedadExcluido().getEstado()!=null)
				cond.append(this.getNovedadExcluido().getEstado().getDescripcion());
			
			if ((this.getNovedadExcluido().getnroActa()!=null) && 
					(this.getNovedadExcluido().getnroActa().intValue()!=0))
				cond.append(" "+this.getNovedadExcluido().getnroActa().toString());
				
			return cond.toString();
			
		}
		return "";
	}
	
	public String getNroPrincipal2() throws BaseException {
		StringBuffer cond = new StringBuffer("");
		if (this.getEstado()!=null)
			cond.append(this.getEstado().getDescripcion());
		cond.append(" "+getNroPrincipal());
		return cond.toString();
	}
	
	public String getNroPrincipal2(HashTableDatos hashEstados) throws BaseException {
		StringBuffer cond = new StringBuffer("");
		if (this.getEstado()!=null) {
			EstadoExcluido estExc = (EstadoExcluido) hashEstados.get(this.getEstado().getOIDInteger());
			cond.append(estExc.getDescripcion());
		}
		cond.append(" "+getNroPrincipal());
		return cond.toString();
	}
	
	
	public String getNroPrincipal() throws BaseException {
		if (this.getNovedadExcluido()!=null) {
			
			if ((this.getEstado()!=null) && 
				(this.getEstado().getOID()==EstadoExcluido.getEstadoConAntecedentes(this.getSesion()).getOID())) {
				
				if ((this.getNovedadExcluido().getnroActa()!=null) && 
						(this.getNovedadExcluido().getnroActa().intValue()!=0))
					return this.getNovedadExcluido().getEstado().getCodigo()+"-"+this.getNovedadExcluido().getnroActa().toString();
				else
					return "";  
				
			} else {
				if ((this.getNovedadExcluido().getnroActa()!=null) && 
						(this.getNovedadExcluido().getnroActa().intValue()!=0))
					return this.getNovedadExcluido().getnroActa().toString();
				else
					return "";
			}
		}
		return "";
	}
	

	public static List getConsultaMasiva(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBIndividuoExcluido.getConsultaMasiva(condiciones, aSesion);
	}

	public static List getAllIndividuosExcluidos(ISesion aSesion) throws BaseException {
		return DBIndividuoExcluido.getAllIndividuosExcluidos(aSesion);
	}
	
	public VehiculoExcluido getUltVehiculoCargado() throws BaseException {
		List listVehi = this.getVehiculos();
		if (listVehi.size()>0)
			return ((VehiAsigExcluido)listVehi.get(0)).getVehiculo();
		else
			return null;
	}
	
	public static List getAllByTipoDocu(ISesion aSesion,Integer oidIndividuo,String nroDocumento) throws BaseException {
		return DBIndividuoExcluido.getAllByTipoDocu(aSesion,oidIndividuo,nroDocumento);
	}
	
	public static List getAllByGrupoImportacion(
			ISesion aSesion,
			GrupoImportacionExcluido grupoImportacion,
			String tipoCons,
			Integer nroLote) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(GrupoImportacionExcluido.NICKNAME, grupoImportacion);
		condiciones.put("NRO_LOTE", nroLote);
		condiciones.put("TIPO_CONSULTA", tipoCons);
		return DBIndividuoExcluido.getAllByGrupoImportacion(aSesion,condiciones);
	}	
	
	/*public static List getNuevoLoteByGrupoImportacion(ISesion aSesion,GrupoImportacionExcluido grupoImportacion, String fechaUltAct) throws BaseException {
		return DBIndividuoExcluido.getNuevoLoteByGrupoImportacion(aSesion,grupoImportacion, fechaUltAct);
	}*/
	
	public static List getLoteAltaByGrupoImportacion(ISesion aSesion,GrupoImportacionExcluido grupoImportacion, Integer nroLote) throws BaseException {
		return DBIndividuoExcluido.getLoteAltaByGrupoImportacion(aSesion,grupoImportacion, nroLote);
	}
	
	public static List getLoteBajaByGrupoImportacion(ISesion aSesion,GrupoImportacionExcluido grupoImportacion, Integer nroLote) throws BaseException {
		return DBIndividuoExcluido.getLoteBajaByGrupoImportacion(aSesion,grupoImportacion, nroLote);
	}
	
	  public static void actuNroLoteSinc(
			  Integer oidIndividuo,
			  Integer nroLote,
		      ISesion aSesion)
		  throws BaseException {
			  DBIndividuoExcluido.actuNroLoteSinc(oidIndividuo,nroLote,aSesion);
	  }
	  
		public static int getMaxNroLoteSinc(ISesion aSesion) throws BaseException {

			return DBIndividuoExcluido.getMaxNroLoteSinc(aSesion);
			
		}

	public boolean isRestriccionAcceso() throws BaseException {
		return (this.getEstado()!= null && this.getEstado().isRestriccionAcceso()) || (this.getNovedadExcluido()!=null && this.getNovedadExcluido().isRestriccionAcceso());
	}
	  
	
	

}
