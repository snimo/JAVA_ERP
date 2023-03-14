package com.srn.erp.reclutamiento.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluPostulante;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class RecluPostulante extends ObjetoLogico {

	@Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return this.nro_docu;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getApe_y_nom();
	}

	public RecluPostulante() {
	}

	public static String NICKNAME = "rs.RecluPostulante";

	private List competencias = new ArrayList();
	private boolean readCompetencias = true;

	private List curriculums = new ArrayList();
	private boolean readCurriculums = true;

	private List novedades = new ArrayList();
	private boolean readNovedades = true;

	private List puestosAplica = new ArrayList();
	private boolean readPuestosAplica = true;

	private List procesosCandidato = new ArrayList();
	private boolean readProcesosCandidato = true;

	private String ape_y_nom;
	private TipoDocumento tipo_documento;
	private String nro_docu;
	private java.util.Date fec_nacimiento;
	private String direccion;
	private String localidad;
	private String cod_postal;
	private String telefono_fijo;
	private String telefono_celular;
	private String referido_por;
	private String sexo;
	private Boolean activo;
	private Boolean esReferido;
	private Integer nroReferido;
	private RecluFuente fuente;
	private RecluEstadoPostulante estadoPostulante;
	private java.util.Date fecEstadoPostulante;

	public String getApe_y_nom() throws BaseException {
		supportRefresh();
		return ape_y_nom;
	}

	public RecluEstadoPostulante getEstadoPostulante() throws BaseException {
		supportRefresh();
		return this.estadoPostulante;
	}

	public java.util.Date getFecEstadoPostulante() throws BaseException {
		supportRefresh();
		return this.fecEstadoPostulante;
	}

	public RecluFuente getFuente() throws BaseException {
		supportRefresh();
		return this.fuente;
	}

	public Boolean isReferido() throws BaseException {
		supportRefresh();
		return this.esReferido;
	}

	public Integer getNroReferido() throws BaseException {
		supportRefresh();
		return this.nroReferido;
	}

	public void setApe_y_nom(String aApe_y_nom) {
		this.ape_y_nom = aApe_y_nom;
	}

	public void setFecEstadoPostulante(java.util.Date aFecEstadoPostulante) {
		this.fecEstadoPostulante = aFecEstadoPostulante;
	}

	public void setEstadoPostulante(RecluEstadoPostulante aRecluEstadoPostulante) {
		this.estadoPostulante = aRecluEstadoPostulante;
	}

	public void setNroReferido(Integer aNroReferido) {
		this.nroReferido = aNroReferido;
	}

	public void setIsReferido(Boolean aEsReferido) {
		this.esReferido = aEsReferido;
	}

	public TipoDocumento getTipo_documento() throws BaseException {
		supportRefresh();
		return tipo_documento;
	}

	public void setTipo_documento(TipoDocumento aTipo_documento) {
		this.tipo_documento = aTipo_documento;
	}

	public String getNro_docu() throws BaseException {
		supportRefresh();
		return nro_docu;
	}

	public void setNro_docu(String aNro_docu) {
		this.nro_docu = aNro_docu;
	}

	public void setFuente(RecluFuente aFuente) {
		this.fuente = aFuente;
	}

	public java.util.Date getFec_nacimiento() throws BaseException {
		supportRefresh();
		return fec_nacimiento;
	}

	public void setFec_nacimiento(java.util.Date aFec_nacimiento) {
		this.fec_nacimiento = aFec_nacimiento;
	}

	public String getDireccion() throws BaseException {
		supportRefresh();
		return direccion;
	}

	public void setDireccion(String aDireccion) {
		this.direccion = aDireccion;
	}

	public String getLocalidad() throws BaseException {
		supportRefresh();
		return localidad;
	}

	public void setLocalidad(String aLocalidad) {
		this.localidad = aLocalidad;
	}

	public String getCod_postal() throws BaseException {
		supportRefresh();
		return cod_postal;
	}

	public void setCod_postal(String aCod_postal) {
		this.cod_postal = aCod_postal;
	}

	public String getTelefono_fijo() throws BaseException {
		supportRefresh();
		return telefono_fijo;
	}

	public void setTelefono_fijo(String aTelefono_fijo) {
		this.telefono_fijo = aTelefono_fijo;
	}

	public String getTelefono_celular() throws BaseException {
		supportRefresh();
		return telefono_celular;
	}

	public void setTelefono_celular(String aTelefono_celular) {
		this.telefono_celular = aTelefono_celular;
	}

	public String getReferido_por() throws BaseException {
		supportRefresh();
		return referido_por;
	}

	public void setReferido_por(String aReferido_por) {
		this.referido_por = aReferido_por;
	}

	public String getSexo() throws BaseException {
		supportRefresh();
		return sexo;
	}

	public void setSexo(String aSexo) {
		this.sexo = aSexo;
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

	public static RecluPostulante findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluPostulante) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RecluPostulante findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluPostulante) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static RecluPostulante findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RecluPostulante) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(this.nro_docu, "Debe ingresar el Nro. de Documento");
		Validar.noNulo(ape_y_nom, "Debe ingresar el Nombre y Apellido");
		Validar.noNulo(this.tipo_documento, "Debe ingresar el Tipo de Documento");
		Validar.noNulo(sexo, "Debe ingresar el Genero");
		Validar.noNulo(this.estadoPostulante, "Debe ingresar el estado");
		Validar.noNulo(this.esReferido, "Debe ingresar se es o no Referido");

	}

	public static final String getGeneroMasculino() throws BaseException {
		return "M";
	}

	public static final String getGeneroFemenino() throws BaseException {
		return "F";
	}

	public static final HashTableDatos getGeneros() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(RecluPostulante.getGeneroMasculino(), "Masculino");
		condiciones.put(RecluPostulante.getGeneroFemenino(), "Femenino");
		return condiciones;
	}

	public List getCompetenciasPostu() throws BaseException {
		if (this.readCompetencias) {
			List listaCompePostu = RecluCompePostu.getRecluCompetencias(this, getSesion());
			this.competencias.addAll(listaCompePostu);
			this.readCompetencias = false;
		}
		return this.competencias;
	}

	public List getPuestosAplica() throws BaseException {
		if (this.readPuestosAplica) {
			List listaPuestosAplica = RecluPuestoAplica.getPuestosAplica(this, getSesion());
			this.puestosAplica.addAll(listaPuestosAplica);
			this.readPuestosAplica = false;
		}
		return this.puestosAplica;
	}

	public List getProcesosCandidato() throws BaseException {
		if (this.readProcesosCandidato) {
			List listaProcesosCandidato = RecluProcesoCandidato.getRecluProcesoCandidato(this, getSesion());
			this.procesosCandidato.addAll(listaProcesosCandidato);
			this.readProcesosCandidato = false;
		}
		return this.procesosCandidato;
	}

	public List getCurriculums() throws BaseException {
		if (this.readCurriculums) {
			List listaCurriculumns = RecluCurriPostu.getRecluCurriculumns(this, getSesion());
			this.curriculums.addAll(listaCurriculumns);
			this.readCurriculums = false;
		}
		return this.curriculums;
	}

	public List getNovedades() throws BaseException {
		if (this.readNovedades) {
			List listaNovedades = RecluNovedadPostu.getNovedadesPostulantes(this, getSesion());
			this.novedades.addAll(listaNovedades);
			this.readNovedades = false;
		}
		return this.novedades;
	}

	public void addRecluCompetencia(RecluCompePostu aRecluCompePostu) throws BaseException {
		aRecluCompePostu.setPostulante(this);
		competencias.add(aRecluCompePostu);
	}

	public void addRecluPuestoAplica(RecluPuestoAplica aRecluPuestoAplica) throws BaseException {
		aRecluPuestoAplica.setPostulante(this);
		this.puestosAplica.add(aRecluPuestoAplica);
	}

	public void addProcesoCandidato(RecluProcesoCandidato aRecluProcesoCandidato) throws BaseException {
		aRecluProcesoCandidato.setPostulante(this);
		this.procesosCandidato.add(aRecluProcesoCandidato);
	}

	public void addRecluNovedad(RecluNovedadPostu aRecluNovedadPostu) throws BaseException {
		aRecluNovedadPostu.setPostulante(this);
		novedades.add(aRecluNovedadPostu);
	}

	public void addRecluCurriculum(RecluCurriPostu aRecluCurriPostu) throws BaseException {
		aRecluCurriPostu.setPostulante(this);
		this.curriculums.add(aRecluCurriPostu);
	}

	public void afterSave() throws BaseException {

		Iterator iterCompetencias = competencias.iterator();
		while (iterCompetencias.hasNext()) {
			RecluCompePostu recluCompePostu = (RecluCompePostu) iterCompetencias.next();
			recluCompePostu.save();
			recluCompePostu = null;
		}
		iterCompetencias = null;

		Iterator iterCurriculumns = this.curriculums.iterator();
		while (iterCurriculumns.hasNext()) {
			RecluCurriPostu recluCurriPostu = (RecluCurriPostu) iterCurriculumns.next();
			recluCurriPostu.save();
			recluCurriPostu = null;
		}
		iterCurriculumns = null;

		Iterator iterNovedades = this.novedades.iterator();
		while (iterNovedades.hasNext()) {
			RecluNovedadPostu recluNovedades = (RecluNovedadPostu) iterNovedades.next();
			recluNovedades.save();
			recluNovedades = null;
		}
		iterNovedades = null;

		Iterator iterPuestosAplica = this.puestosAplica.iterator();
		while (iterPuestosAplica.hasNext()) {
			RecluPuestoAplica recluPuestoAplica = (RecluPuestoAplica) iterPuestosAplica.next();
			recluPuestoAplica.save();
			recluPuestoAplica = null;
		}
		iterPuestosAplica = null;

		Iterator iterProcesosCandidato = this.procesosCandidato.iterator();
		while (iterProcesosCandidato.hasNext()) {
			RecluProcesoCandidato recluProcesoCandidato = (RecluProcesoCandidato) iterProcesosCandidato.next();
			recluProcesoCandidato.save();
			recluProcesoCandidato = null;
		}
		iterProcesosCandidato = null;

	}

	public static String getPathFotoPostulantes(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("PATH_FOTO_POSTULANTE", aSesion).getValorCadena();
	}

	public List getProcesosPostulante() throws BaseException {
		return RecluProcesoCandidato.getRecluProcesoCandidato(this, this.getSesion());
	}

	public static List getPostulantesActivos(ISesion aSesion) throws BaseException {
		return DBRecluPostulante.getPostulantesActivos(aSesion);
	}

	public static List getPostulantesByCondiciones(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBRecluPostulante.getPostulantesByCondiciones(condiciones, aSesion);
	}
	
	public static List getPostulantesByNroLote(Integer nroLote,Integer nroDesde,Integer nroHasta,ISesion aSesion) throws BaseException {
		  
		  return DBRecluPostulante.getPostulantesByNroLote(nroLote, nroDesde, nroHasta, aSesion);
	}	

}
