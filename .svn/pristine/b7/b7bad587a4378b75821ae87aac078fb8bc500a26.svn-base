package com.srn.erp.reclutamiento.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluBusqueda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class RecluBusqueda extends ObjetoLogico {

	private List definicionDeProcesos = new ArrayList();
	private boolean readDefinicionDeProcesos = true;	
	
	private List candidatos = new ArrayList();
	private boolean readCandidatos = true;	
	
	private List competencias = new ArrayList();
	private boolean readCompetencias = true;	
	
	@Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RecluBusqueda() {
	}

	public static String NICKNAME = "rs.RecluBusqueda";

	private RecluPuesto puesto;
	private java.util.Date fec_inicio_busq;
	private Integer cant_vacantes;
	private RecluMotivoBusqueda motivo_busq;
	private String observaciones;
	private RecluOperacion operacion;
	private Money sueldo_buto;
	private String estado_busqueda;
	private String sexo;
	private RecluTipoContrato tipo_contrato;
	private RecluSelector selector;
	private RecluEstAprobBusq est_aprob_busq;
	private RecluSectores sector;
	private java.util.Date fec_est_aprob;
	private RecluConvenio convenio;
	private java.util.Date fec_alta;
	private Boolean activo;
	private RecluMotiEstBusq motivoEstado; 
	private java.util.Date fecCierre;

	public RecluPuesto getPuesto() throws BaseException {
		supportRefresh();
		return puesto;
	}
	
	public java.util.Date getFechaCierre() throws BaseException {
		supportRefresh();
		return this.fecCierre;
	}	
	
	public RecluMotiEstBusq getMotivoEstado() throws BaseException {
		supportRefresh();
		return this.motivoEstado;
	}
	

	public void setPuesto(RecluPuesto aPuesto) {
		this.puesto = aPuesto;
	}
	
	public void setFechaCierre(java.util.Date aFechaCierre) {
		this.fecCierre = aFechaCierre;
	}	

	public java.util.Date getFec_inicio_busq() throws BaseException {
		supportRefresh();
		return fec_inicio_busq;
	}


	public void setMotivoEstado(RecluMotiEstBusq aMotivoEstado) {
		this.motivoEstado = aMotivoEstado;
	}
	
	
	
	public void setFec_inicio_busq(java.util.Date aFec_inicio_busq) {
		this.fec_inicio_busq = aFec_inicio_busq;
	}

	public Integer getCant_vacantes() throws BaseException {
		supportRefresh();
		if (cant_vacantes==null)
			return 0;
		else
			return cant_vacantes;
	}

	public void setCant_vacantes(Integer aCant_vacantes) {
		this.cant_vacantes = aCant_vacantes;
	}

	public RecluMotivoBusqueda getMotivo_busq() throws BaseException {
		supportRefresh();
		return motivo_busq;
	}

	public void setMotivo_busq(RecluMotivoBusqueda aMotivo_busq) {
		this.motivo_busq = aMotivo_busq;
	}

	public String getObservaciones() throws BaseException {
		supportRefresh();
		return observaciones;
	}

	public void setObservaciones(String aObservaciones) {
		this.observaciones = aObservaciones;
	}

	public RecluOperacion getOperacion() throws BaseException {
		supportRefresh();
		return operacion;
	}

	public void setOperacion(RecluOperacion aOperacion) {
		this.operacion = aOperacion;
	}

	public Money getSueldo_buto() throws BaseException {
		supportRefresh();
		return sueldo_buto;
	}

	public void setSueldo_buto(Money aSueldo_buto) {
		this.sueldo_buto = aSueldo_buto;
	}

	public String getEstado_busqueda() throws BaseException {
		supportRefresh();
		return estado_busqueda;
	}

	public void setEstado_busqueda(String aEstado_busqueda) {
		this.estado_busqueda = aEstado_busqueda;
	}

	public String getSexo() throws BaseException {
		supportRefresh();
		return sexo;
	}

	public void setSexo(String aSexo) {
		this.sexo = aSexo;
	}

	public RecluTipoContrato getTipo_contrato() throws BaseException {
		supportRefresh();
		return tipo_contrato;
	}

	public void setTipo_contrato(RecluTipoContrato aTipo_contrato) {
		this.tipo_contrato = aTipo_contrato;
	}

	public RecluSelector getSelector() throws BaseException {
		supportRefresh();
		return selector;
	}

	public void setSelector(RecluSelector aSelector) {
		this.selector = aSelector;
	}

	public RecluEstAprobBusq getEst_aprob_busq() throws BaseException {
		supportRefresh();
		return est_aprob_busq;
	}

	public void setEst_aprob_busq(RecluEstAprobBusq aEst_aprob_busq) {
		this.est_aprob_busq = aEst_aprob_busq;
	}

	public RecluSectores getSector() throws BaseException {
		supportRefresh();
		return sector;
	}

	public void setSector(RecluSectores aSector) {
		this.sector = aSector;
	}

	public java.util.Date getFec_est_aprob() throws BaseException {
		supportRefresh();
		return fec_est_aprob;
	}

	public void setFec_est_aprob(java.util.Date aFec_est_aprob) {
		this.fec_est_aprob = aFec_est_aprob;
	}

	public RecluConvenio getConvenio() throws BaseException {
		supportRefresh();
		return convenio;
	}

	public void setConvenio(RecluConvenio aConvenio) {
		this.convenio = aConvenio;
	}

	public java.util.Date getFec_alta() throws BaseException {
		supportRefresh();
		return fec_alta;
	}

	public void setFec_alta(java.util.Date aFec_alta) {
		this.fec_alta = aFec_alta;
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

	public static RecluBusqueda findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluBusqueda) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RecluBusqueda findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluBusqueda) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static RecluBusqueda findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RecluBusqueda) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		
		
		Validar.noNulo(puesto, "Debe ingresar el Puesto");
		Validar.noNulo(fec_inicio_busq, "Debe ingresar la Fecha de Inicio de Búsqueda");
		Validar.noNulo(cant_vacantes, "Debe ingresar la Cantidad de Vacantes");
		Validar.noNulo(motivo_busq, "Debe ingresar el Motivo de Búsqueda");
		Validar.noNulo(operacion, "Debe ingresar la Operación");
		Validar.noNulo(estado_busqueda, "Debe ingresar el Estado de la Búsqueda");
		Validar.noNulo(est_aprob_busq, "Debe ingresar el Estrado de Aprobación");
		Validar.noNulo(sector, "Debe ingresar el Sector");
		Validar.noNulo(fec_alta, "Debe ingresar la fecha de Alta");
		
		if (this.getEstado_busqueda().equals(RecluBusqueda.getEstadoBusqCerrada())) 
			this.cerrarBusqueda();
		
	}

	public static String getEstadoBusqAbierta() throws BaseException {
		return "ABIERTA";
	}

	public static String getEstadoBusqCerrada() throws BaseException {
		return "CERRADA";
	}

	public static String getSexoMasculino() throws BaseException {
		return "M";
	}

	public static String getSexoFemenino() throws BaseException {
		return "F";
	}

	public static String getSexoIndistinto() throws BaseException {
		return "I";
	}

	public static HashTableDatos getEstadosBusqueda() throws BaseException {
		HashTableDatos estados = new HashTableDatos();
		estados.put(getEstadoBusqAbierta(), "Abierta");
		estados.put(getEstadoBusqCerrada(), "Cerrada");
		return estados;
	}

	public static HashTableDatos getSexoPostulantes() throws BaseException {
		HashTableDatos sexo = new HashTableDatos();
		sexo.put(getSexoMasculino(), "Masculino");
		sexo.put(getSexoFemenino(), "Femenino");
		sexo.put(getSexoIndistinto(), "Indistinto");
		return sexo;
	}

	public static List getCondicionesBusquedas(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBRecluBusqueda.getCondicionesBusquedas(condiciones, aSesion);
	}
	
	public List getDefinicionProcesos() throws BaseException {
		if (this.readDefinicionDeProcesos) {
		      List listaDefinicionProcesos = RecluProcDefEnBusq.getProcesosDefEnBusqueda(this,getSesion());
		      this.definicionDeProcesos.addAll(listaDefinicionProcesos);
		      this.readDefinicionDeProcesos = false;
		}
		return this.definicionDeProcesos;
	}
	
	public List getCandidatos() throws BaseException {
		if (this.readCandidatos) {
		      List listaCandidatos = RecluCandidatoBusq.getCandidatosBusqueda(this,getSesion());
		      this.candidatos.addAll(listaCandidatos);
		      this.readCandidatos = false;
		}
		return this.candidatos;
	}	
	
	public List getCompetencias() throws BaseException {
		if (this.readCompetencias) {
		      List listaCompetencias = RecluCompeBusqAct.getCompetenciasBusqueda(this,getSesion());
		      this.competencias.addAll(listaCompetencias);
		      this.readCompetencias = false;
		}
		return this.competencias;
	}	

	public void addDefinicionProceso(RecluProcDefEnBusq aRecluProcDefEnBusq) throws BaseException {
		aRecluProcDefEnBusq.setBusqueda(this);
		this.definicionDeProcesos.add(aRecluProcDefEnBusq);
	}
	
	public void addCompetenciaBusqueda(RecluCompeBusqAct aRecluCompeBusqAct) throws BaseException {
		aRecluCompeBusqAct.setBusqueda(this);
		this.competencias.add(aRecluCompeBusqAct);
	}	
	
	public void addCandidato(RecluCandidatoBusq aRecluCandidatoBusq) throws BaseException {
		aRecluCandidatoBusq.setBusqueda(this);
		this.candidatos.add(aRecluCandidatoBusq);
	}	

	public void afterSave() throws BaseException {
		Iterator iterDeficionProcesos = this.definicionDeProcesos.iterator();
		while (iterDeficionProcesos.hasNext()) {
		      RecluProcDefEnBusq recluProcDefEnBusq = (RecluProcDefEnBusq) iterDeficionProcesos.next();
		      recluProcDefEnBusq.save();
		      recluProcDefEnBusq = null;
		}
		iterDeficionProcesos = null;
	}
	
	public void cerrarBusqueda() throws BaseException {
		
		
		Iterator iterCandidatos = this.getCandidatos().iterator();
		while (iterCandidatos.hasNext()) {
			RecluCandidatoBusq recluCandidatoBusq = (RecluCandidatoBusq) iterCandidatos.next();
			recluCandidatoBusq.supportRefresh();
			if (!recluCandidatoBusq.getEstado_busqueda().isPuedeCerrarBusqueda()) {
				throw new ExceptionValidation(null,"No se puede cerrar la búsqueda. El candidato "+recluCandidatoBusq.getOid_postulante().getApe_y_nom()+" tiene el estado "+recluCandidatoBusq.getEstado_busqueda().getDescripcion()+".");
			}
			if (recluCandidatoBusq.getEstado_busqueda().isPuedeCerrarBusqueda()) {
				if (recluCandidatoBusq.getEstado_busqueda().getAlCierreEstado()!=null) {
					recluCandidatoBusq.setEstado_busqueda(recluCandidatoBusq.getEstado_busqueda().getAlCierreEstado());
					recluCandidatoBusq.setFechaIngreso(Util.getFechaActual(this.getSesion()));
					recluCandidatoBusq.save();
				}
			}
		}
		
		this.setEstado_busqueda(RecluBusqueda.getEstadoBusqCerrada());
		this.setFechaCierre(Util.getFechaActual(this.getSesion()));
		
		
		
	}
	
	public int getCantDeCandidatosSeleccionados() throws BaseException {
		int cantSeleccionados = 0;
		Iterator iterCandidatos = this.getCandidatos().iterator();
		while (iterCandidatos.hasNext()) {
			RecluCandidatoBusq recluCandidato = (RecluCandidatoBusq) iterCandidatos.next();
			
			if (recluCandidato.getEstado_busqueda().isSugerirCierre())  
				++cantSeleccionados;
			
		}
		return cantSeleccionados;
	}
	
	public boolean isSugerirCierreDeBusqueda() throws BaseException {
		if (getCantDeCandidatosSeleccionados() >= getCant_vacantes().intValue())
			return true;
		else
			return false;
	}

}
