package com.srn.erp.reclutamiento.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluCandidatoBusq;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class RecluCandidatoBusq extends ObjetoLogico {

	public RecluCandidatoBusq() {
	}

	public static String NICKNAME = "rs.RecluCandidatoBusq";
		

	private RecluBusqueda busqueda;

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

	private RecluPostulante oid_postulante;
	private java.util.Date fec_asigno;
	private String hora_asigno;
	private Usuario usuario_asigno;
	private RecluEstCandidatoBusq estado_busqueda;
	private String comentario;
	private Boolean activo;
	private RecluMotiEstCandBusq motivo;
	private java.util.Date fechaIngreso;

	public RecluBusqueda getBusqueda() throws BaseException {
		supportRefresh();
		return busqueda;
	}
	
	public java.util.Date getFechaIngreso() throws BaseException {
		supportRefresh();
		return this.fechaIngreso;
	}	
	
	public RecluMotiEstCandBusq getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}	

	
	public void setMotivo(RecluMotiEstCandBusq aMotivo) {
		this.motivo = aMotivo;
	}	
	
	public void setFechaIngreso(java.util.Date aFechaIngreso) {
		this.fechaIngreso = aFechaIngreso;
	}	
	
	public void setBusqueda(RecluBusqueda aBusqueda) {
		this.busqueda = aBusqueda;
	}

	public RecluPostulante getOid_postulante() throws BaseException {
		supportRefresh();
		return oid_postulante;
	}

	public void setOid_postulante(RecluPostulante aOid_postulante) {
		this.oid_postulante = aOid_postulante;
	}

	public java.util.Date getFec_asigno() throws BaseException {
		supportRefresh();
		return fec_asigno;
	}

	public void setFec_asigno(java.util.Date aFec_asigno) {
		this.fec_asigno = aFec_asigno;
	}

	public String getHora_asigno() throws BaseException {
		supportRefresh();
		return hora_asigno;
	}

	public void setHora_asigno(String aHora_asigno) {
		this.hora_asigno = aHora_asigno;
	}

	public Usuario getUsuario_asigno() throws BaseException {
		supportRefresh();
		return usuario_asigno;
	}

	public void setUsuario_asigno(Usuario aUsuario_asigno) {
		this.usuario_asigno = aUsuario_asigno;
	}

	public RecluEstCandidatoBusq getEstado_busqueda() throws BaseException {
		supportRefresh();
		return estado_busqueda;
	}

	public void setEstado_busqueda(RecluEstCandidatoBusq aEstado_busqueda) {
		this.estado_busqueda = aEstado_busqueda;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
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

	public static RecluCandidatoBusq findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluCandidatoBusq) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static RecluCandidatoBusq findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluCandidatoBusq) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static RecluCandidatoBusq findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RecluCandidatoBusq) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(busqueda, "Debe ingresar la Búsqueda");
		Validar.noNulo(oid_postulante, "Debe ingresar el Postulante");
		Validar.noNulo(fec_asigno, "Debe ingresar la Fecha");
		Validar.noNulo(this.fechaIngreso, "Debe ingresar la Fecha del Estado");
		Validar.noNulo(hora_asigno, "Debe ingresar la Hora");
		Validar.noNulo(usuario_asigno, "Debe ingresar el Usuario");
		Validar.noNulo(estado_busqueda, "Debe ingresar el Estado");
	}

	public static List getCandidatosBusqueda(RecluBusqueda busqueda, ISesion aSesion) throws BaseException {
		return DBRecluCandidatoBusq.getCandidatosBusqueda(busqueda, aSesion);
	}
	
	public List getProcesosCandidato() throws BaseException {
		return RecluProcesoCandidato.getProcesosCandidato(this, this.getSesion());
	}
	
	public static List getCandidatosEnBusqueda(ISesion aSesion,HashTableDatos condiciones) throws BaseException {
		  return DBRecluCandidatoBusq.getCandidatosEnBusqueda(aSesion,condiciones);
	}
	
	public static List getCandidatosResultadoBusqueda(ISesion aSesion,HashTableDatos condiciones) throws BaseException {
		  return DBRecluCandidatoBusq.getCandidatosResultadoBusqueda(aSesion,condiciones);
	}	
	
	public String getDescEstProcByNroCol(HashTableDatos columnasNumeradas , int nroCol) throws BaseException {
		
		Integer oidProceso = (Integer)columnasNumeradas.get(new Integer(nroCol));
		
		if (oidProceso == null) return "";
		
		Iterator iterProcesosCandi = this.getProcesosCandidato().iterator();
		while (iterProcesosCandi.hasNext()) {
			RecluProcesoCandidato procesoCandidato = (RecluProcesoCandidato) iterProcesosCandi.next();
			if (procesoCandidato.getProceso().getOID() == oidProceso.intValue()) {
				String resp = ""; //procesoCandidato.getConcepto_proceso().getDescripcion();
				if (procesoCandidato.getEstado()!=null)
					resp = resp + procesoCandidato.getEstado().getDescripcion();
				return  resp;
			}
			
		}
		
		return "";
	}

}
